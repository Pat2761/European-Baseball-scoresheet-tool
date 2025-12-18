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
import org.eclipse.core.resources.IResource;
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
import org.eclipse.swt.widgets.Group;
import org.bpy.score.preferences.ui.PathSelectionComposite;

/**
 * This class is the page one of generation report wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportWizardPageTwo extends WizardPage implements SelectionListener, ModifyListener {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(GameReportWizardPageOne.class.getSimpleName());

   /** Select file button text */
   public static final String SELECT_FILE_BUTTOB_TEXT = "..."; //$NON-NLS-1$

   /** Select predefined configuration */
   private Button btnStandardConf;

   /** state of the page two */
   private boolean isValid;

   /** SWT composite for select a CSS file */
   private PathSelectionComposite cssFilePath;
   /** SWT composite for select a XSLT file */
   private PathSelectionComposite xsltFilePath;
   /** SWT Composite for select the banner of the HTML file */
   private PathSelectionComposite bannerFilePath;

   private Group specificProjectGroup;

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
      return cssFilePath.getResolvedAbsolutePath();
   }

   /**
    * Get Banner file path
    * 
    * @return banner file path
    */
   public String getBannerFilePath() {
      return bannerFilePath.getResolvedAbsolutePath();
   }

   /**
    * Get XSLT file path
    * 
    * @return XSLT file path
    */
   public String getXsltFilePath() {
      return xsltFilePath.getResolvedAbsolutePath();
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

      specificProjectGroup = new Group(container, SWT.NONE);
      specificProjectGroup.setLayout(new GridLayout(1, false));
      specificProjectGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
      specificProjectGroup.setText(Messages.GameReportWizardPageTwo_grpTtt_text);

      cssFilePath = new PathSelectionComposite(specificProjectGroup, SWT.NONE);
      cssFilePath.setMessage(Messages.GameReportWizardPageTwo_CSSPathFile);
      cssFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      cssFilePath.setFeatures(IResource.FILE, file -> file.isFile() && file.getName().toLowerCase().endsWith(".css")); //$NON-NLS-1$

      xsltFilePath = new PathSelectionComposite(specificProjectGroup, SWT.NONE);
      xsltFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      xsltFilePath.setMessage(Messages.GameReportWizardPageTwo_XSLTPathFile);
      xsltFilePath.setFeatures(IResource.FILE, file -> file.isFile() && file.getName().toLowerCase().endsWith(".xslt")); //$NON-NLS-1$

      bannerFilePath = new PathSelectionComposite(specificProjectGroup, SWT.NONE);
      bannerFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      bannerFilePath.setMessage(Messages.GameReportWizardPageTwo_BannerPathFile);
      bannerFilePath.setFeatures(IResource.FILE,
            file -> file.isFile() && (file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".png"))); //$NON-NLS-1$ //$NON-NLS-2$

      btnStandardConf.addSelectionListener(this);

      ScorePreferencesManager preferenceInstance = ScorePreferencesManager.getInstance();
      btnStandardConf.setSelection(preferenceInstance.getValue(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION));
      cssFilePath.setText(preferenceInstance.getValue(ScorePreferenceConstants.GRW_CSS_FILE_PATH));
      xsltFilePath.setText(preferenceInstance.getValue(ScorePreferenceConstants.GRW_XSLT_FILE_PATH));
      bannerFilePath.setText(preferenceInstance.getValue(ScorePreferenceConstants.GRW_BANNER_FILE_PATH));

      checkIsvalid();
   }

   /**
    * Check if page one is valid
    */
   private void checkIsvalid() {
      if (btnStandardConf.getSelection()) {
         isValid = true;

         setErrorMessage(null);
         setPageComplete(true);

      } else {
         if (!cssFilePath.isValid()) {
            setErrorMessage(Messages.GameReportWizardPageTwo_CSSSelectionMessage);
            setPageComplete(false);
            return;
         }
         if (!xsltFilePath.isValid()) {
            setErrorMessage(Messages.GameReportWizardPageTwo_XSLTSelectionMessage);
            setPageComplete(false);
            return;
         }
         if (!bannerFilePath.isValid()) {
            setErrorMessage(Messages.GameReportWizardPageTwo_BannerSelectionMessage);
            setPageComplete(false);
            return;
         }

         setErrorMessage(null);
         setPageComplete(true);
      }
   }

   @Override
   public void widgetSelected(SelectionEvent e) {
      if (e.getSource() == btnStandardConf) {
         setEnabledRecursive(specificProjectGroup, btnStandardConf.getSelection());
         checkIsvalid();
      }
   }

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

      if (btnStandardConf.getSelection()) {
         ScorePreferencesManager preferenceInstance = ScorePreferencesManager.getInstance();
         preferenceInstance.setValue(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION, btnStandardConf.getSelection());
         preferenceInstance.setValue(ScorePreferenceConstants.GRW_CSS_FILE_PATH, cssFilePath.getDisplayPath());
         preferenceInstance.setValue(ScorePreferenceConstants.GRW_XSLT_FILE_PATH, xsltFilePath.getDisplayPath());
         preferenceInstance.setValue(ScorePreferenceConstants.GRW_BANNER_FILE_PATH, bannerFilePath.getDisplayPath());
      }
   }

   @Override
   public void modifyText(ModifyEvent e) {
      // Nothing to do
   }
}
