/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Defensive Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getAssists <em>Assists</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getCaughtStealingPercentage <em>Caught Stealing Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getDoublePlays <em>Double Plays</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getFieldingPercentage <em>Fielding Percentage</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getInningsPlayed <em>Innings Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getOuts <em>Outs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getOutfieldAssist <em>Outfield Assist</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getPassedBall <em>Passed Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getPutouts <em>Putouts</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getTotalChances <em>Total Chances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getTriplePlay <em>Triple Play</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefensiveStatisticsImpl extends MinimalEObjectImpl.Container implements DefensiveStatistics {
	/**
	 * The default value of the '{@link #getAssists() <em>Assists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssists()
	 * @generated
	 * @ordered
	 */
	protected static final int ASSISTS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getAssists() <em>Assists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssists()
	 * @generated
	 * @ordered
	 */
	protected int assists = ASSISTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCaughtStealingPercentage() <em>Caught Stealing Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtStealingPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double CAUGHT_STEALING_PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCaughtStealingPercentage() <em>Caught Stealing Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtStealingPercentage()
	 * @generated
	 * @ordered
	 */
	protected double caughtStealingPercentage = CAUGHT_STEALING_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoublePlays() <em>Double Plays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlays()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLE_PLAYS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getDoublePlays() <em>Double Plays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlays()
	 * @generated
	 * @ordered
	 */
	protected int doublePlays = DOUBLE_PLAYS_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected static final int ERRORS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected int errors = ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldingPercentage() <em>Fielding Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldingPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double FIELDING_PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFieldingPercentage() <em>Fielding Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldingPercentage()
	 * @generated
	 * @ordered
	 */
	protected double fieldingPercentage = FIELDING_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInningsPlayed() <em>Innings Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInningsPlayed()
	 * @generated
	 * @ordered
	 */
	protected static final double INNINGS_PLAYED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInningsPlayed() <em>Innings Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInningsPlayed()
	 * @generated
	 * @ordered
	 */
	protected double inningsPlayed = INNINGS_PLAYED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOuts() <em>Outs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuts()
	 * @generated
	 * @ordered
	 */
	protected static final int OUTS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getOuts() <em>Outs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuts()
	 * @generated
	 * @ordered
	 */
	protected int outs = OUTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutfieldAssist() <em>Outfield Assist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutfieldAssist()
	 * @generated
	 * @ordered
	 */
	protected static final int OUTFIELD_ASSIST_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getOutfieldAssist() <em>Outfield Assist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutfieldAssist()
	 * @generated
	 * @ordered
	 */
	protected int outfieldAssist = OUTFIELD_ASSIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassedBall() <em>Passed Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassedBall()
	 * @generated
	 * @ordered
	 */
	protected static final int PASSED_BALL_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPassedBall() <em>Passed Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassedBall()
	 * @generated
	 * @ordered
	 */
	protected int passedBall = PASSED_BALL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPutouts() <em>Putouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutouts()
	 * @generated
	 * @ordered
	 */
	protected static final int PUTOUTS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPutouts() <em>Putouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutouts()
	 * @generated
	 * @ordered
	 */
	protected int putouts = PUTOUTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalChances() <em>Total Chances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalChances()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_CHANCES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTotalChances() <em>Total Chances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalChances()
	 * @generated
	 * @ordered
	 */
	protected int totalChances = TOTAL_CHANCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getTriplePlay() <em>Triple Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriplePlay()
	 * @generated
	 * @ordered
	 */
	protected static final int TRIPLE_PLAY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTriplePlay() <em>Triple Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriplePlay()
	 * @generated
	 * @ordered
	 */
	protected int triplePlay = TRIPLE_PLAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefensiveStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.DEFENSIVE_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPutouts() {
		return putouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPutouts(int newPutouts) {
		int oldPutouts = putouts;
		putouts = newPutouts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS, oldPutouts, putouts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTotalChances() {
		return totalChances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalChances(int newTotalChances) {
		int oldTotalChances = totalChances;
		totalChances = newTotalChances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TOTAL_CHANCES, oldTotalChances, totalChances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTriplePlay() {
		return triplePlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTriplePlay(int newTriplePlay) {
		int oldTriplePlay = triplePlay;
		triplePlay = newTriplePlay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TRIPLE_PLAY, oldTriplePlay, triplePlay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAssists() {
		return assists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssists(int newAssists) {
		int oldAssists = assists;
		assists = newAssists;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS, oldAssists, assists));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCaughtStealingPercentage() {
		return caughtStealingPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCaughtStealingPercentage(double newCaughtStealingPercentage) {
		double oldCaughtStealingPercentage = caughtStealingPercentage;
		caughtStealingPercentage = newCaughtStealingPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE, oldCaughtStealingPercentage, caughtStealingPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDoublePlays() {
		return doublePlays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDoublePlays(int newDoublePlays) {
		int oldDoublePlays = doublePlays;
		doublePlays = newDoublePlays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__DOUBLE_PLAYS, oldDoublePlays, doublePlays));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getErrors() {
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setErrors(int newErrors) {
		int oldErrors = errors;
		errors = newErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS, oldErrors, errors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getFieldingPercentage() {
		return fieldingPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldingPercentage(double newFieldingPercentage) {
		double oldFieldingPercentage = fieldingPercentage;
		fieldingPercentage = newFieldingPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE, oldFieldingPercentage, fieldingPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInningsPlayed() {
		return inningsPlayed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInningsPlayed(double newInningsPlayed) {
		double oldInningsPlayed = inningsPlayed;
		inningsPlayed = newInningsPlayed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__INNINGS_PLAYED, oldInningsPlayed, inningsPlayed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOuts() {
		return outs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOuts(int newOuts) {
		int oldOuts = outs;
		outs = newOuts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTS, oldOuts, outs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOutfieldAssist() {
		return outfieldAssist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutfieldAssist(int newOutfieldAssist) {
		int oldOutfieldAssist = outfieldAssist;
		outfieldAssist = newOutfieldAssist;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTFIELD_ASSIST, oldOutfieldAssist, outfieldAssist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPassedBall() {
		return passedBall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassedBall(int newPassedBall) {
		int oldPassedBall = passedBall;
		passedBall = newPassedBall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PASSED_BALL, oldPassedBall, passedBall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				return getAssists();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE:
				return getCaughtStealingPercentage();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__DOUBLE_PLAYS:
				return getDoublePlays();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				return getErrors();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE:
				return getFieldingPercentage();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__INNINGS_PLAYED:
				return getInningsPlayed();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTS:
				return getOuts();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTFIELD_ASSIST:
				return getOutfieldAssist();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PASSED_BALL:
				return getPassedBall();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				return getPutouts();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TOTAL_CHANCES:
				return getTotalChances();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TRIPLE_PLAY:
				return getTriplePlay();
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				setAssists((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE:
				setCaughtStealingPercentage((Double)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__DOUBLE_PLAYS:
				setDoublePlays((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				setErrors((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE:
				setFieldingPercentage((Double)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__INNINGS_PLAYED:
				setInningsPlayed((Double)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTS:
				setOuts((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTFIELD_ASSIST:
				setOutfieldAssist((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PASSED_BALL:
				setPassedBall((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				setPutouts((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TOTAL_CHANCES:
				setTotalChances((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TRIPLE_PLAY:
				setTriplePlay((Integer)newValue);
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				setAssists(ASSISTS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE:
				setCaughtStealingPercentage(CAUGHT_STEALING_PERCENTAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__DOUBLE_PLAYS:
				setDoublePlays(DOUBLE_PLAYS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				setErrors(ERRORS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE:
				setFieldingPercentage(FIELDING_PERCENTAGE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__INNINGS_PLAYED:
				setInningsPlayed(INNINGS_PLAYED_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTS:
				setOuts(OUTS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTFIELD_ASSIST:
				setOutfieldAssist(OUTFIELD_ASSIST_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PASSED_BALL:
				setPassedBall(PASSED_BALL_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				setPutouts(PUTOUTS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TOTAL_CHANCES:
				setTotalChances(TOTAL_CHANCES_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TRIPLE_PLAY:
				setTriplePlay(TRIPLE_PLAY_EDEFAULT);
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				return assists != ASSISTS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__CAUGHT_STEALING_PERCENTAGE:
				return caughtStealingPercentage != CAUGHT_STEALING_PERCENTAGE_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__DOUBLE_PLAYS:
				return doublePlays != DOUBLE_PLAYS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				return errors != ERRORS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__FIELDING_PERCENTAGE:
				return fieldingPercentage != FIELDING_PERCENTAGE_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__INNINGS_PLAYED:
				return inningsPlayed != INNINGS_PLAYED_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTS:
				return outs != OUTS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__OUTFIELD_ASSIST:
				return outfieldAssist != OUTFIELD_ASSIST_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PASSED_BALL:
				return passedBall != PASSED_BALL_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				return putouts != PUTOUTS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TOTAL_CHANCES:
				return totalChances != TOTAL_CHANCES_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__TRIPLE_PLAY:
				return triplePlay != TRIPLE_PLAY_EDEFAULT;
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
		result.append(" (assists: ");
		result.append(assists);
		result.append(", caughtStealingPercentage: ");
		result.append(caughtStealingPercentage);
		result.append(", doublePlays: ");
		result.append(doublePlays);
		result.append(", errors: ");
		result.append(errors);
		result.append(", fieldingPercentage: ");
		result.append(fieldingPercentage);
		result.append(", inningsPlayed: ");
		result.append(inningsPlayed);
		result.append(", outs: ");
		result.append(outs);
		result.append(", outfieldAssist: ");
		result.append(outfieldAssist);
		result.append(", passedBall: ");
		result.append(passedBall);
		result.append(", putouts: ");
		result.append(putouts);
		result.append(", totalChances: ");
		result.append(totalChances);
		result.append(", triplePlay: ");
		result.append(triplePlay);
		result.append(')');
		return result.toString();
	}

} //DefensiveStatisticsImpl
