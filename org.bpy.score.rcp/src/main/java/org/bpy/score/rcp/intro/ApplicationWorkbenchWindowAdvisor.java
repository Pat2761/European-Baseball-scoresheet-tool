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
import org.bpy.score.rcp.decorators.SeasonFolderDecorator;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.WorkbenchWindow;

/**
 * Eclipse internal mechanism
 * 
 * @author Patrick BRIAND.
 *
 */
@SuppressWarnings("restriction")
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * Constructor of the class.
	 * 
	 * @param configurer refrence on the configurer
	 */
  public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    super(configurer);
  }

  public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
    return new ApplicationActionBarAdvisor(configurer);
  }

  @Override
  public void preWindowOpen() {
    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
    configurer.setInitialSize(new Point(700, 550));
    configurer.setShowCoolBar(true);
    configurer.setShowStatusLine(true);
    configurer.setShowProgressIndicator(true);
    configurer.setTitle(Messages.ApplicationWorkbenchWindowAdvisor_RcpTitle);
  }

  @Override
  public void postWindowCreate() {
    IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
    decoratorManager.update(SeasonFolderDecorator.ID);
    
   super.postWindowCreate();
  }
  
  @Override
  public void postWindowOpen() {

    IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IContributionItem[] items = ((WorkbenchWindow) workbenchWindow).getMenuBarManager().getItems();
    for (IContributionItem item : items) {

      switch (item.getId()) {
        case "org.eclipse.ui.run": //$NON-NLS-1$
        case "help": //$NON-NLS-1$
        case "additions": //$NON-NLS-1$
        case "navigate": //$NON-NLS-1$
        case "org.eclipse.ui.externaltools.ExternalToolsSet": //$NON-NLS-1$	
        case "org.eclipse.search.menu": //$NON-NLS-1$
          item.setVisible(false);
          break;
        default:  
      }
    }
  }
  
}
