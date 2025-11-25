/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Offensive Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getPlateAppearances <em>Plate Appearances</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getDouble <em>Double</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getTriple <em>Triple</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHomerun <em>Homerun</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getGroundedDoublePlay <em>Grounded Double Play</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeHit <em>Sacrifice Hit</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getBaseOnBall <em>Base On Ball</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHitByPitch <em>Hit By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getCaughtStealing <em>Caught Stealing</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStrikeOut <em>Strike Out</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRbi <em>Rbi</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic()
 * @model extendedMetaData="kind='elementOnly' name='OFFENSIVE-STATISTICS'"
 * @generated
 */
public interface OffensiveStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Plate Appearances</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plate Appearances</em>' attribute.
	 * @see #setPlateAppearances(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_PlateAppearances()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PLATE-APPEARANCES'"
	 * @generated
	 */
	int getPlateAppearances();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getPlateAppearances <em>Plate Appearances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plate Appearances</em>' attribute.
	 * @see #getPlateAppearances()
	 * @generated
	 */
	void setPlateAppearances(int value);

	/**
	 * Returns the value of the '<em><b>At Bats</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bats</em>' attribute.
	 * @see #setAtBats(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_AtBats()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='AT-BATS'"
	 * @generated
	 */
	int getAtBats();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getAtBats <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Bats</em>' attribute.
	 * @see #getAtBats()
	 * @generated
	 */
	void setAtBats(int value);

	/**
	 * Returns the value of the '<em><b>Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs</em>' attribute.
	 * @see #setRuns(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Runs()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='RUNS'"
	 * @generated
	 */
	int getRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRuns <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runs</em>' attribute.
	 * @see #getRuns()
	 * @generated
	 */
	void setRuns(int value);

	/**
	 * Returns the value of the '<em><b>Hits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hits</em>' attribute.
	 * @see #setHits(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Hits()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HITS'"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHits <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hits</em>' attribute.
	 * @see #getHits()
	 * @generated
	 */
	void setHits(int value);

	/**
	 * Returns the value of the '<em><b>Double</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double</em>' attribute.
	 * @see #setDouble(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Double()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='DOUBLES'"
	 * @generated
	 */
	int getDouble();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getDouble <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double</em>' attribute.
	 * @see #getDouble()
	 * @generated
	 */
	void setDouble(int value);

	/**
	 * Returns the value of the '<em><b>Triple</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triple</em>' attribute.
	 * @see #setTriple(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Triple()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='TRIPLES'"
	 * @generated
	 */
	int getTriple();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getTriple <em>Triple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triple</em>' attribute.
	 * @see #getTriple()
	 * @generated
	 */
	void setTriple(int value);

	/**
	 * Returns the value of the '<em><b>Homerun</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Homerun</em>' attribute.
	 * @see #setHomerun(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Homerun()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMERUNS'"
	 * @generated
	 */
	int getHomerun();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHomerun <em>Homerun</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Homerun</em>' attribute.
	 * @see #getHomerun()
	 * @generated
	 */
	void setHomerun(int value);

	/**
	 * Returns the value of the '<em><b>Grounded Double Play</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grounded Double Play</em>' attribute.
	 * @see #setGroundedDoublePlay(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_GroundedDoublePlay()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GROUND-OUT-DOUBLE-PLAY'"
	 * @generated
	 */
	int getGroundedDoublePlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getGroundedDoublePlay <em>Grounded Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounded Double Play</em>' attribute.
	 * @see #getGroundedDoublePlay()
	 * @generated
	 */
	void setGroundedDoublePlay(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Hit</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Hit</em>' attribute.
	 * @see #setSacrificeHit(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_SacrificeHit()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='SACRIFICES-HITS'"
	 * @generated
	 */
	int getSacrificeHit();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeHit <em>Sacrifice Hit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Hit</em>' attribute.
	 * @see #getSacrificeHit()
	 * @generated
	 */
	void setSacrificeHit(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #setSacrificeFly(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_SacrificeFly()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='SACRIFICE-FLIES'"
	 * @generated
	 */
	int getSacrificeFly();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getSacrificeFly <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #getSacrificeFly()
	 * @generated
	 */
	void setSacrificeFly(int value);

	/**
	 * Returns the value of the '<em><b>Base On Ball</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base On Ball</em>' attribute.
	 * @see #setBaseOnBall(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_BaseOnBall()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='BASE-ON-BALLS'"
	 * @generated
	 */
	int getBaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getBaseOnBall <em>Base On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base On Ball</em>' attribute.
	 * @see #getBaseOnBall()
	 * @generated
	 */
	void setBaseOnBall(int value);

	/**
	 * Returns the value of the '<em><b>Intentionalbase On Ball</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentionalbase On Ball</em>' attribute.
	 * @see #setIntentionalbaseOnBall(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_IntentionalbaseOnBall()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='INTENTIONAL-BASE-ON-BALLS'"
	 * @generated
	 */
	int getIntentionalbaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intentionalbase On Ball</em>' attribute.
	 * @see #getIntentionalbaseOnBall()
	 * @generated
	 */
	void setIntentionalbaseOnBall(int value);

	/**
	 * Returns the value of the '<em><b>Hit By Pitch</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit By Pitch</em>' attribute.
	 * @see #setHitByPitch(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_HitByPitch()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HIT-BY-PITCHS'"
	 * @generated
	 */
	int getHitByPitch();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getHitByPitch <em>Hit By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit By Pitch</em>' attribute.
	 * @see #getHitByPitch()
	 * @generated
	 */
	void setHitByPitch(int value);

	/**
	 * Returns the value of the '<em><b>Interferance Obstruction</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interferance Obstruction</em>' attribute.
	 * @see #setInterferanceObstruction(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_InterferanceObstruction()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='INTERFEENCE-OBSTRUCTIONS'"
	 * @generated
	 */
	int getInterferanceObstruction();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interferance Obstruction</em>' attribute.
	 * @see #getInterferanceObstruction()
	 * @generated
	 */
	void setInterferanceObstruction(int value);

	/**
	 * Returns the value of the '<em><b>Stolen Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stolen Base</em>' attribute.
	 * @see #setStolenBase(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_StolenBase()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='STOLEN-BASES'"
	 * @generated
	 */
	int getStolenBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStolenBase <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stolen Base</em>' attribute.
	 * @see #getStolenBase()
	 * @generated
	 */
	void setStolenBase(int value);

	/**
	 * Returns the value of the '<em><b>Caught Stealing</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing</em>' attribute.
	 * @see #setCaughtStealing(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_CaughtStealing()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='CAUGHT-STEALING'"
	 * @generated
	 */
	int getCaughtStealing();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getCaughtStealing <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing</em>' attribute.
	 * @see #getCaughtStealing()
	 * @generated
	 */
	void setCaughtStealing(int value);

	/**
	 * Returns the value of the '<em><b>Strike Out</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strike Out</em>' attribute.
	 * @see #setStrikeOut(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_StrikeOut()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='STRIKE-OUTS'"
	 * @generated
	 */
	int getStrikeOut();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getStrikeOut <em>Strike Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strike Out</em>' attribute.
	 * @see #getStrikeOut()
	 * @generated
	 */
	void setStrikeOut(int value);

	/**
	 * Returns the value of the '<em><b>Rbi</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rbi</em>' attribute.
	 * @see #setRbi(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getOffensiveStatistic_Rbi()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='RBIS'"
	 * @generated
	 */
	int getRbi();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.OffensiveStatistic#getRbi <em>Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rbi</em>' attribute.
	 * @see #getRbi()
	 * @generated
	 */
	void setRbi(int value);

} // OffensiveStatistic
