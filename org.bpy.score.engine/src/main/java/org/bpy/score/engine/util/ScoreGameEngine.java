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
package org.bpy.score.engine.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractEngine;
import org.bpy.score.game.game.Game;

/**
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreGameEngine extends AbstractEngine {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreGameEngine.class.getSimpleName());
	
	/** reference on the manager */
	private ScoreGameManager scoreGameManager;

	/**
	 * Execute the parsing of the game
	 * 
	 * @param game reference on the game
	 */
	public void runEngine(Game game) {
		scoreGameManager = new ScoreGameManager();

		setActionsManager(scoreGameManager);
		try {
			scoreGameManager.setupLineUp(game.getActions().getLineup());

			manageActions(game.getActions().getHalfInnings());

		} catch (NullPointerException|OccupedbaseException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

	/**
	 * return the manager.
	 * 
	 * @return Reference on the manager.
	 */
	public ScoreGameManager getScoreGameManager() {
		return scoreGameManager;
	}

	/**
	 * Return the current batter
	 * 
	 * @return ame of the current batter
	 */
	public String getCurrentBatter() {
		return getActionsManager().getRunnerPositionManager().getPlayerAtPosition(0).getPlayerDescription().getName();
	}

	/**
	 * Return an arrays which gives the runners on bases.
	 * 
	 * @return arrays which gives the runners on bases.
	 */
	public String[] getCurrentRunners() {
		/* We are searching for batters which become runners , and advance runner */
		String[] bases = new String[5];

		for (int i = 1; i < 4; i++) {
			if (getActionsManager().getRunnerPositionManager().getPlayerAtPosition(i) != null) {
				bases[i] = getActionsManager().getRunnerPositionManager().getPlayerAtPosition(i).getPlayerDescription()
						.getName();
			} else {
				bases[i] = null;
			}
		}
		bases[0] = null;
		bases[4] = null;
		return bases;
	}
}
