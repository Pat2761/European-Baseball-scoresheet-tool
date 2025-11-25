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
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.HalfInning;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;

/**
 * general statistic view (Under construction).
 * 
 * @author Patrick BRIAND
 *
 */
public class GeneralStatisitcView extends AbstractContextualPanel {

	/**
	 * Cell renderer.
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	private class GeneralStatisitcCellRenderer extends DefaultTableCellRenderer {

		/** Serial ID*/
		private static final long serialVersionUID = 8577615469548226100L;
		/** Font use in the cell */
		private final Font boldFont = new Font("Dialog", Font.BOLD, 12); //$NON-NLS-1$

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int col) {

			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			if ((col % 2) == 1) {
				c.setFont(boldFont);
				c.setBackground(Color.CYAN);
			}
			return c;
		}

	}
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GeneralStatisitcView.class.getSimpleName());
	
	/** Inning string constants */
	public static final String INNING = "Inning "; //$NON-NLS-1$

	/** Serial ID*/
	public static final String ID = "org.bpy.score.rcp.view.GeneralStatisitcView"; //$NON-NLS-1$
	/** Reference on the table which display the statistics */
	private JTable table;
	/** Table model */
	private DefaultTableModel model;
	/** Scroll pane */
	private JScrollPane scrollPane;

	/**
	 * Constructor of the class
	 */
	public GeneralStatisitcView() {
		// Nothing to do
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.EMBEDDED);

		Frame frame = SWT_AWT.new_Frame(composite);
		frame.setLayout(new BorderLayout());

		scrollPane = new JScrollPane();

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setDefaultRenderer(Object.class, new GeneralStatisitcCellRenderer());

		model = new DefaultTableModel();
		model.setDataVector(new Object[][] { { "AB" }, { "R" }, { "ER" }, { "H" }, { "A" }, { "E" }, { "LOB" } },  //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-5$  //$NON-NLS-6$ //$NON-NLS-7$
				new String[] { " " }); //$NON-NLS-1$

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		frame.add(scrollPane);

		table.getColumnModel().getColumn(0).setCellRenderer( (x,value,isSelected,hasFocus,row,column) -> 
		{
			boolean selected = table.getSelectionModel().isSelectedIndex(row);
			Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table,
					value, false, false, -1, -2);
			((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
			if (selected) {
				component.setFont(component.getFont().deriveFont(Font.BOLD));
				component.setForeground(Color.red);
			} else {
				component.setFont(component.getFont().deriveFont(Font.PLAIN));
			}
			return component;
		});

		initializeListener();
	}

	@Override
	public void clearPanel() {
		// No Action to do
	}

	@Override
	public void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine) {
		try {

			if (!game.getActions().getHalfInnings().isEmpty()) {
				HalfInning inning = game.getActions().getHalfInnings().get(game.getActions().getHalfInnings().size() - 1);
				if (inning.getTeam().equals(EngineConstants.HOMETEAM)) {
					displayGeneralStatistics(statisticEngine.getStatisticManager().getStats().getHometeam());
				} else {
					displayGeneralStatistics(statisticEngine.getStatisticManager().getStats().getVisitor());
				}
			}

		} catch (NullPointerException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

	/**
	 * Display the statistics. 
	 * 
	 * @param teamStatistic Reference on the team statistics container
	 */
	private void displayGeneralStatistics(TeamStatistic teamStatistic) {
		EList<InninStatictic> inningStats = teamStatistic.getGeneralInningStats();

		int size = (inningStats.isEmpty() ? 1 : inningStats.size() * 2);
		int headerSize = (inningStats.isEmpty() ? 1 : inningStats.size() + 1);

		DefaultTableModel dataModel = new DefaultTableModel(7, 0);
		int counter = 0;
		for (int i = 0; i <= inningStats.size(); i++) {
			switch (counter) {
			case 0:
				dataModel.addColumn(" "); //$NON-NLS-1$
				counter++;
				break;

			case 1:
				dataModel.addColumn(INNING + counter++);
				break;

			default:
				dataModel.addColumn(INNING + counter++);
				dataModel.addColumn(INNING + counter++);
			}
		}

		TableColumnModel columns = new DefaultTableColumnModel();
		counter = 0;
		for (int i = 0; i <= inningStats.size(); i++) {

			if (counter == 0) {
				TableHeader.XTableColumn col0 = new TableHeader.XTableColumn();
				col0.setHeaderValue(" "); //$NON-NLS-1$
				col0.setHeaderSpan(1);
				col0.setModelIndex(0);
				columns.addColumn(col0);
				counter++;

			} else if (counter == 1) {
				TableHeader.XTableColumn col1 = new TableHeader.XTableColumn();
				col1.setHeaderValue(INNING + counter);
				col1.setModelIndex(1);
				col1.setHeaderSpan(1);
				columns.addColumn(col1);
				counter++;

			} else {
				TableHeader.XTableColumn colX = new TableHeader.XTableColumn();
				colX.setHeaderValue(INNING + i);
				colX.setHeaderSpan(2);
				colX.setModelIndex(counter);
				columns.addColumn(colX);
				counter++;
				columns.addColumn(new TableColumn(counter));
				counter++;
			}
		}

		Object[][] data = new Object[7][size];
		String[] header = new String[size];

		data[0][0] = "AB"; //$NON-NLS-1$
		data[1][0] = "R"; //$NON-NLS-1$
		data[2][0] = "ER"; //$NON-NLS-1$
		data[3][0] = "H"; //$NON-NLS-1$
		data[4][0] = "A"; //$NON-NLS-1$
		data[5][0] = "E"; //$NON-NLS-1$
		data[6][0] = "LOB"; //$NON-NLS-1$
		header[0] = " "; //$NON-NLS-1$

		int i = 1;
		for (InninStatictic inningStat : inningStats) {
			data[0][i] = convertValue(inningStat.getInningStat().getAtBats());
			data[1][i] = convertValue(inningStat.getInningStat().getRuns());
			data[2][i] = convertValue(inningStat.getInningStat().getEarnedRuns());
			data[3][i] = convertValue(inningStat.getInningStat().getHits());
			data[4][i] = convertValue(inningStat.getInningStat().getAssitances());
			data[5][i] = convertValue(inningStat.getInningStat().getErrors());
			data[6][i] = convertValue(inningStat.getInningStat().getLob());
			i++;

			if (i != 2) {
				data[0][i] = convertValue(inningStat.getCumulativeInningStat().getAtBats());
				data[1][i] = convertValue(inningStat.getCumulativeInningStat().getRuns());
				data[2][i] = convertValue(inningStat.getCumulativeInningStat().getEarnedRuns());
				data[3][i] = convertValue(inningStat.getCumulativeInningStat().getHits());
				data[4][i] = convertValue(inningStat.getCumulativeInningStat().getAssitances());
				data[5][i] = convertValue(inningStat.getCumulativeInningStat().getErrors());
				data[6][i] = convertValue(inningStat.getCumulativeInningStat().getLob());
				i++;
			}
		}

		for (i = 0; i < headerSize; i++) {
			header[i] = " "; //$NON-NLS-1$
		}

		model.setDataVector(data, header);
		table.setColumnModel(columns);

		TableHeader tableHeader = new TableHeader(table);

		scrollPane.setColumnHeaderView(tableHeader);
		table.getColumnModel().getColumn(0).setCellRenderer( (x,value,isSelected,hasFocus,row,column) -> 
		{
			Component component = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table,
					value, false, false, -1, -2);
			((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
			component.setFont(component.getFont().deriveFont(Font.PLAIN));
			return component;
		});

		table.updateUI();
	}

	/** 
	 * Convert value to string ( 0 = - )
	 * 
	 * @param value Value to convert
	 * 
	 * @return String value converted
	 */
	private String convertValue(int value) {

		return (value == 0 ? "-" : "" + value); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public void setFocus() {
		// No Action to do
	}
}
