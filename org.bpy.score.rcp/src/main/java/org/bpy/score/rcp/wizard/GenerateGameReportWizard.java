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

import java.util.HashMap;
import java.util.List;

import org.bpy.score.preferences.core.PreferenceConstants;
import org.bpy.score.preferences.core.PreferenceManager;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.wizard.Wizard;

/**
 * This class is the wizard which allow to export game files into HTML files
 * 
 * @author Patrick BRIAND
 *
 */
public class GenerateGameReportWizard extends Wizard {

	/** Reference to the page one of the wizard */
	private GameReportWizardPageOne gameReportWizardPageOne;
	/** Reference to the page two of the wizard */
	private GameReportWizardPageTwo gameReportWizardPageTwo;
	/** Current selected folder */
	private IFolder currentFolder;

	/**
	 * Constructor of the class.
	 * 
	 * @param folder Reference to the current folder
	 */
	public GenerateGameReportWizard(IFolder folder) {
		setWindowTitle("New Wizard"); //$NON-NLS-1$
		
		currentFolder = folder;
	}

	/**
	 * Get the current folder. 
	 * 
	 * @return current folder
	 */
	public IFolder getCurrentFolder() {
		return currentFolder;
	}
	
	@Override
	public void addPages() {
		getShell().setSize(600, 530);

		gameReportWizardPageOne = new GameReportWizardPageOne();
		gameReportWizardPageOne.setParent(this);
		addPage(gameReportWizardPageOne);
		
		gameReportWizardPageTwo = new GameReportWizardPageTwo();
		gameReportWizardPageTwo.setParent(this);
		addPage(gameReportWizardPageTwo);
	}

	@Override
	public boolean canFinish() {
		return gameReportWizardPageOne.isValid() && gameReportWizardPageTwo.isValid();
	}

	@Override
	public boolean performFinish() {
		
		gameReportWizardPageOne.savePreferences();
		gameReportWizardPageTwo.savePreference();
		
		GameReportGenerator gameReportGenerator = new GameReportGenerator();
		HashMap<String,Object> options = new HashMap<>();
		
		options.put(GameReportGenerator.OUTPUT_FOLDER_KEY, gameReportWizardPageOne.getPath());
		options.put(GameReportGenerator.STANDARD_PREDEFINED_FLAG, gameReportWizardPageTwo.isStandardConf());
		if (!gameReportWizardPageTwo.isStandardConf()) {
			options.put(GameReportGenerator.CSS_FILE_PATH, gameReportWizardPageTwo.getCssFilePath());
			options.put(GameReportGenerator.XSLT_FILE_PATH, gameReportWizardPageTwo.getXsltFilePath());
			options.put(GameReportGenerator.BANNER_FILE_PATH, gameReportWizardPageTwo.getBannerFilePath());
		}
		String typeOfFile = PreferenceManager.getPreferenceValue(currentFolder.getProject(), PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_GENERATED_FILE, PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_HTML);
		options.put(GameReportGenerator.HTML_GENERATION, (PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_HTML.equals(typeOfFile)? Boolean.TRUE : Boolean.FALSE));
		
		List<IFile> selectedGames = gameReportWizardPageOne.getSelectedGames();
		gameReportGenerator.generateReport(selectedGames, options);
		
		return true;
	}

}
