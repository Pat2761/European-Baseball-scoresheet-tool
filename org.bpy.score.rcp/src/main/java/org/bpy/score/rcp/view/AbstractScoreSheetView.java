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

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.StringReader;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.game.Game;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;
import org.bpy.score.rcp.editor.GameMultipageEditor;
import org.bpy.score.rcp.graphical.ScoreSheetPanel;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

/**
 * Supply common resources for the score sheet view
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractScoreSheetView extends AbstractContextualPanel implements MouseWheelListener, KeyListener {

	/** Id of the view */
	public static final String ID = "org.bpy.score.rcp.view.VisitorGraphicalView"; //$NON-NLS-1$
	
	/** Scroll panel reference */
	protected ScoreSheetPanel panel;
	/** Scroll panel reference */
	private JScrollPane scrollPane;
	/** Current team */
	private String currentTeam;

	/**
	 * Constructor of the class.
	 * 
	 * @param currentTeam current team
	 */
	public AbstractScoreSheetView(String currentTeam) {
		super();
		this.currentTeam = currentTeam;
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.EMBEDDED);
		composite.addKeyListener(this);

		Frame frame = SWT_AWT.new_Frame(composite);
		frame.setLayout(new BorderLayout());

		panel = new ScoreSheetPanel(currentTeam);

		scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(panel);
		panel.addMouseWheelListener(this);
		frame.add(scrollPane);
		frame.pack();

		createActions();
		initializeToolBar();
		initializeMenu();

		initializeListener();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		// Nothing to do
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// Nothing to do
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void clearPanel() {
		// No Action to do
	}

	@Override
	protected void runScoreEngine() {
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (currentEditor instanceof GameMultipageEditor) {
			currentEditor = ((GameMultipageEditor) currentEditor).getGameSourceEditor();
		}

		if (currentEditor instanceof ITextEditor) {
			IEditorInput input = currentEditor.getEditorInput();
			IDocument document = (((ITextEditor) currentEditor).getDocumentProvider()).getDocument(input);

			String content = document.get();
			int cursorPosition = getCursorPosition();

			if (cursorPosition < content.length()) {
				content = content.substring(0, cursorPosition);
			}
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

			panel.updateView(game, scoreViewEngine, statisticEngine);
		}
	}

	@Override
	public void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine) {
		// No Action to do
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int count = e.getWheelRotation() * 5;

		if (!e.isControlDown()) {
			int maxValue = scrollPane.getVerticalScrollBar().getMaximum();
			int position = scrollPane.getVerticalScrollBar().getValue();

			if ((count > 0) && (position < maxValue)) {
				int newPosition = (position + count) > maxValue ? maxValue : position + count;
				scrollPane.getVerticalScrollBar().setValue(newPosition);

			} else if ((count < 0) && position > 0) {
				int newPosition = (position + count) >= 0 ? position + count : 0;
				scrollPane.getVerticalScrollBar().setValue(newPosition);
			}

			panel.repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int position;
		int maxValue;
		
		switch (e.keyCode) {
		
		case SWT.ARROW_DOWN: 
			 maxValue = scrollPane.getVerticalScrollBar().getMaximum();
			 position = scrollPane.getVerticalScrollBar().getValue();

			if (position < maxValue) {
				int newPosition = (position + 10) > maxValue ? maxValue : position + 10;
				scrollPane.getVerticalScrollBar().setValue(newPosition);
				panel.repaint();
			}
		
			break;

		case SWT.ARROW_RIGHT: 
			maxValue = scrollPane.getHorizontalScrollBar().getMaximum();
			position = scrollPane.getHorizontalScrollBar().getValue();

			if (position < maxValue) {
				int newPosition = (position + 10) > maxValue ? maxValue : position + 10;
				scrollPane.getHorizontalScrollBar().setValue(newPosition);
				panel.repaint();
			}
			break;

		case SWT.ARROW_LEFT: 
			position = scrollPane.getHorizontalScrollBar().getValue();

			if (position > 0) {
				int newPosition = (position - 10) < 0 ? 0 : position - 10;
				scrollPane.getHorizontalScrollBar().setValue(newPosition);
				panel.repaint();
			}
			break;

		case SWT.ARROW_UP: 
			position = scrollPane.getVerticalScrollBar().getValue();

			if (position > 0) {
				int newPosition = (position - 10) < 0 ? 0 : position - 10;
				scrollPane.getVerticalScrollBar().setValue(newPosition);
				panel.repaint();
			}
			break;
			
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Nothing to do
	}

}
