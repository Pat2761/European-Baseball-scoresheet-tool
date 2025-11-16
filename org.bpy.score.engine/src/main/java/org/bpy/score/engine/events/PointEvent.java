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
package org.bpy.score.engine.events;

import org.bpy.score.engine.stats.emf.statistic.LineupEntry;

/**
 * This object is used when event is sent when a point is set by a team in an action.
 * This class allows to describe the point.
 * 
 * @author Patrick BRIAND 
 *
 */
public class PointEvent {
	
  /** Player description who is at the origin of this the point */	
  private LineupEntry player;
  /** Reference on the action */
  private Object action;
  /** Define type of earned point */
  private String isEarnedValue;

  /**
   * Constructor of the class. 
   * Initialize all fields
   * 
   * @param player Player description who is at the origin of this the point
   * @param action Reference on the action
   * @param isEarnedValue  Define type of earned point
   */
  public PointEvent(LineupEntry player, Object action, String isEarnedValue) {
    this.player = player;
    this.action = action;
    this.isEarnedValue = isEarnedValue;
  }

  /**
   * get Reference on the action 
   * 
   * @return action reference
   */
  public Object getAction() {
    return action;
  }

  /**
   * Get who have make the point
   * 
   * @return Player description who is at the origin of this the point
   */
  public LineupEntry getPlayer() {
    return player;
  }

  /**
   * Get type of earned point
   * 
   * @return type of earned point
   */
  public String getIsEarnedValue() {
    return isEarnedValue;
  }

}
