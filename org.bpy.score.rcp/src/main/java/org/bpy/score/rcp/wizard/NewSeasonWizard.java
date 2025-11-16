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
package org.bpy.score.rcp.wizard;

import org.bpy.score.rcp.navigator.ScoreToolSeasonElement;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class is a wizard for create a new season in the project.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewSeasonWizard extends Wizard implements INewWizard  {

	/** Reference on the page of the wizard */
  private NewSeasonWizardPage page;

  @Override
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    // nothing to do
  }

  @Override
  public void addPages() {
    page = new NewSeasonWizardPage();
    addPage(page);
    
  }

  @Override
  public boolean performFinish() {
    ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
    if (selection instanceof TreeSelection) {
      TreeSelection treeSelection = (TreeSelection) selection;
      if (treeSelection.getFirstElement() instanceof IProject) {
        IProject project = (IProject) treeSelection.getFirstElement();
        ScoreToolSeasonElement.createSeason(project, page.getSeasonName());

      }
    }  
         
    return true;
  }

  @Override
  public boolean canFinish() {
    return page.isValid();
  }

}
