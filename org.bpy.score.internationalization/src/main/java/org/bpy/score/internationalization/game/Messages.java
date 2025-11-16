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
package org.bpy.score.internationalization.game;


import org.eclipse.osgi.util.NLS;

/**
 * Make the internationalization for the Game plugin.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("all")
public class Messages extends NLS {
	
	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.game.messages"; //$NON-NLS-1$

	/** String for GameValidator class */
	public static String GameValidator_noAssistanceOnNonDecisiveError;
	/** String for GameValidator class */
	public static String GameValidator_badDateFormat;
	/** String for GameValidator class */
	public static String GameValidator_missingWinLoseSaveDescription;
	/** String for GameValidator class */
	public static String GameValidator_pitcherNotDefinedInRoster;
	/** String for GameValidator class */
	public static String GameValidator_runnerNotDefinedInRoster;
	/** String for GameValidator class */
	public static String GameValidator_batterNotDefinedInRoster;
	/** String for GameValidator class */
	public static String GameValidator_badHomerunLocation;
	/** String for GameValidator class */
	public static String GameValidator_upperCaseCodeForRunnerAdvanceNeeded;
	/** String for GameValidator class */
	public static String GameValidator_upperCaseCodeForBatterAdvanceNeeded;
	/** String for GameValidator class */
	public static String GameValidator_lowerCaseCodeForRunnerAdvanceNeeded;
	/** String for GameValidator class */
	public static String GameValidator_noAdvancePossibleOccupedBase;
	/** String for GameValidator class */
	public static String GameValidator_tooManyPutOut;
	/** String for GameValidator class */
	public static String GameValidator_missingDefensivePositions;
	/** String for GameValidator class */
	public static String GameValidator_badDefensivePositions;
	/** String for GameValidator class */
	public static String GameValidator_multiplePlayerInSameDefensivePositions;
	/** String for GameValidator class */
	public static String GameValidator_unknowCodeForDefensivePositions;
	/** String for GameValidator class */
	public static String GameValidator_clubDoesNotExist;
	/** String for GameValidator class */
	public static String GameValidator_teamDoesNotExist;
	/** String for GameValidator class */
	public static String GameValidator_nameSoouldStartWithCaptial;
	/** String for GameValidator class */
	public static String GameValidator_positionAfterTheMarble;
	/** String for GameValidator class */
	public static String GameValidator_noEarnedPointForPosition;

	/** String for LineupEntryValidator_invalidDefensivePosition class */
	public static String LineupEntryValidator_invalidDefensivePosition;
	/** String for LineupEntryValidator_invalidDefensivePosition class */
	public static String LineupEntryValidator_defensivePositionAlreadyDefined;
	
	/** String for ScoreGameAdvanceUtil class */
	public static String ScoreGameAdvanceUtil_AdvanceWithContinuation;
	/** String for ScoreGameAdvanceUtil class */
	public static String ScoreGameAdvanceUtil_BatterAdvance;
	/** String for ScoreGameAdvanceUtil class */
	public static String ScoreGameAdvanceUtil_RunnerAdvance;

	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_badDefenderNumber;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_infieldFlyMissingDefenderNumber;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_infieldFlySuspiciousDefenderNumber;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_FlyCatchSuspiciousDefenderNumber;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_badLastAssistDefenderNumber;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_invalidBatterBaseballObr;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_invalidRunnerBaseballObr;
	/** String for ScoreGameAdvanceUtil class */
	public static String BatterOutValidator_badBaseballObrCause;
	
	
	/** Game proposal provider message : Winner pitcher name*/ 
	public static String GameProposalProvider_WinnerPitecherIs;
	/** Game proposal provider message : Looser pitcher name*/ 
	public static String GameProposalProvider_LooserPitecherIs;
	/** Game proposal provider message : Saved pitcher name*/ 
	public static String GameProposalProvider_SavedPitecherIs;	
	/** Game proposal provider message : Visitor team*/ 
	public static String GameProposalProvider_Visitor_Team;
	/** Game proposal provider message : Hometeam team*/ 
	public static String GameProposalProvider_Hometeam_Team;
	/** Game proposal provider message : One runner advance*/ 
	public static String GameProposalProvider_OneRunnerAdvance;
	/** Game proposal provider message : Two runners advance*/ 
	public static String GameProposalProvider_TwoRunnersAdvance;
	/** Game proposal provider message : Three runners advance*/ 
	public static String GameProposalProvider_ThreeRunnersAdvance;
	/** Game proposal provider message : Insert a new action*/ 
	public static String GameProposalProvider_NewAction;
	/** Game proposal provider message : Select player */ 
	public static String GameProposalProvider_SelectPlayer;
	/** Game proposal provider message : New game creation */ 
	public static String GameProposalProvider_NewGameCreation;
	/** Game proposal provider message : Add player in roster */ 
	public static String GameProposalProvider_AddPlayerInRoster;
	/** Game proposal provider message : Full team in visitor roster */ 
	public static String GameProposalProvider_FullTeamInVisitorRoster;
	/** Game proposal provider message : Empty in visitor roster */ 
	public static String GameProposalProvider_EmptyTeamInVisitorRoster;
	/** Game proposal provider message : Full team in hometeam roster */ 
	public static String GameProposalProvider_FullTeamInHometeamRoster;
	/** Game proposal provider message : Empty in hometeam roster */ 
	public static String GameProposalProvider_EmptyTeamInHometeamRoster;
	/** Game proposal provider message : Add an umpire */ 
	public static String GameProposalProvider_AddUmpire;
	/** Game proposal provider message : Add an Score keeper */ 
	public static String GameProposalProvider_AddScoreKeeper;
	/** Game proposal provider message : Set championnat name */ 
	public static String GameProposalProvider_SetChampionatName;
	/** Game proposal provider message : Set category name */ 
	public static String GameProposalProvider_SetCategoryName;
	/** Game proposal provider message : All the team */ 
	public static String GameProposalProvider_AllTheTeam;
	/** Game proposal provider message : Insert a new inning */ 
	public static String GameProposalProvider_InsertNewInning;
	/** Game proposal provider message : Define line-ups */ 
	public static String GameProposalProvider_DefineLineUp;
	/** Game proposal provider message : Add player line-ups */ 
	public static String GameProposalProvider_AddPLayerInLineUp;
	/** Game proposal provider message : Current active Batter */ 
	public static String GameProposalProvider_CurrentActiveBatter;
	/** Game proposal provider message : Batter and  */ 
	public static String GameProposalProvider_BatterAnd;
	
	/** Game Outline Tree Provider: Roster Visitor String */
	public static String GameOutlineTreeProvider_RosterVisitor;
	/** Game Outline Tree Provider: Roster home team String */
	public static String GameOutlineTreeProvider_RosterHometeam;
	/** Game Outline Tree Provider: Game description */
	public static String GameOutlineTreeProvider_GameDescription;
	/** Game Outline Tree Provider: Line-up visitor */
	public static String GameOutlineTreeProvider_LineupVisitor;
	/** Game Outline Tree Provider: Line-up home team */
	public static String GameOutlineTreeProvider_LineupHometeam;
	/** Game Outline Tree Provider: Half inning visitor */
	public static String GameOutlineTreeProvider_HalfInningVisitor;
	/** Game Outline Tree Provider: Half inning home team */
	public static String GameOutlineTreeProvider_HalfInningHometeam;
	/** Game Outline Tree Provider: game resume */
	public static String GameOutlineTreeProvider_GameResume;
	
	
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
