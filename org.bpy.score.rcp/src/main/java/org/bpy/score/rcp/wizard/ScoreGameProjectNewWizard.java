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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * Under development
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameProjectNewWizard extends Wizard implements INewWizard {

	/** page one */
	private WizardNewProjectCreationPage _pageOne;

	/** 
	 * Constructor of the class
	 */
	public ScoreGameProjectNewWizard() {
		setWindowTitle("My Wizard name");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Nothing to do
	}

	@Override
	public void addPages() {
		super.addPages();

		_pageOne = new WizardNewProjectCreationPage("From Scratch Project Wizard");
		_pageOne.setTitle("From Scratch Project");
		_pageOne.setDescription("Create something from scratch.");

		addPage(_pageOne);

	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
