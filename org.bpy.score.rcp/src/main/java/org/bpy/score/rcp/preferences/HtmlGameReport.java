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
package org.bpy.score.rcp.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for the HTML reports (Under construction)
 * 
 * @author Patrick BRIAND
 *
 */
public class HtmlGameReport extends PreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructor of the page.
	 */
	public HtmlGameReport() {
		// No Action to do
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 */
	public HtmlGameReport(String title) {
		super(title);
	}

	/**
	 * Constructor of the page.
	 * 
	 * @param title title of the page
	 * @param image Image of the page
	 */
	public HtmlGameReport(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
		// No Action to do
	}

	@Override
	protected Control createContents(Composite parent) {
		return null;
	}

}
