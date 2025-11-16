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

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bpy.score.club.club.Club;
import org.bpy.score.club.club.Player;
import org.bpy.score.club.club.Team;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.game.util.GameDataParser;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * This class is a wizard for create a new game in the project.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewGameWizard extends Wizard {

	/** End of line with open accolade constant */
	public static final String END_LINE_WITH_OPEN_ACCOLADE = "\" {\r\n"; //$NON-NLS-1$

	/** End of line with accolade semicolon constant */
	public static final String END_LINE_WITH_SEMI_COLON = "\";\r\n"; //$NON-NLS-1$

	/** End of line with close accolade constant */
	public static final String END_LINE_WITH_CLOSE_ACCOLADE = "\t}\r\n"; //$NON-NLS-1$
	
	/** Reference to the club data parser utility class */
	private ClubDataParser clubDataParser;
	/** Reference to the game data parser utility class */
	private GameDataParser gameDataParser;

	/** Current selected folder */
	private IFolder currentFolder;
	
	/** Reference to the page one of the wizard */
	private NewGamePageOneWizard newGamePageOneWizard;
	/** Reference to the page two of the wizard */
	private NewGamePageTwoWizard newGamePageTwoWizard;

	/**
	 * Constructor of the class
	 * 
	 * @param folder Current selected folder
	 */
	public NewGameWizard(IFolder folder) {
		setWindowTitle(Messages.NewGameWizard_Title);

		clubDataParser = new ClubDataParser();
		gameDataParser = new GameDataParser(); 
		this.currentFolder = folder;
	}

	/**
	 * Get the reference to the club data parser utility class
	 * 
	 * @return Reference to the club data parser utility class
	 */
	public ClubDataParser getClubDataParser() {
		return clubDataParser;
	}

	/**
	 * Get the reference to the game data parser utility class
	 * 
	 * @return Reference to the game data parser utility class
	 */
	public GameDataParser getGameDataParser() {
		return gameDataParser;
	}

	/**
	 * Get the current selected folder
	 * 
	 * @return current selected folder
	 */
	public IFolder getCurrentFolder() {
		return currentFolder;
	}

	@Override
	public void addPages() {

		clubDataParser.parseData((IFolder) currentFolder.getParent());
		gameDataParser.parseData(currentFolder);

		newGamePageOneWizard = new NewGamePageOneWizard(currentFolder.getName());
		newGamePageOneWizard.setNewGameWizard(this);
		addPage(newGamePageOneWizard);
		
		newGamePageTwoWizard = new NewGamePageTwoWizard();
		newGamePageTwoWizard.setNewGameWizard(this);
		addPage(newGamePageTwoWizard);
	}

	@Override
	public boolean canFinish() {
		
		return newGamePageOneWizard.getPageCompleted() && newGamePageTwoWizard.getPageCompleted();
	}

	@Override
	public boolean performFinish() {
		createFile();
		return true;
	}

	/**
	 * Create the game file.
	 */
	private void createFile() {
		StringBuilder strBuffer = new StringBuilder("game \"" + newGamePageOneWizard.getGameName() + END_LINE_WITH_OPEN_ACCOLADE); //$NON-NLS-1$
		strBuffer.append("\r\n"); //$NON-NLS-1$
		strBuffer.append("\theader {\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\ttournament = \""+ currentFolder.getName()  +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tstadium = \"" + newGamePageOneWizard.getStadium() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tplace = \"" + newGamePageOneWizard.getPlace() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tdate = \"" + newGamePageOneWizard.getDate() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tstartTime = \"" + newGamePageOneWizard.getStarttime() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tendTime = \"" + newGamePageOneWizard.getEndtime() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\tduration = \"" + newGamePageOneWizard.getDuration() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		strBuffer.append("\t\ttype = " + newGamePageOneWizard.getGameType() +";\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
		strBuffer.append("\t\tcategory = \"" + newGamePageOneWizard.getCategory() +END_LINE_WITH_SEMI_COLON); //$NON-NLS-1$
		declareOfficials(strBuffer, "scorekeepers", newGamePageTwoWizard.getSelectedScorekeepers()); //$NON-NLS-1$
		declareOfficials(strBuffer, "umpires", newGamePageTwoWizard.getSelectedUmpires()); //$NON-NLS-1$
		strBuffer.append(END_LINE_WITH_CLOSE_ACCOLADE);
		strBuffer.append("\r\n"); //$NON-NLS-1$
		
		/* put the rosters */
		Club visitor = newGamePageOneWizard.getVisitor();
		strBuffer.append("\troster visitor \""+ visitor.getClubDescription().getName() + END_LINE_WITH_OPEN_ACCOLADE); //$NON-NLS-1$
	    if (newGamePageOneWizard.isFullRoster()) {
	    	addFullRoster(strBuffer,visitor);
	    }
		strBuffer.append(END_LINE_WITH_CLOSE_ACCOLADE);
		strBuffer.append("\r\n"); //$NON-NLS-1$
		
		Club hometeam = newGamePageOneWizard.getHometeam();
	    strBuffer.append("\troster hometeam \""+ hometeam.getClubDescription().getName() + END_LINE_WITH_OPEN_ACCOLADE); //$NON-NLS-1$
	    if (newGamePageOneWizard.isFullRoster()) {
	    	addFullRoster(strBuffer,hometeam);
	    }
		strBuffer.append(END_LINE_WITH_CLOSE_ACCOLADE);
		strBuffer.append("\r\n"); //$NON-NLS-1$
		strBuffer.append("\tgameEntry {\r\n"); //$NON-NLS-1$
		strBuffer.append("\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\t/* Lineup description for the visitor */\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\tlineup visitor {\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\t}\r\n"); //$NON-NLS-1$
		strBuffer.append("\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\t/* Lineup description for the hometeam */\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\tlineup hometeam {\r\n"); //$NON-NLS-1$
		strBuffer.append("\t\t}\r\n"); //$NON-NLS-1$
		strBuffer.append(END_LINE_WITH_CLOSE_ACCOLADE);	
		
		strBuffer.append("}\r\n"); //$NON-NLS-1$
		
		IFile gameFile = currentFolder.getFile(newGamePageOneWizard.getGameName() + ".game"); //$NON-NLS-1$
		if (!gameFile.exists()) {
			try {
				gameFile.create(new ByteArrayInputStream(strBuffer.toString().getBytes()), true,
					new NullProgressMonitor());

				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IDE.openEditor(page, gameFile);

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Declare the full roster of a club
	 * 
	 * @param strBuffer String container 
	 * @param club club reference
	 */
	private void addFullRoster(StringBuilder strBuffer, Club club) {
		String category = newGamePageOneWizard.getCategory();
		
		List<String> players = new ArrayList<>();
		for ( Team clubCategory : club.getClubDescription().getTeams()) {
			if (category.equals(clubCategory.getName())) {
				for (Player player : clubCategory.getPlayers()) {
					players.add(player.getPlayerName().getName());
				}
			}
		}
		Collections.sort(players);
		
		for (int i=0 ; i<players.size() ; i++) {
			String playerName = players.get(i);
			
			if (i<(players.size()-1)) {
				strBuffer.append("\t\tplayer \"" + playerName + "\",\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				strBuffer.append("\t\tplayer \"" + playerName + "\"\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Declare the officials in the game
	 * 
	 * @param strBuffer  String container 
	 * @param key represents 'umpire' or 'scorekeepers' key word
	 * @param selectedMembers Selected official
	 */
	private void declareOfficials(StringBuilder strBuffer, String key, String[] selectedMembers) {
		strBuffer.append("\t\t" + key + " = "); //$NON-NLS-1$ //$NON-NLS-2$
		
		for (int i=0 ; i<selectedMembers.length; i++) {
			strBuffer.append("\"" + selectedMembers[i] + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			if (i < selectedMembers.length-1) {
				strBuffer.append(", "); //$NON-NLS-1$
			}
		}
		strBuffer.append(";\r\n"); //$NON-NLS-1$
	}
}
