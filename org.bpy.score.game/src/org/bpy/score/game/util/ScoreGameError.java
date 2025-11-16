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

import org.bpy.score.game.game.BatterAdvanceOnCatcherInterference;
import org.bpy.score.game.game.BatterAdvanceOnFlyError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithError;
import org.bpy.score.game.game.BatterAdvanceOnKWithError;
import org.bpy.score.game.game.BatterAdvanceOnObstruction;
import org.bpy.score.game.game.BatterAdvanceOnReceiveError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithError;
import org.bpy.score.game.game.BatterAdvanceOnThrowError;
import org.bpy.score.game.game.BatterMustOutOnFlyFoulBall;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnError;
import org.bpy.score.game.game.RunnerAdvanceOnNoDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveFlyError;
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
import org.bpy.score.game.game.RunnerMustBeOutOnError;

/**
 * This utility class extract the defender number who make the error.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameError {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreGameError.class.getSimpleName());

	/** Pattern for extract the more advances (all the + in the code */
	public static final String MORE_ADVANCE_PATTERN = "[\\+]+"; //$NON-NLS-1$

	/**
	 * Private constructor for hiding missing public constructor.
	 */
	private ScoreGameError() {
		throw new IllegalStateException("Utility class");//$NON-NLS-1$
	}
	
	/**
	 * extract the defender number in case of Batter Must Out On Fly Foul Ball.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterMustOutOnFlyFoulBall action) {
		return getDefensivePositionForError(action.getError());
	}

	/**
	 * extract the defender number in case of Runner Must Be Out On Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerMustBeOutOnError action) {
		return getDefensivePositionForError(action.getActionCode());
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Pick Off With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnPickOffWithError action) {
		return getDefensivePositionForError(action.getActionCode().replaceFirst("PO", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Runner Advance On Pick Off With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnPickOffWithError action) {
		return getDefensivePositionForError(action.getRunnerAdvance().replaceFirst("PO", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Runner Advance On Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Caught Stealing With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnCaughtStealingWithError action) {
		return getDefensivePositionForError(action.getActionCode().replaceFirst("CS", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Runner Advance On Caught Stealing With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnCaughtStealingWithError action) {
		return getDefensivePositionForError(action.getRunnerAdvance().replaceFirst("CS", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Throw Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnThrowError action) {
		return getDefensivePositionForError(action.getActionCode());
	}

	/**
	 * extract the defender number in case of Runner Advance On Throw Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnThrowError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Advance On Non Decisive Fly Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnNonDecisiveFlyError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Receive Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnReceiveError action) {
		return getDefensivePositionForError(action.getActionCode());
	}

	/**
	 * extract the defender number in case of Runner Advance On Receive Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnReceiveError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Non Decisive Throw Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		return getDefensivePositionForError(action.getActionCode());
	}

	/**
	 * extract the defender number in case of Runner Advance On Non Decisive Throw Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnNonDecisiveThrowError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Don't Advance On Non Decisive Receive Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		return getDefensivePositionForError(action.getActionCode());
	}

	/**
	 * extract the defender number in case of Runner Advance On Non Decisive Receive Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnNonDecisiveReceiveError action) {
		return getDefensivePositionForError(action.getRunnerAdvance());
	}

	/**
	 * extract the defender number in case of Runner Advance On No Decisive Obstruction.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnNoDecisiveObstruction action) {
		return action.getRunnerAdvance().replaceFirst("ob", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Runner Advance On Decisive Obstruction.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(RunnerAdvanceOnDecisiveObstruction action) {
		return action.getRunnerAdvance().replaceFirst("OB", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On Obstruction.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnObstruction action) {
		return action.getBatterAdvance().replaceFirst("OB", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On Catcher Interference action.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	@SuppressWarnings("squid:S1172")
	public static String getDefensivePosition(BatterAdvanceOnCatcherInterference action) {
		return "2"; //$NON-NLS-1$
	}

	/**
	 * extract the defender number in case of Batter Advance On Sacrifice Fly With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnSacrificeFlyWithError action) {
		return getDefensivePositionForError(action.getBatterAdvance().replaceFirst("SF", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On Sacrifice Hit With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnSacrificeHitWithError action) {
		return getDefensivePositionForError(action.getBatterAdvance().replaceFirst("SH", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On K With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnKWithError action) {
		return getDefensivePositionForError(action.getBatterAdvance().replaceFirst("KS", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On GDP With Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnGdpWithError action) {
		return getDefensivePositionForError(action.getBatterAdvance().replaceFirst("GDP", "")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * extract the defender number in case of Batter Advance On Fly Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnFlyError action) {
		return getDefensivePositionForError(action.getBatterAdvance());
	}

	/**
	 * extract the defender number in case of Batter Advance On Receive Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnReceiveError action) {
		String code = action.getBatterAdvance();
		if (code.endsWith("b")) { //$NON-NLS-1$
			code = code.substring(0, code.length() - 1);
		}
		return getDefensivePositionForError(code);
	}

	/**
	 * extract the defender number in case of Batter Advance On Throw Error.
	 * 
	 * @param action String of the action
	 * @return defender number who make the error
	 */
	public static String getDefensivePosition(BatterAdvanceOnThrowError action) {
		String code = action.getBatterAdvance();
		if (code.endsWith("b")) { //$NON-NLS-1$
			code = code.substring(0, code.length() - 1);
		}
		return getDefensivePositionForError(code);
	}

	/**
	 * extract the defender number in case of error.
	 * 
	 * @param code Code to analyze
	 * @return defender number who make the error
	 */
	private static String getDefensivePositionForError(String code) {

		String newCode = code.replaceAll(MORE_ADVANCE_PATTERN, ""); //$NON-NLS-1$

		if (newCode.endsWith("F")) { //$NON-NLS-1$
			return getDefensivePositionForFlyError(newCode);
		} else if (newCode.startsWith("EF")) { //$NON-NLS-1$
			return getDefensivePositionMustBeError(newCode);
		} else if (newCode.endsWith("t") || newCode.endsWith("T")) { //$NON-NLS-1$ //$NON-NLS-2$
			return getDefensivePositionForThrowError(newCode);
		} else {
			return getDefensivePositionForReceiveError(newCode);
		}
	}

	/**
	 * extract the defender number in case of possible error in foul fall ball.
	 * 
	 * @param code Code to analyze
	 * @return defender number who make the error
	 */
	private static String getDefensivePositionMustBeError(String code) {
		return code.replaceAll(MORE_ADVANCE_PATTERN, "").replaceFirst("EF", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * extract the defender number in case of Received Error.
	 * 
	 * @param code Code to analyze
	 * @return defender number who make the error
	 */
	private static String getDefensivePositionForReceiveError(String code) {
		return code.replaceAll(MORE_ADVANCE_PATTERN, "").substring(code.length() - 1); //$NON-NLS-1$
	}

	/**
	 * extract the defender number in case of Fly Error.
	 * 
	 * @param code Code to analyze
	 * @return defender number who make the error
	 */
	private static String getDefensivePositionForFlyError(String code) {
		return code.toUpperCase().replaceAll(MORE_ADVANCE_PATTERN, "").replaceFirst("E", "").replaceFirst("F", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}

	/**
	 * extract the defender number in case of Throw Error.
	 * 
	 * @param code Code to analyze
	 * @return defender number who make the error
	 */
	private static String getDefensivePositionForThrowError(String code) {
		return code.toUpperCase().substring(code.toUpperCase().indexOf("E")).replaceFirst("E", "").replaceFirst("T", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				""); //$NON-NLS-1$
	}

	/**
	 * Just for rapid test
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		logger.log(Level.SEVERE, getDefensivePositionForError("E9F")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("6E3")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("E5")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("E4t")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("E5T++")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("54369E2T++")); //$NON-NLS-1$
		logger.log(Level.SEVERE, getDefensivePositionForError("e2t")); //$NON-NLS-1$
	}
}
