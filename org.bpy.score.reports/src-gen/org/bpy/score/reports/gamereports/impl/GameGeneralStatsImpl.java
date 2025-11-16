/**
 */
package org.bpy.score.reports.gamereports.impl;

import java.util.Collection;

import org.bpy.score.reports.gamereports.GameGeneralStats;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.PointsPerInning;

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
 * An implementation of the model object '<em><b>Game General Stats</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getPointsPerInning <em>Points Per Inning</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getVisitorErrors <em>Visitor Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getVisitorHits <em>Visitor Hits</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getVisitorRuns <em>Visitor Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getHometeamErrors <em>Hometeam Errors</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getHometeamRuns <em>Hometeam Runs</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.GameGeneralStatsImpl#getHometeamHits <em>Hometeam Hits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameGeneralStatsImpl extends MinimalEObjectImpl.Container implements GameGeneralStats {
	/**
	 * The cached value of the '{@link #getPointsPerInning() <em>Points Per Inning</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointsPerInning()
	 * @generated
	 * @ordered
	 */
	protected EList<PointsPerInning> pointsPerInning;

	/**
	 * The default value of the '{@link #getVisitorErrors() <em>Visitor Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorErrors()
	 * @generated
	 * @ordered
	 */
	protected static final int VISITOR_ERRORS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getVisitorErrors() <em>Visitor Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorErrors()
	 * @generated
	 * @ordered
	 */
	protected int visitorErrors = VISITOR_ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisitorHits() <em>Visitor Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorHits()
	 * @generated
	 * @ordered
	 */
	protected static final int VISITOR_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getVisitorHits() <em>Visitor Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorHits()
	 * @generated
	 * @ordered
	 */
	protected int visitorHits = VISITOR_HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisitorRuns() <em>Visitor Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int VISITOR_RUNS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getVisitorRuns() <em>Visitor Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisitorRuns()
	 * @generated
	 * @ordered
	 */
	protected int visitorRuns = VISITOR_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHometeamErrors() <em>Hometeam Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamErrors()
	 * @generated
	 * @ordered
	 */
	protected static final int HOMETEAM_ERRORS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHometeamErrors() <em>Hometeam Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamErrors()
	 * @generated
	 * @ordered
	 */
	protected int hometeamErrors = HOMETEAM_ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHometeamRuns() <em>Hometeam Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamRuns()
	 * @generated
	 * @ordered
	 */
	protected static final int HOMETEAM_RUNS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHometeamRuns() <em>Hometeam Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamRuns()
	 * @generated
	 * @ordered
	 */
	protected int hometeamRuns = HOMETEAM_RUNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHometeamHits() <em>Hometeam Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamHits()
	 * @generated
	 * @ordered
	 */
	protected static final int HOMETEAM_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHometeamHits() <em>Hometeam Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHometeamHits()
	 * @generated
	 * @ordered
	 */
	protected int hometeamHits = HOMETEAM_HITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GameGeneralStatsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.GAME_GENERAL_STATS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PointsPerInning> getPointsPerInning() {
		if (pointsPerInning == null) {
			pointsPerInning = new EObjectContainmentEList<PointsPerInning>(PointsPerInning.class, this, GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING);
		}
		return pointsPerInning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVisitorErrors() {
		return visitorErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitorErrors(int newVisitorErrors) {
		int oldVisitorErrors = visitorErrors;
		visitorErrors = newVisitorErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__VISITOR_ERRORS, oldVisitorErrors, visitorErrors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVisitorHits() {
		return visitorHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitorHits(int newVisitorHits) {
		int oldVisitorHits = visitorHits;
		visitorHits = newVisitorHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__VISITOR_HITS, oldVisitorHits, visitorHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVisitorRuns() {
		return visitorRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisitorRuns(int newVisitorRuns) {
		int oldVisitorRuns = visitorRuns;
		visitorRuns = newVisitorRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__VISITOR_RUNS, oldVisitorRuns, visitorRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHometeamErrors() {
		return hometeamErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHometeamErrors(int newHometeamErrors) {
		int oldHometeamErrors = hometeamErrors;
		hometeamErrors = newHometeamErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_ERRORS, oldHometeamErrors, hometeamErrors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHometeamRuns() {
		return hometeamRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHometeamRuns(int newHometeamRuns) {
		int oldHometeamRuns = hometeamRuns;
		hometeamRuns = newHometeamRuns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_RUNS, oldHometeamRuns, hometeamRuns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHometeamHits() {
		return hometeamHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHometeamHits(int newHometeamHits) {
		int oldHometeamHits = hometeamHits;
		hometeamHits = newHometeamHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_HITS, oldHometeamHits, hometeamHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING:
				return ((InternalEList<?>)getPointsPerInning()).basicRemove(otherEnd, msgs);
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
			case GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING:
				return getPointsPerInning();
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_ERRORS:
				return getVisitorErrors();
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_HITS:
				return getVisitorHits();
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_RUNS:
				return getVisitorRuns();
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_ERRORS:
				return getHometeamErrors();
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_RUNS:
				return getHometeamRuns();
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_HITS:
				return getHometeamHits();
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
			case GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING:
				getPointsPerInning().clear();
				getPointsPerInning().addAll((Collection<? extends PointsPerInning>)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_ERRORS:
				setVisitorErrors((Integer)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_HITS:
				setVisitorHits((Integer)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_RUNS:
				setVisitorRuns((Integer)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_ERRORS:
				setHometeamErrors((Integer)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_RUNS:
				setHometeamRuns((Integer)newValue);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_HITS:
				setHometeamHits((Integer)newValue);
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
			case GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING:
				getPointsPerInning().clear();
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_ERRORS:
				setVisitorErrors(VISITOR_ERRORS_EDEFAULT);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_HITS:
				setVisitorHits(VISITOR_HITS_EDEFAULT);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_RUNS:
				setVisitorRuns(VISITOR_RUNS_EDEFAULT);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_ERRORS:
				setHometeamErrors(HOMETEAM_ERRORS_EDEFAULT);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_RUNS:
				setHometeamRuns(HOMETEAM_RUNS_EDEFAULT);
				return;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_HITS:
				setHometeamHits(HOMETEAM_HITS_EDEFAULT);
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
			case GameReportsPackage.GAME_GENERAL_STATS__POINTS_PER_INNING:
				return pointsPerInning != null && !pointsPerInning.isEmpty();
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_ERRORS:
				return visitorErrors != VISITOR_ERRORS_EDEFAULT;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_HITS:
				return visitorHits != VISITOR_HITS_EDEFAULT;
			case GameReportsPackage.GAME_GENERAL_STATS__VISITOR_RUNS:
				return visitorRuns != VISITOR_RUNS_EDEFAULT;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_ERRORS:
				return hometeamErrors != HOMETEAM_ERRORS_EDEFAULT;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_RUNS:
				return hometeamRuns != HOMETEAM_RUNS_EDEFAULT;
			case GameReportsPackage.GAME_GENERAL_STATS__HOMETEAM_HITS:
				return hometeamHits != HOMETEAM_HITS_EDEFAULT;
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
		result.append(" (visitorErrors: ");
		result.append(visitorErrors);
		result.append(", visitorHits: ");
		result.append(visitorHits);
		result.append(", visitorRuns: ");
		result.append(visitorRuns);
		result.append(", hometeamErrors: ");
		result.append(hometeamErrors);
		result.append(", hometeamRuns: ");
		result.append(hometeamRuns);
		result.append(", hometeamHits: ");
		result.append(hometeamHits);
		result.append(')');
		return result.toString();
	}

} //GameGeneralStatsImpl
