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

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;

/**
 * Interface for the specific object in project explorrer
 * 
 * @author Patrick BRIAND
 *
 */
public interface IScoreToolProjectElement {

	/**
	 * Get image for the folder
	 * 
	 * @return reference on the image decorator
	 */
	public Image getImage();

	/**
	 * Get children of the folder 
	 * 
	 * @return List of children
	 */
	public Object[] getChildren();

	/**
	 * Get text of the object
	 * 
	 * @return text of the object
	 */
	public String getText();

	/**
	 * Get if element has children
	 * 
	 * @return <b>true</b> element has children, <b>false</b> otherwise
	 */
	public boolean hasChildren();

	/**
	 * Return the project owner
	 * 
	 * @return reference on the project owner
	 */
	public IProject getProject();

	/**
	 * Get parent owner.
	 * 
	 * @return reference on the parent owner
	 */
	public Object getParent();
}
