/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defensive Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getPutOut <em>Put Out</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getAssitances <em>Assitances</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getDoublePlay <em>Double Play</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getDefensiveStatistic()
 * @model extendedMetaData="kind='elementOnly' name='DEFENSIVES-STATISTICS'"
 * @generated
 */
public interface DefensiveStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Put Out</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Put Out</em>' attribute.
	 * @see #setPutOut(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getDefensiveStatistic_PutOut()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PUT-OUTS'"
	 * @generated
	 */
	int getPutOut();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getPutOut <em>Put Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Put Out</em>' attribute.
	 * @see #getPutOut()
	 * @generated
	 */
	void setPutOut(int value);

	/**
	 * Returns the value of the '<em><b>Assitances</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assitances</em>' attribute.
	 * @see #setAssitances(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getDefensiveStatistic_Assitances()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='ASSISTANCES'"
	 * @generated
	 */
	int getAssitances();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getAssitances <em>Assitances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assitances</em>' attribute.
	 * @see #getAssitances()
	 * @generated
	 */
	void setAssitances(int value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute.
	 * @see #setErrors(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getDefensiveStatistic_Errors()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='ERRORS'"
	 * @generated
	 */
	int getErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(int value);

	/**
	 * Returns the value of the '<em><b>Double Play</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Play</em>' attribute.
	 * @see #setDoublePlay(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getDefensiveStatistic_DoublePlay()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='DOUBLE-PLAYS'"
	 * @generated
	 */
	int getDoublePlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.DefensiveStatistic#getDoublePlay <em>Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Play</em>' attribute.
	 * @see #getDoublePlay()
	 * @generated
	 */
	void setDoublePlay(int value);

} // DefensiveStatistic
