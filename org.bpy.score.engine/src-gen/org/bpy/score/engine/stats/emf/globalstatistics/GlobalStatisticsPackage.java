/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsFactory
 * @model kind="package"
 * @generated
 */
public interface GlobalStatisticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "globalstatistics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:/www.org.bpy.score/global/stats";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "globalstatistics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlobalStatisticsPackage eINSTANCE = org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticImpl <em>Global Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getGlobalStatistic()
	 * @generated
	 */
	int GLOBAL_STATISTIC = 0;

	/**
	 * The feature id for the '<em><b>Teams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_STATISTIC__TEAMS = 0;

	/**
	 * The number of structural features of the '<em>Global Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_STATISTIC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Global Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl <em>Team Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getTeamStatistics()
	 * @generated
	 */
	int TEAM_STATISTICS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__NAME = 0;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__CITY = 1;

	/**
	 * The feature id for the '<em><b>Game Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__GAME_PLAYED = 2;

	/**
	 * The feature id for the '<em><b>Game Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__GAME_WIN = 3;

	/**
	 * The feature id for the '<em><b>Game Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__GAME_LOSE = 4;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS__MEMBERS = 5;

	/**
	 * The number of structural features of the '<em>Team Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Team Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTICS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Pitcher Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__PITCHER_STATISTICS = 1;

	/**
	 * The feature id for the '<em><b>Offensive Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__OFFENSIVE_STATISTICS = 2;

	/**
	 * The feature id for the '<em><b>Defensive Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__DEFENSIVE_STATISTICS = 3;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl <em>Pitcher Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getPitcherStatistics()
	 * @generated
	 */
	int PITCHER_STATISTICS = 3;

	/**
	 * The feature id for the '<em><b>Game Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS__GAME_WIN = 0;

	/**
	 * The feature id for the '<em><b>Game Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS__GAME_LOSE = 1;

	/**
	 * The feature id for the '<em><b>Game Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS__GAME_SAVE = 2;

	/**
	 * The feature id for the '<em><b>Earned Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS__EARNED_RUNS = 3;

	/**
	 * The feature id for the '<em><b>Ips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS__IPS = 4;

	/**
	 * The number of structural features of the '<em>Pitcher Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Pitcher Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTICS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl <em>Offensive Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getOffensiveStatistics()
	 * @generated
	 */
	int OFFENSIVE_STATISTICS = 4;

	/**
	 * The feature id for the '<em><b>At Bats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__AT_BATS = 0;

	/**
	 * The feature id for the '<em><b>Batting Average</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__BATTING_AVERAGE = 1;

	/**
	 * The feature id for the '<em><b>Caught Stealing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__CAUGHT_STEALING = 2;

	/**
	 * The feature id for the '<em><b>Doubles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__DOUBLES = 3;

	/**
	 * The feature id for the '<em><b>Extra Base Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__EXTRA_BASE_HITS = 4;

	/**
	 * The feature id for the '<em><b>Games Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__GAMES_PLAYED = 5;

	/**
	 * The feature id for the '<em><b>Grand Slam</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__GRAND_SLAM = 6;

	/**
	 * The feature id for the '<em><b>Ground Into Double Play</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY = 7;

	/**
	 * The feature id for the '<em><b>Groundout To Airout Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO = 8;

	/**
	 * The feature id for the '<em><b>Hit By Pitchs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__HIT_BY_PITCHS = 9;

	/**
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__HITS = 10;

	/**
	 * The feature id for the '<em><b>Home Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__HOME_RUNS = 11;

	/**
	 * The feature id for the '<em><b>Intentional Walks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__INTENTIONAL_WALKS = 12;

	/**
	 * The feature id for the '<em><b>Left On Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__LEFT_ON_BASE = 13;

	/**
	 * The feature id for the '<em><b>On Base Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE = 14;

	/**
	 * The feature id for the '<em><b>On Base Plus Slugging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING = 15;

	/**
	 * The feature id for the '<em><b>Plate Appearance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__PLATE_APPEARANCE = 16;

	/**
	 * The feature id for the '<em><b>Reached On Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__REACHED_ON_ERROR = 17;

	/**
	 * The feature id for the '<em><b>Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__RUNS = 18;

	/**
	 * The feature id for the '<em><b>Rbis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__RBIS = 19;

	/**
	 * The feature id for the '<em><b>Sacrifice Bunt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__SACRIFICE_BUNT = 20;

	/**
	 * The feature id for the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__SACRIFICE_FLY = 21;

	/**
	 * The feature id for the '<em><b>Single</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__SINGLE = 22;

	/**
	 * The feature id for the '<em><b>Slugging Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE = 23;

	/**
	 * The feature id for the '<em><b>Stolen Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__STOLEN_BASE = 24;

	/**
	 * The feature id for the '<em><b>Stolen Base Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE = 25;

	/**
	 * The feature id for the '<em><b>Total Bases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__TOTAL_BASES = 26;

	/**
	 * The feature id for the '<em><b>Triples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__TRIPLES = 27;

	/**
	 * The feature id for the '<em><b>Walks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__WALKS = 28;

	/**
	 * The feature id for the '<em><b>Walk Off</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__WALK_OFF = 29;

	/**
	 * The number of structural features of the '<em>Offensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS_FEATURE_COUNT = 30;

	/**
	 * The number of operations of the '<em>Offensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl <em>Defensive Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getDefensiveStatistics()
	 * @generated
	 */
	int DEFENSIVE_STATISTICS = 5;

	/**
	 * The feature id for the '<em><b>Assists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__ASSISTS = 0;

	/**
	 * The feature id for the '<em><b>Caught Stealing Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE = 1;

	/**
	 * The feature id for the '<em><b>Double Plays</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__DOUBLE_PLAYS = 2;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__ERRORS = 3;

	/**
	 * The feature id for the '<em><b>Fielding Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE = 4;

	/**
	 * The feature id for the '<em><b>Innings Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__INNINGS_PLAYED = 5;

	/**
	 * The feature id for the '<em><b>Outs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__OUTS = 6;

	/**
	 * The feature id for the '<em><b>Outfield Assist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__OUTFIELD_ASSIST = 7;

	/**
	 * The feature id for the '<em><b>Passed Ball</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__PASSED_BALL = 8;

	/**
	 * The feature id for the '<em><b>Putouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__PUTOUTS = 9;

	/**
	 * The feature id for the '<em><b>Total Chances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__TOTAL_CHANCES = 10;

	/**
	 * The feature id for the '<em><b>Triple Play</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__TRIPLE_PLAY = 11;

	/**
	 * The number of structural features of the '<em>Defensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Defensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic <em>Global Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic
	 * @generated
	 */
	EClass getGlobalStatistic();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic#getTeams <em>Teams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Teams</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic#getTeams()
	 * @see #getGlobalStatistic()
	 * @generated
	 */
	EReference getGlobalStatistic_Teams();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics <em>Team Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics
	 * @generated
	 */
	EClass getTeamStatistics();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getName()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EAttribute getTeamStatistics_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getCity()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EAttribute getTeamStatistics_City();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGamePlayed <em>Game Played</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Played</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGamePlayed()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EAttribute getTeamStatistics_GamePlayed();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameWin <em>Game Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Win</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameWin()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EAttribute getTeamStatistics_GameWin();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameLose <em>Game Lose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Lose</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameLose()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EAttribute getTeamStatistics_GameLose();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getMembers()
	 * @see #getTeamStatistics()
	 * @generated
	 */
	EReference getTeamStatistics_Members();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member#getName()
	 * @see #getMember()
	 * @generated
	 */
	EAttribute getMember_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getPitcherStatistics <em>Pitcher Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pitcher Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member#getPitcherStatistics()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_PitcherStatistics();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getOffensiveStatistics <em>Offensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Offensive Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member#getOffensiveStatistics()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_OffensiveStatistics();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getDefensiveStatistics <em>Defensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defensive Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member#getDefensiveStatistics()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_DefensiveStatistics();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics <em>Pitcher Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pitcher Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics
	 * @generated
	 */
	EClass getPitcherStatistics();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameWin <em>Game Win</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Win</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameWin()
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	EAttribute getPitcherStatistics_GameWin();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameLose <em>Game Lose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Lose</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameLose()
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	EAttribute getPitcherStatistics_GameLose();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameSave <em>Game Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Save</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameSave()
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	EAttribute getPitcherStatistics_GameSave();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getEarnedRuns <em>Earned Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Earned Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getEarnedRuns()
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	EAttribute getPitcherStatistics_EarnedRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getIps <em>Ips</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ips</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getIps()
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	EAttribute getPitcherStatistics_Ips();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics <em>Offensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offensive Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics
	 * @generated
	 */
	EClass getOffensiveStatistics();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHits()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHomeRuns <em>Home Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHomeRuns()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_HomeRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getIntentionalWalks <em>Intentional Walks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intentional Walks</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getIntentionalWalks()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_IntentionalWalks();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getLeftOnBase <em>Left On Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left On Base</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getLeftOnBase()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_LeftOnBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePercentage <em>On Base Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Base Percentage</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePercentage()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_OnBasePercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePlusSlugging <em>On Base Plus Slugging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Base Plus Slugging</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePlusSlugging()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_OnBasePlusSlugging();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getAtBats()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBattingAverage <em>Batting Average</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Batting Average</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBattingAverage()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_BattingAverage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getCaughtStealing()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_CaughtStealing();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubles <em>Doubles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doubles</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubles()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Doubles();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getExtraBaseHits <em>Extra Base Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extra Base Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getExtraBaseHits()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_ExtraBaseHits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGamesPlayed <em>Games Played</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Games Played</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGamesPlayed()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_GamesPlayed();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGrandSlam <em>Grand Slam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grand Slam</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGrandSlam()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_GrandSlam();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundIntoDoublePlay <em>Ground Into Double Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ground Into Double Play</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundIntoDoublePlay()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_GroundIntoDoublePlay();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundoutToAiroutRatio <em>Groundout To Airout Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Groundout To Airout Ratio</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundoutToAiroutRatio()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_GroundoutToAiroutRatio();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitByPitchs <em>Hit By Pitchs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit By Pitchs</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitByPitchs()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_HitByPitchs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getPlateAppearance <em>Plate Appearance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plate Appearance</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getPlateAppearance()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_PlateAppearance();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getReachedOnError <em>Reached On Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reached On Error</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getReachedOnError()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_ReachedOnError();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRuns()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRbis <em>Rbis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rbis</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRbis()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Rbis();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeBunt <em>Sacrifice Bunt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Bunt</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeBunt()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_SacrificeBunt();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFly <em>Sacrifice Fly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Fly</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFly()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_SacrificeFly();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSingle <em>Single</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Single</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSingle()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Single();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSluggingPercentage <em>Slugging Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slugging Percentage</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSluggingPercentage()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_SluggingPercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBase <em>Stolen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBase()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_StolenBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBasePercentage <em>Stolen Base Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base Percentage</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBasePercentage()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_StolenBasePercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTotalBases <em>Total Bases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Bases</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTotalBases()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_TotalBases();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTriples <em>Triples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triples</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTriples()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Triples();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalks <em>Walks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Walks</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalks()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_Walks();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalkOff <em>Walk Off</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Walk Off</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalkOff()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_WalkOff();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics <em>Defensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defensive Statistics</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics
	 * @generated
	 */
	EClass getDefensiveStatistics();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPutouts <em>Putouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Putouts</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPutouts()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_Putouts();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTotalChances <em>Total Chances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Chances</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTotalChances()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_TotalChances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTriplePlay <em>Triple Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple Play</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTriplePlay()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_TriplePlay();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getAssists <em>Assists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assists</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getAssists()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_Assists();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getCaughtStealingPercentage <em>Caught Stealing Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing Percentage</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getCaughtStealingPercentage()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_CaughtStealingPercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getDoublePlays <em>Double Plays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Plays</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getDoublePlays()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_DoublePlays();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getErrors()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getFieldingPercentage <em>Fielding Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fielding Percentage</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getFieldingPercentage()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_FieldingPercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getInningsPlayed <em>Innings Played</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Innings Played</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getInningsPlayed()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_InningsPlayed();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOuts <em>Outs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outs</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOuts()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_Outs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOutfieldAssist <em>Outfield Assist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outfield Assist</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOutfieldAssist()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_OutfieldAssist();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPassedBall <em>Passed Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passed Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPassedBall()
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	EAttribute getDefensiveStatistics_PassedBall();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GlobalStatisticsFactory getGlobalStatisticsFactory();

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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticImpl <em>Global Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getGlobalStatistic()
		 * @generated
		 */
		EClass GLOBAL_STATISTIC = eINSTANCE.getGlobalStatistic();

		/**
		 * The meta object literal for the '<em><b>Teams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_STATISTIC__TEAMS = eINSTANCE.getGlobalStatistic_Teams();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl <em>Team Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getTeamStatistics()
		 * @generated
		 */
		EClass TEAM_STATISTICS = eINSTANCE.getTeamStatistics();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTICS__NAME = eINSTANCE.getTeamStatistics_Name();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTICS__CITY = eINSTANCE.getTeamStatistics_City();

		/**
		 * The meta object literal for the '<em><b>Game Played</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTICS__GAME_PLAYED = eINSTANCE.getTeamStatistics_GamePlayed();

		/**
		 * The meta object literal for the '<em><b>Game Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTICS__GAME_WIN = eINSTANCE.getTeamStatistics_GameWin();

		/**
		 * The meta object literal for the '<em><b>Game Lose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTICS__GAME_LOSE = eINSTANCE.getTeamStatistics_GameLose();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTICS__MEMBERS = eINSTANCE.getTeamStatistics_Members();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER__NAME = eINSTANCE.getMember_Name();

		/**
		 * The meta object literal for the '<em><b>Pitcher Statistics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__PITCHER_STATISTICS = eINSTANCE.getMember_PitcherStatistics();

		/**
		 * The meta object literal for the '<em><b>Offensive Statistics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__OFFENSIVE_STATISTICS = eINSTANCE.getMember_OffensiveStatistics();

		/**
		 * The meta object literal for the '<em><b>Defensive Statistics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__DEFENSIVE_STATISTICS = eINSTANCE.getMember_DefensiveStatistics();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl <em>Pitcher Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getPitcherStatistics()
		 * @generated
		 */
		EClass PITCHER_STATISTICS = eINSTANCE.getPitcherStatistics();

		/**
		 * The meta object literal for the '<em><b>Game Win</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTICS__GAME_WIN = eINSTANCE.getPitcherStatistics_GameWin();

		/**
		 * The meta object literal for the '<em><b>Game Lose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTICS__GAME_LOSE = eINSTANCE.getPitcherStatistics_GameLose();

		/**
		 * The meta object literal for the '<em><b>Game Save</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTICS__GAME_SAVE = eINSTANCE.getPitcherStatistics_GameSave();

		/**
		 * The meta object literal for the '<em><b>Earned Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTICS__EARNED_RUNS = eINSTANCE.getPitcherStatistics_EarnedRuns();

		/**
		 * The meta object literal for the '<em><b>Ips</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PITCHER_STATISTICS__IPS = eINSTANCE.getPitcherStatistics_Ips();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl <em>Offensive Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getOffensiveStatistics()
		 * @generated
		 */
		EClass OFFENSIVE_STATISTICS = eINSTANCE.getOffensiveStatistics();

		/**
		 * The meta object literal for the '<em><b>Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__HITS = eINSTANCE.getOffensiveStatistics_Hits();

		/**
		 * The meta object literal for the '<em><b>Home Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__HOME_RUNS = eINSTANCE.getOffensiveStatistics_HomeRuns();

		/**
		 * The meta object literal for the '<em><b>Intentional Walks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__INTENTIONAL_WALKS = eINSTANCE.getOffensiveStatistics_IntentionalWalks();

		/**
		 * The meta object literal for the '<em><b>Left On Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__LEFT_ON_BASE = eINSTANCE.getOffensiveStatistics_LeftOnBase();

		/**
		 * The meta object literal for the '<em><b>On Base Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE = eINSTANCE.getOffensiveStatistics_OnBasePercentage();

		/**
		 * The meta object literal for the '<em><b>On Base Plus Slugging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING = eINSTANCE.getOffensiveStatistics_OnBasePlusSlugging();

		/**
		 * The meta object literal for the '<em><b>At Bats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__AT_BATS = eINSTANCE.getOffensiveStatistics_AtBats();

		/**
		 * The meta object literal for the '<em><b>Batting Average</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__BATTING_AVERAGE = eINSTANCE.getOffensiveStatistics_BattingAverage();

		/**
		 * The meta object literal for the '<em><b>Caught Stealing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__CAUGHT_STEALING = eINSTANCE.getOffensiveStatistics_CaughtStealing();

		/**
		 * The meta object literal for the '<em><b>Doubles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__DOUBLES = eINSTANCE.getOffensiveStatistics_Doubles();

		/**
		 * The meta object literal for the '<em><b>Extra Base Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__EXTRA_BASE_HITS = eINSTANCE.getOffensiveStatistics_ExtraBaseHits();

		/**
		 * The meta object literal for the '<em><b>Games Played</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__GAMES_PLAYED = eINSTANCE.getOffensiveStatistics_GamesPlayed();

		/**
		 * The meta object literal for the '<em><b>Grand Slam</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__GRAND_SLAM = eINSTANCE.getOffensiveStatistics_GrandSlam();

		/**
		 * The meta object literal for the '<em><b>Ground Into Double Play</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY = eINSTANCE.getOffensiveStatistics_GroundIntoDoublePlay();

		/**
		 * The meta object literal for the '<em><b>Groundout To Airout Ratio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO = eINSTANCE.getOffensiveStatistics_GroundoutToAiroutRatio();

		/**
		 * The meta object literal for the '<em><b>Hit By Pitchs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__HIT_BY_PITCHS = eINSTANCE.getOffensiveStatistics_HitByPitchs();

		/**
		 * The meta object literal for the '<em><b>Plate Appearance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__PLATE_APPEARANCE = eINSTANCE.getOffensiveStatistics_PlateAppearance();

		/**
		 * The meta object literal for the '<em><b>Reached On Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__REACHED_ON_ERROR = eINSTANCE.getOffensiveStatistics_ReachedOnError();

		/**
		 * The meta object literal for the '<em><b>Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__RUNS = eINSTANCE.getOffensiveStatistics_Runs();

		/**
		 * The meta object literal for the '<em><b>Rbis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__RBIS = eINSTANCE.getOffensiveStatistics_Rbis();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Bunt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__SACRIFICE_BUNT = eINSTANCE.getOffensiveStatistics_SacrificeBunt();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Fly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__SACRIFICE_FLY = eINSTANCE.getOffensiveStatistics_SacrificeFly();

		/**
		 * The meta object literal for the '<em><b>Single</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__SINGLE = eINSTANCE.getOffensiveStatistics_Single();

		/**
		 * The meta object literal for the '<em><b>Slugging Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE = eINSTANCE.getOffensiveStatistics_SluggingPercentage();

		/**
		 * The meta object literal for the '<em><b>Stolen Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__STOLEN_BASE = eINSTANCE.getOffensiveStatistics_StolenBase();

		/**
		 * The meta object literal for the '<em><b>Stolen Base Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE = eINSTANCE.getOffensiveStatistics_StolenBasePercentage();

		/**
		 * The meta object literal for the '<em><b>Total Bases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__TOTAL_BASES = eINSTANCE.getOffensiveStatistics_TotalBases();

		/**
		 * The meta object literal for the '<em><b>Triples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__TRIPLES = eINSTANCE.getOffensiveStatistics_Triples();

		/**
		 * The meta object literal for the '<em><b>Walks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__WALKS = eINSTANCE.getOffensiveStatistics_Walks();

		/**
		 * The meta object literal for the '<em><b>Walk Off</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__WALK_OFF = eINSTANCE.getOffensiveStatistics_WalkOff();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl <em>Defensive Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl
		 * @see org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsPackageImpl#getDefensiveStatistics()
		 * @generated
		 */
		EClass DEFENSIVE_STATISTICS = eINSTANCE.getDefensiveStatistics();

		/**
		 * The meta object literal for the '<em><b>Putouts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__PUTOUTS = eINSTANCE.getDefensiveStatistics_Putouts();

		/**
		 * The meta object literal for the '<em><b>Total Chances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__TOTAL_CHANCES = eINSTANCE.getDefensiveStatistics_TotalChances();

		/**
		 * The meta object literal for the '<em><b>Triple Play</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__TRIPLE_PLAY = eINSTANCE.getDefensiveStatistics_TriplePlay();

		/**
		 * The meta object literal for the '<em><b>Assists</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__ASSISTS = eINSTANCE.getDefensiveStatistics_Assists();

		/**
		 * The meta object literal for the '<em><b>Caught Stealing Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE = eINSTANCE.getDefensiveStatistics_CaughtStealingPercentage();

		/**
		 * The meta object literal for the '<em><b>Double Plays</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__DOUBLE_PLAYS = eINSTANCE.getDefensiveStatistics_DoublePlays();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__ERRORS = eINSTANCE.getDefensiveStatistics_Errors();

		/**
		 * The meta object literal for the '<em><b>Fielding Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE = eINSTANCE.getDefensiveStatistics_FieldingPercentage();

		/**
		 * The meta object literal for the '<em><b>Innings Played</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__INNINGS_PLAYED = eINSTANCE.getDefensiveStatistics_InningsPlayed();

		/**
		 * The meta object literal for the '<em><b>Outs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__OUTS = eINSTANCE.getDefensiveStatistics_Outs();

		/**
		 * The meta object literal for the '<em><b>Outfield Assist</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__OUTFIELD_ASSIST = eINSTANCE.getDefensiveStatistics_OutfieldAssist();

		/**
		 * The meta object literal for the '<em><b>Passed Ball</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__PASSED_BALL = eINSTANCE.getDefensiveStatistics_PassedBall();

	}

} //GlobalStatisticsPackage
