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
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.club.club.Club;
import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * New game wizard (First page)
 * 
 * @author Patrick BRIAND
 *
 */
public class NewGamePageOneWizard extends WizardPage implements SelectionListener, ModifyListener {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(NewGamePageOneWizard.class.getSimpleName());

   /** Date format */
   private static final String DATE_FORMAT = "%02d/%02d/%04d"; //$NON-NLS-1$
   /** Time format */
   private static final String TIME_FORMAT = "%02d:%02d"; //$NON-NLS-1$

   /** Text widget for the game name */
   private Text gameName;
   /** Combo for select the home team */
   private Combo hometeamCombo;
   /** Combo for select the visitor team */
   private Combo visitingTeamCombo;
   /** Date picker for select the date of the game */
   private DateTime datePicker;
   /** DateTime Widget for select the start time of the game */
   private DateTime startTime;
   /** DateTime Widget for select the end time of the game */
   private DateTime endTime;
   /** DateTime Widget for select the duration of the game */
   private DateTime duration;

   /** Reference on the new game wizard (owner of the page) */
   private NewGameWizard newGameWizard;
   /** List of possible teams in the category */
   private HashMap<String, Club> declaredTeams;
   /** Baseball button */
   private Button baseballBtn;
   /** For set all possible players in the roster of the team */
   private Button btnCreateFullRoster;
   /** Combo for select the stadium */
   private Combo stadium;
   /** Combo for select the towm */
   private Combo place;
   /** Combo for select the category */
   private Combo categoryTxt;

   /** Current categgogry value */
   private String currentCategory;

   /**
    * Create the wizard.
    * 
    * @param currentCategory
    */
   public NewGamePageOneWizard(String currentCategory) {
      super("NewGamePageOneWizard"); //$NON-NLS-1$
      setMessage(Messages.NewGamePageOneWizard_PageOneMessage);
      setTitle(Messages.NewGamePageOneWizard_PageOneTitle);
      setDescription(Messages.NewGamePageOneWizard_PageOneDescription);

      this.currentCategory = currentCategory;
      declaredTeams = new HashMap<>();
   }

   /**
    * Set the reference on the new game wizard (owner of the page)
    * 
    * @param newGameWizard reference on the new game wizard (owner of the page)
    */
   public void setNewGameWizard(NewGameWizard newGameWizard) {
      this.newGameWizard = newGameWizard;
   }

    /**
    * Get game name.
    * 
    * @return game name
    */
   public String getGameName() {
      return gameName.getText();
   }

   /**
    * Get stadium name.
    * 
    * @return stadium name
    */
   public String getStadium() {
      return stadium.getText();
   }

   /**
    * Get place name.
    * 
    * @return place name
    */
   public String getPlace() {
      return place.getText();
   }

   /**
    * Get date value
    * 
    * @return date value
    */
   public String getDate() {
      return String.format(DATE_FORMAT, datePicker.getDay(), datePicker.getMonth() + 1, datePicker.getYear());
   }

   /**
    * Get start time value.
    * 
    * @return start time value
    */
   public String getStarttime() {
      return String.format(TIME_FORMAT, startTime.getHours(), startTime.getMinutes());
   }

   /**
    * Get End time value.
    * 
    * @return end time value
    */
   public String getEndtime() {
      return String.format(TIME_FORMAT, endTime.getHours(), endTime.getMinutes());
   }

   /**
    * Get duration value.
    * 
    * @return duration value
    */
   public String getDuration() {
      return String.format(TIME_FORMAT, duration.getHours(), duration.getMinutes());
   }

   /**
    * Get category value.
    * 
    * @return category value
    */
   public String getCategory() {
      return categoryTxt.getText();
   }

   /**
    * Get Type of game value.
    * 
    * @return type of game value
    */
   public String getGameType() {
      if (baseballBtn.getSelection()) {
         return "baseball"; //$NON-NLS-1$
      } else {
         return "softball"; //$NON-NLS-1$
      }
   }

   /**
    * Get home team name.
    * 
    * @return home team name.
    */
   public Club getHometeam() {
      return declaredTeams.get(hometeamCombo.getItem(hometeamCombo.getSelectionIndex()));
   }

   /**
    * Get visitor name.
    * 
    * @return visitor name.
    */
   public Club getVisitor() {
      return declaredTeams.get(visitingTeamCombo.getItem(visitingTeamCombo.getSelectionIndex()));
   }

   /**
    * Get fill roster with all possible names.
    * 
    * @return <b>true</b> fill roster with all possible names., <b>false/b>
    *         otherwise
    */
   public boolean isFullRoster() {
      return btnCreateFullRoster.getSelection();
   }

   /**
    * Create contents of the wizard.
    * 
    * @param parent
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NONE);

      setControl(container);
      container.setLayout(new GridLayout(6, false));

      Label lblNewLabel = new Label(container, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL)); //$NON-NLS-1$
      lblNewLabel.setText(Messages.NewGamePageOneWizard_GameName);

      gameName = new Text(container, SWT.BORDER);
      gameName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      gameName.addModifyListener(this);
      
      Label lblNewLabelEmpty = new Label(container, SWT.NONE);
      lblNewLabelEmpty.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
      lblNewLabelEmpty.setText(" "); //$NON-NLS-1$

      Label lblDate = new Label(container, SWT.NONE);
      lblDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblDate.setText(Messages.NewGamePageOneWizard_DateLabel);

      datePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
      datePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      new Label(container, SWT.NONE);

      Label lblNewLabelStadium = new Label(container, SWT.NONE);
      lblNewLabelStadium.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblNewLabelStadium.setText(Messages.NewGamePageOneWizard_StadiumName);

      stadium = new Combo(container, SWT.NONE);
      stadium.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      stadium.addModifyListener(this);
      new Label(container, SWT.NONE);

      Label lblStartingTable = new Label(container, SWT.NONE);
      lblStartingTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblStartingTable.setText(Messages.NewGamePageOneWizard_StartTime);

      startTime = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
      startTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      new Label(container, SWT.NONE);

      Label lblPlace = new Label(container, SWT.NONE);
      lblPlace.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblPlace.setText(Messages.NewGamePageOneWizard_TownLocation);

      place = new Combo(container, SWT.NONE);
      place.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      place.addModifyListener(this);
      new Label(container, SWT.NONE);

      Label lblEndingTime = new Label(container, SWT.NONE);
      lblEndingTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblEndingTime.setText(Messages.NewGamePageOneWizard_EndTime);

      endTime = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
      endTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      new Label(container, SWT.NONE);

      Label lblCatgorie = new Label(container, SWT.NONE);
      lblCatgorie.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblCatgorie.setText(Messages.NewGamePageOneWizard_Category);

      categoryTxt = new Combo(container, SWT.NONE);
      categoryTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      new Label(container, SWT.NONE);

      Label lblDuration = new Label(container, SWT.NONE);
      lblDuration.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblDuration.setText(Messages.NewGamePageOneWizard_GameDuration);

      duration = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
      duration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      Label lblType = new Label(container, SWT.NONE);
      lblType.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
      lblType.setText(Messages.NewGamePageOneWizard_GameType);
      new Label(container, SWT.NONE);

      Label lblEquipeVisiteur = new Label(container, SWT.NONE);
      lblEquipeVisiteur.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblEquipeVisiteur.setText(Messages.NewGamePageOneWizard_VisitorTeamName);

      visitingTeamCombo = new Combo(container, SWT.READ_ONLY);
      visitingTeamCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
      visitingTeamCombo.addSelectionListener(this);

      baseballBtn = new Button(container, SWT.RADIO);
      baseballBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      baseballBtn.setText("Baseball"); //$NON-NLS-1$
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      Label lblEquipeRecevante = new Label(container, SWT.NONE);
      lblEquipeRecevante.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblEquipeRecevante.setText(Messages.NewGamePageOneWizard_HomeTeamName);

      hometeamCombo = new Combo(container, SWT.READ_ONLY);
      hometeamCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
      hometeamCombo.addSelectionListener(this);

      Button softballBtn = new Button(container, SWT.RADIO);
      softballBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      softballBtn.setText("Softball"); //$NON-NLS-1$
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      
            btnCreateFullRoster = new Button(container, SWT.CHECK);
            btnCreateFullRoster.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
            btnCreateFullRoster.setText(Messages.NewGamePageOneWizard_AllPlayersInRoster);

      checkPageCompleted();
   }

   @Override
   public void setVisible(boolean visible) {

      List<Club> clubs = newGameWizard.getClubDataParser().getDeclaredTeamsForCategory(currentCategory);
      List<Game> games = newGameWizard.getGameDataParser().getGames();
      List<String> categories = getPossiblesCatagory(games);

      for (String possibleCategory : categories) {
         categoryTxt.add(possibleCategory);
      }
      if (!categories.isEmpty()) {
         categoryTxt.setText(categories.get(0));
      }

      declaredTeams.clear();
      ArrayList<String> sortedKeys = new ArrayList<>();

      for (Club club : clubs) {

         String key = club.getClubDescription().getName() + " (" + club.getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
         declaredTeams.put(key, club);
         sortedKeys.add(key);
      }

      Collections.sort(sortedKeys);
      for (String key : sortedKeys) {
         hometeamCombo.add(key);
      }
      for (String key : sortedKeys) {
         visitingTeamCombo.add(key);
      }

      List<String> stadiums = newGameWizard.getGameDataParser().getStadiums();
      List<String> places = newGameWizard.getGameDataParser().getTowns();

      Collections.sort(stadiums);
      Collections.sort(places);

      for (String currentStadium : stadiums) {
         stadium.add(currentStadium);
      }
      for (String currentPlace : places) {
         place.add(currentPlace);
      }

      super.setVisible(visible);
   }

   /**
    * Get all the possibles categories.
    * 
    * @param games List of games
    * 
    * @return all the possibles categories
    */
   private List<String> getPossiblesCatagory(List<Game> games) {
      List<String> categories = new ArrayList<>();
      for (Game game : games) {
         if (!categories.contains(game.getDescription().getCategory())) {
            categories.add(game.getDescription().getCategory());
         }
      }
      return categories;
   }

   @Override
   public void widgetSelected(SelectionEvent e) {
      checkPageCompleted();
   }

   @Override
   public void widgetDefaultSelected(SelectionEvent e) {
      // Nothing to do here
   }

   @Override
   public void modifyText(ModifyEvent e) {
      checkPageCompleted();
   }

   /**
    * Check that all fields are correctly set.
    * 
    */
   private void checkPageCompleted() {
      if (gameName.getText().isBlank()) {
         setErrorMessage(Messages.NewGamePageOneWizard_EmptyGameNameError);
         setPageComplete(false);
         return;
      } else {
         try {
            for (IResource member : newGameWizard.getCurrentFolder().members()) {
               String memberName = member.getLocation().toFile().getName();
               if ((member instanceof IFile) && memberName.equalsIgnoreCase(gameName.getText() + ".game")) { //$NON-NLS-1$
                  setErrorMessage(NLS.bind(Messages.NewGamePageOneWizard_DuplicateGameNameError, gameName.getText()));
                  setPageComplete(false);
                  return;
               }
            }
         } catch (CoreException e) {
            logger.log(Level.SEVERE, e.getMessage());
         }
      }

      List<String> matchDefined = getListOFMatchs(newGameWizard.getCurrentFolder());
      if (matchDefined.contains(gameName.getText().toLowerCase())) {
         setErrorMessage(NLS.bind(Messages.NewGamePageOneWizard_DuplicateGameNameInCategoryError, gameName.getText()));
         setPageComplete(false);
         return;
      }

      if (stadium.getText().isBlank()) {
         setErrorMessage(Messages.NewGamePageOneWizard_EmptyStadiumNameError);
         setPageComplete(false);
         return;
      }

      if (place.getText().isBlank()) {
         setErrorMessage(Messages.NewGamePageOneWizard_EmptyTownNameError);
         setPageComplete(false);
         return;
      }

      if (categoryTxt.getText().isBlank()) {
         setErrorMessage(Messages.NewGamePageOneWizard_EmptyCategoryFileError);
         setPageComplete(false);
         return;
      }

      if (visitingTeamCombo.getText().isEmpty() || hometeamCombo.getText().isEmpty()) {
         setErrorMessage(Messages.NewGamePageOneWizard_MissingTeamSelectionError);
         setPageComplete(false);
         return;
      }

      if (visitingTeamCombo.getText().equals(hometeamCombo.getText())) {
         setErrorMessage(Messages.NewGamePageOneWizard_DuplicateTeamSelectionError);
         setPageComplete(false);
         return;
      }

      setErrorMessage(null);
      setPageComplete(true);
   }

   /**
    * Get the of game in a folder.
    * 
    * @param currentFolder Folder to check
    * 
    * @return List of game
    */
   private List<String> getListOFMatchs(IFolder currentFolder) {
      List<String> existingGames = new ArrayList<>();
      try {
         for (IResource member : currentFolder.members()) {
            if ((member instanceof IFile) && (member.getName().toLowerCase().endsWith(".game"))) { //$NON-NLS-1$
               existingGames.add(member.getName().toLowerCase());
            }
         }
      } catch (CoreException e) {
         logger.log(Level.SEVERE, e.getMessage());
      }
      return existingGames;
   }
}
