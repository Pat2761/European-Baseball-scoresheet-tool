/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2024  Patrick BRIAND
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
package org.bpy.score.samples.wizard;

import java.util.List;

import org.bpy.score.internationalization.samples.Messages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard which allows to import sample projects.
 * 
 */
public class ImportSamplesWizard extends Wizard implements IImportWizard {

	/** Reference on the first page of the wizard */
	private ImportSamplesWizardPageOne pageOne;

	/** 
	 * Constructor of the class.
	 */
	public ImportSamplesWizard() {
		// Nothing to do
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		setWindowTitle(Messages.importWizardWindowTitle);
		pageOne = new ImportSamplesWizardPageOne();
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		List<String> selectedProjects = pageOne.getSelectedExamples();
		System.out.println(selectedProjects);
		return true;
	}
}
