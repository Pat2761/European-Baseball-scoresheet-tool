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
package org.bpy.score.graphics.ui;

import java.net.URL;

import org.bpy.score.graphics.Activator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * Utility for load and store image in the registry
 * 
 * @author Patrick BRIAND
 *
 */
public class SWTUtil {

	/** Reference to the image registry */
	private static ImageRegistry imageRegistry = new ImageRegistry();

	/** Image name */
	private static final String IMAGE_OF_MESSAGE = "PROCESS_RUNNING"; //$NON-NLS-1$

	static {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		IPath path = new Path("icons/info2.gif"); //$NON-NLS-1$
		URL url = FileLocator.find(bundle, path, null);
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		imageRegistry.put(IMAGE_OF_MESSAGE, desc);
	}

	/**
	 * Constructor of the class
	 */
	private SWTUtil() {
	}

	/**
	 * Get the image for the process dialog box
	 * 
	 * @return image for the process dialog box
	 */
	public static Image getImageOfMessage() {
		return imageRegistry.get(IMAGE_OF_MESSAGE);
	}
}