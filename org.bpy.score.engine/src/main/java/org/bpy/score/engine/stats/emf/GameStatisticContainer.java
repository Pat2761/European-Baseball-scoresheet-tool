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
package org.bpy.score.engine.stats.emf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.StatisticFactory;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.stats.emf.statistic.util.StatisticAdapterFactory;
import org.bpy.score.engine.stats.emf.statistic.util.StatisticResourceFactoryImpl;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Pitch;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This class is used to encapsulate the the access to the MEF data structure which describe the statistics.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameStatisticContainer {
	
	/** Format for the debug */
	public static final String FORMAT_1 = " %2d | %2d || "; //$NON-NLS-1$ 
	/** Format for the debug */
	public static final String FORMAT_2D = " %2d |"; //$NON-NLS-1$
	/** Format for the debug */
	public static final String FORMAT_16D = "%-16s|"; //$NON-NLS-1$
	/** Delimiter 133 -  */
	public static final String DELIMITER_133 = "-------------------------------------------------------------------------------------------------------------------------------------"; //$NON-NLS-1$  
	/** Delimiter 102 -  */
	public static final String DELIMITER_102 = "------------------------------------------------------------------------------------------------------"; //$NON-NLS-1$  
	/** Delimiter 102 -  */
	public static final String DELIMITER_32 = "--------------------------------"; //$NON-NLS-1$  
	/** Header for player statistics */
    public static final String PLAYER_HEADER = "| PO |  A |  E | DP |    |                | PA | AB |  R |  H | 2B | 3B | HR | GDP| SH | SF | BB | IBB| HP | IO | SB | CS |  K | RBI|"; //$NON-NLS-1$
	/** Header for pitcher statistics */
    public static final String PITCHER_HEADER = "                | BF | AB |  R | ER |  H | 2B | 3B | HR | SH | SF | BB | IBB| HP | IO |  K | WP | BK |"; //$NON-NLS-1$
	/** Header for catcher statistics */
    public static final String CATCHER_HEADER = "                | PB | SB | CS |"; //$NON-NLS-1$
    /** separator for empty defensive part */
    public static final String EMPTY_DEFENSIVE = "    |    |    |    |"; //$NON-NLS-1$
    /** separator for empty defensive part */
    public static final String CLOSE_EMPTY_DEFENSIVE = "    |    |"; //$NON-NLS-1$
    /** separator simple */
    public static final String SIMPLE_SEPARATOR = "|"; //$NON-NLS-1$
    /** Total String */
    public static final String TOTAL_STRING = "Total"; //$NON-NLS-1$
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameStatisticContainer.class.getSimpleName());

	/** EMF Statistic resource set */
	private static ResourceSet resourceSet = null;

	/** inning stat container */
	private InninStatictic inningStat;

	/**
	 * Constructor of the class.
	 * Initialize the EMF structure
	 */
	public GameStatisticContainer() {
		if (resourceSet == null) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new StatisticResourceFactoryImpl()); //$NON-NLS-1$

			/* Création de la factory */
			StatisticAdapterFactory statsAdapterFactory = new StatisticAdapterFactory();
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(statsAdapterFactory);

			/* Création du domaine */
			BasicCommandStack commandStack = new BasicCommandStack();
			AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack,
					new HashMap<>());
			resourceSet = editingDomain.getResourceSet();
		}
	}

	/**
	 * Create a new statistic container.
	 * 
	 * @param gameName Name of the game
	 * @param hometeamName name of the home team
	 * @param visitorName name of the visitor tream
	 * @return  Statistic container
	 */
	public GameStatistic createNewStaticContainer(String gameName, String hometeamName, String visitorName) {
		resourceSet.createResource(URI.createFileURI(gameName + ".xml")); //$NON-NLS-1$
		GameStatistic stats = StatisticFactory.eINSTANCE.createGameStatistic();
		stats.setGameName(gameName);

		TeamStatistic visitor = StatisticFactory.eINSTANCE.createTeamStatistic();
		visitor.setName(visitorName);
		stats.setVisitor(visitor);
		visitor.setTotalCatcherStatistic(StatisticFactory.eINSTANCE.createCatcherStatistic());
		visitor.setTotalDefensiveStatistic(StatisticFactory.eINSTANCE.createDefensiveStatistic());
		visitor.setTotalOffensiveStatistic(StatisticFactory.eINSTANCE.createOffensiveStatistic());
		visitor.setTotalPitcherStatistic(StatisticFactory.eINSTANCE.createPitcherStatistic());

		TeamStatistic hometeam = StatisticFactory.eINSTANCE.createTeamStatistic();
		hometeam.setName(hometeamName);
		stats.setHometeam(hometeam);
		hometeam.setTotalCatcherStatistic(StatisticFactory.eINSTANCE.createCatcherStatistic());
		hometeam.setTotalDefensiveStatistic(StatisticFactory.eINSTANCE.createDefensiveStatistic());
		hometeam.setTotalOffensiveStatistic(StatisticFactory.eINSTANCE.createOffensiveStatistic());
		hometeam.setTotalPitcherStatistic(StatisticFactory.eINSTANCE.createPitcherStatistic());

		return stats;
	}

	/**
	 * Set the line-up description
	 * 
	 * @param stats reference on the 'stats' EMF container
	 * @param team team name
	 * @param lineup reference on the line-up manager
	 */
	public void setLineupDescription(GameStatistic stats, String team, LineupManager lineup) {
		TeamStatistic teamStatistic = getTeamStatistic(stats, team);

		try {
			for (Entry<String, List<LineupEntry>> entry : lineup.getLineupEntries().entrySet()) {

				for (LineupEntry lineupPlayer : entry.getValue()) {
					setNewPlayer(teamStatistic, team, lineupPlayer, false);
				}
			}
		} catch (NullPointerException ex) {
			logger.log(Level.SEVERE,"GameStatisticContainer:setLineupDescription : ''{0}''", ex.getMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Create a new player in the TeamStatistic EMF element 
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param teamName name of the team
	 * @param lineupPlayer reference on the lineupEntry element of the player
	 * @param isReEntry indicate if it is a re-entry
	 */
	public void setNewPlayer(TeamStatistic teamStatistic, String teamName, LineupEntry lineupPlayer,
			boolean isReEntry) {

		/* create the player in the statistic data structure */
		lineupPlayer.setIsDefensiveEntry(isReEntry);

		setNewOffensivePosition(teamStatistic, lineupPlayer);
		setNewDefensivePosition(teamStatistic, lineupPlayer);

		teamStatistic.getPlayers().add(lineupPlayer);
	}

	/**
	 * Define a new defensive position in the TeamStatistic EMF element.
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupPlayer reference on the lineupEntry element of the player
	 */
	public void setNewDefensivePosition(TeamStatistic teamStatistic, LineupEntry lineupPlayer) {

		DefensiveStatistic defensiveStatistics = StatisticFactory.eINSTANCE.createDefensiveStatistic();
		lineupPlayer.setDefensiveStatistic(defensiveStatistics);
		setPlayerDefensivePosition(teamStatistic, lineupPlayer);

		if (lineupPlayer.getDefensivePosition().equals("1")) { //$NON-NLS-1$

			PitcherStatistic pitcherStatistics = getPitcherStatistic(teamStatistic, lineupPlayer);
			if (pitcherStatistics == null) {
				pitcherStatistics = StatisticFactory.eINSTANCE.createPitcherStatistic();
			}
			lineupPlayer.setPitcherStatistic(pitcherStatistics);
			teamStatistic.getPitchers().add(lineupPlayer);
			teamStatistic.setCurrentPitcher(lineupPlayer);

		} else if (lineupPlayer.getDefensivePosition().equals("2")) { //$NON-NLS-1$

			CatcherStatistic catcherStatistics = getCatcherStatistic(teamStatistic, lineupPlayer);
			if (catcherStatistics == null) {
				catcherStatistics = StatisticFactory.eINSTANCE.createCatcherStatistic();
			}
			lineupPlayer.setCatcherStatistic(catcherStatistics);
			teamStatistic.getCatchers().add(lineupPlayer);
			teamStatistic.setCurrentCatcher(lineupPlayer);

		}
	}

	/**
	 * Define a new offensive position in the TeamStatistic EMF element.
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupPlayer reference on the lineupEntry element of the player
	 */
	private void setNewOffensivePosition(TeamStatistic teamStatistic, LineupEntry lineupPlayer) {

		OffensiveStatistic offensiveStatistic = getOffensiveStatistic(teamStatistic, lineupPlayer);
		if (offensiveStatistic == null) {
			offensiveStatistic = StatisticFactory.eINSTANCE.createOffensiveStatistic();
		}
		lineupPlayer.setOffensiveStatistic(offensiveStatistic);

		setPlayerOffensivePosition(teamStatistic, lineupPlayer);
	}

	/**
	 * Increments pitch counter for the current batter
	 * 
	 * @param pitch pitch value
	 * @param stats Reference to the GameStatistic EMF element
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incPitchs(Pitch pitch, GameStatistic stats, String teamType) {
		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);

		switch (pitch.getPitch()) {
		case "k": //$NON-NLS-1$
		case "K": //$NON-NLS-1$
		case "s": //$NON-NLS-1$
		case "S": //$NON-NLS-1$
			pitcher.getPitcherStatistic().setPitchCountK(pitcher.getPitcherStatistic().getPitchCountK() + 1);
			pitcher.getPitcherStatistic().setPitchCount(pitcher.getPitcherStatistic().getPitchCount() + 1);
			break;

		case "b": //$NON-NLS-1$
		case "B": //$NON-NLS-1$
			pitcher.getPitcherStatistic().setPitchCountB(pitcher.getPitcherStatistic().getPitchCountB() + 1);
			pitcher.getPitcherStatistic().setPitchCount(pitcher.getPitcherStatistic().getPitchCount() + 1);
			break;

		case "h": //$NON-NLS-1$
		case "H": //$NON-NLS-1$
			pitcher.getPitcherStatistic().setPitchCount(pitcher.getPitcherStatistic().getPitchCount() + 1);
			break;

		case "f": //$NON-NLS-1$
		case "F": //$NON-NLS-1$
			pitcher.getPitcherStatistic().setPitchCount(pitcher.getPitcherStatistic().getPitchCount() + 1);
			break;

		case ".": //$NON-NLS-1$
			pitcher.getPitcherStatistic().setPitchCount(pitcher.getPitcherStatistic().getPitchCount() + 1);
			break;

		default:
			pitcher.getPitcherStatistic().setPitchCountOthers(pitcher.getPitcherStatistic().getPitchCountOthers() + 1);
		}

	}

	/**
	 * get the catcher statistics of player from a TeamStatistic EMF element
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupPlayer reference on the player
	 * 
	 * @return Reference to the catcher statistic, <b>null</b> is the player wasn't a catcher
	 */
	private CatcherStatistic getCatcherStatistic(TeamStatistic teamStatistic, LineupEntry lineupPlayer) {
		for (LineupEntry playerEntry : teamStatistic.getPlayers()) {
			if ((playerEntry == lineupPlayer) &&  (playerEntry.getCatcherStatistic() != null)) {
					return playerEntry.getCatcherStatistic();
			}
		}
		return null;
	}

	/**
	 * get the pitcher statistics of player from a TeamStatistic EMF element
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupPlayer reference on the player
	 * 
	 * @return Reference to the pitcher statistic, <b>null</b> is the player wasn't a pticher
	 */
	private PitcherStatistic getPitcherStatistic(TeamStatistic teamStatistic, LineupEntry lineupPlayer) {
		for (LineupEntry pitcher : teamStatistic.getPitchers()) {
			if ((pitcher == lineupPlayer) && (pitcher.getPitcherStatistic() != null)) {
				return pitcher.getPitcherStatistic();
			}
		}
		return null;
	}

	/**
	 * get the offensive statistics of player from a TeamStatistic EMF element
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupPlayer reference on the player
	 * 
	 * @return Reference to the offensive statistic, <b>null</b> is the player wasn't at the marble
	 */
	private OffensiveStatistic getOffensiveStatistic(TeamStatistic teamStatistic, LineupEntry lineupPlayer) {
		for (LineupEntry playerEntry : teamStatistic.getPlayers()) {
			if ( (playerEntry == lineupPlayer) && (playerEntry.getOffensiveStatistic() != null)) {
				return playerEntry.getOffensiveStatistic();
			}
		}
		return null;
	}

	/**
	 * Define the player defensive statistics for a position.
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupEntry reference on the player
	 */
	private void setPlayerDefensivePosition(TeamStatistic teamStatistic, LineupEntry lineupEntry) {
		setPlayerPosition(lineupEntry, teamStatistic.getCurrentDefensivePlayer(), lineupEntry.getDefensivePosition());
	}

	/**
	 * Define the player offensive statistics for a position.
	 * 
	 * @param teamStatistic reference on the TeamStatistic EMF element
	 * @param lineupEntry reference on the player
	 */
	private void setPlayerOffensivePosition(TeamStatistic teamStatistic, LineupEntry lineupEntry) {
		setPlayerPosition(lineupEntry, teamStatistic.getCurrentOffensivePlayer(), lineupEntry.getOffensivePosition());
	}

	/**
	 * Initialize the statistics for a player
	 * 
	 * @param lineupEntry reference on the player
	 * @param currentPositionPlayer current player position
	 * @param position position ot the player
	 */
	private void setPlayerPosition(LineupEntry lineupEntry, EMap<String, LineupEntry> currentPositionPlayer,
			String position) {
		currentPositionPlayer.put(position, lineupEntry);
	}

	/**
	 * Increments the general Double plays value in a TeamStatistic EMF element of a team 
	 * 
	 * @param stats reference to the GameStatistic EMF element
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incGeneralDoublePlayCounter(GameStatistic stats, String teamType) {
		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositeTeamStatictic.setDoublePlayCounter(oppositeTeamStatictic.getDoublePlayCounter() + 1);
	}


	/* ******************************************************************************************************** */
	/* management of beginning end endind of inning */ 
	/* ******************************************************************************************************** */
	
	/**
	 * Initialize the general statistics of an half inning.
	 * 
	 * @param stats reference on the GameStatistic EMF container 
	 * @param team type of the team ('visitor', 'hometeam')
	 */
	public void startNewInnning(GameStatistic stats, String team) {
		TeamStatistic teamStatistic = getTeamStatistic(stats, team);
		inningStat = StatisticFactory.eINSTANCE.createInninStatictic();
		teamStatistic.getGeneralInningStats().add(inningStat);

		InningGeneralStatistic inningGeneralStatistic = StatisticFactory.eINSTANCE.createInningGeneralStatistic();
		inningStat.setInningStat(inningGeneralStatistic);

		InningGeneralStatistic cumulativeInningGeneralStatistic = StatisticFactory.eINSTANCE
				.createInningGeneralStatistic();
		inningStat.setCumulativeInningStat(cumulativeInningGeneralStatistic);
	}

	/**
	 * Close the general statistics of an half inning.
	 * 
	 * @param stats reference on the GameStatistic EMF container 
	 * @param team type of the team ('visitor', 'hometeam')
	 */
	public void closeNewInnning(GameStatistic stats, String team) {
		TeamStatistic teamStatistic = getTeamStatistic(stats, team);
		if (teamStatistic.getGeneralInningStats().size() > 1) {
			InninStatictic lastInningStat = teamStatistic.getGeneralInningStats().get(teamStatistic.getGeneralInningStats().size() - 2);
			inningStat.getCumulativeInningStat().setAtBats(lastInningStat.getCumulativeInningStat().getAtBats() + inningStat.getInningStat().getAtBats());
			inningStat.getCumulativeInningStat().setRuns(lastInningStat.getCumulativeInningStat().getRuns() + inningStat.getInningStat().getRuns());
			inningStat.getCumulativeInningStat().setEarnedRuns(lastInningStat.getCumulativeInningStat().getEarnedRuns()	+ inningStat.getInningStat().getEarnedRuns());
			inningStat.getCumulativeInningStat().setHits(lastInningStat.getCumulativeInningStat().getHits() + inningStat.getInningStat().getHits());
			inningStat.getCumulativeInningStat().setAssitances(lastInningStat.getCumulativeInningStat().getAssitances()	+ inningStat.getInningStat().getAssitances());
			inningStat.getCumulativeInningStat().setErrors(lastInningStat.getCumulativeInningStat().getErrors() + inningStat.getInningStat().getErrors());
			inningStat.getCumulativeInningStat().setLob(lastInningStat.getCumulativeInningStat().getLob() + inningStat.getInningStat().getLob());
		} else {
			inningStat.getCumulativeInningStat().setAtBats(inningStat.getInningStat().getAtBats());
			inningStat.getCumulativeInningStat().setRuns(inningStat.getInningStat().getRuns());
			inningStat.getCumulativeInningStat().setEarnedRuns(inningStat.getInningStat().getEarnedRuns());
			inningStat.getCumulativeInningStat().setHits(inningStat.getInningStat().getHits());
			inningStat.getCumulativeInningStat().setAssitances(inningStat.getInningStat().getAssitances());
			inningStat.getCumulativeInningStat().setErrors(inningStat.getInningStat().getErrors());
			inningStat.getCumulativeInningStat().setLob(inningStat.getInningStat().getLob());
		}
	}

	/**
	 * Return the home team TeamStatistic EMF element.
	 * 
	 * @param stats reference on the GameStatistic EMF container 
	 * 
	 * @return the home team TeamStatistic EMF element
	 */
	public TeamStatistic getHomeTeamStatistic(GameStatistic stats) {
		return stats.getHometeam();
	}

	/**
	 * Return the visitor TeamStatistic EMF element.
	 * 
	 * @param stats reference on the GameStatistic EMF container 
	 * 
	 * @return the visitor TeamStatistic EMF element
	 */
	public TeamStatistic getVisitorStatistic(GameStatistic stats) {
		return stats.getVisitor();
	}

	/* ******************************************************************************************************** */
	/* Stat computing */
	/* ******************************************************************************************************** */

	/**
	 * Increments the tie break of a team
	 * 
	 * @param stats reference on the GameStatistic EMF container 
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incTiebreak(GameStatistic stats, String teamType) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		teamStatictic.setTieBreakCounter(teamStatictic.getTieBreakCounter() + 1);
	}

	/**
	 * Increment the number of plate appearance for a batter.
	 * <ul>
	 * <li>increment the plate appearances of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of plate appearances of the offensive statistic of
	 * the team</li>
	 * <li>increment the number of batter front of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of batter front of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition offensive position in the line-up of the batter
	 */
	public void incPlateAppearance(GameStatistic stats, String teamType, int offensivePosition) {

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setPlateAppearances(playerStatisticEntry.getOffensiveStatistic().getPlateAppearances() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setBatterFront(pitcher.getPitcherStatistic().getBatterFront() + 1);

		teamStatictic.getTotalOffensiveStatistic()
				.setPlateAppearances(teamStatictic.getTotalOffensiveStatistic().getPlateAppearances() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setBatterFront(oppositeTeamStatictic.getTotalPitcherStatistic().getBatterFront() + 1);
	}

	/**
	 * Increment the number of at bat for a batter.
	 * <ul>
	 * <li>increment the at bat number of the current team in the general
	 * statistic</li>
	 * <li>increment the at bat of the offensive statistic of the batter</li>
	 * <li>increment the total of at bat of the offensive statistic of the team</li>
	 * <li>increment the number of at bat of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the total of at bat of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incAtBat(GameStatistic stats, String teamType, int offensivePosition) {
		inningStat.getInningStat().setAtBats(inningStat.getInningStat().getAtBats() + 1);

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setAtBats(playerStatisticEntry.getOffensiveStatistic().getAtBats() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setAtBats(pitcher.getPitcherStatistic().getAtBats() + 1);

		teamStatictic.getTotalOffensiveStatistic()
				.setAtBats(teamStatictic.getTotalOffensiveStatistic().getAtBats() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setAtBats(oppositeTeamStatictic.getTotalPitcherStatistic().getAtBats() + 1);
	}

	/**
	 * Increment the number of runs for a batter.
	 * <ul>
	 * <li>increment the number of runs of he current team in the general
	 * statistic</li>
	 * <li>increment the number of runs of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of runs of the offensive statistic of the team</li>
	 * <li>increment the number of runs of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the total of runs of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats              Reference to the statistic container
	 * @param teamType           type of the team ('visitor', 'hometeam')
	 * @param offensivePosition  Offensive position in the line-up of the batter
	 * @param pitcher            reference on the pitcher
	 */
	public void incRun(GameStatistic stats, String teamType, int offensivePosition, LineupEntry pitcher) {
		inningStat.getInningStat().setRuns(inningStat.getInningStat().getRuns() + 1);

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setRuns(playerStatisticEntry.getOffensiveStatistic().getRuns() + 1);
		teamStatictic.getTotalOffensiveStatistic().setRuns(teamStatictic.getTotalOffensiveStatistic().getRuns() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);

		pitcher.getPitcherStatistic().setRuns(pitcher.getPitcherStatistic().getRuns() + 1);

		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setRuns(oppositeTeamStatictic.getTotalPitcherStatistic().getRuns() + 1);
	}

	/**
	 * Increment the number of hits for a batter.
	 * <ul>
	 * <li>increment the number of hits of he current team in the general
	 * statistic</li>
	 * <li>increment the hits of the offensive statistic of the batter</li>
	 * <li>increment the total of hits of the offensive statistic of the team</li>
	 * <li>increment the number of hits of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the total of hits of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incHits(GameStatistic stats, String teamType, int offensivePosition) {
		inningStat.getInningStat().setHits(inningStat.getInningStat().getHits() + 1);

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setHits(playerStatisticEntry.getOffensiveStatistic().getHits() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setHits(pitcher.getPitcherStatistic().getHits() + 1);

		teamStatictic.getTotalOffensiveStatistic().setHits(teamStatictic.getTotalOffensiveStatistic().getHits() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setHits(oppositeTeamStatictic.getTotalPitcherStatistic().getHits() + 1);
	}

	/**
	 * Increment the number of double for a batter.
	 * <ul>
	 * <li>increment the number of hits of he current team in the general
	 * statistic</li>
	 * <li>increment the hits of the offensive statistic of the batter</li>
	 * <li>increment the total of hits of the offensive statistic of the team</li>
	 * <li>increment the hits of the pitcher statistic of the opposite team</li>
	 * <li>increment the total of hits of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the number of double of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of double of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition offensive position in the line-up of the batter
	 */
	public void incDouble(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setDouble(playerStatisticEntry.getOffensiveStatistic().getDouble() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setDouble(pitcher.getPitcherStatistic().getDouble() + 1);

		teamStatictic.getTotalOffensiveStatistic()
				.setDouble(teamStatictic.getTotalOffensiveStatistic().getDouble() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setDouble(oppositeTeamStatictic.getTotalPitcherStatistic().getDouble() + 1);

		incHits(stats, teamType, offensivePosition);
	}

	/**
	 * Increment the number of triple for a batter.
	 * <ul>
	 * <li>increment the number of hits of he current team in the general
	 * statistic</li>
	 * <li>increment the hits of the offensive statistic of the batter</li>
	 * <li>increment the total of hits of the offensive statistic of the team</li>
	 * <li>increment the hits of the pitcher statistic of the opposite team</li>
	 * <li>increment the total of hits of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the number of triple of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of triple of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incTriple(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setTriple(playerStatisticEntry.getOffensiveStatistic().getTriple() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setTriple(pitcher.getPitcherStatistic().getTriple() + 1);

		teamStatictic.getTotalOffensiveStatistic()
				.setTriple(teamStatictic.getTotalOffensiveStatistic().getTriple() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setTriple(oppositeTeamStatictic.getTotalPitcherStatistic().getTriple() + 1);

		incHits(stats, teamType, offensivePosition);
	}

	/**
	 * Increment the number of home runs for a batter.
	 * <ul>
	 * <li>increment the number of hits of he current team in the general
	 * statistic</li>
	 * <li>increment the hits of the offensive statistic of the batter</li>
	 * <li>increment the total of hits of the offensive statistic of the team</li>
	 * <li>increment the hits of the pitcher statistic of the opposite team</li>
	 * <li>increment the total of hits of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the number of home runs of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of home runs of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incHomerun(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setHomerun(playerStatisticEntry.getOffensiveStatistic().getHomerun() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setHomerun(pitcher.getPitcherStatistic().getHomerun() + 1);

		teamStatictic.getTotalOffensiveStatistic()
				.setHomerun(teamStatictic.getTotalOffensiveStatistic().getHomerun() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setHomerun(oppositeTeamStatictic.getTotalPitcherStatistic().getHomerun() + 1);

		incHits(stats, teamType, offensivePosition);
	}

	/**
	 * Management of an Grounded douple play
	 * <ul>
	 * <li>increment the number of GDP of the offensive statistic of the batter</li>
	 * <li>increment the total of GDP of the offensive statistic of the team</li>
	 * <li>increment the number of assistances of the current team in the general
	 * statistic</li>
	 * <li>increment the number of assistance for each fielder defensive statistic
	 * who participate to the GDP of the opposite team</li>
	 * <li>increment the number of double play for each fielder defensive statistic
	 * who participate to the GDP of the opposite team</li>
	 * <li>increment the total of assistance of the defensive statistic of the
	 * opposite team</li>
	 * <li>increment the number of put out for the fielder defensive statistic who
	 * make the put out of the opposite team</li>
	 * <li>increment the total of put out of the defensive statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incGdp(GameStatistic stats, String teamType, int offensivePosition) {

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setGroundedDoublePlay(playerStatisticEntry.getOffensiveStatistic().getGroundedDoublePlay() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setGroundedDoublePlay(teamStatictic.getTotalOffensiveStatistic().getGroundedDoublePlay() + 1);
	}

	/**
	 * Management of an Sacrifice hit play
	 * <ul>
	 * <li>increment the number of sacrifice hits of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of sacrifice hits of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of sacrifice hits of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of sacrifice hits of the offensive statistic of the
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incSacrificeHit(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);

		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setSacrificeHit(playerStatisticEntry.getOffensiveStatistic().getSacrificeHit() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setSacrificeHit(teamStatictic.getTotalOffensiveStatistic().getSacrificeHit() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setSacrificeHit(pitcher.getPitcherStatistic().getSacrificeHit() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setSacrificeHit(oppositeTeamStatictic.getTotalPitcherStatistic().getSacrificeHit() + 1);
	}

	/**
	 * Management of an Sacrifice fly play
	 * <ul>
	 * <li>increment the number of sacrifice flies of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of sacrifice flies of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of sacrifice flies of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of sacrifice flies of the offensive statistic of the
	 * team</li> opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incSacrificeFly(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);

		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setSacrificeFly(playerStatisticEntry.getOffensiveStatistic().getSacrificeFly() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setSacrificeFly(teamStatictic.getTotalOffensiveStatistic().getSacrificeFly() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setSacrificeFly(pitcher.getPitcherStatistic().getSacrificeFly() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setSacrificeFly(oppositeTeamStatictic.getTotalPitcherStatistic().getSacrificeFly() + 1);

	}

	/**
	 * Increment the number of base on ball for a batter.
	 * <ul>
	 * <li>increment the number of base on ball of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of base on balls of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of base of balls of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of base on ball of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incBaseOnBall(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setBaseOnBall(playerStatisticEntry.getOffensiveStatistic().getBaseOnBall() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setBaseOnBall(teamStatictic.getTotalOffensiveStatistic().getBaseOnBall() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setBaseOnBall(pitcher.getPitcherStatistic().getBaseOnBall() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setBaseOnBall(oppositeTeamStatictic.getTotalPitcherStatistic().getBaseOnBall() + 1);
	}

	/**
	 * Increment the number of intentional base on ball for a batter.
	 * <ul>
	 * <li>increment the number of intentional base on ball of the offensive
	 * statistic of the batter</li>
	 * <li>increment the total of intentional base on balls of the offensive
	 * statistic of the team</li>
	 * <li>increment the number of intentional base of balls of the pitcher
	 * statistic of the opposite team</li>
	 * <li>increment the total of intentional base on ball of the pitcher statistic
	 * of the opposite team</li>
	 * <li>increment the number of base on ball of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of base on balls of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of base of balls of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of base on ball of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incIntentionalBaseOnBall(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setIntentionalbaseOnBall(playerStatisticEntry.getOffensiveStatistic().getIntentionalbaseOnBall() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setIntentionalbaseOnBall(teamStatictic.getTotalOffensiveStatistic().getIntentionalbaseOnBall() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic()
				.setIntentionalbaseOnBall(pitcher.getPitcherStatistic().getIntentionalbaseOnBall() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic().setIntentionalbaseOnBall(
				oppositeTeamStatictic.getTotalPitcherStatistic().getIntentionalbaseOnBall() + 1);

		incBaseOnBall(stats, teamType, offensivePosition);
	}

	/**
	 * Increment the number of hits by pitch for a batter.
	 * <ul>
	 * <li>increment the number of hits by pitch of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of hits by pitch of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of hits by pitch of the pitcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of hits by pitch of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incHitByPitch(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setHitByPitch(playerStatisticEntry.getOffensiveStatistic().getHitByPitch() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setHitByPitch(teamStatictic.getTotalOffensiveStatistic().getHitByPitch() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setHitByPitch(pitcher.getPitcherStatistic().getHitByPitch() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setHitByPitch(oppositeTeamStatictic.getTotalPitcherStatistic().getHitByPitch() + 1);
	}

	/**
	 * Increment the number of Interference/Obstruction for a batter.
	 * <ul>
	 * <li>increment the number of errors of he current team in the general
	 * statistic</li>
	 * <li>increment the number of Interference/Obstruction of the offensive
	 * statistic of the batter</li>
	 * <li>increment the total of Interference/Obstruction of the offensive
	 * statistic of the team</li>
	 * <li>increment the number of Interference/Obstruction of the pitcher statistic
	 * of the opposite team</li>
	 * <li>increment the total of Interference/Obstruction of the pitcher statistic
	 * of the opposite team</li>
	 * <li>increment the number of errors of the defensive statistic of the player
	 * who make the Interference/Obstruction</li>
	 * <li>increment the total of errors of the defensive statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incIO(GameStatistic stats, String teamType, int offensivePosition) {

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic().setInterferanceObstruction(
				playerStatisticEntry.getOffensiveStatistic().getInterferanceObstruction() + 1);
		teamStatictic.getTotalOffensiveStatistic().setInterferanceObstruction(
				teamStatictic.getTotalOffensiveStatistic().getInterferanceObstruction() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic()
				.setInterferanceObstruction(pitcher.getPitcherStatistic().getInterferanceObstruction() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic().setInterferanceObstruction(
				oppositeTeamStatictic.getTotalPitcherStatistic().getInterferanceObstruction() + 1);

	}

	/**
	 * Increment the number of strike for a batter.
	 * <ul>
	 * <li>increment the number of strike of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of strike of the offensive statistic of the team</li>
	 * <li>increment the number of strike of the pitcher statistic of the opposite
	 * team</li>
	 * <li>increment the total of strike of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 */
	public void incStrikeOut(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setStrikeOut(playerStatisticEntry.getOffensiveStatistic().getStrikeOut() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setStrikeOut(teamStatictic.getTotalOffensiveStatistic().getStrikeOut() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setStrikeOut(pitcher.getPitcherStatistic().getStrikeOut() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setStrikeOut(oppositeTeamStatictic.getTotalPitcherStatistic().getStrikeOut() + 1);
	}

	/**
	 * Increment the number of stolen base for a runner.
	 * <ul>
	 * <li>increment the number of stolen base of the offensive statistic of the
	 * runner</li>
	 * <li>increment the total of stolen base of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of stolen base of the catcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of stolen base of the catcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the player who stole a base
	 */
	public void incStolenBase(GameStatistic stats, String teamType, int offensivePosition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setStolenBase(playerStatisticEntry.getOffensiveStatistic().getStolenBase() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setStolenBase(teamStatictic.getTotalOffensiveStatistic().getStolenBase() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry catcher = getCurrentCatcher(oppositeTeamStatictic);
		catcher.getCatcherStatistic().setStolenBase(catcher.getCatcherStatistic().getStolenBase() + 1);
		oppositeTeamStatictic.getTotalCatcherStatistic()
				.setStolenBase(oppositeTeamStatictic.getTotalCatcherStatistic().getStolenBase() + 1);
	}

	/**
	 * Management of an caught stealing play
	 * <ul>
	 * <li>increment the number of caught stealing of the offensive statistic of the
	 * batter</li>
	 * <li>increment the total of caught stealing of the offensive statistic of the
	 * team</li>
	 * <li>increment the number of caught stealing of the catcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of caught stealing of the catcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats          Reference to the statistic container
	 * @param teamType       type of the team ('visitor', 'hometeam')
	 * @param offensivePosition       Offensive position in the line-up of the batter
	 * @param assists List of defensive position who assists tothe put out
	 */
	public void incCaughtStealing(GameStatistic stats, String teamType, int offensivePosition, char[] assists) {

		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic()
				.setCaughtStealing(playerStatisticEntry.getOffensiveStatistic().getCaughtStealing() + 1);
		teamStatictic.getTotalOffensiveStatistic()
				.setCaughtStealing(teamStatictic.getTotalOffensiveStatistic().getCaughtStealing() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		if ((assists.length > 0) && (assists[0] == '1')) {
			LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
			pitcher.getPitcherStatistic().setCaughtStealing(pitcher.getPitcherStatistic().getCaughtStealing() + 1);
		} else {
			LineupEntry catcher = getCurrentCatcher(oppositeTeamStatictic);
			catcher.getCatcherStatistic().setCaughtStealing(catcher.getCatcherStatistic().getCaughtStealing() + 1);
		}
		oppositeTeamStatictic.getTotalCatcherStatistic()
				.setCaughtStealing(oppositeTeamStatictic.getTotalCatcherStatistic().getCaughtStealing() + 1);
	}

	/**
	 * Management of an pass ball
	 * <ul>
	 * <li>increment the number of pass balls of the catcher statistic of the
	 * opposite team</li>
	 * <li>increment the total of pass balls of the catcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incPassBall(GameStatistic stats, String teamType) {
		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry catcher = getCurrentCatcher(oppositeTeamStatictic);
		catcher.getCatcherStatistic().setPassBall(catcher.getCatcherStatistic().getPassBall() + 1);
		oppositeTeamStatictic.getTotalCatcherStatistic()
				.setPassBall(oppositeTeamStatictic.getTotalCatcherStatistic().getPassBall() + 1);
	}

	/**
	 * Management of an RBI
	 * <ul>
	 * <li>increment the number of RBI of the offensive statistic of the batter</li>
	 * <li>increment the total of RBI of the offensive statistic of the team</li>
	 * </ul>
	 *
	 * @param stats          Reference to the statistic container
	 * @param teamType       type of the team ('visitor', 'hometeam')
	 * @param offensivePosition  Offensive position in the line-up of the batter
	 * @param gwRbiCondition indicate if it is a gwrbi condition
	 */
	public void incRbi(GameStatistic stats, String teamType, int offensivePosition, boolean gwRbiCondition) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, teamType);
		LineupEntry playerStatisticEntry = getPlayerAtOffensivePosition(teamStatictic, offensivePosition);

		playerStatisticEntry.getOffensiveStatistic().setRbi(playerStatisticEntry.getOffensiveStatistic().getRbi() + 1);
		teamStatictic.getTotalOffensiveStatistic().setRbi(teamStatictic.getTotalOffensiveStatistic().getRbi() + 1);

		if (gwRbiCondition) {
			teamStatictic.setGwRbi(playerStatisticEntry.getPlayerDescription().getName());
			TeamStatistic oppositTeamStatictic = getOppositeTeamStatistic(stats, teamType);
			oppositTeamStatictic.setGwRbi(null);
		}
	}

	/**
	 * Remove the GWRBI of the opposite team
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void removeGWRBIInOpposititeTeam(GameStatistic stats, String teamType) {
		TeamStatistic oppositTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositTeamStatictic.setGwRbi(null);
	}

	/**
	 * Management of an Wild pitch
	 * <ul>
	 * <li>increment the number of wild pitch of the pitcher statistic for the
	 * pitcher of the opposite team</li>
	 * <li>increment the total of wild pitch of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incWildPitch(GameStatistic stats, String teamType) {
		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setWildPitches(pitcher.getPitcherStatistic().getWildPitches() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setWildPitches(oppositeTeamStatictic.getTotalPitcherStatistic().getWildPitches() + 1);
	}

	/**
	 * Management of a Balk
	 * <ul>
	 * <li>increment the number of a balk of the pitcher statistic for the pitcher
	 * of the opposite team</li>
	 * <li>increment the total of balks of the pitcher statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incBalk(GameStatistic stats, String teamType) {
		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		LineupEntry pitcher = getCurrentPitcher(oppositeTeamStatictic);
		pitcher.getPitcherStatistic().setBalks(pitcher.getPitcherStatistic().getBalks() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setBalks(oppositeTeamStatictic.getTotalPitcherStatistic().getBalks() + 1);
	}

	/**
	 * Increment the number of earned point for a player.
	 * <ul>
	 * <li>increment the number of earned point for the team general statistics</li>
	 * <li>increment the total of earned point of the pitcher statistic of the
	 * current pitcher of the opposite team</li>
	 * <li>increment the total of earned point of the pitcher statistic of the
	 * opposite team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param offensivePosition Offensive position in the line-up of the batter
	 * @param earnedType String which contains the state of the point
	 * @param pitcher Reference to the pitcher
	 */
	public void incEarnedRun(GameStatistic stats, String teamType, int offensivePosition, String earnedType,
			LineupEntry pitcher) {
		inningStat.getInningStat().setEarnedRuns(inningStat.getInningStat().getEarnedRuns() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);

		if ("unEarnedForTeam".equals(earnedType)) { //$NON-NLS-1$
			oppositeTeamStatictic.setEarnedAgainstTheTeam(oppositeTeamStatictic.getEarnedAgainstTheTeam() + 1);
		}

		pitcher.getPitcherStatistic().setEarnedRuns(pitcher.getPitcherStatistic().getEarnedRuns() + 1);
		oppositeTeamStatictic.getTotalPitcherStatistic()
				.setEarnedRuns(oppositeTeamStatictic.getTotalPitcherStatistic().getEarnedRuns() + 1);
	}

	/**
	 * Management of a put out
	 * <ul>
	 * <li>increment the number of assistances of the current team in the general
	 * statistic</li>
	 * <li>increment the number of assistance for each fielder defensive statistic
	 * who participate to the put out of the opposite team</li>
	 * <li>increment the total of assistance of the defensive statistic of the
	 * opposite team</li>
	 * <li>increment the number of put out for the fielder defensive statistic who
	 * make the put out of the opposite team</li>
	 * <li>increment the total of put out of the defensive statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param position Offensive position in the line-up of the batter
	 * @param assists  List of defensive position who assist to the put out
	 * @param putout   number of the defensive position who make the put out
	 */
	public void manageAPoutOutWithAssist(GameStatistic stats, String teamType, int position, char[] assists,
			char putout) {

		addAssistances(stats, teamType, assists);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositeTeamStatictic.getTotalDefensiveStatistic()
				.setPutOut(oppositeTeamStatictic.getTotalDefensiveStatistic().getPutOut() + 1);

		LineupEntry player = getPlayerAtDefensivePosition(oppositeTeamStatictic, "" + putout); //$NON-NLS-1$
		player.getDefensiveStatistic().setPutOut(player.getDefensiveStatistic().getPutOut() + 1);
	}

	/**
	 * Increment the number of error for a player and a team
	 *
	 * <ul>
	 * <li>increment the number of errors of he current team in the general
	 * statistic</li>
	 * <li>increment the number of errors of the defensive statistic of the player
	 * who make the Interference/Obstruction</li>
	 * <li>increment the total of errors of the defensive statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats    Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param defensivePosition Defensive position of the player who makes the error
	 */
	public void incErrors(GameStatistic stats, String teamType, int defensivePosition) {
		inningStat.getInningStat().setErrors(inningStat.getInningStat().getErrors() + 1);

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositeTeamStatictic.getTotalDefensiveStatistic()
				.setErrors(oppositeTeamStatictic.getTotalDefensiveStatistic().getErrors() + 1);

		LineupEntry player = getPlayerAtDefensivePosition(oppositeTeamStatictic, "" + defensivePosition); //$NON-NLS-1$
		player.getDefensiveStatistic().setErrors(player.getDefensiveStatistic().getErrors() + 1);
	}

	/**
	 * Management of an douple play
	 * <ul>
	 * <li>increment the number of assistances of the current team in the general
	 * statistic</li>
	 * <li>increment the number of assistance for each fielder defensive statistic
	 * who participate to the GDP of the opposite team</li>
	 * <li>increment the number of double play for each fielder defensive statistic
	 * who participate to the GDP of the opposite team</li>
	 * <li>increment the total of assistance of the defensive statistic of the
	 * opposite team</li>
	 * <li>increment the number of put out for the fielder defensive statistic who
	 * make the put out of the opposite team</li>
	 * <li>increment the total of put out of the defensive statistic of the opposite
	 * team</li>
	 * </ul>
	 *
	 * @param stats          Reference to the statistic container
	 * @param teamType       type of the team ('visitor', 'hometeam')
	 * @param position       Offensive position in the line-up of the batter
	 * @param defenserNumber defender who participate to the double or triple play
	 */
	public void incDoublePlay(GameStatistic stats, String teamType, String defenserNumber) {

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositeTeamStatictic.getTotalDefensiveStatistic()
				.setDoublePlay(oppositeTeamStatictic.getTotalDefensiveStatistic().getDoublePlay() + 1);

		LineupEntry player = getPlayerAtDefensivePosition(oppositeTeamStatictic, defenserNumber);
		player.getDefensiveStatistic().setDoublePlay(player.getDefensiveStatistic().getDoublePlay() + 1);
	}

	/**
	 * Increment the put out statistic for a team
	 * <ul>
	 * <li>increments the total number of put out in the opposite team</li>
	 * <li>Increments the number of put outs the defensive player</li>
	 * </ul>
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param defensivePosition defender who participate to the put out
	 */
	public void incOut(GameStatistic stats, String teamType, char defensivePosition) {

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		oppositeTeamStatictic.getTotalDefensiveStatistic().setPutOut(oppositeTeamStatictic.getTotalDefensiveStatistic().getPutOut() + 1);

		LineupEntry player = getPlayerAtDefensivePosition(oppositeTeamStatictic, "" + defensivePosition); //$NON-NLS-1$
		player.getDefensiveStatistic().setPutOut(player.getDefensiveStatistic().getPutOut() + 1);
	}

	/**
	 * Increments the assistances counter.
	 * 
	 * <ul>
	 * <li>increment the assitance counter of the inning statisitics</li>
	 * <li>Increment the assistance counter of the defensive players</li>
	 * <li>increments the global counter of assistances for the oppositie team</li>
	 * </ul>
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @param assists List of defensive position
	 */
	public void addAssistances(GameStatistic stats, String teamType, char[] assists) {

		/* For avoid to put two assist for the same defensive player */
		List<Integer> assistDone = new ArrayList<>();
		for (char assist : assists) {
			int val = Integer.parseInt(String.valueOf(assist));
			if (!assistDone.contains(val)) {
				assistDone.add(val);
			}
		}

		inningStat.getInningStat().setAssitances(inningStat.getInningStat().getAssitances() + assistDone.size());

		TeamStatistic oppositeTeamStatictic = getOppositeTeamStatistic(stats, teamType);
		for (Integer assist : assistDone) {

			LineupEntry player = getPlayerAtDefensivePosition(oppositeTeamStatictic, "" + assist); //$NON-NLS-1$
			player.getDefensiveStatistic().setAssitances(player.getDefensiveStatistic().getAssitances() + 1);
		}

		oppositeTeamStatictic.getTotalDefensiveStatistic()
				.setAssitances(oppositeTeamStatictic.getTotalDefensiveStatistic().getAssitances() + assistDone.size());
	}

	/**
	 * Increment the left of base counter of an inning statistics
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 */
	public void incLeftOnBase(GameStatistic stats, String teamType) {
		inningStat.getInningStat().setLob(inningStat.getInningStat().getLob() + 1);
	}

	/**
	 * Increment the left of base counter of an inning statistics
	 * 
	 * @param leftOnBase number of left on base
	 */
	public void setLeftOnBase(int leftOnBase) {
		inningStat.getInningStat().setLob(leftOnBase);
	}

	/**
	 * Set the looser pitcher in Game statistics
	 * 
	 * @param stats  Reference to the statistic container
	 * @param pitcher Reference to the pitcher
	 */
	public void setLooserPitcher(GameStatistic stats, LineupEntry pitcher) {
		stats.setLoosingPitcher(pitcher);
	}

	/**
	 * Set the winner pitcher in Game statistics
	 * 
	 * @param stats  Reference to the statistic container
	 * @param pitcher Reference to the pitcher
	 */
	public void setWinnerPitcher(GameStatistic stats, LineupEntry pitcher) {
		stats.setWinningPitcher(pitcher);
	}

	/**
	 * Set the save pitcher in Game statistics
	 * 
	 * @param stats  Reference to the statistic container
	 * @param pitcher Reference to the pitcher
	 */
	public void setSavePitcher(GameStatistic stats, LineupEntry pitcher) {
		stats.setSavePitcher(pitcher);
	}

	/**
	 * Return the player at a defensive position.
	 * 
	 * @param teamStatictic Reference to the TeamStatistic container
	 * @param defensivePosition defensive position
	 * 
	 * @return a player reference
	 */
	private LineupEntry getPlayerAtDefensivePosition(TeamStatistic teamStatictic, String defensivePosition) {
		return teamStatictic.getCurrentDefensivePlayer().get(defensivePosition);
	}

	/**
	 * Return the player at a offensive position.
	 * 
	 * @param teamStatictic Reference to the TeamStatistic container
	 * @param offensivePosition offensive position
	 * 
	 * @return a player reference
	 */
	private LineupEntry getPlayerAtOffensivePosition(TeamStatistic teamStatictic, int offensivePosition) {
		return teamStatictic.getCurrentOffensivePlayer().get("" + offensivePosition); //$NON-NLS-1$
	}

	/**
	 * Get the current pitcher of a team.
	 * 
	 * @param teamStatistic  Reference to the TeamStatistic container
	 * @return current pitcher
	 */
	private LineupEntry getCurrentPitcher(TeamStatistic teamStatistic) {
		return teamStatistic.getCurrentPitcher();
	}

	/**
	 * Get the current catcher of a team.
	 * 
	 * @param teamStatistic  Reference to the TeamStatistic container
	 * @return current catcher
	 */
	private LineupEntry getCurrentCatcher(TeamStatistic teamStatistic) {
		return teamStatistic.getCurrentCatcher();
	}

	/**
	 * Get the team statistics of a team
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * @return Reference to the TeamStatistic container of a team
	 */
	private TeamStatistic getTeamStatistic(GameStatistic stats, String teamType) {
		if (teamType.equals(EngineConstants.VISITOR)) {
			return getVisitorStatistic(stats);
		} else {
			return getHomeTeamStatistic(stats);
		}
	}

	/**
	 * Get the team statistics of a opposite team
	 * 
	 * @param stats Reference to the statistic container
	 * @param teamType type of the team ('visitor', 'hometeam')
	 * 
	 * @return Reference to the TeamStatistic container of the opposite team
	 */
	private TeamStatistic getOppositeTeamStatistic(GameStatistic stats, String teamType) {
		if (teamType.equals(EngineConstants.VISITOR)) {
			return getHomeTeamStatistic(stats);
		} else {
			return getVisitorStatistic(stats);
		}
	}

	/**
	 * Create a statistic trace for debug
	 * 
	 * @param stats Reference to the statistic container
	 * @param team type of the team ('visitor', 'hometeam')
	 */
	public void debugGeneralInning(GameStatistic stats, String team) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, team);

		StringBuilder atBats = new StringBuilder("AB :");  //$NON-NLS-1$
		StringBuilder runs = new StringBuilder("R  :"); //$NON-NLS-1$
		StringBuilder earnedRuns = new StringBuilder("ER :"); //$NON-NLS-1$
		StringBuilder hits = new StringBuilder("H  :"); //$NON-NLS-1$
		StringBuilder assistances = new StringBuilder("A  :"); //$NON-NLS-1$
		StringBuilder errors = new StringBuilder("E  :"); //$NON-NLS-1$
		StringBuilder lob = new StringBuilder("LOB:"); //$NON-NLS-1$

		for (InninStatictic generalStat : teamStatictic.getGeneralInningStats()) {
			InningGeneralStatistic cumulativeStat = generalStat.getCumulativeInningStat();
			InningGeneralStatistic currentInningStat = generalStat.getInningStat();

			atBats.append(String.format(FORMAT_1, currentInningStat.getAtBats(), cumulativeStat.getAtBats()));
			runs.append(String.format(FORMAT_1, currentInningStat.getRuns(), cumulativeStat.getRuns()));
			earnedRuns.append(
					String.format(FORMAT_1, currentInningStat.getEarnedRuns(), cumulativeStat.getEarnedRuns()));
			hits.append(String.format(FORMAT_1, currentInningStat.getHits(), cumulativeStat.getHits()));
			assistances.append(
					String.format(FORMAT_1, currentInningStat.getAssitances(), cumulativeStat.getAssitances()));
			errors.append(String.format(FORMAT_1, currentInningStat.getErrors(), cumulativeStat.getErrors()));
			lob.append(String.format(FORMAT_1, currentInningStat.getLob(), cumulativeStat.getLob()));
		}

		logger.log(Level.FINE,"{0}",atBats); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",runs); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",earnedRuns); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",hits); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",assistances); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",errors); //$NON-NLS-1$
		logger.log(Level.FINE,"{0}",lob); //$NON-NLS-1$
	}

	/**
	 * Create a statistic trace for debug for a line-up
	 *  
	 * @param stats statistics Reference to the statistic container
	 * @param team type of the team ('visitor', 'hometeam')
	 * @param lineup  reference on the line-up
	 */
	public void debugPlayerStats(GameStatistic stats, String team, LineupManager lineup) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, team);

		logger.log(Level.FINE,DELIMITER_133);
		StringBuilder header = new StringBuilder(PLAYER_HEADER);
				
		logger.log(Level.FINE,"{0}",header); //$NON-NLS-1$

		for (Entry<String, List<LineupEntry>> entry : lineup.getLineupEntries().entrySet()) {
			logger.log(Level.FINE,DELIMITER_133);
			for (LineupEntry lineupEntry : entry.getValue()) {

				StringBuilder pl = new StringBuilder(SIMPLE_SEPARATOR);

				if (lineupEntry.getDefensiveStatistic() != null) {
					pl.append(String.format(FORMAT_2D, lineupEntry.getDefensiveStatistic().getPutOut()));
					pl.append(String.format(FORMAT_2D, lineupEntry.getDefensiveStatistic().getAssitances()));
					pl.append(String.format(FORMAT_2D, lineupEntry.getDefensiveStatistic().getErrors()));
					pl.append(String.format(FORMAT_2D, lineupEntry.getDefensiveStatistic().getDoublePlay()));
				} else {
					pl.append(EMPTY_DEFENSIVE);
				}

				pl.append(String.format(FORMAT_2D, lineupEntry.getDefensivePosition()));

				String name = (lineupEntry.getPlayerDescription().getName().length() > 15
						? lineupEntry.getPlayerDescription().getName().substring(0, 15)
						: lineupEntry.getPlayerDescription().getName());
				pl.append(String.format(FORMAT_16D, name));

				if (getOffensiveStatistic(teamStatictic, lineupEntry) != null) {
					OffensiveStatistic offensiveStat = getOffensiveStatistic(teamStatictic, lineupEntry);
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getPlateAppearances():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getAtBats():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getRuns():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getHits():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getDouble():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getTriple():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getHomerun():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getGroundedDoublePlay():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getSacrificeHit():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getSacrificeFly():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getBaseOnBall():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getIntentionalbaseOnBall():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getHitByPitch():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getInterferanceObstruction():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getStolenBase():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getCaughtStealing():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getStrikeOut():0));
					pl.append(String.format(FORMAT_2D, (offensiveStat!=null)?offensiveStat.getRbi():0)); 
				} else {
					pl.append(EMPTY_DEFENSIVE);
					pl.append(EMPTY_DEFENSIVE);
					pl.append(EMPTY_DEFENSIVE);
					pl.append(EMPTY_DEFENSIVE);
					pl.append(CLOSE_EMPTY_DEFENSIVE);
				}

				logger.log(Level.SEVERE,"{0}",pl);  //$NON-NLS-1$
			}
		}
		logger.log(Level.FINE,DELIMITER_133);

		StringBuilder pl = new StringBuilder(SIMPLE_SEPARATOR);
		DefensiveStatistic defensiveStatistic = teamStatictic.getTotalDefensiveStatistic();
		pl.append(String.format(FORMAT_2D, defensiveStatistic.getPutOut()));
		pl.append(String.format(FORMAT_2D, defensiveStatistic.getAssitances()));
		pl.append(String.format(FORMAT_2D, defensiveStatistic.getErrors()));
		pl.append(String.format(FORMAT_2D, defensiveStatistic.getDoublePlay()));
		pl.append("    |"); //$NON-NLS-1$
		pl.append(String.format(FORMAT_16D, TOTAL_STRING));
		OffensiveStatistic offensiveStat = teamStatictic.getTotalOffensiveStatistic();
		pl.append(String.format(FORMAT_2D, offensiveStat.getPlateAppearances()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getAtBats()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getRuns()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getHits()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getDouble()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getTriple()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getHomerun()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getGroundedDoublePlay()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getSacrificeHit()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getSacrificeFly()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getBaseOnBall()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getIntentionalbaseOnBall()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getHitByPitch()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getInterferanceObstruction()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getStolenBase()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getCaughtStealing()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getStrikeOut()));
		pl.append(String.format(FORMAT_2D, offensiveStat.getRbi()));
		logger.log(Level.FINE,"{0}",pl); //$NON-NLS-1$
		logger.log(Level.FINE,DELIMITER_133);

	}

	/**
	 * Create a statistic trace for debug for the pitchers.
	 * 
	 * @param stats Reference to the statistic container
	 * @param team type of the team ('visitor', 'hometeam')
	 */
	public void debugPitcherStats(GameStatistic stats, String team) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, team);

		StringBuilder header = new StringBuilder(DELIMITER_102);
		header.append(PITCHER_HEADER);
		header.append(DELIMITER_102);
				
		logger.log(Level.FINE,"{0}",header); //$NON-NLS-1$

		for (LineupEntry pitcher : teamStatictic.getPitchers()) {
			PitcherStatistic pictcherStats = pitcher.getPitcherStatistic();

			StringBuilder pl = new StringBuilder(String.format(FORMAT_16D, pitcher.getPlayerDescription().getName()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getBatterFront()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getAtBats()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getRuns()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getEarnedRuns()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getHits()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getDouble()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getTriple()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getHomerun()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getSacrificeHit()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getSacrificeFly()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getBaseOnBall()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getIntentionalbaseOnBall()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getHitByPitch()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getInterferanceObstruction()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getStrikeOut()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getWildPitches()));
			pl.append(String.format(FORMAT_2D, pictcherStats.getBalks()));
			logger.log(Level.FINE,"{0}",pl); //$NON-NLS-1$
		}

		logger.log(Level.FINE,DELIMITER_102);

		StringBuilder pl = new StringBuilder(String.format(FORMAT_16D, TOTAL_STRING));
		PitcherStatistic pictcherStats = teamStatictic.getTotalPitcherStatistic();
		pl.append(String.format(FORMAT_2D, pictcherStats.getBatterFront()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getAtBats()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getRuns()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getEarnedRuns()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getHits()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getDouble()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getTriple()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getHomerun()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getSacrificeHit()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getSacrificeFly()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getBaseOnBall()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getIntentionalbaseOnBall()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getHitByPitch()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getInterferanceObstruction()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getStrikeOut()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getWildPitches()));
		pl.append(String.format(FORMAT_2D, pictcherStats.getBalks()));
		logger.log(Level.FINE,"{0}",pl); //$NON-NLS-1$
		logger.log(Level.FINE,DELIMITER_102);

	}

	/**
	 * Create a statistic trace for debug for the catchers.
	 * 
	 * @param stats Reference to the statistic container
	 * @param team type of the team ('visitor', 'hometeam')
	 */
	public void debugCatchersStats(GameStatistic stats, String team) {
		TeamStatistic teamStatictic = getTeamStatistic(stats, team);
		logger.log(Level.SEVERE,DELIMITER_32);
		StringBuilder header = new StringBuilder(CATCHER_HEADER);
		header.append(DELIMITER_32);
		logger.log(Level.FINE,"{0}",header); //$NON-NLS-1$

		for (LineupEntry catcher : teamStatictic.getCatchers()) {
			CatcherStatistic catcherStats = catcher.getCatcherStatistic();
			StringBuilder pl = new StringBuilder(String.format(FORMAT_16D, catcher.getPlayerDescription().getName()));
			pl.append(String.format(FORMAT_2D, catcherStats.getPassBall()));
			pl.append(String.format(FORMAT_2D, catcherStats.getStolenBase()));
			pl.append(String.format(FORMAT_2D, catcherStats.getCaughtStealing()));
			logger.log(Level.FINE,"{0}",pl); //$NON-NLS-1$
		}

		logger.log(Level.SEVERE,DELIMITER_32);
		StringBuilder pl = new StringBuilder(String.format(FORMAT_16D, TOTAL_STRING));
		CatcherStatistic catcherStats = teamStatictic.getTotalCatcherStatistic();
		pl.append(String.format(FORMAT_2D, catcherStats.getPassBall()));
		pl.append(String.format(FORMAT_2D, catcherStats.getStolenBase()));
		pl.append(String.format(FORMAT_2D, catcherStats.getCaughtStealing()));
		logger.log(Level.FINE,"{0}",pl); //$NON-NLS-1$
		header.append(DELIMITER_32);
	}
}
