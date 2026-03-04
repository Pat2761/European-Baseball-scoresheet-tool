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

import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
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

   /** Reference on the graphical preference composite */
   private GraphicalPreferenceComposite graphicalPreferenceComposite;

   /**
    * Constructor of the page.
    * 
    * @wbp.parser.constructor
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
      // Nothing to do
   }

   @Override
   protected Control createContents(Composite parent) {
      IEclipsePreferences store = ScorePreferencesManager.getInstance().getWorkspacePreferenceStore();
      graphicalPreferenceComposite = new GraphicalPreferenceComposite(parent, store);
      return graphicalPreferenceComposite;
   }

   @Override
   protected void performApply() {
      graphicalPreferenceComposite.performApply();
      super.performApply();
   }

   @Override
   protected void performDefaults() {
      graphicalPreferenceComposite.performDefaults();
      super.performDefaults();
   }

   @Override
   public boolean performOk() {
      graphicalPreferenceComposite.performOk();
      return super.performOk();
   }

   @Override
   public void propertyChange(PropertyChangeEvent event) {
      // Nothing to do
   }
}
