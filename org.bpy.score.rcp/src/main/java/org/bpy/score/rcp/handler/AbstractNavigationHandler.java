package org.bpy.score.rcp.handler;

import java.util.Optional;

import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.rcp.editor.GameMultipageEditor;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public abstract class AbstractNavigationHandler extends AbstractHandler {

   public static XtextEditor findXtextEditor(IWorkbenchPart part) {
      if (part instanceof XtextEditor x) {
         return x;
      }

      if (part instanceof GameMultipageEditor multiEditorPage) {
         return multiEditorPage.getGameSourceEditor();
      }

      return part != null ? part.getAdapter(XtextEditor.class) : null;
   }

   private XtextEditor editor;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      editor = findXtextEditor(HandlerUtil.getActiveEditor(event));
      if (editor == null)
         return null;

      ITextSelection sel = (ITextSelection) editor.getSelectionProvider().getSelection();
      int offset = sel.getOffset();

      editor.getDocument().readOnly((XtextResource res) -> {
         EObjectAtOffsetHelper helper = res.getResourceServiceProvider().get(EObjectAtOffsetHelper.class);
         EObject element = helper.resolveContainedElementAt(res, offset);
         ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(res.getParseResult().getRootNode(), offset);
         doExecute(editor, element, leaf);
         return null;
      });
      return null;
   }

   public static <T extends EObject> T findSelectionOrAncestor(EObject start, Class<T> type) {
      for (EObject o = start; o != null; o = o.eContainer()) {
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   public static <T extends EObject> T findFirstDescendant(EObject start, Class<T> type) {
      var it = start.eAllContents();
      while (it.hasNext()) {
         EObject o = it.next();
         if (type.isInstance(o))
            return type.cast(o);
      }
      return null;
   }

   protected <T extends EObject> Optional<T> findElement(EObject startPosition, Class<T> elementType) {
      if (startPosition == null) {
         return Optional.empty();
      }
      T up = findSelectionOrAncestor(startPosition, elementType);
      if (up != null) {
         return Optional.of(up);
      }

      // 3 : premier descendant
      return Optional.ofNullable(findFirstDescendant(startPosition, elementType));
   }

   protected void moveCursor(EObject target) {
      editor.setFocus();
      editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
         @Override
         public void process(XtextResource resource) throws Exception {
            if (resource == null || resource.getContents().isEmpty()) {
               return;
            }
            EObject root = resource.getContents().get(0);

            // get first action element
            for (java.util.Iterator<EObject> it = root.eAllContents(); it.hasNext();) {
               EObject testedObject = it.next();
               if (testedObject == target) {
                  ICompositeNode node = NodeModelUtils.findActualNodeFor(testedObject);
                  if (node != null) {
                     final int offset = node.getOffset();
                     final int length = node.getLength();
                     org.eclipse.swt.widgets.Display.getDefault().asyncExec(() -> editor.selectAndReveal(offset, length));
                  }
                  return;
               }
            }
         }
      });
   }

   protected abstract void doExecute(XtextEditor editor, EObject element, ILeafNode leaf);
}
