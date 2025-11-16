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
import org.bpy.score.game.ui.internal.GameActivator;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.ui.editor.XtextEditor;

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
		createXtextPage();
		try {
			createVisitorScoresheet();
			createHometeamScoresheet();
		} catch (PartInitException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}

	/**
	 * Create the visitor sheet
	 * 
	 * @throws PartInitException
	 */
	private void createVisitorScoresheet() throws PartInitException {
		ScoreSheetEditor visitorSheetEditor = new ScoreSheetEditor(editor, EngineConstants.VISITOR);

		addPage(1, visitorSheetEditor, getEditorInput());
		setPageText(1, "Visitor score sheet"); //$NON-NLS-1$
	}

	/**
	 * Create the home team sheet
	 * 
	 * @throws PartInitException
	 */
	private void createHometeamScoresheet() throws PartInitException {
		ScoreSheetEditor homeTeamSheetEditor = new ScoreSheetEditor(editor, EngineConstants.HOMETEAM);
		addPage(2, homeTeamSheetEditor, getEditorInput());
		setPageText(2, "Hometeam score sheet"); //$NON-NLS-1$
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

			GameActivator activator = GameActivator.getInstance();
			final Injector injector = activator.getInjector(GameActivator.ORG_BPY_SCORE_GAME_GAME);
			editor = injector.getInstance(XtextEditor.class);

			addPage(0, editor, getEditorInput());
			this.setPartName(editor.getTitle());
			setPageText(0, "Game editor"); //$NON-NLS-1$

			initializeListener();

		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), Messages.GameMultipageEditor_ErrorOpenEditor, null, e.getStatus());
		}
	}

	/** 
	 * Get the current cursor position 
	 *  
	 * @return  current cursor position
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

		this.addPageChangedListener( event -> 
		{
			Object page = event.getSelectedPage();
			if (page instanceof ScoreSheetEditor) {
				updateScoreSheet((ScoreSheetEditor) page);
			}
		});
	}

	/**
	 * Update the score sheet editor
	 * 
	 * @param scoreSheetEditor reference to the score sheet editor 
	 */
	protected void updateScoreSheet(ScoreSheetEditor scoreSheetEditor) {
		EditorPart editorPart = (EditorPart) getEditor(0);
		Control control = editorPart.getAdapter(Control.class);
		if (control instanceof StyledText) {
			StyledText text = (StyledText) control;
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
}
