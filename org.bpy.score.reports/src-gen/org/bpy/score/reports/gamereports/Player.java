/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.Player#getPitcherStatistic <em>Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.Player#getDefensiveStatistic <em>Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.Player#getCatchersStatistic <em>Catchers Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.Player#getOffensiveStatistic <em>Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.Player#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer()
 * @model extendedMetaData="kind='elementOnly' name='PLAYER'"
 * @generated
 */
public interface Player extends EObject {
	/**
	 * Returns the value of the '<em><b>Pitcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitcher Statistic</em>' containment reference.
	 * @see #setPitcherStatistic(PitcherStatistic)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer_PitcherStatistic()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='PITCHER-STATISTICS'"
	 * @generated
	 */
	PitcherStatistic getPitcherStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.Player#getPitcherStatistic <em>Pitcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitcher Statistic</em>' containment reference.
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	void setPitcherStatistic(PitcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Defensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Statistic</em>' containment reference.
	 * @see #setDefensiveStatistic(DefensiveStatistic)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer_DefensiveStatistic()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DEFENSIVES-STATISTICS'"
	 * @generated
	 */
	DefensiveStatistic getDefensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.Player#getDefensiveStatistic <em>Defensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Statistic</em>' containment reference.
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	void setDefensiveStatistic(DefensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Catchers Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catchers Statistic</em>' containment reference.
	 * @see #setCatchersStatistic(CatcherStatistic)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer_CatchersStatistic()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='CATCHER-STATISTICS'"
	 * @generated
	 */
	CatcherStatistic getCatchersStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.Player#getCatchersStatistic <em>Catchers Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catchers Statistic</em>' containment reference.
	 * @see #getCatchersStatistic()
	 * @generated
	 */
	void setCatchersStatistic(CatcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Offensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offensive Statistic</em>' containment reference.
	 * @see #setOffensiveStatistic(OffensiveStatistic)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer_OffensiveStatistic()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='OFFENSIVE-STATISTICS'"
	 * @generated
	 */
	OffensiveStatistic getOffensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.Player#getOffensiveStatistic <em>Offensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offensive Statistic</em>' containment reference.
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	void setOffensiveStatistic(OffensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayer_Name()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='NAME'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.Player#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Player
