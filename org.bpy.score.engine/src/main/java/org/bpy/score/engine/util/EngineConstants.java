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
package org.bpy.score.engine.util;

import java.awt.Color;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.osgi.service.prefs.Preferences;

/**
 * Constants used the application.
 * 
 * @author Patrick BRIAND
 *
 */

public class EngineConstants {

	/**	Home team string */
	public static final String HOMETEAM = "hometeam"; //$NON-NLS-1$
	/**	visitor string */
	public static final String VISITOR = "visitor"; //$NON-NLS-1$

	/** Graphics constants preference: Color of a line String */
	public static final String GRAPHIC_COLOR_LINE = "graphic.color.line"; //$NON-NLS-1$
	/** Graphics constants preference: Color of the text String */
	public static final String GRAPHIC_COLOR_TEXT = "graphic.color.text"; //$NON-NLS-1$
	/** Graphics constants preference: Color for the statistics */
	public static final String GRAPHIC_DISPLAY_STATISTICS = "graphic.display.statistics"; //$NON-NLS-1$
	/** Graphics constants preference: Display the winner, looser and saved */
	public static final String GRAPHIC_DISPLAY_WIN_LOSE_PITCHER = "graphic.display.win.lose.pitcher"; //$NON-NLS-1$
	/** Graphics constants preference: new style sheet */
	public static final String GRAPHIC_NEW_STYLE_SHEET = "graphic.new.style.sheet"; //$NON-NLS-1$

	/** Graphics constants preference: Don't display the statistics */
	public static final String NO_STATS = "graphic.stats.noStats"; //$NON-NLS-1$
	/** Graphics constants preference: Display the statistics like SF1 level */
	public static final String SF1_STATS = "graphic.stats.sf1Stats"; //$NON-NLS-1$
	/** Graphics constants preference: Display all the statistics */
	public static final String FULL_STATS = "graphic.stats.fullStats"; //$NON-NLS-1$

	/** Flag for trace the engine */
	@SuppressWarnings("java:S1444")
	public static boolean debugEngine = false;
	/** Flag for trace the statistics computation */
	@SuppressWarnings("java:S1444")
	public static boolean debugStatistics = false;

	/** Create a PDF mire */
	@SuppressWarnings("java:S1444")
	public static boolean pdfMire = false;

	/* Graphicals options */
	
	/** new style sheet flag */
	@SuppressWarnings("java:S1444")
	public static boolean graphicsShowNewStyleSheet;
	/** isplay the winner, looser and saved flag */
	@SuppressWarnings("java:S1444")
	public static boolean graphicsShowWinLoseSave;
	/** Show statistics state string  */
	@SuppressWarnings("java:S1444")
	public static String graphicsShowStatistiques;

	/** Color of the sheet */
	@SuppressWarnings("java:S1444")
	public static Color graphicsColorSheet;
	/** Color of the pencil */
	@SuppressWarnings("java:S1444")
	public static Color graphicsColorPencil;

	/** Key for the score sheet preference page */
	public static final String SCORESHEET_PREFERENCE_PAGE = "scoresheet_preference_page"; //$NON-NLS-1$
	/** Graphics constants preference: Show statistics */
	public static final String GRAPHICAL_SHOW_STATISTIC = "graphical_show_statistic"; //$NON-NLS-1$
	/** Graphics constants preference: new style sheet */
	public static final String NEW_STYLE_SHEET = "new_style_sheet"; //$NON-NLS-1$

	/* control options */
	/** Check the fly out location (For the validation) */
	@SuppressWarnings("java:S1444")
	public static String checkFlyOutLocation;
	/** Check missing earned point (For the validation) */
	@SuppressWarnings("java:S1444")
	public static String checkMissingEarnedPoint;

	static {
		Preferences preferences = ConfigurationScope.INSTANCE.getNode("org.bpy.score.rcp.preferences"); //$NON-NLS-1$
		Preferences pref = preferences.node(EngineConstants.SCORESHEET_PREFERENCE_PAGE);

		graphicsShowStatistiques = FULL_STATS;
		if (pref != null) {
			graphicsShowStatistiques = pref.get(GRAPHICAL_SHOW_STATISTIC, GRAPHIC_DISPLAY_STATISTICS);
		}
	}

	/**
	 * For avoid to invoke a static class
	 */
	private EngineConstants() {
		throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}

}
