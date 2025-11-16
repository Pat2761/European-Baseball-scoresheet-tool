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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.util.GameDataParser;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Search game by date wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameForTeamWizard extends Wizard {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(SearchGameForTeamWizard.class.getSimpleName());

	/** Reference on the page one of the wizard */
	private SearchGameForTeamWizardPageOne pageOne;

	/** Reference on the club parser utility class */ 
	private ClubDataParser clubDataParser;
	/** Reference on the game parser utility class */
	private GameDataParser gameDataParser;

	/** Current selected folder */
	private IFolder currentFolder;

	/**
	 * Constructor of the class.
	 * 
	 * @param folder Current selected folder
	 */
	public SearchGameForTeamWizard(IFolder folder) {
		setWindowTitle(Messages.SearchGameForTeamWizard_WizardTitle);
		this.currentFolder = folder;
		
		clubDataParser = new ClubDataParser();
		gameDataParser = new GameDataParser(); 

	}

	/**
	 * Get the reference on the club parser utility class
	 * 
	 * @return Reference on the club parser utility class
	 */
	public ClubDataParser getClubDataParser() {
		return clubDataParser;
	}

	/**
	 * Get the reference on the game parser utility class
	 * 
	 * @return Reference on the game parser utility class
	 */
	public GameDataParser getGameDataParser() {
		return gameDataParser;
	}

	@Override
	public void addPages() {
		
		clubDataParser.parseData((IFolder) currentFolder.getParent());
		gameDataParser.parseData(currentFolder);

		pageOne = new SearchGameForTeamWizardPageOne(this, currentFolder.getName());
		addPage(pageOne);
	}

	@Override
	public boolean performFinish() {
		
		Game selectedGame = pageOne.getSelectedGame();
		if (selectedGame != null) {
			URI eUri = selectedGame.eResource().getURI();
			if (eUri.isPlatformResource()) {
				String platformString = eUri.toPlatformString(true);
				IFile iFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
				
	           IWorkbench wb = PlatformUI.getWorkbench();
	           IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
	           IWorkbenchPage page = window.getActivePage();
	           IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(iFile.getName());
	           try {
	            page.openEditor(new FileEditorInput(iFile), desc.getId());
	          } catch (PartInitException e) {
	            logger.log(Level.SEVERE,e.getMessage());
	          }
			}
			
		}
		return true;
	}

	@Override
	public boolean canFinish() {
		return pageOne.canFinish();
	}

}
