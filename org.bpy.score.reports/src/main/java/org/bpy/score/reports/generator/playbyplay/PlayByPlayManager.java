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
package org.bpy.score.reports.generator.playbyplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractActionManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.MoveToData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.ReplacementData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.SubstitutionCommonData;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.BatterAdvanceOnBaseOnBall;
import org.bpy.score.game.game.BatterAdvanceOnCatcherInterference;
import org.bpy.score.game.game.BatterAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.BatterAdvanceOnDoubleHit;
import org.bpy.score.game.game.BatterAdvanceOnFlyError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnHitByPitch;
import org.bpy.score.game.game.BatterAdvanceOnHomeRun;
import org.bpy.score.game.game.BatterAdvanceOnIndiference;
import org.bpy.score.game.game.BatterAdvanceOnInsidePark;
import org.bpy.score.game.game.BatterAdvanceOnIntentionalBaseOnBall;
import org.bpy.score.game.game.BatterAdvanceOnKPassBall;
import org.bpy.score.game.game.BatterAdvanceOnKWildPitch;
import org.bpy.score.game.game.BatterAdvanceOnKWithError;
import org.bpy.score.game.game.BatterAdvanceOnKWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnObstruction;
import org.bpy.score.game.game.BatterAdvanceOnOccupedBall;
import org.bpy.score.game.game.BatterAdvanceOnReceiveError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnSingleHit;
import org.bpy.score.game.game.BatterAdvanceOnThrowError;
import org.bpy.score.game.game.BatterAdvanceOnTripleHit;
import org.bpy.score.game.game.BatterBalk;
import org.bpy.score.game.game.BatterLostTurn;
import org.bpy.score.game.game.BatterMustOutOnFlyFoulBall;
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnAppeal;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnGroundedDoublePlay;
import org.bpy.score.game.game.BatterOutOnInfieldFly;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnLineDriveFallBall;
import org.bpy.score.game.game.BatterOutOnLookedStrike;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.BatterOutOnSacrificeFly;
import org.bpy.score.game.game.BatterOutOnSacrificeFlyFallBall;
import org.bpy.score.game.game.BatterOutOnSacrificeHit;
import org.bpy.score.game.game.BatterOutOnSwingedStrike;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.game.RunnerAdvanceByBatterAction;
import org.bpy.score.game.game.RunnerAdvanceOnBalk;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.RunnerAdvanceOnError;
import org.bpy.score.game.game.RunnerAdvanceOnFielderChoice;
import org.bpy.score.game.game.RunnerAdvanceOnIndiference;
import org.bpy.score.game.game.RunnerAdvanceOnNoDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveFlyError;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveThrowError;
import org.bpy.score.game.game.RunnerAdvanceOnOccupedBall;
import org.bpy.score.game.game.RunnerAdvanceOnOtherPlayerError;
import org.bpy.score.game.game.RunnerAdvanceOnPassBall;
import org.bpy.score.game.game.RunnerAdvanceOnPickOffWithError;
import org.bpy.score.game.game.RunnerAdvanceOnReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnRule;
import org.bpy.score.game.game.RunnerAdvanceOnStolenBase;
import org.bpy.score.game.game.RunnerAdvanceOnThrow;
import org.bpy.score.game.game.RunnerAdvanceOnThrowError;
import org.bpy.score.game.game.RunnerAdvanceOnWildPitch;
import org.bpy.score.game.game.RunnerDontAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerDontAdvanceOnError;
import org.bpy.score.game.game.RunnerDontAdvanceOnNonDecisiveReceiveError;
import org.bpy.score.game.game.RunnerDontAdvanceOnNonDecisiveThrowError;
import org.bpy.score.game.game.RunnerDontAdvanceOnPickOffWithError;
import org.bpy.score.game.game.RunnerDontAdvanceOnReceiveError;
import org.bpy.score.game.game.RunnerDontAdvanceOnThrowError;
import org.bpy.score.game.game.RunnerMustBeOutOnError;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.game.RunnerOutOnAppeal;
import org.bpy.score.game.game.RunnerOutOnCaugthStealing;
import org.bpy.score.game.game.RunnerOutOnFielderAction;
import org.bpy.score.game.game.RunnerOutOnPickOff;
import org.bpy.score.game.util.ScoreGameAdvanceUtil;
import org.bpy.score.game.util.ScoreGameAssistUtil;
import org.bpy.score.game.util.ScoreGameError;
import org.bpy.score.game.util.ScoreGameOutUtil;
import org.bpy.score.game.util.ScoreGameUtil;
import org.bpy.score.internationalization.reports.Messages;
import org.eclipse.emf.common.util.EList;

/**
 * This class analyse actions for create a play by play description.
 *   
 * @author Patrick BRIAND
 *
 */
public class PlayByPlayManager extends AbstractActionManager {

	/** String ky for the player name */
	public static final String PLAYER_NAME = "<<name>>"; // $NON-NLS-1$ 
	/** String key for the new player name */
	public static final String NEW_PLAYER_NAME = "<<new_name>>"; // $NON-NLS-1$
	/** String key for the coming from position */
	public static final String FROM_POSITION = "<<fromPosition>>"; // $NON-NLS-1$
	/** String key for the new position */
	public static final String TO_POSITION = "<<toPosition>>"; // $NON-NLS-1$
	/** String key for the defensive position */
	public static final String DEFENSIVE_POSITION = "<<defensivePosition>>"; // $NON-NLS-1$
	/** String key for the defensive player */
	public static final String DEFENSIVE_PLAYER = "<<defensivePlayer>>"; // $NON-NLS-1$
	/** String key for number of base win */
	public static final String BASE_WIN = "<<baseWin>>"; // $NON-NLS-1$
	/** String key for defensive out fielder name */
	public static final String DEFENSIVE_OUT_FIELDER = "<<defensiveOutFielder>>"; // $NON-NLS-1$
	/** String key for defensive in fielder name */
	public static final String DEFENSIVE_IN_FIELDER = "<<defensiveInFielder>>"; // $NON-NLS-1$
	/** String key for hit location */
	public static final String HIT_LOCATION = "<<hitLocation>>"; // $NON-NLS-1$
	
	/**	Pitcher position */
	public static final String POSITION_1 = Messages.PlayByPlayManager_Pitcher;
	/**	Catcher position */
	public static final String POSITION_2 = Messages.PlayByPlayManager_Catcher;
	/**	First base position position */
	public static final String POSITION_3 = Messages.PlayByPlayManager_FirstBase;
	/**	Second base position position */
	public static final String POSITION_4 = Messages.PlayByPlayManager_SecondBase;
	/**	Third base position position */
	public static final String POSITION_5 = Messages.PlayByPlayManager_ThirdBase;
	/**	Short stop position position */
	public static final String POSITION_6 = Messages.PlayByPlayManager_ShortStop;
	/**	Left field position position */
	public static final String POSITION_7 = Messages.PlayByPlayManager_LeftField;
	/**	Center field position position */
	public static final String POSITION_8 = Messages.PlayByPlayManager_CenterField;
	/**	Right field position position */
	public static final String POSITION_9 = Messages.PlayByPlayManager_RightField;
	/** Designated hitter */
	public static final String POSITION_DH = Messages.PlayByPlayManager_DesignatedHitter;
	/** Pitch hitter */
	public static final String POSITION_PH = Messages.PlayByPlayManager_PitchHitter;
	/** Pitch runner */
	public static final String POSITION_PR = Messages.PlayByPlayManager_PitchRunner;
	
	/** List of play by play descriptions for an inning*/
	private List<PlayByPlayContainer> elements;
	/** Current play by play container for an action */
	private PlayByPlayContainer container;

	/** inning counter */
	private int inningCounter = 1;
	
	/** Current inning description */
	private StringBuilder inningDescription;
	/** Current action description */
	private StringBuilder actionDescription;
	/** Inning statistics for the home team */
	private EList<InninStatictic> hometeamStats;
	/** Inning statistics for the visitor team */
	private EList<InninStatictic> visitorStats;

	/**
	 * return the List of play by play descriptions for an inning.
	 * 
	 * @return List of play by play descriptions for an inning 
	 */
	public List<PlayByPlayContainer> getElements() {
		return elements;
	}

	/**
	 * Initialize the inning statistics for each tema.
	 * 
	 * @param statisticManager Reference on the statistic manager
	 */
	public void setStatisticsValues(StatisticManager statisticManager) {
		hometeamStats  = statisticManager.getStats().getHometeam().getGeneralInningStats();
		visitorStats = statisticManager.getStats().getVisitor().getGeneralInningStats();
	}

	@Override
	public void startGame() {
		elements = new ArrayList<>();
		inningCounter = 0;
		super.startGame();
	}

	
	@Override
	public void startAction(String team, Action action) {
		actionDescription = new StringBuilder();
		super.startAction(team, action);
	}

	@Override
	public void closeAction(String team, Action element) {
		actionDescription.append(". ");
		inningDescription.append(actionDescription);
		super.closeAction(team, element);
	}

	@Override
	public void startInning(HalfInning halfInning) {
		container = new PlayByPlayContainer();
		
		inningDescription = new StringBuilder();

		String teamType = "Visiteur";
		String teamName = "";
		
		currentTeam = halfInning.getTeam(); 
		if (EngineConstants.HOMETEAM.equals(currentTeam)) {
			teamType = "Hometeam";
		} else {
			inningCounter++;
		}
		
		String header = String.format("Equipe %s (%s) manche %d : " , teamType , teamName ,inningCounter);
		container.setHeader(header);

		super.startInning(halfInning);
	}

	@Override
	public void closeInning(HalfInning halfInning) {
		
		InningGeneralStatistic stats = null;
		if (EngineConstants.VISITOR.equals(currentTeam)) {
			stats = visitorStats.get(inningCounter-1).getInningStat();
		} else {
			stats = hometeamStats.get(inningCounter-1).getInningStat();
		}
		
		int lobCounter = this.getRunnerPositionManager().getLeftOnBase();
		String closeMessage = String.format("%d Points %d hits %d erreurs %d laissés sur base", stats.getRuns(), stats.getHits(), stats.getErrors(), lobCounter); 
		container.setContent(inningDescription.toString());
		container.setResume(closeMessage);
		elements.add(container);
		super.closeInning(halfInning);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction moreAdvance) throws OccupedbaseException {
		/* 
		* <coureur> gagne <base> sur une obstruction non décisive du <defenseur>
		*/
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
		String defensivePosition = ScoreGameError.getDefensivePosition(moreAdvance);

		String message = PLAYER_NAME + " gagne " + BASE_WIN + " sur une obstruction (non décisive) " + DEFENSIVE_PLAYER;
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, ""+(baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, defensivePosition);
		putMessage(message, keys);

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnDefensiveChoice moreAdvance) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
		String defensivePosition = ScoreGameAdvanceUtil.getDefensivePosition(moreAdvance);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " gagne " + BASE_WIN + " sur un choix défensif " + DEFENSIVE_PLAYER   );
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, ""+ (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException {

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
		StringBuilder message = new StringBuilder(PLAYER_NAME + " gagne " + BASE_WIN + " sur une erreur de réception de Fly (non décisive) " + DEFENSIVE_PLAYER   );
		String defensivePosition = ScoreGameError.getDefensivePosition(moreAdvance);
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, ""+ (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnError action) {

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnPickOffWithError action) {

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnThrowError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnReceiveError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " n'avance pas sur l'erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnOtherPlayerError action) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une erreur ");
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnRule action) throws OccupedbaseException {
		// N'existe plus
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException {

		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une erreur de réception (non décisive)" + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une erreur de relance(non décisive)" + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une erreur de réception " + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une erreur de relance" + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnIndiference action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameAdvanceUtil.getDefensivePosition(action);
		
		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une indiférence" + DEFENSIVE_PLAYER);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, defensivePlayer);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnThrow action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensiveOutfield = ScoreGameAdvanceUtil.getOutfielder(action);
		String defensiveInfield = ScoreGameAdvanceUtil.getInfielder(action);
		
		StringBuilder message = new StringBuilder(PLAYER_NAME + " avance " + BASE_WIN + " sur une relance du" + DEFENSIVE_OUT_FIELDER + " vers " + DEFENSIVE_IN_FIELDER);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_OUT_FIELDER, defensiveOutfield);
		keys.put(DEFENSIVE_IN_FIELDER, defensiveInfield);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnOccupedBall action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " usur une balle occupée "); 
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

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
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " une tentative de vol suite à l'erreur " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " un 'pick Off' suite à l'erreur " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur balk"); 
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une balle passée"); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un lancer fou"); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

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
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " vole " + BASE_WIN); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + "sur une erreur " + DEFENSIVE_PLAYER); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceByBatterAction action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur la frappe du batteur"); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnDecisiveObstruction moreAdvance) throws OccupedbaseException {
		int runnerPosition;
		if (moreAdvance.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(moreAdvance.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une obstruction " + DEFENSIVE_PLAYER); 

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(moreAdvance));
		putMessage(message.toString(), keys);

		super.makeActionOn(moreAdvance);
	}

	@Override
	protected void makeActionOn(RunnerAdvanceOnFielderChoice action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un choix défensif " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + (baseWin + runnerPosition));
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnAppeal action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " est retiré sur un appel " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameOutUtil.getOut(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutByRules action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String obrNumber = ScoreGameUtil.getOBRType(action);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " est " );
		
		switch (obrNumber) {
		case "9": message.append(" éliminé pour avoir touché une balle frappée");
			break;
		case "10": message.append(" éliminé pour être sorti de son couloir de course");
			break;
		case "11": message.append(" éliminé pour avoir doublé un autre coureur");
			break;
		case "12": message.append(" éliminé pour course à l’envers sur les bases.");
			break;
		case "13": message.append(" éliminé pour avoir interféré avec un défenseur");
			break;
		case "14": message.append(" éliminé pour cause d’interférence du coureur sur base");
			break;
		case "15": message.append(" éliminé pour départ anticipé");
			break;
		case "16": message.append(" éliminé pour avoir touché la mauvaise base sur la double base en 1ère");
			break;
		default:
			break;
		}
		message.append(" par " + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameOutUtil.getOut(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnFielderAction action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " est retrié par " + DEFENSIVE_PLAYER);
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameOutUtil.getOut(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnPickOff action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " est retrié sur un Pick off " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameOutUtil.getOut(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerOutOnCaugthStealing action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " est retrié sur une tentative de vol " + DEFENSIVE_PLAYER); 
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameOutUtil.getOut(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(RunnerMustBeOutOnError action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " aurait du être retiré par " + DEFENSIVE_PLAYER); 
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, runner.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, "" + ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterBalk action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder buffer = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN  + " sur un 'Balk'");

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "1");
		putMessage(buffer.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterMustOutOnFlyFoulBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		StringBuilder buffer = new StringBuilder( PLAYER_NAME + " aurait du être retiré par " + DEFENSIVE_PLAYER );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(buffer.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterLostTurn action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		StringBuilder message = new StringBuilder( PLAYER_NAME + " manque son tour au bâton");

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un choix défensif " + DEFENSIVE_PLAYER  );
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une indifférence de " + DEFENSIVE_PLAYER  );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une balle occupé " + DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " strike out relaché avec un choix " + DEFENSIVE_PLAYER  );
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une obstruction " + DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une interférence du receveur");
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un sacrifice fly sur le choix " + DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un sacrifice fly et l'erreur " + DEFENSIVE_PLAYER  );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un sacrifice hit sur le choix " + DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameAdvanceUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un sacrifice hit et l'erreur "+ DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un strike out et l'erreur "+ DEFENSIVE_PLAYER  );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_PLAYER, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur strike ou relaché lié à un lancer fou" );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur strike ou relaché lié à une balle passée" );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur 'hit by pitch'" );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur BB intentionel" );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne "  + BASE_WIN + " sur un BB" );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		StringBuilder message = new StringBuilder( PLAYER_NAME + " marque le point sur un 'Inside Park' " + HIT_LOCATION );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(HIT_LOCATION, getHitLocation(ScoreGameUtil.getHitLocation(action)));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " marque le point sur un 'Home run' vers " + HIT_LOCATION );
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(HIT_LOCATION, getHitLocation(ScoreGameUtil.getHitLocation(action)));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un triple vers " + HIT_LOCATION );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + 3);
		keys.put(HIT_LOCATION, getHitLocation(ScoreGameUtil.getHitLocation(action)));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un double vers " + HIT_LOCATION );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + 2);
		keys.put(HIT_LOCATION, getHitLocation(ScoreGameUtil.getHitLocation(action)));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un simple vers " + HIT_LOCATION );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + 1);
		keys.put(HIT_LOCATION, getHitLocation(ScoreGameUtil.getHitLocation(action)));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un 'Grounded Double Play avec une erreur " + DEFENSIVE_POSITION );
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_POSITION, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur un 'Grounded Double Play sur le choix " + DEFENSIVE_POSITION );
		addAssistInformation(message, ScoreGameAssistUtil.getAssistances(action));
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_POSITION, ScoreGameUtil.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne " + BASE_WIN + " sur une erreur de lancé " + DEFENSIVE_POSITION );

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(BASE_WIN, "" + baseWin);
		keys.put(DEFENSIVE_POSITION, ScoreGameError.getDefensivePosition(action));
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne la première base sur une erreur de champs " + DEFENSIVE_POSITION );

		if (baseWin>1) {
			message.append(", il profite de l'erreur pour atteindre " + BASE_WIN);
		}
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException {
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		StringBuilder message = new StringBuilder( PLAYER_NAME + " gagne la première base sur une erreur de rattrapé de volé du " + DEFENSIVE_POSITION );

		if (baseWin>1) {
			message.append(" et profite de l'erreur pour atteindre " + BASE_WIN);
		}
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnInfieldFly action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " est retiré sur un 'Infield fly' par " + DEFENSIVE_POSITION);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeHit action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " est retiré 'sacrifice hit' par " + DEFENSIVE_POSITION);
		addAssistInformation(message,assists);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeFlyFallBall action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder(PLAYER_NAME + " est retiré 'sacrifice fly' dans la zone des fausses balles par " + DEFENSIVE_POSITION);
		addAssistInformation(message,assists);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSacrificeFly action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré 'sacrifice fly' par " + DEFENSIVE_POSITION);
		addAssistInformation(message,assists);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnGroundedDoublePlay action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré 'Groubed double play' par " + DEFENSIVE_POSITION);
		addAssistInformation(message,assists);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		keys.put(DEFENSIVE_POSITION, "" + defensivePosition);
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnAppeal action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur un appel");

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutByRule action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String obrNumber = ScoreGameUtil.getOBRType(action);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré ");
		
		switch (obrNumber) {
		case "1": message.append(" pour une frappe illégale");
			break;
		case "2": message.append(" sur bunt foul ball sur le troisième strike");
			break;
		case "3": message.append(" pour avoir touché la balle frappée");
			break;
		case "4": message.append(" pour interférence avec le receveur.");
			break;
		case "5": message.append(" pour avoir oublié son tour de frappe");
			break;
		case "6": message.append(" pour refus d’avancer en 1ère base après un But sur Balles");
			break;
		case "7": message.append(" pour avoir refusé d’avancer de troisième baseau point pour le point gagnant");
			break;
		case "8": message.append(" sur Infield Fly non réceptionnée.");
			break;
		default:
			break;
		}

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnGroundedBall action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char out = ScoreGameOutUtil.getOut(action); 
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur frappe au sol ");
		if (out == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + out));
		addAssistInformation(message,assists);
		
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLineDriveFallBall action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'line drive' dans la zone des fausse balles ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnPoppedFallBall action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'pop' dans la zone des fausse balles ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnFlyedFallBall action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'fly' dans la zone des fausse balles ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnPopped action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'pop' ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLine action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'line drive' ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnFlyed action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		message.append(PLAYER_NAME + " est retiré sur une 'fly' ");
		if (defensivePosition == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + defensivePosition));

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnReleasedStrike action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char out = ScoreGameOutUtil.getOut(action); 
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		StringBuilder message = new StringBuilder();
		if (action.getStrikeOutValue().startsWith("KS")) {
			message.append(PLAYER_NAME + " est retiré sur strike out (Swing) ");
		} else {
			message.append(PLAYER_NAME + " est retiré sur strike out (Look) ");
		}
		if (out == '6') {
			message.append("par l'");
		} else {
			message.append("par le ");
		}
		message.append(getDefensivePosition("" + out));
		addAssistInformation(message,assists);
		
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message.toString(), keys);
		
		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnLookedStrike action) {
		String message = PLAYER_NAME + " est retiré sur strike out (Look)";
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message, keys);

		super.makeActionOn(action);
	}

	@Override
	protected void makeActionOn(BatterOutOnSwingedStrike action) {
		String message = PLAYER_NAME + " est retiré sur strike out (Swing)" ;
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		HashMap<String,String> keys = new HashMap<>();
		keys.put(PLAYER_NAME, batter.getPlayerDescription().getName());
		putMessage(message, keys);

		super.makeActionOn(action);
	}

	@Override
	protected void callCallbackSubstitutionManager(SubstitutionManager substitutionManager) {
		for (SubstitutionCommonData substitution : substitutionManager.getSubstitutions() ) {
			
			if (substitution instanceof MoveToData) {
				MoveToData moveToData = (MoveToData)substitution;
				String message = PLAYER_NAME + " (" + FROM_POSITION + ") se déplace en " + TO_POSITION;
				
				HashMap<String,String> keys = new HashMap<>();
				keys.put(PLAYER_NAME, moveToData.getPlayer().getPlayerDescription().getName());
				keys.put(FROM_POSITION, moveToData.getCurrentDefensivePosition());
				keys.put(TO_POSITION, moveToData.getDefensivePosition().getNewDefensivePosition());
				putMessage(message, keys);
			
			} else {

				ReplacementData replacementData = (ReplacementData) substitution;
				
				String message = null;
				if (replacementData.getCurrentDefensivePosition().equals(replacementData.getPlayerReplaced().getDefensivePosition())) {
				   message = PLAYER_NAME + " (" + FROM_POSITION + ") est remplacé par " + NEW_PLAYER_NAME; 
				} else {
				   message = PLAYER_NAME + " (" + FROM_POSITION + ") est remplacé par " + NEW_PLAYER_NAME + " (" + TO_POSITION  + ") ";
				}
				
				
				HashMap<String,String> keys = new HashMap<>();
				keys.put(PLAYER_NAME, replacementData.getPlayerReplaced().getPlayerDescription().getName());
				keys.put(NEW_PLAYER_NAME, replacementData.getPlayer().getPlayerDescription().getName());
				keys.put(FROM_POSITION, replacementData.getCurrentDefensivePosition());
				keys.put(TO_POSITION, replacementData.getPlayerReplaced().getDefensivePosition());
				putMessage(message, keys);
			}
		}
		super.callCallbackSubstitutionManager(substitutionManager);
	}

	/**
	 * BUIld the description of the action by replacing keys by theirs values
	 * 
	 * @param message Skeleton of the messages
	 * @param keys parameters
	 */
	private void putMessage(String message, HashMap<String, String> keys) {
		if (keys.containsKey(PLAYER_NAME)) {
			message = message.replace(PLAYER_NAME, keys.get(PLAYER_NAME));
		}	
		if (keys.containsKey(NEW_PLAYER_NAME)) {
			message = message.replace(NEW_PLAYER_NAME, keys.get(NEW_PLAYER_NAME));
		}	
		if (keys.containsKey(FROM_POSITION)) {
			message = message.replace(FROM_POSITION, getBaseWin(keys.get(FROM_POSITION)));
		}	
		if (keys.containsKey(TO_POSITION)) {
			message = message.replace(TO_POSITION, getBaseWin(keys.get(TO_POSITION)));
		}	
		if (keys.containsKey(DEFENSIVE_POSITION)) {
			message = message.replace(DEFENSIVE_POSITION, getDefensivePosition(keys.get(DEFENSIVE_POSITION)));
		}	
		if (keys.containsKey(DEFENSIVE_PLAYER)) {
			message = message.replace(DEFENSIVE_PLAYER, getDefensivePosition(keys.get(DEFENSIVE_PLAYER)));
		}
		if (keys.containsKey(BASE_WIN)) {
			message = message.replace(BASE_WIN, getBaseWin(keys.get(BASE_WIN)));
		}
		if (keys.containsKey(DEFENSIVE_IN_FIELDER)) {
			message = message.replace(DEFENSIVE_IN_FIELDER, getDefensivePosition(keys.get(DEFENSIVE_IN_FIELDER)));
		}
		if (keys.containsKey(DEFENSIVE_OUT_FIELDER)) {
			message = message.replace(DEFENSIVE_OUT_FIELDER, getDefensivePosition(keys.get(DEFENSIVE_OUT_FIELDER)));
		}
		if (keys.containsKey(HIT_LOCATION)) {
			message = message.replace(HIT_LOCATION, getHitLocation(keys.get(HIT_LOCATION)));
		}
		if (actionDescription.toString().length() > 0) {
			actionDescription.append("; ");
		}
		actionDescription.append(message);
	}

	/**
	 * Get defensive position string.
	 * 
	 * @param position defensive position
	 * 
	 * @return defensive position string
	 */
	private String getDefensivePosition(String position) {
		switch(position) {
			case "1" : return POSITION_1;
			case "2" : return POSITION_2;
			case "3" : return POSITION_3;
			case "4" : return POSITION_4;
			case "5" : return POSITION_5;
			case "6" : return POSITION_6;
			case "7" : return POSITION_7;
			case "8" : return POSITION_8;
			case "9" : return POSITION_9;
			case "dh" : return POSITION_DH;
			case "pr" : return POSITION_PH;
			case "ph" : return POSITION_PR;
		}
		return "??";
	}

	/**
	 * Add assistance informations to the message.
	 * 
	 * @param message Skeleton of the message
	 * @param assists List of assistances
	 */
	private void addAssistInformation(StringBuilder message, char[] assists) {
		if (assists.length> 0) {
			message.append(", assisté du ");
			
			for (int i=0; i<assists.length; i++) {
				
				message.append(getDefensivePosition(""+assists[i]));

				if ( i<assists.length-1 ) {
					message.append(",");
				}
			}
		}
	}

	/**
	 * Get hit location string
	 * 
	 * @param hitLocation hit location
	 * 
	 * @return hit location string
	 */
	private String getHitLocation(String hitLocation) {
		switch (hitLocation) {
		case "1" : return " sur le batteur";  
		case "2" : return " sur le receveur"; 
		case "3" : return " sur la première base"; 
		case "4" : return " sur la deuxième base"; 
		case "5" : return " sur la troisième base"; 
		case "6" : return " sur l'arrêt court"; 
		case "7" : return " dans le champ gauche";  
		case "8" : return " dans le champ centre"; 
		case "9" : return " dans le champ droit"; 
		case "LL" : return " roulante le long de la ligne du champ gauche"; 
		case "LS" : return " le long de la ligne du champ gauche"; 
		case "LC" : return " entre le champ gauche et le champ centre";
		case "MI" : return " roulante dans le champ centre champ gauche";  
		case "RC" : return " entre le champ centre et le champ droit"; 
		case "RS" : return " le long de la ligne du champ droite"; 
		case "RL" : return " roulante le long de la ligne du champ droit";
		default: break;
		}
		return null;
	}

	/**
	 * get readable names of bases
	 * 
	 * @param position base number
	 * @return readable names of bases
	 */
	private String getBaseWin(String position) {
		switch (position) {
		case "1" : return "la première base";
		case "2" : return "la deuxième base";
		case "3" : return "la troisième base";
		case "4" : return "le marbre";
		default: break;
		}
		return null;
	}


}
