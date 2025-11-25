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
package org.bpy.score.reports.pdf;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractEngine;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.internationalization.reports.Messages;
import org.eclipse.emf.common.util.EList;

/**
 * This class is used for invoke Graphical sheet manager for a PDF File
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreSheetEngine extends AbstractEngine {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreSheetEngine.class.getSimpleName()); 
	
	/** Where to create the document */ 
	private String path;
	/** reference on the statistic engine */
	private StatisticEngine statisticEngine;
	/** reference on the Score sheet manager */
	private ScoringSheetManager scoringSheetManager;

	/** 
	 * Define the path for the PDF generation. 
	 * 
	 * @param path Full path for the generation
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Set the reference on the statistic engine
	 * 
	 * @param statisticEngine reference on the statistic engine
	 */
	public void setStatisticEngine(StatisticEngine statisticEngine) {
		this.statisticEngine = statisticEngine;
	}

	/**
	 * Create an empty score sheet file
	 */
	public void emptyFile() {
		scoringSheetManager = (ScoringSheetManager) getActionsManager();

		scoringSheetManager.createDocument(null, System.getProperty("user.dir")); //$NON-NLS-1$
		scoringSheetManager.fillVisitorSheet(null, null);
		scoringSheetManager.releaseGraphicalContext();

		scoringSheetManager.createNewPage();

		scoringSheetManager.fillHometeamSheet(null, null);
		scoringSheetManager.closeDocument();
		scoringSheetManager.releaseGraphicalContext();
		logger.log(Level.FINE,"File are generated"); //$NON-NLS-1$
	}

	/**
	 * Parse the game file.  
	 */
	public void run() {
		scoringSheetManager = (ScoringSheetManager) getActionsManager();

		scoringSheetManager.createDocument(game, path);

		if (game.getForfeitGame() == null) {
			try {

				scoringSheetManager.setupLineUp(game.getActions().getLineup());
				scoringSheetManager.fillVisitorSheet(game, statisticEngine);
				manageActions(game.getActions().getHalfInnings());
				scoringSheetManager.releaseGraphicalContext();

				scoringSheetManager.createNewPage();

				scoringSheetManager.setupLineUp(game.getActions().getLineup());
				scoringSheetManager.fillHometeamSheet(game, statisticEngine);
				manageActions(game.getActions().getHalfInnings());
				scoringSheetManager.releaseGraphicalContext();

			} catch (OccupedbaseException e) {
				logger.log(Level.SEVERE,e.getLocalizedMessage());
			}
		} else {

			scoringSheetManager.fillSpecialVisitorSheet(game, Messages.ScoreSheetEngine_ForfeitGame);
			scoringSheetManager.createNewPage();
			scoringSheetManager.fillSpecialHometeamSheet(game, Messages.ScoreSheetEngine_ForfeitGame);

		}

		scoringSheetManager.closeDocument();
	}

	@Override
	protected void manageActions(EList<HalfInning> halfInnings) throws OccupedbaseException {
		if (EngineConstants.pdfMire) {
			scoringSheetManager.fillMire();
		} else {
			super.manageActions(halfInnings);
		}
	}

}
