/**
 */
package org.bpy.score.engine.stats.emf.statistic;

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
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getPutOut <em>Put Out</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getAssitances <em>Assitances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getDoublePlay <em>Double Play</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getDefensiveStatistic()
 * @model
 * @generated
 */
public interface DefensiveStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Put Out</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Put Out</em>' attribute.
	 * @see #setPutOut(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getDefensiveStatistic_PutOut()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPutOut();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getPutOut <em>Put Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Put Out</em>' attribute.
	 * @see #getPutOut()
	 * @generated
	 */
	void setPutOut(int value);

	/**
	 * Returns the value of the '<em><b>Assitances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assitances</em>' attribute.
	 * @see #setAssitances(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getDefensiveStatistic_Assitances()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getAssitances();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getAssitances <em>Assitances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assitances</em>' attribute.
	 * @see #getAssitances()
	 * @generated
	 */
	void setAssitances(int value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute.
	 * @see #setErrors(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getDefensiveStatistic_Errors()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(int value);

	/**
	 * Returns the value of the '<em><b>Double Play</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Play</em>' attribute.
	 * @see #setDoublePlay(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getDefensiveStatistic_DoublePlay()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getDoublePlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic#getDoublePlay <em>Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Play</em>' attribute.
	 * @see #getDoublePlay()
	 * @generated
	 */
	void setDoublePlay(int value);

} // DefensiveStatistic
