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
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
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
	public static final String GAME_FILE_EXTENSION = ".game";
	
	/** Reference on the game report wizard */
	private GenerateGameReportWizard generateGameReportWizard;

	/** Select all game reports button */
	private Button allGameButton;
	/** Text widget for the output folder */
	private Text outputFoldePath;
	/** List of game to select */
	private List matchsSelector;
	/** Button for select the output folder */
	private Button outPutFolderSelectionBtn;
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
		
		outPutFolderSelectionBtn = new Button(container, SWT.NONE);
		outPutFolderSelectionBtn.setBounds(417, 294, 33, 21);
		outPutFolderSelectionBtn.setText("..."); //$NON-NLS-1$
		outPutFolderSelectionBtn.addSelectionListener(this);
		
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
		regExDisplayButton.addSelectionListener(this);
		
		checkIsvalid();
	}


	@Override
	public void setVisible(boolean visible) {
		
		String displayRegularExpression = RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.DISPLAY_REGULAR_EXPRESSION_KEY);
		String selectionRegularExpression = RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.SELECTION_REGULAR_EXPRESSION_KEY);
		String outputPath = RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.OUTPUT_FOLDER_KEY);
		 
		regExDisplayText.setText(displayRegularExpression);
		regExSelectionText.setText(selectionRegularExpression);
		outputFoldePath.setText(outputPath);
		
		displayedElements = new HashMap<>();
		try {
			for (IResource member : generateGameReportWizard.getCurrentFolder().members()) {
				if ( (member instanceof IFile) && 
					 (member.getRawLocation().lastSegment().toLowerCase().endsWith(GAME_FILE_EXTENSION))) {
					displayedElements.put(member.getRawLocation().lastSegment(), (IFile) member);
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
			
		} else if (e.getSource() == outPutFolderSelectionBtn) {
			getSelectedOutputFolder();
		}
		checkIsvalid();
	}

	/**
	 * Check if page one is valid
	 */
	private void checkIsvalid() {
		boolean atLeastOneMatch = matchsSelector.getItems().length > 0;
		
		File folder = new File(outputFoldePath.getText());
		boolean folderExist = folder.exists() && folder.isDirectory();
		
		isValid = atLeastOneMatch && folderExist;
		setPageComplete(isValid);
	}

	/**
	 * Set list of game extract with the regular expression 
	 */
	private void setListOfFilesFromRegularExpression() {
		matchsSelector.removeAll();
		
		Pattern pattern = Pattern.compile(regExDisplayText.getText());
		java.util.List<String> filesToDisplay = new ArrayList<>();
		for (Entry<String, IFile> entry : displayedElements.entrySet()) {

			String gameName = entry.getKey().replaceAll(GAME_FILE_EXTENSION, "");
			
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
			
			String gameName = matchsSelector.getItem(index).replaceAll(GAME_FILE_EXTENSION, "");
			
			Matcher matcher = pattern.matcher(gameName);
			if (matcher.matches()) {
				selectedItems.add(index);
			}
		}
		IntStream values = selectedItems.stream().mapToInt(Integer::intValue) ;
		
		matchsSelector.select(values.toArray());
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
