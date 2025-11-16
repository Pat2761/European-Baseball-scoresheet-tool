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

import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.rcp.wizard.NewTeamWizard;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for the creation of a new club.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewClubHandler implements IHandler {

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
    
    ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
    IFolder container = (IFolder) ((TreeSelection)selection).getFirstElement();

    NewTeamWizard newTeanWizard = new NewTeamWizard(container);
    WizardDialog dialog = new WizardDialog(new Shell(), newTeanWizard);
    
    int status = dialog.open();
    if (status == Window.OK) {
    	
    	newTeanWizard.getClubDescription().exportAsFile(container);
      
    }
    return null;
  }

  @Override
  public boolean isEnabled() {
		ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

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
