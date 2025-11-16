/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.CatcherStatistic;
import org.bpy.score.reports.gamereports.DefensiveStatistic;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.OffensiveStatistic;
import org.bpy.score.reports.gamereports.PitcherStatistic;
import org.bpy.score.reports.gamereports.Player;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayerImpl#getPitcherStatistic <em>Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayerImpl#getDefensiveStatistic <em>Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayerImpl#getCatchersStatistic <em>Catchers Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayerImpl#getOffensiveStatistic <em>Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayerImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlayerImpl extends MinimalEObjectImpl.Container implements Player {
	/**
	 * The cached value of the '{@link #getPitcherStatistic() <em>Pitcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected PitcherStatistic pitcherStatistic;

	/**
	 * The cached value of the '{@link #getDefensiveStatistic() <em>Defensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected DefensiveStatistic defensiveStatistic;

	/**
	 * The cached value of the '{@link #getCatchersStatistic() <em>Catchers Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchersStatistic()
	 * @generated
	 * @ordered
	 */
	protected CatcherStatistic catchersStatistic;

	/**
	 * The cached value of the '{@link #getOffensiveStatistic() <em>Offensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected OffensiveStatistic offensiveStatistic;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistic getPitcherStatistic() {
		return pitcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPitcherStatistic(PitcherStatistic newPitcherStatistic, NotificationChain msgs) {
		PitcherStatistic oldPitcherStatistic = pitcherStatistic;
		pitcherStatistic = newPitcherStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__PITCHER_STATISTIC, oldPitcherStatistic, newPitcherStatistic);
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
	public void setPitcherStatistic(PitcherStatistic newPitcherStatistic) {
		if (newPitcherStatistic != pitcherStatistic) {
			NotificationChain msgs = null;
			if (pitcherStatistic != null)
				msgs = ((InternalEObject)pitcherStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__PITCHER_STATISTIC, null, msgs);
			if (newPitcherStatistic != null)
				msgs = ((InternalEObject)newPitcherStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__PITCHER_STATISTIC, null, msgs);
			msgs = basicSetPitcherStatistic(newPitcherStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__PITCHER_STATISTIC, newPitcherStatistic, newPitcherStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistic getDefensiveStatistic() {
		return defensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefensiveStatistic(DefensiveStatistic newDefensiveStatistic, NotificationChain msgs) {
		DefensiveStatistic oldDefensiveStatistic = defensiveStatistic;
		defensiveStatistic = newDefensiveStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC, oldDefensiveStatistic, newDefensiveStatistic);
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
	public void setDefensiveStatistic(DefensiveStatistic newDefensiveStatistic) {
		if (newDefensiveStatistic != defensiveStatistic) {
			NotificationChain msgs = null;
			if (defensiveStatistic != null)
				msgs = ((InternalEObject)defensiveStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC, null, msgs);
			if (newDefensiveStatistic != null)
				msgs = ((InternalEObject)newDefensiveStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC, null, msgs);
			msgs = basicSetDefensiveStatistic(newDefensiveStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC, newDefensiveStatistic, newDefensiveStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatcherStatistic getCatchersStatistic() {
		return catchersStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCatchersStatistic(CatcherStatistic newCatchersStatistic, NotificationChain msgs) {
		CatcherStatistic oldCatchersStatistic = catchersStatistic;
		catchersStatistic = newCatchersStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__CATCHERS_STATISTIC, oldCatchersStatistic, newCatchersStatistic);
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
	public void setCatchersStatistic(CatcherStatistic newCatchersStatistic) {
		if (newCatchersStatistic != catchersStatistic) {
			NotificationChain msgs = null;
			if (catchersStatistic != null)
				msgs = ((InternalEObject)catchersStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__CATCHERS_STATISTIC, null, msgs);
			if (newCatchersStatistic != null)
				msgs = ((InternalEObject)newCatchersStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__CATCHERS_STATISTIC, null, msgs);
			msgs = basicSetCatchersStatistic(newCatchersStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__CATCHERS_STATISTIC, newCatchersStatistic, newCatchersStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistic getOffensiveStatistic() {
		return offensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOffensiveStatistic(OffensiveStatistic newOffensiveStatistic, NotificationChain msgs) {
		OffensiveStatistic oldOffensiveStatistic = offensiveStatistic;
		offensiveStatistic = newOffensiveStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC, oldOffensiveStatistic, newOffensiveStatistic);
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
	public void setOffensiveStatistic(OffensiveStatistic newOffensiveStatistic) {
		if (newOffensiveStatistic != offensiveStatistic) {
			NotificationChain msgs = null;
			if (offensiveStatistic != null)
				msgs = ((InternalEObject)offensiveStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC, null, msgs);
			if (newOffensiveStatistic != null)
				msgs = ((InternalEObject)newOffensiveStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC, null, msgs);
			msgs = basicSetOffensiveStatistic(newOffensiveStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC, newOffensiveStatistic, newOffensiveStatistic));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.PLAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.PLAYER__PITCHER_STATISTIC:
				return basicSetPitcherStatistic(null, msgs);
			case GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC:
				return basicSetDefensiveStatistic(null, msgs);
			case GameReportsPackage.PLAYER__CATCHERS_STATISTIC:
				return basicSetCatchersStatistic(null, msgs);
			case GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC:
				return basicSetOffensiveStatistic(null, msgs);
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
			case GameReportsPackage.PLAYER__PITCHER_STATISTIC:
				return getPitcherStatistic();
			case GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC:
				return getDefensiveStatistic();
			case GameReportsPackage.PLAYER__CATCHERS_STATISTIC:
				return getCatchersStatistic();
			case GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC:
				return getOffensiveStatistic();
			case GameReportsPackage.PLAYER__NAME:
				return getName();
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
			case GameReportsPackage.PLAYER__PITCHER_STATISTIC:
				setPitcherStatistic((PitcherStatistic)newValue);
				return;
			case GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC:
				setDefensiveStatistic((DefensiveStatistic)newValue);
				return;
			case GameReportsPackage.PLAYER__CATCHERS_STATISTIC:
				setCatchersStatistic((CatcherStatistic)newValue);
				return;
			case GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC:
				setOffensiveStatistic((OffensiveStatistic)newValue);
				return;
			case GameReportsPackage.PLAYER__NAME:
				setName((String)newValue);
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
			case GameReportsPackage.PLAYER__PITCHER_STATISTIC:
				setPitcherStatistic((PitcherStatistic)null);
				return;
			case GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC:
				setDefensiveStatistic((DefensiveStatistic)null);
				return;
			case GameReportsPackage.PLAYER__CATCHERS_STATISTIC:
				setCatchersStatistic((CatcherStatistic)null);
				return;
			case GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC:
				setOffensiveStatistic((OffensiveStatistic)null);
				return;
			case GameReportsPackage.PLAYER__NAME:
				setName(NAME_EDEFAULT);
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
			case GameReportsPackage.PLAYER__PITCHER_STATISTIC:
				return pitcherStatistic != null;
			case GameReportsPackage.PLAYER__DEFENSIVE_STATISTIC:
				return defensiveStatistic != null;
			case GameReportsPackage.PLAYER__CATCHERS_STATISTIC:
				return catchersStatistic != null;
			case GameReportsPackage.PLAYER__OFFENSIVE_STATISTIC:
				return offensiveStatistic != null;
			case GameReportsPackage.PLAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //PlayerImpl
