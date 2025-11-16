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

import java.awt.Color;

import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for the graphical choice
 * 
 * @author Patrick BRIAND
 *
 */
public class GraphicalPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, IPropertyChangeListener {

	/** Color selector widget for line color */
	private ColorFieldEditor lineColorSelector;
	/** Color selector widget for text color */
	private ColorFieldEditor textColorSelector;
	/** Combo widget for selected level of statistics */
	private ComboFieldEditor displayStatistics;
	/** Boolean widget for display Win/Lose/Save pitcher */
	private BooleanFieldEditor displayWinLoseSave;
	/** Boolean widget for display the new style sheet */
	private BooleanFieldEditor displayNewStyleSheet;
	/** memorize the display stattistics values */
	private String displayStatisticsValue;

	/**
	 * Constructor of the page.
	 */
	public GraphicalPreferencePage() {
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 */
	public GraphicalPreferencePage(String title) {
		super(title);
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 * @param image Image of the page
	 */
	public GraphicalPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	@SuppressWarnings("java:S2696")
	protected void performApply() {

		IPreferenceStore store = getPreferenceStore();
		PreferenceConverter.setValue(store, EngineConstants.GRAPHIC_COLOR_LINE,
				lineColorSelector.getColorSelector().getColorValue());
		PreferenceConverter.setValue(store, EngineConstants.GRAPHIC_COLOR_TEXT,
				textColorSelector.getColorSelector().getColorValue());

		store.setValue(EngineConstants.GRAPHIC_DISPLAY_STATISTICS, displayStatisticsValue);
		store.setValue(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER, displayWinLoseSave.getBooleanValue());
		store.setValue(EngineConstants.GRAPHIC_NEW_STYLE_SHEET, displayNewStyleSheet.getBooleanValue());

		EngineConstants.graphicsShowStatistiques = displayStatisticsValue;
		EngineConstants.graphicsShowNewStyleSheet = displayNewStyleSheet.getBooleanValue();
		EngineConstants.graphicsShowWinLoseSave = displayWinLoseSave.getBooleanValue();

		RGB rgb = lineColorSelector.getColorSelector().getColorValue();
		EngineConstants.graphicsColorSheet = new Color(rgb.red, rgb.green, rgb.blue);

		rgb = textColorSelector.getColorSelector().getColorValue();
		EngineConstants.graphicsColorPencil = new Color(rgb.red, rgb.green, rgb.blue);

		super.performApply();
	}

	@Override
	protected void performDefaults() {
		lineColorSelector.loadDefault();
		textColorSelector.loadDefault();

		displayStatistics.loadDefault();
		displayWinLoseSave.loadDefault();
		displayNewStyleSheet.loadDefault();

		super.performDefaults();
	}

	@Override
	@SuppressWarnings("java:S2696")
	public boolean performOk() {

		IPreferenceStore store = getPreferenceStore();
		PreferenceConverter.setValue(store, EngineConstants.GRAPHIC_COLOR_LINE,
				lineColorSelector.getColorSelector().getColorValue());
		PreferenceConverter.setValue(store, EngineConstants.GRAPHIC_COLOR_TEXT,
				textColorSelector.getColorSelector().getColorValue());

		store.setValue(EngineConstants.GRAPHIC_DISPLAY_STATISTICS, displayStatisticsValue);
		store.setValue(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER, displayWinLoseSave.getBooleanValue());
		store.setValue(EngineConstants.GRAPHIC_NEW_STYLE_SHEET, displayNewStyleSheet.getBooleanValue());

		EngineConstants.graphicsShowStatistiques = displayStatisticsValue;
		EngineConstants.graphicsShowNewStyleSheet = displayNewStyleSheet.getBooleanValue();
		EngineConstants.graphicsShowWinLoseSave = displayWinLoseSave.getBooleanValue();

		RGB rgb = lineColorSelector.getColorSelector().getColorValue();
		EngineConstants.graphicsColorSheet = new Color(rgb.red, rgb.green, rgb.blue);

		rgb = textColorSelector.getColorSelector().getColorValue();
		EngineConstants.graphicsColorPencil = new Color(rgb.red, rgb.green, rgb.blue);

		return super.performOk();
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite graphicalPreferencePage = new Composite(parent, 2);
		IPreferenceStore store = getPreferenceStore();

		lineColorSelector = new ColorFieldEditor(EngineConstants.GRAPHIC_COLOR_LINE,
				Messages.GraphicalPreferencePage_LineColorLabel, graphicalPreferencePage);
		lineColorSelector.getColorSelector()
				.setColorValue(PreferenceConverter.getColor(store, EngineConstants.GRAPHIC_COLOR_LINE));
		textColorSelector = new ColorFieldEditor(EngineConstants.GRAPHIC_COLOR_TEXT, 
				Messages.GraphicalPreferencePage_PencilColorLabel,graphicalPreferencePage);
		textColorSelector.getColorSelector()
				.setColorValue(PreferenceConverter.getColor(store, EngineConstants.GRAPHIC_COLOR_TEXT));

		String[][] statisticsDisplays = { 
				{ Messages.GraphicalPreferencePage_NoStatistics, EngineConstants.NO_STATS },
				{ Messages.GraphicalPreferencePage_Sf1Display, EngineConstants.SF1_STATS }, 
				{ Messages.GraphicalPreferencePage_FullDisplay, EngineConstants.FULL_STATS }, 
			};

		displayStatistics = new ComboFieldEditor(EngineConstants.GRAPHIC_DISPLAY_STATISTICS,
				Messages.GraphicalPreferencePage_DisplayStatisticsLabel, statisticsDisplays, graphicalPreferencePage);
		displayStatistics.setPreferenceName(EngineConstants.GRAPHIC_DISPLAY_STATISTICS);
		displayStatistics.setPreferenceStore(store);
		displayStatistics.load();
		displayStatistics.setPropertyChangeListener(this);

		displayWinLoseSave = new BooleanFieldEditor(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER,
				Messages.GraphicalPreferencePage_DisplayWinLoseSave, graphicalPreferencePage);
		displayWinLoseSave.setPreferenceName(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER);
		displayWinLoseSave.setPreferenceStore(store);
		displayWinLoseSave.load();

		displayNewStyleSheet = new BooleanFieldEditor(EngineConstants.GRAPHIC_NEW_STYLE_SHEET,
				Messages.GraphicalPreferencePage_NewStyleSheetDisplay, graphicalPreferencePage);
		displayNewStyleSheet.setPreferenceName(EngineConstants.GRAPHIC_NEW_STYLE_SHEET);
		displayNewStyleSheet.setPreferenceStore(store);
		displayNewStyleSheet.load();

		return graphicalPreferencePage;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == displayStatistics) {
			displayStatisticsValue = (String) event.getNewValue();
		}
	}
}
