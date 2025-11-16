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
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_BaseOnBalls() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_HitsByPitch() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_AtBats() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_SacrificeFlies() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_DoubleBaseHits() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_TripleBaseHits() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_FourBaseHits() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistics_PlateAppearance() {
		return (EAttribute)offensiveStatisticsEClass.getEStructuralFeatures().get(8);
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
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Assists() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistics_Errors() {
		return (EAttribute)defensiveStatisticsEClass.getEStructuralFeatures().get(2);
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
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__BASE_ON_BALLS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__HITS_BY_PITCH);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__AT_BATS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__SACRIFICE_FLIES);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__FOUR_BASE_HITS);
		createEAttribute(offensiveStatisticsEClass, OFFENSIVE_STATISTICS__PLATE_APPEARANCE);

		defensiveStatisticsEClass = createEClass(DEFENSIVE_STATISTICS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__PUTOUTS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__ASSISTS);
		createEAttribute(defensiveStatisticsEClass, DEFENSIVE_STATISTICS__ERRORS);
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
		initEAttribute(getOffensiveStatistics_Hits(), ecorePackage.getEInt(), "hits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_BaseOnBalls(), ecorePackage.getEInt(), "baseOnBalls", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_HitsByPitch(), ecorePackage.getEInt(), "hitsByPitch", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_AtBats(), ecorePackage.getEInt(), "atBats", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_SacrificeFlies(), ecorePackage.getEInt(), "sacrificeFlies", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_DoubleBaseHits(), ecorePackage.getEInt(), "doubleBaseHits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_TripleBaseHits(), ecorePackage.getEInt(), "tripleBaseHits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_FourBaseHits(), ecorePackage.getEInt(), "fourBaseHits", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistics_PlateAppearance(), ecorePackage.getEInt(), "plateAppearance", "-1", 1, 1, OffensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defensiveStatisticsEClass, DefensiveStatistics.class, "DefensiveStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefensiveStatistics_Putouts(), ecorePackage.getEInt(), "putouts", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_Assists(), ecorePackage.getEInt(), "assists", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistics_Errors(), ecorePackage.getEInt(), "errors", "-1", 1, 1, DefensiveStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GlobalStatisticsPackageImpl
