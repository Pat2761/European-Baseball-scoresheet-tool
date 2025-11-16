/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.DefensiveStatistic;
import org.bpy.score.reports.gamereports.GameReportsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Defensive Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl#getPutOut <em>Put Out</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl#getAssitances <em>Assitances</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.DefensiveStatisticImpl#getDoublePlay <em>Double Play</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefensiveStatisticImpl extends MinimalEObjectImpl.Container implements DefensiveStatistic {
	/**
	 * The default value of the '{@link #getPutOut() <em>Put Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutOut()
	 * @generated
	 * @ordered
	 */
	protected static final int PUT_OUT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPutOut() <em>Put Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPutOut()
	 * @generated
	 * @ordered
	 */
	protected int putOut = PUT_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssitances() <em>Assitances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssitances()
	 * @generated
	 * @ordered
	 */
	protected static final int ASSITANCES_EDEFAULT = -1;

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
	 * The default value of the '{@link #getDoublePlay() <em>Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLE_PLAY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getDoublePlay() <em>Double Play</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlay()
	 * @generated
	 * @ordered
	 */
	protected int doublePlay = DOUBLE_PLAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefensiveStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.DEFENSIVE_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPutOut() {
		return putOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPutOut(int newPutOut) {
		int oldPutOut = putOut;
		putOut = newPutOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.DEFENSIVE_STATISTIC__PUT_OUT, oldPutOut, putOut));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.DEFENSIVE_STATISTIC__ASSITANCES, oldAssitances, assitances));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.DEFENSIVE_STATISTIC__ERRORS, oldErrors, errors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDoublePlay() {
		return doublePlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDoublePlay(int newDoublePlay) {
		int oldDoublePlay = doublePlay;
		doublePlay = newDoublePlay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.DEFENSIVE_STATISTIC__DOUBLE_PLAY, oldDoublePlay, doublePlay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GameReportsPackage.DEFENSIVE_STATISTIC__PUT_OUT:
				return getPutOut();
			case GameReportsPackage.DEFENSIVE_STATISTIC__ASSITANCES:
				return getAssitances();
			case GameReportsPackage.DEFENSIVE_STATISTIC__ERRORS:
				return getErrors();
			case GameReportsPackage.DEFENSIVE_STATISTIC__DOUBLE_PLAY:
				return getDoublePlay();
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
			case GameReportsPackage.DEFENSIVE_STATISTIC__PUT_OUT:
				setPutOut((Integer)newValue);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ASSITANCES:
				setAssitances((Integer)newValue);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ERRORS:
				setErrors((Integer)newValue);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__DOUBLE_PLAY:
				setDoublePlay((Integer)newValue);
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
			case GameReportsPackage.DEFENSIVE_STATISTIC__PUT_OUT:
				setPutOut(PUT_OUT_EDEFAULT);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ASSITANCES:
				setAssitances(ASSITANCES_EDEFAULT);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ERRORS:
				setErrors(ERRORS_EDEFAULT);
				return;
			case GameReportsPackage.DEFENSIVE_STATISTIC__DOUBLE_PLAY:
				setDoublePlay(DOUBLE_PLAY_EDEFAULT);
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
			case GameReportsPackage.DEFENSIVE_STATISTIC__PUT_OUT:
				return putOut != PUT_OUT_EDEFAULT;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ASSITANCES:
				return assitances != ASSITANCES_EDEFAULT;
			case GameReportsPackage.DEFENSIVE_STATISTIC__ERRORS:
				return errors != ERRORS_EDEFAULT;
			case GameReportsPackage.DEFENSIVE_STATISTIC__DOUBLE_PLAY:
				return doublePlay != DOUBLE_PLAY_EDEFAULT;
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
		result.append(" (putOut: ");
		result.append(putOut);
		result.append(", assitances: ");
		result.append(assitances);
		result.append(", errors: ");
		result.append(errors);
		result.append(", doublePlay: ");
		result.append(doublePlay);
		result.append(')');
		return result.toString();
	}

} //DefensiveStatisticImpl
