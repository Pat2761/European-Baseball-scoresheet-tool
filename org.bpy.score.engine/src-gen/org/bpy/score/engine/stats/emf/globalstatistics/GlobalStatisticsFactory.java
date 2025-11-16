/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage
 * @generated
 */
public interface GlobalStatisticsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlobalStatisticsFactory eINSTANCE = org.bpy.score.engine.stats.emf.globalstatistics.impl.GlobalStatisticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Global Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Statistic</em>'.
	 * @generated
	 */
	GlobalStatistic createGlobalStatistic();

	/**
	 * Returns a new object of class '<em>Team Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Team Statistics</em>'.
	 * @generated
	 */
	TeamStatistics createTeamStatistics();

	/**
	 * Returns a new object of class '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member</em>'.
	 * @generated
	 */
	Member createMember();

	/**
	 * Returns a new object of class '<em>Pitcher Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pitcher Statistics</em>'.
	 * @generated
	 */
	PitcherStatistics createPitcherStatistics();

	/**
	 * Returns a new object of class '<em>Offensive Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Offensive Statistics</em>'.
	 * @generated
	 */
	OffensiveStatistics createOffensiveStatistics();

	/**
	 * Returns a new object of class '<em>Defensive Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defensive Statistics</em>'.
	 * @generated
	 */
	DefensiveStatistics createDefensiveStatistics();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GlobalStatisticsPackage getGlobalStatisticsPackage();

} //GlobalStatisticsFactory
