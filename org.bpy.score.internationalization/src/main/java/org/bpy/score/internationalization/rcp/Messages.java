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
package org.bpy.score.internationalization.rcp;


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
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.rcp.messages"; //$NON-NLS-1$

	/*----------------------------------------------------------------------- */
	/* GameMultipageEditor class                                              */
	/*----------------------------------------------------------------------- */
	/** Error while opening the game editor */
	public static String GameMultipageEditor_ErrorOpenEditor;

	/*----------------------------------------------------------------------- */
	/* NewChampionatWizardPage class                                          */
	/*----------------------------------------------------------------------- */
	/** New tournament title wizard */
	public static String NewChampionatWizardPage_NewTournamentWizardPageTitle;
	/** New tournament title description */
	public static String NewChampionatWizardPage_NewTournamentWizardPageDescription;
	/** New tournament name Label */
	public static String NewChampionatWizardPage_NameOfNewtournament;
	/** New tournament add new season */
	public static String NewChampionatWizardPage_AddSeason;
	/** Blank tournament name error */
	public static String NewChampionatWizardPage_BlanckTournamentNameError;
	/** Tournament duplicate name error */
	public static String NewChampionatWizardPage_TournamentAlreadyExistError;
	
	/*----------------------------------------------------------------------- */
	/* NewGamePageOneWizard class                                             */
	/*----------------------------------------------------------------------- */
	/** New Game Page One Wizard : Wizard message */ 
	public static String NewGamePageOneWizard_PageOneMessage;
	/** New Game Page One Wizard : Wizard title */ 
	public static String NewGamePageOneWizard_PageOneTitle;
	/** New Game Page One Wizard : Wizard description */ 
	public static String NewGamePageOneWizard_PageOneDescription;
	/** New Game Page One Wizard : Game name */ 
	public static String NewGamePageOneWizard_GameName;
	/** New Game Page One Wizard : Stadium name */ 
	public static String NewGamePageOneWizard_StadiumName;
	/** New Game Page One Wizard : Starting time */ 
	public static String NewGamePageOneWizard_StartTime;
	/** New Game Page One Wizard : End time */ 
	public static String NewGamePageOneWizard_EndTime;
	/** New Game Page One Wizard : Town */ 
	public static String NewGamePageOneWizard_TownLocation;
	/** New Game Page One Wizard : Game duration */ 
	public static String NewGamePageOneWizard_GameDuration;
	/** New Game Page One Wizard : Type of game */ 
	public static String NewGamePageOneWizard_GameType;
	/** New Game Page One Wizard : Home team name */ 
	public static String NewGamePageOneWizard_HomeTeamName;
	/** New Game Page One Wizard : Visitor team name */ 
	public static String NewGamePageOneWizard_VisitorTeamName;
	/** New Game Page One Wizard : Category */ 
	public static String NewGamePageOneWizard_Category;
	/** New Game Page One Wizard : All players in roster */ 
	public static String NewGamePageOneWizard_AllPlayersInRoster;
	/** New Game Page One Wizard Error : Game name can't be empty */ 
	public static String NewGamePageOneWizard_EmptyGameNameError;
	/** New Game Page One Wizard Error : Game name already defined */ 
	public static String NewGamePageOneWizard_DuplicateGameNameError;
	/** New Game Page One Wizard Error : Game name already defined in category */ 
	public static String NewGamePageOneWizard_DuplicateGameNameInCategoryError;
	/** New Game Page One Wizard Error : Stadium name can't be empty */ 
	public static String NewGamePageOneWizard_EmptyStadiumNameError;
	/** New Game Page One Wizard Error : Town name can't be empty */ 
	public static String NewGamePageOneWizard_EmptyTownNameError;
	/** New Game Page One Wizard Error : Teams not selected error */ 
	public static String NewGamePageOneWizard_MissingTeamSelectionError;
	/** New Game Page One Wizard Error : Duplicate Team selection error */ 
	public static String NewGamePageOneWizard_DuplicateTeamSelectionError;
	/** New Game Page One Wizard Error : Duplicate Team selection error */ 
	public static String NewGamePageOneWizard_EmptyCategoryFileError;
	/** New Game Page One Wizard UI : Text for date label */ 
	public static String NewGamePageOneWizard_DateLabel;
	
	
	/** Dialog title for select a relative path (message)*/ 
	public static String GameReportWizardPageOne_DialogRelativePath_Title;
	/** Dialog error 1 for select a relative path */ 
	public static String GameReportWizardPageOne_DialogError1_Title;
	/** Dialog error 2 for select a relative path */ 
	public static String GameReportWizardPageOne_DialogError2_Title;
	/** Dialog error 3 for select a relative path */ 
	public static String GameReportWizardPageOne_DialogError3_Title;
	/** Dialog no error for select a relative path */ 
	public static String GameReportWizardPageOne_DialogRelativePath_Message;
	/** Dialog no error for select a relative path */ 
	public static String GameReportWizardPageOne_DialogNoError_Title;
	

	/*----------------------------------------------------------------------- */
	/* GameReportWizardPageOne class                                          */
	/*----------------------------------------------------------------------- */
	/** New Game Page One Wizard : Wizard message */ 
	public static String GameReportWizardPageOne_PageMessage;
	/** New Game Page One Wizard : Wizard title */ 
	public static String GameReportWizardPageOne_PageTitle;
	/** New Game Page One Wizard : Wizard description */ 
	public static String GameReportWizardPageOne_PageDescription;
	/** New Game Page One Wizard : Game selection */ 
	public static String GameReportWizardPageOne_GameSelection;
	/** New Game Page One Wizard : Report generation folder */ 
	public static String GameReportWizardPageOne_ReportGenerationFolder;
	/** New Game Page One Wizard : All games selection */ 
	public static String GameReportWizardPageOne_AllGameSelection;
	/** New Game Page One Wizard : Clear games selection */ 
	public static String GameReportWizardPageOne_ClearGameSelection;
	/** New Game Page One Wizard : Regular selection for games selection */ 
	public static String GameReportWizardPageOne_RegularExpressionGameSelection;
	/** New Game Page One Wizard : Apply */ 
	public static String GameReportWizardPageOne_ApplyButton;
	/** New Game Page One Wizard : Regular selection for games display */ 
	public static String GameReportWizardPageOne_RegularExpressionGameDisplay;
	/** New Game Page One Wizard : Report absolute path generation folder  */ 
	public static String GameReportWizardPageOne_GenereationAbsolutePathTextButton;
	/** New Game Page One Wizard : Report relative path generation folder  */ 
	public static String GameReportWizardPageOne_GenereationRelativePathTextButton;
	/** New Game Page One Wizard : Report absolute path generation folder (tooltip) */ 
	public static String GameReportWizardPageOne_GenereationAbsolutePathToolTip;
	/** New Game Page One Wizard : Report absolute path generation folder (tooltip) */ 
	public static String GameReportWizardPageOne_GenereationRelativeToolTip;

	/*----------------------------------------------------------------------- */
	/* GameReportWizardPageTwo class                                          */
	/*----------------------------------------------------------------------- */
	/** New Game Page Two Wizard : Wizard message */ 
	public static String GameReportWizardPageTwo_PageMessage;
	/** New Game Page Two Wizard : Wizard title */ 
	public static String GameReportWizardPageTwo_PageTitle;
	/** New Game Page Two Wizard : Wizard description */ 
	public static String GameReportWizardPageTwo_PageDescription;
	/** New Game Page Two Wizard : Use standard configuration */ 
	public static String GameReportWizardPageTwo_UseStandardConfiguration;
	/** New Game Page Two Wizard : CSS file path */ 
	public static String GameReportWizardPageTwo_CSSPathFile;
	/** New Game Page Two Wizard : XSLT file path */ 
	public static String GameReportWizardPageTwo_XSLTPathFile;
	/** New Game Page Two Wizard : Banner file path */ 
	public static String GameReportWizardPageTwo_BannerPathFile;
	/** New Game Page Two Wizard : CSS file Selection message */ 
	public static String GameReportWizardPageTwo_CSSSelectionMessage;
	/** New Game Page Two Wizard : XSLT file Selection message */ 
	public static String GameReportWizardPageTwo_XSLTSelectionMessage;
	/** New Game Page Two Wizard : Banner file Selection message */ 
	public static String GameReportWizardPageTwo_BannerSelectionMessage;
	/** Error message if no games are selected */
	public static String GameReportWizardPageOne_OneGameMustBeSeelcted;
	/** Error message if not a valid folder for the genereation of the reports */
	public static String GameReportWizardPageOne_NotAValidFolder;
	/*----------------------------------------------------------------------- */
	/* ImportHtmlWizard class                                                 */
	/*----------------------------------------------------------------------- */
	/** Import Html Wizard : Wizard title */ 
	public static String ImportHtmlWizard_WizardTitle;

	/*----------------------------------------------------------------------- */
	/* ImportHtmlWizardPage class                                             */
	/*----------------------------------------------------------------------- */
	/** Import Html Wizard Page : Wizard message */ 
	public static String ImportHtmlWizardPage_PageMessage;
	/** Import Html Wizard Page : Wizard title */ 
	public static String ImportHtmlWizardPage_PageTitle;
	/** Import Html Wizard Page : Wizard description */ 
	public static String ImportHtmlWizardPage_PageDescription;
	/** Import Html Wizard Page : File Selection */ 
	public static String ImportHtmlWizardPage_FileSelectionLabel;
	/** Import Html Wizard Page : File Path error */ 
	public static String ImportHtmlWizardPage_FilePathNotValidError;
	/** Message for request selection of HTML file */ 
	public static String ImportHtmlWizardPage_SelectHtmlFile;

	/*----------------------------------------------------------------------- */
	/* NewCategoryWizardPage class                                            */
	/*----------------------------------------------------------------------- */
	/** New Category Wizard Page : Wizard message */ 
	public static String NewCategoryWizardPage_PageMessage;
	/** New Category Wizard Page : Wizard title */ 
	public static String NewCategoryWizardPage_PageTitle;
	/** New Category Wizard Page : Wizard description */ 
	public static String NewCategoryWizardPage_PageDescription;
	/** New Category Wizard Page : Select category Label */ 
	public static String NewCategoryWizardPage_CategorySelectionLabel;
	/** New Category Wizard Page : Blank Category Error */ 
	public static String NewCategoryWizardPage_BlankCatgoryError;
	/** New Category Wizard Page : Blank Category Already defined */ 
	public static String NewCategoryWizardPage_CatgoryAlreadyDefined;
	
	/*----------------------------------------------------------------------- */
	/* NewGamePageTwoWizard class                                             */
	/*----------------------------------------------------------------------- */
	/** New Game Page Two Wizard : Wizard message */ 
	public static String NewGamePageTwoWizard_PageMessage;
	/** New Game Page Two Wizard : Wizard title */ 
	public static String NewGamePageTwoWizard_PageTitle;
	/** New Game Page Two Wizard : Wizard description */ 
	public static String NewGamePageTwoWizard_PageDescription;
	/** New Game Page Two Wizard : List of umpires label */ 
	public static String NewGamePageTwoWizard_ListOfUmpiresLabel;
	/** New Game Page Two Wizard : Add umpire button */ 
	public static String NewGamePageTwoWizard_AddUmpireButton;
	/** New Game Page Two Wizard : Remove umpires button */ 
	public static String NewGamePageTwoWizard_RemoveUmpiresButton;
	/** New Game Page Two Wizard : Declare new umpire button */ 
	public static String NewGamePageTwoWizard_DeclareNewUmpireButton;
	/** New Game Page Two Wizard : List of score keepers label */ 
	public static String NewGamePageTwoWizard_ListOfScoreKeepersLabel;
	/** New Game Page Two Wizard : Add score keeper button */ 
	public static String NewGamePageTwoWizard_AddScoreKeeperButton;
	/** New Game Page Two Wizard : Remove score keepers button */ 
	public static String NewGamePageTwoWizard_RemoveScoreKeepersButton;
	/** New Game Page Two Wizard : Declare new score keeper button */ 
	public static String NewGamePageTwoWizard_DeclareNewScoreKeeperButton;
	/** New Game Page Two Wizard : No umpire define error */ 
	public static String NewGamePageTwoWizard_NoUmpireSetError;
	/** New Game Page Two Wizard : No Score keeper define error */ 
	public static String NewGamePageTwoWizard_NoScoreKeeperSetError;
	/** New Game Page Two Wizard : Remove Question Title */ 
	public static String NewGamePageTwoWizard_RemoveQuestionTitle;
	/** New Game Page Two Wizard : Remove Question Message */ 
	public static String NewGamePageTwoWizard_RemoveQuestionMessage;
	/** New Game Page Two Wizard : Add Official */ 
	public static String NewGamePageTwoWizard_AddOffcial;


	/*----------------------------------------------------------------------- */
	/* NewGameWizard class                                                    */
	/*----------------------------------------------------------------------- */
	/** New Game Wizard : Wizard message */ 
	public static String NewGameWizard_Title;
	
	/*----------------------------------------------------------------------- */
	/* NewMemberDialog class                                                  */
	/*----------------------------------------------------------------------- */
	/** New Member Dialog : Wizard message */ 
	public static String NewMemberDialog_Title;
	/** New Member Dialog : Name member label */ 
	public static String NewMemberDialog_MemberNameLabel;
	/** New Member Dialog : Surname member label */ 
	public static String NewMemberDialog_MemberSurNameLabel;
	/** New Member Dialog : License number label */ 
	public static String NewMemberDialog_LicenseNumberLabel;
	/** New Member Dialog : Foreign player */ 
	public static String NewMemberDialog_ForeignPlayerCheckBox;
	/** New Member Dialog : Transfered player */ 
	public static String NewMemberDialog_TransferedPlayerCheckBox;

	/*----------------------------------------------------------------------- */
	/* NewSeasonWizardPage class                                              */
	/*----------------------------------------------------------------------- */
	/** New Season Wizard Page : Wizard message */ 
	public static String NewSeasonWizardPage_PageMessage;
	/** New Season Wizard Page : Wizard title */ 
	public static String NewSeasonWizardPage_PageTitle;
	/** New Season Wizard Page : Wizard description */ 
	public static String NewSeasonWizardPage_PageDescription;
	/** New Season Wizard Page : Season name label */ 
	public static String NewSeasonWizardPage_SeasonNameLabel;
	/** New Season Wizard Page : Duplicate Season name error */ 
	public static String NewSeasonWizardPage_DuplicateSeasonNameError;
	/** New Season Wizard Page : File season name error */ 
	public static String NewSeasonWizardPage_FileSeasonNameError;
	
	/*----------------------------------------------------------------------- */
	/* NewTeamWizard class                                                    */
	/*----------------------------------------------------------------------- */
	/** NewTeamWizard : Wizard title */ 
	public static String NewTeamWizard_Title;
	/** NewTeamWizard : Page player in category title*/ 
	public static String NewTeamWizard_PlayerInCategoryPageTitle;
	/** NewTeamWizard : Page player in category description*/ 
	public static String NewTeamWizard_PlayerInCategoryPageDescription;
	
	/*----------------------------------------------------------------------- */
	/* NewTeamPageCategoryWizard class                                        */
	/*----------------------------------------------------------------------- */
	/** New Team Page Category Wizard : Members list label */ 
	public static String NewTeamPageCategoryWizard_MembersListLabel;
	/** New Team Page Category Wizard : Add member button */ 
	public static String NewTeamPageCategoryWizard_AddMemberButton;
	/** New Team Page Category Wizard : Remove member button */ 
	public static String NewTeamPageCategoryWizard_RemoveMemberButton;
	/** New Team Page Category Wizard : Remove dialog title */ 
	public static String NewTeamPageCategoryWizard_RemoveDialogTitle;
	/** New Team Page Category Wizard : Remove dialog message */ 
	public static String NewTeamPageCategoryWizard_RemoveDialogMessage;
	/** New Team Page Category Wizard : Add dialog message */ 
	public static String NewTeamPageCategoryWizard_AddDialogTitle;
	
	/*----------------------------------------------------------------------- */
	/* NewTeamPageOneWizard class                                             */
	/*----------------------------------------------------------------------- */
	/** New Team Page One Wizard : Wizard message */ 
	public static String NewTeamPageOneWizard_PageMessage;
	/** New Team Page One Wizard : Wizard title */ 
	public static String NewTeamPageOneWizard_PageTitle;
	/** New Team Page One Wizard : Wizard description */ 
	public static String NewTeamPageOneWizard_PageDescription;
	/** New Team Page One Wizard : Club name label*/ 
	public static String NewTeamPageOneWizard_ClubNameLabel;
	/** New Team Page One Wizard : City name label*/ 
	public static String NewTeamPageOneWizard_CityNameLabel;
	/** New Team Page One Wizard : Categories label*/ 
	public static String NewTeamPageOneWizard_CategoriesLabel;
	/** New Team Page One Wizard : New Category button*/ 
	public static String NewTeamPageOneWizard_NewCategoryButton;
	/** New Team Page One Wizard : Remove Category button*/ 
	public static String NewTeamPageOneWizard_RemoveCategoryButton;
	/** New Team Page One Wizard : Rename Category button*/ 
	public static String NewTeamPageOneWizard_RenameCategoryButton;
	/** New Team Page One Wizard : Club importation button*/ 
	public static String NewTeamPageOneWizard_ClubImportationButton;
	/** New Team Page One Wizard : Club importation dialog title */ 
	public static String NewTeamPageOneWizard_ClubImportationDialogTitle;
	/** New Team Page One Wizard : Club importation dialog message */ 
	public static String NewTeamPageOneWizard_ClubImportationDialogMessage;
	/** New Team Page One Wizard : New Category dialog title */ 
	public static String NewTeamPageOneWizard_NewCategoryDialogTitle;
	/** New Team Page One Wizard : Club importation dialog message */ 
	public static String NewTeamPageOneWizard_NewCategoryDialogMessage;
	/** New Team Page One Wizard : New Category Error title */ 
	public static String NewTeamPageOneWizard_NewCategoryErrorTitle;
	/** New Team Page One Wizard : Club importation Error message */ 
	public static String NewTeamPageOneWizard_NewCategoryErrorMessage;
	/** New Team Page One Wizard : New Category dialog title */ 
	public static String NewTeamPageOneWizard_RenameCategoryDialogTitle;
	/** New Team Page One Wizard : Club importation dialog message */ 
	public static String NewTeamPageOneWizard_RenameCategoryDialogMessage;
	/** New Team Page One Wizard : Blank club name error */ 
	public static String NewTeamPageOneWizard_BlankClubNameError;
	/** New Team Page One Wizard : Club name already defined error */ 
	public static String NewTeamPageOneWizard_BlankClubAlreadyDefiendError;
	/** New Team Page One Wizard : Blank city name error */ 
	public static String NewTeamPageOneWizard_BlankCityNameError;

	/*----------------------------------------------------------------------- */
	/* NewTeamPageThreeWizard class                                           */
	/*----------------------------------------------------------------------- */
	/** New Team Page Three Wizard : Wizard message */ 
	public static String NewTeamPageThreeWizard_PageMessage;
	/** New Team Page Three Wizard : Wizard title */ 
	public static String NewTeamPageThreeWizard_PageTitle;
	/** New Team Page Three Wizard : Wizard description */ 
	public static String NewTeamPageThreeWizard_PageDescription;
	/** New Team Page Three Wizard : List of umpires label */ 
	public static String NewTeamPageThreeWizard_ListOfUmpiresLabel;
	/** New Team Page Three Wizard : List of score keepers label */ 
	public static String NewTeamPageThreeWizard_ListOfScoreKeepersLabel;
	/** New Team Page Three Wizard : Add an umpire button */ 
	public static String NewTeamPageThreeWizard_AddUmpireButton;
	/** New Team Page Three Wizard : Remove an umpire button */ 
	public static String NewTeamPageThreeWizard_RemoveUmpireButton;
	/** New Team Page Three Wizard : Add an score keeper button */ 
	public static String NewTeamPageThreeWizard_AddScoreKeeperButton;
	/** New Team Page Three Wizard : Remove an score keeper button */ 
	public static String NewTeamPageThreeWizard_RemoveScoreKeepereButton;
	/** New Team Page Three Wizard : Add official label */ 
	public static String NewTeamPageThreeWizard_AddOfficialLabel;
	/** New Team Page Three Wizard : Dialog box title for removing team member confirmation */ 
	public static String NewTeamPageThreeWizard_RemoveTeamMemberTitle;
	/** New Team Page Three Wizard : Dialog box message for removing team member confirmation */ 
	public static String NewTeamPageThreeWizard_RemoveTeamMemberMessage;

	/*----------------------------------------------------------------------- */
	/* NewTeamPageTwoWizard class                                             */
	/*----------------------------------------------------------------------- */
	/** New Team Page two Wizard : Wizard message */ 
	public static String NewTeamPageTwoWizard_PageMessage;
	/** New Team Page two Wizard : Wizard title */ 
	public static String NewTeamPageTwoWizard_PageTitle;
	/** New Team Page two Wizard : Wizard description */ 
	public static String NewTeamPageTwoWizard_PageDescription;
	/** New Team Page two Wizard : List member label */ 
	public static String NewTeamPageTwoWizard_ListMemberLabel;
	/** New Team Page two Wizard : Add member button */ 
	public static String NewTeamPageTwoWizard_AddMemberButton;
	/** New Team Page two Wizard : Remove member button */ 
	public static String NewTeamPageTwoWizard_RemoveMemberButton;
	/** New Team Page two Wizard : Remove member dialog title */ 
	public static String NewTeamPageTwoWizard_RemoveMemberDialogTitle;
	/** New Team Page two Wizard : Remove member dialog message */ 
	public static String NewTeamPageTwoWizard_RemoveMemberDialogMessage;

	/*----------------------------------------------------------------------- */
	/* SearchGameByDateWizard class                                           */
	/*----------------------------------------------------------------------- */
	/** Search Game By Date Wizard : Wizard title */ 
	public static String SearchGameByDateWizard_WizardTitle;
	
	/*----------------------------------------------------------------------- */
	/* SearchGameForTeamWizard class                                          */
	/*----------------------------------------------------------------------- */
	/** Search Game For Team Wizard : Wizard title */ 
	public static String SearchGameForTeamWizard_WizardTitle;

	/*----------------------------------------------------------------------- */
	/* SearchGameByDateWizardPageOne class                                    */
	/*----------------------------------------------------------------------- */
	/** Search Game By Date Wizard Page One : Wizard message */ 
	public static String SearchGameByDateWizardPageOne_PageMessage;
	/** Search Game By Date Wizard Page One : Wizard title */ 
	public static String SearchGameByDateWizardPageOne_PageTitle;
	/** Search Game By Date Wizard Page One : Wizard description */ 
	public static String SearchGameByDateWizardPageOne_PageDescription;
	/** Search Game By Date Wizard Page One : Start date label */ 
	public static String SearchGameByDateWizardPageOne_StartDateLabel;
	/** Search Game By Date Wizard Page One : End date label */ 
	public static String SearchGameByDateWizardPageOne_EndDateLabel;
	/** Search Game By Date Wizard Page One : Date column table */ 
	public static String SearchGameByDateWizardPageOne_DateColumnTable;
	/** Search Game By Date Wizard Page One : Code column table */ 
	public static String SearchGameByDateWizardPageOne_CodeColumnTable;
	/** Search Game By Date Wizard Page One : Description column table */ 
	public static String SearchGameByDateWizardPageOne_DescriptionColumnTable;
	/** Search Game By Date Wizard Page One : Missing game selection error */ 
	public static String SearchGameByDateWizardPageOne_MissingGameSelectionError;
	
	/*----------------------------------------------------------------------- */
	/* SearchGameForTeamWizardPageOne class                                   */
	/*----------------------------------------------------------------------- */
	/** Search Game By Team Wizard Page One : Wizard message */ 
	public static String SearchGameForTeamWizardPageOne_PageMessage;
	/** Search Game By Team Wizard Page One : Wizard title */ 
	public static String SearchGameForTeamWizardPageOne_PageTitle;
	/** Search Game By Team Wizard Page One : Wizard description */ 
	public static String SearchGameForTeamWizardPageOne_PageDescription;
	/** Search Game By Team Wizard Page One : Team selection label */ 
	public static String SearchGameForTeamWizardPageOne_TeamSelectionLabel;
	/** Search Game By Team Wizard Page One : Games play by team label */ 
	public static String SearchGameForTeamWizardPageOne_GamesPlayByTeam;
	/** Search Game By Team Wizard Page One : Date column table */ 
	public static String SearchGameForTeamWizardPageOne_DateColumnTable;
	/** Search Game By Team Wizard Page One : Number column table */ 
	public static String SearchGameForTeamWizardPageOne_NumberColumnTable;
	/** Search Game By Team Wizard Page One : Location column table */ 
	public static String SearchGameForTeamWizardPageOne_LocationColumnTable;
	/** Search Game By Team Wizard Page One : Description column table */ 
	public static String SearchGameForTeamWizardPageOne_DescriptionColumnTable;
	/** Search Game By Team Wizard Page One : No team selection error */ 
	public static String SearchGameForTeamWizardPageOne_NoTeamSelectionError;
	/** Search Game By Team Wizard Page One : No game selection error */ 
	public static String SearchGameForTeamWizardPageOne_NoGameSelectionError;

	/*----------------------------------------------------------------------- */
	/* CurrentLineupView class                                                */
	/*----------------------------------------------------------------------- */
	/** Current Line-up View : Player column name */
	public static String CurrentLineupView_PlayerColumnName;
	/** Current Line-up View : Defensive column name */
	public static String CurrentLineupView_DefensiveColumnName;
	/** Current Line-up View : Offensive column name */
	public static String CurrentLineupView_OffensiveColumnName;
	/** Current Line-up View : Visitor team */
	public static String CurrentLineupView_VisitorTeam;
	/** Current Line-up View : home team */
	public static String CurrentLineupView_Hometeam;

	/*----------------------------------------------------------------------- */
	/* ExportAsPdfHandler class                                               */
	/*----------------------------------------------------------------------- */
	/** Export As Pdf Handler : Dialog text */
	public static String ExportAsPdfHandler_DialogText;
	/** Export As Pdf Handler : Dialog title */
	public static String ExportAsPdfHandler_DialogTitle;
	/** Export As Pdf Handler : Export succesfull */
	public static String ExportAsPdfHandler_ExportSuccesFull;
	/** Export As Pdf Handler : Export resume */
	public static String ExportAsPdfHandler_ExportResume;

	/*----------------------------------------------------------------------- */
	/* GameReportGeneratorHandler class                                               */
	/*----------------------------------------------------------------------- */
	/** Game Report Generator Handler : Dialog text */
	public static String GameReportGeneratorHandler_DialogText;
	/** Game Report Generator Handler : Dialog title */
	public static String GameReportGeneratorHandler_DialogTitle;

	/*----------------------------------------------------------------------- */
	/* DeleteHandler class                                               */
	/*----------------------------------------------------------------------- */
	/** Delete Handler : Remove text */
	public static String DeleteHandler_RemoveText;

	/*----------------------------------------------------------------------- */
	/* NewExampleProjectForScenarios class                                               */
	/*----------------------------------------------------------------------- */
	/** New Example Project For Scenarios : Dialog title */
	public static String NewExampleProjectForScenarios_DialogTitle;
	/** New Example Project For Scenarios : Dialog text */
	public static String NewExampleProjectForScenarios_DialogText;
	/** New Example Project For Scenarios : Predefined value */
	public static String NewExampleProjectForScenarios_DialogPredefinedValue;
	
	
	/*----------------------------------------------------------------------- */
	/* NewExampleProjectForScenarios class                                               */
	/*----------------------------------------------------------------------- */
	/** New Example Project For Scenarios : Name of the application */
	public static String ApplicationWorkbenchWindowAdvisor_RcpTitle;
	
	/*----------------------------------------------------------------------- */
	/* GraphicalPreferencePage class                                               */
	/*----------------------------------------------------------------------- */
	/** Graphical Preference Page : Line Color label */
	public static String GraphicalPreferencePage_LineColorLabel;
	/** Graphical Preference Page : Pencil Color label */
	public static String GraphicalPreferencePage_PencilColorLabel;
	/** Graphical Preference Page : No statistics */
	public static String GraphicalPreferencePage_NoStatistics;
	/** Graphical Preference Page : SF1 display */
	public static String GraphicalPreferencePage_Sf1Display;
	/** Graphical Preference Page : Full display */
	public static String GraphicalPreferencePage_FullDisplay;
	/** Graphical Preference Page : Display statistics label */
	public static String GraphicalPreferencePage_DisplayStatisticsLabel;
	/** Graphical Preference Page : Display Win/Lose/Save */
	public static String GraphicalPreferencePage_DisplayWinLoseSave;
	/** Graphical Preference Page : New style sheet display */
	public static String GraphicalPreferencePage_NewStyleSheetDisplay;
	
	/*----------------------------------------------------------------------- */
	/* HtmlPreferences class                                               */
	/*----------------------------------------------------------------------- */
	/** Html Preferences : Generation folder */
	public static String HtmlPreferences_GenerationFolder;
	/** Html Preferences : Background picture */
	public static String HtmlPreferences_BackgroundPicture;
	
	/*----------------------------------------------------------------------- */
	/* PreferenceConstants class                                               */
	/*----------------------------------------------------------------------- */
	/** Preference Constants : Level error ignore */
	public static String PreferenceConstants_LevelErrorIgnore;
	/** Preference Constants : Level error warning */
	public static String PreferenceConstants_LevelErrorWarning;
	/** Preference Constants : Level error error */
	public static String PreferenceConstants_LevelErrorError;
	
	/*----------------------------------------------------------------------- */
	/* WorkbenchPreferencePage class                                               */
	/*----------------------------------------------------------------------- */
	/** Workbench Preference Page : Page message */
	public static String WorkbenchPreferencePage_Message;
	public static String GameReportWizardPageTwo_btnNewButton_text;
	public static String GameReportWizardPageTwo_btnNewButton_1_text;
	public static String GameReportWizardPageTwo_lblNewLabel_text;
	public static String GameReportWizardPageTwo_btnNewButton_2_text;
	public static String GameReportWizardPageTwo_btnNewButton_3_text;
	public static String GameReportWizardPageTwo_btnNewButton_4_text;
	public static String GameReportWizardPageTwo_btnNewButton_5_text;
	public static String GameReportWizardPageTwo_cssRelativePath_toolTipText;
	public static String GameReportWizardPageTwo_xsltRelativePath_toolTipText;
	public static String GameReportWizardPageTwo_bannerRelativePath_toolTipText;
	public static String GameReportWizardPageTwo_cssAbsolutePath_toolTipText;
	public static String GameReportWizardPageTwo_xlstAbsolutePath_toolTipText;
	public static String GameReportWizardPageTwo_bannerAbsolutePath_toolTipText;
	public static String GameReportWizardPageTwo_MissingFileError;
	
	/*----------------------------------------------------------------------- */
	/* ApplicationActionBarAdvisor class                                      */
	/*----------------------------------------------------------------------- */
	public static String ApplicationActionBarAdvisor_HelpMenu;
	public static String GameReportWizardPageOne_lblNewLabel_text;
	public static String GameReportWizardPageOne_lblNewLabel_1_text;
	
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
