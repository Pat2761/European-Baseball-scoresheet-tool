/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Points Per Inning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.PointsPerInning#getOrder <em>Order</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PointsPerInning#getVisitorPoint <em>Visitor Point</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PointsPerInning#getHometeamPoint <em>Hometeam Point</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPointsPerInning()
 * @model extendedMetaData="kind='elementOnly' name='POINTS-PER-INNING'"
 * @generated
 */
public interface PointsPerInning extends EObject {
	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPointsPerInning_Order()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='ORDER'"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PointsPerInning#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * Returns the value of the '<em><b>Visitor Point</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Point</em>' attribute.
	 * @see #setVisitorPoint(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPointsPerInning_VisitorPoint()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='VISITOR-POINTS'"
	 * @generated
	 */
	int getVisitorPoint();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PointsPerInning#getVisitorPoint <em>Visitor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Point</em>' attribute.
	 * @see #getVisitorPoint()
	 * @generated
	 */
	void setVisitorPoint(int value);

	/**
	 * Returns the value of the '<em><b>Hometeam Point</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Point</em>' attribute.
	 * @see #setHometeamPoint(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPointsPerInning_HometeamPoint()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-POINTS'"
	 * @generated
	 */
	int getHometeamPoint();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PointsPerInning#getHometeamPoint <em>Hometeam Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Point</em>' attribute.
	 * @see #getHometeamPoint()
	 * @generated
	 */
	void setHometeamPoint(int value);

} // PointsPerInning
