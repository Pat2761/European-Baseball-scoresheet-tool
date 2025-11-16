/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pitcher Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBatterFront <em>Batter Front</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getDouble <em>Double</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getTriple <em>Triple</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHomerun <em>Homerun</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getStrikeOut <em>Strike Out</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBalks <em>Balks</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCount <em>Pitch Count</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameLose <em>Game Lose</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameSave <em>Game Save</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic()
 * @model extendedMetaData="kind='element' name='PITCHER-STATISTICS'"
 * @generated
 */
public interface PitcherStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Batter Front</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Batter Front</em>' attribute.
	 * @see #setBatterFront(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_BatterFront()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='BATTER-FRONTS'"
	 * @generated
	 */
	int getBatterFront();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBatterFront <em>Batter Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Batter Front</em>' attribute.
	 * @see #getBatterFront()
	 * @generated
	 */
	void setBatterFront(int value);

	/**
	 * Returns the value of the '<em><b>At Bats</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bats</em>' attribute.
	 * @see #setAtBats(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_AtBats()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='AT-BATS'"
	 * @generated
	 */
	int getAtBats();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getAtBats <em>At Bats</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Runs()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='RUNS'"
	 * @generated
	 */
	int getRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRuns <em>Runs</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Hits()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HITS'"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHits <em>Hits</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Double()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='DOUBLES'"
	 * @generated
	 */
	int getDouble();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getDouble <em>Double</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Triple()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='TRIPLES'"
	 * @generated
	 */
	int getTriple();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getTriple <em>Triple</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Homerun()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HOMERUNS'"
	 * @generated
	 */
	int getHomerun();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHomerun <em>Homerun</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Homerun</em>' attribute.
	 * @see #getHomerun()
	 * @generated
	 */
	void setHomerun(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Hit</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Hit</em>' attribute.
	 * @see #setSacrificeHit(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_SacrificeHit()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='SACRIFICES-HITS'"
	 * @generated
	 */
	int getSacrificeHit();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_SacrificeFly()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='SACRIFICE-FLIES'"
	 * @generated
	 */
	int getSacrificeFly();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_BaseOnBall()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='BASE-ON-BALLS'"
	 * @generated
	 */
	int getBaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_IntentionalbaseOnBall()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='INTENTIONAL-BASE-ON-BALLS'"
	 * @generated
	 */
	int getIntentionalbaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_HitByPitch()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='HIT-BY-PITCHS'"
	 * @generated
	 */
	int getHitByPitch();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}' attribute.
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
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_InterferanceObstruction()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='INTERFEENCE-OBSTRUCTIONS'"
	 * @generated
	 */
	int getInterferanceObstruction();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interferance Obstruction</em>' attribute.
	 * @see #getInterferanceObstruction()
	 * @generated
	 */
	void setInterferanceObstruction(int value);

	/**
	 * Returns the value of the '<em><b>Strike Out</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strike Out</em>' attribute.
	 * @see #setStrikeOut(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_StrikeOut()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='STRIKE-OUTS'"
	 * @generated
	 */
	int getStrikeOut();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getStrikeOut <em>Strike Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strike Out</em>' attribute.
	 * @see #getStrikeOut()
	 * @generated
	 */
	void setStrikeOut(int value);

	/**
	 * Returns the value of the '<em><b>Earned Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earned Runs</em>' attribute.
	 * @see #setEarnedRuns(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_EarnedRuns()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='EARNED-RUNS'"
	 * @generated
	 */
	int getEarnedRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Earned Runs</em>' attribute.
	 * @see #getEarnedRuns()
	 * @generated
	 */
	void setEarnedRuns(int value);

	/**
	 * Returns the value of the '<em><b>Wild Pitches</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wild Pitches</em>' attribute.
	 * @see #setWildPitches(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_WildPitches()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='WILD-PITCHES'"
	 * @generated
	 */
	int getWildPitches();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wild Pitches</em>' attribute.
	 * @see #getWildPitches()
	 * @generated
	 */
	void setWildPitches(int value);

	/**
	 * Returns the value of the '<em><b>Balks</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balks</em>' attribute.
	 * @see #setBalks(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_Balks()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='BALKS'"
	 * @generated
	 */
	int getBalks();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getBalks <em>Balks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balks</em>' attribute.
	 * @see #getBalks()
	 * @generated
	 */
	void setBalks(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count</em>' attribute.
	 * @see #setPitchCount(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_PitchCount()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PITCH-COUNT'"
	 * @generated
	 */
	int getPitchCount();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCount <em>Pitch Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count</em>' attribute.
	 * @see #getPitchCount()
	 * @generated
	 */
	void setPitchCount(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count K</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count K</em>' attribute.
	 * @see #setPitchCountK(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_PitchCountK()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PITCH-COUNT-K'"
	 * @generated
	 */
	int getPitchCountK();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count K</em>' attribute.
	 * @see #getPitchCountK()
	 * @generated
	 */
	void setPitchCountK(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count B</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count B</em>' attribute.
	 * @see #setPitchCountB(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_PitchCountB()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PITCH-COUNT-B'"
	 * @generated
	 */
	int getPitchCountB();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count B</em>' attribute.
	 * @see #getPitchCountB()
	 * @generated
	 */
	void setPitchCountB(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count Others</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count Others</em>' attribute.
	 * @see #setPitchCountOthers(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_PitchCountOthers()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PITCH-COUNT-OTHERS'"
	 * @generated
	 */
	int getPitchCountOthers();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count Others</em>' attribute.
	 * @see #getPitchCountOthers()
	 * @generated
	 */
	void setPitchCountOthers(int value);

	/**
	 * Returns the value of the '<em><b>Runner Left On Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runner Left On Base</em>' attribute.
	 * @see #setRunnerLeftOnBase(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_RunnerLeftOnBase()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='RUNNER-LEFT-ON-BASE'"
	 * @generated
	 */
	int getRunnerLeftOnBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runner Left On Base</em>' attribute.
	 * @see #getRunnerLeftOnBase()
	 * @generated
	 */
	void setRunnerLeftOnBase(int value);

	/**
	 * Returns the value of the '<em><b>Caught Stealing</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing</em>' attribute.
	 * @see #setCaughtStealing(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_CaughtStealing()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='CAUGHT-STEALING'"
	 * @generated
	 */
	int getCaughtStealing();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing</em>' attribute.
	 * @see #getCaughtStealing()
	 * @generated
	 */
	void setCaughtStealing(int value);

	/**
	 * Returns the value of the '<em><b>Game Lose</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Lose</em>' attribute.
	 * @see #setGameLose(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_GameLose()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GAME-LOSE'"
	 * @generated
	 */
	int getGameLose();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameLose <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Lose</em>' attribute.
	 * @see #getGameLose()
	 * @generated
	 */
	void setGameLose(int value);

	/**
	 * Returns the value of the '<em><b>Game Win</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Win</em>' attribute.
	 * @see #setGameWin(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_GameWin()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GAME-WIN'"
	 * @generated
	 */
	int getGameWin();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameWin <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Win</em>' attribute.
	 * @see #getGameWin()
	 * @generated
	 */
	void setGameWin(int value);

	/**
	 * Returns the value of the '<em><b>Game Save</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Save</em>' attribute.
	 * @see #setGameSave(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getPitcherStatistic_GameSave()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='GAME-SAVE'"
	 * @generated
	 */
	int getGameSave();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.PitcherStatistic#getGameSave <em>Game Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Save</em>' attribute.
	 * @see #getGameSave()
	 * @generated
	 */
	void setGameSave(int value);

} // PitcherStatistic
