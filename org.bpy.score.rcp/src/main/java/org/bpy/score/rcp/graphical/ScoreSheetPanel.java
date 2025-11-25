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
package org.bpy.score.rcp.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Game;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;

/**
 * This class is the panel for the editor og Game
 * 
 * @author Patrick BRIND
 *
 */
@SuppressWarnings("java:S1948")
public class ScoreSheetPanel extends JPanel implements MouseWheelListener {

	/** Serial ID of the panel */
	private static final long serialVersionUID = -7175734418844668013L;
	/** Reference to the Graphical manager */
	private ScoringSheetGraphicalManager scoringSheetGraphicalManager = new ScoringSheetGraphicalManager();
	/** Zoom value */
	private double zoomValue = 2;
	/** Reference to the game parsing result */
	private Game game;
	/** Reference to statistic engine */
	private StatisticEngine statisticEngine;
	/** Reference to the score view engine */
	private ScoreViewEngine scoreViewEngine;
	/** Current team edited */
	private String currentTeam;

	/**
	 * Constructor of the class.
	 * Initialization purpose.
	 * 
	 * @param currentTeam Current team edited
	 */
	public ScoreSheetPanel(String currentTeam) {
		setBackground(Color.WHITE);

		int width = (int) (ScoringSheetGraphicalManager.getBounds().width * zoomValue);
		int heigth = (int) (ScoringSheetGraphicalManager.getBounds().height * zoomValue);

		this.currentTeam = currentTeam;
		setPreferredSize(new Dimension(width, heigth));
		addMouseWheelListener(this);
	}

	/**
	 * Update view when the editor changed
	 * 
	 * @param game  Reference to the game parsing result
	 * @param scoreViewEngine Reference to the score view engine
	 * @param statisticEngine Reference to statistic engine
	 */
	public void updateView(Game game, ScoreViewEngine scoreViewEngine, StatisticEngine statisticEngine) {
		this.game = game;
		this.statisticEngine = statisticEngine;
		scoreViewEngine.setCurrentTeam(currentTeam);
		this.scoreViewEngine = scoreViewEngine;
		scoreViewEngine.setActionsManager(scoringSheetGraphicalManager);
		updateUI();
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		AffineTransform affT = g2D.getTransform();
		g2D.scale(zoomValue, zoomValue);
		super.paint(g);
		g2D.setTransform(affT);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (game != null && scoreViewEngine != null) {

			scoreViewEngine.setG2((Graphics2D) g);
			scoreViewEngine.run();

		} else {
			if (currentTeam.equals(EngineConstants.HOMETEAM)) {
				scoringSheetGraphicalManager.fillHometeamSheet((Graphics2D) g, game, statisticEngine);
			} else {
				scoringSheetGraphicalManager.fillVisitorSheet((Graphics2D) g, game, statisticEngine);
			}
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int count = e.getWheelRotation();
		if (e.isControlDown()) {
			zoomValue += (double) count / 50.0;

			int width = (int) (ScoringSheetGraphicalManager.getBounds().width * zoomValue);
			int heigth = (int) (ScoringSheetGraphicalManager.getBounds().height * zoomValue);
			setPreferredSize(new Dimension(width, heigth));

			repaint();
		}
	}
}
