/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsFactory;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.Member;
import org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalStatisticsPackageImpl extends EPackageImpl implements GlobalStatisticsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teamStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pitcherStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offensiveStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defensiveStatisticsEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GlobalStatisticsPackageImpl() {
		super(eNS_URI, GlobalStatisticsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link GlobalStatisticsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GlobalStatisticsPackage init() {
		if (isInited) return (GlobalStatisticsPackage)EPackage.Registry.INSTANCE.getEPackage(GlobalStatisticsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGlobalStatisticsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GlobalStatisticsPackageImpl theGlobalStatisticsPackage = registeredGlobalStatisticsPackage instanceof GlobalStatisticsPackageImpl ? (GlobalStatisticsPackageImpl)registeredGlobalStatisticsPackage : new GlobalStatisticsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGlobalStatisticsPackage.createPackageContents();

		// Initialize created meta-data
		theGlobalStatisticsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGlobalStatisticsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GlobalStatisticsPackage.eNS_URI, theGlobalStatisticsPackage);
		return theGlobalStatisticsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGlobalStatistic() {
		return globalStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGlobalStatistic_Teams() {
		return (EReference)globalStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTeamStatistics() {
		return teamStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistics_Name() {
		return (EAttribute)teamStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistics_City() {
		return (EAttribute)teamStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistics_GamePlayed() {
		return (EAttribute)teamStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistics_GameWin() {
		return (EAttribute)teamStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistics_GameLose() {
		return (EAttribute)teamStatisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistics_Members() {
		return (EReference)teamStatisticsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMember() {
		return memberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMember_Name() {
		return (EAttribute)memberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMember_PitcherStatistics() {
		return (EReference)memberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMember_OffensiveStatistics() {
		return (EReference)memberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMember_DefensiveStatistics() {
		return (EReference)memberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPitcherStatistics() {
		return pitcherStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistics_GameWin() {
		return (EAttribute)pitcherStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistics_GameLose() {
		return (EAttribute)pitcherStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistics_GameSave() {
		return (EAttribute)pitcherStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistics_EarnedRuns() {
		return (EAttribute)pitcherStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistics_Ips() {
		return (EAttribute)pitcherStatisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOffensiveStatistics() {
		return offensiveStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Hits() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_HomeRuns() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_IntentionalWalks() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_LeftOnBase() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_OnBasePercentage() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_OnBasePlusSlugging() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_AtBats() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_BattingAverage() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_CaughtStealing() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Doubles() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_ExtraBaseHits() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_GamesPlayed() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_GrandSlam() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_GroundIntoDoublePlay() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_GroundoutToAiroutRatio() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_HitByPitchs() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_PlateAppearance() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_ReachedOnError() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Runs() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Rbis() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_SacrificeBunt() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_SacrificeFly() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Single() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_SluggingPercentage() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_StolenBase() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_StolenBasePercentage() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_TotalBases() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Triples() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_Walks() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_WalkOff() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefensiveStatistics() {
		return defensiveStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Putouts() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_TotalChances() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_TriplePlay() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Assists() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_CaughtStealingPercentage() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_DoublePlays() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Errors() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_FieldingPercentage() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_InningsPlayed() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Outs() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_OutfieldAssist() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_PassedBall() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GlobalStatisticsFactory getGlobalStatisticsFactory() {
		return (GlobalStatisticsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		globalStatisticEClass = createEClass(GLOBAL_STATISTIC);
		createEReference(globalStatisticEClass, GLOBAL_STATISTIC__TEAMS);

		teamStatisticsEClass = createEClass(TEAM_STATISTICS);
		createEAttribute(teamStatisticsEClass, TEAM_STATISTICS__NAME);
		createEAttribute(teamStatisticsEClass, TEAM_STATISTICS__CITY);
		createEAttribute(teamStatisticsEClass, TEAM_STATISTICS__GAME_PLAYED);
		createEAttribute(teamStatisticsEClass, TEAM_STATISTICS__GAME_WIN);
		createEAttribute(teamStatisticsEClass, TEAM_STATISTICS__GAME_LOSE);
		createEReference(teamStatisticsEClass, TEAM_STATISTICS__MEMBERS);

		memberEClass = createEClass(MEMBER);
		createEAttribute(memberEClass, MEMBER__NAME);
		createEReference(memberEClass, MEMBER__PITCHER_STATISTICS);
		createEReference(memberEClass, MEMBER__OFFENSIVE_STATISTICS);
		createEReference(memberEClass, MEMBER__DEFENSIVE_STATISTICS);

		pitcherStatisticsEClass = createEClass(PITCHER_STATISTICS);
		createEAttribute(pitcherStatisticsEClass, PITCHER_STATISTICS__GAME_WIN);
		createEAttribute(pitcherStatisticsEClass, PITCHER_STATISTICS__GAME_LOSE);
		createEAttribute(pitcherStatisticsEClass, PITCHER_STATISTICS__GAME_SAVE);
		createEAttribute(pitcherStatisticsEClass, PITCHER_STATISTICS__EARNED_RUNS);
		createEAttribute(pitcherStatisticsEClass, PITCHER_STATISTICS__IPS);

		offensiveStatisticsEClass = createEClass(OFFENSIVE_STATISTICS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__AT_BATS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__BATTING_AVERAGE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__CAUGHT_STEALING);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__DOUBLES);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__EXTRA_BASE_HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__GAMES_PLAYED);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__GRAND_SLAM);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__HIT_BY_PITCHS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__HOME_RUNS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__INTENTIONAL_WALKS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__LEFT_ON_BASE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__PLATE_APPEARANCE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__REACHED_ON_ERROR);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__RUNS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__RBIS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__SACRIFICE_BUNT);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__SACRIFICE_FLY);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__SINGLE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__STOLEN_BASE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__TOTAL_BASES);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__TRIPLES);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__WALKS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__WALK_OFF);

		defensiveStatisticsEClass = createEClass(DEFENSIVE_STATISTICS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__ASSISTS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__DOUBLE_PLAYS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__ERRORS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__INNINGS_PLAYED);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__OUTS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__OUTFIELD_ASSIST);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__PASSED_BALL);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__PUTOUTS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__TOTAL_CHANCES);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__TRIPLE_PLAY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(globalStatisticEClass, GlobalStatistic.class, "GlobalStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalStatistic_Teams(), this.getTeamStatistics(), null, "teams", null, 0, -1, GlobalStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(teamStatisticsEClass, TeamStatistics.class, "TeamStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTeamStatistics_Name(), ecorePackage.getEString(), "name", null, 1, 1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistics_City(), ecorePackage.getEString(), "city", null, 0, 1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistics_GamePlayed(), ecorePackage.getEInt(), "gamePlayed", null, 1, 1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistics_GameWin(), ecorePackage.getEInt(), "gameWin", null, 1, 1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistics_GameLose(), ecorePackage.getEInt(), "gameLose", null, 1, 1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistics_Members(), this.getMember(), null, "members", null, 0, -1, TeamStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memberEClass, Member.class, "Member", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMember_Name(), ecorePackage.getEString(), "name", null, 1, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMember_PitcherStatistics(), this.getPitcherStatistics(), null, "pitcherStatistics", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMember_OffensiveStatistics(), this.getOffensiveStatistics(), null, "offensiveStatistics", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMember_DefensiveStatistics(), this.getDefensiveStatistics(), null, "defensiveStatistics", null, 0, 1, Member.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pitcherStatisticsEClass, PitcherStatistics.class, "PitcherStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPitcherStatistics_GameWin(), ecorePackage.getEInt(), "gameWin", "-1", 1, 1, PitcherStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistics_GameLose(), ecorePackage.getEInt(), "gameLose", "-1", 1, 1, PitcherStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistics_GameSave(), ecorePackage.getEInt(), "gameSave", "-1", 1, 1, PitcherStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistics_EarnedRuns(), ecorePackage.getEInt(), "earnedRuns", "-1", 1, 1, PitcherStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistics_Ips(), ecorePackage.getEInt(), "ips", "-1", 1, 1, PitcherStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(offensiveStatisticsEClass, OffensiveStatistics.class, "OffensiveStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOffensiveStatistics_AtBats(), ecorePackage.getEInt(), "atBats", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_BattingAverage(), ecorePackage.getEDouble(), "battingAverage", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Doubles(), ecorePackage.getEInt(), "doubles", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_ExtraBaseHits(), ecorePackage.getEInt(), "extraBaseHits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_GamesPlayed(), ecorePackage.getEInt(), "gamesPlayed", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_GrandSlam(), ecorePackage.getEInt(), "grandSlam", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_GroundIntoDoublePlay(), ecorePackage.getEInt(), "groundIntoDoublePlay", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_GroundoutToAiroutRatio(), ecorePackage.getEDouble(), "groundoutToAiroutRatio", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_HitByPitchs(), ecorePackage.getEInt(), "hitByPitchs", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Hits(), ecorePackage.getEInt(), "hits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_HomeRuns(), ecorePackage.getEInt(), "homeRuns", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_IntentionalWalks(), ecorePackage.getEInt(), "intentionalWalks", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_LeftOnBase(), ecorePackage.getEInt(), "leftOnBase", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_OnBasePercentage(), ecorePackage.getEDouble(), "onBasePercentage", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_OnBasePlusSlugging(), ecorePackage.getEDouble(), "onBasePlusSlugging", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_PlateAppearance(), ecorePackage.getEInt(), "plateAppearance", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_ReachedOnError(), ecorePackage.getEInt(), "reachedOnError", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Runs(), ecorePackage.getEInt(), "runs", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Rbis(), ecorePackage.getEInt(), "rbis", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_SacrificeBunt(), ecorePackage.getEInt(), "sacrificeBunt", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_SacrificeFly(), ecorePackage.getEInt(), "sacrificeFly", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Single(), ecorePackage.getEInt(), "single", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_SluggingPercentage(), ecorePackage.getEDouble(), "sluggingPercentage", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_StolenBase(), ecorePackage.getEInt(), "stolenBase", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_StolenBasePercentage(), ecorePackage.getEDouble(), "stolenBasePercentage", "0.0", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_TotalBases(), ecorePackage.getEInt(), "totalBases", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Triples(), ecorePackage.getEInt(), "triples", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_Walks(), ecorePackage.getEInt(), "walks", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_WalkOff(), ecorePackage.getEInt(), "walkOff", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defensiveStatisticsEClass, DefensiveStatistics.class, "DefensiveStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefensiveStatistics_Assists(), ecorePackage.getEInt(), "assists", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_CaughtStealingPercentage(), ecorePackage.getEDouble(), "caughtStealingPercentage", "0.0", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_DoublePlays(), ecorePackage.getEInt(), "doublePlays", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_Errors(), ecorePackage.getEInt(), "errors", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_FieldingPercentage(), ecorePackage.getEDouble(), "fieldingPercentage", "0.0", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_InningsPlayed(), ecorePackage.getEDouble(), "inningsPlayed", "0.0", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_Outs(), ecorePackage.getEInt(), "outs", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_OutfieldAssist(), ecorePackage.getEInt(), "outfieldAssist", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_PassedBall(), ecorePackage.getEInt(), "passedBall", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_Putouts(), ecorePackage.getEInt(), "putouts", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_TotalChances(), ecorePackage.getEInt(), "totalChances", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_TriplePlay(), ecorePackage.getEInt(), "triplePlay", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GlobalStatisticsPackageImpl
