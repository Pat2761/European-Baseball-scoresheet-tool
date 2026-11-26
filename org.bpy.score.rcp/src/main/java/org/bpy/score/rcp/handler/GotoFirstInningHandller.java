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

import java.util.Optional;

import org.bpy.score.game.game.Actions;
import org.bpy.score.game.game.HalfInning;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Handler which allows to move the cursor at the first inning 
 * in the active game editor.
 * 
 * @author Patrick BRIAND
 *
 */
public class GotoFirstInningHandller extends AbstractNavigationHandler {

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public boolean isHandled() {
      return true;
   }

   @Override
   protected void doExecute(XtextEditor editor, EObject element, ILeafNode leaf) {
      Optional<HalfInning> halfInning = findElement(element, HalfInning.class);
      halfInning.ifPresent(h -> gotoFirstHalfInning(halfInning.get()));
   }

   private void gotoFirstHalfInning(HalfInning halfInning) {
     Actions actions = (Actions) halfInning.eContainer(); 
     moveCursor(actions.getHalfInnings().get(0));
   }
}
