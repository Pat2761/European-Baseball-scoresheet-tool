/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bpy.score.reports.gamereports.GameReportsPackage
 * @generated
 */
public interface GameReportsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GameReportsFactory eINSTANCE = org.bpy.score.reports.gamereports.impl.GameReportsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Game Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Game Report</em>'.
	 * @generated
	 */
	GameReport createGameReport();

	/**
	 * Returns a new object of class '<em>Team Statisitics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Team Statisitics</em>'.
	 * @generated
	 */
	TeamStatisitics createTeamStatisitics();

	/**
	 * Returns a new object of class '<em>Pitcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pitcher Statistic</em>'.
	 * @generated
	 */
	PitcherStatistic createPitcherStatistic();

	/**
	 * Returns a new object of class '<em>Defensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defensive Statistic</em>'.
	 * @generated
	 */
	DefensiveStatistic createDefensiveStatistic();

	/**
	 * Returns a new object of class '<em>Catcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catcher Statistic</em>'.
	 * @generated
	 */
	CatcherStatistic createCatcherStatistic();

	/**
	 * Returns a new object of class '<em>Offensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Offensive Statistic</em>'.
	 * @generated
	 */
	OffensiveStatistic createOffensiveStatistic();

	/**
	 * Returns a new object of class '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Player</em>'.
	 * @generated
	 */
	Player createPlayer();

	/**
	 * Returns a new object of class '<em>Play By Play</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Play By Play</em>'.
	 * @generated
	 */
	PlayByPlay createPlayByPlay();

	/**
	 * Returns a new object of class '<em>Game General Stats</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Game General Stats</em>'.
	 * @generated
	 */
	GameGeneralStats createGameGeneralStats();

	/**
	 * Returns a new object of class '<em>Points Per Inning</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Points Per Inning</em>'.
	 * @generated
	 */
	PointsPerInning createPointsPerInning();

	/**
	 * Returns a new object of class '<em>Starting Lineup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Starting Lineup</em>'.
	 * @generated
	 */
	StartingLineup createStartingLineup();

	/**
	 * Returns a new object of class '<em>Lineup Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lineup Player</em>'.
	 * @generated
	 */
	LineupPlayer createLineupPlayer();

	/**
	 * Returns a new object of class '<em>Action Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Description</em>'.
	 * @generated
	 */
	ActionDescription createActionDescription();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GameReportsPackage getGameReportsPackage();

} //GameReportsFactory
