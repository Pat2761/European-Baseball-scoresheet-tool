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
package org.bpy.score.game.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bpy.score.game.game.AdvanceWithContinuation;
import org.bpy.score.game.game.BatterAdvance;
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
import org.bpy.score.game.game.RunnerAdvance;
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
import org.bpy.score.game.game.RunnerMustBeOutOnError;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.game.RunnerOutOnAppeal;
import org.bpy.score.game.game.RunnerOutOnCaugthStealing;
import org.bpy.score.game.game.RunnerOutOnFielderAction;
import org.bpy.score.game.game.RunnerOutOnPickOff;
import org.bpy.score.internationalization.game.Messages;

/**
 * This class supply functionalities for compute the advance on base in
 * function of the action
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameAdvanceUtil {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreGameAdvanceUtil.class.getSimpleName());

	/** Pattern for getting the number of more advance ( extract all + in the string) */
	public static final Pattern pattern = Pattern.compile("([\\+]*)$"); //$NON-NLS-1$
	
	/** Constant for 0 base win */
	public static final int NO_BASE_WIN = 0;
	
	/** Constant for 1 base win */
	public static final int ONE_BASE_WIN = 1;

	/**
	 * Private constructor for hiding missing public constructor.
	 */
	private ScoreGameAdvanceUtil() {
		throw new IllegalStateException("Utility class");//$NON-NLS-1$
	}
	
	/**
	 * Compute the base win by a runner in case of more advance.
	 * 
	 * @param advance advance code in case of more advance
	 * 
	 * @return number of base win
	 */
	public static int getBaseWin(AdvanceWithContinuation advance) {
		if (advance instanceof RunnerAdvanceOnNonDecisiveFlyError) {
			return getBaseWin((RunnerAdvanceOnNonDecisiveFlyError) advance);

		} else if (advance instanceof RunnerAdvanceOnError) {
			return getBaseWin((RunnerAdvanceOnError) advance);

		} else if (advance instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			return getBaseWin((RunnerAdvanceOnNonDecisiveThrowError) advance);

		} else if (advance instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			return getBaseWin((RunnerAdvanceOnNonDecisiveReceiveError) advance);

		} else if (advance instanceof RunnerAdvanceOnOccupedBall) {
			return getBaseWin((RunnerAdvanceOnOccupedBall) advance);

		} else if (advance instanceof RunnerAdvanceOnDefensiveChoice) {
			return getBaseWin((RunnerAdvanceOnDefensiveChoice) advance);

		} else if (advance instanceof RunnerAdvanceOnThrowError) {
			return getBaseWin((RunnerAdvanceOnThrowError) advance);

		} else if (advance instanceof RunnerAdvanceOnReceiveError) {
			return getBaseWin((RunnerAdvanceOnReceiveError) advance);

		} else if (advance instanceof RunnerAdvanceOnThrow) {
			return getBaseWin((RunnerAdvanceOnThrow) advance);

		} else if (advance instanceof RunnerAdvanceOnNoDecisiveObstruction) {
			return getBaseWin((RunnerAdvanceOnNoDecisiveObstruction) advance);

		} else if (advance instanceof RunnerAdvanceOnDecisiveObstruction) {
			return getBaseWin((RunnerAdvanceOnDecisiveObstruction) advance);

		} else if (advance instanceof RunnerAdvanceOnRule) {
			return getBaseWin((RunnerAdvanceOnRule) advance);

		} else if (advance instanceof RunnerAdvanceOnIndiference) {
			return getBaseWin((RunnerAdvanceOnIndiference) advance);

		} else if (advance instanceof RunnerAdvanceOnWildPitch) {
			return getBaseWin((RunnerAdvanceOnWildPitch) advance);

		} else if (advance instanceof RunnerAdvanceOnPassBall) {
			return getBaseWin((RunnerAdvanceOnPassBall) advance);

		} else if (advance instanceof RunnerAdvanceOnStolenBase) {
			return getBaseWin((RunnerAdvanceOnStolenBase) advance);

		} else {
			logger.log(Level.SEVERE, Messages.ScoreGameAdvanceUtil_AdvanceWithContinuation,  advance.getClass().getSimpleName());
			return 0;
		}
	}

	/**
	 * Compute the base win by a runner in case of runner advance.
	 * 
	 * @param runnerAdvance advance code in case of runner advance
	 * 
	 * @return number of base win
	 */
	public static int getBaseWin(RunnerAdvance runnerAdvance) {

		if (runnerAdvance instanceof RunnerAdvanceByBatterAction) {
			return getBaseWin((RunnerAdvanceByBatterAction) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnError) {
			return getBaseWin((RunnerAdvanceOnError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnStolenBase) {
			return getBaseWin((RunnerAdvanceOnStolenBase) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnWildPitch) {
			return getBaseWin((RunnerAdvanceOnWildPitch) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnPassBall) {
			return getBaseWin((RunnerAdvanceOnPassBall) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnBalk) {
			return getBaseWin((RunnerAdvanceOnBalk) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnPickOffWithError) {
			return getBaseWin((RunnerAdvanceOnPickOffWithError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnCaughtStealingWithError) {
			return getBaseWin((RunnerAdvanceOnCaughtStealingWithError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnOccupedBall) {
			return getBaseWin((RunnerAdvanceOnOccupedBall) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnThrow) {
			return getBaseWin((RunnerAdvanceOnThrow) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnIndiference) {
			return getBaseWin((RunnerAdvanceOnIndiference) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnThrowError) {
			return getBaseWin((RunnerAdvanceOnThrowError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnReceiveError) {
			return getBaseWin((RunnerAdvanceOnReceiveError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveThrowError) {
			return getBaseWin((RunnerAdvanceOnNonDecisiveThrowError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnNonDecisiveReceiveError) {
			return getBaseWin((RunnerAdvanceOnNonDecisiveReceiveError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnRule) {
			return getBaseWin((RunnerAdvanceOnRule) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnOtherPlayerError) {
			return getBaseWin((RunnerAdvanceOnOtherPlayerError) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnFielderChoice) {
			return getBaseWin((RunnerAdvanceOnFielderChoice) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnDecisiveObstruction) {
			return getBaseWin((RunnerAdvanceOnDecisiveObstruction) runnerAdvance);

		} else if (runnerAdvance instanceof RunnerAdvanceOnNoDecisiveObstruction) {
			return getBaseWin((RunnerAdvanceOnNoDecisiveObstruction) runnerAdvance);

		} else {
			logger.log(Level.SEVERE, Messages.ScoreGameAdvanceUtil_RunnerAdvance, runnerAdvance.getClass().getSimpleName());
			return 0;
		}
	}

	/**
	 * Compute the base win by a runner in case of batter advance.
	 * 
	 * @param advance advance code in case of batter advance
	 * 
	 * @return number of base win
	 */
	public static int getBaseWin(BatterAdvance advance) {
		if (advance instanceof BatterAdvanceOnDefensiveChoice) {
			return getBaseWin((BatterAdvanceOnDefensiveChoice) advance);

		} else if (advance instanceof BatterAdvanceOnIndiference) {
			return getBaseWin((BatterAdvanceOnIndiference) advance);

		} else if (advance instanceof BatterAdvanceOnDoubleHit) {
			return getBaseWin((BatterAdvanceOnDoubleHit) advance);

		} else if (advance instanceof BatterAdvanceOnFlyError) {
			return getBaseWin((BatterAdvanceOnFlyError) advance);

		} else if (advance instanceof BatterAdvanceOnPopError) {
			return getBaseWin((BatterAdvanceOnPopError) advance);
			
		} else if (advance instanceof BatterAdvanceOnGdpWithError) {
			return getBaseWin((BatterAdvanceOnGdpWithError) advance);

		} else if (advance instanceof BatterAdvanceOnOccupedBall) {
			return getBaseWin((BatterAdvanceOnOccupedBall) advance);

		} else if (advance instanceof BatterAdvanceOnReceiveError) {
			return getBaseWin((BatterAdvanceOnReceiveError) advance);

		} else if (advance instanceof BatterAdvanceOnSingleHit) {
			return getBaseWin((BatterAdvanceOnSingleHit) advance);

		} else if (advance instanceof BatterAdvanceOnThrowError) {
			return getBaseWin((BatterAdvanceOnThrowError) advance);

		} else if (advance instanceof BatterAdvanceOnTripleHit) {
			return getBaseWin((BatterAdvanceOnTripleHit) advance);

		} else if (advance instanceof BatterAdvanceOnHomeRun) {
			return getBaseWin((BatterAdvanceOnHomeRun) advance);

		} else if (advance instanceof BatterAdvanceOnInsidePark) {
			return getBaseWin((BatterAdvanceOnInsidePark) advance);

		} else if (advance instanceof BatterAdvanceOnBaseOnBall) {
			return getBaseWin((BatterAdvanceOnBaseOnBall) advance);

		} else if (advance instanceof BatterAdvanceOnIntentionalBaseOnBall) {
			return getBaseWin((BatterAdvanceOnIntentionalBaseOnBall) advance);

		} else if (advance instanceof BatterAdvanceOnHitByPitch) {
			return getBaseWin((BatterAdvanceOnHitByPitch) advance);

		} else if (advance instanceof BatterAdvanceOnKPassBall) {
			return getBaseWin((BatterAdvanceOnKPassBall) advance);

		} else if (advance instanceof BatterAdvanceOnKWildPitch) {
			return getBaseWin((BatterAdvanceOnKWildPitch) advance);

		} else if (advance instanceof BatterAdvanceOnKWithError) {
			return getBaseWin((BatterAdvanceOnKWithError) advance);

		} else if (advance instanceof BatterAdvanceOnSacrificeHitWithError) {
			return getBaseWin((BatterAdvanceOnSacrificeHitWithError) advance);

		} else if (advance instanceof BatterAdvanceOnSacrificeFlyWithError) {
			return getBaseWin((BatterAdvanceOnSacrificeFlyWithError) advance);

		} else if (advance instanceof BatterAdvanceOnCatcherInterference) {
			return getBaseWin((BatterAdvanceOnCatcherInterference) advance);

		} else if (advance instanceof BatterAdvanceOnKAbr) {
			return getBaseWin((BatterAdvanceOnKAbr) advance);

		} else if (advance instanceof BatterAdvanceOnSacrificeHitWithFielderChoice) {
			return getBaseWin((BatterAdvanceOnSacrificeHitWithFielderChoice) advance);

		} else if (advance instanceof BatterAdvanceOnSacrificeFlyWithFielderChoice) {
			return getBaseWin((BatterAdvanceOnSacrificeFlyWithFielderChoice) advance);

		} else if (advance instanceof BatterAdvanceOnObstruction) {
			return getBaseWin((BatterAdvanceOnObstruction) advance);

		} else if (advance instanceof BatterAdvanceOnKWithFielderChoice) {
			return getBaseWin((BatterAdvanceOnKWithFielderChoice) advance);

		} else if (advance instanceof BatterAdvanceOnGdpWithFielderChoice) {
			return getBaseWin((BatterAdvanceOnGdpWithFielderChoice) advance);

		} else {
			logger.log(Level.SEVERE, Messages.ScoreGameAdvanceUtil_BatterAdvance,advance.getClass().getSimpleName());
			return 0;
		}
	}

	/**
	 * FC Advance du to an fielder choice.
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnFielderChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * Code style +E Advance du to an error on an other player
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnOtherPlayerError advance) {
		return advance.getRunnerAdvance().length() - 2;
	}

	/**
	 * Code EF No advance , no out, just for compute earned point
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerMustBeOutOnError advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * Code CS No advance , runner is out
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerOutOnCaugthStealing advance) { 
		return NO_BASE_WIN;
	}

	/**
	 * Code PO No advance , runner is out
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerOutOnPickOff advance) {
		return NO_BASE_WIN;
	}

	/**
	 * Code 21 for example (1 assist 2 for out) No advance , runner is out
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerOutOnFielderAction advance) {
		return NO_BASE_WIN;
	}

	/**
	 * Code OBR No advance , runner is out
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerOutByRules advance) {
		return NO_BASE_WIN;
	}

	/**
	 * Code A No advance , runner is out
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerOutOnAppeal advance) {
		return NO_BASE_WIN;
	}

	/**
	 * Code + 1 or more advance,
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceByBatterAction advance) {
		return advance.getRunnerAdvance().length();
	}

	/**
	 * Code [(][1-9][)][+]* 1 or more advance,
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * Code SB[1-9] 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnStolenBase advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * Code WP[+]* 1 or more
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnWildPitch advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * Code PB[+]* 1 or more
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnPassBall advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * Code BK 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnBalk advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * PO (E[1-9] | E[1-9]t)[+]* 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnPickOffWithError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * CS (E[1-9] | E[1-9]t)[+]* 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnCaughtStealingWithError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * O[1-9][+]* 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnOccupedBall advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * T[7-9][1-6] 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnThrow advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * O/[1-9] 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnIndiference advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * INT? 'E' INT 'T' ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnThrowError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * INT? 'E' INT ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnReceiveError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * 'e' INT 'T' ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnNonDecisiveThrowError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * INT? 'e' INT ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnNonDecisiveReceiveError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * INT ABR 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnRule advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'e' INT 'F' ADVANCE? 1 + modeAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(RunnerAdvanceOnNonDecisiveFlyError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getRunnerAdvance());
	}

	/**
	 * 'FC' INT 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnDefensiveChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'ob' INT? 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnNoDecisiveObstruction advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'OB' INT? 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(RunnerAdvanceOnDecisiveObstruction advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * No advance, no out, just for earned point
	 * 
	 * @param action Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterMustOutOnFlyFoulBall action) {
		return NO_BASE_WIN;
	}

	/**
	 * No advance, no out
	 * 
	 * @param action Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterLostTurn action) {
		return NO_BASE_WIN;
	}

	/**
	 * Single hit 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnSingleHit advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * double hit 2
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnDoubleHit advance) {
		return 2;
	}

	/**
	 * triple hit 3
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnTripleHit advance) {
		return 3;
	}

	/**
	 * homerun hit 4
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnHomeRun advance) {
		return 4;
	}

	/**
	 * Inside park 4
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnInsidePark advance) {
		return 4;
	}

	/**
	 * 'O' INT ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnOccupedBall advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'FC' INT 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnDefensiveChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'O/' INT 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnIndiference advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * BB 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnBaseOnBall advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * IBB 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnIntentionalBaseOnBall advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * HP 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnHitByPitch advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'KPB'|'Kpb' ADVANCE? 1 + moreAdavnce
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnKPassBall advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'KWP'|'Kwp' ADVANCE?
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnKWildPitch advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'KABR 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnKAbr advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * ('K' REACH_ON_RECEIVE_ERROR) | ('K' REACH_ON_THROW_ERROR) 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnKWithError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * ('SH' REACH_ON_RECEIVE_ERROR) | ('SH' REACH_ON_THROW_ERROR) ADVANCE? 1 +
	 * moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnSacrificeHitWithError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'SH' (FIELDER_CHOICE|FIELDER_CHOICE_WITH_PUTOUT) 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnSacrificeHitWithFielderChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'SF' REACH_ON_RECEIVE_ERROR 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnSacrificeFlyWithError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'SF' (FIELDER_CHOICE|FIELDER_CHOICE_WITH_PUTOUT) 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnSacrificeFlyWithFielderChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'OB' INT? 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnObstruction advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * ('KS' | 'KL') (FIELDER_CHOICE|FIELDER_CHOICE_WITH_PUTOUT) 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnKWithFielderChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'E' INT 'F' ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnFlyError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * 'E' INT 'F' ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnPopError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * INT? 'E' INT ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	public static int getBaseWin(BatterAdvanceOnReceiveError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * INT? 'E' INT 'T' ADVANCE? 1 + moreAdvance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnThrowError advance) {
		return ONE_BASE_WIN + getMoreAdvance(advance.getBatterAdvance());
	}

	/**
	 * CI or INT 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnCatcherInterference advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'GDP' (REACH_ON_THROW_ERROR | REACH_ON_RECEIVE_ERROR) 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnGdpWithError advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * 'GDP' FIELDER_CHOICE_WITH_PUTOUT 1
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterAdvanceOnGdpWithFielderChoice advance) {
		return ONE_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnFlyed advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnLine advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnPopped advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnFlyedFallBall advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnPoppedFallBall advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnLineDriveFallBall advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnGroundedBall advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutByRule advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnAppeal advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnGroundedDoublePlay advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnSacrificeFly advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("all")
	public static int getBaseWin(BatterOutOnSacrificeFlyFallBall advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnSacrificeHit advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnInfieldFly advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnSwingedStrike advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnLookedStrike advance) {
		return NO_BASE_WIN;
	}

	/**
	 * batter out, no advance
	 * 
	 * @param advance Object describing the advance 
	 * @return return number of base win
	 */
	@SuppressWarnings("squid:S1172")
	public static int getBaseWin(BatterOutOnReleasedStrike advance) {
		return NO_BASE_WIN;
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(RunnerAdvanceOnDefensiveChoice advance) {
		return "" + advance.getRunnerAdvance().charAt(2);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the indifference.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(RunnerAdvanceOnIndiference advance) {
		return advance.getRunnerAdvance().replaceFirst("O/", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Return the defensive position of player who make the indifference.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnIndiference advance) {
		return advance.getBatterAdvance().replaceFirst("O/", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Return the defensive position of player who make the fielder choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(RunnerAdvanceOnFielderChoice advance) {
		return "" + advance.getRunnerAdvance().charAt(advance.getRunnerAdvance().length() - 1);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the fielder choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnDefensiveChoice advance) {
		return "" + advance.getBatterAdvance().charAt(advance.getBatterAdvance().length()-1);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnOccupedBall advance) {
		return "" + advance.getBatterAdvance().charAt(1);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(RunnerAdvanceOnOccupedBall advance) {
		return "" + advance.getRunnerAdvance().charAt(1);//$NON-NLS-1$
	}

	
	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnKWithFielderChoice advance) {
		return "" + advance.getBatterAdvance().charAt(3);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnSacrificeFlyWithFielderChoice advance) {
		return "" + advance.getBatterAdvance().charAt(3);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getDefensivePosition(BatterAdvanceOnSacrificeHitWithFielderChoice advance) {
		return "" + advance.getBatterAdvance().charAt(3);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getOutfielder(RunnerAdvanceOnThrow advance) {
		return "" + advance.getRunnerAdvance().charAt(1);//$NON-NLS-1$
	}

	/**
	 * Return the defensive position of player who make the choice.
	 * 
	 * @param advance Code of the action
	 * @return char which represent the player implicated in the action 
	 */
	public static String getInfielder(RunnerAdvanceOnThrow advance) {
		return "" + advance.getRunnerAdvance().charAt(2);//$NON-NLS-1$
	}

	/**
	 * Compute the number of base win when there are more advance in the action
	 * 
	 * @param advance code of the advance 
	 * 
	 * @return number of base win
	 */
	private static int getMoreAdvance(String advance) {
		int size = 0;
		String code = advance;
		if (advance.endsWith("b")) { //$NON-NLS-1$  
			code = advance.substring(0, advance.length() - 1);
		}
		Matcher matcher = pattern.matcher(code);
		if (matcher.find() && (matcher.group(1) != null)) {
			size = matcher.group(1).length();
		}
		return size;
	}

}
