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

   /** Collection which define the page which contains a property */
   private static final Map<String, String> parameterLocation = new HashMap<>();

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

   /**
    * Contains the default values of all parameters
    */
   private static final Map<String, Class<?>> parametersType = new HashMap<>();

   /** Static code */
   static {
      /*
       * ----------------------------------------------------------------------
       * Declare parameters of the Game report wizard
       * ----------------------------------------------------------------------
       */
      parameterLocation.put(ScorePreferenceConstants.GAME_REPORT_WIZARD, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_CSS_FILE_PATH, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_XSLT_FILE_PATH, ScorePreferenceConstants.GAME_REPORT_WIZARD);
      parameterLocation.put(ScorePreferenceConstants.GRW_BANNER_FILE_PATH, ScorePreferenceConstants.GAME_REPORT_WIZARD);

      defaultValues.put(ScorePreferenceConstants.GRW_BANNER_FILE_PATH, ScorePreferenceConstants.GRW_BANNER_FILE_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_CSS_FILE_PATH, ScorePreferenceConstants.GRW_CSS_FILE_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY, ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY, ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION, ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION_DEFAULT);
      defaultValues.put(ScorePreferenceConstants.GRW_XSLT_FILE_PATH, ScorePreferenceConstants.GRW_XSLT_FILE_DEFAULT);

      parametersType.put(ScorePreferenceConstants.GRW_BANNER_FILE_PATH, String.class);
      parametersType.put(ScorePreferenceConstants.GRW_CSS_FILE_PATH, String.class);
      parametersType.put(ScorePreferenceConstants.GRW_DISPLAY_REGULAR_EXPRESSION_KEY, String.class);
      parametersType.put(ScorePreferenceConstants.GRW_OUTPUT_FOLDER_KEY, String.class);
      parametersType.put(ScorePreferenceConstants.GRW_SELECTION_REGULAR_EXPRESSION_KEY, String.class);
      parametersType.put(ScorePreferenceConstants.GRW_USE_STANDARD_CONFIGURATION, Boolean.class);
      parametersType.put(ScorePreferenceConstants.GRW_XSLT_FILE_PATH, String.class);

      useSpecificSettingsParameter.put(ScorePreferenceConstants.GAME_REPORT_WIZARD, ScorePreferenceConstants.GRW_PROJECT_SCOPE);
   }

   /** reference on the instance of class */
   private static ScorePreferencesManager instance;

   /** instance on the workspace preference values */
   private InstancePreferences workspaceInstancePreferences;

   /** For the use of the project preference */
   private boolean useWorkSpacePreference = false;

   /** Map which contains instance preferences by properties page */
   static Map<String, InstancePreferences> propertyInstances = new HashMap<>();

   /**
    * Constructor of the class.
    * 
    */
   private ScorePreferencesManager() {
      workspaceInstancePreferences = (InstancePreferences) InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
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
    * Force the usage of the workspace preference.
    * 
    * @param state <b>true</b> for workspace preference usage
    */
   public void setUseWorkspacePreference(boolean state) {
      useWorkSpacePreference = state;
   }

   /**
    * Save the modification of use standard configuration of the preferences in the
    * file.
    * 
    * @param category category of preferences
    */
   public void saveGameReportWizardPreferences(String category) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(ScorePreferenceConstants.GAME_REPORT_WIZARD);
      try {
         instancePreferences.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Return a String value store in the preferences.
    * 
    * @param key key value of the preferences
    * 
    * @return parameter value, defaultValue if not found
    */
   public <T> T getValue(String key) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      Object defaultValue = defaultValues.get(key);
      Class<?> classType = parametersType.get(key);

      Object value;
      if (classType != null) {
         if (classType == String.class) {
            value = instancePreferences.get(key, (String) defaultValue);
         } else if (classType == Boolean.class) {
            value = Boolean.valueOf(instancePreferences.getBoolean(key, (Boolean) defaultValue));
         } else if (classType == Integer.class) {
            value = Integer.valueOf(instancePreferences.getInt(key, (Integer) defaultValue));
         } else if (classType == Long.class) {
            value = Long.valueOf(instancePreferences.getLong(key, (Long) defaultValue));
         } else if (classType == Double.class) {
            value = Double.valueOf(instancePreferences.getDouble(key, (Double) defaultValue));
         } else if (classType == Float.class) {
            value = Float.valueOf(instancePreferences.getFloat(key, (Float) defaultValue));
         } else {
            logger.log(Level.SEVERE, () -> NLS.bind(Messages.typeIsNotManageByPreferences, classType.getSimpleName()));
            value = "";
         }
      } else {
         logger.log(Level.SEVERE, () -> NLS.bind(Messages.noTypeDefinedForPreferenceValue, key));
         value = "";
      }
      return (T) value;
   }

   /**
    * set a string value store in the preferences.
    * 
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(String key, String value) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      instancePreferences.put(key, value);
      try {
         instancePreferences.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Return a double value store in the preferences.
    * 
    * @param key          key value of the preferences
    * @param defaultValue default value linked the the key
    * @return double value
    */
   public double getValue(String key, double defaultValue) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      return instancePreferences.getDouble(key, defaultValue);
   }

   /**
    * Set a double value store in the preferences.
    * 
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(String key, double value) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      instancePreferences.putDouble(key, value);
      try {
         instancePreferences.flush();
      } catch (BackingStoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
   }

   /**
    * Return a boolean value store in the preferences.
    * 
    * @param key          key value of the preferences
    * @param defaultValue default value linked the the key
    * @return parameter value, defaultValue if not found
    */
   public boolean getValue(String key, boolean defaultValue) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      return instancePreferences.getBoolean(key, defaultValue);
   }

   /**
    * Return a boolean value store in the preferences.
    * 
    * @param key   key value of the preferences
    * @param value default value linked the the key
    */
   public void setValue(String key, boolean value) {
      IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
      instancePreferences.putBoolean(key, value);
      try {
         instancePreferences.flush();
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
    * Get preference instance. Return the Workspace preference or the project
    * instance in function of the context
    * 
    * @param key name of preference
    * @return an instance on a preference store
    */
   private IEclipsePreferences getCurrentInstancePreference(String key) {
      if (useWorkSpacePreference) {
         return workspaceInstancePreferences;
      } else {

         try {
            IProject currentProject = getSelectedProject();
            if (currentProject == null) {
               return workspaceInstancePreferences;

            } else {
               String propertyPage = getSelectedPropertyPage(key);
               String specificSettingsName = getSpecificSettingState(propertyPage);
               boolean useSpecific = getScopeSetting(specificSettingsName);

               if (useSpecific) {
                  return new ProjectScope(currentProject).getNode(propertyPage);
               } else {
                  return workspaceInstancePreferences;
               }
            }
         } catch (ScorePreferenceManagerException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
         }
      }
      return workspaceInstancePreferences;
   }

   /**
    * Get name of preference which is used for select project properties or
    * workspace preference
    * 
    * @param propertyPage name of the property page
    * 
    * @return Preference name
    * @throws ScorePreferenceManagerException if not found
    */
   private String getSpecificSettingState(String propertyPage) throws ScorePreferenceManagerException {
      String specificSettings = useSpecificSettingsParameter.get(propertyPage);
      if (propertyPage == null) {
         throw new ScorePreferenceManagerException(NLS.bind(Messages.cannotFindSpecificSettingsForKey,propertyPage));
      }

      return specificSettings;
   }

   /**
    * Get the property page id in function of the name of the parameter
    * 
    * @param key name of the parameter
    * @return name of property page
    * @throws ScorePreferenceManagerException if not found
    */
   private String getSelectedPropertyPage(String key) throws ScorePreferenceManagerException {
      String propertyPage = parameterLocation.get(key);
      if (propertyPage == null) {
         throw new ScorePreferenceManagerException(NLS.bind(Messages.cannotFindPropertyPageForKey, key));
      }
      return propertyPage;
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
