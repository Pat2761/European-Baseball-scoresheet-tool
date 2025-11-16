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

import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.BatterOut;
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnAppeal;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnGroundedDoublePlay;
import org.bpy.score.game.game.BatterOutOnInfieldFly;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnLineDriveFallBall;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.BatterOutOnSacrificeFly;
import org.bpy.score.game.game.BatterOutOnSacrificeFlyFallBall;
import org.bpy.score.game.game.BatterOutOnSacrificeHit;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.game.RunnerAction;
import org.bpy.score.game.game.RunnerAdvance;
import org.bpy.score.game.game.RunnerOut;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.game.RunnerOutOnAppeal;
import org.bpy.score.game.game.RunnerOutOnCaugthStealing;
import org.bpy.score.game.game.RunnerOutOnFielderAction;
import org.bpy.score.game.game.RunnerOutOnPickOff;
import org.eclipse.emf.ecore.EObject;

/**
 * Utility class which manage outs
 *  - Compute number of out in half inning
 *  - Get Defender number who make the out
 *  
 * @author Patrick BRIAND
 *
 */
public class ScoreGameOutUtil {

	/**
	 * Private constructor for hiding missing public constructor.
	 */
	private ScoreGameOutUtil() {
	    throw new IllegalStateException("Utility class"); //$NON-NLS-1$
    }
	
	/**
	 * Count number of out in a half inning
	 * 
	 * @param halfInning reference on the half inning
	 * @return Number of out
	 */
	public static int getOut(HalfInning halfInning) {
		int putoutCounter = 0;
		
		for (EObject element : halfInning.getInningElements()) {
			if (element instanceof Action) {
				Action action = (Action) element;
				for (int bcl = action.getRunnerActions().size() - 1; bcl >= 0; bcl--) {
		
					RunnerAction runnerAction = action.getRunnerActions().get(bcl);
		
					if (runnerAction instanceof RunnerAdvance) {
						RunnerAdvance runnerAdvance = (RunnerAdvance) runnerAction;
						if (runnerAdvance.getRunnerOut() != null) {
							putoutCounter += 1;
						}
		
					} else if (runnerAction instanceof RunnerOut) {
						putoutCounter += 1;
					}
				}
		
				if ( action.getBatterAction() instanceof BatterOut) {
					putoutCounter += 1;
				}
			}
		}
		
		return putoutCounter;
	}

	/**
	 * get defender position who makes the out in case of Runner Out On Caught Stealing.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(RunnerOutOnCaugthStealing action) {
		return action.getRunnerOut().charAt(action.getRunnerOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Runner Out On Pick Off.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(RunnerOutOnPickOff action) {
		return action.getRunnerOut().charAt(action.getRunnerOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Runner Out On Fielder Action.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(RunnerOutOnFielderAction action) {
		return ("" + action.getRunnerOut()%10).charAt(0); //$NON-NLS-1$
	}

	/**
	 * get defender position who makes the out in case of Runner Out By Rules.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(RunnerOutByRules action) {
		return action.getRunnerOut().charAt(action.getRunnerOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Runner Out On Appeal.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(RunnerOutOnAppeal action) {
		return action.getRunnerOut().charAt(action.getRunnerOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Flyed.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnFlyed action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		strAction = strAction.replaceFirst("F",""); //$NON-NLS-1$ //$NON-NLS-2$
		return strAction.charAt(strAction.length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Line.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnLine action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		strAction = strAction.replaceFirst("L",""); //$NON-NLS-1$ //$NON-NLS-2$
		return strAction.charAt(strAction.length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Popped.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnPopped action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		strAction = strAction.replaceFirst("P",""); //$NON-NLS-1$ //$NON-NLS-2$
		return strAction.charAt(strAction.length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Flyed Fall Ball.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnFlyedFallBall action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		strAction = strAction.replaceFirst("FP",""); //$NON-NLS-1$ //$NON-NLS-2$
		return strAction.charAt(strAction.length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Popped Fall Ball.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnPoppedFallBall action) {
		String strAction = action.getBatterOut().replace("b",""); //$NON-NLS-1$ //$NON-NLS-2$
		strAction = strAction.replaceFirst("FP",""); //$NON-NLS-1$ //$NON-NLS-2$
		return strAction.charAt(strAction.length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Line Drive Fall Ball.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnLineDriveFallBall action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Grounded Ball.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnGroundedBall action) {
		return ("" + action.getBatterOut()%10).charAt(0); //$NON-NLS-1$
	}

	/**
	 * get defender position who makes the out in case of Batter Out By Rule.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutByRule action) {
		String[] parts = action.getBatterOut().split("-"); //$NON-NLS-1$
		return parts[1].charAt(parts[1].length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Grounded Double Play.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnGroundedDoublePlay action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Appeal.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnAppeal action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Sacrifice Fly.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnSacrificeFly action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Sacrifice Fly Fall Ball.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnSacrificeFlyFallBall action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Sacrifice Hit.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnSacrificeHit action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Infield Fly.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnInfieldFly action) {
		return action.getBatterOut().charAt(action.getBatterOut().length()-1);
	}

	/**
	 * get defender position who makes the out in case of Batter Out On Released Strike.
	 * 
	 * @param action code of the action
	 * @return defender position who makes the out 
	 */
	public static char getOut(BatterOutOnReleasedStrike action) {
		return action.getStrikeOutValue().charAt(action.getStrikeOutValue().length()-1);
	}

}
