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
package org.bpy.score.graphics;

import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractEngine;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.util.EngineConstants;

/**
 * Engine class for drawing a score sheet.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreViewEngine extends AbstractEngine {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreViewEngine.class.getSimpleName());
	
	/** Reference to the statistic engine */
	private StatisticEngine statisticEngine;

	/** graphical context */
	private Graphics2D g2;
	
	/** memorize the current team */
	private String currentTeam;

	/**
	 * Set the statistic engine. 
	 * 
	 * @param statisticEngine reference on the statistic engine 
	 */
	public void setStatisticEngine(StatisticEngine statisticEngine) {
		this.statisticEngine = statisticEngine;
	}

	/**
	 * Set the graphical context.
	 * 
	 * @param g2 Graphical context
	 */
	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}

	/**
	 * Set the current team.
	 * 
	 * @param currentTeam current team (hometeam or visitor)
	 */
	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}

	/**
	 * Run the engine.
	 */
	public void run() {
		ScoringSheetGraphicalManager action = (ScoringSheetGraphicalManager) getActionsManager();

		action.createDocument(game, statisticEngine);

		try {

			if (currentTeam.equals(EngineConstants.HOMETEAM)) {

				if (game.getActions() != null && game.getActions().getLineup() != null) {
					action.setupLineUp(game.getActions().getLineup());
					action.fillHometeamSheet(g2, game, statisticEngine);
					manageActions(game.getActions().getHalfInnings());
				} else {
					action.fillHometeamSheet(g2, game, statisticEngine);
				}

			} else {
				if (game.getActions() != null && game.getActions().getLineup() != null) {
					action.setupLineUp(game.getActions().getLineup());
					action.fillVisitorSheet(g2, game, statisticEngine);
					manageActions(game.getActions().getHalfInnings());
				} else {
					action.fillVisitorSheet(g2, game, statisticEngine);
				}

			}

		} catch (OccupedbaseException|NullPointerException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}

		action.closeDocument();
	}
}
