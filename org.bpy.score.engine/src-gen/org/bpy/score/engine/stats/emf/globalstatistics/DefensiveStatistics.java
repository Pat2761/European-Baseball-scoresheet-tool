/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defensive Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPutouts <em>Putouts</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getAssists <em>Assists</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getErrors <em>Errors</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics()
 * @model
 * @generated
 */
public interface DefensiveStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Putouts</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Putouts</em>' attribute.
	 * @see #setPutouts(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_Putouts()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getPutouts();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPutouts <em>Putouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Putouts</em>' attribute.
	 * @see #getPutouts()
	 * @generated
	 */
	void setPutouts(int value);

	/**
	 * Returns the value of the '<em><b>Assists</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assists</em>' attribute.
	 * @see #setAssists(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_Assists()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getAssists();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getAssists <em>Assists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assists</em>' attribute.
	 * @see #getAssists()
	 * @generated
	 */
	void setAssists(int value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute.
	 * @see #setErrors(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_Errors()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(int value);

} // DefensiveStatistics
