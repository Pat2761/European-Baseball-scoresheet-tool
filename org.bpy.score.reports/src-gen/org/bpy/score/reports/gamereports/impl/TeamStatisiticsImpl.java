/**
 */
package org.bpy.score.reports.gamereports.impl;

import java.util.Collection;

import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.Player;
import org.bpy.score.reports.gamereports.TeamStatisitics;

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
 * An implementation of the model object '<em><b>Team Statisitics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl#getTeamName <em>Team Name</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl#getTown <em>Town</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.TeamStatisiticsImpl#getGameLose <em>Game Lose</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TeamStatisiticsImpl extends MinimalEObjectImpl.Container implements TeamStatisitics {
	/**
	 * The cached value of the '{@link #getPlayers() <em>Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Player> players;

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
	 * The default value of the '{@link #getTown() <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTown()
	 * @generated
	 * @ordered
	 */
	protected static final String TOWN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTown() <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTown()
	 * @generated
	 * @ordered
	 */
	protected String town = TOWN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGameWin() <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameWin()
	 * @generated
	 * @ordered
	 */
	protected static final int GAME_WIN_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGameWin() <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameWin()
	 * @generated
	 * @ordered
	 */
	protected int gameWin = GAME_WIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGameLose() <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameLose()
	 * @generated
	 * @ordered
	 */
	protected static final int GAME_LOSE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGameLose() <em>Game Lose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameLose()
	 * @generated
	 * @ordered
	 */
	protected int gameLose = GAME_LOSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamStatisiticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.TEAM_STATISITICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Player> getPlayers() {
		if (players == null) {
			players = new EObjectContainmentEList<Player>(Player.class, this, GameReportsPackage.TEAM_STATISITICS__PLAYERS);
		}
		return players;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.TEAM_STATISITICS__TEAM_NAME, oldTeamName, teamName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTown() {
		return town;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTown(String newTown) {
		String oldTown = town;
		town = newTown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.TEAM_STATISITICS__TOWN, oldTown, town));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGameWin() {
		return gameWin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGameWin(int newGameWin) {
		int oldGameWin = gameWin;
		gameWin = newGameWin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.TEAM_STATISITICS__GAME_WIN, oldGameWin, gameWin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGameLose() {
		return gameLose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGameLose(int newGameLose) {
		int oldGameLose = gameLose;
		gameLose = newGameLose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.TEAM_STATISITICS__GAME_LOSE, oldGameLose, gameLose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.TEAM_STATISITICS__PLAYERS:
				return ((InternalEList<?>)getPlayers()).basicRemove(otherEnd, msgs);
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
			case GameReportsPackage.TEAM_STATISITICS__PLAYERS:
				return getPlayers();
			case GameReportsPackage.TEAM_STATISITICS__TEAM_NAME:
				return getTeamName();
			case GameReportsPackage.TEAM_STATISITICS__TOWN:
				return getTown();
			case GameReportsPackage.TEAM_STATISITICS__GAME_WIN:
				return getGameWin();
			case GameReportsPackage.TEAM_STATISITICS__GAME_LOSE:
				return getGameLose();
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
			case GameReportsPackage.TEAM_STATISITICS__PLAYERS:
				getPlayers().clear();
				getPlayers().addAll((Collection<? extends Player>)newValue);
				return;
			case GameReportsPackage.TEAM_STATISITICS__TEAM_NAME:
				setTeamName((String)newValue);
				return;
			case GameReportsPackage.TEAM_STATISITICS__TOWN:
				setTown((String)newValue);
				return;
			case GameReportsPackage.TEAM_STATISITICS__GAME_WIN:
				setGameWin((Integer)newValue);
				return;
			case GameReportsPackage.TEAM_STATISITICS__GAME_LOSE:
				setGameLose((Integer)newValue);
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
			case GameReportsPackage.TEAM_STATISITICS__PLAYERS:
				getPlayers().clear();
				return;
			case GameReportsPackage.TEAM_STATISITICS__TEAM_NAME:
				setTeamName(TEAM_NAME_EDEFAULT);
				return;
			case GameReportsPackage.TEAM_STATISITICS__TOWN:
				setTown(TOWN_EDEFAULT);
				return;
			case GameReportsPackage.TEAM_STATISITICS__GAME_WIN:
				setGameWin(GAME_WIN_EDEFAULT);
				return;
			case GameReportsPackage.TEAM_STATISITICS__GAME_LOSE:
				setGameLose(GAME_LOSE_EDEFAULT);
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
			case GameReportsPackage.TEAM_STATISITICS__PLAYERS:
				return players != null && !players.isEmpty();
			case GameReportsPackage.TEAM_STATISITICS__TEAM_NAME:
				return TEAM_NAME_EDEFAULT == null ? teamName != null : !TEAM_NAME_EDEFAULT.equals(teamName);
			case GameReportsPackage.TEAM_STATISITICS__TOWN:
				return TOWN_EDEFAULT == null ? town != null : !TOWN_EDEFAULT.equals(town);
			case GameReportsPackage.TEAM_STATISITICS__GAME_WIN:
				return gameWin != GAME_WIN_EDEFAULT;
			case GameReportsPackage.TEAM_STATISITICS__GAME_LOSE:
				return gameLose != GAME_LOSE_EDEFAULT;
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
		result.append(", town: ");
		result.append(town);
		result.append(", gameWin: ");
		result.append(gameWin);
		result.append(", gameLose: ");
		result.append(gameLose);
		result.append(')');
		return result.toString();
	}

} //TeamStatisiticsImpl
