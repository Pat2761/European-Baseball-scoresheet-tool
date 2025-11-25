/**
 */
package org.bpy.score.reports.gamereports.impl;

import org.bpy.score.reports.gamereports.ActionDescription;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.TEAM;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl#getResume <em>Resume</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.ActionDescriptionImpl#getTeam <em>Team</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionDescriptionImpl extends MinimalEObjectImpl.Container implements ActionDescription {
	/**
	 * The default value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected String header = HEADER_EDEFAULT;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getResume() <em>Resume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResume()
	 * @generated
	 * @ordered
	 */
	protected static final String RESUME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResume() <em>Resume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResume()
	 * @generated
	 * @ordered
	 */
	protected String resume = RESUME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTeam() <em>Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam()
	 * @generated
	 * @ordered
	 */
	protected static final TEAM TEAM_EDEFAULT = TEAM.HOMETEAM;

	/**
	 * The cached value of the '{@link #getTeam() <em>Team</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam()
	 * @generated
	 * @ordered
	 */
	protected TEAM team = TEAM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.ACTION_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeader(String newHeader) {
		String oldHeader = header;
		header = newHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.ACTION_DESCRIPTION__HEADER, oldHeader, header));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.ACTION_DESCRIPTION__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResume() {
		return resume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResume(String newResume) {
		String oldResume = resume;
		resume = newResume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.ACTION_DESCRIPTION__RESUME, oldResume, resume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TEAM getTeam() {
		return team;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTeam(TEAM newTeam) {
		TEAM oldTeam = team;
		team = newTeam == null ? TEAM_EDEFAULT : newTeam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GameReportsPackage.ACTION_DESCRIPTION__TEAM, oldTeam, team));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GameReportsPackage.ACTION_DESCRIPTION__HEADER:
				return getHeader();
			case GameReportsPackage.ACTION_DESCRIPTION__CONTENT:
				return getContent();
			case GameReportsPackage.ACTION_DESCRIPTION__RESUME:
				return getResume();
			case GameReportsPackage.ACTION_DESCRIPTION__TEAM:
				return getTeam();
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
			case GameReportsPackage.ACTION_DESCRIPTION__HEADER:
				setHeader((String)newValue);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__CONTENT:
				setContent((String)newValue);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__RESUME:
				setResume((String)newValue);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__TEAM:
				setTeam((TEAM)newValue);
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
			case GameReportsPackage.ACTION_DESCRIPTION__HEADER:
				setHeader(HEADER_EDEFAULT);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__RESUME:
				setResume(RESUME_EDEFAULT);
				return;
			case GameReportsPackage.ACTION_DESCRIPTION__TEAM:
				setTeam(TEAM_EDEFAULT);
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
			case GameReportsPackage.ACTION_DESCRIPTION__HEADER:
				return HEADER_EDEFAULT == null ? header != null : !HEADER_EDEFAULT.equals(header);
			case GameReportsPackage.ACTION_DESCRIPTION__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case GameReportsPackage.ACTION_DESCRIPTION__RESUME:
				return RESUME_EDEFAULT == null ? resume != null : !RESUME_EDEFAULT.equals(resume);
			case GameReportsPackage.ACTION_DESCRIPTION__TEAM:
				return team != TEAM_EDEFAULT;
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
		result.append(" (header: ");
		result.append(header);
		result.append(", content: ");
		result.append(content);
		result.append(", resume: ");
		result.append(resume);
		result.append(", team: ");
		result.append(team);
		result.append(')');
		return result.toString();
	}

} //ActionDescriptionImpl
