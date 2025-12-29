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

import org.bpy.score.internationalization.preferences.Messages;
import org.bpy.score.preferences.core.ScorePreferenceConstants;
import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;

/**
 * Preference page for the control of the game file
 * 
 * @author Patrick BRIAND
 *
 */
public class ControlPreferenceComposite extends AbstractScorePreferenceComposite implements IScopePreferenceChange {

   /** SWT Widget for select compile level error on the fly out */
   private Combo flyOutLocation;

   /** POssibles compile levels */
   private static final String[] COMPILATION_LEVEL = { Messages.Compile_Ignore, Messages.Compile_Warning, Messages.Compile_Error };

   /**
    * Constructor of the page.
    * 
    * @param parent          parent composite
    * @param preferenceStore preference store used for save the values
    * 
    * @wbp.parser.constructor
    */
   public ControlPreferenceComposite(Composite parent, IEclipsePreferences preferenceStore) {
      super(parent, preferenceStore);
   }

   /**
    * Create the content of the panel.
    */
   @Override
   public void createPreferenceContent() {

      setLayout(new GridLayout(2, false));

      Label lblNewLabel = new Label(this, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
      lblNewLabel.setText(Messages.ControlPreferencePage_FlyOutLocationlabel);

      flyOutLocation = new Combo(this, SWT.NONE);
      GridData gdCombo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
      gdCombo.widthHint = 120;
      flyOutLocation.setLayoutData(gdCombo);
      flyOutLocation.setItems(COMPILATION_LEVEL);

      initContent();
   }

   /**
    * Initialize the content with the preference values
    */
   @Override
   protected void initContent() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      String level = preferenceManager.getValue(store, ScorePreferenceConstants.CPP_FLYOUT_CONTROL);
      flyOutLocation.select(getCompileIndexOf(level));
   }

   /**
    * Get the preference value of compile level.
    * 
    * @param selectionIndex Index of the combo
    * 
    * @return preference value of compile level
    */
   private String getCompileLevel(int selectionIndex) {
      switch (selectionIndex) {
      case 0:
         return ScorePreferenceConstants.CPP_FLYOUT_CONTROL_NONE;
      case 1:
         return ScorePreferenceConstants.CPP_FLYOUT_CONTROL_WARNING;
      case 2:
         return ScorePreferenceConstants.CPP_FLYOUT_CONTROL_ERROR;
      default:
         return ScorePreferenceConstants.CPP_FLYOUT_CONTROL_DEFAULT_VALUE;
      }
   }

   /**
    * Get the index of a compile error store in preferences.
    * 
    * @param level level to check
    * 
    * @return index of the combo
    */
   private int getCompileIndexOf(String level) {
      if (ScorePreferenceConstants.CPP_FLYOUT_CONTROL_NONE.equals(level)) {
         return 0;
      } else if (ScorePreferenceConstants.CPP_FLYOUT_CONTROL_WARNING.equals(level)) {
         return 1;
      } else if (ScorePreferenceConstants.CPP_FLYOUT_CONTROL_ERROR.equals(level)) {
         return 2;
      } else {
         return 0;
      }
   }

   @Override
   protected void savePreferences() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      String compileLevel = getCompileLevel(flyOutLocation.getSelectionIndex());
      preferenceManager.setValue(store, ScorePreferenceConstants.CPP_FLYOUT_CONTROL, compileLevel);
   }

   @Override
   protected void setDefaultValues() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      String defaultValue = preferenceManager.getDefaultValue(ScorePreferenceConstants.CPP_FLYOUT_CONTROL);
      flyOutLocation.select(getCompileIndexOf(defaultValue));
   }
}
