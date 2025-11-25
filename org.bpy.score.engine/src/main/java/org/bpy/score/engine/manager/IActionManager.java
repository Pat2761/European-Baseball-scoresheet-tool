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

import org.bpy.score.engine.exception.OccupedbaseException;
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

/**
 * Interface which define all possible action done by a player
 * 
 * @author Patrick BRIAND
 *
 */
public interface IActionManager {

	/**
	 * Runner get more advance on a decisive obstruction action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	public void makeActionOn(RunnerAdvanceOnDecisiveObstruction moreAdvance) throws OccupedbaseException;
	
	/**
	 * Runner get more advance on a no decisive obstruction action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	public void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction moreAdvance) throws OccupedbaseException;
	
	/**
	 * Runner get more advance on a defensive choice action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	public void makeActionOn(RunnerAdvanceOnDefensiveChoice moreAdvance) throws OccupedbaseException;

	/**
	 * Runner get more advance on no decisive fly error action.
	 * 
	 * @param moreAdvance reference on the advance
	 * @throws OccupedbaseException
	 */
	public void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException;
	
	/**
	 * Manage a runner action of type Runner don't advance on error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnError action);
	
	/**
	 * Manage a runner action of type Runner don't advance on pick off error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnPickOffWithError action);


	/**
	 * Manage a runner action of type Runner don't advance on caught stealing with error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action);

	/**
	 * Manage a runner action of type Runner don't advance on throx error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnThrowError action);
	
	/**
	 * Manage a runner action of type Runner don't advance on receive error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnReceiveError action);

	/**
	 * Manage a runner action of type Runner don't advance on no decisive throw error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action);
	
	/**
	 * Manage a runner action of type Runner don't advance on non decisive received error action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action);

	/**
	 * Manage a runner action of type Runner advance on other player error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnOtherPlayerError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on rule action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnRule action) throws OccupedbaseException;
	
	/**
	 * Manage a runner action of type Runner advance on no decisive received error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on no decisive throw error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on receive error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on fielder choice action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnFielderChoice action) throws OccupedbaseException;
	
	/**
	 * Manage a runner action of type Runner advance on throw error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on indifference action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnIndiference action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on throw action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnThrow action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on occupied ball action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnOccupedBall action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on caught stealing with error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnCaughtStealingWithError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on pick off with error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on balk action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on pass ball action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on wild pitch action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on stolen base action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnStolenBase action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on error action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceOnError action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner advance on batter action.
	 * 
	 * @param action action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(RunnerAdvanceByBatterAction action) throws OccupedbaseException;

	/**
	 * Manage a runner action of type Runner out on appeal.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerOutOnAppeal action);

	/**
	 * Manage a runner action of type Runner out by rules.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerOutByRules action);

	/**
	 * Manage a runner action of type Runner out on fielder action.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerOutOnFielderAction action);

	/**
	 * Manage a runner action of type Runner out on pick off.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerOutOnPickOff action);

	/**
	 * Manage a runner action of type Runner out on caught stealing.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerOutOnCaugthStealing action);

	/**
	 * Manage a runner action of type Runner must be out on error.
	 * 
	 * @param action action reference to the action
	 */
	public void makeActionOn(RunnerMustBeOutOnError action);
	
	/**
	 * Manage Batter balk action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterBalk action);


	/**
	 * Manage Batter must be out on fly foul ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterMustOutOnFlyFoulBall action);

	/**
	 * Manage Batter advance on batter lost turn action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterLostTurn action);

	/**
	 * Manage Batter advance on indifference action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on defensive choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on occupied ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on strike with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on obstruction action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on catcher interference action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on sacrifice fly with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on sacrifice fly with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on sacrifice hit with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on sacrifice hit with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on strike with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on K Advance by rule action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnKAbr action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on K Wild pitch action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on K pass ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on hit by pitch action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on intentional base on ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on base on ball action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on inside park action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on home run action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on triple hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on double hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on single hit action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on Grounded double play with error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on Grounded double play with fielder choice action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on throw error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on received error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on fly error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException;

	/**
	 * Manage Batter advance on fly error action.
	 * 
	 * @param action reference to the action
	 * @throws OccupedbaseException 
	 */
	public void makeActionOn(BatterAdvanceOnPopError action) throws OccupedbaseException;

	/**
	 * Manage Batter out on infield fly action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnInfieldFly action);

	/**
	 * Manage Batter out on sacrifice hit action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnSacrificeHit action);

	/**
	 * Manage Batter out on sacrifice fly fall ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnSacrificeFlyFallBall action);

	/**
	 * Manage Batter out on sacrifice fly ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnSacrificeFly action);

	/**
	 * Manage Batter out on grounded double play action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnGroundedDoublePlay action);

	/**
	 * Manage Batter out on batter out by appeal ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnAppeal action);

	/**
	 * Manage Batter out on batter out by rules ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutByRule action);

	/**
	 * Manage Batter out on grounded ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnGroundedBall action);

	/**
	 * Manage Batter out On line fall ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnLineDriveFallBall action);

	/**
	 * Manage Batter out On Popup fall ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnPoppedFallBall action);

	/**
	 * Manage Batter out On Flyed fall ball action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnFlyedFallBall action);

	/**
	 * Manage Batter out On Popup action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnPopped action);

	/**
	 * Manage Batter out On Line action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnLine action);

	/**
	 * Manage Batter out On fly action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnFlyed action);

	/**
	 * Manage Batter out On release strike action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnReleasedStrike action);

	/**
	 * Manage Batter out On look strike action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnLookedStrike action);

	/**
	 * Manage Batter out On Swing strike action.
	 * 
	 * @param action reference to the action
	 */
	public void makeActionOn(BatterOutOnSwingedStrike action);

}
