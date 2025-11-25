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
package org.bpy.score.internationalization.graphics;


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
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.graphics.messages"; //$NON-NLS-1$

	/** Tournament translation */
	public static String ScoringSheetGraphicalManager_Tournament;
	/** Town translation */
	public static String ScoringSheetGraphicalManager_Town;
	/** Umpires translation */
	public static String ScoringSheetGraphicalManager_Umpires;
	/** Score keepers translation */
	public static String ScoringSheetGraphicalManager_ScoreKeeper;
	/** Category translation */
	public static String ScoringSheetGraphicalManager_Category;
	/** Date translation */
	public static String ScoringSheetGraphicalManager_Date;
	/** Stadium translation */
	public static String ScoringSheetGraphicalManager_Stadium;
	/** Start time translation */
	public static String ScoringSheetGraphicalManager_Start;
	/** End time translation */
	public static String ScoringSheetGraphicalManager_End;
	/** Tournament translation */
	public static String ScoringSheetGraphicalManager_Duration;
	/** Visitor translation */
	public static String ScoringSheetGraphicalManager_Visitor;
	/** Home team translation */
	public static String ScoringSheetGraphicalManager_Hometeam;
	/** Baseball translation */
	public static String ScoringSheetGraphicalManager_Baseball;
	/** Softball translation */
	public static String ScoringSheetGraphicalManager_Softball;
	/** Notes translation */
	public static String ScoringSheetGraphicalManager_Notes;
	/** Control area translation */
	public static String ScoringSheetGraphicalManager_ControlArea;
	/** Defense area translation */
	public static String ScoringSheetGraphicalManager_DefenseArea;
	/** Offense area translation */
	public static String ScoringSheetGraphicalManager_OffensiveArea;
	/** Players translation */
	public static String ScoringSheetGraphicalManager_Players;
	/** Pitcher translation */
	public static String ScoringSheetGraphicalManager_Pitchers;
	/** Double plays translation */
	public static String ScoringSheetGraphicalManager_DoublePlays;
	/** Catchers translation */
	public static String ScoringSheetGraphicalManager_Catchers;
	/** Totals translation */
	public static String ScoringSheetGraphicalManager_Totals;
	/** Game number translation */
	public static String ScoringSheetGraphicalManager_GameNumber;
	/** Teams translation */
	public static String ScoringSheetGraphicalManager_Teams;
	/** Total translation */
	public static String ScoringSheetGraphicalManager_Total;
	

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
