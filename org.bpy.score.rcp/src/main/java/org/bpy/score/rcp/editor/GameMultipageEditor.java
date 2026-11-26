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
package org.bpy.score.rcp.editor;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.GameStandaloneSetup;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.ui.internal.GameActivator;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class is a multi page editor which allow to edit a game file. its
 * contains; - One page for editing the game - One page for the visualization of
 * the visitor sheet - One page for the visualization of the home team sheet
 * 
 * @author Patrick BRIAND
 *
 */
public class GameMultipageEditor extends MultiPageEditorPart {

   /** Page number of game editor */
   public static final int XTEXT_EDITOR_PAGE_NUMBER = 2;
   /** Page number of the visitor sheet */
   public static final int VISITOR_SHEET_PAGE_NUMBER = 0;
   /** Page number of the home team page */
   public static final int HOMETEAM_SHEET_PAGE_NUMBER = 1;

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(GameMultipageEditor.class.getSimpleName());

   /** Reference on the game parser */
   @Inject
   private IParser parser;

   /** Id of the editor */
   public static final String ID = "org.bpy.score.rcp.editor.GameMultipageEditor"; //$NON-NLS-1$

   /** Reference to the game file editor */
   private XtextEditor editor;

   /** Current cursor position */
   private int cursorPosition;
   /** Reference on the visitor sheet */
   private ScoreSheetEditor visitorSheetEditor;
   /** Reference on the home team sheet */
   private ScoreSheetEditor homeTeamSheetEditor;

   /**
    * Constructor of the class. create the EMF injector
    */
   public GameMultipageEditor() {
      com.google.inject.Injector injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
      injector.injectMembers(this);

   }

    /**
    * Get the reference to the game file editor
    * 
    * @return Reference to the game file editor
    */
   public XtextEditor getGameSourceEditor() {
      return editor;
   }

   @Override
   protected void createPages() {
      GameActivator activator = GameActivator.getInstance();
      final Injector injector = activator.getInjector(GameActivator.ORG_BPY_SCORE_GAME_GAME);
      editor = injector.getInstance(XtextEditor.class);
      org.eclipse.swt.widgets.Display.getDefault().asyncExec(() -> goToFirstAction(editor));

      try {
         createVisitorScoresheet();
         createHometeamScoresheet();
      } catch (PartInitException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
      createXtextPage();

      visitorSheetEditor.listenCursor();
      homeTeamSheetEditor.listenCursor();

      initializeListener();

   }

   /**
    * Allow to set the editor cursor just before the first action of the game
    * 
    * @param xtextEditor reference on xtext editor
    */
   private void goToFirstAction(XtextEditor xtextEditor) {
      xtextEditor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
         @Override
         public void process(XtextResource resource) throws Exception {
            if (resource == null || resource.getContents().isEmpty()) {
               return;
            }
            EObject root = resource.getContents().get(0);

            // get first action element
            for (java.util.Iterator<EObject> it = root.eAllContents(); it.hasNext();) {
               EObject o = it.next();
               if (o instanceof HalfInning) { // ton type généré par Xtext
                  ICompositeNode node = NodeModelUtils.findActualNodeFor(o);
                  if (node != null) {
                     final int offset = node.getOffset();
                     final int length = node.getLength();
                     org.eclipse.swt.widgets.Display.getDefault().asyncExec(() -> xtextEditor.selectAndReveal(offset, length));
                  }

                  return;
               }
            }
         }
      });
   }

   /**
    * Create the visitor sheet
    * 
    * @throws PartInitException
    */
   private void createVisitorScoresheet() throws PartInitException {
      visitorSheetEditor = new ScoreSheetEditor(editor, EngineConstants.VISITOR);
 
      addPage(VISITOR_SHEET_PAGE_NUMBER, visitorSheetEditor, getEditorInput());
      setPageText(VISITOR_SHEET_PAGE_NUMBER, Messages.VisitorSheetPanelName);
   }

   /**
    * Create the home team sheet
    * 
    * @throws PartInitException
    */
   private void createHometeamScoresheet() throws PartInitException {
      homeTeamSheetEditor = new ScoreSheetEditor(editor, EngineConstants.HOMETEAM);
      
      addPage(HOMETEAM_SHEET_PAGE_NUMBER, homeTeamSheetEditor, getEditorInput());
      setPageText(HOMETEAM_SHEET_PAGE_NUMBER, Messages.HometeamSheetPanelName);
   }

   @Override
   public boolean isSaveAsAllowed() {
      return true;
   }

   @Override
   public void doSave(IProgressMonitor monitor) {
      getEditor(0).doSave(monitor);
   }

   @Override
   public void doSaveAs() {
      EditorPart localEditor = (EditorPart) getEditor(0);
      localEditor.doSaveAs();
   }

   /**
    * Create the game editor.
    */
   private void createXtextPage() {

      try {

         addPage(XTEXT_EDITOR_PAGE_NUMBER, editor, getEditorInput());
         this.setPartName(editor.getTitle());
         setPageText(XTEXT_EDITOR_PAGE_NUMBER, Messages.EditorSheetPanelName);

      } catch (PartInitException e) {
         ErrorDialog.openError(getSite().getShell(), Messages.GameMultipageEditor_ErrorOpenEditor, null, e.getStatus());
      }
   }

   /**
    * Get the current cursor position
    * 
    * @return current cursor position
    */
   protected int getCursorPosition() {
      return cursorPosition;
   }

   /**
    * Set the current cursor position
    * 
    * @param cursorPosition current cursor position
    */
   protected void setCursorPosition(int cursorPosition) {
      this.cursorPosition = cursorPosition;
   }

   /**
    * Initialize the page changed listener
    * 
    */
   protected void initializeListener() {

      addPageChangedListener(event -> {
         Object page = event.getSelectedPage();
         if (page instanceof ScoreSheetEditor scoreSheetEditor) {
            updateScoreSheet(scoreSheetEditor);
         }
      });
   }

   /**
    * Update the score sheet editor
    * 
    * @param scoreSheetEditor reference to the score sheet editor
    */
   protected void updateScoreSheet(ScoreSheetEditor scoreSheetEditor) {
      EditorPart editorPart = (EditorPart) getEditor(XTEXT_EDITOR_PAGE_NUMBER);
      Control control = editorPart.getAdapter(Control.class);

      if (control instanceof StyledText text) {

         if (scoreSheetEditor instanceof ITextEditor textEditor) {
            IEditorInput input = textEditor.getEditorInput();

            IProject project = null;
            if (input instanceof IFileEditorInput fileInput) {
               IFile file = fileInput.getFile();
               project = file.getProject();
            }
         }

         setCursorPosition(text.getCaretOffset());

         IEditorInput input = editor.getEditorInput();
         IDocument document = editor.getDocumentProvider().getDocument(input);

         String content = document.get().substring(0, getCursorPosition());
         IParseResult parserResult = parser.parse(new StringReader(content));
         Game game = (Game) parserResult.getRootASTElement();

         StatisticEngine statisticEngine = new StatisticEngine();
         statisticEngine.setGame(game);
         statisticEngine.setActionsManager(new StatisticManager());
         statisticEngine.run();

         ScoreViewEngine scoreViewEngine = new ScoreViewEngine();
         scoreViewEngine.setGame(game);
         scoreViewEngine.setActionsManager(new ScoringSheetGraphicalManager());
         scoreViewEngine.setStatisticEngine(statisticEngine);
         scoreSheetEditor.updateView(game, scoreViewEngine, statisticEngine);
      }
   }

   @Override
   public <T> T getAdapter(Class<T> adapter) {
      if (adapter == IContentOutlinePage.class || adapter == IPropertySheetPage.class) {
         if (getGameSourceEditor() != null) {
            T result = getGameSourceEditor().getAdapter(adapter);
            if (result != null)
               return result;
         }
      }
      return super.getAdapter(adapter);
   }
}
