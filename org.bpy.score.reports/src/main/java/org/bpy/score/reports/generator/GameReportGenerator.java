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
package org.bpy.score.reports.generator;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.club.Club;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.engine.stats.emf.GlobalStatisticContainer;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.ui.internal.GameActivator;
import org.bpy.score.internationalization.reports.Messages;
import org.bpy.score.reports.generator.processtask.GameReportGeneratorProcess;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import com.google.inject.Injector;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * 
 * Allow to create a report on a match.
 * 
 * @author BRIAND Patrick 
 * 
 */
public class GameReportGenerator extends AbstractReportGenerator {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportGenerator.class.getCanonicalName());

	/** Segment separator */
	public static final String SEGMENT_SEPARATOR = "/"; //$NON-NLS-1$
	
	/** Standard configuration flag key */
	public static final String STANDARD_PREDEFINED_FLAG = "standardConfigurationFlag"; //$NON-NLS-1$
	/** CSS file path key */
	public static final String CSS_FILE_PATH = "cssFilePath"; //$NON-NLS-1$
	/** XSLT File path key */
	public static final String XSLT_FILE_PATH = "xsltFilePath"; //$NON-NLS-1$
	/** BANNER File path key */
	public static final String BANNER_FILE_PATH = "bannerFilePath"; //$NON-NLS-1$
	
	/** Display regular expression key */
	public static final String DISPLAY_REGULAR_EXPRESSION_KEY = "display_regular_expression_key"; //$NON-NLS-1$
	/** Selection regular expression key */
	public static final String SELECTION_REGULAR_EXPRESSION_KEY = "selection_regular_expression_key"; //$NON-NLS-1$
	/** Output folder path key */
	public static final String OUTPUT_FOLDER_KEY = "output_folder_key"; //$NON-NLS-1$

	/** Generate report as HTML file */
	public static final String HTML_GENERATION = "generate_html_report";
	
	/** Injector on the Game parser */
	private static final Injector injector = GameActivator.getInstance().getInjector("org.bpy.score.game.Game"); //$NON-NLS-1$


	/**
	 * Constructor of the class.
	 */
	public GameReportGenerator() {
		super();
	}

	/**
	 * Main entry point for generate an XML file which contains the report description of the game.
	 * 
	 * @param selectedGames List of report to generate
	 * @param options options for the generation of the report (or HTML file)
	 */
	public void generateReport(List<IFile> selectedGames, Map<String, Object> options) {
		
		GlobalStatisticContainer globalStatisticContainer = new GlobalStatisticContainer();
		GameReportContainer gameReportContainer = new GameReportContainer();
		
		ClubDataParser clubDataParser = new ClubDataParser();
		clubDataParser.parseData((IFolder)selectedGames.get(0).getParent().getParent());
		List<Club> clubs = clubDataParser.getClubs();

		String outputFolderPath = getGameReportPath(options, selectedGames);
		
		if (outputFolderPath != null && createFolder(outputFolderPath + "/site" )) {  //$NON-NLS-1$
			
			HashMap<Date,List<Game>> sortedByDateGame = sortByDate(selectedGames);

			GameReportGeneratorProcess generatorProcess = new GameReportGeneratorProcess(Messages.GameReportGenerator_TaskMessage, ""); //$NON-NLS-1$
			generatorProcess.setGameReportContainer(gameReportContainer);
			generatorProcess.setGlobalStatisticContainer(globalStatisticContainer);
			generatorProcess.setPath(outputFolderPath + "/site"); //$NON-NLS-1$
			generatorProcess.setClubs(clubs);
			generatorProcess.setData(sortedByDateGame);
			generatorProcess.setOptions(options);
			generatorProcess.executeTasks();

		} else {
			MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_ERROR | SWT.ABORT);
			messageBox.setText(Messages.GameReportGenerator_JobReportGeneration);
			messageBox.setMessage(Messages.GameReportGenerator_ErrorReportGeneration);
			messageBox.open();
		}
	}

	private String getGameReportPath(Map<String, Object> options, List<IFile> selectedGames) {
		
		String outputFolderPath = (String)options.get(GameReportGenerator.OUTPUT_FOLDER_KEY);
		try {
			outputFolderPath = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(outputFolderPath);
			return outputFolderPath;
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return null;
	}

	/**
	 * Get a list of game sorted by date
	 * 
	 * @param selectedGames A list of selected game
	 * @return A list of sorted game by date
	 */
	private HashMap<Date, List<Game>> sortByDate(List<IFile> selectedGames) {
		HashMap<Date,List<Game>> sortedByDateGame = new HashMap<>();
		
		for (IFile selectedGame : selectedGames) {
			
			XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(selectedGame.getProject());
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			Resource resource = resourceSet.getResource(URI.createURI(selectedGame.getLocationURI().toString()),true);
			Game game = (Game) resource.getContents().get(0);

			String dateTime = game.getDescription().getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			Date gameDate = null;
			try {
				gameDate = dateFormat.parse(dateTime);
			} catch (ParseException e) {
				gameDate = new Date(System.currentTimeMillis());
			}
			
			List<Game> games = sortedByDateGame.get(gameDate);
			if (games == null) {
				games = new ArrayList<>();
				sortedByDateGame.put(gameDate, games);
			}
			games.add(game);
		}

		return sortedByDateGame;
	}

	/**
	 * Create folders which contains pdf and jpg files
	 *  
	 * @param path where to create folders
	 * @return <b>true</b> folders are created, <b>false</b> otherwise
	 */
	private boolean createFolder(String path) {
		
		File siteFolder = new File(path);
		if (!siteFolder.exists()) {
			siteFolder.mkdir();
		}
		
		File pdfFolder = new File(path + "/pdf"); //$NON-NLS-1$
		File imgFolder = new File(path + "/img"); //$NON-NLS-1$

		if (!pdfFolder.exists()) {
			pdfFolder.mkdir();
		} else {
			if (pdfFolder.isFile()) {
				return false;
			} else {
				pdfFolder.delete();
				pdfFolder.mkdir();
			}
		}

		if (!imgFolder.exists()) {
			imgFolder.mkdir();
		} else {
			if (imgFolder.isFile()) {
				return false;
			} else {
				imgFolder.delete();
				imgFolder.mkdir();
			}
		}
		return true;
	}
}
