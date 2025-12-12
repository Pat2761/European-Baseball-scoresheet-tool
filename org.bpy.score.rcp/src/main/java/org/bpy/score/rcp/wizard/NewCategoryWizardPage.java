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

import java.util.List;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * his class is the page for the wizard which allow to create a new category folder in a project
 * 
 * @author Patrick BRIAND
 *
 */
public class NewCategoryWizardPage extends WizardPage implements ModifyListener {
	
	/** Cobo widget for select a  possible category */
	private Combo combo;
	/** List of possible categories */
	private List<String> possibleCategories;
	/** Reference to the selected folder */
	private IFolder currentFolder;
	/** State of the page */
	private boolean isValid;

	/**
	 * Create the wizard.
	 */
	public NewCategoryWizardPage() {
		super(Messages.NewCategoryWizardPage_PageMessage);
		setTitle(Messages.NewCategoryWizardPage_PageTitle);
		setDescription(Messages.NewCategoryWizardPage_PageDescription);
	}

	/**
	 * get page state
	 * 
	 * @return <b>true</b> Page is complete,<b>false</b> otherwise
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Label lblSlectionDuNom = new Label(container, SWT.NONE);
		lblSlectionDuNom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblSlectionDuNom.setText(Messages.NewCategoryWizardPage_CategorySelectionLabel);
		
		combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		for (String value : possibleCategories) {
			combo.add(value);
		}
		combo.addModifyListener(this);
		modifyText(null);
	}

	/**
	 * Set all possibles values
	 * 
	 * @param possibleCategories Possible categories values
	 */
	public void setPossibleValues(List<String> possibleCategories) {
		this.possibleCategories = possibleCategories;
	}
	
	/**
	 * Get selected category name
	 * 
	 * @return selected category name
	 */
	public String getSelectedValue() {
		return combo.getText();
	}

	/**
	 * Set selected folder
	 * 
	 * @param currentFolder selected folder
	 */
	public void setRootFolder(IFolder currentFolder) {
		this.currentFolder = currentFolder;
	}

	@Override
	public void modifyText(ModifyEvent e) {
		if (getSelectedValue().isBlank()) {
			setErrorMessage(Messages.NewCategoryWizardPage_BlankCatgoryError);
			setPageComplete(false);
			isValid = false;
			return;
		}
		
		IFolder targetFolder = currentFolder.getFolder(getSelectedValue());
		if (targetFolder.exists()) {
			setErrorMessage(NLS.bind(Messages.NewCategoryWizardPage_CatgoryAlreadyDefined, getSelectedValue()));
			setPageComplete(false);
			isValid = false;
			return;
		}
		
		setErrorMessage(null);
		isValid = true;
		setPageComplete(true);
	}
}
