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
package org.bpy.score.reports.generator.playbyplay;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractEngine;
import org.bpy.score.game.game.Game;

/**
 * Allows to create a report on a match.
 * 
 * @author Patrick BRIAND
 * 
 */
public class PlayByPlayEngine extends AbstractEngine {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(PlayByPlayEngine.class.getSimpleName());

	/** 
	 * Entry point of the generation of the play by play
	 * 
	 * @param game reference on the EMF description of a game
	 */
	public void runEngine(Game game) {

		try {
			actionsManager.setupLineUp(game.getActions().getLineup());
			
			manageActions(game.getActions().getHalfInnings());

		} catch (NullPointerException|OccupedbaseException ex) {
			logger.log(Level.SEVERE,ex.getMessage());
		}
	}

	/** 
	 *  Get inning descriptions
	 * 
	 *  @return List of inning descriptions
	 */
	public List<PlayByPlayContainer> getActionDescription() {
		return ((PlayByPlayManager)getActionsManager()).getElements();
	}
}
