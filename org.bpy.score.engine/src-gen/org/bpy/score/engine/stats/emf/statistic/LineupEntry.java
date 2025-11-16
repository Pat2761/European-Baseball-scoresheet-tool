/**
 */
package org.bpy.score.engine.stats.emf.statistic;

import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lineup Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isIsDefensiveEntry <em>Is Defensive Entry</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePosition <em>Defensive Position</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensivePosition <em>Offensive Position</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePositionIndex <em>Defensive Position Index</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getStartEntryIp <em>Start Entry Ip</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getIpPlayed <em>Ip Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPlayerDescription <em>Player Description</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getAssociatedObjects <em>Associated Objects</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensiveStatistic <em>Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensiveStatistic <em>Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getCatcherStatistic <em>Catcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPitcherStatistic <em>Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isActif <em>Actif</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOrderNumber <em>Order Number</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getLaterality <em>Laterality</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry()
 * @model
 * @generated
 */
public interface LineupEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Defensive Entry</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Defensive Entry</em>' attribute.
	 * @see #setIsDefensiveEntry(boolean)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_IsDefensiveEntry()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsDefensiveEntry();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isIsDefensiveEntry <em>Is Defensive Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Defensive Entry</em>' attribute.
	 * @see #isIsDefensiveEntry()
	 * @generated
	 */
	void setIsDefensiveEntry(boolean value);

	/**
	 * Returns the value of the '<em><b>Defensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Position</em>' attribute.
	 * @see #setDefensivePosition(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_DefensivePosition()
	 * @model
	 * @generated
	 */
	String getDefensivePosition();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePosition <em>Defensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Position</em>' attribute.
	 * @see #getDefensivePosition()
	 * @generated
	 */
	void setDefensivePosition(String value);

	/**
	 * Returns the value of the '<em><b>Offensive Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offensive Position</em>' attribute.
	 * @see #setOffensivePosition(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_OffensivePosition()
	 * @model
	 * @generated
	 */
	String getOffensivePosition();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensivePosition <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offensive Position</em>' attribute.
	 * @see #getOffensivePosition()
	 * @generated
	 */
	void setOffensivePosition(String value);

	/**
	 * Returns the value of the '<em><b>Defensive Position Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Position Index</em>' attribute.
	 * @see #setDefensivePositionIndex(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_DefensivePositionIndex()
	 * @model
	 * @generated
	 */
	String getDefensivePositionIndex();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensivePositionIndex <em>Defensive Position Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Position Index</em>' attribute.
	 * @see #getDefensivePositionIndex()
	 * @generated
	 */
	void setDefensivePositionIndex(String value);

	/**
	 * Returns the value of the '<em><b>Start Entry Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Entry Ip</em>' attribute.
	 * @see #setStartEntryIp(double)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_StartEntryIp()
	 * @model
	 * @generated
	 */
	double getStartEntryIp();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getStartEntryIp <em>Start Entry Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Entry Ip</em>' attribute.
	 * @see #getStartEntryIp()
	 * @generated
	 */
	void setStartEntryIp(double value);

	/**
	 * Returns the value of the '<em><b>Ip Played</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip Played</em>' attribute.
	 * @see #setIpPlayed(double)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_IpPlayed()
	 * @model default="0.0"
	 * @generated
	 */
	double getIpPlayed();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getIpPlayed <em>Ip Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip Played</em>' attribute.
	 * @see #getIpPlayed()
	 * @generated
	 */
	void setIpPlayed(double value);

	/**
	 * Returns the value of the '<em><b>Player Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player Description</em>' attribute.
	 * @see #setPlayerDescription(LineupPlayerDescription)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_PlayerDescription()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.PlayerDescription"
	 * @generated
	 */
	LineupPlayerDescription getPlayerDescription();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPlayerDescription <em>Player Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player Description</em>' attribute.
	 * @see #getPlayerDescription()
	 * @generated
	 */
	void setPlayerDescription(LineupPlayerDescription value);

	/**
	 * Returns the value of the '<em><b>Associated Objects</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Objects</em>' map.
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_AssociatedObjects()
	 * @model mapType="org.bpy.score.engine.stats.emf.statistic.EStringToAssociatedObjectMap&lt;org.eclipse.emf.ecore.EString, org.bpy.score.engine.stats.emf.statistic.AssociatedObject&gt;"
	 * @generated
	 */
	EMap<String, Object> getAssociatedObjects();

	/**
	 * Returns the value of the '<em><b>Defensive Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defensive Statistic</em>' attribute.
	 * @see #setDefensiveStatistic(DefensiveStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_DefensiveStatistic()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.DefensiveStatisticType"
	 * @generated
	 */
	DefensiveStatistic getDefensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getDefensiveStatistic <em>Defensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defensive Statistic</em>' attribute.
	 * @see #getDefensiveStatistic()
	 * @generated
	 */
	void setDefensiveStatistic(DefensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Offensive Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offensive Statistic</em>' attribute.
	 * @see #setOffensiveStatistic(OffensiveStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_OffensiveStatistic()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.OffensiveStatisticType"
	 * @generated
	 */
	OffensiveStatistic getOffensiveStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOffensiveStatistic <em>Offensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offensive Statistic</em>' attribute.
	 * @see #getOffensiveStatistic()
	 * @generated
	 */
	void setOffensiveStatistic(OffensiveStatistic value);

	/**
	 * Returns the value of the '<em><b>Catcher Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catcher Statistic</em>' attribute.
	 * @see #setCatcherStatistic(CatcherStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_CatcherStatistic()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.CatcherStatisticType"
	 * @generated
	 */
	CatcherStatistic getCatcherStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getCatcherStatistic <em>Catcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catcher Statistic</em>' attribute.
	 * @see #getCatcherStatistic()
	 * @generated
	 */
	void setCatcherStatistic(CatcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Pitcher Statistic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitcher Statistic</em>' attribute.
	 * @see #setPitcherStatistic(PitcherStatistic)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_PitcherStatistic()
	 * @model dataType="org.bpy.score.engine.stats.emf.statistic.PitcherStatisticType"
	 * @generated
	 */
	PitcherStatistic getPitcherStatistic();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getPitcherStatistic <em>Pitcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitcher Statistic</em>' attribute.
	 * @see #getPitcherStatistic()
	 * @generated
	 */
	void setPitcherStatistic(PitcherStatistic value);

	/**
	 * Returns the value of the '<em><b>Actif</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actif</em>' attribute.
	 * @see #setActif(boolean)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_Actif()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isActif();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#isActif <em>Actif</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actif</em>' attribute.
	 * @see #isActif()
	 * @generated
	 */
	void setActif(boolean value);

	/**
	 * Returns the value of the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order Number</em>' attribute.
	 * @see #setOrderNumber(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_OrderNumber()
	 * @model required="true"
	 * @generated
	 */
	int getOrderNumber();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getOrderNumber <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order Number</em>' attribute.
	 * @see #getOrderNumber()
	 * @generated
	 */
	void setOrderNumber(int value);

	/**
	 * Returns the value of the '<em><b>Laterality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Laterality</em>' attribute.
	 * @see #setLaterality(String)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getLineupEntry_Laterality()
	 * @model
	 * @generated
	 */
	String getLaterality();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.LineupEntry#getLaterality <em>Laterality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Laterality</em>' attribute.
	 * @see #getLaterality()
	 * @generated
	 */
	void setLaterality(String value);

} // LineupEntry
