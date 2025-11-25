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
package org.bpy.score.rcp.intro;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Allow to manage the menus, action bar, etc ...
 * 
 * @author Patrick BRIAND
 *
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	/** Reference on the actions */
    private IWorkbenchAction introAction;
    
    /**
     * Constructor of the class.
     * 
     * @param configurer Configurer of the action bar
     */
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		introAction = ActionFactory.INTRO.create(window);
		IWorkbenchAction switchWorkspaceAction = IDEActionFactory.OPEN_WORKSPACE.create(window);
		
		register(introAction);
		
		register(ActionFactory.COPY.create(window));
		register(ActionFactory.PASTE.create(window));
		register(ActionFactory.CUT.create(window));
		register(ActionFactory.RENAME.create(window));
		register(switchWorkspaceAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		
		MenuManager helpMenu = new MenuManager("&" + Messages.ApplicationActionBarAdvisor_HelpMenu, IWorkbenchActionConstants.M_HELP); //$NON-NLS-1$
		menuBar.add(helpMenu);

		// Help
		helpMenu.add(introAction);
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// Nothing to do	
	}

}
