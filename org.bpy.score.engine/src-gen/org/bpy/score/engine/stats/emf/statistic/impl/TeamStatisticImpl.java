/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import java.util.Collection;

import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Team Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getGeneralInningStats <em>General Inning Stats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getTotalCatcherStatistic <em>Total Catcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getTotalDefensiveStatistic <em>Total Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getTotalPitcherStatistic <em>Total Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getTotalOffensiveStatistic <em>Total Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getDoublePlayCounter <em>Double Play Counter</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getTieBreakCounter <em>Tie Break Counter</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getCurrentOffensivePlayer <em>Current Offensive Player</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getCurrentDefensivePlayer <em>Current Defensive Player</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getCurrentCatcher <em>Current Catcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getCurrentPitcher <em>Current Pitcher</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getCatchers <em>Catchers</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getPitchers <em>Pitchers</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getGwRbi <em>Gw Rbi</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getEarnedAgainstTheTeam <em>Earned Against The Team</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.TeamStatisticImpl#getFinalScore <em>Final Score</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TeamStatisticImpl extends MinimalEObjectImpl.Container implements TeamStatistic {
	/**
	 * The cached value of the '{@link #getGeneralInningStats() <em>General Inning Stats</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralInningStats()
	 * @generated
	 * @ordered
	 */
	protected EList<InninStatictic> generalInningStats;

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
	 * The cached value of the '{@link #getTotalCatcherStatistic() <em>Total Catcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalCatcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected CatcherStatistic totalCatcherStatistic;

	/**
	 * The cached value of the '{@link #getTotalDefensiveStatistic() <em>Total Defensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDefensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected DefensiveStatistic totalDefensiveStatistic;

	/**
	 * The cached value of the '{@link #getTotalPitcherStatistic() <em>Total Pitcher Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalPitcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected PitcherStatistic totalPitcherStatistic;

	/**
	 * The cached value of the '{@link #getTotalOffensiveStatistic() <em>Total Offensive Statistic</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalOffensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected OffensiveStatistic totalOffensiveStatistic;

	/**
	 * The default value of the '{@link #getDoublePlayCounter() <em>Double Play Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlayCounter()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLE_PLAY_COUNTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDoublePlayCounter() <em>Double Play Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoublePlayCounter()
	 * @generated
	 * @ordered
	 */
	protected int doublePlayCounter = DOUBLE_PLAY_COUNTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTieBreakCounter() <em>Tie Break Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTieBreakCounter()
	 * @generated
	 * @ordered
	 */
	protected static final int TIE_BREAK_COUNTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTieBreakCounter() <em>Tie Break Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTieBreakCounter()
	 * @generated
	 * @ordered
	 */
	protected int tieBreakCounter = TIE_BREAK_COUNTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCurrentOffensivePlayer() <em>Current Offensive Player</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentOffensivePlayer()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, LineupEntry> currentOffensivePlayer;

	/**
	 * The cached value of the '{@link #getCurrentDefensivePlayer() <em>Current Defensive Player</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDefensivePlayer()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, LineupEntry> currentDefensivePlayer;

	/**
	 * The default value of the '{@link #getCurrentCatcher() <em>Current Catcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentCatcher()
	 * @generated
	 * @ordered
	 */
	protected static final LineupEntry CURRENT_CATCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentCatcher() <em>Current Catcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentCatcher()
	 * @generated
	 * @ordered
	 */
	protected LineupEntry currentCatcher = CURRENT_CATCHER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentPitcher() <em>Current Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentPitcher()
	 * @generated
	 * @ordered
	 */
	protected static final LineupEntry CURRENT_PITCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentPitcher() <em>Current Pitcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentPitcher()
	 * @generated
	 * @ordered
	 */
	protected LineupEntry currentPitcher = CURRENT_PITCHER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCatchers() <em>Catchers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchers()
	 * @generated
	 * @ordered
	 */
	protected EList<LineupEntry> catchers;

	/**
	 * The cached value of the '{@link #getPitchers() <em>Pitchers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitchers()
	 * @generated
	 * @ordered
	 */
	protected EList<LineupEntry> pitchers;

	/**
	 * The cached value of the '{@link #getPlayers() <em>Players</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<LineupEntry> players;

	/**
	 * The default value of the '{@link #getGwRbi() <em>Gw Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwRbi()
	 * @generated
	 * @ordered
	 */
	protected static final String GW_RBI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGwRbi() <em>Gw Rbi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwRbi()
	 * @generated
	 * @ordered
	 */
	protected String gwRbi = GW_RBI_EDEFAULT;

	/**
	 * The default value of the '{@link #getEarnedAgainstTheTeam() <em>Earned Against The Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedAgainstTheTeam()
	 * @generated
	 * @ordered
	 */
	protected static final int EARNED_AGAINST_THE_TEAM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEarnedAgainstTheTeam() <em>Earned Against The Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEarnedAgainstTheTeam()
	 * @generated
	 * @ordered
	 */
	protected int earnedAgainstTheTeam = EARNED_AGAINST_THE_TEAM_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinalScore() <em>Final Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalScore()
	 * @generated
	 * @ordered
	 */
	protected static final int FINAL_SCORE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFinalScore() <em>Final Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalScore()
	 * @generated
	 * @ordered
	 */
	protected int finalScore = FINAL_SCORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.TEAM_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InninStatictic> getGeneralInningStats() {
		if (generalInningStats == null) {
			generalInningStats = new EObjectContainmentEList<InninStatictic>(InninStatictic.class, this, StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS);
		}
		return generalInningStats;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatcherStatistic getTotalCatcherStatistic() {
		return totalCatcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTotalCatcherStatistic(CatcherStatistic newTotalCatcherStatistic, NotificationChain msgs) {
		CatcherStatistic oldTotalCatcherStatistic = totalCatcherStatistic;
		totalCatcherStatistic = newTotalCatcherStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC, oldTotalCatcherStatistic, newTotalCatcherStatistic);
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
	public void setTotalCatcherStatistic(CatcherStatistic newTotalCatcherStatistic) {
		if (newTotalCatcherStatistic != totalCatcherStatistic) {
			NotificationChain msgs = null;
			if (totalCatcherStatistic != null)
				msgs = ((InternalEObject)totalCatcherStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC, null, msgs);
			if (newTotalCatcherStatistic != null)
				msgs = ((InternalEObject)newTotalCatcherStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC, null, msgs);
			msgs = basicSetTotalCatcherStatistic(newTotalCatcherStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC, newTotalCatcherStatistic, newTotalCatcherStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistic getTotalDefensiveStatistic() {
		return totalDefensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTotalDefensiveStatistic(DefensiveStatistic newTotalDefensiveStatistic, NotificationChain msgs) {
		DefensiveStatistic oldTotalDefensiveStatistic = totalDefensiveStatistic;
		totalDefensiveStatistic = newTotalDefensiveStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC, oldTotalDefensiveStatistic, newTotalDefensiveStatistic);
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
	public void setTotalDefensiveStatistic(DefensiveStatistic newTotalDefensiveStatistic) {
		if (newTotalDefensiveStatistic != totalDefensiveStatistic) {
			NotificationChain msgs = null;
			if (totalDefensiveStatistic != null)
				msgs = ((InternalEObject)totalDefensiveStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC, null, msgs);
			if (newTotalDefensiveStatistic != null)
				msgs = ((InternalEObject)newTotalDefensiveStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC, null, msgs);
			msgs = basicSetTotalDefensiveStatistic(newTotalDefensiveStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC, newTotalDefensiveStatistic, newTotalDefensiveStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistic getTotalPitcherStatistic() {
		return totalPitcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTotalPitcherStatistic(PitcherStatistic newTotalPitcherStatistic, NotificationChain msgs) {
		PitcherStatistic oldTotalPitcherStatistic = totalPitcherStatistic;
		totalPitcherStatistic = newTotalPitcherStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC, oldTotalPitcherStatistic, newTotalPitcherStatistic);
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
	public void setTotalPitcherStatistic(PitcherStatistic newTotalPitcherStatistic) {
		if (newTotalPitcherStatistic != totalPitcherStatistic) {
			NotificationChain msgs = null;
			if (totalPitcherStatistic != null)
				msgs = ((InternalEObject)totalPitcherStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC, null, msgs);
			if (newTotalPitcherStatistic != null)
				msgs = ((InternalEObject)newTotalPitcherStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC, null, msgs);
			msgs = basicSetTotalPitcherStatistic(newTotalPitcherStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC, newTotalPitcherStatistic, newTotalPitcherStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistic getTotalOffensiveStatistic() {
		return totalOffensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTotalOffensiveStatistic(OffensiveStatistic newTotalOffensiveStatistic, NotificationChain msgs) {
		OffensiveStatistic oldTotalOffensiveStatistic = totalOffensiveStatistic;
		totalOffensiveStatistic = newTotalOffensiveStatistic;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC, oldTotalOffensiveStatistic, newTotalOffensiveStatistic);
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
	public void setTotalOffensiveStatistic(OffensiveStatistic newTotalOffensiveStatistic) {
		if (newTotalOffensiveStatistic != totalOffensiveStatistic) {
			NotificationChain msgs = null;
			if (totalOffensiveStatistic != null)
				msgs = ((InternalEObject)totalOffensiveStatistic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC, null, msgs);
			if (newTotalOffensiveStatistic != null)
				msgs = ((InternalEObject)newTotalOffensiveStatistic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC, null, msgs);
			msgs = basicSetTotalOffensiveStatistic(newTotalOffensiveStatistic, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC, newTotalOffensiveStatistic, newTotalOffensiveStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDoublePlayCounter() {
		return doublePlayCounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDoublePlayCounter(int newDoublePlayCounter) {
		int oldDoublePlayCounter = doublePlayCounter;
		doublePlayCounter = newDoublePlayCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__DOUBLE_PLAY_COUNTER, oldDoublePlayCounter, doublePlayCounter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTieBreakCounter() {
		return tieBreakCounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTieBreakCounter(int newTieBreakCounter) {
		int oldTieBreakCounter = tieBreakCounter;
		tieBreakCounter = newTieBreakCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__TIE_BREAK_COUNTER, oldTieBreakCounter, tieBreakCounter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, LineupEntry> getCurrentOffensivePlayer() {
		if (currentOffensivePlayer == null) {
			currentOffensivePlayer = new EcoreEMap<String,LineupEntry>(StatisticPackage.Literals.ESTRING_TO_LINEUP_ENTRY_TYPE_MAP, EStringToLineupEntryTypeMapImpl.class, this, StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER);
		}
		return currentOffensivePlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, LineupEntry> getCurrentDefensivePlayer() {
		if (currentDefensivePlayer == null) {
			currentDefensivePlayer = new EcoreEMap<String,LineupEntry>(StatisticPackage.Literals.ESTRING_TO_LINEUP_ENTRY_TYPE_MAP, EStringToLineupEntryTypeMapImpl.class, this, StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER);
		}
		return currentDefensivePlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry getCurrentCatcher() {
		return currentCatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentCatcher(LineupEntry newCurrentCatcher) {
		LineupEntry oldCurrentCatcher = currentCatcher;
		currentCatcher = newCurrentCatcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__CURRENT_CATCHER, oldCurrentCatcher, currentCatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry getCurrentPitcher() {
		return currentPitcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentPitcher(LineupEntry newCurrentPitcher) {
		LineupEntry oldCurrentPitcher = currentPitcher;
		currentPitcher = newCurrentPitcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__CURRENT_PITCHER, oldCurrentPitcher, currentPitcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LineupEntry> getCatchers() {
		if (catchers == null) {
			catchers = new EDataTypeUniqueEList<LineupEntry>(LineupEntry.class, this, StatisticPackage.TEAM_STATISTIC__CATCHERS);
		}
		return catchers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LineupEntry> getPitchers() {
		if (pitchers == null) {
			pitchers = new EDataTypeUniqueEList<LineupEntry>(LineupEntry.class, this, StatisticPackage.TEAM_STATISTIC__PITCHERS);
		}
		return pitchers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LineupEntry> getPlayers() {
		if (players == null) {
			players = new EDataTypeUniqueEList<LineupEntry>(LineupEntry.class, this, StatisticPackage.TEAM_STATISTIC__PLAYERS);
		}
		return players;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGwRbi() {
		return gwRbi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGwRbi(String newGwRbi) {
		String oldGwRbi = gwRbi;
		gwRbi = newGwRbi;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__GW_RBI, oldGwRbi, gwRbi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEarnedAgainstTheTeam() {
		return earnedAgainstTheTeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarnedAgainstTheTeam(int newEarnedAgainstTheTeam) {
		int oldEarnedAgainstTheTeam = earnedAgainstTheTeam;
		earnedAgainstTheTeam = newEarnedAgainstTheTeam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM, oldEarnedAgainstTheTeam, earnedAgainstTheTeam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFinalScore() {
		return finalScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinalScore(int newFinalScore) {
		int oldFinalScore = finalScore;
		finalScore = newFinalScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.TEAM_STATISTIC__FINAL_SCORE, oldFinalScore, finalScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS:
				return ((InternalEList<?>)getGeneralInningStats()).basicRemove(otherEnd, msgs);
			case StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC:
				return basicSetTotalCatcherStatistic(null, msgs);
			case StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC:
				return basicSetTotalDefensiveStatistic(null, msgs);
			case StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC:
				return basicSetTotalPitcherStatistic(null, msgs);
			case StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC:
				return basicSetTotalOffensiveStatistic(null, msgs);
			case StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER:
				return ((InternalEList<?>)getCurrentOffensivePlayer()).basicRemove(otherEnd, msgs);
			case StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER:
				return ((InternalEList<?>)getCurrentDefensivePlayer()).basicRemove(otherEnd, msgs);
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
			case StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS:
				return getGeneralInningStats();
			case StatisticPackage.TEAM_STATISTIC__NAME:
				return getName();
			case StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC:
				return getTotalCatcherStatistic();
			case StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC:
				return getTotalDefensiveStatistic();
			case StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC:
				return getTotalPitcherStatistic();
			case StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC:
				return getTotalOffensiveStatistic();
			case StatisticPackage.TEAM_STATISTIC__DOUBLE_PLAY_COUNTER:
				return getDoublePlayCounter();
			case StatisticPackage.TEAM_STATISTIC__TIE_BREAK_COUNTER:
				return getTieBreakCounter();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER:
				if (coreType) return getCurrentOffensivePlayer();
				else return getCurrentOffensivePlayer().map();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER:
				if (coreType) return getCurrentDefensivePlayer();
				else return getCurrentDefensivePlayer().map();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_CATCHER:
				return getCurrentCatcher();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_PITCHER:
				return getCurrentPitcher();
			case StatisticPackage.TEAM_STATISTIC__CATCHERS:
				return getCatchers();
			case StatisticPackage.TEAM_STATISTIC__PITCHERS:
				return getPitchers();
			case StatisticPackage.TEAM_STATISTIC__PLAYERS:
				return getPlayers();
			case StatisticPackage.TEAM_STATISTIC__GW_RBI:
				return getGwRbi();
			case StatisticPackage.TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM:
				return getEarnedAgainstTheTeam();
			case StatisticPackage.TEAM_STATISTIC__FINAL_SCORE:
				return getFinalScore();
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
			case StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS:
				getGeneralInningStats().clear();
				getGeneralInningStats().addAll((Collection<? extends InninStatictic>)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__NAME:
				setName((String)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC:
				setTotalCatcherStatistic((CatcherStatistic)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC:
				setTotalDefensiveStatistic((DefensiveStatistic)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC:
				setTotalPitcherStatistic((PitcherStatistic)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC:
				setTotalOffensiveStatistic((OffensiveStatistic)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__DOUBLE_PLAY_COUNTER:
				setDoublePlayCounter((Integer)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__TIE_BREAK_COUNTER:
				setTieBreakCounter((Integer)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER:
				((EStructuralFeature.Setting)getCurrentOffensivePlayer()).set(newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER:
				((EStructuralFeature.Setting)getCurrentDefensivePlayer()).set(newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_CATCHER:
				setCurrentCatcher((LineupEntry)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_PITCHER:
				setCurrentPitcher((LineupEntry)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__CATCHERS:
				getCatchers().clear();
				getCatchers().addAll((Collection<? extends LineupEntry>)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__PITCHERS:
				getPitchers().clear();
				getPitchers().addAll((Collection<? extends LineupEntry>)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__PLAYERS:
				getPlayers().clear();
				getPlayers().addAll((Collection<? extends LineupEntry>)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__GW_RBI:
				setGwRbi((String)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM:
				setEarnedAgainstTheTeam((Integer)newValue);
				return;
			case StatisticPackage.TEAM_STATISTIC__FINAL_SCORE:
				setFinalScore((Integer)newValue);
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
			case StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS:
				getGeneralInningStats().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC:
				setTotalCatcherStatistic((CatcherStatistic)null);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC:
				setTotalDefensiveStatistic((DefensiveStatistic)null);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC:
				setTotalPitcherStatistic((PitcherStatistic)null);
				return;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC:
				setTotalOffensiveStatistic((OffensiveStatistic)null);
				return;
			case StatisticPackage.TEAM_STATISTIC__DOUBLE_PLAY_COUNTER:
				setDoublePlayCounter(DOUBLE_PLAY_COUNTER_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__TIE_BREAK_COUNTER:
				setTieBreakCounter(TIE_BREAK_COUNTER_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER:
				getCurrentOffensivePlayer().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER:
				getCurrentDefensivePlayer().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_CATCHER:
				setCurrentCatcher(CURRENT_CATCHER_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_PITCHER:
				setCurrentPitcher(CURRENT_PITCHER_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__CATCHERS:
				getCatchers().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__PITCHERS:
				getPitchers().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__PLAYERS:
				getPlayers().clear();
				return;
			case StatisticPackage.TEAM_STATISTIC__GW_RBI:
				setGwRbi(GW_RBI_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM:
				setEarnedAgainstTheTeam(EARNED_AGAINST_THE_TEAM_EDEFAULT);
				return;
			case StatisticPackage.TEAM_STATISTIC__FINAL_SCORE:
				setFinalScore(FINAL_SCORE_EDEFAULT);
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
			case StatisticPackage.TEAM_STATISTIC__GENERAL_INNING_STATS:
				return generalInningStats != null && !generalInningStats.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StatisticPackage.TEAM_STATISTIC__TOTAL_CATCHER_STATISTIC:
				return totalCatcherStatistic != null;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_DEFENSIVE_STATISTIC:
				return totalDefensiveStatistic != null;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_PITCHER_STATISTIC:
				return totalPitcherStatistic != null;
			case StatisticPackage.TEAM_STATISTIC__TOTAL_OFFENSIVE_STATISTIC:
				return totalOffensiveStatistic != null;
			case StatisticPackage.TEAM_STATISTIC__DOUBLE_PLAY_COUNTER:
				return doublePlayCounter != DOUBLE_PLAY_COUNTER_EDEFAULT;
			case StatisticPackage.TEAM_STATISTIC__TIE_BREAK_COUNTER:
				return tieBreakCounter != TIE_BREAK_COUNTER_EDEFAULT;
			case StatisticPackage.TEAM_STATISTIC__CURRENT_OFFENSIVE_PLAYER:
				return currentOffensivePlayer != null && !currentOffensivePlayer.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_DEFENSIVE_PLAYER:
				return currentDefensivePlayer != null && !currentDefensivePlayer.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__CURRENT_CATCHER:
				return CURRENT_CATCHER_EDEFAULT == null ? currentCatcher != null : !CURRENT_CATCHER_EDEFAULT.equals(currentCatcher);
			case StatisticPackage.TEAM_STATISTIC__CURRENT_PITCHER:
				return CURRENT_PITCHER_EDEFAULT == null ? currentPitcher != null : !CURRENT_PITCHER_EDEFAULT.equals(currentPitcher);
			case StatisticPackage.TEAM_STATISTIC__CATCHERS:
				return catchers != null && !catchers.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__PITCHERS:
				return pitchers != null && !pitchers.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__PLAYERS:
				return players != null && !players.isEmpty();
			case StatisticPackage.TEAM_STATISTIC__GW_RBI:
				return GW_RBI_EDEFAULT == null ? gwRbi != null : !GW_RBI_EDEFAULT.equals(gwRbi);
			case StatisticPackage.TEAM_STATISTIC__EARNED_AGAINST_THE_TEAM:
				return earnedAgainstTheTeam != EARNED_AGAINST_THE_TEAM_EDEFAULT;
			case StatisticPackage.TEAM_STATISTIC__FINAL_SCORE:
				return finalScore != FINAL_SCORE_EDEFAULT;
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
		result.append(", doublePlayCounter: ");
		result.append(doublePlayCounter);
		result.append(", tieBreakCounter: ");
		result.append(tieBreakCounter);
		result.append(", currentCatcher: ");
		result.append(currentCatcher);
		result.append(", currentPitcher: ");
		result.append(currentPitcher);
		result.append(", catchers: ");
		result.append(catchers);
		result.append(", pitchers: ");
		result.append(pitchers);
		result.append(", players: ");
		result.append(players);
		result.append(", gwRbi: ");
		result.append(gwRbi);
		result.append(", earnedAgainstTheTeam: ");
		result.append(earnedAgainstTheTeam);
		result.append(", finalScore: ");
		result.append(finalScore);
		result.append(')');
		return result.toString();
	}

} //TeamStatisticImpl
