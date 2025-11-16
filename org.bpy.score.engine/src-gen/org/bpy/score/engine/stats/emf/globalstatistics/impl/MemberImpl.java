/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.Member;
import org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl#getPitcherStatistics <em>Pitcher Statistics</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl#getOffensiveStatistics <em>Offensive Statistics</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.MemberImpl#getDefensiveStatistics <em>Defensive Statistics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberImpl extends MinimalEObjectImpl.Container implements Member {
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
	 * The cached value of the '{@link #getPitcherStatistics() <em>Pitcher Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitcherStatistics()
	 * @generated
	 * @ordered
	 */
	protected PitcherStatistics pitcherStatistics;

	/**
	 * The cached value of the '{@link #getOffensiveStatistics() <em>Offensive Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensiveStatistics()
	 * @generated
	 * @ordered
	 */
	protected OffensiveStatistics offensiveStatistics;

	/**
	 * The cached value of the '{@link #getDefensiveStatistics() <em>Defensive Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensiveStatistics()
	 * @generated
	 * @ordered
	 */
	protected DefensiveStatistics defensiveStatistics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.MEMBER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistics getPitcherStatistics() {
		return pitcherStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPitcherStatistics(PitcherStatistics newPitcherStatistics, NotificationChain msgs) {
		PitcherStatistics oldPitcherStatistics = pitcherStatistics;
		pitcherStatistics = newPitcherStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS, oldPitcherStatistics, newPitcherStatistics);
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
	public void setPitcherStatistics(PitcherStatistics newPitcherStatistics) {
		if (newPitcherStatistics != pitcherStatistics) {
			NotificationChain msgs = null;
			if (pitcherStatistics != null)
				msgs = ((InternalEObject)pitcherStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS, null, msgs);
			if (newPitcherStatistics != null)
				msgs = ((InternalEObject)newPitcherStatistics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS, null, msgs);
			msgs = basicSetPitcherStatistics(newPitcherStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS, newPitcherStatistics, newPitcherStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistics getOffensiveStatistics() {
		return offensiveStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOffensiveStatistics(OffensiveStatistics newOffensiveStatistics, NotificationChain msgs) {
		OffensiveStatistics oldOffensiveStatistics = offensiveStatistics;
		offensiveStatistics = newOffensiveStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS, oldOffensiveStatistics, newOffensiveStatistics);
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
	public void setOffensiveStatistics(OffensiveStatistics newOffensiveStatistics) {
		if (newOffensiveStatistics != offensiveStatistics) {
			NotificationChain msgs = null;
			if (offensiveStatistics != null)
				msgs = ((InternalEObject)offensiveStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS, null, msgs);
			if (newOffensiveStatistics != null)
				msgs = ((InternalEObject)newOffensiveStatistics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS, null, msgs);
			msgs = basicSetOffensiveStatistics(newOffensiveStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS, newOffensiveStatistics, newOffensiveStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistics getDefensiveStatistics() {
		return defensiveStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefensiveStatistics(DefensiveStatistics newDefensiveStatistics, NotificationChain msgs) {
		DefensiveStatistics oldDefensiveStatistics = defensiveStatistics;
		defensiveStatistics = newDefensiveStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS, oldDefensiveStatistics, newDefensiveStatistics);
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
	public void setDefensiveStatistics(DefensiveStatistics newDefensiveStatistics) {
		if (newDefensiveStatistics != defensiveStatistics) {
			NotificationChain msgs = null;
			if (defensiveStatistics != null)
				msgs = ((InternalEObject)defensiveStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS, null, msgs);
			if (newDefensiveStatistics != null)
				msgs = ((InternalEObject)newDefensiveStatistics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS, null, msgs);
			msgs = basicSetDefensiveStatistics(newDefensiveStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS, newDefensiveStatistics, newDefensiveStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS:
				return basicSetPitcherStatistics(null, msgs);
			case GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS:
				return basicSetOffensiveStatistics(null, msgs);
			case GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS:
				return basicSetDefensiveStatistics(null, msgs);
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
			case GlobalStatisticsPackage.MEMBER__NAME:
				return getName();
			case GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS:
				return getPitcherStatistics();
			case GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS:
				return getOffensiveStatistics();
			case GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS:
				return getDefensiveStatistics();
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
			case GlobalStatisticsPackage.MEMBER__NAME:
				setName((String)newValue);
				return;
			case GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS:
				setPitcherStatistics((PitcherStatistics)newValue);
				return;
			case GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS:
				setOffensiveStatistics((OffensiveStatistics)newValue);
				return;
			case GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS:
				setDefensiveStatistics((DefensiveStatistics)newValue);
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
			case GlobalStatisticsPackage.MEMBER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS:
				setPitcherStatistics((PitcherStatistics)null);
				return;
			case GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS:
				setOffensiveStatistics((OffensiveStatistics)null);
				return;
			case GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS:
				setDefensiveStatistics((DefensiveStatistics)null);
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
			case GlobalStatisticsPackage.MEMBER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GlobalStatisticsPackage.MEMBER__PITCHER_STATISTICS:
				return pitcherStatistics != null;
			case GlobalStatisticsPackage.MEMBER__OFFENSIVE_STATISTICS:
				return offensiveStatistics != null;
			case GlobalStatisticsPackage.MEMBER__DEFENSIVE_STATISTICS:
				return defensiveStatistics != null;
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

} //MemberImpl
