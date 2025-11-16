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
import java.util.ArrayList;
import java.util.Collection;

/**
 * Manager of square in the scoring sheet.
 * 
 * @author Patrick BRIAND
 *
 */
public class PlayerSquareManager {

	/** During the inning constant */
	public static final int DURING_INNING = 0;
	/** End the inning constant */
	public static final int END_OF_INNING = 1;

	/** Starting line position */
	private int startingLinePosition;
	/** Current position */
	private Point currentPosition;

	/**
	 * Collection of change row listener.
	 */
	private final Collection<ChangeRowListener> listeners = new ArrayList<>();

	/**
	 * Constructor of the class.
	 * Initialize some fields
	 */
	public PlayerSquareManager() {
		startingLinePosition = 1;
		currentPosition = new Point(1, 1);
	}

	/** 
	 * Get the starting line position.
	 * 
	 * @return starting line position.
	 */
	public int getStartingLinePosition() {
		return startingLinePosition;
	}

	/**
	 * Get the current square position. 
	 * 
	 * @return current square position.
	 */
	public Point getCurrentPosition() {
		return currentPosition;
	}

	/** 
	 * Get the current column position. 
	 * 
	 * @param columnNumber current column position. 
	 */
	public void setColumnPosition(int columnNumber) {
		currentPosition.y = columnNumber;
	}

	/**
	 * Set batter square position. 
	 * 
	 * @param batterPosition batter square position.
	 */
	public void setBatterPosition(int batterPosition) {
		currentPosition.x = batterPosition;
		startingLinePosition = batterPosition;
	}

	/**
	 * Set next batter square position. 
	 */
	public void setNextBatterPosition() {
		currentPosition.x++;
		if (currentPosition.x == 10) {
			currentPosition.x = 1;
		}

		if (currentPosition.x == startingLinePosition) {
			currentPosition.y++;
			fireChangerRow(currentPosition.y, DURING_INNING);
		}
	}

	/**
	 * Signal the end of inning.
	 * Compute the next square position to use 
	 * 
	 */
	public void endOfInning() {

		if (currentPosition.x != startingLinePosition) {
			currentPosition.y++;
			fireChangerRow(currentPosition.y, END_OF_INNING);
		}

		startingLinePosition = currentPosition.x;
	}

	/**
	 * Add a listener to the change row event.
	 * 
	 * @param changeRowListener Change row listener
	 */
	public void addChangeRowListener(ChangeRowListener changeRowListener) {
		listeners.add(changeRowListener);
	}

	/**
	 * Signal a row change.
	 * 
	 * @param y column number
	 * @param motif cause
	 */
	private void fireChangerRow(int y, int motif) {
		for (ChangeRowListener listener : listeners) {
			listener.changeRowListener(y, motif);
		}

	}
}
