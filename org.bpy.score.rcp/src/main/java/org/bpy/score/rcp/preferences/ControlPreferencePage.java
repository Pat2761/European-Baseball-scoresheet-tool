/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2020  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.score.rcp.preferences;

import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.Activator;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for the control of the game file
 * 
 * @author Patrick BRIAND
 *
 */
public class ControlPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, IPropertyChangeListener {

	/** Fly out location combo box */
	private ComboFieldEditor flyOutLocationCheck;
	/** Missing earned point combo box */
	private ComboFieldEditor missingEarnedPoint;

	/** Flyed out new value */
	private String flyOutLocationCheckNewValue = ""; //$NON-NLS-1$
	/** Earned point new value */
	private String missingEarnedPointNewValue = ""; //$NON-NLS-1$

	/**
	 * Constructor of the page.
	 */
	public ControlPreferencePage() {
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 */
	public ControlPreferencePage(String title) {
		super(title);
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 * @param image Image of the page
	 */
	public ControlPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {

		setPreferenceStore(Activator.getDefault().getPreferenceStore());

		flyOutLocationCheckNewValue = EngineConstants.checkFlyOutLocation;
		missingEarnedPointNewValue = EngineConstants.checkMissingEarnedPoint;
	}

	@Override
	@SuppressWarnings("java:S2696")
	protected void performApply() {

		EngineConstants.checkFlyOutLocation = flyOutLocationCheckNewValue;
		EngineConstants.checkMissingEarnedPoint = missingEarnedPointNewValue;

		IPreferenceStore store = getPreferenceStore();
		store.setValue(PreferenceConstants.CHECK_FLY_OUT_LOCATION, flyOutLocationCheckNewValue);
		store.setValue(PreferenceConstants.CHECK_MISSING_EARNED_POINT, missingEarnedPointNewValue);

		super.performApply();
	}

	@Override
	protected void performDefaults() {
		flyOutLocationCheck.loadDefault();
		missingEarnedPoint.loadDefault();

		super.performDefaults();
	}

	@Override
	@SuppressWarnings("java:S2696")
	public boolean performOk() {

		EngineConstants.checkFlyOutLocation = flyOutLocationCheckNewValue;
		EngineConstants.checkMissingEarnedPoint = missingEarnedPointNewValue;

		IPreferenceStore store = getPreferenceStore();
		store.setValue(PreferenceConstants.CHECK_FLY_OUT_LOCATION, flyOutLocationCheckNewValue);
		store.setValue(PreferenceConstants.CHECK_MISSING_EARNED_POINT, missingEarnedPointNewValue);

		return super.performOk();
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite controlPreferencePage = new Composite(parent, 2);

		IPreferenceStore store = getPreferenceStore();

		flyOutLocationCheck = new ComboFieldEditor(PreferenceConstants.CHECK_FLY_OUT_LOCATION,
				Messages.ControlPreferencePage_FlyOutLocationlabel, PreferenceConstants.errorLevel,
				controlPreferencePage);
		flyOutLocationCheck.setPropertyChangeListener(this);
		flyOutLocationCheck.setPreferenceName(PreferenceConstants.CHECK_FLY_OUT_LOCATION);
		flyOutLocationCheck.setPreferenceStore(store);
		flyOutLocationCheck.load();

		missingEarnedPoint = new ComboFieldEditor(PreferenceConstants.CHECK_MISSING_EARNED_POINT,
				Messages.ControlPreferencePage_MissingEarnedPointlabel, PreferenceConstants.errorLevel, controlPreferencePage);
		missingEarnedPoint.setPropertyChangeListener(this);
		missingEarnedPoint.load();
		missingEarnedPoint.setPreferenceName(PreferenceConstants.CHECK_MISSING_EARNED_POINT);
		missingEarnedPoint.setPreferenceStore(store);
		missingEarnedPoint.load();

		return controlPreferencePage;
	}

	@Override
	public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
		if (event.getSource() == flyOutLocationCheck) {
			flyOutLocationCheckNewValue = (String) event.getNewValue();
		} else if (event.getSource() == missingEarnedPoint) {
			missingEarnedPointNewValue = (String) event.getNewValue();
		}
	}

}
