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
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This class provide a wizard page which allow to create a new season folder.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewSeasonWizardPage extends WizardPage implements ModifyListener {

	/** Text widget which contains the name of the season */
	private Text seasonName;
	/** Is valid state */
	private boolean isValid = false;

	/**
	 * Create the wizard.
	 */
	public NewSeasonWizardPage() {
		super("wizardPage"); //$NON-NLS-1$
		setTitle(Messages.NewSeasonWizardPage_PageTitle);
		setDescription(Messages.NewSeasonWizardPage_PageDescription);
	}

	/**
	 * Get if all the page is correctly fulfilled.
	 * 
	 * @return <b>true</b> the page is correctly fulfilled, <b>false</b> otherwise
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);

		Label lblDfinirLeNom = new Label(container, SWT.NONE);
		lblDfinirLeNom.setBounds(10, 10, 171, 15);
		lblDfinirLeNom.setText(Messages.NewSeasonWizardPage_SeasonNameLabel);

		seasonName = new Text(container, SWT.BORDER);
		seasonName.setBounds(10, 31, 196, 21);
		seasonName.addModifyListener(this);
	}
	
	/**
	 * get season name
	 * 
	 * @return season name
	 */
	public String getSeasonName() {
		return seasonName.getText();
	}

	@Override
	public void modifyText(ModifyEvent e) {
		IProject currentProject = RcpUtils.getToolSelectedProject();
		if (currentProject != null) {

			IFile file = currentProject.getFile(currentProject.getName() + File.separator + seasonName.getText());
			if (file.exists()) {
				isValid = false;
				setErrorMessage(NLS.bind(Messages.NewSeasonWizardPage_FileSeasonNameError, seasonName.getText()));
				setPageComplete(false);
				return;
			}

			IFolder folder = currentProject.getFolder(seasonName.getText());
			if (folder.exists()) {
				isValid = false;
				setErrorMessage(NLS.bind(Messages.NewSeasonWizardPage_DuplicateSeasonNameError, seasonName.getText()));
				setPageComplete(false);
				return;
			}

			setErrorMessage(null);
			isValid = true;
			setPageComplete(true);
		}
	}

}
