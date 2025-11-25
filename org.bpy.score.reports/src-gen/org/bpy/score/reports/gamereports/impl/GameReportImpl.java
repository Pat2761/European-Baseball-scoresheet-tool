/**
 */
package org.bpy.score.reports.gamereports.impl;

import java.util.Collection;

import org.bpy.score.reports.gamereports.GameGeneralStats;
import org.bpy.score.reports.gamereports.GameReport;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.PlayByPlay;
import org.bpy.score.reports.gamereports.StartingLineup;
import org.bpy.score.reports.gamereports.TeamStatisitics;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getBannerPath <em>Banner Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getVisitorSheetPath <em>Visitor Sheet Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getVisitorStats <em>Visitor Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getHometeamStats <em>Hometeam Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getUmpires <em>Umpires</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getScorekeepers <em>Scorekeepers</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getStartingTime <em>Starting Time</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getTown <em>Town</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getStadium <em>Stadium</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getHometeamSheetPath <em>Hometeam Sheet Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getGameNumber <em>Game Number</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getPlayByPlay <em>Play By Play</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getPdfFile <em>Pdf File</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getGeneralStats <em>General Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getVisitorLineup <em>Visitor Lineup</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getHometeamLineup <em>Hometeam Lineup</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameReportImpl#getMixed <em>Mixed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameReportImpl extends MinimalEObjectImpl.Container implements GameReport {
	/**
	 * The cached value of the '{@link #getBannerPath() <em>Banner Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBannerPath()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bannerPath;

	/**
	 * The default value of the '{@link #getVisitorSheetPath() <em>Visitor Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorSheetPath()
	 * @generated
	 * @ordered
	 */
	protected static final String VISITOR_SHEET_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVisitorSheetPath() <em>Visitor Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorSheetPath()
	 * @generated
	 * @ordered
	 */
	protected String visitorSheetPath = VISITOR_SHEET_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVisitorStats() <em>Visitor Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorStats()
	 * @generated
	 * @ordered
	 */
	protected TeamStatisitics visitorStats;

	/**
	 * The cached value of the '{@link #getHometeamStats() <em>Hometeam Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamStats()
	 * @generated
	 * @ordered
	 */
	protected TeamStatisitics hometeamStats;

	/**
	 * The cached value of the '{@link #getUmpires() <em>Umpires</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmpires()
	 * @generated
	 * @ordered
	 */
	protected EList<String> umpires;

	/**
	 * The cached value of the '{@link #getScorekeepers() <em>Scorekeepers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScorekeepers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> scorekeepers;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartingTime() <em>Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingTime()
	 * @generated
	 * @ordered
	 */
	protected static final String STARTING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartingTime() <em>Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingTime()
	 * @generated
	 * @ordered
	 */
	protected String startingTime = STARTING_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final String DURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected String duration = DURATION_EDEFAULT;

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
	 * The default value of the '{@link #getStadium() <em>Stadium</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStadium()
	 * @generated
	 * @ordered
	 */
	protected static final String STADIUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStadium() <em>Stadium</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStadium()
	 * @generated
	 * @ordered
	 */
	protected String stadium = STADIUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getHometeamSheetPath() <em>Hometeam Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamSheetPath()
	 * @generated
	 * @ordered
	 */
	protected static final String HOMETEAM_SHEET_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHometeamSheetPath() <em>Hometeam Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamSheetPath()
	 * @generated
	 * @ordered
	 */
	protected String hometeamSheetPath = HOMETEAM_SHEET_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getGameNumber() <em>Game Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String GAME_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGameNumber() <em>Game Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGameNumber()
	 * @generated
	 * @ordered
	 */
	protected String gameNumber = GAME_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlayByPlay() <em>Play By Play</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayByPlay()
	 * @generated
	 * @ordered
	 */
	protected PlayByPlay playByPlay;

	/**
	 * The default value of the '{@link #getPdfFile() <em>Pdf File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdfFile()
	 * @generated
	 * @ordered
	 */
	protected static final String PDF_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPdfFile() <em>Pdf File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdfFile()
	 * @generated
	 * @ordered
	 */
	protected String pdfFile = PDF_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGeneralStats() <em>General Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralStats()
	 * @generated
	 * @ordered
	 */
	protected GameGeneralStats generalStats;

	/**
	 * The cached value of the '{@link #getVisitorLineup() <em>Visitor Lineup</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorLineup()
	 * @generated
	 * @ordered
	 */
	protected StartingLineup visitorLineup;

	/**
	 * The cached value of the '{@link #getHometeamLineup() <em>Hometeam Lineup</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamLineup()
	 * @generated
	 * @ordered
	 */
	protected StartingLineup hometeamLineup;

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.GAME_REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getBannerPath() {
		if (bannerPath == null) {
			bannerPath = new EDataTypeUniqueEList<String>(String.class, this, GameReportsPackage.GAME_REPORT__BANNER_PATH);
		}
		return bannerPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVisitorSheetPath() {
		return visitorSheetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitorSheetPath(String newVisitorSheetPath) {
		String oldVisitorSheetPath = visitorSheetPath;
		visitorSheetPath = newVisitorSheetPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__VISITOR_SHEET_PATH, oldVisitorSheetPath, visitorSheetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatisitics getVisitorStats() {
		return visitorStats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisitorStats(TeamStatisitics newVisitorStats, NotificationChain msgs) {
		TeamStatisitics oldVisitorStats = visitorStats;
		visitorStats = newVisitorStats;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__VISITOR_STATS, oldVisitorStats, newVisitorStats);
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
	public void setVisitorStats(TeamStatisitics newVisitorStats) {
		if (newVisitorStats != visitorStats) {
			NotificationChain msgs = null;
			if (visitorStats != null)
				msgs = ((InternalEObject)visitorStats).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__VISITOR_STATS, null, msgs);
			if (newVisitorStats != null)
				msgs = ((InternalEObject)newVisitorStats).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__VISITOR_STATS, null, msgs);
			msgs = basicSetVisitorStats(newVisitorStats, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__VISITOR_STATS, newVisitorStats, newVisitorStats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatisitics getHometeamStats() {
		return hometeamStats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHometeamStats(TeamStatisitics newHometeamStats, NotificationChain msgs) {
		TeamStatisitics oldHometeamStats = hometeamStats;
		hometeamStats = newHometeamStats;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__HOMETEAM_STATS, oldHometeamStats, newHometeamStats);
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
	public void setHometeamStats(TeamStatisitics newHometeamStats) {
		if (newHometeamStats != hometeamStats) {
			NotificationChain msgs = null;
			if (hometeamStats != null)
				msgs = ((InternalEObject)hometeamStats).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__HOMETEAM_STATS, null, msgs);
			if (newHometeamStats != null)
				msgs = ((InternalEObject)newHometeamStats).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__HOMETEAM_STATS, null, msgs);
			msgs = basicSetHometeamStats(newHometeamStats, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__HOMETEAM_STATS, newHometeamStats, newHometeamStats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getUmpires() {
		if (umpires == null) {
			umpires = new EDataTypeUniqueEList<String>(String.class, this, GameReportsPackage.GAME_REPORT__UMPIRES);
		}
		return umpires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getScorekeepers() {
		if (scorekeepers == null) {
			scorekeepers = new EDataTypeUniqueEList<String>(String.class, this, GameReportsPackage.GAME_REPORT__SCOREKEEPERS);
		}
		return scorekeepers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartingTime() {
		return startingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartingTime(String newStartingTime) {
		String oldStartingTime = startingTime;
		startingTime = newStartingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__STARTING_TIME, oldStartingTime, startingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuration(String newDuration) {
		String oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__DURATION, oldDuration, duration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__TOWN, oldTown, town));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStadium() {
		return stadium;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStadium(String newStadium) {
		String oldStadium = stadium;
		stadium = newStadium;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__STADIUM, oldStadium, stadium));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHometeamSheetPath() {
		return hometeamSheetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHometeamSheetPath(String newHometeamSheetPath) {
		String oldHometeamSheetPath = hometeamSheetPath;
		hometeamSheetPath = newHometeamSheetPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__HOMETEAM_SHEET_PATH, oldHometeamSheetPath, hometeamSheetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGameNumber() {
		return gameNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGameNumber(String newGameNumber) {
		String oldGameNumber = gameNumber;
		gameNumber = newGameNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__GAME_NUMBER, oldGameNumber, gameNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PlayByPlay getPlayByPlay() {
		return playByPlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayByPlay(PlayByPlay newPlayByPlay, NotificationChain msgs) {
		PlayByPlay oldPlayByPlay = playByPlay;
		playByPlay = newPlayByPlay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY, oldPlayByPlay, newPlayByPlay);
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
	public void setPlayByPlay(PlayByPlay newPlayByPlay) {
		if (newPlayByPlay != playByPlay) {
			NotificationChain msgs = null;
			if (playByPlay != null)
				msgs = ((InternalEObject)playByPlay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY, null, msgs);
			if (newPlayByPlay != null)
				msgs = ((InternalEObject)newPlayByPlay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY, null, msgs);
			msgs = basicSetPlayByPlay(newPlayByPlay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY, newPlayByPlay, newPlayByPlay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPdfFile() {
		return pdfFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPdfFile(String newPdfFile) {
		String oldPdfFile = pdfFile;
		pdfFile = newPdfFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__PDF_FILE, oldPdfFile, pdfFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameGeneralStats getGeneralStats() {
		return generalStats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralStats(GameGeneralStats newGeneralStats, NotificationChain msgs) {
		GameGeneralStats oldGeneralStats = generalStats;
		generalStats = newGeneralStats;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__GENERAL_STATS, oldGeneralStats, newGeneralStats);
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
	public void setGeneralStats(GameGeneralStats newGeneralStats) {
		if (newGeneralStats != generalStats) {
			NotificationChain msgs = null;
			if (generalStats != null)
				msgs = ((InternalEObject)generalStats).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__GENERAL_STATS, null, msgs);
			if (newGeneralStats != null)
				msgs = ((InternalEObject)newGeneralStats).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__GENERAL_STATS, null, msgs);
			msgs = basicSetGeneralStats(newGeneralStats, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__GENERAL_STATS, newGeneralStats, newGeneralStats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StartingLineup getVisitorLineup() {
		return visitorLineup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisitorLineup(StartingLineup newVisitorLineup, NotificationChain msgs) {
		StartingLineup oldVisitorLineup = visitorLineup;
		visitorLineup = newVisitorLineup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__VISITOR_LINEUP, oldVisitorLineup, newVisitorLineup);
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
	public void setVisitorLineup(StartingLineup newVisitorLineup) {
		if (newVisitorLineup != visitorLineup) {
			NotificationChain msgs = null;
			if (visitorLineup != null)
				msgs = ((InternalEObject)visitorLineup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__VISITOR_LINEUP, null, msgs);
			if (newVisitorLineup != null)
				msgs = ((InternalEObject)newVisitorLineup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__VISITOR_LINEUP, null, msgs);
			msgs = basicSetVisitorLineup(newVisitorLineup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__VISITOR_LINEUP, newVisitorLineup, newVisitorLineup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StartingLineup getHometeamLineup() {
		return hometeamLineup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHometeamLineup(StartingLineup newHometeamLineup, NotificationChain msgs) {
		StartingLineup oldHometeamLineup = hometeamLineup;
		hometeamLineup = newHometeamLineup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP, oldHometeamLineup, newHometeamLineup);
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
	public void setHometeamLineup(StartingLineup newHometeamLineup) {
		if (newHometeamLineup != hometeamLineup) {
			NotificationChain msgs = null;
			if (hometeamLineup != null)
				msgs = ((InternalEObject)hometeamLineup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP, null, msgs);
			if (newHometeamLineup != null)
				msgs = ((InternalEObject)newHometeamLineup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP, null, msgs);
			msgs = basicSetHometeamLineup(newHometeamLineup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP, newHometeamLineup, newHometeamLineup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, GameReportsPackage.GAME_REPORT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.GAME_REPORT__VISITOR_STATS:
				return basicSetVisitorStats(null, msgs);
			case GameReportsPackage.GAME_REPORT__HOMETEAM_STATS:
				return basicSetHometeamStats(null, msgs);
			case GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY:
				return basicSetPlayByPlay(null, msgs);
			case GameReportsPackage.GAME_REPORT__GENERAL_STATS:
				return basicSetGeneralStats(null, msgs);
			case GameReportsPackage.GAME_REPORT__VISITOR_LINEUP:
				return basicSetVisitorLineup(null, msgs);
			case GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP:
				return basicSetHometeamLineup(null, msgs);
			case GameReportsPackage.GAME_REPORT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
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
			case GameReportsPackage.GAME_REPORT__BANNER_PATH:
				return getBannerPath();
			case GameReportsPackage.GAME_REPORT__VISITOR_SHEET_PATH:
				return getVisitorSheetPath();
			case GameReportsPackage.GAME_REPORT__VISITOR_STATS:
				return getVisitorStats();
			case GameReportsPackage.GAME_REPORT__HOMETEAM_STATS:
				return getHometeamStats();
			case GameReportsPackage.GAME_REPORT__UMPIRES:
				return getUmpires();
			case GameReportsPackage.GAME_REPORT__SCOREKEEPERS:
				return getScorekeepers();
			case GameReportsPackage.GAME_REPORT__DATE:
				return getDate();
			case GameReportsPackage.GAME_REPORT__STARTING_TIME:
				return getStartingTime();
			case GameReportsPackage.GAME_REPORT__DURATION:
				return getDuration();
			case GameReportsPackage.GAME_REPORT__TOWN:
				return getTown();
			case GameReportsPackage.GAME_REPORT__STADIUM:
				return getStadium();
			case GameReportsPackage.GAME_REPORT__HOMETEAM_SHEET_PATH:
				return getHometeamSheetPath();
			case GameReportsPackage.GAME_REPORT__GAME_NUMBER:
				return getGameNumber();
			case GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY:
				return getPlayByPlay();
			case GameReportsPackage.GAME_REPORT__PDF_FILE:
				return getPdfFile();
			case GameReportsPackage.GAME_REPORT__GENERAL_STATS:
				return getGeneralStats();
			case GameReportsPackage.GAME_REPORT__VISITOR_LINEUP:
				return getVisitorLineup();
			case GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP:
				return getHometeamLineup();
			case GameReportsPackage.GAME_REPORT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
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
			case GameReportsPackage.GAME_REPORT__BANNER_PATH:
				getBannerPath().clear();
				getBannerPath().addAll((Collection<? extends String>)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_SHEET_PATH:
				setVisitorSheetPath((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_STATS:
				setVisitorStats((TeamStatisitics)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_STATS:
				setHometeamStats((TeamStatisitics)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__UMPIRES:
				getUmpires().clear();
				getUmpires().addAll((Collection<? extends String>)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__SCOREKEEPERS:
				getScorekeepers().clear();
				getScorekeepers().addAll((Collection<? extends String>)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__DATE:
				setDate((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__STARTING_TIME:
				setStartingTime((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__DURATION:
				setDuration((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__TOWN:
				setTown((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__STADIUM:
				setStadium((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_SHEET_PATH:
				setHometeamSheetPath((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__GAME_NUMBER:
				setGameNumber((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY:
				setPlayByPlay((PlayByPlay)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__PDF_FILE:
				setPdfFile((String)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__GENERAL_STATS:
				setGeneralStats((GameGeneralStats)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_LINEUP:
				setVisitorLineup((StartingLineup)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP:
				setHometeamLineup((StartingLineup)newValue);
				return;
			case GameReportsPackage.GAME_REPORT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
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
			case GameReportsPackage.GAME_REPORT__BANNER_PATH:
				getBannerPath().clear();
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_SHEET_PATH:
				setVisitorSheetPath(VISITOR_SHEET_PATH_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_STATS:
				setVisitorStats((TeamStatisitics)null);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_STATS:
				setHometeamStats((TeamStatisitics)null);
				return;
			case GameReportsPackage.GAME_REPORT__UMPIRES:
				getUmpires().clear();
				return;
			case GameReportsPackage.GAME_REPORT__SCOREKEEPERS:
				getScorekeepers().clear();
				return;
			case GameReportsPackage.GAME_REPORT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__STARTING_TIME:
				setStartingTime(STARTING_TIME_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__TOWN:
				setTown(TOWN_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__STADIUM:
				setStadium(STADIUM_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_SHEET_PATH:
				setHometeamSheetPath(HOMETEAM_SHEET_PATH_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__GAME_NUMBER:
				setGameNumber(GAME_NUMBER_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY:
				setPlayByPlay((PlayByPlay)null);
				return;
			case GameReportsPackage.GAME_REPORT__PDF_FILE:
				setPdfFile(PDF_FILE_EDEFAULT);
				return;
			case GameReportsPackage.GAME_REPORT__GENERAL_STATS:
				setGeneralStats((GameGeneralStats)null);
				return;
			case GameReportsPackage.GAME_REPORT__VISITOR_LINEUP:
				setVisitorLineup((StartingLineup)null);
				return;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP:
				setHometeamLineup((StartingLineup)null);
				return;
			case GameReportsPackage.GAME_REPORT__MIXED:
				getMixed().clear();
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
			case GameReportsPackage.GAME_REPORT__BANNER_PATH:
				return bannerPath != null && !bannerPath.isEmpty();
			case GameReportsPackage.GAME_REPORT__VISITOR_SHEET_PATH:
				return VISITOR_SHEET_PATH_EDEFAULT == null ? visitorSheetPath != null : !VISITOR_SHEET_PATH_EDEFAULT.equals(visitorSheetPath);
			case GameReportsPackage.GAME_REPORT__VISITOR_STATS:
				return visitorStats != null;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_STATS:
				return hometeamStats != null;
			case GameReportsPackage.GAME_REPORT__UMPIRES:
				return umpires != null && !umpires.isEmpty();
			case GameReportsPackage.GAME_REPORT__SCOREKEEPERS:
				return scorekeepers != null && !scorekeepers.isEmpty();
			case GameReportsPackage.GAME_REPORT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case GameReportsPackage.GAME_REPORT__STARTING_TIME:
				return STARTING_TIME_EDEFAULT == null ? startingTime != null : !STARTING_TIME_EDEFAULT.equals(startingTime);
			case GameReportsPackage.GAME_REPORT__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case GameReportsPackage.GAME_REPORT__TOWN:
				return TOWN_EDEFAULT == null ? town != null : !TOWN_EDEFAULT.equals(town);
			case GameReportsPackage.GAME_REPORT__STADIUM:
				return STADIUM_EDEFAULT == null ? stadium != null : !STADIUM_EDEFAULT.equals(stadium);
			case GameReportsPackage.GAME_REPORT__HOMETEAM_SHEET_PATH:
				return HOMETEAM_SHEET_PATH_EDEFAULT == null ? hometeamSheetPath != null : !HOMETEAM_SHEET_PATH_EDEFAULT.equals(hometeamSheetPath);
			case GameReportsPackage.GAME_REPORT__GAME_NUMBER:
				return GAME_NUMBER_EDEFAULT == null ? gameNumber != null : !GAME_NUMBER_EDEFAULT.equals(gameNumber);
			case GameReportsPackage.GAME_REPORT__PLAY_BY_PLAY:
				return playByPlay != null;
			case GameReportsPackage.GAME_REPORT__PDF_FILE:
				return PDF_FILE_EDEFAULT == null ? pdfFile != null : !PDF_FILE_EDEFAULT.equals(pdfFile);
			case GameReportsPackage.GAME_REPORT__GENERAL_STATS:
				return generalStats != null;
			case GameReportsPackage.GAME_REPORT__VISITOR_LINEUP:
				return visitorLineup != null;
			case GameReportsPackage.GAME_REPORT__HOMETEAM_LINEUP:
				return hometeamLineup != null;
			case GameReportsPackage.GAME_REPORT__MIXED:
				return mixed != null && !mixed.isEmpty();
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
		result.append(" (bannerPath: ");
		result.append(bannerPath);
		result.append(", visitorSheetPath: ");
		result.append(visitorSheetPath);
		result.append(", umpires: ");
		result.append(umpires);
		result.append(", scorekeepers: ");
		result.append(scorekeepers);
		result.append(", date: ");
		result.append(date);
		result.append(", startingTime: ");
		result.append(startingTime);
		result.append(", duration: ");
		result.append(duration);
		result.append(", town: ");
		result.append(town);
		result.append(", stadium: ");
		result.append(stadium);
		result.append(", hometeamSheetPath: ");
		result.append(hometeamSheetPath);
		result.append(", gameNumber: ");
		result.append(gameNumber);
		result.append(", pdfFile: ");
		result.append(pdfFile);
		result.append(", mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //GameReportImpl
