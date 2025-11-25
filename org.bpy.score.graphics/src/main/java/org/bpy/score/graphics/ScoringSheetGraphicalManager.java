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
package org.bpy.score.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.AbstractActionManager;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;
import org.bpy.score.engine.manager.lineup.SubstitutionManager;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.MoveToData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.ReplacementData;
import org.bpy.score.engine.manager.lineup.SubstitutionManager.SubstitutionCommonData;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.stats.emf.GameStatisticContainer;
import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.InningGeneralStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.*;
import org.bpy.score.game.util.ScoreGameAdvanceUtil;
import org.bpy.score.game.util.ScoreGameDisplay;
import org.bpy.score.game.util.ScoreGameUtil;
import org.bpy.score.graphics.MultiplePlayContainer.DIRECTION;
import org.bpy.score.internationalization.graphics.Messages;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;

/**
 * This class draw the scoring sheet in a graphical context.
 *
 * @author Patrick BRIAND
 *
 */
public class ScoringSheetGraphicalManager extends AbstractActionManager {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ScoringSheetGraphicalManager.class.getSimpleName());

	/** Empty string */
	private static final String EMPTY_STRING = "";  //$NON-NLS-1$
	
	/** Square position key for the linked object */ 
	protected static final String SQUARE_POSITION = "SquarePosition"; //$NON-NLS-1$
	/** Draw substitution key for the linked object */ 
	protected static final String DRAW_SUBSTITUTION = "DrawSubstitution";  //$NON-NLS-1$
	/** Graphical position key for the linked object */ 
	protected static final String GRAPHICAL_POSITION = "GraphicalPosition";  //$NON-NLS-1$

	/** Corrective factor for each draw */
	public static final double FACTOR_CORRECTIF = 2.833;

	/** Horizontal margin of the sheet */
	protected static final double HORIZONTAL_MARGE = 4 * FACTOR_CORRECTIF;
	/** Vertical margin of the sheet */
	protected static final double VERTICAL_MARGE = 3 * FACTOR_CORRECTIF;
	/** Size of the horizontal length */
	protected static final double HORIZONTAL = 291;
	/** Size of the horizontal length corrected with the corrective factor */
	protected static final double HORIZONTAL_LENGHT = HORIZONTAL * FACTOR_CORRECTIF;

	/** Height of a line */
	public static final double HEIGHT_LINE = 4.26;
	/** Width of a line */
	public static final double WIDTH_LINE = 4.1;

	/** Position of the the complete double horizontal line 0 */ 
	public static final double VERTICAL_000 = VERTICAL_MARGE + (0 * HEIGHT_LINE) * FACTOR_CORRECTIF; // Ligne du haut
	/** Position of the the complete double horizontal line 1 */ 
	public static final double VERTICAL_001 = VERTICAL_MARGE + (1 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 2 */ 
	public static final double VERTICAL_002 = VERTICAL_MARGE + (2 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 3 */ 
	public static final double VERTICAL_003 = VERTICAL_MARGE + (3 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 4 */ 
	public static final double VERTICAL_004 = VERTICAL_MARGE + (4 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 5 */ 
	public static final double VERTICAL_005 = VERTICAL_MARGE + (5 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 6 */ 
	public static final double VERTICAL_006 = VERTICAL_MARGE + (6 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 7 */ 
	public static final double VERTICAL_007 = VERTICAL_MARGE + (7 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 8 */ 
	public static final double VERTICAL_008 = VERTICAL_MARGE + (8 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 9 */ 
	public static final double VERTICAL_009 = VERTICAL_MARGE + (9 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 10 */ 
	public static final double VERTICAL_010 = VERTICAL_MARGE + (10 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 11 */ 
	public static final double VERTICAL_011 = VERTICAL_MARGE + (11 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 12 */ 
	public static final double VERTICAL_012 = VERTICAL_MARGE + (12 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 13 */ 
	public static final double VERTICAL_013 = VERTICAL_MARGE + (13 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 14 */ 
	public static final double VERTICAL_014 = VERTICAL_MARGE + (14 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 15 */ 
	public static final double VERTICAL_015 = VERTICAL_MARGE + (15 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 16 */ 
	public static final double VERTICAL_016 = VERTICAL_MARGE + (16 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 17 */ 
	public static final double VERTICAL_017 = VERTICAL_MARGE + (17 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 18 */ 
	public static final double VERTICAL_018 = VERTICAL_MARGE + (18 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 19 */ 
	public static final double VERTICAL_019 = VERTICAL_MARGE + (19 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 20 */ 
	public static final double VERTICAL_020 = VERTICAL_MARGE + (20 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 21 */ 
	public static final double VERTICAL_021 = VERTICAL_MARGE + (21 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 22 */ 
	public static final double VERTICAL_022 = VERTICAL_MARGE + (22 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 23 */ 
	public static final double VERTICAL_023 = VERTICAL_MARGE + (23 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 24 */ 
	public static final double VERTICAL_024 = VERTICAL_MARGE + (24 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 25 */ 
	public static final double VERTICAL_025 = VERTICAL_MARGE + (25 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 26 */ 
	public static final double VERTICAL_026 = VERTICAL_MARGE + (26 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 27 */ 
	public static final double VERTICAL_027 = VERTICAL_MARGE + (27 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 28 */ 
	public static final double VERTICAL_028 = VERTICAL_MARGE + (28 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 29 */ 
	public static final double VERTICAL_029 = VERTICAL_MARGE + (29 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 30 */ 
	public static final double VERTICAL_030 = VERTICAL_MARGE + (30 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 31 */ 
	public static final double VERTICAL_031 = VERTICAL_MARGE + (31 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 32 */ 
	public static final double VERTICAL_032 = VERTICAL_MARGE + (32 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 33 */ 
	public static final double VERTICAL_033 = VERTICAL_MARGE + (33 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 34 */ 
	public static final double VERTICAL_034 = VERTICAL_MARGE + (34 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 35 */ 
	public static final double VERTICAL_035 = VERTICAL_MARGE + (35 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 36 */ 
	public static final double VERTICAL_036 = VERTICAL_MARGE + (36 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 37 */ 
	public static final double VERTICAL_037 = VERTICAL_MARGE + (37 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 38 */ 
	public static final double VERTICAL_038 = VERTICAL_MARGE + (38 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 39 */ 
	public static final double VERTICAL_039 = VERTICAL_MARGE + (39 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 40 */ 
	public static final double VERTICAL_040 = VERTICAL_MARGE + (40 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 41 */ 
	public static final double VERTICAL_041 = VERTICAL_MARGE + (41 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 42 */ 
	public static final double VERTICAL_042 = VERTICAL_MARGE + (42 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 43 */ 
	public static final double VERTICAL_043 = VERTICAL_MARGE + (43 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 44 */ 
	public static final double VERTICAL_044 = VERTICAL_MARGE + (44 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 45 */ 
	public static final double VERTICAL_045 = VERTICAL_MARGE + (45 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 46 */ 
	public static final double VERTICAL_046 = VERTICAL_MARGE + (46 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 47 */ 
	public static final double VERTICAL_047 = VERTICAL_MARGE + (47 * HEIGHT_LINE) * FACTOR_CORRECTIF;
	/** Position of the the complete double horizontal 48 */ 
	public static final double VERTICAL_048 = VERTICAL_MARGE + (48 * HEIGHT_LINE) * FACTOR_CORRECTIF;

	/** Position of the the complete double vertical 0 */
	public static final double HORIZONTAL_000 = HORIZONTAL_MARGE;
	/** Position of the the complete double vertical 1 */
	public static final double HORIZONTAL_001 = HORIZONTAL_MARGE + (4.1 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 2 */
	public static final double HORIZONTAL_002 = HORIZONTAL_MARGE + (8.2 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 3 */
	public static final double HORIZONTAL_003 = HORIZONTAL_MARGE + (12.3 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 4 */
	public static final double HORIZONTAL_004 = HORIZONTAL_MARGE + (16.4 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 5 */
	public static final double HORIZONTAL_005 = HORIZONTAL_MARGE + (20.5 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 6 */
	public static final double HORIZONTAL_006 = HORIZONTAL_MARGE + (24.6 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 6N */
	public static final double HORIZONTAL_006N = HORIZONTAL_MARGE + (28.7 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 7 */
	public static final double HORIZONTAL_007 = HORIZONTAL_MARGE + (61 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 8 */
	public static final double HORIZONTAL_008 = HORIZONTAL_MARGE + (65.2 * FACTOR_CORRECTIF);

	/** Width size of an action box */
	public static final double ACTION_WIDTH = 12.316;

	
	/** Position of the the complete double vertical 9 - Column action 1 */
	public static final double HORIZONTAL_009 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 0) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 11 - Column action 2 */
	public static final double HORIZONTAL_011 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 1) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 13 - Column action 3 */
	public static final double HORIZONTAL_013 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 2) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 15 - Column action 4 */
	public static final double HORIZONTAL_015 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 3) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 17 - Column action 5 */
	public static final double HORIZONTAL_017 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 4) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 19 - Column action 6 */
	public static final double HORIZONTAL_019 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 5) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 21 - Column action 7 */
	public static final double HORIZONTAL_021 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 6) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 23 - Column action 8 */
	public static final double HORIZONTAL_023 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 7) * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical 25 - Column action 9 */
	public static final double HORIZONTAL_025 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 8) * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 27 - Column action 10 */
	public static final double HORIZONTAL_027 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 9) * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 29 - Column action 11 */
	public static final double HORIZONTAL_029 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 10) * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical 31 - Column action 12 */
	public static final double HORIZONTAL_031 = HORIZONTAL_MARGE + ((69.2 + ACTION_WIDTH * 11) * FACTOR_CORRECTIF);


	/** Position of the the complete double vertical Offensive statistic PA */
	public static final double HORIZONTAL_PA_POSITION = HORIZONTAL_MARGE + (217.0 * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical Offensive statistic AB */
	public static final double HORIZONTAL_AB_POSITION = HORIZONTAL_MARGE + (221.1 * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical Offensive statistic RUN */
	public static final double HORIZONTAL_RUN_POSITION = HORIZONTAL_MARGE + (225.1 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic HIT */
	public static final double HORIZONTAL_HIT_POSITION = HORIZONTAL_MARGE + (229.2 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic 2B */
	public static final double HORIZONTAL_2B_POSITION = HORIZONTAL_MARGE + (233.3 * FACTOR_CORRECTIF); 
	/** Position of the the complete double vertical Offensive statistic 3B */
	public static final double HORIZONTAL_3B_POSITION = HORIZONTAL_MARGE + (237.4 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic HR */
	public static final double HORIZONTAL_HR_POSITION = HORIZONTAL_MARGE + (241.5 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic GDP */
	public static final double HORIZONTAL_GDP_POSITION = HORIZONTAL_MARGE + (245.6 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic SH */
	public static final double HORIZONTAL_SH_POSITION = HORIZONTAL_MARGE + (249.7 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic SF */
	public static final double HORIZONTAL_SF_POSITION = HORIZONTAL_MARGE + (253.8 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic BB */
	public static final double HORIZONTAL_BB_POSITION = HORIZONTAL_MARGE + (257.9 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic IBB */
	public static final double HORIZONTAL_IBB_POSITION = HORIZONTAL_MARGE + (262.0 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic HP */
	public static final double HORIZONTAL_HP_POSITION = HORIZONTAL_MARGE + (266.1 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic IO */
	public static final double HORIZONTAL_IO_POSITION = HORIZONTAL_MARGE + (270.2 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic SB */
	public static final double HORIZONTAL_SB_POSITION = HORIZONTAL_MARGE + (274.3 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic CS */
	public static final double HORIZONTAL_CS_POSITION = HORIZONTAL_MARGE + (278.4 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic K */
	public static final double HORIZONTAL_K_POSITION = HORIZONTAL_MARGE + (282.5 * FACTOR_CORRECTIF);
	/** Position of the the complete double vertical Offensive statistic RBI */
	public static final double HORIZONTAL_RBI_POSITION = HORIZONTAL_MARGE + (286.6 * FACTOR_CORRECTIF);

	/** Position of the the complete double vertical 60 */
	public static final double HORIZONTAL_060 = HORIZONTAL_MARGE + HORIZONTAL_LENGHT;
	/** Position of the the complete double vertical 5 2 */
	public static final double HORIZONTAL_005_2 = HORIZONTAL_MARGE + 216.8 * FACTOR_CORRECTIF;

	/** Position of the the vertical pitcher statistic 1 */
	public static final double STAT_PITCHER_001 = HORIZONTAL_025 - (4.133 * 17) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 2 */
	public static final double STAT_PITCHER_002 = HORIZONTAL_025 - (4.133 * 16) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 3 */
	public static final double STAT_PITCHER_003 = HORIZONTAL_025 - (4.133 * 15) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 4 */
	public static final double STAT_PITCHER_004 = HORIZONTAL_025 - (4.133 * 14) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 5 */
	public static final double STAT_PITCHER_005 = HORIZONTAL_025 - (4.133 * 13) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 6 */
	public static final double STAT_PITCHER_006 = HORIZONTAL_025 - (4.133 * 12) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 7 */
	public static final double STAT_PITCHER_007 = HORIZONTAL_025 - (4.133 * 11) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 8 */
	public static final double STAT_PITCHER_008 = HORIZONTAL_025 - (4.133 * 10) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 9 */
	public static final double STAT_PITCHER_009 = HORIZONTAL_025 - (4.133 * 9) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 10 */
	public static final double STAT_PITCHER_010 = HORIZONTAL_025 - (4.133 * 8) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 11 */
	public static final double STAT_PITCHER_011 = HORIZONTAL_025 - (4.133 * 7) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 12 */
	public static final double STAT_PITCHER_012 = HORIZONTAL_025 - (4.133 * 6) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 13 */
	public static final double STAT_PITCHER_013 = HORIZONTAL_025 - (4.133 * 5) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 14 */
	public static final double STAT_PITCHER_014 = HORIZONTAL_025 - (4.133 * 4) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 15 */
	public static final double STAT_PITCHER_015 = HORIZONTAL_025 - (4.133 * 3) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 16 */
	public static final double STAT_PITCHER_016 = HORIZONTAL_025 - (4.133 * 2) * FACTOR_CORRECTIF;
	/** Position of the the vertical pitcher statistic 17 */
	public static final double STAT_PITCHER_017 = HORIZONTAL_025 - (4.133 * 1) * FACTOR_CORRECTIF;

	/** Position of the the vertical catcher statistic PB */
	public static final double STAT_CATCHER_PB = HORIZONTAL_PA_POSITION - (4.133 * 3) * FACTOR_CORRECTIF;
	/** Position of the the vertical catcher statistic SB */
	public static final double STAT_CATCHER_SB = HORIZONTAL_PA_POSITION - (4.133 * 2) * FACTOR_CORRECTIF;
	/** Position of the the vertical catcher statistic CS */
	public static final double STAT_CATCHER_CS = HORIZONTAL_PA_POSITION - (4.133 * 1) * FACTOR_CORRECTIF;

	/** Vertical position of the team end play */
	public static final double HOME_TEAM_END_PLAY_NUMBER = HORIZONTAL_015 + (16.5 * FACTOR_CORRECTIF);
	/** Vertical position of the team start play */
	public static final double HOME_TEAM_START_PLAY_NUMBER = HORIZONTAL_015;

	/** Position of the horizontal baseball check box */
	protected static final double BASEBALL_X_POSITION = (180 + HORIZONTAL_MARGE) * FACTOR_CORRECTIF;
	/** Position of the horizontal softball check box */
	protected static final double SOFTBALL_X_POSITION = (219 + HORIZONTAL_MARGE) * FACTOR_CORRECTIF;
	/** Position of the vertical  baseball/softball check box */
	protected static final double CHECK_BOX_Y_POSITION = VERTICAL_MARGE + (1 * FACTOR_CORRECTIF);
	/** Height of the baseball/softball check box */
	protected static final double CHECKBOX_WIDTH = 2.35 * FACTOR_CORRECTIF;
	/** witdh of the baseball/softball check box */
	protected static final double CHECHBOX_HEIGHT = 2.35 * FACTOR_CORRECTIF;

	/** Horizontal position of the visitor sheet city name */
	protected static final int VISITOR_CITY_TEXT_X = (int) ((30 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor sheet city name */
	protected static final int VISITOR_CITY_TEXT_Y = (int) (VERTICAL_002 - 4);
	/** Horizontal position of the visitor sheet place name */

	protected static final int VISITOR_PLACE_TEXT_X = (int) ((91 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor sheet place name */
	protected static final int VISITOR_PLACE_TEXT_Y = (int) (VERTICAL_002 - 4);
	
	/** Horizontal position of the visitor tournament name */
	protected static final int VISITOR_TOURNAMENT_TEXT_X = (int) ((38 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** vertical position of the visitor tournament name */
	protected static final int VISITOR_TOURNAMENT_TEXT_Y = (int) (VERTICAL_001 - 4);
	
	/** Horizontal position of the visitor category name */
	protected static final int VISITOR_CATEGORY_TEXT_X = (int) ((116 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor category name */
	protected static final int VISITOR_CATEGORY_TEXT_Y = (int) (VERTICAL_001 - 4);
	
	/** Horizontal position of the visitor date value */
	protected static final int VISITOR_DATE_TEXT_X = (int) ((163 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor date value */
	protected static final int VISITOR_DATE_TEXT_Y = (int) (VERTICAL_001 - 4);
	
	/** Horizontal position of the visitor start time value */
	protected static final int VISITOR_START_TIME_TEXT_X = (int) ((138 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor start time value */
	protected static final int VISITOR_START_TIME_TEXT_Y = (int) (VERTICAL_002 - 4);
	
	/** Horizontal position of the visitor end time value */
	protected static final int VISITOR_END_TIME_TEXT_X = (int) ((153 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor end time value */
	protected static final int VISITOR_END_TIME_TEXT_Y = (int) (VERTICAL_002 - 4);
	
	/** Horizontal position of the visitor duration time value */
	protected static final int VISITOR_DURATION_TEXT_X = (int) ((175 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** vertical position of the visitor duration time value */
	protected static final int VISITOR_DURATION_TEXT_Y = (int) (VERTICAL_002 - 4);
	
	/** Horizontal position of the visitor Umpire list */
	protected static final int VISITOR_UMPIRES_TEXT_X = (int) ((34 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the visitor Umpire list */
	protected static final int VISITOR_UMPIRES_TEXT_Y = (int) (VERTICAL_003 - 4);
	
	/** Horizontal position of the visitor Score keepers list */
	protected static final int VISITOR_SCOREKEEPERS_TEXT_X = (int) ((34 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** vertical position of the visitor Score keepers list */
	protected static final int VISITOR_SCOREKEEPERS_TEXT_Y = (int) (VERTICAL_004 - 4);

	/** Horizontal position of the home team tournament name */
	protected static final int HOMETEAM_TOURNAMENT_TEXT_X = (int) ((38 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the home team tournament name */
	protected static final int HOMETEAM_TOURNAMENT_TEXT_Y = (int) (VERTICAL_001 - 4);

	/** Horizontal position of the home team category name */
	protected static final int HOMETEAM_CATEGORY_TEXT_X = (int) ((33 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the home team category name */
	protected static final int HOMETEAM_CATEGORY_TEXT_Y = (int) (VERTICAL_002 - 4);
	
	/** Horizontal position of the home team visitor name */
	protected static final int HOMETEAM_VISITOR_TEXT_X = (int) ((35 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the home team visitor name */
	protected static final int HOMETEAM_VISITOR_TEXT_Y = (int) (VERTICAL_003 - 4);
	
	/** Horizontal position of the home team home team name */
	protected static final int HOMETEAM_HOMETEAM_TEXT_X = (int) ((35 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the home team home team name */
	protected static final int HOMETEAM_HOMETEAM_TEXT_Y = (int) (VERTICAL_004 - 4);
	
	/** Horizontal position of the home team date value */
	protected static final int HOMETEAM_DATE_TEXT_X = (int) ((85 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the home team date value */
	protected static final int HOMETEAM_DATE_TEXT_Y = (int) (VERTICAL_001 - 4);
	
	/** Horizontal position of the hoem team start time value */
	protected static final int HOMETEAM_START_TEXT_X = (int) ((85 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);
	/** Vertical position of the hoem team start time value */
	protected static final int HOMETEAM_START_TEXT_Y = (int) (VERTICAL_002 - 4);

	/** Number separator for home team */
	protected static final int NUMBER_SEPARATOR_HOMETEAM = (int) ((123 * FACTOR_CORRECTIF) + HORIZONTAL_MARGE);

	/** Action square width	 */
	protected static final int ACTION_PLACE_WIDTH = (int) (ACTION_WIDTH * FACTOR_CORRECTIF);
	/** Action square height	 */
	protected static final int ACTION_PLACE_HEIGHT = (int) (HEIGHT_LINE * 3 * FACTOR_CORRECTIF);

	/** Array which contains all bold lines to draw */
	protected static final Rectangle[] COMMON_BOLD_LINE = {

			/* Lignes completes horizontales */
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_000, (int) HORIZONTAL_060, (int) VERTICAL_000), // Première ligne du haut
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_004, (int) HORIZONTAL_060, (int) VERTICAL_004),
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_005, (int) HORIZONTAL_008, (int) VERTICAL_005),
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_060, (int) VERTICAL_005),
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_006, (int) HORIZONTAL_060, (int) VERTICAL_006), // Haut 1
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_009, (int) HORIZONTAL_060, (int) VERTICAL_009), // Haut 2
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_012, (int) HORIZONTAL_060, (int) VERTICAL_012), // Haut 3
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_015, (int) HORIZONTAL_060, (int) VERTICAL_015), // Haut 4
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_018, (int) HORIZONTAL_060, (int) VERTICAL_018), // Haut 5
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_021, (int) HORIZONTAL_060, (int) VERTICAL_021), // Haut 6
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_024, (int) HORIZONTAL_060, (int) VERTICAL_024), // Haut 7
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_027, (int) HORIZONTAL_060, (int) VERTICAL_027), // Haut 8
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_030, (int) HORIZONTAL_060, (int) VERTICAL_030), // Haut 9
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_033, (int) HORIZONTAL_060, (int) VERTICAL_033), // Bas 9
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_040, (int) HORIZONTAL_060, (int) VERTICAL_040), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_041, (int) HORIZONTAL_060, (int) VERTICAL_041), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_047, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_047), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_048, (int) HORIZONTAL_060, (int) VERTICAL_048), // Ligne du bas
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_042, (int) HORIZONTAL_060, (int) VERTICAL_042), // Controle

			/* Lignes completes verticales */
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_000, (int) HORIZONTAL_000, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_003, (int) VERTICAL_005, (int) HORIZONTAL_003, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_003, (int) VERTICAL_041, (int) HORIZONTAL_003, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_005, (int) VERTICAL_000, (int) HORIZONTAL_005, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_008, (int) VERTICAL_004, (int) HORIZONTAL_008, (int) VERTICAL_048),

			new Rectangle((int) HORIZONTAL_009, (int) VERTICAL_004, (int) HORIZONTAL_009, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_011, (int) VERTICAL_004, (int) HORIZONTAL_011, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_013, (int) VERTICAL_004, (int) HORIZONTAL_013, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_015, (int) VERTICAL_004, (int) HORIZONTAL_015, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_017, (int) VERTICAL_004, (int) HORIZONTAL_017, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_019, (int) VERTICAL_004, (int) HORIZONTAL_019, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_021, (int) VERTICAL_004, (int) HORIZONTAL_021, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_023, (int) VERTICAL_004, (int) HORIZONTAL_023, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_025, (int) VERTICAL_004, (int) HORIZONTAL_025, (int) VERTICAL_048),
			new Rectangle((int) HORIZONTAL_027, (int) VERTICAL_004, (int) HORIZONTAL_027, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_029, (int) VERTICAL_004, (int) HORIZONTAL_029, (int) VERTICAL_040),
			new Rectangle((int) HORIZONTAL_031, (int) VERTICAL_004, (int) HORIZONTAL_031, (int) VERTICAL_048),

			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_004, (int) HORIZONTAL_PA_POSITION,
					(int) VERTICAL_048), // Seperation PA
			new Rectangle((int) HORIZONTAL_HIT_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_HIT_POSITION,
					(int) VERTICAL_041), // Seperation H
			new Rectangle((int) HORIZONTAL_2B_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_2B_POSITION,
					(int) VERTICAL_041), // Seperation 2B
			new Rectangle((int) HORIZONTAL_GDP_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_GDP_POSITION,
					(int) VERTICAL_041), // Seperation GDP
			new Rectangle((int) HORIZONTAL_SH_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_SH_POSITION,
					(int) VERTICAL_041), // Seperation SH
			new Rectangle((int) HORIZONTAL_BB_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_BB_POSITION,
					(int) VERTICAL_041), // Seperation BB
			new Rectangle((int) HORIZONTAL_IBB_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_IBB_POSITION,
					(int) VERTICAL_041), // Seperation IBB
			new Rectangle((int) HORIZONTAL_SB_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_SB_POSITION,
					(int) VERTICAL_041), // Seperation k
			new Rectangle((int) HORIZONTAL_K_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_K_POSITION,
					(int) VERTICAL_041), // Seperation k
			new Rectangle((int) HORIZONTAL_RBI_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_RBI_POSITION,
					(int) VERTICAL_041), // Séperation RBI
			new Rectangle((int) HORIZONTAL_060, (int) VERTICAL_000, (int) HORIZONTAL_060, (int) VERTICAL_048),

			/* Statistique pitcher */
			new Rectangle((int) STAT_PITCHER_001, (int) VERTICAL_040, (int) STAT_PITCHER_001, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_004, (int) VERTICAL_040, (int) STAT_PITCHER_004, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_005, (int) VERTICAL_040, (int) STAT_PITCHER_005, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_011, (int) VERTICAL_040, (int) STAT_PITCHER_011, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_016, (int) VERTICAL_040, (int) STAT_PITCHER_016, (int) VERTICAL_048) };

	/** Array which contains all not bold lines to draw */
	protected static final Rectangle[] COMMON_NORMAL_LINE = {
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_007, (int) HORIZONTAL_008, (int) VERTICAL_007), // Batteur 1
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_008, (int) HORIZONTAL_008, (int) VERTICAL_008), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_007, (int) HORIZONTAL_060, (int) VERTICAL_007), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_008, (int) HORIZONTAL_060, (int) VERTICAL_008), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_010, (int) HORIZONTAL_008, (int) VERTICAL_010), // Batteur 2
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_011, (int) HORIZONTAL_008, (int) VERTICAL_011), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_010, (int) HORIZONTAL_060, (int) VERTICAL_010), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_011, (int) HORIZONTAL_060, (int) VERTICAL_011), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_013, (int) HORIZONTAL_008, (int) VERTICAL_013), // Batteur 3
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_014, (int) HORIZONTAL_008, (int) VERTICAL_014), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_013, (int) HORIZONTAL_060, (int) VERTICAL_013), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_014, (int) HORIZONTAL_060, (int) VERTICAL_014), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_016, (int) HORIZONTAL_008, (int) VERTICAL_016), // Batteur 4
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_017, (int) HORIZONTAL_008, (int) VERTICAL_017), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_016, (int) HORIZONTAL_060, (int) VERTICAL_016), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_017, (int) HORIZONTAL_060, (int) VERTICAL_017), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_019, (int) HORIZONTAL_008, (int) VERTICAL_019), // Batteur 5
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_020, (int) HORIZONTAL_008, (int) VERTICAL_020), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_019, (int) HORIZONTAL_060, (int) VERTICAL_019), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_020, (int) HORIZONTAL_060, (int) VERTICAL_020), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_022, (int) HORIZONTAL_008, (int) VERTICAL_022), // Batteur 6
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_023, (int) HORIZONTAL_008, (int) VERTICAL_023), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_022, (int) HORIZONTAL_060, (int) VERTICAL_022), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_023, (int) HORIZONTAL_060, (int) VERTICAL_023), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_025, (int) HORIZONTAL_008, (int) VERTICAL_025), // Batteur 7
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_026, (int) HORIZONTAL_008, (int) VERTICAL_026), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_025, (int) HORIZONTAL_060, (int) VERTICAL_025), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_026, (int) HORIZONTAL_060, (int) VERTICAL_026), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_028, (int) HORIZONTAL_008, (int) VERTICAL_028), // Batteur 8
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_029, (int) HORIZONTAL_008, (int) VERTICAL_029), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_028, (int) HORIZONTAL_060, (int) VERTICAL_028), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_029, (int) HORIZONTAL_060, (int) VERTICAL_029), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_031, (int) HORIZONTAL_008, (int) VERTICAL_031), // Batteur 9
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_032, (int) HORIZONTAL_008, (int) VERTICAL_032), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_031, (int) HORIZONTAL_060, (int) VERTICAL_031), //
			new Rectangle((int) HORIZONTAL_PA_POSITION, (int) VERTICAL_032, (int) HORIZONTAL_060, (int) VERTICAL_032), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_034, (int) HORIZONTAL_060, (int) VERTICAL_034), // Comptage batteur
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_035, (int) HORIZONTAL_060, (int) VERTICAL_035), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_036, (int) HORIZONTAL_060, (int) VERTICAL_036), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_037, (int) HORIZONTAL_060, (int) VERTICAL_037), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_038, (int) HORIZONTAL_060, (int) VERTICAL_038), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_039, (int) HORIZONTAL_060, (int) VERTICAL_039), //

			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_042, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_042), // Stat lanceur
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_043, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_043), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_044, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_044), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_045, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_045), //
			new Rectangle((int) HORIZONTAL_000, (int) VERTICAL_046, (int) HORIZONTAL_PA_POSITION, (int) VERTICAL_046), //

			/* dessin des ligens verticales */
			new Rectangle((int) HORIZONTAL_001, (int) VERTICAL_005, (int) HORIZONTAL_001, (int) VERTICAL_040), // Stat defensives
			new Rectangle((int) HORIZONTAL_001, (int) VERTICAL_041, (int) HORIZONTAL_001, (int) VERTICAL_048), //
			new Rectangle((int) HORIZONTAL_002, (int) VERTICAL_005, (int) HORIZONTAL_002, (int) VERTICAL_040), //
			new Rectangle((int) HORIZONTAL_002, (int) VERTICAL_041, (int) HORIZONTAL_002, (int) VERTICAL_048), //
			new Rectangle((int) HORIZONTAL_004, (int) VERTICAL_005, (int) HORIZONTAL_004, (int) VERTICAL_040), //
			new Rectangle((int) HORIZONTAL_004, (int) VERTICAL_041, (int) HORIZONTAL_004, (int) VERTICAL_048), //
			new Rectangle((int) HORIZONTAL_006, (int) VERTICAL_006, (int) HORIZONTAL_006, (int) VERTICAL_048), //

			new Rectangle((int) HORIZONTAL_007, (int) VERTICAL_005, (int) HORIZONTAL_007, (int) VERTICAL_040), // Numéro de maillot lanceur
			new Rectangle((int) HORIZONTAL_007, (int) VERTICAL_041, (int) HORIZONTAL_007, (int) VERTICAL_047), //

			new Rectangle((int) HORIZONTAL_AB_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_AB_POSITION,
					(int) VERTICAL_041), // Seperation AB
			new Rectangle((int) HORIZONTAL_RUN_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_RUN_POSITION,
					(int) VERTICAL_041), // Seperation R
			new Rectangle((int) HORIZONTAL_3B_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_3B_POSITION,
					(int) VERTICAL_041), // Seperation 3B
			new Rectangle((int) HORIZONTAL_HR_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_HR_POSITION,
					(int) VERTICAL_041), // Seperation HR
			new Rectangle((int) HORIZONTAL_SF_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_SF_POSITION,
					(int) VERTICAL_041), // Seperation SF
			new Rectangle((int) HORIZONTAL_HP_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_HP_POSITION,
					(int) VERTICAL_041), // Seperation HP
			new Rectangle((int) HORIZONTAL_IO_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_IO_POSITION,
					(int) VERTICAL_041), // Seperation IO
			new Rectangle((int) HORIZONTAL_CS_POSITION, (int) VERTICAL_005, (int) HORIZONTAL_CS_POSITION,
					(int) VERTICAL_041), // Seperation CS

			/* Statistique pitcher */
			new Rectangle((int) STAT_PITCHER_002, (int) VERTICAL_040, (int) STAT_PITCHER_002, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_003, (int) VERTICAL_040, (int) STAT_PITCHER_003, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_007, (int) VERTICAL_040, (int) STAT_PITCHER_007, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_008, (int) VERTICAL_040, (int) STAT_PITCHER_008, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_010, (int) VERTICAL_040, (int) STAT_PITCHER_010, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_013, (int) VERTICAL_040, (int) STAT_PITCHER_013, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_014, (int) VERTICAL_040, (int) STAT_PITCHER_014, (int) VERTICAL_048),
			new Rectangle((int) STAT_PITCHER_017, (int) VERTICAL_040, (int) STAT_PITCHER_017, (int) VERTICAL_048),

			/* Statistique catcheur */
			new Rectangle((int) STAT_CATCHER_SB, (int) VERTICAL_040, (int) STAT_CATCHER_SB, (int) VERTICAL_048),
			new Rectangle((int) STAT_CATCHER_CS, (int) VERTICAL_040, (int) STAT_CATCHER_CS, (int) VERTICAL_048) };

	/** Name separator position */ 
	private static final double NAME_SEPARATOR_VISITOR = HORIZONTAL_027 + (ACTION_WIDTH / 3 * FACTOR_CORRECTIF);
	/** Score separator position */ 
	private static final double SCORE_SEPARATOR_VISITOR = NAME_SEPARATOR_VISITOR + 38.9 * FACTOR_CORRECTIF;
	/** NuUmber separator position */ 
	private static final double NUMBER_SEPARATOR_VISITOR = HORIZONTAL_015 + (3 * ACTION_WIDTH / 2 * FACTOR_CORRECTIF);

	/** Array which contains the graphical horizontal position of the actions squares */
	protected static final double[] actionAreaHorizontal = { HORIZONTAL_009, HORIZONTAL_011, HORIZONTAL_013,
			HORIZONTAL_015, HORIZONTAL_017, HORIZONTAL_019, HORIZONTAL_021, HORIZONTAL_023, HORIZONTAL_025,
			HORIZONTAL_027, HORIZONTAL_029, HORIZONTAL_031 };

	/** Square correction in the Y axe */
	private static final int[] squareCorrectionY = { 0, 0, -1, -1, -1, -1, 0, -1, -1, -1 };
	/** Square correction in the X axe */
	private static final int[] squareCorrectionX = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 };
	
	/** Font name */
	private static final String FONT_NAME = "ArialNarrow"; //$NON-NLS-1$

	/** Font  size 4 bold */
	protected Font bold4Font;
	/** Font  size 5 bold */
	protected Font bold5Font;
	/** Font  size 6 bold */
	protected Font bold6Font;
	/** Font  size 7 bold */
	protected Font bold7Font;
	/** Font  size 10 bold */
	protected Font bold10Font;
	/** Font  size 12 bold */
	protected Font bold12Font;
	/** Font  size 14 bold */
	private Font bold14Font;
	/** Font  size 4 normal */
	protected Font normal4Font;
	/** Font  size 5 normal */
	private Font normal5Font;
	/** Font  size 6 normal */
	protected Font normal6Font;
	/** Font  size 7 normal */
	protected Font normal7Font;
	/** Font  size 8 normal */
	protected Font normal8Font;
	/** Font  size 2 normal for index */
	protected Font normal2FontIndex;

	/** the Strike counter */
	protected int kCounter;
	/** The base on ball counter */
	protected int bbCounter;
	/** Hit by pitch counter */
	protected int hpCounter;

	/** Collection of player square managers : Key = visitor or hometeam */
	protected HashMap<String, PlayerSquareManager> playerSquareManagers;

	/** Reference on the graphical context */
	protected Graphics2D g2;

	/** Name of the team (visitor or hometeam) which is currently drawing */ 
	protected String sheetTeam;

	/** Number of batters */
	protected int nbBatters;

	/** Number of substitution by column */
	protected HashMap<String, Integer> countSubsByColumn;
	/** Line of runner out caught stealing for the current pitcher */
	protected List<LineupEntry> caugthStealingForPitchers;

	/** Reference on the statistic engine */
	protected StatisticEngine statistiqueEngine;

	/** Starting column for the inning */
	protected int startInningColumn;
	/** Ending column for the inning */
	protected int endInningColumn;
	/** Starting line for the inning */
	protected int startInningLine;

	/** Reference on the resume substitution teleprinter */ 
	protected Teleprinter substitutionResumeTelescriptor;

	/** Memorize put outs square position in case of double plays */
	private List<MultiplePlayContainer> putoutCases;
	
	/** HashMap< team , HashMap< OffensivePosition , HashMap< Square, Offset>>> */
	private HashMap<String,HashMap<String,HashMap<String,List<Integer>>>> offensiveSubstitutionGraphicalOffset;

	/**
	 * Initialize the class.
	 * Create fonts and initialize some fields
	 * 
	 */
	public ScoringSheetGraphicalManager() {
		normal4Font = new Font(FONT_NAME, 0, 4);
		normal5Font = new Font(FONT_NAME, 0, 5);
		normal6Font = new Font(FONT_NAME, 0, 6);
		normal7Font = new Font(FONT_NAME, 0, 7);
		normal8Font = new Font(FONT_NAME, 0, 8);
		bold4Font = new Font(FONT_NAME, Font.BOLD, 4);
		bold5Font = new Font(FONT_NAME, Font.BOLD, 5);
		bold6Font = new Font(FONT_NAME, Font.BOLD, 6);
		bold7Font = new Font(FONT_NAME, Font.BOLD, 7);
		bold10Font = new Font(FONT_NAME, Font.BOLD, 10);
		bold12Font = new Font(FONT_NAME, Font.BOLD, 12);
		bold14Font = new Font(FONT_NAME, Font.BOLD, 14);
		normal2FontIndex = new Font(FONT_NAME, 0, 2);

		nbBatters = 9;
		offensiveSubstitutionGraphicalOffset = new HashMap<>();
	}

	/**
	 * Set the number of batters.
	 *  
	 * @param nbBatters number of batters
	 */
	public void setNbBatters(int nbBatters) {
		this.nbBatters = nbBatters;
	}

	/**
	 * Get the dimension of the sheet
	 *  
	 * @return dimension of the sheet
	 */
	public static Dimension getBounds() {
		return new Dimension((int) (HORIZONTAL_060 + HORIZONTAL_MARGE), (int) (VERTICAL_048 + VERTICAL_MARGE));
	}

	/**
	 * Create the document.
	 * 
	 * @param game reference on the Game parsing result.  
	 * @param scoreEngine reference on the statistic engine
	 */
	public void createDocument(Game game, StatisticEngine scoreEngine) {
		/* Forma A4 : ==> 842 *595 ratio = 2.83 */

		offensiveSubstitutionGraphicalOffset = new HashMap<>();
		visitorLineup = new LineupManager();
		hometeamLineup = new LineupManager();
		playerSquareManagers = new HashMap<>();
		
		playerSquareManagers.put(EngineConstants.HOMETEAM, new PlayerSquareManager());

		playerSquareManagers.get(EngineConstants.HOMETEAM).addChangeRowListener((newRow,motif) ->  updateGraphicForNewRow(newRow, motif));

		playerSquareManagers.put(EngineConstants.VISITOR, new PlayerSquareManager());
		playerSquareManagers.get(EngineConstants.VISITOR).addChangeRowListener((newRow,motif) ->  updateGraphicForNewRow(newRow, motif));
	}

	/**
	 * Fill the visitor sheet with the game parsing result.

	 * @param g2 reference on the graphical context
	 * @param game game parsing result
	 * @param statistiqueEngine reference on the statistic engine
	 */
	public void fillVisitorSheet(Graphics2D g2, Game game, StatisticEngine statistiqueEngine) {

		caugthStealingForPitchers = new ArrayList<>();
		this.g2 = g2;

		g2.setColor(EngineConstants.graphicsColorSheet);

		this.statistiqueEngine = statistiqueEngine;
		kCounter = 0;
		bbCounter = 0;
		hpCounter = 0;

		if (game != null) {

			/* Creation de la page visiteur */
			sheetTeam = EngineConstants.VISITOR;
			createEmptyVisitorPage();
			fillHeaderVisitorPage(game);

			LineupManager lineup = statistiqueEngine.getActionsManager().getVisitorLineup();

			if (lineup != null) {
				fillLineupPart(lineup);
			}
			fillGeneralScore(statistiqueEngine);

			StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
			if (statistiqueManager != null) {
				GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
				GameStatisticContainer container = statistiqueManager.getStatisticContainer();

				if (stats != null && container != null) {
					TeamStatistic visitorStats = container.getVisitorStatistic(stats);
					TeamStatistic oppositStats = container.getHomeTeamStatistic(stats);
					fillTeamStatistics(visitorStats, lineup);
					fillControlPart(visitorStats, oppositStats);

					fillPitcherCaugthStealingIfNecessary();
				}
			}

		} else {

			/* Creation de la page visiteur */
			createEmptyVisitorPage();
		}

		releaseGraphicalContext();
	}

	/**
	 * Fill the home team sheet with the game parsing result.

	 * @param g2 reference on the graphical context
	 * @param game game parsing result
	 * @param statistiqueEngine reference on the statistic engine
	 */
	public void fillHometeamSheet(Graphics2D g2, Game game, StatisticEngine statistiqueEngine) {

		caugthStealingForPitchers = new ArrayList<>();
		this.g2 = g2;
		g2.setColor(EngineConstants.graphicsColorSheet);

		this.statistiqueEngine = statistiqueEngine;
		kCounter = 0;
		bbCounter = 0;
		hpCounter = 0;

		if (game != null) {

			sheetTeam = EngineConstants.HOMETEAM;
			createEmptyHomeTeamPage();
			fillHeaderHomeTeamPage(game);

			LineupManager lineup = statistiqueEngine.getActionsManager().getHometeamLineup();

			if (lineup != null) {
				fillLineupPart(lineup);
			}

			StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
			if (statistiqueManager != null) {
				GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
				GameStatisticContainer container = statistiqueManager.getStatisticContainer();

				if (stats != null && container != null) {
					TeamStatistic hometeamStats = container.getHomeTeamStatistic(stats);
					TeamStatistic oppositStats = container.getVisitorStatistic(stats);

					fillTeamStatistics(hometeamStats, lineup);
					fillControlPart(hometeamStats, oppositStats);

					fillPitcherCaugthStealingIfNecessary();
				}
			}

		} else {

			/* Creation de la page hometeam */
			createEmptyHomeTeamPage();
		}

		releaseGraphicalContext();
	}

	/**
	 * Releaser the graphical context
	 */
	public void releaseGraphicalContext() {
		// Nothing to do here
	}

	/**
	 * Fill the mire
	 */
	public void fillMire() {
		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 13; y++) {
				drawAdvance(0, 4, new Point(x, y), null);
			}
		}
	}

	/** 
	 * Update the graphical content in case of detection of new row usage .
	 * 
	 * @param newRow new row number 
	 * @param motif motif of the new row
	 */
	protected void updateGraphicForNewRow(int newRow, int motif) {

		if (motif == PlayerSquareManager.DURING_INNING) {
			createSubstitutionTelescripteur(newRow);
		}
	}

	/**
	 * Create a scriptor for display the substitution resume for a column.
	 * 
	 * @param row new row number
	 */
	private void createSubstitutionTelescripteur(int row) {
		List<TeleprinterLineDescripter> lineDescriptors = new ArrayList<>();
		Point pointDrawPosition = getPosition(row, row);
		lineDescriptors
				.add(new TeleprinterLineDescripter(new Point(pointDrawPosition.x + 9, (int) VERTICAL_004), 7));
		lineDescriptors
				.add(new TeleprinterLineDescripter(new Point(pointDrawPosition.x + 9, (int) (VERTICAL_004 + 7)), 7));
		lineDescriptors
				.add(new TeleprinterLineDescripter(new Point(pointDrawPosition.x, (int) (VERTICAL_004 + 14)), 12));

		substitutionResumeTelescriptor = new Teleprinter(lineDescriptors);
	}

	@Override
	public void startInning(HalfInning halfInning) {
		countSubsByColumn = new HashMap<>();

		if (sheetTeam.equals(halfInning.getTeam())) {

			Point point = playerSquareManagers.get(halfInning.getTeam()).getCurrentPosition();
			runnerPositionManager.clearField();

			startInningColumn = point.y;
			startInningLine = point.x;
			createSubstitutionTelescripteur(startInningColumn);

		}
		super.startInning(halfInning);
	}

	@Override
	public void closeInning(HalfInning halfInning) {

		if (sheetTeam.equals(halfInning.getTeam())) {

			playerSquareManagers.get(halfInning.getTeam()).endOfInning();
			Point point = playerSquareManagers.get(halfInning.getTeam()).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			endInningColumn = point.y;
			drawEndOfInning(pointDrawPosition);

			int inningNumber = halfInning.getNumber();

			StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
			GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
			GameStatisticContainer container = statistiqueManager.getStatisticContainer();
			TeamStatistic teamStatistic = ( sheetTeam.equals(EngineConstants.HOMETEAM) 
					? container.getHomeTeamStatistic(stats)
					: container.getVisitorStatistic(stats));

			try {
				fillGeneralStatistics(teamStatistic.getGeneralInningStats().get(inningNumber - 1), inningNumber - 1, point.y - 2);
			} catch (IndexOutOfBoundsException ex) {
				logger.log(Level.SEVERE,ex.getMessage());
			}

		}
		super.closeInning(halfInning);
	}

	@Override
	public void startAction(String team, Action action) {
		super.startAction(team, action);
		if (sheetTeam.equals(team)) {
			putoutCases = new ArrayList<>();
		}
	}

	@Override
	public void closeAction(String team, Action element) {
		super.closeAction(team, element);

		if (sheetTeam.equals(team) && (putoutCases.size() > 1)) {
			Collections.sort(putoutCases);
			for (int i = 0; i < putoutCases.size() - 1; i++) {
				drawDoublePutout(putoutCases.get(i), putoutCases.get(i + 1));
			}
		}
	}

	@Override
	public void makeCommand(SelectedBatterCommand selectedBatterCommand) {
		super.makeCommand(selectedBatterCommand);

		PlayerSquareManager playerSquareManager = playerSquareManagers.get(currentTeam);
		playerSquareManager.setBatterPosition(currentLineup.getCurrentBatterNumber());

		startInningLine = selectedBatterCommand.getStarterBatter();

	}

	@Override
	public void makeCommand(MoveCommand command) {
		super.makeCommand(command);

		PlayerSquareManager playerSquareManager = playerSquareManagers.get(currentTeam);
		playerSquareManager.setColumnPosition(command.getColumnNumber());

		startInningColumn = command.getColumnNumber();
	}

	/**
	 * Draw the end of inning
	 * 
	 * @param playerCurrentPosition Current position player square
	 */
	private void drawEndOfInning(Point playerCurrentPosition) {
		g2.drawLine(playerCurrentPosition.x + 4, playerCurrentPosition.y - 4, playerCurrentPosition.x - 4,
				playerCurrentPosition.y + 4);
	}

	@Override
	public void closeGame() {
		
		LineupManager lineup = (sheetTeam.equals(EngineConstants.HOMETEAM) ? hometeamLineup : visitorLineup);
		for (Entry<String, LineupEntry> entry : lineup.getOffensivePlayers().entrySet()) {
			LineupEntry player = entry.getValue();

			if (player.getAssociatedObjects().containsKey(DRAW_SUBSTITUTION)) {
				Boolean needToDrawSubstitution = (Boolean) player.getAssociatedObjects().get(DRAW_SUBSTITUTION);
				if (needToDrawSubstitution.booleanValue()) {

					player.getAssociatedObjects().put(DRAW_SUBSTITUTION, false);
				}
			}
		}
		
		drawAllOffensiveSubstitution(sheetTeam);
	}

	@Override
	public void manageTieBreak() throws OccupedbaseException {
		super.manageTieBreak();

		if (sheetTeam.equals(currentTeam)) {

			int offensivePosition = currentLineup.getCurrentBatterNumber();

			for (int pos = 1; pos < 3; pos++) {

				offensivePosition -= 1;
				if (offensivePosition == 0) {
					offensivePosition = 9;
				}

				Point currentPosition = playerSquareManagers.get(currentTeam).getCurrentPosition();
				Point point = new Point(offensivePosition, currentPosition.y);
				LineupEntry player = currentLineup.getPlayerForOffensivePosition(EMPTY_STRING + offensivePosition);

				Point pointDrawPosition = getPosition(point.x, point.y);
				drawStringInSquarePosition(bold7Font, "TIE", pointDrawPosition, pos); //$NON-NLS-1$
				player.getAssociatedObjects().put(SQUARE_POSITION, point);

				drawAdvance(0, pos, point, null);
			}
		}
	}

	@Override
	protected void manage(BatterAction action) throws OccupedbaseException {

		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			LineupEntry player = currentLineup.getPlayerForOffensivePosition(EMPTY_STRING + point.x);

			/* Used for draw offensive substitution */
			if (player.getAssociatedObjects().containsKey(DRAW_SUBSTITUTION)) {

				Boolean needToDraw = (Boolean) player.getAssociatedObjects().get(DRAW_SUBSTITUTION);
				if (Boolean.TRUE.equals(needToDraw)) {

					player.getAssociatedObjects().put(DRAW_SUBSTITUTION, false);
				}
			}
		}
		super.manage(action);
	}

	@Override
	public void manage(Action action) throws OccupedbaseException {

		if (runnerPositionManager.getPlayerAtPosition(0) == null) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			runnerPositionManager.setNewBatter();
			runnerPositionManager.linkObjectToPlayer(0, SQUARE_POSITION, new Point(point.x, point.y));
		}

		super.manage(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnOtherPlayerError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, EMPTY_STRING + ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNoDecisiveObstruction action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnDefensiveChoice moreAdvance) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(moreAdvance), pointDrawPosition,
					runnerPosition + 1);

			if (!(moreAdvance.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, moreAdvance.getIsEarned());

			super.makeActionOn(moreAdvance);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveFlyError moreAdvance) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(moreAdvance);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(moreAdvance), pointDrawPosition,
					runnerPosition + 1);

			if (!(moreAdvance.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, moreAdvance.getIsEarned());

			super.makeActionOn(moreAdvance);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnRule action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveReceiveError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnNonDecisiveThrowError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnReceiveError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnThrowError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnIndiference action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnThrow action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + baseWin);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnOccupedBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + baseWin);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnCaughtStealingWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			int batterNumber = currentLineup.getCurrentBatterNumber();
			drawCurrentBatter(batterNumber, pointDrawPosition, runnerPosition + 1);
			drawStringInSquarePosition(bold6Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnPickOffWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			int batterNumber = currentLineup.getCurrentBatterNumber();
			drawCurrentBatter(batterNumber, pointDrawPosition, runnerPosition + 1);
			drawStringInSquarePosition(bold6Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}
			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnBalk action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font,
					ScoreGameDisplay.getDisplayCode(action)
							+ getBatterNumberForThisAction(),
					pointDrawPosition, runnerPosition + baseWin);

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnDecisiveObstruction action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + 1);

			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
		}
		super.makeActionOn(action);
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnPassBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font,
					ScoreGameDisplay.getDisplayCode(action)
							+ getBatterNumberForThisAction(),
					pointDrawPosition, runnerPosition + 1);

			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnWildPitch action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font,
					ScoreGameDisplay.getDisplayCode(action) + "\n" //$NON-NLS-1$
							+ getBatterNumberForThisAction(),
					pointDrawPosition, runnerPosition + 1);

			if (baseWin > 1) {
				drawMoreAdvanceArrow(runnerPosition + 1, runnerPosition + baseWin, pointDrawPosition);
			}

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnStolenBase action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font,
					ScoreGameDisplay.getDisplayCode(action)
							+ +getBatterNumberForThisAction(),
					pointDrawPosition, runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnFielderChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceOnError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, EMPTY_STRING + action.getRunnerAdvance().substring(0, 3), pointDrawPosition,
					runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerAdvanceByBatterAction action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, EMPTY_STRING + currentLineup.getCurrentBatterNumber(), pointDrawPosition,
					runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, action.getIsEarned());
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerOutOnAppeal action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawRunnerOut(EMPTY_STRING + ScoreGameDisplay.getDisplayCode(action), point, runnerPosition,
					!action.isNotInDoublePlay());

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerOutByRules action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawRunnerOutByObr(EMPTY_STRING + ScoreGameDisplay.getDisplayCode(action), ScoreGameUtil.getOBRType(action), point,
					runnerPosition, !action.isNotInDoublePlay());

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerOutOnFielderAction action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawRunnerOut(EMPTY_STRING + action.getRunnerOut(), point, runnerPosition, !action.isNotInDoublePlay());

			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerOutOnPickOff action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawRunnerOut(EMPTY_STRING + action.getRunnerOut(), point, runnerPosition, !action.isNotInDoublePlay());

			int batterNumber = currentLineup.getCurrentBatterNumber();
			drawCurrentBatter(batterNumber, pointDrawPosition, runnerPosition + 1);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerOutOnCaugthStealing action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			int batterNumber = currentLineup.getCurrentBatterNumber();
			drawCurrentBatter(batterNumber, pointDrawPosition, runnerPosition + 1);
			drawRunnerOut(ScoreGameDisplay.getDisplayCode(action), point, runnerPosition, !action.isNotInDoublePlay());

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerMustBeOutOnError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;

			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawStringInSquarePosition(bold7Font, ScoreGameDisplay.getDisplayCode(action), pointDrawPosition,
					runnerPosition + baseWin);
			drawAdvance(runnerPosition, baseWin, point, null);
			if (!(action.eContainer() instanceof Action)) {
				drawContinuation(runnerPosition, pointDrawPosition);
			}

			super.makeActionOn(action);
		}
	}

	/*
	 * ---------------------------------------------------------------------------
	 * ------------------------------
	 */
	/* Manage the batters */
	/*
	 * ---------------------------------------------------------------------------
	 * ------------------------------
	 */
	@Override
	public void makeActionOn(RunnerDontAdvanceOnError action) {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), 1, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnPickOffWithError action) {
		if (currentTeam.equals(sheetTeam)) {

			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnCaughtStealingWithError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);
			int batterNumber = currentLineup.getCurrentBatterNumber();
			drawCurrentBatter(batterNumber, pointDrawPosition, runnerPosition);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnThrowError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnReceiveError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveThrowError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(RunnerDontAdvanceOnNonDecisiveReceiveError action) {
		if (currentTeam.equals(sheetTeam)) {
			int runnerPosition;
			if (action.eContainer() instanceof Action) {
				runnerPosition = ScoreGameUtil.getRunnerNumber(action.getRunner());
			} else {
				runnerPosition = runnerPositionManager.getLastPlayerPositionSetted();
			}

			Point point = (Point) runnerPositionManager.getPlayerAssociatedObject(runnerPosition, SQUARE_POSITION);
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawPlayerMustBeOut(action.getActionCode(), runnerPosition, pointDrawPosition);

			super.makeActionOn(action);
		}
	}

	/*
	 * ---------------------------------------------------------------------------
	 * ------------------------------
	 */
	/* Manage the batters */
	/*
	 * ---------------------------------------------------------------------------
	 * ------------------------------
	 */
	@Override
	public void makeActionOn(BatterMustOutOnFlyFoulBall action) {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawBatterMustBeOut("E" + ScoreGameUtil.getLocation(action), pointDrawPosition); //$NON-NLS-1$

			super.makeActionOn(action);
		}
	}

	@Override
	public void makeActionOn(BatterLostTurn action) {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			drawBatterLostTurn(point.x, point.y);

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnDefensiveChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvanceOnFirstBase(point);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}
	
	@Override
	public void makeActionOn(BatterAdvanceOnIndiference action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvanceOnFirstBase(point);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterBalk action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvanceOnFirstBase(point);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnOccupedBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWithFielderChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);
			kCounter = putCounter(point.x, point.y, kCounter);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnObstruction action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnCatcherInterference action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithFielderChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeFlyWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}
			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}

			drawAdvance(0, baseWin, point, null);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithFielderChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);
			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSacrificeHitWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}
			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericActionMultiline(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}
			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			kCounter = putCounter(point.x, point.y, kCounter);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKAbr action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, 1, point, null);
			kCounter = putCounter(point.x, point.y, kCounter);
			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKWildPitch action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}
			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			kCounter = putCounter(point.x, point.y, kCounter);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnKPassBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			drawAdvance(0, 1, point, null);
			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}
			kCounter = putCounter(point.x, point.y, kCounter);

			super.makeActionOn(action);
			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnHitByPitch action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction("HP", pointDrawPosition); //$NON-NLS-1$
			drawAdvance(0, 1, point, null);
			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}
			hpCounter = putCounter(point.x, point.y, hpCounter);

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnIntentionalBaseOnBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction("IBB", pointDrawPosition); //$NON-NLS-1$
			drawAdvance(0, 1, point, null);
			bbCounter = putCounter(point.x, point.y, bbCounter);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnBaseOnBall action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction("BB", pointDrawPosition); //$NON-NLS-1$
			drawAdvance(0, 1, point, null);
			bbCounter = putCounter(point.x, point.y, bbCounter);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnInsidePark action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawHomeRunHit("IHR", pointDrawPosition, ScoreGameDisplay.getDisplayCode(action)); //$NON-NLS-1$
			drawAdvance(0, 4, point, action.getIsEarned());

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(4, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnHomeRun action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawHomeRunHit("HR", pointDrawPosition, ScoreGameDisplay.getDisplayCode(action)); //$NON-NLS-1$
			drawAdvance(0, 4, point, action.getIsEarned());

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(4, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnTripleHit action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawTripleHit(pointDrawPosition, ScoreGameDisplay.getDisplayCode(action));
			drawAdvance(0, 3, point, null);

			if (action.getOut() != null) {
				drawContinuation(3, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(3, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnDoubleHit action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawDoubleHit(pointDrawPosition, ScoreGameDisplay.getDisplayCode(action));
			drawAdvance(0, 2, point, null);

			if (action.getOut() != null) {
				drawContinuation(2, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(2, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnSingleHit action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);
			drawSingleHit(pointDrawPosition, ScoreGameDisplay.getDisplayCode(action));
			drawAdvance(0, 1, point, null);

			if (action.getOut() != null) {
				drawContinuation(1, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(1, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnGdpWithError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnGdpWithFielderChoice action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnThrowError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}

			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnReceiveError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnFlyError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterAdvanceOnPopError action) throws OccupedbaseException {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			int baseWin = ScoreGameAdvanceUtil.getBaseWin(action);

			Point pointDrawPosition = getPosition(point.x, point.y);
			drawBatterGenericAction(ScoreGameDisplay.getDisplayCode(action), pointDrawPosition);
			drawAdvance(0, baseWin, point, null);
			if (baseWin > 1) {
				drawMoreAdvanceArrow(1, baseWin, pointDrawPosition);
			}

			if (action.getOut() != null) {
				drawContinuation(baseWin, pointDrawPosition);
			}
			super.makeActionOn(action);

			runnerPositionManager.linkObjectToPlayer(baseWin, SQUARE_POSITION, new Point(point.x, point.y));
			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnInfieldFly action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeHit action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeFlyFallBall action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnSacrificeFly action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnGroundedDoublePlay action) {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnAppeal action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutByRule action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			Point pointDrawPosition = getPosition(point.x, point.y);

			if (action.getBatterOut().equals("OBRKS-2")) { //$NON-NLS-1$
				drawBatterPutOutByRule(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), "2", //$NON-NLS-1$
						pointDrawPosition, !action.isNotInDoublePlay());
			} else {
				drawBatterPutOutByRule(point.x, point.y, ScoreGameDisplay.getDisplayCode(action),
						ScoreGameUtil.getOBRType(action), pointDrawPosition, !action.isNotInDoublePlay());
			}

			String outCause = ScoreGameUtil.getOBRType(action);
			if ("KS".equals(outCause) || "2".equals(outCause)) { //$NON-NLS-1$ //$NON-NLS-2$
				kCounter = putCounter(point.x, point.y, kCounter);
			}

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnGroundedBall action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			String code = EMPTY_STRING + action.getBatterOut();
			if (action.isIsBunt()) {
				code += "b"; //$NON-NLS-1$
			}
			drawBatterPutOut(point.x, point.y, code, !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnLineDriveFallBall action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnPoppedFallBall action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnFlyedFallBall action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnPopped action) {
		if (currentTeam.equals(sheetTeam)) {
			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();

			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnLine action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnFlyed action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnReleasedStrike action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			drawBatterPutOut(point.x, point.y, ScoreGameDisplay.getDisplayCode(action), !action.isNotInDoublePlay());
			kCounter = putCounter(point.x, point.y, kCounter);

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnLookedStrike action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			kCounter = drawBatterPutOutWithCounter(point.x, point.y, "KL", kCounter, !action.isNotInDoublePlay()); //$NON-NLS-1$

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	public void makeActionOn(BatterOutOnSwingedStrike action) {
		if (currentTeam.equals(sheetTeam)) {

			Point point = playerSquareManagers.get(currentTeam).getCurrentPosition();
			kCounter = drawBatterPutOutWithCounter(point.x, point.y, "KS", kCounter, !action.isNotInDoublePlay()); //$NON-NLS-1$

			super.makeActionOn(action);

			playerSquareManagers.get(currentTeam).setNextBatterPosition();
		}
	}

	@Override
	@SuppressWarnings("java:S3776")
	protected void callCallbackSubstitutionManager(SubstitutionManager substitutionManager) {

		String team = substitutionManager.getTeam();
		LineupManager subLineup = (team.equals(EngineConstants.HOMETEAM) ? hometeamLineup : visitorLineup);
		boolean picherSubstitution = false;

		if (team.equals(sheetTeam)) {
			for (SubstitutionCommonData sub : substitutionManager.getSubstitutions()) {

				if (sub instanceof ReplacementData) {

					ReplacementData replacementData = (ReplacementData) sub;
					Point point = (Point) replacementData.getPlayer().getAssociatedObjects().get(SQUARE_POSITION);
					if (replacementData.getReplacement().getNewDefensivePosition().startsWith("pr")) { //$NON-NLS-1$

						Point pointDrawPosition = getPosition(point.x, point.y);
						int positionOnBase = this.runnerPositionManager.getPosition(replacementData.getPlayer());
						if (positionOnBase > 0 && positionOnBase < 4) {
							drawPitchRunnerSubstitution(pointDrawPosition, positionOnBase);
						}

					} else {
						
						LineupEntry newPlayer = subLineup.getPlayerForOffensivePosition(replacementData.getOffensivePosition());
						newPlayer.getAssociatedObjects().put(DRAW_SUBSTITUTION, true);
						if (!"-1".equals(replacementData.getOffensivePosition())) { //$NON-NLS-1$
							Point currentPosition = playerSquareManagers.get(team).getCurrentPosition();
						
							Point playerSquarePosition = new Point(currentPosition.y, Integer.parseInt(replacementData.getOffensivePosition()) ); 
							registerDrawLineForOffensiveSubstitution(team,playerSquarePosition);
						}	
					}
				}
			}

		} else { /* Changement dans l'équipe adverse */

			for (SubstitutionCommonData sub : substitutionManager.getSubstitutions()) {

				if (sub instanceof ReplacementData) {

					ReplacementData replacementData = (ReplacementData) sub;

					if (((replacementData.getReplacement().getNewDefensivePosition() == null)
							&& replacementData.getPlayer().getDefensivePosition().equals("1")) //$NON-NLS-1$
							|| (replacementData.getReplacement().getNewDefensivePosition() != null
									&& replacementData.getReplacement().getNewDefensivePosition().equals("1"))) { //$NON-NLS-1$
						
						Object pitcherKeepPosition = replacementData.getPlayerReplaced().getAssociatedObjects().get(LineupManager.PITCHER_KEEP_ITS_POSITION);
						if (pitcherKeepPosition == null) {
							picherSubstitution = true;
							hpCounter = 0;
							kCounter = 0;
							bbCounter = 0;
						}	
					}

				} else if ((sub instanceof MoveToData) && (((MoveToData) sub).getDefensivePosition() != null) && (((MoveToData) sub).getDefensivePosition().getNewDefensivePosition() != null) && 
						(((MoveToData) sub).getDefensivePosition().getNewDefensivePosition().equals("1"))) { //$NON-NLS-1$
						
					Object pitcherKeepPosition = ((MoveToData) sub).getPlayerReplaced().getAssociatedObjects().get(LineupManager.PITCHER_KEEP_ITS_POSITION);
					if ( (subLineup.getCurrentPitcher().getPlayerDescription() !=  ((MoveToData) sub).getPlayerReplaced().getPlayerDescription()) && 
							(pitcherKeepPosition == null))	{
							picherSubstitution = true;
							hpCounter = 0;
							kCounter = 0;
							bbCounter = 0;
					}
				}
			}

			/* Puis on construit l'affichage des changements */
			StringBuilder substitutionDescriptor = new StringBuilder();
			for (SubstitutionCommonData sub : substitutionManager.getSubstitutions()) {
				if (sub instanceof ReplacementData) {
					ReplacementData replacementData = (ReplacementData) sub;

					LineupEntry player = subLineup
							.getPlayerForDefensivePosition(replacementData.getReplacement().getNewDefensivePosition());
					if (!player.getDefensivePosition().equals("dh") && !player.getDefensivePosition().startsWith("pr") //$NON-NLS-1$ //$NON-NLS-2$
							&& !player.getDefensivePosition().equals("dp") //$NON-NLS-1$
							&& !player.getDefensivePosition().startsWith("ph")) { //$NON-NLS-1$
						
						if (!"0".contentEquals(player.getDefensivePositionIndex())) { //$NON-NLS-1$
							substitutionDescriptor.append(player.getDefensivePosition());
							substitutionDescriptor.append(player.getDefensivePositionIndex());
						}
					}

				} else if (sub instanceof MoveToData) {
					MoveToData moveToData = (MoveToData) sub;

					LineupEntry player = subLineup.getPlayerForDefensivePosition(moveToData.getDefensivePosition().getNewDefensivePosition());
					if (!player.getDefensivePosition().equals("dh") && !player.getDefensivePosition().startsWith("pr") //$NON-NLS-1$ //$NON-NLS-2$
							&& !player.getDefensivePosition().equals("dp") //$NON-NLS-1$
							&& !player.getDefensivePosition().startsWith("ph")) { //$NON-NLS-1$
						
						
						if (((MoveToData) sub).getDefensivePosition().getNewDefensivePosition().equals("1")) { //$NON-NLS-1$
							if (subLineup.getCurrentPitcher().getPlayerDescription() !=  ((MoveToData) sub).getPlayerReplaced().getPlayerDescription()) {
								if (!"0".contentEquals(player.getDefensivePositionIndex())) { //$NON-NLS-1$
									substitutionDescriptor.append(player.getDefensivePosition());
									substitutionDescriptor.append(player.getDefensivePositionIndex());
								}
							}
						} else {
							if (!"0".contentEquals(player.getDefensivePositionIndex())) { //$NON-NLS-1$
								substitutionDescriptor.append(player.getDefensivePosition());
								substitutionDescriptor.append(player.getDefensivePositionIndex());
							}
						}
					}
				}
			}

			Point currentPosition = playerSquareManagers.get(sheetTeam).getCurrentPosition();

			if (!countSubsByColumn.containsKey(EMPTY_STRING + currentPosition.y)) {
				countSubsByColumn.put(EMPTY_STRING + currentPosition.y, 1);
			} else {
				countSubsByColumn.put(EMPTY_STRING + currentPosition.y,
						countSubsByColumn.get(EMPTY_STRING + currentPosition.y).intValue() + 1);
			}

			if (substitutionDescriptor.toString().length() > 0) {
				drawSubstitutionResume(currentPosition.y, countSubsByColumn.get(EMPTY_STRING + currentPosition.y).intValue(),
						substitutionDescriptor.toString());

				Point pointDrawPosition = getPosition(currentPosition.x, currentPosition.y);
				drawDefensiveSubstitutionLine(pointDrawPosition, picherSubstitution);
			}
		}
	}

	/**
	 * Draw the resume of the substitution.
	 * 
	 * @param y Column number
	 * @param line Line number
	 * @param substitutionDescriptor reference on the scriptor
	 */
	@SuppressWarnings("java:S3776")
	private void drawSubstitutionResume(int y, int line, String substitutionDescriptor) {
		/* position defensive */
		int nbChars = line == 1 ? 6 : 12;
		String strToProcess = substitutionDescriptor;
		int i = 0;
		while (strToProcess.length() > 0) {

			String subPart = strToProcess.substring(0, Math.min(nbChars, strToProcess.length()));
			for (i = 0; i < subPart.length(); i++) {
				char character = subPart.charAt(i);
				if ((i % 2) == 0) {
					substitutionResumeTelescriptor.pushChar(g2, character, normal6Font,
							EngineConstants.graphicsColorPencil, 0);
				} else {
					substitutionResumeTelescriptor.pushChar(g2, character, normal4Font,
							EngineConstants.graphicsColorPencil, -2);
				}
			}

			strToProcess = strToProcess.replaceFirst(subPart, EMPTY_STRING);
			if (strToProcess.length() == 0) {
				substitutionResumeTelescriptor.pushChar(g2, '/', normal6Font, EngineConstants.graphicsColorPencil, 0);
			} else {
				if (!substitutionResumeTelescriptor.leftPlaceFor(2)) {
					substitutionResumeTelescriptor.newLine();
				}
			}

			line++;
			nbChars = line == 1 ? 6 : 12;
		}
		substitutionResumeTelescriptor.newLine();
	}

	/**
	 * Drax a itch runner substitution
	 * 
	 * @param pointDrawPosition Where to draw
	 * @param positionOnBase On which base
	 */
	private void drawPitchRunnerSubstitution(Point pointDrawPosition, int positionOnBase) {
		switch (positionOnBase) {

		case 1:
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH * 2 / 3,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 - 1, pointDrawPosition.x + 1 + ACTION_PLACE_WIDTH,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 - 1);
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH * 2 / 3, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x + 1 + ACTION_PLACE_WIDTH, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2);
			break;

		case 2:
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 - 1, pointDrawPosition.y,
					pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 - 1, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 3);
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2, pointDrawPosition.y,
					pointDrawPosition.x + ACTION_PLACE_WIDTH / 2, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 3);
			break;

		case 3:
			g2.drawLine(pointDrawPosition.x, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 1,
					pointDrawPosition.x + ACTION_PLACE_WIDTH * 1 / 3,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 1);
			g2.drawLine(pointDrawPosition.x, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x + ACTION_PLACE_WIDTH * 1 / 3, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2);
			break;
		}
	}

	/**
	 * Draw all offensives substitutions. 
	 * 
	 * @param currentTeam team name (visitor or hometeam)
	 */
	@SuppressWarnings("java:S3776")
	private void drawAllOffensiveSubstitution(String currentTeam) {
		HashMap<String, HashMap<String, List<Integer>>> positionsForTeam = offensiveSubstitutionGraphicalOffset.get(currentTeam);

		if (positionsForTeam != null)  {
			for (Entry<String, HashMap<String, List<Integer>>> offensivePositionEntry : positionsForTeam.entrySet()) {
				String offensivePosition = offensivePositionEntry.getKey();
				
				if (offensivePositionEntry != null) {
					for (Entry<String, List<Integer>> squareToDrawEntry : offensivePositionEntry.getValue().entrySet()) {
						String squareToDraw = squareToDrawEntry.getKey();
						
						if (squareToDrawEntry != null) {
							for (Integer extraOffet : squareToDrawEntry.getValue()) {
								drawOffensiveSubstitutionLine(new Point(Integer.parseInt(squareToDraw),Integer.parseInt(offensivePosition)), extraOffet.intValue());
							}
						}
					}
				}
			}
		}
	}

	/** 
	 * Draw the offensive line substitution.
	 * 
	 * @param squareToDraw Which square
	 * @param offset needed offset when for more one substitution
	 */
	private void drawOffensiveSubstitutionLine(Point squareToDraw, int offset ) {
		
		Point pointDrawPosition = getPosition(squareToDraw.y, squareToDraw.x);
		
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + offset - 1, pointDrawPosition.y, pointDrawPosition.x + offset - 1 ,
				pointDrawPosition.y + ACTION_PLACE_HEIGHT);
		g2.drawLine(pointDrawPosition.x + offset + 0, pointDrawPosition.y, pointDrawPosition.x + offset + 0 ,
				pointDrawPosition.y + ACTION_PLACE_HEIGHT);
	}

	/**
	 * Draw defensive line substitution.
	 * 
	 * @param pointDrawPosition Where to draw
	 * @param pitcherSubstitution Indicate if it is a pitcher substitution
	 */
	private void drawDefensiveSubstitutionLine(Point pointDrawPosition, boolean pitcherSubstitution) {
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x, pointDrawPosition.y - 1, pointDrawPosition.x + ACTION_PLACE_WIDTH,
				pointDrawPosition.y - 1);
		g2.drawLine(pointDrawPosition.x, pointDrawPosition.y, pointDrawPosition.x + ACTION_PLACE_WIDTH,
				pointDrawPosition.y);
		g2.drawLine(pointDrawPosition.x, pointDrawPosition.y + 1, pointDrawPosition.x + ACTION_PLACE_WIDTH,
				pointDrawPosition.y + 1);

		if (pitcherSubstitution) {
			g2.drawLine(pointDrawPosition.x, pointDrawPosition.y, pointDrawPosition.x - 4, pointDrawPosition.y - 4);
			g2.drawLine(pointDrawPosition.x, pointDrawPosition.y - 1, pointDrawPosition.x - 4, pointDrawPosition.y - 5);

			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH, pointDrawPosition.y,
					pointDrawPosition.x + ACTION_PLACE_WIDTH + 4, pointDrawPosition.y - 4);
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH, pointDrawPosition.y - 1,
					pointDrawPosition.x + ACTION_PLACE_WIDTH + 4, pointDrawPosition.y - 5);
		}
	}

	/**
	 * Draw the line which indicate that runner reach the marble.
	 *
	 * @param graphicalPosition Square coordinate where to draw
	 * @param isEarned indicate if it is a earned point 
	 */
	private void drawAdvanceOnMarbleBase(Point graphicalPosition, String isEarned) {
		g2.setColor(EngineConstants.graphicsColorPencil);

		Point pointDrawPosition = getPosition(graphicalPosition.x, graphicalPosition.y);
		if ((isEarned != null) && (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques))) {

			if ("earned".equals(isEarned)) { //$NON-NLS-1$
				Polygon polygon = new Polygon();
				polygon.addPoint(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT * 2 / 3);

				polygon.addPoint(
						pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + 1 + ACTION_PLACE_WIDTH * 2 / 3,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2);

				polygon.addPoint(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 3);

				polygon.addPoint(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 3,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2);

				g2.fillPolygon(polygon);

			} else if ("unEarnedForTeam".equals(isEarned)) { //$NON-NLS-1$

				g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 3,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2,
						pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH * 2 / 3,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2);

				g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT * 2 / 3,
						pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 3);
				g2.setColor(EngineConstants.graphicsColorPencil);

				g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 3,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2,
						pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
						pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT * 2 / 3);
			}

		} else {
			g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 3,
					pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
					pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT * 2 / 3);
		}
	}

	/**
	 * Draw the line which indicate that runner reach the third base.
	 *
	 * @param graphicalPosition Square coordinate where to draw
	 */
	private void drawAdvanceOnThirdBase(Point graphicalPosition) {
		Point pointDrawPosition = getPosition(graphicalPosition.x, graphicalPosition.y);
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 3,
				pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 3,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2);
	}

	/**
	 * Draw the line which indicate that runner reach the second base.
	 *
	 * @param graphicalPosition Square coordinate where to draw
	 */
	private void drawAdvanceOnSecondBase(Point graphicalPosition) {
		Point pointDrawPosition = getPosition(graphicalPosition.x, graphicalPosition.y);
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + 1 + ACTION_PLACE_WIDTH * 2 / 3,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2,
				pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH * 1 / 2,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 3);
	}

	/**
	 * Draw the line which indicate that runner reach the first base.
	 *
	 * @param graphicalPosition Square coordinate where to draw
	 */
	private void drawAdvanceOnFirstBase(Point graphicalPosition) {
		Point pointDrawPosition = getPosition(graphicalPosition.x, graphicalPosition.y);
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + ACTION_PLACE_WIDTH / 2,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT * 2 / 3,
				pointDrawPosition.x + squareCorrectionX[graphicalPosition.y] + 1 + ACTION_PLACE_WIDTH * 2 / 3,
				pointDrawPosition.y + squareCorrectionY[graphicalPosition.x] + 1 + ACTION_PLACE_HEIGHT / 2);
	}

	/**
	 * Draw symbol of a batter out by rules.
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param text  String containing the code of the action.
	 * @param obrNumber OBR number
	 * @param pointDrawPosition Square coordinate where to draw
	 * @param isAPossibleDoublePlay <b>true</b> if it is a double play,<b>false</b> otherwise
	 */
	private void drawBatterPutOutByRule(int x, int y, String text, String obrNumber, Point pointDrawPosition,
			boolean isAPossibleDoublePlay) {
		drawBatterPutOut(x, y, text, isAPossibleDoublePlay);
		putString(obrNumber, bold6Font, EngineConstants.graphicsColorPencil,
				pointDrawPosition.x + (double)ACTION_PLACE_WIDTH - ACTION_PLACE_WIDTH * 3.0 / 16, pointDrawPosition.y + 2.0,
				ACTION_PLACE_WIDTH * 3 / 16.0, ACTION_PLACE_HEIGHT * 3 / 16.0);
	}

	/**
	 * Draw symbol of a runner out by rules.
	 * 
	 * @param text  String containing the code of the action.
	 * @param obrNumber OBR number
	 * @param squarePosition Square coordinate where to draw
	 * @param runnerPosition Last base win by the runner
	 * @param isAPossibleDoublePlay <b>true</b> if it is a double play,<b>false</b> otherwise
	 */
	private void drawRunnerOutByObr(String text, String obrNumber, Point squarePosition, int runnerPosition,
			boolean isAPossibleDoublePlay) {
		drawRunnerOut(text, squarePosition, runnerPosition, isAPossibleDoublePlay);
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.setFont(normal6Font);

		Point pointDrawPosition = getPosition(squarePosition.x, squarePosition.y);
		switch (runnerPosition) {

		case 1:
			putString(obrNumber, normal6Font, EngineConstants.graphicsColorPencil,
					pointDrawPosition.x + ACTION_PLACE_WIDTH / 2.0 + 2.0, pointDrawPosition.y + 2.0,
					ACTION_PLACE_WIDTH * 3 / 16.0, ACTION_PLACE_HEIGHT * 3 / 16.0);
			break;
		
		case 2:
			putString(obrNumber, normal6Font, EngineConstants.graphicsColorPencil,
					pointDrawPosition.x + ACTION_PLACE_WIDTH / 2.0 - ACTION_PLACE_WIDTH * 3 / 16.0, pointDrawPosition.y,
					ACTION_PLACE_WIDTH * 3 / 16.0, ACTION_PLACE_HEIGHT * 3 / 16.0);
			break;
		
		case 3:
			putString(obrNumber, normal6Font, EngineConstants.graphicsColorPencil,
					pointDrawPosition.x + ACTION_PLACE_WIDTH / 2.0 - ACTION_PLACE_WIDTH * 3 / 16.0,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH * 3 / 16.0,
					ACTION_PLACE_HEIGHT * 3 / 16.0);
			break;
		
		default:
			// nothing to do
		}
	}

	/**
	 * Draw runner put out.
	 * 
	 * @param text  String containing the code of the action.
	 * @param squarePosition  Square coordinate where to draw
	 * @param runnerPosition last base win by the runner
	 * @param isAPossibleDoublePlay <b>true</b> if it is a double play,<b>false</b> otherwise
	 */
	private void drawRunnerOut(String text, Point squarePosition, int runnerPosition, boolean isAPossibleDoublePlay) {

		g2.setColor(EngineConstants.graphicsColorPencil);

		MultiplePlayContainer newPutoutCase = new MultiplePlayContainer();
		newPutoutCase.setPosition(squarePosition);

		Point pointDrawPosition = getPosition(squarePosition.x, squarePosition.y);
		switch (runnerPosition) {
		case 1:

			g2.drawOval(pointDrawPosition.x + 1, pointDrawPosition.y + 2, ACTION_PLACE_WIDTH / 2 + 3,
					ACTION_PLACE_HEIGHT / 2 + 3);
			putString(text, bold6Font, EngineConstants.graphicsColorPencil, pointDrawPosition.x, pointDrawPosition.y,
					ACTION_PLACE_WIDTH / 2.0 + 5, ACTION_PLACE_HEIGHT / 2.0 + 8);
			newPutoutCase.setPutoutCase(MultiplePlayContainer.PUTOUT_CASE.RUNNER1_PUTOUT);

			break;
		case 2:

			g2.drawOval(pointDrawPosition.x + 1, pointDrawPosition.y + 2, ACTION_PLACE_WIDTH / 2 - 2,
					ACTION_PLACE_HEIGHT / 2 - 2);
			putString(text, bold6Font, EngineConstants.graphicsColorPencil, pointDrawPosition.x, pointDrawPosition.y,
					ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			newPutoutCase.setPutoutCase(MultiplePlayContainer.PUTOUT_CASE.RUNNER2_PUTOUT);

			break;
		case 3:
			g2.drawOval(pointDrawPosition.x + 1, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 2,
					ACTION_PLACE_WIDTH / 2 - 2, ACTION_PLACE_HEIGHT / 2 - 2);
			putString(text, bold6Font, EngineConstants.graphicsColorPencil, pointDrawPosition.x,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			newPutoutCase.setPutoutCase(MultiplePlayContainer.PUTOUT_CASE.RUNNER3_PUTOUT);
			break;
		default:
			// Not possible
		}

		if (isAPossibleDoublePlay) {
			putoutCases.add(newPutoutCase);
		}

	}

	/**
	 * Draw the small line which indicate a continuation.
	 * 
	 * @param position define the starting base number 
	 * 
	 * @param pointDrawPosition  Square coordinate where to draw
	 */
	private void drawContinuation(int position, Point pointDrawPosition) {

		g2.setColor(EngineConstants.graphicsColorPencil);

		switch (position) {
		case 1:
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH - 4,
					pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 2) - 3, pointDrawPosition.x + ACTION_PLACE_WIDTH - 4,
					pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 2) + 3);
			break;
		case 2:
			g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_WIDTH / 2) - 3, pointDrawPosition.y + 4,
					pointDrawPosition.x + (ACTION_PLACE_WIDTH / 2) + 3, pointDrawPosition.y + 4);
			break;
		case 3:
			g2.drawLine(pointDrawPosition.x + 4, pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 2) - 3,
					pointDrawPosition.x + 4, pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 2) + 3);
			break;
		default:
			// Not possible
		}
	}

	/**
	 * Draw a more advance arrow. 
	 * 
	 * @param start from which base number
	 * @param end to which base number
	 * @param pointDrawPosition Square coordinate where to draw
	 */
	private void drawMoreAdvanceArrow(int start, int end, Point pointDrawPosition) {

		int i = start;
		g2.setColor(EngineConstants.graphicsColorPencil);

		/* Draw line of the arrow */
		while (i < end) {
			switch (i) {

			case 1: 
				g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) + 2,
						pointDrawPosition.y + (ACTION_PLACE_HEIGHT * 3 / 4) - 5,
						pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) + 2,
						pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4));
				break;
			

			case 2: 
				int startingPosition = pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) + 2;
				if (i == start) {
					startingPosition -= 5;
				}

				g2.drawLine(startingPosition, pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4),
						pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 2,
						pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4));
				break;
			

			case 3: 
				startingPosition = pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4);
				if (i == start) {
					startingPosition += 5;
				}
				g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 2, startingPosition,
						pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 2,
						pointDrawPosition.y + (ACTION_PLACE_HEIGHT * 3 / 4));
				break;
			
			
			default:
				// Not possible
			}

			i++;
		}

		/* Draw edge of the arrow */
		switch (end) {
		case 2:
			g2.fillPolygon(
					new int[] { pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) - 1,
							pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) + 5,
							pointDrawPosition.x + (ACTION_PLACE_WIDTH * 3 / 4) + 2 },
					new int[] { pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4) + 1,
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4) + 1,
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4) - 2 },
					3);
			break;
		case 3:
			g2.fillPolygon(new int[] { pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 3,
					pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4), pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) },
					new int[] { pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4),
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4) - 3,
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT / 4) + 3 },
					3);
			break;
		case 4:
			g2.fillPolygon(
					new int[] { pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 5,
							pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) + 1,
							pointDrawPosition.x + (ACTION_PLACE_WIDTH / 4) - 2 },
					new int[] { pointDrawPosition.y + (ACTION_PLACE_HEIGHT * 3 / 4) - 1,
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT * 3 / 4) - 1,
							pointDrawPosition.y + (ACTION_PLACE_HEIGHT * 3 / 4) + 2 },
					3);
			break;
			
		default:
			// not possible
		}
	}

	/**
	 * Draw a runner advance on base.
	 *  
	 * @param runnerPosition Starting position.
	 * @param baseWin Number of base win
	 * @param graphicalPosition Square coordinate where to draw
	 * @param isEarned indicate if it is a earned point 
	 */
	private void drawAdvance(int runnerPosition, int baseWin, Point graphicalPosition, String isEarned) {
		for (int i = runnerPosition + 1; i < (runnerPosition + baseWin + 1); i++) {
			switch (i) {
			case 1:
				drawAdvanceOnFirstBase(graphicalPosition);
				break;
			case 2:
				drawAdvanceOnSecondBase(graphicalPosition);
				break;
			case 3:
				drawAdvanceOnThirdBase(graphicalPosition);
				break;
			case 4:
				drawAdvanceOnMarbleBase(graphicalPosition, isEarned);
				break;
			default:
				// Not possible
			}
		}
	}

	/**
	 * Draw a batter out with need a counter(K, HP, BB)
	 * 
	 * @param batterNumber Batter number
	 * @param currentColumn current column number
	 * @param code Code of the action
	 * @param counter Value of the counter
	 * @param isAPossibleDoublePlay  <b>true</b> if it is a double play,<b>false</b> otherwise
	 * 
	 * @return return the value of the counter
	 */
	private int drawBatterPutOutWithCounter(int batterNumber, int currentColumn, String code, int counter,
			boolean isAPossibleDoublePlay) {
		drawBatterPutOut(batterNumber, currentColumn, code, isAPossibleDoublePlay);
		counter = putCounter(batterNumber, currentColumn, counter);
		return counter;
	}

	/**
	 * Draw a batter lost turn (Case of LT)
	 * 
	 * @param batterNumber batter number 
	 * @param currentColumn current column
	 */
	private void drawBatterLostTurn(int batterNumber, int currentColumn) {
		g2.setFont(bold10Font);
		Point pointDrawPosition = getPosition(batterNumber, currentColumn);

		if ((pointDrawPosition.getX() != 0) && (pointDrawPosition.getY() != 0)) {
			putString("LT", bold10Font, EngineConstants.graphicsColorPencil, pointDrawPosition.getX(), //$NON-NLS-1$
					pointDrawPosition.getY(), ACTION_PLACE_WIDTH, ACTION_PLACE_HEIGHT);
		}
	}

	/**
	 * Draw a batter put out.
	 * 
	 * @param batterNumber Batter number
	 * @param currentColumn Current column number
	 * @param code code of the action
	 * @param isAPossibleDoublePlay <b>true</b> if it is a double play,<b>false</b> otherwise
	 */
	private void drawBatterPutOut(int batterNumber, int currentColumn, String code, boolean isAPossibleDoublePlay) {
		g2.setColor(EngineConstants.graphicsColorPencil);
		Point pointDrawPosition = getPosition(batterNumber, currentColumn);

		MultiplePlayContainer newPutoutCase = new MultiplePlayContainer();
		newPutoutCase.setPosition(new Point(batterNumber, currentColumn));
		newPutoutCase.setPutoutCase(MultiplePlayContainer.PUTOUT_CASE.BATTER_PUTOUT);

		if (isAPossibleDoublePlay) {
			putoutCases.add(newPutoutCase);
		}

		if ((pointDrawPosition.getX() != 0) && (pointDrawPosition.getY() != 0)) {
			g2.drawOval((int) pointDrawPosition.getX(), pointDrawPosition.y, ACTION_PLACE_WIDTH,	ACTION_PLACE_HEIGHT);

			putString(bold12Font, EngineConstants.graphicsColorPencil, code, pointDrawPosition.getX(),
					pointDrawPosition.getY(), ACTION_PLACE_WIDTH, ACTION_PLACE_HEIGHT);
		}
	}

	/**
	 * Draw batter must be out (case foul fall error on batter hit).
	 * 
	 * @param code code of the error
	 * @param pointDrawPosition Square coordinate where to draw
	 */
	private void drawBatterMustBeOut(String code, Point pointDrawPosition) {
		g2.setFont(bold6Font);
		g2.setColor(EngineConstants.graphicsColorPencil);
		putString(code, bold4Font, EngineConstants.graphicsColorPencil,
				(pointDrawPosition.getX() + (ACTION_PLACE_WIDTH * 7.0 / 8.0)),
				pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 7.0 / 8.0, ACTION_PLACE_WIDTH / 8.0,
				ACTION_PLACE_HEIGHT / 8.0);
	}

	/**
	 * Draw a player must be out.
	 * 
	 * @param code code of the action
	 * @param squaerPosition last base win by the runner
	 * @param pointDrawPosition  Square coordinate where to draw
	 */
	private void drawPlayerMustBeOut(String code, int squaerPosition, Point pointDrawPosition) {
		g2.setFont(bold6Font);
		g2.setColor(EngineConstants.graphicsColorPencil);

		switch (squaerPosition) {
		case 1:
			putString(code, bold4Font, EngineConstants.graphicsColorPencil,
					(pointDrawPosition.getX() + (ACTION_PLACE_WIDTH * 6.0 / 8.0)),
					pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 7.0 / 8.0, ACTION_PLACE_WIDTH / 8.0,
					ACTION_PLACE_HEIGHT / 8.0);
			break;

		case 2:
			putString(code, normal4Font, EngineConstants.graphicsColorPencil,
					(pointDrawPosition.getX() + (ACTION_PLACE_WIDTH * 6.0 / 8.0)),
					pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 3.0 / 8.0 + 1, ACTION_PLACE_WIDTH / 8.0,
					ACTION_PLACE_HEIGHT / 8.0);
			break;

		case 3:
			putString(code, normal4Font, EngineConstants.graphicsColorPencil,
					(pointDrawPosition.getX() + (ACTION_PLACE_WIDTH * 1 / 8.0)),
					pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 3 / 8.0 + 1, ACTION_PLACE_WIDTH / 8.0,
					ACTION_PLACE_HEIGHT / 8.0);
			break;

		case 4:
			putString(code, normal4Font, EngineConstants.graphicsColorPencil,
					(pointDrawPosition.getX() + (ACTION_PLACE_WIDTH * 1 / 8.0)),
					pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 7 / 8.0, ACTION_PLACE_WIDTH / 8.0,
					ACTION_PLACE_HEIGHT / 8.0);
			break;
			
		default:
			// Not possible
		}
	}

	/**
	 * Draw a put out counter (Case of BB, K, HP).
	 * 
	 * @param batterNumber Batter number
	 * @param currentColumn current column number
	 * @param counter value of the counter
	 * 
	 * @return the new value of the counter
	 */
	private int putCounter(int batterNumber, int currentColumn, int counter) {
		g2.setFont(bold6Font);
		g2.setColor(EngineConstants.graphicsColorPencil);
		counter++;
		Point pointDrawPosition = getPosition(batterNumber, currentColumn);
		putString(EMPTY_STRING + counter, bold6Font, EngineConstants.graphicsColorPencil,
				pointDrawPosition.getX() + ACTION_PLACE_WIDTH * 7 / 8.0 + 1,
				pointDrawPosition.getY() + ACTION_PLACE_HEIGHT * 7 / 8.0, ACTION_PLACE_WIDTH / 8.0,
				ACTION_PLACE_HEIGHT / 8.0);
		return counter;
	}

	/**
	 * Draw the line which indicate a double play.
	 * 
	 * @param container1 starting point double play description container 
	 * @param container2 ending point double play description container
	 */
	private void drawDoublePutout(MultiplePlayContainer container1, MultiplePlayContainer container2) {

		/* Deux retrait dans la même colonne */
		g2.setColor(EngineConstants.graphicsColorPencil);
		Point point1 = getPosition(container1.getPosition().x, container1.getPosition().y);
		Point point2 = getPosition(container2.getPosition().x, container2.getPosition().y);
		
		if (container1.getPosition().y == container2.getPosition().y) {

			Point startPosition1 = container1.getOutputPoint(DIRECTION.LEFT_BOTTOM);
			Point endPosition2 = container2.getOutputPoint(DIRECTION.LEFT_TOP);

			/* Deux retrait sur deux joueurs consécutifs */
			if (container1.getPosition().x == container2.getPosition().x - 1) {
				g2.drawLine(point1.x + startPosition1.x, point1.y + startPosition1.y, point2.x + endPosition2.x,
						point2.y + endPosition2.y);

			} else {

				g2.drawLine(point1.x + startPosition1.x, point1.y + startPosition1.y, point1.x + 3,
						point1.y + startPosition1.y);
				g2.drawLine(point1.x + 3, point1.y + startPosition1.y, point1.x + 3, point2.y);
				g2.drawLine(point1.x + 3, point2.y, point2.x + endPosition2.x, point2.y + endPosition2.y);
			}

		} else {

			if (container1.getPosition().y > container2.getPosition().y) {

				Point startPosition1 = container1.getOutputPoint(DIRECTION.LEFT_BOTTOM);
				Point endPosition2 = container2.getOutputPoint(DIRECTION.RIGHT_TOP);

				g2.drawLine(point1.x + startPosition1.x, point1.y + startPosition1.y, point1.x + 3,
						point1.y + ACTION_PLACE_HEIGHT);
				g2.drawLine(point1.x + 3, point1.y + ACTION_PLACE_HEIGHT, point1.x + 3, point2.y);
				g2.drawLine(point1.x + 3, point2.y, point2.x + endPosition2.x, point2.y + endPosition2.y);

			} else {

				Point startPosition1 = container1.getOutputPoint(DIRECTION.LEFT_BOTTOM);
				Point endPosition2 = container2.getOutputPoint(DIRECTION.LEFT_TOP);

				g2.drawLine(point1.x + startPosition1.x, point1.y + startPosition1.y, point1.x + 3,
						point1.y + ACTION_PLACE_HEIGHT);
				g2.drawLine(point1.x + 3, point1.y + ACTION_PLACE_HEIGHT, point1.x + 3, point2.y);
				g2.drawLine(point1.x + 3, point2.y, point2.x + endPosition2.x, point2.y + endPosition2.y);
			}
		}
	}

	/**
	 * Draw common part to the visitor and home team sheet. 
	 *
	 * @param g2 reference on the graphical context
	 */
	private void drawCommonEmptyPage() {

		g2.setColor(EngineConstants.graphicsColorSheet);
		Stroke baseStroke = g2.getStroke();

		/* Traits gras */
		g2.setStroke(new BasicStroke((float) 1.5));
		for (Rectangle rect : COMMON_BOLD_LINE) {
			g2.drawLine(rect.x, rect.y, rect.width, rect.height);
		}

		/* Traits fins */
		g2.setStroke(new BasicStroke((float) 0.5));
		for (Rectangle rect : COMMON_NORMAL_LINE) {
			g2.drawLine(rect.x, rect.y, rect.width, rect.height);
		}

		/*
		 * gestion des différent type de feuilles , zone des position défensive du
		 * lineup
		 */
		if (EngineConstants.graphicsShowNewStyleSheet) {
			g2.drawLine((int) HORIZONTAL_006N, (int) VERTICAL_005, (int) HORIZONTAL_006N, (int) VERTICAL_040);
		} else {
			g2.drawLine((int) HORIZONTAL_006, (int) VERTICAL_005, (int) HORIZONTAL_006, (int) VERTICAL_006);
		}

		/* Définition de la zone action */
		for (int x = 0; x < 12; x++) {
			g2.drawLine((int) actionAreaHorizontal[x], (int) VERTICAL_005,
					(int) (actionAreaHorizontal[x] + (4.2 * FACTOR_CORRECTIF)), (int) VERTICAL_005);
			g2.drawLine((int) (actionAreaHorizontal[x] + (4.2 * FACTOR_CORRECTIF)), (int) VERTICAL_004,
					(int) (actionAreaHorizontal[x] + (4.2 * FACTOR_CORRECTIF)), (int) VERTICAL_005);

			int x1;
			int x2;
			int y1;
			int y2;
			for (int y = 0; y < nbBatters; y++) {
				x1 = (int) (actionAreaHorizontal[x] + (ACTION_WIDTH / 2 * FACTOR_CORRECTIF));
				y1 = (int) (VERTICAL_006 + (((3 * y) * HEIGHT_LINE) * FACTOR_CORRECTIF));
				y2 = (int) (VERTICAL_006 + ((HEIGHT_LINE + ((3 * y) * HEIGHT_LINE)) * FACTOR_CORRECTIF));
				if (y == 0) {
					g2.drawLine(x1, y1, x1, y2 + 1);
				} else {
					g2.drawLine(x1, y1, x1, y2);
				}

				y1 = (int) (VERTICAL_006 + ((2 * HEIGHT_LINE + ((3 * y) * HEIGHT_LINE)) * FACTOR_CORRECTIF));
				y2 = (int) (VERTICAL_006 + ((3 * HEIGHT_LINE + ((3 * y) * HEIGHT_LINE)) * FACTOR_CORRECTIF));
				g2.drawLine(x1, y1, x1, y2);

				x1 = (int) actionAreaHorizontal[x];
				x2 = (int) (actionAreaHorizontal[x] + (ACTION_WIDTH / 3 * FACTOR_CORRECTIF));
				y1 = (int) (VERTICAL_006 + ((3 * HEIGHT_LINE / 2 + ((3 * y) * HEIGHT_LINE)) * FACTOR_CORRECTIF));
				g2.drawLine(x1, y1, x2, y1);

				x1 = (int) (actionAreaHorizontal[x] + (ACTION_WIDTH * 2 / 3 * FACTOR_CORRECTIF));
				x2 = (int) (actionAreaHorizontal[x] + (ACTION_WIDTH * FACTOR_CORRECTIF));
				g2.drawLine(x1, y1, x2, y1);
			}

			x1 = (int) (actionAreaHorizontal[x] + (ACTION_WIDTH / 2 * FACTOR_CORRECTIF));
			g2.drawLine(x1, (int) VERTICAL_033, x1, (int) VERTICAL_040);
		}
		g2.setStroke(baseStroke);

		/* ecriture du texte sur la feuille : cas d'un demi manche */
		g2.setFont(normal6Font);
		putString("AB", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_033, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("R", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_034, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("ER", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_035, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("H", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_036, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("A", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_037, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("E", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_038, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("LOB", normal6Font, EngineConstants.graphicsColorSheet, actionAreaHorizontal[0], VERTICAL_039, //$NON-NLS-1$
				ACTION_WIDTH / 2 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* ecriture du texte sur la feuille : Statitistique lanceur */
		putString("BF", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_001, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("AB", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_002, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("R", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_003, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("ER", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_004, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("H", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_005, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("2B", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_006, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("3B", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_007, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("HR", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_008, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SH", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_009, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SF", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_010, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("BB", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_011, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IBB", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_012, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("HP", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_013, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IO", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_014, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("K", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_015, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("WP", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_016, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("BK", normal6Font, EngineConstants.graphicsColorSheet, STAT_PITCHER_017, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("W /L /Sa", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_007, VERTICAL_040, //$NON-NLS-1$
				STAT_PITCHER_001 - HORIZONTAL_007, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* ecriture du texte sur la feuille : Statitistique catcher */
		putString("PB", normal6Font, EngineConstants.graphicsColorSheet, STAT_CATCHER_PB, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SB", normal6Font, EngineConstants.graphicsColorSheet, STAT_CATCHER_SB, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("CS", normal6Font, EngineConstants.graphicsColorSheet, STAT_CATCHER_CS, VERTICAL_040, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* ecriture du texte sur la feuille : Statitistique defensive */
		putString("PO", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_000, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("A", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_001, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("E", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_002, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("DP", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_003, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IP", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_004, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* ecriture du texte sur la feuille : Statitistique offensive */
		putString("PA", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_PA_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("AB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_AB_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("R", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_RUN_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("H", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HIT_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("2B", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_2B_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("3B", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_3B_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("HR", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HR_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("GDP", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_GDP_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SH", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SH_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SF", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SF_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("BB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_BB_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IBB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_IBB_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("HP", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HP_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IO", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_IO_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SB_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("CS", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_CS_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("K", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_K_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("RBI", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_RBI_POSITION, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* ecriture du texte sur la feuille : Diverse */
		if (EngineConstants.graphicsShowNewStyleSheet) {
			putString("Pos", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_005, VERTICAL_005, //$NON-NLS-1$
					(ACTION_WIDTH * 2) / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		} else {
			putString("Pos", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_005, VERTICAL_005, //$NON-NLS-1$
					ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		}
		putString("N.", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_007, VERTICAL_005, //$NON-NLS-1$
				ACTION_WIDTH / 3 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		g2.drawString("GWRBI:", (int) HORIZONTAL_PA_POSITION + 3, (int) (VERTICAL_042 - 4)); //$NON-NLS-1$

		/* Ecriture et dessin de la zone contrôle */
		putString(Messages.ScoringSheetGraphicalManager_ControlArea, normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_PA_POSITION, VERTICAL_042,
				HORIZONTAL_060 - HORIZONTAL_PA_POSITION, HEIGHT_LINE * FACTOR_CORRECTIF);
		g2.drawRect((int) HORIZONTAL_AB_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_HIT_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_3B_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_GDP_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_SF_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_IBB_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_IO_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_CS_POSITION, (int) VERTICAL_044, (int) (WIDTH_LINE * 1.5 * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_RUN_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_2B_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HR_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SH_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_BB_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HP_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("=", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SB_POSITION, VERTICAL_044, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("AB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_AB_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SH", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_HIT_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("SF", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_3B_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("BB", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_GDP_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("HP", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SF_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("IO", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_IBB_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("TIE", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_IO_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("TOTAUX", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_CS_POSITION, VERTICAL_043, //$NON-NLS-1$
				WIDTH_LINE * 1.5 * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);

		g2.drawRect((int) (HORIZONTAL_2B_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), (int) (WIDTH_LINE * 1.5 * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) (HORIZONTAL_SH_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), (int) (WIDTH_LINE * 1.5 * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) (HORIZONTAL_HP_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), (int) (WIDTH_LINE * 1.5 * FACTOR_CORRECTIF),
				(int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		g2.drawRect((int) HORIZONTAL_CS_POSITION, (int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF),
				(int) (WIDTH_LINE * 1.5 * FACTOR_CORRECTIF), (int) (HEIGHT_LINE * FACTOR_CORRECTIF));
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, //$NON-NLS-1$
				(int) (HORIZONTAL_HR_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * 1.5 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("+", normal6Font, EngineConstants.graphicsColorSheet, //$NON-NLS-1$
				(int) (HORIZONTAL_BB_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * 1.5 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("=", normal6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_SB_POSITION, //$NON-NLS-1$
				(int) (VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("R", normal6Font, EngineConstants.graphicsColorSheet, //$NON-NLS-1$
				(int) (HORIZONTAL_2B_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_045 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * 1.5 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("LOB", normal6Font, EngineConstants.graphicsColorSheet, //$NON-NLS-1$
				(int) (HORIZONTAL_SH_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_045 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * 1.5 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
		putString("PO", normal6Font, EngineConstants.graphicsColorSheet, //$NON-NLS-1$
				(int) (HORIZONTAL_HP_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF),
				(int) (VERTICAL_045 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF), WIDTH_LINE * 1.5 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);

		/* Ecriture des titres */
		g2.setFont(bold7Font);
		putString(Messages.ScoringSheetGraphicalManager_DefenseArea, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_000, VERTICAL_004,
				HORIZONTAL_005 - HORIZONTAL_000, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_OffensiveArea, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_PA_POSITION, VERTICAL_004,
				HORIZONTAL_RBI_POSITION - HORIZONTAL_PA_POSITION, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Players, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_006, VERTICAL_005,
				HORIZONTAL_007 - HORIZONTAL_006, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Pitchers, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_006, VERTICAL_040,
				HORIZONTAL_008 - HORIZONTAL_006, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_DoublePlays, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_000, VERTICAL_040,
				HORIZONTAL_005 - HORIZONTAL_000, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Catchers, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_025, VERTICAL_040,
				STAT_CATCHER_PB - HORIZONTAL_025, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Totals, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_006, VERTICAL_047,
				HORIZONTAL_008 - HORIZONTAL_006, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Totals, bold7Font, EngineConstants.graphicsColorSheet, HORIZONTAL_025, VERTICAL_047,
				STAT_CATCHER_PB - HORIZONTAL_025, HEIGHT_LINE * FACTOR_CORRECTIF);

		/* pour numéroter les lignes des batteur */
		g2.setFont(bold14Font);
		putString("1", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_006, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_009 - VERTICAL_006);
		putString("2", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_009, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_012 - VERTICAL_009);
		putString("3", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_012, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_015 - VERTICAL_012);
		putString("4", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_015, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_018 - VERTICAL_015);
		putString("5", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_018, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_021 - VERTICAL_018);
		putString("6", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_021, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_024 - VERTICAL_021);
		putString("7", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_024, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_027 - VERTICAL_024);
		putString("8", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_027, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_030 - VERTICAL_027);
		putString("9", bold12Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_030, //$NON-NLS-1$
				HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_033 - VERTICAL_030);
		if (nbBatters == 10) {
			putString("10", bold10Font, EngineConstants.graphicsColorSheet, HORIZONTAL_008, VERTICAL_033, //$NON-NLS-1$
					HORIZONTAL_009 - HORIZONTAL_008, VERTICAL_036 - VERTICAL_033);
		}

		// Add logo of the federation
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL logoUrl = bundle.getEntry("icons/FFBS_Icone.jpg"); //NON-NLS-1$ //$NON-NLS-1$
		ImageIcon ffbsLogo = new ImageIcon(logoUrl);

		if (ffbsLogo.getImage() != null) {
			g2.drawImage(ffbsLogo.getImage(), (int) (HORIZONTAL_000 + 1), (int) (VERTICAL_000 + 1),
					(int) (HORIZONTAL_005 - HORIZONTAL_000 - 2), (int) (VERTICAL_004 - VERTICAL_000 - 3), null);
		}
	}

	/**
	 * Draw an empty header for the home team sheet.
	 * 
	 * @param g2 Reference on the graphical context
	 */
	private void drawEmptyHeaderHomeTeamPart() {
		Stroke baseStroke = g2.getStroke();
		g2.setColor(EngineConstants.graphicsColorSheet);

		/* ligne de séparation total avec infos générales */
		g2.drawLine((int) HOME_TEAM_START_PLAY_NUMBER, (int) VERTICAL_000, (int) HOME_TEAM_START_PLAY_NUMBER,
				(int) VERTICAL_004);

		g2.setStroke(new BasicStroke((float) 0.5));
		/* dessin des lignes horizontales */
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_001, (int) HORIZONTAL_060, (int) VERTICAL_001);
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_002, (int) HORIZONTAL_060, (int) VERTICAL_002);
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_003, (int) HORIZONTAL_060, (int) VERTICAL_003);

		/* dessin des lignes pour les champs du numéro de rencontre */
		g2.drawLine((int) HOME_TEAM_END_PLAY_NUMBER, (int) VERTICAL_000, (int) HOME_TEAM_END_PLAY_NUMBER,
				(int) VERTICAL_001);
		for (int i = 1; i < 9; i++) {
			g2.drawLine((int) (HOME_TEAM_END_PLAY_NUMBER + (i * WIDTH_LINE * FACTOR_CORRECTIF)), (int) VERTICAL_000,
					(int) (HOME_TEAM_END_PLAY_NUMBER + (i * WIDTH_LINE * FACTOR_CORRECTIF)), (int) VERTICAL_001);
		}
		g2.setStroke(baseStroke);

		g2.setFont(normal6Font);
		/* ecriture des textes */
		g2.drawString(Messages.ScoringSheetGraphicalManager_Tournament, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_001 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Category, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_002 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Visitor, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_003 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Hometeam, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_004 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Date, (int) (82 * FACTOR_CORRECTIF), (int) VERTICAL_001 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Start, (int) (82 * FACTOR_CORRECTIF), (int) VERTICAL_002 - 4);

		putString(Messages.ScoringSheetGraphicalManager_GameNumber, normal6Font, EngineConstants.graphicsColorSheet, HOME_TEAM_START_PLAY_NUMBER,
				VERTICAL_000, HOME_TEAM_END_PLAY_NUMBER - HOME_TEAM_START_PLAY_NUMBER, HEIGHT_LINE * FACTOR_CORRECTIF);

		g2.drawString(Messages.ScoringSheetGraphicalManager_Baseball, (int) (HOME_TEAM_START_PLAY_NUMBER + (60 * FACTOR_CORRECTIF)),
				(int) (VERTICAL_001 - 4));
		g2.drawString(Messages.ScoringSheetGraphicalManager_Softball, (int) (HOME_TEAM_START_PLAY_NUMBER + (99 * FACTOR_CORRECTIF)),
				(int) (VERTICAL_001 - 4));
		g2.drawString(Messages.ScoringSheetGraphicalManager_Notes, (int) (HOME_TEAM_START_PLAY_NUMBER + (1 * FACTOR_CORRECTIF)), (int) (VERTICAL_002 - 4));

		/* dessin des check box baseball et softball */
		g2.drawRect((int) BASEBALL_X_POSITION, (int) CHECK_BOX_Y_POSITION, (int) CHECKBOX_WIDTH, (int) CHECHBOX_HEIGHT);
		g2.drawRect((int) SOFTBALL_X_POSITION, (int) CHECK_BOX_Y_POSITION, (int) CHECKBOX_WIDTH, (int) CHECHBOX_HEIGHT);
	}

	/**
	 * Draw an empty header for the visitor team sheet.
	 *
	 * @param g2 Reference on the graphical context
	 */
	private void drawEmptyHeaderVisitorPart() {
		Stroke baseStroke = g2.getStroke();
		g2.setColor(EngineConstants.graphicsColorSheet);
		/* dessin des ligne de taille double */
		g2.setStroke(new BasicStroke((float) 1.5));

		/* ligne de séparation total avec infos générales */
		g2.drawLine((int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_000, (int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_004);
		/* ligne de séparation total avec score par manche */
		g2.drawLine((int) SCORE_SEPARATOR_VISITOR, (int) VERTICAL_000, (int) SCORE_SEPARATOR_VISITOR,
				(int) VERTICAL_004);
		/* lignes horizontales séparants les infos générales */
		g2.drawLine((int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_001, (int) HORIZONTAL_060, (int) VERTICAL_001);
		g2.drawLine((int) (SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * 15 * FACTOR_CORRECTIF)), (int) VERTICAL_000,
				(int) (SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * 15 * FACTOR_CORRECTIF)), (int) VERTICAL_004);

		/* dessin des ligne de taille simple */
		g2.setStroke(new BasicStroke((float) 0.5));
		for (int i = 1; i < 15; i++) {
			g2.drawLine((int) (SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * i * FACTOR_CORRECTIF)), (int) VERTICAL_000,
					(int) (SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * i * FACTOR_CORRECTIF)), (int) VERTICAL_004);
		}
		g2.drawLine((int) NAME_SEPARATOR_VISITOR, (int) ((VERTICAL_004 - VERTICAL_001) / 2 + VERTICAL_001),
				(int) HORIZONTAL_060, (int) ((VERTICAL_004 - VERTICAL_001) / 2 + VERTICAL_001));
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_001, (int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_001);
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_002, (int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_002);
		g2.drawLine((int) HORIZONTAL_005, (int) VERTICAL_003, (int) NAME_SEPARATOR_VISITOR, (int) VERTICAL_003);

		g2.drawLine((int) HORIZONTAL_015, (int) VERTICAL_003, (int) HORIZONTAL_015, (int) VERTICAL_004);
		g2.drawLine((int) NUMBER_SEPARATOR_VISITOR, (int) VERTICAL_003, (int) NUMBER_SEPARATOR_VISITOR,
				(int) VERTICAL_004);
		for (int i = 1; i < 9; i++) {
			g2.drawLine((int) (NUMBER_SEPARATOR_VISITOR + (i * WIDTH_LINE * FACTOR_CORRECTIF)), (int) VERTICAL_003,
					(int) (NUMBER_SEPARATOR_VISITOR + (i * WIDTH_LINE * FACTOR_CORRECTIF)), (int) VERTICAL_004);
		}
		g2.setStroke(baseStroke);

		/* Gestion des textes */
		g2.setFont(normal7Font);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Tournament, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_001 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Town, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)), (int) VERTICAL_002 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Umpires, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_003 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_ScoreKeeper, (int) (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)),
				(int) VERTICAL_004 - 4);

		g2.drawString(Messages.ScoringSheetGraphicalManager_Category, (int) (HORIZONTAL_MARGE + 102.8 * FACTOR_CORRECTIF), (int) VERTICAL_001 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Date, (int) (HORIZONTAL_MARGE + 155.6 * FACTOR_CORRECTIF), (int) VERTICAL_001 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Stadium, (int) (HORIZONTAL_MARGE + 79.7 * FACTOR_CORRECTIF), (int) VERTICAL_002 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Start, (int) (HORIZONTAL_MARGE + 128.8 * FACTOR_CORRECTIF), (int) VERTICAL_002 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_End, (int) (HORIZONTAL_MARGE + 147.3 * FACTOR_CORRECTIF), (int) VERTICAL_002 - 4);
		g2.drawString(Messages.ScoringSheetGraphicalManager_Duration, (int) (HORIZONTAL_MARGE + 166.2 * FACTOR_CORRECTIF), (int) VERTICAL_002 - 4);

		putString(Messages.ScoringSheetGraphicalManager_GameNumber, bold6Font, EngineConstants.graphicsColorSheet, HORIZONTAL_015, VERTICAL_003,
				NUMBER_SEPARATOR_VISITOR - HORIZONTAL_015, HEIGHT_LINE * FACTOR_CORRECTIF);
		putString(Messages.ScoringSheetGraphicalManager_Teams, bold6Font, EngineConstants.graphicsColorSheet, NAME_SEPARATOR_VISITOR, VERTICAL_000,
				SCORE_SEPARATOR_VISITOR - NAME_SEPARATOR_VISITOR, HEIGHT_LINE * FACTOR_CORRECTIF);
		for (int i = 0; i < 15; i++) {
			putString(EMPTY_STRING + (i + 1), bold6Font, EngineConstants.graphicsColorSheet,
					SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * i * FACTOR_CORRECTIF), VERTICAL_000,
					WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
		}
		putString(Messages.ScoringSheetGraphicalManager_Total, bold6Font, EngineConstants.graphicsColorSheet,
				SCORE_SEPARATOR_VISITOR + ((WIDTH_LINE * 15 + 1) * FACTOR_CORRECTIF), VERTICAL_000,
				WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * Draw a generic batter action. 
	 * 
	 * @param code code of the action.
	 * @param location Square location 
	 */
	private void drawBatterGenericAction(String code, Point location) {
		putString(code, bold7Font, EngineConstants.graphicsColorPencil, location.x + ACTION_PLACE_WIDTH / 2.0,
				location.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
	}

	/**
	 * Draw a generic batter action on multiple line. 
	 * 
	 * @param code code of the action.
	 * @param location Square location 
	 */
	private void drawBatterGenericActionMultiline(String code, Point location) {
		putString(code, bold6Font, EngineConstants.graphicsColorPencil, location.x + ACTION_PLACE_WIDTH / 2.0,
				location.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
	}

	/**
	 * Draw a string in the square position (code for runner)
	 * 
	 * @param font Which font to use
	 * @param text Code of the action
	 * @param pointDrawPosition Square location 
	 * @param squarePosition in which part of the square
	 */
	private void drawStringInSquarePosition(Font font, String text, Point pointDrawPosition, int squarePosition) {
		g2.setFont(font);
		g2.setColor(EngineConstants.graphicsColorPencil);

		switch (squarePosition) {
		case 1:
			putString(text, font, EngineConstants.graphicsColorPencil, pointDrawPosition.x + ACTION_PLACE_HEIGHT / 2.0,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			break;
		case 2:
			putString(text, font, EngineConstants.graphicsColorPencil, pointDrawPosition.x + ACTION_PLACE_HEIGHT / 2.0,
					pointDrawPosition.y, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			break;
		case 3:
			putString(text, font, EngineConstants.graphicsColorPencil, pointDrawPosition.x, pointDrawPosition.y,
					ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			break;
		case 4:
			/*
			 * dans le cas d'un GDP avec deux retrait ou deux retrait si pas d'erreurs, on
			 * dessine un trait sur le RBI pour eviter de le compter comme un RBI
			 */

			try {
				if (isGdpAction) {
					int batterNumber = Integer.parseInt(text);
					if (batterNumber >= 1 && batterNumber < 10) {
						Rectangle2D bounds = g2.getFontMetrics().getStringBounds(text, g2);
						g2.drawLine((int) (pointDrawPosition.x + (ACTION_PLACE_WIDTH / 2.0 - bounds.getWidth()) / 2.0),
								(int) (pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0
										+ ((ACTION_PLACE_HEIGHT / 2.0 - bounds.getHeight()) / 2)) + 1,
								(int) ((int) (pointDrawPosition.x + (ACTION_PLACE_WIDTH / 2.0 - bounds.getWidth()) / 2.0)
										+ (int) bounds.getWidth() * 2.0),
								(int) (pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0
										+ ((ACTION_PLACE_HEIGHT / 2.0 - bounds.getHeight()) / 2.0)) + 1);
					}
				}
			} catch (NumberFormatException ex) {
				logger.log(Level.SEVERE, ex.getMessage());
			}
			putString(text, font, EngineConstants.graphicsColorPencil, pointDrawPosition.x,
					pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
			break;
		default:
			// It is not possible
			
		}
	}

	/**
	 * Draw an Home run
	 * 
	 * @param code code of the home run
	 * @param pointDrawPosition Square location
	 * @param location Localization of the home run
	 */
	private void drawHomeRunHit(String code, Point pointDrawPosition, String location) {
		putString(code + location, bold7Font, EngineConstants.graphicsColorPencil, pointDrawPosition.x,
				pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0, ACTION_PLACE_WIDTH / 2.0, ACTION_PLACE_HEIGHT / 2.0);
	}

	/**
	 * Draw a single hit.
	 * 
	 * @param pointDrawPosition Square location
	 * @param location Localization of the home run
	 */
	private void drawSingleHit(Point pointDrawPosition, String location) {
		Color lastColor = g2.getColor();
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 5, pointDrawPosition.y + ACTION_PLACE_HEIGHT - 6,
				pointDrawPosition.x + ACTION_PLACE_WIDTH * 3 / 4, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 2);
		g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 5, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 4,
				pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 10, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 + 4);
		g2.setFont(bold7Font);
		g2.drawString(location, (int) (pointDrawPosition.x + ACTION_PLACE_WIDTH / 2.0 + 7),
				(int) (pointDrawPosition.y + ACTION_PLACE_HEIGHT - 4.0));
		g2.setColor(lastColor);
	}

	/**
	 * Draw a double hit.
	 * 
	 * @param pointDrawPosition Square location
	 * @param location Localization of the home run
	 */
	private void drawDoubleHit(Point pointDrawPosition, String location) {
		Color lastColor = g2.getColor();
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 5, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 - 6,
				pointDrawPosition.x + ACTION_PLACE_WIDTH * 3 / 4, pointDrawPosition.y + 2);
		g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 5, pointDrawPosition.y + 4,
				pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 10, pointDrawPosition.y + 4);
		g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 4, pointDrawPosition.y + 6,
				pointDrawPosition.x + ACTION_PLACE_WIDTH / 2 + 9, pointDrawPosition.y + 6);
		g2.setFont(bold7Font);
		g2.drawString(location, (int) (pointDrawPosition.x + ACTION_PLACE_WIDTH / 2.0 + 7),
				(int) (pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0 - 4));
		g2.setColor(lastColor);
	}

	/**
	 * Draw a triple hit.
	 * 
	 * @param pointDrawPosition Square location
	 * @param location Localization of the home run
	 */
	private void drawTripleHit(Point pointDrawPosition, String location) {
		Color lastColor = g2.getColor();
		g2.setColor(EngineConstants.graphicsColorPencil);
		g2.drawLine(pointDrawPosition.x + 5, pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2 - 6,
				pointDrawPosition.x + ACTION_PLACE_WIDTH * 1 / 4, pointDrawPosition.y + 2);
		g2.drawLine(pointDrawPosition.x + 5, pointDrawPosition.y + 4, pointDrawPosition.x + 10,
				pointDrawPosition.y + 4);
		g2.drawLine(pointDrawPosition.x + 4, pointDrawPosition.y + 6, pointDrawPosition.x + 9, pointDrawPosition.y + 6);
		g2.drawLine(pointDrawPosition.x + 3, pointDrawPosition.y + 8, pointDrawPosition.x + 8, pointDrawPosition.y + 8);
		g2.setFont(bold7Font);
		g2.drawString(location, (int) (pointDrawPosition.x + 7.0),
				(int) (pointDrawPosition.y + ACTION_PLACE_HEIGHT / 2.0 - 4));
		g2.setColor(lastColor);
	}

	/**
	 * Draw runner advance base on the current batter action.
	 * 
	 * @param batterNumber batter number
	 * @param pointDrawPosition Square location
	 * @param basePosition last base win by the runner
	 */
	private void drawCurrentBatter(int batterNumber, Point pointDrawPosition, int basePosition) {
		Color currentColor = g2.getColor();
		g2.setFont(bold6Font);
		g2.setColor(EngineConstants.graphicsColorPencil);

		switch (basePosition) {

		case 1:
			g2.drawString(EMPTY_STRING + batterNumber, pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 3,
					pointDrawPosition.y + 6 + ACTION_PLACE_HEIGHT / 2);
			g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2,
					pointDrawPosition.y + 1 + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2,
					pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2);
			g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2,
					pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2, pointDrawPosition.x + ACTION_PLACE_HEIGHT - 1,
					pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2);
			break;

		case 2:
			g2.drawString(EMPTY_STRING + batterNumber, pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 3,
					pointDrawPosition.y + 6);
			g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2, pointDrawPosition.y + 1,
					pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2, pointDrawPosition.y + 7);
			g2.drawLine(pointDrawPosition.x + (ACTION_PLACE_HEIGHT / 8) * 7 + 2, pointDrawPosition.y + 7,
					pointDrawPosition.x + ACTION_PLACE_HEIGHT - 1, pointDrawPosition.y + 7);
			break;

		case 3:
			g2.drawString(EMPTY_STRING + batterNumber, pointDrawPosition.x + 1, pointDrawPosition.y + 6 + (ACTION_PLACE_HEIGHT / 2));
			g2.drawLine(pointDrawPosition.x + 5 , pointDrawPosition.y + 1 + (ACTION_PLACE_HEIGHT / 2),
					pointDrawPosition.x + 5 , pointDrawPosition.y + 7+ (ACTION_PLACE_HEIGHT / 2));
			g2.drawLine(pointDrawPosition.x + 1 , pointDrawPosition.y + 7+ (ACTION_PLACE_HEIGHT / 2),
					pointDrawPosition.x + 5 , pointDrawPosition.y + 7+ (ACTION_PLACE_HEIGHT / 2));
			break;

		case 4:
			g2.drawString(EMPTY_STRING + batterNumber, pointDrawPosition.x - 4 + ACTION_PLACE_WIDTH,
					pointDrawPosition.y + 6 + ACTION_PLACE_HEIGHT / 2);
			g2.drawLine(pointDrawPosition.x - 5 + ACTION_PLACE_WIDTH, pointDrawPosition.y + 1 + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x - 5 + ACTION_PLACE_WIDTH, pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2);
			g2.drawLine(pointDrawPosition.x + ACTION_PLACE_WIDTH, pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2,
					pointDrawPosition.x - 5 + ACTION_PLACE_WIDTH, pointDrawPosition.y + 7 + ACTION_PLACE_HEIGHT / 2);
			break;
			
		default:
			// Not possible
		}
		g2.setColor(currentColor);
	}

	/**
	 * Get Square location for a batter number.
	 * 
	 * @param batteurNumber Batter order number
	 * @param column Column number 
	 * 
	 * @return Point whichs give the square location
	 */
	private Point getPosition(int batteurNumber, int column) {
		int x;
		int y;

		switch (column) {
		case 1:
			x = (int) HORIZONTAL_009;
			break;
		case 2:
			x = (int) HORIZONTAL_011;
			break;
		case 3:
			x = (int) HORIZONTAL_013;
			break;
		case 4:
			x = (int) HORIZONTAL_015;
			break;
		case 5:
			x = (int) HORIZONTAL_017;
			break;
		case 6:
			x = (int) HORIZONTAL_019;
			break;
		case 7:
			x = (int) HORIZONTAL_021;
			break;
		case 8:
			x = (int) HORIZONTAL_023;
			break;
		case 9:
			x = (int) HORIZONTAL_025;
			break;
		case 10:
			x = (int) HORIZONTAL_027;
			break;
		case 11:
			x = (int) HORIZONTAL_029;
			break;
		case 12:
			x = (int) HORIZONTAL_031;
			break;
		default:
			x = 0;
			break;
		}

		switch (batteurNumber) {
		case 1:
			y = (int) VERTICAL_006;
			break;
		case 2:
			y = (int) VERTICAL_009;
			break;
		case 3:
			y = (int) VERTICAL_012;
			break;
		case 4:
			y = (int) VERTICAL_015;
			break;
		case 5:
			y = (int) VERTICAL_018;
			break;
		case 6:
			y = (int) VERTICAL_021;
			break;
		case 7:
			y = (int) VERTICAL_024;
			break;
		case 8:
			y = (int) VERTICAL_027;
			break;
		case 9:
			y = (int) VERTICAL_030;
			break;
		case 10:
			y = (int) VERTICAL_033;
			break;
		default:
			y = 0;
			break;
		}

		return new Point(x, y);
	}

	/**
	 * Fill line-up part of sheet which the line-up manager of a team
	 *
	 * @param g2 Reference on the graphical context
	 * @param lineup Reference on the line-up manager of a team
	 */
	protected void fillLineupPart(LineupManager lineup) {

		LineupEntry lastPlayerDescription = null;

		/* pour tous les joueurs actifs dans le Line up */
		int offensivePosition = 1;
		HashMap<Integer, LineupEntry> extraPLayers = new HashMap<>();

		if (lineup != null && lineup.getLineupEntries() != null) {
			for (Entry<String, List<LineupEntry>> element : lineup.getLineupEntries().entrySet()) {
	
				if (!element.getKey().equals("-1")) { //$NON-NLS-1$
					if (offensivePosition < 10) {
						offensivePosition++;
	
						HashMap<Integer, String> batterNameInRow = new HashMap<>();
						int positionInBatterRow = 0;
						for (int i = 0; i < element.getValue().size(); i++) {
							LineupEntry player = element.getValue().get(i);
							batterNameInRow.put(positionInBatterRow, player.getPlayerDescription().getName());
	
							if ((positionInBatterRow < 3)) {
	
								double position;
								if (isSamePlayer(player, lastPlayerDescription)) {
	
									position = (double) lastPlayerDescription.getAssociatedObjects().get(GRAPHICAL_POSITION);
									positionInBatterRow++;
	
								} else {
									position = getGraphicalLineUpPosition(Integer.parseInt(element.getKey()),
											element.getValue(), positionInBatterRow, player);
									try {
										LineupEntry nextPlayer = element.getValue().get(i + 1);
										if (isSamePlayer(player, nextPlayer)) {
											if (player.getDefensivePosition().startsWith("pr") //$NON-NLS-1$
													|| player.getDefensivePosition().startsWith("ph")) { //$NON-NLS-1$
											} else {
												positionInBatterRow++;
											}
										} else {
											positionInBatterRow++;
										}
									} catch (IndexOutOfBoundsException e) {
										positionInBatterRow++;
									}
								}
	
								player.getAssociatedObjects().put(GRAPHICAL_POSITION, position);
	
								boolean setTilde = false;
								if ( (positionInBatterRow > 1) &&
									(player.getPlayerDescription().getName().equals(batterNameInRow.get(positionInBatterRow - 2)))) {
										setTilde = true;
								}
								drawPlayerName(player, lastPlayerDescription, position, setTilde);
	
								/* et le numero de maillot */
								drawShirtNumber(player, lastPlayerDescription, position);
	
								/* la valeur de l'IP */
								drawIpValue(player, position);
	
								drawDefensivePosition(player, lastPlayerDescription, position);
	
								/* set indice for defensive position */
								drawIndiceForDefensivePosition(player, lastPlayerDescription, position);
	
								lastPlayerDescription = getLastPlayerDescription(player,
										ScoreGameDisplay.getSubstitutionDisplayCode(player.getDefensivePosition()));
	
							} else {
	
								extraPLayers.put(player.getOrderNumber(), player);
							}
	
						}
					}
				} else {
					/* case of the pitcher who don't pass to attack */
					int pitcherPosition = 0;
					for (int i = 0; i < element.getValue().size(); i++) {
						LineupEntry player = element.getValue().get(i);
						
						if (player.getDefensivePosition().equals("1")) { //$NON-NLS-1$
						
							double graphicalPosition = VERTICAL_041 + (pitcherPosition * HEIGHT_LINE * FACTOR_CORRECTIF);
							player.getAssociatedObjects().put(GRAPHICAL_POSITION, graphicalPosition);
							pitcherPosition++;
						} else {
							extraPLayers.put(player.getOrderNumber(), player);
						}
					}
				}
			}
			
	
			/* On place les joueurs dans la partie supplémentaire de la feuille */
			List<Integer> positions = new ArrayList<>(extraPLayers.keySet());
			Collections.sort(positions);
			int counter = 0;
			lastPlayerDescription = null;
			for (Integer entryPosition : positions) {
				LineupEntry player = extraPLayers.get(entryPosition);
	
				double graphicalPosition = VERTICAL_033 + (counter * HEIGHT_LINE * FACTOR_CORRECTIF);
				player.getAssociatedObjects().put(GRAPHICAL_POSITION, graphicalPosition);
				if (lastPlayerDescription != null
						&& lastPlayerDescription.getPlayerDescription().getName().equals(player.getPlayerDescription().getName())) {
					if (lastPlayerDescription.getDefensivePosition().startsWith("ph") //$NON-NLS-1$
							|| lastPlayerDescription.getDefensivePosition().startsWith("pr")) { //$NON-NLS-1$
						graphicalPosition = (double) lastPlayerDescription.getAssociatedObjects().get(GRAPHICAL_POSITION);
						player.getAssociatedObjects().put(GRAPHICAL_POSITION, graphicalPosition);
					}
				}
	
				drawPlayerName(player, lastPlayerDescription, graphicalPosition, false);
	
				/* et le numero de maillot */
				drawShirtNumber(player, lastPlayerDescription, graphicalPosition);
	
				/* la valeur de l'IP */
				drawIpValue(player, graphicalPosition);
	
				/* position defensive */
				drawDefensivePosition(player, lastPlayerDescription, graphicalPosition);
	
				/* et ne pas oublier la position offensive */
				drawOffensivePosition(player, lastPlayerDescription, graphicalPosition);
	
				/* set indice for defensive position */
				drawIndiceForDefensivePosition(player, lastPlayerDescription, graphicalPosition);
	
				lastPlayerDescription = getLastPlayerDescription(player,
						ScoreGameDisplay.getSubstitutionDisplayCode(player.getDefensivePosition()));
	
				counter++;
			}
	
			int pitcherCounter = 0;
			for (LineupEntry pitcher : lineup.getPitchers()) {
				LineupPlayerDescription player = pitcher.getPlayerDescription();
	
				double position = VERTICAL_041 + pitcherCounter * HEIGHT_LINE * FACTOR_CORRECTIF;
	
				/* on affiche la latéralité*/
				if (pitcher.getLaterality() != null) {
					putString(normal6Font, EngineConstants.graphicsColorPencil, pitcher.getLaterality(), HORIZONTAL_005, 
							position,  HORIZONTAL_006 - HORIZONTAL_005, HEIGHT_LINE * FACTOR_CORRECTIF);
				}
				
				/* On affiche le nom */
				putStringWithXOffset(normal8Font, player.getName().substring(0, Math.min(player.getName().length(), 19)),
						HORIZONTAL_006 + 1, position, HEIGHT_LINE * FACTOR_CORRECTIF);
	
				/* et le numero de maillot */
				putString(normal6Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + player.getShirtNumber(), HORIZONTAL_007,
						position, HORIZONTAL_008 - HORIZONTAL_007, HEIGHT_LINE * FACTOR_CORRECTIF);
				/* la valeur de l'IP */
				putString(normal6Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + pitcher.getIpPlayed(), HORIZONTAL_004,
						position, HORIZONTAL_005 - HORIZONTAL_004, HEIGHT_LINE * FACTOR_CORRECTIF);
				pitcherCounter++;
	
				if (EngineConstants.graphicsShowWinLoseSave) {
					try {
						if (statistiqueEngine.getStatisticManager().getStats().getLoosingPitcher() == pitcher) {
							putString(bold6Font, EngineConstants.graphicsColorPencil, "L", HORIZONTAL_008, position, //$NON-NLS-1$
									STAT_PITCHER_001 - HORIZONTAL_008, HEIGHT_LINE * FACTOR_CORRECTIF);
						} else if (statistiqueEngine.getStatisticManager().getStats().getWinningPitcher() == pitcher) {
							putString(bold6Font, EngineConstants.graphicsColorPencil, "W", HORIZONTAL_008, position, //$NON-NLS-1$
									STAT_PITCHER_001 - HORIZONTAL_008, HEIGHT_LINE * FACTOR_CORRECTIF);
						} else if (statistiqueEngine.getStatisticManager().getStats().getSavePitcher() == pitcher) {
							putString(bold6Font, EngineConstants.graphicsColorPencil, "Sa", HORIZONTAL_008, position, //$NON-NLS-1$
									STAT_PITCHER_001 - HORIZONTAL_008, HEIGHT_LINE * FACTOR_CORRECTIF);
						}
					} catch (NullPointerException ex) {
						
					}
				}
			}
	
			/* Set pitcher description */
	
			int catcherCounter = 0;
			for (LineupEntry catcher : lineup.getCatchers()) {
	
				double position = VERTICAL_041 + catcherCounter * HEIGHT_LINE * FACTOR_CORRECTIF;
	
				/* On affiche le nom */
				putStringWithXOffset(normal8Font,
						catcher.getPlayerDescription().getName().substring(0,
								Math.min(catcher.getPlayerDescription().getName().length(), 19)),
						HORIZONTAL_025 + 1, position, HEIGHT_LINE * FACTOR_CORRECTIF);
	
				/* la valeur de l'IP */
				catcherCounter++;
			}
		}
	}

	/**
	 * Get player description for a substitution
	 * 
	 * @param player Reference on the player 
	 * @param codeToDisplay code to display
	 * 
	 * @return  reference on the last player description,<b>null</b> if not found
	 */
	private LineupEntry getLastPlayerDescription(LineupEntry player, String codeToDisplay) {
		if ("ph".equals(codeToDisplay) || "pr".equals(codeToDisplay)) { //$NON-NLS-1$ //$NON-NLS-2$
			return player;
		} else {
			return null;
		}
	}

	/**
	 * Draw a player name.
	 * 
	 * @param player Reference on the player description
	 * @param lastPlayerDescription Reference on the last player
	 * @param graphicalPosition Where to draw
	 * @param setTilde <b>true</b> display the title,<b>false</b> otherwise
	 */
	private void drawPlayerName(LineupEntry player, LineupEntry lastPlayerDescription, double graphicalPosition,
			boolean setTilde) {
		if (!isSamePlayer(player, lastPlayerDescription)) {

			if (EngineConstants.graphicsShowNewStyleSheet) {
				String name = player.getPlayerDescription().getName().substring(0,
						Math.min(player.getPlayerDescription().getName().length(), 16));
				if (setTilde) {
					name = "-------------------------------"; //$NON-NLS-1$
				}

				putStringWithXOffset(normal8Font, name, HORIZONTAL_006N + 1, graphicalPosition,
						HEIGHT_LINE * FACTOR_CORRECTIF);

			} else {
				String name = player.getPlayerDescription().getName().substring(0,
						Math.min(player.getPlayerDescription().getName().length(), 19));
				if (setTilde) {
					name = "-------------------------------"; //$NON-NLS-1$
				}

				putStringWithXOffset(normal8Font, name, HORIZONTAL_006 + 1, graphicalPosition,
						HEIGHT_LINE * FACTOR_CORRECTIF);

			}
		}
	}

	/**
	 * Draw the shirt number of a player
	 * 
	 * @param player  Reference on the player description
	 * @param lastPlayerDescription Reference on the last player
	 * @param graphicalPosition Where to draw
	 */
	private void drawShirtNumber(LineupEntry player, LineupEntry lastPlayerDescription, double graphicalPosition) {
		if (!isSamePlayer(player, lastPlayerDescription)) {
			putString(normal6Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + player.getPlayerDescription().getShirtNumber(),
					HORIZONTAL_007, graphicalPosition, HORIZONTAL_008 - HORIZONTAL_007, HEIGHT_LINE * FACTOR_CORRECTIF);
		}
	}

	/**
	 * Draw indice of the defensive position of a player.
	 * 
	 * @param player  Reference on the player description
	 * @param lastPlayerDescription Reference on the last player
	 * @param graphicalPosition Where to draw
	 */
	private void drawIndiceForDefensivePosition(LineupEntry player, LineupEntry lastPlayerDescription,
			double graphicalPosition) {
		g2.setFont(normal2FontIndex);

		if (Character.isDigit(player.getDefensivePosition().charAt(0)) && 
			(!player.getDefensivePositionIndex().equals("0"))) { //$NON-NLS-1$

			if (EngineConstants.graphicsShowNewStyleSheet) {

				if (isSamePlayer(player, lastPlayerDescription)) {

					putString(normal4Font, EngineConstants.graphicsColorPencil,
							EMPTY_STRING + player.getDefensivePositionIndex(),
							HORIZONTAL_006 + (HORIZONTAL_006 - HORIZONTAL_005) / 4, graphicalPosition + 2,
							(HORIZONTAL_006 - HORIZONTAL_005) / 2 + 2, HEIGHT_LINE * (FACTOR_CORRECTIF / 2));

				} else {
					putString(normal4Font, EngineConstants.graphicsColorPencil,
							EMPTY_STRING + player.getDefensivePositionIndex(),
							HORIZONTAL_005 + (HORIZONTAL_006 - HORIZONTAL_005) / 4, graphicalPosition + 2,
							(HORIZONTAL_006 - HORIZONTAL_005) / 2 + 2, HEIGHT_LINE * (FACTOR_CORRECTIF / 2));
				}

			} else {

				if (isSamePlayer(player, lastPlayerDescription)) {

					putString(normal4Font, EngineConstants.graphicsColorPencil,
							EMPTY_STRING + player.getDefensivePositionIndex(),
							HORIZONTAL_005 + (HORIZONTAL_006 - HORIZONTAL_005) / 4 + 2.5, graphicalPosition + 4.5,
							(HORIZONTAL_006 - HORIZONTAL_005) / 2 + 2, HEIGHT_LINE * (FACTOR_CORRECTIF / 2));

				} else {

					putString(normal4Font, EngineConstants.graphicsColorPencil,
							EMPTY_STRING + player.getDefensivePositionIndex(),
							HORIZONTAL_005 + (HORIZONTAL_006 - HORIZONTAL_005) / 4, graphicalPosition + 2,
							(HORIZONTAL_006 - HORIZONTAL_005) / 2 + 2, HEIGHT_LINE * (FACTOR_CORRECTIF / 2));
				}
			}
		}
	}

	/**
	 * Draw the offensive position of a player.
	 * 
	 * @param player  Reference on the player description
	 * @param lastPlayerDescription Reference on the last player
	 * @param graphicalPosition Where to draw
	 */
	private void drawOffensivePosition(LineupEntry player, LineupEntry lastPlayerDescription,
			double graphicalPosition) {
		if (lastPlayerDescription == null) {
			putString(normal6Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + player.getOffensivePosition(),
					HORIZONTAL_008, graphicalPosition, HORIZONTAL_009 - HORIZONTAL_008, HEIGHT_LINE * FACTOR_CORRECTIF);
		}
	}

	/**
	 * Draw the IP value of a player.
	 * 
	 * @param player  Reference on the player description
	 * @param graphicalPosition Where to draw
	 */
	private void drawIpValue(LineupEntry player, double graphicalPosition) {
		if (Character.isDigit(player.getDefensivePosition().charAt(0))) {
			putString(normal6Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + player.getIpPlayed(), HORIZONTAL_004,
					graphicalPosition, HORIZONTAL_005 - HORIZONTAL_004, HEIGHT_LINE * FACTOR_CORRECTIF);
		}
	}

	/**
	 * Draw the defensive position of a player.
	 * 
	 * @param player  Reference on the player description
	 * @param lastPlayerDescription Reference on the last player
	 * @param graphicalPosition Where to draw
	 */
	private void drawDefensivePosition(LineupEntry player, LineupEntry lastPlayerDescription,
			double graphicalPosition) {

		if (EngineConstants.graphicsShowNewStyleSheet) {

			if (Character.isDigit(player.getDefensivePosition().charAt(0))
					|| player.getDefensivePosition().equals("dh")) { //$NON-NLS-1$

				if (isSamePlayer(player, lastPlayerDescription)) {

					putString(normal6Font, EngineConstants.graphicsColorPencil, player.getDefensivePosition(),
							HORIZONTAL_006 + 2, graphicalPosition, (HORIZONTAL_006N - HORIZONTAL_006) / 2,
							HEIGHT_LINE * FACTOR_CORRECTIF);

				} else {
					putString(normal6Font, EngineConstants.graphicsColorPencil, player.getDefensivePosition(),
							HORIZONTAL_005 + 2, graphicalPosition, (HORIZONTAL_006 - HORIZONTAL_005) / 2,
							HEIGHT_LINE * FACTOR_CORRECTIF);
				}

			} else {
				/* cas du pr, ph, dr, dp */
				String codeToDisplay = ScoreGameDisplay.getSubstitutionDisplayCode(player.getDefensivePosition());

				if ("ph".equals(codeToDisplay) || "pr".equals(codeToDisplay)) { //$NON-NLS-1$ //$NON-NLS-2$
					putString(normal6Font, EngineConstants.graphicsColorPencil, codeToDisplay, HORIZONTAL_005 + 2,
							graphicalPosition, (HORIZONTAL_006 - HORIZONTAL_005) / 2, HEIGHT_LINE * FACTOR_CORRECTIF);

				} else {

					putString(normal6Font, EngineConstants.graphicsColorPencil, codeToDisplay, HORIZONTAL_005 + 2,
							graphicalPosition, (HORIZONTAL_006N - HORIZONTAL_006) / 2, HEIGHT_LINE * FACTOR_CORRECTIF);
				}

			}

		} else {

			if (Character.isDigit(player.getDefensivePosition().charAt(0))
					|| player.getDefensivePosition().equals("dh")) { //$NON-NLS-1$

				if (isSamePlayer(player, lastPlayerDescription)) {

					Stroke currentStroke = g2.getStroke();
					Color lastColor = g2.getColor();
					g2.setColor(EngineConstants.graphicsColorPencil);
					g2.setStroke(new BasicStroke((float) 0.5));
					g2.drawLine((int) (HORIZONTAL_006), (int) (graphicalPosition), (int) (HORIZONTAL_005),
							(int) (graphicalPosition + HEIGHT_LINE * FACTOR_CORRECTIF));
					g2.setStroke(currentStroke);
					g2.setColor(lastColor);

					putString(normal5Font, EngineConstants.graphicsColorPencil, player.getDefensivePosition(),
							HORIZONTAL_005 + 5, graphicalPosition + 2.5, (HORIZONTAL_006 - HORIZONTAL_005) / 2,
							HEIGHT_LINE * FACTOR_CORRECTIF);

				} else {

					putString(normal6Font, EngineConstants.graphicsColorPencil, player.getDefensivePosition(),
							HORIZONTAL_005 + 2, graphicalPosition, (HORIZONTAL_006 - HORIZONTAL_005) / 2,
							HEIGHT_LINE * FACTOR_CORRECTIF);
				}

			} else {
				/* cas du pr, ph, dr, dp */
				String codeToDisplay = ScoreGameDisplay.getSubstitutionDisplayCode(player.getDefensivePosition());

				if ("ph".equals(codeToDisplay) || "pr".equals(codeToDisplay)) { //$NON-NLS-1$ //$NON-NLS-2$
					putString(normal5Font, EngineConstants.graphicsColorPencil, codeToDisplay, HORIZONTAL_005 + 1,
							graphicalPosition - 2, (HORIZONTAL_006 - HORIZONTAL_005) / 2,
							HEIGHT_LINE * FACTOR_CORRECTIF);

				} else {

					putString(normal6Font, EngineConstants.graphicsColorPencil, codeToDisplay, HORIZONTAL_005 + 2,
							graphicalPosition, (HORIZONTAL_006 - HORIZONTAL_005) / 2, HEIGHT_LINE * FACTOR_CORRECTIF);
				}
			}
		}
	}

	/**
	 * Check if the current player is the same player than the last description.
	 * 
	 * @param player reference to the player
	 * @param lastPlayerDescription reference to the last player
	 * @return <b>true</b> it is the same player,<b>false</b> otherwize
	 */
	private boolean isSamePlayer(LineupEntry player, LineupEntry lastPlayerDescription) {
		return (lastPlayerDescription != null)
				&& (player.getPlayerDescription() == lastPlayerDescription.getPlayerDescription());
	}

	/**
	 * Get the graphical position of an entry in the line-up
	 * 
	 * @param intValue Batter number
	 * @param players List of possibles players in the line-up
	 * @param positionInBatterRow POition in the batter row
	 * @param player reference to the player
	 * 
	 * @return Graphical position in the sheet
	 */
	private double getGraphicalLineUpPosition(int intValue, List<LineupEntry> players, int positionInBatterRow,
			LineupEntry player) {
		if (intValue > 9) {
			return getPosition(intValue, 0).y + (players.indexOf(player) + 8) * HEIGHT_LINE * FACTOR_CORRECTIF;
		} else {
			return getPosition(intValue, 0).y + positionInBatterRow * HEIGHT_LINE * FACTOR_CORRECTIF;
		}
	}

	/**
	 * Get the list of score keepers.
	 * 
	 * @param description Game description element
	 * @return List of names
	 */
	private String getScoreKeepersList(Description description) {
		StringBuilder scoreKeepers = new StringBuilder();
		if (description != null && description.getScorekeepers() != null) {
			for (int i = 0; i < description.getScorekeepers().getScorekeepers().size(); i++) {
				scoreKeepers.append(description.getScorekeepers().getScorekeepers().get(i));
				if (i < description.getScorekeepers().getScorekeepers().size() - 1) {
					scoreKeepers.append(", "); //$NON-NLS-1$
				}
			}
		}
		return scoreKeepers.toString();
	}

	/**
	 * Get the list of score keepers.
	 * 
	 * @param description Game description element
	 * @return List of names
	 */
	private String getUmpireList(Description description) {
		StringBuilder umpires = new StringBuilder();

		if (description != null && description.getUmpires() != null) {
			for (int i = 0; i < description.getUmpires().getUmpires().size(); i++) {
				umpires.append(description.getUmpires().getUmpires().get(i));
				if (i < description.getUmpires().getUmpires().size() - 1) {
					umpires.append(", "); //$NON-NLS-1$
				}
			}
		}
		return umpires.toString();
	}

	/**
	 * Fill the header part of the home team score sheet.
	 * 
	 * @param game Reference on the Game parse result.
	 */
	public void fillHeaderHomeTeamPage(Game game) {
		g2.setColor(EngineConstants.graphicsColorPencil);
		Font currentFont = g2.getFont();
		
		g2.setFont(normal7Font);
		Rectangle2D headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Tournament, g2); 
		double tournametOffet = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Category, g2); 
		double categoryOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Visitor, g2); 
		double visitorOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Hometeam, g2); 
		double hometeamOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Date, g2); 
		double dateOffset = (int) (82 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Start, g2); 
		double startOffset = (82 * FACTOR_CORRECTIF) + headerSize.getWidth();
	
		
		g2.setFont(bold6Font);

		/* remplissage de l'entête */
		Description description = game.getDescription();
		if (description != null) {
			if (description.getTournament() != null) {
				g2.drawString(description.getTournament().toUpperCase(), (int)tournametOffet+1,	HOMETEAM_TOURNAMENT_TEXT_Y);
			}
			if (description.getCategory() != null) {
				g2.drawString(description.getCategory().toUpperCase(), (int)categoryOffset+1, HOMETEAM_CATEGORY_TEXT_Y);
			}
			if (game.getVisitor() != null && game.getVisitor().getName() != null) {
				g2.drawString(game.getVisitor().getName().toUpperCase(), (int)visitorOffset+1,HOMETEAM_VISITOR_TEXT_Y);
			}
			if (game.getHometeam() != null && game.getHometeam().getName() != null) {
				g2.drawString(game.getHometeam().getName().toUpperCase(), (int)hometeamOffset+1,	HOMETEAM_HOMETEAM_TEXT_Y);
			}
			if (description.getDate() != null) {
				g2.drawString(description.getDate(), (int)dateOffset+1, HOMETEAM_DATE_TEXT_Y);
			}
			if (description.getStartTime() != null) {
				g2.drawString(description.getStartTime(), (int)startOffset+1, HOMETEAM_START_TEXT_Y);
			}

			String gameNumber = game.getName();
			if (gameNumber != null) {
				for (int i = 0; i < gameNumber.length(); i++) {
					putString(EMPTY_STRING + gameNumber.charAt(i), bold6Font, EngineConstants.graphicsColorPencil,
							NUMBER_SEPARATOR_HOMETEAM + (i * WIDTH_LINE * FACTOR_CORRECTIF), VERTICAL_000,
							WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
				}
			}

			if (description.getType() != null) {
				if (description.getType().equals("baseball")) { //$NON-NLS-1$
					g2.fillRect((int) BASEBALL_X_POSITION, (int) CHECK_BOX_Y_POSITION, (int) CHECKBOX_WIDTH,
							(int) CHECHBOX_HEIGHT);
				} else {
					g2.fillRect((int) SOFTBALL_X_POSITION, (int) CHECK_BOX_Y_POSITION, (int) CHECKBOX_WIDTH,
							(int) CHECHBOX_HEIGHT);
				}
			}

			g2.setFont(bold7Font);
			if (game.getHometeam() != null && game.getHometeam().getName() != null) {
				String homeTeamName = game.getHometeam().getName();
				putString(homeTeamName, bold7Font, EngineConstants.graphicsColorPencil, HORIZONTAL_005 + 10,
						VERTICAL_004, HORIZONTAL_007 - HORIZONTAL_005, HEIGHT_LINE * FACTOR_CORRECTIF);
			}
		}
		g2.setFont(currentFont);
	}

	/**
	 * Fill the header part of the visitor team score sheet.
	 * 
	 * @param game Reference on the Game parse result.
	 */
	protected void fillHeaderVisitorPage(Game game) {
		g2.setColor(EngineConstants.graphicsColorPencil);
		Font currentFont = g2.getFont();
		
		g2.setFont(normal7Font);
		Rectangle2D headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_ScoreKeeper, g2); 
		double scoreKeeperOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Umpires, g2); 
		double umpireOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Tournament, g2); 
		double tournamentOffset = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Category, g2); 
		double catgoryOffset = (HORIZONTAL_MARGE + 102.8 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Date, g2); 
		double catgoryDate = (HORIZONTAL_MARGE + 155.6 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Stadium, g2); 
		double catgoryStadium = (HORIZONTAL_MARGE + 79.7 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Start, g2); 
		double catgoryStart = (HORIZONTAL_MARGE + 128.8 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_End, g2); 
		double catgoryEnd = (HORIZONTAL_MARGE + 147.3 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Duration, g2); 
		double catgoryDuration = (HORIZONTAL_MARGE + 166.2 * FACTOR_CORRECTIF) + headerSize.getWidth();
		headerSize = g2.getFontMetrics().getStringBounds(Messages.ScoringSheetGraphicalManager_Town, g2); 
		double catgoryTown = (HORIZONTAL_005 + (WIDTH_LINE / 2 * FACTOR_CORRECTIF)) + headerSize.getWidth();
		
		g2.setFont(bold6Font);
		/* remplissage de l'entête */
		Description description = game.getDescription();
		if (description != null) {
			if (description.getTournament() != null) {
				g2.drawString(description.getTournament(), (int)tournamentOffset+1, VISITOR_TOURNAMENT_TEXT_Y);
			}
			if (description.getCategory() != null) {
				g2.drawString(description.getCategory(), (int)catgoryOffset+1, VISITOR_CATEGORY_TEXT_Y);
			}
			if (description.getPlace() != null) {
				g2.drawString(description.getPlace(), (int)catgoryTown+1, VISITOR_CITY_TEXT_Y);
			}
			if (description.getStadium() != null) {
				g2.drawString(description.getStadium(), (int)catgoryStadium+1, VISITOR_PLACE_TEXT_Y);
			}
			if (description.getDate() != null) {
				g2.drawString(description.getDate(), (int)catgoryDate+1, VISITOR_DATE_TEXT_Y);
			}
			if (description.getStartTime() != null) {
				g2.drawString(description.getStartTime(), (int)catgoryStart+1, VISITOR_START_TIME_TEXT_Y);
			}
			if (description.getEndTime() != null) {
				g2.drawString(description.getEndTime(), (int)catgoryEnd+1, VISITOR_END_TIME_TEXT_Y);
			}
			if (description.getDuration() != null) {
				g2.drawString(description.getDuration(), (int)catgoryDuration+1, VISITOR_DURATION_TEXT_Y);
			}
			g2.drawString(getUmpireList(description), (int)umpireOffset+1, VISITOR_UMPIRES_TEXT_Y);
			g2.drawString(getScoreKeepersList(description), (int)scoreKeeperOffset+1, VISITOR_SCOREKEEPERS_TEXT_Y);

			String gameNumber = game.getName();
			if (gameNumber != null) {
				for (int i = 0; i < gameNumber.length(); i++) {
					putString(EMPTY_STRING + gameNumber.charAt(i), bold6Font, EngineConstants.graphicsColorPencil,
							NUMBER_SEPARATOR_VISITOR + (i * WIDTH_LINE * FACTOR_CORRECTIF), VERTICAL_003,
							WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);
				}
			}

			if (game.getVisitor() != null && game.getVisitor().getName() != null) {
				String visitorName = game.getVisitor().getName();
				putStringWithXOffset(bold12Font, visitorName, NAME_SEPARATOR_VISITOR + 10, VERTICAL_001,
						(VERTICAL_004 - VERTICAL_001) / 2);
			}
			if (game.getHometeam() != null && game.getHometeam().getName() != null) {
				String homeTeamName = game.getHometeam().getName();
				putStringWithXOffset(bold12Font, homeTeamName, NAME_SEPARATOR_VISITOR + 10,
						VERTICAL_001 + (VERTICAL_004 - VERTICAL_001) / 2, (VERTICAL_004 - VERTICAL_001) / 2);
			}
			/* nom de l'equipe au dessus du lineup */
			g2.setFont(bold7Font);
			if (game.getVisitor() != null && game.getVisitor().getName() != null) {
				String visitorName = game.getVisitor().getName();
				putString(visitorName, bold7Font, EngineConstants.graphicsColorPencil, HORIZONTAL_005 + 10,
						VERTICAL_004, HORIZONTAL_007 - HORIZONTAL_005, HEIGHT_LINE * FACTOR_CORRECTIF);
			}
		}
		g2.setFont(currentFont);
	}

	/**
	 * Fill the control part of the score sheet.
	 * 
	 * @param teamStats Statistics of the team
	 * @param oppositStats Statistics of the opposite team
	 */
	protected void fillControlPart(TeamStatistic teamStats, TeamStatistic oppositStats) {

		if (!EngineConstants.NO_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
			OffensiveStatistic offensiveStats = teamStats.getTotalOffensiveStatistic();
			double heigthLine = HEIGHT_LINE * FACTOR_CORRECTIF;
			double widthLine = WIDTH_LINE * FACTOR_CORRECTIF;

			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + offensiveStats.getAtBats(),
					HORIZONTAL_AB_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + offensiveStats.getSacrificeHit(),
					HORIZONTAL_HIT_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + offensiveStats.getSacrificeFly(),
					HORIZONTAL_3B_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + offensiveStats.getBaseOnBall(),
					HORIZONTAL_GDP_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + offensiveStats.getHitByPitch(),
					HORIZONTAL_SF_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil,
					EMPTY_STRING + offensiveStats.getInterferanceObstruction(), HORIZONTAL_IBB_POSITION, VERTICAL_044, widthLine,
					heigthLine);//$NON-NLS-1$
			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + teamStats.getTieBreakCounter(),
					HORIZONTAL_IO_POSITION, VERTICAL_044, widthLine, heigthLine);//$NON-NLS-1$

			int total = offensiveStats.getAtBats() + offensiveStats.getSacrificeHit() + offensiveStats.getSacrificeFly()
					+ offensiveStats.getBaseOnBall() + offensiveStats.getHitByPitch()
					+ offensiveStats.getInterferanceObstruction() + teamStats.getTieBreakCounter();

			putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + total, HORIZONTAL_CS_POSITION,
					VERTICAL_044, widthLine * 1.5, heigthLine);//$NON-NLS-1$

			EList<InninStatictic> generalStatistic = teamStats.getGeneralInningStats();
			DefensiveStatistic defensiveStats = oppositStats.getTotalDefensiveStatistic();
			if (!generalStatistic.isEmpty()) {
				InningGeneralStatistic cumultativeStats = generalStatistic.get(generalStatistic.size() - 1)
						.getCumulativeInningStat();
				double verticalPosition = VERTICAL_046 + HEIGHT_LINE / 2 * FACTOR_CORRECTIF;

				putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + cumultativeStats.getRuns(),
						HORIZONTAL_2B_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF, verticalPosition, widthLine,
						heigthLine);
				putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + cumultativeStats.getLob(),
						HORIZONTAL_SH_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF, verticalPosition, widthLine,
						heigthLine);
				putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + defensiveStats.getPutOut(),
						HORIZONTAL_HP_POSITION + WIDTH_LINE / 2 * FACTOR_CORRECTIF, verticalPosition, widthLine,
						heigthLine);

				total = cumultativeStats.getRuns() + cumultativeStats.getLob() + defensiveStats.getPutOut();
				putString(normal7Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + total, HORIZONTAL_CS_POSITION,
						verticalPosition, widthLine * 1.5, heigthLine);
			}
		}
	}

	/**
	 * Fill a statistics values on the score sheet.
	 * 
	 * @param teamStats Statistics of the team 
	 * @param lineup Reference on the line-up of the team
	 */
	protected void fillTeamStatistics(TeamStatistic teamStats, LineupManager lineup) {

		if (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
			fillOffensiveStatistics(teamStats, teamStats.getTotalOffensiveStatistic(), lineup);
			fillDefensivesStatistics(teamStats.getTotalDefensiveStatistic(), lineup);
			fillPitcherStatistics(teamStats.getPitchers(), teamStats.getTotalPitcherStatistic());
			fillCatcherStatistics(teamStats.getCatchers(), teamStats.getTotalCatcherStatistic());

			setEarnedAgainstTheTeam(teamStats.getEarnedAgainstTheTeam());

			if (teamStats.getGwRbi() != null) {
				g2.drawString(teamStats.getGwRbi(), (int) HORIZONTAL_HIT_POSITION, (int) (VERTICAL_042) - 4);
			}

			if (teamStats.getDoublePlayCounter() > 0) {
				putString(EMPTY_STRING + teamStats.getDoublePlayCounter(), bold6Font, EngineConstants.graphicsColorPencil,
						HORIZONTAL_005, VERTICAL_040, WIDTH_LINE * FACTOR_CORRECTIF, HEIGHT_LINE * FACTOR_CORRECTIF);//$NON-NLS-1$

			}
		}
	}

	/**
	 * Fill the catcher statistics values on the score sheet.
	 * 
	 * @param catchers List of catchers
	 * @param totalCatcherStatistic Catchers statistics
	 */
	private void fillCatcherStatistics(EList<LineupEntry> catchers, CatcherStatistic totalCatcherStatistic) {
		/* pour tous les joueurs actfs dans le Line up */
		for (int i = 0; i < catchers.size(); i++) {
			LineupEntry catcher = catchers.get(i);
			CatcherStatistic catcherStatistic = catcher.getCatcherStatistic();

			g2.setFont(normal8Font);
			putCatcherStatValue(catcherStatistic.getPassBall(), 0, i);
			putCatcherStatValue(catcherStatistic.getStolenBase(), 1, i);
			putCatcherStatValue(catcherStatistic.getCaughtStealing(), 2, i);
		}
		putCatcherStatValue(totalCatcherStatistic.getPassBall(), 0, 6);
		putCatcherStatValue(totalCatcherStatistic.getStolenBase(), 1, 6);
		putCatcherStatValue(totalCatcherStatistic.getCaughtStealing(), 2, 6);
	}

	/**
	 * Fill pitcher caught stealing values (in the catcher statistic part)
	 */ 
	protected void fillPitcherCaugthStealingIfNecessary() {
		if (!caugthStealingForPitchers.isEmpty()) {

			if (caugthStealingForPitchers.size() == 1) {
				LineupEntry pitcher = caugthStealingForPitchers.get(0);
				PitcherStatistic stats = pitcher.getPitcherStatistic();

				putCatcherStatValue(stats.getCaughtStealing(), 2, 5);

				double position = VERTICAL_041 + 5 * HEIGHT_LINE * FACTOR_CORRECTIF;
				/* On affiche le nom */
				putStringWithXOffset(normal8Font,
						pitcher.getPlayerDescription().getName().substring(0,
								Math.min(pitcher.getPlayerDescription().getName().length(), 19)),
						HORIZONTAL_025 + 1, position, HEIGHT_LINE * FACTOR_CORRECTIF);

			} else {

				int cs = 0;

				for (LineupEntry pitcher : caugthStealingForPitchers) {
					PitcherStatistic stats = pitcher.getPitcherStatistic();

					cs += stats.getCaughtStealing();
					putCatcherStatValue(cs, 2, 5);

					double position = VERTICAL_041 + 5 * HEIGHT_LINE * FACTOR_CORRECTIF;
					putStringWithXOffset(normal8Font, "multiple pitchers", HORIZONTAL_025 + 1, position, //$NON-NLS-1$
							HEIGHT_LINE * FACTOR_CORRECTIF);
				}
			}
		}
	}

	/**
	 * Fill the pitcher statistics values on the score sheet.
	 * 
	 * @param pitchers List of pitchers
	 * @param totalPitcherStatistic Pitchers statistics
	 */
	private void fillPitcherStatistics(EList<LineupEntry> pitchers, PitcherStatistic totalPitcherStatistic) {

		/* pour tous les joueurs actfs dans le Line up */
		for (int i = 0; i < pitchers.size(); i++) {
			LineupEntry pitcher = pitchers.get(i);
			PitcherStatistic pitcherStatistic = pitcher.getPitcherStatistic();

			g2.setFont(normal8Font);
			putPitcherStatValue(pitcherStatistic.getBatterFront(), 0, i);
			putPitcherStatValue(pitcherStatistic.getAtBats(), 1, i);
			putPitcherStatValue(pitcherStatistic.getRuns(), 2, i);
			putPitcherStatValue(pitcherStatistic.getEarnedRuns(), 3, i);
			putPitcherStatValue(pitcherStatistic.getHits(), 4, i);
			putPitcherStatValue(pitcherStatistic.getDouble(), 5, i);
			putPitcherStatValue(pitcherStatistic.getTriple(), 6, i);
			putPitcherStatValue(pitcherStatistic.getHomerun(), 7, i);
			putPitcherStatValue(pitcherStatistic.getSacrificeHit(), 8, i);
			putPitcherStatValue(pitcherStatistic.getSacrificeFly(), 9, i);
			putPitcherStatValue(pitcherStatistic.getBaseOnBall(), 10, i);
			putPitcherStatValue(pitcherStatistic.getIntentionalbaseOnBall(), 11, i);
			putPitcherStatValue(pitcherStatistic.getHitByPitch(), 12, i);
			putPitcherStatValue(pitcherStatistic.getInterferanceObstruction(), 13, i);
			putPitcherStatValue(pitcherStatistic.getStrikeOut(), 14, i);
			putPitcherStatValue(pitcherStatistic.getWildPitches(), 15, i);
			putPitcherStatValue(pitcherStatistic.getBalks(), 16, i);

			if (pitcherStatistic.getCaughtStealing() > 0) {
				caugthStealingForPitchers.add(pitcher);
			}

		}
		putPitcherStatValue(totalPitcherStatistic.getBatterFront(), 0, 6);
		putPitcherStatValue(totalPitcherStatistic.getAtBats(), 1, 6);
		putPitcherStatValue(totalPitcherStatistic.getRuns(), 2, 6);
		putPitcherStatValue(totalPitcherStatistic.getEarnedRuns(), 3, 6);
		putPitcherStatValue(totalPitcherStatistic.getHits(), 4, 6);
		putPitcherStatValue(totalPitcherStatistic.getDouble(), 5, 6);
		putPitcherStatValue(totalPitcherStatistic.getTriple(), 6, 6);
		putPitcherStatValue(totalPitcherStatistic.getHomerun(), 7, 6);
		putPitcherStatValue(totalPitcherStatistic.getSacrificeHit(), 8, 6);
		putPitcherStatValue(totalPitcherStatistic.getSacrificeFly(), 9, 6);
		putPitcherStatValue(totalPitcherStatistic.getBaseOnBall(), 10, 6);
		putPitcherStatValue(totalPitcherStatistic.getIntentionalbaseOnBall(), 11, 6);
		putPitcherStatValue(totalPitcherStatistic.getHitByPitch(), 12, 6);
		putPitcherStatValue(totalPitcherStatistic.getInterferanceObstruction(), 13, 6);
		putPitcherStatValue(totalPitcherStatistic.getStrikeOut(), 14, 6);
		putPitcherStatValue(totalPitcherStatistic.getWildPitches(), 15, 6);
		putPitcherStatValue(totalPitcherStatistic.getBalks(), 16, 6);
	}

	/**
	 * Fill the earned against team points in the pitcher statistics area.
	 * 
	 * @param earnedAgainstTheTeam Number of runs
	 */
	private void setEarnedAgainstTheTeam(int earnedAgainstTheTeam) {
		if (earnedAgainstTheTeam != 0) {
			g2.setFont(normal8Font);
			/* on met l valeur, puis on dessine le petit cercle */
			putPitcherStatValue(earnedAgainstTheTeam, 3, 5);

			double x = STAT_PITCHER_001 + WIDTH_LINE / 2 + 3 * WIDTH_LINE * FACTOR_CORRECTIF - 1;
			double y = VERTICAL_041 + HEIGHT_LINE * 5 * FACTOR_CORRECTIF + 1;

			g2.drawOval((int) x, (int) y, (int) (WIDTH_LINE * FACTOR_CORRECTIF - 1),
					(int) (HEIGHT_LINE * FACTOR_CORRECTIF - 2));

		}
	}

	/**
	 * Fill the defensive statistics values on the score sheet.
	 * 
	 * @param totalDefensiveStatistic Reference on the defensive statistics
	 * @param lineup Reference on the line-up of the team
	 */
	private void fillDefensivesStatistics(DefensiveStatistic totalDefensiveStatistic, LineupManager lineup) {

		/* pour tous les joueurs actfs dans le Line up */
		if (lineup != null) {
			for (Entry<String, List<LineupEntry>> element : lineup.getLineupEntries().entrySet()) {
	
				for (int i = 0; i < element.getValue().size(); i++) {
					LineupEntry lineupEntry = element.getValue().get(i);
					DefensiveStatistic defensiveStatistic = getDefensiveStastisticOf(lineupEntry);
	
					if (lineupEntry.getAssociatedObjects().get(GRAPHICAL_POSITION) != null) {
	
						double position = (double) lineupEntry.getAssociatedObjects().get(GRAPHICAL_POSITION);
						if (defensiveStatistic != null) {
							g2.setFont(normal8Font);
	
							putDefensiveStatValue(defensiveStatistic.getPutOut(), 0, position);
							putDefensiveStatValue(defensiveStatistic.getAssitances(), 1, position);
							putDefensiveStatValue(defensiveStatistic.getErrors(), 2, position);
							putDefensiveStatValue(defensiveStatistic.getDoublePlay(), 3, position);
	
						}
					}
				}
			}
		}

		putDefensiveStatValue(totalDefensiveStatistic.getPutOut(), 0, VERTICAL_047);
		putDefensiveStatValue(totalDefensiveStatistic.getAssitances(), 1, VERTICAL_047);
		putDefensiveStatValue(totalDefensiveStatistic.getErrors(), 2, VERTICAL_047);
		putDefensiveStatValue(totalDefensiveStatistic.getDoublePlay(), 3, VERTICAL_047);
	}

	/**
	 * Fill the offensive statistics values on the score sheet.
	 * 
	 * @param teamStats reference on the statistics of the team
	 * @param totalOffensiveStatistic Reference on the offensvie statistics
	 * @param lineup Reference on the line-up of the team
	 */
	private void fillOffensiveStatistics(TeamStatistic teamStats, OffensiveStatistic totalOffensiveStatistic,
			LineupManager lineup) {

		/* pour tous les joueurs actfs dans le Line up */
		if (lineup != null) {
			for (Entry<String, List<LineupEntry>> element : lineup.getLineupEntries().entrySet()) {
	
				for (int i = 0; i < element.getValue().size(); i++) {
					LineupEntry player = element.getValue().get(i);
	
					OffensiveStatistic offensiveStatistic = getOffensiveStastisticOf(player, teamStats);
					if (player.getAssociatedObjects() != null
							&& player.getAssociatedObjects().containsKey(GRAPHICAL_POSITION)) {
						double position = (double) player.getAssociatedObjects().get(GRAPHICAL_POSITION);
	
						if (offensiveStatistic != null) {
	
							g2.setFont(normal8Font);
	
							putOffensiveStatValue(offensiveStatistic.getPlateAppearances(), 0, position);
							putOffensiveStatValue(offensiveStatistic.getAtBats(), 1, position);
							putOffensiveStatValue(offensiveStatistic.getRuns(), 2, position);
							putOffensiveStatValue(offensiveStatistic.getHits(), 3, position);
							putOffensiveStatValue(offensiveStatistic.getDouble(), 4, position);
							putOffensiveStatValue(offensiveStatistic.getTriple(), 5, position);
							putOffensiveStatValue(offensiveStatistic.getHomerun(), 6, position);
							putOffensiveStatValue(offensiveStatistic.getGroundedDoublePlay(), 7, position);
							putOffensiveStatValue(offensiveStatistic.getSacrificeHit(), 8, position);
							putOffensiveStatValue(offensiveStatistic.getSacrificeFly(), 9, position);
							putOffensiveStatValue(offensiveStatistic.getBaseOnBall(), 10, position);
							putOffensiveStatValue(offensiveStatistic.getIntentionalbaseOnBall(), 11, position);
							putOffensiveStatValue(offensiveStatistic.getHitByPitch(), 12, position);
							putOffensiveStatValue(offensiveStatistic.getInterferanceObstruction(), 13, position);
							putOffensiveStatValue(offensiveStatistic.getStolenBase(), 14, position);
							putOffensiveStatValue(offensiveStatistic.getCaughtStealing(), 15, position);
							putOffensiveStatValue(offensiveStatistic.getStrikeOut(), 16, position);
							putOffensiveStatValue(offensiveStatistic.getRbi(), 17, position);
	
						}
					}
				}
			}
		}

		putOffensiveStatValue(totalOffensiveStatistic.getPlateAppearances(), 0, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getAtBats(), 1, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getRuns(), 2, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getHits(), 3, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getDouble(), 4, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getTriple(), 5, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getHomerun(), 6, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getGroundedDoublePlay(), 7, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getSacrificeHit(), 8, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getSacrificeFly(), 9, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getBaseOnBall(), 10, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getIntentionalbaseOnBall(), 11, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getHitByPitch(), 12, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getInterferanceObstruction(), 13, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getStolenBase(), 14, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getCaughtStealing(), 15, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getStrikeOut(), 16, VERTICAL_040);
		putOffensiveStatValue(totalOffensiveStatistic.getRbi(), 17, VERTICAL_040);
	}

	/**
	 * Put a catcher statistic
	 * 
	 * @param value Value of the statistic
	 * @param offset offset (column number)
	 * @param indice catcher line
	 */
	private void putCatcherStatValue(int value, int offset, int indice) {
		String strValue = EMPTY_STRING;
		if (value > 0) {
			strValue = EMPTY_STRING + value;
		}
		double x = STAT_CATCHER_PB + WIDTH_LINE / 2 + offset * WIDTH_LINE * FACTOR_CORRECTIF;
		putString(strValue, bold6Font, EngineConstants.graphicsColorPencil, x,
				VERTICAL_041 + HEIGHT_LINE * indice * FACTOR_CORRECTIF, WIDTH_LINE / 2 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * Put a pitcher statistic
	 * 
	 * @param value Value of the statistic
	 * @param offset offset (column number)
	 * @param indice catcher line
	 */
	private void putPitcherStatValue(int value, int offset, int indice) {
		String strValue = EMPTY_STRING;
		if (value > 0) {
			strValue = EMPTY_STRING + value;
		}
		double x = STAT_PITCHER_001 + WIDTH_LINE / 2 + offset * WIDTH_LINE * FACTOR_CORRECTIF;
		putString(strValue, bold6Font, EngineConstants.graphicsColorPencil, x,
				VERTICAL_041 + HEIGHT_LINE * indice * FACTOR_CORRECTIF, WIDTH_LINE / 2 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * Put a defensive statistic
	 * 
	 * @param value Value of the statistic
	 * @param offset offset (column number)
	 * @param y catcher line
	 */
	private void putDefensiveStatValue(int value, int offset, double y) {
		String strValue = EMPTY_STRING;
		if (value > 0) {
			strValue = EMPTY_STRING + value;
		}
		double x = HORIZONTAL_000 + WIDTH_LINE / 2 + offset * WIDTH_LINE * FACTOR_CORRECTIF;
		putString(strValue, bold6Font, EngineConstants.graphicsColorPencil, x, y, WIDTH_LINE / 2 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * Put a offensive statistic
	 * 
	 * @param value Value of the statistic
	 * @param offset offset (column number)
	 * @param y catcher line
	 */
	private void putOffensiveStatValue(int value, double offset, double y) {
		String strValue = EMPTY_STRING;
		if (value > 0) {
			strValue = EMPTY_STRING + value;
		}
		double x = HORIZONTAL_PA_POSITION + WIDTH_LINE / 2 + offset * WIDTH_LINE * FACTOR_CORRECTIF;
		putString(strValue, bold6Font, EngineConstants.graphicsColorPencil, x, y, WIDTH_LINE / 2 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * return the offensive statistic for a player.
	 * 
	 * @param player Reference on the player
	 * @param teamStats Reference on the team statistics
	 * 
	 * @return Reference on the offensive statistic of the player,<b>null</b> if not exist
	 */
	private OffensiveStatistic getOffensiveStastisticOf(LineupEntry player, TeamStatistic teamStats) {
		for (LineupEntry statPlayer : teamStats.getPlayers()) {
			if (statPlayer == player) {
				return statPlayer.getOffensiveStatistic();
			}
		}

		return null;
	}

	/**
	 * return the defensive statistic for a player.
	 * 
	 * @param player Reference on the player
	 *
	 * @return  Reference on the defensive statistic of the player,<b>null</b> if not exist
	 */
	private DefensiveStatistic getDefensiveStastisticOf(LineupEntry player) {

		return player.getDefensiveStatistic();
	}

	/**
	 * Fill the general statistic of an inning. 
	 * 
	 * @param inningStat Reference on the inning statistics
	 * @param inningCounter inning counter
	 * @param columnPosition Column position
	 */
	private void fillGeneralStatistics(InninStatictic inningStat, int inningCounter, int columnPosition) {

		if (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques) ||
			EngineConstants.SF1_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
			double offset = 34.6 / 2;
			g2.setColor(EngineConstants.graphicsColorPencil);

			/*
			 * on dessine la ligne en travers des stats generales si il y a plusieurs
			 * colonnes
			 */
			for (int count = startInningColumn; count < endInningColumn - 1; count++) {
				if (count == 1) {
					g2.drawLine((int) (actionAreaHorizontal[count] + offset), (int) VERTICAL_033,
							(int) (actionAreaHorizontal[count - 1] + offset), (int) VERTICAL_040);
				} else {
					g2.drawLine((int) actionAreaHorizontal[count], (int) VERTICAL_033,
							(int) actionAreaHorizontal[count - 1], (int) VERTICAL_040);
				}

				Point pointDrawPosition = getPosition(1, count);
				g2.setFont(normal6Font);
				g2.drawString(EMPTY_STRING + (inningCounter + 1), pointDrawPosition.x + 3, pointDrawPosition.y - 15);

				/* Dessin de la flèche dans les zone changement */
				pointDrawPosition = getPosition(1, count + 1);
				g2.drawLine((int) (pointDrawPosition.x - 5.0), pointDrawPosition.y - 7, (int) (pointDrawPosition.x + 5.0),
						pointDrawPosition.y - 7);

				Polygon arrow = new Polygon();
				arrow.addPoint((int) (pointDrawPosition.x + 5.0), pointDrawPosition.y - 5);
				arrow.addPoint((int) (pointDrawPosition.x + 5.0), pointDrawPosition.y - 9);
				arrow.addPoint((int) (pointDrawPosition.x + 7.0), pointDrawPosition.y - 7);
				g2.setColor(EngineConstants.graphicsColorPencil);
				g2.fillPolygon(arrow);
				g2.setColor(EngineConstants.graphicsColorPencil);

				/* Dessin de la flèche dans les zone jeu */
				pointDrawPosition = getPosition(startInningLine, count + 1);
				g2.drawLine((int) (pointDrawPosition.x - 5.0), pointDrawPosition.y - 5, (int) (pointDrawPosition.x + 5.0),
						pointDrawPosition.y + 5);

				arrow = new Polygon();
				arrow.addPoint((int) (pointDrawPosition.x + 7.0), pointDrawPosition.y + 3);
				arrow.addPoint((int) (pointDrawPosition.x + 3.0), pointDrawPosition.y + 7);
				arrow.addPoint((int) (pointDrawPosition.x + 7.0), pointDrawPosition.y + 7);
				g2.setColor(EngineConstants.graphicsColorPencil);
				g2.fillPolygon(arrow);
				g2.setColor(EngineConstants.graphicsColorPencil);

			}
			Point pointDrawPosition = getPosition(1, endInningColumn - 1);
			g2.setFont(normal6Font);
			g2.drawString(EMPTY_STRING + (inningCounter + 1), pointDrawPosition.x + 3, pointDrawPosition.y - 15);

			if (inningCounter == 0) {
				try {
					putInningStatValue(inningStat.getInningStat().getAtBats(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_033);
					putInningStatValue(inningStat.getInningStat().getRuns(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_034);
					if (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
						putInningStatValue(inningStat.getInningStat().getEarnedRuns(),
								actionAreaHorizontal[columnPosition] + offset, VERTICAL_035);
					}	
					putInningStatValue(inningStat.getInningStat().getHits(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_036);
					putInningStatValue(inningStat.getInningStat().getAssitances(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_037);
					putInningStatValue(inningStat.getInningStat().getErrors(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_038);
					putInningStatValue(inningStat.getInningStat().getLob(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_039);
				} catch (NullPointerException|ArrayIndexOutOfBoundsException ex) {
					logger.log(Level.SEVERE, ex.getMessage());
				}

			} else {

				putInningStatValue(inningStat.getInningStat().getAtBats(), actionAreaHorizontal[columnPosition],
						VERTICAL_033);
				putInningStatValue(inningStat.getInningStat().getRuns(), actionAreaHorizontal[columnPosition],
						VERTICAL_034);
				if (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
					putInningStatValue(inningStat.getInningStat().getEarnedRuns(), actionAreaHorizontal[columnPosition],
							VERTICAL_035);
				}	
				putInningStatValue(inningStat.getInningStat().getHits(), actionAreaHorizontal[columnPosition],
						VERTICAL_036);
				putInningStatValue(inningStat.getInningStat().getAssitances(), actionAreaHorizontal[columnPosition],
						VERTICAL_037);
				putInningStatValue(inningStat.getInningStat().getErrors(), actionAreaHorizontal[columnPosition],
						VERTICAL_038);
				putInningStatValue(inningStat.getInningStat().getLob(), actionAreaHorizontal[columnPosition],
						VERTICAL_039);

				putInningStatValue(inningStat.getCumulativeInningStat().getAtBats(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_033);
				putInningStatValue(inningStat.getCumulativeInningStat().getRuns(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_034);
				if (EngineConstants.FULL_STATS.equals(EngineConstants.graphicsShowStatistiques)) {
					putInningStatValue(inningStat.getCumulativeInningStat().getEarnedRuns(),
							actionAreaHorizontal[columnPosition] + offset, VERTICAL_035);
				}	
				putInningStatValue(inningStat.getCumulativeInningStat().getHits(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_036);
				putInningStatValue(inningStat.getCumulativeInningStat().getAssitances(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_037);
				putInningStatValue(inningStat.getCumulativeInningStat().getErrors(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_038);
				putInningStatValue(inningStat.getCumulativeInningStat().getLob(),
						actionAreaHorizontal[columnPosition] + offset, VERTICAL_039);
			}
		}
		/* cumulative stats */
	}

	/**
	 * Put an inning stat value
	 * 
	 * @param value Value to write
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	private void putInningStatValue(int value, double x, double y) {
		String strValue = "-"; //$NON-NLS-1$
		if (value > 0) {
			strValue = EMPTY_STRING + value;
		}

		putString(strValue, bold6Font, EngineConstants.graphicsColorPencil, x, y, ACTION_WIDTH / 2 * FACTOR_CORRECTIF,
				HEIGHT_LINE * FACTOR_CORRECTIF);
	}

	/**
	 * Write the general score in the visitor sheet
	 * 
	 * @param visitorScore Visitor score
	 * @param hometeamScore Home team score
	 */
	protected void setGeneralScore(int visitorScore, int hometeamScore) {
		g2.setColor(EngineConstants.graphicsColorPencil);

		putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + visitorScore,
				SCORE_SEPARATOR_VISITOR + ((WIDTH_LINE * 15 + 1) * FACTOR_CORRECTIF), VERTICAL_001,
				WIDTH_LINE * FACTOR_CORRECTIF, (VERTICAL_004 - VERTICAL_001) / 2); //$NON-NLS-1$

		putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + hometeamScore,
				SCORE_SEPARATOR_VISITOR + ((WIDTH_LINE * 15 + 1) * FACTOR_CORRECTIF),
				VERTICAL_001 + (VERTICAL_004 - VERTICAL_001) / 2, WIDTH_LINE * FACTOR_CORRECTIF,
				(VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$
	}

	/**
	 * Fill all inning score in the visitor score sheet.
	 * 
	 * @param statistiqueEngine Reference on the statistic engine
	 */
	protected void fillGeneralScore(StatisticEngine statistiqueEngine) {
		g2.setColor(EngineConstants.graphicsColorPencil);

		StatisticManager statistiqueManager = statistiqueEngine.getStatisticManager();
		GameStatistic stats = statistiqueEngine.getStatisticManager().getStats();
		GameStatisticContainer container = statistiqueManager.getStatisticContainer();

		if (stats != null && container != null) {
			TeamStatistic visitorStats = container.getVisitorStatistic(stats);
			EList<InninStatictic> inningStats = visitorStats.getGeneralInningStats();

			int inningNumber = 0;
			int visitorNbInningPlayed = inningStats.size();
			for (InninStatictic inningStat : inningStats) {
				int runs = inningStat.getInningStat().getRuns();
					putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + runs,
							SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * inningNumber * FACTOR_CORRECTIF), VERTICAL_001,
							WIDTH_LINE * FACTOR_CORRECTIF, (VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$
				inningNumber++;
			}
			putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + visitorStats.getFinalScore(),
					SCORE_SEPARATOR_VISITOR + ((WIDTH_LINE * 15 + 1) * FACTOR_CORRECTIF), VERTICAL_001,
					WIDTH_LINE * FACTOR_CORRECTIF, (VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$

			TeamStatistic homeTeamStats = container.getHomeTeamStatistic(stats);
			inningStats = homeTeamStats.getGeneralInningStats();

			inningNumber = 0;
			for (InninStatictic inningStat : inningStats) {
				int runs = inningStat.getInningStat().getRuns();
					putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + runs,
							SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * inningNumber * FACTOR_CORRECTIF),
							VERTICAL_001 + (VERTICAL_004 - VERTICAL_001) / 2, WIDTH_LINE * FACTOR_CORRECTIF,
							(VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$
				inningNumber++;
			}

			if (visitorNbInningPlayed > inningStats.size()) {
				putString(bold12Font, EngineConstants.graphicsColorPencil, "X", //$NON-NLS-1$
						SCORE_SEPARATOR_VISITOR + (WIDTH_LINE * inningNumber * FACTOR_CORRECTIF),
						VERTICAL_001 + (VERTICAL_004 - VERTICAL_001) / 2, WIDTH_LINE * FACTOR_CORRECTIF,
						(VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$
			}

			putString(bold12Font, EngineConstants.graphicsColorPencil, EMPTY_STRING + homeTeamStats.getFinalScore(),
					SCORE_SEPARATOR_VISITOR + ((WIDTH_LINE * 15 + 1) * FACTOR_CORRECTIF),
					VERTICAL_001 + (VERTICAL_004 - VERTICAL_001) / 2, WIDTH_LINE * FACTOR_CORRECTIF,
					(VERTICAL_004 - VERTICAL_001) / 2);//$NON-NLS-1$
		}
	}

	/**
	 * Draw an empty home team sheet.
	 *
	 * @param g2 Reference on the graphic context
	 */
	protected void createEmptyHomeTeamPage() {
		drawCommonEmptyPage();
		drawEmptyHeaderHomeTeamPart();
	}

	/**
	 * Draw an empty visitor sheet.
	 *
	 * @param g2 Reference on the graphic context
	 */
	protected void createEmptyVisitorPage() {
		drawCommonEmptyPage();
		drawEmptyHeaderVisitorPart();
	}

	/**
	 * Put a string in the center a an area.
	 *
	 * @param text Text to write
	 * @param font font to use
	 * @param color color to use
	 * @param x X coordinate of the area 
	 * @param y Y coordinate of the area 
	 * @param width Width of the area
	 * @param height height of the area
	 */
	private void putString(String text, Font font, Color color, double x, double y, double width, double height) {
		putString(font, color, text, x, y, width, height);
	}

	/**
	 *  Put a string in an area.
     *
	 * @param text Text to write
	 * @param font font to use
	 * @param color color to use
	 * @param x X coordinate of the area 
	 * @param y Y coordinate of the area 
	 * @param width Width of the area
	 * @param height height of the area
	 */
	private void putString(Font font, Color color, String text, double x, double y, double width, double height) {
		g2.setFont(font);
		g2.setColor(color);

		String[] parts = text.split("\n"); //$NON-NLS-1$
		if (parts.length == 1) {

			Rectangle2D bounds = g2.getFontMetrics().getStringBounds(text, g2);
			g2.drawString(text, (float) (x + (width - bounds.getWidth()) / 2),
					(float) (y + height - ((height - bounds.getHeight()) / 2) - g2.getFontMetrics().getMaxDescent()));

		} else {

			Rectangle2D bounds0 = g2.getFontMetrics().getStringBounds(parts[0], g2);
			Rectangle2D bounds1 = g2.getFontMetrics().getStringBounds(parts[1], g2);

			g2.drawString(parts[0], (float) (x + (width - bounds0.getWidth()) / 2),
					(float) (y + height - bounds0.getHeight() / 2 - ((height - bounds0.getHeight()) / 2)
							- g2.getFontMetrics().getMaxDescent()) + 3);

			g2.drawString(parts[1], (float) (x + (width - bounds1.getWidth()) / 2),
					(float) (y + height + bounds1.getHeight() / 2 - ((height - bounds1.getHeight()) / 2)
							- g2.getFontMetrics().getMaxDescent()) + 1);
		}
	}

	/**
	 * Put a string with an offset.
	 *	
	 * @param font font to use
	 * @param text Text to write
	 * @param x X coordinate of the area 
	 * @param y Y coordinate of the area 
	 * @param height height of the string
	 */
	private void putStringWithXOffset(Font font, String text, double x, double y, double height) {
		g2.setFont(font);
		Rectangle2D bounds = g2.getFontMetrics().getStringBounds(text, g2);
		g2.drawString(text, (float) x,
				(float) (y + height - ((height - bounds.getHeight()) / 2) - g2.getFontMetrics().getMaxDescent()));
	}

	/**
	 * Get batter number for an action.
	 * 
	 * @return batter number
	 */
	private int getBatterNumberForThisAction() {
		return currentLineup.getCurrentBatterNumber();
	}

	/**
	 * Close the document
	 */
	public void closeDocument() {
		// Nothing to do
	}

	/**
	 * Create an empty visitor sheet
	 * 
	 * @param g2 reference on the graphical context
	 */
	public void fillSpecialVisitorSheet(Graphics2D g2) {
		this.g2 = g2;
		createEmptyVisitorPage();
	}

	/**
	 * Create a new page.
	 */
	public void createNewPage() {
		// Nothing to do
	}

	/**
	 * Create an empty home team sheet
	 * 
	 * @param g2 reference on the graphical context
	 */
	public void fillSpecialHometeamSheet(Graphics2D g2) {
		this.g2 = g2;
		createEmptyHomeTeamPage();
	}
	
	/**
	 * Register all graphical command for drawing offensive substitution.
	 * 
	 * @param team name of the team (visitor or hometeam)
	 * @param playerSquarePosition Square coordinate
	 */
	private void registerDrawLineForOffensiveSubstitution(String team, Point playerSquarePosition) {
		HashMap<String, HashMap<String, List<Integer>>> offensivesPositions = offensiveSubstitutionGraphicalOffset.get(team);
		if (offensivesPositions == null) {
			offensivesPositions = new HashMap<>();
			offensiveSubstitutionGraphicalOffset.put(team, offensivesPositions);
		}
		
		HashMap<String, List<Integer>> squaresPositions = offensivesPositions.get(EMPTY_STRING + playerSquarePosition.y);
		if (squaresPositions == null) {
			squaresPositions = new HashMap<>();
			offensivesPositions.put(EMPTY_STRING + playerSquarePosition.y, squaresPositions);
		}
	
		List<Integer> offsetPositions = squaresPositions.get(EMPTY_STRING + playerSquarePosition.x); 
		if (offsetPositions == null) {
			offsetPositions = new ArrayList<>();
			offsetPositions.add(0);
			squaresPositions.put(EMPTY_STRING + playerSquarePosition.x, offsetPositions);
		} else {
			int offsetPosition = offsetPositions.get(offsetPositions.size()-1).intValue(); 
			offsetPositions.add(offsetPosition + 3);
		}
	}
}
