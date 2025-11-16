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
package org.bpy.score.rcp.containers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.game.game.Game;

/**
 * Data class which store information for seaaching 
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameContainer implements Comparable<SearchGameContainer> {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(SearchGameContainer.class.getSimpleName());
	
	/** Data time of the game */
	private String dateTime;
	/** Code of the game */
	private String code;
	/** Place of the game */
	private String place;
	/** Description of the game */
	private String description;
	/** Reference to the game parsing result */
	private Game game;

	/** Date format to use */ 
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm"); //$NON-NLS-1$

	/**
	 * Constructor of the class.
	 */
	public SearchGameContainer() {
		// Nothing to do
	}
	
	/**
	 * Get date and time
	 * 
	 * @return date and time value
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Set date and time
	 * 
	 * @param dateTime date and time value
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Get code of the game
	 * 
	 * @return code of the game
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set code of the game
	 * 
	 * @param code code of the game
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get place of the game
	 * 
	 * @return place of the game
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Set place of the game
	 * 
	 * @param place place of the game
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Get description of the game 
	 * 
	 * @return Description of the game
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description of the game 
	 * 
	 * @param description Description of the game
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get reference to the game parsing result
	 * 
	 * @return Reference to the game parsing result
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Set reference to the game parsing result
	 * 
	 * @param game Reference to the game parsing result
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public int compareTo(SearchGameContainer target) {
		try {
			Date currentDate = dateFormat.parse(this.dateTime) ;
			Date targetDate = dateFormat.parse(target.getDateTime());
			return currentDate.compareTo(targetDate);
		} catch (ParseException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		
		return 0;
	}

}
