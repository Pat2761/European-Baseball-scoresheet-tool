/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.ActionDescription#getHeader <em>Header</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.ActionDescription#getContent <em>Content</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.ActionDescription#getResume <em>Resume</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getActionDescription()
 * @model extendedMetaData="kind='element' name='ACTION-DESCRIPTION'"
 * @generated
 */
public interface ActionDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' attribute.
	 * @see #setHeader(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getActionDescription_Header()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='HEADER'"
	 * @generated
	 */
	String getHeader();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.ActionDescription#getHeader <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' attribute.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(String value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getActionDescription_Content()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='CONTENT'"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.ActionDescription#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Resume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resume</em>' attribute.
	 * @see #setResume(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getActionDescription_Resume()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='RESUME'"
	 * @generated
	 */
	String getResume();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.ActionDescription#getResume <em>Resume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resume</em>' attribute.
	 * @see #getResume()
	 * @generated
	 */
	void setResume(String value);

} // ActionDescription
