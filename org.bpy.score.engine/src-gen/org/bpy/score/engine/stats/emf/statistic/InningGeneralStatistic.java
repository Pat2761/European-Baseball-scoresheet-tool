/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inning General Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAssitances <em>Assitances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getLob <em>Lob</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic()
 * @model
 * @generated
 */
public interface InningGeneralStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>At Bats</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bats</em>' attribute.
	 * @see #setAtBats(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_AtBats()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getAtBats();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAtBats <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Bats</em>' attribute.
	 * @see #getAtBats()
	 * @generated
	 */
	void setAtBats(int value);

	/**
	 * Returns the value of the '<em><b>Runs</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs</em>' attribute.
	 * @see #setRuns(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_Runs()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getRuns <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runs</em>' attribute.
	 * @see #getRuns()
	 * @generated
	 */
	void setRuns(int value);

	/**
	 * Returns the value of the '<em><b>Earned Runs</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earned Runs</em>' attribute.
	 * @see #setEarnedRuns(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_EarnedRuns()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getEarnedRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getEarnedRuns <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Earned Runs</em>' attribute.
	 * @see #getEarnedRuns()
	 * @generated
	 */
	void setEarnedRuns(int value);

	/**
	 * Returns the value of the '<em><b>Hits</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hits</em>' attribute.
	 * @see #setHits(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_Hits()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getHits <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hits</em>' attribute.
	 * @see #getHits()
	 * @generated
	 */
	void setHits(int value);

	/**
	 * Returns the value of the '<em><b>Assitances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assitances</em>' attribute.
	 * @see #setAssitances(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_Assitances()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getAssitances();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getAssitances <em>Assitances</em>}' attribute.
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
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_Errors()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(int value);

	/**
	 * Returns the value of the '<em><b>Lob</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lob</em>' attribute.
	 * @see #setLob(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInningGeneralStatistic_Lob()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getLob();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic#getLob <em>Lob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lob</em>' attribute.
	 * @see #getLob()
	 * @generated
	 */
	void setLob(int value);

} // InningGeneralStatistic
