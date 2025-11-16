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
package org.bpy.score.rcp.handler;

import org.bpy.score.rcp.wizard.NewChampionatWizard;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Handler for the creation of a new tournament.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewChampionatHandler implements IHandler {

  @Override
  public void addHandlerListener(IHandlerListener handlerListener) {
    // No Action to do
  }

  @Override
  public void dispose() {
    // No Action to do
 }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell() , new NewChampionatWizard());
    dialog.open();
    return null;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean isHandled() {
    return true;
  }

  @Override
  public void removeHandlerListener(IHandlerListener handlerListener) {
    // No Action to do
  }

}
