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


import org.bpy.score.preferences.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Manager of preferences and properties
 * 
 * @author Patrick BRIAND
 *
 */
public class PreferenceManager {

	/** reference on the preference store */
	private static IPreferenceStore store = Activator.getDefault().getPreferenceStore();

	/**
	 * For avoid instanciate static class
	 */
	private PreferenceManager() {
	    throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}

	/**
	 * Push the project properties
	 * 
	 * @param project reference to the project
	 * @throws BackingStoreException
	 */
	public static void flushProjectPreference(IProject project) throws BackingStoreException {
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode!=null){
			projectNode.flush();
		}
	}
	
	/**
	 * Get the preference manager of eclipse for a project
	 * 
	 * @param project reference to the project
	 * @return reference on the project manager
	 */
	private static IEclipsePreferences getProjectEclipsePreferences(IProject project){
		IScopeContext projectScope = new ProjectScope(project);
		return projectScope.getNode(PreferenceConstants.PREFERENCE_ID);
	}

	/**
	 * Get a project property value of type boolean
	 * 
	 * @param project reference to the project
	 * @param key key of the property
	 * @param defaultValue default value if not found
	 * 
	 * @return property value, the default value if not found
	 */
	public static boolean getProjectProperty(IProject project, String key, boolean defaultValue){
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode!=null){
			return projectNode.getBoolean(key, defaultValue);
		}else{
			return defaultValue;
		}	
	}

	/**
	 * Get a project property value of type string
	 * 
	 * @param project reference to the project
	 * @param key key of the property
	 * @param defaultValue default value if not found
	 * 
	 * @return property value, the default value if not found
	 */
	public static String getProjectProperty(IProject project, String key, String defaultValue){
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode!=null){
			return projectNode.get(key, defaultValue);
		}else{
			return defaultValue;
		}	
	}

	/**
	 * Set a project property value of type boolean
	 * 
	 * @param project reference to the project
	 * @param key key of the property
	 * @param value value
	 */
	public static void setProjectProperty(IProject project, String key, boolean value){
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode!=null){
			projectNode.putBoolean(key, value);
		}
	}
	
	/**
	 * Set a project property value of type string
	 * 
	 * @param project reference to the project
	 * @param key key of the property
	 * @param value value
	 */
	public static void setProjectProperty(IProject project, String key, String value){
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode!=null){
			projectNode.put(key, value);
		}
	}

	public static boolean getPreferenceValue(IProject project, String key, boolean defaultValue) {
		if (isProjectUseSpecificProperties(project)) {
			return getProjectProperty(project, key, defaultValue);
		} else {
			return store.getBoolean(key);
		}
	}

	public static String getPreferenceValue(IProject project, String key, String defaultValue) {
		if (isProjectUseSpecificProperties(project)) {
			return getProjectProperty(project, key, defaultValue);
		} else {
			return store.getString(key);
		}
	}
	
	
	public static boolean isProjectUseSpecificProperties(IProject project) {
		IEclipsePreferences projectNode = getProjectEclipsePreferences(project);
		if (projectNode != null) {
			return projectNode.getBoolean(PreferenceConstants.PROPERTIE_USE_PROJECT_SETTINGS,false);
		}
		return false;
	}
}
