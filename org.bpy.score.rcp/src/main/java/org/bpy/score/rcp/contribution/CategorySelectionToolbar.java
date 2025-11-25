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
package org.bpy.score.rcp.contribution;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.Activator;
import org.bpy.score.rcp.ScoreProjectNature;
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * Add a combo in the toolbar for Category, season and tournament
 * 
 * @author Patrick BRIAND
 *
 */
public class CategorySelectionToolbar extends WorkbenchWindowControlContribution {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(CategorySelectionToolbar.class.getCanonicalName());

	/** SWT combo for the resource selection */
	private Combo navigator;

	/** reference on the project navigator viex */
	private CommonNavigator commonNavigator;
	
	/** Store string index in the combo */
	private Map<String, Integer> indexs;
	/** Store the String displayed in the combo for a resource reference */ 
	private Map<IResource, String> reourceMapping;
	/** Store the the resource corresponfing toi a string which is displayed in the combo */ 
	private Map<String, IResource> invertedReourceMapping;

	/**
	 * Constructor of the class
	 * 
	 */
	public CategorySelectionToolbar() {
		// Nothing to do
	}

	/**
	 * Constructor of the class
	 * 
	 * @param id id of the widget
	 */
	public CategorySelectionToolbar(String id) {
		super(id);
	}

	@Override
	protected Control createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		GridLayout glContainer = new GridLayout(1, false);
		glContainer.marginTop = -1;
		glContainer.marginHeight = 0;
		glContainer.marginWidth = 0;
		container.setLayout(glContainer);
		GridData glReader = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		glReader.widthHint = 280;
		navigator = new Combo(container, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
		navigator.setLayoutData(glReader);
		navigator.addListener(SWT.Selection, e -> setMemberSelection());
		populateCombo();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(event -> manageNavigatorResourceChanged());

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page != null) {

			IViewPart view = page.findView("org.eclipse.ui.navigator.ProjectExplorer");
			if (view instanceof CommonNavigator) {
				commonNavigator = (CommonNavigator) view;
				commonNavigator.getCommonViewer().addSelectionChangedListener(this::navigatorSelectionChange);
			}
		}

		return container;
	}

	/**
	 * Manage the selection event in the project explorer view.
	 * 
	 * @param event selection event
	 */
	private void navigatorSelectionChange(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			String textToDisplay = reourceMapping.get(selectedObject);
			if (textToDisplay != null) {
				Integer indexToDisplay = indexs.get(textToDisplay);
				if (indexToDisplay != null) {
					navigator.select(indexToDisplay.intValue());
					return;
				}
			}
		}
		navigator.deselectAll();
	}

	/**
	 * Manage the resource change in the project explorer view
	 */
	private void manageNavigatorResourceChanged() {
		Display.getDefault().syncExec(this::populateCombo);
	}

	/**
	 * Manage e member selection
	 */
	private void setMemberSelection() {
		int selection = navigator.getSelectionIndex();
		if (selection >= 0) {
			String selectionPath = navigator.getText();
			IResource selectedMember = invertedReourceMapping.get(selectionPath);

			if (selectedMember != null) {
				commonNavigator.getCommonViewer().setSelection(new StructuredSelection(selectedMember));
			}
		}
	}

	/**
	 * Populate the combo with all the possibilities which are offer by the project explorer view
	 * 
	 */
	private void populateCombo() {
		
		indexs = new HashMap<>();
		reourceMapping = new HashMap<>();
		invertedReourceMapping= new HashMap<>();

		navigator.removeAll();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IProject[] projects = workspaceRoot.getProjects();
		try {
			for (int i = 0; i < projects.length; i++) {
				IProject project = projects[i];
				if (project.isOpen() && project.hasNature(ScoreProjectNature.NATURE_ID)) {
					addNavigationInformation(project, project.getName());
					addSeason(project);
				}
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage());
		}
	}

	/**
	 * Add a season description in the list of possibilities.
	 * 
	 * @param project reference on the project which own the season
	 * @throws CoreException 
	 */
	private void addSeason(IProject project) throws CoreException {
		for (IResource member : project.members()) {
			if (member instanceof IFolder) {
				IScopeContext projectScope = new ProjectScope(project);
				IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);

				if (projectNode != null) {
					String category = projectNode.get(member.toString().replaceAll("\\s+", "_"), ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					if (RcpUtils.SEASON_CATEGORY.equals(category)) {
						addNavigationInformation(member, project.getName() + "/" + member.getName());
						addCategory(projectNode, project, (IFolder) member);
					}
				}
			}
		}
	}

	/**
	 * Add a category description in the list of possibilities.
	 * 
	 * @param projectNode reference on the project element 
	 * @param project reference on the project which own the category
	 * @param seasonFolder reference on the season folder
	 * 
	 * @throws CoreException 
	 */
	private void addCategory(IEclipsePreferences projectNode, IProject project, IFolder seasonFolder)
			throws CoreException {
		for (IResource member : seasonFolder.members()) {
			if (member instanceof IFolder) {
				String category = projectNode.get(member.toString().replaceAll("\\s+", "_"), ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				if (RcpUtils.CATEGORY_CATEGORY.equals(category)) {
					addNavigationInformation(member,
							project.getName() + "/" + seasonFolder.getName() + "/" + member.getName());
				}
			}
		}
	}

	/**
	 * Add data information.
	 * 
	 * @param resource reference on the resource
	 * @param name String which describe the resource
	 */
	private void addNavigationInformation(IResource resource, String name) {
		indexs.put(name, navigator.getItemCount());
		reourceMapping.put(resource, name);
		invertedReourceMapping.put(name, resource);
		
		navigator.add(name);
	}
}
