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
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getPutouts <em>Putouts</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getAssists <em>Assists</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.DefensiveStatisticsImpl#getErrors <em>Errors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefensiveStatisticsImpl extends MinimalEObjectImpl.Container implements DefensiveStatistics {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				return getPutouts();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				return getAssists();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				return getErrors();
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				setPutouts((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				setAssists((Integer)newValue);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				setErrors((Integer)newValue);
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				setPutouts(PUTOUTS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				setAssists(ASSISTS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				setErrors(ERRORS_EDEFAULT);
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
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__PUTOUTS:
				return putouts != PUTOUTS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ASSISTS:
				return assists != ASSISTS_EDEFAULT;
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS__ERRORS:
				return errors != ERRORS_EDEFAULT;
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
		result.append(" (putouts: ");
		result.append(putouts);
		result.append(", assists: ");
		result.append(assists);
		result.append(", errors: ");
		result.append(errors);
		result.append(')');
		return result.toString();
	}

} //DefensiveStatisticsImpl
