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
package org.bpy.score.rcp.testers;

import org.bpy.score.rcp.ScoreProjectNature;
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.TreeSelection;

/**
 * Property tester the RCP plugins.
 * 
 * @author Patrick BRIAND
 *
 */
public class RcpMenuTester extends PropertyTester {

	/**
	 * Constructor of the class.
	 */
	public RcpMenuTester() {
		// Nothing to do
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		switch (property) {
		case "natureId":  //$NON-NLS-1$
			return checkNatureID(receiver, (String)args[0], (boolean)expectedValue);

		case "seasonFolder": //$NON-NLS-1$
			return checkFolderAsSeasonFolder(receiver, (boolean)expectedValue);
			
		default:
			break;
		}
		return false;
	}

	/**
	 * Check that folder is a season folder
	 * 
	 * @param receiver element to check
	 * @param expectedValue expected value
	 * @return <b>true</b> it is a season folder, <b>false</b> otherwise
	 */
	private boolean checkFolderAsSeasonFolder(Object receiver, boolean expectedValue) {
		if (receiver instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) receiver;
		
			if (treeSelection.getFirstElement() instanceof IFolder) {
				IFolder currentFolder = (IFolder) treeSelection.getFirstElement();

				boolean seasonState = (currentFolder.getParent() instanceof IProject)
						&& RcpUtils.isProjectHasNature((IProject)currentFolder.getParent(), ScoreProjectNature.NATURE_ID)
						&& RcpUtils.isSeasonFolder(currentFolder);
				return seasonState == expectedValue;
			}
		}
		return false;
	}

	/**
	 * Check the natureID of a project
	 * 
	 * @param receiver reference on the selected element
	 * @param natureId The nature ID
	 * @param expectedValue expected state of the Nature ID of the project
	 * 
	 * @return <b>true</b> value is equals to the waiting value, <b>false</b> otherwise
	 */
	private boolean checkNatureID(Object receiver, String natureId, boolean expectedValue) {
		
		if (receiver instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) receiver;
		
			if (treeSelection.getFirstElement() instanceof IProject) {
				IProject currentProject = (IProject) treeSelection.getFirstElement();

				boolean state = RcpUtils.isProjectHasNature(currentProject, natureId);
				return expectedValue==state;
				
			}
		}
		return false;
	}

}
