/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Offensive Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getPlateAppearances <em>Plate Appearances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getDouble <em>Double</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getTriple <em>Triple</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getHomerun <em>Homerun</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getGroundedDoublePlay <em>Grounded Double Play</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getSacrificeHit <em>Sacrifice Hit</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getSacrificeFly <em>Sacrifice Fly</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getBaseOnBall <em>Base On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getIntentionalbaseOnBall <em>Intentionalbase On Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getHitByPitch <em>Hit By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getInterferanceObstruction <em>Interferance Obstruction</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getCaughtStealing <em>Caught Stealing</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getStrikeOut <em>Strike Out</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.OffensiveStatisticImpl#getRbi <em>Rbi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OffensiveStatisticImpl extends MinimalEObjectImpl.Container implements OffensiveStatistic {
	/**
	 * The default value of the '{@link #getPlateAppearances() <em>Plate Appearances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearances()
	 * @generated
	 * @ordered
	 */
	protected static final int PLATE_APPEARANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPlateAppearances() <em>Plate Appearances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearances()
	 * @generated
	 * @ordered
	 */
	protected int plateAppearances = PLATE_APPEARANCES_EDEFAULT;

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
	 * The default value of the '{@link #getGroundedDoublePlay() <em>Grounded Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundedDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected static final int GROUNDED_DOUBLE_PLAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGroundedDoublePlay() <em>Grounded Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundedDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected int groundedDoublePlay = GROUNDED_DOUBLE_PLAY_EDEFAULT;

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
	 * The default value of the '{@link #getStolenBase() <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStolenBase()
	 * @generated
	 * @ordered
	 */
	protected static final int STOLEN_BASE_EDEFAULT = 0;

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
	 * The default value of the '{@link #getRbi() <em>Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRbi()
	 * @generated
	 * @ordered
	 */
	protected static final int RBI_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRbi() <em>Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRbi()
	 * @generated
	 * @ordered
	 */
	protected int rbi = RBI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OffensiveStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.OFFENSIVE_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPlateAppearances() {
		return plateAppearances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlateAppearances(int newPlateAppearances) {
		int oldPlateAppearances = plateAppearances;
		plateAppearances = newPlateAppearances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__PLATE_APPEARANCES, oldPlateAppearances, plateAppearances));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__AT_BATS, oldAtBats, atBats));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__RUNS, oldRuns, runs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__HITS, oldHits, hits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__DOUBLE, oldDouble, double_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__TRIPLE, oldTriple, triple));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__HOMERUN, oldHomerun, homerun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGroundedDoublePlay() {
		return groundedDoublePlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroundedDoublePlay(int newGroundedDoublePlay) {
		int oldGroundedDoublePlay = groundedDoublePlay;
		groundedDoublePlay = newGroundedDoublePlay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY, oldGroundedDoublePlay, groundedDoublePlay));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_HIT, oldSacrificeHit, sacrificeHit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_FLY, oldSacrificeFly, sacrificeFly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__BASE_ON_BALL, oldBaseOnBall, baseOnBall));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL, oldIntentionalbaseOnBall, intentionalbaseOnBall));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__HIT_BY_PITCH, oldHitByPitch, hitByPitch));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION, oldInterferanceObstruction, interferanceObstruction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__STOLEN_BASE, oldStolenBase, stolenBase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__CAUGHT_STEALING, oldCaughtStealing, caughtStealing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__STRIKE_OUT, oldStrikeOut, strikeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRbi() {
		return rbi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRbi(int newRbi) {
		int oldRbi = rbi;
		rbi = newRbi;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.OFFENSIVE_STATISTIC__RBI, oldRbi, rbi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatisticPackage.OFFENSIVE_STATISTIC__PLATE_APPEARANCES:
				return getPlateAppearances();
			case StatisticPackage.OFFENSIVE_STATISTIC__AT_BATS:
				return getAtBats();
			case StatisticPackage.OFFENSIVE_STATISTIC__RUNS:
				return getRuns();
			case StatisticPackage.OFFENSIVE_STATISTIC__HITS:
				return getHits();
			case StatisticPackage.OFFENSIVE_STATISTIC__DOUBLE:
				return getDouble();
			case StatisticPackage.OFFENSIVE_STATISTIC__TRIPLE:
				return getTriple();
			case StatisticPackage.OFFENSIVE_STATISTIC__HOMERUN:
				return getHomerun();
			case StatisticPackage.OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY:
				return getGroundedDoublePlay();
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_HIT:
				return getSacrificeHit();
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_FLY:
				return getSacrificeFly();
			case StatisticPackage.OFFENSIVE_STATISTIC__BASE_ON_BALL:
				return getBaseOnBall();
			case StatisticPackage.OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL:
				return getIntentionalbaseOnBall();
			case StatisticPackage.OFFENSIVE_STATISTIC__HIT_BY_PITCH:
				return getHitByPitch();
			case StatisticPackage.OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION:
				return getInterferanceObstruction();
			case StatisticPackage.OFFENSIVE_STATISTIC__STOLEN_BASE:
				return getStolenBase();
			case StatisticPackage.OFFENSIVE_STATISTIC__CAUGHT_STEALING:
				return getCaughtStealing();
			case StatisticPackage.OFFENSIVE_STATISTIC__STRIKE_OUT:
				return getStrikeOut();
			case StatisticPackage.OFFENSIVE_STATISTIC__RBI:
				return getRbi();
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
			case StatisticPackage.OFFENSIVE_STATISTIC__PLATE_APPEARANCES:
				setPlateAppearances((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__AT_BATS:
				setAtBats((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__RUNS:
				setRuns((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HITS:
				setHits((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__DOUBLE:
				setDouble((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__TRIPLE:
				setTriple((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HOMERUN:
				setHomerun((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY:
				setGroundedDoublePlay((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_HIT:
				setSacrificeHit((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_FLY:
				setSacrificeFly((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__BASE_ON_BALL:
				setBaseOnBall((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL:
				setIntentionalbaseOnBall((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HIT_BY_PITCH:
				setHitByPitch((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION:
				setInterferanceObstruction((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__STOLEN_BASE:
				setStolenBase((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__CAUGHT_STEALING:
				setCaughtStealing((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__STRIKE_OUT:
				setStrikeOut((Integer)newValue);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__RBI:
				setRbi((Integer)newValue);
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
			case StatisticPackage.OFFENSIVE_STATISTIC__PLATE_APPEARANCES:
				setPlateAppearances(PLATE_APPEARANCES_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__AT_BATS:
				setAtBats(AT_BATS_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__RUNS:
				setRuns(RUNS_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__DOUBLE:
				setDouble(DOUBLE_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__TRIPLE:
				setTriple(TRIPLE_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HOMERUN:
				setHomerun(HOMERUN_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY:
				setGroundedDoublePlay(GROUNDED_DOUBLE_PLAY_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_HIT:
				setSacrificeHit(SACRIFICE_HIT_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_FLY:
				setSacrificeFly(SACRIFICE_FLY_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__BASE_ON_BALL:
				setBaseOnBall(BASE_ON_BALL_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL:
				setIntentionalbaseOnBall(INTENTIONALBASE_ON_BALL_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__HIT_BY_PITCH:
				setHitByPitch(HIT_BY_PITCH_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION:
				setInterferanceObstruction(INTERFERANCE_OBSTRUCTION_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__STOLEN_BASE:
				setStolenBase(STOLEN_BASE_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__CAUGHT_STEALING:
				setCaughtStealing(CAUGHT_STEALING_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__STRIKE_OUT:
				setStrikeOut(STRIKE_OUT_EDEFAULT);
				return;
			case StatisticPackage.OFFENSIVE_STATISTIC__RBI:
				setRbi(RBI_EDEFAULT);
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
			case StatisticPackage.OFFENSIVE_STATISTIC__PLATE_APPEARANCES:
				return plateAppearances != PLATE_APPEARANCES_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__AT_BATS:
				return atBats != AT_BATS_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__RUNS:
				return runs != RUNS_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__HITS:
				return hits != HITS_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__DOUBLE:
				return double_ != DOUBLE_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__TRIPLE:
				return triple != TRIPLE_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__HOMERUN:
				return homerun != HOMERUN_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__GROUNDED_DOUBLE_PLAY:
				return groundedDoublePlay != GROUNDED_DOUBLE_PLAY_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_HIT:
				return sacrificeHit != SACRIFICE_HIT_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__SACRIFICE_FLY:
				return sacrificeFly != SACRIFICE_FLY_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__BASE_ON_BALL:
				return baseOnBall != BASE_ON_BALL_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTENTIONALBASE_ON_BALL:
				return intentionalbaseOnBall != INTENTIONALBASE_ON_BALL_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__HIT_BY_PITCH:
				return hitByPitch != HIT_BY_PITCH_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__INTERFERANCE_OBSTRUCTION:
				return interferanceObstruction != INTERFERANCE_OBSTRUCTION_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__STOLEN_BASE:
				return stolenBase != STOLEN_BASE_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__CAUGHT_STEALING:
				return caughtStealing != CAUGHT_STEALING_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__STRIKE_OUT:
				return strikeOut != STRIKE_OUT_EDEFAULT;
			case StatisticPackage.OFFENSIVE_STATISTIC__RBI:
				return rbi != RBI_EDEFAULT;
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
		result.append(" (plateAppearances: ");
		result.append(plateAppearances);
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
		result.append(", groundedDoublePlay: ");
		result.append(groundedDoublePlay);
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
		result.append(", stolenBase: ");
		result.append(stolenBase);
		result.append(", caughtStealing: ");
		result.append(caughtStealing);
		result.append(", strikeOut: ");
		result.append(strikeOut);
		result.append(", rbi: ");
		result.append(rbi);
		result.append(')');
		return result.toString();
	}

} //OffensiveStatisticImpl
