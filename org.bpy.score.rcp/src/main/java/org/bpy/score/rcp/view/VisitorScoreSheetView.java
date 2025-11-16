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
package org.bpy.score.rcp.view;

import org.bpy.score.engine.util.EngineConstants;

/**
 * View of the visitor score sheet.
 * 
 * @author Patrick BRIAND
 *
 */
public class VisitorScoreSheetView extends AbstractScoreSheetView {

	/** ID of the view */
	public static final String ID = "org.bpy.score.rcp.view.VisitorGraphicalView"; //$NON-NLS-1$

	/**
	 * Constructor of the view
	 */
	public VisitorScoreSheetView() {
		super(EngineConstants.VISITOR);
	}

}
