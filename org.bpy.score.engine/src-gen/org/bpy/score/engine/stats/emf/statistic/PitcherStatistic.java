/**
 */
package org.bpy.score.engine.stats.emf.statistic;

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
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBatterFront <em>Batter Front</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getDouble <em>Double</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getTriple <em>Triple</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHomerun <em>Homerun</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getStrikeOut <em>Strike Out</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBalks <em>Balks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCount <em>Pitch Count</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic()
 * @model
 * @generated
 */
public interface PitcherStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Batter Front</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Batter Front</em>' attribute.
	 * @see #setBatterFront(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_BatterFront()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getBatterFront();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBatterFront <em>Batter Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Batter Front</em>' attribute.
	 * @see #getBatterFront()
	 * @generated
	 */
	void setBatterFront(int value);

	/**
	 * Returns the value of the '<em><b>At Bats</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bats</em>' attribute.
	 * @see #setAtBats(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_AtBats()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getAtBats();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getAtBats <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Bats</em>' attribute.
	 * @see #getAtBats()
	 * @generated
	 */
	void setAtBats(int value);

	/**
	 * Returns the value of the '<em><b>Runs</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs</em>' attribute.
	 * @see #setRuns(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Runs()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRuns <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runs</em>' attribute.
	 * @see #getRuns()
	 * @generated
	 */
	void setRuns(int value);

	/**
	 * Returns the value of the '<em><b>Hits</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hits</em>' attribute.
	 * @see #setHits(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Hits()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHits <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hits</em>' attribute.
	 * @see #getHits()
	 * @generated
	 */
	void setHits(int value);

	/**
	 * Returns the value of the '<em><b>Double</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double</em>' attribute.
	 * @see #setDouble(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Double()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getDouble();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getDouble <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double</em>' attribute.
	 * @see #getDouble()
	 * @generated
	 */
	void setDouble(int value);

	/**
	 * Returns the value of the '<em><b>Triple</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triple</em>' attribute.
	 * @see #setTriple(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Triple()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getTriple();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getTriple <em>Triple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triple</em>' attribute.
	 * @see #getTriple()
	 * @generated
	 */
	void setTriple(int value);

	/**
	 * Returns the value of the '<em><b>Homerun</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Homerun</em>' attribute.
	 * @see #setHomerun(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Homerun()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getHomerun();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHomerun <em>Homerun</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Homerun</em>' attribute.
	 * @see #getHomerun()
	 * @generated
	 */
	void setHomerun(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Hit</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Hit</em>' attribute.
	 * @see #setSacrificeHit(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_SacrificeHit()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSacrificeHit();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeHit <em>Sacrifice Hit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Hit</em>' attribute.
	 * @see #getSacrificeHit()
	 * @generated
	 */
	void setSacrificeHit(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #setSacrificeFly(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_SacrificeFly()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSacrificeFly();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getSacrificeFly <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #getSacrificeFly()
	 * @generated
	 */
	void setSacrificeFly(int value);

	/**
	 * Returns the value of the '<em><b>Base On Ball</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base On Ball</em>' attribute.
	 * @see #setBaseOnBall(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_BaseOnBall()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getBaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBaseOnBall <em>Base On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base On Ball</em>' attribute.
	 * @see #getBaseOnBall()
	 * @generated
	 */
	void setBaseOnBall(int value);

	/**
	 * Returns the value of the '<em><b>Intentionalbase On Ball</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentionalbase On Ball</em>' attribute.
	 * @see #setIntentionalbaseOnBall(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_IntentionalbaseOnBall()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getIntentionalbaseOnBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intentionalbase On Ball</em>' attribute.
	 * @see #getIntentionalbaseOnBall()
	 * @generated
	 */
	void setIntentionalbaseOnBall(int value);

	/**
	 * Returns the value of the '<em><b>Hit By Pitch</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit By Pitch</em>' attribute.
	 * @see #setHitByPitch(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_HitByPitch()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getHitByPitch();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getHitByPitch <em>Hit By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit By Pitch</em>' attribute.
	 * @see #getHitByPitch()
	 * @generated
	 */
	void setHitByPitch(int value);

	/**
	 * Returns the value of the '<em><b>Interferance Obstruction</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interferance Obstruction</em>' attribute.
	 * @see #setInterferanceObstruction(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_InterferanceObstruction()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getInterferanceObstruction();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getInterferanceObstruction <em>Interferance Obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interferance Obstruction</em>' attribute.
	 * @see #getInterferanceObstruction()
	 * @generated
	 */
	void setInterferanceObstruction(int value);

	/**
	 * Returns the value of the '<em><b>Strike Out</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strike Out</em>' attribute.
	 * @see #setStrikeOut(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_StrikeOut()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getStrikeOut();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getStrikeOut <em>Strike Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strike Out</em>' attribute.
	 * @see #getStrikeOut()
	 * @generated
	 */
	void setStrikeOut(int value);

	/**
	 * Returns the value of the '<em><b>Earned Runs</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Earned Runs</em>' attribute.
	 * @see #setEarnedRuns(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_EarnedRuns()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getEarnedRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getEarnedRuns <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Earned Runs</em>' attribute.
	 * @see #getEarnedRuns()
	 * @generated
	 */
	void setEarnedRuns(int value);

	/**
	 * Returns the value of the '<em><b>Wild Pitches</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wild Pitches</em>' attribute.
	 * @see #setWildPitches(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_WildPitches()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getWildPitches();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getWildPitches <em>Wild Pitches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wild Pitches</em>' attribute.
	 * @see #getWildPitches()
	 * @generated
	 */
	void setWildPitches(int value);

	/**
	 * Returns the value of the '<em><b>Balks</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balks</em>' attribute.
	 * @see #setBalks(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_Balks()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getBalks();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getBalks <em>Balks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balks</em>' attribute.
	 * @see #getBalks()
	 * @generated
	 */
	void setBalks(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count</em>' attribute.
	 * @see #setPitchCount(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_PitchCount()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPitchCount();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCount <em>Pitch Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count</em>' attribute.
	 * @see #getPitchCount()
	 * @generated
	 */
	void setPitchCount(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count K</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count K</em>' attribute.
	 * @see #setPitchCountK(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_PitchCountK()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPitchCountK();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountK <em>Pitch Count K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count K</em>' attribute.
	 * @see #getPitchCountK()
	 * @generated
	 */
	void setPitchCountK(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count B</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count B</em>' attribute.
	 * @see #setPitchCountB(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_PitchCountB()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPitchCountB();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountB <em>Pitch Count B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count B</em>' attribute.
	 * @see #getPitchCountB()
	 * @generated
	 */
	void setPitchCountB(int value);

	/**
	 * Returns the value of the '<em><b>Pitch Count Others</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch Count Others</em>' attribute.
	 * @see #setPitchCountOthers(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_PitchCountOthers()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPitchCountOthers();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getPitchCountOthers <em>Pitch Count Others</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch Count Others</em>' attribute.
	 * @see #getPitchCountOthers()
	 * @generated
	 */
	void setPitchCountOthers(int value);

	/**
	 * Returns the value of the '<em><b>Runner Left On Base</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runner Left On Base</em>' attribute.
	 * @see #setRunnerLeftOnBase(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_RunnerLeftOnBase()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getRunnerLeftOnBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getRunnerLeftOnBase <em>Runner Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runner Left On Base</em>' attribute.
	 * @see #getRunnerLeftOnBase()
	 * @generated
	 */
	void setRunnerLeftOnBase(int value);

	/**
	 * Returns the value of the '<em><b>Caught Stealing</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing</em>' attribute.
	 * @see #setCaughtStealing(int)
	 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage#getPitcherStatistic_CaughtStealing()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getCaughtStealing();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.statistic.PitcherStatistic#getCaughtStealing <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing</em>' attribute.
	 * @see #getCaughtStealing()
	 * @generated
	 */
	void setCaughtStealing(int value);

} // PitcherStatistic
