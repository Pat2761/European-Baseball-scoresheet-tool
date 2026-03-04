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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * Page one of the search function by team
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameForTeamWizardPageOne extends WizardPage {

   /** Table widget for list game */
   private Table table;

   /** Reference to the owner of the page */
   private SearchGameForTeamWizard searchGameForTeamWizard;
   /** Current selected category */
   private String currentCategory;
   /** Combo widget for display the list of teams */
   private Combo clubsCombo;

   /** List of clubs */
   private HashMap<String, Club> clubsDescriptions;
   /** List of search game container */
   private List<SearchGameContainer> gamesContainer;
   /** List of games */
   private List<Game> games;

   /**
    * Create the wizard.
    * 
    * @param searchGameForTeamWizard Reference to the owner of the page
    * @param currentCategory         Current selected category
    */
   public SearchGameForTeamWizardPageOne(SearchGameForTeamWizard searchGameForTeamWizard, String currentCategory) {
      super("SearchGameForTeamWizardPageOne"); //$NON-NLS-1$
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
      container.setLayout(new GridLayout(2, false));

      Label lblSlectionDeLquipe = new Label(container, SWT.NONE);
      lblSlectionDeLquipe.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblSlectionDeLquipe.setText(Messages.SearchGameForTeamWizardPageOne_TeamSelectionLabel);
      new Label(container, SWT.NONE);

      clubsCombo = new Combo(container, SWT.NONE);
      clubsCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      clubsCombo.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            String selection = clubsCombo.getText();
            Club club = clubsDescriptions.get(selection);

            searchForMatch(club);
            checkPageCompleted();
         }
      });
      new Label(container, SWT.NONE);

      Label lblNewLabel = new Label(container, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblNewLabel.setText(Messages.SearchGameForTeamWizardPageOne_GamesPlayByTeam);
      
      Label lblNewLabel1 = new Label(container, SWT.NONE);
      lblNewLabel1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
      lblNewLabel1.setText(" "); //$NON-NLS-1$

      table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
      GridData gdTable = new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1);
      gdTable.widthHint = 701;
      table.setLayoutData(gdTable);
      table.setHeaderVisible(true);
      table.setLinesVisible(true);
      table.addListener(SWT.MouseDoubleClick, e -> {

         if (getWizard().getContainer() instanceof WizardDialog dialog) {
            Button finishButton = dialog.getShell().getDefaultButton();

            if (finishButton != null && !finishButton.isDisposed()) {
               finishButton.notifyListeners(SWT.Selection, new Event());
            }
         }
      });

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
         return;
      }

      if (table.getSelectionIndex() < 0) {
         setErrorMessage(Messages.SearchGameForTeamWizardPageOne_NoGameSelectionError);
         setPageComplete(false);
         return;
      }

      setPageComplete(true);
      setErrorMessage(null);
   }

   @Override
   public void setVisible(boolean visible) {

      List<Club> clubs = searchGameForTeamWizard.getClubDataParser().getDeclaredTeamsForCategory(currentCategory);
      games = searchGameForTeamWizard.getGameDataParser().getGames();

      clubsDescriptions = new HashMap<>();
      for (Club club : clubs) {

         String clubDesc = club.getClubDescription().getName() + " (" + club.getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
         clubsDescriptions.put(clubDesc, club);
      }

      List<String> clubNames = new ArrayList<>(clubsDescriptions.keySet());
      Collections.sort(clubNames);

      for (String clubName : clubNames) {
         clubsCombo.add(clubName);
      }

      super.setVisible(visible);
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
            searchGameContainer.setDateTime(game.getDescription().getDate()); //$NON-NLS-1$
            searchGameContainer.setDescription(hometeamName + " vs " + visitorName); //$NON-NLS-1$
            searchGameContainer.setGame(game);
            gamesContainer.add(searchGameContainer);
         }
      }

      Collections.sort(gamesContainer);
      table.removeAll();

      for (SearchGameContainer gameContainer : gamesContainer) {
         TableItem item = new TableItem(table, SWT.NONE);
         item.setText(new String[] { gameContainer.getDateTime(), gameContainer.getCode(), gameContainer.getPlace(), gameContainer.getDescription() });
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

}
