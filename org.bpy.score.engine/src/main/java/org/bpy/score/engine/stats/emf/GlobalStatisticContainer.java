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

import java.util.HashMap;

import org.bpy.score.engine.manager.IpCounter;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.globalstatistics.DefensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatistic;
import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsFactory;
import org.bpy.score.engine.stats.emf.globalstatistics.Member;
import org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.PitcherStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics;
import org.bpy.score.engine.stats.emf.globalstatistics.util.GlobalStatisticsAdapterFactory;
import org.bpy.score.engine.stats.emf.globalstatistics.util.GlobalStatisticsResourceFactoryImpl;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.game.game.Game;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * Allow to create general statistics.
 * 
 * @author Patrick BRIAND
 *
 */
public class GlobalStatisticContainer {

	/** Reference on the resourceSet of the EMF Container */ 
	private static ResourceSet resourceSet = null;
	/** EMF Entry point of the container */ 
	private GlobalStatistic globalStatistic;

	/**
	 * Constructor of the class.
	 * Initialize the EMF data structure
	 */
	public GlobalStatisticContainer() {
		if (resourceSet == null) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*",new GlobalStatisticsResourceFactoryImpl());
	
			/* Création de la factory */
			GlobalStatisticsAdapterFactory globalStatisiticAdapterFactory = new GlobalStatisticsAdapterFactory();
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(globalStatisiticAdapterFactory);
	
			/* Création du domaine */
			BasicCommandStack commandStack = new BasicCommandStack();
			AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack,new HashMap<>());
			resourceSet = editingDomain.getResourceSet();
	
			resourceSet.createResource(URI.createFileURI("GlobalStatsContainer.xml"));
			globalStatistic = GlobalStatisticsFactory.eINSTANCE.createGlobalStatistic();
		}

	}

	/**
	 * Update the  globals statistics with the stats of a game 
	 * @param game reference on the game 
	 * @param statisticManager reference on the stats of the game
	 */
	public void updateWithGameStatistics(Game game, StatisticManager statisticManager) {
		GameStatistic stats = statisticManager.getStats();

		String visitorName = game.getVisitor().getName();
		String hometeamName = game.getHometeam().getName();

		TeamStatistic hometeamStats = stats.getHometeam();
		TeamStatistic visitorStats = stats.getVisitor();

		updateWithGameStatistics(visitorName, stats, visitorStats, hometeamStats);
		updateWithGameStatistics(hometeamName, stats, hometeamStats, visitorStats);
		
	}

	/**
	 * Update the  globals statistics with the statistics of a team.
	 * 
	 * @param teamName team name
	 * @param stats reference on the statistics of the game
	 * @param currentTeamStats statistics of the team
	 * @param oppositeTeamStats statistics of the opposite team
	 */
	private void updateWithGameStatistics(String teamName, GameStatistic stats, TeamStatistic currentTeamStats, TeamStatistic oppositeTeamStats) {
		TeamStatistics team = getTeamContainer(teamName);

		if (currentTeamStats.getFinalScore() > oppositeTeamStats.getFinalScore()) {
			team.setGameWin(team.getGameWin() + 1);
		} else {
			team.setGameLose(team.getGameLose() + 1);
		}
		team.setGamePlayed(team.getGamePlayed()+1);
		
		for (LineupEntry pitcher : currentTeamStats.getPitchers()) {
			updateWithPitcherStatistics(team, pitcher, stats);
		}
		for (LineupEntry player : currentTeamStats.getPlayers()) {
			updateWithOffensiveStatistics(team, player);
		}
		for (LineupEntry player : currentTeamStats.getPlayers()) {
			updateWithDefensiveStatistics(team, player);
		}
	}

	/**
	 * Update the  globals statistics with the defensive statistics of a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param player reference to the player
	 */
	private void updateWithDefensiveStatistics(TeamStatistics team, LineupEntry player) {
		
		if (player.getDefensiveStatistic() != null) {
			String memberName = player.getPlayerDescription().getName();
			DefensiveStatistics defensiveStatitics = getOrCreateDefensiveStatisitics(team, memberName);
			
			defensiveStatitics.setAssists( defensiveStatitics.getAssists() + player.getDefensiveStatistic().getAssitances());
			defensiveStatitics.setErrors( defensiveStatitics.getErrors() + player.getDefensiveStatistic().getErrors());
			defensiveStatitics.setPutouts(  defensiveStatitics.getPutouts() + player.getDefensiveStatistic().getPutOut());
		}
	}

	/**
	 * Update the  globals statistics with the offensive statistics of a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param player reference to the player
	 */
	private void updateWithOffensiveStatistics(TeamStatistics team, LineupEntry player) {
		if (player.getOffensiveStatistic() != null) {
			String memberName = player.getPlayerDescription().getName();

			OffensiveStatistics offensiveStatitics = getOrCreateOffensiveStatisitics(team, memberName);

			offensiveStatitics.setAtBats(offensiveStatitics.getAtBats() + player.getOffensiveStatistic().getAtBats());
			offensiveStatitics.setBaseOnBalls(offensiveStatitics.getBaseOnBalls() + player.getOffensiveStatistic().getBaseOnBall());
			offensiveStatitics.setDoubleBaseHits(offensiveStatitics.getDoubleBaseHits() + player.getOffensiveStatistic().getDouble());
			offensiveStatitics.setFourBaseHits(offensiveStatitics.getFourBaseHits() + player.getOffensiveStatistic().getHomerun());
			offensiveStatitics.setHits(offensiveStatitics.getHits() + player.getOffensiveStatistic().getHits());
			offensiveStatitics.setHitsByPitch(offensiveStatitics.getHitsByPitch() + player.getOffensiveStatistic().getHitByPitch());
			offensiveStatitics.setPlateAppearance(offensiveStatitics.getPlateAppearance() + player.getOffensiveStatistic().getPlateAppearances());
			offensiveStatitics.setSacrificeFlies(offensiveStatitics.getSacrificeFlies() + player.getOffensiveStatistic().getSacrificeFly());
			offensiveStatitics.setTripleBaseHits(offensiveStatitics.getTripleBaseHits() + player.getOffensiveStatistic().getTriple());
		}
	}

	/**
	 * Update the  globals statistics with the pitcher statistics of a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param pitcher reference to the player
	 * @param stats reference on the statistics of the game
	 */
	private void updateWithPitcherStatistics(TeamStatistics team, LineupEntry pitcher, GameStatistic stats) {
		
		if (pitcher.getPitcherStatistic() != null) {
			String memberName = pitcher.getPlayerDescription().getName();

			PitcherStatistics pitcherStatistics = getOrCreatePitcherStatistics(team, memberName);

			if (stats.getLoosingPitcher()!=null &&  memberName.equals(stats.getLoosingPitcher().getPlayerDescription().getName())) {
				pitcherStatistics.setGameLose(pitcherStatistics.getGameLose()+1);
			}
			if (stats.getSavePitcher()!=null &&  memberName.equals(stats.getSavePitcher().getPlayerDescription().getName())) {
				pitcherStatistics.setGameSave(pitcherStatistics.getGameSave()+1);
			}
			if (stats.getWinningPitcher()!=null &&  memberName.equals(stats.getWinningPitcher().getPlayerDescription().getName())) {
				pitcherStatistics.setGameWin(pitcherStatistics.getGameWin()+1);
			}
			
			pitcherStatistics.setEarnedRuns(pitcherStatistics.getEarnedRuns() + pitcher.getPitcherStatistic().getEarnedRuns());
			int playerOut = IpCounter.intValue(pitcher.getIpPlayed());
			pitcherStatistics.setIps(pitcherStatistics.getIps() + playerOut);
					
		}
	}

	/**
	 * Get or create offensive statistics for a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param memberName name of the player
	 * 
	 * @return Offensive statistic of a player
	 */
	private OffensiveStatistics getOrCreateOffensiveStatisitics(TeamStatistics team, String memberName) {
		Member member = getOrCreateMember(team, memberName);

		if (member.getOffensiveStatistics()!= null) {
			return member.getOffensiveStatistics();
		} else {
			return createOffensiveStatictsics(member);
		}
	}

	/**
	 * Get or create pitcher statistics for a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param memberName name of the player
	 * 
	 * @return pitcher statistic of a player
	 */
	public PitcherStatistics getOrCreatePitcherStatistics(TeamStatistics team, String memberName) {
		
		Member member = getOrCreateMember(team, memberName);

		if (member.getPitcherStatistics()!= null) {
			return member.getPitcherStatistics();
		} else {
			return createPitcherStatictsics(member);
		}
	}

	/**
	 * Get or create defensive statistics for a player.
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param memberName name of the player
	 * 
	 * @return defensive statistic of a player
	 */
	private DefensiveStatistics getOrCreateDefensiveStatisitics(TeamStatistics team, String memberName) {
		
		Member member = getOrCreateMember(team, memberName);

		if (member.getDefensiveStatistics() != null) {
			return member.getDefensiveStatistics();
		} else {
			return createDefensiveStatisitics(member);
		}
	}

	/**
	 * Get or create member for a team
	 * 
	 * @param team reference to the TeamStatistics of the team
	 * @param memberName name of the player
	 * 
	 * @return A member of a team
	 */
	private Member getOrCreateMember(TeamStatistics team, String memberName) {
		for (Member member : team.getMembers()) {
			if (member.getName().equals(memberName)) {
				return member;
			}
		}
		Member newMember = GlobalStatisticsFactory.eINSTANCE.createMember();
		newMember.setName(memberName);
		team.getMembers().add(newMember);
		return newMember;
	}

	/**
	 * Create an empty offensive statistics for a member.
	 * 
	 * @param member reference to the member
	 * 
	 * @return empty offensive statistics
	 */
	private OffensiveStatistics createOffensiveStatictsics(Member member) {
		OffensiveStatistics offensiveStatistics = GlobalStatisticsFactory.eINSTANCE.createOffensiveStatistics();
		member.setOffensiveStatistics(offensiveStatistics);
		
		offensiveStatistics.setAtBats(0);
		offensiveStatistics.setBaseOnBalls(0);
		offensiveStatistics.setDoubleBaseHits(0);
		offensiveStatistics.setFourBaseHits(0);
		offensiveStatistics.setHits(0);
		offensiveStatistics.setHitsByPitch(0);
		offensiveStatistics.setPlateAppearance(0);
		offensiveStatistics.setSacrificeFlies(0);
		offensiveStatistics.setTripleBaseHits(0);
		
		return offensiveStatistics;
	}

	/**
	 * Create an empty defensive statistics for a member.
	 * 
	 * @param member reference to the member
	 * 
	 * @return empty defensive statistics
	 */
	private DefensiveStatistics createDefensiveStatisitics(Member member) {
		DefensiveStatistics defensiveStatitics = GlobalStatisticsFactory.eINSTANCE.createDefensiveStatistics();
		member.setDefensiveStatistics(defensiveStatitics);
		
		defensiveStatitics.setAssists(0);
		defensiveStatitics.setErrors(0);
		defensiveStatitics.setPutouts(0);
		
		return defensiveStatitics;
	}

	/**
	 * Create pitcher statistic for a member of a team
	 * 
	 * @param member reference on the member
	 * @return pitcher statistic element
	 */
	private PitcherStatistics createPitcherStatictsics(Member member) {
		PitcherStatistics pitcherStatistics = GlobalStatisticsFactory.eINSTANCE.createPitcherStatistics();
		member.setPitcherStatistics(pitcherStatistics);
		
		pitcherStatistics.setGameLose(0);
		pitcherStatistics.setGameSave(0);
		pitcherStatistics.setGameWin(0);
		pitcherStatistics.setIps(0);
		pitcherStatistics.setEarnedRuns(0);
		
		return pitcherStatistics;
	}

	/**
	 * get global statistics container of a team, or create it if don't exist
	 * 
	 * @param teamName team name
	 * @return global statistics container of a team 
	 */
	public TeamStatistics getTeamContainer(String teamName) {
		for (TeamStatistics team : globalStatistic.getTeams()) {
			if (teamName.equals(team.getName())) {
				return team;
			}
		}

		TeamStatistics team = GlobalStatisticsFactory.eINSTANCE.createTeamStatistics();
		team.setName(teamName);
		
		team.setGameWin(0);
		team.setGameLose(0);
		team.setGamePlayed(0);
		
		globalStatistic.getTeams().add(team);

		return team;
	}
}
