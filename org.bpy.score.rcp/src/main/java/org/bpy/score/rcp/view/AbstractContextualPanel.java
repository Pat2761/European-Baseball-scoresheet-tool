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
package org.bpy.score.rcp.view;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.GameStandaloneSetup;
import org.bpy.score.game.game.Game;
import org.bpy.score.rcp.editor.GameMultipageEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Inject;

/**
 * Abstract common view for all speicific view of the application.
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractContextualPanel extends ViewPart {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(AbstractContextualPanel.class.getSimpleName());
	
	/** XText parser reference */
	@Inject	protected IParser parser;
	
	/** Caret Listener */
	private CaretListener caretListener;

	/** Cursor position in the editor */
	private int cursorPosition;

	/**
	 * Constructor of the class
	 * .
	 * Initialize the injectors.
	 */
	public AbstractContextualPanel() {
		com.google.inject.Injector injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * Clear the panel
	 */
	public abstract void clearPanel();

	/**
	 * Call for update the panel with the edition of a game file. 
	 * 
	 * @param game Reference on the game parsing result
	 * @param scoreGameEngine Reference on the score game engine
	 * @param statisticEngine Reference on the statistic engine
	 */
	public abstract void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine);

	/**
	 * Get cursor position.
	 * 
	 * @return cursor position
	 */
	protected int getCursorPosition() {
		return cursorPosition;
	}

	/**
	 * Set the cursor position.
	 * 
	 * @param cursorPosition cursor position
	 */
	protected void setCursorPosition(int cursorPosition) {
		this.cursorPosition = cursorPosition;
	}

	/**
	 * Initialize the listener
	 */
	protected void initializeListener() {

		caretListener = event -> {setCursorPosition(event.caretOffset); runScoreEngine();} ;

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {

				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText) {
						StyledText text = (StyledText) control;
						text.addCaretListener(caretListener);
						setCursorPosition(text.getCaretOffset());
					}

					runScoreEngine();
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// notinh to do
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText) {
						StyledText text = (StyledText) control;
						text.removeCaretListener(caretListener);
					}
				}

				clearPanel();
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				runScoreEngine();
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
				runScoreEngine();
			}
		});
	}

	/**
	 * Execute the game engine
	 */
	protected void runScoreEngine() {
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (currentEditor instanceof GameMultipageEditor) {
			currentEditor = ((GameMultipageEditor) currentEditor).getGameSourceEditor();
		}

		if (currentEditor instanceof ITextEditor) {
			IEditorInput input = currentEditor.getEditorInput();
			IDocument document = (((ITextEditor) currentEditor).getDocumentProvider()).getDocument(input);

			try {
				String content = document.get().substring(0, getCursorPosition());
				IParseResult parserResult = parser.parse(new StringReader(content));
				Game game = (Game) parserResult.getRootASTElement();

				StatisticEngine statisticEngine = new StatisticEngine();
				statisticEngine.setGame(game);
				statisticEngine.setActionsManager(new StatisticManager());
				statisticEngine.run();

				ScoreGameEngine scoreGameEngine = new ScoreGameEngine();
				scoreGameEngine.runEngine(game);

				updatePanel(game, scoreGameEngine, statisticEngine);
			} catch (StringIndexOutOfBoundsException|SWTException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Set label widget value
	 * @param label label to set
	 * @param value value to set
	 */
	protected void setLabelValue(Label label, String value) {
		if (!label.isDisposed()) {
			label.setText(value);
		}
	}
}
