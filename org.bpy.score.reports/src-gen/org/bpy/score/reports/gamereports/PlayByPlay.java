/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Play By Play</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.PlayByPlay#getActiondescription <em>Actiondescription</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayByPlay()
 * @model extendedMetaData="kind='elementOnly' name='PLAY-BY-PLAY'"
 * @generated
 */
public interface PlayByPlay extends EObject {
	/**
	 * Returns the value of the '<em><b>Actiondescription</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.reports.gamereports.ActionDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actiondescription</em>' containment reference list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPlayByPlay_Actiondescription()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ACTION-DESCRIPTION'"
	 * @generated
	 */
	EList<ActionDescription> getActiondescription();

} // PlayByPlay
