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
package org.bpy.score.rcp.view;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.util.ScoreGameOutUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

/**
 * View which display some general information about the game
 * 
 * @author Patrick BRIAND
 *
 */
public class GeneralDisplayPanelView extends AbstractContextualPanel {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GeneralDisplayPanelView.class.getSimpleName());
	
	/** Id of the view */
	public static final String ID = "org.bpy.score.rcp.view.GeneralDisplayPanelView"; //$NON-NLS-1$
	/** Label font */
	public static final String LABEL_FONT_1 = "@Microsoft YaHei"; //$NON-NLS-1$
	/** Label font */
	public static final String LABEL_FONT_2 = "Arial"; //$NON-NLS-1$
	
	
	/** Strike counter label */
	private Label strikes;
	/** Ball counter label */
	private Label balls;
	/** Visitor name label */
	private Label visitorName;
	/** Home team name label */
	private Label hometeamName;
	/** Visitor point counter label */
	private Label visitorGeneralRun;
	/** Home team point counter label */
	private Label hometeamGeneralRun;
	/** Visitor hit counter label */
	private Label visitorGeneralHit;
	/** Home team hit counter label */
	private Label hometeamGeneralHits;
	/** Visitor error counter label */
	private Label visitorGeneralErrors;
	/** Home team error counter label */
	private Label hometeamGeneralErrors;
	/** Out counter label */
	private Label outCounter;

	/** Label collection for the visitor inning points  */
	private HashMap<Integer, Label> visitorPoints;
	/** Label collection for the home team inning points  */
	private HashMap<Integer, Label> hometemPoints;
	/** Pitch counter */
	private Label pitchesCounter;

	/**
	 * Constructor of the class	 */
	public GeneralDisplayPanelView() {
		super();
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));

		initialiszePanel(container);
		createActions();
		initializeToolBar();
		initializeMenu();

		initializeListener();
	}

	/**
	 * View panel initialization.
	 * 
	 * @param container Parent container
	 */
	private void initialiszePanel(Composite container) {
		visitorName = new Label(container, SWT.NONE);
		visitorName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		visitorName.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		visitorName.setAlignment(SWT.CENTER);
		visitorName.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorName.setBounds(0, 99, 149, 36);
		visitorName.setText("VISITOR"); //$NON-NLS-1$

		hometeamName = new Label(container, SWT.NONE);
		hometeamName.setText("HOMETEAM"); //$NON-NLS-1$
		hometeamName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		hometeamName.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamName.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		hometeamName.setAlignment(SWT.CENTER);
		hometeamName.setBounds(0, 141, 149, 30);

		Label ballsTitle = new Label(container, SWT.NONE);
		ballsTitle.setText("BALL"); //$NON-NLS-1$
		ballsTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		ballsTitle.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		ballsTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		ballsTitle.setBounds(151, 38, 47, 22);

		balls = new Label(container, SWT.BORDER);
		balls.setText("0"); //$NON-NLS-1$
		balls.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		balls.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		balls.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		balls.setAlignment(SWT.CENTER);
		balls.setBounds(213, 31, 27, 29);

		Label strikesLabel = new Label(container, SWT.NONE);
		strikesLabel.setText("STRIKE"); //$NON-NLS-1$
		strikesLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		strikesLabel.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		strikesLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		strikesLabel.setAlignment(SWT.CENTER);
		strikesLabel.setBounds(286, 38, 83, 22);

		strikes = new Label(container, SWT.BORDER);
		strikes.setText("0"); //$NON-NLS-1$
		strikes.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		strikes.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		strikes.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		strikes.setAlignment(SWT.CENTER);
		strikes.setBounds(376, 32, 27, 28);

		Label outs = new Label(container, SWT.NONE);
		outs.setText("OUT"); //$NON-NLS-1$
		outs.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		outs.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		outs.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		outs.setAlignment(SWT.CENTER);
		outs.setBounds(433, 38, 59, 22);

		outCounter = new Label(container, SWT.BORDER);
		outCounter.setText("0"); //$NON-NLS-1$
		outCounter.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		outCounter.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		outCounter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		outCounter.setAlignment(SWT.CENTER);
		outCounter.setBounds(499, 32, 27, 28);

		Label label3 = new Label(container, SWT.NONE);
		label3.setText("1"); //$NON-NLS-1$
		label3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label3.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label3.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label3.setAlignment(SWT.CENTER);
		label3.setBounds(164, 71, 35, 22);

		Label visitorInning1 = new Label(container, SWT.BORDER);
		visitorInning1.setText("0"); //$NON-NLS-1$
		visitorInning1.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning1.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning1.setAlignment(SWT.CENTER);
		visitorInning1.setBounds(165, 99, 34, 36);

		Label hometeamInning1 = new Label(container, SWT.BORDER);
		hometeamInning1.setText("0"); //$NON-NLS-1$
		hometeamInning1.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning1.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning1.setAlignment(SWT.CENTER);
		hometeamInning1.setBounds(165, 140, 34, 31);

		Label label6 = new Label(container, SWT.NONE);
		label6.setText("2"); //$NON-NLS-1$
		label6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label6.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label6.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label6.setAlignment(SWT.CENTER);
		label6.setBounds(205, 71, 35, 22);

		Label visitorInning2 = new Label(container, SWT.BORDER);
		visitorInning2.setText("0"); //$NON-NLS-1$
		visitorInning2.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning2.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning2.setAlignment(SWT.CENTER);
		visitorInning2.setBounds(206, 99, 34, 36);

		Label hometeamInning2 = new Label(container, SWT.BORDER);
		hometeamInning2.setText("0"); //$NON-NLS-1$
		hometeamInning2.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning2.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning2.setAlignment(SWT.CENTER);
		hometeamInning2.setBounds(206, 140, 34, 31);

		Label label9 = new Label(container, SWT.NONE);
		label9.setText("3"); //$NON-NLS-1$
		label9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label9.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label9.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label9.setAlignment(SWT.CENTER);
		label9.setBounds(246, 71, 35, 22);

		Label visitorInning3 = new Label(container, SWT.BORDER);
		visitorInning3.setText("0"); //$NON-NLS-1$
		visitorInning3.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning3.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning3.setAlignment(SWT.CENTER);
		visitorInning3.setBounds(247, 99, 34, 36);

		Label hometeamInning3 = new Label(container, SWT.BORDER);
		hometeamInning3.setText("0"); //$NON-NLS-1$
		hometeamInning3.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning3.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning3.setAlignment(SWT.CENTER);
		hometeamInning3.setBounds(247, 140, 34, 31);

		Label label12 = new Label(container, SWT.NONE);
		label12.setText("4"); //$NON-NLS-1$
		label12.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label12.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label12.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label12.setAlignment(SWT.CENTER);
		label12.setBounds(286, 71, 35, 22);

		Label visitorInning4 = new Label(container, SWT.BORDER);
		visitorInning4.setText("0"); //$NON-NLS-1$
		visitorInning4.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning4.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning4.setAlignment(SWT.CENTER);
		visitorInning4.setBounds(287, 99, 34, 36);

		Label hometeamInning4 = new Label(container, SWT.BORDER);
		hometeamInning4.setText("0"); //$NON-NLS-1$
		hometeamInning4.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning4.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning4.setAlignment(SWT.CENTER);
		hometeamInning4.setBounds(287, 140, 34, 31);

		Label label15 = new Label(container, SWT.NONE);
		label15.setText("5"); //$NON-NLS-1$
		label15.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label15.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label15.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label15.setAlignment(SWT.CENTER);
		label15.setBounds(327, 71, 35, 22);

		Label visitorInning5 = new Label(container, SWT.BORDER);
		visitorInning5.setText("0"); //$NON-NLS-1$
		visitorInning5.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning5.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning5.setAlignment(SWT.CENTER);
		visitorInning5.setBounds(328, 99, 34, 36);

		Label hometeamInning5 = new Label(container, SWT.BORDER);
		hometeamInning5.setText("0"); //$NON-NLS-1$
		hometeamInning5.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning5.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning5.setAlignment(SWT.CENTER);
		hometeamInning5.setBounds(328, 140, 34, 31);

		Label label18 = new Label(container, SWT.NONE);
		label18.setText("6"); //$NON-NLS-1$
		label18.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label18.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label18.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label18.setAlignment(SWT.CENTER);
		label18.setBounds(368, 71, 35, 22);

		Label visitorInning6 = new Label(container, SWT.BORDER);
		visitorInning6.setText("0"); //$NON-NLS-1$
		visitorInning6.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning6.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning6.setAlignment(SWT.CENTER);
		visitorInning6.setBounds(369, 99, 34, 36);

		Label hometeamInning6 = new Label(container, SWT.BORDER);
		hometeamInning6.setText("0"); //$NON-NLS-1$
		hometeamInning6.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning6.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning6.setAlignment(SWT.CENTER);
		hometeamInning6.setBounds(369, 140, 34, 31);

		Label label21 = new Label(container, SWT.NONE);
		label21.setText("7"); //$NON-NLS-1$
		label21.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label21.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label21.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label21.setAlignment(SWT.CENTER);
		label21.setBounds(409, 71, 35, 22);

		Label visitorInning7 = new Label(container, SWT.BORDER);
		visitorInning7.setText("0"); //$NON-NLS-1$
		visitorInning7.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning7.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning7.setAlignment(SWT.CENTER);
		visitorInning7.setBounds(410, 99, 34, 36);

		Label hometeamInning7 = new Label(container, SWT.BORDER);
		hometeamInning7.setText("0"); //$NON-NLS-1$
		hometeamInning7.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning7.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning7.setAlignment(SWT.CENTER);
		hometeamInning7.setBounds(410, 140, 34, 31);

		Label label24 = new Label(container, SWT.NONE);
		label24.setText("8"); //$NON-NLS-1$
		label24.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label24.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label24.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label24.setAlignment(SWT.CENTER);
		label24.setBounds(450, 71, 35, 22);

		Label visitorInning8 = new Label(container, SWT.BORDER);
		visitorInning8.setText("0"); //$NON-NLS-1$
		visitorInning8.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning8.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning8.setAlignment(SWT.CENTER);
		visitorInning8.setBounds(451, 99, 34, 36);

		Label hometeamInning8 = new Label(container, SWT.BORDER);
		hometeamInning8.setText("0"); //$NON-NLS-1$
		hometeamInning8.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning8.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning8.setAlignment(SWT.CENTER);
		hometeamInning8.setBounds(451, 140, 34, 31);

		Label label27 = new Label(container, SWT.NONE);
		label27.setText("9"); //$NON-NLS-1$
		label27.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label27.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		label27.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label27.setAlignment(SWT.CENTER);
		label27.setBounds(491, 71, 35, 22);

		Label visitorInning9 = new Label(container, SWT.BORDER);
		visitorInning9.setText("0"); //$NON-NLS-1$
		visitorInning9.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorInning9.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorInning9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorInning9.setAlignment(SWT.CENTER);
		visitorInning9.setBounds(492, 99, 34, 36);

		Label hometeamInning9 = new Label(container, SWT.BORDER);
		hometeamInning9.setText("0"); //$NON-NLS-1$
		hometeamInning9.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamInning9.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamInning9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamInning9.setAlignment(SWT.CENTER);
		hometeamInning9.setBounds(492, 140, 34, 31);

		Label lblRuns = new Label(container, SWT.NONE);
		lblRuns.setText("Run"); //$NON-NLS-1$
		lblRuns.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRuns.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.NORMAL));
		lblRuns.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblRuns.setAlignment(SWT.CENTER);
		lblRuns.setBounds(556, 71, 35, 22);

		visitorGeneralRun = new Label(container, SWT.BORDER);
		visitorGeneralRun.setText("0"); //$NON-NLS-1$
		visitorGeneralRun.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorGeneralRun.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorGeneralRun.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorGeneralRun.setAlignment(SWT.CENTER);
		visitorGeneralRun.setBounds(556, 98, 34, 37);

		hometeamGeneralRun = new Label(container, SWT.BORDER);
		hometeamGeneralRun.setText("0"); //$NON-NLS-1$
		hometeamGeneralRun.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamGeneralRun.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamGeneralRun.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamGeneralRun.setAlignment(SWT.CENTER);
		hometeamGeneralRun.setBounds(556, 140, 34, 31);

		Label lblHit = new Label(container, SWT.NONE);
		lblHit.setText("Hit"); //$NON-NLS-1$
		lblHit.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHit.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.NORMAL));
		lblHit.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblHit.setAlignment(SWT.CENTER);
		lblHit.setBounds(599, 72, 35, 22);

		visitorGeneralHit = new Label(container, SWT.BORDER);
		visitorGeneralHit.setText("0"); //$NON-NLS-1$
		visitorGeneralHit.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorGeneralHit.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorGeneralHit.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorGeneralHit.setAlignment(SWT.CENTER);
		visitorGeneralHit.setBounds(599, 99, 34, 36);

		hometeamGeneralHits = new Label(container, SWT.BORDER);
		hometeamGeneralHits.setText("0"); //$NON-NLS-1$
		hometeamGeneralHits.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamGeneralHits.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamGeneralHits.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamGeneralHits.setAlignment(SWT.CENTER);
		hometeamGeneralHits.setBounds(600, 141, 34, 30);

		Label lblError = new Label(container, SWT.NONE);
		lblError.setText("Error"); //$NON-NLS-1$
		lblError.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblError.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.NORMAL));
		lblError.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblError.setAlignment(SWT.CENTER);
		lblError.setBounds(632, 73, 53, 22);

		visitorGeneralErrors = new Label(container, SWT.BORDER);
		visitorGeneralErrors.setText("0"); //$NON-NLS-1$
		visitorGeneralErrors.setForeground(SWTResourceManager.getColor(255, 255, 0));
		visitorGeneralErrors.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		visitorGeneralErrors.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		visitorGeneralErrors.setAlignment(SWT.CENTER);
		visitorGeneralErrors.setBounds(642, 99, 34, 36);

		hometeamGeneralErrors = new Label(container, SWT.BORDER);
		hometeamGeneralErrors.setText("0"); //$NON-NLS-1$
		hometeamGeneralErrors.setForeground(SWTResourceManager.getColor(255, 255, 0));
		hometeamGeneralErrors.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		hometeamGeneralErrors.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		hometeamGeneralErrors.setAlignment(SWT.CENTER);
		hometeamGeneralErrors.setBounds(642, 141, 34, 30);

		Label lblPitches = new Label(container, SWT.NONE);
		lblPitches.setText("PITCHES"); //$NON-NLS-1$
		lblPitches.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPitches.setFont(SWTResourceManager.getFont(LABEL_FONT_2, 10, SWT.BOLD));
		lblPitches.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblPitches.setAlignment(SWT.CENTER);
		lblPitches.setBounds(556, 38, 85, 22);

		pitchesCounter = new Label(container, SWT.BORDER);
		pitchesCounter.setText("0"); //$NON-NLS-1$
		pitchesCounter.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		pitchesCounter.setFont(SWTResourceManager.getFont(LABEL_FONT_1, 12, SWT.BOLD));
		pitchesCounter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		pitchesCounter.setAlignment(SWT.CENTER);
		pitchesCounter.setBounds(642, 30, 35, 30);

		visitorPoints = new HashMap<>();
		visitorPoints.put(1, visitorInning1);
		visitorPoints.put(2, visitorInning2);
		visitorPoints.put(3, visitorInning3);
		visitorPoints.put(4, visitorInning4);
		visitorPoints.put(5, visitorInning5);
		visitorPoints.put(6, visitorInning6);
		visitorPoints.put(7, visitorInning7);
		visitorPoints.put(8, visitorInning8);
		visitorPoints.put(9, visitorInning9);

		hometemPoints = new HashMap<>();
		hometemPoints.put(1, hometeamInning1);
		hometemPoints.put(2, hometeamInning2);
		hometemPoints.put(3, hometeamInning3);
		hometemPoints.put(4, hometeamInning4);
		hometemPoints.put(5, hometeamInning5);
		hometemPoints.put(6, hometeamInning6);
		hometemPoints.put(7, hometeamInning7);
		hometemPoints.put(8, hometeamInning8);
		hometemPoints.put(9, hometeamInning9);
	}

	@Override
	public void clearPanel() {

		for (Entry<Integer, Label> entry : hometemPoints.entrySet()) {
			setLabelValue(entry.getValue(), ""); //$NON-NLS-1$
		}
		for (Entry<Integer, Label> entry : visitorPoints.entrySet()) {
			setLabelValue(entry.getValue(), ""); //$NON-NLS-1$
		}

		setLabelValue(visitorName, "VISITOR"); //$NON-NLS-1$
		setLabelValue(hometeamName, "HOMETEAM"); //$NON-NLS-1$
		setLabelValue(outCounter, "0"); //$NON-NLS-1$
		setLabelValue(strikes, "0"); //$NON-NLS-1$
		setLabelValue(balls, "0"); //$NON-NLS-1$
		setLabelValue(visitorGeneralRun, "0"); //$NON-NLS-1$
		setLabelValue(hometeamGeneralRun, "0"); //$NON-NLS-1$
		setLabelValue(visitorGeneralHit, "0"); //$NON-NLS-1$
		setLabelValue(hometeamGeneralHits, "0"); //$NON-NLS-1$
		setLabelValue(visitorGeneralErrors, "0"); //$NON-NLS-1$
		setLabelValue(hometeamGeneralErrors, "0"); //$NON-NLS-1$
		setLabelValue(pitchesCounter, "0"); //$NON-NLS-1$
	}

	@Override
	public void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine) {

		if (game != null) {
			if ((game.getHometeam() != null) && 
					((hometeamName != null) && (game.getHometeam().getName() != null))	) {
					hometeamName.setText(game.getHometeam().getName());
			}
			if ((game.getVisitor() != null) && 
					((visitorName != null) && game.getVisitor().getName() != null)	) {
					visitorName.setText(game.getVisitor().getName());
			}
		}

		String currentTeam = scoreGameEngine.getScoreGameManager().getLastCurrentTeam();
		if (currentTeam != null) {
			GameStatistic stats = statisticEngine.getStatisticManager().getStats();
			TeamStatistic teamStats = (EngineConstants.HOMETEAM.equals(currentTeam) ? stats.getVisitor()
					: stats.getHometeam());
			LineupEntry pitcher = teamStats.getCurrentPitcher();
			if (pitcher != null) {
				setLabelValue(pitchesCounter, "" + pitcher.getPitcherStatistic().getPitchCount()); //$NON-NLS-1$
			} else {
				setLabelValue(pitchesCounter, "0"); //$NON-NLS-1$
			}
		}

		StatisticManager manager = statisticEngine.getStatisticManager();
		if (manager != null) {

			setLabelValue(strikes, "" + manager.getCurrentStrikeCount()); //$NON-NLS-1$
			setLabelValue(balls, "" + manager.getCurrentBallCount()); //$NON-NLS-1$

			GameStatistic stats = manager.getStats();
			if (stats != null) {

				int pointCounter = 0;
				int hitsCounter = 0;
				int errorsCounter = 0;

				TeamStatistic homeTeamStats = stats.getHometeam();
				TeamStatistic visitorStats = stats.getVisitor();

				int counter = 1;
				for (InninStatictic inningStat : homeTeamStats.getGeneralInningStats()) {
					int runs = inningStat.getInningStat().getRuns();

					if (counter < 10) {
						setLabelValue(hometemPoints.get(counter), "" + runs); //$NON-NLS-1$
					}
					pointCounter += runs;
					hitsCounter += inningStat.getInningStat().getHits();
					errorsCounter += inningStat.getInningStat().getErrors();
					counter++;
				}
				while (counter < 10) {
					setLabelValue(hometemPoints.get(counter), ""); //$NON-NLS-1$
					counter++;
				}

				setLabelValue(hometeamGeneralRun, "" + pointCounter); //$NON-NLS-1$
				setLabelValue(hometeamGeneralHits, "" + hitsCounter); //$NON-NLS-1$
				setLabelValue(visitorGeneralErrors, "" + errorsCounter); //$NON-NLS-1$

				counter = 1;
				pointCounter = 0;
				hitsCounter = 0;
				errorsCounter = 0;
				for (InninStatictic inningStat : visitorStats.getGeneralInningStats()) {
					int runs = inningStat.getInningStat().getRuns();

					if (counter < 10) {
						setLabelValue(visitorPoints.get(counter), "" + runs); //$NON-NLS-1$
					}
					pointCounter += runs;
					hitsCounter += inningStat.getInningStat().getHits();
					errorsCounter += inningStat.getInningStat().getErrors();
					counter++;
				}
				while (counter < 10) {
					setLabelValue(visitorPoints.get(counter), ""); //$NON-NLS-1$
					counter++;
				}

				setLabelValue(visitorGeneralRun, "" + pointCounter); //$NON-NLS-1$
				setLabelValue(visitorGeneralHit, "" + hitsCounter); //$NON-NLS-1$
				setLabelValue(hometeamGeneralErrors, "" + errorsCounter); //$NON-NLS-1$

				try {
				
					HalfInning halfInning = game.getActions().getHalfInnings()
							.get(game.getActions().getHalfInnings().size() - 1);
					int nbOuts = ScoreGameOutUtil.getOut(halfInning);
					setLabelValue(outCounter, "" + nbOuts); //$NON-NLS-1$
				
				} catch (NullPointerException|IndexOutOfBoundsException ex) {
					logger.log(Level.SEVERE, ex.getMessage());
				}
			}
		}
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		// nothing to do
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// nothing to do
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
