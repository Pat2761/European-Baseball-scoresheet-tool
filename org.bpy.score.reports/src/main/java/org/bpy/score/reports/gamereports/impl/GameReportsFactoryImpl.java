/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GameReportsFactoryImpl extends EFactoryImpl implements GameReportsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GameReportsFactory init() {
		try {
			GameReportsFactory theGameReportsFactory = (GameReportsFactory)EPackage.Registry.INSTANCE.getEFactory(GameReportsPackage.eNS_URI);
			if (theGameReportsFactory != null) {
				return theGameReportsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GameReportsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GameReportsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GameReportsPackage.GAME_REPORT: return createGameReport();
			case GameReportsPackage.TEAM_STATISITICS: return createTeamStatisitics();
			case GameReportsPackage.PITCHER_STATISTIC: return createPitcherStatistic();
			case GameReportsPackage.DEFENSIVE_STATISTIC: return createDefensiveStatistic();
			case GameReportsPackage.CATCHER_STATISTIC: return createCatcherStatistic();
			case GameReportsPackage.OFFENSIVE_STATISTIC: return createOffensiveStatistic();
			case GameReportsPackage.PLAYER: return createPlayer();
			case GameReportsPackage.PLAY_BY_PLAY: return createPlayByPlay();
			case GameReportsPackage.GAME_GENERAL_STATS: return createGameGeneralStats();
			case GameReportsPackage.POINTS_PER_INNING: return createPointsPerInning();
			case GameReportsPackage.STARTING_LINEUP: return createStartingLineup();
			case GameReportsPackage.LINEUP_PLAYER: return createLineupPlayer();
			case GameReportsPackage.ACTION_DESCRIPTION: return createActionDescription();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GameReportsPackage.TEAM:
				return createTEAMFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GameReportsPackage.TEAM:
				return convertTEAMToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameReport createGameReport() {
		GameReportImpl gameReport = new GameReportImpl();
		return gameReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatisitics createTeamStatisitics() {
		TeamStatisiticsImpl teamStatisitics = new TeamStatisiticsImpl();
		return teamStatisitics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistic createPitcherStatistic() {
		PitcherStatisticImpl pitcherStatistic = new PitcherStatisticImpl();
		return pitcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistic createDefensiveStatistic() {
		DefensiveStatisticImpl defensiveStatistic = new DefensiveStatisticImpl();
		return defensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatcherStatistic createCatcherStatistic() {
		CatcherStatisticImpl catcherStatistic = new CatcherStatisticImpl();
		return catcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistic createOffensiveStatistic() {
		OffensiveStatisticImpl offensiveStatistic = new OffensiveStatisticImpl();
		return offensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Player createPlayer() {
		PlayerImpl player = new PlayerImpl();
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PlayByPlay createPlayByPlay() {
		PlayByPlayImpl playByPlay = new PlayByPlayImpl();
		return playByPlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameGeneralStats createGameGeneralStats() {
		GameGeneralStatsImpl gameGeneralStats = new GameGeneralStatsImpl();
		return gameGeneralStats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointsPerInning createPointsPerInning() {
		PointsPerInningImpl pointsPerInning = new PointsPerInningImpl();
		return pointsPerInning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StartingLineup createStartingLineup() {
		StartingLineupImpl startingLineup = new StartingLineupImpl();
		return startingLineup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupPlayer createLineupPlayer() {
		LineupPlayerImpl lineupPlayer = new LineupPlayerImpl();
		return lineupPlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionDescription createActionDescription() {
		ActionDescriptionImpl actionDescription = new ActionDescriptionImpl();
		return actionDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEAM createTEAMFromString(EDataType eDataType, String initialValue) {
		TEAM result = TEAM.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTEAMToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameReportsPackage getGameReportsPackage() {
		return (GameReportsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GameReportsPackage getPackage() {
		return GameReportsPackage.eINSTANCE;
	}

} //GameReportsFactoryImpl
