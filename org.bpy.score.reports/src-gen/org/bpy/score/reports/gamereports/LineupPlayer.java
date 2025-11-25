/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lineup Player</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.LineupPlayer#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.LineupPlayer#getOffensivePosition <em>Offensive Position</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.LineupPlayer#getDefensivePosition <em>Defensive Position</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getLineupPlayer()
 * @model extendedMetaData="kind='elementOnly' name='LINEUP-PLAYER'"
 * @generated
 */
public interface LineupPlayer extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getLineupPlayer_Name()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='NAME'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.LineupPlayer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Offensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offensive Position</em>' attribute.
	 * @see #setOffensivePosition(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getLineupPlayer_OffensivePosition()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='OFFENSIVE-POSITION'"
	 * @generated
	 */
	int getOffensivePosition();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.LineupPlayer#getOffensivePosition <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offensive Position</em>' attribute.
	 * @see #getOffensivePosition()
	 * @generated
	 */
	void setOffensivePosition(int value);

	/**
	 * Returns the value of the '<em><b>Defensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Position</em>' attribute.
	 * @see #setDefensivePosition(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getLineupPlayer_DefensivePosition()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='DEFENSIVE-POSITION'"
	 * @generated
	 */
	String getDefensivePosition();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.LineupPlayer#getDefensivePosition <em>Defensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Position</em>' attribute.
	 * @see #getDefensivePosition()
	 * @generated
	 */
	void setDefensivePosition(String value);

} // LineupPlayer
