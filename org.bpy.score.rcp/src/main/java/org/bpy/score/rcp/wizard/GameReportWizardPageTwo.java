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
package org.bpy.score.rcp.wizard;

import java.util.logging.Logger;

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.preferences.core.ScorePreferenceConstants;
import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.bpy.score.preferences.ui.IPathSelectionCompositeChange;
import org.bpy.score.preferences.ui.PathSelectionCompositeStatus;
import org.bpy.score.preferences.ui.ReportParameterComposite;

/**
 * This class is the page one of generation report wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportWizardPageTwo extends WizardPage implements IPathSelectionCompositeChange, SelectionListener, ModifyListener {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(GameReportWizardPageOne.class.getSimpleName());

   /** Select file button text */
   public static final String SELECT_FILE_BUTTOB_TEXT = "..."; //$NON-NLS-1$

   /** Select predefined configuration */
   private Button btnStandardConf;

   /** state of the page two */
   private boolean isValid;

   /** Report parameter composite */
   private ReportParameterComposite reportParameterComposite;

   /**
    * Create the wizard.
    */
   public GameReportWizardPageTwo() {
      super("wizardPage"); //$NON-NLS-1$
      setMessage(Messages.GameReportWizardPageTwo_PageMessage);
      setTitle(Messages.GameReportWizardPageTwo_PageTitle);
      setDescription(Messages.GameReportWizardPageTwo_PageDescription);
      isValid = false;
   }

   /**
    * Return the state of the page one
    * 
    * @return <b>true</b> is valid, <b>false</b> otherwise
    */
   public boolean isValid() {
      return isValid;
   }

   /**
    * Get CSS file path
    * 
    * @return CSS file path
    */
   public String getCssFilePath() {
      return reportParameterComposite.getCSSFileLocation();
   }

   /**
    * Get Banner file path
    * 
    * @return banner file path
    */
   public String getBannerFilePath() {
      return reportParameterComposite.getBannerFilePath();
   }

   /**
    * Get XSLT file path
    * 
    * @return XSLT file path
    */
   public String getXsltFilePath() {
      return reportParameterComposite.getXSLTFileLocation();
   }

   /**
    * Get standard configuration (use predefined CSS, XSTL and banner)
    * 
    * @return <b>true</b> predefined configuration, <b>false</b> otherwise
    */
   public boolean isStandardConf() {
      return btnStandardConf.getSelection();
   }

   /**
    * Create contents of the wizard.
    * 
    * @param parent
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NONE);

      setControl(container);
      container.setLayout(new GridLayout(1, false));

      btnStandardConf = new Button(container, SWT.CHECK);
      btnStandardConf.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      btnStandardConf.addSelectionListener(this);
      btnStandardConf.setText(Messages.GameReportWizardPageTwo_UseStandardConfiguration);

      IEclipsePreferences store = ScorePreferencesManager.getInstance().getProjectPreferenceStore();
      reportParameterComposite = new ReportParameterComposite(container, store, this);
      reportParameterComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

      initContent();
   }

   /**
    * Initialization of the panel with last options used.
    * 
    */
   private void initContent() {
      ScorePreferencesManager preferencesManager = ScorePreferencesManager.getInstance();
      IEclipsePreferences projectStore = preferencesManager.getProjectPreferenceStore();

      boolean useProjectConfiguration = preferencesManager.getBooleanValue(projectStore, ScorePreferenceConstants.GRW_USE_REPORT_PROJECT_SETTING);
      btnStandardConf.setSelection(useProjectConfiguration);
      changeScopeLevel(useProjectConfiguration);
      
      validateContent();
   }

   /**
    * Validate the content of the page.
    */
   private void validateContent() {
      if (reportParameterComposite != null) {
         String resultValue = reportParameterComposite.validate();
         if (resultValue != null) {
            setPageComplete(false);
            setErrorMessage(resultValue);
            return;
         }
      }
      setPageComplete(true);
      setErrorMessage(null);
   }

   /**
    * Change the scope level.
    * 
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
         reportParameterComposite.storePreferenceChange(preferenceScope);
      }

      setState(reportParameterComposite, projectScope);
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

   @Override
   public void widgetSelected(SelectionEvent e) {
      if (e.getSource() == btnStandardConf) {
         changeScopeLevel(btnStandardConf.getSelection());
      }
   }

   /**
    * Allow to enable or disable widget in a group of widget
    * 
    * @param composite
    * @param enabled   <b>true</b> enable all widgets,<b>false</b> disable all
    *                  widgets
    */
   public static void setEnabledRecursive(Composite composite, boolean enabled) {
      composite.setEnabled(enabled);
      for (Control child : composite.getChildren()) {
         if (child instanceof Composite compositeChild) {
            setEnabledRecursive(compositeChild, enabled);
         } else {
            child.setEnabled(enabled);
         }
      }
   }

   @Override
   public void widgetDefaultSelected(SelectionEvent e) {
      // not used
   }

   /**
    * Save configuration in the preference for the next call
    */
   public void savePreferences() {
      // Not used
   }

   @Override
   public void modifyText(ModifyEvent e) {
      // Nothing to do
   }

   @Override
   public void pathSelectionChanged(PathSelectionCompositeStatus status) {
      validateContent();
   }
}
