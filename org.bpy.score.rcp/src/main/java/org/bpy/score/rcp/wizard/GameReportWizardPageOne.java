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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.preferences.Activator;
import org.bpy.score.preferences.core.PreferenceConstants;
import org.bpy.score.preferences.core.PreferenceManager;
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * This class is the page one of generation report wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportWizardPageOne extends WizardPage implements SelectionListener {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportWizardPageOne.class.getSimpleName());
	
	/** Game extension constant */
	public static final String GAME_FILE_EXTENSION = ".game"; //$NON-NLS-1$
	
	/** Reference on the game report wizard */
	private GenerateGameReportWizard generateGameReportWizard;

	/** Select all game reports button */
	private Button allGameButton;
	/** Text widget for the output folder */
	private Text outputFoldePath;
	/** List of game to select */
	private List matchsSelector;
	/** Button for remove games selection */
	private Button clearGameSelectionBtn;
	/** Text widget for setting the Regex game selector */
	private Text regExSelectionText;
	/** Text widget for setting the Regex Display in the list of game */
	private Text regExDisplayText;
	/** Button for apply regex Display */
	private Button regExDisplayButton;
	/** Button for apply regex game selector */
	private Button regExSelButton;
	/** Button for select the output folder (absolute path)*/
	private Button genereationAbsolutePathBtn;
	/** Button for select the output folder (relative path)*/
	private Button genereationRelativePathBtn;

	/** List of displayed game elements */
	private HashMap<String, IFile> displayedElements;
	/** state of the page one */
	private boolean isValid;


	/**
	 * Create the wizard.
	 */
	public GameReportWizardPageOne() {
		super("wizardPage"); //$NON-NLS-1$
		setMessage(Messages.GameReportWizardPageOne_PageMessage);
		setTitle(Messages.GameReportWizardPageOne_PageTitle);
		setDescription(Messages.GameReportWizardPageOne_PageDescription);
	}

	/**
	 * Set Reference on the game report wizard
	 * 
	 * @param generateGameReportWizard Reference on the game report wizard
	 */
	public void setParent(GenerateGameReportWizard generateGameReportWizard) {
		this.generateGameReportWizard = generateGameReportWizard; 
	}
	
	/**
	 * Return the state of the page one
	 * 
	 * @return <b>true</b> is valid, <b>false</b> otherwise
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Get the list of selected games.
	 * 
	 * @return list of selected games
	 */ 
	public java.util.List<IFile> getSelectedGames() {
		int[] indices = matchsSelector.getSelectionIndices();
		
		java.util.List<IFile> selectedFiles = new ArrayList<>();
		for (int indice : indices) {
			String key = matchsSelector.getItem(indice);
			selectedFiles.add(displayedElements.get(key));
		}
		return selectedFiles;
	}

	/**
	 * Get the generation folder path
	 * 
	 * @return generation folder path
	 */
	public String getPath() {
		return outputFoldePath.getText();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent parent composite
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		Label lblSlectionDesMatchs = new Label(container, SWT.NONE);
		lblSlectionDesMatchs.setBounds(10, 10, 224, 15);
		lblSlectionDesMatchs.setText(Messages.GameReportWizardPageOne_GameSelection);
		
		matchsSelector = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		matchsSelector.setBounds(10, 31, 157, 236);
		matchsSelector.addSelectionListener(this);
		
		Label lblRpertoireDeGnration = new Label(container, SWT.NONE);
		lblRpertoireDeGnration.setBounds(10, 273, 224, 15);
		lblRpertoireDeGnration.setText(Messages.GameReportWizardPageOne_ReportGenerationFolder);
		
		outputFoldePath = new Text(container, SWT.BORDER);
		outputFoldePath.setBounds(10, 294, 401, 21);
		outputFoldePath.addModifyListener(event -> checkIsvalid());
		
		allGameButton = new Button(container, SWT.NONE);
		allGameButton.setBounds(177, 31, 125, 25);
		allGameButton.setText(Messages.GameReportWizardPageOne_AllGameSelection);
		allGameButton.addSelectionListener(this);
		
		clearGameSelectionBtn = new Button(container, SWT.NONE);
		clearGameSelectionBtn.setBounds(177, 62, 125, 25);
		clearGameSelectionBtn.setText(Messages.GameReportWizardPageOne_ClearGameSelection);
		clearGameSelectionBtn.addSelectionListener(this);
		
		Label lblExpressionRgulireDe = new Label(container, SWT.NONE);
		lblExpressionRgulireDe.setBounds(177, 100, 204, 15);
		lblExpressionRgulireDe.setText(Messages.GameReportWizardPageOne_RegularExpressionGameSelection);
		
		regExSelectionText = new Text(container, SWT.BORDER);
		regExSelectionText.setBounds(173, 121, 277, 21);
		
		regExSelButton = new Button(container, SWT.NONE);
		regExSelButton.setBounds(388, 94, 62, 21);
		regExSelButton.setText(Messages.GameReportWizardPageOne_ApplyButton);
		regExSelButton.addSelectionListener(this);
		
		Label lblExpressionRgulireDaffichage = new Label(container, SWT.NONE);
		lblExpressionRgulireDaffichage.setText(Messages.GameReportWizardPageOne_RegularExpressionGameDisplay);
		lblExpressionRgulireDaffichage.setBounds(173, 167, 204, 15);
		
		regExDisplayText = new Text(container, SWT.BORDER);
		regExDisplayText.setText(StringUtils.EMPTY);
		regExDisplayText.setBounds(173, 188, 277, 21);
		
		regExDisplayButton = new Button(container, SWT.NONE);
		regExDisplayButton.setText(Messages.GameReportWizardPageOne_ApplyButton);
		regExDisplayButton.setBounds(388, 164, 62, 21);
		
		genereationAbsolutePathBtn = new Button(container, SWT.NONE);
		genereationAbsolutePathBtn.setToolTipText(Messages.GameReportWizardPageOne_GenereationAbsolutePathToolTip);
		genereationAbsolutePathBtn.setText(Messages.GameReportWizardPageOne_GenereationAbsolutePathTextButton );
		genereationAbsolutePathBtn.setBounds(10, 321, 86, 25);
		genereationAbsolutePathBtn.addSelectionListener(this);
		
		genereationRelativePathBtn = new Button(container, SWT.NONE);
		genereationRelativePathBtn.setToolTipText(Messages.GameReportWizardPageOne_GenereationRelativeToolTip);
		genereationRelativePathBtn.setText(Messages.GameReportWizardPageOne_GenereationRelativePathTextButton);
		genereationRelativePathBtn.setBounds(102, 321, 80, 25);
		genereationRelativePathBtn.addSelectionListener(this);
		
		regExDisplayButton.addSelectionListener(this);
		
		checkIsvalid();
	}


	@Override
	public void setVisible(boolean visible) {
		
		String displayRegularExpression = RcpUtils.getPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.DISPLAY_REGULAR_EXPRESSION_KEY);
		String selectionRegularExpression = RcpUtils.getPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.SELECTION_REGULAR_EXPRESSION_KEY);
		String outputPath = RcpUtils.getPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.OUTPUT_FOLDER_KEY);
		 
		regExDisplayText.setText(displayRegularExpression);
		regExSelectionText.setText(selectionRegularExpression);
		outputFoldePath.setText(outputPath);
		
		displayedElements = new HashMap<>();
		try {
			for (IResource member : generateGameReportWizard.getCurrentFolder().members()) {
				if ( (member instanceof IFile) && 
					 (member.getRawLocation().lastSegment().toLowerCase().endsWith(GAME_FILE_EXTENSION))) {
					String key = member.getRawLocation().lastSegment().replace(GAME_FILE_EXTENSION, ""); //$NON-NLS-1$
					displayedElements.put(key, (IFile) member);
				}
			}
			
			java.util.List<String> toDisplayed = new ArrayList<>(displayedElements.keySet());
			Collections.sort(toDisplayed);
			
			for (String toDisplay : toDisplayed) {
				matchsSelector.add(toDisplay);
			}
			
		} catch (CoreException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
		
		super.setVisible(visible);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == regExDisplayButton) {
			setListOfFilesFromRegularExpression();

		} else if (e.getSource() == regExSelButton) {
			selectFilesFromRegularExpression();
			
		} else if (e.getSource() == clearGameSelectionBtn) {
			matchsSelector.deselectAll();
			
		} else if (e.getSource() == allGameButton) {
			matchsSelector.selectAll();
			
		} else if (e.getSource() == genereationAbsolutePathBtn) {
			getSelectedOutputFolder();

		} else if (e.getSource() == genereationRelativePathBtn) {
			getSelectedRelativeOutputFolder(outputFoldePath, IResource.FOLDER);
		}
		checkIsvalid();
	}

	/**
	 * Check if page one is valid
	 */
	private void checkIsvalid() {
		boolean atLeastOneMatch = matchsSelector.getItems().length > 0;
		
		boolean folderExist = false;
		try {
			String outputFolderPath = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(outputFoldePath.getText());
			File folder = new File(outputFolderPath);
			folderExist = folder.exists() && folder.isDirectory();

		} catch (CoreException e) {
			isValid = false;
			setErrorMessage(NLS.bind(Messages.GameReportWizardPageOne_NotAValidFolder, outputFoldePath.getText()));
			setPageComplete(false);
			return;
		}
		
		if (!atLeastOneMatch) {
			isValid = false;
			setErrorMessage(Messages.GameReportWizardPageOne_OneGameMustBeSeelcted);
			setPageComplete(false);
			return;
		}
		
		if (!folderExist) {
			isValid = false;
			setErrorMessage(NLS.bind(Messages.GameReportWizardPageOne_NotAValidFolder, outputFoldePath.getText()));
			setPageComplete(false);
			return;
		}
		
		isValid = true;
		setErrorMessage(null);
		setPageComplete(true);
	}

	/**
	 * Set list of game extract with the regular expression 
	 */
	private void setListOfFilesFromRegularExpression() {
		matchsSelector.removeAll();
		
		Pattern pattern = Pattern.compile(regExDisplayText.getText());
		java.util.List<String> filesToDisplay = new ArrayList<>();
		for (Entry<String, IFile> entry : displayedElements.entrySet()) {

			String gameName = entry.getKey().replaceAll(GAME_FILE_EXTENSION, ""); //$NON-NLS-1$
			
			Matcher matcher = pattern.matcher(gameName);
			if (matcher.matches()) {
				filesToDisplay.add(gameName);
			}
		}
		Collections.sort(filesToDisplay);
		for (String fileToDisplay : filesToDisplay) {
			matchsSelector.add(fileToDisplay);
		}	
		
	}

	/**
	 * Select game based which match with the regular expression.
	 */
	private void selectFilesFromRegularExpression() {
		matchsSelector.deselectAll();
		
		Pattern pattern = Pattern.compile(regExSelectionText.getText());
		java.util.List<Integer> selectedItems = new ArrayList<>();
		for (int index=0 ; index<matchsSelector.getItemCount() ; index++) {
			
			String gameName = matchsSelector.getItem(index).replaceAll(GAME_FILE_EXTENSION, ""); //$NON-NLS-1$
			
			Matcher matcher = pattern.matcher(gameName);
			if (matcher.matches()) {
				selectedItems.add(index);
			}
		}
		IntStream values = selectedItems.stream().mapToInt(Integer::intValue) ;
		
		matchsSelector.select(values.toArray());
	}

	private void getSelectedRelativeOutputFolder(Text textToUpdate, int type) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(),new WorkbenchContentProvider());
		dialog.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (type == IResource.FOLDER) {
					return (element instanceof IProject) || (element instanceof IFolder);
				} else {
					return (element instanceof IProject) || (element instanceof IFolder) || (element instanceof IFile);
				}

			}
		});

		dialog.setTitle(Messages.GameReportWizardPageOne_DialogRelativePath_Title);
		dialog.setValidator(selection -> {

			if (selection.length == 0) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportWizardPageOne_DialogError1_Title, null);
			} else if (selection.length > 1) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportWizardPageOne_DialogError2_Title, null);
			} else if ((type == IResource.FILE) && !(selection[0] instanceof IFile)) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportWizardPageOne_DialogError3_Title, null);
			}
			return new Status(IStatus.OK, Activator.PLUGIN_ID, 0, Messages.GameReportWizardPageOne_DialogNoError_Title, null);
		});

		dialog.setMessage(Messages.GameReportWizardPageOne_DialogRelativePath_Message);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		if (dialog.open() == IDialogConstants.OK_ID) {
			IResource resource = (IResource) dialog.getFirstResult();
			if (resource != null) {
				String arg = resource.getFullPath().toString();
				String fileLoc = VariablesPlugin.getDefault().getStringVariableManager().generateVariableExpression("workspace_loc", arg); //$NON-NLS-1$
				textToUpdate.setText(fileLoc);
			}
		}

	}
	
	/**
	 * Get selected output folder
	 * 
	 */
	private void getSelectedOutputFolder() {
		DirectoryDialog  dialog = new DirectoryDialog (new Shell());
		
		if (outputFoldePath.getText().isBlank()) {
			dialog.setFilterPath(generateGameReportWizard.getCurrentFolder().getProject().getLocationURI().getRawFragment() );
		} else {
			dialog.setFilterPath(outputFoldePath.getText());
		}
		String result = dialog.open();
		if (result != null) {
			outputFoldePath.setText(result);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do here
	}

	/**
	 * Save configuration in the preference for the next call
	 */
	public void savePreferences() {
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.SELECTION_REGULAR_EXPRESSION_KEY, regExSelectionText.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.DISPLAY_REGULAR_EXPRESSION_KEY, regExDisplayText.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.OUTPUT_FOLDER_KEY, outputFoldePath.getText());
	}
}
