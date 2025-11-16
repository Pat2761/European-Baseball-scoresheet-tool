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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.manager.IpCounter;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.NewDefensivePosition;
import org.bpy.score.game.game.Replacement;
import org.bpy.score.game.game.SubstitutionDescription;

/**
 * This class manage the substitution.
 * 
 * @author Patrick BRIAND
 *
 */
public class SubstitutionManager {

	/**
	 * Class which contains common information about substitution
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public abstract class SubstitutionCommonData {
		
		/** reference to the player */
		protected LineupEntry player;
		/** Reference to player who is replaced */
		protected LineupEntry playerReplaced;
		/** Defensive position */ 
		protected String currentDefensivePosition;
		
		/**
		 * Get the new player
		 * 
		 * @return new  player
		 */
		public LineupEntry getPlayer() {
			return player;
		}
		
		/**
		 * Set the new player
		 * 
		 * @param player new player
		 */
		public void setPlayer(LineupEntry player) {
			this.player = player;
		}

		/**
		 * Get the replaced player
		 * 
		 * @return replaced player
		 */
		public LineupEntry getPlayerReplaced() {
			return playerReplaced;
		}

		/**
		 * Set the replaced player
		 * 
		 * @param playerReplaced replaced player
		 */
		public void setPlayerReplaced(LineupEntry playerReplaced) {
			this.playerReplaced = playerReplaced;
		}
		
		/**
		 * Get the defensive position
		 * 
		 * @return set the defensive position
		 */
		public String getCurrentDefensivePosition() {
			return currentDefensivePosition;
		}
		
		/**
		 * Set the defensive position
		 * 
		 * @param currentDefensivePosition defensive position
		 */
		public void setCurrentDefensivePosition(String currentDefensivePosition) {
			this.currentDefensivePosition = currentDefensivePosition;
		}
	}

	/**
	 * Class which contains common information about offensive substitution
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public class ReplacementData extends SubstitutionCommonData {
		/** reference to the replacement object */
		private Replacement replacement;
		/** Offensive position */
		private  String offensivePosition;

		@Override
		public String toString() {
			StringBuilder strBuilder = new StringBuilder(player.getPlayerDescription().getName() + "(" //$NON-NLS-1$
					+ currentDefensivePosition + ")" + " for " + replacement.getName()); //$NON-NLS-1$ //$NON-NLS-2$
			if (replacement.getNewDefensivePosition() != null) {
				strBuilder.append(" at " + replacement.getNewDefensivePosition()); //$NON-NLS-1$
			}
			return strBuilder.toString();
		}

		/**
		 * Get the replacement object 
		 * 
		 * @return replacement object
		 */
		public Replacement getReplacement() {
			return replacement;
		}

		/**
		 * Set the replacement object 
		 * 
		 * @param replacement replacement object
		 */
		public void setReplacement(Replacement replacement) {
			this.replacement = replacement;
		}

		/**
		 * Get the offensive position
		 * 
		 * @return Offensive position
		 */
		public String getOffensivePosition() {
			return offensivePosition;
		}

		/**
		 * Set the offensive position
		 * 
		 * @param offensivePosition Offensive position
		 */
		public void setOffensivePosition(String offensivePosition) {
			this.offensivePosition = offensivePosition;
		}
		
	}

	/**
	 * Class which contains common information about offensive substitution.
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public class MoveToData extends SubstitutionCommonData {
		/** new defensive position */
		private NewDefensivePosition defensivePosition;

		@Override
		public String toString() {
			return player.getPlayerDescription().getName() + "(" + currentDefensivePosition + ")" + " to " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ defensivePosition.getNewDefensivePosition();
		}

		/**
		 * Get the new defensive position
		 * 
		 * @return new defensive position
		 */
		public NewDefensivePosition getDefensivePosition() {
			return defensivePosition;
		}
		
		/**
		 * Set the new defensive position.
		 *  
		 * @param defensivePosition new defensive position
		 */
		public void setDefensivePosition(NewDefensivePosition defensivePosition) {
			this.defensivePosition = defensivePosition;
		}
		
	}

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(SubstitutionManager.class.getName());
	
	/** List of substitutions to manage */
	private List<SubstitutionCommonData> substitutions;

	/** Reference to the line-up manager */
	private LineupManager lineupManager;
	/** IP counter */
	private IpCounter currentIpCounter;
	/** Name of the team */
	private String team;

	/**
	 * Constructor of the class.
	 * Initialize some fields
	 */
	public SubstitutionManager() {
		substitutions = new ArrayList<>();
	}

	/**
	 * Set the line-up manager.
	 *  
	 * @param lineupManager  reference to the line-up manager
	 */
	public void setLineupManager(LineupManager lineupManager) {
		this.lineupManager = lineupManager;
	}

	/**
	 * Get the line-up manager.
	 * 
	 * @return reference to the line-up manager
	 */
	public LineupManager getLineupManager() {
		return lineupManager;
	}

	/**
	 * Set the current IP
	 * 
	 * @param currentIpCounter current IP
	 */
	public void setCurrentIpCounter(IpCounter currentIpCounter) {
		this.currentIpCounter = currentIpCounter;
	}

	/**
	 * Get the list of substitution to manage.
	 * 
	 * @return list of substitution to manage
	 */
	public List<SubstitutionCommonData> getSubstitutions() {
		return substitutions;
	}

	/**
	 * Set team name.
	 * 
	 * @param team team name
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * Get the team name
	 * 
	 * @return team name
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * Add a new offensive substitution to the manager.
	 * 
	 * @param sub Description of the substitution
	 */
	public void addReplacement(SubstitutionDescription sub) {

		ReplacementData replacementData = new ReplacementData();
		replacementData.replacement = (Replacement) sub.getSubtitution();

		String defensivePosition = sub.getCurrentDefensivePosition();
		replacementData.player = lineupManager.getPlayerForDefensivePosition(defensivePosition);
		replacementData.currentDefensivePosition = defensivePosition;
		replacementData.offensivePosition = replacementData.player.getOffensivePosition();

		if ("ph".equals(replacementData.replacement.getNewDefensivePosition()) //$NON-NLS-1$
				|| "pr".equals(replacementData.replacement.getNewDefensivePosition())) { //$NON-NLS-1$
			replacementData.replacement.setNewDefensivePosition(
					replacementData.replacement.getNewDefensivePosition() + replacementData.offensivePosition);
		}

		if (replacementData.replacement.getDefensivePosition() != 0) {

			replacementData.playerReplaced = lineupManager
					.getPlayerForDefensivePosition("" + replacementData.replacement.getDefensivePosition()); //$NON-NLS-1$
		} else {
			String newDefensivePosition = replacementData.replacement.getNewDefensivePosition();
			replacementData.playerReplaced = lineupManager.getPlayerForDefensivePosition(newDefensivePosition);
		}

		if (replacementData.replacement.getNewDefensivePosition() == null) {
			replacementData.replacement.setNewDefensivePosition(sub.getCurrentDefensivePosition());
		}
		substitutions.add(replacementData);

		if (EngineConstants.debugEngine) {
			StringBuilder strBuilder = new StringBuilder("OFFENSIVE REPLACEMENT:"); //$NON-NLS-1$
			strBuilder.append(replacementData.player.getPlayerDescription().getName() + "(" //$NON-NLS-1$
					+ replacementData.currentDefensivePosition + ") replace by "); //$NON-NLS-1$
			strBuilder.append(replacementData.replacement.getName() + " at " //$NON-NLS-1$
					+ replacementData.replacement.getNewDefensivePosition());
			logger.log(Level.FINE,"{0}",strBuilder); //$NON-NLS-1$
		}
	}

	/**
	 * Add a new defensive substitution to the manager.
	 * 
	 * @param sub Description of the substitution
	 */
	public void addMoveto(SubstitutionDescription sub) {
		MoveToData moveToData = new MoveToData();
		moveToData.defensivePosition = (NewDefensivePosition) sub.getSubtitution();

		moveToData.player = lineupManager.getPlayerForDefensivePosition(sub.getCurrentDefensivePosition());
		moveToData.playerReplaced = lineupManager
				.getPlayerForDefensivePosition(moveToData.defensivePosition.getNewDefensivePosition());
		moveToData.currentDefensivePosition = sub.getCurrentDefensivePosition();

		substitutions.add(moveToData);
		if (EngineConstants.debugEngine) {
			logger.log(Level.FINE,"------------------------------------------------------------------------"); //$NON-NLS-1$
			StringBuilder strBuilder = new StringBuilder("DEFENSIVE REPLACEMENT:"); //$NON-NLS-1$
			strBuilder.append(
					moveToData.player.getPlayerDescription().getName() + "(" + moveToData.currentDefensivePosition //$NON-NLS-1$
							+ ") moveto " + moveToData.defensivePosition.getNewDefensivePosition()); //$NON-NLS-1$
			logger.log(Level.FINE,"{0}", strBuilder); //$NON-NLS-1$
		}
	}

	/**
	 * Apply the substitution
	 */
	public void applySubstitution() {
		StringBuilder strBuilder = new StringBuilder("Substitution: "); //$NON-NLS-1$
		for (SubstitutionCommonData substitution : substitutions) {
			strBuilder.append(substitution.toString() + " , "); //$NON-NLS-1$
			if (substitution instanceof MoveToData) {
				lineupManager.applySubstitution((MoveToData) substitution, currentIpCounter);
			} else
				lineupManager.applySubstitution((ReplacementData) substitution, currentIpCounter);
		}
		logger.log(Level.FINE, "{0}", strBuilder); //$NON-NLS-1$
	}
}
