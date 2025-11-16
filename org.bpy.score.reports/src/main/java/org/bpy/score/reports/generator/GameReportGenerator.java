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

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bpy.score.club.club.Club;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.engine.manager.lineup.LineupManager;
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
import org.bpy.score.game.ui.internal.GameActivator;
import org.bpy.score.internationalization.reports.Messages;
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
import org.bpy.score.reports.generator.playbyplay.PlayByPlayContainer;
import org.bpy.score.reports.generator.playbyplay.PlayByPlayEngine;
import org.bpy.score.reports.generator.playbyplay.PlayByPlayManager;
import org.bpy.score.reports.image.BaseballFieldOccupation;
import org.bpy.score.reports.image.ScoreSheetImageCreator;
import org.bpy.score.reports.pdf.ScoreSheetFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import com.google.inject.Injector;

/**
 * 
 * Allow to create a report on a match.
 * 
 * @author BRIAND Patrick 
 * 
 */
public class GameReportGenerator extends AbstractReportGenerator {

	/** Segment separator */
	public static final String SEGMENT_SEPARATOR = "/"; //$NON-NLS-1$
	
	/** Standard configuration flag key */
	public static final String STANDARD_CONFIGURATION_FLAG = "standardConfigurationFlag"; //$NON-NLS-1$
	/** CSS file path key */
	public static final String CSS_FILE_PATH = "cssFilePath"; //$NON-NLS-1$
	/** XSLT File path key */
	public static final String XSLT_FILE_PATH = "xsltFilePath"; //$NON-NLS-1$
	/** BANNER File path key */
	public static final String BANNER_FILE_PATH = "bannerFilePath"; //$NON-NLS-1$
	
	/** Display regular expression key */
	public static final String DISPLAY_REGULAR_EXPRESSION_KEY = "display_regular_expression_key"; //$NON-NLS-1$
	/** Selection regular expression key */
	public static final String SELECTION_REGULAR_EXPRESSION_KEY = "selection_regular_expression_key"; //$NON-NLS-1$
	/** Output folder path key */
	public static final String OUTPUT_FOLDER_KEY = "output_folder_key"; //$NON-NLS-1$
	
	/** Injector on the Game parser */
	private static final Injector injector = GameActivator.getInstance().getInjector("org.bpy.score.game.Game"); //$NON-NLS-1$

	/** Reference on the EMF data base which contains the description of the report */
	private GameReportContainer gameReportContainer;

	/** Reference on the global statistic container */
	private GlobalStatisticContainer globalStatisticContainer;

	/**
	 * Constructor of the class.
	 */
	public GameReportGenerator() {
		super();
	}

	/**
	 * Main entry point for generate an XML file which contains the report description of the game.
	 * 
	 * @param selectedGames List of report to generate
	 * @param options options for the generation of the report (or HTML file)
	 */
	public void generateReport(List<IFile> selectedGames, Map<String, Object> options) {
		
		globalStatisticContainer = new GlobalStatisticContainer();
		gameReportContainer = new GameReportContainer();
		
		ClubDataParser clubDataParser = new ClubDataParser();
		clubDataParser.parseData((IFolder)selectedGames.get(0).getParent().getParent());
		List<Club> clubs = clubDataParser.getClubs();

		String path = (String) options.get(OUTPUT_FOLDER_KEY);
		
		if (createFolder(path)) {
			
			HashMap<Date,List<Game>> sortedByDateGame = sortByDate(selectedGames);

			Job job = new Job(Messages.GameReportGenerator_JobReportGeneration) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					
					monitor.beginTask(Messages.GameReportGenerator_ReportsGeneration, selectedGames.size());
					int i=1;
					
					List<Date> sortedDates = new ArrayList<>(sortedByDateGame.keySet());
					Collections.sort(sortedDates);
					
					for (Date sortedDate : sortedDates) {
						List<Game> games = sortedByDateGame.get(sortedDate);
						
						for (Game game : games) {
							String gameName = game.getName();
							monitor.subTask(NLS.bind(Messages.GameReportGenerator_ReportGeneration, gameName));
							monitor.worked(i++);
							
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
	
							createGeneralStats(game, gameReport,statisticEngine.getStatisticManager());
	
							if (game.getActions() != null && game.getActions().getLineup() != null) {
	
								createStartingLineUp(game, gameReport, game.getActions().getLineup(), path + "/img"); //$NON-NLS-1$
								createTeamDescription(game, EngineConstants.HOMETEAM, gameReport, clubs, statisticEngine.getStatisticManager().getHometeamLineup(), statisticEngine.getStatisticManager().getStats().getHometeam());
								createTeamDescription(game, EngineConstants.VISITOR,  gameReport, clubs, statisticEngine.getStatisticManager().getVisitorLineup(), statisticEngine.getStatisticManager().getStats().getVisitor());
								createPlayByPlay(game, gameReport,statisticEngine);
							}	
							
							gameReportContainer.saveFile(gameReport, path + SEGMENT_SEPARATOR + gameName + ".xml", "GameReport.xsl"); //$NON-NLS-1$ //$NON-NLS-2$

						}
					}
					
					return Status.OK_STATUS;
				}
			};
			job.schedule();
			
			
		} else {
			MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_ERROR | SWT.ABORT);
			messageBox.setText(Messages.GameReportGenerator_JobReportGeneration);
			messageBox.setMessage(Messages.GameReportGenerator_ErrorReportGeneration);
			messageBox.open();
		}
	}

	/**
	 * Get a list of game sorted by date
	 * 
	 * @param selectedGames A list of selected game
	 * @return A list of sorted game by date
	 */
	private HashMap<Date, List<Game>> sortByDate(List<IFile> selectedGames) {
		HashMap<Date,List<Game>> sortedByDateGame = new HashMap<>();
		
		for (IFile selectedGame : selectedGames) {
			
			XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(selectedGame.getProject());
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			Resource resource = resourceSet.getResource(URI.createURI(selectedGame.getLocationURI().toString()),true);
			Game game = (Game) resource.getContents().get(0);

			String dateTime = game.getDescription().getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			Date gameDate = null;
			try {
				gameDate = dateFormat.parse(dateTime);
			} catch (ParseException e) {
				gameDate = new Date(System.currentTimeMillis());
			}
			
			List<Game> games = sortedByDateGame.get(gameDate);
			if (games == null) {
				games = new ArrayList<>();
				sortedByDateGame.put(gameDate, games);
			}
			games.add(game);
		}

		return sortedByDateGame;
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
				newPlayer.setOffensivePosition(offensivePosition++);
			}
			
			BaseballFieldOccupation baseballFieldOccupation = new BaseballFieldOccupation();
			baseballFieldOccupation.placePlayers(startingLineup);
			String fileName = imagePath + SEGMENT_SEPARATOR + game.getName() + "_" + lineup.getTeamType() + ".jpg"; //$NON-NLS-1$
			baseballFieldOccupation.saveImage(fileName);
			startingLineup.setFieldPictrureLink(fileName);
		}
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
			generalStats.setHometeamErrors(lastInning.getErrors());
			generalStats.setHometeamHits(lastInning.getHits());
			generalStats.setHometeamRuns(lastInning.getRuns());
			
			if (!visitorStats.getGeneralInningStats().isEmpty()) {
				lastInning = visitorStats.getGeneralInningStats().get(visitorStats.getGeneralInningStats().size()-1).getCumulativeInningStat();
				generalStats.setVisitorErrors(lastInning.getErrors());
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
		return "";
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
		}
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
	 * Create folders which contains pdf and jpg files
	 *  
	 * @param path where to create folders
	 * @return <b>true</b> folders are created, <b>false</b> otherwise
	 */
	private boolean createFolder(String path) {
		File pdfFolder = new File(path + "/pdf"); //$NON-NLS-1$
		File imgFolder = new File(path + "/img"); //$NON-NLS-1$

		if (!pdfFolder.exists()) {
			pdfFolder.mkdir();
		} else {
			if (pdfFolder.isFile()) {
				return false;
			}
		}

		if (!imgFolder.exists()) {
			imgFolder.mkdir();
		} else {
			if (imgFolder.isFile()) {
				return false;
			}
		}
		return true;
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
}
