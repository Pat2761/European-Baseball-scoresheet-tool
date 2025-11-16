/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getPitcherStatistics <em>Pitcher Statistics</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getOffensiveStatistics <em>Offensive Statistics</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getDefensiveStatistics <em>Defensive Statistics</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getMember()
 * @model
 * @generated
 */
public interface Member extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getMember_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pitcher Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitcher Statistics</em>' containment reference.
	 * @see #setPitcherStatistics(PitcherStatistics)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getMember_PitcherStatistics()
	 * @model containment="true"
	 * @generated
	 */
	PitcherStatistics getPitcherStatistics();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getPitcherStatistics <em>Pitcher Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitcher Statistics</em>' containment reference.
	 * @see #getPitcherStatistics()
	 * @generated
	 */
	void setPitcherStatistics(PitcherStatistics value);

	/**
	 * Returns the value of the '<em><b>Offensive Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offensive Statistics</em>' containment reference.
	 * @see #setOffensiveStatistics(OffensiveStatistics)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getMember_OffensiveStatistics()
	 * @model containment="true"
	 * @generated
	 */
	OffensiveStatistics getOffensiveStatistics();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getOffensiveStatistics <em>Offensive Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offensive Statistics</em>' containment reference.
	 * @see #getOffensiveStatistics()
	 * @generated
	 */
	void setOffensiveStatistics(OffensiveStatistics value);

	/**
	 * Returns the value of the '<em><b>Defensive Statistics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Statistics</em>' containment reference.
	 * @see #setDefensiveStatistics(DefensiveStatistics)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getMember_DefensiveStatistics()
	 * @model containment="true"
	 * @generated
	 */
	DefensiveStatistics getDefensiveStatistics();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.Member#getDefensiveStatistics <em>Defensive Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Statistics</em>' containment reference.
	 * @see #getDefensiveStatistics()
	 * @generated
	 */
	void setDefensiveStatistics(DefensiveStatistics value);

} // Member
