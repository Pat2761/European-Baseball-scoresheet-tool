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
package org.bpy.score.preferences.core;

import org.bpy.score.preferences.Activator;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

/**
 * 
 * Allow to initialize all parameters of the application.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("restriction")
public class ScorePreferenceInitializer extends AbstractPreferenceInitializer {


	/* -------------------------------------------------------------------------------- */
	/* Keys and default values for the editor                                           */
	/* -------------------------------------------------------------------------------- */
	
	
	/* -------------------------------------------------------------------------------- */
	/* Keys and default values for hieroglyphic view                                    */
	/* -------------------------------------------------------------------------------- */


	/**
	 * Constructor of the class.
	 * 
	 */
	public ScorePreferenceInitializer() {
		// nothing to do
	}

	@Override
	public void initializeDefaultPreferences() {
		InstancePreferences node = (InstancePreferences) InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

		try {
//			node.putBoolean(TRANSCRIPTION_SPECIFIC_SETTINGS, false);
//			node.putBoolean(HIEROGLYPHIC_VIEW_SPECIFIC_SETTINGS, false);
//			
//			node.put(PAGE_INFO, PAGE_INFO_DEFAULT_VALUE);
//			node.put(PAGE_DIRECTION, PAGE_DIRECTION_DEFAULT_VALUE.name());
//			node.put(PAGE_ORIENTATION, PAGE_ORIENTATION_DEFAULT_VALUE.name());
//			node.put(STANDARD_SIGN_HEIGHT, "" + STANDARD_SIGN_HEIGHT_DEFAULT_VALUE);
			
			node.flush();
		} catch (BackingStoreException e) {
			// nothing to do
		}
	}
}
