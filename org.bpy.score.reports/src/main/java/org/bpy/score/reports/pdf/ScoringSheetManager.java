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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.GameStatisticContainer;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.*;
import org.bpy.score.graphics.PlayerSquareManager;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class generate the PDF score sheet file.
 *
 * @author Patrick BRIAND
 *
 */
public class ScoringSheetManager extends ScoringSheetGraphicalManager {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoringSheetManager.class.getSimpleName());

	/** Reference to the PDF document */
	private Document document;
	/** Reference to the PDF writer */
	private PdfWriter writer;

	/**
	 * Constructor of the class.
	 */
	public ScoringSheetManager() {
		super();
	}

	@Override
	public void setNbBatters(int nbBatters) {
		this.nbBatters = nbBatters;
	}


	/**
	 * Create the document.
	 * 
	 * @param game Reference on the game parsing result
	 * @param path Where to generate the PDF file
	 */
	public void createDocument(Game game, String path) {
		/* Forma A4 : ==> 842 *595 ratio = 2.83 */

		visitorLineup = new LineupManager();
		hometeamLineup = new LineupManager();
		playerSquareManagers = new HashMap<String, PlayerSquareManager>();

		document = new Document(PageSize.A4.rotate());

		playerSquareManagers.put(EngineConstants.HOMETEAM, new PlayerSquareManager());
		playerSquareManagers.get(EngineConstants.HOMETEAM).addChangeRowListener(this::updateGraphicForNewRow);

		playerSquareManagers.put(EngineConstants.VISITOR, new PlayerSquareManager());
		playerSquareManagers.get(EngineConstants.VISITOR).addChangeRowListener(this::updateGraphicForNewRow);

		try {
			if (game != null) {
				writer = PdfWriter.getInstance(document, new FileOutputStream(path + "/" + game.getName() + ".pdf")); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				writer = PdfWriter.getInstance(document, new FileOutputStream(path + "/FFBS_ScoreSheet_Modele.pdf")); //$NON-NLS-1$
			}
			document.open();

		} catch (DocumentException|FileNotFoundException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}

	/**
	 * Fill the visitor sheet with the game parsing result.
	 * 
	 * @param game Reference on the game parsing result
	 * @param statistiqueEngine Reference on the statistic engine
	 */
	@SuppressWarnings("deprecation")
	public void fillVisitorSheet(Game game, StatisticEngine statistiqueEngine) {

		caugthStealingForPitchers = new ArrayList<>();
		this.statistiqueEngine = statistiqueEngine;
		kCounter = 0;
		bbCounter = 0;
		hpCounter = 0;

		if (game != null) {

			/* Creation de la page visiteur */
			sheetTeam = EngineConstants.VISITOR;
			PdfContentByte cb = writer.getDirectContent();
			g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
			createEmptyVisitorPage();
			fillHeaderVisitorPage(game);

			LineupManager lineup = statistiqueEngine.getActionsManager().getVisitorLineup();

			fillLineupPart(lineup);
			fillGeneralScore(statistiqueEngine);

			StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
			GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
			GameStatisticContainer container = statistiqueManager.getStatisticContainer();

			TeamStatistic visitorStats = container.getVisitorStatistic(stats);
			TeamStatistic oppositStats = container.getHomeTeamStatistic(stats);
			fillTeamStatistics(visitorStats, lineup);
			fillControlPart(visitorStats, oppositStats);

			fillPitcherCaugthStealingIfNecessary();

		} else {

			/* Creation de la page visiteur */
			PdfContentByte cb = writer.getDirectContent();
			g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
			createEmptyVisitorPage();
		}
	}

	/**
	 * Fill the visitor sheet for specific cases (Forfeit game for example)
	 * 
	 * @param game Reference on the game parsing result
	 * @param rootCause Specific cause
	 */
	@SuppressWarnings("deprecation")
	public void fillSpecialVisitorSheet(Game game, String rootCause) {

		sheetTeam = EngineConstants.VISITOR;
		PdfContentByte cb = writer.getDirectContent();
		g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
		createEmptyVisitorPage();
		fillHeaderVisitorPage(game);

		if (game.getForfeitGame() != null) {

			setWaterMarked(rootCause + " " + game.getForfeitGame().getTeam().toUpperCase());

			if (game.getForfeitGame().getTeam().equals(EngineConstants.HOMETEAM)) {
				setGeneralScore(9, 0);
			} else {
				setGeneralScore(0, 9);
			}
		}

		releaseGraphicalContext();

	}

	/**
	 * Fill the home team sheet with the game parsing result.
	 * 
	 * @param game Reference on the game parsing result
	 * @param statistiqueEngine Reference on the statistic engine
	 */
	@SuppressWarnings("deprecation")
	public void fillHometeamSheet(Game game, StatisticEngine statistiqueEngine) {
		caugthStealingForPitchers = new ArrayList<>();

		this.statistiqueEngine = statistiqueEngine;
		kCounter = 0;
		bbCounter = 0;
		hpCounter = 0;

		if (game != null) {

			sheetTeam = EngineConstants.HOMETEAM;
			PdfContentByte cb = writer.getDirectContent();
			g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
			createEmptyHomeTeamPage();
			fillHeaderHomeTeamPage(game);

			LineupManager lineup = statistiqueEngine.getActionsManager().getHometeamLineup();

			fillLineupPart(lineup);

			StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
			GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
			GameStatisticContainer container = statistiqueManager.getStatisticContainer();

			TeamStatistic hometeamStats = container.getHomeTeamStatistic(stats);
			TeamStatistic oppositStats = container.getVisitorStatistic(stats);

			fillTeamStatistics(hometeamStats, lineup);
			fillControlPart(hometeamStats, oppositStats);

			fillPitcherCaugthStealingIfNecessary();

		} else {

			/* Creation de la page hometeam */
			PdfContentByte cb = writer.getDirectContent();
			g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
			createEmptyHomeTeamPage();

		}
	}

	/**
	 * Fill the home team sheet for specific cases (Forfeit game for example)
	 * 
	 * @param game Reference on the game parsing result
	 * @param rootCause Specific cause
	 */
	@SuppressWarnings("deprecation")
	public void fillSpecialHometeamSheet(Game game, String rootCause) {

		sheetTeam = EngineConstants.HOMETEAM;
		PdfContentByte cb = writer.getDirectContent();
		g2 = cb.createGraphics(PageSize.A4.getHeight(), PageSize.A4.getWidth());
		createEmptyHomeTeamPage();
		fillHeaderHomeTeamPage(game);

		setWaterMarked(rootCause + " " + game.getForfeitGame().getTeam().toUpperCase());

		releaseGraphicalContext();
	}

	/**
	 * Draw a water marked on the score sheet.
	 * 
	 * @param rootCause String write in the water marked
	 */
	private void setWaterMarked(String rootCause) {
		com.itextpdf.text.Font f = new com.itextpdf.text.Font(FontFamily.HELVETICA, 60);
		Phrase p = new Phrase(rootCause, f);

		PdfGState gs1 = new PdfGState();
		gs1.setFillOpacity(0.5f);

		PdfContentByte cb = writer.getDirectContent();
		com.itextpdf.text.Rectangle pageSize = writer.getPageSize();
		float x = (pageSize.getLeft() + pageSize.getRight()) / 2;
		float y = (pageSize.getTop() + pageSize.getBottom()) / 2;

		cb.saveState();
		cb.setGState(gs1);
		ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, p, x, y, 0);
		cb.restoreState();
	}

	@Override
	public void createNewPage() {
		document.newPage();
	}

	@Override
	public void releaseGraphicalContext() {
		g2.dispose();
	}

	@Override
	public void closeDocument() {
		document.close();
	}

}
