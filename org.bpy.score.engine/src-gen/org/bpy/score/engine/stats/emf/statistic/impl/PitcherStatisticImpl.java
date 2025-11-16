/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pitcher Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getBatterFront <em>Batter Front</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getDouble <em>Double</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getTriple <em>Triple</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getHomerun <em>Homerun</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getSacrificeHit <em>Sacrifice Hit</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getBaseOnBall <em>Base On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getHitByPitch <em>Hit By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getInterferanceObstruction <em>Interferance Obstruction</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getStrikeOut <em>Strike Out</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getWildPitches <em>Wild Pitches</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getBalks <em>Balks</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getPitchCount <em>Pitch Count</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getPitchCountK <em>Pitch Count K</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getPitchCountB <em>Pitch Count B</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getPitchCountOthers <em>Pitch Count Others</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getRunnerLeftOnBase <em>Runner Left On Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.PitcherStatisticImpl#getCaughtStealing <em>Caught Stealing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PitcherStatisticImpl extends MinimalEObjectImpl.Container implements PitcherStatistic {
	/**
	 * The default value of the '{@link #getBatterFront() <em>Batter Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatterFront()
	 * @generated
	 * @ordered
	 */
	protected static final int BATTER_FRONT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBatterFront() <em>Batter Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatterFront()
	 * @generated
	 * @ordered
	 */
	protected int batterFront = BATTER_FRONT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAtBats() <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtBats()
	 * @generated
	 * @ordered
	 */
	protected static final int AT_BATS_EDEFAULT = 0;

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
	 * The default value of the '{@link #getRuns() <em>Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int RUNS_EDEFAULT = 0;

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
	 * The default value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected static final int HITS_EDEFAULT = 0;

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
	 * The default value of the '{@link #getDouble() <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDouble()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDouble() <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDouble()
	 * @generated
	 * @ordered
	 */
	protected int double_ = DOUBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriple() <em>Triple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriple()
	 * @generated
	 * @ordered
	 */
	protected static final int TRIPLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTriple() <em>Triple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriple()
	 * @generated
	 * @ordered
	 */
	protected int triple = TRIPLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHomerun() <em>Homerun</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomerun()
	 * @generated
	 * @ordered
	 */
	protected static final int HOMERUN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHomerun() <em>Homerun</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHomerun()
	 * @generated
	 * @ordered
	 */
	protected int homerun = HOMERUN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSacrificeHit() <em>Sacrifice Hit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeHit()
	 * @generated
	 * @ordered
	 */
	protected static final int SACRIFICE_HIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSacrificeHit() <em>Sacrifice Hit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeHit()
	 * @generated
	 * @ordered
	 */
	protected int sacrificeHit = SACRIFICE_HIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSacrificeFly() <em>Sacrifice Fly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeFly()
	 * @generated
	 * @ordered
	 */
	protected static final int SACRIFICE_FLY_EDEFAULT = 0;

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
	 * The default value of the '{@link #getBaseOnBall() <em>Base On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseOnBall()
	 * @generated
	 * @ordered
	 */
	protected static final int BASE_ON_BALL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBaseOnBall() <em>Base On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseOnBall()
	 * @generated
	 * @ordered
	 */
	protected int baseOnBall = BASE_ON_BALL_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntentionalbaseOnBall() <em>Intentionalbase On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalbaseOnBall()
	 * @generated
	 * @ordered
	 */
	protected static final int INTENTIONALBASE_ON_BALL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntentionalbaseOnBall() <em>Intentionalbase On Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentionalbaseOnBall()
	 * @generated
	 * @ordered
	 */
	protected int intentionalbaseOnBall = INTENTIONALBASE_ON_BALL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitByPitch() <em>Hit By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitByPitch()
	 * @generated
	 * @ordered
	 */
	protected static final int HIT_BY_PITCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHitByPitch() <em>Hit By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitByPitch()
	 * @generated
	 * @ordered
	 */
	protected int hitByPitch = HIT_BY_PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterferanceObstruction() <em>Interferance Obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterferanceObstruction()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERFERANCE_OBSTRUCTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInterferanceObstruction() <em>Interferance Obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterferanceObstruction()
	 * @generated
	 * @ordered
	 */
	protected int interferanceObstruction = INTERFERANCE_OBSTRUCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStrikeOut() <em>Strike Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrikeOut()
	 * @generated
	 * @ordered
	 */
	protected static final int STRIKE_OUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStrikeOut() <em>Strike Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrikeOut()
	 * @generated
	 * @ordered
	 */
	protected int strikeOut = STRIKE_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEarnedRuns() <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int EARNED_RUNS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEarnedRuns() <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedRuns()
	 * @generated
	 * @ordered
	 */
	protected int earnedRuns = EARNED_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWildPitches() <em>Wild Pitches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWildPitches()
	 * @generated
	 * @ordered
	 */
	protected static final int WILD_PITCHES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWildPitches() <em>Wild Pitches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWildPitches()
	 * @generated
	 * @ordered
	 */
	protected int wildPitches = WILD_PITCHES_EDEFAULT;

	/**
	 * The default value of the '{@link #getBalks() <em>Balks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalks()
	 * @generated
	 * @ordered
	 */
	protected static final int BALKS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBalks() <em>Balks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalks()
	 * @generated
	 * @ordered
	 */
	protected int balks = BALKS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitchCount() <em>Pitch Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPitchCount() <em>Pitch Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCount()
	 * @generated
	 * @ordered
	 */
	protected int pitchCount = PITCH_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitchCountK() <em>Pitch Count K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountK()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_COUNT_K_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPitchCountK() <em>Pitch Count K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountK()
	 * @generated
	 * @ordered
	 */
	protected int pitchCountK = PITCH_COUNT_K_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitchCountB() <em>Pitch Count B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountB()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_COUNT_B_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPitchCountB() <em>Pitch Count B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountB()
	 * @generated
	 * @ordered
	 */
	protected int pitchCountB = PITCH_COUNT_B_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitchCountOthers() <em>Pitch Count Others</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountOthers()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_COUNT_OTHERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPitchCountOthers() <em>Pitch Count Others</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchCountOthers()
	 * @generated
	 * @ordered
	 */
	protected int pitchCountOthers = PITCH_COUNT_OTHERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRunnerLeftOnBase() <em>Runner Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnerLeftOnBase()
	 * @generated
	 * @ordered
	 */
	protected static final int RUNNER_LEFT_ON_BASE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRunnerLeftOnBase() <em>Runner Left On Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnerLeftOnBase()
	 * @generated
	 * @ordered
	 */
	protected int runnerLeftOnBase = RUNNER_LEFT_ON_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCaughtStealing() <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtStealing()
	 * @generated
	 * @ordered
	 */
	protected static final int CAUGHT_STEALING_EDEFAULT = 0;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PitcherStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.PITCHER_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBatterFront() {
		return batterFront;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBatterFront(int newBatterFront) {
		int oldBatterFront = batterFront;
		batterFront = newBatterFront;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__BATTER_FRONT, oldBatterFront, batterFront));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__AT_BATS, oldAtBats, atBats));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__RUNS, oldRuns, runs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__HITS, oldHits, hits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDouble() {
		return double_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDouble(int newDouble) {
		int oldDouble = double_;
		double_ = newDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__DOUBLE, oldDouble, double_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTriple() {
		return triple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTriple(int newTriple) {
		int oldTriple = triple;
		triple = newTriple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__TRIPLE, oldTriple, triple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHomerun() {
		return homerun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHomerun(int newHomerun) {
		int oldHomerun = homerun;
		homerun = newHomerun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__HOMERUN, oldHomerun, homerun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSacrificeHit() {
		return sacrificeHit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSacrificeHit(int newSacrificeHit) {
		int oldSacrificeHit = sacrificeHit;
		sacrificeHit = newSacrificeHit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__SACRIFICE_HIT, oldSacrificeHit, sacrificeHit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__SACRIFICE_FLY, oldSacrificeFly, sacrificeFly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBaseOnBall() {
		return baseOnBall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseOnBall(int newBaseOnBall) {
		int oldBaseOnBall = baseOnBall;
		baseOnBall = newBaseOnBall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__BASE_ON_BALL, oldBaseOnBall, baseOnBall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIntentionalbaseOnBall() {
		return intentionalbaseOnBall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntentionalbaseOnBall(int newIntentionalbaseOnBall) {
		int oldIntentionalbaseOnBall = intentionalbaseOnBall;
		intentionalbaseOnBall = newIntentionalbaseOnBall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL, oldIntentionalbaseOnBall, intentionalbaseOnBall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitByPitch() {
		return hitByPitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitByPitch(int newHitByPitch) {
		int oldHitByPitch = hitByPitch;
		hitByPitch = newHitByPitch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__HIT_BY_PITCH, oldHitByPitch, hitByPitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInterferanceObstruction() {
		return interferanceObstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterferanceObstruction(int newInterferanceObstruction) {
		int oldInterferanceObstruction = interferanceObstruction;
		interferanceObstruction = newInterferanceObstruction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION, oldInterferanceObstruction, interferanceObstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStrikeOut() {
		return strikeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStrikeOut(int newStrikeOut) {
		int oldStrikeOut = strikeOut;
		strikeOut = newStrikeOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__STRIKE_OUT, oldStrikeOut, strikeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEarnedRuns() {
		return earnedRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarnedRuns(int newEarnedRuns) {
		int oldEarnedRuns = earnedRuns;
		earnedRuns = newEarnedRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__EARNED_RUNS, oldEarnedRuns, earnedRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWildPitches() {
		return wildPitches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWildPitches(int newWildPitches) {
		int oldWildPitches = wildPitches;
		wildPitches = newWildPitches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__WILD_PITCHES, oldWildPitches, wildPitches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBalks() {
		return balks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBalks(int newBalks) {
		int oldBalks = balks;
		balks = newBalks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__BALKS, oldBalks, balks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPitchCount() {
		return pitchCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPitchCount(int newPitchCount) {
		int oldPitchCount = pitchCount;
		pitchCount = newPitchCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT, oldPitchCount, pitchCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPitchCountK() {
		return pitchCountK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPitchCountK(int newPitchCountK) {
		int oldPitchCountK = pitchCountK;
		pitchCountK = newPitchCountK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_K, oldPitchCountK, pitchCountK));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPitchCountB() {
		return pitchCountB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPitchCountB(int newPitchCountB) {
		int oldPitchCountB = pitchCountB;
		pitchCountB = newPitchCountB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_B, oldPitchCountB, pitchCountB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPitchCountOthers() {
		return pitchCountOthers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPitchCountOthers(int newPitchCountOthers) {
		int oldPitchCountOthers = pitchCountOthers;
		pitchCountOthers = newPitchCountOthers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_OTHERS, oldPitchCountOthers, pitchCountOthers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRunnerLeftOnBase() {
		return runnerLeftOnBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRunnerLeftOnBase(int newRunnerLeftOnBase) {
		int oldRunnerLeftOnBase = runnerLeftOnBase;
		runnerLeftOnBase = newRunnerLeftOnBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE, oldRunnerLeftOnBase, runnerLeftOnBase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.PITCHER_STATISTIC__CAUGHT_STEALING, oldCaughtStealing, caughtStealing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatisticPackage.PITCHER_STATISTIC__BATTER_FRONT:
				return getBatterFront();
			case StatisticPackage.PITCHER_STATISTIC__AT_BATS:
				return getAtBats();
			case StatisticPackage.PITCHER_STATISTIC__RUNS:
				return getRuns();
			case StatisticPackage.PITCHER_STATISTIC__HITS:
				return getHits();
			case StatisticPackage.PITCHER_STATISTIC__DOUBLE:
				return getDouble();
			case StatisticPackage.PITCHER_STATISTIC__TRIPLE:
				return getTriple();
			case StatisticPackage.PITCHER_STATISTIC__HOMERUN:
				return getHomerun();
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_HIT:
				return getSacrificeHit();
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_FLY:
				return getSacrificeFly();
			case StatisticPackage.PITCHER_STATISTIC__BASE_ON_BALL:
				return getBaseOnBall();
			case StatisticPackage.PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL:
				return getIntentionalbaseOnBall();
			case StatisticPackage.PITCHER_STATISTIC__HIT_BY_PITCH:
				return getHitByPitch();
			case StatisticPackage.PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION:
				return getInterferanceObstruction();
			case StatisticPackage.PITCHER_STATISTIC__STRIKE_OUT:
				return getStrikeOut();
			case StatisticPackage.PITCHER_STATISTIC__EARNED_RUNS:
				return getEarnedRuns();
			case StatisticPackage.PITCHER_STATISTIC__WILD_PITCHES:
				return getWildPitches();
			case StatisticPackage.PITCHER_STATISTIC__BALKS:
				return getBalks();
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT:
				return getPitchCount();
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_K:
				return getPitchCountK();
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_B:
				return getPitchCountB();
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_OTHERS:
				return getPitchCountOthers();
			case StatisticPackage.PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE:
				return getRunnerLeftOnBase();
			case StatisticPackage.PITCHER_STATISTIC__CAUGHT_STEALING:
				return getCaughtStealing();
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
			case StatisticPackage.PITCHER_STATISTIC__BATTER_FRONT:
				setBatterFront((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__AT_BATS:
				setAtBats((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__RUNS:
				setRuns((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HITS:
				setHits((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__DOUBLE:
				setDouble((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__TRIPLE:
				setTriple((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HOMERUN:
				setHomerun((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_HIT:
				setSacrificeHit((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_FLY:
				setSacrificeFly((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__BASE_ON_BALL:
				setBaseOnBall((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL:
				setIntentionalbaseOnBall((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HIT_BY_PITCH:
				setHitByPitch((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION:
				setInterferanceObstruction((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__STRIKE_OUT:
				setStrikeOut((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__EARNED_RUNS:
				setEarnedRuns((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__WILD_PITCHES:
				setWildPitches((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__BALKS:
				setBalks((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT:
				setPitchCount((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_K:
				setPitchCountK((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_B:
				setPitchCountB((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_OTHERS:
				setPitchCountOthers((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE:
				setRunnerLeftOnBase((Integer)newValue);
				return;
			case StatisticPackage.PITCHER_STATISTIC__CAUGHT_STEALING:
				setCaughtStealing((Integer)newValue);
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
			case StatisticPackage.PITCHER_STATISTIC__BATTER_FRONT:
				setBatterFront(BATTER_FRONT_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__AT_BATS:
				setAtBats(AT_BATS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__RUNS:
				setRuns(RUNS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__DOUBLE:
				setDouble(DOUBLE_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__TRIPLE:
				setTriple(TRIPLE_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HOMERUN:
				setHomerun(HOMERUN_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_HIT:
				setSacrificeHit(SACRIFICE_HIT_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_FLY:
				setSacrificeFly(SACRIFICE_FLY_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__BASE_ON_BALL:
				setBaseOnBall(BASE_ON_BALL_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL:
				setIntentionalbaseOnBall(INTENTIONALBASE_ON_BALL_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__HIT_BY_PITCH:
				setHitByPitch(HIT_BY_PITCH_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION:
				setInterferanceObstruction(INTERFERANCE_OBSTRUCTION_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__STRIKE_OUT:
				setStrikeOut(STRIKE_OUT_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__EARNED_RUNS:
				setEarnedRuns(EARNED_RUNS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__WILD_PITCHES:
				setWildPitches(WILD_PITCHES_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__BALKS:
				setBalks(BALKS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT:
				setPitchCount(PITCH_COUNT_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_K:
				setPitchCountK(PITCH_COUNT_K_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_B:
				setPitchCountB(PITCH_COUNT_B_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_OTHERS:
				setPitchCountOthers(PITCH_COUNT_OTHERS_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE:
				setRunnerLeftOnBase(RUNNER_LEFT_ON_BASE_EDEFAULT);
				return;
			case StatisticPackage.PITCHER_STATISTIC__CAUGHT_STEALING:
				setCaughtStealing(CAUGHT_STEALING_EDEFAULT);
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
			case StatisticPackage.PITCHER_STATISTIC__BATTER_FRONT:
				return batterFront != BATTER_FRONT_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__AT_BATS:
				return atBats != AT_BATS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__RUNS:
				return runs != RUNS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__HITS:
				return hits != HITS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__DOUBLE:
				return double_ != DOUBLE_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__TRIPLE:
				return triple != TRIPLE_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__HOMERUN:
				return homerun != HOMERUN_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_HIT:
				return sacrificeHit != SACRIFICE_HIT_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__SACRIFICE_FLY:
				return sacrificeFly != SACRIFICE_FLY_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__BASE_ON_BALL:
				return baseOnBall != BASE_ON_BALL_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__INTENTIONALBASE_ON_BALL:
				return intentionalbaseOnBall != INTENTIONALBASE_ON_BALL_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__HIT_BY_PITCH:
				return hitByPitch != HIT_BY_PITCH_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__INTERFERANCE_OBSTRUCTION:
				return interferanceObstruction != INTERFERANCE_OBSTRUCTION_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__STRIKE_OUT:
				return strikeOut != STRIKE_OUT_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__EARNED_RUNS:
				return earnedRuns != EARNED_RUNS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__WILD_PITCHES:
				return wildPitches != WILD_PITCHES_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__BALKS:
				return balks != BALKS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT:
				return pitchCount != PITCH_COUNT_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_K:
				return pitchCountK != PITCH_COUNT_K_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_B:
				return pitchCountB != PITCH_COUNT_B_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__PITCH_COUNT_OTHERS:
				return pitchCountOthers != PITCH_COUNT_OTHERS_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__RUNNER_LEFT_ON_BASE:
				return runnerLeftOnBase != RUNNER_LEFT_ON_BASE_EDEFAULT;
			case StatisticPackage.PITCHER_STATISTIC__CAUGHT_STEALING:
				return caughtStealing != CAUGHT_STEALING_EDEFAULT;
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
		result.append(" (batterFront: ");
		result.append(batterFront);
		result.append(", atBats: ");
		result.append(atBats);
		result.append(", runs: ");
		result.append(runs);
		result.append(", hits: ");
		result.append(hits);
		result.append(", double: ");
		result.append(double_);
		result.append(", triple: ");
		result.append(triple);
		result.append(", homerun: ");
		result.append(homerun);
		result.append(", sacrificeHit: ");
		result.append(sacrificeHit);
		result.append(", sacrificeFly: ");
		result.append(sacrificeFly);
		result.append(", baseOnBall: ");
		result.append(baseOnBall);
		result.append(", intentionalbaseOnBall: ");
		result.append(intentionalbaseOnBall);
		result.append(", hitByPitch: ");
		result.append(hitByPitch);
		result.append(", interferanceObstruction: ");
		result.append(interferanceObstruction);
		result.append(", strikeOut: ");
		result.append(strikeOut);
		result.append(", earnedRuns: ");
		result.append(earnedRuns);
		result.append(", wildPitches: ");
		result.append(wildPitches);
		result.append(", balks: ");
		result.append(balks);
		result.append(", pitchCount: ");
		result.append(pitchCount);
		result.append(", pitchCountK: ");
		result.append(pitchCountK);
		result.append(", pitchCountB: ");
		result.append(pitchCountB);
		result.append(", pitchCountOthers: ");
		result.append(pitchCountOthers);
		result.append(", runnerLeftOnBase: ");
		result.append(runnerLeftOnBase);
		result.append(", caughtStealing: ");
		result.append(caughtStealing);
		result.append(')');
		return result.toString();
	}

} //PitcherStatisticImpl
