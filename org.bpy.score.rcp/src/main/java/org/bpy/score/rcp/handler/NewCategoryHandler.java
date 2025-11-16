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
package org.bpy.score.rcp.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.club.Team;
import org.bpy.score.game.GameStandaloneSetup;
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.rcp.wizard.NewCategoryWizard;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * 
 * @author Patrick BRIAND
 *
 */
public class NewCategoryHandler implements IHandler {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(NewCategoryHandler.class.getSimpleName());
	
	/** Reference on the injector */
	private Injector injector;

	/**
	 * Constructor of the class.
	 */
	public NewCategoryHandler() {
		injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// No Action to do
	}

	@Override
	public void dispose() {
		// No Action to do
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		/* On commence par récupérer la liste des catégories définies dans les clubs */
		ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			if (treeSelection.getFirstElement() instanceof IFolder) {
				IFolder folder = (IFolder) treeSelection.getFirstElement();
				List<String> possibleCategories = getPossiblesCategories(folder);

				WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(),	new NewCategoryWizard(folder, possibleCategories));
				dialog.open();
			}
		}

		return null;
	}

	/**
	 * Get the list of possibles categories in a folder.
	 * 
	 * @param folder folder to analyse
	 * 
	 * @return list of possibles categories
	 */
	private List<String> getPossiblesCategories(IFolder folder) {
		List<String> possibleCategories = new ArrayList<>();

		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		try {
			for (IResource member : folder.members()) {

				if ((member.getFileExtension() != null) && member.getFileExtension().equalsIgnoreCase("club")) { //$NON-NLS-1$

					URI modelURI = URI.createPlatformResourceURI(member.getFullPath().toString(), true);
					Resource xtextResource = resourceSet.getResource(modelURI, true);

					EcoreUtil.resolveAll(xtextResource);

					List<String> fileCategories = getPossiblesCategories(xtextResource);

					for (String category : fileCategories) {
						if (!possibleCategories.contains(category)) {
							possibleCategories.add(category);
						}
					}
				}
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}

		Collections.sort(possibleCategories);
		return possibleCategories;
	}

	/**
	 * Get the list of possibles categories in a resource.
	 * 
	 * @param xtextResource reference on the resource
	 * 
	 * @return list of possibles categories
	 */
	private List<String> getPossiblesCategories(Resource xtextResource) {
		List<String> possibleCategories = new ArrayList<>();

		TreeIterator<EObject> contents = xtextResource.getAllContents();
		while (contents.hasNext()) {
			EObject content = contents.next();
			if (content instanceof Team) {
				Team team = (Team) content;
				possibleCategories.add(team.getName());
			}
		}

		return possibleCategories;
	}

	@Override
	public boolean isEnabled() {

		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			if (treeSelection.getFirstElement() instanceof IFolder) {
				IFolder folder = (IFolder) treeSelection.getFirstElement();
				return RcpUtils.isSeasonFolder(folder);
			}
		}

		return false;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// No Action to do
	}

}
