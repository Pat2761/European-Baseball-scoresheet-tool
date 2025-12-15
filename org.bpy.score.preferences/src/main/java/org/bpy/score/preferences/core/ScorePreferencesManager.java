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

import org.bpy.score.preferences.Activator;
import org.eclipse.core.internal.preferences.EclipsePreferences;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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

	/** Name of the property page which define the transcription properties */
	private static final String TRANSCRIPTION_CONFIGURATION_PAGE = "org.bpy.hieroglyphs.properties.ui.transcriptionConfiguration";

	/** Name of the property page which define the transcription properties */
	private static final String HIEROGLYPHIC_VIEW_PAGE = "org.bpy.hieroglyphs.properties.ui.hieroglyphicView";

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

	/** Static code */
	static {
//		parameterLocation.put(TRANSCRIPTION_CONFIGURATION_PAGE, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.PAGE_INFO, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.PAGE_WIDTH, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.PAGE_HEIGHT, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.TEXT_ORIGIN_X, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.TEXT_ORIGIN_Y, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.TEXT_WIDTH, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.TEXT_HEIGHT, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.PAGE_ORIENTATION, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.PAGE_DIRECTION, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.SMALL_SIGNS_CENTRED, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.CARTOUCHE_LINE_WIDTH, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.MAX_QUADRANT_WIDTH, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.MAX_QUADRANT_HEIGHT, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.LINE_SKIP, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.COLUMN_SKIP, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.USE_LINES_FOR_SHADING, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.STANDARD_SIGN_HEIGHT, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.SMALL_BODY_SCALE_LIMIT, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.SMALL_SKIP, TRANSCRIPTION_CONFIGURATION_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.SMALL_SKIP, TRANSCRIPTION_CONFIGURATION_PAGE);
//
//		parameterLocation.put(HIEROGLYPHIC_VIEW_PAGE, HIEROGLYPHIC_VIEW_PAGE);
//		parameterLocation.put(HieroglyphPreferenceInitializer.LATIN_FONT_NAME, HIEROGLYPHIC_VIEW_PAGE);
//		
//		useSpecificSettingsParameter.put(TRANSCRIPTION_CONFIGURATION_PAGE,
//				HieroglyphPreferenceInitializer.TRANSCRIPTION_SPECIFIC_SETTINGS);
//		useSpecificSettingsParameter.put(HIEROGLYPHIC_VIEW_PAGE,
//				HieroglyphPreferenceInitializer.HIEROGLYPHIC_VIEW_SPECIFIC_SETTINGS);
//		
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
	 * Save the modification of transcription settings of the preferences in the file.
	 * 
	 */
	public void saveTranscriptionSetting() {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(TRANSCRIPTION_CONFIGURATION_PAGE);
		try {
			instancePreferences.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Set the state of project use specific settings for transcription parameters.
	 * 
	 * @param parameterName Name of the specific setting
	 * @param state Use specific setting state
	 */
	public void setTranscriptionSpecificSetting(String parameterName, boolean state) {
		try {
			IProject project = getSelectedProject();
			EclipsePreferences instancePreferences = (EclipsePreferences) new ProjectScope(project).getNode(TRANSCRIPTION_CONFIGURATION_PAGE);
			instancePreferences .putBoolean(parameterName, state);
			instancePreferences.flush();

		} catch (ScorePreferenceManagerException | BackingStoreException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Get the state of project use specific settings for transcription parameters.
	 * 
	 * @param parameterName Name of the specific setting
	 * @return <b>true<b> Use specific setting, <b>false</b> otherwise
	 */
	public boolean getSpecificSetting(String parameterName) {
		try {
			IProject project = getSelectedProject();
			EclipsePreferences instancePreferences = (EclipsePreferences) new ProjectScope(project).getNode(TRANSCRIPTION_CONFIGURATION_PAGE);
			return instancePreferences .getBoolean(parameterName, false);

		} catch (ScorePreferenceManagerException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Get the preference value for the info value.
	 * 
	 * @return info value
	 */
	public String getJSeshInfo() {
//		return getValue(HieroglyphPreferenceInitializer.PAGE_INFO,
//				HieroglyphPreferenceInitializer.PAGE_INFO_DEFAULT_VALUE);
		return "";
	}

	/**
	 * Get the default value for the info value.
	 * 
	 */
	public void setJSeshInfoDefaultValue() {
//		setValue(HieroglyphPreferenceInitializer.PAGE_INFO, HieroglyphPreferenceInitializer.PAGE_INFO_DEFAULT_VALUE);
	}

	/**
	 * Set the value for the info value preference.
	 * 
	 * @param value new value to set
	 */
	public void setJSeshInfoValue(String value) {
//		setValue(HieroglyphPreferenceInitializer.PAGE_INFO, value);
	}


	/**
	 * Return a String value store in the preferences.
	 * 
	 * @param key          key value of the preferences
	 * @param defaultValue default value linked the the key
	 * @return parameter value, defaultValue if not found
	 */
	private String getValue(String key, String defaultValue) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		return instancePreferences.get(key, defaultValue);
	}

	/**
	 * set a string value store in the preferences.
	 * 
	 * @param key   key value of the preferences
	 * @param value default value linked the the key
	 */
	private void setValue(String key, String value) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		instancePreferences.put(key, value);
	}

	/**
	 * Return a double value store in the preferences.
	 * 
	 * @param key          key value of the preferences
	 * @param defaultValue default value linked the the key
	 * @return double value
	 */
	private double getValue(String key, double defaultValue) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		return instancePreferences.getDouble(key, defaultValue);
	}

	/**
	 * Set a double value store in the preferences.
	 * 
	 * @param key   key value of the preferences
	 * @param value default value linked the the key
	 */
	private void setValue(String key, double value) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		instancePreferences.putDouble(key, value);
	}

	/**
	 * Return a boolean value store in the preferences.
	 * 
	 * @param key          key value of the preferences
	 * @param defaultValue default value linked the the key
	 * @return parameter value, defaultValue if not found
	 */
	private boolean getValue(String key, boolean defaultValue) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		return instancePreferences.getBoolean(key, defaultValue);
	}

	/**
	 * Return a boolean value store in the preferences.
	 * 
	 * @param key   key value of the preferences
	 * @param value default value linked the the key
	 */
	private void setValue(String key, boolean value) {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(key);
		instancePreferences.putBoolean(key, value);
	}

	/**
	 * Get preference instance.
	 * Return the Workspace preference or the project instance in function of the context 
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
					boolean useSpecific = getSpecificSetting(specificSettingsName);
					
					if (useSpecific) {
						return new ProjectScope(currentProject).getNode(propertyPage);
					} else {
						return workspaceInstancePreferences;
					}
				}
			} catch (ScorePreferenceManagerException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return workspaceInstancePreferences;
	}

	/**
	 * Get name of preference which is used for select project properties or workspace preference 
	 * 
	 * @param propertyPage name of the property page
	 * 
	 * @return Preference name 
	 * @throws ScorePreferenceManagerException if not found
	 */
	private String getSpecificSettingState(String propertyPage) throws ScorePreferenceManagerException {
		String specificSettings = useSpecificSettingsParameter.get(propertyPage);
		if (propertyPage == null) {
			throw new ScorePreferenceManagerException("Can't find specific setting state for the property page " + propertyPage);
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
			throw new ScorePreferenceManagerException("Can't find property page for the key " + key);
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

			if (selection instanceof IStructuredSelection) {
				Object element = ((IStructuredSelection) selection).getFirstElement();

				if (element instanceof IResource) {
					return ((IResource) element).getProject();
				} else if (element != null){
				
					throw new ScorePreferenceManagerException (
							"Can't manage element of type " + element.getClass().getName());
				}
			}
		}
		return null;
	}

	/**
	 * Save the modification of transcription settings of the preferences in the file.
	 * 
	 */
	public void saveHieroglyphicViewSetting() {
		IEclipsePreferences instancePreferences = getCurrentInstancePreference(HIEROGLYPHIC_VIEW_PAGE);
		try {
			instancePreferences.flush();

			for (IScoreViewPreferenceChangeListener listener : scoreChangerListeners) {
				listener.preferenceChanged();
			}
		
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Set the state of project use specific settings for transcription parameters.
	 * 
	 * @param parameterName Name of the specific setting
	 * @param state Use specific setting state
	 */
	public void setHieroglyphicViewSpecificSetting(String parameterName, boolean state) {
		try {
			IProject project = getSelectedProject();
			EclipsePreferences instancePreferences = (EclipsePreferences) new ProjectScope(project).getNode(HIEROGLYPHIC_VIEW_PAGE);
			instancePreferences .putBoolean(parameterName, state);
			instancePreferences.flush();

		} catch (ScorePreferenceManagerException | BackingStoreException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Add a listener to the change of preference of the Hieroglyphic view.
	 * 
	 * @param listener
	 */
	public void addHieroglyphChangerListener(IScoreViewPreferenceChangeListener listener) {
		scoreChangerListeners.add(listener);
    }

	/**
	 * Remove a listener to the change of preference of the Hieroglyphic view.
	 * 
	 * @param listener
	 */
    public void removeHieroglyphChangerListener(IScoreViewPreferenceChangeListener listener) {
    	scoreChangerListeners.remove(listener);
    }
    

}
