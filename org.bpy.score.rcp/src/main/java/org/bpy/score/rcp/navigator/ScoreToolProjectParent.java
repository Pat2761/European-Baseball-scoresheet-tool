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
import org.bpy.score.rcp.ScoreProjectNature;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.XtextProjectHelper;

/**
 * Manage a tournament project.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreToolProjectParent implements IScoreToolProjectElement {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreToolProjectParent.class.getSimpleName());
	
	/** Reference on the project */
	private IProject project;
	/** Reference on the image of the project */
	private Image projectImage;

	/**
	 * Constructor of the class.
	 * 
	 * @param iProject Reference on the project
	 */
	public ScoreToolProjectParent(IProject iProject) {
		project = iProject;
	}

	@Override
	public Object[] getChildren() {

		return TournamentContentProvider.NO_CHILDREN;
	}

	@Override
	public String getText() {
		return project.getName();
	}

	@Override
	public boolean hasChildren() {
		try {
			return project.members().length > 0;
		} catch (CoreException e) {
			return false;
		}
	}

	@Override
	public Object getParent() {
		return null;
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public Image getImage() {
		if (projectImage == null) {
			projectImage = Activator.getImage("icons/full/obj16/OpenTournamentFolder.png"); //$NON-NLS-1$
		}
		return projectImage;
	}

	/**
	 * Create the project
	 * 
	 * @param project Reference on the project
	 * @param seasonName season name
	 */
	public static void createProject(IProject project, String seasonName) {

		IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
		desc.setLocation(null);
		desc.setLocationURI(null);

		try {

			project.create(desc, new NullProgressMonitor());

			if (!project.isOpen()) {
				project.open(new NullProgressMonitor());
			}

			ScoreToolSeasonElement.createSeason(project, seasonName);

			project.setDescription(desc, new NullProgressMonitor());

			if (!project.hasNature(ScoreProjectNature.NATURE_ID)) {
				IProjectDescription description = project.getDescription();
				String[] newNatures = new String[2];
				newNatures[0] = ScoreProjectNature.NATURE_ID;
				newNatures[1] = XtextProjectHelper.NATURE_ID;
				description.setNatureIds(newNatures);

				project.setDescription(description, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

}
