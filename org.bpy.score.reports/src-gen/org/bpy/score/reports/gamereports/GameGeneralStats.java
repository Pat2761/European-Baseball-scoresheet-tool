/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game General Stats</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getPointsPerInning <em>Points Per Inning</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorErrors <em>Visitor Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorHits <em>Visitor Hits</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorRuns <em>Visitor Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamErrors <em>Hometeam Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamRuns <em>Hometeam Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamHits <em>Hometeam Hits</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats()
 * @model extendedMetaData="kind='elementOnly' name='GAME-GENERAL-STATS'"
 * @generated
 */
public interface GameGeneralStats extends EObject {
	/**
	 * Returns the value of the '<em><b>Points Per Inning</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.reports.gamereports.PointsPerInning}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points Per Inning</em>' containment reference list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_PointsPerInning()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='POINTS-PER-INNING'"
	 * @generated
	 */
	EList<PointsPerInning> getPointsPerInning();

	/**
	 * Returns the value of the '<em><b>Visitor Errors</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Errors</em>' attribute.
	 * @see #setVisitorErrors(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_VisitorErrors()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='VISITOR-ERRORS'"
	 * @generated
	 */
	int getVisitorErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorErrors <em>Visitor Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Errors</em>' attribute.
	 * @see #getVisitorErrors()
	 * @generated
	 */
	void setVisitorErrors(int value);

	/**
	 * Returns the value of the '<em><b>Visitor Hits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Hits</em>' attribute.
	 * @see #setVisitorHits(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_VisitorHits()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='VISITOR-HITS'"
	 * @generated
	 */
	int getVisitorHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorHits <em>Visitor Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Hits</em>' attribute.
	 * @see #getVisitorHits()
	 * @generated
	 */
	void setVisitorHits(int value);

	/**
	 * Returns the value of the '<em><b>Visitor Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Runs</em>' attribute.
	 * @see #setVisitorRuns(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_VisitorRuns()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='VISITOR-RUNS'"
	 * @generated
	 */
	int getVisitorRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getVisitorRuns <em>Visitor Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Runs</em>' attribute.
	 * @see #getVisitorRuns()
	 * @generated
	 */
	void setVisitorRuns(int value);

	/**
	 * Returns the value of the '<em><b>Hometeam Errors</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Errors</em>' attribute.
	 * @see #setHometeamErrors(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_HometeamErrors()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-ERRORS'"
	 * @generated
	 */
	int getHometeamErrors();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamErrors <em>Hometeam Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Errors</em>' attribute.
	 * @see #getHometeamErrors()
	 * @generated
	 */
	void setHometeamErrors(int value);

	/**
	 * Returns the value of the '<em><b>Hometeam Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Runs</em>' attribute.
	 * @see #setHometeamRuns(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_HometeamRuns()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-RUNS'"
	 * @generated
	 */
	int getHometeamRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamRuns <em>Hometeam Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Runs</em>' attribute.
	 * @see #getHometeamRuns()
	 * @generated
	 */
	void setHometeamRuns(int value);

	/**
	 * Returns the value of the '<em><b>Hometeam Hits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Hits</em>' attribute.
	 * @see #setHometeamHits(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameGeneralStats_HometeamHits()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-HITS'"
	 * @generated
	 */
	int getHometeamHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameGeneralStats#getHometeamHits <em>Hometeam Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Hits</em>' attribute.
	 * @see #getHometeamHits()
	 * @generated
	 */
	void setHometeamHits(int value);

} // GameGeneralStats
