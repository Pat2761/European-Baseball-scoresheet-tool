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
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.PropertyPage;

/**
 * Class which manage the graphical properties page.
 * 
 * @author Patrick BRIAND
 */
public class ControlPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

   /** Button which specify is we are using project configuration */
   private Button useProjectConfiguration;
   /** Reference on the SWT Composite for define the parameters */
   private ControlPreferenceComposite controlPreferenceComposite;

   /**
    * Constructor of the class.
    */
   public ControlPropertyPage() {
      // nothing to do
   }

   @Override
   protected Control createContents(Composite parent) {
      Composite composite = new Composite(parent, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));

      Composite composite1 = new Composite(composite, SWT.NONE);
      composite1.setLayout(new GridLayout(3, false));
      composite1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      useProjectConfiguration = new Button(composite1, SWT.CHECK);
      useProjectConfiguration.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            changeScopeLevel(useProjectConfiguration.getSelection());
         }
      });
      useProjectConfiguration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      useProjectConfiguration.setText(Messages.EnableProjectSetting);

      Label lblNewLabel = new Label(composite1, SWT.NONE);
      lblNewLabel.setText(Messages.GraphicalPropertyPage_lblNewLabel_text); // $NON-NLS-1$

      Link link = new Link(composite1, SWT.NONE);
      link.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            displayPreferencePage(parent);
         }
      });
      link.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      link.setText("<a>" + Messages.ConfigureWorkspaceSetting + "</a>");//$NON-NLS-1$ //$NON-NLS-2$

      IEclipsePreferences store = ScorePreferencesManager.getInstance().getProjectPreferenceStore();
      controlPreferenceComposite = new ControlPreferenceComposite(composite, store);
      controlPreferenceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

      initContent();
      return composite;
   }

   /**
    * Initialize the content of the panel.
    */
   private void initContent() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();
      IEclipsePreferences store = preferenceManager.getProjectPreferenceStore();

      Boolean useProjectSettings = preferenceManager.getBooleanValue(store, ScorePreferenceConstants.CPP_USE_REPORT_PROJECT_SETTING);
      useProjectConfiguration.setSelection(useProjectSettings);
      changeScopeLevel(useProjectSettings);
   }
   /**
    * Change the scope level.
    * @param projectScope scope level
    */
   protected void changeScopeLevel(boolean projectScope) {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      IEclipsePreferences preferenceScope;
      if (projectScope) {
         preferenceScope = preferenceManager.getProjectPreferenceStore();
      } else {
         preferenceScope = preferenceManager.getWorkspacePreferenceStore();
      }

      if (preferenceScope != null) {
         controlPreferenceComposite.storePreferenceChange(preferenceScope);
      }

      setState(controlPreferenceComposite, projectScope);
   }

   /**
    * Change the state of parameter composite.
    * 
    * @param swtElement   composite eelement
    * @param projectScope state of the composite
    */
   private void setState(Composite swtElement, boolean projectScope) {
      swtElement.setEnabled(projectScope);
      for (Control child : swtElement.getChildren()) {
         if (child instanceof Composite subComposite) {
            setState(subComposite, projectScope);
         } else {
            child.setEnabled(projectScope);
         }
      }
   }

   /**
    * Display the preference panel.
    * 
    * @param parent Parent composite
    */
   protected void displayPreferencePage(Composite parent) {
      PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(parent.getShell(), "org.bpy.score.rcp.preferences.controls", //$NON-NLS-1$
            null, null);
      if (dialog != null) {
         dialog.open();
      }
   }

   @Override
   protected void performApply() {
      saveValues();
      controlPreferenceComposite.performApply();
      super.performApply();
   }

   @Override
   protected void performDefaults() {
      controlPreferenceComposite.performDefaults();
      super.performDefaults();
   }

   @Override
   public boolean performOk() {
      saveValues();
      controlPreferenceComposite.performOk();
      return super.performOk();
   }

   /** 
    * Memorize the parameters specific to this panel
    * 
    */
   private void saveValues() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();
      
      boolean projectScope = useProjectConfiguration.getSelection();
      IEclipsePreferences preferenceScope;
      preferenceScope = preferenceManager.getProjectPreferenceStore();
      preferenceManager.setValue(preferenceScope, ScorePreferenceConstants.CPP_USE_REPORT_PROJECT_SETTING, projectScope);
   }
}
