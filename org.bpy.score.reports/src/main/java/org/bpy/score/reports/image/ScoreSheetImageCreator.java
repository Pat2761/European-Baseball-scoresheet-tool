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
package org.bpy.score.reports.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Game;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;

/**
 * This cleas create image file of a score sheet.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreSheetImageCreator {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoreSheetImageCreator.class.getSimpleName());

	/** Zoom value */
	private double zoomValue = 3.0;
	/** Score sheet manager reference */ 
	private static ScoringSheetGraphicalManager scoringSheetGraphicalManager = new ScoringSheetGraphicalManager();

	/**
	 * Constructor of the class.
	 */
	public ScoreSheetImageCreator() {
		// Nothing to do
	}

	/**
	 * Create a JPEG file from the score sheet of a team.
	 * 
	 * @param team Team name (visitor or hometeam)
	 * @param game Reference on the Game file parsing result
	 * @param outputFolder Where to generate
	 * 
	 * @return Generated full path name of the JPG file
	 */
	public String buildJpgFile(String team, Game game, String outputFolder) {
		if ( game != null) {
			int width = (int) (ScoringSheetGraphicalManager.getBounds().width * zoomValue);
			int heigth = (int) (ScoringSheetGraphicalManager.getBounds().height * zoomValue);
	
			BufferedImage bImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bImage.createGraphics();
	
			g2.scale(zoomValue, zoomValue);
	
			g2.setBackground(Color.WHITE);
			g2.fillRect(0, 0, width, heigth);
	
			StatisticEngine statisticEngine = new StatisticEngine();
			statisticEngine.setGame(game);
			statisticEngine.setActionsManager(new StatisticManager());
			statisticEngine.run();
	
			ScoreViewEngine scoreViewEngine = new ScoreViewEngine();
			scoreViewEngine.setGame(game);
			scoreViewEngine.setActionsManager(scoringSheetGraphicalManager);
			scoreViewEngine.setStatisticEngine(statisticEngine);
			scoreViewEngine.setCurrentTeam(team);
	
			scoreViewEngine.setG2(g2);
			scoreViewEngine.run();

			if (team.equals(EngineConstants.HOMETEAM)) {
				scoringSheetGraphicalManager.fillHometeamSheet( g2, game, statisticEngine);
			} else {
				scoringSheetGraphicalManager.fillVisitorSheet( g2, game, statisticEngine);
			}
	
			try {
				ImageIO.write(bImage, "jpg",
						new File(outputFolder + "/" + game.getName() + "_" + team + "_scoreSheet.jpg"));
				return "./img/" + game.getName() + "_" + team + "_scoreSheet.jpg";
			} catch (IOException e) {
				logger.log(Level.SEVERE,e.getMessage());
			}
		}
		return null;
	}
}
