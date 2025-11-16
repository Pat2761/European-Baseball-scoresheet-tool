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
package org.bpy.score.rcp.decorators;

import java.net.URL;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * This class provide a season folder decoration.
 * 
 * @author Patrick BRIAND
 *
 */
public class SeasonFolderDecorator extends LabelProvider implements ILightweightLabelDecorator {

	/** Id of the decorator */
	public static final String ID = "org.bpy.score.rcp.season.decorator";

	/** Reference on the decorator image */
	private ImageDescriptor imgDescSeason;

	@Override
	public void decorate(Object element, IDecoration decoration) {
		ImageDescriptor overlay = getOverlay(element);
		if (overlay != null)
			decoration.addOverlay(overlay, IDecoration.TOP_LEFT);

	}

	/**
	 * Get the image of the decorator.
	 * 
	 * @param element element to decorate
	 * 
	 * @return image descriptor for the decoration, <b>null</b> if element can't be decorated
	 */
	private ImageDescriptor getOverlay(Object element) {
		if (IFolder.class.isInstance(element)) {

			if (imgDescSeason == null) {
				URL imgURL = getClass().getClassLoader().getResource("icons/season.png");
				imgDescSeason = ImageDescriptor.createFromURL(imgURL);
			}

			return imgDescSeason;
		}
		return null;
	}
}
