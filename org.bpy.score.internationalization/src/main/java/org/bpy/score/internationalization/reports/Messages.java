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
package org.bpy.score.internationalization.reports;


import org.eclipse.osgi.util.NLS;

/**
 * Make the internationalization for the graphics plugin.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("all")
public class Messages extends NLS {
	
	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.reports.messages"; //$NON-NLS-1$

	/** keyword pitcher position */
	public static String PlayByPlayManager_Pitcher;
	/** keyword catcher position */
	public static String PlayByPlayManager_Catcher;
	/** keyword First Base position */
	public static String PlayByPlayManager_FirstBase;
	/** keyword Second Base position */
	public static String PlayByPlayManager_SecondBase;
	/** keyword Third Base position */
	public static String PlayByPlayManager_ThirdBase;
	/** keyword Short stop position */
	public static String PlayByPlayManager_ShortStop;
	/** keyword left field */
	public static String PlayByPlayManager_LeftField;
	/** keyword center field */
	public static String PlayByPlayManager_CenterField;
	/** keyword Right field */
	public static String PlayByPlayManager_RightField;
	/** keyword Designated hitter */
	public static String PlayByPlayManager_DesignatedHitter;
	/** keyword Pitch hitter */
	public static String PlayByPlayManager_PitchHitter;
	/** keyword Pitch runner */
	public static String PlayByPlayManager_PitchRunner;
	
	/** keyword Forfeit game */
	public static String ScoreSheetEngine_ForfeitGame;

	
	/** GameReportGenerator class */
	/** Game Report Generator : Job report generation */
	public static String GameReportGenerator_JobReportGeneration;
	/** Game Report Generator : Reports generation */
	public static String GameReportGenerator_ReportsGeneration;
	/** Game Report Generator : Report generation */
	public static String GameReportGenerator_ReportGeneration;
	/** Game Report Generator : Error Report generation */
	public static String GameReportGenerator_ErrorReportGeneration;
	
	/**
	 * Initialize the internationalization
	 */
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	/**
	 * Constructor of the class
	 */
	private Messages() {
	}
}
