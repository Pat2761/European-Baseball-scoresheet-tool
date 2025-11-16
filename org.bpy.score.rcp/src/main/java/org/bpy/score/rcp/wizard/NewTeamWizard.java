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
import java.util.List;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;

/**
 * This class is a wizard for create a new tournament in the workspace.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamWizard extends Wizard {

	/** Reference on the first page of the wizard */
	private NewTeamPageOneWizard newTeamPageOneWizard;
	/** Reference on the third page of the wizard */
	private NewTeamPageThreeWizard newTeamPageThreeWizard;

	/** City name of the club */
	private String cityName;
	/** Club name */
	private String clubName;
	/** List of categories in the club */
	private List<String> categories;

	/** Current selected folder */
	private IFolder currentFolder;
	
	/** Reference on club utility class */
	private ClubDataParser clubsAlreadyDefined;

	/** Reference on club utility class */
	private ClubDataParser clubDescription;
	
	/** Counter for category page */ 
	private int categoryPageCounter;

	/**
	 * Constructor of the class
	 * 
	 * @param container Where to create the club
	 */
	public NewTeamWizard(IFolder container) {
		setWindowTitle(Messages.NewTeamWizard_Title);
		this.currentFolder = container;

		clubsAlreadyDefined = new ClubDataParser();
		clubsAlreadyDefined.parseData(container);

		clubDescription = new ClubDataParser();
	}

	/**
	 * Get club description.
	 * 
	 * @return club description
	 */
	public ClubDataParser getClubDescription() {
		return clubDescription;
	}

	/**
	 * Set club description.
	 * 
	 * @param clubDescription club description
	 */
	public void setClubDescription(ClubDataParser clubDescription) {
		this.clubDescription = clubDescription;
	}

	@Override
	public void addPages() {

		ClubDataParser clubDataParser = new ClubDataParser();
		clubDataParser.parseData( currentFolder);

		newTeamPageOneWizard = new NewTeamPageOneWizard();
		newTeamPageOneWizard.setNewTeamWizard(this);
		newTeamPageOneWizard.setCurrentFolder(currentFolder);
		newTeamPageOneWizard.setClubsDescription(clubsAlreadyDefined);
		addPage(newTeamPageOneWizard);

		NewTeamPageTwoWizard newTeamPageTwoWizard = new NewTeamPageTwoWizard();
		newTeamPageTwoWizard.setNewTeamWizard(this);
		addPage(newTeamPageTwoWizard);

		newTeamPageThreeWizard = new NewTeamPageThreeWizard();
		newTeamPageThreeWizard.setNewTeamWizard(this);
		addPage(newTeamPageThreeWizard);

		categoryPageCounter = 0;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {

		categories = new ArrayList<>(newTeamPageOneWizard.getCategories());

		if (page == newTeamPageThreeWizard) {

			if (categoryPageCounter < categories.size()) {
				NewTeamPageCategoryWizard newTeamPageCategoryWizard = new NewTeamPageCategoryWizard();
				newTeamPageCategoryWizard.setTitle(NLS.bind(Messages.NewTeamWizard_PlayerInCategoryPageTitle, categories.get(categoryPageCounter)));
				newTeamPageCategoryWizard.setMessage(NLS.bind(Messages.NewTeamWizard_PlayerInCategoryPageDescription, categories.get(categoryPageCounter)));
				newTeamPageCategoryWizard.setPageComplete(true);
				newTeamPageCategoryWizard.setCategoryName(categories.get(categoryPageCounter));
				newTeamPageCategoryWizard.setNewTeamWizard(this);
				categoryPageCounter = 1;
				addPage(newTeamPageCategoryWizard);
			}

		} else if (page instanceof NewTeamPageCategoryWizard) {

			if (categoryPageCounter < categories.size() - 1) {
				NewTeamPageCategoryWizard newTeamPageCategoryWizard = new NewTeamPageCategoryWizard();
				newTeamPageCategoryWizard.setTitle(NLS.bind(Messages.NewTeamWizard_PlayerInCategoryPageTitle, categories.get(categoryPageCounter)));
				newTeamPageCategoryWizard.setMessage(NLS.bind(Messages.NewTeamWizard_PlayerInCategoryPageDescription, categories.get(categoryPageCounter)));
				newTeamPageCategoryWizard.setPageComplete(true);
				newTeamPageCategoryWizard.setCategoryName(categories.get(categoryPageCounter));
				newTeamPageCategoryWizard.setNewTeamWizard(this);
				categoryPageCounter++;
				addPage(newTeamPageCategoryWizard);

			} else {
				/* pas d'autres pages */
			}
		}

		return super.getNextPage(page);
	}

	@Override
	public boolean canFinish() {
		return newTeamPageOneWizard.isPageComplete();
	}

	@Override
	public boolean performFinish() {
		cityName = newTeamPageOneWizard.getCityName();
		clubName = newTeamPageOneWizard.getClubName();

		categories = new ArrayList<>(newTeamPageOneWizard.getCategories());
		clubDescription.setCityName(cityName);
		clubDescription.setClubName(clubName);
		return true;
	}

	/**
	 * Get club name.
	 * 
	 * @return club name
	 */
	public String getClubName() {
		return clubName;
	}
	
	/**
	 * Get city name.
	 * 
	 * @return city name
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Get the list of categories
	 * 
	 * @return list of categories.
	 */
	public List<String> getCategories() {
		return categories;
	}
}
