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
package org.bpy.score.preferences.ui;

import java.util.logging.Logger;

import org.bpy.score.internationalization.preferences.Messages;
import org.bpy.score.preferences.core.ScorePreferenceConstants;
import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.ScrolledComposite;

/**
 * Preference page for the graphical choice
 * 
 * @author Patrick BRIAND
 *
 */
public class GraphicalPreferenceComposite extends Composite implements IScopePreferenceChange {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(GraphicalPreferenceComposite.class.getCanonicalName());

   /** SWT composite for select the line color */
   private ColorSelector lineColorSelector;
   /** SWT composite for select the text color */
   private ColorSelector textColorSelector;

   /** Preference store use for the preferences */
   private IEclipsePreferences preferenceStore;

   /** SWT Combo for select the level of statistics */
   private Combo displayStatistics;

   /** SWT Button for define the usage a the new style sheet */
   private Button useNewSheetStyle;

   /** SWT Button use for allow the display the pitcher state */
   private Button displayPitcherWinner;

   /**
    * Constructor of the page.
    * 
    * @param parent          parent composite
    * @param preferenceStore preference store used for save the values
    * 
    * @wbp.parser.constructor
    */
   public GraphicalPreferenceComposite(Composite parent, IEclipsePreferences preferenceStore) {
      super(parent, SWT.NONE);
      this.preferenceStore = preferenceStore;
      createContents();
   }

   /**
    * Create the content of the panel.
    */
   private void createContents() {

      this.setLayout(new GridLayout(3, false));

      Label lblNewLabel = new Label(this, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      lblNewLabel.setText(Messages.GraphicalPreferencePage_LineColorLabel);

      lineColorSelector = new ColorSelector(this);
      GridData gdColorSelector = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
      gdColorSelector.heightHint = 25;
      lineColorSelector.setLayoutData(gdColorSelector);

      Label lblNewLabelEmpty = new Label(this, SWT.NONE);
      lblNewLabelEmpty.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      lblNewLabelEmpty.setText("");

      Label lblNewLabel2 = new Label(this, SWT.NONE);
      lblNewLabel2.setText(Messages.GraphicalPreferencePage_PencilColorLabel);

      textColorSelector = new ColorSelector(this);
      GridData gdTextColorSelector = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
      gdTextColorSelector.heightHint = 25;
      textColorSelector.setLayoutData(gdTextColorSelector);
      new Label(this, SWT.NONE);

      useNewSheetStyle = new Button(this, SWT.CHECK);
      useNewSheetStyle.setText(Messages.GraphicalPreferencePage_NewStyleSheetDisplay);
      new Label(this, SWT.NONE);
      new Label(this, SWT.NONE);

      displayPitcherWinner = new Button(this, SWT.CHECK);
      displayPitcherWinner.setText(Messages.GraphicalPreferencePage_DisplayWinLoseSave);
      new Label(this, SWT.NONE);
      new Label(this, SWT.NONE);

      Label lblNewLabel3 = new Label(this, SWT.NONE);
      lblNewLabel3.setText(Messages.GraphicalPreferencePage_DisplayStatisticsLabel);
      new Label(this, SWT.NONE);
      new Label(this, SWT.NONE);

      displayStatistics = new Combo(this, SWT.NONE);
      displayStatistics.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      new Label(this, SWT.NONE);
      new Label(this, SWT.NONE);

      Label lblPreview = new Label(this, SWT.NONE);
      lblPreview.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      lblPreview.setText(Messages.GraphicalPreferencePage_preview);
      new Label(this, SWT.NONE);
      new Label(this, SWT.NONE);

      ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
      scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
      scrolledComposite.setExpandHorizontal(true);
      scrolledComposite.setExpandVertical(true);

      initContent();
   }

   /**
    * Initialize the content with the preference values
    */
   private void initContent() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      RGB rgb = preferenceManager.getRGBValue(preferenceStore, ScorePreferenceConstants.GPP_GRAPHIC_COLOR_LINE);
      lineColorSelector.setRGB(rgb);
      rgb = preferenceManager.getRGBValue(preferenceStore, ScorePreferenceConstants.GPP_GRAPHIC_WRITING_LINE);
      textColorSelector.setRGB(rgb);

      displayStatistics.removeAll();
      displayStatistics.add(Messages.GraphicalPreferencePage_NoStatistics);
      displayStatistics.add(Messages.GraphicalPreferencePage_Sf1Display);
      displayStatistics.add(Messages.GraphicalPreferencePage_FullDisplay);
      displayStatistics.setData(Messages.GraphicalPreferencePage_NoStatistics, ScorePreferenceConstants.GPP_NO_STATISTC_DISPLAY);
      displayStatistics.setData(Messages.GraphicalPreferencePage_Sf1Display, ScorePreferenceConstants.GPP_SF1_STATISTC_DISPLAY);
      displayStatistics.setData(Messages.GraphicalPreferencePage_FullDisplay, ScorePreferenceConstants.GPP_FULL_STATISTC_DISPLAY);

      String staticticLevel = preferenceManager.getValue(preferenceStore, ScorePreferenceConstants.GPP_DISPLAY_STATISTICS);
      switch (staticticLevel){
      case ScorePreferenceConstants.GPP_NO_STATISTC_DISPLAY:
         displayStatistics.select(0);
         break;
      case ScorePreferenceConstants.GPP_SF1_STATISTC_DISPLAY:
         displayStatistics.select(1);
         break;
      case ScorePreferenceConstants.GPP_FULL_STATISTC_DISPLAY:
         displayStatistics.select(2);
         break;
      default:
         displayStatistics.select(2);
         break;
      }
      
      useNewSheetStyle.setSelection(preferenceManager.getBooleanValue(preferenceStore, ScorePreferenceConstants.GPP_USE_NEW_STYLE_SHEET));
      displayPitcherWinner.setSelection(preferenceManager.getBooleanValue(preferenceStore, ScorePreferenceConstants.GPP_DISPLAY_PITCHER_STATE));
   }

   /**
    * Perform the apply button and save values in the preferences.
    */
   public void performApply() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      preferenceManager.setValue(preferenceStore, ScorePreferenceConstants.GPP_GRAPHIC_COLOR_LINE, lineColorSelector.getRGB());
      preferenceManager.setValue(preferenceStore, ScorePreferenceConstants.GPP_GRAPHIC_WRITING_LINE, textColorSelector.getRGB());

      int selectedStatisticIndex = displayStatistics.getSelectionIndex();
      String selectedValue = displayStatistics.getItem(selectedStatisticIndex);
      preferenceManager.setValue(preferenceStore, ScorePreferenceConstants.GPP_DISPLAY_STATISTICS, (String) displayStatistics.getData(selectedValue));

      preferenceManager.setValue(preferenceStore, ScorePreferenceConstants.GPP_DISPLAY_PITCHER_STATE, displayPitcherWinner.getSelection());
      preferenceManager.setValue(preferenceStore, ScorePreferenceConstants.GPP_USE_NEW_STYLE_SHEET, useNewSheetStyle.getSelection());
   }

   /**
    * Perform default button and restore defaults values.
    */
   public void performDefaults() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      lineColorSelector.setRGB(preferenceManager.getDefaultRGBValue(ScorePreferenceConstants.GPP_GRAPHIC_COLOR_LINE));
      textColorSelector.setRGB(preferenceManager.getDefaultRGBValue(ScorePreferenceConstants.GPP_GRAPHIC_WRITING_LINE));
      
      String staticticLevel = preferenceManager.getDefaultValue(ScorePreferenceConstants.GPP_DISPLAY_STATISTICS);
      switch (staticticLevel){
      case ScorePreferenceConstants.GPP_NO_STATISTC_DISPLAY:
         displayStatistics.select(0);
         break;
      case ScorePreferenceConstants.GPP_SF1_STATISTC_DISPLAY:
         displayStatistics.select(1);
         break;
      case ScorePreferenceConstants.GPP_FULL_STATISTC_DISPLAY:
         displayStatistics.select(2);
         break;
      default:
         displayStatistics.select(2);
         break;
      }

      displayPitcherWinner.setSelection(preferenceManager.getBooleanDefaultValue(ScorePreferenceConstants.GPP_DISPLAY_PITCHER_STATE));
      useNewSheetStyle.setSelection(preferenceManager.getBooleanDefaultValue(ScorePreferenceConstants.GPP_USE_NEW_STYLE_SHEET));
      
   }

   /**
    * Perform OK button and apply new values in the preferences.
    */
   public void performOk() {
      performApply();
   }

   @Override
   public void storePreferenceChange(IEclipsePreferences preferenceScope) {
      this.preferenceStore = preferenceScope;
      initContent();
   }
}
