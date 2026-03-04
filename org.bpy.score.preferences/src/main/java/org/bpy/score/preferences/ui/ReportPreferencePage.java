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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for display report preferences.
 * 
 * @author Patrick BRIAND
 */
public class ReportPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, IPathSelectionCompositeChange {

   /** Reference on the page which allow to configure the parameters */
   private ReportParameterComposite reportParameterComposite;

   /**
    * Constructor of the class.
    * 
    * @wbp.parser.constructor
    */
   public ReportPreferencePage() {
      // Nothing to do
   }

   /**
    * Constructor of the class.
    * 
    * @param title title of the panel
    */
   public ReportPreferencePage(String title) {
      super(title);
      // Nothing to do
   }

   /**
    * Constructor of the class.
    * 
    * @param title title of the panel
    * @param image image to display
    */
   public ReportPreferencePage(String title, ImageDescriptor image) {
      super(title, image);
      // Nothing to do
   }

   @Override
   public void init(IWorkbench workbench) {
      // Nothing to do
   }

   @Override
   protected Control createContents(Composite parent) {
      IEclipsePreferences store = ScorePreferencesManager.getInstance().getWorkspacePreferenceStore();
      reportParameterComposite = new ReportParameterComposite(parent, store, this);
      return reportParameterComposite;
   }

   @Override
   protected void performApply() {
      reportParameterComposite.performApply();
      super.performApply();
   }

   @Override
   protected void performDefaults() {
      reportParameterComposite.performDefaults();
      super.performDefaults();
   }

   @Override
   public boolean performOk() {
      reportParameterComposite.performOk();
      return super.performOk();
   }

   @Override
   public void pathSelectionChanged(PathSelectionCompositeStatus status) {
      if (reportParameterComposite != null) {
         String resultValue = reportParameterComposite.validate();
         if (resultValue != null) {
            setValid(false);
            setErrorMessage(resultValue);
            return;
         }
      }
      setValid(true);
      setErrorMessage(null);
   }

}
