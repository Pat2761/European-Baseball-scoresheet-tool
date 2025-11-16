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
package org.bpy.score.game.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bpy.score.club.club.ClubDescription;
import org.bpy.score.club.club.ClubPackage;
import org.bpy.score.club.club.Team;
import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.Actions;
import org.bpy.score.game.game.AdvanceWithContinuation;
import org.bpy.score.game.game.BatterAdvance;
import org.bpy.score.game.game.BatterAdvanceOnHomeRun;
import org.bpy.score.game.game.BatterAdvanceOnKPassBall;
import org.bpy.score.game.game.BatterAdvanceOnKWildPitch;
import org.bpy.score.game.game.BatterOut;
import org.bpy.score.game.game.CurrentBatter;
import org.bpy.score.game.game.CurrentRunner;
import org.bpy.score.game.game.Description;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.GamePackage;
import org.bpy.score.game.game.GameResume;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.game.LineUp;
import org.bpy.score.game.game.LineUpEntry;
import org.bpy.score.game.game.OtherBatterAdvance;
import org.bpy.score.game.game.Player;
import org.bpy.score.game.game.Roster;
import org.bpy.score.game.game.RunnerAction;
import org.bpy.score.game.game.RunnerAdvance;
import org.bpy.score.game.game.RunnerAdvanceByBatterAction;
import org.bpy.score.game.game.RunnerAdvanceOnBalk;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnError;
import org.bpy.score.game.game.RunnerAdvanceOnIndiference;
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
import org.bpy.score.game.game.RunnerOut;
import org.bpy.score.game.util.ScoreGameAdvanceUtil;
import org.bpy.score.game.util.ScoreGameAssistUtil;
import org.bpy.score.game.util.ScoreGameUtil;
import org.bpy.score.internationalization.game.Messages;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class GameValidator extends AbstractGameValidator {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameValidator.class.getSimpleName());
	
	/** Runner constant */
	public static final String RUNNER = "runner"; //$NON-NLS-1$
	
	/** bad description for a player constant (use for quick fix) */
	public static final String BAD_PLAYER_DEFINITION = "badPlayerDefinition"; //$NON-NLS-1$
	/** bad description for a club constant  (use for quick fix) */
	public static final String BAD_CLUB_DEFINITION = "badClubDefinition"; //$NON-NLS-1$
	/** Bad team definition constant  (use for quick fix) */
	public static final String BAD_TEAM_DEFINITION = "badTeamDefinition"; //$NON-NLS-1$
	/** invalid defense position constant  (use for quick fix) */
	public static final String INVALID_DEFENSIVE_POSITION = "invalidDefensivePosition"; //$NON-NLS-1$
	/** invalid advance constant  (use for quick fix) */
	public static final String INVALID_ADVANCE = "invalidAdvance"; //$NON-NLS-1$
	/** Invalid poutout constant  (use for quick fix) */
	public static final String INVALID_PUTOUT = "invalidPutout"; //$NON-NLS-1$
	/** Invalid earned point constant  (use for quick fix) */
	public static final String INVALID_EARNED_POINT = "invalidEarnedPoint"; //$NON-NLS-1$
	/** Invalid player name constant  (use for quick fix) */
	public static final String INVALID_PLAYER_NAME = "invalidPlayerName"; //$NON-NLS-1$
	
	/** Date regular expression */
	public static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");  //$NON-NLS-1$

	/** get reference on the resource description provider */
	@Inject private ResourceDescriptionsProvider resourceDescriptionsProvider;
	/** Get Xtext resource provider */
	@Inject private Provider<XtextResourceSet> resourceSetProvider;

	/** Field simulator reference */
	private FieldSimulator fieldSimulator;
	/** Put out counter */
	private int putoutCounter;

	/**
	 * Check that no assistance can be set on a non decisive error
	 * 
	 * @param runnerAdvance code of the advance
	 */
	@Check
	public void noAssistancesOnNoDecisiveError(RunnerAdvance runnerAdvance) {
		
		boolean errorFound = false;
		
		if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			char[] assists = ScoreGameAssistUtil.getAssistances((RunnerAdvanceOnNonDecisiveReceiveError)runnerAdvance);
			if (assists.length>0) {
				errorFound = true;
			}
		
		} else if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			char[] assists = ScoreGameAssistUtil.getAssistances((RunnerAdvanceOnNonDecisiveThrowError)runnerAdvance);
			if (assists.length>0) {
				errorFound = true;
			}
		}
		
		if (errorFound) {
			error(Messages.GameValidator_noAssistanceOnNonDecisiveError,
				GamePackage.Literals.RUNNER_ADVANCE__RUNNER_ADVANCE
			);
		}
	}

	/**
	 * Validate date format 
	 * 
	 * @param description reference on the game description object
	 */
	@Check 
	public void validateDateFormat(Description description) {
		Matcher matcher = DATE_PATTERN.matcher(description.getDate());
		if (!matcher.matches()) {
			error(NLS.bind(Messages.GameValidator_badDateFormat, description.getDate()),
				GamePackage.Literals.DESCRIPTION__DATE
			);
		}
	}

	/**
	 * Check that the resume part of the exist
	 * 
	 * @param game Reference on the game object
	 */
	@Check 
	public void validateGameResumeExistence(Game game) {
		
		Actions actions = game.getActions();
		
		if (actions.getGameResume() == null) {
			error(Messages.GameValidator_missingWinLoseSaveDescription,
				GamePackage.Literals.GAME__NAME
			);
		}
	}

	/**
	 * Check that pitcher defines in the game resume are valid
	 * 
	 * @param gameResume reference on the game resume object
	 */
	@Check
	public void validatePitcherState(GameResume gameResume) {
		if (gameResume != null) {
			Game game = ScoreGameUtil.getGame(gameResume); 
			List<String> possiblePlayers = getPossiblePlayers(game, "hometeam"); //$NON-NLS-1$
			possiblePlayers.addAll(getPossiblePlayers(game, "visitor")); //$NON-NLS-1$
			
			if ( (gameResume.getWin() != null) && (!possiblePlayers.contains(gameResume.getWin()))) {
					error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster, gameResume.getWin()),
						GamePackage.Literals.GAME_RESUME__WIN);
			}
			if ( (gameResume.getLose() != null) && (!possiblePlayers.contains(gameResume.getLose()))) {
					error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster,gameResume.getLose()),
						GamePackage.Literals.GAME_RESUME__WIN);
			}
			if ( (gameResume.getSave() != null) && (!possiblePlayers.contains(gameResume.getSave()))) {
					error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster,gameResume.getSave()),
						GamePackage.Literals.GAME_RESUME__WIN);
			}
		}	
	}

	/**
	 * Validate the runner name. Runner name must be defined in the roster
	 * 
	 * @param currentRunner reference on the current runner object
	 */
	@Check
	public void validateRunnerName(CurrentRunner currentRunner) {
		if (currentRunner.getName() != null) {
			Game game = ScoreGameUtil.getGame(currentRunner);
			HalfInning inning = (HalfInning) currentRunner.eContainer().eContainer().eContainer(); 
		
			List<String> possiblePlayers = getPossiblePlayers(game, inning.getTeam());
			if (!possiblePlayers.contains(currentRunner.getName())) {
				error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster,currentRunner.getName()),
					GamePackage.Literals.CURRENT_RUNNER__NAME, INVALID_PLAYER_NAME);
			}
			
		}
	}

	/** 
	 * Check that batter name is defined in the roster of the team
	 * 
	 * @param currentBatter reference on the current batter object
	 */
	 @Check
	 public void validateBatterName(CurrentBatter currentBatter) {
		if (currentBatter.getName() != null) {
			Game game = ScoreGameUtil.getGame(currentBatter);
			HalfInning inning = (HalfInning) currentBatter.eContainer().eContainer().eContainer();  
		
			List<String> possiblePlayers = getPossiblePlayers(game, inning.getTeam());
			if (!possiblePlayers.contains(currentBatter.getName())) {
				error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster,currentBatter.getName()),
					GamePackage.Literals.CURRENT_BATTER__NAME, INVALID_PLAYER_NAME);
			}
		}
	 }
	
	/**
	 * Extract all players names defined in a roster of a team
	 *  
	 * @param game Reference on the game 
	 * @param teamName team name
	 * @return List of name
	 */
	private List<String> getPossiblePlayers(Game game, String teamName) {
		Roster roster = game.getHometeam();
		if ("visitor".equals(teamName)) { //$NON-NLS-1$
			roster = game.getVisitor();
		}
		
		ArrayList<String> players = new ArrayList<>();
		for (Player member : roster.getPlayers()) {
			players.add(member.getPlayerName());
		} 
		return players;
	}
	 
	/**
	 * Check that Homerun location can't be defined as MI, LS or RS (it is  grounded ball=)
	 * 
	 * @param advanceOnHomerun reference on the home run object
	 */
	@Check 
	public void homerunValidation(BatterAdvanceOnHomeRun advanceOnHomerun) {
		String actionCode = advanceOnHomerun.getHit().replaceFirst("HR",""); //$NON-NLS-1$ //$NON-NLS-2$
		if ("LS".equals(actionCode) || "MI".equals(actionCode) || "RS".equals(actionCode)) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			error(NLS.bind(Messages.GameValidator_pitcherNotDefinedInRoster,actionCode),
				GamePackage.Literals.BATTER_ADVANCE_ON_HOME_RUN__IS_EARNED, INVALID_ADVANCE);
		} 
	}

	/**
	 * Initialize the field manager and the number of put outs
	 * It is used by the other check for initialize some variables
	 * 
	 * @param halfInning reference on the Half inning
	 */
	@Check
	public void fieldManager(HalfInning halfInning) {
		fieldSimulator = new FieldSimulator();
		putoutCounter = 0;
	}

	/**
	 * Check cast consistency on pass ball action.
	 * 
	 * @param action reference on the Pass ball action
	 */
	@Check
	public void passBallCoherency(Action action) {
		advanceCoherency(action, BatterAdvanceOnKPassBall.class, RunnerAdvanceOnPassBall.class, "pb"); //$NON-NLS-1$
	}

	/**
	 * Check cast consistency on Wild pitch action.
	 * 
	 * @param action reference on Wild pitch action
	 */
	@Check
	public void wildPitchCoherency(Action action) {
		advanceCoherency(action, BatterAdvanceOnKWildPitch.class, RunnerAdvanceOnWildPitch.class, "wp"); //$NON-NLS-1$
	}

	/**
	 * Check cast consistency on balk pitch action.
	 * 
	 * @param action reference on balk pitch action
	 */
	@Check
	public void balkCoherency(Action action) {
		advanceCoherency(action, BatterAdvanceOnKWildPitch.class, RunnerAdvanceOnWildPitch.class, "bk"); //$NON-NLS-1$
	}

	/**
	 * Check consistency on cast code for Balk, Wild pitch or Pass ball.
	 * 
	 * @param action reference on the action
	 * @param batterAdvance Type of object for the batter
	 * @param runnerAdvance Type of object for the runner
	 * @param code code of object (bk,wp,pb)
	 */
	@SuppressWarnings({"java:S1481","java:S127"})
	private void advanceCoherency(Action action, Class<?> batterAdvance, Class<?> runnerAdvance, String code) {

		ArrayList<String> advances = new ArrayList<>();

		if ((action.getBatterAction() != null) && batterAdvance.isInstance(action.getBatterAction())) {
			OtherBatterAdvance advance = (OtherBatterAdvance) action.getBatterAction();
			if (advance.getBatterAdvance().toLowerCase().contains(code.toLowerCase())) {
				advances.add(advance.getBatterAdvance());
			}

			for (AdvanceWithContinuation moreAdvance : advance.getMoreAdvances()) {
				if (((RunnerAdvance)moreAdvance).getRunnerAdvance().toLowerCase().startsWith(code.toLowerCase())) {
					advances.add(((RunnerAdvance)moreAdvance).getRunnerAdvance());
				}
			}
		}
		for (int bcl = 0; bcl < action.getRunnerActions().size(); bcl++) {
			RunnerAction runnerAction = action.getRunnerActions().get(bcl);
			if (runnerAction instanceof RunnerAdvance) {

				RunnerAdvance advance = (RunnerAdvance) runnerAction;
				if (runnerAdvance.isInstance(advance) && (advance.getRunnerAdvance().toLowerCase().startsWith(code.toLowerCase())) ) {
						advances.add(advance.getRunnerAdvance());
				}

				for (@SuppressWarnings("unused") AdvanceWithContinuation moreAdvance : advance.getMoreAdvances()) {
					if (runnerAdvance.isInstance(advance) && (!advance.getRunnerAdvance().toLowerCase().startsWith(code.toLowerCase()))) {
							advances.add(advance.getRunnerAdvance());
					}
				}
			}
		}

		if (!advances.isEmpty()) {

			if (advances.size() == 1) {
				if (advances.get(0).contains(code.toLowerCase())) {
					error(NLS.bind(Messages.GameValidator_upperCaseCodeForRunnerAdvanceNeeded,code.toUpperCase()),
						GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
				}

			} else {
				if (advances.get(0).startsWith("K")) { //$NON-NLS-1$
					if (!advances.get(0).contains(code.toUpperCase())) {
						error(NLS.bind(Messages.GameValidator_upperCaseCodeForBatterAdvanceNeeded,code.toUpperCase()),
							GamePackage.Literals.ACTION__BATTER_ACTION, INVALID_ADVANCE);
					}
					for (int i = 1; i < advances.size(); i++) {
						if (advances.get(i).contains(code.toUpperCase())) {
							error(NLS.bind(Messages.GameValidator_lowerCaseCodeForRunnerAdvanceNeeded,code.toLowerCase()),
								GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
							i = advances.size();
						}
					}

				} else {
					for (int i = 0; i < advances.size(); i++) {

						if (i < advances.size() - 1) {
							if (advances.get(i).contains(code.toUpperCase())) {
								error(NLS.bind(Messages.GameValidator_lowerCaseCodeForRunnerAdvanceNeeded,code.toLowerCase()), 
										GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
								i = advances.size();
							}
						} else {
							if (advances.get(i).contains(code.toLowerCase())) {
								error(NLS.bind(Messages.GameValidator_upperCaseCodeForRunnerAdvanceNeeded,code.toUpperCase()), 
										GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Update the infield simulator with an action
	 * 
	 * @param action reference on the action
	 */
	@Check
	public void fieldManager(Action action) {

		for (int bcl = action.getRunnerActions().size() - 1; bcl >= 0; bcl--) {

			RunnerAction runnerAction = action.getRunnerActions().get(bcl);

			if (runnerAction instanceof RunnerAdvance) {

				RunnerAdvance runnerAdvance = (RunnerAdvance) runnerAction;
				int advance = ScoreGameAdvanceUtil.getBaseWin(runnerAdvance);
				int position = getRunnerPosition(runnerAdvance);

				if (!fieldSimulator.moveTo(position, position + advance)) {
					error(NLS.bind(Messages.GameValidator_noAdvancePossibleOccupedBase,(position + advance)), 
						GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
				}

				for (AdvanceWithContinuation moreAdvance : runnerAdvance.getMoreAdvances()) {
					position = position + advance;
					advance = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
					if (!fieldSimulator.moveTo(position, position + advance)) {
						error(NLS.bind(Messages.GameValidator_noAdvancePossibleOccupedBase,(position + advance)),
							GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
					}
				}

				if (runnerAdvance.getRunnerOut() != null) {
					position = position + advance;
					fieldSimulator.out(position);
					putoutCounter += 1;
					if (putoutCounter > 3) {
						error(Messages.GameValidator_tooManyPutOut, GamePackage.Literals.ACTION__RUNNER_ACTIONS,
							INVALID_PUTOUT);
					}
				}

			} else if (runnerAction instanceof RunnerOut) {
				int position = getRunnerPosition((RunnerOut)runnerAction);
				fieldSimulator.out(position);
				putoutCounter += 1;
				if (putoutCounter > 3) {
					error(Messages.GameValidator_tooManyPutOut, GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_PUTOUT);
				}
			}
		}

		if (action.getBatterAction() != null) {
			if (action.getBatterAction() instanceof BatterAdvance) {
				BatterAdvance batterAdvance = (BatterAdvance) action.getBatterAction() ;
				int advance = ScoreGameAdvanceUtil.getBaseWin(batterAdvance); 
				int position = 0;
				if (!fieldSimulator.moveTo(advance)) {
					error(NLS.bind(Messages.GameValidator_noAdvancePossibleOccupedBase,advance),
						GamePackage.Literals.ACTION__BATTER_ACTION, INVALID_ADVANCE);
				}

				for (AdvanceWithContinuation moreAdvance : batterAdvance.getMoreAdvances()) {
					position = position + advance;
					advance = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);
					if (!fieldSimulator.moveTo(position, position + advance)) {
						error(NLS.bind(Messages.GameValidator_noAdvancePossibleOccupedBase,(position + advance)),
							GamePackage.Literals.ACTION__RUNNER_ACTIONS, INVALID_ADVANCE);
					}
				}

				if (batterAdvance.getOut() != null) {
					position = position + advance;
					fieldSimulator.out(position);
					putoutCounter += 1;
					if (putoutCounter > 3) {
						error(Messages.GameValidator_tooManyPutOut, GamePackage.Literals.ACTION__RUNNER_ACTIONS,
							INVALID_PUTOUT);
					}
				}
			} else if (action.getBatterAction() instanceof BatterOut) {
				putoutCounter += 1;
				if (putoutCounter > 3) {
					error(Messages.GameValidator_tooManyPutOut, GamePackage.Literals.ACTION__BATTER_ACTION, INVALID_PUTOUT);
				}
			}
		}
	}

	/**
	 * Not used
	 * 
	 * @param halfInning reference on a Half inning
	 */
	@Check
	public void checkNumberOfOut(HalfInning halfInning) {
		// Nothing to do here
	}

	
	/**
	 * Check the code of the runner advance.
	 * 
	 * @param runnerAdvance Code of the runner advance 
	 */
	@Check
	public void checkRunnerAdvanceValidity(RunnerAdvance runnerAdvance) {
		if (runnerAdvance instanceof RunnerAdvanceByBatterAction) {
			checkRunnerAdvance(runnerAdvance, ((RunnerAdvanceByBatterAction)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnError) {
			checkRunnerAdvance(runnerAdvance, ((RunnerAdvanceOnError)runnerAdvance).getIsEarned(), ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnStolenBase) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnStolenBase)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnWildPitch) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnWildPitch)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnPassBall) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnPassBall)runnerAdvance).getIsEarned(), ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnBalk) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnBalk)runnerAdvance).getIsEarned(), ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnPickOffWithError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnPickOffWithError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnCaughtStealingWithError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnCaughtStealingWithError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnOccupedBall) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnOccupedBall)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnThrow) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnThrow)runnerAdvance).getIsEarned(), ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnIndiference) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnIndiference)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnThrowError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnThrowError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnReceiveError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnReceiveError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnNonDecisiveThrowError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnNonDecisiveReceiveError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnRule) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnRule)runnerAdvance).getIsEarned(), ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnOtherPlayerError) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnOtherPlayerError)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
		if (runnerAdvance instanceof RunnerAdvanceOnDecisiveObstruction) {
			checkRunnerAdvance(runnerAdvance,((RunnerAdvanceOnDecisiveObstruction)runnerAdvance).getIsEarned(),
					ScoreGameAdvanceUtil.getBaseWin(runnerAdvance));
		}
	}

	/**
	 * Check the code of the runner advance.
	 * 
	 * @param runnerAdvance Code of the runner advance 
	 * @param isEarned Flag for earned points
	 * @param advance Number of base win
	 */
	private void checkRunnerAdvance(RunnerAdvance runnerAdvance, String isEarned, int advance) {
		boolean isIsEarned = isEarned != null;
		String runnerPosition = runnerAdvance.getRunner().getRunner().replace(RUNNER, ""); //$NON-NLS-1$
		try {
			int position = Integer.parseInt(runnerPosition);

			if ((position + advance) > 4) {
				error(NLS.bind(Messages.GameValidator_positionAfterTheMarble, (position + advance)),
					GamePackage.Literals.RUNNER_ADVANCE__RUNNER_ADVANCE, INVALID_ADVANCE);
			}

			if (isIsEarned && (position + advance) != 4) {
				error(Messages.GameValidator_noEarnedPointForPosition,
					GamePackage.Literals.RUNNER_ADVANCE__IS_EARNED, INVALID_EARNED_POINT);
			}

		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

	/**
	 *  Get the runner number who advance
	 * 
	 * @param runnerAdvance Action of the runner advance
	 * @return runner number, <b>0</b> if not found
	 */
	private int getRunnerPosition(RunnerAdvance runnerAdvance) {
		String runnerPosition = runnerAdvance.getRunner().getRunner().replace(RUNNER, ""); //$NON-NLS-1$
		try {
			return Integer.parseInt(runnerPosition);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	/**
	 * Get the runner number who is put out
	 * 
	 * @param runnerOut Action of the runner out
	 * 
	 * @return runner number, <b>0</b> if not found
	 */
	private int getRunnerPosition(RunnerOut runnerOut) {
		String runnerPosition = runnerOut.getRunner().getRunner().replace(RUNNER, ""); //$NON-NLS-1$
		try {
			return Integer.parseInt(runnerPosition);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	/**
	 * Check that all defensive position are correctly set in a starting lineup. 
	 * 
	 * @param lineup Reference on the lineup
	 */
	@Check
	public void checkDefensivePositionConsistence(LineUp lineup) {
		Map<String,Integer> defensivePositions = new HashMap<>(); 
		defensivePositions.put("1", 0); //$NON-NLS-1$
		defensivePositions.put("2", 0); //$NON-NLS-1$
		defensivePositions.put("3", 0); //$NON-NLS-1$
		defensivePositions.put("4", 0); //$NON-NLS-1$
		defensivePositions.put("5", 0); //$NON-NLS-1$
		defensivePositions.put("6", 0); //$NON-NLS-1$
		defensivePositions.put("7", 0); //$NON-NLS-1$
		defensivePositions.put("8", 0); //$NON-NLS-1$
		defensivePositions.put("9", 0); //$NON-NLS-1$

		for (LineUpEntry lineupEntry : lineup.getLineUpEntries()) {
			try {
				int defensivePosition = Integer.parseInt(lineupEntry.getDefensivePosition());
				if ((defensivePosition < 0) || (defensivePosition > 9)) {
					// All is good
				} else {
					defensivePositions.put(lineupEntry.getDefensivePosition(),
						defensivePositions.get(lineupEntry.getDefensivePosition()) + 1);
				}
			} catch (NumberFormatException ex) {
				logger.log(Level.SEVERE,ex.getMessage());
			}
		}

		boolean errorFound = false;
		StringBuilder strBuilder = new StringBuilder();
		for (Entry<String, Integer> entry : defensivePositions.entrySet()) {
			if (entry.getValue() != 1) {
				errorFound = true;
				if(!"".equals(strBuilder.toString())) strBuilder.append(','); //$NON-NLS-1$
				strBuilder.append(entry.getKey());
			}
		}
		if (errorFound) {
			error(NLS.bind(Messages.GameValidator_missingDefensivePositions, strBuilder.toString()), GamePackage.Literals.LINE_UP__TEAM_TYPE,
				INVALID_DEFENSIVE_POSITION);
		}

	}

	/**
	 * Check that all defensive position are correctly set in a starting lineup. 
	 * 
	 * @param lineupEntry Reference on the starting lineup
	 */
	@Check
	public void checkDefensivePositionConsistence(LineUpEntry lineupEntry) {
		LineUp lineup = (LineUp) lineupEntry.eContainer();
		Map<String,Integer> defensivePositions = new HashMap<>(); 
		defensivePositions.put("1", 0); //$NON-NLS-1$
		defensivePositions.put("2", 0); //$NON-NLS-1$
		defensivePositions.put("3", 0); //$NON-NLS-1$
		defensivePositions.put("4", 0); //$NON-NLS-1$
		defensivePositions.put("5", 0); //$NON-NLS-1$
		defensivePositions.put("6", 0); //$NON-NLS-1$
		defensivePositions.put("7", 0); //$NON-NLS-1$
		defensivePositions.put("8", 0); //$NON-NLS-1$
		defensivePositions.put("9", 0); //$NON-NLS-1$

		try {

			int defensivePosition = Integer.parseInt(lineupEntry.getDefensivePosition());
			if ((defensivePosition < 0) || (defensivePosition > 9)) {
				error(NLS.bind(Messages.GameValidator_badDefensivePositions, defensivePosition),
					GamePackage.Literals.LINE_UP_ENTRY__DEFENSIVE_POSITION, INVALID_DEFENSIVE_POSITION);
			} else {

				for (LineUpEntry linupEntryChecked : lineup.getLineUpEntries()) {
					defensivePositions.put(linupEntryChecked.getDefensivePosition(),
						defensivePositions.get(linupEntryChecked.getDefensivePosition()) + 1);
				}

				if (defensivePositions.get(lineupEntry.getDefensivePosition()) > 1) {
					error(NLS.bind(Messages.GameValidator_multiplePlayerInSameDefensivePositions, defensivePosition),
						GamePackage.Literals.LINE_UP_ENTRY__DEFENSIVE_POSITION, INVALID_DEFENSIVE_POSITION);
				}
			}
		} catch (NumberFormatException ex) {
			if (!"dh".equals(lineupEntry.getDefensivePosition())  && !lineupEntry.getDefensivePosition().startsWith("pr") && //$NON-NLS-1$ //$NON-NLS-2$
				lineupEntry.getDefensivePosition().startsWith("ph") && !"dp".equals(lineupEntry.getDefensivePosition())) { //$NON-NLS-1$ //$NON-NLS-2$
				error(NLS.bind(Messages.GameValidator_unknowCodeForDefensivePositions, lineupEntry.getDefensivePosition()),
					GamePackage.Literals.LINE_UP_ENTRY__DEFENSIVE_POSITION, INVALID_DEFENSIVE_POSITION);

			}
		}
	}

	/**
	 * Check the roster content.
	 * <ul>
	 * <li>Check that the name is defined in the club description</li>
	 * <li>That team exist in the club</li>
	 * </ul>
	 * 
	 * @param roster reference to the roster
	 */
	@Check
	public void checkRosterContent(Roster roster) {
		Game game = (Game) roster.eContainer();

		ClubDescription clubDescription = getClubDescription(roster.getName());
		if (clubDescription == null) {
			error(NLS.bind(Messages.GameValidator_clubDoesNotExist, roster.getName()), GamePackage.Literals.ROSTER__NAME, BAD_CLUB_DEFINITION);
		} else {
			Team teamDescription = getTeamDescription(game.getDescription().getTournament(), clubDescription);
			if (teamDescription == null) {
				error(NLS.bind(Messages.GameValidator_teamDoesNotExist, new String[] {game.getDescription().getTournament(),roster.getName()}),
					GamePackage.Literals.ROSTER__NAME, BAD_TEAM_DEFINITION);

			}
		}
	}

	/**
	 * Check the roster content.
	 * All names must start with a Capital letter
	 * 
	 * @param player Reference to the player in the roster.
	 */
	@Check
	public void checkRosterContent(Player player) {

		Roster roster = (Roster) player.eContainer();
		Game game = (Game) roster.eContainer();
		String championat = game.getDescription().getTournament();
		String city = roster.getName();
		List<String> possiblePeoples = getListOfPeople(city,championat);
		if (possiblePeoples.isEmpty()) {
			error(Messages.GameValidator_nameSoouldStartWithCaptial, GamePackage.Literals.PLAYER__PLAYER_NAME, BAD_PLAYER_DEFINITION);
		} else if (!possiblePeoples.contains(player.getPlayerName())) {
			error(Messages.GameValidator_nameSoouldStartWithCaptial, GamePackage.Literals.PLAYER__PLAYER_NAME, BAD_PLAYER_DEFINITION);
		} else {
			// All is well
		}
	}

	/**
	 * Return a team object for a category in a club.
	 * 
	 * @param teamName name of the team
	 * @param clubDescription Description object of the club
	 * @return A team object, <b>null</b> if not found
	 */
	private Team getTeamDescription(String teamName, ClubDescription clubDescription) {
		for (Team team : clubDescription.getTeams()) {
			if (teamName.equals(team.getName())) {
				return team;
			}
		}
		return null;
	}

	/**
	 * Return the description object of a team.
	 * 
	 * @param teamName Name of the team
	 * @return Description object of the team, <b>null</b> if not found
	 */
	private ClubDescription getClubDescription(String teamName) {
		IResourceDescriptions index = resourceDescriptionsProvider.createResourceDescriptions();
		XtextResourceSet resourceSet = resourceSetProvider.get();

		for (IEObjectDescription exportedObject : index.getExportedObjectsByType(ClubPackage.Literals.CLUB_DESCRIPTION)) {
			ClubDescription clubDescription = (ClubDescription) EcoreUtil.resolve(exportedObject.getEObjectOrProxy(), resourceSet);
			if (teamName.equals(clubDescription.getName())) {
				return clubDescription;
			}
		}
		return null;
	}

	/**
	 * Return the list of player in a cateogory for a team.
	 * 
	 * @param teamName Name of the team
	 * @param championat Name of the category
	 * @return List of player names
	 */
	private List<String> getListOfPeople(String teamName, String championat) {

		List<String> players = new ArrayList<>();
		IResourceDescriptions index = resourceDescriptionsProvider.createResourceDescriptions();
		XtextResourceSet resourceSet = resourceSetProvider.get();

		for (IEObjectDescription exportedObject : index.getExportedObjectsByType(ClubPackage.Literals.CLUB_DESCRIPTION)) {
			ClubDescription clubDescription = (ClubDescription) EcoreUtil.resolve(exportedObject.getEObjectOrProxy(), resourceSet); 
			if (teamName.equals(clubDescription.getName())) {
				for (Team team : clubDescription.getTeams()) {
					if (championat.equals(team.getName())) {
						for (org.bpy.score.club.club.Player player : team.getPlayers()) {
							players.add(player.getPlayerName().getName());
						}
					}
				}
			}
		}
		return players;
	}
}
