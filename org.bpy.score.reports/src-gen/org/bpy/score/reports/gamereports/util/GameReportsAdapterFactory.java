/**
 */
package org.bpy.score.reports.gamereports.util;

import org.bpy.score.reports.gamereports.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.reports.gamereports.GameReportsPackage
 * @generated
 */
public class GameReportsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GameReportsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GameReportsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GameReportsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameReportsSwitch<Adapter> modelSwitch =
		new GameReportsSwitch<Adapter>() {
			@Override
			public Adapter caseGameReport(GameReport object) {
				return createGameReportAdapter();
			}
			@Override
			public Adapter caseTeamStatisitics(TeamStatisitics object) {
				return createTeamStatisiticsAdapter();
			}
			@Override
			public Adapter casePitcherStatistic(PitcherStatistic object) {
				return createPitcherStatisticAdapter();
			}
			@Override
			public Adapter caseDefensiveStatistic(DefensiveStatistic object) {
				return createDefensiveStatisticAdapter();
			}
			@Override
			public Adapter caseCatcherStatistic(CatcherStatistic object) {
				return createCatcherStatisticAdapter();
			}
			@Override
			public Adapter caseOffensiveStatistic(OffensiveStatistic object) {
				return createOffensiveStatisticAdapter();
			}
			@Override
			public Adapter casePlayer(Player object) {
				return createPlayerAdapter();
			}
			@Override
			public Adapter casePlayByPlay(PlayByPlay object) {
				return createPlayByPlayAdapter();
			}
			@Override
			public Adapter caseGameGeneralStats(GameGeneralStats object) {
				return createGameGeneralStatsAdapter();
			}
			@Override
			public Adapter casePointsPerInning(PointsPerInning object) {
				return createPointsPerInningAdapter();
			}
			@Override
			public Adapter caseStartingLineup(StartingLineup object) {
				return createStartingLineupAdapter();
			}
			@Override
			public Adapter caseLineupPlayer(LineupPlayer object) {
				return createLineupPlayerAdapter();
			}
			@Override
			public Adapter caseActionDescription(ActionDescription object) {
				return createActionDescriptionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.GameReport <em>Game Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.GameReport
	 * @generated
	 */
	public Adapter createGameReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.TeamStatisitics <em>Team Statisitics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.TeamStatisitics
	 * @generated
	 */
	public Adapter createTeamStatisiticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.PitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.PitcherStatistic
	 * @generated
	 */
	public Adapter createPitcherStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.DefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.DefensiveStatistic
	 * @generated
	 */
	public Adapter createDefensiveStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.CatcherStatistic <em>Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.CatcherStatistic
	 * @generated
	 */
	public Adapter createCatcherStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.OffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.OffensiveStatistic
	 * @generated
	 */
	public Adapter createOffensiveStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.Player
	 * @generated
	 */
	public Adapter createPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.PlayByPlay <em>Play By Play</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.PlayByPlay
	 * @generated
	 */
	public Adapter createPlayByPlayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.GameGeneralStats <em>Game General Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.GameGeneralStats
	 * @generated
	 */
	public Adapter createGameGeneralStatsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.PointsPerInning <em>Points Per Inning</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.PointsPerInning
	 * @generated
	 */
	public Adapter createPointsPerInningAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.StartingLineup <em>Starting Lineup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.StartingLineup
	 * @generated
	 */
	public Adapter createStartingLineupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.LineupPlayer <em>Lineup Player</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.LineupPlayer
	 * @generated
	 */
	public Adapter createLineupPlayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.reports.gamereports.ActionDescription <em>Action Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.reports.gamereports.ActionDescription
	 * @generated
	 */
	public Adapter createActionDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GameReportsAdapterFactory
