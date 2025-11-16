/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inning General Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getRuns <em>Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getAssitances <em>Assitances</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InningGeneralStatisticImpl#getLob <em>Lob</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InningGeneralStatisticImpl extends MinimalEObjectImpl.Container implements InningGeneralStatistic {
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
	 * The default value of the '{@link #getAssitances() <em>Assitances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssitances()
	 * @generated
	 * @ordered
	 */
	protected static final int ASSITANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAssitances() <em>Assitances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssitances()
	 * @generated
	 * @ordered
	 */
	protected int assitances = ASSITANCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected static final int ERRORS_EDEFAULT = 0;

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
	 * The default value of the '{@link #getLob() <em>Lob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLob()
	 * @generated
	 * @ordered
	 */
	protected static final int LOB_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLob() <em>Lob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLob()
	 * @generated
	 * @ordered
	 */
	protected int lob = LOB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InningGeneralStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.INNING_GENERAL_STATISTIC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__AT_BATS, oldAtBats, atBats));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__RUNS, oldRuns, runs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__EARNED_RUNS, oldEarnedRuns, earnedRuns));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__HITS, oldHits, hits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAssitances() {
		return assitances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssitances(int newAssitances) {
		int oldAssitances = assitances;
		assitances = newAssitances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__ASSITANCES, oldAssitances, assitances));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__ERRORS, oldErrors, errors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLob() {
		return lob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLob(int newLob) {
		int oldLob = lob;
		lob = newLob;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNING_GENERAL_STATISTIC__LOB, oldLob, lob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatisticPackage.INNING_GENERAL_STATISTIC__AT_BATS:
				return getAtBats();
			case StatisticPackage.INNING_GENERAL_STATISTIC__RUNS:
				return getRuns();
			case StatisticPackage.INNING_GENERAL_STATISTIC__EARNED_RUNS:
				return getEarnedRuns();
			case StatisticPackage.INNING_GENERAL_STATISTIC__HITS:
				return getHits();
			case StatisticPackage.INNING_GENERAL_STATISTIC__ASSITANCES:
				return getAssitances();
			case StatisticPackage.INNING_GENERAL_STATISTIC__ERRORS:
				return getErrors();
			case StatisticPackage.INNING_GENERAL_STATISTIC__LOB:
				return getLob();
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
			case StatisticPackage.INNING_GENERAL_STATISTIC__AT_BATS:
				setAtBats((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__RUNS:
				setRuns((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__EARNED_RUNS:
				setEarnedRuns((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__HITS:
				setHits((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ASSITANCES:
				setAssitances((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ERRORS:
				setErrors((Integer)newValue);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__LOB:
				setLob((Integer)newValue);
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
			case StatisticPackage.INNING_GENERAL_STATISTIC__AT_BATS:
				setAtBats(AT_BATS_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__RUNS:
				setRuns(RUNS_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__EARNED_RUNS:
				setEarnedRuns(EARNED_RUNS_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ASSITANCES:
				setAssitances(ASSITANCES_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ERRORS:
				setErrors(ERRORS_EDEFAULT);
				return;
			case StatisticPackage.INNING_GENERAL_STATISTIC__LOB:
				setLob(LOB_EDEFAULT);
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
			case StatisticPackage.INNING_GENERAL_STATISTIC__AT_BATS:
				return atBats != AT_BATS_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__RUNS:
				return runs != RUNS_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__EARNED_RUNS:
				return earnedRuns != EARNED_RUNS_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__HITS:
				return hits != HITS_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ASSITANCES:
				return assitances != ASSITANCES_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__ERRORS:
				return errors != ERRORS_EDEFAULT;
			case StatisticPackage.INNING_GENERAL_STATISTIC__LOB:
				return lob != LOB_EDEFAULT;
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
		result.append(", runs: ");
		result.append(runs);
		result.append(", earnedRuns: ");
		result.append(earnedRuns);
		result.append(", hits: ");
		result.append(hits);
		result.append(", assitances: ");
		result.append(assitances);
		result.append(", errors: ");
		result.append(errors);
		result.append(", lob: ");
		result.append(lob);
		result.append(')');
		return result.toString();
	}

} //InningGeneralStatisticImpl
