/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Offensive Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBattingAverage <em>Batting Average</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getCaughtStealing <em>Caught Stealing</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubles <em>Doubles</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getExtraBaseHits <em>Extra Base Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGamesPlayed <em>Games Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGrandSlam <em>Grand Slam</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundIntoDoublePlay <em>Ground Into Double Play</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundoutToAiroutRatio <em>Groundout To Airout Ratio</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitByPitchs <em>Hit By Pitchs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHomeRuns <em>Home Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getIntentionalWalks <em>Intentional Walks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getLeftOnBase <em>Left On Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePercentage <em>On Base Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePlusSlugging <em>On Base Plus Slugging</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getPlateAppearance <em>Plate Appearance</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getReachedOnError <em>Reached On Error</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRbis <em>Rbis</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeBunt <em>Sacrifice Bunt</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSingle <em>Single</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSluggingPercentage <em>Slugging Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBasePercentage <em>Stolen Base Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTotalBases <em>Total Bases</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTriples <em>Triples</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalks <em>Walks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalkOff <em>Walk Off</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics()
 * @model
 * @generated
 */
public interface OffensiveStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Hits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hits</em>' attribute.
	 * @see #setHits(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Hits()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHits <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hits</em>' attribute.
	 * @see #getHits()
	 * @generated
	 */
	void setHits(int value);

	/**
	 * Returns the value of the '<em><b>Home Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Home Runs</em>' attribute.
	 * @see #setHomeRuns(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_HomeRuns()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getHomeRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHomeRuns <em>Home Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Runs</em>' attribute.
	 * @see #getHomeRuns()
	 * @generated
	 */
	void setHomeRuns(int value);

	/**
	 * Returns the value of the '<em><b>Intentional Walks</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intentional Walks</em>' attribute.
	 * @see #setIntentionalWalks(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_IntentionalWalks()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getIntentionalWalks();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getIntentionalWalks <em>Intentional Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intentional Walks</em>' attribute.
	 * @see #getIntentionalWalks()
	 * @generated
	 */
	void setIntentionalWalks(int value);

	/**
	 * Returns the value of the '<em><b>Left On Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left On Base</em>' attribute.
	 * @see #setLeftOnBase(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_LeftOnBase()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getLeftOnBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getLeftOnBase <em>Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left On Base</em>' attribute.
	 * @see #getLeftOnBase()
	 * @generated
	 */
	void setLeftOnBase(int value);

	/**
	 * Returns the value of the '<em><b>On Base Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Base Percentage</em>' attribute.
	 * @see #setOnBasePercentage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_OnBasePercentage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getOnBasePercentage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePercentage <em>On Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Base Percentage</em>' attribute.
	 * @see #getOnBasePercentage()
	 * @generated
	 */
	void setOnBasePercentage(double value);

	/**
	 * Returns the value of the '<em><b>On Base Plus Slugging</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Base Plus Slugging</em>' attribute.
	 * @see #setOnBasePlusSlugging(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_OnBasePlusSlugging()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getOnBasePlusSlugging();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getOnBasePlusSlugging <em>On Base Plus Slugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Base Plus Slugging</em>' attribute.
	 * @see #getOnBasePlusSlugging()
	 * @generated
	 */
	void setOnBasePlusSlugging(double value);

	/**
	 * Returns the value of the '<em><b>At Bats</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bats</em>' attribute.
	 * @see #setAtBats(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_AtBats()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getAtBats();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getAtBats <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Bats</em>' attribute.
	 * @see #getAtBats()
	 * @generated
	 */
	void setAtBats(int value);

	/**
	 * Returns the value of the '<em><b>Batting Average</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Batting Average</em>' attribute.
	 * @see #setBattingAverage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_BattingAverage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getBattingAverage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getBattingAverage <em>Batting Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Batting Average</em>' attribute.
	 * @see #getBattingAverage()
	 * @generated
	 */
	void setBattingAverage(double value);

	/**
	 * Returns the value of the '<em><b>Caught Stealing</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing</em>' attribute.
	 * @see #setCaughtStealing(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_CaughtStealing()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getCaughtStealing();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getCaughtStealing <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing</em>' attribute.
	 * @see #getCaughtStealing()
	 * @generated
	 */
	void setCaughtStealing(int value);

	/**
	 * Returns the value of the '<em><b>Doubles</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doubles</em>' attribute.
	 * @see #setDoubles(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Doubles()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getDoubles();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getDoubles <em>Doubles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doubles</em>' attribute.
	 * @see #getDoubles()
	 * @generated
	 */
	void setDoubles(int value);

	/**
	 * Returns the value of the '<em><b>Extra Base Hits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra Base Hits</em>' attribute.
	 * @see #setExtraBaseHits(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_ExtraBaseHits()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getExtraBaseHits();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getExtraBaseHits <em>Extra Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extra Base Hits</em>' attribute.
	 * @see #getExtraBaseHits()
	 * @generated
	 */
	void setExtraBaseHits(int value);

	/**
	 * Returns the value of the '<em><b>Games Played</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Games Played</em>' attribute.
	 * @see #setGamesPlayed(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_GamesPlayed()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGamesPlayed();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGamesPlayed <em>Games Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Games Played</em>' attribute.
	 * @see #getGamesPlayed()
	 * @generated
	 */
	void setGamesPlayed(int value);

	/**
	 * Returns the value of the '<em><b>Grand Slam</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grand Slam</em>' attribute.
	 * @see #setGrandSlam(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_GrandSlam()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGrandSlam();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGrandSlam <em>Grand Slam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grand Slam</em>' attribute.
	 * @see #getGrandSlam()
	 * @generated
	 */
	void setGrandSlam(int value);

	/**
	 * Returns the value of the '<em><b>Ground Into Double Play</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ground Into Double Play</em>' attribute.
	 * @see #setGroundIntoDoublePlay(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_GroundIntoDoublePlay()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getGroundIntoDoublePlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundIntoDoublePlay <em>Ground Into Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ground Into Double Play</em>' attribute.
	 * @see #getGroundIntoDoublePlay()
	 * @generated
	 */
	void setGroundIntoDoublePlay(int value);

	/**
	 * Returns the value of the '<em><b>Groundout To Airout Ratio</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groundout To Airout Ratio</em>' attribute.
	 * @see #setGroundoutToAiroutRatio(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_GroundoutToAiroutRatio()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getGroundoutToAiroutRatio();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getGroundoutToAiroutRatio <em>Groundout To Airout Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Groundout To Airout Ratio</em>' attribute.
	 * @see #getGroundoutToAiroutRatio()
	 * @generated
	 */
	void setGroundoutToAiroutRatio(double value);

	/**
	 * Returns the value of the '<em><b>Hit By Pitchs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit By Pitchs</em>' attribute.
	 * @see #setHitByPitchs(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_HitByPitchs()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getHitByPitchs();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getHitByPitchs <em>Hit By Pitchs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit By Pitchs</em>' attribute.
	 * @see #getHitByPitchs()
	 * @generated
	 */
	void setHitByPitchs(int value);

	/**
	 * Returns the value of the '<em><b>Plate Appearance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plate Appearance</em>' attribute.
	 * @see #setPlateAppearance(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_PlateAppearance()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getPlateAppearance();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getPlateAppearance <em>Plate Appearance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plate Appearance</em>' attribute.
	 * @see #getPlateAppearance()
	 * @generated
	 */
	void setPlateAppearance(int value);

	/**
	 * Returns the value of the '<em><b>Reached On Error</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reached On Error</em>' attribute.
	 * @see #setReachedOnError(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_ReachedOnError()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getReachedOnError();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getReachedOnError <em>Reached On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reached On Error</em>' attribute.
	 * @see #getReachedOnError()
	 * @generated
	 */
	void setReachedOnError(int value);

	/**
	 * Returns the value of the '<em><b>Runs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runs</em>' attribute.
	 * @see #setRuns(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Runs()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getRuns();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRuns <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runs</em>' attribute.
	 * @see #getRuns()
	 * @generated
	 */
	void setRuns(int value);

	/**
	 * Returns the value of the '<em><b>Rbis</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rbis</em>' attribute.
	 * @see #setRbis(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Rbis()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getRbis();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getRbis <em>Rbis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rbis</em>' attribute.
	 * @see #getRbis()
	 * @generated
	 */
	void setRbis(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Bunt</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Bunt</em>' attribute.
	 * @see #setSacrificeBunt(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_SacrificeBunt()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getSacrificeBunt();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeBunt <em>Sacrifice Bunt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Bunt</em>' attribute.
	 * @see #getSacrificeBunt()
	 * @generated
	 */
	void setSacrificeBunt(int value);

	/**
	 * Returns the value of the '<em><b>Sacrifice Fly</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #setSacrificeFly(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_SacrificeFly()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getSacrificeFly();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSacrificeFly <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sacrifice Fly</em>' attribute.
	 * @see #getSacrificeFly()
	 * @generated
	 */
	void setSacrificeFly(int value);

	/**
	 * Returns the value of the '<em><b>Single</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single</em>' attribute.
	 * @see #setSingle(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Single()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getSingle();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSingle <em>Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single</em>' attribute.
	 * @see #getSingle()
	 * @generated
	 */
	void setSingle(int value);

	/**
	 * Returns the value of the '<em><b>Slugging Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slugging Percentage</em>' attribute.
	 * @see #setSluggingPercentage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_SluggingPercentage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getSluggingPercentage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getSluggingPercentage <em>Slugging Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slugging Percentage</em>' attribute.
	 * @see #getSluggingPercentage()
	 * @generated
	 */
	void setSluggingPercentage(double value);

	/**
	 * Returns the value of the '<em><b>Stolen Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stolen Base</em>' attribute.
	 * @see #setStolenBase(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_StolenBase()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getStolenBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBase <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stolen Base</em>' attribute.
	 * @see #getStolenBase()
	 * @generated
	 */
	void setStolenBase(int value);

	/**
	 * Returns the value of the '<em><b>Stolen Base Percentage</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stolen Base Percentage</em>' attribute.
	 * @see #setStolenBasePercentage(double)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_StolenBasePercentage()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getStolenBasePercentage();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getStolenBasePercentage <em>Stolen Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stolen Base Percentage</em>' attribute.
	 * @see #getStolenBasePercentage()
	 * @generated
	 */
	void setStolenBasePercentage(double value);

	/**
	 * Returns the value of the '<em><b>Total Bases</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Bases</em>' attribute.
	 * @see #setTotalBases(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_TotalBases()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getTotalBases();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTotalBases <em>Total Bases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Bases</em>' attribute.
	 * @see #getTotalBases()
	 * @generated
	 */
	void setTotalBases(int value);

	/**
	 * Returns the value of the '<em><b>Triples</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triples</em>' attribute.
	 * @see #setTriples(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Triples()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getTriples();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getTriples <em>Triples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triples</em>' attribute.
	 * @see #getTriples()
	 * @generated
	 */
	void setTriples(int value);

	/**
	 * Returns the value of the '<em><b>Walks</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Walks</em>' attribute.
	 * @see #setWalks(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_Walks()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getWalks();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalks <em>Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Walks</em>' attribute.
	 * @see #getWalks()
	 * @generated
	 */
	void setWalks(int value);

	/**
	 * Returns the value of the '<em><b>Walk Off</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Walk Off</em>' attribute.
	 * @see #setWalkOff(int)
	 * @see org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage#getOffensiveStatistics_WalkOff()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getWalkOff();

	/**
	 * Sets the value of the '{@link org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics#getWalkOff <em>Walk Off</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Walk Off</em>' attribute.
	 * @see #getWalkOff()
	 * @generated
	 */
	void setWalkOff(int value);

} // OffensiveStatistics
