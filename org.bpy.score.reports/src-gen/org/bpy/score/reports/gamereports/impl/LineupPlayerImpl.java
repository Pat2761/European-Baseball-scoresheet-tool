/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.LineupPlayer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lineup Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.LineupPlayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.LineupPlayerImpl#getOffensivePosition <em>Offensive Position</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.LineupPlayerImpl#getDefensivePosition <em>Defensive Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LineupPlayerImpl extends MinimalEObjectImpl.Container implements LineupPlayer {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffensivePosition() <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensivePosition()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFENSIVE_POSITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffensivePosition() <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensivePosition()
	 * @generated
	 * @ordered
	 */
	protected int offensivePosition = OFFENSIVE_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefensivePosition() <em>Defensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensivePosition()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFENSIVE_POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefensivePosition() <em>Defensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensivePosition()
	 * @generated
	 * @ordered
	 */
	protected String defensivePosition = DEFENSIVE_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineupPlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.LINEUP_PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.LINEUP_PLAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffensivePosition() {
		return offensivePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffensivePosition(int newOffensivePosition) {
		int oldOffensivePosition = offensivePosition;
		offensivePosition = newOffensivePosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.LINEUP_PLAYER__OFFENSIVE_POSITION, oldOffensivePosition, offensivePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefensivePosition() {
		return defensivePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefensivePosition(String newDefensivePosition) {
		String oldDefensivePosition = defensivePosition;
		defensivePosition = newDefensivePosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.LINEUP_PLAYER__DEFENSIVE_POSITION, oldDefensivePosition, defensivePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GameReportsPackage.LINEUP_PLAYER__NAME:
				return getName();
			case GameReportsPackage.LINEUP_PLAYER__OFFENSIVE_POSITION:
				return getOffensivePosition();
			case GameReportsPackage.LINEUP_PLAYER__DEFENSIVE_POSITION:
				return getDefensivePosition();
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
			case GameReportsPackage.LINEUP_PLAYER__NAME:
				setName((String)newValue);
				return;
			case GameReportsPackage.LINEUP_PLAYER__OFFENSIVE_POSITION:
				setOffensivePosition((Integer)newValue);
				return;
			case GameReportsPackage.LINEUP_PLAYER__DEFENSIVE_POSITION:
				setDefensivePosition((String)newValue);
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
			case GameReportsPackage.LINEUP_PLAYER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GameReportsPackage.LINEUP_PLAYER__OFFENSIVE_POSITION:
				setOffensivePosition(OFFENSIVE_POSITION_EDEFAULT);
				return;
			case GameReportsPackage.LINEUP_PLAYER__DEFENSIVE_POSITION:
				setDefensivePosition(DEFENSIVE_POSITION_EDEFAULT);
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
			case GameReportsPackage.LINEUP_PLAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GameReportsPackage.LINEUP_PLAYER__OFFENSIVE_POSITION:
				return offensivePosition != OFFENSIVE_POSITION_EDEFAULT;
			case GameReportsPackage.LINEUP_PLAYER__DEFENSIVE_POSITION:
				return DEFENSIVE_POSITION_EDEFAULT == null ? defensivePosition != null : !DEFENSIVE_POSITION_EDEFAULT.equals(defensivePosition);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", offensivePosition: ");
		result.append(offensivePosition);
		result.append(", defensivePosition: ");
		result.append(defensivePosition);
		result.append(')');
		return result.toString();
	}

} //LineupPlayerImpl
