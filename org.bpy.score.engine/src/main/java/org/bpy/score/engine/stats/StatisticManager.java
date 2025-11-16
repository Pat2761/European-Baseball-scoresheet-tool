/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2020  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.score.engine.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bpy.score.engine.events.PointEvent;
import org.bpy.score.engine.events.PointListener;
import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractActionManager;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.MoveToData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.ReplacementData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.SubstitutionCommonData;
import org.bpy.score.engine.stats.emf.GameStatisticContainer;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.*;
import org.bpy.score.game.util.ScoreGameAdvanceUtil;
import org.bpy.score.game.util.ScoreGameAssistUtil;
import org.bpy.score.game.util.ScoreGameError;
import org.bpy.score.game.util.ScoreGameOutUtil;
import org.bpy.score.game.util.ScoreGameUtil;

/**
 * This class parse the game file, analyse each action for compute the statistic of the game.
 * 
 * @author Patrick BRIAND
 *
 */
public class StatisticManager extends AbstractActionManager implements PointListener {

	/** Remove extra move */
	public static final String REGEX_REMOVE_PLUS = "[\\+]+"; //$NON-NLS-1$
	
	/** Key for memorize the referenced pitcher */
	public static final String PITCHER_REFERENCE = "pitcher_reference"; //$NON-NLS-1$
	/** Key for memorize the offensive position */
	public static final String OFFENSIVE_POSITION = "offensive_position"; //$NON-NLS-1$
	/** Key for memorize the maximum of point */
	public static final String MAX_POSSIBLE_POINT = "max_possible_point"; //$NON-NLS-1$

	/** Reference on the game statistic Container */
	private GameStatisticContainer statisticContainer;
	
	/** Reference on entry point of the game statistic */
	private GameStatistic stats;

	/** List of defensive positionwho participate to a double play */
	private List<String> defensersNumberForDoublePlay;
	/** Reference on the object which compute the Winner, Looser or saved pitcher */
	private PitcherAwardFactory pitcherAwardFactory;

	/** Counter of strike */
	private int currentStrikeCount = 0;
	/** Counter of ball */
	private int currentBallCount = 0;
	/** Memorise the situation for the point transfer */
	private HashMap<Integer, LineupEntry> transferedSituationMemory = new HashMap<>();
	/** Data structure for compute the transfered pitchers */
	private HashMap<LineupEntry, HashMap<Integer, TransferedPitcherDataStructure>> transferedPitchers = new HashMap<>();
	/** Counter of transfered pitcher */
	private int transferedPitchersCounter;

	/**
	 * Constructor of the class.
	 * In purpose of initialization
	 */
	public StatisticManager() {
		super();
		getRunnerPositionManager().addPointListener(this);
	}

	/**
	 * Get the statistic container.
	 * 
	 * @return reference on the GameStatisticContainer object
	 */
	public GameStatisticContainer getStatisticContainer() {
		return statisticContainer;
	}

	/**
	 * Get entry point of the game statistic.
	 * 
	 * @return entry point of the game statistic
	 */
	public GameStatistic getStats() {
		return stats;
	}

	/**
	 * get the current strike count.
	 * 
	 * @return number of strike
	 */
	public int getCurrentStrikeCount() {
		return currentStrikeCount;
	}

	/**
	 * Get the current ball count.
	 *  
	 * @return number of ball
	 */
	public int getCurrentBallCount() {
		return currentBallCount;
	}

	@Override
	public void closeGame() {

		try {
		   InninStatictic lastGeneralStats = stats.getVisitor().getGeneralInningStats()
				.get(stats.getVisitor().getGeneralInningStats().size() - 1);
		   stats.getVisitor().setFinalScore(lastGeneralStats.getCumulativeInningStat().getRuns());

		   lastGeneralStats = stats.getHometeam().getGeneralInningStats()
				.get(stats.getHometeam().getGeneralInningStats().size() - 1);
		   stats.getHometeam().setFinalScore(lastGeneralStats.getCumulativeInningStat().getRuns());
		} catch (IndexOutOfBoundsException e) {
			stats.getVisitor().setFinalScore(0);
			stats.getHometeam().setFinalScore(0);
		}

		super.closeGame();
	}

	@Override
	public void manage(Action action) throws OccupedbaseException {
		super.manage(action);
		if (EngineConstants.debugStatistics) {
			this.debug();
		}
	}

	/**
	 * Initialization of the game statistic container
	 * 
	 * @param gameName name of the game
	 * @param hometeamName name of the home team
	 * @param visitorName name of the visitor team
	 */
	public void initStattistic(String gameName, String hometeamName, String visitorName) {
		statisticContainer = new GameStatisticContainer();
		stats = statisticContainer.createNewStaticContainer(gameName, hometeamName, visitorName);
		statisticContainer.setLineupDescription(stats, EngineConstants.HOMETEAM, hometeamLineup);
		statisticContainer.setLineupDescription(stats, EngineConstants.VISITOR, visitorLineup);

		/* pitcher Awards initialisation */
		pitcherAwardFactory = new PitcherAwardFactory();
		pitcherAwardFactory.addPitcherReplacement(EngineConstants.VISITOR, visitorLineup.getCurrentPitcher());
		pitcherAwardFactory.addPitcherReplacement(EngineConstants.HOMETEAM, hometeamLineup.getCurrentPitcher());
	}

	/**
	 * Set the statistic in case of forfeit
	 * 
	 * @param gameName  name of the game
	 * @param hometeamName name of the home team
	 * @param visitorName name of the visitor team
	 * @param forfeitTeam name of the forfeit team
	 */
	public void setForfeitStattistic(String gameName, String hometeamName, String visitorName, String forfeitTeam) {
		statisticContainer = new GameStatisticContainer();
		stats = statisticContainer.createNewStaticContainer(gameName, hometeamName, visitorName);

		if (forfeitTeam.equals(EngineConstants.HOMETEAM)) {
			stats.getVisitor().setFinalScore(9);
			stats.getHometeam().setFinalScore(0);
		} else {
			stats.getVisitor().setFinalScore(0);
			stats.getHometeam().setFinalScore(9);
		}
	}

	@Override
	public void startInning(HalfInning halfInning) {
		statisticContainer.startNewInnning(stats, halfInning.getTeam());

		transferedPitchers.clear();
		transferedPitchersCounter = 0;

		super.startInning(halfInning);
		runnerPositionManager.setLineUpManager(currentLineup);
	}

	@Override
	public void closeInning(HalfInning halfInning) {
		statisticContainer.setLeftOnBase(runnerPositionManager.getLeftOnBase());

		statisticContainer.closeNewInnning(stats, halfInning.getTeam());

		super.closeInning(halfInning);
	}

	@Override
	public void manage(GameResume gameResume) {
		if (gameResume != null) {
			String winPitcher = gameResume.getWin();
			String losePitcher = gameResume.getLose();
			String savePitcher = gameResume.getSave();

			LineupEntry pitcher = getPitcherByName(winPitcher);
			stats.setWinningPitcher(pitcher);

			pitcher = getPitcherByName(losePitcher);
			stats.setLoosingPitcher(pitcher);

			pitcher = getPitcherByName(savePitcher);
			stats.setSavePitcher(pitcher);
		}
	}

	/**
	 * Retrieve a player entry from a name.
	 * 
	 * @param pitcherName pitcher name
	 * 
	 * @return Player entry is exist,<b>null</b> if not found
	 */
	private LineupEntry getPitcherByName(String pitcherName) {
		for (LineupEntry potentialPitcher : stats.getHometeam().getPitchers()) {
			if (potentialPitcher.getPlayerDescription().getName().equals(pitcherName)) {
				return potentialPitcher;
			}
		}
		for (LineupEntry potentialPitcher : stats.getVisitor().getPitchers()) {
			if (potentialPitcher.getPlayerDescription().getName().equals(pitcherName)) {
				return potentialPitcher;
			}
		}
		return null;
	}

	@Override
	public void startAction(String team, Action action) {
		super.startAction(team, action);

		/* On recherche si l'on a un double ou triple jeu dans l'acion */
		if (defensersNumberForDoublePlay == null) {
			defensersNumberForDoublePlay = new ArrayList<>();
		} else {
			defensersNumberForDoublePlay.clear();
		}

		/* Management of transfered point */
		transferedSituationMemory.clear();

		if (action.getBatterAction() instanceof BatterAdvanceOnOccupedBall) {
			for (int i = 1; i < 4; i++) {
				if (runnerPositionManager.getPlayerAtPosition(i) != null) {
					transferedSituationMemory.put(i, runnerPositionManager.getPlayerAtPosition(i));
				}
			}
		}
	}

	@Override
	public void closeAction(String team, Action action) {
		super.closeAction(team, action);

		if (putoutDetected > 0) {

			getOpposingTeamLinup().upddateIPs(putoutDetected);
			if (doublePlayDetection > 1) {

				for (String defenserNumberForDoublePlay : defensersNumberForDoublePlay) {
					statisticContainer.incDoublePlay(stats, team, defenserNumberForDoublePlay);
				}

				statisticContainer.incGeneralDoublePlayCounter(stats, currentTeam);
			}
		}
	}

	@Override
	public void manageTieBreak() throws OccupedbaseException {

		statisticContainer.incTiebreak(stats, currentTeam);
		statisticContainer.incTiebreak(stats, currentTeam);

		super.manageTieBreak();
	}

	@Override
	protected void manage(Pitch element, String team) {
		/* get current pitcher */
		statisticContainer.incPitchs(element, stats, team);

		String pitch = element.getPitch();
		switch (pitch) {

		case "s": //$NON-NLS-1$
		case "S": //$NON-NLS-1$
		case "k": //$NON-NLS-1$
		case "K": //$NON-NLS-1$
			currentStrikeCount++;
			break;

		case "f": //$NON-NLS-1$
		case "F": //$NON-NLS-1$
			if (currentStrikeCount < 2)
				currentStrikeCount++;
			break;

		case "b": //$NON-NLS-1$
		case "B": //$NON-NLS-1$
			currentBallCount++;
			break;
		default :
			break;
		}

	}

	@Override
	protected void setNewBatter() {
		super.setNewBatter();

		currentStrikeCount = 0;
		currentBallCount = 0;

	}

	/*
	 * *************************************************************************
	 * ************************* Actions on runners
	 * *************************************************************************
	 * *************************
	 */

	@Override
	protected void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction moreAdvance) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(moreAdvance);
		statisticContainer.incErrors(stats, currentTeam,
		Integer.parseInt(defensivePosition));

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnDecisiveObstruction moreAdvance) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(moreAdvance);
		try {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(moreAdvance);
		try {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}
		
		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		try {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		try  {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		try {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}
	
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		try {
			statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}
	
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnCaughtStealingWithError action) throws OccupedbaseException {

		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		Integer offensivePosition = (Integer) runnerPositionManager.getPlayerAssociatedObject(runnerPosition,
				OFFENSIVE_POSITION);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.incCaughtStealing(stats, currentTeam, offensivePosition, assists);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException {

		if ("BK".equals(action.getRunnerAdvance())) { //$NON-NLS-1$
			statisticContainer.incBalk(stats, currentTeam);
		}
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException {

		if (action.getRunnerAdvance().equals("PB")) { //$NON-NLS-1$
			statisticContainer.incPassBall(stats, currentTeam);
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException {

		if ("WP".equals(action.getRunnerAdvance().replaceAll(REGEX_REMOVE_PLUS, ""))) { //$NON-NLS-1$ //$NON-NLS-2$
			statisticContainer.incWildPitch(stats, currentTeam);
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnStolenBase action) throws OccupedbaseException {
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int offensivePosition = (Integer) runnerPositionManager.getPlayerAssociatedObject(runnerPosition,
				OFFENSIVE_POSITION);

		statisticContainer.incStolenBase(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnAppeal action) {

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutByRules action) {

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnFielderAction action) {

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnPickOff action) {

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnCaugthStealing action) {

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int offensivePosition = (Integer) runnerPositionManager.getPlayerAssociatedObject(runnerPosition,
				OFFENSIVE_POSITION);
		statisticContainer.incCaughtStealing(stats, currentTeam, offensivePosition, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerMustBeOutOnError action) {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnPickOffWithError action) {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		Integer offensivePosition = (Integer) runnerPositionManager.getPlayerAssociatedObject(runnerPosition,
				OFFENSIVE_POSITION);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.incCaughtStealing(stats, currentTeam, offensivePosition, assists);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnThrowError action) {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnReceiveError action) {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);
	}

	/*
	 * *************************************************************************
	 * ************************* Actions on batters
	 * *************************************************************************
	 * *************************
	 */

	@Override
	protected void makeActionOn(BatterBalk action) {

		statisticContainer.incBalk(stats, currentTeam);
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterMustOutOnFlyFoulBall action) {

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	
	
	@Override
	protected void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
		getResponsiblePitcher(action, oppositeTeamLineup);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incStrikeOut(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incIO(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incIO(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incSacrificeFly(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incSacrificeFly(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incSacrificeHit(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incSacrificeHit(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incStrikeOut(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKAbr action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incStrikeOut(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incStrikeOut(stats, currentTeam, offensivePosition);

		String wildPitch = action.getBatterAdvance().substring(2, 4);
		if (wildPitch.equals("WP")) { //$NON-NLS-1$
			statisticContainer.incWildPitch(stats, currentTeam);
		}

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incStrikeOut(stats, currentTeam, offensivePosition);

		String passBall = action.getBatterAdvance().substring(2, 4);
		if (passBall.equals("PB")) { //$NON-NLS-1$
			statisticContainer.incPassBall(stats, currentTeam);
		}

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incHitByPitch(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incIntentionalBaseOnBall(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incBaseOnBall(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incHomerun(stats, currentTeam, offensivePosition);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		runnerPositionManager.linkObjectToPlayer(0, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(0, OFFENSIVE_POSITION, offensivePosition);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incHomerun(stats, currentTeam, offensivePosition);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		runnerPositionManager.linkObjectToPlayer(0, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(0, OFFENSIVE_POSITION, offensivePosition);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incTriple(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incDouble(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException {

		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incHits(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incGdp(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);
		statisticContainer.incGdp(stats, currentTeam, offensivePosition);

		super.makeActionOn(action);

		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException {
		LineupManager oppositeTeamLineup = getOpposingTeamLinup();
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		statisticContainer.incPlateAppearance(stats, currentTeam, offensivePosition);
		statisticContainer.incAtBat(stats, currentTeam, offensivePosition);

		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		statisticContainer.incErrors(stats, currentTeam, Integer.parseInt(defensivePosition));

		super.makeActionOn(action);

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.linkObjectToPlayer(baseWin, PITCHER_REFERENCE, oppositeTeamLineup.getCurrentPitcher());
		runnerPositionManager.linkObjectToPlayer(baseWin, OFFENSIVE_POSITION, offensivePosition);
	}

	@Override
	protected void makeActionOn(BatterOutOnInfieldFly action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeHit action) {
		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incSacrificeHit(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeFlyFallBall action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incSacrificeFly(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeFly action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incSacrificeFly(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnGroundedDoublePlay action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incGdp(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnAppeal action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutByRule action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		String obrCause = ScoreGameUtil.getOBRType(action);
		switch (obrCause) {
		case "KS": //$NON-NLS-1$
		case "2": //$NON-NLS-1$
			statisticContainer.incStrikeOut(stats, currentTeam, currentLineup.getCurrentBatterNumber());
			statisticContainer.incOut(stats, currentTeam, '2');

			/* Double play or triple play management */
			if (!action.isNotInDoublePlay()) {
				setDoublePlayData("2", assists); //$NON-NLS-1$
			}
			break;

		default:
			statisticContainer.incOut(stats, currentTeam, ScoreGameOutUtil.getOut(action));
			/* Double play or triple play management */
			if (!action.isNotInDoublePlay()) {
				setDoublePlayData("" + ScoreGameOutUtil.getOut(action), assists); //$NON-NLS-1$
			}
			break;
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnGroundedBall action) {
		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLineDriveFallBall action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnPoppedFallBall action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnFlyedFallBall action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnPopped action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLine action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnFlyed action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, null); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnReleasedStrike action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incStrikeOut(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		statisticContainer.addAssistances(stats, currentTeam, assists);

		char defensivePosition = ScoreGameOutUtil.getOut(action);
		statisticContainer.incOut(stats, currentTeam, defensivePosition);

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("" + defensivePosition, assists); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLookedStrike action) {
		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incStrikeOut(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		statisticContainer.incOut(stats, currentTeam, '2');

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("2", new char[0]); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSwingedStrike action) {

		statisticContainer.incPlateAppearance(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incAtBat(stats, currentTeam, currentLineup.getCurrentBatterNumber());
		statisticContainer.incStrikeOut(stats, currentTeam, currentLineup.getCurrentBatterNumber());

		statisticContainer.incOut(stats, currentTeam, '2');

		/* Double play or triple play management */
		if (!action.isNotInDoublePlay()) {
			setDoublePlayData("2", new char[0]); //$NON-NLS-1$
		}

		super.makeActionOn(action);
	}

	@Override
	protected void callCallbackSubstitutionManager(SubstitutionManager substitutionManager) {
		super.callCallbackSubstitutionManager(substitutionManager);

		String team = substitutionManager.getTeam();
		TeamStatistic teamStatistic = (team.equals(EngineConstants.HOMETEAM)
				? statisticContainer.getHomeTeamStatistic(stats)
				: statisticContainer.getVisitorStatistic(stats));
		LineupEntry currentPitcher = teamStatistic.getCurrentPitcher();

		for (SubstitutionCommonData substitution : substitutionManager.getSubstitutions()) {

			if (substitution instanceof ReplacementData) {

				ReplacementData replacementData = (ReplacementData) substitution;
				String offensivePosition = replacementData.getOffensivePosition();
				LineupEntry player = substitutionManager.getLineupManager()
						.getPlayerForOffensivePosition(offensivePosition);

				statisticContainer.setNewPlayer(teamStatistic, team, player, false);
				if (player.getDefensivePosition().equals("1")) { //$NON-NLS-1$
					pitcherAwardFactory.addPitcherReplacement(team, player);
					currentPitcher.getPitcherStatistic().setRunnerLeftOnBase(runnerPositionManager.getLeftOnBase());
					currentPitcher.getAssociatedObjects().put(MAX_POSSIBLE_POINT,
							runnerPositionManager.getLeftOnBase() + currentPitcher.getPitcherStatistic().getRuns());
				}

			} else if (substitution instanceof MoveToData) {
				MoveToData moveToData = (MoveToData) substitution;

				String defensivePosition = moveToData.getDefensivePosition().getNewDefensivePosition();

				LineupEntry player = substitutionManager.getLineupManager().getPlayerForDefensivePosition(defensivePosition);

				if (player.getDefensivePosition().equals("1")) { //$NON-NLS-1$
					
					if (moveToData.getPlayerReplaced().getPlayerDescription() != player.getPlayerDescription()) {
					
						pitcherAwardFactory.addPitcherReplacement(team, player);
						currentPitcher.getPitcherStatistic().setRunnerLeftOnBase(runnerPositionManager.getLeftOnBase());
						currentPitcher.getAssociatedObjects().put(MAX_POSSIBLE_POINT,runnerPositionManager.getLeftOnBase() + currentPitcher.getPitcherStatistic().getRuns());
						statisticContainer.setNewDefensivePosition(teamStatistic, player);
					}
				} else {
					statisticContainer.setNewDefensivePosition(teamStatistic, player);
				}
			}
		}
	}

	/**
	 * For the debug
	 */
	@Override
	public void debug() {
		debugTeam(EngineConstants.VISITOR, visitorLineup);
		debugTeam(EngineConstants.HOMETEAM, hometeamLineup);
	}

	/**
	 * Debug for a team 
	 * @param team team name (visitor or home team)
	 * 
	 * @param lineup reference on the line-up manager
	 */
	public void debugTeam(String team, LineupManager lineup) {
		logger.log(Level.FINE,"############################### [{0}] ###############################",team); //$NON-NLS-1$
		logger.log(Level.FINE,"general statistics:"); //$NON-NLS-1$
		statisticContainer.debugGeneralInning(stats, team);
		logger.log(Level.FINE,"player statistics:"); //$NON-NLS-1$
		statisticContainer.debugPlayerStats(stats, team, lineup);
		logger.log(Level.FINE,"pitchers statistics:"); //$NON-NLS-1$
		statisticContainer.debugPitcherStats(stats, team);
		logger.log(Level.FINE,"catchers statistics:"); //$NON-NLS-1$
		statisticContainer.debugCatchersStats(stats, team);
	}

	@Override
	public void newPoint(PointEvent event) {

		String offensivePositionStr = event.getPlayer().getOffensivePosition();
		int offensivePosition = Integer.parseInt(offensivePositionStr);

		Object action = event.getAction();
		LineupEntry batter = currentLineup.getCurrentBatter();
		String position = batter.getOffensivePosition();

		/*
		 * Un RBI peut être compter si le coureur avance sur la frappe du batteur, mais
		 * il ne faut oublier le cas du Home run
		 */
		int hometeamPoints = getTotalPointsForTeam(stats.getHometeam());
		int visitorPoints = getTotalPointsForTeam(stats.getVisitor());

		if (action instanceof BatterAdvanceOnHomeRun || action instanceof BatterAdvanceOnInsidePark) {
			statisticContainer.incRbi(stats, currentTeam, Integer.parseInt(position), hometeamPoints == visitorPoints);

		} else if (action instanceof RunnerAdvanceByBatterAction && !isGdpAction) {
			statisticContainer.incRbi(stats, currentTeam, Integer.parseInt(position), hometeamPoints == visitorPoints);
		} else if (hometeamPoints == visitorPoints) {
			statisticContainer.removeGWRBIInOpposititeTeam(stats, currentTeam);
		}

		/* atribution du point pour la défense */
		if (event.getPlayer().getAssociatedObjects() == null
				|| event.getPlayer().getAssociatedObjects().get(OFFENSIVE_POSITION) == null) {

			/* recherche du lanceur responsable du point */
			LineupEntry currentPitcher = getOpposingTeamLinup().getCurrentPitcher();
			currentPitcher = getTransferedPitcherIfExists(currentPitcher);

			/* case of HR */
			statisticContainer.incRun(stats, currentTeam, offensivePosition, currentPitcher);
			if (event.getIsEarnedValue() != null) {
				statisticContainer.incEarnedRun(stats, currentTeam, +offensivePosition, event.getIsEarnedValue(),
						currentPitcher);
			}

			pitcherAwardFactory.addNewPointEvent(currentTeam, getOpposingTeamLinup().getCurrentBatter());

		} else {
			/* other cases */

			/* recherche du lanceur responsable du point */
			LineupEntry currentPitcher = (LineupEntry) event.getPlayer().getAssociatedObjects().get(PITCHER_REFERENCE);
			currentPitcher = getTransferedPitcherIfExists(currentPitcher);

			offensivePosition = (int) event.getPlayer().getAssociatedObjects().get(OFFENSIVE_POSITION);

			statisticContainer.incRun(stats, currentTeam, offensivePosition, currentPitcher);
			if (event.getIsEarnedValue() != null) {
				statisticContainer.incEarnedRun(stats, currentTeam, +offensivePosition, event.getIsEarnedValue(),
						currentPitcher);
			}

			pitcherAwardFactory.addNewPointEvent(currentTeam,
					(LineupEntry) event.getPlayer().getAssociatedObjects().get(PITCHER_REFERENCE));
		}
	}

	/**
	 * Return the transfered pitcher is it is possible. 
	 * 
	 * @param currentPitcher current pitcher
	 * @return the transfered pitcher is it is possible , <b>null</b> if not found
	 */
	private LineupEntry getTransferedPitcherIfExists(LineupEntry currentPitcher) {

		HashMap<Integer, TransferedPitcherDataStructure> transferedPitchersForPitcher = transferedPitchers.get(currentPitcher);
		if (transferedPitchersForPitcher != null) {

			List<Integer> keys = new ArrayList<>(transferedPitchersForPitcher.keySet());
			Collections.sort(keys);

			for (Integer key : keys) {

				TransferedPitcherDataStructure transferedPitcherDataStructure = transferedPitchersForPitcher.get(key);

				if (transferedPitcherDataStructure.getRealPitcher() == currentPitcher) {

					int transferedPitcherPoints = transferedPitcherDataStructure.getTransferedPitcher().getPitcherStatistic().getRuns();
					int transferedPitcherPointsMaxPoint = (int) transferedPitcherDataStructure.getTransferedPitcher().getAssociatedObjects().get(MAX_POSSIBLE_POINT);
					if (transferedPitcherPoints < transferedPitcherPointsMaxPoint) {
						currentPitcher = transferedPitcherDataStructure.getTransferedPitcher();
					}

					transferedPitchersForPitcher.remove(key);
					break;
				}
			}
		}

		return currentPitcher;
	}

	/**
	 * Get the total of points for a team. 
	 *  
	 * @param team Reference on the statistic for the team
	 * @return Number of point
	 */
	private int getTotalPointsForTeam(TeamStatistic team) {
		int points = 0;
		for (InninStatictic inningStat : team.getGeneralInningStats()) {
			points += inningStat.getInningStat().getRuns();
		}
		return points;
	}

	/**
	 * Get the opposite team line-up
	 * 
	 * @return opposite team line-up 
	 */
	private LineupManager getOpposingTeamLinup() {
		if (currentLineup == hometeamLineup) {
			return visitorLineup;
		} else {
			return hometeamLineup;
		}
	}

	/**
	 * Extract the defensive position in case of double play.
	 * 
	 * @param defensivePosition defensive position
	 * @param assists List of assistances
	 */
	private void setDoublePlayData(String defensivePosition, char[] assists) {

		if (!defensersNumberForDoublePlay.contains(defensivePosition)) {
			defensersNumberForDoublePlay.add("" + defensivePosition); //$NON-NLS-1$
		}
		if (assists != null) {
			for (char assist : assists) {
				if (!defensersNumberForDoublePlay.contains("" + assist)) { //$NON-NLS-1$
					defensersNumberForDoublePlay.add("" + assist); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * get the responsible pitcher of point when Batter Advance On Occupied Ball arrive with a pitch replacement
	 * 
	 * @param action Batter Advance On Occupied Ball action
	 * @param oppositeTeamLineup the opposite team line-up
	 */
	private void getResponsiblePitcher(BatterAdvanceOnOccupedBall action, LineupManager oppositeTeamLineup) {

		LineupEntry currentPitcher = oppositeTeamLineup.getCurrentPitcher();

		LineupEntry transferedPitcher = null;
		Action generalAction = (Action) action.eContainer();

		for (RunnerAction runnerAction : generalAction.getRunnerActions()) {
			if ((runnerAction instanceof RunnerOutOnFielderAction)
					|| (runnerAction instanceof RunnerAdvanceOnThrowError)
					|| (runnerAction instanceof RunnerAdvanceOnReceiveError)) {

				/* C'est le joueur qui est la cause du choix */
				int runnerPosition;

				if (action.eContainer() instanceof Action) {
					runnerPosition = ScoreGameUtil.getRunnerNumber(runnerAction.getRunner());
				} else {
					runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
				}

				LineupEntry player = transferedSituationMemory.get(runnerPosition);
				transferedPitcher = (LineupEntry) player.getAssociatedObjects().get(PITCHER_REFERENCE);
			}
		}

		if ((transferedPitcher != null) && (currentPitcher != transferedPitcher)) {

			HashMap<Integer, TransferedPitcherDataStructure> data = transferedPitchers.get(currentPitcher);
			if (data == null) {
				data = new HashMap<>();
				transferedPitchers.put(currentPitcher, data);
			}

			TransferedPitcherDataStructure transferedPitcherDataStructure = new TransferedPitcherDataStructure();
			transferedPitcherDataStructure.setTransferedPitcher(transferedPitcher);
			transferedPitcherDataStructure.setRealPitcher(currentPitcher);
			data.put(transferedPitchersCounter++, transferedPitcherDataStructure);

			for (RunnerAction runnerAction : generalAction.getRunnerActions()) {

				/* C'est le joueur qui est la cause du choix */
				int runnerPosition;

				if (action.eContainer() instanceof Action) {
					runnerPosition = ScoreGameUtil.getRunnerNumber(runnerAction.getRunner());
				} else {
					runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
				}

				LineupEntry player = transferedSituationMemory.get(runnerPosition);

				if (player.getAssociatedObjects().get(PITCHER_REFERENCE) == currentPitcher) {
					transferedPitcherDataStructure.addPlayers(player);
				}
			}
		}
	}

}
