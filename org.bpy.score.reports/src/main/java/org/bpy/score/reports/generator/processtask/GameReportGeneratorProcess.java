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
package org.bpy.score.reports.generator.processtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.club.Club;
import org.bpy.score.engine.stats.emf.GlobalStatisticContainer;
import org.bpy.score.game.game.Game;
import org.bpy.score.graphics.ui.DataProcessContainer;
import org.bpy.score.graphics.ui.ProcessThread;
import org.bpy.score.internationalization.reports.Messages;
import org.bpy.score.reports.Activator;
import org.bpy.score.reports.generator.GameReportContainer;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.osgi.util.NLS;

/**
 * This class allow to process the game report generation for each game.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportGeneratorProcess extends ProcessThread {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportGeneratorProcess.class.getCanonicalName());

	/** reference  to the game report container */
	private GameReportContainer gameReportContainer;
	/** Reference to the global statistic container */
	private GlobalStatisticContainer globalStatisticContainer;
	/** Generation path */
	private String path;
    /** List of clubs */
	private List<Club> clubs;
	/** Collection of games sorted by date */
	private Map<Date, List<Game>> sortedByDateGame;
	/** generation options */
	private Map<String, Object> options;

	/** 
	 * Constructor of the class.
	 * 
	 * @param dialogBoxTitle Title of the progress dialog box
	 * @param firstMessage first message to display
	 */
	public GameReportGeneratorProcess(String dialogBoxTitle, String firstMessage) {
		super(dialogBoxTitle, firstMessage);
	}

	/** 
	 * Constructor of the class.
	 * Used for debug
	 * 
	 * @param dialogBoxTitle Title of the progress dialog box
	 * @param firstMessage first message to display
	 */
	public GameReportGeneratorProcess() {
		super();
	}

	/**
	 * Set the game report container
	 * 
	 * @param gameReportContainer game report container
	 */
	public void setGameReportContainer(GameReportContainer gameReportContainer) {
		this.gameReportContainer = gameReportContainer;
	}

	/**
	 * Define the global statistic manager. 
	 * 
	 * @param globalStatisticContainer global statistic manager
	 */
	public void setGlobalStatisticContainer(GlobalStatisticContainer globalStatisticContainer) {
		this.globalStatisticContainer = globalStatisticContainer;
	}

	/**
	 * Define the path of the report generation
	 * 
	 * @param path path of the report generation
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Define the list of clubs
	 * 
	 * @param clubs list of clubs
	 */
	public void setClubs( List<Club> clubs) {
		this.clubs = clubs;
	}

	/**
	 * Memorize options for game report generation.
	 * 
	 * @param options options for game report generation
	 */
	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}

	/**
	 * Define the list of game to manage sorted by date
	 * 
	 * @param sortedByDateGame list of game to manage sorted by date
	 */
	public void setData(Map<Date, List<Game>> sortedByDateGame) {
		this.sortedByDateGame = sortedByDateGame;
	}

	@Override
	public void initializeDataToProcess(Queue<DataProcessContainer> actionsStacks) {
		List<Date> sortedDates = new ArrayList<>(sortedByDateGame.keySet());
		Collections.sort(sortedDates);
		
		for (Date sortedDate : sortedDates) {
			List<Game> games = sortedByDateGame.get(sortedDate);
			for (Game game : games) {
				
				String message = NLS.bind(Messages.GameReportGeneratorProcess_GenerateInformation, new String[] {game.getName()}); 
				GameReportGeneratorProcessData data = new GameReportGeneratorProcessData();
				data.setClubs(clubs);
				data.setGameReportContainer(gameReportContainer);
				data.setGlobalStatisticContainer(globalStatisticContainer);
				data.setPath(path);
				data.setGame(game);
				data.setOptions(options);
				
				CreateXmlGameDescription container = new CreateXmlGameDescription(message, data);
				actionsStacks.offer(container);
			}
		}
		
		createCopyCssFileAction(actionsStacks);
		createCopyXslFileAction(actionsStacks);
		createCopyBannerFileAction(actionsStacks);
	}

	private void createCopyBannerFileAction(Queue<DataProcessContainer> actionsStacks) {
		CopyInputStreamToDestinationData data = new CopyInputStreamToDestinationData();
		data.setPath(path + "/banner.jpg"); //$NON-NLS-1$
		
		if (options.containsKey(GameReportGenerator.BANNER_FILE_PATH)) {
			try {
				String resourceFileName = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution((String)options.get(GameReportGenerator.BANNER_FILE_PATH));
				InputStream inputStream = new FileInputStream(new File(resourceFileName));
				data.setInputStream(inputStream);
			} catch (FileNotFoundException | CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
			
		} else {
			// import example resource
			InputStream inputStream = Activator.class.getResourceAsStream("banner.jpg"); //$NON-NLS-1$
			data.setInputStream(inputStream);
		}
		
		CopyInputStreamToDestination copyFileAction = new CopyInputStreamToDestination(Messages.GameReportGeneratorProcess_CopyBannerFileMessage, data);
		actionsStacks.offer(copyFileAction );
	}

	private void createCopyXslFileAction(Queue<DataProcessContainer> actionsStacks) {
		CopyInputStreamToDestinationData data = new CopyInputStreamToDestinationData();
		data.setPath(path + "/GameReport.xsl"); //$NON-NLS-1$
		
		if (options.containsKey(GameReportGenerator.XSLT_FILE_PATH)) {
			try {
				String resourceFileName = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution((String)options.get(GameReportGenerator.XSLT_FILE_PATH));
				InputStream inputStream = new FileInputStream(new File(resourceFileName));
				data.setInputStream(inputStream);
			} catch (FileNotFoundException | CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
			
		} else {
			// import example resource
			InputStream inputStream = Activator.class.getResourceAsStream("GameReport.xsl"); //$NON-NLS-1$
			data.setInputStream(inputStream);
		}
		
		CopyInputStreamToDestination copyFileAction = new CopyInputStreamToDestination(Messages.GameReportGeneratorProcess_CopyXSLTFileMessage, data);
		actionsStacks.offer(copyFileAction );
	}

	private void createCopyCssFileAction(Queue<DataProcessContainer> actionsStacks) {
		CopyInputStreamToDestinationData data = new CopyInputStreamToDestinationData();
		data.setPath(path + "/GameReport.css"); //$NON-NLS-1$
		
		if (options.containsKey(GameReportGenerator.CSS_FILE_PATH)) {
			try {
				String resourceFileName = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution((String)options.get(GameReportGenerator.CSS_FILE_PATH));
				InputStream inputStream = new FileInputStream(new File(resourceFileName));
				data.setInputStream(inputStream);
			} catch (FileNotFoundException | CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			} 
			
		} else {
			// import example resource
			InputStream inputStream = Activator.class.getResourceAsStream("GameReport.css"); //$NON-NLS-1$
			data.setInputStream(inputStream);
		}
		
		CopyInputStreamToDestination copyFileAction = new CopyInputStreamToDestination(Messages.GameReportGeneratorProcess_CopyCSSFileMessage, data);
		actionsStacks.offer(copyFileAction );
	}

	@Override
	public void executeElement(DataProcessContainer container) {
		container.executeTask();
	}

}
