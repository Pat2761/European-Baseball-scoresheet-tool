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
package org.bpy.score.graphics;

import java.awt.Point;

/**
 * Use to contains the position of the outputs in case of multiple plays.
 * 
 * @author Patrick
 *
 */
public class MultiplePlayContainer implements Comparable<MultiplePlayContainer> {

	/**
	 * Type of put out.
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public enum PUTOUT_CASE {
		/** Batter put out */
		BATTER_PUTOUT, 
		/** Runner 1 put out */
		RUNNER1_PUTOUT, 
		/** Runner 2 put out */
		RUNNER2_PUTOUT, 
		/** Runner 3 put out */
		RUNNER3_PUTOUT
	}

	/** 
	 * Direction of the put out.
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public enum DIRECTION {
		/** Left top direction */
		LEFT_TOP, 
		/** Right top direction */
		RIGHT_TOP, 
		/** Left bottom direction */
		LEFT_BOTTOM, 
		/** Rigth bottom direction */
		RIGHT_BOTTOM
	}

	/** Square position to draw */
	private Point position;
	/** Put out case */
	private PUTOUT_CASE putoutCase;

	@Override
	public int compareTo(MultiplePlayContainer container) {
		if (this.position.x == container.position.x) {
			return 0;
		} else if (this.position.x < container.position.x) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Get square position to draw.
	 *  
	 * @return square position to draw
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Set square position to draw.
	 * 
	 * @param position quare position to draw
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Get cause of the put out.
	 * 
	 * @return cause of the put out.
	 */
	public PUTOUT_CASE getPutoutCase() {
		return putoutCase;
	}

	/**
	 * Set cause of the put out.
	 * 
	 * @param putoutCase cause of the put out.
	 */
	public void setPutoutCase(PUTOUT_CASE putoutCase) {
		this.putoutCase = putoutCase;
	}

	/**
	 * Compute the output point of the circle in function of the direction.
	 * 	 
	 * @param direction direction of the put out
	 * 
	 * @return the output point of the circle in function of the direction.
	 */
	public Point getOutputPoint(DIRECTION direction) {

		Point outputPoint = null;

		switch (putoutCase) {
		case BATTER_PUTOUT:

			switch (direction) {
			case LEFT_TOP:
				outputPoint = new Point(5, 5);
				break;
			case LEFT_BOTTOM:
				outputPoint = new Point(5, 29);
				break;
			case RIGHT_TOP:
				outputPoint = new Point(29, 5);
				break;
			case RIGHT_BOTTOM:
				outputPoint = new Point(29, 29);
				break;
			}
			break;

		case RUNNER1_PUTOUT:

			switch (direction) {
			case LEFT_TOP:
				outputPoint = new Point(3, 5);
				break;
			case LEFT_BOTTOM:
				outputPoint = new Point(3, 18);
				break;
			case RIGHT_TOP:
				outputPoint = new Point(18, 5);
				break;
			case RIGHT_BOTTOM:
				outputPoint = new Point(18, 18);
				break;
			}
			break;

		case RUNNER2_PUTOUT:

			switch (direction) {
			case LEFT_TOP:
				outputPoint = new Point(3, 3);
				break;
			case LEFT_BOTTOM:
				outputPoint = new Point(3, 15);
				break;
			case RIGHT_TOP:
				outputPoint = new Point(15, 3);
				break;
			case RIGHT_BOTTOM:
				outputPoint = new Point(15, 15);
				break;
			}
			break;

		case RUNNER3_PUTOUT:

			switch (direction) {
			case LEFT_TOP:
				outputPoint = new Point(3, 20);
				break;
			case LEFT_BOTTOM:
				outputPoint = new Point(3, 33);
				break;
			case RIGHT_TOP:
				outputPoint = new Point(13, 21);
				break;
			case RIGHT_BOTTOM:
				outputPoint = new Point(15, 30);
				break;
			}
			break;

		}

		return outputPoint;
	}
}
