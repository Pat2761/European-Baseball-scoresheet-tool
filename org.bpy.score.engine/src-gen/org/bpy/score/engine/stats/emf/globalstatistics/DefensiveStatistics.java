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
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getAssists <em>Assists</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getCaughtStealingPercentage <em>Caught Stealing Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getDoublePlays <em>Double Plays</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getFieldingPercentage <em>Fielding Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getInningsPlayed <em>Innings Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOuts <em>Outs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOutfieldAssist <em>Outfield Assist</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPassedBall <em>Passed Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPutouts <em>Putouts</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTotalChances <em>Total Chances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTriplePlay <em>Triple Play</em>}</li>
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
	 * Returns the value of the '<em><b>Total Chances</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Chances</em>' attribute.
	 * @see #setTotalChances(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_TotalChances()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getTotalChances();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTotalChances <em>Total Chances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Chances</em>' attribute.
	 * @see #getTotalChances()
	 * @generated
	 */
	void setTotalChances(int value);

	/**
	 * Returns the value of the '<em><b>Triple Play</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triple Play</em>' attribute.
	 * @see #setTriplePlay(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_TriplePlay()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getTriplePlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getTriplePlay <em>Triple Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triple Play</em>' attribute.
	 * @see #getTriplePlay()
	 * @generated
	 */
	void setTriplePlay(int value);

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
	 * Returns the value of the '<em><b>Caught Stealing Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing Percentage</em>' attribute.
	 * @see #setCaughtStealingPercentage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_CaughtStealingPercentage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getCaughtStealingPercentage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getCaughtStealingPercentage <em>Caught Stealing Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing Percentage</em>' attribute.
	 * @see #getCaughtStealingPercentage()
	 * @generated
	 */
	void setCaughtStealingPercentage(double value);

	/**
	 * Returns the value of the '<em><b>Double Plays</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Plays</em>' attribute.
	 * @see #setDoublePlays(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_DoublePlays()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getDoublePlays();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getDoublePlays <em>Double Plays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Plays</em>' attribute.
	 * @see #getDoublePlays()
	 * @generated
	 */
	void setDoublePlays(int value);

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

	/**
	 * Returns the value of the '<em><b>Fielding Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fielding Percentage</em>' attribute.
	 * @see #setFieldingPercentage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_FieldingPercentage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getFieldingPercentage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getFieldingPercentage <em>Fielding Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fielding Percentage</em>' attribute.
	 * @see #getFieldingPercentage()
	 * @generated
	 */
	void setFieldingPercentage(double value);

	/**
	 * Returns the value of the '<em><b>Innings Played</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Innings Played</em>' attribute.
	 * @see #setInningsPlayed(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_InningsPlayed()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getInningsPlayed();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getInningsPlayed <em>Innings Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Innings Played</em>' attribute.
	 * @see #getInningsPlayed()
	 * @generated
	 */
	void setInningsPlayed(double value);

	/**
	 * Returns the value of the '<em><b>Outs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outs</em>' attribute.
	 * @see #setOuts(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_Outs()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getOuts();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOuts <em>Outs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outs</em>' attribute.
	 * @see #getOuts()
	 * @generated
	 */
	void setOuts(int value);

	/**
	 * Returns the value of the '<em><b>Outfield Assist</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outfield Assist</em>' attribute.
	 * @see #setOutfieldAssist(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_OutfieldAssist()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getOutfieldAssist();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getOutfieldAssist <em>Outfield Assist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outfield Assist</em>' attribute.
	 * @see #getOutfieldAssist()
	 * @generated
	 */
	void setOutfieldAssist(int value);

	/**
	 * Returns the value of the '<em><b>Passed Ball</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passed Ball</em>' attribute.
	 * @see #setPassedBall(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getDefensiveStatistics_PassedBall()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getPassedBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics#getPassedBall <em>Passed Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passed Ball</em>' attribute.
	 * @see #getPassedBall()
	 * @generated
	 */
	void setPassedBall(int value);

} // DefensiveStatistics
