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
package org.bpy.score.internationalization.engine;


import org.eclipse.osgi.util.NLS;

/**
 * Make the internationalization for the engine plugin.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("all")
public class Messages extends NLS {
	
	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.engine.messages"; //$NON-NLS-1$

	/** String for bad class in case of more advance fail */
	public static String AbstractActionManager_BadClassMoreAdvanceFail;
	/** String for bad class in case of advance with continuation */
	public static String AbstractActionManager_AdvanceWithContinuation;
	/** String for bad class in case of runner action */
	public static String AbstractActionManager_RunnerAction;
	/** String for bad class in case of batter action */
	public static String AbstractActionManager_BatterAction;
	/** String for bad class in case of a specific command */
	public static String AbstractActionManager_Commands;
	
	/** Base class detected */
	public static String AbstractEngine_UnexpectedClassDetected;
	
	/** Base not free */
	public static String RunnerPositionManager_BaseIsNotFree;
	/** No player found */
	public static String RunnerPositionManager_NoPlayerFoundOnBase;

	
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
