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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.manager.IpCounter;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.MoveToData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.ReplacementData;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.StatisticFactory;
import org.bpy.score.game.game.LineUp;
import org.bpy.score.game.game.LineUpEntry;
import org.bpy.score.game.game.Replacement;

/**
 * Manage the team line-up during a game.
 * 
 * @author Patrick BRIAND
 *
 */
public class LineupManager {
	
	/**
	 * Logger of the class
	 */
	public static final Logger logger = Logger.getLogger(LineupManager.class.getSimpleName());

	/** Constant string for said that a pitcher keep its position */
	public static final String PITCHER_KEEP_ITS_POSITION = "pictherKeepItsPosition"; //$NON-NLS-1$
	
	/** Contains the list of players in a line-up */
	private List<LineupEntry> players;

	/**
	 * Contains the list of all players position.
	 * <Offesive position,List of player> 
	 */
	private HashMap<String, List<LineupEntry>> lineupEntries;

	/**  
	 * Contains the list of player which play at a defensive position
	 * <Defensive position, list of player>
	 * */
	private HashMap<String, LineupEntry> defensivePlayers;

	/**  
	 * Contains the list of player which play at an offensive position
	 * <Offensive position, list of player>
	 */
	private HashMap<String, LineupEntry> offensivePlayers;

	/** 
	 * Contains the list of position for each player
	 */
	private HashMap<LineupPlayerDescription, List<LineupEntry>> playersEntries;

	/** Contains the index of the defensive positions */
	private HashMap<String, Integer> defensiveIndexs;

	/**
	 * List of the pitchers
	 */
	private List<LineupEntry> pitchers;
	
	/**
	 * List of catchers
	 */
	private List<LineupEntry> catchers;

	/**
	 * Order number
	 */
	private int orderNumber = 0;

	/** Memorize the order number of the batter */
	private int currentBatterNumber;

	/**
	 * Constructor of the class.
	 * Initialize all data structures
	 */
	public LineupManager() {
		lineupEntries = new HashMap<>();
		defensivePlayers = new HashMap<>();
		offensivePlayers = new HashMap<>();
		playersEntries = new HashMap<>();
		defensiveIndexs = new HashMap<>();

		players = new ArrayList<>();
		pitchers = new ArrayList<>();
		catchers = new ArrayList<>();
	}

	/**
	 * Reset the order of the current batter
	 */
	public void resetCurrentBatter() {
		currentBatterNumber = 1;
	}

	/**
	 * Set the current batter order.
	 *  
	 * @param currentBatterNumber current batter order
	 */
	public void setCurrentBatter(int currentBatterNumber) {
		this.currentBatterNumber = currentBatterNumber;
	}

	/**
	 * Initialize the line-up data structure with a line-up and the current ip
	 * 
	 * @param lineup Current line-up
	 * @param currentIpCounter Ip counter
	 */
	public void init(LineUp lineup, IpCounter currentIpCounter) {

		int offensivePosition = 1;

		for (LineUpEntry entry : lineup.getLineUpEntries()) {

			LineupPlayerDescription player = createNewPlayer(entry);
			LineupEntry lineupEntry = createNewEntry("" + offensivePosition, entry.getDefensivePosition(), entry.getLaterality(),  player); //$NON-NLS-1$
			List<LineupPlayerDescription> localPlayers = new ArrayList<>();
			localPlayers.add(player);

			defensivePlayers.put(entry.getDefensivePosition(), lineupEntry);
			offensivePlayers.put("" + offensivePosition, lineupEntry); //$NON-NLS-1$

			if (offensivePosition < 9) {
				offensivePosition++;
			} else {
				offensivePosition = -1;
			}
		}

		currentBatterNumber = 1;
	}

	/**
	 * Get list of player for an offensive position.
	 * 
	 * @param offensivePosition offensive position
	 * @return a list of players
	 */
	public LineupEntry getPlayerForOffensivePosition(String offensivePosition) {
		return offensivePlayers.get(offensivePosition);
	}

	/**
	 * Get all line-up entries. 
	 * 
	 * @return line-up entries
	 */
	public Map<String, List<LineupEntry>> getLineupEntries() {
		return lineupEntries;
	}

	/**
	 * Get the list of pitchers.
	 *  
	 * @return list of pitchers
	 */
	public List<LineupEntry> getPitchers() {
		return pitchers;
	}

	/**
	 * Get the list of catchers.
	 *  
	 * @return list of catchers
	 */
	public List<LineupEntry> getCatchers() {
		return catchers;
	}
	
	/** 
	 * Return the list of offensive players in the line-up.
	 * 
	 * @return offensive players in the line-up
	 */
	public Map<String, LineupEntry> getOffensivePlayers() {
		return offensivePlayers;
	}

	/**
	 *  Return the list of defensive players in the line-up.
	 * 
	 * @return list of defensive players in the line-up
	 */
	public Map<String, LineupEntry> getDefensivePlayers() {
		return defensivePlayers;
	}

	/**
	 * Get the list of Line-up entries for an offensive position.
	 * 
	 * @param offensivePosition Offesnive position
	 * @return list of Line-up entries for an offensive position
	 */
	public List<LineupEntry> getEntriesForOffensivePosition(String offensivePosition) {
		return lineupEntries.get(offensivePosition);
	}

	/**
	 * Get the list of all players contains in the line-up.
	 * 
	 * @return list of all players
	 */
	public List<LineupEntry> getPlayers() {
		return players;
	}

	/**
	 * Get the current batter.
	 *  
	 * @return reference on the current batter
	 */
	public LineupEntry getCurrentBatter() {
		return getPlayerForOffensivePosition("" + currentBatterNumber); //$NON-NLS-1$
	}

	/**
	 * Set the current batter to the next batter in the line-up.
	 */
	public void nextBatter() {
		currentBatterNumber++;
		if (currentBatterNumber == 10)
			currentBatterNumber = 1;
	}
	
	/**
	 * Get the current batter number  
	 *  
	 * @return current batter number  
	 */
	public int getCurrentBatterNumber() {
		return currentBatterNumber;
	}

	/**
	 * Get the current pitcher.
	 * 
	 * @return reference on the current pitcher
	 */
	public LineupEntry getCurrentPitcher() {
		return getPlayerFromDefensivePosition("1"); //$NON-NLS-1$
	}

	/**
	 * Get the current catcher.
	 * 
	 * @return reference on the current catcher
	 */
	public LineupEntry getCurrentCatcher() {
		return getPlayerFromDefensivePosition("2"); //$NON-NLS-1$
	}

	/**
	 * Get the player at a defensive position.
	 * 
	 * @param defensivePosition defensive position
	 * @return player at a defensive position
	 */
	public LineupEntry getPlayerFromDefensivePosition(String defensivePosition) {
		return defensivePlayers.get(defensivePosition);
	}

	
	/**
	 * Get the current player at a defensive position.
	 * 
	 * @param currentDefensiveposition defensive position
	 * @return current player at a defensive position
	 */
	public LineupEntry getPlayerForDefensivePosition(String currentDefensiveposition) {
		return defensivePlayers.get(currentDefensiveposition);
	}

	/**
	 * UPdate all players Ips after a put-out.
	 * 
	 * @param putoutDetected Number of put-out
	 */
	public void upddateIPs(int putoutDetected) {
		for (Entry<String, LineupEntry> defensivePlayerEntry : defensivePlayers.entrySet()) {
			if (Character.isDigit(defensivePlayerEntry.getKey().charAt(0))) {

				IpCounter playerIpCounter = new IpCounter();
				double currentIps = defensivePlayerEntry.getValue().getIpPlayed();
				currentIps = playerIpCounter.getNewIpValue(currentIps, putoutDetected);
				defensivePlayerEntry.getValue().setIpPlayed(currentIps);
			}
		}
	}

	/**
	 * Apply offensive substitutions in the line-up. 
	 * 
	 * @param replacementData Description of the substitution
	 * @param currentIpCounter Current Ip counter
	 */
	public void applySubstitution(ReplacementData replacementData, IpCounter currentIpCounter) {

		LineupEntry lastEntry = replacementData.player;
		lastEntry.setActif(false);
		replacementData.player.getPlayerDescription().setActif(false);

		/* Puis on effectue le changement */
		if (replacementData.getReplacement().getName() != null) {
			LineupPlayerDescription player = getPlayerByName(replacementData.getReplacement().getName());
			if (player == null) {
				player = createNewPlayer(replacementData.getReplacement());
			} else {
				player.setActif(true);
			}

			String offensivePosition = replacementData.player.getOffensivePosition();
			LineupEntry lineupEntry = createNewEntry(offensivePosition,
					replacementData.getReplacement().getNewDefensivePosition(), replacementData.player.getLaterality(), player);

			if (replacementData.getReplacement().getNewDefensivePosition().startsWith("pr")) { //$NON-NLS-1$
				lineupEntry.getAssociatedObjects().putAll(lastEntry.getAssociatedObjects());
			}
			offensivePlayers.put(offensivePosition, lineupEntry);

		} else {

			String offensivePosition = replacementData.player.getOffensivePosition();
			LineupEntry player = replacementData.playerReplaced;
			String defensivePosition = replacementData.getReplacement().getNewDefensivePosition();
			LineupEntry newPlayer = createNewEntry(offensivePosition, defensivePosition, replacementData.player.getLaterality(), player.getPlayerDescription());

			offensivePlayers.put(offensivePosition, newPlayer);
		}
	}

	/**
	 * Apply defensive substitutions in the line-up .
	 * 
	 * @param substitution Description of the substitution
	 * @param currentIpCounter Current Ip counter
	 */
	public void applySubstitution(MoveToData substitution, IpCounter currentIpCounter) {

		String offensivePosition = substitution.player.getOffensivePosition();
		substitution.player.setActif(false);
		substitution.playerReplaced.setActif(false);
		
		createNewEntry(offensivePosition, substitution.getDefensivePosition().getNewDefensivePosition(),substitution.player.getLaterality(),
				substitution.player.getPlayerDescription());
	}

	/**
	 * Get player description for a player name.
	 * 
	 * @param name player name
	 * @return player description
	 */
	public LineupPlayerDescription getPlayerByName(String name) {
		for (LineupEntry player : players) {
			if (player.getPlayerDescription().getName().equals(name)) {
				return player.getPlayerDescription();
			}
		}
		return null;
	}

	/**
	 * Create a new player description from a substitution.
	 * 
	 * @param replacement description of the player
	 * 
	 * @return Player description
	 */
	private LineupPlayerDescription createNewPlayer(Replacement replacement) {
		LineupPlayerDescription player = new LineupPlayerDescription();

		player.setName(replacement.getName());
		player.setShirtNumber(replacement.getShirtNumber());
		player.setActif(true);
		return player;
	}

	/**
	 * Create a new player description from the line-up entry.
	 * 
	 * @param entry description of the line-up entry
	 * 
	 * @return Player description
	 */
	private LineupPlayerDescription createNewPlayer(LineUpEntry entry) {
		LineupPlayerDescription player = new LineupPlayerDescription();
		player.setName(entry.getName());
		player.setShirtNumber(entry.getShirtNumber());
		player.setActif(true);

		return player;
	}

	/**
	 * Add player entry in the line-up manager .
	 * 
	 * @param player player description
	 * @param lineupEntry Line-up entry object
	 */
	private void addPlayerEntry(LineupPlayerDescription player, LineupEntry lineupEntry) {
		if (playersEntries.containsKey(player)) {
			playersEntries.get(player).add(lineupEntry);
		} else {
			List<LineupEntry> entries = new ArrayList<>();
			entries.add(lineupEntry);
			playersEntries.put(player, entries);
		}
	}

	/**
	 * Add a new entry for an offensive position. 
	 * 
	 * @param offensivePosition offensive position
	 * @param lineupEntry Line-up entry object
	 */
	private void addLineEntry(String offensivePosition, LineupEntry lineupEntry) {
		if (lineupEntries.containsKey(offensivePosition)) {
			lineupEntries.get(offensivePosition).add(lineupEntry);
		} else {
			List<LineupEntry> entries = new ArrayList<>();
			entries.add(lineupEntry);
			lineupEntries.put(offensivePosition, entries);
		}
	}

	/**
	 * Create a new player entry in the line-up manager
	 * 
	 * @param offensivePosition Offensive position
	 * @param defensivePosition Defensive position
	 * @param laterality laterality
	 * @param player Description of the player
	 * @param currentIpCounter Current Ip counter
	 * 
	 * @return The created line-up entry
	 */
	private LineupEntry createNewEntry(String offensivePosition, String defensivePosition, String laterality, LineupPlayerDescription player) {
		
		LineupEntry lineupEntry = StatisticFactory.eINSTANCE.createLineupEntry();
		lineupEntry.setActif(true);
		lineupEntry.setPlayerDescription(player);
		lineupEntry.setStartEntryIp(0.0);
		lineupEntry.setDefensivePosition(defensivePosition);
		lineupEntry.setOffensivePosition(offensivePosition);
		lineupEntry.setOrderNumber(orderNumber++);
		lineupEntry.setLaterality(laterality);

		if (lineupEntry.getDefensivePosition().equals("1")) { //$NON-NLS-1$

			/* Le lanceur peut resté lanceur quand il devient batteur */
			if (getCurrentPitcher() == null) {
				
				pitchers.add(lineupEntry);
			
			} else {
				
				if (getCurrentPitcher().getPlayerDescription() != lineupEntry.getPlayerDescription()) {
					
					pitchers.add(lineupEntry);
					
				} else {
					
					lineupEntry = getCurrentPitcher();
					lineupEntry.setOffensivePosition(offensivePosition);
					lineupEntry.getAssociatedObjects().put(PITCHER_KEEP_ITS_POSITION, true);
				}
			}

		} else if (lineupEntry.getDefensivePosition().equals("2")) { //$NON-NLS-1$

			if (getCurrentCatcher() == null) {
				catchers.add(lineupEntry);
			} else if (getCurrentCatcher().getPlayerDescription() != lineupEntry.getPlayerDescription()) {
				catchers.add(lineupEntry);
			} else {
				// Nothing to do in this case
			}
		}

		players.add(lineupEntry);

		/* puis on effectue le déplacement */
		if (defensiveIndexs.containsKey(defensivePosition)) {
			if (lineupEntry.getDefensivePosition().equals("1")) { //$NON-NLS-1$
			    if (getCurrentPitcher().getPlayerDescription() != lineupEntry.getPlayerDescription()) {
			    	defensiveIndexs.put(defensivePosition, defensiveIndexs.get(defensivePosition).intValue() + 1);
			    }
			} else {
				defensiveIndexs.put(defensivePosition, defensiveIndexs.get(defensivePosition).intValue() + 1);
			}
		} else {
			defensiveIndexs.put(defensivePosition, 0);
		}
		lineupEntry.setDefensivePositionIndex("" + defensiveIndexs.get(defensivePosition)); //$NON-NLS-1$

		defensivePlayers.put(defensivePosition, lineupEntry);

		addLineEntry(offensivePosition, lineupEntry);
		addPlayerEntry(player, lineupEntry);
		return lineupEntry;
	}

	/**
	 * Display the current line-up (for debug).
	 * 
	 */
	public void displayCurrentLineup() {
		for (Entry<String, List<LineupEntry>> entry : lineupEntries.entrySet()) {
			logger.log(Level.INFO,entry.getKey());
		}
	}
}
