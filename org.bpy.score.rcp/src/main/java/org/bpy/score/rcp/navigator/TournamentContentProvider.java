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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.ScoreProjectNature;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This class is content provider for a tournament.
 * 
 * @author Patrick BRIAND
 *
 */
public class TournamentContentProvider implements ITreeContentProvider, IResourceChangeListener {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(TournamentContentProvider.class.getSimpleName());

	/** Empty tournament folder */
	public static final Object[] NO_CHILDREN = {};
	/** Project parents */
	private ScoreToolProjectParent[] customProjectParents;
	/** Reference to the viewer */
	private Viewer viewer;

	/**
	 * Constructor of the class.
	 */
	public TournamentContentProvider() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (ScoreToolProjectWorkbenchRoot.class.isInstance(parentElement)) {

			if (customProjectParents == null) {
				customProjectParents = initializeParent(parentElement);
			}

			children = customProjectParents;

		} else if (ScoreToolProjectParent.class.isInstance(parentElement)) {
			children = ((ScoreToolProjectParent) parentElement).getChildren();

		} else if (ScoreToolSeasonElement.class.isInstance(parentElement)) {
			children = ((ScoreToolSeasonElement) parentElement).getChildren();

		} else if (ScoreToolCategoryElement.class.isInstance(parentElement)) {
			children = ((ScoreToolCategoryElement) parentElement).getChildren();

		} else if (IFolder.class.isInstance(parentElement)) {
			try {
				children = ((IFolder) parentElement).members();
			} catch (CoreException e) {
				children = NO_CHILDREN;
			}

		} else {

			children = NO_CHILDREN;
		}

		return children;
	}

	@Override
	public Object getParent(Object element) {
		Object parent = null;

		if (IProject.class.isInstance(element)) {
			parent = ((IProject) element).getWorkspace().getRoot();

		} else if (ScoreToolProjectParent.class.isInstance(element)) {
			parent = ((ScoreToolProjectParent) element).getParent();

		}

		return parent;
	}

	@Override
	public boolean hasChildren(Object element) {

		boolean status = false;

		if (ScoreToolProjectParent.class.isInstance(element)) {
			status = ((ScoreToolProjectParent) element).hasChildren();

		} else if (ScoreToolSeasonElement.class.isInstance(element)) {
			status = ((ScoreToolSeasonElement) element).hasChildren();

		} else if (ScoreToolCategoryElement.class.isInstance(element)) {
			status = ((ScoreToolCategoryElement) element).hasChildren();

		} else if (element instanceof IFolder) {
			try {
				status = ((IFolder) element).members().length > 0;
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}

		return status;
	}
	
	/**
	 * Initialize the parent element.
	 * 
	 * @param parentElement parent element reference
	 * 
	 * @return parents
	 */
	private ScoreToolProjectParent[] initializeParent(Object parentElement) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		List<ScoreToolProjectParent> list = new ArrayList<>();
		for (int i = 0; i < projects.length; i++) {
			try {
				if (projects[i].getNature(ScoreProjectNature.NATURE_ID) != null) {
					list.add(new ScoreToolProjectParent(projects[i]));
				}
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}

		ScoreToolProjectParent[] result = new ScoreToolProjectParent[list.size()];
		result = list.toArray(result);

		return result;
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		viewer.refresh();
	}
}
