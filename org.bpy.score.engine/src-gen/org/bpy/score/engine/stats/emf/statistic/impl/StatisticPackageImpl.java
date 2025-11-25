/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import java.util.Map;

import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;

import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticFactory;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatisticPackageImpl extends EPackageImpl implements StatisticPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gameStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teamStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inningGeneralStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inninStaticticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offensiveStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pitcherStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catcherStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defensiveStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineupEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToAssociatedObjectMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToLineupEntryTypeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lineupEntryTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType associatedObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType playerDescriptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType defensiveStatisticTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType catcherStatisticTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType offensiveStatisticTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pitcherStatisticTypeEDataType = null;

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
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StatisticPackageImpl() {
		super(eNS_URI, StatisticFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StatisticPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StatisticPackage init() {
		if (isInited) return (StatisticPackage)EPackage.Registry.INSTANCE.getEPackage(StatisticPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredStatisticPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		StatisticPackageImpl theStatisticPackage = registeredStatisticPackage instanceof StatisticPackageImpl ? (StatisticPackageImpl)registeredStatisticPackage : new StatisticPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theStatisticPackage.createPackageContents();

		// Initialize created meta-data
		theStatisticPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStatisticPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StatisticPackage.eNS_URI, theStatisticPackage);
		return theStatisticPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGameStatistic() {
		return gameStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameStatistic_GameName() {
		return (EAttribute)gameStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameStatistic_Hometeam() {
		return (EReference)gameStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameStatistic_Visitor() {
		return (EReference)gameStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameStatistic_WinningPitcher() {
		return (EAttribute)gameStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameStatistic_LoosingPitcher() {
		return (EAttribute)gameStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameStatistic_SavePitcher() {
		return (EAttribute)gameStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTeamStatistic() {
		return teamStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_GeneralInningStats() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_Name() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_TotalCatcherStatistic() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_TotalDefensiveStatistic() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_TotalPitcherStatistic() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_TotalOffensiveStatistic() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_DoublePlayCounter() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_TieBreakCounter() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_CurrentOffensivePlayer() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatistic_CurrentDefensivePlayer() {
		return (EReference)teamStatisticEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_CurrentCatcher() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_CurrentPitcher() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_Catchers() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_Pitchers() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_Players() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_GwRbi() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_EarnedAgainstTheTeam() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatistic_FinalScore() {
		return (EAttribute)teamStatisticEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInningGeneralStatistic() {
		return inningGeneralStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_AtBats() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_Runs() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_EarnedRuns() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_Hits() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_Assitances() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_Errors() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInningGeneralStatistic_Lob() {
		return (EAttribute)inningGeneralStatisticEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInninStatictic() {
		return inninStaticticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInninStatictic_InningStat() {
		return (EReference)inninStaticticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInninStatictic_CumulativeInningStat() {
		return (EReference)inninStaticticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOffensiveStatistic() {
		return offensiveStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_PlateAppearances() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_AtBats() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Runs() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Hits() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Double() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Triple() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Homerun() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_GroundedDoublePlay() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_SacrificeHit() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_SacrificeFly() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_BaseOnBall() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_IntentionalbaseOnBall() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_HitByPitch() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_InterferanceObstruction() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_StolenBase() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_CaughtStealing() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_StrikeOut() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOffensiveStatistic_Rbi() {
		return (EAttribute)offensiveStatisticEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPitcherStatistic() {
		return pitcherStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_BatterFront() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_AtBats() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Runs() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Hits() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Double() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Triple() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Homerun() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_SacrificeHit() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_SacrificeFly() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_BaseOnBall() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_IntentionalbaseOnBall() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_HitByPitch() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_InterferanceObstruction() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_StrikeOut() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_EarnedRuns() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_WildPitches() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Balks() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_PitchCount() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_PitchCountK() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_PitchCountB() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_PitchCountOthers() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_RunnerLeftOnBase() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_CaughtStealing() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Ips() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_FlyOuts() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_GroundedOuts() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCatcherStatistic() {
		return catcherStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCatcherStatistic_PassBall() {
		return (EAttribute)catcherStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCatcherStatistic_StolenBase() {
		return (EAttribute)catcherStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCatcherStatistic_CaughtStealing() {
		return (EAttribute)catcherStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefensiveStatistic() {
		return defensiveStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistic_PutOut() {
		return (EAttribute)defensiveStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistic_Assitances() {
		return (EAttribute)defensiveStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistic_Errors() {
		return (EAttribute)defensiveStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDefensiveStatistic_DoublePlay() {
		return (EAttribute)defensiveStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLineupEntry() {
		return lineupEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_IsDefensiveEntry() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_DefensivePosition() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_OffensivePosition() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_DefensivePositionIndex() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_StartEntryIp() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_IpPlayed() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_PlayerDescription() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLineupEntry_AssociatedObjects() {
		return (EReference)lineupEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_DefensiveStatistic() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_OffensiveStatistic() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_CatcherStatistic() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_PitcherStatistic() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_Actif() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_OrderNumber() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupEntry_Laterality() {
		return (EAttribute)lineupEntryEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStringToAssociatedObjectMap() {
		return eStringToAssociatedObjectMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToAssociatedObjectMap_Key() {
		return (EAttribute)eStringToAssociatedObjectMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToAssociatedObjectMap_Value() {
		return (EAttribute)eStringToAssociatedObjectMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStringToLineupEntryTypeMap() {
		return eStringToLineupEntryTypeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToLineupEntryTypeMap_Key() {
		return (EAttribute)eStringToLineupEntryTypeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEStringToLineupEntryTypeMap_Value() {
		return (EAttribute)eStringToLineupEntryTypeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLineupEntryType() {
		return lineupEntryTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getAssociatedObject() {
		return associatedObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPlayerDescription() {
		return playerDescriptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDefensiveStatisticType() {
		return defensiveStatisticTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getCatcherStatisticType() {
		return catcherStatisticTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getOffensiveStatisticType() {
		return offensiveStatisticTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getPitcherStatisticType() {
		return pitcherStatisticTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticFactory getStatisticFactory() {
		return (StatisticFactory)getEFactoryInstance();
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
		gameStatisticEClass = createEClass(GAME_STATISTIC);
		createEAttribute(gameStatisticEClass, GAME_STATISTIC__GAME_NAME);
		createEReference(gameStatisticEClass, GAME_STATISTIC__HOMETEAM);
		createEReference(gameStatisticEClass, GAME_STATISTIC__VISITOR);
		createEAttribute(gameStatisticEClass, GAME_STATISTIC__WINNING_PITCHER);
		createEAttribute(gameStatisticEClass, GAME_STATISTIC__LOOSING_PITCHER);
		createEAttribute(gameStatisticEClass, GAME_STATISTIC__SAVE_PITCHER);

		teamStatisticEClass = createEClass(TEAM_STATISTIC);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__GENERAL_INNING_STATS);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__NAME);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__DOUBLE_PLAY_COUNTER);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__TIE_BREAK_COUNTER);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER);
		createEReference(teamStatisticEClass, TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__CURRENT_CATCHER);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__CURRENT_PITCHER);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__CATCHERS);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__PITCHERS);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__PLAYERS);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__GW_RBI);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM);
		createEAttribute(teamStatisticEClass, TEAM_STATISTIC__FINAL_SCORE);

		inningGeneralStatisticEClass = createEClass(INNING_GENERAL_STATISTIC);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__AT_BATS);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__RUNS);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__EARNED_RUNS);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__HITS);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__ASSITANCES);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__ERRORS);
		createEAttribute(inningGeneralStatisticEClass, INNING_GENERAL_STATISTIC__LOB);

		inninStaticticEClass = createEClass(INNIN_STATICTIC);
		createEReference(inninStaticticEClass, INNIN_STATICTIC__INNING_STAT);
		createEReference(inninStaticticEClass, INNIN_STATICTIC__CUMULATIVE_INNING_STAT);

		offensiveStatisticEClass = createEClass(OFFENSIVE_STATISTIC);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__PLATE_APPEARANCES);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__AT_BATS);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__RUNS);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__HITS);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__DOUBLE);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__TRIPLE);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__HOMERUN);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__SACRIFICE_HIT);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__SACRIFICE_FLY);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__BASE_ON_BALL);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__HIT_BY_PITCH);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__STOLEN_BASE);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__CAUGHT_STEALING);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__STRIKE_OUT);
		createEAttribute(offensiveStatisticEClass, OFFENSIVE_STATISTIC__RBI);

		pitcherStatisticEClass = createEClass(PITCHER_STATISTIC);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__BATTER_FRONT);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__AT_BATS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__RUNS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__HITS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__DOUBLE);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__TRIPLE);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__HOMERUN);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__SACRIFICE_HIT);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__SACRIFICE_FLY);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__BASE_ON_BALL);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__HIT_BY_PITCH);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__STRIKE_OUT);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__EARNED_RUNS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__WILD_PITCHES);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__BALKS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__PITCH_COUNT);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__PITCH_COUNT_K);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__PITCH_COUNT_B);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__PITCH_COUNT_OTHERS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__CAUGHT_STEALING);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__IPS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__FLY_OUTS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__GROUNDED_OUTS);

		catcherStatisticEClass = createEClass(CATCHER_STATISTIC);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__PASS_BALL);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__STOLEN_BASE);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__CAUGHT_STEALING);

		defensiveStatisticEClass = createEClass(DEFENSIVE_STATISTIC);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__PUT_OUT);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__ASSITANCES);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__ERRORS);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__DOUBLE_PLAY);

		lineupEntryEClass = createEClass(LINEUP_ENTRY);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__IS_DEFENSIVE_ENTRY);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__DEFENSIVE_POSITION);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__OFFENSIVE_POSITION);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__START_ENTRY_IP);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__IP_PLAYED);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__PLAYER_DESCRIPTION);
		createEReference(lineupEntryEClass, LINEUP_ENTRY__ASSOCIATED_OBJECTS);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__DEFENSIVE_STATISTIC);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__OFFENSIVE_STATISTIC);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__CATCHER_STATISTIC);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__PITCHER_STATISTIC);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__ACTIF);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__ORDER_NUMBER);
		createEAttribute(lineupEntryEClass, LINEUP_ENTRY__LATERALITY);

		eStringToAssociatedObjectMapEClass = createEClass(ESTRING_TO_ASSOCIATED_OBJECT_MAP);
		createEAttribute(eStringToAssociatedObjectMapEClass, ESTRING_TO_ASSOCIATED_OBJECT_MAP__KEY);
		createEAttribute(eStringToAssociatedObjectMapEClass, ESTRING_TO_ASSOCIATED_OBJECT_MAP__VALUE);

		eStringToLineupEntryTypeMapEClass = createEClass(ESTRING_TO_LINEUP_ENTRY_TYPE_MAP);
		createEAttribute(eStringToLineupEntryTypeMapEClass, ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__KEY);
		createEAttribute(eStringToLineupEntryTypeMapEClass, ESTRING_TO_LINEUP_ENTRY_TYPE_MAP__VALUE);

		// Create data types
		lineupEntryTypeEDataType = createEDataType(LINEUP_ENTRY_TYPE);
		associatedObjectEDataType = createEDataType(ASSOCIATED_OBJECT);
		playerDescriptionEDataType = createEDataType(PLAYER_DESCRIPTION);
		defensiveStatisticTypeEDataType = createEDataType(DEFENSIVE_STATISTIC_TYPE);
		catcherStatisticTypeEDataType = createEDataType(CATCHER_STATISTIC_TYPE);
		offensiveStatisticTypeEDataType = createEDataType(OFFENSIVE_STATISTIC_TYPE);
		pitcherStatisticTypeEDataType = createEDataType(PITCHER_STATISTIC_TYPE);
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
		initEClass(gameStatisticEClass, GameStatistic.class, "GameStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGameStatistic_GameName(), ecorePackage.getEString(), "gameName", null, 1, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGameStatistic_Hometeam(), this.getTeamStatistic(), null, "hometeam", null, 1, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGameStatistic_Visitor(), this.getTeamStatistic(), null, "visitor", null, 1, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameStatistic_WinningPitcher(), this.getLineupEntryType(), "winningPitcher", null, 0, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameStatistic_LoosingPitcher(), this.getLineupEntryType(), "loosingPitcher", null, 0, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameStatistic_SavePitcher(), this.getLineupEntryType(), "savePitcher", null, 0, 1, GameStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(teamStatisticEClass, TeamStatistic.class, "TeamStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTeamStatistic_GeneralInningStats(), this.getInninStatictic(), null, "generalInningStats", null, 0, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_Name(), ecorePackage.getEString(), "name", null, 0, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_TotalCatcherStatistic(), this.getCatcherStatistic(), null, "totalCatcherStatistic", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_TotalDefensiveStatistic(), this.getDefensiveStatistic(), null, "totalDefensiveStatistic", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_TotalPitcherStatistic(), this.getPitcherStatistic(), null, "totalPitcherStatistic", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_TotalOffensiveStatistic(), this.getOffensiveStatistic(), null, "totalOffensiveStatistic", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_DoublePlayCounter(), ecorePackage.getEInt(), "doublePlayCounter", "0", 0, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_TieBreakCounter(), ecorePackage.getEInt(), "tieBreakCounter", null, 0, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_CurrentOffensivePlayer(), this.getEStringToLineupEntryTypeMap(), null, "currentOffensivePlayer", null, 0, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeamStatistic_CurrentDefensivePlayer(), this.getEStringToLineupEntryTypeMap(), null, "currentDefensivePlayer", null, 0, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_CurrentCatcher(), this.getLineupEntryType(), "currentCatcher", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_CurrentPitcher(), this.getLineupEntryType(), "currentPitcher", null, 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_Catchers(), this.getLineupEntryType(), "catchers", null, 1, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_Pitchers(), this.getLineupEntryType(), "pitchers", null, 1, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_Players(), this.getLineupEntryType(), "players", null, 1, -1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_GwRbi(), ecorePackage.getEString(), "gwRbi", null, 0, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_EarnedAgainstTheTeam(), ecorePackage.getEInt(), "earnedAgainstTheTeam", "0", 1, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatistic_FinalScore(), ecorePackage.getEInt(), "finalScore", null, 0, 1, TeamStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inningGeneralStatisticEClass, InningGeneralStatistic.class, "InningGeneralStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInningGeneralStatistic_AtBats(), ecorePackage.getEInt(), "atBats", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_Runs(), ecorePackage.getEInt(), "runs", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_EarnedRuns(), ecorePackage.getEInt(), "earnedRuns", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_Hits(), ecorePackage.getEInt(), "hits", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_Assitances(), ecorePackage.getEInt(), "assitances", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_Errors(), ecorePackage.getEInt(), "errors", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInningGeneralStatistic_Lob(), ecorePackage.getEInt(), "lob", "0", 1, 1, InningGeneralStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inninStaticticEClass, InninStatictic.class, "InninStatictic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInninStatictic_InningStat(), this.getInningGeneralStatistic(), null, "inningStat", null, 1, 1, InninStatictic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInninStatictic_CumulativeInningStat(), this.getInningGeneralStatistic(), null, "cumulativeInningStat", null, 1, 1, InninStatictic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(offensiveStatisticEClass, OffensiveStatistic.class, "OffensiveStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOffensiveStatistic_PlateAppearances(), ecorePackage.getEInt(), "plateAppearances", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_AtBats(), ecorePackage.getEInt(), "atBats", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Runs(), ecorePackage.getEInt(), "runs", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Hits(), ecorePackage.getEInt(), "hits", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Double(), ecorePackage.getEInt(), "double", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Triple(), ecorePackage.getEInt(), "triple", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Homerun(), ecorePackage.getEInt(), "homerun", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_GroundedDoublePlay(), ecorePackage.getEInt(), "groundedDoublePlay", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_SacrificeHit(), ecorePackage.getEInt(), "sacrificeHit", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_SacrificeFly(), ecorePackage.getEInt(), "sacrificeFly", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_BaseOnBall(), ecorePackage.getEInt(), "baseOnBall", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_IntentionalbaseOnBall(), ecorePackage.getEInt(), "intentionalbaseOnBall", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_HitByPitch(), ecorePackage.getEInt(), "hitByPitch", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_InterferanceObstruction(), ecorePackage.getEInt(), "interferanceObstruction", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_StolenBase(), ecorePackage.getEInt(), "stolenBase", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_StrikeOut(), ecorePackage.getEInt(), "strikeOut", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Rbi(), ecorePackage.getEInt(), "rbi", "0", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pitcherStatisticEClass, PitcherStatistic.class, "PitcherStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPitcherStatistic_BatterFront(), ecorePackage.getEInt(), "batterFront", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_AtBats(), ecorePackage.getEInt(), "atBats", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Runs(), ecorePackage.getEInt(), "runs", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Hits(), ecorePackage.getEInt(), "hits", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Double(), ecorePackage.getEInt(), "double", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Triple(), ecorePackage.getEInt(), "triple", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Homerun(), ecorePackage.getEInt(), "homerun", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_SacrificeHit(), ecorePackage.getEInt(), "sacrificeHit", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_SacrificeFly(), ecorePackage.getEInt(), "sacrificeFly", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_BaseOnBall(), ecorePackage.getEInt(), "baseOnBall", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_IntentionalbaseOnBall(), ecorePackage.getEInt(), "intentionalbaseOnBall", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_HitByPitch(), ecorePackage.getEInt(), "hitByPitch", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_InterferanceObstruction(), ecorePackage.getEInt(), "interferanceObstruction", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_StrikeOut(), ecorePackage.getEInt(), "strikeOut", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_EarnedRuns(), ecorePackage.getEInt(), "earnedRuns", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_WildPitches(), ecorePackage.getEInt(), "wildPitches", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Balks(), ecorePackage.getEInt(), "balks", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCount(), ecorePackage.getEInt(), "pitchCount", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountK(), ecorePackage.getEInt(), "pitchCountK", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountB(), ecorePackage.getEInt(), "pitchCountB", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountOthers(), ecorePackage.getEInt(), "pitchCountOthers", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_RunnerLeftOnBase(), ecorePackage.getEInt(), "runnerLeftOnBase", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Ips(), ecorePackage.getEDouble(), "ips", "0.0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_FlyOuts(), ecorePackage.getEInt(), "flyOuts", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_GroundedOuts(), ecorePackage.getEInt(), "groundedOuts", "0", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catcherStatisticEClass, CatcherStatistic.class, "CatcherStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatcherStatistic_PassBall(), ecorePackage.getEInt(), "passBall", "0", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatcherStatistic_StolenBase(), ecorePackage.getEInt(), "stolenBase", "0", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatcherStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "0", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defensiveStatisticEClass, DefensiveStatistic.class, "DefensiveStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefensiveStatistic_PutOut(), ecorePackage.getEInt(), "putOut", "0", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_Assitances(), ecorePackage.getEInt(), "assitances", "0", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_Errors(), ecorePackage.getEInt(), "errors", "0", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_DoublePlay(), ecorePackage.getEInt(), "doublePlay", "0", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineupEntryEClass, LineupEntry.class, "LineupEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLineupEntry_IsDefensiveEntry(), ecorePackage.getEBoolean(), "isDefensiveEntry", "false", 1, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_DefensivePosition(), ecorePackage.getEString(), "defensivePosition", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_OffensivePosition(), ecorePackage.getEString(), "offensivePosition", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_DefensivePositionIndex(), ecorePackage.getEString(), "defensivePositionIndex", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_StartEntryIp(), ecorePackage.getEDouble(), "startEntryIp", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_IpPlayed(), ecorePackage.getEDouble(), "ipPlayed", "0.0", 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_PlayerDescription(), this.getPlayerDescription(), "playerDescription", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLineupEntry_AssociatedObjects(), this.getEStringToAssociatedObjectMap(), null, "associatedObjects", null, 0, -1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_DefensiveStatistic(), this.getDefensiveStatisticType(), "defensiveStatistic", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_OffensiveStatistic(), this.getOffensiveStatisticType(), "offensiveStatistic", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_CatcherStatistic(), this.getCatcherStatisticType(), "catcherStatistic", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_PitcherStatistic(), this.getPitcherStatisticType(), "pitcherStatistic", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_Actif(), ecorePackage.getEBoolean(), "actif", "false", 1, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_OrderNumber(), ecorePackage.getEInt(), "orderNumber", null, 1, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupEntry_Laterality(), ecorePackage.getEString(), "laterality", null, 0, 1, LineupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToAssociatedObjectMapEClass, Map.Entry.class, "EStringToAssociatedObjectMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToAssociatedObjectMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToAssociatedObjectMap_Value(), this.getAssociatedObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToLineupEntryTypeMapEClass, Map.Entry.class, "EStringToLineupEntryTypeMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToLineupEntryTypeMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEStringToLineupEntryTypeMap_Value(), this.getLineupEntryType(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(lineupEntryTypeEDataType, LineupEntry.class, "LineupEntryType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(associatedObjectEDataType, Object.class, "AssociatedObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(playerDescriptionEDataType, LineupPlayerDescription.class, "PlayerDescription", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(defensiveStatisticTypeEDataType, DefensiveStatistic.class, "DefensiveStatisticType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(catcherStatisticTypeEDataType, CatcherStatistic.class, "CatcherStatisticType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(offensiveStatisticTypeEDataType, OffensiveStatistic.class, "OffensiveStatisticType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(pitcherStatisticTypeEDataType, PitcherStatistic.class, "PitcherStatisticType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.obeo.fr/dsl/dnc/archetype
		createArchetypeAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.obeo.fr/dsl/dnc/archetype</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArchetypeAnnotations() {
		String source = "http://www.obeo.fr/dsl/dnc/archetype";
		addAnnotation
		  (teamStatisticEClass,
		   source,
		   new String[] {
			   "archetype", "Role"
		   });
	}

} //StatisticPackageImpl
