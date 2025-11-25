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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * View which show the current line-up for teams.
 * 
 * @author Patrick BRIAND
 *
 */
public class CurrentLineupView extends AbstractContextualPanel implements SelectionListener {

	/**
	 * Data class which describe a player in the line-up.
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public class LineupPlayerDescription {
		
		/** Name of the player */
		private String name;
		/** Defensive position of the player */
		private String defensivePosition;
		/** Offensive position of the player */
		private String offensivePosition;
		
		/**
		 * Get player name.
		 *  
		 * @return player name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * Set player name.
		 * 
		 * @param name ^player name
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * Get defensive position.
		 * 
		 * @return defensive position
		 */
		public String getDefensivePosition() {
			return defensivePosition;
		}
		
		/**
		 * Set defensive position.
		 * 
		 * @param defensivePosition defensive position
		 */
		public void setDefensivePosition(String defensivePosition) {
			this.defensivePosition = defensivePosition;
		}
		
		/**
		 *  Get offensive position.
		 * 
		 * @return offensive position
		 */
		public String getOffensivePosition() {
			return offensivePosition;
		}
		
		/**
		 * set offensive position.
		 * 
		 * @param offensivePosition offensive position
		 */
		public void setOffensivePosition(String offensivePosition) {
			this.offensivePosition = offensivePosition;
		}
		
		
	}
	
	/** Constant for no position (defensive or offensive */
	public static final String NO_POSITION = "-1"; //$NON-NLS-1$
	
	/** Id of the view */
    public static final String ID = "org.bpy.score.rcp.currentlineup.view"; //$NON-NLS-1$

    /** Reference to the table which display players in the line-up */
	private Table table;
	/** Combo for select the team */
	private Combo combo;

	/** Current visitor line-up */
	private LineupManager currentVisitorlineup;
	/** Current home team line-up */
	private LineupManager currentHometeamlineup;
	
	/** Current values displayed */
	HashMap<String, LineupPlayerDescription> currentDisplay;

	/**
	 * Constructor of the class.
	 */
	public CurrentLineupView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		
		table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 29, 268, 319);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnJoueur = new TableColumn(table, SWT.NONE);
		tblclmnJoueur.setWidth(162);
		tblclmnJoueur.setText(Messages.CurrentLineupView_PlayerColumnName);
		
		TableColumn tblclmnPositionOfffensive = new TableColumn(table, SWT.NONE);
		tblclmnPositionOfffensive.setWidth(51);
		tblclmnPositionOfffensive.setText(Messages.CurrentLineupView_DefensiveColumnName);
		
		TableColumn tblclmnDp = new TableColumn(table, SWT.NONE);
		tblclmnDp.setWidth(49);
		tblclmnDp.setText(Messages.CurrentLineupView_OffensiveColumnName);
		
		combo = new Combo(parent, SWT.READ_ONLY);
		combo.setItems(Messages.CurrentLineupView_VisitorTeam, Messages.CurrentLineupView_Hometeam);
		combo.setBounds(10, 0, 264, 23);
		combo.setText(Messages.CurrentLineupView_VisitorTeam);
		combo.addSelectionListener(this);

		initializeListener();
	}

	@Override
	public void setFocus() {
		// Nothing to do
	}

	@Override
	public void clearPanel() {
		// Nothing to do
	}

	@Override
	public void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine) {
		
		LineupManager visitorlineup = scoreGameEngine.getActionsManager().getVisitorLineup();
		LineupManager hometeamlineup = scoreGameEngine.getActionsManager().getHometeamLineup();
		
		if (currentVisitorlineup == null) {
			currentVisitorlineup = visitorlineup;
		}
		
		if (currentHometeamlineup == null) {
			currentHometeamlineup = hometeamlineup;
		}
		
		if (combo.getSelectionIndex() == 0) {
			updatePanel(visitorlineup);
		} else {
			updatePanel(hometeamlineup);
		}
	}

	/**
	 * Update the panel with the new line-up manager
	 * 
	 * @param currentLineUp current line-up manager
	 */
	private void updatePanel(LineupManager currentLineUp) {
		if (currentLineUp != null) {
			table.removeAll();
			currentDisplay = new HashMap<>();

			for (LineupEntry lineupEntry : currentLineUp.getPlayers()) {
				
				if (lineupEntry.isActif()) {
					
					LineupPlayerDescription lineupPlayerDescription = new LineupPlayerDescription(); 
					
					String offensivePosition = (NO_POSITION.equals(lineupEntry.getOffensivePosition())? StringUtils.EMPTY : lineupEntry.getOffensivePosition()); 
					String defensivePosition = (NO_POSITION.equals(lineupEntry.getDefensivePosition())? StringUtils.EMPTY : lineupEntry.getDefensivePosition()); 
					
					lineupPlayerDescription.offensivePosition = offensivePosition;
					lineupPlayerDescription.defensivePosition = defensivePosition;
					lineupPlayerDescription.name = lineupEntry.getPlayerDescription().getName();

					currentDisplay.put(offensivePosition, lineupPlayerDescription);
				}
			}
			
			List<String> positions = new ArrayList<> (currentDisplay.keySet());
			Collections.sort(positions);
			for (String position : positions) {
				
				TableItem item = new TableItem(table, SWT.NONE);
				LineupPlayerDescription player = currentDisplay.get(position);
				item.setText(new String[] {player.name, player.defensivePosition, player.offensivePosition});
				
			}
		}
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (combo.getSelectionIndex() == 0) {
			updatePanel(currentVisitorlineup);
		} else {
			updatePanel(currentHometeamlineup);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do
	}

}
