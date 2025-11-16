/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.util;

import org.bpy.score.engine.stats.emf.globalstatistics.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage
 * @generated
 */
public class GlobalStatisticsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GlobalStatisticsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalStatisticsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GlobalStatisticsPackage.eINSTANCE;
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
	protected GlobalStatisticsSwitch<Adapter> modelSwitch =
		new GlobalStatisticsSwitch<Adapter>() {
			@Override
			public Adapter caseGlobalStatistic(GlobalStatistic object) {
				return createGlobalStatisticAdapter();
			}
			@Override
			public Adapter caseTeamStatistics(TeamStatistics object) {
				return createTeamStatisticsAdapter();
			}
			@Override
			public Adapter caseMember(Member object) {
				return createMemberAdapter();
			}
			@Override
			public Adapter casePitcherStatistics(PitcherStatistics object) {
				return createPitcherStatisticsAdapter();
			}
			@Override
			public Adapter caseOffensiveStatistics(OffensiveStatistics object) {
				return createOffensiveStatisticsAdapter();
			}
			@Override
			public Adapter caseDefensiveStatistics(DefensiveStatistics object) {
				return createDefensiveStatisticsAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic <em>Global Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic
	 * @generated
	 */
	public Adapter createGlobalStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics <em>Team Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics
	 * @generated
	 */
	public Adapter createTeamStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.Member
	 * @generated
	 */
	public Adapter createMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics <em>Pitcher Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics
	 * @generated
	 */
	public Adapter createPitcherStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics <em>Offensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics
	 * @generated
	 */
	public Adapter createOffensiveStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics <em>Defensive Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics
	 * @generated
	 */
	public Adapter createDefensiveStatisticsAdapter() {
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

} //GlobalStatisticsAdapterFactory
