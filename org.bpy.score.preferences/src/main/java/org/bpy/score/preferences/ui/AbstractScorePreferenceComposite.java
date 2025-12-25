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

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Common class the display preference and property panel.
 * 
 * @author Patrick BRIAND
 */
public abstract class AbstractScorePreferenceComposite extends Composite implements IScopePreferenceChange{

   /** reference on the preference store */
   protected IEclipsePreferences store;

   /**
    * Constructor of the page.
    * 
    * @param parent parent composite
    * @param store  preference store used
    */
   protected AbstractScorePreferenceComposite(Composite parent, IEclipsePreferences store) {
      super(parent, SWT.NONE);
       this.store = store;
      createPreferenceContent();
   }
   
   /**
    * Populate the panel.
    */
   public abstract void createPreferenceContent();

   /**
    * Save values in the preferences
    */
   protected abstract void savePreferences();
 
   /**
    * Save values in the preferences
    */
   protected abstract void setDefaultValues();

   /**
    * initialize the content of the composite.
    */
   protected abstract void initContent();

   /**
    * Perform apply button.
    */
   public void performApply() {
      savePreferences();
   }
   
   /**
    * perform Ok button.
    */
   public void performOk() {
      savePreferences();
   }
   
   @Override
   public void storePreferenceChange(IEclipsePreferences preferenceScope) {
      store = preferenceScope;
      initContent();
   }

   /**
    * Perform defaults button.
    */
   public void performDefaults() {
      setDefaultValues();
    }

}
