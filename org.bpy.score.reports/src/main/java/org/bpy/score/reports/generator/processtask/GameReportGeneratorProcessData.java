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

import java.util.List;
import java.util.Map;

import org.bpy.score.club.club.Club;
import org.bpy.score.engine.stats.emf.GlobalStatisticContainer;
import org.bpy.score.game.game.Game;
import org.bpy.score.reports.generator.GameReportContainer;

/**
 * Data container for the process of generation of the XML game description
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportGeneratorProcessData {

	/** reference  to the game report container */
	private GameReportContainer gameReportContainer;
	/** Reference to the global statistic container */
	private GlobalStatisticContainer globalStatisticContainer;
	/** Generation path */
	private String path;
    /** List of clubs */
	private List<Club> clubs;
	/** Reference on the EMF description of the game*/
	private Game game;
	/** Generation options */
	private Map<String, Object> options;
	
	/**
	 * Constructor of the class
	 * 
	 */
	public GameReportGeneratorProcessData() {
		// nothing to do
	}
	
	/** 
	 * get the report container.
	 * 
	 * @return reference on the report container
	 */
	public GameReportContainer getGameReportContainer() {
		return gameReportContainer;
	}
	
	/**
	 * Set the report container.
	 * 
	 * @param gameReportContainer reference on the report container
	 */
	public void setGameReportContainer(GameReportContainer gameReportContainer) {
		this.gameReportContainer = gameReportContainer;
	}
	
	/**
	 * Get the global statistic container.
	 * 
	 * @return reference on the global statistic container
	 */
	public GlobalStatisticContainer getGlobalStatisticContainer() {
		return globalStatisticContainer;
	}
	
	/**
	 * Set the global statistic container.
	 * 
	 * @param globalStatisticContainer  reference on the global statistic container
	 */
	public void setGlobalStatisticContainer(GlobalStatisticContainer globalStatisticContainer) {
		this.globalStatisticContainer = globalStatisticContainer;
	}
	
	/**
	 * Get the file generation path.
	 * 
	 * @return file generation path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Set the file generation path.
	 * 
	 * @param path file generation path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Get the list of EMF container which describes the clubs. 
	 * 
	 * @return list of EMF container which describes the clubs
	 */
	public List<Club> getClubs() {
		return clubs;
	}
	
	/**
	 * Set the list of EMF container which describes the clubs. 
	 * 
	 * @param clubs list of EMF container which describes the clubs
	 */
	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	/**
	 * Get the reference on the EMF container which describe the game.
	 * 
	 * @return reference on the EMF container which describes the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Set the reference on the EMF container which describe the game.
	 * 
	 * @param game reference on the EMF container which describes the game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Set the generation options.
	 * 
	 * @param options generation options.
	 */
	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
	
	/**
	 * get the generation options.
	 * 
	 * @return generation options.
	 */
	public Map<String, Object> getOptions() {
		return options;
	}
}
