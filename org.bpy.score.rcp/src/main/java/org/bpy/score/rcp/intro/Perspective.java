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
package org.bpy.score.rcp.intro;


import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Define the perspective.
 * 
 * @author Patrick BRIAND
 *
 */
public class Perspective implements IPerspectiveFactory {

  /**
   * The Package Explorer view from JDT. We create a placeholder for this
   * view, so that if a user has this view open in another perspective,
   * they'll see it here, too, otherwise they won't see it.
   */
  public void createInitialLayout(IPageLayout layout) {
	  // Nothing to do for the moment
  }
  
}
