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

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

/**
 * Allow to import a tournament in the workspace
 * 
 * @author Patrick BRIAND
 *
 */
public class ImportTournamentWizard extends Wizard implements IImportWizard {

	/** Main page of the importer */
	private ImportTournamentWizardPageOne pageOne;
	/** Current selection for the import */
	private IStructuredSelection currentSelection;

	/**
	 * Constructor of the class
	 */
	public ImportTournamentWizard() {
		IDialogSettings workbenchSettings = IDEWorkbenchPlugin.getDefault().getDialogSettings();
		setDialogSettings(workbenchSettings);
	}

	@Override
	public void addPages() {
		pageOne = new ImportTournamentWizardPageOne("wizardExternalProjectsPage", null, currentSelection); //$NON-NLS-1$
		addPage(pageOne);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.currentSelection = selection;
	}

	@Override
	public boolean performCancel() {
		pageOne.performCancel();
		return true;
	}

	@Override
	public boolean performFinish() {
		return pageOne.createProjects();
	}

}
