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
	private static final String DATE_FORMAT = "%02d/%02d/%04d";
	/** Time format */
	private static final String TIME_FORMAT = "%02d:%02d";
	
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
	
	/**	Reference on the new game wizard (owner of the page) */
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
	 * get the state page complete (All mandatory value are correctly set).
	 * 
	 * @return <b>true</b> page is complete,<b>false</b> otherwise
	 */
	public boolean getPageCompleted() {
		return getErrorMessage() == null;
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
		return String.format(DATE_FORMAT,datePicker.getDay(),datePicker.getMonth()+1,datePicker.getYear()); 
	}
	
	/**
	 * Get start time value.
	 * 
	 * @return start time value
	 */
	public String getStarttime() {
		return String.format(TIME_FORMAT,startTime.getHours(),startTime.getMinutes());
	}

	/**
	 * Get End time value.
	 * 
	 * @return end time value
	 */
	public String getEndtime() {
		return String.format(TIME_FORMAT,endTime.getHours(),endTime.getMinutes());
	}
	
	/**
	 * Get duration value.
	 * 
	 * @return duration value
	 */
	public String getDuration() {
		return String.format(TIME_FORMAT,duration.getHours(),duration.getMinutes());
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
	 * @return <b>true</b> fill roster with all possible names., <b>false/b> otherwise
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

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL)); //$NON-NLS-1$
		lblNewLabel.setBounds(10, 10, 131, 24);
		lblNewLabel.setText(Messages.NewGamePageOneWizard_GameName);

		gameName = new Text(container, SWT.BORDER);
		gameName.setBounds(147, 10, 152, 22);
		gameName.addModifyListener(this);

		Label lblNewLabelStadium = new Label(container, SWT.NONE);
		lblNewLabelStadium.setBounds(10, 52, 125, 16);
		lblNewLabelStadium.setText(Messages.NewGamePageOneWizard_StadiumName);

		Label lblDate = new Label(container, SWT.NONE);
		lblDate.setBounds(371, 10, 133, 16);
		lblDate.setText("Date :");

		Label lblStartingTable = new Label(container, SWT.NONE);
		lblStartingTable.setText(Messages.NewGamePageOneWizard_StartTime);
		lblStartingTable.setBounds(371, 44, 133, 24);

		Label lblEndingTime = new Label(container, SWT.NONE);
		lblEndingTime.setText(Messages.NewGamePageOneWizard_EndTime);
		lblEndingTime.setBounds(371, 77, 147, 24);

		Label lblPlace = new Label(container, SWT.NONE);
		lblPlace.setText(Messages.NewGamePageOneWizard_TownLocation);
		lblPlace.setBounds(10, 77, 75, 16);

		Label lblDuration = new Label(container, SWT.NONE);
		lblDuration.setText(Messages.NewGamePageOneWizard_GameDuration);
		lblDuration.setBounds(371, 108, 147, 24);

		Label lblType = new Label(container, SWT.NONE);
		lblType.setText(Messages.NewGamePageOneWizard_GameType);
		lblType.setBounds(10, 151, 182, 24);

		datePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
		datePicker.setBounds(598, 10, 125, 24);

		startTime = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
		startTime.setBounds(598, 44, 117, 24);

		endTime = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
		endTime.setBounds(598, 77, 117, 24);

		duration = new DateTime(container, SWT.BORDER | SWT.TIME | SWT.SHORT);
		duration.setBounds(598, 108, 117, 24);

		Label lblEquipeRecevante = new Label(container, SWT.NONE);
		lblEquipeRecevante.setBounds(371, 208, 125, 15);
		lblEquipeRecevante.setText(Messages.NewGamePageOneWizard_HomeTeamName);

		hometeamCombo = new Combo(container, SWT.READ_ONLY);
		hometeamCombo.setBounds(371, 229, 182, 23);
		hometeamCombo.addSelectionListener(this);

		Label lblEquipeVisiteur = new Label(container, SWT.NONE);
		lblEquipeVisiteur.setText(Messages.NewGamePageOneWizard_VisitorTeamName);
		lblEquipeVisiteur.setBounds(371, 151, 125, 16);

		visitingTeamCombo = new Combo(container, SWT.READ_ONLY);
		visitingTeamCombo.setBounds(371, 170, 182, 23);
		visitingTeamCombo.addSelectionListener(this);
		
		baseballBtn = new Button(container, SWT.RADIO);
		baseballBtn.setBounds(10, 181, 90, 24);
		baseballBtn.setText("Baseball"); //$NON-NLS-1$
		
		Button softballBtn = new Button(container, SWT.RADIO);
		softballBtn.setBounds(10, 202, 90, 26);
		softballBtn.setText("Softball"); //$NON-NLS-1$
		
		Label lblCatgorie = new Label(container, SWT.NONE);
		lblCatgorie.setText(Messages.NewGamePageOneWizard_Category);
		lblCatgorie.setBounds(10, 108, 125, 24);
		
		btnCreateFullRoster = new Button(container, SWT.CHECK);
		btnCreateFullRoster.setBounds(370, 267, 196, 16);
		btnCreateFullRoster.setText(Messages.NewGamePageOneWizard_AllPlayersInRoster);
		
		stadium = new Combo(container, SWT.NONE);
		stadium.setBounds(147, 49, 152, 23);
		stadium.addModifyListener(this);
		
		place = new Combo(container, SWT.NONE);
		place.setBounds(147, 77, 152, 23);
		
		categoryTxt = new Combo(container, SWT.NONE);
		categoryTxt.setBounds(147, 105, 152, 23);
		place.addModifyListener(this);
		
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
	@SuppressWarnings("java:S3776")
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
				logger.log(Level.SEVERE,e.getMessage());
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
			setErrorMessage("Le champs 'Catégorie' ne peut pas être vide");
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
				if ( (member instanceof IFile) && (member.getName().toLowerCase().endsWith(".game"))) { //$NON-NLS-1$
					existingGames.add(member.getName().toLowerCase());
				}
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return existingGames;
	}
}
