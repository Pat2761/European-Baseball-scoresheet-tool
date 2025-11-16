/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;

import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lineup Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#isIsDefensiveEntry <em>Is Defensive Entry</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getDefensivePosition <em>Defensive Position</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getOffensivePosition <em>Offensive Position</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getDefensivePositionIndex <em>Defensive Position Index</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getStartEntryIp <em>Start Entry Ip</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getIpPlayed <em>Ip Played</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getPlayerDescription <em>Player Description</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getAssociatedObjects <em>Associated Objects</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getDefensiveStatistic <em>Defensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getOffensiveStatistic <em>Offensive Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getCatcherStatistic <em>Catcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getPitcherStatistic <em>Pitcher Statistic</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#isActif <em>Actif</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getOrderNumber <em>Order Number</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.statistic.impl.LineupEntryImpl#getLaterality <em>Laterality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LineupEntryImpl extends MinimalEObjectImpl.Container implements LineupEntry {
	/**
	 * The default value of the '{@link #isIsDefensiveEntry() <em>Is Defensive Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefensiveEntry()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFENSIVE_ENTRY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefensiveEntry() <em>Is Defensive Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefensiveEntry()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefensiveEntry = IS_DEFENSIVE_ENTRY_EDEFAULT;

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
	 * The default value of the '{@link #getOffensivePosition() <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensivePosition()
	 * @generated
	 * @ordered
	 */
	protected static final String OFFENSIVE_POSITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffensivePosition() <em>Offensive Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensivePosition()
	 * @generated
	 * @ordered
	 */
	protected String offensivePosition = OFFENSIVE_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefensivePositionIndex() <em>Defensive Position Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensivePositionIndex()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFENSIVE_POSITION_INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefensivePositionIndex() <em>Defensive Position Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensivePositionIndex()
	 * @generated
	 * @ordered
	 */
	protected String defensivePositionIndex = DEFENSIVE_POSITION_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartEntryIp() <em>Start Entry Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartEntryIp()
	 * @generated
	 * @ordered
	 */
	protected static final double START_ENTRY_IP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartEntryIp() <em>Start Entry Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartEntryIp()
	 * @generated
	 * @ordered
	 */
	protected double startEntryIp = START_ENTRY_IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpPlayed() <em>Ip Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpPlayed()
	 * @generated
	 * @ordered
	 */
	protected static final double IP_PLAYED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIpPlayed() <em>Ip Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIpPlayed()
	 * @generated
	 * @ordered
	 */
	protected double ipPlayed = IP_PLAYED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlayerDescription() <em>Player Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayerDescription()
	 * @generated
	 * @ordered
	 */
	protected static final LineupPlayerDescription PLAYER_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlayerDescription() <em>Player Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayerDescription()
	 * @generated
	 * @ordered
	 */
	protected LineupPlayerDescription playerDescription = PLAYER_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociatedObjects() <em>Associated Objects</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedObjects()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> associatedObjects;

	/**
	 * The default value of the '{@link #getDefensiveStatistic() <em>Defensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected static final DefensiveStatistic DEFENSIVE_STATISTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefensiveStatistic() <em>Defensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected DefensiveStatistic defensiveStatistic = DEFENSIVE_STATISTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffensiveStatistic() <em>Offensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected static final OffensiveStatistic OFFENSIVE_STATISTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffensiveStatistic() <em>Offensive Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffensiveStatistic()
	 * @generated
	 * @ordered
	 */
	protected OffensiveStatistic offensiveStatistic = OFFENSIVE_STATISTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getCatcherStatistic() <em>Catcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected static final CatcherStatistic CATCHER_STATISTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatcherStatistic() <em>Catcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected CatcherStatistic catcherStatistic = CATCHER_STATISTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitcherStatistic() <em>Pitcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected static final PitcherStatistic PITCHER_STATISTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPitcherStatistic() <em>Pitcher Statistic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitcherStatistic()
	 * @generated
	 * @ordered
	 */
	protected PitcherStatistic pitcherStatistic = PITCHER_STATISTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isActif() <em>Actif</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActif()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActif() <em>Actif</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActif()
	 * @generated
	 * @ordered
	 */
	protected boolean actif = ACTIF_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected int orderNumber = ORDER_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaterality() <em>Laterality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaterality()
	 * @generated
	 * @ordered
	 */
	protected static final String LATERALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLaterality() <em>Laterality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaterality()
	 * @generated
	 * @ordered
	 */
	protected String laterality = LATERALITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineupEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatisticPackage.Literals.LINEUP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDefensiveEntry() {
		return isDefensiveEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDefensiveEntry(boolean newIsDefensiveEntry) {
		boolean oldIsDefensiveEntry = isDefensiveEntry;
		isDefensiveEntry = newIsDefensiveEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__IS_DEFENSIVE_ENTRY, oldIsDefensiveEntry, isDefensiveEntry));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION, oldDefensivePosition, defensivePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOffensivePosition() {
		return offensivePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffensivePosition(String newOffensivePosition) {
		String oldOffensivePosition = offensivePosition;
		offensivePosition = newOffensivePosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__OFFENSIVE_POSITION, oldOffensivePosition, offensivePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDefensivePositionIndex() {
		return defensivePositionIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefensivePositionIndex(String newDefensivePositionIndex) {
		String oldDefensivePositionIndex = defensivePositionIndex;
		defensivePositionIndex = newDefensivePositionIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX, oldDefensivePositionIndex, defensivePositionIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartEntryIp() {
		return startEntryIp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartEntryIp(double newStartEntryIp) {
		double oldStartEntryIp = startEntryIp;
		startEntryIp = newStartEntryIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__START_ENTRY_IP, oldStartEntryIp, startEntryIp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getIpPlayed() {
		return ipPlayed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIpPlayed(double newIpPlayed) {
		double oldIpPlayed = ipPlayed;
		ipPlayed = newIpPlayed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__IP_PLAYED, oldIpPlayed, ipPlayed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupPlayerDescription getPlayerDescription() {
		return playerDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlayerDescription(LineupPlayerDescription newPlayerDescription) {
		LineupPlayerDescription oldPlayerDescription = playerDescription;
		playerDescription = newPlayerDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__PLAYER_DESCRIPTION, oldPlayerDescription, playerDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Object> getAssociatedObjects() {
		if (associatedObjects == null) {
			associatedObjects = new EcoreEMap<String,Object>(StatisticPackage.Literals.ESTRING_TO_ASSOCIATED_OBJECT_MAP, EStringToAssociatedObjectMapImpl.class, this, StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS);
		}
		return associatedObjects;
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
	@Override
	public void setDefensiveStatistic(DefensiveStatistic newDefensiveStatistic) {
		DefensiveStatistic oldDefensiveStatistic = defensiveStatistic;
		defensiveStatistic = newDefensiveStatistic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__DEFENSIVE_STATISTIC, oldDefensiveStatistic, defensiveStatistic));
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
	@Override
	public void setOffensiveStatistic(OffensiveStatistic newOffensiveStatistic) {
		OffensiveStatistic oldOffensiveStatistic = offensiveStatistic;
		offensiveStatistic = newOffensiveStatistic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__OFFENSIVE_STATISTIC, oldOffensiveStatistic, offensiveStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatcherStatistic getCatcherStatistic() {
		return catcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCatcherStatistic(CatcherStatistic newCatcherStatistic) {
		CatcherStatistic oldCatcherStatistic = catcherStatistic;
		catcherStatistic = newCatcherStatistic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__CATCHER_STATISTIC, oldCatcherStatistic, catcherStatistic));
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
	@Override
	public void setPitcherStatistic(PitcherStatistic newPitcherStatistic) {
		PitcherStatistic oldPitcherStatistic = pitcherStatistic;
		pitcherStatistic = newPitcherStatistic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__PITCHER_STATISTIC, oldPitcherStatistic, pitcherStatistic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isActif() {
		return actif;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActif(boolean newActif) {
		boolean oldActif = actif;
		actif = newActif;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__ACTIF, oldActif, actif));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrderNumber(int newOrderNumber) {
		int oldOrderNumber = orderNumber;
		orderNumber = newOrderNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__ORDER_NUMBER, oldOrderNumber, orderNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLaterality() {
		return laterality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLaterality(String newLaterality) {
		String oldLaterality = laterality;
		laterality = newLaterality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatisticPackage.LINEUP_ENTRY__LATERALITY, oldLaterality, laterality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS:
				return ((InternalEList<?>)getAssociatedObjects()).basicRemove(otherEnd, msgs);
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
			case StatisticPackage.LINEUP_ENTRY__IS_DEFENSIVE_ENTRY:
				return isIsDefensiveEntry();
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION:
				return getDefensivePosition();
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_POSITION:
				return getOffensivePosition();
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX:
				return getDefensivePositionIndex();
			case StatisticPackage.LINEUP_ENTRY__START_ENTRY_IP:
				return getStartEntryIp();
			case StatisticPackage.LINEUP_ENTRY__IP_PLAYED:
				return getIpPlayed();
			case StatisticPackage.LINEUP_ENTRY__PLAYER_DESCRIPTION:
				return getPlayerDescription();
			case StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS:
				if (coreType) return getAssociatedObjects();
				else return getAssociatedObjects().map();
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_STATISTIC:
				return getDefensiveStatistic();
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_STATISTIC:
				return getOffensiveStatistic();
			case StatisticPackage.LINEUP_ENTRY__CATCHER_STATISTIC:
				return getCatcherStatistic();
			case StatisticPackage.LINEUP_ENTRY__PITCHER_STATISTIC:
				return getPitcherStatistic();
			case StatisticPackage.LINEUP_ENTRY__ACTIF:
				return isActif();
			case StatisticPackage.LINEUP_ENTRY__ORDER_NUMBER:
				return getOrderNumber();
			case StatisticPackage.LINEUP_ENTRY__LATERALITY:
				return getLaterality();
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
			case StatisticPackage.LINEUP_ENTRY__IS_DEFENSIVE_ENTRY:
				setIsDefensiveEntry((Boolean)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION:
				setDefensivePosition((String)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_POSITION:
				setOffensivePosition((String)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX:
				setDefensivePositionIndex((String)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__START_ENTRY_IP:
				setStartEntryIp((Double)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__IP_PLAYED:
				setIpPlayed((Double)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__PLAYER_DESCRIPTION:
				setPlayerDescription((LineupPlayerDescription)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS:
				((EStructuralFeature.Setting)getAssociatedObjects()).set(newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_STATISTIC:
				setDefensiveStatistic((DefensiveStatistic)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_STATISTIC:
				setOffensiveStatistic((OffensiveStatistic)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__CATCHER_STATISTIC:
				setCatcherStatistic((CatcherStatistic)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__PITCHER_STATISTIC:
				setPitcherStatistic((PitcherStatistic)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__ACTIF:
				setActif((Boolean)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__ORDER_NUMBER:
				setOrderNumber((Integer)newValue);
				return;
			case StatisticPackage.LINEUP_ENTRY__LATERALITY:
				setLaterality((String)newValue);
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
			case StatisticPackage.LINEUP_ENTRY__IS_DEFENSIVE_ENTRY:
				setIsDefensiveEntry(IS_DEFENSIVE_ENTRY_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION:
				setDefensivePosition(DEFENSIVE_POSITION_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_POSITION:
				setOffensivePosition(OFFENSIVE_POSITION_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX:
				setDefensivePositionIndex(DEFENSIVE_POSITION_INDEX_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__START_ENTRY_IP:
				setStartEntryIp(START_ENTRY_IP_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__IP_PLAYED:
				setIpPlayed(IP_PLAYED_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__PLAYER_DESCRIPTION:
				setPlayerDescription(PLAYER_DESCRIPTION_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS:
				getAssociatedObjects().clear();
				return;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_STATISTIC:
				setDefensiveStatistic(DEFENSIVE_STATISTIC_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_STATISTIC:
				setOffensiveStatistic(OFFENSIVE_STATISTIC_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__CATCHER_STATISTIC:
				setCatcherStatistic(CATCHER_STATISTIC_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__PITCHER_STATISTIC:
				setPitcherStatistic(PITCHER_STATISTIC_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__ACTIF:
				setActif(ACTIF_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__ORDER_NUMBER:
				setOrderNumber(ORDER_NUMBER_EDEFAULT);
				return;
			case StatisticPackage.LINEUP_ENTRY__LATERALITY:
				setLaterality(LATERALITY_EDEFAULT);
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
			case StatisticPackage.LINEUP_ENTRY__IS_DEFENSIVE_ENTRY:
				return isDefensiveEntry != IS_DEFENSIVE_ENTRY_EDEFAULT;
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION:
				return DEFENSIVE_POSITION_EDEFAULT == null ? defensivePosition != null : !DEFENSIVE_POSITION_EDEFAULT.equals(defensivePosition);
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_POSITION:
				return OFFENSIVE_POSITION_EDEFAULT == null ? offensivePosition != null : !OFFENSIVE_POSITION_EDEFAULT.equals(offensivePosition);
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_POSITION_INDEX:
				return DEFENSIVE_POSITION_INDEX_EDEFAULT == null ? defensivePositionIndex != null : !DEFENSIVE_POSITION_INDEX_EDEFAULT.equals(defensivePositionIndex);
			case StatisticPackage.LINEUP_ENTRY__START_ENTRY_IP:
				return startEntryIp != START_ENTRY_IP_EDEFAULT;
			case StatisticPackage.LINEUP_ENTRY__IP_PLAYED:
				return ipPlayed != IP_PLAYED_EDEFAULT;
			case StatisticPackage.LINEUP_ENTRY__PLAYER_DESCRIPTION:
				return PLAYER_DESCRIPTION_EDEFAULT == null ? playerDescription != null : !PLAYER_DESCRIPTION_EDEFAULT.equals(playerDescription);
			case StatisticPackage.LINEUP_ENTRY__ASSOCIATED_OBJECTS:
				return associatedObjects != null && !associatedObjects.isEmpty();
			case StatisticPackage.LINEUP_ENTRY__DEFENSIVE_STATISTIC:
				return DEFENSIVE_STATISTIC_EDEFAULT == null ? defensiveStatistic != null : !DEFENSIVE_STATISTIC_EDEFAULT.equals(defensiveStatistic);
			case StatisticPackage.LINEUP_ENTRY__OFFENSIVE_STATISTIC:
				return OFFENSIVE_STATISTIC_EDEFAULT == null ? offensiveStatistic != null : !OFFENSIVE_STATISTIC_EDEFAULT.equals(offensiveStatistic);
			case StatisticPackage.LINEUP_ENTRY__CATCHER_STATISTIC:
				return CATCHER_STATISTIC_EDEFAULT == null ? catcherStatistic != null : !CATCHER_STATISTIC_EDEFAULT.equals(catcherStatistic);
			case StatisticPackage.LINEUP_ENTRY__PITCHER_STATISTIC:
				return PITCHER_STATISTIC_EDEFAULT == null ? pitcherStatistic != null : !PITCHER_STATISTIC_EDEFAULT.equals(pitcherStatistic);
			case StatisticPackage.LINEUP_ENTRY__ACTIF:
				return actif != ACTIF_EDEFAULT;
			case StatisticPackage.LINEUP_ENTRY__ORDER_NUMBER:
				return orderNumber != ORDER_NUMBER_EDEFAULT;
			case StatisticPackage.LINEUP_ENTRY__LATERALITY:
				return LATERALITY_EDEFAULT == null ? laterality != null : !LATERALITY_EDEFAULT.equals(laterality);
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
		result.append(" (isDefensiveEntry: ");
		result.append(isDefensiveEntry);
		result.append(", defensivePosition: ");
		result.append(defensivePosition);
		result.append(", offensivePosition: ");
		result.append(offensivePosition);
		result.append(", defensivePositionIndex: ");
		result.append(defensivePositionIndex);
		result.append(", startEntryIp: ");
		result.append(startEntryIp);
		result.append(", ipPlayed: ");
		result.append(ipPlayed);
		result.append(", playerDescription: ");
		result.append(playerDescription);
		result.append(", defensiveStatistic: ");
		result.append(defensiveStatistic);
		result.append(", offensiveStatistic: ");
		result.append(offensiveStatistic);
		result.append(", catcherStatistic: ");
		result.append(catcherStatistic);
		result.append(", pitcherStatistic: ");
		result.append(pitcherStatistic);
		result.append(", actif: ");
		result.append(actif);
		result.append(", orderNumber: ");
		result.append(orderNumber);
		result.append(", laterality: ");
		result.append(laterality);
		result.append(')');
		return result.toString();
	}

} //LineupEntryImpl
