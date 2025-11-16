/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getCity <em>City</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGamePlayed <em>Game Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameLose <em>Game Lose</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics()
 * @model
 * @generated
 */
public interface TeamStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_City()
	 * @model
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>Game Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Played</em>' attribute.
	 * @see #setGamePlayed(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_GamePlayed()
	 * @model required="true"
	 * @generated
	 */
	int getGamePlayed();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGamePlayed <em>Game Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Played</em>' attribute.
	 * @see #getGamePlayed()
	 * @generated
	 */
	void setGamePlayed(int value);

	/**
	 * Returns the value of the '<em><b>Game Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Win</em>' attribute.
	 * @see #setGameWin(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_GameWin()
	 * @model required="true"
	 * @generated
	 */
	int getGameWin();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameWin <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Win</em>' attribute.
	 * @see #getGameWin()
	 * @generated
	 */
	void setGameWin(int value);

	/**
	 * Returns the value of the '<em><b>Game Lose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Lose</em>' attribute.
	 * @see #setGameLose(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_GameLose()
	 * @model required="true"
	 * @generated
	 */
	int getGameLose();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics#getGameLose <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Lose</em>' attribute.
	 * @see #getGameLose()
	 * @generated
	 */
	void setGameLose(int value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.globalstatistics.Member}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getTeamStatistics_Members()
	 * @model containment="true"
	 * @generated
	 */
	EList<Member> getMembers();

} // TeamStatistics
