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
package org.bpy.score.rcp.wizard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.club.Club;
import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.containers.SearchGameContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Page one of the search function by date
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameByDateWizardPageOne extends WizardPage implements SelectionListener {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(SearchGameByDateWizardPageOne.class.getSimpleName());
	
	/** End DateTime picker widget */
	private DateTime endDatePicker;
	/** Start DateTime picker widget */
	private DateTime startDatePicker;
	/** Table which contains games */
	private Table table;
	/** State of the page */
	private boolean canFinish;
	/** Current selected category */ 
	private String currentCategory;
	
	/** Reference to the owner of the page */
	private SearchGameByDateWizard searchGameForDateWizard;
	
	/** List of game search container */
	private List<SearchGameContainer> gamesContainer;
	/** List of games by date */
	private HashMap<Date,List<Game>> gamesByDate;
	
	/**
	 * Create the wizard.
	 * 
	 * @param searchGameForDateWizard Reference to the owner of the page 
	 * @param currentCategory Current selected category
	 */
	public SearchGameByDateWizardPageOne(SearchGameByDateWizard searchGameForDateWizard, String currentCategory) {
		super("wizardPage"); //$NON-NLS-1$
		setMessage(Messages.SearchGameByDateWizardPageOne_PageMessage);
		setTitle(Messages.SearchGameByDateWizardPageOne_PageTitle);
		setDescription(Messages.SearchGameByDateWizardPageOne_PageDescription);
		
		this.searchGameForDateWizard = searchGameForDateWizard;
		this.currentCategory = currentCategory;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent reference to the parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		startDatePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
		startDatePicker.setBounds(20, 37, 80, 24);
		
		Label lblDbutDeLa = new Label(container, SWT.NONE);
		lblDbutDeLa.setBounds(20, 16, 138, 15);
		lblDbutDeLa.setText(Messages.SearchGameByDateWizardPageOne_StartDateLabel);
		
		Label lblFinDeLa = new Label(container, SWT.NONE);
		lblFinDeLa.setText(Messages.SearchGameByDateWizardPageOne_EndDateLabel);
		lblFinDeLa.setBounds(333, 16, 138, 15);
		
		endDatePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
		endDatePicker.setBounds(333, 37, 80, 24);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 84, 544, 225);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addSelectionListener(this);
		
		TableColumn tblclmnDate = new TableColumn(table, SWT.NONE);
		tblclmnDate.setWidth(100);
		tblclmnDate.setText(Messages.SearchGameByDateWizardPageOne_DateColumnTable);
		
		TableColumn tblclmnCode = new TableColumn(table, SWT.NONE);
		tblclmnCode.setWidth(100);
		tblclmnCode.setText(Messages.SearchGameByDateWizardPageOne_CodeColumnTable);
		
		TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
		tblclmnDescription.setWidth(341);
		tblclmnDescription.setText(Messages.SearchGameByDateWizardPageOne_DescriptionColumnTable);
		
		checkPageCompleted();
	}

	/**
	 * Check that the page is correctly fill
	 */
	private void checkPageCompleted() {
		if (table.getSelectionIndex() <0) {
			setErrorMessage(Messages.SearchGameByDateWizardPageOne_MissingGameSelectionError);
			setPageComplete(false);
			canFinish = false;
			return;
		}
		
		canFinish = true;
		setErrorMessage(null);
		setPageComplete(true);
	}

	@Override
	public void setVisible(boolean visible) {
		
		List<Club> clubs = searchGameForDateWizard.getClubDataParser().getDeclaredTeamsForCategory(currentCategory);
		List<Game> games = searchGameForDateWizard.getGameDataParser().getGames();
		
		gamesByDate = new HashMap<>();

		HashMap<String, Club> clubsDescriptions = new HashMap<>();
		for (Club club : clubs) {
			
			String clubDesc = club.getClubDescription().getName() + " (" + club.getName() + ")"; //$NOn-NLS-1$  //$NOn-NLS-2$ //$NON-NLS-1$ //$NON-NLS-2$
			clubsDescriptions.put(clubDesc, club);
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NOn-NLS-1$ //$NON-NLS-1$
		for (Game game : games) {
			String strDate = game.getDescription().getDate();
			try {
				Date gameDate = dateFormat.parse(strDate);
				if(gamesByDate.containsKey(gameDate)) {
					List<Game> localGames = gamesByDate.get(gameDate);
					localGames.add(game);
					
				} else {
					List<Game> localGames = new ArrayList<>();
					localGames.add(game);
					gamesByDate.put(gameDate,games);
				}
			
			} catch (ParseException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		
		initDateLimits();
		updateTable();
		
		super.setVisible(visible);
	}
	
	/**
	 * Update table display
	 */
	private void updateTable() {
		Date startDate = getDate(startDatePicker,false);
		Date endDate = getDate(endDatePicker,true);
		table.removeAll();
		
		List<Date> dates = new ArrayList<>(gamesByDate.keySet());
		Collections.sort(dates);
		gamesContainer = new ArrayList<>();
		for (Date date : dates) {
			if ( (date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <=0)) {

				List<Game> gamesForDate = gamesByDate.get(date);

				for (Game game : gamesForDate) {

					String hometeamName = game.getHometeam().getName();
					String visitorName = game.getVisitor().getName();
					
					SearchGameContainer searchGameContainer = new SearchGameContainer();
					searchGameContainer.setPlace(game.getDescription().getPlace());
					searchGameContainer.setCode(game.getName());
					searchGameContainer.setDateTime(game.getDescription().getDate() + " " + game.getDescription().getStartTime()); //$NON-NLS-1$ 
					searchGameContainer.setDescription(hometeamName + " vs " + visitorName); //$NON-NLS-1$
					searchGameContainer.setGame(game);
					gamesContainer.add(searchGameContainer);
					
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(new String[] {searchGameContainer.getDateTime(), searchGameContainer.getCode(), searchGameContainer.getDescription()});
				}
			}
		}
	}

	/**
	 * Get selected date.
	 * 
	 * @param datePicker reference to the date picker widget
	 * @param untilEndOfDay Flag for taking into accoutn the current day 
	 * 
	 * @return data value
	 */
	private Date getDate(DateTime datePicker, boolean untilEndOfDay) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, datePicker.getYear());
		cal.set(Calendar.MONTH, datePicker.getMonth());
		cal.set(Calendar.DAY_OF_MONTH, datePicker.getDay());
		
		if (untilEndOfDay) {
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
		}
		
		return cal.getTime();
	}

	/**
	 * Initialisation of the limits 
	 */
	private void initDateLimits() {
		List<Date> dates = new ArrayList<>(gamesByDate.keySet());
		Collections.sort(dates);
		int endPosition = dates.size()-1;
		
		Date startDate = dates.get(0);
		Date endDate = dates.get(endPosition);
		
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		
		startDatePicker.setDate(startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH)+1, startCalendar.get(Calendar.DAY_OF_MONTH));
		endDatePicker.setDate(endCalendar.get(Calendar.YEAR), endCalendar.get(Calendar.MONTH)+1, endCalendar.get(Calendar.DAY_OF_MONTH));

		startDatePicker.addSelectionListener(this);
		endDatePicker.addSelectionListener(this);
	}

	/**
	 * Return the state of the page
	 * 
	 * @return <b>true</b> the page is correctly fill,<b>false</b> otherwise
	 */
	public boolean canFinish() {
		return canFinish;
	}

	/**
	 * Get the selected game.
	 * 
	 * @return Selected game
	 */
	public Game getSelectedGame() {
		int selectedIndex = table.getSelectionIndex();
		if (selectedIndex >= 0) {
			String gameName = table.getItem(selectedIndex).getText(1);
			
			for (SearchGameContainer gameContainer : gamesContainer) {
				if (gameContainer.getCode().equals(gameName)) {
					return gameContainer.getGame();
				}
			}
			
		}
		return null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if ( (e.getSource() == startDatePicker) || (e.getSource() == endDatePicker)) {
			updateTable();
		}
		checkPageCompleted(); 
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Not used
	}
}
