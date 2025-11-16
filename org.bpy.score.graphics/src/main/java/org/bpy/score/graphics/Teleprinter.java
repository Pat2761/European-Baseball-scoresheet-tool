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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * This class allow to print some test in an predefined area.
 * 
 * @author Patrick BRIAND
 *
 */
public class Teleprinter {

	/** List of line to print */
	private List<TeleprinterLineDescripter> lineDescriptors;
	/** Reference on the curren(t line description to print */
	private TeleprinterLineDescripter currentLineDescritor;
	/** Memorize the current position in the area */
	private int currentPosition;
	/** Current line to print */
	private int currentLine;

	/** Width of the area for the tele printer */
	private static double width = ScoringSheetGraphicalManager.WIDTH_LINE * ScoringSheetGraphicalManager.FACTOR_CORRECTIF;
	/** heigth of the area for the tele printer */
	private static double height = ScoringSheetGraphicalManager.HEIGHT_LINE * ScoringSheetGraphicalManager.FACTOR_CORRECTIF;

	/**
	 * Constructor of the class.
	 * Initialize the list of line to teleprint 
	 * 
	 * @param lineDescriptors list of line to teleprint
	 */
	public Teleprinter(List<TeleprinterLineDescripter> lineDescriptors) {
		this.lineDescriptors = lineDescriptors;
		currentPosition = 0;
		currentLine = 0;
		currentLineDescritor = lineDescriptors.get(0);
	}

	/**
	 * Push a character in the teleprinter.
	 * 
	 * @param g2 Reference on the graphical context
	 * @param charToDisplay character tu print
	 * @param font font to use
	 * @param color color to use
	 * @param heightOffset Height offset
	 */
	public void pushChar(Graphics2D g2, char charToDisplay, Font font, Color color, int heightOffset) {
		Font currentFont = g2.getFont();
		Color currentColor = g2.getColor();

		g2.setFont(font);
		g2.setColor(color);

		int x = currentLineDescritor.getStartingPositions().x + currentPosition * 3;
		int y = currentLineDescritor.getStartingPositions().y;

		Rectangle2D bounds = g2.getFontMetrics().getStringBounds("" + charToDisplay, g2); //$NON-NLS-1$
		g2.drawString("" + charToDisplay, (float) (x + (width - bounds.getWidth()) / 2), (float) (y + height //$NON-NLS-1$
				- ((height - bounds.getHeight()) / 2) - g2.getFontMetrics().getMaxDescent() + heightOffset));

		g2.setFont(currentFont);
		g2.setColor(currentColor);

		currentPosition++;
		if (currentPosition == currentLineDescritor.getNbCharsMax()) {
			currentLine++;
			currentPosition = 0;
			if (currentLine < lineDescriptors.size()) {
				currentLineDescritor = lineDescriptors.get(currentLine);
			}
		}
	}

	/** Add a new line */
	public void newLine() {
		currentLine++;
		currentPosition = 0;
		if (currentLine < lineDescriptors.size()) {
			currentLineDescritor = lineDescriptors.get(currentLine);
		}
	}

	/**
	 * Check if left place is enough to a number of characters.
	 * 
	 * @param nbCharToAdded number of characters to print
	 * 
	 * @return <b>true</b> Enough place left, <b>false</b> otherwize
	 */
	public boolean leftPlaceFor(int nbCharToAdded) {
		return (currentPosition + nbCharToAdded) <= currentLineDescritor.getNbCharsMax();
	}

}
