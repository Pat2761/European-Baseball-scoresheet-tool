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

import org.bpy.score.game.game.BatterAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnKWithError;
import org.bpy.score.game.game.BatterAdvanceOnKWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnReceiveError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithError;
import org.bpy.score.game.game.BatterAdvanceOnThrowError;
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnAppeal;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnGroundedDoublePlay;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnLineDriveFallBall;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.BatterOutOnSacrificeFly;
import org.bpy.score.game.game.BatterOutOnSacrificeFlyFallBall;
import org.bpy.score.game.game.BatterOutOnSacrificeHit;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnFielderChoice;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveThrowError;
import org.bpy.score.game.game.RunnerAdvanceOnPickOffWithError;
import org.bpy.score.game.game.RunnerAdvanceOnReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnThrowError;
import org.bpy.score.game.game.RunnerDontAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerDontAdvanceOnNonDecisiveReceiveError;
import org.bpy.score.game.game.RunnerDontAdvanceOnNonDecisiveThrowError;
import org.bpy.score.game.game.RunnerDontAdvanceOnPickOffWithError;
import org.bpy.score.game.game.RunnerDontAdvanceOnReceiveError;
import org.bpy.score.game.game.RunnerDontAdvanceOnThrowError;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.game.RunnerOutOnAppeal;
import org.bpy.score.game.game.RunnerOutOnCaugthStealing;
import org.bpy.score.game.game.RunnerOutOnFielderAction;
import org.bpy.score.game.game.RunnerOutOnPickOff;

/**
 * 
 * Utilities for computing the assistance in function of the action.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameAssistUtil {

	/**
	 * Private constructor for hiding missing public constructor.
	 */
	private ScoreGameAssistUtil() {
		throw new IllegalStateException("Utility class");//$NON-NLS-1$
	}
	
	/**
	 * Get all the defensive positions which assist to the put out in case of a runner out by an appeal play.
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerOutOnAppeal action) {
		return getExtractAssist(action.getRunnerOut().substring(0,action.getRunnerOut().length()-1).replaceFirst("A","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist to the put out in case of a runner out by rule (Case OBR).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerOutByRules action) {
		String[] parts = action.getRunnerOut().split("-"); //NON-NLS-1$ //$NON-NLS-1$
		if (parts.length == 2) {
		  return getExtractAssist(parts[1].substring(0,parts[1].length()-1));
        } else {
        	return "".toCharArray(); //$NON-NLS-1$
        }
    }

	/**
	 * Get all the defensive positions which assist to the put out in case of a runner out by a caught stealing
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerOutOnCaugthStealing action) {
		return getExtractAssist( action.getRunnerOut().substring(0,action.getRunnerOut().length()-1).replaceFirst("CS","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist to the put out in case of a runner out by a pick off.
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerOutOnPickOff action) {
		return getExtractAssist(action.getRunnerOut().substring(0,action.getRunnerOut().length()-1).replaceFirst("PO","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist to the put out in case of a runner out by a fielder action
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerOutOnFielderAction action) {
		if (action.getRunnerOut()>10) {
			return getExtractAssist(""+ action.getRunnerOut()/10); //NON-NLS-1$ //$NON-NLS-1$
		} else {
		  return getExtractAssist("");  //NON-NLS-1$ //$NON-NLS-1$
		}
	}

	/**
	 * Get all the defensive positions which assist in case of a runner out by Pick off with error, the runner don't advance.
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnPickOffWithError action) {
		return getExtractErrorAssist(action.getActionCode().replaceFirst("PO","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a runner out by a pick off with error, the runner advance.
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerAdvanceOnPickOffWithError action) {
		return getExtractErrorAssist(action.getRunnerAdvance().replaceFirst("PO","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a runner out by a caught stealing with error (with advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerAdvanceOnCaughtStealingWithError action) {
		return getExtractErrorAssist(action.getRunnerAdvance().replaceFirst("CS","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a runner out by a caught stealing with error (with no advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnCaughtStealingWithError action) {
		return getExtractErrorAssist(action.getActionCode().replaceFirst("CS","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on no decisive error with throw error (with no advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		return getExtractErrorAssist(action.getActionCode());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on no decisive error with throw error (with advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public  static char[] getAssistances(RunnerAdvanceOnNonDecisiveThrowError action) {
		return getExtractErrorAssist(action.getRunnerAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on error with receive error (with no advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnReceiveError action) {
		return getExtractErrorAssist(action.getActionCode());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on error with receive error (with advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerAdvanceOnReceiveError action) {
		return getExtractErrorAssist(action.getRunnerAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on decisive error with throw error (with no advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist 
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnThrowError action) {
		return getExtractErrorAssist(action.getActionCode());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on no decisive error with throw error (with advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerAdvanceOnThrowError action) {
		return getExtractErrorAssist(action.getRunnerAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on no decisive error with receive error (with no advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		return getExtractErrorAssist(action.getActionCode());
	}

	/**
	 * Get all the defensive positions which assist in case of a runner on no decisive error with receive error (with advance).
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerAdvanceOnNonDecisiveReceiveError action) {
		return getExtractErrorAssist(action.getRunnerAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on Sacrifice fly with error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnSacrificeFlyWithError action) {
		return getExtractErrorAssist(action.getBatterAdvance().substring(0,action.getBatterAdvance().length()-1).replaceFirst("SF","")); //NON-NLS-1$ //NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on Sacrifice hit with error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnSacrificeHitWithError action) {
		return getExtractErrorAssist(action.getBatterAdvance().replaceFirst("SH","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on third strike released with error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnKWithError action) {
		return getExtractErrorAssist(action.getBatterAdvance().replaceFirst("KS","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on Grounded double play with error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnGdpWithError action) {
		return getExtractErrorAssist(action.getBatterAdvance().replaceFirst("GDP","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on throw error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnThrowError action) {
		return getExtractErrorAssist(action.getBatterAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance on receive error
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnReceiveError action) {
		return getExtractErrorAssist(action.getBatterAdvance());
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out by sacrifice hit
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnSacrificeHit action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("SH","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out by rules
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutByRule action) {
		String[] parts = action.getBatterOut().split("-"); //NON-NLS-1$ //$NON-NLS-1$
		if (parts.length == 2) {
		  return getExtractAssist(parts[1].substring(0,parts[1].length()-1));
        } else {
        	return "".toCharArray(); //$NON-NLS-1$
        }
    }

	/**
	 * Get all the defensive positions which assist in case of a batter advance on strike out with fielder choice
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnKWithFielderChoice action) {
		return getExtractAssist(action.getBatterAdvance().substring(0,action.getBatterAdvance().length()-1).replaceFirst("K[S|L]?","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter is out on a sacrifice (foul ball)
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnSacrificeFlyFallBall action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("FSF","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter advance in case of fielder choice
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnDefensiveChoice action) {
		return getExtractAssist(action.getBatterAdvance().substring(0,action.getBatterAdvance().length()-1).replaceFirst("FC","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter fly out in case off fall ball
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnFlyedFallBall action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction.substring(0,strAction.length()-1).replaceFirst("FF","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a runner who advance on a fielder choice
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(RunnerAdvanceOnFielderChoice action) {
		String strAction = action.getRunnerAdvance().replace("FC","");  //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction);
	}

	/**
	 * Get all the defensive positions which assist in case of a  batter pop out in case of fall ball
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnPoppedFallBall action) {
		String strAction = action.getBatterOut().replace("b","");   //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction.substring(0,strAction.length()-1).replaceFirst("FP","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a  batter line out in case of fall ball
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnLineDriveFallBall action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("FL",""));//$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter flyed out
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnFlyed action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction.substring(0,strAction.length()-1).replaceFirst("F","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter popped out
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnPopped action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction.substring(0,strAction.length()-1).replaceFirst("P","")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter lined out
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnLine action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(strAction.substring(0,strAction.length()-1).replaceFirst("L",""));  //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out on appeal
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnAppeal action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("A",""));  //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out sacrifice fly
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnSacrificeFly action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("SF",""));  //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out grounded out with double play
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnGroundedDoublePlay action) {
		return getExtractAssist(action.getBatterOut().substring(0,action.getBatterOut().length()-1).replaceFirst("GDP",""));  //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out grounded out with double play with fielder choice
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterAdvanceOnGdpWithFielderChoice action) {
		String choice = action.getBatterAdvance().replaceFirst("GDP","");  //$NON-NLS-1$ //$NON-NLS-2$
		if (choice.startsWith("O")) { //NON-NLS-1$ //$NON-NLS-1$
			return getExtractAssist(choice.replaceFirst("O","")); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			return getExtractAssist(choice.replaceFirst("FC","")); //$NON-NLS-1$ //$NON-NLS-2$
		} 
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out grounded out
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnGroundedBall action) {
		if (action.getBatterOut()>10) {
			return getExtractAssist(""+ action.getBatterOut()/10); //$NON-NLS-1$
		} else {
		  return getExtractAssist(""); //$NON-NLS-1$
		}
	}

	/**
	 * Get all the defensive positions which assist in case of a batter out of release strike
	 * 
	 * @param action code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	public static char[] getAssistances(BatterOutOnReleasedStrike action) {
		String part = action.getStrikeOutValue().replace("K",""); //$NON-NLS-1$ //$NON-NLS-2$
		part = part.replace("S",""); //$NON-NLS-1$ //$NON-NLS-2$
		part = part.replace("L",""); //$NON-NLS-1$ //$NON-NLS-2$
		return getExtractAssist(part.substring(0,part.length()-1));
	}

	/**
	 * get assistance in case of action with error
	 * 
	 * @param code code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	private static char[] getExtractErrorAssist(String code) {
		String newCode = code.toUpperCase().substring(0,code.toUpperCase().indexOf("E")); //$NON-NLS-1$
		return newCode.toCharArray();
	}

	/**
	 * get assistance in case of action without error
	 * 
	 * @param code code of the action
	 * @return String which contains all the defensive positions which assist
	 */
	private static char[] getExtractAssist(String code) {
		return code.toCharArray();
	}
}
