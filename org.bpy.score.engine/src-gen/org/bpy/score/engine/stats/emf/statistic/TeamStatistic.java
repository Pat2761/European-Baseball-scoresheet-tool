/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGeneralInningStats <em>General Inning Stats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalCatcherStatistic <em>Total Catcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalDefensiveStatistic <em>Total Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalPitcherStatistic <em>Total Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalOffensiveStatistic <em>Total Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getDoublePlayCounter <em>Double Play Counter</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTieBreakCounter <em>Tie Break Counter</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentOffensivePlayer <em>Current Offensive Player</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentDefensivePlayer <em>Current Defensive Player</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentCatcher <em>Current Catcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentPitcher <em>Current Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCatchers <em>Catchers</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPitchers <em>Pitchers</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGwRbi <em>Gw Rbi</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getEarnedAgainstTheTeam <em>Earned Against The Team</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getFinalScore <em>Final Score</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic()
 * @model annotation="http://www.obeo.fr/dsl/dnc/archetype archetype='Role'"
 * @generated
 */
public interface TeamStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>General Inning Stats</b></em>' containment reference list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.statistic.InninStatictic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Inning Stats</em>' containment reference list.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_GeneralInningStats()
	 * @model containment="true"
	 * @generated
	 */
	EList<InninStatictic> getGeneralInningStats();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Total Catcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Catcher Statistic</em>' containment reference.
	 * @see #setTotalCatcherStatistic(CatcherStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_TotalCatcherStatistic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CatcherStatistic getTotalCatcherStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalCatcherStatistic <em>Total Catcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Catcher Statistic</em>' containment reference.
	 * @see #getTotalCatcherStatistic()
	 * @generated
	 */
	void setTotalCatcherStatistic(CatcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Total Defensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Defensive Statistic</em>' containment reference.
	 * @see #setTotalDefensiveStatistic(DefensiveStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_TotalDefensiveStatistic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DefensiveStatistic getTotalDefensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalDefensiveStatistic <em>Total Defensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Defensive Statistic</em>' containment reference.
	 * @see #getTotalDefensiveStatistic()
	 * @generated
	 */
	void setTotalDefensiveStatistic(DefensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Total Pitcher Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Pitcher Statistic</em>' containment reference.
	 * @see #setTotalPitcherStatistic(PitcherStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_TotalPitcherStatistic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PitcherStatistic getTotalPitcherStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalPitcherStatistic <em>Total Pitcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Pitcher Statistic</em>' containment reference.
	 * @see #getTotalPitcherStatistic()
	 * @generated
	 */
	void setTotalPitcherStatistic(PitcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Total Offensive Statistic</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Offensive Statistic</em>' containment reference.
	 * @see #setTotalOffensiveStatistic(OffensiveStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_TotalOffensiveStatistic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OffensiveStatistic getTotalOffensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTotalOffensiveStatistic <em>Total Offensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Offensive Statistic</em>' containment reference.
	 * @see #getTotalOffensiveStatistic()
	 * @generated
	 */
	void setTotalOffensiveStatistic(OffensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Double Play Counter</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Play Counter</em>' attribute.
	 * @see #setDoublePlayCounter(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_DoublePlayCounter()
	 * @model default="0"
	 * @generated
	 */
	int getDoublePlayCounter();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getDoublePlayCounter <em>Double Play Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Play Counter</em>' attribute.
	 * @see #getDoublePlayCounter()
	 * @generated
	 */
	void setDoublePlayCounter(int value);

	/**
	 * Returns the value of the '<em><b>Tie Break Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tie Break Counter</em>' attribute.
	 * @see #setTieBreakCounter(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_TieBreakCounter()
	 * @model
	 * @generated
	 */
	int getTieBreakCounter();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getTieBreakCounter <em>Tie Break Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tie Break Counter</em>' attribute.
	 * @see #getTieBreakCounter()
	 * @generated
	 */
	void setTieBreakCounter(int value);

	/**
	 * Returns the value of the '<em><b>Current Offensive Player</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.bpy.score.engine.stats.emf.statistic.LineupEntry},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Offensive Player</em>' map.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_CurrentOffensivePlayer()
	 * @model mapType="org.bpy.score.engine.stats.emf.statistic.EStringToLineupEntryTypeMap&lt;org.eclipse.emf.ecore.EString, org.bpy.score.engine.stats.emf.statistic.LineupEntryType&gt;"
	 * @generated
	 */
	EMap<String, LineupEntry> getCurrentOffensivePlayer();

	/**
	 * Returns the value of the '<em><b>Current Defensive Player</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.bpy.score.engine.stats.emf.statistic.LineupEntry},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Defensive Player</em>' map.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_CurrentDefensivePlayer()
	 * @model mapType="org.bpy.score.engine.stats.emf.statistic.EStringToLineupEntryTypeMap&lt;org.eclipse.emf.ecore.EString, org.bpy.score.engine.stats.emf.statistic.LineupEntryType&gt;"
	 * @generated
	 */
	EMap<String, LineupEntry> getCurrentDefensivePlayer();

	/**
	 * Returns the value of the '<em><b>Current Catcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Catcher</em>' attribute.
	 * @see #setCurrentCatcher(LineupEntry)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_CurrentCatcher()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" required="true"
	 * @generated
	 */
	LineupEntry getCurrentCatcher();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentCatcher <em>Current Catcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Catcher</em>' attribute.
	 * @see #getCurrentCatcher()
	 * @generated
	 */
	void setCurrentCatcher(LineupEntry value);

	/**
	 * Returns the value of the '<em><b>Current Pitcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Pitcher</em>' attribute.
	 * @see #setCurrentPitcher(LineupEntry)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_CurrentPitcher()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" required="true"
	 * @generated
	 */
	LineupEntry getCurrentPitcher();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getCurrentPitcher <em>Current Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Pitcher</em>' attribute.
	 * @see #getCurrentPitcher()
	 * @generated
	 */
	void setCurrentPitcher(LineupEntry value);

	/**
	 * Returns the value of the '<em><b>Catchers</b></em>' attribute list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.statistic.LineupEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catchers</em>' attribute list.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_Catchers()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" required="true"
	 * @generated
	 */
	EList<LineupEntry> getCatchers();

	/**
	 * Returns the value of the '<em><b>Pitchers</b></em>' attribute list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.statistic.LineupEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitchers</em>' attribute list.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_Pitchers()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" required="true"
	 * @generated
	 */
	EList<LineupEntry> getPitchers();

	/**
	 * Returns the value of the '<em><b>Players</b></em>' attribute list.
	 * The list contents are of type {@link org.bpy.score.engine.stats.emf.statistic.LineupEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Players</em>' attribute list.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_Players()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.LineupEntryType" required="true"
	 * @generated
	 */
	EList<LineupEntry> getPlayers();

	/**
	 * Returns the value of the '<em><b>Gw Rbi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gw Rbi</em>' attribute.
	 * @see #setGwRbi(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_GwRbi()
	 * @model
	 * @generated
	 */
	String getGwRbi();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getGwRbi <em>Gw Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gw Rbi</em>' attribute.
	 * @see #getGwRbi()
	 * @generated
	 */
	void setGwRbi(String value);

	/**
	 * Returns the value of the '<em><b>Earned Against The Team</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earned Against The Team</em>' attribute.
	 * @see #setEarnedAgainstTheTeam(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_EarnedAgainstTheTeam()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getEarnedAgainstTheTeam();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getEarnedAgainstTheTeam <em>Earned Against The Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Earned Against The Team</em>' attribute.
	 * @see #getEarnedAgainstTheTeam()
	 * @generated
	 */
	void setEarnedAgainstTheTeam(int value);

	/**
	 * Returns the value of the '<em><b>Final Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Score</em>' attribute.
	 * @see #setFinalScore(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getTeamStatistic_FinalScore()
	 * @model
	 * @generated
	 */
	int getFinalScore();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.TeamStatistic#getFinalScore <em>Final Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Score</em>' attribute.
	 * @see #getFinalScore()
	 * @generated
	 */
	void setFinalScore(int value);

} // TeamStatistic
