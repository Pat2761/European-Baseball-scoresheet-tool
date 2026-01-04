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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;

/**
 * Preference page for setting the Game report generation preferences
 * 
 * @author Patrick BRIAND
 */
public class ReportParameterComposite extends AbstractScorePreferenceComposite implements IPathSelectionCompositeChange {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(ReportParameterComposite.class.getCanonicalName());

   /** SWT composite for select CSS file */
   private PathSelectionComposite cssFileSelector;
   /** SWT Composite for select XSLT file */
   private PathSelectionComposite xsltFileSelector;
   /** SWT Composite for select banner file */
   private PathSelectionComposite bannerFileSelector;
   /** Check box for export the report in a XML File */
   private Button exportAsXmlBtn;
   /** Check box for export the report in a HTML File */
   private Button exportAsHtmlBtn;
   /** property or preference page which is using the composite */
   private IPathSelectionCompositeChange listener;

   /**
    * Constructor of the page.
    * 
    * @param parent parent composite
    * @param store  preference store used
    * @param listener property or preference page which is using the composite
    */
   public ReportParameterComposite(Composite parent, IEclipsePreferences store, IPathSelectionCompositeChange listener) {
      super(parent, store);
      this.listener = listener;
   }

   /**
    * Get the CSS File path
    * 
    * @return CSS file path
    */
   public String getCSSFileLocation() {
      return cssFileSelector.getResolvedAbsolutePath();
   }
   
   /**
    * Get the XSLT File path
    * 
    * @return XSLT file path
    */
   public String getXSLTFileLocation() {
      return xsltFileSelector.getResolvedAbsolutePath();
   }
   
   /**
    * Get the Banner File path
    * 
    * @return Banner file path
    */
   public String getBannerFilePath() {
      return bannerFileSelector.getResolvedAbsolutePath();
   }
   
   /**
    * Populate the panel.
    */
   @Override
   public void createPreferenceContent() {
      setLayout(new GridLayout(1, false));

      cssFileSelector = new PathSelectionComposite(this, SWT.NONE);
      cssFileSelector.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      cssFileSelector.setMessage("Define the CSS file:");
      cssFileSelector.setFeatures(IResource.FILE, new PathSelectionFileFilter(IResource.FILE, new String[] { "css" }));
      cssFileSelector.addPathChangerListener(this);

      xsltFileSelector = new PathSelectionComposite(this, SWT.NONE);
      xsltFileSelector.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      xsltFileSelector.setMessage(Messages.GameReportPreferencePage_pathSelectionComposite_1_message);
      xsltFileSelector.setFeatures(IResource.FILE, new PathSelectionFileFilter(IResource.FILE, new String[] { "xslt" }));
      xsltFileSelector.addPathChangerListener(this);

      bannerFileSelector = new PathSelectionComposite(this, SWT.NONE);
      bannerFileSelector.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      bannerFileSelector.setMessage(Messages.GameReportPreferencePage_pathSelectionComposite_message);
      bannerFileSelector.setFeatures(IResource.FILE, new PathSelectionFileFilter(IResource.FILE, new String[] { "jpg", "png" }));
      bannerFileSelector.addPathChangerListener(this);

      exportAsHtmlBtn = new Button(this, SWT.RADIO);
      exportAsHtmlBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      exportAsHtmlBtn.setSelection(true);
      exportAsHtmlBtn.setToolTipText(Messages.GameReportPreferencePage_HtmlExport_Tooltip);
      exportAsHtmlBtn.setText(Messages.GameReportPreferencePage_HtmlExport_Text);

      exportAsXmlBtn = new Button(this, SWT.RADIO);
      exportAsXmlBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      exportAsXmlBtn.setToolTipText(Messages.GameReportPreferencePage_XmlExport_Tooltip);
      exportAsXmlBtn.setText(Messages.GameReportPreferencePage_XmlExport_Text);

      initContent();
   }

   /**
    * Initialize the content of panel.
    */
   @Override
   protected void initContent() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      cssFileSelector.setText(preferenceManager.getValue(store, ScorePreferenceConstants.GRW_CSS_FILE_PATH));
      xsltFileSelector.setText(preferenceManager.getValue(store, ScorePreferenceConstants.GRW_XSLT_FILE_PATH));
      bannerFileSelector.setText(preferenceManager.getValue(store, ScorePreferenceConstants.GRW_BANNER_FILE_PATH));

      String documentStyle = preferenceManager.getValue(store, ScorePreferenceConstants.GRW_PREFERENCE_TYPE_GENERATED_FILE);

      if (ScorePreferenceConstants.GRW_TYPE_XML.equals(documentStyle)) {
         exportAsXmlBtn.setSelection(true);
         exportAsHtmlBtn.setSelection(false);
      } else {
         exportAsXmlBtn.setSelection(false);
         exportAsHtmlBtn.setSelection(true);
      }
   }

   /**
    * Validate the content of the panel
    * 
    * @return String message
    */
   public String validate() {
      PathSelectionCompositeStatus cssStatus = cssFileSelector.validateSelection();
      if (cssStatus != PathSelectionCompositeStatus.OK) {
         return buildErrorMessage(Messages.ReportParameterComposite_CSSConfiguration, cssStatus);
      }

      PathSelectionCompositeStatus xsltStatus = xsltFileSelector.validateSelection();
      if (xsltStatus != PathSelectionCompositeStatus.OK) {
         return buildErrorMessage(Messages.ReportParameterComposite_XSLTConfiguration, xsltStatus);
      }

      PathSelectionCompositeStatus bannerStatus = bannerFileSelector.validateSelection();
      if (bannerStatus != PathSelectionCompositeStatus.OK) {
         return buildErrorMessage(Messages.ReportParameterComposite_BannerConfiguration, bannerStatus);
      }

      return null;
   }

   /**
    * Build the error message.
    * 
    * @param rootMessage Message to display
    * @param status status to add to the message
    * 
    * @return String which contains the error message
    */
   private String buildErrorMessage(String rootMessage, PathSelectionCompositeStatus status) {
      switch (status) {
      case BAD_FILE_NAME:
         return NLS.bind(rootMessage, Messages.NotAValidFileName);
      case NOT_A_FILE:
         return NLS.bind(rootMessage, Messages.NotAFile);
      case BAD_FILE_TYPE:
         return NLS.bind(rootMessage, Messages.BadFileType);
      default:
         return NLS.bind(rootMessage, Messages.undefinedError);
      }
   }

   @Override
   protected void savePreferences() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      preferenceManager.setValue(store, ScorePreferenceConstants.GRW_CSS_FILE_PATH, cssFileSelector.getDisplayPath());
      preferenceManager.setValue(store, ScorePreferenceConstants.GRW_XSLT_FILE_PATH, xsltFileSelector.getDisplayPath());
      preferenceManager.setValue(store, ScorePreferenceConstants.GRW_BANNER_FILE_PATH, bannerFileSelector.getDisplayPath());

      if (exportAsXmlBtn.getSelection()) {
         preferenceManager.setValue(store, ScorePreferenceConstants.GRW_PREFERENCE_TYPE_GENERATED_FILE, ScorePreferenceConstants.GRW_TYPE_XML);
      } else {
         preferenceManager.setValue(store, ScorePreferenceConstants.GRW_PREFERENCE_TYPE_GENERATED_FILE, ScorePreferenceConstants.GRW_TYPE_HTML);
      }
   }

   @Override
   protected void setDefaultValues() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();
      cssFileSelector.setText(preferenceManager.getDefaultValue(ScorePreferenceConstants.GRW_CSS_FILE_PATH));
      xsltFileSelector.setText(preferenceManager.getDefaultValue(ScorePreferenceConstants.GRW_XSLT_FILE_PATH));
      bannerFileSelector.setText(preferenceManager.getDefaultValue(ScorePreferenceConstants.GRW_BANNER_FILE_PATH));
   }

   @Override
   public void pathSelectionChanged(PathSelectionCompositeStatus status) {
      if (listener != null) {
         listener.pathSelectionChanged(status);
      }
   }
}
