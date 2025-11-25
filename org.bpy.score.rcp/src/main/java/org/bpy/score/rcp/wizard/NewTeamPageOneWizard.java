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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.bpy.score.club.club.Club;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * Page one of the New team wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamPageOneWizard extends WizardPage implements ModifyListener {
	/** Text widget which contains the club name */
	private Text clubName;
	/** Text widget which contains the city name */
	private Text cityName;
	/** List widget which display the categories*/
	private List categories;
	/** Button widget for remove a categories*/
	private Button deleteCategoryButton;
	/** Button widget for rename a categories*/
	private Button renameCategoryButton;

	/** Reference on the wizard owner of this page */
	private NewTeamWizard newTeamWizard;
	/** Current selected folder */
	private IFolder currentFolder;
	/** Club data parser reference */
	private ClubDataParser clubDataParser;

	/** List of club names in the folder */
	private java.util.List<String> clubNames;
	
	/**
	 * Create the wizard.
	 */
	public NewTeamPageOneWizard() {
		super("NewTeamPageOneWizard"); //$NON-NLS-1$
		setTitle(Messages.NewTeamPageOneWizard_PageTitle);
		setDescription(Messages.NewTeamPageOneWizard_PageDescription);
		
		clubNames = new ArrayList<>();
	}

	/**
	 * Create the club name list
	 * 
	 * @param clubsAlreadyDefined a club description
	 */
	public void setClubsDescription(ClubDataParser clubsAlreadyDefined) {
		for (Resource resource : clubsAlreadyDefined.getClubsDescription()) {
			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject content = contents.next();
				if (content instanceof Club) {
					clubNames.add( ((Club)content).getName());
				}
			}
		}
	}
	
	/**
	 * Set the current selected folder.
	 * 
	 * @param currentFolder current selected folder
	 */
	public void setCurrentFolder(IFolder currentFolder) {
		this.currentFolder = currentFolder;
	}

	/** 
	 * Set the reference on the wizard owner of this page. 
	 * 
	 * @param newTeamWizard reference on the wizard owner of this page 
	 */ 
	public void setNewTeamWizard(NewTeamWizard newTeamWizard) {
		this.newTeamWizard = newTeamWizard;
	}

	/**
	 * Get club name
	 * 
	 * @return club name
	 */
	public String getClubName() {
		return clubName.getText();
	}

	/**
	 * Get city name
	 * 
	 * @return city name
	 */
	public String getCityName() {
		return cityName.getText();
	}

	/**
	 * Get list of category names
	 * 
	 * @return list of category names
	 */
	public java.util.List<String> getCategories() {
		return Arrays.asList(categories.getItems());
	}

	/**
	 * Get club parser utility class.
	 * 
	 * @return club parser utility class.
	 */
	public ClubDataParser getClubDataParser() {
		return clubDataParser;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);

		Label lblClubName = new Label(container, SWT.NONE);
		lblClubName.setBounds(10, 10, 140, 24);
		lblClubName.setText(Messages.NewTeamPageOneWizard_ClubNameLabel);

		clubName = new Text(container, SWT.BORDER);
		clubName.setBounds(10, 40, 238, 31);
		clubName.addModifyListener(this);

		Label lblCityName = new Label(container, SWT.NONE);
		lblCityName.setBounds(10, 77, 229, 24);
		lblCityName.setText(Messages.NewTeamPageOneWizard_CityNameLabel);

		cityName = new Text(container, SWT.BORDER);
		cityName.setBounds(10, 107, 238, 27);
		cityName.addModifyListener(this);

		Label lblCategory = new Label(container, SWT.NONE);
		lblCategory.setBounds(10, 130, 140, 24);
		lblCategory.setText(Messages.NewTeamPageOneWizard_CategoriesLabel);

		categories = new List(container, SWT.BORDER);
		categories.setBounds(10, 163, 238, 126);
		categories.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				categorySelectionListener();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}
		});

		Button newCategoryButton = new Button(container, SWT.NONE);
		newCategoryButton.setBounds(259, 150, 287, 25);
		newCategoryButton.setText(Messages.NewTeamPageOneWizard_NewCategoryButton);
		newCategoryButton.addListener(SWT.Selection, e -> addNewCategory());
		
		deleteCategoryButton = new Button(container, SWT.NONE);
		deleteCategoryButton.setEnabled(false);
		
		deleteCategoryButton.setBounds(259, 182, 287, 25);
		deleteCategoryButton.setText(Messages.NewTeamPageOneWizard_RemoveCategoryButton);
		deleteCategoryButton.addListener(SWT.Selection, event -> deleteCategory());

		renameCategoryButton = new Button(container, SWT.NONE);
		renameCategoryButton.setEnabled(false);
		renameCategoryButton.setBounds(259, 212, 287, 25);
		renameCategoryButton.setText(Messages.NewTeamPageOneWizard_RenameCategoryButton);
		renameCategoryButton.addListener(SWT.Selection, event -> renameCategory()); 

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				importFromOldTeam();
			}
		});
		btnNewButton.setBounds(283, 27, 263, 25);
		btnNewButton.setText(Messages.NewTeamPageOneWizard_ClubImportationButton);

				
		modifyText(null);
	}

	/**
	 * Import a club from an another club description
	 */
	protected void importFromOldTeam() {
		
		/* On cherche les fichier de description d'un club */
		HashMap<String, IFile> clubsDescription = new HashMap<>(); 
		createListOfPossiblesClubs(clubsDescription, (IContainer)ResourcesPlugin.getWorkspace().getRoot(), currentFolder);
		String[] choices = clubsDescription.keySet().toArray(new String[clubsDescription.keySet().size()]);

		/* On permet � l'utilisateur de s�lectionner le club � importer */
		ElementListSelectionDialog elementListSelectionDialog = new ElementListSelectionDialog(new Shell(), new LabelProvider());
		elementListSelectionDialog.setTitle(Messages.NewTeamPageOneWizard_ClubImportationDialogTitle);
		elementListSelectionDialog.setMessage(Messages.NewTeamPageOneWizard_ClubImportationDialogMessage);
		elementListSelectionDialog.setElements(choices);
		elementListSelectionDialog.setMultipleSelection(false);
		if (elementListSelectionDialog.open() == Window.OK) {
			
			/* Importation du club */
			clubDataParser = new ClubDataParser();
			clubDataParser.parseData(clubsDescription.get(elementListSelectionDialog.getFirstResult()));
			
			cityName.setText(clubDataParser.getCityName());
			clubName.setText(clubDataParser.getClubName());
			
			categories.removeAll();
			for (String category :clubDataParser.getCategories().keySet()) {
				categories.add(category);
			}
			
			newTeamWizard.setClubDescription(clubDataParser);
		}
	}


	/**
	 * Create a list of possible clubs
	 * 
	 * @param clubsDescription club flies
	 * @param container folder which contains the club files
	 * @param currentFolderExcluded current selected folder
	 */
	private void createListOfPossiblesClubs(HashMap<String, IFile> clubsDescription, IContainer container, IFolder currentFolderExcluded) {
		IResource[] members;
		try {
			members = container.members();
			for (IResource member : members)
			{
			   if (member instanceof IContainer) {
				   
				   if (!member.getFullPath().toOSString().equals(currentFolderExcluded.getFullPath().toOSString())) {
					   createListOfPossiblesClubs(clubsDescription, (IContainer)member, currentFolderExcluded);
				   }	   
			   } else if ((member instanceof IFile) && 
				   (((IFile)member).getFileExtension().equalsIgnoreCase("club"))) { //$NON-LS-1$ //$NON-NLS-1$
			   
				  String path = member.getParent().getFullPath().toOSString();
				  String key = ((IFile)member).getName() + " (" + path +")"; //$NON-LS-1$ //$NON-LS-2$ //$NON-NLS-1$ //$NON-NLS-2$
				  clubsDescription.put(key, (IFile) member);
			   }    
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Categogry selection listener 
	 */
	protected void categorySelectionListener() {
		deleteCategoryButton.setEnabled(categories.getSelectionCount() > 0);
		renameCategoryButton.setEnabled(categories.getSelectionCount() > 0);
	}

	/**
	 * Rename a category
	 */
	protected void renameCategory() {
		int index = categories.getSelectionIndex();

		if (index != -1) {
			InputDialog dialog = new InputDialog(new Shell(), Messages.NewTeamPageOneWizard_RenameCategoryDialogTitle,
					Messages.NewTeamPageOneWizard_RenameCategoryDialogMessage, categories.getItem(index), null);
			int status = dialog.open();
			if (status == Window.OK) {
				String[] items = categories.getItems();
				if (Arrays.asList(items).contains(dialog.getValue())) {

					MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
					messageBox.setText(Messages.NewTeamPageOneWizard_NewCategoryErrorTitle);
					messageBox.setMessage(NLS.bind(Messages.NewTeamPageOneWizard_NewCategoryErrorMessage, dialog.getValue()));
					messageBox.open();

				} else {
					categories.remove(index);
					categories.add(dialog.getValue(), index);
				}
			}
		}
	}

	/**
	 * Delete a category
	 */
	protected void deleteCategory() {
		int index = categories.getSelectionIndex();
		if (index != -1) {
			categories.remove(index);
			categorySelectionListener();
		}
	}

	/**
	 * Add a new Category
	 */
	protected void addNewCategory() {
		InputDialog dialog = new InputDialog(new Shell(), Messages.NewTeamPageOneWizard_NewCategoryDialogTitle, 
				Messages.NewTeamPageOneWizard_NewCategoryDialogMessage,
				StringUtils.EMPTY, null);
		int status = dialog.open();
		if (status == Window.OK) {
			String[] items = categories.getItems();
			if (Arrays.asList(items).contains(dialog.getValue())) {

				MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_ERROR);
				messageBox.setText(Messages.NewTeamPageOneWizard_NewCategoryErrorTitle);
				messageBox.setMessage(NLS.bind(Messages.NewTeamPageOneWizard_NewCategoryErrorMessage, dialog.getValue()));
				messageBox.open();

			} else {
				categories.add(dialog.getValue());
			}
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		/* controle sur le nom d'un club */
		if (clubName.getText().isBlank()) {
			setErrorMessage(Messages.NewTeamPageOneWizard_BlankClubNameError);
			setPageComplete(false);
			return;
		}
		
		if (clubNames.contains(clubName.getText())) {
			setErrorMessage(NLS.bind(Messages.NewTeamPageOneWizard_BlankClubAlreadyDefiendError, clubName.getText()));
			setPageComplete(false);
			return;
		}
		
		if ("".equals(cityName.getText())) { //$NON-NLS-1$
			setErrorMessage(Messages.NewTeamPageOneWizard_BlankCityNameError);
			setPageComplete(false);
			return;
		}
		
		setErrorMessage(null);
		setPageComplete(true);
		newTeamWizard.getContainer().updateButtons();
	}

}
