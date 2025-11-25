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
import java.util.LinkedList;
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
import org.bpy.score.game.game.BatterAdvanceOnKAbr;
import org.bpy.score.game.game.BatterAdvanceOnKPassBall;
import org.bpy.score.game.game.BatterAdvanceOnKWildPitch;
import org.bpy.score.game.game.BatterAdvanceOnKWithError;
import org.bpy.score.game.game.BatterAdvanceOnKWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnObstruction;
import org.bpy.score.game.game.BatterAdvanceOnOccupedBall;
import org.bpy.score.game.game.BatterAdvanceOnPopError;
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
import org.bpy.score.reports.gamereports.TEAM;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;

/**
 * This class analyse actions for create a play by play description.
 *   
 * @author Patrick BRIAND
 *
 */
public class PlayByPlayManager extends AbstractActionManager {

	/** String ky for the player name */
	public static final String PLAYER_NAME = "<<name>>"; //$NON-NLS-1$ 
	/** String key for the new player name */
	public static final String NEW_PLAYER_NAME = "<<new_name>>"; //$NON-NLS-1$
	/** String key for the coming from position */
	public static final String FROM_POSITION = "<<fromPosition>>"; //$NON-NLS-1$
	/** String key for the new position */
	public static final String TO_POSITION = "<<toPosition>>"; //$NON-NLS-1$
	/** String key for the defensive position */
	public static final String DEFENSIVE_POSITION = "<<defensivePosition>>"; //$NON-NLS-1$
	/** String key for the defensive player */
	public static final String DEFENSIVE_PLAYER = "<<defensivePlayer>>"; //$NON-NLS-1$
	/** String key for number of base win */
	public static final String BASE_WIN = "<<baseWin>>"; //$NON-NLS-1$
	/** String key for defensive out fielder name */
	public static final String DEFENSIVE_OUT_FIELDER = "<<defensiveOutFielder>>"; //$NON-NLS-1$
	/** String key for defensive in fielder name */
	public static final String DEFENSIVE_IN_FIELDER = "<<defensiveInFielder>>"; //$NON-NLS-1$
	/** String key for hit location */
	public static final String HIT_LOCATION = "<<hitLocation>>"; //$NON-NLS-1$
	
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
	private LinkedList<String> actionDescription;
	/** Inning statistics for the home team */
	private EList<InninStatictic> hometeamStats;
	/** Inning statistics for the visitor team */
	private EList<InninStatictic> visitorStats;
	/** Used for add a space after a . if needed */
	private String neededSpace;

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
		actionDescription = new LinkedList<>();
		super.startAction(team, action);
	}

	@Override
	public void closeAction(String team, Action element) {
		StringBuilder actionBuilder = new StringBuilder(neededSpace);
		neededSpace = " "; //$NON-NLS-1$
		
		while (!actionDescription.isEmpty()) {
			actionBuilder.append(actionDescription.poll());
			if (!actionDescription.isEmpty()) {
				actionBuilder.append("; "); //$NON-NLS-1$
			}
		}
		
		actionBuilder.append("."); //$NON-NLS-1$
		inningDescription.append(actionBuilder);
		super.closeAction(team, element);
	}

	@Override
	public void startInning(HalfInning halfInning) {
		neededSpace = ""; //$NON-NLS-1$
		container = new PlayByPlayContainer();
		
		inningDescription = new StringBuilder();

		String teamType = Messages.PlayByPlayManager_Visitor;
		String teamName = ""; //$NON-NLS-1$
		
		currentTeam = halfInning.getTeam(); 
		if (EngineConstants.HOMETEAM.equals(currentTeam)) {
			teamType = Messages.PlayByPlayManager_Hometeam;
			container.setTeam(TEAM.HOMETEAM);
		} else {
			inningCounter++;
			container.setTeam(TEAM.VISITOR);
		}
		
		String header = NLS.bind(Messages.PlayByPlayManager_Header, new Object[] {teamType, teamName, inningCounter});
		container.setHeader(header);
		super.startInning(halfInning);
	}

	@Override
	public void closeInning(HalfInning halfInning) {
		
		InningGeneralStatistic stats = null;
		if (EngineConstants.VISITOR.equals(currentTeam)) {
			stats = visitorStats.get(inningCounter-1).getInningStat();
		} else {
			// D1B0146
			stats = hometeamStats.get(inningCounter-1).getInningStat();
		}
		
		int lobCounter = this.getRunnerPositionManager().getLeftOnBase();
		String closeMessage = NLS.bind(Messages.PlayByPlayManager_Resume, new Object[] {stats.getRuns(),stats.getHits(),stats.getErrors(),lobCounter}); 
		container.setContent(inningDescription.toString());
		container.setResume(closeMessage);
		elements.add(container);
		super.closeInning(halfInning);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction moreAdvance) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		boolean isMoreAdavance = false;

		if (moreAdvance.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(moreAdvance.getRunner());
		} else {
			isMoreAdavance = true;
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		String whoMakeTheObstuction = getDefensivePosition(ScoreGameError.getDefensivePosition(moreAdvance));
		
		if (isMoreAdavance) {

			if ((runnerPosition+baseWin) == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnNoDecisiveObstruction;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheObstuction});
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNoDecisiveObstruction;
				String strLocation = "" + (baseWin + runnerPosition); //$NON-NLS-1$
				String location = getDefensiveLocation(strLocation.charAt(0));
				putMoreAdavcenMessage(message, new String[] {whoMakeTheObstuction, location});
			}
			
		} else {
		
			if ((runnerPosition+baseWin) == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnNoDecisiveObstruction;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheObstuction});
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnNoDecisiveObstruction;
				String location = getBaseWin(baseWin + runnerPosition);
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheObstuction, location});
			}
		}
		
		super.makeActionOn(moreAdvance);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnDefensiveChoice moreAdvance) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(moreAdvance));
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		if ((runnerPosition+baseWin) == 4) {
			String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnDefensiveChoice;
			putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice});
		} else {
			String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnDefensiveChoice;
			String location = getBaseWin(baseWin + runnerPosition);
			putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice, location});
		}
 
		super.makeActionOn(moreAdvance);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(moreAdvance));
		
		if ((runnerPosition+baseWin) == 4) {
			String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveFlyError;
			putMoreAdavcenMessage(message, new String[] {whoMakeTheError});
			
		} else {
			String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveFlyError;
			String location = getBaseWin(baseWin + runnerPosition);
			putMoreAdavcenMessage(message, new String[] {whoMakeTheError, location});
		}

		super.makeActionOn(moreAdvance);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnError;
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName()});
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnPickOffWithError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnPickOffWithError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnCaughtStealingWithError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
				
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnThrowError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnThrowError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});
		

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnReceiveError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnReceiveError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action) {

		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnNonDecisiveThrowError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		}	

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerDontAdvanceOnNonDecisiveReceiveError;
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnOtherPlayerError action) throws OccupedbaseException {
		int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnOtherPlayerError;
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnOtherPlayerError;
				putMoreAdavcenMessage(message, new String[] {newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnOtherPlayerError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnOtherPlayerError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}
		
		super.makeActionOn(action);
	}

	@Override
	@SuppressWarnings("java:S1185")
	public void makeActionOn(RunnerAdvanceOnRule action) throws OccupedbaseException {
		// N'existe plus
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameError.getDefensivePosition(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheError = getDefensivePosition(defensivePlayer);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveReceiveError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveReceiveError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnNonDecisiveReceiveError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnNonDecisiveReceiveError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError, newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameError.getDefensivePosition(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheError = getDefensivePosition(defensivePlayer);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveThrowError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveThrowError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnNonDecisiveThrowError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnNonDecisiveThrowError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError, newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameError.getDefensivePosition(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheError = getDefensivePosition(defensivePlayer);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnReceiveError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnReceiveError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnReceiveError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnReceiveError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError, newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameError.getDefensivePosition(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheError = getDefensivePosition(defensivePlayer);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnThrowError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnThrowError;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheError, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnThrowError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnThrowError;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheError, newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnIndiference action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensivePlayer = ScoreGameAdvanceUtil.getDefensivePosition(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheChoice = getDefensivePosition(defensivePlayer);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnIndiference;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnIndiference;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnIndiference;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnIndiference;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnThrow action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String defensiveOutfield = ScoreGameAdvanceUtil.getOutfielder(action);
		String defensiveInfield = ScoreGameAdvanceUtil.getInfielder(action);
		
		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheChoice = getDefensivePosition(defensiveOutfield);
		String destination = getDefensivePosition(defensiveInfield);
		
		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnThrow;
				putMoreAdavcenMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, destination});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnThrow;
				putMoreAdavcenMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, destination, newPosition});
				
			}
		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnThrow;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, destination});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnThrow;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, destination, newPosition});
			}
			
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnOccupedBall action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		
		if (isMoreAdavance) {
			
			if (baseWin+runnerPosition == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnOccupedBall; 
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnOccupedBall; 
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice, newPosition});
				
			}

		} else {
			
			if (baseWin+runnerPosition == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnOccupedBall; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnOccupedBall; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, newPosition});
				
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnCaughtStealingWithError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakeTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		if (runnerPosition+baseWin == 4 ) {

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnCaughtStealingWithErrorWithoutAssitance; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheError});
			} else {
				String message = Messages.PlayByPlayManager_RunnerScoreOnCaughtStealingWithErrorWithAssitance;
				String assistances = getAssistanceString(assists);
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheError, assistances});
			}
			
		} else {
			
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnCaughtStealingWithErrorWithoutAssitance; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheError, newPosition});
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnCaughtStealingWithErrorWithAssitance;
				String assistances = getAssistanceString(assists);
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheError, newPosition, assistances});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);
		String whoMakesTheError = getDefensivePosition(ScoreGameError.getDefensivePosition(action)); 

		if (runnerPosition+baseWin == 4) {
			String message = Messages.PlayByPlayManager_RunnerScoreOnPickOffWithError; 
			putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakesTheError});
			
		} else {
			String message = Messages.PlayByPlayManager_RunnerAdvanceOnPickOffWithError; 
			putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakesTheError, newPosition});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;
		
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnBalk; 
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnBalk; 
				putMoreAdavcenMessage(message, new String[] {newPosition});
			}

		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnBalk; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnBalk; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;
		
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnPassBall; 
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnPassBall; 
				putMoreAdavcenMessage(message, new String[] {newPosition});
			}

		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnPassBall; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnPassBall; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);

		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnWildPitch; 
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceAdvanceOnWildPitch; 
				putMoreAdavcenMessage(message, new String[] {newPosition});
			}

		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnWildPitch; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnWildPitch; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnStolenBase action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;
		
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;

		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);
				
		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnStolenBase; 
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnStolenBase; 
				putMoreAdavcenMessage(message, new String[] {newPosition});
			}

		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnStolenBase; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnStolenBase; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnError action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String newPosition = getBaseWin(runnerPosition+baseWin);
		
		if (isMoreAdavance) {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerScoreOnError; 
				putMoreAdavcenMessage(message, new String[] {});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnError; 
				putMoreAdavcenMessage(message, new String[] {newPosition});
			}

		} else {
			
			if (runnerPosition+baseWin == 4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnError; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName()});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnError; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceByBatterAction action) throws OccupedbaseException {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		if ((runnerPosition + baseWin) == 4) {
			String message = Messages.PlayByPlayManager_RunnerAdvanceByBatterActionScore;
			putMessage(message, new String[] {runner.getPlayerDescription().getName()});
		} else {
			String message = Messages.PlayByPlayManager_RunnerAdvanceByBatterActionDontScore;
			String newPosition = getBaseWin(runnerPosition+baseWin);
			putMessage(message, new String[] {runner.getPlayerDescription().getName(), newPosition});
		}	

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnDecisiveObstruction moreAdvance) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;
		
		if (moreAdvance.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(moreAdvance.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
		String whoMakesTheObstruction = getDefensivePosition(ScoreGameError.getDefensivePosition(moreAdvance));
		String position = getBaseWin(runnerPosition + baseWin);

		if (isMoreAdavance) {

			if ((runnerPosition+baseWin)==4) {
				String message = Messages.PlayByPlayManager_MoreAedvanceRunnerScoreOnDecisiveObstruction; 
				putMoreAdavcenMessage(message, new String[] {whoMakesTheObstruction});
			} else {
				String message = Messages.PlayByPlayManager_MoreAdavnceRunnerAdvanceOnDecisiveObstruction; 
				putMoreAdavcenMessage(message, new String[] {whoMakesTheObstruction, position});
			}
			
		} else {
		
			if ((runnerPosition+baseWin)==4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnDecisiveObstruction; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakesTheObstruction});
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnDecisiveObstruction; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakesTheObstruction, position});
			}
		}

		super.makeActionOn(moreAdvance);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnFielderChoice action) throws OccupedbaseException {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));

		String position = getBaseWin(runnerPosition + baseWin);
		
		if (isMoreAdavance) {

			if ((runnerPosition+baseWin)==4) {
				String message = Messages.PlayByPlayManager_MoreAdavanceRunnerScoreOnFielderChoice; 
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice});
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerAdvanceOnFielderChoice; 
				putMoreAdavcenMessage(message, new String[] {whoMakeTheChoice, position});
			}
			
		} else {
		
			if ((runnerPosition+baseWin)==4) {
				String message = Messages.PlayByPlayManager_RunnerScoreOnFielderChoice; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice});
			} else {
				String message = Messages.PlayByPlayManager_RunnerAdvanceOnFielderChoice; 
				putMessage(message, new String[] {runner.getPlayerDescription().getName(), whoMakeTheChoice, position});
			}
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerOutOnAppeal action) {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		String whoMakeTheOut = getDefensivePosition("" + ScoreGameOutUtil.getOut(action)); //$NON-NLS-1$

		if (isMoreAdavance) {

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerOutOnAppealWithoutAssists;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheOut});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerOutOnAppealWithAssists;
				String assistances = getAssistanceString(assists);
				putMoreAdavcenMessage(message, new String[] {whoMakeTheOut,assistances});
			}
			
		} else {

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_RunnerOutOnAppealWithoutAssists;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerOutOnAppealWithAssists;
				String assistances = getAssistanceString(assists);
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut,assistances});
			}
		}
		
		super.makeActionOn(action);
	}


	@Override
	public void makeActionOn(RunnerOutByRules action) {
		int runnerPosition;
		boolean isMoreAdavance = false;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		String obrNumber = ScoreGameUtil.getOBRType(action);
		String message = Messages.PlayByPlayManager_UnkonwOutByRule; 
		
		switch (obrNumber) {
		case "9": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule9 : Messages.PlayByPlayManager_OutByRule9); //$NON-NLS-1$
			break;
		case "10": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule10 : Messages.PlayByPlayManager_OutByRule10); //$NON-NLS-1$
			break;
		case "11": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule11 : Messages.PlayByPlayManager_OutByRule11); //$NON-NLS-1$
			break;
		case "12": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule12 : Messages.PlayByPlayManager_OutByRule12); //$NON-NLS-1$
			break;
		case "13": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule13 : Messages.PlayByPlayManager_OutByRule13); //$NON-NLS-1$
			break;
		case "14": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule14 : Messages.PlayByPlayManager_OutByRule14); //$NON-NLS-1$
			break;
		case "15": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule15 : Messages.PlayByPlayManager_OutByRule15); //$NON-NLS-1$
			break;
		case "16": message = (isMoreAdavance ? Messages.PlayByPlayManager_MoreAdvanceOutByRule16 : Messages.PlayByPlayManager_OutByRule16); //$NON-NLS-1$
			break;
		default:
			break;
		}

		if (isMoreAdavance) {
			putMoreAdavcenMessage(message, new String[] {});
		} else {
			putMessage(message, new String[] {runner.getPlayerDescription().getName()});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerOutOnFielderAction action) {
		int runnerPosition;
		boolean isMoreAdavance = false;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			isMoreAdavance = true;
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		String whoMakeTheOut = getDefensivePosition("" + ScoreGameOutUtil.getOut(action)); //$NON-NLS-1$

		if (isMoreAdavance) {
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerOutOnFielderActionWithoutAssists;
				putMoreAdavcenMessage(message, new String[] {whoMakeTheOut});
				
			} else {
				String message = Messages.PlayByPlayManager_MoreAdvanceRunnerOutOnFielderActionWithAssists;
				String assistances = getAssistanceString(assists);
				putMoreAdavcenMessage(message, new String[] {whoMakeTheOut,assistances});
			}
		} else {
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_RunnerOutOnFielderActionWithoutAssists;
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut});
				
			} else {
				String message = Messages.PlayByPlayManager_RunnerOutOnFielderActionWithAssists;
				String assistances = getAssistanceString(assists);
				putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut,assistances});
			}
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerOutOnPickOff action) {
		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}

		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		String whoMakeTheOut = getDefensivePosition("" + ScoreGameOutUtil.getOut(action)); //$NON-NLS-1$

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_RunnerOutOnPickOffWithoutAssist;
			putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut});
			
		} else {
			String message = Messages.PlayByPlayManager_RunnerOutOnPickOffWithAssist;
			String assistances = getAssistanceString(assists);
			putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut,assistances});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerOutOnCaugthStealing action) {
		int runnerPosition;

		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		
		String whoMakeTheOut = getDefensivePosition("" + ScoreGameOutUtil.getOut(action)); //$NON-NLS-1$
		
		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_RunnerOutOnCaugthStealingWithoutAssists; 
			putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut});
			
		} else {
			String message = Messages.PlayByPlayManager_RunnerOutOnCaugthStealingWithAssists;
			String assistances = getAssistanceString(assists);
			putMessage(message, new String[] {runner.getPlayerDescription().getName(),whoMakeTheOut,assistances});
		}
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerMustBeOutOnError action) {

		int runnerPosition;
		if (action.eContainer() instanceof Action) {
			runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
		} else {
			runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
		}
		LineupEntry runner = runnerPositionManager.getPlayerAtPosition(runnerPosition);

		String message = Messages.PlayByPlayManager_RunnerMustBeOutOnError; 
		
		putMessage(message, new String[] {runner.getPlayerDescription().getName()});
		
		super.makeActionOn(action);
	}

	@Override
	@SuppressWarnings("java:S1185")
	public void makeActionOn(BatterAdvanceOnKAbr action) throws OccupedbaseException {
		// Nothing to do
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterBalk action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterBalk; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterMustOutOnFlyFoulBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String defensivePosition = getDefensivePosition(ScoreGameError.getDefensivePosition(action)); 
		
		String message = Messages.PlayByPlayManager_BatterMustOutOnFlyFoulBall; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), defensivePosition});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterLostTurn action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterLostTurn; 

		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		
		String position = getBaseWin(baseWin);
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		
		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnDefensiveChoiceWithoutAssists; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});
		} else {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnDefensiveChoiceWithAsists; 
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position, assistance});
			
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		String position = getBaseWin(baseWin);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnIndiference; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		String position = getBaseWin(baseWin);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnOccupedBall; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		String position = getBaseWin(baseWin);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnKWithFielderChoice; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String whoMakeObstruction = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		String position = getBaseWin(baseWin);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnObstruction; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeObstruction, position});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String position = getBaseWin(baseWin);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnCatcherInterference; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), position});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		String position = getBaseWin(baseWin);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithFielderChoice; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		
		String whoMakeError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));

		if (baseWin == 4) {
			
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterScoreOnSacrificeFlyWithErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError});
			} else {
				String message = Messages.PlayByPlayManager_BatterScoreOnSacrificeFlyWithErrorWithAssists; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,assistance});
			}
			
		} else {
		
			String position = getBaseWin(baseWin);
	
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position});
			} else {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithErrorWithAssists; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position,assistance});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String whoMakeTheChoice = getDefensivePosition(ScoreGameAdvanceUtil.getDefensivePosition(action));
		String position = getBaseWin(baseWin);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeHitWithFielderChoice; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, position});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoMakeError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));

		if (baseWin == 4) {
			
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterScoreOnSacrificeHitWithErrorWithoutAssist; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError});
			} else {
				String message = Messages.PlayByPlayManager_BatterscoreOnSacrificeHitWithErrorWithAssist; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,assistance});
			}
			
		} else {	
			String position = getBaseWin(baseWin);
			
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeHitWithErrorWithoutAssist; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position});
			} else {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnSacrificeHitWithErrorWithAssist; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position,assistance});
			}
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		
		String whoMakeError = getDefensivePosition(ScoreGameError.getDefensivePosition(action));
		
		if (baseWin == 4) {
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterScoreOnKWithErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError});
				
			} else {
				String message = Messages.PlayByPlayManager_BatterScoreOnKWithErrorWithAssists; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,assistance});
			}
		} else {
			String position = getBaseWin(baseWin);
			
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnKWithErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position});
				
			} else {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnKWithErrorWithAssists; 
				String assistance = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(),whoMakeError,position,assistance});
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		if (baseWin == 4) {
			String message = Messages.PlayByPlayManager_BatterScoreOnKWildPitch; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName()});
			
		} else {
			String position = getBaseWin(baseWin);
			String message = Messages.PlayByPlayManager_BatterAdvanceOnKWildPitch; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), position});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		if (baseWin == 4) {
			String message = Messages.PlayByPlayManager_BatterScoreOnKPassBall; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName()});
			
		} else {
			String position = getBaseWin(baseWin);
			String message = Messages.PlayByPlayManager_BatterAdvanceOnKPassBall; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), position});
		}
		

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnHitByPitch; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnIntentionalBaseOnBall; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnBaseOnBall; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		String message = Messages.PlayByPlayManager_BatterAdvanceOnInsidePark; 
		String hitLocation = getHitLocation(ScoreGameUtil.getHitLocation(action));

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), hitLocation});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnHomeRun; 
		String hitLocation = getHitLocation(ScoreGameUtil.getHitLocation(action));

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), hitLocation});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnTripleHit; 
		String hitLocation = getHitLocation(ScoreGameUtil.getHitLocation(action));

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), hitLocation});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnDoubleHit; 
		String hitLocation = getHitLocation(ScoreGameUtil.getHitLocation(action));

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), hitLocation});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterAdvanceOnSingleHit;
		if (ScoreGameUtil.isBunt(action)) {
			message += " (" + Messages.ScoreSheetEngine_bunt + ")";  //$NON-NLS-1$ //$NON-NLS-2$
		}
		String hitLocation = getHitLocation(ScoreGameUtil.getHitLocation(action));

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), hitLocation});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		String defensivePosition = ScoreGameError.getDefensivePosition(action);

		String whoMakeTheError = getDefensivePosition(defensivePosition);
		String location = getBaseWin(baseWin);
		
		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnGdpWithErrorWithoutAssist; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheError, location});
		} else {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnGdpWithErrorWithAssist; 
			String assistsStr = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheError, location, assistsStr});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String whoMakeTheChoice = getDefensivePosition(ScoreGameUtil.getDefensivePosition(action));
		if (baseWin == 4) {

			String message = Messages.PlayByPlayManager_BatterScoreOnGdpWithFielderChoice; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice});
			
		} else {
			String location = getBaseWin(baseWin);
			
			String message = Messages.PlayByPlayManager_BatterAdvanceOnGdpWithFielderChoice; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeTheChoice, location});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoMaheTheError = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		if (baseWin == 4) {

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterScoreOnThrowErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError});
			} else {
				String message = Messages.PlayByPlayManager_BatterScoreOnThrowErrorWithAssists; 
				String assistsStr = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, assistsStr});
			}		

		} else {
			String location = getBaseWin(baseWin);

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnThrowErrorWithoutAssists; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location});
			} else {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnThrowErrorWithAssists; 
				String assistsStr = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location, assistsStr});
			}		
			
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoMaheTheError = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		if (baseWin == 4) {

			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterScoreOnReceiveErrorWithoutAssist; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError});
				
			} else {
				String message = Messages.PlayByPlayManager_BatterScoreOnReceiveErrorWithAssist; 
				String assistsStr = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, assistsStr});
				
			}
			
		} else {
			String location = getBaseWin(baseWin);
			if (assists.length == 0) {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnReceiveErrorWithoutAssist; 
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location});
				
			} else {
				String message = Messages.PlayByPlayManager_BatterAdvanceOnReceiveErrorWithAssist; 
				String assistsStr = getAssistanceString(assists);
				putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location, assistsStr});
				
			}
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

		String whoMaheTheError = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		if (baseWin == 4) {
			String message = Messages.PlayByPlayManager_BatterScoreOnFlyError; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError});
		} else {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnFlyError; 
			String location = getBaseWin(baseWin);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location});
		}


		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterAdvanceOnPopError action) throws OccupedbaseException {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String defensivePosition = ScoreGameError.getDefensivePosition(action);
		int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
		
		String whoMaheTheError = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$
		
		if (baseWin == 4) {
			String message = Messages.PlayByPlayManager_BatterScoreOnPopError; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError});
		} else {
			String message = Messages.PlayByPlayManager_BatterAdvanceOnPopError; 
			String location = getBaseWin(baseWin);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMaheTheError, location});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnInfieldFly action) {
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String whoPutOut = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		String message = Messages.PlayByPlayManager_BatterOutOnInfieldFly; 

		putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeHit action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		String whoPutOut = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeHitWhitoutAssist; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeHitWhitAssists; 
			String assistsStr = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistsStr});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeFlyFallBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		String whoPutOut = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeFlyFallBallWhitoutAssist; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
			
		} else {
			
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeFlyFallBallWhitAssists; 
			String assistsStr = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistsStr});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeFly action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		String whoPutOut = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$


		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeFlyWithoutAssists; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnSacrificeFlyWithAssists;
			String assistsStr = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistsStr});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnGroundedDoublePlay action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char defensivePosition = ScoreGameOutUtil.getOut(action);

		String whoPutOut = getDefensivePosition("" + defensivePosition); //$NON-NLS-1$
		
		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnGroundedDoublePlayWithoutAssists;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnGroundedDoublePlayWithAssists;
			String assistValues = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistValues});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnAppeal action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char out = ScoreGameOutUtil.getOut(action);
		
		String whoPutOut = getDefensivePosition("" + out); //$NON-NLS-1$
		
		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnAppealWithoutAssists; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnAppealWithAssists;
			String assistsValue = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistsValue});
			
		}
	
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutByRule action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		String obrNumber = ScoreGameUtil.getOBRType(action);

		String message = Messages.PlayByPlayManager_UnkonwOutByRule; 
		
		switch (obrNumber) {
		case "1": message = Messages.PlayByPlayManager_OutByRule1; //$NON-NLS-1$
			break;
		case "2": message = Messages.PlayByPlayManager_OutByRule2; //$NON-NLS-1$
			break;
		case "3": message = Messages.PlayByPlayManager_OutByRule3; //$NON-NLS-1$
			break;
		case "4": message = Messages.PlayByPlayManager_OutByRule4; //$NON-NLS-1$
			break;
		case "5": message = Messages.PlayByPlayManager_OutByRule5; //$NON-NLS-1$
			break;
		case "6": message = Messages.PlayByPlayManager_OutByRule6; //$NON-NLS-1$
			break;
		case "7": message = Messages.PlayByPlayManager_OutByRule7; //$NON-NLS-1$
			break;
		case "8": message = Messages.PlayByPlayManager_OutByRule8; //$NON-NLS-1$
			break;
		default:
			break;
		}

		putMessage(message, new String[] {batter.getPlayerDescription().getName()});
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnGroundedBall action) {

		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char out = ScoreGameOutUtil.getOut(action); 

		String whoPutOut = getDefensivePosition("" + out); //$NON-NLS-1$

		if (assists.length == 0) {

			String message = Messages.PlayByPlayManager_BatterOutOnGroundedBallWithoutAssists; 
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
			
		} else {

			String message = Messages.PlayByPlayManager_BatterOutOnGroundedBallWithAssists; 
			String assistsList = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut, assistsList});
			
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnLineDriveFallBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnLineDriveFallBallWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnLineDriveFallBallWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnPoppedFallBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnPoppedFallBallWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnPoppedFallBallWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnFlyedFallBall action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnFlyedFallBallWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnFlyedFallBallWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnPopped action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnPoppedWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnPoppedWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}
		
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnLine action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnLineWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnLineWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnFlyed action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		char defensivePosition = ScoreGameOutUtil.getOut(action);
		char[] assists = ScoreGameAssistUtil.getAssistances(action);

		String whoPutOut = getDefensiveLocation(defensivePosition);

		if (assists.length == 0) {
			String message = Messages.PlayByPlayManager_BatterOutOnFlyedWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut});
		} else {
			String message = Messages.PlayByPlayManager_BatterOutOnFlyedWithAssist;
			String assistance = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoPutOut,assistance});
		}

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnReleasedStrike action) {
		char[] assists = ScoreGameAssistUtil.getAssistances(action);
		char out = ScoreGameOutUtil.getOut(action); 
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String whoMakeOut = getDefensivePosition("" + out); //$NON-NLS-1$

		if (assists.length == 0) {
			String message= Messages.PlayByPlayManager_BatterOutOnReleasedStrikeWithoutAssist;
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeOut});
		} else {
			String message= Messages.PlayByPlayManager_BatterOutOnReleasedStrikeWithAssist;
			String assistValue = getAssistanceString(assists);
			putMessage(message, new String[] {batter.getPlayerDescription().getName(), whoMakeOut, assistValue});
		}
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnLookedStrike action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);
		
		String message = Messages.PlayByPlayManager_BatterOutOnLookedStrike; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(BatterOutOnSwingedStrike action) {
		LineupEntry batter = runnerPositionManager.getPlayerAtPosition(0);

		String message = Messages.PlayByPlayManager_BatterOutOnSwingedStrike; 
		putMessage(message, new String[] {batter.getPlayerDescription().getName()});

		super.makeActionOn(action);
	}

	@Override
	protected void callCallbackSubstitutionManager(SubstitutionManager substitutionManager) {
		
		StringBuilder strBuilder = new StringBuilder(neededSpace);
		neededSpace = ""; //$NON-NLS-1$
		String mainMessage = Messages.PlayByPlayManager_TeamSubstitution;
		strBuilder.append(NLS.bind(mainMessage, new String[] { getTeamName(substitutionManager.getTeam())}));
		
		List<String> subsText = new ArrayList<>();
		
		for (SubstitutionCommonData substitution : substitutionManager.getSubstitutions() ) {
			
			if (substitution instanceof MoveToData) {
				MoveToData moveToData = (MoveToData)substitution;

				String message = Messages.PlayByPlayManager_TeamMoveToSubstitution; 
				
				String playerName = moveToData.getPlayer().getPlayerDescription().getName();
				String oldPosition = getDefensivePosition(moveToData.getCurrentDefensivePosition());
				String newPosition = getDefensivePosition(moveToData.getDefensivePosition().getNewDefensivePosition());
				
				String textValue = NLS.bind(message, new String[] {playerName, oldPosition, newPosition});
				subsText.add(textValue);
			
			} else {

				ReplacementData replacementData = (ReplacementData) substitution;
				
				
				if (replacementData.getPlayerReplaced()!=null && replacementData.getCurrentDefensivePosition().equals(replacementData.getPlayerReplaced().getDefensivePosition())) {
					String message = Messages.PlayByPlayManager_TeamReplaceSubstitutionPlaceToPlace; 
	
					String oldPlayerName = replacementData.getPlayerReplaced().getPlayerDescription().getName();
					String defensivePosition = getDefensivePosition(replacementData.getCurrentDefensivePosition());
					String newPlayerName = replacementData.getReplacement().getName();
					
					String textValue = NLS.bind(message, new String[] {oldPlayerName, defensivePosition, newPlayerName});
					subsText.add(textValue);
					
				} else {
					String message = Messages.PlayByPlayManager_TeamReplaceSubstitutionNewDefensivePosition;

					String oldPlayerName = replacementData.getPlayer().getPlayerDescription().getName();
					String oldDefensivePosition = getDefensivePosition(replacementData.getCurrentDefensivePosition());
					String newPlayerName = replacementData.getReplacement().getName();
					String newDefensivePosition =  getDefensivePosition(replacementData.getReplacement().getNewDefensivePosition());
					
					String textValue = NLS.bind(message, new String[] {oldPlayerName, oldDefensivePosition, newPlayerName, newDefensivePosition});
					subsText.add(textValue);
				}
				
			}
		}

		for (int i=0; i<subsText.size(); i++) {
			strBuilder.append(subsText.get(i));
			if (i<(subsText.size()-1)) {
				strBuilder.append(", "); //$NON-NLS-1$
			}
		}
		
		strBuilder.append("."); //$NON-NLS-1$
		inningDescription.append(strBuilder);

		neededSpace = " "; //$NON-NLS-1$

		
		super.callCallbackSubstitutionManager(substitutionManager);
	}

	/**
	 * Get team name which is displayed
	 * 
	 * @param team team
	 * @return team name
	 */
	private String getTeamName(String team) {
		if (EngineConstants.HOMETEAM.equals(team)) {
			return Messages.PlayByPlayManager_HomeTeamName;
		} else {
			return Messages.PlayByPlayManager_VisitorName;
		}
	}

	/**
	 * Allow to define a more advance message 
	 * 
	 * @param message message to put
	 * @param parameters list of parameters
	 */
	private void putMoreAdavcenMessage(String message, String[] parameters) {
		String completeString = NLS.bind(message, parameters);
		String currentMessage = actionDescription.poll();
		currentMessage += ", " + completeString; //$NON-NLS-1$
		actionDescription.addFirst(currentMessage);
	}

	/**
	 * Put the action text value in the EMF representation of the game
	 * 
	 * @param message message to put
	 * @param parameters list of parameters
	 */
	private void putMessage(String message, String[] parameters) {
		String completeString = NLS.bind(message, parameters);
		actionDescription.addFirst(completeString);
	}
	
	/**
	 * Get the defensive position text
	 * 
	 * @param defensiveLocation code of the defensive location
	 * @return defensive position text
	 */
	private String getDefensiveLocation(char defensiveLocation) {
		switch (defensiveLocation) {
		case '1' : return Messages.PlayByPlayManager_PitcherDefensiveLocation; 
		case '2' : return Messages.PlayByPlayManager_CatcherDefensiveLocation; 
		case '3' : return Messages.PlayByPlayManager_FirstBaseDefensiveLocation; 
		case '4' : return Messages.PlayByPlayManager_SecondBaseDefensiveLocation; 
		case '5' : return Messages.PlayByPlayManager_ThirdBaseDefensiveLocation; 
		case '6' : return Messages.PlayByPlayManager_ShortStopDefensiveLocation; 
		case '7' : return Messages.PlayByPlayManager_LeftFieldDefensiveLocation; 
		case '8' : return Messages.PlayByPlayManager_CenterFieldDefensiveLocation; 
		case '9' : return Messages.PlayByPlayManager_RightFieldDefensiveLocation; 
		default  : return Messages.PlayByPlayManager_UnknownDefensiveLocation; 
		}
	}
	
	/**
	 * Get defensive position string.
	 * 
	 * @param position defensive position
	 * 
	 * @return defensive position string
	 */
	private String getDefensivePosition(String position) {
		
		if (position.startsWith("ph")) { //$NON-NLS-1$
			position = "ph"; //$NON-NLS-1$
		}
		if (position.startsWith("pr")) { //$NON-NLS-1$
			position = "pr"; //$NON-NLS-1$
		}
		
		switch(position) {
			case "1" : return POSITION_1; //$NON-NLS-1$
			case "2" : return POSITION_2; //$NON-NLS-1$
			case "3" : return POSITION_3; //$NON-NLS-1$
			case "4" : return POSITION_4; //$NON-NLS-1$
			case "5" : return POSITION_5; //$NON-NLS-1$
			case "6" : return POSITION_6; //$NON-NLS-1$
			case "7" : return POSITION_7; //$NON-NLS-1$
			case "8" : return POSITION_8; //$NON-NLS-1$
			case "9" : return POSITION_9; //$NON-NLS-1$
			case "dh" : return POSITION_DH; //$NON-NLS-1$
			case "pr" : return POSITION_PH; //$NON-NLS-1$
			case "ph" : return POSITION_PR; //$NON-NLS-1$
			default: break;
		}
		return "??"; //$NON-NLS-1$
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
		case "1" : return Messages.PlayByPlayManager_PitcherHitLocation;     //$NON-NLS-1$
		case "2" : return Messages.PlayByPlayManager_CatcherHitLocation;     //$NON-NLS-1$ 
		case "3" : return Messages.PlayByPlayManager_FirstHitLocation;       //$NON-NLS-1$ 
		case "4" : return Messages.PlayByPlayManager_SecondHitLocation;      //$NON-NLS-1$
		case "5" : return Messages.PlayByPlayManager_ThirdHitLocation;       //$NON-NLS-1$
		case "6" : return Messages.PlayByPlayManager_ShortStopHitLocation;   //$NON-NLS-1$ 
		case "7" : return Messages.PlayByPlayManager_LeftFieldHitLocation;   //$NON-NLS-1$  
		case "8" : return Messages.PlayByPlayManager_CenterFieldHitLocation; //$NON-NLS-1$
		case "9" : return Messages.PlayByPlayManager_RightHitLocation;       //$NON-NLS-1$
		case "LL" : return Messages.PlayByPlayManager_LLHitLocation;         //$NON-NLS-1$
		case "LS" : return Messages.PlayByPlayManager_LSHitLocation;         //$NON-NLS-1$
		case "LC" : return Messages.PlayByPlayManager_LCHitLocation;         //$NON-NLS-1$
		case "MI" : return Messages.PlayByPlayManager_MIHitLocation;         //$NON-NLS-1$
		case "RC" : return Messages.PlayByPlayManager_RCHitLocation;         //$NON-NLS-1$
		case "RS" : return Messages.PlayByPlayManager_RSHitLocation;         //$NON-NLS-1$
		case "RL" : return Messages.PlayByPlayManager_RLHitLocation;         //$NON-NLS-1$
		default:  return Messages.PlayByPlayManager_UnknownHitLocation;      //$NON-NLS-1$
		}
	}

	/**
	 * get readable names of bases
	 * 
	 * @param position base number
	 * @return readable names of bases
	 */
	private String getBaseWin(int position) {
		switch (position) {
		case 1 : return Messages.PlayByPlayManager_FirstBaseWin;
		case 2 : return Messages.PlayByPlayManager_SecondBaseWin;
		case 3 : return Messages.PlayByPlayManager_ThirdBaseWin;
		case 4 : return Messages.PlayByPlayManager_ForthBaseWin;
		default: break;
		}

		return null;
	}

	/**
	 * Create a string which describe who make the assistance
	 * 
	 * @param assists list a defensive position who assist
	 * @return string which describe who make the assistance
	 */
	private String getAssistanceString(char[] assists) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i=0; i<assists.length; i++) {
			strBuilder.append(getDefensivePosition("" + assists[i])); //$NON-NLS-1$
			if (i<assists.length-1) {
				strBuilder.append(","); //$NON-NLS-1$
			}
		}
		return strBuilder.toString();
	}
}
