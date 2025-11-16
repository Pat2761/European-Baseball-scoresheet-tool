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
package org.bpy.score.engine.stats.stats;

import java.util.Comparator;
import java.util.Map;

/**
 * This is a comparator for sort a map in function of the key. 
 * 
 * @author Patrick BRIAND
 *
 */
public class MapValueComparator implements Comparator<String> {
	
  /** Map which serve to compare */
  private Map<String, Double> base;

  /**
   * Constructor of the class.
   * Initialize fields
   * 
   * @param base Map which serve to compare
   */
  public MapValueComparator(Map<String, Double> base) {
    this.base = base;
  }

  // Note: this comparator imposes orderings that are inconsistent with
  // equals.
  public int compare(String a, String b) {
    if (base.get(a) >= base.get(b)) {
      return -1;
    } else {
      return 1;
    } // returning 0 would merge keys
  }
}