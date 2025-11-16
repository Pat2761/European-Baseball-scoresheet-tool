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

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.importer.HtmlStatcrewImporter;
import org.eclipse.jface.wizard.Wizard;

/**
 * This class is a wizard for import Html description game coming from the FFBS 
 * 
 * @author Patrick BRIAND
 *
 */
public class ImportHtmlWizard extends Wizard {

	/**	Page of the wizard */
	private ImportHtmlWizardPage importHtmlWizardPage;

	/**
	 * Constructor of the class.
	 */
	public ImportHtmlWizard() {
		setWindowTitle(Messages.ImportHtmlWizard_WizardTitle);
	}

	@Override
	public void addPages() {
		importHtmlWizardPage = new ImportHtmlWizardPage();
		addPage(importHtmlWizardPage);
	}

	@Override
	public boolean canFinish() {
		return importHtmlWizardPage.canFinish();
	}

	@Override
	public boolean performFinish() {
		HtmlStatcrewImporter htmlStatcrewImporter = new HtmlStatcrewImporter();
		htmlStatcrewImporter.readFile(importHtmlWizardPage.getFileName());
		return true;
	}

}
