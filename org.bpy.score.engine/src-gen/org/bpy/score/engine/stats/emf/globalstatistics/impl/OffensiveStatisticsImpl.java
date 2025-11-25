/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Offensive Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getBattingAverage <em>Batting Average</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getCaughtStealing <em>Caught Stealing</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getDoubles <em>Doubles</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getExtraBaseHits <em>Extra Base Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getGamesPlayed <em>Games Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getGrandSlam <em>Grand Slam</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getGroundIntoDoublePlay <em>Ground Into Double Play</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getGroundoutToAiroutRatio <em>Groundout To Airout Ratio</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getHitByPitchs <em>Hit By Pitchs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getHomeRuns <em>Home Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getIntentionalWalks <em>Intentional Walks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getLeftOnBase <em>Left On Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getOnBasePercentage <em>On Base Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getOnBasePlusSlugging <em>On Base Plus Slugging</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getPlateAppearance <em>Plate Appearance</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getReachedOnError <em>Reached On Error</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getRbis <em>Rbis</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getSacrificeBunt <em>Sacrifice Bunt</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getSingle <em>Single</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getSluggingPercentage <em>Slugging Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getStolenBasePercentage <em>Stolen Base Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getTotalBases <em>Total Bases</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getTriples <em>Triples</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getWalks <em>Walks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getWalkOff <em>Walk Off</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OffensiveStatisticsImpl extends MinimalEObjectImpl.Container implements OffensiveStatistics {
	/**
	 * The default value of the '{@link #getAtBats() <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtBats()
	 * @generated
	 * @ordered
	 */
	protected static final int AT_BATS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getAtBats() <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtBats()
	 * @generated
	 * @ordered
	 */
	protected int atBats = AT_BATS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBattingAverage() <em>Batting Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBattingAverage()
	 * @generated
	 * @ordered
	 */
	protected static final double BATTING_AVERAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBattingAverage() <em>Batting Average</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBattingAverage()
	 * @generated
	 * @ordered
	 */
	protected double battingAverage = BATTING_AVERAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCaughtStealing() <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtStealing()
	 * @generated
	 * @ordered
	 */
	protected static final int CAUGHT_STEALING_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCaughtStealing() <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtStealing()
	 * @generated
	 * @ordered
	 */
	protected int caughtStealing = CAUGHT_STEALING_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoubles() <em>Doubles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubles()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getDoubles() <em>Doubles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubles()
	 * @generated
	 * @ordered
	 */
	protected int doubles = DOUBLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtraBaseHits() <em>Extra Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraBaseHits()
	 * @generated
	 * @ordered
	 */
	protected static final int EXTRA_BASE_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getExtraBaseHits() <em>Extra Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraBaseHits()
	 * @generated
	 * @ordered
	 */
	protected int extraBaseHits = EXTRA_BASE_HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getGamesPlayed() <em>Games Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGamesPlayed()
	 * @generated
	 * @ordered
	 */
	protected static final int GAMES_PLAYED_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGamesPlayed() <em>Games Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGamesPlayed()
	 * @generated
	 * @ordered
	 */
	protected int gamesPlayed = GAMES_PLAYED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrandSlam() <em>Grand Slam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrandSlam()
	 * @generated
	 * @ordered
	 */
	protected static final int GRAND_SLAM_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGrandSlam() <em>Grand Slam</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrandSlam()
	 * @generated
	 * @ordered
	 */
	protected int grandSlam = GRAND_SLAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroundIntoDoublePlay() <em>Ground Into Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundIntoDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected static final int GROUND_INTO_DOUBLE_PLAY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGroundIntoDoublePlay() <em>Ground Into Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundIntoDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected int groundIntoDoublePlay = GROUND_INTO_DOUBLE_PLAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroundoutToAiroutRatio() <em>Groundout To Airout Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundoutToAiroutRatio()
	 * @generated
	 * @ordered
	 */
	protected static final double GROUNDOUT_TO_AIROUT_RATIO_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGroundoutToAiroutRatio() <em>Groundout To Airout Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundoutToAiroutRatio()
	 * @generated
	 * @ordered
	 */
	protected double groundoutToAiroutRatio = GROUNDOUT_TO_AIROUT_RATIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitByPitchs() <em>Hit By Pitchs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitByPitchs()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_BY_PITCHS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHitByPitchs() <em>Hit By Pitchs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitByPitchs()
	 * @generated
	 * @ordered
	 */
	protected int hitByPitchs = HIT_BY_PITCHS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected static final int HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected int hits = HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHomeRuns() <em>Home Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomeRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int HOME_RUNS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHomeRuns() <em>Home Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomeRuns()
	 * @generated
	 * @ordered
	 */
	protected int homeRuns = HOME_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntentionalWalks() <em>Intentional Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalWalks()
	 * @generated
	 * @ordered
	 */
	protected static final int INTENTIONAL_WALKS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getIntentionalWalks() <em>Intentional Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalWalks()
	 * @generated
	 * @ordered
	 */
	protected int intentionalWalks = INTENTIONAL_WALKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeftOnBase() <em>Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOnBase()
	 * @generated
	 * @ordered
	 */
	protected static final int LEFT_ON_BASE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLeftOnBase() <em>Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOnBase()
	 * @generated
	 * @ordered
	 */
	protected int leftOnBase = LEFT_ON_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnBasePercentage() <em>On Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnBasePercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double ON_BASE_PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOnBasePercentage() <em>On Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnBasePercentage()
	 * @generated
	 * @ordered
	 */
	protected double onBasePercentage = ON_BASE_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnBasePlusSlugging() <em>On Base Plus Slugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnBasePlusSlugging()
	 * @generated
	 * @ordered
	 */
	protected static final double ON_BASE_PLUS_SLUGGING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOnBasePlusSlugging() <em>On Base Plus Slugging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnBasePlusSlugging()
	 * @generated
	 * @ordered
	 */
	protected double onBasePlusSlugging = ON_BASE_PLUS_SLUGGING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlateAppearance() <em>Plate Appearance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearance()
	 * @generated
	 * @ordered
	 */
	protected static final int PLATE_APPEARANCE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPlateAppearance() <em>Plate Appearance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearance()
	 * @generated
	 * @ordered
	 */
	protected int plateAppearance = PLATE_APPEARANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReachedOnError() <em>Reached On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReachedOnError()
	 * @generated
	 * @ordered
	 */
	protected static final int REACHED_ON_ERROR_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getReachedOnError() <em>Reached On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReachedOnError()
	 * @generated
	 * @ordered
	 */
	protected int reachedOnError = REACHED_ON_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuns() <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int RUNS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getRuns() <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuns()
	 * @generated
	 * @ordered
	 */
	protected int runs = RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRbis() <em>Rbis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRbis()
	 * @generated
	 * @ordered
	 */
	protected static final int RBIS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getRbis() <em>Rbis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRbis()
	 * @generated
	 * @ordered
	 */
	protected int rbis = RBIS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSacrificeBunt() <em>Sacrifice Bunt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeBunt()
	 * @generated
	 * @ordered
	 */
	protected static final int SACRIFICE_BUNT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSacrificeBunt() <em>Sacrifice Bunt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeBunt()
	 * @generated
	 * @ordered
	 */
	protected int sacrificeBunt = SACRIFICE_BUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSacrificeFly() <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeFly()
	 * @generated
	 * @ordered
	 */
	protected static final int SACRIFICE_FLY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSacrificeFly() <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeFly()
	 * @generated
	 * @ordered
	 */
	protected int sacrificeFly = SACRIFICE_FLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSingle() <em>Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingle()
	 * @generated
	 * @ordered
	 */
	protected static final int SINGLE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSingle() <em>Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingle()
	 * @generated
	 * @ordered
	 */
	protected int single = SINGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSluggingPercentage() <em>Slugging Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSluggingPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double SLUGGING_PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSluggingPercentage() <em>Slugging Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSluggingPercentage()
	 * @generated
	 * @ordered
	 */
	protected double sluggingPercentage = SLUGGING_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStolenBase() <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStolenBase()
	 * @generated
	 * @ordered
	 */
	protected static final int STOLEN_BASE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStolenBase() <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStolenBase()
	 * @generated
	 * @ordered
	 */
	protected int stolenBase = STOLEN_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStolenBasePercentage() <em>Stolen Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStolenBasePercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double STOLEN_BASE_PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStolenBasePercentage() <em>Stolen Base Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStolenBasePercentage()
	 * @generated
	 * @ordered
	 */
	protected double stolenBasePercentage = STOLEN_BASE_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalBases() <em>Total Bases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalBases()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_BASES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTotalBases() <em>Total Bases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalBases()
	 * @generated
	 * @ordered
	 */
	protected int totalBases = TOTAL_BASES_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriples() <em>Triples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriples()
	 * @generated
	 * @ordered
	 */
	protected static final int TRIPLES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTriples() <em>Triples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriples()
	 * @generated
	 * @ordered
	 */
	protected int triples = TRIPLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getWalks() <em>Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalks()
	 * @generated
	 * @ordered
	 */
	protected static final int WALKS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getWalks() <em>Walks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalks()
	 * @generated
	 * @ordered
	 */
	protected int walks = WALKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWalkOff() <em>Walk Off</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkOff()
	 * @generated
	 * @ordered
	 */
	protected static final int WALK_OFF_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getWalkOff() <em>Walk Off</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkOff()
	 * @generated
	 * @ordered
	 */
	protected int walkOff = WALK_OFF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OffensiveStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.OFFENSIVE_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHits() {
		return hits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHits(int newHits) {
		int oldHits = hits;
		hits = newHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS, oldHits, hits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHomeRuns() {
		return homeRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHomeRuns(int newHomeRuns) {
		int oldHomeRuns = homeRuns;
		homeRuns = newHomeRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HOME_RUNS, oldHomeRuns, homeRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIntentionalWalks() {
		return intentionalWalks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntentionalWalks(int newIntentionalWalks) {
		int oldIntentionalWalks = intentionalWalks;
		intentionalWalks = newIntentionalWalks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__INTENTIONAL_WALKS, oldIntentionalWalks, intentionalWalks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLeftOnBase() {
		return leftOnBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeftOnBase(int newLeftOnBase) {
		int oldLeftOnBase = leftOnBase;
		leftOnBase = newLeftOnBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__LEFT_ON_BASE, oldLeftOnBase, leftOnBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOnBasePercentage() {
		return onBasePercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOnBasePercentage(double newOnBasePercentage) {
		double oldOnBasePercentage = onBasePercentage;
		onBasePercentage = newOnBasePercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE, oldOnBasePercentage, onBasePercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOnBasePlusSlugging() {
		return onBasePlusSlugging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOnBasePlusSlugging(double newOnBasePlusSlugging) {
		double oldOnBasePlusSlugging = onBasePlusSlugging;
		onBasePlusSlugging = newOnBasePlusSlugging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING, oldOnBasePlusSlugging, onBasePlusSlugging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAtBats() {
		return atBats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtBats(int newAtBats) {
		int oldAtBats = atBats;
		atBats = newAtBats;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS, oldAtBats, atBats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBattingAverage() {
		return battingAverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBattingAverage(double newBattingAverage) {
		double oldBattingAverage = battingAverage;
		battingAverage = newBattingAverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BATTING_AVERAGE, oldBattingAverage, battingAverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCaughtStealing() {
		return caughtStealing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCaughtStealing(int newCaughtStealing) {
		int oldCaughtStealing = caughtStealing;
		caughtStealing = newCaughtStealing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__CAUGHT_STEALING, oldCaughtStealing, caughtStealing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDoubles() {
		return doubles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDoubles(int newDoubles) {
		int oldDoubles = doubles;
		doubles = newDoubles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLES, oldDoubles, doubles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getExtraBaseHits() {
		return extraBaseHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtraBaseHits(int newExtraBaseHits) {
		int oldExtraBaseHits = extraBaseHits;
		extraBaseHits = newExtraBaseHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__EXTRA_BASE_HITS, oldExtraBaseHits, extraBaseHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGamesPlayed(int newGamesPlayed) {
		int oldGamesPlayed = gamesPlayed;
		gamesPlayed = newGamesPlayed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GAMES_PLAYED, oldGamesPlayed, gamesPlayed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGrandSlam() {
		return grandSlam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrandSlam(int newGrandSlam) {
		int oldGrandSlam = grandSlam;
		grandSlam = newGrandSlam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GRAND_SLAM, oldGrandSlam, grandSlam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGroundIntoDoublePlay() {
		return groundIntoDoublePlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroundIntoDoublePlay(int newGroundIntoDoublePlay) {
		int oldGroundIntoDoublePlay = groundIntoDoublePlay;
		groundIntoDoublePlay = newGroundIntoDoublePlay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY, oldGroundIntoDoublePlay, groundIntoDoublePlay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGroundoutToAiroutRatio() {
		return groundoutToAiroutRatio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroundoutToAiroutRatio(double newGroundoutToAiroutRatio) {
		double oldGroundoutToAiroutRatio = groundoutToAiroutRatio;
		groundoutToAiroutRatio = newGroundoutToAiroutRatio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO, oldGroundoutToAiroutRatio, groundoutToAiroutRatio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitByPitchs() {
		return hitByPitchs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitByPitchs(int newHitByPitchs) {
		int oldHitByPitchs = hitByPitchs;
		hitByPitchs = newHitByPitchs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HIT_BY_PITCHS, oldHitByPitchs, hitByPitchs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPlateAppearance() {
		return plateAppearance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlateAppearance(int newPlateAppearance) {
		int oldPlateAppearance = plateAppearance;
		plateAppearance = newPlateAppearance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE, oldPlateAppearance, plateAppearance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getReachedOnError() {
		return reachedOnError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReachedOnError(int newReachedOnError) {
		int oldReachedOnError = reachedOnError;
		reachedOnError = newReachedOnError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__REACHED_ON_ERROR, oldReachedOnError, reachedOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRuns() {
		return runs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRuns(int newRuns) {
		int oldRuns = runs;
		runs = newRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RUNS, oldRuns, runs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRbis() {
		return rbis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRbis(int newRbis) {
		int oldRbis = rbis;
		rbis = newRbis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RBIS, oldRbis, rbis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSacrificeBunt() {
		return sacrificeBunt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSacrificeBunt(int newSacrificeBunt) {
		int oldSacrificeBunt = sacrificeBunt;
		sacrificeBunt = newSacrificeBunt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_BUNT, oldSacrificeBunt, sacrificeBunt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSacrificeFly() {
		return sacrificeFly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSacrificeFly(int newSacrificeFly) {
		int oldSacrificeFly = sacrificeFly;
		sacrificeFly = newSacrificeFly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLY, oldSacrificeFly, sacrificeFly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSingle() {
		return single;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSingle(int newSingle) {
		int oldSingle = single;
		single = newSingle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SINGLE, oldSingle, single));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSluggingPercentage() {
		return sluggingPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSluggingPercentage(double newSluggingPercentage) {
		double oldSluggingPercentage = sluggingPercentage;
		sluggingPercentage = newSluggingPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE, oldSluggingPercentage, sluggingPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStolenBase() {
		return stolenBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStolenBase(int newStolenBase) {
		int oldStolenBase = stolenBase;
		stolenBase = newStolenBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE, oldStolenBase, stolenBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStolenBasePercentage() {
		return stolenBasePercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStolenBasePercentage(double newStolenBasePercentage) {
		double oldStolenBasePercentage = stolenBasePercentage;
		stolenBasePercentage = newStolenBasePercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE, oldStolenBasePercentage, stolenBasePercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTotalBases() {
		return totalBases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalBases(int newTotalBases) {
		int oldTotalBases = totalBases;
		totalBases = newTotalBases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TOTAL_BASES, oldTotalBases, totalBases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTriples() {
		return triples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTriples(int newTriples) {
		int oldTriples = triples;
		triples = newTriples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLES, oldTriples, triples));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWalks() {
		return walks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWalks(int newWalks) {
		int oldWalks = walks;
		walks = newWalks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALKS, oldWalks, walks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWalkOff() {
		return walkOff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWalkOff(int newWalkOff) {
		int oldWalkOff = walkOff;
		walkOff = newWalkOff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALK_OFF, oldWalkOff, walkOff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				return getAtBats();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BATTING_AVERAGE:
				return getBattingAverage();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__CAUGHT_STEALING:
				return getCaughtStealing();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLES:
				return getDoubles();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__EXTRA_BASE_HITS:
				return getExtraBaseHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GAMES_PLAYED:
				return getGamesPlayed();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GRAND_SLAM:
				return getGrandSlam();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY:
				return getGroundIntoDoublePlay();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO:
				return getGroundoutToAiroutRatio();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HIT_BY_PITCHS:
				return getHitByPitchs();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				return getHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HOME_RUNS:
				return getHomeRuns();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__INTENTIONAL_WALKS:
				return getIntentionalWalks();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__LEFT_ON_BASE:
				return getLeftOnBase();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE:
				return getOnBasePercentage();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING:
				return getOnBasePlusSlugging();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				return getPlateAppearance();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__REACHED_ON_ERROR:
				return getReachedOnError();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RUNS:
				return getRuns();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RBIS:
				return getRbis();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_BUNT:
				return getSacrificeBunt();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLY:
				return getSacrificeFly();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SINGLE:
				return getSingle();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE:
				return getSluggingPercentage();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE:
				return getStolenBase();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE:
				return getStolenBasePercentage();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TOTAL_BASES:
				return getTotalBases();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLES:
				return getTriples();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALKS:
				return getWalks();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALK_OFF:
				return getWalkOff();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				setAtBats((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BATTING_AVERAGE:
				setBattingAverage((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__CAUGHT_STEALING:
				setCaughtStealing((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLES:
				setDoubles((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__EXTRA_BASE_HITS:
				setExtraBaseHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GAMES_PLAYED:
				setGamesPlayed((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GRAND_SLAM:
				setGrandSlam((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY:
				setGroundIntoDoublePlay((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO:
				setGroundoutToAiroutRatio((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HIT_BY_PITCHS:
				setHitByPitchs((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				setHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HOME_RUNS:
				setHomeRuns((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__INTENTIONAL_WALKS:
				setIntentionalWalks((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__LEFT_ON_BASE:
				setLeftOnBase((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE:
				setOnBasePercentage((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING:
				setOnBasePlusSlugging((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				setPlateAppearance((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__REACHED_ON_ERROR:
				setReachedOnError((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RUNS:
				setRuns((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RBIS:
				setRbis((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_BUNT:
				setSacrificeBunt((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLY:
				setSacrificeFly((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SINGLE:
				setSingle((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE:
				setSluggingPercentage((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE:
				setStolenBase((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE:
				setStolenBasePercentage((Double)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TOTAL_BASES:
				setTotalBases((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLES:
				setTriples((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALKS:
				setWalks((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALK_OFF:
				setWalkOff((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				setAtBats(AT_BATS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BATTING_AVERAGE:
				setBattingAverage(BATTING_AVERAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__CAUGHT_STEALING:
				setCaughtStealing(CAUGHT_STEALING_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLES:
				setDoubles(DOUBLES_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__EXTRA_BASE_HITS:
				setExtraBaseHits(EXTRA_BASE_HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GAMES_PLAYED:
				setGamesPlayed(GAMES_PLAYED_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GRAND_SLAM:
				setGrandSlam(GRAND_SLAM_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY:
				setGroundIntoDoublePlay(GROUND_INTO_DOUBLE_PLAY_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO:
				setGroundoutToAiroutRatio(GROUNDOUT_TO_AIROUT_RATIO_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HIT_BY_PITCHS:
				setHitByPitchs(HIT_BY_PITCHS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HOME_RUNS:
				setHomeRuns(HOME_RUNS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__INTENTIONAL_WALKS:
				setIntentionalWalks(INTENTIONAL_WALKS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__LEFT_ON_BASE:
				setLeftOnBase(LEFT_ON_BASE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE:
				setOnBasePercentage(ON_BASE_PERCENTAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING:
				setOnBasePlusSlugging(ON_BASE_PLUS_SLUGGING_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				setPlateAppearance(PLATE_APPEARANCE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__REACHED_ON_ERROR:
				setReachedOnError(REACHED_ON_ERROR_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RUNS:
				setRuns(RUNS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RBIS:
				setRbis(RBIS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_BUNT:
				setSacrificeBunt(SACRIFICE_BUNT_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLY:
				setSacrificeFly(SACRIFICE_FLY_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SINGLE:
				setSingle(SINGLE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE:
				setSluggingPercentage(SLUGGING_PERCENTAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE:
				setStolenBase(STOLEN_BASE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE:
				setStolenBasePercentage(STOLEN_BASE_PERCENTAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TOTAL_BASES:
				setTotalBases(TOTAL_BASES_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLES:
				setTriples(TRIPLES_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALKS:
				setWalks(WALKS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALK_OFF:
				setWalkOff(WALK_OFF_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				return atBats != AT_BATS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BATTING_AVERAGE:
				return battingAverage != BATTING_AVERAGE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__CAUGHT_STEALING:
				return caughtStealing != CAUGHT_STEALING_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLES:
				return doubles != DOUBLES_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__EXTRA_BASE_HITS:
				return extraBaseHits != EXTRA_BASE_HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GAMES_PLAYED:
				return gamesPlayed != GAMES_PLAYED_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GRAND_SLAM:
				return grandSlam != GRAND_SLAM_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUND_INTO_DOUBLE_PLAY:
				return groundIntoDoublePlay != GROUND_INTO_DOUBLE_PLAY_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__GROUNDOUT_TO_AIROUT_RATIO:
				return groundoutToAiroutRatio != GROUNDOUT_TO_AIROUT_RATIO_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HIT_BY_PITCHS:
				return hitByPitchs != HIT_BY_PITCHS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				return hits != HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HOME_RUNS:
				return homeRuns != HOME_RUNS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__INTENTIONAL_WALKS:
				return intentionalWalks != INTENTIONAL_WALKS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__LEFT_ON_BASE:
				return leftOnBase != LEFT_ON_BASE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PERCENTAGE:
				return onBasePercentage != ON_BASE_PERCENTAGE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__ON_BASE_PLUS_SLUGGING:
				return onBasePlusSlugging != ON_BASE_PLUS_SLUGGING_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				return plateAppearance != PLATE_APPEARANCE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__REACHED_ON_ERROR:
				return reachedOnError != REACHED_ON_ERROR_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RUNS:
				return runs != RUNS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__RBIS:
				return rbis != RBIS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_BUNT:
				return sacrificeBunt != SACRIFICE_BUNT_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLY:
				return sacrificeFly != SACRIFICE_FLY_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SINGLE:
				return single != SINGLE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SLUGGING_PERCENTAGE:
				return sluggingPercentage != SLUGGING_PERCENTAGE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE:
				return stolenBase != STOLEN_BASE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__STOLEN_BASE_PERCENTAGE:
				return stolenBasePercentage != STOLEN_BASE_PERCENTAGE_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TOTAL_BASES:
				return totalBases != TOTAL_BASES_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLES:
				return triples != TRIPLES_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALKS:
				return walks != WALKS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__WALK_OFF:
				return walkOff != WALK_OFF_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (atBats: ");
		result.append(atBats);
		result.append(", battingAverage: ");
		result.append(battingAverage);
		result.append(", caughtStealing: ");
		result.append(caughtStealing);
		result.append(", doubles: ");
		result.append(doubles);
		result.append(", extraBaseHits: ");
		result.append(extraBaseHits);
		result.append(", gamesPlayed: ");
		result.append(gamesPlayed);
		result.append(", grandSlam: ");
		result.append(grandSlam);
		result.append(", groundIntoDoublePlay: ");
		result.append(groundIntoDoublePlay);
		result.append(", groundoutToAiroutRatio: ");
		result.append(groundoutToAiroutRatio);
		result.append(", hitByPitchs: ");
		result.append(hitByPitchs);
		result.append(", hits: ");
		result.append(hits);
		result.append(", homeRuns: ");
		result.append(homeRuns);
		result.append(", intentionalWalks: ");
		result.append(intentionalWalks);
		result.append(", leftOnBase: ");
		result.append(leftOnBase);
		result.append(", onBasePercentage: ");
		result.append(onBasePercentage);
		result.append(", onBasePlusSlugging: ");
		result.append(onBasePlusSlugging);
		result.append(", plateAppearance: ");
		result.append(plateAppearance);
		result.append(", reachedOnError: ");
		result.append(reachedOnError);
		result.append(", runs: ");
		result.append(runs);
		result.append(", rbis: ");
		result.append(rbis);
		result.append(", sacrificeBunt: ");
		result.append(sacrificeBunt);
		result.append(", sacrificeFly: ");
		result.append(sacrificeFly);
		result.append(", single: ");
		result.append(single);
		result.append(", sluggingPercentage: ");
		result.append(sluggingPercentage);
		result.append(", stolenBase: ");
		result.append(stolenBase);
		result.append(", stolenBasePercentage: ");
		result.append(stolenBasePercentage);
		result.append(", totalBases: ");
		result.append(totalBases);
		result.append(", triples: ");
		result.append(triples);
		result.append(", walks: ");
		result.append(walks);
		result.append(", walkOff: ");
		result.append(walkOff);
		result.append(')');
		return result.toString();
	}

} //OffensiveStatisticsImpl
