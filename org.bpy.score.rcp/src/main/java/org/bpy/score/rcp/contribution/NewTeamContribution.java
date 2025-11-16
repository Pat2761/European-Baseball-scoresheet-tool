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
package org.bpy.score.rcp.contribution;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * This class isn't used for the moment. It just exist for test a concept
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamContribution extends ContributionItem {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(NewTeamContribution.class.getSimpleName());

	/**
	 * Constructor of the class
	 */
	public NewTeamContribution() {
		// Notthing to do
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param id id value
	 */
	public NewTeamContribution(String id) {
		super(id);
	}

	@Override
	public void fill(Menu menu, int index) {
		MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
		
		menuItem.setText("My menu item"); //$NON-NLS-1$
		
		menuItem.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.log(Level.SEVERE,"Dynamic menu selected"); //$NON-NLS-1$
			}
		});
	}
}
