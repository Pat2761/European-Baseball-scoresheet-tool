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

import java.awt.Point;

/**
 * Data class which describe a line to print.
 * 
 * @author Patrick BRIAND
 *
 */
public class TeleprinterLineDescripter {

	/** Graphical position for start tele print */
	private Point startingPositions;
	/** Number max of character to print. */
	private int nbCharsMax;

	/**
	 * Constructor of the class.
	 * Initialize fields
	 * 
	 * @param startingPositions Graphical position for start tele print
	 * @param nbCharsMax  Number max of character to print.
	 */
	public TeleprinterLineDescripter(Point startingPositions, int nbCharsMax) {
		this.startingPositions = startingPositions;
		this.nbCharsMax = nbCharsMax;
	}

	/**
	 * Get graphical position for start tele print
	 * 
	 * @return graphical position for start tele print
	 */
	public Point getStartingPositions() {
		return startingPositions;
	}

	/**
	 * Set graphical position for start tele print
	 * 
	 * @param startingPositions graphical position for start tele print
	 */
	public void setStartingPositions(Point startingPositions) {
		this.startingPositions = startingPositions;
	}

	/**
	 * get number max of character to print
	 * 
	 * @return number max of character to print
	 */
	public int getNbCharsMax() {
		return nbCharsMax;
	}

	/**
	 * Set number max of character to print
	 * 
	 * @param nbCharsMax number max of character to print
	 */
	public void setNbCharsMax(int nbCharsMax) {
		this.nbCharsMax = nbCharsMax;
	}
	
}
