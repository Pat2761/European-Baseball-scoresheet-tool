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

import java.io.File;

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.Activator;
import org.bpy.score.rcp.navigator.ScoreToolProjectParent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * This class is a wizard for create a new tournament in the workspace.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewChampionatWizard extends Wizard implements INewWizard {

   /** Key for the icon of the Report Generation wizard */
   public static final String NEW_CHAMPIONAT_WIZARD_ICON_NAME = "NewChampionatWizardIconName";
   
	/** Reference on the page of the wizard */
	private NewChampionatWizardPage newChampionatWizardPage;

	/**
	 * Constructor of the class.
	 */
	public NewChampionatWizard() {
	   setWindowTitle(Messages.NewChampionatWizard_Title);
      setDefaultPageImageDescriptor(
            Activator.getDefault()
                     .getImageRegistry()
                     .getDescriptor(NEW_CHAMPIONAT_WIZARD_ICON_NAME)
        );
   }
	
	@Override
	public void addPages() {
		newChampionatWizardPage = new NewChampionatWizardPage();
		addPage(newChampionatWizardPage);
	}

	@Override
	public boolean performFinish() {

		String baseWS = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath();
		String projectFolder = baseWS + File.separator + newChampionatWizardPage.getTournamentName();

		File projectPath = new File(projectFolder);
		if (!projectPath.exists()) {
			projectPath.mkdir();
		}

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(newChampionatWizardPage.getTournamentName());
		ScoreToolProjectParent.createProject(project, newChampionatWizardPage.getSeasonName());
		return true;
	}

	@Override
	public boolean canFinish() {
		return newChampionatWizardPage.isPageComplete();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Nothing to do
	}

}
