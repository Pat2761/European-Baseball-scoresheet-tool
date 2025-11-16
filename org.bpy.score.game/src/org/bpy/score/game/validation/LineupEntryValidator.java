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
package org.bpy.score.game.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.game.game.GamePackage;
import org.bpy.score.game.game.LineUp;
import org.bpy.score.game.game.LineUpEntry;
import org.bpy.score.internationalization.game.Messages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.validation.Check;

/**
 * Line up validation 
 * 
 * @author Patrick BRIAND
 *
 */
public class LineupEntryValidator  extends AbstractGameValidator {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(LineupEntryValidator.class.getSimpleName());

	/** Invalid defensive position constant, use for quick fix */
	public static final String INVALID_DEFENSIVE_POSITION = "invalidDefensivePosition"; //$NON-NLS-1$

	/**
	 * Check the defensive positions set in the line up of a game.
	 *  
	 * @param lineupEntry Reference on the lineupEntry object
	 */
	@Check 
	public void checkLineupEntryConsistency(LineUpEntry lineupEntry) {
		Map<Integer, Boolean> validationTable = new HashMap<>();
		LineUp lineup = (LineUp) lineupEntry.eContainer();

		for (LineUpEntry entry : lineup.getLineUpEntries()) {

			try {
				int defensivePosition = Integer.parseInt(entry.getDefensivePosition());
				if (defensivePosition < 1 || defensivePosition > 9) {
					error(NLS.bind(Messages.LineupEntryValidator_invalidDefensivePosition, defensivePosition),  
						GamePackage.eINSTANCE.getLineUpEntry_DefensivePosition(), INVALID_DEFENSIVE_POSITION);
				} else {

					if (validationTable.containsKey(defensivePosition)) {

						error(NLS.bind(Messages.LineupEntryValidator_defensivePositionAlreadyDefined,entry.getDefensivePosition()),
							GamePackage.eINSTANCE.getLineUpEntry_DefensivePosition(), INVALID_DEFENSIVE_POSITION);
					} else {
						validationTable.put(defensivePosition, true);

					}
				}
			} catch (NullPointerException ex) {
				logger.log(Level.SEVERE, ex.getMessage());
			}
		}
	}
}
