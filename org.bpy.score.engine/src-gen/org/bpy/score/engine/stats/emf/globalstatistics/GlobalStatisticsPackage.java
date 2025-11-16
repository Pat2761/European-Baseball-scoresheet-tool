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
	 * The feature id for the '<em><b>Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__HITS = 0;

	/**
	 * The feature id for the '<em><b>Base On Balls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__BASE_ON_BALLS = 1;

	/**
	 * The feature id for the '<em><b>Hits By Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__HITS_BY_PITCH = 2;

	/**
	 * The feature id for the '<em><b>At Bats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__AT_BATS = 3;

	/**
	 * The feature id for the '<em><b>Sacrifice Flies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__SACRIFICE_FLIES = 4;

	/**
	 * The feature id for the '<em><b>Double Base Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS = 5;

	/**
	 * The feature id for the '<em><b>Triple Base Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS = 6;

	/**
	 * The feature id for the '<em><b>Four Base Hits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__FOUR_BASE_HITS = 7;

	/**
	 * The feature id for the '<em><b>Plate Appearance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS__PLATE_APPEARANCE = 8;

	/**
	 * The number of structural features of the '<em>Offensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFENSIVE_STATISTICS_FEATURE_COUNT = 9;

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
	 * The feature id for the '<em><b>Putouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__PUTOUTS = 0;

	/**
	 * The feature id for the '<em><b>Assists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__ASSISTS = 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS__ERRORS = 2;

	/**
	 * The number of structural features of the '<em>Defensive Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFENSIVE_STATISTICS_FEATURE_COUNT = 3;

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
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBaseOnBalls <em>Base On Balls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base On Balls</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBaseOnBalls()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_BaseOnBalls();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitsByPitch <em>Hits By Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hits By Pitch</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitsByPitch()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_HitsByPitch();

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
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFlies <em>Sacrifice Flies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sacrifice Flies</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFlies()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_SacrificeFlies();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubleBaseHits <em>Double Base Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Double Base Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubleBaseHits()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_DoubleBaseHits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTripleBaseHits <em>Triple Base Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triple Base Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTripleBaseHits()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_TripleBaseHits();

	/**
	 * Returns the meta object for the attribute '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getFourBaseHits <em>Four Base Hits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Four Base Hits</em>'.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getFourBaseHits()
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	EAttribute getOffensiveStatistics_FourBaseHits();

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
		 * The meta object literal for the '<em><b>Base On Balls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__BASE_ON_BALLS = eINSTANCE.getOffensiveStatistics_BaseOnBalls();

		/**
		 * The meta object literal for the '<em><b>Hits By Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__HITS_BY_PITCH = eINSTANCE.getOffensiveStatistics_HitsByPitch();

		/**
		 * The meta object literal for the '<em><b>At Bats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__AT_BATS = eINSTANCE.getOffensiveStatistics_AtBats();

		/**
		 * The meta object literal for the '<em><b>Sacrifice Flies</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__SACRIFICE_FLIES = eINSTANCE.getOffensiveStatistics_SacrificeFlies();

		/**
		 * The meta object literal for the '<em><b>Double Base Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS = eINSTANCE.getOffensiveStatistics_DoubleBaseHits();

		/**
		 * The meta object literal for the '<em><b>Triple Base Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS = eINSTANCE.getOffensiveStatistics_TripleBaseHits();

		/**
		 * The meta object literal for the '<em><b>Four Base Hits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__FOUR_BASE_HITS = eINSTANCE.getOffensiveStatistics_FourBaseHits();

		/**
		 * The meta object literal for the '<em><b>Plate Appearance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFENSIVE_STATISTICS__PLATE_APPEARANCE = eINSTANCE.getOffensiveStatistics_PlateAppearance();

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
		 * The meta object literal for the '<em><b>Assists</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__ASSISTS = eINSTANCE.getDefensiveStatistics_Assists();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFENSIVE_STATISTICS__ERRORS = eINSTANCE.getDefensiveStatistics_Errors();

	}

} //GlobalStatisticsPackage
