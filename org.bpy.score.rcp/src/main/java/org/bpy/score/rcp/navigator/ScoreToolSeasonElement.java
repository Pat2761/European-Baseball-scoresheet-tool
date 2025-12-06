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
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.swt.graphics.Image;
import org.osgi.service.prefs.BackingStoreException;

/**
 * This class describe a season element in the project explorer.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("restriction")
public class ScoreToolSeasonElement extends Folder implements IScoreToolProjectElement {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreToolSeasonElement.class.getSimpleName());

	/** Reference on the image of the category folder */
	private Image seasontImage;

	/**
	 * Constructor of the class.
	 * 
	 * @param path Where to create the season folder
	 * @param container refernece to the parent 
	 */
	public ScoreToolSeasonElement(IPath path, Workspace container) {
		super(path, container);
	}

	/**
	 * Get the eclipse folder
	 * 
	 * @return reference to the folder
	 */
	public Folder getFolder() {
		return this;
	}

	@Override
	public Image getImage() {
		if (seasontImage == null) {
			seasontImage = Activator.getImage("icons/full/obj16/SeasonFolder.png"); //$NON-NLS-1$
		}
		return seasontImage;
	}

	@Override
	public Object[] getChildren() {
		Object[] members = TournamentContentProvider.NO_CHILDREN;

		try {
			int counter = 0;
			members = new Object[members().length];
			for (IResource member : members()) {

				if (ScoreToolSeasonElement.class.isInstance(member)) {
					members[counter] = new ScoreToolCategoryElement(this, member);

				} else {
					members[counter] = member;
				}
				counter++;

			}
		} catch (CoreException e) {
			return TournamentContentProvider.NO_CHILDREN;
		}

		return members;
	}

	@Override
	public String getText() {
		return getName();
	}

	@Override
	public boolean hasChildren() {
		try {
			return members().length > 0;
		} catch (CoreException e) {
			return false;
		}
	}

	@Override
	public IProject getProject() {
		return getProject();
	}

	@Override
	public IContainer getParent() {
		return this.getParent();
	}

	/**
	 * Create a season.
	 * 
	 * @param project project reference
	 * @param seasonName season name
	 */
	public static void createSeason(IProject project, String seasonName) {
		IFolder seasonFolder = project.getFolder(seasonName);

		if (!seasonFolder.exists()) {
			try {
				seasonFolder.create(true, true, new NullProgressMonitor());
				seasonFolder.setPersistentProperty(RcpUtils.FOLDER_CATEGORY, RcpUtils.SEASON_CATEGORY);

				IScopeContext projectScope = new ProjectScope(project);
				IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);
				if (projectNode != null) {
					projectNode.put(seasonFolder.getFullPath().toPortableString(), RcpUtils.SEASON_CATEGORY);
					projectNode.flush();
				}

			} catch (BackingStoreException | CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}
}
