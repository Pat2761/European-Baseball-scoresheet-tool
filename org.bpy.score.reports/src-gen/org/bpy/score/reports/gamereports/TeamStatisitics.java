/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team Statisitics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.TeamStatisitics#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTeamName <em>Team Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTown <em>Town</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameLose <em>Game Lose</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics()
 * @model extendedMetaData="kind='elementOnly' name='TEAM-STATISTICS'"
 * @generated
 */
public interface TeamStatisitics extends EObject {
	/**
	 * Returns the value of the '<em><b>Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.reports.gamereports.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Players</em>' containment reference list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics_Players()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='PLAYER'"
	 * @generated
	 */
	EList<Player> getPlayers();

	/**
	 * Returns the value of the '<em><b>Team Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team Name</em>' attribute.
	 * @see #setTeamName(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics_TeamName()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='TEAM-NAME'"
	 * @generated
	 */
	String getTeamName();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTeamName <em>Team Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team Name</em>' attribute.
	 * @see #getTeamName()
	 * @generated
	 */
	void setTeamName(String value);

	/**
	 * Returns the value of the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Town</em>' attribute.
	 * @see #setTown(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics_Town()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='TOWN-NAME'"
	 * @generated
	 */
	String getTown();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getTown <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Town</em>' attribute.
	 * @see #getTown()
	 * @generated
	 */
	void setTown(String value);

	/**
	 * Returns the value of the '<em><b>Game Win</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Win</em>' attribute.
	 * @see #setGameWin(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics_GameWin()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GAME-WIN'"
	 * @generated
	 */
	int getGameWin();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameWin <em>Game Win</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTeamStatisitics_GameLose()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GAME-LOSE'"
	 * @generated
	 */
	int getGameLose();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.TeamStatisitics#getGameLose <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Lose</em>' attribute.
	 * @see #getGameLose()
	 * @generated
	 */
	void setGameLose(int value);

} // TeamStatisitics
