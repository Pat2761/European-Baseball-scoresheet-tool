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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.bpy.score.club.club.Club;
import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.rcp.containers.SearchGameContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Page one of the search function by team
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameForTeamWizardPageOne extends WizardPage implements SelectionListener {
	
	/** Table widget for list game */
	private Table table;
	
	/** Reference to the owner of the page */
	private SearchGameForTeamWizard searchGameForTeamWizard;
	/** Current selected category */
	private String currentCategory;
	/** Combo widget for display the list of teams */
	private Combo clubsCombo;
	
	/** List of clubs */
	private HashMap<String,Club> clubsDescriptions;
	/** List of search game container */
	private List<SearchGameContainer> gamesContainer;
	/** List of games */
	private List<Game> games;
	
	/** State of the page */
	private boolean canFinish;
	
	/**
	 * Create the wizard.
	 * 
	 * @param searchGameForTeamWizard Reference to the owner of the page
	 * @param currentCategory Current selected category
	 */
	public SearchGameForTeamWizardPageOne(SearchGameForTeamWizard searchGameForTeamWizard, String currentCategory) {
		super("wizardPage"); //$NON-NLS-1$
		setTitle(Messages.SearchGameForTeamWizardPageOne_PageTitle);
		setDescription(Messages.SearchGameForTeamWizardPageOne_PageDescription);
		setMessage(Messages.SearchGameForTeamWizardPageOne_PageMessage);
		
		this.searchGameForTeamWizard = searchGameForTeamWizard;
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
		
		Label lblSlectionDeLquipe = new Label(container, SWT.NONE);
		lblSlectionDeLquipe.setBounds(10, 10, 160, 15);
		lblSlectionDeLquipe.setText(Messages.SearchGameForTeamWizardPageOne_TeamSelectionLabel);
		
		clubsCombo = new Combo(container, SWT.NONE);
		clubsCombo.setBounds(10, 31, 190, 23);
		clubsCombo.addSelectionListener(this);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 65, 220, 15);
		lblNewLabel.setText(Messages.SearchGameForTeamWizardPageOne_GamesPlayByTeam);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 86, 633, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addSelectionListener(this);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText(Messages.SearchGameForTeamWizardPageOne_DateColumnTable);
		
		TableColumn tblclmnHeure = new TableColumn(table, SWT.NONE);
		tblclmnHeure.setWidth(100);
		tblclmnHeure.setText(Messages.SearchGameForTeamWizardPageOne_NumberColumnTable);
		
		TableColumn tblclmnLieu = new TableColumn(table, SWT.NONE);
		tblclmnLieu.setWidth(100);
		tblclmnLieu.setText(Messages.SearchGameForTeamWizardPageOne_LocationColumnTable);
		
		TableColumn tblclmnNewColumn1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn1.setWidth(400);
		tblclmnNewColumn1.setText(Messages.SearchGameForTeamWizardPageOne_DescriptionColumnTable);
		
		checkPageCompleted();
		setPageComplete(false);
	}

	/**
	 * Check that the page is correctly fill
	 */
	private void checkPageCompleted() {
		if (clubsCombo.getText().isBlank() || clubsCombo.getText() == null) {
			setErrorMessage(Messages.SearchGameForTeamWizardPageOne_NoTeamSelectionError);
			setPageComplete(false);
			canFinish = false;
			return;
		}
		
		if (table.getSelectionIndex() < 0) {
			setErrorMessage(Messages.SearchGameForTeamWizardPageOne_NoGameSelectionError);
			setPageComplete(false);
			canFinish = false;
			return;
		}
		
		canFinish = true;

		setPageComplete(true);
		setErrorMessage(null);
	}

	@Override
	public void setVisible(boolean visible) {
		
		List<Club> clubs = searchGameForTeamWizard.getClubDataParser().getDeclaredTeamsForCategory(currentCategory);
		games = searchGameForTeamWizard.getGameDataParser().getGames();

		clubsDescriptions = new HashMap<>();
		for (Club club : clubs) {
			
			String clubDesc = club.getClubDescription().getName() + " (" + club.getName() + ")";  //$NON-NLS-1$ //$NON-NLS-2$
			clubsDescriptions.put(clubDesc, club);
		}
		
		List<String> clubNames = new ArrayList<>(clubsDescriptions.keySet());
		Collections.sort(clubNames);
		
		for (String clubName : clubNames) {
			clubsCombo.add(clubName);
		}
		
		super.setVisible(visible);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == clubsCombo) {
			String selection = clubsCombo.getText();
			Club club = clubsDescriptions.get(selection);
			
			searchForMatch(club);
		}
		checkPageCompleted();

	}

	/**
	 * Search game played by a team.
	 * 
	 * @param club reference on the team
	 */
	private void searchForMatch(Club club) {
		gamesContainer = new ArrayList<>();
		for (Game game : games) {
			String hometeamName = game.getHometeam().getName();
			String visitorName = game.getVisitor().getName();
			
			String clubTownName = club.getClubDescription().getName();
			
			if (hometeamName.equals(clubTownName) || visitorName.equals(clubTownName)) {
				SearchGameContainer searchGameContainer = new SearchGameContainer();
				searchGameContainer.setPlace(game.getDescription().getPlace());
				searchGameContainer.setCode(game.getName());
				searchGameContainer.setDateTime(game.getDescription().getDate() + " " + game.getDescription().getStartTime()); //$NON-NLS-1$
				searchGameContainer.setDescription(hometeamName + " vs " + visitorName); //$NON-NLS-1$
				searchGameContainer.setGame(game);
				gamesContainer.add(searchGameContainer);
			}
		}
		
		Collections.sort(gamesContainer);
		table.removeAll();
		
		for (SearchGameContainer gameContainer : gamesContainer) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {gameContainer.getDateTime(), gameContainer.getCode(), gameContainer.getPlace() , gameContainer.getDescription()});
		}
	}

	/**
	 * Get the selected game
	 * 
	 * @return selected game
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
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do here
	}

	/**
	 * Return the state of the page
	 * 
	 * @return <b>true</b> the page is correctly fill,<b>false</b> otherwise
	 */
	public boolean canFinish() {
		return canFinish;
	}
	
}
