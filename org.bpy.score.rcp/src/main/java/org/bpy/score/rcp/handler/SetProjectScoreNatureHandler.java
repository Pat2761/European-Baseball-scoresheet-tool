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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.ScoreProjectNature;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.XtextProjectHelper;

/**
 * Convert a standard project to a Scoring tool project
 * 
 * @author Patrick BRIAND
 *
 */
public class SetProjectScoreNatureHandler implements IHandler {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(SetProjectScoreNatureHandler.class.getCanonicalName());
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// do nothing
	}

	@Override
	public void dispose() {
		// do nothing
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

	    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
	    if (selection instanceof TreeSelection) {
	      TreeSelection treeSelection = (TreeSelection) selection;
	      if (treeSelection.getFirstElement() instanceof IProject) {
	    	  
	    	IProject currentProject = (IProject) treeSelection.getFirstElement();
	  		IProjectDescription description;
			try {
				description = currentProject.getDescription();
				String[] newNatures = new String[2];
				newNatures[0] = ScoreProjectNature.NATURE_ID;
				newNatures[1] = XtextProjectHelper.NATURE_ID;
				description.setNatureIds(newNatures);

				currentProject.setDescription(description, new NullProgressMonitor());
				
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
	      }
	    }  
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

	    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
	    if (selection instanceof TreeSelection) {
	      TreeSelection treeSelection = (TreeSelection) selection;
	      if (treeSelection.getFirstElement() instanceof IProject) {
	    	  return true;
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
		// do nothing
	}

}
