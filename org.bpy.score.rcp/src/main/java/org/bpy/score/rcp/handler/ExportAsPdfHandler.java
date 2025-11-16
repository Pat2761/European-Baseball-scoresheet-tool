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

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.reports.pdf.ScoreSheetEngine;
import org.bpy.score.reports.pdf.ScoringSheetManager;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Handler for export score sheet as an PDF file.
 * 
 * @author Patrick BRIAND
 *
 */
public class ExportAsPdfHandler implements IHandler {

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

    DirectoryDialog dlg = new DirectoryDialog(new Shell());
    dlg.setText(Messages.ExportAsPdfHandler_DialogText);
    dlg.setMessage(Messages.ExportAsPdfHandler_DialogTitle);
    String dir = dlg.open();
    if (dir != null) {

      IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if (editor instanceof XtextEditor) {
        XtextEditor xtextEditor = (XtextEditor) editor;
        IXtextDocument document = xtextEditor.getDocument();
        
        document.readOnly(new IUnitOfWork.Void<XtextResource>() {
          @Override
          public void process(XtextResource resource) throws Exception {
            
            IParseResult parseResult = resource.getParseResult();
            Game game = (Game) parseResult.getRootASTElement();
            
            /* needs stats for file the sheets */
            StatisticEngine statisticEngine = new StatisticEngine();
            statisticEngine.setGame(game);
            statisticEngine.setActionsManager(new StatisticManager());
            statisticEngine.run();
       
            /* fill sheet */
            ScoreSheetEngine scoreSheetEngine = new ScoreSheetEngine();
            scoreSheetEngine.setGame(game);
            scoreSheetEngine.setActionsManager(new ScoringSheetManager());
            scoreSheetEngine.setPath(dir);
            scoreSheetEngine.setStatisticEngine(statisticEngine);
            scoreSheetEngine.run();
            
            String fileName = ((XtextEditor) editor).getPartName().replace(".game", ".pdf"); //$NON-NLS--1$ //$NON-NLS--2$
            String message = NLS.bind(Messages.ExportAsPdfHandler_ExportResume, new Object[] {fileName,dir});
            
            MessageDialog.openInformation(new Shell(), Messages.ExportAsPdfHandler_ExportSuccesFull, message);
          }
        });
      }  
    }
    
    return null;
  }

  @Override
  public boolean isEnabled() {
    IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if (editor instanceof XtextEditor) {
      XtextEditor xtextEditor = (XtextEditor) editor;

      if ("org.bpy.score.game.Game".equals(xtextEditor.getLanguageName())) { //$NON-NLS--1$
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isHandled() {
	  return isEnabled();
  }

  @Override
  public void removeHandlerListener(IHandlerListener handlerListener) {
    // No Action to do
  }

}
