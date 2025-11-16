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
package org.bpy.score.game.validation;

/**
 * Make a simulation of the position of the runners. 
 * 
 * @author Patrick BRIAND
 *
 */
public class FieldSimulator {
	
	/** Memorize the state of the base (Free or Occupied) */
	private boolean[] bases = new boolean[] { false, false, false, false };

	/**
	 * Constructor of the class.
	 * All bases are free
	 */
	public FieldSimulator() {
		bases = new boolean[] { false, false, false, false };
	}

	/**
	 * Set a player to a position.
	 * 
	 * @param to new position
	 * @return <b>true</b> the move is done, <b>false</b> the move isn't possible
	 */
	public boolean moveTo(int to) {
		boolean success = true;

		if (to < 1 || to > 4) {
			success = false;

		} else {

			if (to < 4) {
				if (!bases[to]) {
					bases[to] = true;
				} else {
					success = false;
				}
			}
		}
		return success;
	}

	/**
	 * Move  a player from a position to an another position.
	 * 
	 * @param from Starting position
	 * @param to next position
	 * @return <b>true</b> the move is done, <b>false</b> the move isn't possible
	 */
	public boolean moveTo(int from, int to) {
		boolean success = true;

		if (from > to || from < 0 || from > 3 || to < 1 || to > 4) {
			success = false;

		} else {
			if (from != 0) {
				bases[from] = false;
			}
			if (to < 4) {
				if (!bases[to]) {
					bases[to] = true;
				} else {
					success = false;
				}
			}
		}
		return success;
	}

	/**
	 * Empty a position
	 * 
	 * @param i position to empty
	 */
	public void out(int i) {
		bases[i] = false;
	}

	/**
	 * Check if a base is free
	 * 
	 * @param i base number to test
	 * @return <b>true</b> the base is free, <b>false</b> otherwise
	 */
	public boolean isBaseFree(int i) {
		return bases[i];
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < 4; i++) {
			str.append("base " + i + ":"); //$NON-NLS-1$ //$NON-NLS-2$
			if (bases[i]) {
				str.append("occupied - "); //$NON-NLS-1$
			} else {
				str.append("free    - "); //$NON-NLS-1$
			}
		}
		return str.toString();
	}
}
