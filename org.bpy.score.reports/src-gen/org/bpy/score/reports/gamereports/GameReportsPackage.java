/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.bpy.score.reports.gamereports.GameReportsFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface GameReportsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gamereports";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:/www.org.bpy.score/reports/game";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gamereports";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GameReportsPackage eINSTANCE = org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.GameReportImpl <em>Game Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.GameReportImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getGameReport()
	 * @generated
	 */
	int GAME_REPORT = 0;

	/**
	 * The feature id for the '<em><b>Banner Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__BANNER_PATH = 0;

	/**
	 * The feature id for the '<em><b>Visitor Sheet Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__VISITOR_SHEET_PATH = 1;

	/**
	 * The feature id for the '<em><b>Visitor Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__VISITOR_STATS = 2;

	/**
	 * The feature id for the '<em><b>Hometeam Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__HOMETEAM_STATS = 3;

	/**
	 * The feature id for the '<em><b>Umpires</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__UMPIRES = 4;

	/**
	 * The feature id for the '<em><b>Scorekeepers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__SCOREKEEPERS = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__DATE = 6;

	/**
	 * The feature id for the '<em><b>Starting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__STARTING_TIME = 7;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__DURATION = 8;

	/**
	 * The feature id for the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__TOWN = 9;

	/**
	 * The feature id for the '<em><b>Stadium</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__STADIUM = 10;

	/**
	 * The feature id for the '<em><b>Hometeam Sheet Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__HOMETEAM_SHEET_PATH = 11;

	/**
	 * The feature id for the '<em><b>Game Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__GAME_NUMBER = 12;

	/**
	 * The feature id for the '<em><b>Play By Play</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__PLAY_BY_PLAY = 13;

	/**
	 * The feature id for the '<em><b>Pdf File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__PDF_FILE = 14;

	/**
	 * The feature id for the '<em><b>General Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__GENERAL_STATS = 15;

	/**
	 * The feature id for the '<em><b>Visitor Lineup</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__VISITOR_LINEUP = 16;

	/**
	 * The feature id for the '<em><b>Hometeam Lineup</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__HOMETEAM_LINEUP = 17;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT__MIXED = 18;

	/**
	 * The number of structural features of the '<em>Game Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT_FEATURE_COUNT = 19;

	/**
	 * The number of operations of the '<em>Game Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_REPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl <em>Team Statisitics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getTeamStatisitics()
	 * @generated
	 */
	int TEAM_STATISITICS = 1;

	/**
	 * The feature id for the '<em><b>Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS__PLAYERS = 0;

	/**
	 * The feature id for the '<em><b>Team Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS__TEAM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS__TOWN = 2;

	/**
	 * The feature id for the '<em><b>Game Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS__GAME_WIN = 3;

	/**
	 * The feature id for the '<em><b>Game Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS__GAME_LOSE = 4;

	/**
	 * The number of structural features of the '<em>Team Statisitics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Team Statisitics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISITICS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.PitcherStatisticImpl <em>Pitcher Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.PitcherStatisticImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPitcherStatistic()
	 * @generated
	 */
	int PITCHER_STATISTIC = 2;

	/**
	 * The feature id for the '<em><b>Batter Front</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__BATTER_FRONT = 0;

	/**
	 * The feature id for the '<em><b>At Bats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__AT_BATS = 1;

	/**
	 * The feature id for the '<em><b>Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__RUNS = 2;

	/**
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__HITS = 3;

	/**
	 * The feature id for the '<em><b>Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__DOUBLE = 4;

	/**
	 * The feature id for the '<em><b>Triple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__TRIPLE = 5;

	/**
	 * The feature id for the '<em><b>Homerun</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__HOMERUN = 6;

	/**
	 * The feature id for the '<em><b>Sacrifice Hit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__SACRIFICE_HIT = 7;

	/**
	 * The feature id for the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__SACRIFICE_FLY = 8;

	/**
	 * The feature id for the '<em><b>Base On Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__BASE_ON_BALL = 9;

	/**
	 * The feature id for the '<em><b>Intentionalbase On Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL = 10;

	/**
	 * The feature id for the '<em><b>Hit By Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__HIT_BY_PITCH = 11;

	/**
	 * The feature id for the '<em><b>Interferance Obstruction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION = 12;

	/**
	 * The feature id for the '<em><b>Strike Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__STRIKE_OUT = 13;

	/**
	 * The feature id for the '<em><b>Earned Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__EARNED_RUNS = 14;

	/**
	 * The feature id for the '<em><b>Wild Pitches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__WILD_PITCHES = 15;

	/**
	 * The feature id for the '<em><b>Balks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__BALKS = 16;

	/**
	 * The feature id for the '<em><b>Pitch Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__PITCH_COUNT = 17;

	/**
	 * The feature id for the '<em><b>Pitch Count K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__PITCH_COUNT_K = 18;

	/**
	 * The feature id for the '<em><b>Pitch Count B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__PITCH_COUNT_B = 19;

	/**
	 * The feature id for the '<em><b>Pitch Count Others</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__PITCH_COUNT_OTHERS = 20;

	/**
	 * The feature id for the '<em><b>Runner Left On Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE = 21;

	/**
	 * The feature id for the '<em><b>Caught Stealing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__CAUGHT_STEALING = 22;

	/**
	 * The feature id for the '<em><b>Game Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__GAME_LOSE = 23;

	/**
	 * The feature id for the '<em><b>Game Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__GAME_WIN = 24;

	/**
	 * The feature id for the '<em><b>Game Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__GAME_SAVE = 25;

	/**
	 * The feature id for the '<em><b>Ips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__IPS = 26;

	/**
	 * The feature id for the '<em><b>Pitcher Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__PITCHER_ORDER = 27;

	/**
	 * The feature id for the '<em><b>Fly Outs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__FLY_OUTS = 28;

	/**
	 * The feature id for the '<em><b>Grounded Outs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC__GROUNDED_OUTS = 29;

	/**
	 * The number of structural features of the '<em>Pitcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC_FEATURE_COUNT = 30;

	/**
	 * The number of operations of the '<em>Pitcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl <em>Defensive Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getDefensiveStatistic()
	 * @generated
	 */
	int DEFENSIVE_STATISTIC = 3;

	/**
	 * The feature id for the '<em><b>Put Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC__PUT_OUT = 0;

	/**
	 * The feature id for the '<em><b>Assitances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC__ASSITANCES = 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC__ERRORS = 2;

	/**
	 * The feature id for the '<em><b>Double Play</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC__DOUBLE_PLAY = 3;

	/**
	 * The number of structural features of the '<em>Defensive Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Defensive Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.CatcherStatisticImpl <em>Catcher Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.CatcherStatisticImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getCatcherStatistic()
	 * @generated
	 */
	int CATCHER_STATISTIC = 4;

	/**
	 * The feature id for the '<em><b>Pass Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCHER_STATISTIC__PASS_BALL = 0;

	/**
	 * The feature id for the '<em><b>Stolen Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCHER_STATISTIC__STOLEN_BASE = 1;

	/**
	 * The feature id for the '<em><b>Caught Stealing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCHER_STATISTIC__CAUGHT_STEALING = 2;

	/**
	 * The number of structural features of the '<em>Catcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCHER_STATISTIC_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Catcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCHER_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.OffensiveStatisticImpl <em>Offensive Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.OffensiveStatisticImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getOffensiveStatistic()
	 * @generated
	 */
	int OFFENSIVE_STATISTIC = 5;

	/**
	 * The feature id for the '<em><b>Plate Appearances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__PLATE_APPEARANCES = 0;

	/**
	 * The feature id for the '<em><b>At Bats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__AT_BATS = 1;

	/**
	 * The feature id for the '<em><b>Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__RUNS = 2;

	/**
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__HITS = 3;

	/**
	 * The feature id for the '<em><b>Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__DOUBLE = 4;

	/**
	 * The feature id for the '<em><b>Triple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__TRIPLE = 5;

	/**
	 * The feature id for the '<em><b>Homerun</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__HOMERUN = 6;

	/**
	 * The feature id for the '<em><b>Grounded Double Play</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY = 7;

	/**
	 * The feature id for the '<em><b>Sacrifice Hit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__SACRIFICE_HIT = 8;

	/**
	 * The feature id for the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__SACRIFICE_FLY = 9;

	/**
	 * The feature id for the '<em><b>Base On Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__BASE_ON_BALL = 10;

	/**
	 * The feature id for the '<em><b>Intentionalbase On Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL = 11;

	/**
	 * The feature id for the '<em><b>Hit By Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__HIT_BY_PITCH = 12;

	/**
	 * The feature id for the '<em><b>Interferance Obstruction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION = 13;

	/**
	 * The feature id for the '<em><b>Stolen Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__STOLEN_BASE = 14;

	/**
	 * The feature id for the '<em><b>Caught Stealing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__CAUGHT_STEALING = 15;

	/**
	 * The feature id for the '<em><b>Strike Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__STRIKE_OUT = 16;

	/**
	 * The feature id for the '<em><b>Rbi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC__RBI = 17;

	/**
	 * The number of structural features of the '<em>Offensive Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Offensive Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.PlayerImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 6;

	/**
	 * The feature id for the '<em><b>Pitcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__PITCHER_STATISTIC = 0;

	/**
	 * The feature id for the '<em><b>Defensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__DEFENSIVE_STATISTIC = 1;

	/**
	 * The feature id for the '<em><b>Catchers Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__CATCHERS_STATISTIC = 2;

	/**
	 * The feature id for the '<em><b>Offensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__OFFENSIVE_STATISTIC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = 4;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.PlayByPlayImpl <em>Play By Play</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.PlayByPlayImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPlayByPlay()
	 * @generated
	 */
	int PLAY_BY_PLAY = 7;

	/**
	 * The feature id for the '<em><b>Actiondescription</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_BY_PLAY__ACTIONDESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Play By Play</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_BY_PLAY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Play By Play</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAY_BY_PLAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl <em>Game General Stats</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getGameGeneralStats()
	 * @generated
	 */
	int GAME_GENERAL_STATS = 8;

	/**
	 * The feature id for the '<em><b>Points Per Inning</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__POINTS_PER_INNING = 0;

	/**
	 * The feature id for the '<em><b>Visitor Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__VISITOR_ERRORS = 1;

	/**
	 * The feature id for the '<em><b>Visitor Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__VISITOR_HITS = 2;

	/**
	 * The feature id for the '<em><b>Visitor Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__VISITOR_RUNS = 3;

	/**
	 * The feature id for the '<em><b>Hometeam Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__HOMETEAM_ERRORS = 4;

	/**
	 * The feature id for the '<em><b>Hometeam Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__HOMETEAM_RUNS = 5;

	/**
	 * The feature id for the '<em><b>Hometeam Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS__HOMETEAM_HITS = 6;

	/**
	 * The number of structural features of the '<em>Game General Stats</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Game General Stats</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_GENERAL_STATS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.PointsPerInningImpl <em>Points Per Inning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.PointsPerInningImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPointsPerInning()
	 * @generated
	 */
	int POINTS_PER_INNING = 9;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_PER_INNING__ORDER = 0;

	/**
	 * The feature id for the '<em><b>Visitor Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_PER_INNING__VISITOR_POINT = 1;

	/**
	 * The feature id for the '<em><b>Hometeam Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_PER_INNING__HOMETEAM_POINT = 2;

	/**
	 * The number of structural features of the '<em>Points Per Inning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_PER_INNING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Points Per Inning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINTS_PER_INNING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.StartingLineupImpl <em>Starting Lineup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.StartingLineupImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getStartingLineup()
	 * @generated
	 */
	int STARTING_LINEUP = 10;

	/**
	 * The feature id for the '<em><b>Team Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTING_LINEUP__TEAM_NAME = 0;

	/**
	 * The feature id for the '<em><b>Lineup Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTING_LINEUP__LINEUP_PLAYERS = 1;

	/**
	 * The feature id for the '<em><b>Field Pictrure Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTING_LINEUP__FIELD_PICTRURE_LINK = 2;

	/**
	 * The number of structural features of the '<em>Starting Lineup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTING_LINEUP_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Starting Lineup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTING_LINEUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.LineupPlayerImpl <em>Lineup Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.LineupPlayerImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getLineupPlayer()
	 * @generated
	 */
	int LINEUP_PLAYER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_PLAYER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Offensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_PLAYER__OFFENSIVE_POSITION = 1;

	/**
	 * The feature id for the '<em><b>Defensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_PLAYER__DEFENSIVE_POSITION = 2;

	/**
	 * The number of structural features of the '<em>Lineup Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_PLAYER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Lineup Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_PLAYER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl <em>Action Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getActionDescription()
	 * @generated
	 */
	int ACTION_DESCRIPTION = 12;

	/**
	 * The feature id for the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION__CONTENT = 1;

	/**
	 * The feature id for the '<em><b>Resume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION__RESUME = 2;

	/**
	 * The feature id for the '<em><b>Team</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION__TEAM = 3;

	/**
	 * The number of structural features of the '<em>Action Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Action Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.reports.gamereports.TEAM <em>TEAM</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.reports.gamereports.TEAM
	 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getTEAM()
	 * @generated
	 */
	int TEAM = 13;


	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.GameReport <em>Game Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game Report</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport
	 * @generated
	 */
	EClass getGameReport();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.reports.gamereports.GameReport#getBannerPath <em>Banner Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Banner Path</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getBannerPath()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_BannerPath();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorSheetPath <em>Visitor Sheet Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visitor Sheet Path</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getVisitorSheetPath()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_VisitorSheetPath();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorStats <em>Visitor Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visitor Stats</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getVisitorStats()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_VisitorStats();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamStats <em>Hometeam Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hometeam Stats</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getHometeamStats()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_HometeamStats();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.reports.gamereports.GameReport#getUmpires <em>Umpires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Umpires</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getUmpires()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Umpires();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.reports.gamereports.GameReport#getScorekeepers <em>Scorekeepers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Scorekeepers</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getScorekeepers()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Scorekeepers();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getDate()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getStartingTime <em>Starting Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Starting Time</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getStartingTime()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_StartingTime();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getDuration()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Town</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getTown()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Town();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getStadium <em>Stadium</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stadium</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getStadium()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Stadium();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamSheetPath <em>Hometeam Sheet Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hometeam Sheet Path</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getHometeamSheetPath()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_HometeamSheetPath();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getGameNumber <em>Game Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Number</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getGameNumber()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_GameNumber();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getPlayByPlay <em>Play By Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Play By Play</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getPlayByPlay()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_PlayByPlay();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameReport#getPdfFile <em>Pdf File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pdf File</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getPdfFile()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_PdfFile();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getGeneralStats <em>General Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>General Stats</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getGeneralStats()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_GeneralStats();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorLineup <em>Visitor Lineup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visitor Lineup</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getVisitorLineup()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_VisitorLineup();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamLineup <em>Hometeam Lineup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hometeam Lineup</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getHometeamLineup()
	 * @see #getGameReport()
	 * @generated
	 */
	EReference getGameReport_HometeamLineup();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.reports.gamereports.GameReport#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.bpy.score.reports.gamereports.GameReport#getMixed()
	 * @see #getGameReport()
	 * @generated
	 */
	EAttribute getGameReport_Mixed();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.TeamStatisitics <em>Team Statisitics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team Statisitics</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics
	 * @generated
	 */
	EClass getTeamStatisitics();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getPlayers <em>Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Players</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics#getPlayers()
	 * @see #getTeamStatisitics()
	 * @generated
	 */
	EReference getTeamStatisitics_Players();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTeamName <em>Team Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Team Name</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics#getTeamName()
	 * @see #getTeamStatisitics()
	 * @generated
	 */
	EAttribute getTeamStatisitics_TeamName();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Town</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics#getTown()
	 * @see #getTeamStatisitics()
	 * @generated
	 */
	EAttribute getTeamStatisitics_Town();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameWin <em>Game Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Win</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics#getGameWin()
	 * @see #getTeamStatisitics()
	 * @generated
	 */
	EAttribute getTeamStatisitics_GameWin();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameLose <em>Game Lose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Lose</em>'.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics#getGameLose()
	 * @see #getTeamStatisitics()
	 * @generated
	 */
	EAttribute getTeamStatisitics_GameLose();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.PitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pitcher Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic
	 * @generated
	 */
	EClass getPitcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBatterFront <em>Batter Front</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Batter Front</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getBatterFront()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_BatterFront();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getAtBats()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getRuns()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getHits()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getDouble <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getDouble()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Double();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getTriple <em>Triple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getTriple()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Triple();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHomerun <em>Homerun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Homerun</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getHomerun()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Homerun();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Hit</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeHit()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_SacrificeHit();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Fly</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeFly()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_SacrificeFly();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base On Ball</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getBaseOnBall()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_BaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intentionalbase On Ball</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getIntentionalbaseOnBall()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_IntentionalbaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit By Pitch</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getHitByPitch()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_HitByPitch();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interferance Obstruction</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getInterferanceObstruction()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_InterferanceObstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getStrikeOut <em>Strike Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strike Out</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getStrikeOut()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_StrikeOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Earned Runs</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getEarnedRuns()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_EarnedRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wild Pitches</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getWildPitches()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_WildPitches();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBalks <em>Balks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balks</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getBalks()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Balks();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCount <em>Pitch Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCount()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCount();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count K</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountK()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountK();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count B</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountB()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountB();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count Others</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountOthers()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountOthers();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runner Left On Base</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getRunnerLeftOnBase()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_RunnerLeftOnBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getCaughtStealing()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_CaughtStealing();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameLose <em>Game Lose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Lose</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getGameLose()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_GameLose();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameWin <em>Game Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Win</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getGameWin()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_GameWin();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameSave <em>Game Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Save</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getGameSave()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_GameSave();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getIps <em>Ips</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ips</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getIps()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Ips();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitcherOrder <em>Pitcher Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitcher Order</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getPitcherOrder()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitcherOrder();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getFlyOuts <em>Fly Outs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fly Outs</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getFlyOuts()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_FlyOuts();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGroundedOuts <em>Grounded Outs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grounded Outs</em>'.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic#getGroundedOuts()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_GroundedOuts();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.DefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defensive Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic
	 * @generated
	 */
	EClass getDefensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getPutOut <em>Put Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Put Out</em>'.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic#getPutOut()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_PutOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getAssitances <em>Assitances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assitances</em>'.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic#getAssitances()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_Assitances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic#getErrors()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getDoublePlay <em>Double Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Play</em>'.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic#getDoublePlay()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_DoublePlay();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.CatcherStatistic <em>Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catcher Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.CatcherStatistic
	 * @generated
	 */
	EClass getCatcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getPassBall <em>Pass Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pass Ball</em>'.
	 * @see org.bpy.score.reports.gamereports.CatcherStatistic#getPassBall()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_PassBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getStolenBase <em>Stolen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base</em>'.
	 * @see org.bpy.score.reports.gamereports.CatcherStatistic#getStolenBase()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_StolenBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.reports.gamereports.CatcherStatistic#getCaughtStealing()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_CaughtStealing();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.OffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offensive Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic
	 * @generated
	 */
	EClass getOffensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getPlateAppearances <em>Plate Appearances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plate Appearances</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getPlateAppearances()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_PlateAppearances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getAtBats()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getRuns()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getHits()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getDouble <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getDouble()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Double();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getTriple <em>Triple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getTriple()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Triple();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHomerun <em>Homerun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Homerun</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getHomerun()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Homerun();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getGroundedDoublePlay <em>Grounded Double Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grounded Double Play</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getGroundedDoublePlay()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_GroundedDoublePlay();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeHit <em>Sacrifice Hit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Hit</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeHit()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_SacrificeHit();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeFly <em>Sacrifice Fly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Fly</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeFly()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_SacrificeFly();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getBaseOnBall <em>Base On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base On Ball</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getBaseOnBall()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_BaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intentionalbase On Ball</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getIntentionalbaseOnBall()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_IntentionalbaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHitByPitch <em>Hit By Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit By Pitch</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getHitByPitch()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_HitByPitch();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interferance Obstruction</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getInterferanceObstruction()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_InterferanceObstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStolenBase <em>Stolen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getStolenBase()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_StolenBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getCaughtStealing()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_CaughtStealing();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStrikeOut <em>Strike Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strike Out</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getStrikeOut()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_StrikeOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRbi <em>Rbi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rbi</em>'.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic#getRbi()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Rbi();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see org.bpy.score.reports.gamereports.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.Player#getPitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pitcher Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.Player#getPitcherStatistic()
	 * @see #getPlayer()
	 * @generated
	 */
	EReference getPlayer_PitcherStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.Player#getDefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defensive Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.Player#getDefensiveStatistic()
	 * @see #getPlayer()
	 * @generated
	 */
	EReference getPlayer_DefensiveStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.Player#getCatchersStatistic <em>Catchers Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catchers Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.Player#getCatchersStatistic()
	 * @see #getPlayer()
	 * @generated
	 */
	EReference getPlayer_CatchersStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.reports.gamereports.Player#getOffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Offensive Statistic</em>'.
	 * @see org.bpy.score.reports.gamereports.Player#getOffensiveStatistic()
	 * @see #getPlayer()
	 * @generated
	 */
	EReference getPlayer_OffensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.Player#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bpy.score.reports.gamereports.Player#getName()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Name();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.PlayByPlay <em>Play By Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Play By Play</em>'.
	 * @see org.bpy.score.reports.gamereports.PlayByPlay
	 * @generated
	 */
	EClass getPlayByPlay();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.reports.gamereports.PlayByPlay#getActiondescription <em>Actiondescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actiondescription</em>'.
	 * @see org.bpy.score.reports.gamereports.PlayByPlay#getActiondescription()
	 * @see #getPlayByPlay()
	 * @generated
	 */
	EReference getPlayByPlay_Actiondescription();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.GameGeneralStats <em>Game General Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game General Stats</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats
	 * @generated
	 */
	EClass getGameGeneralStats();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getPointsPerInning <em>Points Per Inning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points Per Inning</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getPointsPerInning()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EReference getGameGeneralStats_PointsPerInning();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorErrors <em>Visitor Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visitor Errors</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorErrors()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_VisitorErrors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorHits <em>Visitor Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visitor Hits</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorHits()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_VisitorHits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorRuns <em>Visitor Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visitor Runs</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorRuns()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_VisitorRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamErrors <em>Hometeam Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hometeam Errors</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamErrors()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_HometeamErrors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamRuns <em>Hometeam Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hometeam Runs</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamRuns()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_HometeamRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamHits <em>Hometeam Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hometeam Hits</em>'.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamHits()
	 * @see #getGameGeneralStats()
	 * @generated
	 */
	EAttribute getGameGeneralStats_HometeamHits();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.PointsPerInning <em>Points Per Inning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Points Per Inning</em>'.
	 * @see org.bpy.score.reports.gamereports.PointsPerInning
	 * @generated
	 */
	EClass getPointsPerInning();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PointsPerInning#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.bpy.score.reports.gamereports.PointsPerInning#getOrder()
	 * @see #getPointsPerInning()
	 * @generated
	 */
	EAttribute getPointsPerInning_Order();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PointsPerInning#getVisitorPoint <em>Visitor Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visitor Point</em>'.
	 * @see org.bpy.score.reports.gamereports.PointsPerInning#getVisitorPoint()
	 * @see #getPointsPerInning()
	 * @generated
	 */
	EAttribute getPointsPerInning_VisitorPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.PointsPerInning#getHometeamPoint <em>Hometeam Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hometeam Point</em>'.
	 * @see org.bpy.score.reports.gamereports.PointsPerInning#getHometeamPoint()
	 * @see #getPointsPerInning()
	 * @generated
	 */
	EAttribute getPointsPerInning_HometeamPoint();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.StartingLineup <em>Starting Lineup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Starting Lineup</em>'.
	 * @see org.bpy.score.reports.gamereports.StartingLineup
	 * @generated
	 */
	EClass getStartingLineup();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.StartingLineup#getTeamName <em>Team Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Team Name</em>'.
	 * @see org.bpy.score.reports.gamereports.StartingLineup#getTeamName()
	 * @see #getStartingLineup()
	 * @generated
	 */
	EAttribute getStartingLineup_TeamName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.reports.gamereports.StartingLineup#getLineupPlayers <em>Lineup Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lineup Players</em>'.
	 * @see org.bpy.score.reports.gamereports.StartingLineup#getLineupPlayers()
	 * @see #getStartingLineup()
	 * @generated
	 */
	EReference getStartingLineup_LineupPlayers();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.StartingLineup#getFieldPictrureLink <em>Field Pictrure Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Pictrure Link</em>'.
	 * @see org.bpy.score.reports.gamereports.StartingLineup#getFieldPictrureLink()
	 * @see #getStartingLineup()
	 * @generated
	 */
	EAttribute getStartingLineup_FieldPictrureLink();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.LineupPlayer <em>Lineup Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lineup Player</em>'.
	 * @see org.bpy.score.reports.gamereports.LineupPlayer
	 * @generated
	 */
	EClass getLineupPlayer();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.LineupPlayer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bpy.score.reports.gamereports.LineupPlayer#getName()
	 * @see #getLineupPlayer()
	 * @generated
	 */
	EAttribute getLineupPlayer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.LineupPlayer#getOffensivePosition <em>Offensive Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offensive Position</em>'.
	 * @see org.bpy.score.reports.gamereports.LineupPlayer#getOffensivePosition()
	 * @see #getLineupPlayer()
	 * @generated
	 */
	EAttribute getLineupPlayer_OffensivePosition();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.LineupPlayer#getDefensivePosition <em>Defensive Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defensive Position</em>'.
	 * @see org.bpy.score.reports.gamereports.LineupPlayer#getDefensivePosition()
	 * @see #getLineupPlayer()
	 * @generated
	 */
	EAttribute getLineupPlayer_DefensivePosition();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.reports.gamereports.ActionDescription <em>Action Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Description</em>'.
	 * @see org.bpy.score.reports.gamereports.ActionDescription
	 * @generated
	 */
	EClass getActionDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.ActionDescription#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header</em>'.
	 * @see org.bpy.score.reports.gamereports.ActionDescription#getHeader()
	 * @see #getActionDescription()
	 * @generated
	 */
	EAttribute getActionDescription_Header();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.ActionDescription#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.bpy.score.reports.gamereports.ActionDescription#getContent()
	 * @see #getActionDescription()
	 * @generated
	 */
	EAttribute getActionDescription_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.ActionDescription#getResume <em>Resume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resume</em>'.
	 * @see org.bpy.score.reports.gamereports.ActionDescription#getResume()
	 * @see #getActionDescription()
	 * @generated
	 */
	EAttribute getActionDescription_Resume();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.reports.gamereports.ActionDescription#getTeam <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Team</em>'.
	 * @see org.bpy.score.reports.gamereports.ActionDescription#getTeam()
	 * @see #getActionDescription()
	 * @generated
	 */
	EAttribute getActionDescription_Team();

	/**
	 * Returns the meta object for enum '{@link org.bpy.score.reports.gamereports.TEAM <em>TEAM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TEAM</em>'.
	 * @see org.bpy.score.reports.gamereports.TEAM
	 * @generated
	 */
	EEnum getTEAM();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GameReportsFactory getGameReportsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.GameReportImpl <em>Game Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.GameReportImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getGameReport()
		 * @generated
		 */
		EClass GAME_REPORT = eINSTANCE.getGameReport();

		/**
		 * The meta object literal for the '<em><b>Banner Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__BANNER_PATH = eINSTANCE.getGameReport_BannerPath();

		/**
		 * The meta object literal for the '<em><b>Visitor Sheet Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__VISITOR_SHEET_PATH = eINSTANCE.getGameReport_VisitorSheetPath();

		/**
		 * The meta object literal for the '<em><b>Visitor Stats</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__VISITOR_STATS = eINSTANCE.getGameReport_VisitorStats();

		/**
		 * The meta object literal for the '<em><b>Hometeam Stats</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__HOMETEAM_STATS = eINSTANCE.getGameReport_HometeamStats();

		/**
		 * The meta object literal for the '<em><b>Umpires</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__UMPIRES = eINSTANCE.getGameReport_Umpires();

		/**
		 * The meta object literal for the '<em><b>Scorekeepers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__SCOREKEEPERS = eINSTANCE.getGameReport_Scorekeepers();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__DATE = eINSTANCE.getGameReport_Date();

		/**
		 * The meta object literal for the '<em><b>Starting Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__STARTING_TIME = eINSTANCE.getGameReport_StartingTime();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__DURATION = eINSTANCE.getGameReport_Duration();

		/**
		 * The meta object literal for the '<em><b>Town</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__TOWN = eINSTANCE.getGameReport_Town();

		/**
		 * The meta object literal for the '<em><b>Stadium</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__STADIUM = eINSTANCE.getGameReport_Stadium();

		/**
		 * The meta object literal for the '<em><b>Hometeam Sheet Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__HOMETEAM_SHEET_PATH = eINSTANCE.getGameReport_HometeamSheetPath();

		/**
		 * The meta object literal for the '<em><b>Game Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__GAME_NUMBER = eINSTANCE.getGameReport_GameNumber();

		/**
		 * The meta object literal for the '<em><b>Play By Play</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__PLAY_BY_PLAY = eINSTANCE.getGameReport_PlayByPlay();

		/**
		 * The meta object literal for the '<em><b>Pdf File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__PDF_FILE = eINSTANCE.getGameReport_PdfFile();

		/**
		 * The meta object literal for the '<em><b>General Stats</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__GENERAL_STATS = eINSTANCE.getGameReport_GeneralStats();

		/**
		 * The meta object literal for the '<em><b>Visitor Lineup</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__VISITOR_LINEUP = eINSTANCE.getGameReport_VisitorLineup();

		/**
		 * The meta object literal for the '<em><b>Hometeam Lineup</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_REPORT__HOMETEAM_LINEUP = eINSTANCE.getGameReport_HometeamLineup();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_REPORT__MIXED = eINSTANCE.getGameReport_Mixed();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl <em>Team Statisitics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getTeamStatisitics()
		 * @generated
		 */
		EClass TEAM_STATISITICS = eINSTANCE.getTeamStatisitics();

		/**
		 * The meta object literal for the '<em><b>Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISITICS__PLAYERS = eINSTANCE.getTeamStatisitics_Players();

		/**
		 * The meta object literal for the '<em><b>Team Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISITICS__TEAM_NAME = eINSTANCE.getTeamStatisitics_TeamName();

		/**
		 * The meta object literal for the '<em><b>Town</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISITICS__TOWN = eINSTANCE.getTeamStatisitics_Town();

		/**
		 * The meta object literal for the '<em><b>Game Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISITICS__GAME_WIN = eINSTANCE.getTeamStatisitics_GameWin();

		/**
		 * The meta object literal for the '<em><b>Game Lose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISITICS__GAME_LOSE = eINSTANCE.getTeamStatisitics_GameLose();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.PitcherStatisticImpl <em>Pitcher Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.PitcherStatisticImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPitcherStatistic()
		 * @generated
		 */
		EClass PITCHER_STATISTIC = eINSTANCE.getPitcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Batter Front</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__BATTER_FRONT = eINSTANCE.getPitcherStatistic_BatterFront();

		/**
		 * The meta object literal for the '<em><b>At Bats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__AT_BATS = eINSTANCE.getPitcherStatistic_AtBats();

		/**
		 * The meta object literal for the '<em><b>Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__RUNS = eINSTANCE.getPitcherStatistic_Runs();

		/**
		 * The meta object literal for the '<em><b>Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__HITS = eINSTANCE.getPitcherStatistic_Hits();

		/**
		 * The meta object literal for the '<em><b>Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__DOUBLE = eINSTANCE.getPitcherStatistic_Double();

		/**
		 * The meta object literal for the '<em><b>Triple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__TRIPLE = eINSTANCE.getPitcherStatistic_Triple();

		/**
		 * The meta object literal for the '<em><b>Homerun</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__HOMERUN = eINSTANCE.getPitcherStatistic_Homerun();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Hit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__SACRIFICE_HIT = eINSTANCE.getPitcherStatistic_SacrificeHit();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Fly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__SACRIFICE_FLY = eINSTANCE.getPitcherStatistic_SacrificeFly();

		/**
		 * The meta object literal for the '<em><b>Base On Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__BASE_ON_BALL = eINSTANCE.getPitcherStatistic_BaseOnBall();

		/**
		 * The meta object literal for the '<em><b>Intentionalbase On Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL = eINSTANCE.getPitcherStatistic_IntentionalbaseOnBall();

		/**
		 * The meta object literal for the '<em><b>Hit By Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__HIT_BY_PITCH = eINSTANCE.getPitcherStatistic_HitByPitch();

		/**
		 * The meta object literal for the '<em><b>Interferance Obstruction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION = eINSTANCE.getPitcherStatistic_InterferanceObstruction();

		/**
		 * The meta object literal for the '<em><b>Strike Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__STRIKE_OUT = eINSTANCE.getPitcherStatistic_StrikeOut();

		/**
		 * The meta object literal for the '<em><b>Earned Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__EARNED_RUNS = eINSTANCE.getPitcherStatistic_EarnedRuns();

		/**
		 * The meta object literal for the '<em><b>Wild Pitches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__WILD_PITCHES = eINSTANCE.getPitcherStatistic_WildPitches();

		/**
		 * The meta object literal for the '<em><b>Balks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__BALKS = eINSTANCE.getPitcherStatistic_Balks();

		/**
		 * The meta object literal for the '<em><b>Pitch Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__PITCH_COUNT = eINSTANCE.getPitcherStatistic_PitchCount();

		/**
		 * The meta object literal for the '<em><b>Pitch Count K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__PITCH_COUNT_K = eINSTANCE.getPitcherStatistic_PitchCountK();

		/**
		 * The meta object literal for the '<em><b>Pitch Count B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__PITCH_COUNT_B = eINSTANCE.getPitcherStatistic_PitchCountB();

		/**
		 * The meta object literal for the '<em><b>Pitch Count Others</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__PITCH_COUNT_OTHERS = eINSTANCE.getPitcherStatistic_PitchCountOthers();

		/**
		 * The meta object literal for the '<em><b>Runner Left On Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE = eINSTANCE.getPitcherStatistic_RunnerLeftOnBase();

		/**
		 * The meta object literal for the '<em><b>Caught Stealing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__CAUGHT_STEALING = eINSTANCE.getPitcherStatistic_CaughtStealing();

		/**
		 * The meta object literal for the '<em><b>Game Lose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__GAME_LOSE = eINSTANCE.getPitcherStatistic_GameLose();

		/**
		 * The meta object literal for the '<em><b>Game Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__GAME_WIN = eINSTANCE.getPitcherStatistic_GameWin();

		/**
		 * The meta object literal for the '<em><b>Game Save</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__GAME_SAVE = eINSTANCE.getPitcherStatistic_GameSave();

		/**
		 * The meta object literal for the '<em><b>Ips</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__IPS = eINSTANCE.getPitcherStatistic_Ips();

		/**
		 * The meta object literal for the '<em><b>Pitcher Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__PITCHER_ORDER = eINSTANCE.getPitcherStatistic_PitcherOrder();

		/**
		 * The meta object literal for the '<em><b>Fly Outs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__FLY_OUTS = eINSTANCE.getPitcherStatistic_FlyOuts();

		/**
		 * The meta object literal for the '<em><b>Grounded Outs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTIC__GROUNDED_OUTS = eINSTANCE.getPitcherStatistic_GroundedOuts();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl <em>Defensive Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getDefensiveStatistic()
		 * @generated
		 */
		EClass DEFENSIVE_STATISTIC = eINSTANCE.getDefensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Put Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTIC__PUT_OUT = eINSTANCE.getDefensiveStatistic_PutOut();

		/**
		 * The meta object literal for the '<em><b>Assitances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTIC__ASSITANCES = eINSTANCE.getDefensiveStatistic_Assitances();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTIC__ERRORS = eINSTANCE.getDefensiveStatistic_Errors();

		/**
		 * The meta object literal for the '<em><b>Double Play</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTIC__DOUBLE_PLAY = eINSTANCE.getDefensiveStatistic_DoublePlay();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.CatcherStatisticImpl <em>Catcher Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.CatcherStatisticImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getCatcherStatistic()
		 * @generated
		 */
		EClass CATCHER_STATISTIC = eINSTANCE.getCatcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Pass Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATCHER_STATISTIC__PASS_BALL = eINSTANCE.getCatcherStatistic_PassBall();

		/**
		 * The meta object literal for the '<em><b>Stolen Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATCHER_STATISTIC__STOLEN_BASE = eINSTANCE.getCatcherStatistic_StolenBase();

		/**
		 * The meta object literal for the '<em><b>Caught Stealing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATCHER_STATISTIC__CAUGHT_STEALING = eINSTANCE.getCatcherStatistic_CaughtStealing();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.OffensiveStatisticImpl <em>Offensive Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.OffensiveStatisticImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getOffensiveStatistic()
		 * @generated
		 */
		EClass OFFENSIVE_STATISTIC = eINSTANCE.getOffensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Plate Appearances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__PLATE_APPEARANCES = eINSTANCE.getOffensiveStatistic_PlateAppearances();

		/**
		 * The meta object literal for the '<em><b>At Bats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__AT_BATS = eINSTANCE.getOffensiveStatistic_AtBats();

		/**
		 * The meta object literal for the '<em><b>Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__RUNS = eINSTANCE.getOffensiveStatistic_Runs();

		/**
		 * The meta object literal for the '<em><b>Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__HITS = eINSTANCE.getOffensiveStatistic_Hits();

		/**
		 * The meta object literal for the '<em><b>Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__DOUBLE = eINSTANCE.getOffensiveStatistic_Double();

		/**
		 * The meta object literal for the '<em><b>Triple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__TRIPLE = eINSTANCE.getOffensiveStatistic_Triple();

		/**
		 * The meta object literal for the '<em><b>Homerun</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__HOMERUN = eINSTANCE.getOffensiveStatistic_Homerun();

		/**
		 * The meta object literal for the '<em><b>Grounded Double Play</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY = eINSTANCE.getOffensiveStatistic_GroundedDoublePlay();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Hit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__SACRIFICE_HIT = eINSTANCE.getOffensiveStatistic_SacrificeHit();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Fly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__SACRIFICE_FLY = eINSTANCE.getOffensiveStatistic_SacrificeFly();

		/**
		 * The meta object literal for the '<em><b>Base On Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__BASE_ON_BALL = eINSTANCE.getOffensiveStatistic_BaseOnBall();

		/**
		 * The meta object literal for the '<em><b>Intentionalbase On Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL = eINSTANCE.getOffensiveStatistic_IntentionalbaseOnBall();

		/**
		 * The meta object literal for the '<em><b>Hit By Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__HIT_BY_PITCH = eINSTANCE.getOffensiveStatistic_HitByPitch();

		/**
		 * The meta object literal for the '<em><b>Interferance Obstruction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION = eINSTANCE.getOffensiveStatistic_InterferanceObstruction();

		/**
		 * The meta object literal for the '<em><b>Stolen Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__STOLEN_BASE = eINSTANCE.getOffensiveStatistic_StolenBase();

		/**
		 * The meta object literal for the '<em><b>Caught Stealing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__CAUGHT_STEALING = eINSTANCE.getOffensiveStatistic_CaughtStealing();

		/**
		 * The meta object literal for the '<em><b>Strike Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__STRIKE_OUT = eINSTANCE.getOffensiveStatistic_StrikeOut();

		/**
		 * The meta object literal for the '<em><b>Rbi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTIC__RBI = eINSTANCE.getOffensiveStatistic_Rbi();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.PlayerImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Pitcher Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYER__PITCHER_STATISTIC = eINSTANCE.getPlayer_PitcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Defensive Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYER__DEFENSIVE_STATISTIC = eINSTANCE.getPlayer_DefensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Catchers Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYER__CATCHERS_STATISTIC = eINSTANCE.getPlayer_CatchersStatistic();

		/**
		 * The meta object literal for the '<em><b>Offensive Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYER__OFFENSIVE_STATISTIC = eINSTANCE.getPlayer_OffensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__NAME = eINSTANCE.getPlayer_Name();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.PlayByPlayImpl <em>Play By Play</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.PlayByPlayImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPlayByPlay()
		 * @generated
		 */
		EClass PLAY_BY_PLAY = eINSTANCE.getPlayByPlay();

		/**
		 * The meta object literal for the '<em><b>Actiondescription</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAY_BY_PLAY__ACTIONDESCRIPTION = eINSTANCE.getPlayByPlay_Actiondescription();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl <em>Game General Stats</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getGameGeneralStats()
		 * @generated
		 */
		EClass GAME_GENERAL_STATS = eINSTANCE.getGameGeneralStats();

		/**
		 * The meta object literal for the '<em><b>Points Per Inning</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_GENERAL_STATS__POINTS_PER_INNING = eINSTANCE.getGameGeneralStats_PointsPerInning();

		/**
		 * The meta object literal for the '<em><b>Visitor Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__VISITOR_ERRORS = eINSTANCE.getGameGeneralStats_VisitorErrors();

		/**
		 * The meta object literal for the '<em><b>Visitor Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__VISITOR_HITS = eINSTANCE.getGameGeneralStats_VisitorHits();

		/**
		 * The meta object literal for the '<em><b>Visitor Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__VISITOR_RUNS = eINSTANCE.getGameGeneralStats_VisitorRuns();

		/**
		 * The meta object literal for the '<em><b>Hometeam Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__HOMETEAM_ERRORS = eINSTANCE.getGameGeneralStats_HometeamErrors();

		/**
		 * The meta object literal for the '<em><b>Hometeam Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__HOMETEAM_RUNS = eINSTANCE.getGameGeneralStats_HometeamRuns();

		/**
		 * The meta object literal for the '<em><b>Hometeam Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_GENERAL_STATS__HOMETEAM_HITS = eINSTANCE.getGameGeneralStats_HometeamHits();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.PointsPerInningImpl <em>Points Per Inning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.PointsPerInningImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getPointsPerInning()
		 * @generated
		 */
		EClass POINTS_PER_INNING = eINSTANCE.getPointsPerInning();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINTS_PER_INNING__ORDER = eINSTANCE.getPointsPerInning_Order();

		/**
		 * The meta object literal for the '<em><b>Visitor Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINTS_PER_INNING__VISITOR_POINT = eINSTANCE.getPointsPerInning_VisitorPoint();

		/**
		 * The meta object literal for the '<em><b>Hometeam Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINTS_PER_INNING__HOMETEAM_POINT = eINSTANCE.getPointsPerInning_HometeamPoint();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.StartingLineupImpl <em>Starting Lineup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.StartingLineupImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getStartingLineup()
		 * @generated
		 */
		EClass STARTING_LINEUP = eINSTANCE.getStartingLineup();

		/**
		 * The meta object literal for the '<em><b>Team Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTING_LINEUP__TEAM_NAME = eINSTANCE.getStartingLineup_TeamName();

		/**
		 * The meta object literal for the '<em><b>Lineup Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STARTING_LINEUP__LINEUP_PLAYERS = eINSTANCE.getStartingLineup_LineupPlayers();

		/**
		 * The meta object literal for the '<em><b>Field Pictrure Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTING_LINEUP__FIELD_PICTRURE_LINK = eINSTANCE.getStartingLineup_FieldPictrureLink();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.LineupPlayerImpl <em>Lineup Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.LineupPlayerImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getLineupPlayer()
		 * @generated
		 */
		EClass LINEUP_PLAYER = eINSTANCE.getLineupPlayer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_PLAYER__NAME = eINSTANCE.getLineupPlayer_Name();

		/**
		 * The meta object literal for the '<em><b>Offensive Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_PLAYER__OFFENSIVE_POSITION = eINSTANCE.getLineupPlayer_OffensivePosition();

		/**
		 * The meta object literal for the '<em><b>Defensive Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_PLAYER__DEFENSIVE_POSITION = eINSTANCE.getLineupPlayer_DefensivePosition();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl <em>Action Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getActionDescription()
		 * @generated
		 */
		EClass ACTION_DESCRIPTION = eINSTANCE.getActionDescription();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DESCRIPTION__HEADER = eINSTANCE.getActionDescription_Header();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DESCRIPTION__CONTENT = eINSTANCE.getActionDescription_Content();

		/**
		 * The meta object literal for the '<em><b>Resume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DESCRIPTION__RESUME = eINSTANCE.getActionDescription_Resume();

		/**
		 * The meta object literal for the '<em><b>Team</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DESCRIPTION__TEAM = eINSTANCE.getActionDescription_Team();

		/**
		 * The meta object literal for the '{@link org.bpy.score.reports.gamereports.TEAM <em>TEAM</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.reports.gamereports.TEAM
		 * @see org.bpy.score.reports.gamereports.impl.GameReportsPackageImpl#getTEAM()
		 * @generated
		 */
		EEnum TEAM = eINSTANCE.getTEAM();

	}

} //GameReportsPackage
