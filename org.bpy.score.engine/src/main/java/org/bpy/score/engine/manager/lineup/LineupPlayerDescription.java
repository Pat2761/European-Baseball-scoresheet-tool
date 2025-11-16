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
package org.bpy.score.engine.manager.lineup;

/**
 * Data class for describe a player
 * 
 * @author Patrick BRIAND
 *
 */
public class LineupPlayerDescription {

	/** Name of the player */
	private String name;
	/** Shirt number of the player */
	private int shirtNumber;
	/** state of the player */
	private boolean isActif;

	/**
	 * Constructor of the class
	 */
	public LineupPlayerDescription() {
		// Nothing to do
	}

	/**
	 * Get the name of player.
	 * 
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of player
	 * 
	 * @param name name of player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the shirt number of player.
	 * 
	 * @return shirt number of the player
	 */
	public int getShirtNumber() {
		return shirtNumber;
	}

	/**
	 * Set the shirt number of player
	 * 
	 * @param shirtNumber shirt number of player
	 */
	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	/**
	 * Get the state of player.
	 * 
	 * @return <b>true</b> is active, <b>false</b> otherwise
	 */
	public boolean isActif() {
		return isActif;
	}

	/**
	 * Set state of the player
	 * 
	 * @param isActif state of the player
	 */
	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

}