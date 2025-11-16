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
package org.bpy.score.reports.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.reports.gamereports.ActionDescription;
import org.bpy.score.reports.gamereports.CatcherStatistic;
import org.bpy.score.reports.gamereports.DefensiveStatistic;
import org.bpy.score.reports.gamereports.GameGeneralStats;
import org.bpy.score.reports.gamereports.GameReport;
import org.bpy.score.reports.gamereports.GameReportsFactory;
import org.bpy.score.reports.gamereports.LineupPlayer;
import org.bpy.score.reports.gamereports.OffensiveStatistic;
import org.bpy.score.reports.gamereports.PitcherStatistic;
import org.bpy.score.reports.gamereports.PlayByPlay;
import org.bpy.score.reports.gamereports.Player;
import org.bpy.score.reports.gamereports.PointsPerInning;
import org.bpy.score.reports.gamereports.StartingLineup;
import org.bpy.score.reports.gamereports.TeamStatisitics;
import org.bpy.score.reports.gamereports.util.GameReportsAdapterFactory;
import org.bpy.score.reports.gamereports.util.GameReportsResourceFactoryImpl;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This class supply services for use the EMF data structure dedicated to the report generation.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportContainer {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportContainer.class.getSimpleName());

	/** reference on the resource set EMF */
	private static ResourceSet resourceSet = null;

	/**
	 * Constructor of the class.
	 * 
	 * Initialize the EMF data structure
	 */
	public GameReportContainer() {
		if (resourceSet == null) {
			/* Ajout de la factory dans le registre */
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*",new GameReportsResourceFactoryImpl()); //$NON-NLS-1$

			/* Création de la factory autosar */
			GameReportsAdapterFactory agsXmlAdapterFactory = new GameReportsAdapterFactory();
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(	ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(agsXmlAdapterFactory);

			/* Création du domaine */
			BasicCommandStack commandStack = new BasicCommandStack();
			AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<>());
			resourceSet = editingDomain.getResourceSet();
		}
	}

	/**
	 * Create a new game report EMF structure
	 * 
	 * @param fileName file name of the report
	 * 
	 * @return An entry point on the EMF game report  
	 */
	public GameReport createNewGameReport(String fileName) {
		Resource resource = resourceSet.createResource(URI.createFileURI(fileName));
		GameReport gameReport = GameReportsFactory.eINSTANCE.createGameReport();
		resource.getContents().add(gameReport);
		return gameReport;
	}
	
	/**
	 * Create a team statistics container for the report.
	 * 
	 * @return EMF element for team statistics container for the report.
	 */
	public TeamStatisitics createTeamStatistics() {
		return GameReportsFactory.eINSTANCE.createTeamStatisitics();
	}

	
	/**
	 * Create a team statistics container for the report.
	 * 
	 * @param gameReport game report (parent of this container) 
	 * 
	 * @return EMF element for the general team statistics container for the report.
	 */
	public GameGeneralStats createGeneralStatistic(GameReport gameReport) {
		GameGeneralStats generalStats = GameReportsFactory.eINSTANCE.createGameGeneralStats();
		gameReport.setGeneralStats(generalStats);
		return generalStats;
	}
	
	/**
	 * Create a container for setting the starting line-up of a team.
	 * 
	 * @param gameReport game report (parent of this container) 
	 * @param team team name
	 * 
	 * @return container for setting the starting line-up of a team
	 */
	public StartingLineup createStartingLineUp(GameReport gameReport, String team) {
		StartingLineup lineup = GameReportsFactory.eINSTANCE.createStartingLineup();
		if (EngineConstants.HOMETEAM.equals(team)) {
			gameReport.setHometeamLineup(lineup);
		} else {
			gameReport.setVisitorLineup(lineup);
		}
		return lineup;
	}

	/**
	 * Add a player in the report stating line-up
	 * 
	 * @param startingLineup reference on the starting line-up
	 * 
	 * @return an EMF player element in the starting line-up
	 */
	public LineupPlayer addPlayerInLineup(StartingLineup startingLineup) {
		LineupPlayer player = GameReportsFactory.eINSTANCE.createLineupPlayer();
		startingLineup.getLineupPlayers().add(player);
		return player;
	}

	/**
	 * Create a Point per inning container in the report
	 * 
	 * @param generalStats reference on the general statistics container (OWner of this element)
	 * 
	 * @return Point per inning EMF object
	 */
	public PointsPerInning getPointsPerInning(GameGeneralStats generalStats) {
		PointsPerInning pointsPerInning = GameReportsFactory.eINSTANCE.createPointsPerInning();
		generalStats.getPointsPerInning().add(pointsPerInning);
		return pointsPerInning;
	}

	/**
	 * Create a player in the team statistic EMF element.
	 * 
	 * @param teamStats reference on the team statistic EMF object (owner of the create object)
	 * 
	 * @return Player EMF object created.
	 */
	public Player createPlayer(TeamStatisitics teamStats) {

		Player player = GameReportsFactory.eINSTANCE.createPlayer();
		teamStats.getPlayers().add(player );
		
		return player;
	}

	/**
	 * Create  statistic EMF container for a pitcher. 
	 * 
	 * @param playerDescription reference on the player (Owner of the created object)
	 * 
	 * @return statistic EMF container for a pitcher 
	 */
	public PitcherStatistic createPitcherStats(Player playerDescription) {
		PitcherStatistic pitcherStats = GameReportsFactory.eINSTANCE.createPitcherStatistic();
		playerDescription.setPitcherStatistic(pitcherStats);
		
		pitcherStats.setAtBats(0);
		pitcherStats.setBalks(0);
		pitcherStats.setBaseOnBall(0);
		pitcherStats.setBatterFront(0);
		pitcherStats.setCaughtStealing(0);
		pitcherStats.setDouble(0);
		pitcherStats.setEarnedRuns(0);
		pitcherStats.setHitByPitch(0);
		pitcherStats.setHits(0);
		pitcherStats.setHomerun(0);
		pitcherStats.setIntentionalbaseOnBall(0);
		pitcherStats.setInterferanceObstruction(0);
		pitcherStats.setPitchCount(0);
		pitcherStats.setPitchCountB(0);
		pitcherStats.setPitchCountK(0);
		pitcherStats.setPitchCountOthers(0);
		pitcherStats.setRunnerLeftOnBase(0);
		pitcherStats.setRuns(0);
		pitcherStats.setSacrificeFly(0);
		pitcherStats.setSacrificeHit(0);
		pitcherStats.setStrikeOut(0);
		pitcherStats.setTriple(0);
		pitcherStats.setWildPitches(0);
		
		return pitcherStats;
	}

	/**
	 * Create statistic EMF container for a defender. 
	 * 
	 * @param playerDescription reference on the player (Owner of the created object)
	 * 
	 * @return statistic EMF container for a defender 
	 */
	public DefensiveStatistic createDefensiveStats(Player playerDescription) {
		DefensiveStatistic defensiveStatistic = GameReportsFactory.eINSTANCE.createDefensiveStatistic();
		playerDescription.setDefensiveStatistic(defensiveStatistic);
		
		defensiveStatistic.setAssitances(0);
		defensiveStatistic.setDoublePlay(0);
		defensiveStatistic.setErrors(0);
		defensiveStatistic.setPutOut(0);
		
		return defensiveStatistic;
	}

	/**
	 * Create statistic EMF container for a catcher. 
	 * 
	 * @param playerDescription reference on the player (Owner of the created object)
	 * 
	 * @return statistic EMF container for a catcher 
	 */
	public CatcherStatistic createCatcherStats(Player playerDescription) {
		CatcherStatistic catcherStats = GameReportsFactory.eINSTANCE.createCatcherStatistic();
		playerDescription.setCatchersStatistic(catcherStats);
		
		catcherStats.setCaughtStealing(0);
		catcherStats.setPassBall(0);
		catcherStats.setStolenBase(0);
		
		return catcherStats;
	}

	/**
	 * Create statistic EMF container for an offensive player. 
	 * 
	 * @param playerDescription reference on the player (Owner of the created object)
	 * 
	 * @return statistic EMF container for an offensive player 
	 */
	public OffensiveStatistic createOffensiveStats(Player playerDescription) {
		OffensiveStatistic offensiveStats = GameReportsFactory.eINSTANCE.createOffensiveStatistic();
		playerDescription.setOffensiveStatistic(offensiveStats);
		
		offensiveStats.setAtBats(0);
		offensiveStats.setBaseOnBall(0);
		offensiveStats.setCaughtStealing(0);
		offensiveStats.setDouble(0);
		offensiveStats.setGroundedDoublePlay(0);
		offensiveStats.setHitByPitch(0);
		offensiveStats.setHits(0);
		offensiveStats.setHomerun(0);
		offensiveStats.setIntentionalbaseOnBall(0);
		offensiveStats.setInterferanceObstruction(0);
		offensiveStats.setPlateAppearances(0);
		offensiveStats.setRbi(0);
		offensiveStats.setRuns(0);
		offensiveStats.setSacrificeFly(0);
		offensiveStats.setSacrificeHit(0);
		offensiveStats.setStolenBase(0);
		offensiveStats.setStrikeOut(0);
		offensiveStats.setTriple(0);
		
		return offensiveStats;
	}

	/**
	 * Create a play by play container for a game report EMF data structure.
	 * 
	 * @param gameReport reference on the game report element (Owner of the play by play element)
	 * 
	 * @return play by play container 
	 */
	public PlayByPlay createPlayByPlayContainer(GameReport gameReport) {
		PlayByPlay playByPlay = GameReportsFactory.eINSTANCE.createPlayByPlay();
		gameReport.setPlayByPlay(playByPlay);
		return playByPlay;
	}

	/**
	 * Create an action in the play by play container
	 * 
	 * @param playByPlay reference on the play by play element (Owner of the action element)
	 * 
	 * @return action container
	 */
	public ActionDescription createActionDescription(PlayByPlay playByPlay) {
		ActionDescription actionDescription = GameReportsFactory.eINSTANCE.createActionDescription();
		playByPlay.getActiondescription().add(actionDescription);
		return actionDescription;
	}

	/**
	 * Save the EMF game report data structure in an XML file
	 * 
	 * @param gameReport reference on the Game report EMF data structure
	 * @param fileName Name of the XML file
	 * @param xsltFileName path of the XSLT file
	 */
	public void saveFile(GameReport gameReport, String fileName, String xsltFileName) {
		Map<String, Object> options = new HashMap<>();
		options.put("ENCODING", "UTF-8"); //$NON-NLS-1$
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);

		try (
				BufferedReader reader = new BufferedReader(new FileReader(fileName));	
		        FileWriter writer = new FileWriter(fileName);
		){
			OutputStream outStream = new FileOutputStream(new File(fileName));
			gameReport.eResource().save(outStream, options);
			outStream.close();
			
	        /* add stylesheet information */
	        ArrayList<String> lines = new ArrayList<>();
	        String readLine = reader.readLine();
	        while (readLine != null)
	        {
	            lines.add(readLine);
	            readLine = reader.readLine();
	        }
	        lines.add(1, "<?xml-stylesheet href=\""+ xsltFileName +"\" type=\"text/xsl\"?>"); //$NON-NLS-1$ //$NON-NLS-2$
	        for (String line : lines)
	        {
	            writer.write(line + "\r\n"); //$NON-NLS-1$
	        }

		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
