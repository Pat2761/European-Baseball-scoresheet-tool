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
package org.bpy.score.reports.generator.processtask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bpy.score.club.club.Club;
import org.bpy.score.engine.manager.IpCounter;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.GlobalStatisticContainer;
import org.bpy.score.engine.stats.emf.globalstatistics.TeamStatistics;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Description;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.LineUp;
import org.bpy.score.game.game.LineUpEntry;
import org.bpy.score.graphics.ui.DataProcessContainer;
import org.bpy.score.reports.gamereports.ActionDescription;
import org.bpy.score.reports.gamereports.CatcherStatistic;
import org.bpy.score.reports.gamereports.DefensiveStatistic;
import org.bpy.score.reports.gamereports.GameGeneralStats;
import org.bpy.score.reports.gamereports.GameReport;
import org.bpy.score.reports.gamereports.LineupPlayer;
import org.bpy.score.reports.gamereports.OffensiveStatistic;
import org.bpy.score.reports.gamereports.PitcherStatistic;
import org.bpy.score.reports.gamereports.PlayByPlay;
import org.bpy.score.reports.gamereports.Player;
import org.bpy.score.reports.gamereports.PointsPerInning;
import org.bpy.score.reports.gamereports.StartingLineup;
import org.bpy.score.reports.gamereports.TeamStatisitics;
import org.bpy.score.reports.generator.GameReportContainer;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.bpy.score.reports.generator.playbyplay.PlayByPlayContainer;
import org.bpy.score.reports.generator.playbyplay.PlayByPlayEngine;
import org.bpy.score.reports.generator.playbyplay.PlayByPlayManager;
import org.bpy.score.reports.image.BaseballFieldOccupation;
import org.bpy.score.reports.image.ScoreSheetImageCreator;
import org.bpy.score.reports.pdf.ScoreSheetFactory;
import org.eclipse.emf.common.util.EList;

/**
 * Create a task description for generate an XML description of a game
 * 
 * @author Patrick BRIAND
 *
 */
public class CreateXmlGameDescription extends DataProcessContainer {
    
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(CreateXmlGameDescription.class.getCanonicalName());

	/** Segment separator */
	public static final String SEGMENT_SEPARATOR = "/"; //$NON-NLS-1$

	/** reference  to the game report container */
	private GameReportContainer gameReportContainer;
	/** Reference to the global statistic container */
	private GlobalStatisticContainer globalStatisticContainer;
	/** Generation path */
	private String path;
    /** List of clubs */
	private List<Club> clubs;

	/**
	 * Constructor of the class.
	 * 
	 * @param message message to display while the execution is done
	 * @param dataToProcess object use for the execution
	 */
	public CreateXmlGameDescription(String message, Object dataToProcess) {
		super(message, dataToProcess);
	}

	@Override
	public void executeTask() {
		
		GameReportGeneratorProcessData data = (GameReportGeneratorProcessData)getDataToProcess();
		gameReportContainer = data.getGameReportContainer();
		globalStatisticContainer = data.getGlobalStatisticContainer();
		path = data.getPath();
		clubs = data.getClubs();
		Game game = data.getGame();
		
		String gameName = game.getName();
		logger.log(Level.INFO, "Generate report for the game {0}", game.getName()); //$NON-NLS-1$ 
		
		// D1B0147
		GameReport gameReport = gameReportContainer.createNewGameReport(gameName + ".gamereports"); //$NON-NLS-1$

		/* needs stats for file the sheets */
		StatisticEngine statisticEngine = new StatisticEngine();
		statisticEngine.setGame(game);
		statisticEngine.setActionsManager(new StatisticManager());
		statisticEngine.run();
		
		globalStatisticContainer.updateWithGameStatistics(game, statisticEngine.getStatisticManager());
		
		setGeneralInformation(game, gameReport);
		
		createPdfFile(game, path + "/pdf",gameReport); //$NON-NLS-1$
		createImageFiles(game, path + "/img", gameReport); //$NON-NLS-1$

		createGeneralStats(game, gameReport, statisticEngine.getStatisticManager());
		
		if (game.getActions() != null && game.getActions().getLineup() != null) {

			createStartingLineUp(game, gameReport, game.getActions().getLineup(), path + "/img"); //$NON-NLS-1$
			createTeamDescription(game, EngineConstants.HOMETEAM, gameReport, clubs, statisticEngine.getStatisticManager().getHometeamLineup(), statisticEngine.getStatisticManager().getStats().getHometeam());
			createTeamDescription(game, EngineConstants.VISITOR,  gameReport, clubs, statisticEngine.getStatisticManager().getVisitorLineup(), statisticEngine.getStatisticManager().getStats().getVisitor());
			createPlayByPlay(game, gameReport,statisticEngine);
		}	
		
		File tmpFile = gameReportContainer.saveFile(gameReport, path + SEGMENT_SEPARATOR + gameName + ".xml"); //$NON-NLS-1$ //$NON-NLS-2$
		gameReportContainer.setXsltReference(tmpFile, path + SEGMENT_SEPARATOR + gameName + ".xml", "GameReport.xsl");//$NON-NLS-1$ //$NON-NLS-2$
		
		Boolean isHtmlFile = (Boolean) data.getOptions().get(GameReportGenerator.HTML_GENERATION);
		if (isHtmlFile.booleanValue()) {
			translateToHtml(path + SEGMENT_SEPARATOR + gameName + ".xml", path + SEGMENT_SEPARATOR + "GameReport.xsl", path + SEGMENT_SEPARATOR + gameName + ".html" );//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}	
	}

	private void translateToHtml(String xmlFile, String xslFile, String targetFile) {
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
            Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(targetFile));
            Files.delete(Paths.get(xmlFile));
        } catch (TransformerException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * fill the general information of the game in the EMF data structure of the report
	 * 
	 * @param game reference on the game parsing result
	 * @param gameReport reference on the entry point of the EMF data structure
	 */
	private void setGeneralInformation(Game game, GameReport gameReport) {
		Description gameDescription = game.getDescription();
		gameReport.setDate(gameDescription.getDate());
		gameReport.setDuration(gameDescription.getDuration());
		gameReport.setStartingTime(gameDescription.getStartTime());
		gameReport.setGameNumber(game.getName());
		gameReport.setStadium(gameDescription.getStadium());
		gameReport.setTown(gameDescription.getPlace());
		
		for (String umpire : gameDescription.getUmpires().getUmpires() ) {
			gameReport.getUmpires().add(umpire);
		}
		for (String scoreKeeper : gameDescription.getScorekeepers().getScorekeepers()) {
			gameReport.getScorekeepers().add(scoreKeeper);
		}
	}

	/**
	 * Create PDF file which contains the scoring sheets
	 * 
	 * @param game reference on the game parsing result
	 * @param generationPath where to generate PDF
	 * @param gameReport reference on the entry point of the EMF data structure
	 */
	private void createPdfFile(Game game, String generationPath, GameReport gameReport) {
		ScoreSheetFactory scoreSheetFactory = new ScoreSheetFactory();
		String fileName = scoreSheetFactory.run(game, generationPath);
		gameReport.setPdfFile("./pdf/" + fileName); //$NON-NLS-1$
	}

	/**
	 * create JPG files of the scoring sheets
	 * 
	 * @param game reference on the game parsing result
	 * @param outputFolder where to generate jpg
	 * @param gameReport reference on the entry point of the EMF data structure
	 */
	private void createImageFiles(Game game, String outputFolder, GameReport gameReport) {
		ScoreSheetImageCreator imageCreator = new ScoreSheetImageCreator();
		String fileName = imageCreator.buildJpgFile(EngineConstants.HOMETEAM, game, outputFolder);
		gameReport.setHometeamSheetPath(fileName);
		
		fileName = imageCreator.buildJpgFile(EngineConstants.VISITOR, game, outputFolder);
		gameReport.setVisitorSheetPath(fileName);
	}

	/**
	 * Set the generals statistics (score, hits, errors)  in the EMF data structure of the report.
	 * 
	 * @param game reference on the game parsing result
	 * @param gameReport reference on the entry point of the EMF data structure
	 * @param statisticManager reference on the statistics computed for the current game
	 */
	protected void createGeneralStats(Game game, GameReport gameReport, StatisticManager statisticManager) {
		TeamStatistic hometeamStats = statisticManager.getStats().getHometeam();
		TeamStatistic visitorStats = statisticManager.getStats().getVisitor();

		GameGeneralStats generalStats = gameReportContainer.createGeneralStatistic(gameReport);
		
		if ( (game.getForfeitGame() == null) && !hometeamStats.getGeneralInningStats().isEmpty()) {
		
			InningGeneralStatistic lastInning = hometeamStats.getGeneralInningStats().get(hometeamStats.getGeneralInningStats().size()-1).getCumulativeInningStat();
			generalStats.setVisitorErrors(lastInning.getErrors());
			generalStats.setHometeamHits(lastInning.getHits());
			generalStats.setHometeamRuns(lastInning.getRuns());
			
			if (!visitorStats.getGeneralInningStats().isEmpty()) {
				lastInning = visitorStats.getGeneralInningStats().get(visitorStats.getGeneralInningStats().size()-1).getCumulativeInningStat();
				generalStats.setHometeamErrors(lastInning.getErrors());
				generalStats.setVisitorHits(lastInning.getHits());
				generalStats.setVisitorRuns(lastInning.getRuns());
				
				for (int i=0 ; i<visitorStats.getGeneralInningStats().size(); i++) {
					PointsPerInning pointsPerInning = gameReportContainer.getPointsPerInning(generalStats);
					pointsPerInning.setOrder(i);
	
					InninStatictic visitorInning = visitorStats.getGeneralInningStats().get(i);
					pointsPerInning.setVisitorPoint(visitorInning.getInningStat().getRuns());
					
					if (i<hometeamStats.getGeneralInningStats().size()) {
						InninStatictic hometeamInning = hometeamStats.getGeneralInningStats().get(i);
						pointsPerInning.setHometeamPoint(hometeamInning.getInningStat().getRuns());
					} else {
						pointsPerInning.setHometeamPoint(-1);
					}
				}
			}
		}
		
		
	}
	
	/** 
	 * Create the stating line-up description in the EMF data structure of the report
	 * 
	 * @param game reference on the game parsing result
	 * @param gameReport reference on the entry point of the EMF data structure
	 * @param lineups reference on the line-up description in the current game
	 * @param imagePath reference on the path of the image which show the occupation field
	 */
	protected void createStartingLineUp(Game game, GameReport gameReport, EList<LineUp> lineups, String imagePath) {
		for (LineUp lineup : lineups) {
			StartingLineup startingLineup = gameReportContainer.createStartingLineUp(gameReport, lineup.getTeamType());	
			startingLineup.setTeamName(lineup.getTeamType());
			
			int offensivePosition = 1;
			for (LineUpEntry player : lineup.getLineUpEntries()) {
				LineupPlayer newPlayer = gameReportContainer.addPlayerInLineup(startingLineup);
				newPlayer.setName(player.getName());
				newPlayer.setDefensivePosition(player.getDefensivePosition());
				if (offensivePosition<10) {
					newPlayer.setOffensivePosition(offensivePosition++);
				}	
			}
			
			BaseballFieldOccupation baseballFieldOccupation = new BaseballFieldOccupation();
			baseballFieldOccupation.placePlayers(startingLineup);
			String fileName = imagePath + SEGMENT_SEPARATOR + game.getName() + "_" + lineup.getTeamType() + ".jpg"; //$NON-NLS-1$ //$NON-NLS-2$
			baseballFieldOccupation.saveImage(fileName);
			startingLineup.setFieldPictrureLink(fileName);
		}
	}

	/**
	 * Create the play by play EMF content
	 * 
	 * @param game reference on the game parsing result
	 * @param gameReport reference on the entry point of the EMF data structure
	 * @param statisticEngine reference on the statistics engine
	 */
	protected void createPlayByPlay(Game game, GameReport gameReport, StatisticEngine statisticEngine) {
		PlayByPlayManager manager = new PlayByPlayManager();
		PlayByPlayEngine engine = new PlayByPlayEngine();
		
		engine.setActionsManager(manager);
		manager.setStatisticsValues(statisticEngine.getStatisticManager());
		
		engine.runEngine(game);
		
		List<PlayByPlayContainer> actions = engine.getActionDescription();
		
		PlayByPlay playByPlay = gameReportContainer.createPlayByPlayContainer(gameReport);
		
		for (PlayByPlayContainer action : actions) {
			ActionDescription actionDescription = gameReportContainer.createActionDescription(playByPlay);
			actionDescription.setHeader( action.getHeader());
			actionDescription.setContent(action.getContent());
			actionDescription.setResume(action.getResume());
			actionDescription.setTeam(action.getTeam());
		}
	}

	/**
	 * 	create a team description in the EMF data structure of the report.
	 *  this description contains the name, town of the team, and the stats for each player of the team
	 * 
	 * @param game reference on the game parsing result
	 * @param team home team or visitor 
	 * @param gameReport reference on the entry point of the EMF data structure
	 * @param clubs reference on the club description
	 * @param lineupManager final line-up of the team
	 * @param teamStatistic reference on the team statistics
	 */
	protected void createTeamDescription(Game game, String team, GameReport gameReport, List<Club> clubs, LineupManager lineupManager, TeamStatistic teamStatistic) {
		TeamStatisitics teamStats = gameReportContainer.createTeamStatistics();
		
		String city = null;
		if (team.equals(EngineConstants.HOMETEAM)) {
			city = game.getHometeam().getName();
			String clubName = getClubName(clubs, city); 
			teamStats.setTeamName(clubName);
			teamStats.setTown(city);

			gameReport.setHometeamStats(teamStats);
			
		} else {
			city = game.getVisitor().getName();
			String clubName = getClubName(clubs, city); 
			teamStats.setTeamName(clubName);
			teamStats.setTown(city);

			gameReport.setVisitorStats(teamStats);
		}

		TeamStatistics teamContainer = globalStatisticContainer.getTeamContainer(city);
		teamStats.setGameWin(teamContainer.getGameWin());
		teamStats.setGameLose(teamContainer.getGameLose());
		
		HashMap<String,Player> players = new HashMap<>();
		HashMap<Integer,String> playersOrder = new HashMap<>();
		int offensiveIndex = 0;
		if (lineupManager != null && lineupManager.getLineupEntries() != null) {
			for (Entry<String, List<LineupEntry>> entry : lineupManager.getLineupEntries().entrySet()) {
				for (LineupEntry playerEntry : entry.getValue()) {
					String playerName = playerEntry.getPlayerDescription().getName();  
					
					Player playerDescription = players.get(playerName);
					if (playerDescription == null) {
						playerDescription = gameReportContainer.createPlayer(teamStats);
						playerDescription.setName(playerName);
						players.put(playerName, playerDescription);
						playersOrder.put(offensiveIndex, playerName);
						offensiveIndex++;
					}
					
					if (playerEntry.getPitcherStatistic() != null) {
						PitcherStatistic pitcherStats = playerDescription.getPitcherStatistic();
						if (pitcherStats == null) {
							pitcherStats = gameReportContainer.createPitcherStats(playerDescription);
						}
						
						org.bpy.score.engine.stats.emf.statistic.PitcherStatistic playerStat = playerEntry.getPitcherStatistic();
						
						pitcherStats.setAtBats(playerStat.getAtBats() + pitcherStats.getAtBats());
						pitcherStats.setBalks(playerStat.getBalks() + pitcherStats.getBalks());
						pitcherStats.setBaseOnBall(playerStat.getBaseOnBall() + pitcherStats.getBaseOnBall());
						pitcherStats.setBatterFront(playerStat.getBatterFront() + pitcherStats.getBatterFront());
						pitcherStats.setCaughtStealing(playerStat.getCaughtStealing() + pitcherStats.getCaughtStealing());
						pitcherStats.setDouble(playerStat.getDouble() + pitcherStats.getDouble());
						pitcherStats.setEarnedRuns(playerStat.getEarnedRuns() + pitcherStats.getEarnedRuns());
						pitcherStats.setHitByPitch(playerStat.getHitByPitch() + pitcherStats.getHitByPitch());
						pitcherStats.setHits(playerStat.getHits() + pitcherStats.getHits());
						pitcherStats.setHomerun(playerStat.getHomerun() + pitcherStats.getHomerun());
						pitcherStats.setIntentionalbaseOnBall(playerStat.getIntentionalbaseOnBall() + pitcherStats.getIntentionalbaseOnBall());
						pitcherStats.setInterferanceObstruction(playerStat.getInterferanceObstruction() + pitcherStats.getInterferanceObstruction());
						pitcherStats.setPitchCount(playerStat.getPitchCount() + pitcherStats.getPitchCount());
						pitcherStats.setPitchCountB(playerStat.getPitchCountB() + pitcherStats.getPitchCountB());
						pitcherStats.setPitchCountK(playerStat.getPitchCountK() + pitcherStats.getPitchCountK());
						pitcherStats.setPitchCountOthers(playerStat.getPitchCountOthers() + pitcherStats.getPitchCountOthers());
						pitcherStats.setRunnerLeftOnBase(playerStat.getRunnerLeftOnBase() + pitcherStats.getRunnerLeftOnBase());
						pitcherStats.setRuns(playerStat.getRuns() + pitcherStats.getRuns());
						pitcherStats.setSacrificeFly(playerStat.getSacrificeFly() + pitcherStats.getSacrificeFly());
						pitcherStats.setSacrificeHit(playerStat.getSacrificeHit() + pitcherStats.getSacrificeHit());
						pitcherStats.setStrikeOut(playerStat.getStrikeOut() + pitcherStats.getStrikeOut());
						pitcherStats.setTriple(playerStat.getTriple() + pitcherStats.getTriple());
						pitcherStats.setWildPitches(playerStat.getWildPitches() + pitcherStats.getWildPitches());
						pitcherStats.setFlyOuts(playerStat.getFlyOuts() + pitcherStats.getFlyOuts());
						pitcherStats.setGroundedOuts(playerStat.getGroundedOuts() + pitcherStats.getGroundedOuts());
						pitcherStats.setPitcherOrder(getPitcherOrder(playerEntry.getPlayerDescription(), lineupManager.getPitchers()));
						
						IpCounter ipCounter = new IpCounter(playerEntry.getIpPlayed());
						pitcherStats.setIps(ipCounter.getIpCounter(pitcherStats.getIps()));
					}	
					
					if (playerEntry.getDefensiveStatistic() != null) {
						DefensiveStatistic defensiveStats = playerDescription.getDefensiveStatistic();
						if (defensiveStats == null) {
							defensiveStats = gameReportContainer.createDefensiveStats(playerDescription);
						}
						org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic playerStat = playerEntry.getDefensiveStatistic();
						
						defensiveStats.setAssitances(playerStat.getAssitances() + defensiveStats.getAssitances());
						defensiveStats.setDoublePlay(playerStat.getDoublePlay() + defensiveStats.getDoublePlay());
						defensiveStats.setErrors(playerStat.getErrors() + defensiveStats.getErrors());
						defensiveStats.setPutOut(playerStat.getPutOut() + defensiveStats.getPutOut());
					}
					
					if (playerEntry.getCatcherStatistic() != null) {
						CatcherStatistic catcherStats = playerDescription.getCatchersStatistic();
						if (catcherStats == null) {
							catcherStats = gameReportContainer.createCatcherStats(playerDescription);
						}
						
						org.bpy.score.engine.stats.emf.statistic.CatcherStatistic playerStat = playerEntry.getCatcherStatistic();
						
						catcherStats.setCaughtStealing(playerStat.getCaughtStealing() + catcherStats.getCaughtStealing());
						catcherStats.setPassBall(playerStat.getPassBall() + catcherStats.getPassBall());
						catcherStats.setStolenBase(playerStat.getStolenBase() + catcherStats.getStolenBase());
					}
					
					if (playerEntry.getOffensiveStatistic() != null) {
						OffensiveStatistic offensiveStats = playerDescription.getOffensiveStatistic();
						if (offensiveStats == null) {
							offensiveStats = gameReportContainer.createOffensiveStats(playerDescription);
						}
						
						org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic playerStats = playerEntry.getOffensiveStatistic();
						offensiveStats.setAtBats(offensiveStats.getAtBats() + playerStats.getAtBats());
						offensiveStats.setBaseOnBall(offensiveStats.getBaseOnBall() + playerStats.getBaseOnBall());
						offensiveStats.setCaughtStealing(offensiveStats.getCaughtStealing() + playerStats.getCaughtStealing());
						offensiveStats.setDouble(offensiveStats.getDouble() + playerStats.getDouble());
						offensiveStats.setGroundedDoublePlay(offensiveStats.getGroundedDoublePlay() + playerStats.getGroundedDoublePlay());
						offensiveStats.setHitByPitch(offensiveStats.getHitByPitch() + playerStats.getHitByPitch());
						offensiveStats.setHits(offensiveStats.getHits() + playerStats.getHits());
						offensiveStats.setHomerun(offensiveStats.getHomerun() + playerStats.getHomerun());
						offensiveStats.setIntentionalbaseOnBall(offensiveStats.getIntentionalbaseOnBall() + playerStats.getIntentionalbaseOnBall());
						offensiveStats.setInterferanceObstruction(offensiveStats.getInterferanceObstruction() + playerStats.getInterferanceObstruction());
						offensiveStats.setPlateAppearances(offensiveStats.getPlateAppearances() + playerStats.getPlateAppearances());
						offensiveStats.setRbi(offensiveStats.getRbi() + playerStats.getRbi());
						offensiveStats.setRuns(offensiveStats.getRuns() + playerStats.getRuns());
						offensiveStats.setSacrificeFly(offensiveStats.getSacrificeFly() + playerStats.getSacrificeFly());
						offensiveStats.setSacrificeHit(offensiveStats.getSacrificeHit() + playerStats.getSacrificeHit());
						offensiveStats.setStolenBase(offensiveStats.getStolenBase() + playerStats.getStolenBase());
						offensiveStats.setStrikeOut(offensiveStats.getStrikeOut() + playerStats.getStrikeOut());
						offensiveStats.setTriple(offensiveStats.getTriple() + playerStats.getTriple());
					}
				}
			}
		}
		
		/* Exportation dans EMF */
		Set<Integer> keys = playersOrder.keySet();
		List<Integer> keysSorted = new ArrayList<>(keys);
		Collections.sort(keysSorted);
		
		for (Integer key : keysSorted) {
			String playerName = playersOrder.get(key);
			Player playerDescription = players.get(playerName);
			teamStats.getPlayers().add(playerDescription);
		}
	}
	
	private int getPitcherOrder(LineupPlayerDescription playerDescription, List<LineupEntry> pitchers) {
		for (int i=0; i<pitchers.size(); i++) {
			LineupEntry pitcher = pitchers.get(i);
			if (pitcher.getPlayerDescription().getName().equals(playerDescription.getName())) {
				return i+1;
			}
		}
		return -1;
	}

	/**
	 * return the name of the club
	 * 
	 * @param clubs Description of all the clubs
	 * @param city city name
	 * 
	 * @return return the club name
	 */
	private String getClubName(List<Club> clubs, String city) {
		for (Club club : clubs) {
			if (club.getClubDescription().getName().equals(city)) {
				return club.getName();
			}
		}
		return ""; //$NON-NLS-1$
	}

}
