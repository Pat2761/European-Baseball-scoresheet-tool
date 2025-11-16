/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getGameName <em>Game Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getHometeam <em>Hometeam</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getVisitor <em>Visitor</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getWinningPitcher <em>Winning Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getLoosingPitcher <em>Loosing Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.GameStatisticImpl#getSavePitcher <em>Save Pitcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameStatisticImpl extends MinimalEObjectImpl.Container implements GameStatistic {
	/**
	 * The default value of the '{@link #getGameName() <em>Game Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameName()
	 * @generated
	 * @ordered
	 */
	protected static final String GAME_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGameName() <em>Game Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameName()
	 * @generated
	 * @ordered
	 */
	protected String gameName = GAME_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHometeam() <em>Hometeam</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeam()
	 * @generated
	 * @ordered
	 */
	protected TeamStatistic hometeam;

	/**
	 * The cached value of the '{@link #getVisitor() <em>Visitor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitor()
	 * @generated
	 * @ordered
	 */
	protected TeamStatistic visitor;

	/**
	 * The default value of the '{@link #getWinningPitcher() <em>Winning Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWinningPitcher()
	 * @generated
	 * @ordered
	 */
	protected static final LineupEntry WINNING_PITCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWinningPitcher() <em>Winning Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWinningPitcher()
	 * @generated
	 * @ordered
	 */
	protected LineupEntry winningPitcher = WINNING_PITCHER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLoosingPitcher() <em>Loosing Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoosingPitcher()
	 * @generated
	 * @ordered
	 */
	protected static final LineupEntry LOOSING_PITCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoosingPitcher() <em>Loosing Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoosingPitcher()
	 * @generated
	 * @ordered
	 */
	protected LineupEntry loosingPitcher = LOOSING_PITCHER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSavePitcher() <em>Save Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSavePitcher()
	 * @generated
	 * @ordered
	 */
	protected static final LineupEntry SAVE_PITCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSavePitcher() <em>Save Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSavePitcher()
	 * @generated
	 * @ordered
	 */
	protected LineupEntry savePitcher = SAVE_PITCHER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.GAME_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGameName() {
		return gameName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGameName(String newGameName) {
		String oldGameName = gameName;
		gameName = newGameName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__GAME_NAME, oldGameName, gameName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatistic getHometeam() {
		return hometeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHometeam(TeamStatistic newHometeam, NotificationChain msgs) {
		TeamStatistic oldHometeam = hometeam;
		hometeam = newHometeam;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__HOMETEAM, oldHometeam, newHometeam);
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
	public void setHometeam(TeamStatistic newHometeam) {
		if (newHometeam != hometeam) {
			NotificationChain msgs = null;
			if (hometeam != null)
				msgs = ((InternalEObject)hometeam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.GAME_STATISTIC__HOMETEAM, null, msgs);
			if (newHometeam != null)
				msgs = ((InternalEObject)newHometeam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.GAME_STATISTIC__HOMETEAM, null, msgs);
			msgs = basicSetHometeam(newHometeam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__HOMETEAM, newHometeam, newHometeam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatistic getVisitor() {
		return visitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisitor(TeamStatistic newVisitor, NotificationChain msgs) {
		TeamStatistic oldVisitor = visitor;
		visitor = newVisitor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__VISITOR, oldVisitor, newVisitor);
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
	public void setVisitor(TeamStatistic newVisitor) {
		if (newVisitor != visitor) {
			NotificationChain msgs = null;
			if (visitor != null)
				msgs = ((InternalEObject)visitor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.GAME_STATISTIC__VISITOR, null, msgs);
			if (newVisitor != null)
				msgs = ((InternalEObject)newVisitor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.GAME_STATISTIC__VISITOR, null, msgs);
			msgs = basicSetVisitor(newVisitor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__VISITOR, newVisitor, newVisitor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry getWinningPitcher() {
		return winningPitcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWinningPitcher(LineupEntry newWinningPitcher) {
		LineupEntry oldWinningPitcher = winningPitcher;
		winningPitcher = newWinningPitcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__WINNING_PITCHER, oldWinningPitcher, winningPitcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry getLoosingPitcher() {
		return loosingPitcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoosingPitcher(LineupEntry newLoosingPitcher) {
		LineupEntry oldLoosingPitcher = loosingPitcher;
		loosingPitcher = newLoosingPitcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__LOOSING_PITCHER, oldLoosingPitcher, loosingPitcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry getSavePitcher() {
		return savePitcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSavePitcher(LineupEntry newSavePitcher) {
		LineupEntry oldSavePitcher = savePitcher;
		savePitcher = newSavePitcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.GAME_STATISTIC__SAVE_PITCHER, oldSavePitcher, savePitcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatisticPackage.GAME_STATISTIC__HOMETEAM:
				return basicSetHometeam(null, msgs);
			case StatisticPackage.GAME_STATISTIC__VISITOR:
				return basicSetVisitor(null, msgs);
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
			case StatisticPackage.GAME_STATISTIC__GAME_NAME:
				return getGameName();
			case StatisticPackage.GAME_STATISTIC__HOMETEAM:
				return getHometeam();
			case StatisticPackage.GAME_STATISTIC__VISITOR:
				return getVisitor();
			case StatisticPackage.GAME_STATISTIC__WINNING_PITCHER:
				return getWinningPitcher();
			case StatisticPackage.GAME_STATISTIC__LOOSING_PITCHER:
				return getLoosingPitcher();
			case StatisticPackage.GAME_STATISTIC__SAVE_PITCHER:
				return getSavePitcher();
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
			case StatisticPackage.GAME_STATISTIC__GAME_NAME:
				setGameName((String)newValue);
				return;
			case StatisticPackage.GAME_STATISTIC__HOMETEAM:
				setHometeam((TeamStatistic)newValue);
				return;
			case StatisticPackage.GAME_STATISTIC__VISITOR:
				setVisitor((TeamStatistic)newValue);
				return;
			case StatisticPackage.GAME_STATISTIC__WINNING_PITCHER:
				setWinningPitcher((LineupEntry)newValue);
				return;
			case StatisticPackage.GAME_STATISTIC__LOOSING_PITCHER:
				setLoosingPitcher((LineupEntry)newValue);
				return;
			case StatisticPackage.GAME_STATISTIC__SAVE_PITCHER:
				setSavePitcher((LineupEntry)newValue);
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
			case StatisticPackage.GAME_STATISTIC__GAME_NAME:
				setGameName(GAME_NAME_EDEFAULT);
				return;
			case StatisticPackage.GAME_STATISTIC__HOMETEAM:
				setHometeam((TeamStatistic)null);
				return;
			case StatisticPackage.GAME_STATISTIC__VISITOR:
				setVisitor((TeamStatistic)null);
				return;
			case StatisticPackage.GAME_STATISTIC__WINNING_PITCHER:
				setWinningPitcher(WINNING_PITCHER_EDEFAULT);
				return;
			case StatisticPackage.GAME_STATISTIC__LOOSING_PITCHER:
				setLoosingPitcher(LOOSING_PITCHER_EDEFAULT);
				return;
			case StatisticPackage.GAME_STATISTIC__SAVE_PITCHER:
				setSavePitcher(SAVE_PITCHER_EDEFAULT);
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
			case StatisticPackage.GAME_STATISTIC__GAME_NAME:
				return GAME_NAME_EDEFAULT == null ? gameName != null : !GAME_NAME_EDEFAULT.equals(gameName);
			case StatisticPackage.GAME_STATISTIC__HOMETEAM:
				return hometeam != null;
			case StatisticPackage.GAME_STATISTIC__VISITOR:
				return visitor != null;
			case StatisticPackage.GAME_STATISTIC__WINNING_PITCHER:
				return WINNING_PITCHER_EDEFAULT == null ? winningPitcher != null : !WINNING_PITCHER_EDEFAULT.equals(winningPitcher);
			case StatisticPackage.GAME_STATISTIC__LOOSING_PITCHER:
				return LOOSING_PITCHER_EDEFAULT == null ? loosingPitcher != null : !LOOSING_PITCHER_EDEFAULT.equals(loosingPitcher);
			case StatisticPackage.GAME_STATISTIC__SAVE_PITCHER:
				return SAVE_PITCHER_EDEFAULT == null ? savePitcher != null : !SAVE_PITCHER_EDEFAULT.equals(savePitcher);
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
		result.append(" (gameName: ");
		result.append(gameName);
		result.append(", winningPitcher: ");
		result.append(winningPitcher);
		result.append(", loosingPitcher: ");
		result.append(loosingPitcher);
		result.append(", savePitcher: ");
		result.append(savePitcher);
		result.append(')');
		return result.toString();
	}

} //GameStatisticImpl
