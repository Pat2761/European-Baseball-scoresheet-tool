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
package org.bpy.score.reports.pdf;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;

/**
 * Factory for create Score sheet PDF files
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreSheetFactory {

	/** 
	 * Constructor of the class.
	 */
	public ScoreSheetFactory() {
		// Nothing to do
	}

	/**
	 * Create score sheet for a game file.
	 * 
	 * @param game reference to the game parsing result
	 * @param generationPath Where to generate the file
	 * 
	 * @return name of the PDF file
	 */
	public String run(Game game, String generationPath) {

		/* needs stats for file the sheets */
		StatisticEngine statisticEngine = new StatisticEngine();
		statisticEngine.setGame(game);
		statisticEngine.setActionsManager(new StatisticManager());
		statisticEngine.run();

		/* fill sheet */
		ScoreSheetEngine scoreSheetEngine = new ScoreSheetEngine();
		scoreSheetEngine.setGame(game);
		scoreSheetEngine.setActionsManager(new ScoringSheetManager());
		scoreSheetEngine.setPath(generationPath);
		scoreSheetEngine.setStatisticEngine(statisticEngine);
		scoreSheetEngine.run();

		return game.getName() + ".pdf"; //$NON-NLS-1$
	}

	/**
	 * Create empties score sheets files  
	 */
	public void emptyFile() {
		ScoreSheetEngine scoreSheetEngine = new ScoreSheetEngine();
		scoreSheetEngine.setActionsManager(new ScoringSheetManager());
		scoreSheetEngine.emptyFile();
	}
}
