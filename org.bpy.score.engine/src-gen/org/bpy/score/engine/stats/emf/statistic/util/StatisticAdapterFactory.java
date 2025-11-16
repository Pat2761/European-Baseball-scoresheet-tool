/**
 */
package org.bpy.score.engine.stats.emf.statistic.util;

import java.util.Map;

import org.bpy.score.engine.stats.emf.statistic.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage
 * @generated
 */
public class StatisticAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatisticPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StatisticPackage.eINSTANCE;
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
	protected StatisticSwitch<Adapter> modelSwitch =
		new StatisticSwitch<Adapter>() {
			@Override
			public Adapter caseGameStatistic(GameStatistic object) {
				return createGameStatisticAdapter();
			}
			@Override
			public Adapter caseTeamStatistic(TeamStatistic object) {
				return createTeamStatisticAdapter();
			}
			@Override
			public Adapter caseInningGeneralStatistic(InningGeneralStatistic object) {
				return createInningGeneralStatisticAdapter();
			}
			@Override
			public Adapter caseInninStatictic(InninStatictic object) {
				return createInninStaticticAdapter();
			}
			@Override
			public Adapter caseOffensiveStatistic(OffensiveStatistic object) {
				return createOffensiveStatisticAdapter();
			}
			@Override
			public Adapter casePitcherStatistic(PitcherStatistic object) {
				return createPitcherStatisticAdapter();
			}
			@Override
			public Adapter caseCatcherStatistic(CatcherStatistic object) {
				return createCatcherStatisticAdapter();
			}
			@Override
			public Adapter caseDefensiveStatistic(DefensiveStatistic object) {
				return createDefensiveStatisticAdapter();
			}
			@Override
			public Adapter caseLineupEntry(LineupEntry object) {
				return createLineupEntryAdapter();
			}
			@Override
			public Adapter caseEStringToAssociatedObjectMap(Map.Entry<String, Object> object) {
				return createEStringToAssociatedObjectMapAdapter();
			}
			@Override
			public Adapter caseEStringToLineupEntryTypeMap(Map.Entry<String, LineupEntry> object) {
				return createEStringToLineupEntryTypeMapAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic <em>Game Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.GameStatistic
	 * @generated
	 */
	public Adapter createGameStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic <em>Team Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.TeamStatistic
	 * @generated
	 */
	public Adapter createTeamStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic <em>Inning General Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic
	 * @generated
	 */
	public Adapter createInningGeneralStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic <em>Innin Statictic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.InninStatictic
	 * @generated
	 */
	public Adapter createInninStaticticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic <em>Offensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic
	 * @generated
	 */
	public Adapter createOffensiveStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic <em>Pitcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.PitcherStatistic
	 * @generated
	 */
	public Adapter createPitcherStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.CatcherStatistic <em>Catcher Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.CatcherStatistic
	 * @generated
	 */
	public Adapter createCatcherStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic <em>Defensive Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic
	 * @generated
	 */
	public Adapter createDefensiveStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry <em>Lineup Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.statistic.LineupEntry
	 * @generated
	 */
	public Adapter createLineupEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To Associated Object Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToAssociatedObjectMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To Lineup Entry Type Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToLineupEntryTypeMapAdapter() {
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

} //StatisticAdapterFactory
