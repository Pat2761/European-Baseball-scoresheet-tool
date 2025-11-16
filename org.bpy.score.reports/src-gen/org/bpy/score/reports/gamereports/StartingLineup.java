/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Starting Lineup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.StartingLineup#getTeamName <em>Team Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.StartingLineup#getLineupPlayers <em>Lineup Players</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.StartingLineup#getFieldPictrureLink <em>Field Pictrure Link</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getStartingLineup()
 * @model extendedMetaData="kind='element' name='STARTING-LINEUP'"
 * @generated
 */
public interface StartingLineup extends EObject {
	/**
	 * Returns the value of the '<em><b>Team Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team Name</em>' attribute.
	 * @see #setTeamName(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getStartingLineup_TeamName()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='TEAM-NAME'"
	 * @generated
	 */
	String getTeamName();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.StartingLineup#getTeamName <em>Team Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team Name</em>' attribute.
	 * @see #getTeamName()
	 * @generated
	 */
	void setTeamName(String value);

	/**
	 * Returns the value of the '<em><b>Lineup Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.reports.gamereports.LineupPlayer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lineup Players</em>' containment reference list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getStartingLineup_LineupPlayers()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='LINEUP-PLAYER'"
	 * @generated
	 */
	EList<LineupPlayer> getLineupPlayers();

	/**
	 * Returns the value of the '<em><b>Field Pictrure Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Pictrure Link</em>' attribute.
	 * @see #setFieldPictrureLink(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getStartingLineup_FieldPictrureLink()
	 * @model extendedMetaData="kind='element' name='FIELD-PICTURE-LINK'"
	 * @generated
	 */
	String getFieldPictrureLink();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.StartingLineup#getFieldPictrureLink <em>Field Pictrure Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Pictrure Link</em>' attribute.
	 * @see #getFieldPictrureLink()
	 * @generated
	 */
	void setFieldPictrureLink(String value);

} // StartingLineup
