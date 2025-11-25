/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.ActionDescription;
import org.bpy.score.reports.gamereports.CatcherStatistic;
import org.bpy.score.reports.gamereports.DefensiveStatistic;
import org.bpy.score.reports.gamereports.GameGeneralStats;
import org.bpy.score.reports.gamereports.GameReport;
import org.bpy.score.reports.gamereports.GameReportsFactory;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.LineupPlayer;
import org.bpy.score.reports.gamereports.OffensiveStatistic;
import org.bpy.score.reports.gamereports.PitcherStatistic;
import org.bpy.score.reports.gamereports.PlayByPlay;
import org.bpy.score.reports.gamereports.Player;
import org.bpy.score.reports.gamereports.PointsPerInning;
import org.bpy.score.reports.gamereports.StartingLineup;
import org.bpy.score.reports.gamereports.TeamStatisitics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GameReportsPackageImpl extends EPackageImpl implements GameReportsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gameReportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teamStatisiticsEClass = null;

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
	private EClass defensiveStatisticEClass = null;

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
	private EClass offensiveStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playByPlayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gameGeneralStatsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointsPerInningEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startingLineupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineupPlayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum teamEEnum = null;

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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GameReportsPackageImpl() {
		super(eNS_URI, GameReportsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GameReportsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GameReportsPackage init() {
		if (isInited) return (GameReportsPackage)EPackage.Registry.INSTANCE.getEPackage(GameReportsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGameReportsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GameReportsPackageImpl theGameReportsPackage = registeredGameReportsPackage instanceof GameReportsPackageImpl ? (GameReportsPackageImpl)registeredGameReportsPackage : new GameReportsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theGameReportsPackage.createPackageContents();

		// Initialize created meta-data
		theGameReportsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGameReportsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GameReportsPackage.eNS_URI, theGameReportsPackage);
		return theGameReportsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGameReport() {
		return gameReportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_BannerPath() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_VisitorSheetPath() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_VisitorStats() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_HometeamStats() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Umpires() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Scorekeepers() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Date() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_StartingTime() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Duration() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Town() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Stadium() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_HometeamSheetPath() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_GameNumber() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_PlayByPlay() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_PdfFile() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_GeneralStats() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_VisitorLineup() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameReport_HometeamLineup() {
		return (EReference)gameReportEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameReport_Mixed() {
		return (EAttribute)gameReportEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTeamStatisitics() {
		return teamStatisiticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTeamStatisitics_Players() {
		return (EReference)teamStatisiticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatisitics_TeamName() {
		return (EAttribute)teamStatisiticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatisitics_Town() {
		return (EAttribute)teamStatisiticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatisitics_GameWin() {
		return (EAttribute)teamStatisiticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTeamStatisitics_GameLose() {
		return (EAttribute)teamStatisiticsEClass.getEStructuralFeatures().get(4);
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
	public EAttribute getPitcherStatistic_GameLose() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_GameWin() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_GameSave() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_Ips() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_PitcherOrder() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_FlyOuts() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPitcherStatistic_GroundedOuts() {
		return (EAttribute)pitcherStatisticEClass.getEStructuralFeatures().get(29);
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
	public EClass getPlayer() {
		return playerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlayer_PitcherStatistic() {
		return (EReference)playerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlayer_DefensiveStatistic() {
		return (EReference)playerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlayer_CatchersStatistic() {
		return (EReference)playerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlayer_OffensiveStatistic() {
		return (EReference)playerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlayer_Name() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlayByPlay() {
		return playByPlayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPlayByPlay_Actiondescription() {
		return (EReference)playByPlayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGameGeneralStats() {
		return gameGeneralStatsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGameGeneralStats_PointsPerInning() {
		return (EReference)gameGeneralStatsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_VisitorErrors() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_VisitorHits() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_VisitorRuns() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_HometeamErrors() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_HometeamRuns() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGameGeneralStats_HometeamHits() {
		return (EAttribute)gameGeneralStatsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPointsPerInning() {
		return pointsPerInningEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPointsPerInning_Order() {
		return (EAttribute)pointsPerInningEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPointsPerInning_VisitorPoint() {
		return (EAttribute)pointsPerInningEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPointsPerInning_HometeamPoint() {
		return (EAttribute)pointsPerInningEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStartingLineup() {
		return startingLineupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStartingLineup_TeamName() {
		return (EAttribute)startingLineupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStartingLineup_LineupPlayers() {
		return (EReference)startingLineupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStartingLineup_FieldPictrureLink() {
		return (EAttribute)startingLineupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLineupPlayer() {
		return lineupPlayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupPlayer_Name() {
		return (EAttribute)lineupPlayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupPlayer_OffensivePosition() {
		return (EAttribute)lineupPlayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLineupPlayer_DefensivePosition() {
		return (EAttribute)lineupPlayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActionDescription() {
		return actionDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionDescription_Header() {
		return (EAttribute)actionDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionDescription_Content() {
		return (EAttribute)actionDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionDescription_Resume() {
		return (EAttribute)actionDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActionDescription_Team() {
		return (EAttribute)actionDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTEAM() {
		return teamEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameReportsFactory getGameReportsFactory() {
		return (GameReportsFactory)getEFactoryInstance();
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
		gameReportEClass = createEClass(GAME_REPORT);
		createEAttribute(gameReportEClass, GAME_REPORT__BANNER_PATH);
		createEAttribute(gameReportEClass, GAME_REPORT__VISITOR_SHEET_PATH);
		createEReference(gameReportEClass, GAME_REPORT__VISITOR_STATS);
		createEReference(gameReportEClass, GAME_REPORT__HOMETEAM_STATS);
		createEAttribute(gameReportEClass, GAME_REPORT__UMPIRES);
		createEAttribute(gameReportEClass, GAME_REPORT__SCOREKEEPERS);
		createEAttribute(gameReportEClass, GAME_REPORT__DATE);
		createEAttribute(gameReportEClass, GAME_REPORT__STARTING_TIME);
		createEAttribute(gameReportEClass, GAME_REPORT__DURATION);
		createEAttribute(gameReportEClass, GAME_REPORT__TOWN);
		createEAttribute(gameReportEClass, GAME_REPORT__STADIUM);
		createEAttribute(gameReportEClass, GAME_REPORT__HOMETEAM_SHEET_PATH);
		createEAttribute(gameReportEClass, GAME_REPORT__GAME_NUMBER);
		createEReference(gameReportEClass, GAME_REPORT__PLAY_BY_PLAY);
		createEAttribute(gameReportEClass, GAME_REPORT__PDF_FILE);
		createEReference(gameReportEClass, GAME_REPORT__GENERAL_STATS);
		createEReference(gameReportEClass, GAME_REPORT__VISITOR_LINEUP);
		createEReference(gameReportEClass, GAME_REPORT__HOMETEAM_LINEUP);
		createEAttribute(gameReportEClass, GAME_REPORT__MIXED);

		teamStatisiticsEClass = createEClass(TEAM_STATISITICS);
		createEReference(teamStatisiticsEClass, TEAM_STATISITICS__PLAYERS);
		createEAttribute(teamStatisiticsEClass, TEAM_STATISITICS__TEAM_NAME);
		createEAttribute(teamStatisiticsEClass, TEAM_STATISITICS__TOWN);
		createEAttribute(teamStatisiticsEClass, TEAM_STATISITICS__GAME_WIN);
		createEAttribute(teamStatisiticsEClass, TEAM_STATISITICS__GAME_LOSE);

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
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__GAME_LOSE);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__GAME_WIN);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__GAME_SAVE);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__IPS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__PITCHER_ORDER);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__FLY_OUTS);
		createEAttribute(pitcherStatisticEClass, PITCHER_STATISTIC__GROUNDED_OUTS);

		defensiveStatisticEClass = createEClass(DEFENSIVE_STATISTIC);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__PUT_OUT);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__ASSITANCES);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__ERRORS);
		createEAttribute(defensiveStatisticEClass, DEFENSIVE_STATISTIC__DOUBLE_PLAY);

		catcherStatisticEClass = createEClass(CATCHER_STATISTIC);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__PASS_BALL);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__STOLEN_BASE);
		createEAttribute(catcherStatisticEClass, CATCHER_STATISTIC__CAUGHT_STEALING);

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

		playerEClass = createEClass(PLAYER);
		createEReference(playerEClass, PLAYER__PITCHER_STATISTIC);
		createEReference(playerEClass, PLAYER__DEFENSIVE_STATISTIC);
		createEReference(playerEClass, PLAYER__CATCHERS_STATISTIC);
		createEReference(playerEClass, PLAYER__OFFENSIVE_STATISTIC);
		createEAttribute(playerEClass, PLAYER__NAME);

		playByPlayEClass = createEClass(PLAY_BY_PLAY);
		createEReference(playByPlayEClass, PLAY_BY_PLAY__ACTIONDESCRIPTION);

		gameGeneralStatsEClass = createEClass(GAME_GENERAL_STATS);
		createEReference(gameGeneralStatsEClass, GAME_GENERAL_STATS__POINTS_PER_INNING);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__VISITOR_ERRORS);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__VISITOR_HITS);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__VISITOR_RUNS);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__HOMETEAM_ERRORS);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__HOMETEAM_RUNS);
		createEAttribute(gameGeneralStatsEClass, GAME_GENERAL_STATS__HOMETEAM_HITS);

		pointsPerInningEClass = createEClass(POINTS_PER_INNING);
		createEAttribute(pointsPerInningEClass, POINTS_PER_INNING__ORDER);
		createEAttribute(pointsPerInningEClass, POINTS_PER_INNING__VISITOR_POINT);
		createEAttribute(pointsPerInningEClass, POINTS_PER_INNING__HOMETEAM_POINT);

		startingLineupEClass = createEClass(STARTING_LINEUP);
		createEAttribute(startingLineupEClass, STARTING_LINEUP__TEAM_NAME);
		createEReference(startingLineupEClass, STARTING_LINEUP__LINEUP_PLAYERS);
		createEAttribute(startingLineupEClass, STARTING_LINEUP__FIELD_PICTRURE_LINK);

		lineupPlayerEClass = createEClass(LINEUP_PLAYER);
		createEAttribute(lineupPlayerEClass, LINEUP_PLAYER__NAME);
		createEAttribute(lineupPlayerEClass, LINEUP_PLAYER__OFFENSIVE_POSITION);
		createEAttribute(lineupPlayerEClass, LINEUP_PLAYER__DEFENSIVE_POSITION);

		actionDescriptionEClass = createEClass(ACTION_DESCRIPTION);
		createEAttribute(actionDescriptionEClass, ACTION_DESCRIPTION__HEADER);
		createEAttribute(actionDescriptionEClass, ACTION_DESCRIPTION__CONTENT);
		createEAttribute(actionDescriptionEClass, ACTION_DESCRIPTION__RESUME);
		createEAttribute(actionDescriptionEClass, ACTION_DESCRIPTION__TEAM);

		// Create enums
		teamEEnum = createEEnum(TEAM);
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
		initEClass(gameReportEClass, GameReport.class, "GameReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGameReport_BannerPath(), ecorePackage.getEString(), "bannerPath", null, 0, -1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_VisitorSheetPath(), ecorePackage.getEString(), "visitorSheetPath", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_VisitorStats(), this.getTeamStatisitics(), null, "visitorStats", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_HometeamStats(), this.getTeamStatisitics(), null, "hometeamStats", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Umpires(), ecorePackage.getEString(), "umpires", null, 0, -1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Scorekeepers(), ecorePackage.getEString(), "scorekeepers", null, 0, -1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Date(), ecorePackage.getEString(), "date", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_StartingTime(), ecorePackage.getEString(), "startingTime", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Duration(), ecorePackage.getEString(), "duration", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Town(), ecorePackage.getEString(), "town", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Stadium(), ecorePackage.getEString(), "stadium", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_HometeamSheetPath(), ecorePackage.getEString(), "hometeamSheetPath", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_GameNumber(), ecorePackage.getEString(), "gameNumber", null, 1, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_PlayByPlay(), this.getPlayByPlay(), null, "playByPlay", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_PdfFile(), ecorePackage.getEString(), "pdfFile", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_GeneralStats(), this.getGameGeneralStats(), null, "generalStats", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_VisitorLineup(), this.getStartingLineup(), null, "visitorLineup", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getGameReport_HometeamLineup(), this.getStartingLineup(), null, "hometeamLineup", null, 0, 1, GameReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameReport_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, 1, GameReport.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(teamStatisiticsEClass, TeamStatisitics.class, "TeamStatisitics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTeamStatisitics_Players(), this.getPlayer(), null, "players", null, 1, -1, TeamStatisitics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatisitics_TeamName(), ecorePackage.getEString(), "teamName", null, 1, 1, TeamStatisitics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatisitics_Town(), ecorePackage.getEString(), "town", null, 1, 1, TeamStatisitics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatisitics_GameWin(), ecorePackage.getEInt(), "gameWin", "-1", 1, 1, TeamStatisitics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeamStatisitics_GameLose(), ecorePackage.getEInt(), "gameLose", "-1", 1, 1, TeamStatisitics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pitcherStatisticEClass, PitcherStatistic.class, "PitcherStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPitcherStatistic_BatterFront(), ecorePackage.getEInt(), "batterFront", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_AtBats(), ecorePackage.getEInt(), "atBats", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Runs(), ecorePackage.getEInt(), "runs", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Hits(), ecorePackage.getEInt(), "hits", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Double(), ecorePackage.getEInt(), "double", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Triple(), ecorePackage.getEInt(), "triple", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Homerun(), ecorePackage.getEInt(), "homerun", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_SacrificeHit(), ecorePackage.getEInt(), "sacrificeHit", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_SacrificeFly(), ecorePackage.getEInt(), "sacrificeFly", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_BaseOnBall(), ecorePackage.getEInt(), "baseOnBall", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_IntentionalbaseOnBall(), ecorePackage.getEInt(), "intentionalbaseOnBall", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_HitByPitch(), ecorePackage.getEInt(), "hitByPitch", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_InterferanceObstruction(), ecorePackage.getEInt(), "interferanceObstruction", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_StrikeOut(), ecorePackage.getEInt(), "strikeOut", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_EarnedRuns(), ecorePackage.getEInt(), "earnedRuns", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_WildPitches(), ecorePackage.getEInt(), "wildPitches", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Balks(), ecorePackage.getEInt(), "balks", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCount(), ecorePackage.getEInt(), "pitchCount", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountK(), ecorePackage.getEInt(), "pitchCountK", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountB(), ecorePackage.getEInt(), "pitchCountB", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitchCountOthers(), ecorePackage.getEInt(), "pitchCountOthers", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_RunnerLeftOnBase(), ecorePackage.getEInt(), "runnerLeftOnBase", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_GameLose(), ecorePackage.getEInt(), "gameLose", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_GameWin(), ecorePackage.getEInt(), "gameWin", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_GameSave(), ecorePackage.getEInt(), "gameSave", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_Ips(), ecorePackage.getEDouble(), "ips", null, 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_PitcherOrder(), ecorePackage.getEInt(), "pitcherOrder", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_FlyOuts(), ecorePackage.getEInt(), "flyOuts", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPitcherStatistic_GroundedOuts(), ecorePackage.getEInt(), "groundedOuts", "-1", 1, 1, PitcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defensiveStatisticEClass, DefensiveStatistic.class, "DefensiveStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefensiveStatistic_PutOut(), ecorePackage.getEInt(), "putOut", "-1", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_Assitances(), ecorePackage.getEInt(), "assitances", "-1", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_Errors(), ecorePackage.getEInt(), "errors", "-1", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefensiveStatistic_DoublePlay(), ecorePackage.getEInt(), "doublePlay", "-1", 1, 1, DefensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catcherStatisticEClass, CatcherStatistic.class, "CatcherStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatcherStatistic_PassBall(), ecorePackage.getEInt(), "passBall", "-1", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatcherStatistic_StolenBase(), ecorePackage.getEInt(), "stolenBase", "-1", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatcherStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "-1", 1, 1, CatcherStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(offensiveStatisticEClass, OffensiveStatistic.class, "OffensiveStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOffensiveStatistic_PlateAppearances(), ecorePackage.getEInt(), "plateAppearances", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_AtBats(), ecorePackage.getEInt(), "atBats", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Runs(), ecorePackage.getEInt(), "runs", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Hits(), ecorePackage.getEInt(), "hits", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Double(), ecorePackage.getEInt(), "double", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Triple(), ecorePackage.getEInt(), "triple", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Homerun(), ecorePackage.getEInt(), "homerun", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_GroundedDoublePlay(), ecorePackage.getEInt(), "groundedDoublePlay", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_SacrificeHit(), ecorePackage.getEInt(), "sacrificeHit", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_SacrificeFly(), ecorePackage.getEInt(), "sacrificeFly", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_BaseOnBall(), ecorePackage.getEInt(), "baseOnBall", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_IntentionalbaseOnBall(), ecorePackage.getEInt(), "intentionalbaseOnBall", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_HitByPitch(), ecorePackage.getEInt(), "hitByPitch", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_InterferanceObstruction(), ecorePackage.getEInt(), "interferanceObstruction", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_StolenBase(), ecorePackage.getEInt(), "stolenBase", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_CaughtStealing(), ecorePackage.getEInt(), "caughtStealing", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_StrikeOut(), ecorePackage.getEInt(), "strikeOut", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOffensiveStatistic_Rbi(), ecorePackage.getEInt(), "rbi", "-1", 1, 1, OffensiveStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlayer_PitcherStatistic(), this.getPitcherStatistic(), null, "pitcherStatistic", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlayer_DefensiveStatistic(), this.getDefensiveStatistic(), null, "defensiveStatistic", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlayer_CatchersStatistic(), this.getCatcherStatistic(), null, "catchersStatistic", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlayer_OffensiveStatistic(), this.getOffensiveStatistic(), null, "offensiveStatistic", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlayer_Name(), ecorePackage.getEString(), "name", null, 1, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playByPlayEClass, PlayByPlay.class, "PlayByPlay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlayByPlay_Actiondescription(), this.getActionDescription(), null, "actiondescription", null, 0, -1, PlayByPlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gameGeneralStatsEClass, GameGeneralStats.class, "GameGeneralStats", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGameGeneralStats_PointsPerInning(), this.getPointsPerInning(), null, "pointsPerInning", null, 1, -1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_VisitorErrors(), ecorePackage.getEInt(), "visitorErrors", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_VisitorHits(), ecorePackage.getEInt(), "visitorHits", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_VisitorRuns(), ecorePackage.getEInt(), "visitorRuns", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_HometeamErrors(), ecorePackage.getEInt(), "hometeamErrors", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_HometeamRuns(), ecorePackage.getEInt(), "hometeamRuns", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGameGeneralStats_HometeamHits(), ecorePackage.getEInt(), "hometeamHits", "-1", 1, 1, GameGeneralStats.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointsPerInningEClass, PointsPerInning.class, "PointsPerInning", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPointsPerInning_Order(), ecorePackage.getEInt(), "order", "-1", 1, 1, PointsPerInning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPointsPerInning_VisitorPoint(), ecorePackage.getEInt(), "visitorPoint", "-1", 1, 1, PointsPerInning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPointsPerInning_HometeamPoint(), ecorePackage.getEInt(), "hometeamPoint", "-1", 1, 1, PointsPerInning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startingLineupEClass, StartingLineup.class, "StartingLineup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartingLineup_TeamName(), ecorePackage.getEString(), "teamName", null, 1, 1, StartingLineup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartingLineup_LineupPlayers(), this.getLineupPlayer(), null, "lineupPlayers", null, 0, -1, StartingLineup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartingLineup_FieldPictrureLink(), ecorePackage.getEString(), "fieldPictrureLink", null, 0, 1, StartingLineup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineupPlayerEClass, LineupPlayer.class, "LineupPlayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLineupPlayer_Name(), ecorePackage.getEString(), "name", null, 1, 1, LineupPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupPlayer_OffensivePosition(), ecorePackage.getEInt(), "offensivePosition", null, 1, 1, LineupPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLineupPlayer_DefensivePosition(), ecorePackage.getEString(), "defensivePosition", null, 1, 1, LineupPlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionDescriptionEClass, ActionDescription.class, "ActionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionDescription_Header(), ecorePackage.getEString(), "header", null, 1, 1, ActionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDescription_Content(), ecorePackage.getEString(), "content", null, 1, 1, ActionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDescription_Resume(), ecorePackage.getEString(), "resume", null, 1, 1, ActionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDescription_Team(), this.getTEAM(), "team", null, 1, 1, ActionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(teamEEnum, org.bpy.score.reports.gamereports.TEAM.class, "TEAM");
		addEEnumLiteral(teamEEnum, org.bpy.score.reports.gamereports.TEAM.HOMETEAM);
		addEEnumLiteral(teamEEnum, org.bpy.score.reports.gamereports.TEAM.VISITOR);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "qualified", "false"
		   });
		addAnnotation
		  (gameReportEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "GAME-REPORT"
		   });
		addAnnotation
		  (getGameReport_BannerPath(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BANNER-PATH"
		   });
		addAnnotation
		  (getGameReport_VisitorSheetPath(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-SHEET-PATH"
		   });
		addAnnotation
		  (getGameReport_VisitorStats(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-STATS"
		   });
		addAnnotation
		  (getGameReport_HometeamStats(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-STATS"
		   });
		addAnnotation
		  (getGameReport_Umpires(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "UMPIRE"
		   });
		addAnnotation
		  (getGameReport_Scorekeepers(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SCOREKEEPER"
		   });
		addAnnotation
		  (getGameReport_Date(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DATE"
		   });
		addAnnotation
		  (getGameReport_StartingTime(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "START-TIME"
		   });
		addAnnotation
		  (getGameReport_Duration(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DURATION"
		   });
		addAnnotation
		  (getGameReport_Town(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CITY"
		   });
		addAnnotation
		  (getGameReport_Stadium(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STADIUM"
		   });
		addAnnotation
		  (getGameReport_HometeamSheetPath(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-SHEET-PATH"
		   });
		addAnnotation
		  (getGameReport_GameNumber(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-NUMBER"
		   });
		addAnnotation
		  (getGameReport_PlayByPlay(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PLAY-BY-PLAY"
		   });
		addAnnotation
		  (getGameReport_PdfFile(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PDF-FILE"
		   });
		addAnnotation
		  (getGameReport_GeneralStats(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-GENERAL-STATS"
		   });
		addAnnotation
		  (getGameReport_VisitorLineup(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STARTING-VISITOR-LINEUP"
		   });
		addAnnotation
		  (getGameReport_HometeamLineup(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STARTING-HOMETEAM-LINEUP"
		   });
		addAnnotation
		  (getGameReport_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (teamStatisiticsEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "TEAM-STATISTICS"
		   });
		addAnnotation
		  (getTeamStatisitics_Players(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PLAYER"
		   });
		addAnnotation
		  (getTeamStatisitics_TeamName(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TEAM-NAME"
		   });
		addAnnotation
		  (getTeamStatisitics_Town(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TOWN-NAME"
		   });
		addAnnotation
		  (getTeamStatisitics_GameWin(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-WIN"
		   });
		addAnnotation
		  (getTeamStatisitics_GameLose(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-LOSE"
		   });
		addAnnotation
		  (pitcherStatisticEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "PITCHER-STATISTICS"
		   });
		addAnnotation
		  (getPitcherStatistic_BatterFront(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BATTER-FRONTS"
		   });
		addAnnotation
		  (getPitcherStatistic_AtBats(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "AT-BATS"
		   });
		addAnnotation
		  (getPitcherStatistic_Runs(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "RUNS"
		   });
		addAnnotation
		  (getPitcherStatistic_Hits(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HITS"
		   });
		addAnnotation
		  (getPitcherStatistic_Double(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DOUBLES"
		   });
		addAnnotation
		  (getPitcherStatistic_Triple(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TRIPLES"
		   });
		addAnnotation
		  (getPitcherStatistic_Homerun(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMERUNS"
		   });
		addAnnotation
		  (getPitcherStatistic_SacrificeHit(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SACRIFICES-HITS"
		   });
		addAnnotation
		  (getPitcherStatistic_SacrificeFly(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SACRIFICE-FLIES"
		   });
		addAnnotation
		  (getPitcherStatistic_BaseOnBall(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BASE-ON-BALLS"
		   });
		addAnnotation
		  (getPitcherStatistic_IntentionalbaseOnBall(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "INTENTIONAL-BASE-ON-BALLS"
		   });
		addAnnotation
		  (getPitcherStatistic_HitByPitch(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HIT-BY-PITCHS"
		   });
		addAnnotation
		  (getPitcherStatistic_InterferanceObstruction(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "INTERFEENCE-OBSTRUCTIONS"
		   });
		addAnnotation
		  (getPitcherStatistic_StrikeOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STRIKE-OUTS"
		   });
		addAnnotation
		  (getPitcherStatistic_EarnedRuns(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "EARNED-RUNS"
		   });
		addAnnotation
		  (getPitcherStatistic_WildPitches(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "WILD-PITCHES"
		   });
		addAnnotation
		  (getPitcherStatistic_Balks(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BALKS"
		   });
		addAnnotation
		  (getPitcherStatistic_PitchCount(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCH-COUNT"
		   });
		addAnnotation
		  (getPitcherStatistic_PitchCountK(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCH-COUNT-K"
		   });
		addAnnotation
		  (getPitcherStatistic_PitchCountB(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCH-COUNT-B"
		   });
		addAnnotation
		  (getPitcherStatistic_PitchCountOthers(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCH-COUNT-OTHERS"
		   });
		addAnnotation
		  (getPitcherStatistic_RunnerLeftOnBase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "RUNNER-LEFT-ON-BASE"
		   });
		addAnnotation
		  (getPitcherStatistic_CaughtStealing(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CAUGHT-STEALING"
		   });
		addAnnotation
		  (getPitcherStatistic_GameLose(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-LOSE"
		   });
		addAnnotation
		  (getPitcherStatistic_GameWin(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-WIN"
		   });
		addAnnotation
		  (getPitcherStatistic_GameSave(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GAME-SAVE"
		   });
		addAnnotation
		  (getPitcherStatistic_Ips(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "IPS"
		   });
		addAnnotation
		  (getPitcherStatistic_PitcherOrder(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCHER-ORDER"
		   });
		addAnnotation
		  (getPitcherStatistic_FlyOuts(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "FLY-OUTS"
		   });
		addAnnotation
		  (getPitcherStatistic_GroundedOuts(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GROUNDED-OUTS"
		   });
		addAnnotation
		  (defensiveStatisticEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "DEFENSIVES-STATISTICS"
		   });
		addAnnotation
		  (getDefensiveStatistic_PutOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PUT-OUTS"
		   });
		addAnnotation
		  (getDefensiveStatistic_Assitances(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ASSISTANCES"
		   });
		addAnnotation
		  (getDefensiveStatistic_Errors(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ERRORS"
		   });
		addAnnotation
		  (getDefensiveStatistic_DoublePlay(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DOUBLE-PLAYS"
		   });
		addAnnotation
		  (catcherStatisticEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "CATCHER-STATISTICS"
		   });
		addAnnotation
		  (getCatcherStatistic_PassBall(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PASS-BALLS"
		   });
		addAnnotation
		  (getCatcherStatistic_StolenBase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STOLEN-BASES"
		   });
		addAnnotation
		  (getCatcherStatistic_CaughtStealing(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CAUGHT-STEALING"
		   });
		addAnnotation
		  (offensiveStatisticEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "OFFENSIVE-STATISTICS"
		   });
		addAnnotation
		  (getOffensiveStatistic_PlateAppearances(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PLATE-APPEARANCES"
		   });
		addAnnotation
		  (getOffensiveStatistic_AtBats(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "AT-BATS"
		   });
		addAnnotation
		  (getOffensiveStatistic_Runs(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "RUNS"
		   });
		addAnnotation
		  (getOffensiveStatistic_Hits(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HITS"
		   });
		addAnnotation
		  (getOffensiveStatistic_Double(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DOUBLES"
		   });
		addAnnotation
		  (getOffensiveStatistic_Triple(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TRIPLES"
		   });
		addAnnotation
		  (getOffensiveStatistic_Homerun(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMERUNS"
		   });
		addAnnotation
		  (getOffensiveStatistic_GroundedDoublePlay(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "GROUND-OUT-DOUBLE-PLAY"
		   });
		addAnnotation
		  (getOffensiveStatistic_SacrificeHit(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SACRIFICES-HITS"
		   });
		addAnnotation
		  (getOffensiveStatistic_SacrificeFly(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "SACRIFICE-FLIES"
		   });
		addAnnotation
		  (getOffensiveStatistic_BaseOnBall(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "BASE-ON-BALLS"
		   });
		addAnnotation
		  (getOffensiveStatistic_IntentionalbaseOnBall(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "INTENTIONAL-BASE-ON-BALLS"
		   });
		addAnnotation
		  (getOffensiveStatistic_HitByPitch(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HIT-BY-PITCHS"
		   });
		addAnnotation
		  (getOffensiveStatistic_InterferanceObstruction(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "INTERFEENCE-OBSTRUCTIONS"
		   });
		addAnnotation
		  (getOffensiveStatistic_StolenBase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STOLEN-BASES"
		   });
		addAnnotation
		  (getOffensiveStatistic_CaughtStealing(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CAUGHT-STEALING"
		   });
		addAnnotation
		  (getOffensiveStatistic_StrikeOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "STRIKE-OUTS"
		   });
		addAnnotation
		  (getOffensiveStatistic_Rbi(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "RBIS"
		   });
		addAnnotation
		  (playerEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "PLAYER"
		   });
		addAnnotation
		  (getPlayer_PitcherStatistic(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "PITCHER-STATISTICS"
		   });
		addAnnotation
		  (getPlayer_DefensiveStatistic(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DEFENSIVES-STATISTICS"
		   });
		addAnnotation
		  (getPlayer_CatchersStatistic(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CATCHER-STATISTICS"
		   });
		addAnnotation
		  (getPlayer_OffensiveStatistic(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "OFFENSIVE-STATISTICS"
		   });
		addAnnotation
		  (getPlayer_Name(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "NAME"
		   });
		addAnnotation
		  (playByPlayEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "PLAY-BY-PLAY"
		   });
		addAnnotation
		  (getPlayByPlay_Actiondescription(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ACTION-DESCRIPTION"
		   });
		addAnnotation
		  (gameGeneralStatsEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "GAME-GENERAL-STATS"
		   });
		addAnnotation
		  (getGameGeneralStats_PointsPerInning(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "POINTS-PER-INNING"
		   });
		addAnnotation
		  (getGameGeneralStats_VisitorErrors(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-ERRORS"
		   });
		addAnnotation
		  (getGameGeneralStats_VisitorHits(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-HITS"
		   });
		addAnnotation
		  (getGameGeneralStats_VisitorRuns(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-RUNS"
		   });
		addAnnotation
		  (getGameGeneralStats_HometeamErrors(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-ERRORS"
		   });
		addAnnotation
		  (getGameGeneralStats_HometeamRuns(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-RUNS"
		   });
		addAnnotation
		  (getGameGeneralStats_HometeamHits(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-HITS"
		   });
		addAnnotation
		  (pointsPerInningEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "POINTS-PER-INNING"
		   });
		addAnnotation
		  (getPointsPerInning_Order(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "ORDER"
		   });
		addAnnotation
		  (getPointsPerInning_VisitorPoint(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "VISITOR-POINTS"
		   });
		addAnnotation
		  (getPointsPerInning_HometeamPoint(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HOMETEAM-POINTS"
		   });
		addAnnotation
		  (startingLineupEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "STARTING-LINEUP"
		   });
		addAnnotation
		  (getStartingLineup_TeamName(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TEAM-NAME"
		   });
		addAnnotation
		  (getStartingLineup_LineupPlayers(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "LINEUP-PLAYER"
		   });
		addAnnotation
		  (getStartingLineup_FieldPictrureLink(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "FIELD-PICTURE-LINK"
		   });
		addAnnotation
		  (lineupPlayerEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "LINEUP-PLAYER"
		   });
		addAnnotation
		  (getLineupPlayer_Name(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "NAME"
		   });
		addAnnotation
		  (getLineupPlayer_OffensivePosition(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "OFFENSIVE-POSITION"
		   });
		addAnnotation
		  (getLineupPlayer_DefensivePosition(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "DEFENSIVE-POSITION"
		   });
		addAnnotation
		  (actionDescriptionEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "ACTION-DESCRIPTION"
		   });
		addAnnotation
		  (getActionDescription_Header(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "HEADER"
		   });
		addAnnotation
		  (getActionDescription_Content(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "CONTENT"
		   });
		addAnnotation
		  (getActionDescription_Resume(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "RESUME"
		   });
		addAnnotation
		  (getActionDescription_Team(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "TEAM"
		   });
	}

} //GameReportsPackageImpl
