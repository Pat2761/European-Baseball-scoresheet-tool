/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catcher Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl#getPassBall <em>Pass Ball</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.CatcherStatisticImpl#getCaughtStealing <em>Caught Stealing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CatcherStatisticImpl extends MinimalEObjectImpl.Container implements CatcherStatistic {
	/**
	 * The default value of the '{@link #getPassBall() <em>Pass Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassBall()
	 * @generated
	 * @ordered
	 */
	protected static final int PASS_BALL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPassBall() <em>Pass Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassBall()
	 * @generated
	 * @ordered
	 */
	protected int passBall = PASS_BALL_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CatcherStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.CATCHER_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPassBall() {
		return passBall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPassBall(int newPassBall) {
		int oldPassBall = passBall;
		passBall = newPassBall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.CATCHER_STATISTIC__PASS_BALL, oldPassBall, passBall));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.CATCHER_STATISTIC__STOLEN_BASE, oldStolenBase, stolenBase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.CATCHER_STATISTIC__CAUGHT_STEALING, oldCaughtStealing, caughtStealing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatisticPackage.CATCHER_STATISTIC__PASS_BALL:
				return getPassBall();
			case StatisticPackage.CATCHER_STATISTIC__STOLEN_BASE:
				return getStolenBase();
			case StatisticPackage.CATCHER_STATISTIC__CAUGHT_STEALING:
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
			case StatisticPackage.CATCHER_STATISTIC__PASS_BALL:
				setPassBall((Integer)newValue);
				return;
			case StatisticPackage.CATCHER_STATISTIC__STOLEN_BASE:
				setStolenBase((Integer)newValue);
				return;
			case StatisticPackage.CATCHER_STATISTIC__CAUGHT_STEALING:
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
			case StatisticPackage.CATCHER_STATISTIC__PASS_BALL:
				setPassBall(PASS_BALL_EDEFAULT);
				return;
			case StatisticPackage.CATCHER_STATISTIC__STOLEN_BASE:
				setStolenBase(STOLEN_BASE_EDEFAULT);
				return;
			case StatisticPackage.CATCHER_STATISTIC__CAUGHT_STEALING:
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
			case StatisticPackage.CATCHER_STATISTIC__PASS_BALL:
				return passBall != PASS_BALL_EDEFAULT;
			case StatisticPackage.CATCHER_STATISTIC__STOLEN_BASE:
				return stolenBase != STOLEN_BASE_EDEFAULT;
			case StatisticPackage.CATCHER_STATISTIC__CAUGHT_STEALING:
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
		result.append(" (passBall: ");
		result.append(passBall);
		result.append(", stolenBase: ");
		result.append(stolenBase);
		result.append(", caughtStealing: ");
		result.append(caughtStealing);
		result.append(')');
		return result.toString();
	}

} //CatcherStatisticImpl
