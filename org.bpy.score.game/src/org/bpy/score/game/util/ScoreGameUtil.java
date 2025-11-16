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

import java.util.List;

import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.BatterAdvanceOnDoubleHit;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnHomeRun;
import org.bpy.score.game.game.BatterAdvanceOnInsidePark;
import org.bpy.score.game.game.BatterAdvanceOnSingleHit;
import org.bpy.score.game.game.BatterAdvanceOnTripleHit;
import org.bpy.score.game.game.BatterMustOutOnFlyFoulBall;
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnInfieldFly;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.CurrentRunner;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.LineUp;
import org.bpy.score.game.game.RunnerOutByRules;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Some utilities about game file
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameUtil {
	
	/**
	 * Private constructor for hiding missing public constructor.
	 */
	private ScoreGameUtil() {
		throw new IllegalStateException("Utility class");//$NON-NLS-1$
	}

	/**
	 * Get hit position in case of Batter Must Out On Fly Foul Ball. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getLocation(BatterMustOutOnFlyFoulBall advance) {
		return advance.getError().replaceFirst("EF",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get hit position in case of Batter Advance On Inside Park. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getHitLocation(BatterAdvanceOnInsidePark advance) {
		return advance.getHit().replaceFirst("IHR",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get hit position in case of Batter Advance On Single Hit. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getHitLocation(BatterAdvanceOnSingleHit advance) {
		return advance.getHit().replaceFirst("1B",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get hit position in case of Batter Advance On Double Hit. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getHitLocation(BatterAdvanceOnDoubleHit advance) {
		return advance.getHit().replaceFirst("2B",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get hit position in case of Batter Advance On Triple Hit. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getHitLocation(BatterAdvanceOnTripleHit advance) {
		return advance.getHit().replaceFirst("3B",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get hit position in case of Batter Advance On Home Run. 
	 * 
	 * @param advance code of the action
	 * @return hit position
	 */
	public static String getHitLocation(BatterAdvanceOnHomeRun advance) {
		return advance.getHit().replaceFirst("HR",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defenders position who make out. 
	 * 
	 * @param releasedStrikeOut  code of the action
	 * @return defenders position who make out. 
	 */
	public static String getDefenderPart(BatterOutOnReleasedStrike releasedStrikeOut) {
		return releasedStrikeOut.getStrikeOutValue().replaceFirst("K[L|S]?",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who makes the out in a list of defenders. 
	 * 
	 * @param defenderParts  String which contains the list of defenders
	 * @return defender position who makes the out. 
	 */
	public static char getPutoutDefender(String defenderParts) {
		return defenderParts.charAt(defenderParts.length()-1);
	}

	/**
	 * Get defender position who makes the assists in a list of defenders. 
	 * 
	 * @param defenderParts  String which contains the list of defenders
	 * @return defender position who make the assist. 
	 */
	public static String getAssistDefender(String defenderParts) {
		if (defenderParts.length()>1 ) {
			return defenderParts.substring(0,defenderParts.length()-1); 
		} else {
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * Get defender position who participate to an out in case of infieldFly. 
	 * 
	 * @param infieldFlyOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnInfieldFly infieldFlyOut) {
		return infieldFlyOut.getBatterOut().replaceFirst("IF",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Flyed. 
	 * 
	 * @param flyedOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnFlyed flyedOut) {
		return flyedOut.getBatterOut().replaceFirst("F",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Line. 
	 * 
	 * @param lineOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnLine lineOut) {
		return lineOut.getBatterOut().replaceFirst("L",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Popped. 
	 * 
	 * @param popupOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnPopped popupOut) {
		return popupOut.getBatterOut().replaceFirst("P",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Flyed Fall Ball. 
	 * 
	 * @param flyedOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnFlyedFallBall flyedOut) {
		return flyedOut.getBatterOut().replaceFirst("FF",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Popped Fall Ball. 
	 * 
	 * @param flyedOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnPoppedFallBall flyedOut) {
		return flyedOut.getBatterOut().replaceFirst("FP",""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Out On Grounded Ball. 
	 * 
	 * @param groundedOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterOutOnGroundedBall groundedOut) {
		return "" + groundedOut.getBatterOut(); //$NON-NLS-1$
	}

	/**
	 * Get defender position who participate to an out in case of Batter Advance On GDP With Fielder Choice. 
	 * 
	 * @param action code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getDefensivePosition(BatterAdvanceOnGdpWithFielderChoice action) {
		String choice = action.getBatterAdvance().replaceFirst("GDP",""); //$NON-NLS-1$ //$NON-NLS-2$
		if (choice.startsWith("O")) { //$NON-NLS-1$
			return "" + choice.charAt(1); //$NON-NLS-1$
		} else {
			return "" + choice.charAt(choice.length()-1); 			 //$NON-NLS-1$
		} 

	}

	/**
	 * Get defender position who participate to an out in case of Batter Out By Rule. 
	 * 
	 * @param outByRuleOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getOBRType(BatterOutByRule outByRuleOut) {
		return getOBRType(outByRuleOut.getBatterOut());
	}

	/**
	 * Get defender position who participate to an out in case of Runner Out By Rule. 
	 * 
	 * @param outByRuleOut code of the action
	 * @return defender position list who participate to the out
	 */
	public static String getOBRType(RunnerOutByRules outByRuleOut) {
		return getOBRType(outByRuleOut.getRunnerOut());
	}

	/**
	 * Retrieve the Action object which is a parent of the object.
	 * 
	 * @param obj children object of the action
	 * @return Action object, <b>null</b> if not found
	 */
	public static Action getActionFromObject(EObject obj) {
		if (obj instanceof Action) {
			return (Action) obj;
		} else {
			if (obj.eContainer() != null) {
				return getActionFromObject(obj.eContainer());
			} else {
				return null;
			}
		}
	}

	/**
	 * Check that the action is linked to a batter action
	 * 
	 * @param action code of the action
	 * @return <b>true</b> the action is linked to a batter action, <b>false</b> otherwise
	 */
	public static boolean isActionHasBatterEvent(Action action) {
		return action.getBatterAction() != null;
	}

	/**
	 * Get the OBR type.
	 * 
	 * @param ruleOut code of the action
	 * @return the OBR type
	 */
	public static String getOBRType(String ruleOut) {
		String action = ruleOut.replaceFirst("OBR",""); //$NON-NLS-1$ //$NON-NLS-2$
		String[] parts = action.split("-"); //$NON-NLS-1$
		String obrNumber = ""; //$NON-NLS-1$
		if (parts.length == 2) {
			obrNumber = parts[0];
		} else if (parts.length == 1) {
			obrNumber = "2"; //$NON-NLS-1$
		} else {
			obrNumber = "0"; //$NON-NLS-1$
		}
		return obrNumber;
	}

	/**
	 * Return a type of game
	 * 
	 * @param game Reference on the game
	 * @return <b>baseball</b>; <b>softball</b> or <b>null</b> if not found
	 */
	public static String getTypeOfGame(Game game) {
		return game.getDescription().getType();
	}

	/**
	 * get the line-up of a team in a game
	 * 
	 * @param game reference to the game
	 * @param team name of the team
	 * 
	 * @return the lineup of the team, <b>null</b> if not found
	 */
	public static LineUp getLineUp(Game game, String team) {
		LineUp lineupFound = null;
		for (LineUp lineup :game.getActions().getLineup()) {
			if (team.equals(lineup.getTeamType())) {
				lineupFound = lineup;
			}
		}

		return lineupFound;
	}

	/**
	 * Get the runner number in a current runner description
	 * 
	 * @param currentRunner current runner description 
	 * @return current runner number
	 */
	public static int getRunnerNumber(CurrentRunner currentRunner) {
		return Integer.parseInt(currentRunner.getRunner().replace("runner","")); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * return the list of possible player in a club for a category
	 * 
	 * @param file Reference the the IFIle which contains the game
	 * @param teamName Name of the team
	 * @param tournament name of the tournament
	 * @return List of possibles plyers
	 */
	public  static List<String> getPossiblePlayers(IFile file, String teamName, String tournament) {
		ClubDataParser clubDataParser = new ClubDataParser();
		return clubDataParser.getPlayersInTeam((IFolder)file.getParent().getParent()  ,teamName, tournament);
	}
	
	/**
	 * Find game object from an children object of the game
	 * 
	 * @param obj reference to the object included in a game
	 * @return reference to the game,<b>null</b> if not found
	 */
	public static Game getGame(EObject obj) {
		if (obj == null) {
			return null; 
        } else {			
			if (obj instanceof Game) {
				return (Game)obj; 
			} else {
				return getGame(obj.eContainer());
			}
		}
	} 
	
	/**
	 * Get the IFile reference from an EMF Resource
	 * 
	 * @param resource reference to the resource
	 * @return IFile reference
	 */
	public static IResource getIFileFromResource(Resource resource) {
	    if (resource != null) {
			URI eUri = resource.getURI();
			if (eUri.isPlatformResource()) {
				String platformString = eUri.toPlatformString(true);
			    return ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			}
		}
		return null;
	}

}
