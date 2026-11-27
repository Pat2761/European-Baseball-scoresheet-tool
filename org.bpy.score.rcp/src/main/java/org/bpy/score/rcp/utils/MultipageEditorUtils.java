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
package org.bpy.score.rcp.utils;

import java.util.Optional;

import org.bpy.score.game.game.HalfInning;
import org.bpy.score.rcp.editor.GameMultipageEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Supply static methods based on the multi page editor class
 * 
 * @author Patrick BRIAND
 * 
 */
public class MultipageEditorUtils {

   /**
    * Constructor of the class
    */
   private MultipageEditorUtils() {
      // nothing to do
   }

   /**
    * Search for the editor document.
    * 
    * @return reference on the editor document, <b>null</b> if not found
    */
   public static Optional<IDocument> getEditorDocument() {

      IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      if (currentEditor instanceof GameMultipageEditor multiPageEditor) {
         IEditorInput input = multiPageEditor.getEditorInput();
         ITextEditor textEditor = multiPageEditor.getGameSourceEditor();
         IDocument document = textEditor.getDocumentProvider().getDocument(input);
         return Optional.ofNullable(document);

      } else if (currentEditor instanceof ITextEditor textEditor) {
         IEditorInput input = textEditor.getEditorInput();
         IDocument document = (((ITextEditor) currentEditor).getDocumentProvider()).getDocument(input);
         return Optional.ofNullable(document);

      } else {
         return Optional.ofNullable(null);
      }
   }

   /**
    * Get the editor input.
    * 
    * @return reference on the editor input, <b>null</b> if not found
    */
   public static Optional<IEditorInput> getEditorInput() {
      IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      if (currentEditor instanceof GameMultipageEditor multiPageEditor) {
         return Optional.ofNullable(multiPageEditor.getEditorInput());

      } else if (currentEditor instanceof ITextEditor textEditor) {
         return Optional.ofNullable(textEditor.getEditorInput());

      } else {
         return Optional.ofNullable(null);
      }
   }

   /**
    * Retrieve the active Xtext editor.
    * 
    * @return reference on the Xtext editor, <b>null</b> if not found
    */
   public static Optional<XtextEditor> getXtextEditor() {
      IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      if (editorPart instanceof GameMultipageEditor multiPageEditor && multiPageEditor.getGameSourceEditor() instanceof XtextEditor xtextEditor) {
         return Optional.of(xtextEditor);
      }

      if (editorPart instanceof XtextEditor xtextEditor) {
         return Optional.of(xtextEditor);
      }

      return Optional.empty();
   }

   /**
    * Retrieve the reference of the object at the cursor location.
    * 
    * @return reference on the Xtext object, <b>null</b> if not found
    */
   public static Optional<EObject> getObjectAtCursor() {
      Optional<XtextEditor> xtextEditor = getXtextEditor();

      if (xtextEditor.isPresent()) {

         XtextEditor editor = xtextEditor.get();

         ISelection selection = editor.getSelectionProvider().getSelection();
         if (!(selection instanceof ITextSelection textSelection)) {
            return Optional.empty();
         }

         int offset = textSelection.getOffset();

         return editor.getDocument().readOnly(resource -> {
            EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
            EObject element = helper.resolveElementAt(resource, offset);
            return Optional.ofNullable(element);
         });

      }
      return Optional.empty();
   }
   
   /**
    * Get the object length.
    * 
    * @param element reference on the element
    * @return size of the element, 0 if not found
    */
   public static int getObjectLenght(EObject element) {
      ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
      
      return (node != null ? node.getLength() : 0);
   }

   /**
    * Find the reference of an element which is link to an another object. 
    * 
    * @param <T> Type of object 
    * @param start starting object
    * @param type Type of object to search
m    * 
    * @return Reference of the found object 
    */
   public static <T extends EObject> Optional<T> findElement(EObject start, Class<T> type) {
      if (start == null)
         return Optional.empty();

      // 1 et 2 : soi-même, puis remontée par eContainer()
      T up = findSelfOrAncestor(start, type);
      if (up != null)
         return Optional.of(up);

      // 3 : premier descendant
      return Optional.ofNullable(findFirstDescendant(start, type));
   }

   /**
    * Ascendant search.
    *  
    * @param <T> Type of object 
    * @param start starting object
    * @param type Type of object to search
    *
    * @return Reference of the found object 
    */
   private static <T extends EObject> T findSelfOrAncestor(EObject start, Class<T> type) {
      for (EObject o = start; o != null; o = o.eContainer()) {
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   /**
    * Descendant search.
    *  
    * @param <T> Type of object 
    * @param start starting object
    * @param type Type of object to search
    *
    * @return Reference of the found object 
    */
   private static <T extends EObject> T findFirstDescendant(EObject start, Class<T> type) {
      var it = start.eAllContents();
      while (it.hasNext()) {
         EObject o = it.next();
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   /** 
    * Get the name the current team for the element.
    * 
    * @param optionalElement Element to search
    * @return Name of the team, <b>null</b> if not found
    */
   public static Optional<String> getCurrentTeam(Optional<EObject> optionalElement) {

      if (optionalElement.isPresent()) {
         Optional<HalfInning> optionalInning = findElement(optionalElement.get(), HalfInning.class);
         if (optionalInning.isPresent()) {
            return Optional.ofNullable(optionalInning.get().getTeam());
         }
      }
      return Optional.empty();
   }
}
