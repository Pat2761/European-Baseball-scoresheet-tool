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
import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ReportPropertyPage extends PropertyPage implements IWorkbenchPropertyPage, IPathSelectionCompositeChange {

   private ReportParameterComposite reportParameterComposite;
   
   public ReportPropertyPage() {
      // Nothing to do
   }

   @Override
   protected Control createContents(Composite parent) {
      
      Composite composite = new Composite(parent, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));
      
      Composite composite_1 = new Composite(composite, SWT.NONE);
      composite_1.setLayout(new GridLayout(3, false));
      composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      Button btnCheckButton = new Button(composite_1, SWT.CHECK);
      btnCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      btnCheckButton.setText(Messages.EnableProjectSetting);
      
      Label lblNewLabel = new Label(composite_1, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
      lblNewLabel.setText(Messages.ReportPropertyPageParameters_lblNewLabel_text);
      
      Link link = new Link(composite_1, SWT.NONE);
      link.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            displayPreferencePage(parent);
         }
      });
      link.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      link.setText("<a>" + Messages.ConfigureWorkspaceSetting + "</a>");//$NON-NLS-1$ //$NON-NLS-2$
      
      IEclipsePreferences store = ScorePreferencesManager.getInstance().getProjectPreferenceStore();
      reportParameterComposite = new ReportParameterComposite(this, composite, store);
      reportParameterComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      return composite;
   }

   protected void displayPreferencePage(Composite parent) {
      PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(parent.getShell(),
            "org.bpy.score.preference.reports.game", //$NON-NLS-N$
            null, 
            null); 
         if (dialog != null) {
            dialog.open();
         }
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
      String resultValue = reportParameterComposite.validate();
      if (resultValue != null) {
         setValid(false);
         setErrorMessage(resultValue);
      }
      setValid(true);
      setErrorMessage(null);
   }
}
