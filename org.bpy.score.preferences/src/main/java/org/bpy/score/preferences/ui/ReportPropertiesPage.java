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
package org.bpy.score.preferences.ui;

import org.bpy.score.internationalization.preferences.Messages;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IWorkbenchPropertyPage;

/**
 *  Main property page of the report preference
 * 
 * @author Patrick BRIAND
 *
 */
public class ReportPropertiesPage extends ReportPreferencePage implements IWorkbenchPropertyPage {

	/**
	 * Create the property page.
	 */
	public ReportPropertiesPage() {
		setMessage(Messages.ReportPropertiesPage_Message);
		setDescription(Messages.ReportPropertiesPage_Description);
	}

	@Override
	public IAdaptable getElement() {
		// Nothing to do
		return null;
	}

	@Override
	public void setElement(IAdaptable element) {
		// NBothing to do
		
	}

}
