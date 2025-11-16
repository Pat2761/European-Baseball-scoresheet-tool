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
package org.bpy.score.rcp.handler;

import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

/**
 * Handler for the creation of a new project which can be used as example.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewExampleProjectForScenarios implements IHandler {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(NewExampleProjectForScenarios.class.getSimpleName());
	
	/** String constant */
	public static final String GAME_CLOSE_ACCOLADE_1 = "          }\r\n"; //$NON-NLS-1$
	/** Club license number constant */
	public static final String CLUB_LICNESE_NUMBER = "\" licenceNumber = \""; //$NON-NLS-1$
	/** Club close constant */
	public static final String CLUB_CLOSE_1 = "\";\r\n"; //$NON-NLS-1$
	
	/** Club number */
	private int clubNumber = 0;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// No Action to do
	}

	@Override
	public void dispose() {
		// No Action to do
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		InputDialog dialog = new InputDialog(new Shell(), Messages.NewExampleProjectForScenarios_DialogTitle,
				Messages.NewExampleProjectForScenarios_DialogText, 
				Messages.NewExampleProjectForScenarios_DialogPredefinedValue, null); 
		int status = dialog.open();

		if (status == Window.OK) {
			IProgressMonitor progressMonitor = new NullProgressMonitor();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(dialog.getValue());
			try {
				project.create(progressMonitor);
				project.open(progressMonitor);

				createClub(project, "receiver", progressMonitor); //$NON-NLS-1$
				createClub(project, "visitor", progressMonitor); //$NON-NLS-1$

				IFolder folder = project.getFolder("scenario"); //$NON-NLS-1$
				folder.create(true, false, progressMonitor);

				createTemplateGameFile(folder, progressMonitor);

			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}

		return null;
	}

	/**
	 * Create a template of a game file.
	 * 
	 * @param folder folder reference 
	 * @param progressMonitor progress monitor
	 */
	private void createTemplateGameFile(IFolder folder, IProgressMonitor progressMonitor) {
		IFile templateFile = folder.getFile("template.game"); //$NON-NLS-1$
		try {

			StringBuilder strBuf = new StringBuilder("/* start of game description */\r\n"); //$NON-NLS-1$
			strBuf.append("game \"template\" {\r\n");//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("  /* description of the game */\r\n");//$NON-NLS-1$
			strBuf.append("  header {\r\n");//$NON-NLS-1$
			strBuf.append("    tournament = \"scenario\";\r\n");//$NON-NLS-1$
			strBuf.append("    stadium = \"anywhere\";\r\n");//$NON-NLS-1$
			strBuf.append("    place = \"Place\";\r\n");//$NON-NLS-1$
			strBuf.append("    date = \"01/01/2018\";\r\n");//$NON-NLS-1$
			strBuf.append("    startTime = \"11:00\";\r\n");//$NON-NLS-1$
			strBuf.append("    endTime = \"12:00\";\r\n");//$NON-NLS-1$
			strBuf.append("    duration = \"01::00\";\r\n");//$NON-NLS-1$
			strBuf.append("    type = baseball;\r\n");//$NON-NLS-1$
			strBuf.append("    category = \"Senior\";\r\n");//$NON-NLS-1$
			strBuf.append("    scorekeepers = \"ScoreKeeper_receiver\";\r\n");//$NON-NLS-1$
			strBuf.append("    umpires = \"Umpire_visitor\";\r\n");//$NON-NLS-1$
			strBuf.append("}\r\n");//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("  /* Roster of the visitor team */\r\n");//$NON-NLS-1$
			strBuf.append("    roster visitor \"receiver\" {\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 1\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 2\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 3\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 4\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 5\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 6\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 7\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 8\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 9\"\r\n");//$NON-NLS-1$
			strBuf.append("     }\r\n");//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("  /* Roster of the hometeam team */\r\n");//$NON-NLS-1$
			strBuf.append("    roster hometeam \"visitor\" {\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 1\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 2\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 3\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 4\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 5\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 6\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 7\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 8\",\r\n");//$NON-NLS-1$
			strBuf.append("       player \"Player 9\"\r\n");//$NON-NLS-1$
			strBuf.append("     }\r\n");//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("        /* Game description template */\r\n");//$NON-NLS-1$
			strBuf.append("        gameEntry {\r\n");//$NON-NLS-1$
			strBuf.append("          \r\n");//$NON-NLS-1$
			strBuf.append("          /* Lineup description for the visitor */\r\n");//$NON-NLS-1$
			strBuf.append("          lineup visitor {\r\n");//$NON-NLS-1$
			strBuf.append("            /* 01 */  name= \"Player 1\" defensivePosition = 1 shirtNumber = 01;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 02 */  name= \"Player 2\" defensivePosition = 2 shirtNumber = 02;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 03 */  name= \"Player 3\" defensivePosition = 3 shirtNumber = 03;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 04 */  name= \"Player 4\" defensivePosition = 4 shirtNumber = 04;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 05 */  name= \"Player 5\" defensivePosition = 5 shirtNumber = 05;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 06 */  name= \"Player 6\" defensivePosition = 6 shirtNumber = 06;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 07 */  name= \"Player 7\" defensivePosition = 7 shirtNumber = 07;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 08 */  name= \"Player 8\" defensivePosition = 8 shirtNumber = 08;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 09 */  name= \"Player 9\" defensivePosition = 9 shirtNumber = 09;\r\n");//$NON-NLS-1$
			strBuf.append(GAME_CLOSE_ACCOLADE_1);
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("          /* Lineup description for the hometeam */\r\n");//$NON-NLS-1$
			strBuf.append("          lineup hometeam {\r\n");//$NON-NLS-1$
			strBuf.append("            /* 01 */  name= \"Player 1\" defensivePosition = 1 shirtNumber = 01;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 02 */  name= \"Player 2\" defensivePosition = 2 shirtNumber = 02;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 03 */  name= \"Player 3\" defensivePosition = 3 shirtNumber = 03;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 04 */  name= \"Player 4\" defensivePosition = 4 shirtNumber = 04;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 05 */  name= \"Player 5\" defensivePosition = 5 shirtNumber = 05;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 06 */  name= \"Player 6\" defensivePosition = 6 shirtNumber = 06;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 07 */  name= \"Player 7\" defensivePosition = 7 shirtNumber = 07;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 08 */  name= \"Player 8\" defensivePosition = 8 shirtNumber = 08;\r\n");//$NON-NLS-1$
			strBuf.append("            /* 09 */  name= \"Player 9\" defensivePosition = 9 shirtNumber = 09;\r\n");//$NON-NLS-1$
			strBuf.append(GAME_CLOSE_ACCOLADE_1);//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("\r\n");//$NON-NLS-1$
			strBuf.append("          /* Inning 1 : visitor */\r\n");//$NON-NLS-1$
			strBuf.append("          inning visitor number 1 {\r\n");//$NON-NLS-1$
			strBuf.append(GAME_CLOSE_ACCOLADE_1);
			strBuf.append("        }\r\n");//$NON-NLS-1$
			strBuf.append("      }\r\n");//$NON-NLS-1$

			templateFile.create(new ByteArrayInputStream(strBuf.toString().getBytes()), true, progressMonitor);
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

	}

	/**
	 * Create a club
	 * 
	 * @param project reference on the project
	 * @param teamName Name of the team
	 * @param progressMonitor progress monitor
	 */
	private void createClub(IProject project, String teamName, IProgressMonitor progressMonitor) {
		StringBuilder buf = new StringBuilder("club \"" + teamName + "\" {\r\n" + "\r\n" + "  city = \"" + teamName //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ CLUB_CLOSE_1 + "\r\n" + "  members {\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
		int i = 0;
		for (i = 1; i < 13; i++) {
			buf.append("   member name = \"Player " + i + CLUB_LICNESE_NUMBER + clubNumber + "000" + i + CLUB_CLOSE_1); //$NON-NLS-1$ //$NON-NLS-2$
		}
		buf.append("   member name = \"ScoreKeeper_" + teamName + CLUB_LICNESE_NUMBER + clubNumber + "00" + (i + 1) //$NON-NLS-1$ //$NON-NLS-2$
				+ CLUB_CLOSE_1);
		buf.append("   member name = \"Umpire_" + teamName + CLUB_LICNESE_NUMBER + clubNumber + "00" + (i + 2) //$NON-NLS-1$ //$NON-NLS-2$
				+ CLUB_CLOSE_1);
		buf.append("  }\r\n" + "\r\n"); //$NON-NLS-1$ //$NON-NLS-2$

		buf.append("  team \"scenario\" {\r\n"); //$NON-NLS-1$

		for (i = 1; i < 13; i++) {
			buf.append("player name = \"Player " + i + CLUB_CLOSE_1); //$NON-NLS-1$
		}
		buf.append("  }\r\n"); //$NON-NLS-1$

		buf.append("\r\n  officials {\r\n"); //$NON-NLS-1$
		buf.append("    scoreKeeper name = \"ScoreKeeper_" + teamName + CLUB_CLOSE_1); //$NON-NLS-1$
		buf.append("    umpire name = \"Umpire_" + teamName + CLUB_CLOSE_1); //$NON-NLS-1$
		buf.append("  }\r\n\r\n}"); //$NON-NLS-1$

		IFile clubFile = project.getFile(teamName + ".club"); //$NON-NLS-1$
		if (!clubFile.exists()) {
			try {
				clubFile.create(new ByteArrayInputStream(buf.toString().getBytes()), true, progressMonitor);

			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		clubNumber++;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// No Action to do
	}

}
