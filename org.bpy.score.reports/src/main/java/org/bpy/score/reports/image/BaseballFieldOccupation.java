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
package org.bpy.score.reports.image;

import java.util.HashMap;

import org.bpy.score.reports.Activator;
import org.bpy.score.reports.gamereports.LineupPlayer;
import org.bpy.score.reports.gamereports.StartingLineup;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Create an image of infield with players position.
 * 
 * @author Patrick BRIAND
 *
 */
public class BaseballFieldOccupation {

	/** reference on the field image */
	private Image fieldImage;

	/** X positions of the players names*/ 
	private static final HashMap<String,Integer> xPositions = new HashMap<String, Integer>();
	/** Y positions of the players names*/ 
	private static final HashMap<String,Integer> yPositions = new HashMap<String, Integer>();
	
	static {
		xPositions.put("1", 410); //$NON-NLS-1$
		xPositions.put("2", 410); //$NON-NLS-1$
		xPositions.put("3", 540); //$NON-NLS-1$
		xPositions.put("4", 470); //$NON-NLS-1$
		xPositions.put("5", 280); //$NON-NLS-1$
		xPositions.put("6", 320); //$NON-NLS-1$
		xPositions.put("7", 170); //$NON-NLS-1$
		xPositions.put("8", 410); //$NON-NLS-1$
		xPositions.put("9", 630); //$NON-NLS-1$

		yPositions.put("1", 420); //$NON-NLS-1$  
		yPositions.put("2", 630); //$NON-NLS-1$
		yPositions.put("3", 460); //$NON-NLS-1$
		yPositions.put("4", 340); //$NON-NLS-1$
		yPositions.put("5", 460); //$NON-NLS-1$
		yPositions.put("6", 290); //$NON-NLS-1$
		yPositions.put("7", 220); //$NON-NLS-1$
		yPositions.put("8", 125); //$NON-NLS-1$
		yPositions.put("9", 220); //$NON-NLS-1$
	}

	/**
	 * Constructor of the class.
	 */
	public BaseballFieldOccupation() {
		// Nothing to do
	}
	
	/**
	 * Draw name of the players on the image.
	 * 
	 * @param lineUp Line-up of the team
	 */
	public void placePlayers(StartingLineup lineUp) {
		Font font = new Font(Display.getCurrent(),"Arial",12,SWT.BOLD);//$NON-NLS-1$

		ImageDescriptor emptyField = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "./icons/baseball-field.png");//$NON-NLS-1$
		fieldImage = emptyField.createImage();
		
		GC gc = new GC(fieldImage);
		gc.setFont(font);
		
		for (LineupPlayer player : lineUp.getLineupPlayers()) {
			Integer xPosition = xPositions.get(player.getDefensivePosition());
			Integer yPosition = yPositions.get(player.getDefensivePosition());
			if (xPosition != null) {
				int x= xPosition.intValue() - gc.textExtent(player.getName()).x/2;
				gc.drawString(player.getName(), x, yPosition.intValue(),true);
			}	
		}
		font.dispose();
		gc.dispose();
	}
	
	/** 
	 * Save the modified image. 
	 * 
	 * @param path Where to save the image
	 */
	public void saveImage(String path) {
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] {fieldImage.getImageData()};
		loader.save(path, SWT.IMAGE_JPEG);
		
		fieldImage.dispose();
	}
}
