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
package org.bpy.score.rcp.utils;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.Activator;
import org.bpy.score.rcp.ScoreProjectNature;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Utility class for the RCP plugin.
 * 
 * @author Patrick BRIAND
 *
 */
public class RcpUtils {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(RcpUtils.class.getCanonicalName());


	/** Category folder qualified name */
	public static final QualifiedName FOLDER_CATEGORY = new QualifiedName("org.bpy.score.rcp.folder", "category"); //$NON-NLS-1$ //$NON-NLS-2$
	/** Season folder qualified name */
	public static final String SEASON_CATEGORY = "org.bpy.score.rcp.season.category"; //$NON-NLS-1$
	/** Category folder qualified name */
	public static final String CATEGORY_CATEGORY = "org.bpy.score.rcp.category.category"; //$NON-NLS-1$

	/** Image for the season folder decoration */
	public static final Image seasonImage = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/season.png").createImage(); //$NON-NLS-1$
	/** Image for the category folder decoration */
	public static final Image categoryImage = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/category.png").createImage(); //$NON-NLS-1$
	/** Image for the close tournament */
	public static final Image CLOSE_TOURNAMENT_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/tournament_close.png").createImage(); //$NON-NLS-1$
	/** Image for the close tournament */
	public static final Image OPEN_TOURNAMENT_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/tournament.png").createImage(); //$NON-NLS-1$
	/** Image for the classical project */
	public static final Image OPEN_PROJECT_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/prj_obj.png").createImage(); //$NON-NLS-1$
	/** Image for the classical project */
	public static final Image CLOSE_PROJECT_IMAGE = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/prj_mode.png").createImage(); //$NON-NLS-1$

	/**
	 * Get selected project.
	 * 
	 * @return selected project
	 */
	public static IProject getToolSelectedProject() {

		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$

		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			if (treeSelection.getFirstElement() instanceof IProject) {
				IProject project = (IProject) treeSelection.getFirstElement();
				try {
					if ((project.getDescription().getNatureIds().length > 0) && 
						(ScoreProjectNature.NATURE_ID.equals(project.getDescription().getNatureIds()[0]))){
						return project;
					}
				} catch (CoreException e) {
					return null;
				}
			}
		}
		return null;
	}

	/**
	 * Check if the folder is a season folder. 
	 * 
	 * @param folder folder to check
	 * @return <b>true</b> the folder is a season folder, <b>false</b> otherwise
	 */
	public static boolean isSeasonFolder(IFolder folder) {
		IScopeContext projectScope = new ProjectScope(folder.getProject());
		IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);
		if (projectNode != null) {
			String property = projectNode.get(folder.getFullPath().toPortableString(), ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return SEASON_CATEGORY.equals(property);
		} else {
			return false;
		}
	}

	/**
	 * Check if the folder is a category folder. 
	 * 
	 * @param folder folder to check
	 * @return <b>true</b> the folder is a category folder, <b>false</b> otherwise
	 */
	public static boolean isCategoryFolder(IFolder folder) {
		IScopeContext projectScope = new ProjectScope(folder.getProject());
		IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);
		if (projectNode != null) {
			String property = projectNode.get(folder.getFullPath().toPortableString(), ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return CATEGORY_CATEGORY.equals(property);
		} else {
			return false;
		}
	}
	
	/**
	 * Check if path is a file and exist.
	 * 
	 * @param path path to check
	 * @return  <b>true</b> path is valid, <b>false</b> otherwise
	 */
	public static boolean isPathIsAValidFile(String path) {
		try {
			path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(path);
			File file = new File(path);
			return file.isFile() && file.exists();
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return false;
	}

	/**
	 * Check if path is a file name.
	 * 
	 * @param path path to check
	 * @return  <b>true</b> path is valid, <b>false</b> otherwise
	 */
	public static boolean isPathIsAValidFileName(String path) {
		try {
			path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(path);
			new File(path);
			return true;
		} catch (CoreException e) {
			return false;
		}
	}

	/**
	 * Set a preference value.
	 * 
	 * @param folder reference on the folder
	 * @param key Key of the preference 
	 * @param value value of the preference
	 */
	public static void setPreferenceValue(IFolder folder, String key, String value) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String rootKey = RcpUtils.getRootKey(folder);
		
		store.putValue(rootKey + key, value);
	}
	
	/**
	 * Get preference value
	 * 
	 * @param folder reference on the folder
	 * @param key Key of the preference 
	 * 
	 * @return Preference value, <b>null</b> if not exist
	 */
	public static String getPreferenceValue(IFolder folder, String key) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String rootKey = RcpUtils.getRootKey(folder);

		return store.getString(rootKey + key);
	}
	
	/**
	 * Check if a project have a defined nature.
	 * Works also when the project is closed
	 * 
	 * @param project reference to the project 
	 * @param natureId value of the Nature ID
	 * 
	 * @return <b>true</b> the project have the nature ID, <b>false</b> otherwise
	 */
	public static boolean isProjectHasNature(IProject project, String natureId) {
		try {
			IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(project.getLocation().toOSString().replace("\\", "/") + "/.project" )); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			return description.hasNature(natureId);
				
		} catch (CoreException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
		return false;
	}
	
	/**
	 * get root key for a folder
	 * 
	 * @param currentFolder reference on the folder
	 * 
	 * @return Key value
	 */
	private static String getRootKey(IFolder currentFolder) {
		String rootKey = currentFolder.getFullPath().toString();
		rootKey = rootKey.replaceFirst("/", ""); //$NON-NLS-1$ //$NON-NLS-2$
		rootKey = rootKey.replace("/", "."); //$NON-NLS-1$ //$NON-NLS-2$
		rootKey = rootKey.replace(" ", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		return rootKey + "_"; //$NON-NLS-1$
	}

	/**
	 * Just for static class
	 */
	private RcpUtils() {
	    throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	  }

}
