/**
 */
package org.bpy.score.reports.gamereports.impl;

import java.util.Collection;

import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.LineupPlayer;
import org.bpy.score.reports.gamereports.StartingLineup;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Starting Lineup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.StartingLineupImpl#getTeamName <em>Team Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.StartingLineupImpl#getLineupPlayers <em>Lineup Players</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.StartingLineupImpl#getFieldPictrureLink <em>Field Pictrure Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartingLineupImpl extends MinimalEObjectImpl.Container implements StartingLineup {
	/**
	 * The default value of the '{@link #getTeamName() <em>Team Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeamName()
	 * @generated
	 * @ordered
	 */
	protected static final String TEAM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTeamName() <em>Team Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeamName()
	 * @generated
	 * @ordered
	 */
	protected String teamName = TEAM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLineupPlayers() <em>Lineup Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineupPlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<LineupPlayer> lineupPlayers;

	/**
	 * The default value of the '{@link #getFieldPictrureLink() <em>Field Pictrure Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldPictrureLink()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_PICTRURE_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldPictrureLink() <em>Field Pictrure Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldPictrureLink()
	 * @generated
	 * @ordered
	 */
	protected String fieldPictrureLink = FIELD_PICTRURE_LINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartingLineupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.STARTING_LINEUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTeamName() {
		return teamName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTeamName(String newTeamName) {
		String oldTeamName = teamName;
		teamName = newTeamName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.STARTING_LINEUP__TEAM_NAME, oldTeamName, teamName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LineupPlayer> getLineupPlayers() {
		if (lineupPlayers == null) {
			lineupPlayers = new EObjectContainmentEList<LineupPlayer>(LineupPlayer.class, this, GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS);
		}
		return lineupPlayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFieldPictrureLink() {
		return fieldPictrureLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldPictrureLink(String newFieldPictrureLink) {
		String oldFieldPictrureLink = fieldPictrureLink;
		fieldPictrureLink = newFieldPictrureLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.STARTING_LINEUP__FIELD_PICTRURE_LINK, oldFieldPictrureLink, fieldPictrureLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS:
				return ((InternalEList<?>)getLineupPlayers()).basicRemove(otherEnd, msgs);
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
			case GameReportsPackage.STARTING_LINEUP__TEAM_NAME:
				return getTeamName();
			case GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS:
				return getLineupPlayers();
			case GameReportsPackage.STARTING_LINEUP__FIELD_PICTRURE_LINK:
				return getFieldPictrureLink();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GameReportsPackage.STARTING_LINEUP__TEAM_NAME:
				setTeamName((String)newValue);
				return;
			case GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS:
				getLineupPlayers().clear();
				getLineupPlayers().addAll((Collection<? extends LineupPlayer>)newValue);
				return;
			case GameReportsPackage.STARTING_LINEUP__FIELD_PICTRURE_LINK:
				setFieldPictrureLink((String)newValue);
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
			case GameReportsPackage.STARTING_LINEUP__TEAM_NAME:
				setTeamName(TEAM_NAME_EDEFAULT);
				return;
			case GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS:
				getLineupPlayers().clear();
				return;
			case GameReportsPackage.STARTING_LINEUP__FIELD_PICTRURE_LINK:
				setFieldPictrureLink(FIELD_PICTRURE_LINK_EDEFAULT);
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
			case GameReportsPackage.STARTING_LINEUP__TEAM_NAME:
				return TEAM_NAME_EDEFAULT == null ? teamName != null : !TEAM_NAME_EDEFAULT.equals(teamName);
			case GameReportsPackage.STARTING_LINEUP__LINEUP_PLAYERS:
				return lineupPlayers != null && !lineupPlayers.isEmpty();
			case GameReportsPackage.STARTING_LINEUP__FIELD_PICTRURE_LINK:
				return FIELD_PICTRURE_LINK_EDEFAULT == null ? fieldPictrureLink != null : !FIELD_PICTRURE_LINK_EDEFAULT.equals(fieldPictrureLink);
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
		result.append(" (teamName: ");
		result.append(teamName);
		result.append(", fieldPictrureLink: ");
		result.append(fieldPictrureLink);
		result.append(')');
		return result.toString();
	}

} //StartingLineupImpl
