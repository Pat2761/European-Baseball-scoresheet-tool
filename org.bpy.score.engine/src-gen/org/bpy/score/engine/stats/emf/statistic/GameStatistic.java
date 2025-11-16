/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getGameName <em>Game Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getHometeam <em>Hometeam</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getVisitor <em>Visitor</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getWinningPitcher <em>Winning Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getLoosingPitcher <em>Loosing Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getSavePitcher <em>Save Pitcher</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic()
 * @model
 * @generated
 */
public interface GameStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Game Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Name</em>' attribute.
	 * @see #setGameName(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_GameName()
	 * @model required="true"
	 * @generated
	 */
	String getGameName();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getGameName <em>Game Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Name</em>' attribute.
	 * @see #getGameName()
	 * @generated
	 */
	void setGameName(String value);

	/**
	 * Returns the value of the '<em><b>Hometeam</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam</em>' containment reference.
	 * @see #setHometeam(TeamStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_Hometeam()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TeamStatistic getHometeam();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getHometeam <em>Hometeam</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam</em>' containment reference.
	 * @see #getHometeam()
	 * @generated
	 */
	void setHometeam(TeamStatistic value);

	/**
	 * Returns the value of the '<em><b>Visitor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor</em>' containment reference.
	 * @see #setVisitor(TeamStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_Visitor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TeamStatistic getVisitor();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getVisitor <em>Visitor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor</em>' containment reference.
	 * @see #getVisitor()
	 * @generated
	 */
	void setVisitor(TeamStatistic value);

	/**
	 * Returns the value of the '<em><b>Winning Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Winning Pitcher</em>' attribute.
	 * @see #setWinningPitcher(LineupEntry)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_WinningPitcher()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType"
	 * @generated
	 */
	LineupEntry getWinningPitcher();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getWinningPitcher <em>Winning Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Winning Pitcher</em>' attribute.
	 * @see #getWinningPitcher()
	 * @generated
	 */
	void setWinningPitcher(LineupEntry value);

	/**
	 * Returns the value of the '<em><b>Loosing Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loosing Pitcher</em>' attribute.
	 * @see #setLoosingPitcher(LineupEntry)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_LoosingPitcher()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType"
	 * @generated
	 */
	LineupEntry getLoosingPitcher();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getLoosingPitcher <em>Loosing Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loosing Pitcher</em>' attribute.
	 * @see #getLoosingPitcher()
	 * @generated
	 */
	void setLoosingPitcher(LineupEntry value);

	/**
	 * Returns the value of the '<em><b>Save Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Save Pitcher</em>' attribute.
	 * @see #setSavePitcher(LineupEntry)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getGameStatistic_SavePitcher()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType"
	 * @generated
	 */
	LineupEntry getSavePitcher();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.GameStatistic#getSavePitcher <em>Save Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Save Pitcher</em>' attribute.
	 * @see #getSavePitcher()
	 * @generated
	 */
	void setSavePitcher(LineupEntry value);

} // GameStatistic
