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
package org.bpy.score.preferences.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.internationalization.preferences.Messages;
import org.bpy.score.preferences.Activator;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.BackingStoreException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;

/**
 * Singleton class for the management of the preferences.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("restriction")
public class ScorePreferencesManager {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(ScorePreferencesManager.class.getSimpleName());

   /**
    * Contains the list of listener.
    */
   private List<IScoreViewPreferenceChangeListener> scoreChangerListeners;

   /**
    * Contains the name of the parameter which define the use specific settings for
    * each page
    */
   private static final Map<String, String> useSpecificSettingsParameter = new HashMap<>();

   /**
    * Contains the default values of all parameters
    */
   private static final Map<String, Object> defaultValues = new HashMap<>();

   /** Static code */
   static {
      defaultValues.put(ScorePreferenceConstants.GRW_USE_REPORT_PROJECT_SETTING, ScorePreferenceConstants.GRW_USE_REPORT_PROJECT_SETTING_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.GRW_BANNER_FILE_PATH, ScorePreferenceConstants.GRW_BANNER_FILE_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_CSS_FILE_PATH, ScorePreferenceConstants.GRW_CSS_FILE_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY, ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION, ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_XSLT_FILE_PATH, ScorePreferenceConstants.GRW_XSLT_FILE_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_PREFERENCE_TYPE_GENERATED_FILE, ScorePreferenceConstants.GRW_TYPE_XML);

      defaultValues.put(ScorePreferenceConstants.GPP_USE_GRAPHICAL_PROJECT_SETTING, ScorePreferenceConstants.GPP_USE_GRAPHICAL_PROJECT_SETTING_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.GPP_GRAPHIC_COLOR_LINE, ScorePreferenceConstants.GPP_GRAPHIC_COLOR_LINE_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.GPP_GRAPHIC_WRITING_LINE, ScorePreferenceConstants.GPP_GRAPHIC_WRITING_LINE_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.GPP_DISPLAY_STATISTICS, ScorePreferenceConstants.GPP_FULL_STATISTC_DISPLAY);
      defaultValues.put(ScorePreferenceConstants.GPP_DISPLAY_PITCHER_STATE, ScorePreferenceConstants.GPP_DISPLAY_PITCHER_STATE_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.GPP_USE_NEW_STYLE_SHEET, ScorePreferenceConstants.GPP_USE_NEW_STYLE_SHEET_DEFAULT_VALUE);

      defaultValues.put(ScorePreferenceConstants.CPP_USE_CONTROL_PROJECT_SETTING, ScorePreferenceConstants.CPP_USE_CONTROL_PROJECT_SETTING_DEFAULT_VALUE);
      defaultValues.put(ScorePreferenceConstants.CPP_FLYOUT_CONTROL, ScorePreferenceConstants.CPP_FLYOUT_CONTROL_DEFAULT_VALUE);

      useSpecificSettingsParameter.put(ScorePreferenceConstants.GAME_REPORT_WIZARD, ScorePreferenceConstants.GRW_PROJECT_SCOPE);
   }

   /** reference on the instance of class */
   private static ScorePreferencesManager instance;

   /** instance on the workspace preference values */
   private IEclipsePreferences workspaceInstancePreferences;

   /** Map which contains instance preferences by properties page */
   static Map<String, InstancePreferences> propertyInstances = new HashMap<>();

   /**
    * Constructor of the class.
    * 
    */
   private ScorePreferencesManager() {
      workspaceInstancePreferences = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
      scoreChangerListeners = new ArrayList<>();

      workspaceInstancePreferences.putBoolean(ScorePreferenceConstants.GRW_PROJECT_SCOPE, true);
   }

   /**
    * Get the instance on the class. if project is null, the manager use the
    * project preference if the parameter useSpecificProjectPrefernce is true.
    * 
    * @return Instance of class
    */
   public static ScorePreferencesManager getInstance() {
      if (instance == null) {
         instance = new ScorePreferencesManager();
      }
      return instance;
   }

   /**
    * Get the workspace preferences.
    * 
    * @return worksapce preferences
    */
   public IEclipsePreferences getWorkspacePreferenceStore() {

      return workspaceInstancePreferences;
   }

   /**
    * Get the project preferences.
    * 
    * @return project preferences
    */
   public IEclipsePreferences getProjectPreferenceStore() {
      IProject project;

      try {
         project = getSelectedProject();
         if (project != null) {
            return new ProjectScope(project).getNode(project.getName());
         }

      } catch (ScorePreferenceManagerException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
      return getWorkspacePreferenceStore();

   }

   /**
    * Return the preference store of a project.
    * 
    * @param project reference to the project
    * @return reference on the project store
    */
   public IEclipsePreferences getProjectPreferenceStore(IProject project) {
      return new ProjectScope(project).getNode(project.getName());
   }

   /**
    * return the preference store for a defined flag.
    * 
    * @param useProjectFlag preference flag for a category of parameters
    * @return preference store
    */
   public IEclipsePreferences getPreferenceStore(String useProjectFlag) {
      IEclipsePreferences projectStore = getProjectPreferenceStore();
      if (getBooleanValue(projectStore, useProjectFlag)) {
         return projectStore;
      } else {
         return getWorkspacePreferenceStore();
      }
   }

   /**
    * Return a String value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @return String value
    */
   public String getValue(IEclipsePreferences store, String key) {
      Object defaultValue = defaultValues.get(key);

      return store.get(key, (String) defaultValue);
   }

   /**
    * Return the default value of a parameter.
    * 
    * @param key key value of the preferences
    * @return String value
    */
   public String getDefaultValue(String key) {
      Object defaultValue = defaultValues.get(key);

      return (String) defaultValue;
   }

   /**
    * set a string value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(IEclipsePreferences store, String key, String value) {
      store.put(key, value);
      try {
         store.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Return a double value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @return double value
    */
   public double getDoubleValue(IEclipsePreferences store, String key) {
      Object defaultValue = defaultValues.get(key);

      return store.getDouble(key, (double) defaultValue);
   }

   /**
    * Return the default value of a parameter.
    * 
    * @param key key value of the preferences
    * @return double value
    */
   public double getDoubleDefaultValue(String key) {
      Object defaultValue = defaultValues.get(key);

      return (double) defaultValue;
   }

   /**
    * Set a double value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(IEclipsePreferences store, String key, double value) {
      store.putDouble(key, value);
      try {
         store.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Return a boolean value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @return parameter value, defaultValue if not found
    */
   public boolean getBooleanValue(IEclipsePreferences store, String key) {
      Object defaultValue = defaultValues.get(key);
      if (defaultValue == null) {
         defaultValue = Boolean.FALSE;
      }
      return store.getBoolean(key, (boolean) defaultValue);
   }

   /**
    * Return the default value of a parameter.
    * 
    * @param key key value of the preferences
    * @return boolean value
    */
   public Boolean getDefaultBooleanValue(String key) {
      Object defaultValue = defaultValues.get(key);
      if (defaultValue == null) {
         defaultValue = Boolean.FALSE;
      }
      return (boolean) defaultValue;
   }

   /**
    * Return a boolean value store in the preferences.
    * 
    * @param store preference store
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(IEclipsePreferences store, String key, boolean value) {
      store.putBoolean(key, value);
      try {
         store.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Get a RGB value form the preferences.
    * 
    * @param store Preference store where is defined the parameter
    * @param key Parameter key
    * 
    * @return value of the parameter is found, the default value otherwise
    */
   public RGB getRGBValue(IEclipsePreferences store, String key) {

      Object defaultValue = defaultValues.get(key);
      if (defaultValue == null) {
         defaultValue = "255,255,255";
      }
      String rgbString = store.get(key, (String) defaultValue);
      String[] parts = rgbString.split(",");

      try {
         return new RGB(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
      } catch (NumberFormatException ex) {
         return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK).getRGB();
      }
   }

   /**
    * Get a RGB value default value .
    * 
    * @param key Parameter key
    * 
    * @return value of the parameter is found, the default value otherwise
    */
   public RGB getDefaultRGBValue(String key) {

      Object defaultValue = defaultValues.get(key);
      if (defaultValue == null) {
         defaultValue = "255,255,255";
      }
      String[] parts = ((String)defaultValue).split(",");

      try {
         return new RGB(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
      } catch (NumberFormatException ex) {
         return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK).getRGB();
      }
   }

   /**
    * Set the value of the parameter in the preference.
    * 
    * @param store Preference store where is defined the parameter
    * @param key Parameter key
    * @param rgb RGB value to save
    */
   public void setValue(IEclipsePreferences store, String key, RGB rgb) {
      String value = rgb.red + "," + rgb.green + "," + rgb.blue;
      store.put(key, value);
      try {
         store.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Get the state of project use specific settings for transcription parameters.
    * 
    * @param categoryName Name of the category
    * @return <b>true<b> Use specific setting, <b>false</b> otherwise
    */
   public boolean getScopeSetting(String categoryName) {
      return workspaceInstancePreferences.getBoolean(categoryName, false);

   }

   /**
    * Retrieve the project linked to a selection.
    * 
    * @return reference to a project, <b>null</b> if not found
    * @throws ScorePreferenceManagerException in case of error
    */
   private IProject getSelectedProject() throws ScorePreferenceManagerException {
      IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
      if (window != null) {
         ISelectionService service = window.getSelectionService();
         ISelection selection = service.getSelection();

         if (selection instanceof IStructuredSelection structuredSelection) {
            Object element = structuredSelection.getFirstElement();

            if (element instanceof IResource resource) {
               return resource.getProject();
            } else if (element != null) {

               throw new ScorePreferenceManagerException(NLS.bind(Messages.badTypeElement, element.getClass().getName()));
            }
         }
      }
      return null;
   }

   /**
    * Add a listener to the change of preference of the Hieroglyphic view.
    * 
    * @param listener
    */
   public void addScoreChangerListener(IScoreViewPreferenceChangeListener listener) {
      scoreChangerListeners.add(listener);
   }

   /**
    * Remove a listener to the change of preference of the Hieroglyphic view.
    * 
    * @param listener
    */
   public void removeScoreChangerListener(IScoreViewPreferenceChangeListener listener) {
      scoreChangerListeners.remove(listener);
   }

 }
