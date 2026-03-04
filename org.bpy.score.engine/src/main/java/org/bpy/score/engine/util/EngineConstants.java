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

	/** Flag for trace the engine */
	public static final boolean DEBUG_ENGINE = false;
	/** Flag for trace the statistics computation */
	public static final boolean DEBUG_STATISTIQUE = false;

	/** Create a PDF mire */
	public static final boolean PDF_MIRE = false;

	/**
	 * For avoid to invoke a static class
	 */
	private EngineConstants() {
		throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}
}
