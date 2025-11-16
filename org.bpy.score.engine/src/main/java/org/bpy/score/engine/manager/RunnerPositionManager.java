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
package org.bpy.score.engine.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.EventListenerList;

import org.bpy.score.engine.events.PointEvent;
import org.bpy.score.engine.events.PointListener;
import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.internationalization.engine.Messages;
import org.eclipse.osgi.util.NLS;

/**
 * THis class compute the occupation of the base by the runners
 * 
 * @author Patrick BRIAND
 *
 */
public class RunnerPositionManager {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(RunnerPositionManager.class.getSimpleName());

	/** PLayer description string */
	public static final String PLAYER_DESCRIPTION = "playerDescription"; //$NON-NLS-1$
	/** Const which represents an empty base */
	private static final int EMPTY = -1;

	/** Array which contains the state of each bases */
	private LineupEntry[] runnerPositions;
	/** Current line-up associated to the base occupation */
	private LineupManager lineUpManager;
	/** Memorize the last position which have change */
	private int lastPlayerPositionSetted = -1;

	/** Event listener for points */
	private final EventListenerList pointListeners = new EventListenerList();

	/**
	 * Constructor of the class.
	 * Initialize some internal fields
	 */
	public RunnerPositionManager() {
		runnerPositions = new LineupEntry[5];
		clearField();
	}

	/**
	 * allow to be prevent of a new Point.
	 *
	 * @param listener which want to be prevent
	 */
	public void addPointListener(PointListener listener) {
		pointListeners.add(PointListener.class, listener);
	}

	/**
	 * Do not want to be prevent of a new point.
	 *
	 * @param listener listener which don't want to be prevent
	 */
	public void removePointListener(PointListener listener) {
		pointListeners.remove(PointListener.class, listener);
	}

	/**
	 * Return all classes which listen for points.
	 * 
	 * @return List of classes which listen for points
	 */
	public PointListener[] getPointListeners() {
		return pointListeners.getListeners(PointListener.class);
	}

	/**
	 * Signal that a point is mark

	 * @param event  Point event which describe the point 
	 */
	protected void firePlayerMarkPoint(PointEvent event) {
		for (PointListener pointListener : getPointListeners()) {
			pointListener.newPoint(event);
		}
	}

	/**
	 * Return the reference on a player description who occupy a base
	 * 
	 * @param position Base number
	 * @return the reference on a player description who occupy a base, <b>null</b> if base is free
	 */
	public LineupEntry getPlayerAtPosition(int position) {
		return runnerPositions[position];
	}

	/**
	 * Return the last position settled
	 * 
	 * @return last position settled
	 */
	public int getLastPlayerPositionSetted() {
		return lastPlayerPositionSetted;
	}

	/**
	 * Define the line-up manager for the simulator.
	 * 
	 * @param lineUpManager line-up manager for the simulator
	 */
	public void setLineUpManager(LineupManager lineUpManager) {
		this.lineUpManager = lineUpManager;
	}

	/**
	 * Empty all base
	 */
	public void clearField() {
		runnerPositions[0] = null;
		runnerPositions[1] = null;
		runnerPositions[2] = null;
		runnerPositions[3] = null;
		runnerPositions[4] = null;
	}

	/**
	 * Out a runner from a base.
	 * @param pos base number
	 */
	public void runnerOut(int pos) {
		runnerPositions[pos] = null;
	}

	/**
	 * Advance a runner from a base to an another base.
	 * 
	 * @param fromPos Starting position
	 * @param toPos new position
	 * @param action reference on the action
	 * @param isEarnedValue State of point
	 * @throws OccupedbaseException
	 */
	public void runnerAdvance(int fromPos, int toPos, Object action, String isEarnedValue) throws OccupedbaseException {
		if ((toPos <= 4) && (toPos > 0)) {
			if (toPos != 4) {
				if (runnerPositions[toPos] != null) {
					String message = NLS.bind(Messages.RunnerPositionManager_BaseIsNotFree,toPos);
					throw new OccupedbaseException(message);

				} else {
					runnerPositions[toPos] = runnerPositions[fromPos];
					runnerPositions[fromPos] = null;
					lastPlayerPositionSetted = toPos;
				}
			} else {
				/* It is a point so, no runner on this position */
				firePlayerMarkPoint(new PointEvent(runnerPositions[fromPos], action, isEarnedValue));

				lastPlayerPositionSetted = EMPTY;
				runnerPositions[fromPos] = null;
			}
		}
	}

	/**
	 * Define a new batter on the base 0 (marble)
	 * 
	 */
	public void setNewBatter() {
		linkObjectToPlayer(0, PLAYER_DESCRIPTION, lineUpManager.getCurrentBatter());
		runnerPositions[0] = lineUpManager.getCurrentBatter();
	}

	/**
	 * Define a new batter on the base 0 (marble)
	 * 
	 * @param key key for a data for the position
	 * @param object object to link to the position
	 */
	public void setNewBatter(String key, Object object) {
		linkObjectToPlayer(0, PLAYER_DESCRIPTION, lineUpManager.getCurrentBatter());
		runnerPositions[0] = lineUpManager.getCurrentBatter();
		runnerPositions[0].getAssociatedObjects().put(key, object);
	}

	/**
	 * Place a runner on a base.
	 * 
	 * @param player Player entry in the line-up
	 * @param position Base number
	 * @throws OccupedbaseException
	 */
	public void setRunnerAtPosition(LineupEntry player, int position) throws OccupedbaseException {
		if (position >= 0) {
			if (runnerPositions[position] == null) {
				runnerPositions[position] = player;
			} else {
				String message = NLS.bind(Messages.RunnerPositionManager_BaseIsNotFree,position);
				throw new OccupedbaseException(message);
			}
		}
	}

	/**
	 * Get object associated to a base.
	 * 
	 * @param position Base number
	 * @param key Key of the object

	 * @return Object associated the base,<b>null</b> if no object found
	 */
	public Object getPlayerAssociatedObject(int position, String key) {
		if (position >= 0) {
			if (runnerPositions[position] != null) {
				return runnerPositions[position].getAssociatedObjects().get(key);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Compute the number of players on the bases.
	 * 
	 * @return number of players on the bases.
	 */
	public int getLeftOnBase() {
		int count = 0;
		for (int i = 1; i <= 3; i++) {
			if (runnerPositions[i] != null) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Put out oa player from a base
	 * 
	 * @param runnerPosition base number
	 */
	public void setPlayerOut(int runnerPosition) {
		try {
			if (runnerPositions[runnerPosition] != null) {
				runnerPositions[runnerPosition] = null;
			} else {
				String messages = NLS.bind(Messages.RunnerPositionManager_NoPlayerFoundOnBase, runnerPosition);
				logger.log(Level.WARNING,messages);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Link an object to a base
	 * 
	 * @param position Base number
	 * @param key Key of the object
	 * @param object Object to link
	 */
	public void linkObjectToPlayer(int position, String key, Object object) {
		if (runnerPositions[position] != null) {
			runnerPositions[position].getAssociatedObjects().put(key, object);
		}
	}

	/**
	 * Try to find the position of a runner on the bases.
	 * 
	 * @param player Line-up entry of the player
	 * @return position on bases, <b>-1</b> if not found
	 */
	public int getPosition(LineupEntry player) {
		for (int i = 0; i < 5; i++) {
			if ((runnerPositions[i] != null) && runnerPositions[i].getPlayerDescription().getName()
					.equals(player.getPlayerDescription().getName())) {
				return i;
			}
		}
		return EMPTY;
	}

	@Override
	public String toString() {
		String runner3 = runnerPositions[3] == null ? "" : runnerPositions[3].getPlayerDescription().getName(); //$NON-NLS-1$
		String runner2 = runnerPositions[2] == null ? "" : runnerPositions[2].getPlayerDescription().getName(); //$NON-NLS-1$
		String runner1 = runnerPositions[1] == null ? "" : runnerPositions[1].getPlayerDescription().getName(); //$NON-NLS-1$
		String battter = runnerPositions[0] == null ? "" : runnerPositions[0].getPlayerDescription().getName(); //$NON-NLS-1$

		StringBuilder str = new StringBuilder("         # " + String.format("%10s", runner2) + "\n"); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		str.append("       /  \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("      /    \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("     /      \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("    /        \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("   /          \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("  /            \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append(" /              \\" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("# " + String.format("%10s", runner3) + "     #" + String.format("%10s", runner1) + "\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		str.append(" \\              /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("  \\            /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("   \\          /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("    \\        /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("     \\      /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("      \\    /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("       \\  /" + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		str.append("         # " + String.format("%10s", battter) + "\n");  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return str.toString();
	}
}
