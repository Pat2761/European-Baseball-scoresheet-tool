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
package org.bpy.score.engine.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.ReplacementData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.SubstitutionCommonData;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.*;
import org.bpy.score.game.util.ScoreGameAdvanceUtil;
import org.bpy.score.game.util.ScoreGameUtil;
import org.bpy.score.internationalization.engine.Messages;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;

/**
 * This class is an abstract class which must be used for analyse a game file.
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractActionManager {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(AbstractActionManager.class.getSimpleName());

	/** Debug format string */
	public static final String DEBUG_FORMAT_STRING_1 = "[ {0} ]: {1}";  //$NON-NLS-1$
	
	/** Debug format string */
	public static final String DEBUG_FORMAT_STRIKE_OUT = " StrikeOutBValue ="; //$NON-NLS-1$
	
	/** reference to the runner position manager in infield */
	protected RunnerPositionManager runnerPositionManager;

	/** Reference to the visitor line-up */
	protected LineupManager visitorLineup;
	/** Reference to the home team line-up */
	protected LineupManager hometeamLineup;
	/** Reference to the current line-up */
	protected LineupManager currentLineup;

	/** IP counter visitor */
	protected IpCounter visitorIpCounter;
	/** IP counter home team */
	protected IpCounter hometeamIpCounter;

	/** Reference to the current team */
	protected String currentTeam = null;
	/** Reference to the last current team */
	protected String lastCurrentTeam = null;

	/** Number of put out detected */
	protected int putoutDetected;

	/** Double play detection */
	protected int doublePlayDetection;

	
	/** Current action to analyse */
	protected Action currentAction;
	/** Flag which memorize if it is a Grounded double play action */
	protected boolean isGdpAction;

	/**
	 * Constructor of the class.
	 * Initialize some fields 
	 */
	public AbstractActionManager() {
		runnerPositionManager = new RunnerPositionManager();
		visitorIpCounter = new IpCounter();
		hometeamIpCounter = new IpCounter();
	}

	/**
	 * Get the reference on the runner position manager.
	 * 
	 * @return reference on the runner position manager
	 */
	public RunnerPositionManager getRunnerPositionManager() {
		return runnerPositionManager;
	}

	/**
	 * Get the reference on the last current team.
	 * 
	 * @return reference on the last current team
	 */
	public String getLastCurrentTeam() {
		return lastCurrentTeam;
	}

	/**
	 * Get the reference on the current team.
	 * 
	 * @return reference on the current team
	 */
	public String getCurrentTeam() {
		return currentTeam;
	}

	/**
	 * Install the line-up (Home team and visitor team)
	 * 
	 * @param lineUps List of line-up
	 */
	public void setupLineUp(EList<LineUp> lineUps) {
		if (lineUps != null) {
			for (LineUp lineup : lineUps) {
				if (lineup.getTeamType().equals(EngineConstants.VISITOR)) {
					visitorLineup = new LineupManager();
					visitorLineup.init(lineup, visitorIpCounter);
				} else {
					hometeamLineup = new LineupManager();
					hometeamLineup.init(lineup, hometeamIpCounter);
				}
			}
		}	
	}
		
	/**
	 * Get the current line-up
	 * 
	 * @return refrence on the current line-up
	 */
	public LineupManager getCurrentLineup() {
		return currentLineup;
	}

	/**
	 * Start the analyze of a half inning.
	 * 
	 * @param halfInning reference on the half inning
	 */
	public void startInning(HalfInning halfInning) {
		currentTeam = halfInning.getTeam();
		lastCurrentTeam = currentTeam;

		runnerPositionManager.clearField();
		if (halfInning.getTeam().equals(EngineConstants.HOMETEAM)) {
			currentLineup = hometeamLineup;
		} else {
			currentLineup = visitorLineup;
		}
		runnerPositionManager.setLineUpManager(currentLineup);
		runnerPositionManager.setNewBatter();

	}

	/**
	 * Close the analyze of a half inning.
	 * 
	 * @param halfInning reference on the half inning
	 */
	public void closeInning(HalfInning halfInning) {
		currentTeam = null;
	}

	/**
	 * Start the analyze of an action.
	 * 
	 * @param team Name of the team
	 * @param action reference on the action
	 */
	public void startAction(String team, Action action) {
		currentAction = action;
		putoutDetected = 0;
		isGdpAction = false;
		doublePlayDetection = 0;

		if ( (action.getBatterAction() != null) && 
			 ((action.getBatterAction() instanceof BatterOutOnGroundedDoublePlay) || 
			  (action.getBatterAction() instanceof BatterAdvanceOnGdpWithError) || 
			  (action.getBatterAction() instanceof BatterAdvanceOnGdpWithFielderChoice))) {
			
				isGdpAction = true;
		}
		
		if (action.getBatterAction() != null) {
			if (action.getBatterAction() instanceof BatterOut) {
				putoutDetected++;
				if (!((BatterOut)action.getBatterAction()).isNotInDoublePlay()) {
					doublePlayDetection++;
				}
			} else if ((action.getBatterAction() instanceof BatterAdvance) && (((BatterAdvance)action.getBatterAction()).getOut() != null)) {
					putoutDetected++;
					
					if (isDoublePlayActionForMoreADvanceFail(((BatterAdvance)action.getBatterAction()).getOut())) {
						doublePlayDetection++;
					}
					
			} else {
				// Nothing to do
			}
			
		}
		for (RunnerAction runnerAction : action.getRunnerActions()) {
			if (runnerAction instanceof RunnerOut)  {
				putoutDetected++;

				if (!((RunnerOut)runnerAction).isNotInDoublePlay()) {
					doublePlayDetection++;
				}

			} else if ( (runnerAction instanceof RunnerAdvance) && ( ((RunnerAdvance)runnerAction).getRunnerOut() != null)){
					putoutDetected++;

					if (isDoublePlayActionForMoreADvanceFail(((RunnerAdvance)runnerAction).getRunnerOut())) {
						doublePlayDetection++;
					}
			} else {
				// nothing to do
			}
		}
	}

	/**
	 * Indicate if an out participate to a double play
	 * 
	 * @param out action to check
	 * 
	 * @return <b>true</b> if participate to a double play, <b>false</b> otherwise
	 */
	private boolean isDoublePlayActionForMoreADvanceFail(MoreAdanceFail out) {
		if (out instanceof RunnerOutOnFielderAction) {
			return ( !((RunnerOutOnFielderAction)out).isNotInDoublePlay() );
		
		} else if(out instanceof RunnerOutByRules) {
			return ( !((RunnerOutByRules)out).isNotInDoublePlay() );
			
		} else if(out instanceof RunnerOutOnAppeal) {
			return ( !((RunnerOutOnAppeal)out).isNotInDoublePlay() );
			
		} else {
			
			logger.log(Level.SEVERE,"AbstractActionManager::isDoublePlayActionForMoreADvanceFail don't manage out of type {0}", out.getClass().getSimpleName() );
			return false;
		}
	}

	/**
	 * Close the analyze of an action.
	 * 
	 * @param team Name of the team
	 * @param action reference on the action
	 */
	public void closeAction(String team, Action action) {
		// nothing to do
	}

	/**
	 * Start a game analyze.
	 */
	public void startGame() {
		// No Action to do
	}

	/**
	 * End a game analyze.
	 */
	public void closeGame() {
		// No Action to do
	}

	/**
	 * Get the reference on the visitor line-up.
	 * 
	 * @return reference on the visitor line-up
	 */
	public LineupManager getVisitorLineup() {
		return visitorLineup;
	}

	/**
	 * Get the reference on the home team line-up.
	 * 
	 * @return reference on the home team line-up
	 */
	public LineupManager getHometeamLineup() {
		return hometeamLineup;
	}

	/**
	 * Get the reference on the current line-up.
	 * 
	 * @return reference on the current line-up
	 */
	protected LineupManager getCurrentLineupManager() {
		return currentLineup;
	}

	/**
	 * Manager pitch description.
	 * 
	 * @param pitch pitch element
	 * @param team name of the team
	 */
	protected void manage(Pitch pitch, String team) {
	}

	/**
	 * Manage the tie break situation.
	 * 
	 * @throws OccupedbaseException
	 */
	public void manageTieBreak() throws OccupedbaseException {
		int offensivePosition = currentLineup.getCurrentBatterNumber();

		for (int pos = 1; pos < 3; pos++) {

			offensivePosition -= 1;
			if (offensivePosition == 0) {
				offensivePosition = 9;
			}

			LineupEntry player = currentLineup.getPlayerForOffensivePosition("" + offensivePosition); //$NON-NLS-1$
			runnerPositionManager.setRunnerAtPosition(player, pos);
		}
	}

	/**
	 * Manage an action. 
	 * 
	 * @param action reference on the action
	 * @throws OccupedbaseException
	 */
	public void manage(Action action) throws OccupedbaseException {

		for (int i = action.getRunnerActions().size() - 1; i >= 0; i--) {

			RunnerAction runnerAction = action.getRunnerActions().get(i);
			manage(runnerAction);

			if (runnerAction instanceof RunnerAdvance) {
				RunnerAdvance runnerAdvance = (RunnerAdvance) runnerAction;

				for (AdvanceWithContinuation moreAdvance : runnerAdvance.getMoreAdvances()) {
					manage(moreAdvance);
				}

				if (runnerAdvance.getRunnerOut() != null) {
					manage(runnerAdvance.getRunnerOut());
				}
			}

		}

		if (action.getBatterAction() != null) {
			BatterAction batterAction = action.getBatterAction();
			manage(action.getBatterAction());

			if (batterAction instanceof BatterAdvance) {
				BatterAdvance batterAdvance = (BatterAdvance) batterAction;

				for (AdvanceWithContinuation moreAdvance : batterAdvance.getMoreAdvances()) {
					manage(moreAdvance);
				}

				if (batterAdvance.getOut() != null) {
					manage(batterAdvance.getOut());
				}
			}
		}
	}

	/**
	 * Manage a more advance fail action.
	 * 
	 * @param out reference to a more advance fail action
	 */
	private void manage(MoreAdanceFail out) {
		if (out instanceof RunnerOutOnFielderAction) {
			makeActionOn((RunnerOutOnFielderAction) out);
		} else if (out instanceof RunnerOutByRules) {
			makeActionOn((RunnerOutByRules) out);
		} else if (out instanceof RunnerOutOnAppeal) {
			makeActionOn((RunnerOutOnAppeal) out);
		} else {
			String message = NLS.bind(Messages.AbstractActionManager_BadClassMoreAdvanceFail, out.getClass().getSimpleName()); 
			logger.log(Level.SEVERE, message);
		}
	}

	
	/**
	 * Manage a more advance fail action.
	 * 
	 * @param moreAdvance reference on the more Aadvance action 
	 * 
	 * @throws OccupedbaseException
	 */
	private void manage(AdvanceWithContinuation moreAdvance) throws OccupedbaseException {
		if (moreAdvance instanceof RunnerAdvanceOnNonDecisiveFlyError) {
			makeActionOn((RunnerAdvanceOnNonDecisiveFlyError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnError) {
			makeActionOn((RunnerAdvanceOnError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			makeActionOn((RunnerAdvanceOnNonDecisiveThrowError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			makeActionOn((RunnerAdvanceOnNonDecisiveReceiveError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnOccupedBall) {
			makeActionOn((RunnerAdvanceOnOccupedBall) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnDefensiveChoice) {
			makeActionOn((RunnerAdvanceOnDefensiveChoice) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnThrowError) {
			makeActionOn((RunnerAdvanceOnThrowError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnReceiveError) {
			makeActionOn((RunnerAdvanceOnReceiveError) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnThrow) {
			makeActionOn((RunnerAdvanceOnThrow) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnNoDecisiveObstruction) {
			makeActionOn((RunnerAdvanceOnNoDecisiveObstruction) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnDecisiveObstruction) {
			makeActionOn((RunnerAdvanceOnDecisiveObstruction) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnRule) {
			makeActionOn((RunnerAdvanceOnRule) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnIndiference) {
			makeActionOn((RunnerAdvanceOnIndiference) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnWildPitch) {
			makeActionOn((RunnerAdvanceOnWildPitch) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnPassBall) {
			makeActionOn((RunnerAdvanceOnPassBall) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnBalk) {
			makeActionOn((RunnerAdvanceOnBalk) moreAdvance);
		} else if (moreAdvance instanceof RunnerAdvanceOnStolenBase) {
			makeActionOn((RunnerAdvanceOnStolenBase) moreAdvance);
		} else {
			String message = NLS.bind(Messages.AbstractActionManager_AdvanceWithContinuation, moreAdvance.getClass().getSimpleName());
			logger.log(Level.SEVERE,message);
		}

	}

	/**
	 * Runner get more advance on a decisive obstruction action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	protected void makeActionOn(RunnerAdvanceOnDecisiveObstruction moreAdvance) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, moreAdvance});
		}

		int runnerPosition;
		if (moreAdvance.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(moreAdvance.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, moreAdvance,
				moreAdvance.getIsEarned());
	}

	/**
	 * Runner get more advance on a no decisive obstruction action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	protected void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction moreAdvance) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, moreAdvance});
		}

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, moreAdvance,
				moreAdvance.getIsEarned());
	}

	/**
	 * Runner get more advance on a defensive choice action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	protected void makeActionOn(RunnerAdvanceOnDefensiveChoice moreAdvance) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, moreAdvance});
		}

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, moreAdvance,
				moreAdvance.getIsEarned());
	}

	/**
	 * Runner get more advance on no decisive fly error action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, moreAdvance});
		}

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, moreAdvance,
				moreAdvance.getIsEarned());
	}

	/**
	 * Manage all runners action.
	 * 
	 * @param action reference to the action.
	 * @throws OccupedbaseException
	 */
	private void manage(RunnerAction action) throws OccupedbaseException {
		if (action instanceof RunnerMustBeOutOnError) {
			makeActionOn((RunnerMustBeOutOnError) action);
		} else if (action instanceof RunnerDontAdvanceOnError) {
			makeActionOn((RunnerDontAdvanceOnError) action);
		} else if (action instanceof RunnerDontAdvanceOnPickOffWithError) {
			makeActionOn((RunnerDontAdvanceOnPickOffWithError) action);
		} else if (action instanceof RunnerDontAdvanceOnCaughtStealingWithError) {
			makeActionOn((RunnerDontAdvanceOnCaughtStealingWithError) action);
		} else if (action instanceof RunnerDontAdvanceOnThrowError) {
			makeActionOn((RunnerDontAdvanceOnThrowError) action);
		} else if (action instanceof RunnerDontAdvanceOnReceiveError) {
			makeActionOn((RunnerDontAdvanceOnReceiveError) action);
		} else if (action instanceof RunnerDontAdvanceOnNonDecisiveThrowError) {
			makeActionOn((RunnerDontAdvanceOnNonDecisiveThrowError) action);
		} else if (action instanceof RunnerDontAdvanceOnNonDecisiveReceiveError) {
			makeActionOn((RunnerDontAdvanceOnNonDecisiveReceiveError) action);

		} else if (action instanceof RunnerOutOnCaugthStealing) {
			makeActionOn((RunnerOutOnCaugthStealing) action);
		} else if (action instanceof RunnerOutOnPickOff) {
			makeActionOn((RunnerOutOnPickOff) action);
		} else if (action instanceof RunnerOutOnFielderAction) {
			makeActionOn((RunnerOutOnFielderAction) action);
		} else if (action instanceof RunnerOutByRules) {
			makeActionOn((RunnerOutByRules) action);
		} else if (action instanceof RunnerOutOnAppeal) {
			makeActionOn((RunnerOutOnAppeal) action);
		} else if (action instanceof RunnerAdvanceByBatterAction) {
			makeActionOn((RunnerAdvanceByBatterAction) action);
		} else if (action instanceof RunnerAdvanceOnError) {
			makeActionOn((RunnerAdvanceOnError) action);
		} else if (action instanceof RunnerAdvanceOnStolenBase) {
			makeActionOn((RunnerAdvanceOnStolenBase) action);
		} else if (action instanceof RunnerAdvanceOnWildPitch) {
			makeActionOn((RunnerAdvanceOnWildPitch) action);
		} else if (action instanceof RunnerAdvanceOnPassBall) {
			makeActionOn((RunnerAdvanceOnPassBall) action);
		} else if (action instanceof RunnerAdvanceOnBalk) {
			makeActionOn((RunnerAdvanceOnBalk) action);
		} else if (action instanceof RunnerAdvanceOnPickOffWithError) {
			makeActionOn((RunnerAdvanceOnPickOffWithError) action);
		} else if (action instanceof RunnerAdvanceOnDecisiveObstruction) {
			makeActionOn((RunnerAdvanceOnDecisiveObstruction) action);
		} else if (action instanceof RunnerAdvanceOnCaughtStealingWithError) {
			makeActionOn((RunnerAdvanceOnCaughtStealingWithError) action);
		} else if (action instanceof RunnerAdvanceOnOccupedBall) {
			makeActionOn((RunnerAdvanceOnOccupedBall) action);
		} else if (action instanceof RunnerAdvanceOnThrow) {
			makeActionOn((RunnerAdvanceOnThrow) action);
		} else if (action instanceof RunnerAdvanceOnIndiference) {
			makeActionOn((RunnerAdvanceOnIndiference) action);
		} else if (action instanceof RunnerAdvanceOnThrowError) {
			makeActionOn((RunnerAdvanceOnThrowError) action);
		} else if (action instanceof RunnerAdvanceOnReceiveError) {
			makeActionOn((RunnerAdvanceOnReceiveError) action);
		} else if (action instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			makeActionOn((RunnerAdvanceOnNonDecisiveThrowError) action);
		} else if (action instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			makeActionOn((RunnerAdvanceOnNonDecisiveReceiveError) action);
		} else if (action instanceof RunnerAdvanceOnRule) {
			makeActionOn((RunnerAdvanceOnRule) action);
		} else if (action instanceof RunnerAdvanceOnOtherPlayerError) {
			makeActionOn((RunnerAdvanceOnOtherPlayerError) action);
		} else if (action instanceof RunnerAdvanceOnFielderChoice) {
			makeActionOn((RunnerAdvanceOnFielderChoice) action);
		} else {
			String message = NLS.bind(Messages.AbstractActionManager_RunnerAction, action.getClass().getSimpleName());
			logger.log(Level.SEVERE, message); 
		}
	}

	/**
	 * Manage specific commands.
	 * 
	 * @param element reference to the command
	 */
	public void manage(Commands element) {
		if (element.getCommand() instanceof MoveCommand) {
			makeCommand((MoveCommand) element.getCommand());
		} else if (element.getCommand() instanceof SelectedBatterCommand) {
			makeCommand((SelectedBatterCommand) element.getCommand());
		} else {
			String message = NLS.bind(Messages.AbstractActionManager_Commands, element.getCommand().getClass().getSimpleName());
			logger.log(Level.SEVERE, message); 
		}
	}

	/**
	 * Manage command: changer change batter
	 * 
	 * @param selectedBatterCommand reference to the command
	 */
	public void makeCommand(SelectedBatterCommand selectedBatterCommand) {
		currentLineup.setCurrentBatter(selectedBatterCommand.getStarterBatter());
		runnerPositionManager.setNewBatter();
	}

	/**
	 * Manage specific commands.
	 * 
	 * @param command reference to the command
	 */
	public void makeCommand(MoveCommand command) {
		// No Action to do
	}

	/**
	 * Manage a runner action of type Runner don't advance on error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on pick off error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnPickOffWithError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on caught stealing with error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on throx error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnThrowError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on receive error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnReceiveError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on no decisive throw error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner don't advance on non decisive received error action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage a runner action of type Runner advance on other player error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnOtherPlayerError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on rule action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnRule action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on no decisive received error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on no decisive throw error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on receive error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on fielder choice action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnFielderChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on throw error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on indifference action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnIndiference action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on throw action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnThrow action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on occupied ball action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnOccupedBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on caught stealing with error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnCaughtStealingWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on pick off with error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on balk action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on pass ball action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on wild pitch action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on stolen base action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnStolenBase action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceOnError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner advance on batter action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(RunnerAdvanceByBatterAction action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(runnerPosition, runnerPosition + baseWin, action, action.getIsEarned());
	}

	/**
	 * Manage a runner action of type Runner out on appeal.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerOutOnAppeal action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		runnerPositionManager.setPlayerOut(runnerPosition);
	}

	/**
	 * Manage a runner action of type Runner out by rules.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerOutByRules action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		runnerPositionManager.setPlayerOut(runnerPosition);
	}

	/**
	 * Manage a runner action of type Runner out on fielder action.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerOutOnFielderAction action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		runnerPositionManager.setPlayerOut(runnerPosition);
	}

	/**
	 * Manage a runner action of type Runner out on pick off.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerOutOnPickOff action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		runnerPositionManager.setPlayerOut(runnerPosition);
	}

	/**
	 * Manage a runner action of type Runner out on caught stealing.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerOutOnCaugthStealing action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		runnerPositionManager.setPlayerOut(runnerPosition);
	}

	/**
	 * Manage a runner action of type Runner must be out on error.
	 * 
	 * @param action action reference to the action
	 */
	protected void makeActionOn(RunnerMustBeOutOnError action){

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage all batter actions.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException
	 */
	protected void manage(BatterAction action) throws OccupedbaseException {
		if (action instanceof BatterOutOnSwingedStrike) {
			makeActionOn((BatterOutOnSwingedStrike) action);
		} else if (action instanceof BatterOutOnLookedStrike) {
			makeActionOn((BatterOutOnLookedStrike) action);
		} else if (action instanceof BatterOutOnReleasedStrike) {
			makeActionOn((BatterOutOnReleasedStrike) action);
		} else if (action instanceof BatterOutOnFlyed) {
			makeActionOn((BatterOutOnFlyed) action);
		} else if (action instanceof BatterOutOnLine) {
			makeActionOn((BatterOutOnLine) action);
		} else if (action instanceof BatterOutOnPopped) {
			makeActionOn((BatterOutOnPopped) action);
		} else if (action instanceof BatterOutOnFlyedFallBall) {
			makeActionOn((BatterOutOnFlyedFallBall) action);
		} else if (action instanceof BatterOutOnPoppedFallBall) {
			makeActionOn((BatterOutOnPoppedFallBall) action);
		} else if (action instanceof BatterOutOnLineDriveFallBall) {
			makeActionOn((BatterOutOnLineDriveFallBall) action);
		} else if (action instanceof BatterOutOnGroundedBall) {
			makeActionOn((BatterOutOnGroundedBall) action);
		} else if (action instanceof BatterOutByRule) {
			makeActionOn((BatterOutByRule) action);
		} else if (action instanceof BatterOutOnAppeal) {
			makeActionOn((BatterOutOnAppeal) action);
		} else if (action instanceof BatterOutOnGroundedDoublePlay) {
			makeActionOn((BatterOutOnGroundedDoublePlay) action);
		} else if (action instanceof BatterOutOnSacrificeFly) {
			makeActionOn((BatterOutOnSacrificeFly) action);
		} else if (action instanceof BatterOutOnSacrificeFlyFallBall) {
			makeActionOn((BatterOutOnSacrificeFlyFallBall) action);
		} else if (action instanceof BatterOutOnSacrificeHit) {
			makeActionOn((BatterOutOnSacrificeHit) action);
		} else if (action instanceof BatterOutOnInfieldFly) {
			makeActionOn((BatterOutOnInfieldFly) action);
		} else if (action instanceof BatterAdvanceOnFlyError) {
			makeActionOn((BatterAdvanceOnFlyError) action);
		} else if (action instanceof BatterAdvanceOnReceiveError) {
			makeActionOn((BatterAdvanceOnReceiveError) action);
		} else if (action instanceof BatterAdvanceOnThrowError) {
			makeActionOn((BatterAdvanceOnThrowError) action);
		} else if (action instanceof BatterAdvanceOnGdpWithError) {
			makeActionOn((BatterAdvanceOnGdpWithError) action);
		} else if (action instanceof BatterAdvanceOnIndiference) {
			makeActionOn((BatterAdvanceOnIndiference) action);
		} else if (action instanceof BatterAdvanceOnGdpWithFielderChoice) {
			makeActionOn((BatterAdvanceOnGdpWithFielderChoice) action);
		} else if (action instanceof BatterAdvanceOnSingleHit) {
			makeActionOn((BatterAdvanceOnSingleHit) action);
		} else if (action instanceof BatterAdvanceOnDoubleHit) {
			makeActionOn((BatterAdvanceOnDoubleHit) action);
		} else if (action instanceof BatterAdvanceOnTripleHit) {
			makeActionOn((BatterAdvanceOnTripleHit) action);
		} else if (action instanceof BatterAdvanceOnHomeRun) {
			makeActionOn((BatterAdvanceOnHomeRun) action);
		} else if (action instanceof BatterAdvanceOnInsidePark) {
			makeActionOn((BatterAdvanceOnInsidePark) action);
		} else if (action instanceof BatterAdvanceOnBaseOnBall) {
			makeActionOn((BatterAdvanceOnBaseOnBall) action);
		} else if (action instanceof BatterAdvanceOnIntentionalBaseOnBall) {
			makeActionOn((BatterAdvanceOnIntentionalBaseOnBall) action);
		} else if (action instanceof BatterAdvanceOnHitByPitch) {
			makeActionOn((BatterAdvanceOnHitByPitch) action);
		} else if (action instanceof BatterAdvanceOnKPassBall) {
			makeActionOn((BatterAdvanceOnKPassBall) action);
		} else if (action instanceof BatterAdvanceOnKWildPitch) {
			makeActionOn((BatterAdvanceOnKWildPitch) action);
		} else if (action instanceof BatterAdvanceOnKAbr) {
			makeActionOn((BatterAdvanceOnKAbr) action);
		} else if (action instanceof BatterAdvanceOnKWithError) {
			makeActionOn((BatterAdvanceOnKWithError) action);
		} else if (action instanceof BatterAdvanceOnSacrificeHitWithError) {
			makeActionOn((BatterAdvanceOnSacrificeHitWithError) action);
		} else if (action instanceof BatterAdvanceOnSacrificeHitWithFielderChoice) {
			makeActionOn((BatterAdvanceOnSacrificeHitWithFielderChoice) action);
		} else if (action instanceof BatterAdvanceOnSacrificeFlyWithError) {
			makeActionOn((BatterAdvanceOnSacrificeFlyWithError) action);
		} else if (action instanceof BatterAdvanceOnSacrificeFlyWithFielderChoice) {
			makeActionOn((BatterAdvanceOnSacrificeFlyWithFielderChoice) action);
		} else if (action instanceof BatterAdvanceOnCatcherInterference) {
			makeActionOn((BatterAdvanceOnCatcherInterference) action);
		} else if (action instanceof BatterAdvanceOnObstruction) {
			makeActionOn((BatterAdvanceOnObstruction) action);
		} else if (action instanceof BatterAdvanceOnKWithFielderChoice) {
			makeActionOn((BatterAdvanceOnKWithFielderChoice) action);
		} else if (action instanceof BatterAdvanceOnOccupedBall) {
			makeActionOn((BatterAdvanceOnOccupedBall) action);
		} else if (action instanceof BatterAdvanceOnDefensiveChoice) {
			makeActionOn((BatterAdvanceOnDefensiveChoice) action);
		} else if (action instanceof BatterLostTurn) {
			makeActionOn((BatterLostTurn) action);
		} else if (action instanceof BatterMustOutOnFlyFoulBall) {
			makeActionOn((BatterMustOutOnFlyFoulBall) action);
		} else if (action instanceof BatterBalk) {
			makeActionOn((BatterBalk) action);
		} else {
			
			String message = NLS.bind(Messages.AbstractActionManager_BatterAction, action.getClass().getSimpleName());
			logger.log(Level.SEVERE,message);
		}
	}

	/**
	 * Manage Batter balk action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterBalk action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage Batter must be out on fly foul ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterMustOutOnFlyFoulBall action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}
	}

	/**
	 * Manage Batter advance on batter lost turn action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterLostTurn action) {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter advance on indifference action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on defensive choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on occupied ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on strike with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on obstruction action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on catcher interference action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on sacrifice fly with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on sacrifice fly with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on sacrifice hit with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on sacrifice hit with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on strike with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on K Advance by rule action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnKAbr action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on K Wild pitch action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on K pass ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on hit by pitch action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on intentional base on ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on base on ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on inside park action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, action.getIsEarned());

		setNewBatter();
	}

	/**
	 * Manage Batter advance on home run action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, action.getIsEarned());

		setNewBatter();
	}

	/**
	 * Manage Batter advance on triple hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on double hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on single hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on Grounded double play with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on Grounded double play with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on throw error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on received error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter advance on fly error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	protected void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException {
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		runnerPositionManager.runnerAdvance(0, baseWin, action, null);

		setNewBatter();
	}

	/**
	 * Manage Batter out on infield fly action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnInfieldFly action) {
		/* Do specific action in function of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on sacrifice hit action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnSacrificeHit action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on sacrifice fly fall ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnSacrificeFlyFallBall action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on sacrifice fly ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnSacrificeFly action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on grounded double play action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnGroundedDoublePlay action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on batter out by appeal ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnAppeal action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on batter out by rules ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutByRule action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out on grounded ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnGroundedBall action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On line fall ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnLineDriveFallBall action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On Popup fall ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnPoppedFallBall action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On Flyed fall ball action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnFlyedFallBall action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On Popup action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnPopped action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On Line action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnLine action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On fly action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnFlyed action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,DEBUG_FORMAT_STRING_1, new Object[] {currentTeam, action});
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On release strike action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnReleasedStrike action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			StringBuilder str = new StringBuilder("[" + currentTeam + "]:" + action.getCurrentBatter() + " : "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			str.append(DEBUG_FORMAT_STRIKE_OUT + action.getStrikeOutValue());
			logger.log(Level.FINE,"{0}",str); //$NON-NLS-1$
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On look strike action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnLookedStrike action) {
		/* Do specific action in funtion of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			StringBuilder str = new StringBuilder("[" + currentTeam + "]:" + action.getCurrentBatter() + " : "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			str.append(DEBUG_FORMAT_STRIKE_OUT + action.getStrikeOutValue());
			logger.log(Level.FINE,"{0}",str); //$NON-NLS-1$
		}

		setNewBatter();
	}

	/**
	 * Manage Batter out On Swing strike action.
	 * 
	 * @param action reference to the action
	 */
	protected void makeActionOn(BatterOutOnSwingedStrike action) {
		/* Do specific action in function of the team */
		if (currentTeam.equals(EngineConstants.HOMETEAM)) {
			hometeamIpCounter.addPutOut();
		} else {
			visitorIpCounter.addPutOut();
		}

		if (EngineConstants.debugEngine) {
			StringBuilder str = new StringBuilder("[" + currentTeam + "]:" + action.getCurrentBatter() + " : "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			str.append(DEBUG_FORMAT_STRIKE_OUT + action.getStrikeOutValue());
			logger.log(Level.FINE,"{0}",str); //$NON-NLS-1$
		}

		setNewBatter();
	}

	/**
	 * Set the new batter
	 */
	protected void setNewBatter() {
		currentLineup.nextBatter();
		runnerPositionManager.setNewBatter();
	}

	/**
	 * Manage a substitution event.
	 * 
	 * @param substitutionEvent reference to the substitution event
	 */
	public void manage(SubstitutionEvent substitutionEvent) {

		SubstitutionManager substitutionManager = new SubstitutionManager();

		String team = substitutionEvent.getTeam();
		substitutionManager.setTeam(team);
		LineupManager lineupManager = (team.equals(EngineConstants.HOMETEAM) ? hometeamLineup : visitorLineup);
		IpCounter currentIpCounter = (team.equals(EngineConstants.HOMETEAM) ? visitorIpCounter : hometeamIpCounter);

		substitutionManager.setLineupManager(lineupManager);
		substitutionManager.setCurrentIpCounter(currentIpCounter);

		for (SubstitutionDescription sub : substitutionEvent.getSubstitutions()) {
			manageSubstitution(substitutionEvent.getTeam(), substitutionManager, sub);
		}

		substitutionManager.applySubstitution();
		callCallbackSubstitutionManager(substitutionManager);
	}

	/**
	 * CallBack for the management of substitutions
	 * 
	 * @param substitutionManager reference on the substitution manager
	 */
	protected void callCallbackSubstitutionManager(SubstitutionManager substitutionManager) {
		if (currentTeam.equals(substitutionManager.getTeam())) {
			for (SubstitutionCommonData substitution : substitutionManager.getSubstitutions()) {
				if (substitution instanceof ReplacementData) {
					ReplacementData replacement = (ReplacementData) substitution;
					LineupEntry playerEntry = currentLineup.getPlayerForOffensivePosition(replacement.getOffensivePosition());
					int position = runnerPositionManager.getPosition(replacement.getPlayer());
					try {
						runnerPositionManager.setPlayerOut(position);
						runnerPositionManager.setRunnerAtPosition(playerEntry, position);
					} catch (OccupedbaseException e) {
						logger.log(Level.SEVERE,e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Manage a substitution.
	 * 
	 * @param team team name
	 * @param substitutionManager reference to the substitution manager
	 * @param sub reference on on the substitution description
	 */
	protected void manageSubstitution(String team, SubstitutionManager substitutionManager,
			SubstitutionDescription sub) {
		if (sub.getSubtitution() instanceof NewDefensivePosition) {
			substitutionManager.addMoveto(sub);

		} else if (sub.getSubtitution() instanceof Replacement) {
			substitutionManager.addReplacement(sub);
		}
	}

	/**
	 * Check if we must avoid a RBI on a GDP.
	 * 
	 * @return <b>true</b> avoid RBI on GDP,<b>false</b> otherwise
	 */
	protected boolean avoidRbiOnGDP() {
		boolean avoidRbi = false;

		BatterAction batterAction = currentAction.getBatterAction();
		if  ((batterAction != null)  && 
			    (batterAction instanceof BatterAdvanceOnGdpWithError || 
			     batterAction instanceof BatterAdvanceOnGdpWithFielderChoice ||
			     batterAction instanceof BatterOutOnGroundedDoublePlay)) {
				// nothing to do 
		}

		return avoidRbi;
	}

	/**
	 * Not used
	 */
	public void debug() {
		// No Action to do
	}

	/**
	 * Manage the game resume object
	 * 
	 * @param gameResume reference on the game resume object
	 */
	public void manage(GameResume gameResume) {
		// Nothing to do
	}
}
