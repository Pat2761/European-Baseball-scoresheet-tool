/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Innin Statictic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getInningStat <em>Inning Stat</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getCumulativeInningStat <em>Cumulative Inning Stat</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInninStatictic()
 * @model
 * @generated
 */
public interface InninStatictic extends EObject {
	/**
	 * Returns the value of the '<em><b>Inning Stat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inning Stat</em>' containment reference.
	 * @see #setInningStat(InningGeneralStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInninStatictic_InningStat()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InningGeneralStatistic getInningStat();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getInningStat <em>Inning Stat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inning Stat</em>' containment reference.
	 * @see #getInningStat()
	 * @generated
	 */
	void setInningStat(InningGeneralStatistic value);

	/**
	 * Returns the value of the '<em><b>Cumulative Inning Stat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cumulative Inning Stat</em>' containment reference.
	 * @see #setCumulativeInningStat(InningGeneralStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getInninStatictic_CumulativeInningStat()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InningGeneralStatistic getCumulativeInningStat();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.InninStatictic#getCumulativeInningStat <em>Cumulative Inning Stat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cumulative Inning Stat</em>' containment reference.
	 * @see #getCumulativeInningStat()
	 * @generated
	 */
	void setCumulativeInningStat(InningGeneralStatistic value);

} // InninStatictic
