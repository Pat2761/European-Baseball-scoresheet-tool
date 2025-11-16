/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Innin Statictic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl#getInningStat <em>Inning Stat</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.InninStaticticImpl#getCumulativeInningStat <em>Cumulative Inning Stat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InninStaticticImpl extends MinimalEObjectImpl.Container implements InninStatictic {
	/**
	 * The cached value of the '{@link #getInningStat() <em>Inning Stat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInningStat()
	 * @generated
	 * @ordered
	 */
	protected InningGeneralStatistic inningStat;

	/**
	 * The cached value of the '{@link #getCumulativeInningStat() <em>Cumulative Inning Stat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCumulativeInningStat()
	 * @generated
	 * @ordered
	 */
	protected InningGeneralStatistic cumulativeInningStat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InninStaticticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.INNIN_STATICTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InningGeneralStatistic getInningStat() {
		return inningStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInningStat(InningGeneralStatistic newInningStat, NotificationChain msgs) {
		InningGeneralStatistic oldInningStat = inningStat;
		inningStat = newInningStat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.INNIN_STATICTIC__INNING_STAT, oldInningStat, newInningStat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInningStat(InningGeneralStatistic newInningStat) {
		if (newInningStat != inningStat) {
			NotificationChain msgs = null;
			if (inningStat != null)
				msgs = ((InternalEObject)inningStat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.INNIN_STATICTIC__INNING_STAT, null, msgs);
			if (newInningStat != null)
				msgs = ((InternalEObject)newInningStat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.INNIN_STATICTIC__INNING_STAT, null, msgs);
			msgs = basicSetInningStat(newInningStat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNIN_STATICTIC__INNING_STAT, newInningStat, newInningStat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InningGeneralStatistic getCumulativeInningStat() {
		return cumulativeInningStat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCumulativeInningStat(InningGeneralStatistic newCumulativeInningStat, NotificationChain msgs) {
		InningGeneralStatistic oldCumulativeInningStat = cumulativeInningStat;
		cumulativeInningStat = newCumulativeInningStat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT, oldCumulativeInningStat, newCumulativeInningStat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCumulativeInningStat(InningGeneralStatistic newCumulativeInningStat) {
		if (newCumulativeInningStat != cumulativeInningStat) {
			NotificationChain msgs = null;
			if (cumulativeInningStat != null)
				msgs = ((InternalEObject)cumulativeInningStat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT, null, msgs);
			if (newCumulativeInningStat != null)
				msgs = ((InternalEObject)newCumulativeInningStat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT, null, msgs);
			msgs = basicSetCumulativeInningStat(newCumulativeInningStat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT, newCumulativeInningStat, newCumulativeInningStat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatisticPackage.INNIN_STATICTIC__INNING_STAT:
				return basicSetInningStat(null, msgs);
			case StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT:
				return basicSetCumulativeInningStat(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatisticPackage.INNIN_STATICTIC__INNING_STAT:
				return getInningStat();
			case StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT:
				return getCumulativeInningStat();
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
			case StatisticPackage.INNIN_STATICTIC__INNING_STAT:
				setInningStat((InningGeneralStatistic)newValue);
				return;
			case StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT:
				setCumulativeInningStat((InningGeneralStatistic)newValue);
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
			case StatisticPackage.INNIN_STATICTIC__INNING_STAT:
				setInningStat((InningGeneralStatistic)null);
				return;
			case StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT:
				setCumulativeInningStat((InningGeneralStatistic)null);
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
			case StatisticPackage.INNIN_STATICTIC__INNING_STAT:
				return inningStat != null;
			case StatisticPackage.INNIN_STATICTIC__CUMULATIVE_INNING_STAT:
				return cumulativeInningStat != null;
		}
		return super.eIsSet(featureID);
	}

} //InninStaticticImpl
