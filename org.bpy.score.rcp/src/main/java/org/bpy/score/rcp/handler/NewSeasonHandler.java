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

import org.bpy.score.rcp.ScoreProjectNature;
import org.bpy.score.rcp.wizard.NewSeasonWizard;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

/**
 * This class active the new Season wizard. 
 * 
 * @author Patrick BRIAND
 *
 */
public class NewSeasonHandler  implements IHandler {

  @Override
  public void addHandlerListener(IHandlerListener handlerListener) {
    // Nothing to do
  }

  @Override
  public void dispose() {
	    // Nothing to do
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell() , new NewSeasonWizard());
    dialog.open();
    
    return null;
  }

  @Override
  public boolean isEnabled() {
    ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
    if (selection instanceof TreeSelection) {
      TreeSelection treeSelection = (TreeSelection) selection;
      if (treeSelection.getFirstElement() instanceof IProject) {
        IProject project = (IProject) treeSelection.getFirstElement();
        try {
          if (project.getDescription().getNatureIds().length > 0) {
            return ScoreProjectNature.NATURE_ID.equals(project.getDescription().getNatureIds()[0]);
          }
        } catch (CoreException e) {
          return false;
        }
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
    // Nothing to do
  }

}
