/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage
 * @generated
 */
public interface StatisticFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatisticFactory eINSTANCE = org.bpy.score.engine.stats.emf.statistic.impl.StatisticFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Game Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Game Statistic</em>'.
	 * @generated
	 */
	GameStatistic createGameStatistic();

	/**
	 * Returns a new object of class '<em>Team Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Team Statistic</em>'.
	 * @generated
	 */
	TeamStatistic createTeamStatistic();

	/**
	 * Returns a new object of class '<em>Inning General Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inning General Statistic</em>'.
	 * @generated
	 */
	InningGeneralStatistic createInningGeneralStatistic();

	/**
	 * Returns a new object of class '<em>Innin Statictic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Innin Statictic</em>'.
	 * @generated
	 */
	InninStatictic createInninStatictic();

	/**
	 * Returns a new object of class '<em>Offensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Offensive Statistic</em>'.
	 * @generated
	 */
	OffensiveStatistic createOffensiveStatistic();

	/**
	 * Returns a new object of class '<em>Pitcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pitcher Statistic</em>'.
	 * @generated
	 */
	PitcherStatistic createPitcherStatistic();

	/**
	 * Returns a new object of class '<em>Catcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catcher Statistic</em>'.
	 * @generated
	 */
	CatcherStatistic createCatcherStatistic();

	/**
	 * Returns a new object of class '<em>Defensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defensive Statistic</em>'.
	 * @generated
	 */
	DefensiveStatistic createDefensiveStatistic();

	/**
	 * Returns a new object of class '<em>Lineup Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lineup Entry</em>'.
	 * @generated
	 */
	LineupEntry createLineupEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatisticPackage getStatisticPackage();

} //StatisticFactory
