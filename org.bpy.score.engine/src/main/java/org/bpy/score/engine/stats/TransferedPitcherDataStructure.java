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

import java.util.ArrayList;
import java.util.List;

import org.bpy.score.engine.stats.emf.statistic.LineupEntry;

/**
 * Data class which is used for store data in the purpose to determine the
 * transfered points
 * 
 * @author Patrick BRIAND
 *
 */
public class TransferedPitcherDataStructure {

	/** List of players */
	private List<LineupEntry> players;

	/** Transfered pitcher */
	private LineupEntry transferedPitcher;
	
	/** Real pitcher */
	private LineupEntry realPitcher;

	/**
	 * Constructor of the class.
	 * Initialize fields
	 */
	public TransferedPitcherDataStructure() {
		players = new ArrayList<>();
	}

	/**
	 * Get the list players.
	 * 
	 * @return the list of player
	 */
	public List<LineupEntry> getPlayers() {
		return players;
	}

	/**
	 * Add a player to the list of players.
	 * 
	 * @param player player add to the list of player 
	 */
	public void addPlayers(LineupEntry player) {
		this.players.add(player);
	}

	/**
	 * Return the transfered pitcher
	 * 
	 * @return transfered pitcher
	 */
	public LineupEntry getTransferedPitcher() {
		return transferedPitcher;
	}

	/**
	 * Set the transfered pitcher.
	 *  
	 * @param transferedPitcher reference to a player
	 */
	public void setTransferedPitcher(LineupEntry transferedPitcher) {
		this.transferedPitcher = transferedPitcher;
	}

	/**
	 * Return the pitcher responsible of the point.
	 * 
	 * @return pitcher responsible of the point.
	 */
	public LineupEntry getRealPitcher() {
		return realPitcher;
	}

	/**
	 * Set the real pitcher.
	 * 
	 * @param realPitcher reference to a player
	 */
	public void setRealPitcher(LineupEntry realPitcher) {
		this.realPitcher = realPitcher;
	}
}
