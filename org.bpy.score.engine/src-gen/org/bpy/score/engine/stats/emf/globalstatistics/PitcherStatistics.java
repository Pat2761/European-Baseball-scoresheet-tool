/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pitcher Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameLose <em>Game Lose</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameSave <em>Game Save</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getIps <em>Ips</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics()
 * @model
 * @generated
 */
public interface PitcherStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Game Win</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Win</em>' attribute.
	 * @see #setGameWin(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics_GameWin()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGameWin();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameWin <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Win</em>' attribute.
	 * @see #getGameWin()
	 * @generated
	 */
	void setGameWin(int value);

	/**
	 * Returns the value of the '<em><b>Game Lose</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Lose</em>' attribute.
	 * @see #setGameLose(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics_GameLose()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGameLose();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameLose <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Lose</em>' attribute.
	 * @see #getGameLose()
	 * @generated
	 */
	void setGameLose(int value);

	/**
	 * Returns the value of the '<em><b>Game Save</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Save</em>' attribute.
	 * @see #setGameSave(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics_GameSave()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGameSave();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getGameSave <em>Game Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Save</em>' attribute.
	 * @see #getGameSave()
	 * @generated
	 */
	void setGameSave(int value);

	/**
	 * Returns the value of the '<em><b>Earned Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earned Runs</em>' attribute.
	 * @see #setEarnedRuns(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics_EarnedRuns()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getEarnedRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getEarnedRuns <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Earned Runs</em>' attribute.
	 * @see #getEarnedRuns()
	 * @generated
	 */
	void setEarnedRuns(int value);

	/**
	 * Returns the value of the '<em><b>Ips</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ips</em>' attribute.
	 * @see #setIps(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getPitcherStatistics_Ips()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getIps();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics#getIps <em>Ips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ips</em>' attribute.
	 * @see #getIps()
	 * @generated
	 */
	void setIps(int value);

} // PitcherStatistics
