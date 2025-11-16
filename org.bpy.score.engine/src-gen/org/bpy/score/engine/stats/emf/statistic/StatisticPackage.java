/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticFactory
 * @model kind="package"
 * @generated
 */
public interface StatisticPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statistic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.org.bpy.score";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statistic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatisticPackage eINSTANCE = org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl <em>Game Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getGameStatistic()
	 * @generated
	 */
	int GAME_STATISTIC = 0;

	/**
	 * The feature id for the '<em><b>Game Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__GAME_NAME = 0;

	/**
	 * The feature id for the '<em><b>Hometeam</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__HOMETEAM = 1;

	/**
	 * The feature id for the '<em><b>Visitor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__VISITOR = 2;

	/**
	 * The feature id for the '<em><b>Winning Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__WINNING_PITCHER = 3;

	/**
	 * The feature id for the '<em><b>Loosing Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__LOOSING_PITCHER = 4;

	/**
	 * The feature id for the '<em><b>Save Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC__SAVE_PITCHER = 5;

	/**
	 * The number of structural features of the '<em>Game Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Game Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl <em>Team Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getTeamStatistic()
	 * @generated
	 */
	int TEAM_STATISTIC = 1;

	/**
	 * The feature id for the '<em><b>General Inning Stats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__GENERAL_INNING_STATS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Total Catcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC = 2;

	/**
	 * The feature id for the '<em><b>Total Defensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC = 3;

	/**
	 * The feature id for the '<em><b>Total Pitcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC = 4;

	/**
	 * The feature id for the '<em><b>Total Offensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC = 5;

	/**
	 * The feature id for the '<em><b>Double Play Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__DOUBLE_PLAY_COUNTER = 6;

	/**
	 * The feature id for the '<em><b>Tie Break Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__TIE_BREAK_COUNTER = 7;

	/**
	 * The feature id for the '<em><b>Current Offensive Player</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER = 8;

	/**
	 * The feature id for the '<em><b>Current Defensive Player</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER = 9;

	/**
	 * The feature id for the '<em><b>Current Catcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__CURRENT_CATCHER = 10;

	/**
	 * The feature id for the '<em><b>Current Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__CURRENT_PITCHER = 11;

	/**
	 * The feature id for the '<em><b>Catchers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__CATCHERS = 12;

	/**
	 * The feature id for the '<em><b>Pitchers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__PITCHERS = 13;

	/**
	 * The feature id for the '<em><b>Players</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__PLAYERS = 14;

	/**
	 * The feature id for the '<em><b>Gw Rbi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__GW_RBI = 15;

	/**
	 * The feature id for the '<em><b>Earned Against The Team</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM = 16;

	/**
	 * The feature id for the '<em><b>Final Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC__FINAL_SCORE = 17;

	/**
	 * The number of structural features of the '<em>Team Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Team Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl <em>Inning General Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getInningGeneralStatistic()
	 * @generated
	 */
	int INNING_GENERAL_STATISTIC = 2;

	/**
	 * The feature id for the '<em><b>At Bats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__AT_BATS = 0;

	/**
	 * The feature id for the '<em><b>Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__RUNS = 1;

	/**
	 * The feature id for the '<em><b>Earned Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__EARNED_RUNS = 2;

	/**
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__HITS = 3;

	/**
	 * The feature id for the '<em><b>Assitances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__ASSITANCES = 4;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__ERRORS = 5;

	/**
	 * The feature id for the '<em><b>Lob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC__LOB = 6;

	/**
	 * The number of structural features of the '<em>Inning General Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Inning General Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNING_GENERAL_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl <em>Innin Statictic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getInninStatictic()
	 * @generated
	 */
	int INNIN_STATICTIC = 3;

	/**
	 * The feature id for the '<em><b>Inning Stat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNIN_STATICTIC__INNING_STAT = 0;

	/**
	 * The feature id for the '<em><b>Cumulative Inning Stat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNIN_STATICTIC__CUMULATIVE_INNING_STAT = 1;

	/**
	 * The number of structural features of the '<em>Innin Statictic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNIN_STATICTIC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Innin Statictic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INNIN_STATICTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl <em>Offensive Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getOffensiveStatistic()
	 * @generated
	 */
	int OFFENSIVE_STATISTIC = 4;

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
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl <em>Pitcher Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPitcherStatistic()
	 * @generated
	 */
	int PITCHER_STATISTIC = 5;

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
	 * The number of structural features of the '<em>Pitcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC_FEATURE_COUNT = 23;

	/**
	 * The number of operations of the '<em>Pitcher Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PITCHER_STATISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl <em>Catcher Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getCatcherStatistic()
	 * @generated
	 */
	int CATCHER_STATISTIC = 6;

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
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.DefensiveStatisticImpl <em>Defensive Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.DefensiveStatisticImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getDefensiveStatistic()
	 * @generated
	 */
	int DEFENSIVE_STATISTIC = 7;

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
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl <em>Lineup Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getLineupEntry()
	 * @generated
	 */
	int LINEUP_ENTRY = 8;

	/**
	 * The feature id for the '<em><b>Is Defensive Entry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__IS_DEFENSIVE_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Defensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__DEFENSIVE_POSITION = 1;

	/**
	 * The feature id for the '<em><b>Offensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__OFFENSIVE_POSITION = 2;

	/**
	 * The feature id for the '<em><b>Defensive Position Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX = 3;

	/**
	 * The feature id for the '<em><b>Start Entry Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__START_ENTRY_IP = 4;

	/**
	 * The feature id for the '<em><b>Ip Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__IP_PLAYED = 5;

	/**
	 * The feature id for the '<em><b>Player Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__PLAYER_DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Associated Objects</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__ASSOCIATED_OBJECTS = 7;

	/**
	 * The feature id for the '<em><b>Defensive Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__DEFENSIVE_STATISTIC = 8;

	/**
	 * The feature id for the '<em><b>Offensive Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__OFFENSIVE_STATISTIC = 9;

	/**
	 * The feature id for the '<em><b>Catcher Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__CATCHER_STATISTIC = 10;

	/**
	 * The feature id for the '<em><b>Pitcher Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__PITCHER_STATISTIC = 11;

	/**
	 * The feature id for the '<em><b>Actif</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__ACTIF = 12;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__ORDER_NUMBER = 13;

	/**
	 * The feature id for the '<em><b>Laterality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY__LATERALITY = 14;

	/**
	 * The number of structural features of the '<em>Lineup Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Lineup Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEUP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.EStringToAssociatedObjectMapImpl <em>EString To Associated Object Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.EStringToAssociatedObjectMapImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getEStringToAssociatedObjectMap()
	 * @generated
	 */
	int ESTRING_TO_ASSOCIATED_OBJECT_MAP = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ASSOCIATED_OBJECT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ASSOCIATED_OBJECT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Associated Object Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ASSOCIATED_OBJECT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To Associated Object Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ASSOCIATED_OBJECT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.EStringToLineupEntryTypeMapImpl <em>EString To Lineup Entry Type Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.EStringToLineupEntryTypeMapImpl
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getEStringToLineupEntryTypeMap()
	 * @generated
	 */
	int ESTRING_TO_LINEUP_ENTRY_TYPE_MAP = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To Lineup Entry Type Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LINEUP_ENTRY_TYPE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EString To Lineup Entry Type Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_LINEUP_ENTRY_TYPE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Lineup Entry Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getLineupEntryType()
	 * @generated
	 */
	int LINEUP_ENTRY_TYPE = 11;

	/**
	 * The meta object id for the '<em>Associated Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getAssociatedObject()
	 * @generated
	 */
	int ASSOCIATED_OBJECT = 12;

	/**
	 * The meta object id for the '<em>Player Description</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.manager.lineup.LineupPlayerDescription
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPlayerDescription()
	 * @generated
	 */
	int PLAYER_DESCRIPTION = 13;

	/**
	 * The meta object id for the '<em>Defensive Statistic Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getDefensiveStatisticType()
	 * @generated
	 */
	int DEFENSIVE_STATISTIC_TYPE = 14;

	/**
	 * The meta object id for the '<em>Catcher Statistic Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getCatcherStatisticType()
	 * @generated
	 */
	int CATCHER_STATISTIC_TYPE = 15;

	/**
	 * The meta object id for the '<em>Offensive Statistic Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getOffensiveStatisticType()
	 * @generated
	 */
	int OFFENSIVE_STATISTIC_TYPE = 16;

	/**
	 * The meta object id for the '<em>Pitcher Statistic Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic
	 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPitcherStatisticType()
	 * @generated
	 */
	int PITCHER_STATISTIC_TYPE = 17;


	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic <em>Game Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic
	 * @generated
	 */
	EClass getGameStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getGameName <em>Game Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Game Name</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getGameName()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EAttribute getGameStatistic_GameName();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getHometeam <em>Hometeam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hometeam</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getHometeam()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EReference getGameStatistic_Hometeam();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visitor</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getVisitor()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EReference getGameStatistic_Visitor();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getWinningPitcher <em>Winning Pitcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Winning Pitcher</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getWinningPitcher()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EAttribute getGameStatistic_WinningPitcher();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getLoosingPitcher <em>Loosing Pitcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loosing Pitcher</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getLoosingPitcher()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EAttribute getGameStatistic_LoosingPitcher();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getSavePitcher <em>Save Pitcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Save Pitcher</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic#getSavePitcher()
	 * @see #getGameStatistic()
	 * @generated
	 */
	EAttribute getGameStatistic_SavePitcher();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic <em>Team Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic
	 * @generated
	 */
	EClass getTeamStatistic();

	/**
	 * Returns the meta object for the containment reference list '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGeneralInningStats <em>General Inning Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>General Inning Stats</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGeneralInningStats()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_GeneralInningStats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getName()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalCatcherStatistic <em>Total Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Total Catcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalCatcherStatistic()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_TotalCatcherStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalDefensiveStatistic <em>Total Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Total Defensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalDefensiveStatistic()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_TotalDefensiveStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalPitcherStatistic <em>Total Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Total Pitcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalPitcherStatistic()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_TotalPitcherStatistic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalOffensiveStatistic <em>Total Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Total Offensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalOffensiveStatistic()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_TotalOffensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getDoublePlayCounter <em>Double Play Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Play Counter</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getDoublePlayCounter()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_DoublePlayCounter();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTieBreakCounter <em>Tie Break Counter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tie Break Counter</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTieBreakCounter()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_TieBreakCounter();

	/**
	 * Returns the meta object for the map '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentOffensivePlayer <em>Current Offensive Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Current Offensive Player</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentOffensivePlayer()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_CurrentOffensivePlayer();

	/**
	 * Returns the meta object for the map '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentDefensivePlayer <em>Current Defensive Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Current Defensive Player</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentDefensivePlayer()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EReference getTeamStatistic_CurrentDefensivePlayer();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentCatcher <em>Current Catcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Catcher</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentCatcher()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_CurrentCatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentPitcher <em>Current Pitcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Pitcher</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentPitcher()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_CurrentPitcher();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCatchers <em>Catchers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Catchers</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCatchers()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_Catchers();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPitchers <em>Pitchers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pitchers</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPitchers()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_Pitchers();

	/**
	 * Returns the meta object for the attribute list '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPlayers <em>Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Players</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPlayers()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_Players();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGwRbi <em>Gw Rbi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gw Rbi</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGwRbi()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_GwRbi();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getEarnedAgainstTheTeam <em>Earned Against The Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Earned Against The Team</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getEarnedAgainstTheTeam()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_EarnedAgainstTheTeam();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getFinalScore <em>Final Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final Score</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getFinalScore()
	 * @see #getTeamStatistic()
	 * @generated
	 */
	EAttribute getTeamStatistic_FinalScore();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic <em>Inning General Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inning General Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic
	 * @generated
	 */
	EClass getInningGeneralStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAtBats()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getRuns()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getEarnedRuns <em>Earned Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Earned Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getEarnedRuns()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_EarnedRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getHits()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAssitances <em>Assitances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assitances</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAssitances()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_Assitances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getErrors()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getLob <em>Lob</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lob</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getLob()
	 * @see #getInningGeneralStatistic()
	 * @generated
	 */
	EAttribute getInningGeneralStatistic_Lob();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic <em>Innin Statictic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Innin Statictic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InninStatictic
	 * @generated
	 */
	EClass getInninStatictic();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getInningStat <em>Inning Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inning Stat</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InninStatictic#getInningStat()
	 * @see #getInninStatictic()
	 * @generated
	 */
	EReference getInninStatictic_InningStat();

	/**
	 * Returns the meta object for the containment reference '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getCumulativeInningStat <em>Cumulative Inning Stat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cumulative Inning Stat</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.InninStatictic#getCumulativeInningStat()
	 * @see #getInninStatictic()
	 * @generated
	 */
	EReference getInninStatictic_CumulativeInningStat();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic
	 * @generated
	 */
	EClass getOffensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getPlateAppearances <em>Plate Appearances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plate Appearances</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getPlateAppearances()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_PlateAppearances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getAtBats()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getRuns()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHits()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getDouble <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getDouble()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Double();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getTriple <em>Triple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getTriple()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Triple();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHomerun <em>Homerun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Homerun</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHomerun()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Homerun();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getGroundedDoublePlay <em>Grounded Double Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grounded Double Play</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getGroundedDoublePlay()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_GroundedDoublePlay();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getSacrificeHit <em>Sacrifice Hit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Hit</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getSacrificeHit()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_SacrificeHit();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getSacrificeFly <em>Sacrifice Fly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Fly</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getSacrificeFly()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_SacrificeFly();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getBaseOnBall <em>Base On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base On Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getBaseOnBall()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_BaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intentionalbase On Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getIntentionalbaseOnBall()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_IntentionalbaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHitByPitch <em>Hit By Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit By Pitch</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getHitByPitch()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_HitByPitch();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interferance Obstruction</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getInterferanceObstruction()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_InterferanceObstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getStolenBase <em>Stolen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getStolenBase()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_StolenBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getCaughtStealing()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_CaughtStealing();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getStrikeOut <em>Strike Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strike Out</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getStrikeOut()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_StrikeOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getRbi <em>Rbi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rbi</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic#getRbi()
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	EAttribute getOffensiveStatistic_Rbi();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pitcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic
	 * @generated
	 */
	EClass getPitcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBatterFront <em>Batter Front</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Batter Front</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBatterFront()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_BatterFront();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getAtBats <em>At Bats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bats</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getAtBats()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_AtBats();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRuns <em>Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRuns()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Runs();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHits <em>Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHits()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Hits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getDouble <em>Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getDouble()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Double();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getTriple <em>Triple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getTriple()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Triple();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHomerun <em>Homerun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Homerun</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHomerun()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Homerun();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Hit</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeHit()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_SacrificeHit();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Fly</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeFly()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_SacrificeFly();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base On Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBaseOnBall()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_BaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intentionalbase On Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getIntentionalbaseOnBall()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_IntentionalbaseOnBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hit By Pitch</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHitByPitch()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_HitByPitch();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interferance Obstruction</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getInterferanceObstruction()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_InterferanceObstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getStrikeOut <em>Strike Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strike Out</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getStrikeOut()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_StrikeOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Earned Runs</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getEarnedRuns()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_EarnedRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wild Pitches</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getWildPitches()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_WildPitches();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBalks <em>Balks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balks</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBalks()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_Balks();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCount <em>Pitch Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCount()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCount();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count K</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountK()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountK();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count B</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountB()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountB();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch Count Others</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountOthers()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_PitchCountOthers();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runner Left On Base</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRunnerLeftOnBase()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_RunnerLeftOnBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getCaughtStealing()
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	EAttribute getPitcherStatistic_CaughtStealing();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic <em>Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic
	 * @generated
	 */
	EClass getCatcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getPassBall <em>Pass Ball</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pass Ball</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getPassBall()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_PassBall();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getStolenBase <em>Stolen Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stolen Base</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getStolenBase()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_StolenBase();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getCaughtStealing <em>Caught Stealing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caught Stealing</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic#getCaughtStealing()
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	EAttribute getCatcherStatistic_CaughtStealing();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic
	 * @generated
	 */
	EClass getDefensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getPutOut <em>Put Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Put Out</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getPutOut()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_PutOut();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getAssitances <em>Assitances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assitances</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getAssitances()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_Assitances();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getErrors()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getDoublePlay <em>Double Play</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Play</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getDoublePlay()
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	EAttribute getDefensiveStatistic_DoublePlay();

	/**
	 * Returns the meta object for class '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry <em>Lineup Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lineup Entry</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry
	 * @generated
	 */
	EClass getLineupEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isIsDefensiveEntry <em>Is Defensive Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Defensive Entry</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#isIsDefensiveEntry()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_IsDefensiveEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePosition <em>Defensive Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defensive Position</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePosition()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_DefensivePosition();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensivePosition <em>Offensive Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offensive Position</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensivePosition()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_OffensivePosition();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePositionIndex <em>Defensive Position Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defensive Position Index</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePositionIndex()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_DefensivePositionIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getStartEntryIp <em>Start Entry Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Entry Ip</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getStartEntryIp()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_StartEntryIp();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getIpPlayed <em>Ip Played</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip Played</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getIpPlayed()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_IpPlayed();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPlayerDescription <em>Player Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Player Description</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPlayerDescription()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_PlayerDescription();

	/**
	 * Returns the meta object for the map '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getAssociatedObjects <em>Associated Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Associated Objects</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getAssociatedObjects()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EReference getLineupEntry_AssociatedObjects();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensiveStatistic()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_DefensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offensive Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensiveStatistic()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_OffensiveStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getCatcherStatistic <em>Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Catcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getCatcherStatistic()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_CatcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitcher Statistic</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPitcherStatistic()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_PitcherStatistic();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isActif <em>Actif</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actif</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#isActif()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_Actif();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOrderNumber <em>Order Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Number</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOrderNumber()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_OrderNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getLaterality <em>Laterality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Laterality</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry#getLaterality()
	 * @see #getLineupEntry()
	 * @generated
	 */
	EAttribute getLineupEntry_Laterality();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Associated Object Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Associated Object Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.bpy.score.engine.stats.emf.statistic.AssociatedObject" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToAssociatedObjectMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToAssociatedObjectMap()
	 * @generated
	 */
	EAttribute getEStringToAssociatedObjectMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToAssociatedObjectMap()
	 * @generated
	 */
	EAttribute getEStringToAssociatedObjectMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Lineup Entry Type Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Lineup Entry Type Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" valueRequired="true"
	 * @generated
	 */
	EClass getEStringToLineupEntryTypeMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToLineupEntryTypeMap()
	 * @generated
	 */
	EAttribute getEStringToLineupEntryTypeMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToLineupEntryTypeMap()
	 * @generated
	 */
	EAttribute getEStringToLineupEntryTypeMap_Value();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry <em>Lineup Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lineup Entry Type</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry
	 * @model instanceClass="org.bpy.score.engine.stats.emf.statistic.LineupEntry"
	 * @generated
	 */
	EDataType getLineupEntryType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Associated Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Associated Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getAssociatedObject();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.manager.lineup.LineupPlayerDescription <em>Player Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Player Description</em>'.
	 * @see org.bpy.score.engine.manager.lineup.LineupPlayerDescription
	 * @model instanceClass="org.bpy.score.engine.manager.lineup.LineupPlayerDescription"
	 * @generated
	 */
	EDataType getPlayerDescription();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic <em>Defensive Statistic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Defensive Statistic Type</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic
	 * @model instanceClass="org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic"
	 * @generated
	 */
	EDataType getDefensiveStatisticType();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic <em>Catcher Statistic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Catcher Statistic Type</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic
	 * @model instanceClass="org.bpy.score.engine.stats.emf.statistic.CatcherStatistic"
	 * @generated
	 */
	EDataType getCatcherStatisticType();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic <em>Offensive Statistic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Offensive Statistic Type</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic
	 * @model instanceClass="org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic"
	 * @generated
	 */
	EDataType getOffensiveStatisticType();

	/**
	 * Returns the meta object for data type '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic <em>Pitcher Statistic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pitcher Statistic Type</em>'.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic
	 * @model instanceClass="org.bpy.score.engine.stats.emf.statistic.PitcherStatistic"
	 * @generated
	 */
	EDataType getPitcherStatisticType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatisticFactory getStatisticFactory();

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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl <em>Game Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getGameStatistic()
		 * @generated
		 */
		EClass GAME_STATISTIC = eINSTANCE.getGameStatistic();

		/**
		 * The meta object literal for the '<em><b>Game Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_STATISTIC__GAME_NAME = eINSTANCE.getGameStatistic_GameName();

		/**
		 * The meta object literal for the '<em><b>Hometeam</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_STATISTIC__HOMETEAM = eINSTANCE.getGameStatistic_Hometeam();

		/**
		 * The meta object literal for the '<em><b>Visitor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME_STATISTIC__VISITOR = eINSTANCE.getGameStatistic_Visitor();

		/**
		 * The meta object literal for the '<em><b>Winning Pitcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_STATISTIC__WINNING_PITCHER = eINSTANCE.getGameStatistic_WinningPitcher();

		/**
		 * The meta object literal for the '<em><b>Loosing Pitcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_STATISTIC__LOOSING_PITCHER = eINSTANCE.getGameStatistic_LoosingPitcher();

		/**
		 * The meta object literal for the '<em><b>Save Pitcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GAME_STATISTIC__SAVE_PITCHER = eINSTANCE.getGameStatistic_SavePitcher();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl <em>Team Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getTeamStatistic()
		 * @generated
		 */
		EClass TEAM_STATISTIC = eINSTANCE.getTeamStatistic();

		/**
		 * The meta object literal for the '<em><b>General Inning Stats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__GENERAL_INNING_STATS = eINSTANCE.getTeamStatistic_GeneralInningStats();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__NAME = eINSTANCE.getTeamStatistic_Name();

		/**
		 * The meta object literal for the '<em><b>Total Catcher Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC = eINSTANCE.getTeamStatistic_TotalCatcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Total Defensive Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC = eINSTANCE.getTeamStatistic_TotalDefensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Total Pitcher Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC = eINSTANCE.getTeamStatistic_TotalPitcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Total Offensive Statistic</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC = eINSTANCE.getTeamStatistic_TotalOffensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Double Play Counter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__DOUBLE_PLAY_COUNTER = eINSTANCE.getTeamStatistic_DoublePlayCounter();

		/**
		 * The meta object literal for the '<em><b>Tie Break Counter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__TIE_BREAK_COUNTER = eINSTANCE.getTeamStatistic_TieBreakCounter();

		/**
		 * The meta object literal for the '<em><b>Current Offensive Player</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER = eINSTANCE.getTeamStatistic_CurrentOffensivePlayer();

		/**
		 * The meta object literal for the '<em><b>Current Defensive Player</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER = eINSTANCE.getTeamStatistic_CurrentDefensivePlayer();

		/**
		 * The meta object literal for the '<em><b>Current Catcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__CURRENT_CATCHER = eINSTANCE.getTeamStatistic_CurrentCatcher();

		/**
		 * The meta object literal for the '<em><b>Current Pitcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__CURRENT_PITCHER = eINSTANCE.getTeamStatistic_CurrentPitcher();

		/**
		 * The meta object literal for the '<em><b>Catchers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__CATCHERS = eINSTANCE.getTeamStatistic_Catchers();

		/**
		 * The meta object literal for the '<em><b>Pitchers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__PITCHERS = eINSTANCE.getTeamStatistic_Pitchers();

		/**
		 * The meta object literal for the '<em><b>Players</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__PLAYERS = eINSTANCE.getTeamStatistic_Players();

		/**
		 * The meta object literal for the '<em><b>Gw Rbi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__GW_RBI = eINSTANCE.getTeamStatistic_GwRbi();

		/**
		 * The meta object literal for the '<em><b>Earned Against The Team</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM = eINSTANCE.getTeamStatistic_EarnedAgainstTheTeam();

		/**
		 * The meta object literal for the '<em><b>Final Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM_STATISTIC__FINAL_SCORE = eINSTANCE.getTeamStatistic_FinalScore();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl <em>Inning General Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getInningGeneralStatistic()
		 * @generated
		 */
		EClass INNING_GENERAL_STATISTIC = eINSTANCE.getInningGeneralStatistic();

		/**
		 * The meta object literal for the '<em><b>At Bats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__AT_BATS = eINSTANCE.getInningGeneralStatistic_AtBats();

		/**
		 * The meta object literal for the '<em><b>Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__RUNS = eINSTANCE.getInningGeneralStatistic_Runs();

		/**
		 * The meta object literal for the '<em><b>Earned Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__EARNED_RUNS = eINSTANCE.getInningGeneralStatistic_EarnedRuns();

		/**
		 * The meta object literal for the '<em><b>Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__HITS = eINSTANCE.getInningGeneralStatistic_Hits();

		/**
		 * The meta object literal for the '<em><b>Assitances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__ASSITANCES = eINSTANCE.getInningGeneralStatistic_Assitances();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__ERRORS = eINSTANCE.getInningGeneralStatistic_Errors();

		/**
		 * The meta object literal for the '<em><b>Lob</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INNING_GENERAL_STATISTIC__LOB = eINSTANCE.getInningGeneralStatistic_Lob();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl <em>Innin Statictic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getInninStatictic()
		 * @generated
		 */
		EClass INNIN_STATICTIC = eINSTANCE.getInninStatictic();

		/**
		 * The meta object literal for the '<em><b>Inning Stat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INNIN_STATICTIC__INNING_STAT = eINSTANCE.getInninStatictic_InningStat();

		/**
		 * The meta object literal for the '<em><b>Cumulative Inning Stat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INNIN_STATICTIC__CUMULATIVE_INNING_STAT = eINSTANCE.getInninStatictic_CumulativeInningStat();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl <em>Offensive Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getOffensiveStatistic()
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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl <em>Pitcher Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPitcherStatistic()
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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl <em>Catcher Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getCatcherStatistic()
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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.DefensiveStatisticImpl <em>Defensive Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.DefensiveStatisticImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getDefensiveStatistic()
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
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl <em>Lineup Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getLineupEntry()
		 * @generated
		 */
		EClass LINEUP_ENTRY = eINSTANCE.getLineupEntry();

		/**
		 * The meta object literal for the '<em><b>Is Defensive Entry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__IS_DEFENSIVE_ENTRY = eINSTANCE.getLineupEntry_IsDefensiveEntry();

		/**
		 * The meta object literal for the '<em><b>Defensive Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__DEFENSIVE_POSITION = eINSTANCE.getLineupEntry_DefensivePosition();

		/**
		 * The meta object literal for the '<em><b>Offensive Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__OFFENSIVE_POSITION = eINSTANCE.getLineupEntry_OffensivePosition();

		/**
		 * The meta object literal for the '<em><b>Defensive Position Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX = eINSTANCE.getLineupEntry_DefensivePositionIndex();

		/**
		 * The meta object literal for the '<em><b>Start Entry Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__START_ENTRY_IP = eINSTANCE.getLineupEntry_StartEntryIp();

		/**
		 * The meta object literal for the '<em><b>Ip Played</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__IP_PLAYED = eINSTANCE.getLineupEntry_IpPlayed();

		/**
		 * The meta object literal for the '<em><b>Player Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__PLAYER_DESCRIPTION = eINSTANCE.getLineupEntry_PlayerDescription();

		/**
		 * The meta object literal for the '<em><b>Associated Objects</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINEUP_ENTRY__ASSOCIATED_OBJECTS = eINSTANCE.getLineupEntry_AssociatedObjects();

		/**
		 * The meta object literal for the '<em><b>Defensive Statistic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__DEFENSIVE_STATISTIC = eINSTANCE.getLineupEntry_DefensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Offensive Statistic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__OFFENSIVE_STATISTIC = eINSTANCE.getLineupEntry_OffensiveStatistic();

		/**
		 * The meta object literal for the '<em><b>Catcher Statistic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__CATCHER_STATISTIC = eINSTANCE.getLineupEntry_CatcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Pitcher Statistic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__PITCHER_STATISTIC = eINSTANCE.getLineupEntry_PitcherStatistic();

		/**
		 * The meta object literal for the '<em><b>Actif</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__ACTIF = eINSTANCE.getLineupEntry_Actif();

		/**
		 * The meta object literal for the '<em><b>Order Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__ORDER_NUMBER = eINSTANCE.getLineupEntry_OrderNumber();

		/**
		 * The meta object literal for the '<em><b>Laterality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEUP_ENTRY__LATERALITY = eINSTANCE.getLineupEntry_Laterality();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.EStringToAssociatedObjectMapImpl <em>EString To Associated Object Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.EStringToAssociatedObjectMapImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getEStringToAssociatedObjectMap()
		 * @generated
		 */
		EClass ESTRING_TO_ASSOCIATED_OBJECT_MAP = eINSTANCE.getEStringToAssociatedObjectMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ASSOCIATED_OBJECT_MAP__KEY = eINSTANCE.getEStringToAssociatedObjectMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ASSOCIATED_OBJECT_MAP__VALUE = eINSTANCE.getEStringToAssociatedObjectMap_Value();

		/**
		 * The meta object literal for the '{@link org.bpy.score.engine.stats.emf.statistic.impl.EStringToLineupEntryTypeMapImpl <em>EString To Lineup Entry Type Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.EStringToLineupEntryTypeMapImpl
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getEStringToLineupEntryTypeMap()
		 * @generated
		 */
		EClass ESTRING_TO_LINEUP_ENTRY_TYPE_MAP = eINSTANCE.getEStringToLineupEntryTypeMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__KEY = eINSTANCE.getEStringToLineupEntryTypeMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__VALUE = eINSTANCE.getEStringToLineupEntryTypeMap_Value();

		/**
		 * The meta object literal for the '<em>Lineup Entry Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getLineupEntryType()
		 * @generated
		 */
		EDataType LINEUP_ENTRY_TYPE = eINSTANCE.getLineupEntryType();

		/**
		 * The meta object literal for the '<em>Associated Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getAssociatedObject()
		 * @generated
		 */
		EDataType ASSOCIATED_OBJECT = eINSTANCE.getAssociatedObject();

		/**
		 * The meta object literal for the '<em>Player Description</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.manager.lineup.LineupPlayerDescription
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPlayerDescription()
		 * @generated
		 */
		EDataType PLAYER_DESCRIPTION = eINSTANCE.getPlayerDescription();

		/**
		 * The meta object literal for the '<em>Defensive Statistic Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getDefensiveStatisticType()
		 * @generated
		 */
		EDataType DEFENSIVE_STATISTIC_TYPE = eINSTANCE.getDefensiveStatisticType();

		/**
		 * The meta object literal for the '<em>Catcher Statistic Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getCatcherStatisticType()
		 * @generated
		 */
		EDataType CATCHER_STATISTIC_TYPE = eINSTANCE.getCatcherStatisticType();

		/**
		 * The meta object literal for the '<em>Offensive Statistic Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getOffensiveStatisticType()
		 * @generated
		 */
		EDataType OFFENSIVE_STATISTIC_TYPE = eINSTANCE.getOffensiveStatisticType();

		/**
		 * The meta object literal for the '<em>Pitcher Statistic Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic
		 * @see org.bpy.score.engine.stats.emf.statistic.impl.StatisticPackageImpl#getPitcherStatisticType()
		 * @generated
		 */
		EDataType PITCHER_STATISTIC_TYPE = eINSTANCE.getPitcherStatisticType();

	}

} //StatisticPackage
