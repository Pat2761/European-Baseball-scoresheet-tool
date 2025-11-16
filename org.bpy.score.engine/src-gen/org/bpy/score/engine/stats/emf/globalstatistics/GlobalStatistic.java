/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic#getTeams <em>Teams</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getGlobalStatistic()
 * @model
 * @generated
 */
public interface GlobalStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Teams</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Teams</em>' containment reference list.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getGlobalStatistic_Teams()
	 * @model containment="true"
	 * @generated
	 */
	EList<TeamStatistics> getTeams();

} // GlobalStatistic
