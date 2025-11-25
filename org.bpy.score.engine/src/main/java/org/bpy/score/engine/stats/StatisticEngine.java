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
package org.bpy.score.engine.stats;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractEngine;

/**
 * This class is the engine which analyze the game file for extract an calculate
 * the game statistics.
 * 
 * @author Patrick BRIAND
 */
public class StatisticEngine extends AbstractEngine {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(StatisticEngine.class.getSimpleName());

	/** Statistic manager for parsing the game */
	private StatisticManager statisticManager;

	/**
	 * Constructor of the class.
	 */
	public StatisticEngine() {
		// No thing to do
	}

	/**
	 * Get the statistic manager.
	 * 
	 * @return reference on the statistic manager
	 */
	public StatisticManager getStatisticManager() {
		return statisticManager;
	}

	/**
	 * Parse the game file
	 * 
	 */
	public void run() {
		statisticManager = new StatisticManager();
		setActionsManager(statisticManager);

		if ((game != null) && (game.getActions() != null) && (game.getForfeitGame() == null)) {

			try {
				statisticManager.setupLineUp(game.getActions().getLineup());
				statisticManager.initStattistic(game.getName(), game.getHometeam().getName(), game.getVisitor().getName());

				manageActions(game.getActions().getHalfInnings());
				manageGameResume(game.getActions().getGameResume());

			} catch (OccupedbaseException| NullPointerException e) {
				logger.log(Level.SEVERE, e.getLocalizedMessage());
			}

		} else if (game != null && game.getForfeitGame() != null) {
			statisticManager.setForfeitStattistic(game.getName(), game.getHometeam().getName(),
					game.getVisitor().getName(), game.getForfeitGame().getTeam());
		}
	}
}
