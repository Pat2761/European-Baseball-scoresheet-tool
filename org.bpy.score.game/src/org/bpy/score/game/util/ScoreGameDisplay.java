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

import org.bpy.score.game.game.BatterAdvanceOnCatcherInterference;
import org.bpy.score.game.game.BatterAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.BatterAdvanceOnDoubleHit;
import org.bpy.score.game.game.BatterAdvanceOnFlyError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnHomeRun;
import org.bpy.score.game.game.BatterAdvanceOnIndiference;
import org.bpy.score.game.game.BatterAdvanceOnInsidePark;
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
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnAppeal;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
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
import org.bpy.score.game.game.RunnerAdvanceOnBalk;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnDefensiveChoice;
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

/**
 * Utility class which follow text of an action to put in the sore sheet.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameDisplay {

	/** Code for GDP */
	public static final String GDP_NEW_LINE = "GDP\n"; //$NON-NLS-1$
	/** Regular expression for remove all + (more advance) in the code of the action */
	public static final String PATTERN_REMOVE_MORE_ADVANCE = "[\\+]*"; //$NON-NLS-1$
	
	/**
	 * Private constructor for hiding missing public constructor.
	 */
	 private ScoreGameDisplay() {
	    throw new IllegalStateException("Utility class"); //$NON-NLS-1$
     }
	
	/**
	 * Get the substitution code to display
	 *  
	 * @param text String of the description of the substitution
	 * @return String to display
	 */
	public static String getSubstitutionDisplayCode(String text) {
		if (text.startsWith("ph")) return "ph"; //$NON-NLS-1$ //$NON-NLS-2$
		if (text.startsWith("pr")) return "pr"; //$NON-NLS-1$ //$NON-NLS-2$
		return text;
	}

	/**
	 * Get string to display for a Batter Out On Infield Fly.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnInfieldFly action) {
		return "IF\n" + action.getBatterOut().replaceFirst("IF",""); //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Runner Advance On Decisive Obstruction.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnDecisiveObstruction action) {
		return action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Out On Appeal.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnAppeal action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Grounded Double Play.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnGroundedDoublePlay action) {
		return GDP_NEW_LINE + action.getBatterOut().replaceFirst("GDP",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Runner Advance On Other Player Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnOtherPlayerError action) {
		return "(" + action.getRunnerAdvance().substring(action.getRunnerAdvance().length()-1,action.getRunnerAdvance().length()) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Runner Advance On Rule.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnRule action) {
		return "ABR\n" + action.getRunnerAdvance().replaceFirst("ABR",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Runner Must Be Out On Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerMustBeOutOnError action) {
		return action.getActionCode();
	}

	/**
	 * Get string to display for a Runner Advance On Caught Stealing With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnCaughtStealingWithError action) {
		return "CS\n" + action.getRunnerAdvance().replaceFirst("CS","").replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Get string to display for a Runner Advance On Fielder Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnFielderChoice action) {
		return "FC\n" + action.getRunnerAdvance().replaceFirst("FC",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Sacrifice Fly With Fielder Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnSacrificeFlyWithFielderChoice action) {
		return "SF\n" + action.getBatterAdvance().replaceFirst("SF",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Obstruction.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnObstruction action) {
		return action.getBatterAdvance();
	}

	/**
	 * Get string to display for a Runner Advance On Non Decisive Fly Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnNonDecisiveFlyError action) {
		return action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Batter Advance On Catcher Interference.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnCatcherInterference action) {
		return action.getBatterAdvance();
	}

	/**
	 * Get string to display for a Runner Out On Appeal.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerOutOnAppeal action) {
		return action.getRunnerOut();
	}

	/**
	 * Get string to display for a Batter Advance On Sacrifice Hit With Fielder Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnSacrificeHitWithFielderChoice action) {
		return "SH\n" + action.getBatterAdvance().replaceFirst("SH",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Out On Sacrifice Fly Fall Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnSacrificeFlyFallBall action) {
		return "FSF\n" + action.getBatterOut().replaceFirst("FSF",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Sacrifice Fly With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnSacrificeFlyWithError action) {
		return "SF\n" + action.getBatterAdvance().replaceFirst("SF","").replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Get string to display for a Batter Advance On Sacrifice Hit With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnSacrificeHitWithError action) {
		return "SH\n" + action.getBatterAdvance().replaceFirst("SH","").replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Get string to display for a Batter Advance On K With Fielder Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnKWithFielderChoice action) {
		return action.getBatterAdvance().substring(0,2)+ "\n" + action.getBatterAdvance().substring(2); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On K Abr.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	@SuppressWarnings("squid:S1172")
	public static String getDisplayCode(BatterAdvanceOnKAbr action) {
		return "K\nABR"; //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On K With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnKWithError action) {
		return "KS\n" +  action.getBatterAdvance().replaceFirst("KS",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Out By Rule.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutByRule action) {
		String obrType = ScoreGameUtil.getOBRType(action);
		if ("KS".equals(obrType) || "2".equals(obrType) ) { //$NON-NLS-1$ //$NON-NLS-2$
			return "OBR" + "\n" +  obrType; //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			String[] parts = action.getBatterOut().split("-"); //$NON-NLS-1$
			return "OBR" + "\n" +  parts[1];	 //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Get string to display for a Runner Out By Rules.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerOutByRules action) {
			String[] parts = action.getRunnerOut().split("-"); //$NON-NLS-1$
			return "OBR" + "\n" +  parts[1]; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Runner Advance On Defensive Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnDefensiveChoice action) {
		return "FC\n" + action.getRunnerAdvance().replaceFirst("FC",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Runner Advance On No Decisive Obstruction.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnNoDecisiveObstruction action) {
		return "" + action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Runner Advance On Receive Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnReceiveError action) {
		return "" + action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Runner Advance On Throw Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnThrowError action) {
		return "" + action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$ 
	}

	/**
	 * Get string to display for a Runner Advance On Pick Off With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnPickOffWithError action) {
		return "PO\n" + action.getRunnerAdvance().substring(2).replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Runner Advance On Non Decisive Throw Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnNonDecisiveThrowError action) {
		return "" + action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a Runner Advance On Stolen Base.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnStolenBase action) {
		return "" + action.getRunnerAdvance(); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Advance On Wild Pitch.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnWildPitch action) {
		String text = action.getRunnerAdvance().replaceAll("[\\+]+",""); //$NON-NLS-1$ //$NON-NLS-2$
		return "" + text; //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Advance On Pass Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnPassBall action) {
		String text = action.getRunnerAdvance().replaceAll("[\\+']+",""); //$NON-NLS-1$ //$NON-NLS-2$
		return "" + text; //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Advance On Balk.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnBalk action) {
		return "" + action.getRunnerAdvance(); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Balk.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterBalk action) {
		return "" + action.getBatterAction(); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Advance On Occuped Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnOccupedBall action) {
		return "" + action.getRunnerAdvance(); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On Indifference.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnIndiference action) {
		return "" + action.getBatterAdvance(); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On Indifference.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnThrow action) {
		return action.getRunnerAdvance();
	}

	/**
	 * Get string to display for a Batter Out On Sacrifice Hit.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnSacrificeHit action) {
		return "SH\r\n" + action.getBatterOut().replaceFirst("SH",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Occupied Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnOccupedBall action) {
		return action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On GDP With Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnGdpWithError action) {
		return GDP_NEW_LINE + action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,"").replaceFirst("GDP",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On GDP With Fielder Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnGdpWithFielderChoice action) {
		return GDP_NEW_LINE + action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,"").replaceFirst("GDP",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
	}

	/**
	 * Get string to display for a Runner Advance On Non Decisive Receive Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnNonDecisiveReceiveError action) {
		return action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Advance On Indifference.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerAdvanceOnIndiference action) {
		return action.getRunnerAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Runner Out On Caugth Stealing.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(RunnerOutOnCaugthStealing action) {
		return "CS\n" + action.getRunnerOut().replaceFirst("CS",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Fly Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnFlyError action) {
		return action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On Pop Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnPopError action) {
		return action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On K Pass Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnKPassBall action) {
		String text = action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,"");  //$NON-NLS-1$
		return "KS\n" + text.replaceFirst("KS","");  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On K Wild Pitch.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnKWildPitch action) {
		String textToDisplay = action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
		return "KS\n" + textToDisplay.replaceFirst("KS",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Advance On Defensive Choice.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnDefensiveChoice action) {
		String text =  action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
		return "FC\n" + text.replaceFirst("FC",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Get string to display for a Batter Out On Line Drive Fall Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnLineDriveFallBall action) {
		 return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Popped Fall Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnPoppedFallBall action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Popped.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnPopped action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Line drive.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnLine action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Flyed.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnFlyed action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a Batter Out On Released Strike.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnReleasedStrike action) {
		String defenderPart = action.getStrikeOutValue().replaceFirst("K[S|L]?",""); //$NON-NLS-1$ //$NON-NLS-2$
		String actionCode = action.getStrikeOutValue().replace(defenderPart,""); //$NON-NLS-1$
		return actionCode + "\n" + defenderPart; //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Out On Sacrifice Fly.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnSacrificeFly action) {
		return "SF\r\n" + action.getBatterOut().replaceFirst("SF",""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
	}

	/**
	 * Get string to display for a Batter Advance On Receive Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnReceiveError action) {
		return action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Advance On Throw Error.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnThrowError action) {
		return action.getBatterAdvance().replaceAll(PATTERN_REMOVE_MORE_ADVANCE,""); //$NON-NLS-1$
	}

	/**
	 * Get string to display for a Batter Out On Flyed Fall Ball.
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterOutOnFlyedFallBall action) {
		return action.getBatterOut();
	}

	/**
	 * Get string to display for a single hit
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnSingleHit action) {
		return action.getHit().replace("1B", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a double hit
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnDoubleHit action) {
		return action.getHit().replace("2B", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a triple hit
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnTripleHit action) {
		return action.getHit().replace("3B", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a homerun
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnHomeRun action) {
		return action.getHit().replace("HR", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get string to display for a inside park
	 * 
	 * @param action String of the action
	 * @return String to display
	 */
	public static String getDisplayCode(BatterAdvanceOnInsidePark action) {
		return action.getHit().replace("IHR", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
