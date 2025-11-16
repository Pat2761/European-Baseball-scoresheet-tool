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
package org.bpy.score.rcp.navigator;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.Activator;
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.swt.graphics.Image;
import org.osgi.service.prefs.BackingStoreException;

/**
 * This class manage a category folder.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreToolCategoryElement implements IScoreToolProjectElement {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreToolCategoryElement.class.getSimpleName());
	
	/** Reference on the parent */
	private ScoreToolSeasonElement parent;
	/** Eclipse folder reference */ 
	private IFolder folder;

	/** Reference on the image of the category folder */
	private Image image;

	/**
	 * Constructor of the class.
	 * 
	 * @param seasonElement Reference to the parent
	 * 
	 * @param member Reference to the eclipse mmember element
	 */
	public ScoreToolCategoryElement(ScoreToolSeasonElement seasonElement, IResource member) {
		this.parent = seasonElement;
		folder = (IFolder) member;
	}

	@Override
	public Image getImage() {
		if (image == null) {
			image = Activator.getImage("icons/full/obj16/CategoryFolder.png"); //$NON-NLS-1$
		}
		return image;
	}

	@Override
	public Object[] getChildren() {
		Object[] members = TournamentContentProvider.NO_CHILDREN;

		try {
			int counter = 0;
			members = new Object[folder.members().length];
			for (IResource member : folder.members()) {

				members[counter] = member;
				counter++;

			}
		} catch (CoreException e) {
			return TournamentContentProvider.NO_CHILDREN;
		}

		return members;
	}

	@Override
	public String getText() {
		return folder.getName();
	}

	@Override
	public boolean hasChildren() {
		try {
			return folder.members().length > 0;
		} catch (CoreException e) {
			return false;
		}
	}

	@Override
	public IProject getProject() {
		return folder.getProject();
	}

	@Override
	public Object getParent() {
		return parent;
	}

	/**
	 * Create a category folder type.
	 * 
	 * @param folder Reference on the parent folder of the category
	 * 
	 * @param categoryName Category name
	 */
	public static void createCategory(IFolder folder, String categoryName) {
		IFolder categoryFolder = folder.getFolder(categoryName);

		if (!categoryFolder.exists()) {
			try {
				categoryFolder.create(true, true, new NullProgressMonitor());
				categoryFolder.setPersistentProperty(RcpUtils.FOLDER_CATEGORY, RcpUtils.CATEGORY_CATEGORY);

				IScopeContext projectScope = new ProjectScope(folder.getProject());
				IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);
				if (projectNode != null) {
					projectNode.put(categoryFolder.toString(), RcpUtils.CATEGORY_CATEGORY);
					projectNode.flush();
				}

			} catch (CoreException|BackingStoreException e) {
				logger.log(Level.SEVERE,e.getMessage());
			}
		}
	}
}
