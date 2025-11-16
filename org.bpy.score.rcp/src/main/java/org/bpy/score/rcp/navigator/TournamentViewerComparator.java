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
package org.bpy.score.rcp.navigator;

import java.util.Comparator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

/**
 * Comparator for the tournament project
 * 
 * @author Patrick BRIAND
 *
 */
public class TournamentViewerComparator extends ViewerComparator {

	/**
	 * Constructor of the class
	 */
	public TournamentViewerComparator() {
		// Nothing to do
	}

	/**
	 * Constructor of the class
	 * 
	 * @param comparator reference on a comparator
	 */
	public TournamentViewerComparator(Comparator<? super String> comparator) {
		super(comparator);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int result = -1;

		if (IFolder.class.isInstance(e1)) {

			if (IFolder.class.isInstance(e2)) {
				String nameE1 = ((IFolder) e1).getName();
				String nameE2 = ((IFolder) e2).getName();

				result = nameE1.compareTo(nameE2);
			} else {
				result = 1;
			}

		} else if (IFile.class.isInstance(e1)) {

			if (IFile.class.isInstance(e2)) {
				String nameE1 = ((IFile) e1).getName();
				String nameE2 = ((IFile) e2).getName();

				result = nameE1.compareTo(nameE2);
			} else {
				result = 1;
			}

		}
		return result;
	}

}
