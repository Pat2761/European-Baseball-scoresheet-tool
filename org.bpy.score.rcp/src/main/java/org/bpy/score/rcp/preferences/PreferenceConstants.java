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
package org.bpy.score.rcp.preferences;

import java.util.HashMap;

import org.bpy.score.internationalization.rcp.Messages;

/**
 * Constant preference container
 * 
 * @author Patrick BRIAND
 *
 */
public class PreferenceConstants {

	/** ID for preference maanager */
	public static final String PREFERENCE_ID = "org.bpy.score.rcp.preferences"; //$NON-NLS-1$

	/** Error level preference definition */ 
	protected static final HashMap<String, String> errorsDefinition = new HashMap<>();
	/** Reverse Error level preference definition */ 
	protected static final HashMap<String, String> reverseErrorsDefinition = new HashMap<>();

	/** Error levels */
	protected static final String[][] errorLevel = new String[3][2];

	/** Level error ignore */
	public static final String IGNORE_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorIgnore;
	/** Level error warning */
	public static final String WARNING_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorWarning;
	/** Level error error */
	public static final String ERROR_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorError;

	/** Level error ignore key store*/
	public static final String IGNORE = "ignore";//$NON-NLS-1$
	/** Level error warning key store */
	public static final String WARNING = "warning";//$NON-NLS-1$
	/** Level error error key store */
	public static final String ERROR = "error";//$NON-NLS-1$

	/** Fly out check location key store */
	public static final String CHECK_FLY_OUT_LOCATION = "check.fly.out.location";//$NON-NLS-1$
	/** Earned point check location key store */
	public static final String CHECK_MISSING_EARNED_POINT = "check.missing.earned.point";//$NON-NLS-1$

	static {

		errorsDefinition.put(IGNORE, IGNORE_STR_TO_DISPLAY);
		errorsDefinition.put(WARNING, WARNING_STR_TO_DISPLAY);
		errorsDefinition.put(ERROR, ERROR_STR_TO_DISPLAY);

		reverseErrorsDefinition.put(IGNORE_STR_TO_DISPLAY, IGNORE);
		reverseErrorsDefinition.put(WARNING_STR_TO_DISPLAY, WARNING);
		reverseErrorsDefinition.put(ERROR_STR_TO_DISPLAY, ERROR);

		errorLevel[0][0] = IGNORE_STR_TO_DISPLAY;
		errorLevel[0][1] = IGNORE;
		errorLevel[1][0] = WARNING_STR_TO_DISPLAY;
		errorLevel[1][1] = WARNING;
		errorLevel[2][0] = ERROR_STR_TO_DISPLAY;
		errorLevel[2][1] = ERROR;

	}

	/**
	 * Private constructor for static class
	 */
	private PreferenceConstants() {
		throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}
}
