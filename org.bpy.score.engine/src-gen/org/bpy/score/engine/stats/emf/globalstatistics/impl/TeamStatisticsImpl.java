/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import java.util.Collection;

import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.Member;
import org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics;

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
 * An implementation of the model object '<em><b>Team Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getCity <em>City</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getGamePlayed <em>Game Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getGameLose <em>Game Lose</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.TeamStatisticsImpl#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TeamStatisticsImpl extends MinimalEObjectImpl.Container implements TeamStatistics {
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
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGamePlayed() <em>Game Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGamePlayed()
	 * @generated
	 * @ordered
	 */
	protected static final int GAME_PLAYED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGamePlayed() <em>Game Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGamePlayed()
	 * @generated
	 * @ordered
	 */
	protected int gamePlayed = GAME_PLAYED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGameWin() <em>Game Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameWin()
	 * @generated
	 * @ordered
	 */
	protected static final int GAME_WIN_EDEFAULT = 0;

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
	protected static final int GAME_LOSE_EDEFAULT = 0;

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
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<Member> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.TEAM_STATISTICS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.TEAM_STATISTICS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.TEAM_STATISTICS__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGamePlayed() {
		return gamePlayed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGamePlayed(int newGamePlayed) {
		int oldGamePlayed = gamePlayed;
		gamePlayed = newGamePlayed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.TEAM_STATISTICS__GAME_PLAYED, oldGamePlayed, gamePlayed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.TEAM_STATISTICS__GAME_WIN, oldGameWin, gameWin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.TEAM_STATISTICS__GAME_LOSE, oldGameLose, gameLose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Member> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<Member>(Member.class, this, GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case GlobalStatisticsPackage.TEAM_STATISTICS__NAME:
				return getName();
			case GlobalStatisticsPackage.TEAM_STATISTICS__CITY:
				return getCity();
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_PLAYED:
				return getGamePlayed();
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_WIN:
				return getGameWin();
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_LOSE:
				return getGameLose();
			case GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS:
				return getMembers();
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
			case GlobalStatisticsPackage.TEAM_STATISTICS__NAME:
				setName((String)newValue);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__CITY:
				setCity((String)newValue);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_PLAYED:
				setGamePlayed((Integer)newValue);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_WIN:
				setGameWin((Integer)newValue);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_LOSE:
				setGameLose((Integer)newValue);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Member>)newValue);
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
			case GlobalStatisticsPackage.TEAM_STATISTICS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_PLAYED:
				setGamePlayed(GAME_PLAYED_EDEFAULT);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_WIN:
				setGameWin(GAME_WIN_EDEFAULT);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_LOSE:
				setGameLose(GAME_LOSE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS:
				getMembers().clear();
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
			case GlobalStatisticsPackage.TEAM_STATISTICS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GlobalStatisticsPackage.TEAM_STATISTICS__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_PLAYED:
				return gamePlayed != GAME_PLAYED_EDEFAULT;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_WIN:
				return gameWin != GAME_WIN_EDEFAULT;
			case GlobalStatisticsPackage.TEAM_STATISTICS__GAME_LOSE:
				return gameLose != GAME_LOSE_EDEFAULT;
			case GlobalStatisticsPackage.TEAM_STATISTICS__MEMBERS:
				return members != null && !members.isEmpty();
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
		result.append(", city: ");
		result.append(city);
		result.append(", gamePlayed: ");
		result.append(gamePlayed);
		result.append(", gameWin: ");
		result.append(gameWin);
		result.append(", gameLose: ");
		result.append(gameLose);
		result.append(')');
		return result.toString();
	}

} //TeamStatisticsImpl
