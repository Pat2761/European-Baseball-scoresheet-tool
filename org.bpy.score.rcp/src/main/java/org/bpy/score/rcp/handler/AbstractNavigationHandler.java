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

import org.bpy.score.rcp.editor.GameMultipageEditor;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Abstract class which supply services for the navigation.
 * 
 * @author Patrick BRIAND
 */
public abstract class AbstractNavigationHandler extends AbstractHandler {

   
   /**
    * Reference on the XText editor
    */
   private XtextEditor editor;

   /**
    * Get the reference on the XtextEditor.
    * 
    * @param part Reference on the active part.
    * @return reference on the XtextEditor, <b>null</b> if not found
    */
   public static XtextEditor findXtextEditor(IWorkbenchPart part) {
      if (part instanceof XtextEditor x) {
         return x;
      }

      if (part instanceof GameMultipageEditor multiEditorPage) {
         return multiEditorPage.getGameSourceEditor();
      }

      return part != null ? part.getAdapter(XtextEditor.class) : null;
   }

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      editor = findXtextEditor(HandlerUtil.getActiveEditor(event));
      if (editor != null) {

         ITextSelection sel = (ITextSelection) editor.getSelectionProvider().getSelection();
         int offset = sel.getOffset();

         editor.getDocument().readOnly((XtextResource res) -> {
            EObjectAtOffsetHelper helper = res.getResourceServiceProvider().get(EObjectAtOffsetHelper.class);
            EObject element = helper.resolveContainedElementAt(res, offset);
            ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(res.getParseResult().getRootNode(), offset);
            doExecute(editor, element, leaf);
            return null;
         });
      }
      return null;
   }

   /**
    * Search for the selection or a parent of an Xtext object.
    * 
    * @param <T> Generic type
    * @param start Starting point of the search
    * @param type Type of object
    * 
    * @return Reference on the object, <b>null</b> if not found
    */
   public static <T extends EObject> T findSelectionOrAncestor(EObject start, Class<T> type) {
      for (EObject o = start; o != null; o = o.eContainer()) {
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   /**
    * Search for the first descendant object. 
    * 
    * @param <T> Generic type
    * @param start Starting point of the search
    * @param type Type of object
    * 
    * @return Reference on the object, <b>null</b> if not found
    */
   public static <T extends EObject> T findFirstDescendant(EObject start, Class<T> type) {
      var it = start.eAllContents();
      while (it.hasNext()) {
         EObject o = it.next();
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   /**
    * Search for the ascendant object.
    * 
    * @param <T> Generic type
    * @param startPosition Starting point of the search
    * @param elementType Type of object
    * 
    * @return Reference on the object, <b>null</b> if not found
    */
   protected <T extends EObject> Optional<T> findElement(EObject startPosition, Class<T> elementType) {
      if (startPosition == null) {
         return Optional.empty();
      }
      T up = findSelectionOrAncestor(startPosition, elementType);
      if (up != null) {
         return Optional.of(up);
      }

      return Optional.ofNullable(findFirstDescendant(startPosition, elementType));
   }
  
   /**
    * Move the cursor to a an Xtext element.
    * 
    * @param target reference on the Xtext element
    */
   protected void moveCursor(EObject target) {
      if (target == null || editor == null || editor.getDocument() == null) {
         return;
      }
      org.eclipse.emf.common.util.URI targetUri = org.eclipse.emf.ecore.util.EcoreUtil.getURI(target);

      editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
         @Override
         public void process(XtextResource resource) throws Exception {
             EObject resolvedTarget = targetUri != null
                     ? resource.getEObject(targetUri.fragment()) : null;
             if (resolvedTarget == null) return;

             // URI recalculée sur l'objet effectivement résolu
             final URI uri = EcoreUtil.getURI(resolvedTarget);

             Display.getDefault().asyncExec(() -> {
                 Object page = editor.getAdapter(IContentOutlinePage.class);
                 if (!(page instanceof OutlinePage outline)) return;

                 TreeViewer viewer = outline.getTreeViewer();
                 if (viewer == null || viewer.getControl().isDisposed()) return;

                 IOutlineNode node = findNode((IOutlineNode) viewer.getInput(), uri);
                 if (node != null) {
                     viewer.setSelection(new StructuredSelection(node), true); // true = révéler
                 }
             });
         }
     });    
      
      
//      editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
//         @Override
//         public void process(XtextResource resource) throws Exception {
//            if (resource == null || resource.getContents().isEmpty()) {
//               return;
//            }
//            EObject resolvedTarget = targetUri != null ? resource.getEObject(targetUri.fragment()) : null;
//            if (resolvedTarget == null) {
//               return;
//            }
//            
//            ICompositeNode node = NodeModelUtils.findActualNodeFor(resolvedTarget);
//            if (node != null) {
//               final int offset = node.getOffset();
//               final int length = node.getLength();
//               
//               IContentOutlinePage page = editor.getAdapter(IContentOutlinePage.class);
//               if (page instanceof OutlinePage outlinePage) {
//                  outlinePage.getTreeViewer().setSelection(new StructuredSelection(node), true);
//               }
//               
//               org.eclipse.swt.widgets.Display.getDefault().asyncExec(() -> {
//                  editor.setFocus();
//                  editor.selectAndReveal(offset, length);
//               });
//            }
//         }
//      });
      
//      Display.getDefault().asyncExec(() -> {
//      Object page = editor.getAdapter(IContentOutlinePage.class);
//      if (page instanceof OutlinePage outline) {
//         ISelection selection = editor.getSelectionProvider().getSelection();
//         outline.setSelection(selection);
//      }
//      });

   }
   
   private static IOutlineNode findNode(IOutlineNode node, URI target) {
      if (node == null) return null;
      if (node instanceof EObjectNode n && target.equals(n.getEObjectURI())) return node;
      for (IOutlineNode child : node.getChildren()) {
          IOutlineNode r = findNode(child, target);
          if (r != null) return r;
      }
      return null;
  }
   /**
    * Action to do
    * 
    * @param editor reference on the Xtext editor
    * @param element Reference on the current element in the editor
    * @param leaf Node of the current element
    */
   protected abstract void doExecute(XtextEditor editor, EObject element, ILeafNode leaf);
}
