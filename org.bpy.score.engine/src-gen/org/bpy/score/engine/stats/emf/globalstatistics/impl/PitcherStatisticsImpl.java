/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pitcher Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl#getGameWin <em>Game Win</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl#getGameLose <em>Game Lose</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl#getGameSave <em>Game Save</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl#getEarnedRuns <em>Earned Runs</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.PitcherStatisticsImpl#getIps <em>Ips</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PitcherStatisticsImpl extends MinimalEObjectImpl.Container implements PitcherStatistics {
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
	 * The default value of the '{@link #getGameSave() <em>Game Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameSave()
	 * @generated
	 * @ordered
	 */
	protected static final int GAME_SAVE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getGameSave() <em>Game Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameSave()
	 * @generated
	 * @ordered
	 */
	protected int gameSave = GAME_SAVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEarnedRuns() <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int EARNED_RUNS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getEarnedRuns() <em>Earned Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedRuns()
	 * @generated
	 * @ordered
	 */
	protected int earnedRuns = EARNED_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIps() <em>Ips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIps()
	 * @generated
	 * @ordered
	 */
	protected static final int IPS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getIps() <em>Ips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIps()
	 * @generated
	 * @ordered
	 */
	protected int ips = IPS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PitcherStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.PITCHER_STATISTICS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_WIN, oldGameWin, gameWin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_LOSE, oldGameLose, gameLose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getGameSave() {
		return gameSave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGameSave(int newGameSave) {
		int oldGameSave = gameSave;
		gameSave = newGameSave;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_SAVE, oldGameSave, gameSave));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEarnedRuns() {
		return earnedRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarnedRuns(int newEarnedRuns) {
		int oldEarnedRuns = earnedRuns;
		earnedRuns = newEarnedRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.PITCHER_STATISTICS__EARNED_RUNS, oldEarnedRuns, earnedRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIps() {
		return ips;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIps(int newIps) {
		int oldIps = ips;
		ips = newIps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.PITCHER_STATISTICS__IPS, oldIps, ips));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_WIN:
				return getGameWin();
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_LOSE:
				return getGameLose();
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_SAVE:
				return getGameSave();
			case GlobalStatisticsPackage.PITCHER_STATISTICS__EARNED_RUNS:
				return getEarnedRuns();
			case GlobalStatisticsPackage.PITCHER_STATISTICS__IPS:
				return getIps();
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
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_WIN:
				setGameWin((Integer)newValue);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_LOSE:
				setGameLose((Integer)newValue);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_SAVE:
				setGameSave((Integer)newValue);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__EARNED_RUNS:
				setEarnedRuns((Integer)newValue);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__IPS:
				setIps((Integer)newValue);
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
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_WIN:
				setGameWin(GAME_WIN_EDEFAULT);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_LOSE:
				setGameLose(GAME_LOSE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_SAVE:
				setGameSave(GAME_SAVE_EDEFAULT);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__EARNED_RUNS:
				setEarnedRuns(EARNED_RUNS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__IPS:
				setIps(IPS_EDEFAULT);
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
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_WIN:
				return gameWin != GAME_WIN_EDEFAULT;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_LOSE:
				return gameLose != GAME_LOSE_EDEFAULT;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__GAME_SAVE:
				return gameSave != GAME_SAVE_EDEFAULT;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__EARNED_RUNS:
				return earnedRuns != EARNED_RUNS_EDEFAULT;
			case GlobalStatisticsPackage.PITCHER_STATISTICS__IPS:
				return ips != IPS_EDEFAULT;
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
		result.append(" (gameWin: ");
		result.append(gameWin);
		result.append(", gameLose: ");
		result.append(gameLose);
		result.append(", gameSave: ");
		result.append(gameSave);
		result.append(", earnedRuns: ");
		result.append(earnedRuns);
		result.append(", ips: ");
		result.append(ips);
		result.append(')');
		return result.toString();
	}

} //PitcherStatisticsImpl
