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
package org.bpy.score.internationalization.reports;


import org.eclipse.osgi.util.NLS;

/**
 * Make the internationalization for the graphics plugin.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("all")
public class Messages extends NLS {
	
	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.reports.messages"; //$NON-NLS-1$

	// ###################################################################"
	// defensives positions 
	// ###################################################################"
	/** Pitcher defensive position */
	public static String PlayByPlayManager_PitcherDefensiveLocation;
	/** Catcher defensive position */
	public static String PlayByPlayManager_CatcherDefensiveLocation;
	/** First base defensive position */
	public static String PlayByPlayManager_FirstBaseDefensiveLocation;
	/** Second base defensive position */
	public static String PlayByPlayManager_SecondBaseDefensiveLocation;
	/** third base defensive position */
	public static String PlayByPlayManager_ThirdBaseDefensiveLocation;
	/** short stop defensive position */
	public static String PlayByPlayManager_ShortStopDefensiveLocation;
	/** left field defensive position */
	public static String PlayByPlayManager_LeftFieldDefensiveLocation;
	/** center field defensive position */
	public static String PlayByPlayManager_CenterFieldDefensiveLocation;
	/** Right field defensive position */
	public static String PlayByPlayManager_RightFieldDefensiveLocation;
	/** Unknown defensive position */
	public static String PlayByPlayManager_UnknownDefensiveLocation;
	
	// ###################################################################
	// Hit location 
	// ###################################################################
	/** pitcher hit position */
	public static String PlayByPlayManager_PitcherHitLocation;
	/** catcher hit position */
	public static String PlayByPlayManager_CatcherHitLocation;
	/** first base hit position */
	public static String PlayByPlayManager_FirstHitLocation;
	/** second base hit position */
	public static String PlayByPlayManager_SecondHitLocation;
	/** third base hit position */
	public static String PlayByPlayManager_ThirdHitLocation;
	/** short stop hit position */
	public static String PlayByPlayManager_ShortStopHitLocation;
	/** left field hit position */
	public static String PlayByPlayManager_LeftFieldHitLocation;
	/** center field hit position */
	public static String PlayByPlayManager_CenterFieldHitLocation;
	/** Right field hit position */
	public static String PlayByPlayManager_RightHitLocation;
	/** down left line hit ;position */
	public static String PlayByPlayManager_LLHitLocation;
	/** through left line hit position */
	public static String PlayByPlayManager_LSHitLocation;
	/** left center hit position */
	public static String PlayByPlayManager_LCHitLocation;
	/** up the middle hit position */
	public static String PlayByPlayManager_MIHitLocation;
	/** Right center hit position */
	public static String PlayByPlayManager_RCHitLocation;
	/** Right side hit position */
	public static String PlayByPlayManager_RSHitLocation;
	/** Right side hit position */
	public static String PlayByPlayManager_RLHitLocation;
	/** Unknown hit position */
	public static String PlayByPlayManager_UnknownHitLocation;
	
	
	
	// ###################################################################
	// Base win 
	// ###################################################################
	/** First v*base win */
	public static String PlayByPlayManager_FirstBaseWin;
	/** Second base win */
	public static String PlayByPlayManager_SecondBaseWin;
	/** Third base win */
	public static String PlayByPlayManager_ThirdBaseWin;
	/** marble base win */
	public static String PlayByPlayManager_ForthBaseWin;

	
	
	
	
	/** keyword pitcher position */
	public static String PlayByPlayManager_Pitcher;
	/** keyword catcher position */
	public static String PlayByPlayManager_Catcher;
	/** keyword First Base position */
	public static String PlayByPlayManager_FirstBase;
	/** keyword Second Base position */
	public static String PlayByPlayManager_SecondBase;
	/** keyword Third Base position */
	public static String PlayByPlayManager_ThirdBase;
	/** keyword Short stop position */
	public static String PlayByPlayManager_ShortStop;
	/** keyword left field */
	public static String PlayByPlayManager_LeftField;
	/** keyword center field */
	public static String PlayByPlayManager_CenterField;
	/** keyword Right field */
	public static String PlayByPlayManager_RightField;
	/** keyword Designated hitter */
	public static String PlayByPlayManager_DesignatedHitter;
	/** keyword Pitch hitter */
	public static String PlayByPlayManager_PitchHitter;
	/** keyword Pitch runner */
	public static String PlayByPlayManager_PitchRunner;
	/** Visitor */
	public static String PlayByPlayManager_Visitor;
	/** Hometeam */
	public static String PlayByPlayManager_Hometeam;
	/** Header */
	public static String PlayByPlayManager_Header;
	/** inning resume */
	public static String PlayByPlayManager_Resume;
	/** keyword Forfeit game */
	public static String ScoreSheetEngine_ForfeitGame;
	
	/** keyword bunt */
	public static String ScoreSheetEngine_bunt;
	
	// ###################################################################
	// Action description 
	// ###################################################################
	
	/** Runner Advance On No Decisive Obstruction */ 
	public static String PlayByPlayManager_RunnerAdvanceOnNoDecisiveObstruction;
	/** Runner Advance On No Decisive Obstruction */ 
	public static String PlayByPlayManager_RunnerScoreOnNoDecisiveObstruction;
	/** Runner Advance On No Decisive Obstruction */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNoDecisiveObstruction;
	/** Runner Advance On No Decisive Obstruction */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnNoDecisiveObstruction;
	
	/** Runner Advance On Defensive Choice */
	public static String PlayByPlayManager_RunnerScoreOnDefensiveChoice;
	/** Runner Advance On Defensive Choice */
	public static String PlayByPlayManager_RunnerAdvanceOnDefensiveChoice;
	/** Runner Advance On Defensive Choice */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnDefensiveChoice;
	/** Runner Advance On Defensive Choice */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnDefensiveChoice;
	
	
	/** Runner Advance On Non Decisive Fly Error */
	public static String PlayByPlayManager_RunnerAdvanceOnNonDecisiveFlyError;
	/** Runner Advance On Non Decisive Fly Error */
	public static String PlayByPlayManager_RunnerScoreOnNonDecisiveFlyError;
	/** Runner Advance On Non Decisive Fly Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveFlyError;
	/** Runner Advance On Non Decisive Fly Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveFlyError;

	/** Runner Dont Advance On Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnError;
		
	/** Runner Dont Advance On Pick Off With Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnPickOffWithError;
	/** Runner Dont Advance On Caught Stealing With Error */ 
	public static String PlayByPlayManager_RunnerDontAdvanceOnCaughtStealingWithError;
	/** Runner Dont Advance On Throw Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnThrowError;
	/** Runner Dont Advance On Receive Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnReceiveError;
	/** Runner Dont Advance On Non Decisive Throw Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnNonDecisiveThrowError;
	/** Runner Dont Advance On Non Decisive Receive Error */
	public static String PlayByPlayManager_RunnerDontAdvanceOnNonDecisiveReceiveError;

	/**Runner Advance On Other Player Error */
	public static String PlayByPlayManager_RunnerAdvanceOnOtherPlayerError;
	/**Runner Advance On Other Player Error */
	public static String PlayByPlayManager_RunnerScoreOnOtherPlayerError;
	/**Runner Advance On Other Player Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnOtherPlayerError;
	/**Runner Advance On Other Player Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnOtherPlayerError;
	
	/** Runner Advance On Non Decisive Receive Error */
	public static String PlayByPlayManager_RunnerAdvanceOnNonDecisiveReceiveError;
	/** Runner Advance On Non Decisive Receive Error */
	public static String PlayByPlayManager_RunnerScoreOnNonDecisiveReceiveError;
	/** Runner Advance On Non Decisive Receive Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveReceiveError;
	/** Runner Advance On Non Decisive Receive Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveReceiveError;
	
	/** Runner Advance On Non Decisive Throw Error */ 
	public static String PlayByPlayManager_RunnerAdvanceOnNonDecisiveThrowError;
	/** Runner Advance On Non Decisive Throw Error */ 
	public static String PlayByPlayManager_RunnerScoreOnNonDecisiveThrowError;
	/** Runner Advance On Non Decisive Throw Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnNonDecisiveThrowError;
	/** Runner Advance On Non Decisive Throw Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnNonDecisiveThrowError;
	
	/** Runner Advance On Receive Error */ 
	public static String PlayByPlayManager_RunnerAdvanceOnReceiveError;
	/** Runner Advance On Receive Error */ 
	public static String PlayByPlayManager_RunnerScoreOnReceiveError;
	/** Runner Advance On Receive Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnReceiveError;
	/** Runner Advance On Receive Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnReceiveError;
	
	/** Runner Advance On Throw Error */ 
	public static String PlayByPlayManager_RunnerAdvanceOnThrowError;
	/** Runner Advance On Throw Error */ 
	public static String PlayByPlayManager_RunnerScoreOnThrowError;
	/** Runner Advance On Throw Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnThrowError;
	/** Runner Advance On Throw Error */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnThrowError;
	
	/** Runner Advance On Indifference */
	public static String PlayByPlayManager_RunnerAdvanceOnIndiference;
	/** Runner Advance On Indifference */
	public static String PlayByPlayManager_RunnerScoreOnIndiference;
	/** Runner Advance On Indifference */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnIndiference;
	/** Runner Advance On Indifference */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnIndiference;
	
	/** Runner Advance On Throw */ 
	public static String PlayByPlayManager_RunnerAdvanceOnThrow;
	/** Runner Advance On Throw */ 
	public static String PlayByPlayManager_RunnerScoreOnThrow;
	/** Runner Advance On Throw */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnThrow;
	/** Runner Advance On Throw */ 
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnThrow;

	/** Runner Advance On Occuped Ball */
	public static String PlayByPlayManager_RunnerAdvanceOnOccupedBall;
	/** Runner Advance On Occuped Ball */
	public static String PlayByPlayManager_RunnerScoreOnOccupedBall;
	/** Runner Advance On Occuped Ball */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnOccupedBall;
	/** Runner Advance On Occuped Ball */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnOccupedBall;

	/** Runner Advance On Caught Stealing With Error */
	public static String PlayByPlayManager_RunnerAdvanceOnCaughtStealingWithErrorWithoutAssitance;
	/** Runner Advance On Caught Stealing With Error */
	public static String PlayByPlayManager_RunnerAdvanceOnCaughtStealingWithErrorWithAssitance;
	/** Runner Advance On Caught Stealing With Error */
	public static String PlayByPlayManager_RunnerScoreOnCaughtStealingWithErrorWithoutAssitance;
	/** Runner Advance On Caught Stealing With Error */
	public static String PlayByPlayManager_RunnerScoreOnCaughtStealingWithErrorWithAssitance;
	
	/** Runner Advance On PickOf fWith Error */
	public static String PlayByPlayManager_RunnerAdvanceOnPickOffWithError;
	/** Runner Advance On PickOf fWith Error */
	public static String PlayByPlayManager_RunnerScoreOnPickOffWithError;
	
	/** Runner Advance On Balk */
	public static String PlayByPlayManager_RunnerAdvanceOnBalk;
	/** Runner Advance On Balk */
	public static String PlayByPlayManager_RunnerScoreOnBalk;
	/** Runner Advance On Balk */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnBalk;
	/** Runner Advance On Balk */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnBalk;
	
	/** Runner Advance On Pass Ball */
	public static String PlayByPlayManager_RunnerAdvanceOnPassBall;
	/** Runner Advance On Pass Ball */
	public static String PlayByPlayManager_RunnerScoreOnPassBall;
	/** Runner Advance On Pass Ball */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnPassBall;
	/** Runner Advance On Pass Ball */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnPassBall;

	/** Runner Advance On Wild Pitch */
	public static String PlayByPlayManager_RunnerAdvanceOnWildPitch;
	/** Runner Advance On Wild Pitch */
	public static String PlayByPlayManager_RunnerScoreOnWildPitch;
	/** Runner Advance On Wild Pitch */
	public static String PlayByPlayManager_MoreAdvanceAdvanceOnWildPitch;
	/** Runner Advance On Wild Pitch */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnWildPitch;

	/** Runner Advance On Stolen Base */
	public static String PlayByPlayManager_RunnerAdvanceOnStolenBase;
	/** Runner Advance On Stolen Base */
	public static String PlayByPlayManager_RunnerScoreOnStolenBase;
	/** Runner Advance On Stolen Base */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnStolenBase;
	/** Runner Advance On Stolen Base */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnStolenBase;

	/** Runner Advance On Error */
	public static String PlayByPlayManager_RunnerAdvanceOnError;
	/** Runner Advance On Error */
	public static String PlayByPlayManager_RunnerScoreOnError;
	/** Runner Advance On Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnError;
	/** Runner Advance On Error */
	public static String PlayByPlayManager_MoreAdvanceRunnerScoreOnError;
	
	/** Runner Advance By Batter Action */
	public static String PlayByPlayManager_RunnerAdvanceByBatterActionScore;
	/** Runner Advance By Batter Action */
	public static String PlayByPlayManager_RunnerAdvanceByBatterActionDontScore;
	
	/** Runner Advance On Decisive Obstruction */
	public static String PlayByPlayManager_RunnerAdvanceOnDecisiveObstruction;
	/** Runner Advance On Decisive Obstruction */
	public static String PlayByPlayManager_RunnerScoreOnDecisiveObstruction;
	/** Runner Advance On Decisive Obstruction */
	public static String PlayByPlayManager_MoreAdavnceRunnerAdvanceOnDecisiveObstruction;
	/** Runner Advance On Decisive Obstruction */
	public static String PlayByPlayManager_MoreAedvanceRunnerScoreOnDecisiveObstruction;

	/** Runner Advance On Fielder Choice */
	public static String PlayByPlayManager_RunnerScoreOnFielderChoice;
	/** Runner Advance On Fielder Choice */
	public static String PlayByPlayManager_RunnerAdvanceOnFielderChoice;
	/** Runner Advance On Fielder Choice */
	public static String PlayByPlayManager_MoreAdavanceRunnerScoreOnFielderChoice;
	/** Runner Advance On Fielder Choice */
	public static String PlayByPlayManager_MoreAdvanceRunnerAdvanceOnFielderChoice;
	
	/** Runner Out On Appeal */
	public static String PlayByPlayManager_RunnerOutOnAppealWithoutAssists;
	/** Runner Out On Appeal */
	public static String PlayByPlayManager_RunnerOutOnAppealWithAssists;
	/** Runner Out On Appeal */
	public static String PlayByPlayManager_MoreAdvanceRunnerOutOnAppealWithoutAssists;
	/** Runner Out On Appeal */
	public static String PlayByPlayManager_MoreAdvanceRunnerOutOnAppealWithAssists;
	
	/** Unkonw Out By Rule */
	public static String PlayByPlayManager_UnkonwOutByRule;
	/** Out By Rule 1 */
	public static String PlayByPlayManager_OutByRule1;
	/** Out By Rule 2 */
	public static String PlayByPlayManager_OutByRule2;
	/** Out By Rule 3 */
	public static String PlayByPlayManager_OutByRule3;
	/** Out By Rule 4 */
	public static String PlayByPlayManager_OutByRule4;
	/** Out By Rule 5 */
	public static String PlayByPlayManager_OutByRule5;
	/** Out By Rule 6 */
	public static String PlayByPlayManager_OutByRule6;
	/** Out By Rule 7 */
	public static String PlayByPlayManager_OutByRule7;
	/** Out By Rule 8 */
	public static String PlayByPlayManager_OutByRule8;
	/** Out By Rule 9 */
	public static String PlayByPlayManager_OutByRule9;
	/** Out By Rule 9 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule9;
	/** Out By Rule 10 */
	public static String PlayByPlayManager_OutByRule10;
	/** Out By Rule 10 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule10;
	/** Out By Rule 11 */
	public static String PlayByPlayManager_OutByRule11;
	/** Out By Rule 11 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule11;
	/** Out By Rule 12 */
	public static String PlayByPlayManager_OutByRule12;
	/** Out By Rule 12 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule12;
	/** Out By Rule 13 */
	public static String PlayByPlayManager_OutByRule13;
	/** Out By Rule 13 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule13;
	/** Out By Rule 14 */
	public static String PlayByPlayManager_OutByRule14;
	/** Out By Rule 14 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule14;
	/** Out By Rule 15 */
	public static String PlayByPlayManager_OutByRule15;
	/** Out By Rule 15 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule15;
	/** Out By Rule 16 */
	public static String PlayByPlayManager_OutByRule16;
	/** Out By Rule 16 */
	public static String PlayByPlayManager_MoreAdvanceOutByRule16;

	/** Runner Out On Fielder Action */
	public static String PlayByPlayManager_RunnerOutOnFielderActionWithoutAssists;
	/** Runner Out On Fielder Action */
	public static String PlayByPlayManager_RunnerOutOnFielderActionWithAssists;
	/** Runner Out On Fielder Action */
	public static String PlayByPlayManager_MoreAdvanceRunnerOutOnFielderActionWithoutAssists;
	/** Runner Out On Fielder Action */
	public static String PlayByPlayManager_MoreAdvanceRunnerOutOnFielderActionWithAssists;
	
	/** Runner Out On Pick Off */ 
	public static String PlayByPlayManager_RunnerOutOnPickOffWithoutAssist;
	/** Runner Out On Pick Off */ 
	public static String PlayByPlayManager_RunnerOutOnPickOffWithAssist;

	/** Runner Out On Caugth Stealing */ 
	public static String PlayByPlayManager_RunnerOutOnCaugthStealingWithoutAssists;
	/** Runner Out On Caugth Stealing */ 
	public static String PlayByPlayManager_RunnerOutOnCaugthStealingWithAssists;
	
	/** Runner Must Be Out On Error */ 
	public static String PlayByPlayManager_RunnerMustBeOutOnError;
	/** Batter Balk */
	public static String PlayByPlayManager_BatterBalk;
	/** Batter Must Out On Fly Foul Ball */
	public static String PlayByPlayManager_BatterMustOutOnFlyFoulBall;
	/** Batter Lost Turn */
	public static String PlayByPlayManager_BatterLostTurn;
	
	/** Batter Advance On Defensive Choice */
	public static String PlayByPlayManager_BatterAdvanceOnDefensiveChoiceWithoutAssists;
	/** Batter Advance On Defensive Choice */
	public static String PlayByPlayManager_BatterAdvanceOnDefensiveChoiceWithAsists;
	
	/** Batter Advance On Indiference */
	public static String PlayByPlayManager_BatterAdvanceOnIndiference;
	
	/** Batter Advance On Occuped Ball */
	public static String PlayByPlayManager_BatterAdvanceOnOccupedBall;
	
	/** Batter Advance On K With Fielder Choice */
	public static String PlayByPlayManager_BatterAdvanceOnKWithFielderChoice;
	
	/** Batter Advance On Obstruction */
	public static String PlayByPlayManager_BatterAdvanceOnObstruction;
	
	/** Batter Advance On Catcher Interference */
	public static String PlayByPlayManager_BatterAdvanceOnCatcherInterference;
	
	/** Batter Advance On Sacrifice Fly With Fielder Choice */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithFielderChoice;
	
	/** Batter Advance On Sacrifice Fly With Error */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithErrorWithoutAssists;
	/** Batter Advance On Sacrifice Fly With Error */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeFlyWithErrorWithAssists;
	/** Batter Advance On Sacrifice Fly With Error */
	public static String PlayByPlayManager_BatterScoreOnSacrificeFlyWithErrorWithoutAssists;
	/** Batter Advance On Sacrifice Fly With Error */
	public static String PlayByPlayManager_BatterScoreOnSacrificeFlyWithErrorWithAssists;

	/** Batter Advance On Sacrifice Hit With Fielder Choice */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeHitWithFielderChoice;
	
	/** Batter Advance On Sacrifice Hit With Error */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeHitWithErrorWithoutAssist;
	/** Batter Advance On Sacrifice Hit With Error */
	public static String PlayByPlayManager_BatterAdvanceOnSacrificeHitWithErrorWithAssist;
	/** Batter Advance On Sacrifice Hit With Error */
	public static String PlayByPlayManager_BatterScoreOnSacrificeHitWithErrorWithoutAssist;
	/** Batter Advance On Sacrifice Hit With Error */
	public static String PlayByPlayManager_BatterscoreOnSacrificeHitWithErrorWithAssist;
	
	/** Batter Advance On K With Error */
	public static String PlayByPlayManager_BatterAdvanceOnKWithErrorWithoutAssists;
	/** Batter Advance On K With Error */
	public static String PlayByPlayManager_BatterAdvanceOnKWithErrorWithAssists;
	/** Batter Advance On K With Error */
	public static String PlayByPlayManager_BatterScoreOnKWithErrorWithoutAssists;
	/** Batter Advance On K With Error */
	public static String PlayByPlayManager_BatterScoreOnKWithErrorWithAssists;
	
	/** Batter Advance On K Wild Pitch */ 
	public static String PlayByPlayManager_BatterAdvanceOnKWildPitch;
	/** Batter Advance On K Wild Pitch */ 
	public static String PlayByPlayManager_BatterScoreOnKWildPitch;
	
	/** Batter Advance On K Pass Ball */
	public static String PlayByPlayManager_BatterAdvanceOnKPassBall;
	/** Batter Advance On K Pass Ball */
	public static String PlayByPlayManager_BatterScoreOnKPassBall;
	
	/** Batter Advance On Hit By Pitch */
	public static String PlayByPlayManager_BatterAdvanceOnHitByPitch;
	
	/** Batter Advance On Intentional Base On Ball */
	public static String PlayByPlayManager_BatterAdvanceOnIntentionalBaseOnBall;
	
	/** Batter Advance On Base On Ball */
	public static String PlayByPlayManager_BatterAdvanceOnBaseOnBall;
	
	/** Batter Advance On Inside Park */
	public static String PlayByPlayManager_BatterAdvanceOnInsidePark;
	
	/** Batter Advance On Home Run */
	public static String PlayByPlayManager_BatterAdvanceOnHomeRun;
	
	/** Batter Advance On Triple Hit */
	public static String PlayByPlayManager_BatterAdvanceOnTripleHit;
	
	/** Batter Advance On Double Hit */
	public static String PlayByPlayManager_BatterAdvanceOnDoubleHit;
	
	/** Batter Advance On Single Hit */
	public static String PlayByPlayManager_BatterAdvanceOnSingleHit;
	
	/** Batter Advance On Gdp With Error */
	public static String PlayByPlayManager_BatterAdvanceOnGdpWithErrorWithoutAssist;
	/** Batter Advance On Gdp With Error */
	public static String PlayByPlayManager_BatterAdvanceOnGdpWithErrorWithAssist;
	
	/** Batter Advance On Gdp With Fielder Choice */
	public static String PlayByPlayManager_BatterAdvanceOnGdpWithFielderChoice;
	/** Batter Advance On Gdp With Fielder Choice */
	public static String PlayByPlayManager_BatterScoreOnGdpWithFielderChoice;
	
	/** Batter Advance On Throw Error */
	public static String PlayByPlayManager_BatterScoreOnThrowErrorWithoutAssists;
	/** Batter Advance On Throw Error */
	public static String PlayByPlayManager_BatterScoreOnThrowErrorWithAssists;
	/** Batter Advance On Throw Error */
	public static String PlayByPlayManager_BatterAdvanceOnThrowErrorWithoutAssists;
	/** Batter Advance On Throw Error */
	public static String PlayByPlayManager_BatterAdvanceOnThrowErrorWithAssists;
	
	/** Batter Advance On Receive Error */
	public static String PlayByPlayManager_BatterScoreOnReceiveErrorWithoutAssist;
	/** Batter Advance On Receive Error */
	public static String PlayByPlayManager_BatterScoreOnReceiveErrorWithAssist;
	/** Batter Advance On Receive Error */
	public static String PlayByPlayManager_BatterAdvanceOnReceiveErrorWithoutAssist;
	/** Batter Advance On Receive Error */
	public static String PlayByPlayManager_BatterAdvanceOnReceiveErrorWithAssist;
	
	/** Batter Advance On Fly Error */
	public static String PlayByPlayManager_BatterAdvanceOnFlyError;
	/** Batter Advance On Fly Error */
	public static String PlayByPlayManager_BatterScoreOnFlyError;
	
	/** Batter Advance On Pop Error */
	public static String PlayByPlayManager_BatterAdvanceOnPopError;
	/** Batter Advance On Pop Error */
	public static String PlayByPlayManager_BatterScoreOnPopError;
	
	/** Batter Out On Infield Fly */
	public static String PlayByPlayManager_BatterOutOnInfieldFly;
	
	/** Batter Out On Sacrifice Hit */
	public static String PlayByPlayManager_BatterOutOnSacrificeHitWhitoutAssist;
	/** Batter Out On Sacrifice Hit */
	public static String PlayByPlayManager_BatterOutOnSacrificeHitWhitAssists;
	
	/** Batter Out On Sacrifice Fly Fall Ball */
	public static String PlayByPlayManager_BatterOutOnSacrificeFlyFallBallWhitoutAssist;
	/** Batter Out On Sacrifice Fly Fall Ball */
	public static String PlayByPlayManager_BatterOutOnSacrificeFlyFallBallWhitAssists;
	
	/** Batter Out On Sacrifice Fly */
	public static String PlayByPlayManager_BatterOutOnSacrificeFlyWithoutAssists;
	/** Batter Out On Sacrifice Fly */
	public static String PlayByPlayManager_BatterOutOnSacrificeFlyWithAssists;
	
	/** Batter Out On Grounded Double Play */
	public static String PlayByPlayManager_BatterOutOnGroundedDoublePlayWithoutAssists;
	/** Batter Out On Grounded Double Play */
	public static String PlayByPlayManager_BatterOutOnGroundedDoublePlayWithAssists;
	
	/** Batter Out On Appeal */
	public static String PlayByPlayManager_BatterOutOnAppealWithoutAssists;
	/** Batter Out On Appeal */
	public static String PlayByPlayManager_BatterOutOnAppealWithAssists;
	/** Batter Out On Grounded Ball */
	
	public static String PlayByPlayManager_BatterOutOnGroundedBallWithoutAssists;
	/** Batter Out On Grounded Ball */
	public static String PlayByPlayManager_BatterOutOnGroundedBallWithAssists;
	
	/** Batter Out On Line Drive Fall Ball */
	public static String PlayByPlayManager_BatterOutOnLineDriveFallBallWithoutAssist;
	/** Batter Out On Line Drive Fall Ball */
	public static String PlayByPlayManager_BatterOutOnLineDriveFallBallWithAssist;
	
	/** Batter Out On Popped Fall Ball */
	public static String PlayByPlayManager_BatterOutOnPoppedFallBallWithoutAssist;
	/** Batter Out On Popped Fall Ball */
	public static String PlayByPlayManager_BatterOutOnPoppedFallBallWithAssist;
	
	/** Batter Out On Flyed Fall Ball */
	public static String PlayByPlayManager_BatterOutOnFlyedFallBallWithoutAssist;
	/** Batter Out On Flyed Fall Ball */
	public static String PlayByPlayManager_BatterOutOnFlyedFallBallWithAssist;
	
	/** Batter Out On Popped */
	public static String PlayByPlayManager_BatterOutOnPoppedWithoutAssist;
	/** Batter Out On Popped */
	public static String PlayByPlayManager_BatterOutOnPoppedWithAssist;
	
	/** Batter Out On Line */
	public static String PlayByPlayManager_BatterOutOnLineWithoutAssist;
	/** Batter Out On Line */
	public static String PlayByPlayManager_BatterOutOnLineWithAssist;
	
	/** Batter Out On Flyed */
	public static String PlayByPlayManager_BatterOutOnFlyedWithoutAssist;
	/** Batter Out On Flyed */
	public static String PlayByPlayManager_BatterOutOnFlyedWithAssist;
	
	/** Batter Out On Released Strike */
	public static String PlayByPlayManager_BatterOutOnReleasedStrikeWithoutAssist;
	/** Batter Out On Released Strike */
	public static String PlayByPlayManager_BatterOutOnReleasedStrikeWithAssist;
	
	/** Batter Out On Looked Strike */
	public static String PlayByPlayManager_BatterOutOnLookedStrike;

	/** Batter Out On Swinged Strike */
	public static String PlayByPlayManager_BatterOutOnSwingedStrike;
	
	/** Main title for a substitution */
	public static String PlayByPlayManager_TeamSubstitution;
	/** Move to substitution */
	public static String PlayByPlayManager_TeamMoveToSubstitution;
	/** Move to substitution */
	public static String PlayByPlayManager_TeamReplaceSubstitutionPlaceToPlace;
	/** Move to substitution */
	public static String PlayByPlayManager_TeamReplaceSubstitutionNewDefensivePosition;
	
	/** Home team name */
	public static String PlayByPlayManager_HomeTeamName;
	/** Visitor team name */
	public static String PlayByPlayManager_VisitorName;
	
	/** GameReportGenerator class */
	/** Game Report Generator : Job report generation */
	public static String GameReportGenerator_JobReportGeneration;
	/** Game Report Generator : Reports generation */
	public static String GameReportGenerator_ReportsGeneration;
	/** Game Report Generator : Report generation */
	public static String GameReportGenerator_ReportGeneration;
	/** Game Report Generator : Error Report generation */
	public static String GameReportGenerator_ErrorReportGeneration;
	/** Game Report Generator : task message */
	public static String GameReportGenerator_TaskMessage;

	// ###################################################################
	// Class GameReportGeneratorProcess 
	// ###################################################################
	// Task Action message
	public static String GameReportGeneratorProcess_GenerateInformation;
	// Copy banner file message
	public static String GameReportGeneratorProcess_CopyBannerFileMessage;
	// Copy XSLT file message
	public static String GameReportGeneratorProcess_CopyXSLTFileMessage;
	// Copy CSS file message
	public static String GameReportGeneratorProcess_CopyCSSFileMessage;

	
	/**
	 * Initialize the internationalization
	 */
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	/**
	 * Constructor of the class
	 */
	private Messages() {
	}
}
