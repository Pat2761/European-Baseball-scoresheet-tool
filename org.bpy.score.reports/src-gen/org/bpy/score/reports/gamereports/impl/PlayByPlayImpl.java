/**
 */
package org.bpy.score.reports.gamereports.impl;

import java.util.Collection;

import org.bpy.score.reports.gamereports.ActionDescription;
import org.bpy.score.reports.gamereports.GameReportsPackage;
import org.bpy.score.reports.gamereports.PlayByPlay;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Play By Play</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.impl.PlayByPlayImpl#getActiondescription <em>Actiondescription</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlayByPlayImpl extends MinimalEObjectImpl.Container implements PlayByPlay {
	/**
	 * The cached value of the '{@link #getActiondescription() <em>Actiondescription</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiondescription()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionDescription> actiondescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayByPlayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GameReportsPackage.Literals.PLAY_BY_PLAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ActionDescription> getActiondescription() {
		if (actiondescription == null) {
			actiondescription = new EObjectContainmentEList<ActionDescription>(ActionDescription.class, this, GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION);
		}
		return actiondescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION:
				return ((InternalEList<?>)getActiondescription()).basicRemove(otherEnd, msgs);
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
			case GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION:
				return getActiondescription();
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
			case GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION:
				getActiondescription().clear();
				getActiondescription().addAll((Collection<? extends ActionDescription>)newValue);
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
			case GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION:
				getActiondescription().clear();
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
			case GameReportsPackage.PLAY_BY_PLAY__ACTIONDESCRIPTION:
				return actiondescription != null && !actiondescription.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlayByPlayImpl
