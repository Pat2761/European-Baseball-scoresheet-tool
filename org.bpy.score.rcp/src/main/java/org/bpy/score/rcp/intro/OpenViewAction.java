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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ContributionItemFactory;

/**
 * open RCP window
 * 
 * @author Patrick BRIAND
 *
 */
public class OpenViewAction implements IWorkbenchWindowActionDelegate  {

  @Override
  public void run(IAction action) {
    // No Action to do
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // No Action to do
  }

  @Override
  public void dispose() {
    // No Action to do
  }

  @Override
  public void init(IWorkbenchWindow window) {
    IContributionItem viewList = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
    
    MenuManager windowMenu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW); //$NON-NLS-1$
    MenuManager viewMenu = new MenuManager("Show &view");  //$NON-NLS-1$
    viewMenu.add(viewList);
    windowMenu.add(viewMenu);
  }

}
