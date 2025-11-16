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

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.game.game.Game;
import org.bpy.score.graphics.ScoreViewEngine;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;
import org.bpy.score.rcp.graphical.ScoreSheetPanel;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * This class is the Editor of Game files.
 * 
 * @author Patrick BRIAND
 *
 */
public class ScoreSheetEditor extends EditorPart implements MouseWheelListener {

	/** ID of the editor */
	public static final String ID = "org.bpy.score.rcp.editor.ScoreSheetEditor"; //$NON-NLS-1$

	/** Reference to the Xtext Editor of game */
	private XtextEditor editor;
	/** Current team edited */
	private String currentTeam;
	/** Reference the to score sheet panel */
	private ScoreSheetPanel panel;
	/** Reference to the score sheet graphical manager */
	ScoringSheetGraphicalManager scoringSheetGraphicalManager = new ScoringSheetGraphicalManager();

	/** Scroll pane for tehe ditor */
	private JScrollPane scrollPane;

	/**
	 * Constructor of the class
	 * 
	 * @param editor Reference to the Xtext Editor of game
	 * @param currentTeam Current team edited
	 */
	public ScoreSheetEditor(XtextEditor editor, String currentTeam) {
		super();
		this.editor = editor;
		this.currentTeam = currentTeam;
	}

	/**
	 * Create contents of the editor part.
	 *
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.EMBEDDED);

		Frame frame = SWT_AWT.new_Frame(composite);
		frame.setLayout(new BorderLayout());

		panel = new ScoreSheetPanel(currentTeam);

		scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(panel);
		panel.addMouseWheelListener(this);
		frame.add(scrollPane);
		frame.pack();
	}

	@Override
	public IEditorSite getEditorSite() {
		return editor.getEditorSite();
	}

	@Override
	public IWorkbenchPartSite getSite() {
		return editor.getSite();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * Update view when the edition has changed.
	 *  
	 * @param game Reference on the game parsing result
	 * @param scoreViewEngine Manager of Score sheet view 
	 * @param statisticEngine Manager of statistics
	 */
	public void updateView(Game game, ScoreViewEngine scoreViewEngine, StatisticEngine statisticEngine) {
		panel.updateView(game, scoreViewEngine, statisticEngine);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int count = e.getWheelRotation() * 5;

//		if (!e.isControlDown()) {
//			int maxValue = scrollPane.getVerticalScrollBar().getMaximum();
//			int position = scrollPane.getVerticalScrollBar().getValue();
//
//			if ((count > 0) && (position < maxValue)) {
//				int newPosition = (position + count) > maxValue ? maxValue : position + count;
//				scrollPane.getVerticalScrollBar().setValue(newPosition);
//
//			} else if ((count < 0) && position > 0) {
//				int newPosition = (position + count) >= 0 ? position + count : 0;
//				scrollPane.getVerticalScrollBar().setValue(newPosition);
//			}
//
//			panel.repaint();
//		}
	}

}
