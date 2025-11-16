/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.PointsPerInning;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Points Per Inning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PointsPerInningImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PointsPerInningImpl#getVisitorPoint <em>Visitor Point</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PointsPerInningImpl#getHometeamPoint <em>Hometeam Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointsPerInningImpl extends MinimalEObjectImpl.Container implements PointsPerInning {
	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisitorPoint() <em>Visitor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorPoint()
	 * @generated
	 * @ordered
	 */
	protected static final int VISITOR_POINT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getVisitorPoint() <em>Visitor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorPoint()
	 * @generated
	 * @ordered
	 */
	protected int visitorPoint = VISITOR_POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHometeamPoint() <em>Hometeam Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamPoint()
	 * @generated
	 * @ordered
	 */
	protected static final int HOMETEAM_POINT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHometeamPoint() <em>Hometeam Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamPoint()
	 * @generated
	 * @ordered
	 */
	protected int hometeamPoint = HOMETEAM_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointsPerInningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.POINTS_PER_INNING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.POINTS_PER_INNING__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVisitorPoint() {
		return visitorPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitorPoint(int newVisitorPoint) {
		int oldVisitorPoint = visitorPoint;
		visitorPoint = newVisitorPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.POINTS_PER_INNING__VISITOR_POINT, oldVisitorPoint, visitorPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHometeamPoint() {
		return hometeamPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHometeamPoint(int newHometeamPoint) {
		int oldHometeamPoint = hometeamPoint;
		hometeamPoint = newHometeamPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.POINTS_PER_INNING__HOMETEAM_POINT, oldHometeamPoint, hometeamPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GameReportsPackage.POINTS_PER_INNING__ORDER:
				return getOrder();
			case GameReportsPackage.POINTS_PER_INNING__VISITOR_POINT:
				return getVisitorPoint();
			case GameReportsPackage.POINTS_PER_INNING__HOMETEAM_POINT:
				return getHometeamPoint();
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
			case GameReportsPackage.POINTS_PER_INNING__ORDER:
				setOrder((Integer)newValue);
				return;
			case GameReportsPackage.POINTS_PER_INNING__VISITOR_POINT:
				setVisitorPoint((Integer)newValue);
				return;
			case GameReportsPackage.POINTS_PER_INNING__HOMETEAM_POINT:
				setHometeamPoint((Integer)newValue);
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
			case GameReportsPackage.POINTS_PER_INNING__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case GameReportsPackage.POINTS_PER_INNING__VISITOR_POINT:
				setVisitorPoint(VISITOR_POINT_EDEFAULT);
				return;
			case GameReportsPackage.POINTS_PER_INNING__HOMETEAM_POINT:
				setHometeamPoint(HOMETEAM_POINT_EDEFAULT);
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
			case GameReportsPackage.POINTS_PER_INNING__ORDER:
				return order != ORDER_EDEFAULT;
			case GameReportsPackage.POINTS_PER_INNING__VISITOR_POINT:
				return visitorPoint != VISITOR_POINT_EDEFAULT;
			case GameReportsPackage.POINTS_PER_INNING__HOMETEAM_POINT:
				return hometeamPoint != HOMETEAM_POINT_EDEFAULT;
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
		result.append(" (order: ");
		result.append(order);
		result.append(", visitorPoint: ");
		result.append(visitorPoint);
		result.append(", hometeamPoint: ");
		result.append(hometeamPoint);
		result.append(')');
		return result.toString();
	}

} //PointsPerInningImpl
