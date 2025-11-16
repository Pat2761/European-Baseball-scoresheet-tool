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
import java.util.Arrays;
import java.util.HashMap;

import org.bpy.score.club.club.Member;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

/**
 * Page one of the New team wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamPageThreeWizard extends WizardPage implements Listener,SelectionListener {
	/** New umpire button */
	private Button newUmpireBtn;
	/** Remove umpire button */
	private Button removeUmpireBtn;
	/** New Score keeper button */
	private Button addScorekeeperBtn;
	/** Remove Score keeper button */
	private Button removeScorekeeperBtn;
	/** List widget for display the umpires */
	private List umpireList;
	/** List widget for display the score keepers */
	private List scorekeeperList;

	/** Reference on the wizard owner of this page */
	private NewTeamWizard newTeamWizard;
	/** State for first display */
	private boolean firstSetVisible = true;

	/** List of umpires */
	private HashMap<String, Member> definedUmpires;
	/** List of score keepers */
	private HashMap<String, Member> definedScorekeepers;

	/**
	 * Create the wizard.
	 */
	public NewTeamPageThreeWizard() {
		super("NewTeamPageThreeWizard"); //$NON-NLS-1$
		setTitle(Messages.NewTeamPageThreeWizard_PageTitle);
		setDescription(Messages.NewTeamPageThreeWizard_PageDescription);

		definedUmpires = new HashMap<>();
		definedScorekeepers = new HashMap<>();
	}
	
	/** 
	 * Set the reference on the wizard owner of this page. 
	 * 
	 * @param newTeamWizard reference on the wizard owner of this page 
	 */ 
	public void setNewTeamWizard(NewTeamWizard newTeamWizard) {
		this.newTeamWizard = newTeamWizard;
	}


	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		Label lblListeDesArbitres = new Label(container, SWT.NONE);
		lblListeDesArbitres.setBounds(10, 10, 151, 29);
		lblListeDesArbitres.setText(Messages.NewTeamPageThreeWizard_ListOfUmpiresLabel);
		
		Label lblListeDesSoceurs = new Label(container, SWT.NONE);
		lblListeDesSoceurs.setBounds(365, 10, 167, 29);
		lblListeDesSoceurs.setText(Messages.NewTeamPageThreeWizard_ListOfScoreKeepersLabel);
		
		umpireList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		umpireList.setBounds(10, 45, 140, 220);
		umpireList.addListener(SWT.Selection, this);
		
		scorekeeperList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		scorekeeperList.setBounds(365, 45, 140, 220);
		scorekeeperList.addListener(SWT.Selection, this);
		
		newUmpireBtn = new Button(container, SWT.NONE);
		newUmpireBtn.setBounds(156, 45, 182, 25);
		newUmpireBtn.setText(Messages.NewTeamPageThreeWizard_AddUmpireButton);
		newUmpireBtn.addSelectionListener(this);
		
		removeUmpireBtn = new Button(container, SWT.NONE);
		removeUmpireBtn.setText(Messages.NewTeamPageThreeWizard_RemoveUmpireButton);
		removeUmpireBtn.setBounds(156, 76, 182, 25);
		removeUmpireBtn.addSelectionListener(this);
		
		addScorekeeperBtn = new Button(container, SWT.NONE);
		addScorekeeperBtn.setText(Messages.NewTeamPageThreeWizard_AddScoreKeeperButton);
		addScorekeeperBtn.setBounds(511, 53, 173, 25);
		addScorekeeperBtn.addSelectionListener(this);
		
		removeScorekeeperBtn = new Button(container, SWT.NONE);
		removeScorekeeperBtn.setText(Messages.NewTeamPageThreeWizard_RemoveScoreKeepereButton);
		removeScorekeeperBtn.setBounds(511, 89, 173, 25);
		removeScorekeeperBtn.addSelectionListener(this);
	}

	@Override
	public void setVisible(boolean visible) {
		if (firstSetVisible) {
			firstSetVisible = false;
			if (newTeamWizard.getClubDescription() != null) {
				
				defineRoleMembers(umpireList, newTeamWizard.getClubDescription().getUmpires(),definedUmpires);
				defineRoleMembers(scorekeeperList, newTeamWizard.getClubDescription().getScoreKeepers(),definedScorekeepers);
			}
		}

		super.setVisible(visible);
	}

	/**
	 * Define the role members.
	 * 
	 * @param officialList Widget List of officials
	 * @param officials List of officials (umpires or score keepers) in the club
	 * @param memos List of officials (umpires or score keepers) in the page
	 */
	private void defineRoleMembers(List officialList, java.util.List<Member> officials, HashMap<String, Member> memos) {
		
		memos.clear();
		
		for (Member member : officials) {
			memos.put(member.getName(), member);
			officialList.add(member.getName());
		}
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == newUmpireBtn) {
			addNewOfficial(umpireList, definedUmpires, newTeamWizard.getClubDescription().getUmpires());
			
		} else if (e.getSource() == addScorekeeperBtn) {
			addNewOfficial(scorekeeperList, definedScorekeepers, newTeamWizard.getClubDescription().getScoreKeepers());
			
		} else if (e.getSource() == removeUmpireBtn) {
			removeSelectedOfficial(umpireList, definedUmpires, newTeamWizard.getClubDescription().getUmpires());
			
		} else if (e.getSource() == removeScorekeeperBtn) {
			removeSelectedOfficial(scorekeeperList, definedScorekeepers, newTeamWizard.getClubDescription().getScoreKeepers());
		}
	}

	/**
	 * Add a new official
	 * 
	 * @param swtList  Widget List of officials
	 * @param officialsDisplayed List of officials (umpires or score keepers) in the page
	 * @param teamOfficial List of officials (umpires or score keepers) in the club
	 */
	private void addNewOfficial(List swtList, HashMap<String, Member> officialsDisplayed, java.util.List<Member> teamOfficial) {
		ArrayList<String> allreadyDefinedOfficials = new ArrayList<>(officialsDisplayed.keySet());
		HashMap<String, Member> potientalOfficials = new HashMap<>();
		for (Member member : newTeamWizard.getClubDescription().getMembers()) {
			if (!allreadyDefinedOfficials.contains(member.getName())) {
				potientalOfficials.put(member.getName(), member);
			}
		}
		
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(new Shell(), new LabelProvider());
		dialog.setTitle("Ajout d'un nouvel officiel");
		dialog.setElements(potientalOfficials.keySet().toArray(new String[potientalOfficials.size()]));
		if (dialog.open() == Window.OK) {
			String officialName = (String) dialog.getFirstResult();
			if (officialName!= null) {
				Member officialMember = potientalOfficials.get(officialName);
				
				officialsDisplayed.put(officialName, officialMember);
				teamOfficial.add(officialMember);
				
				swtList.add(officialName);
				String[] listOfName = swtList.getItems();
				Arrays.sort(listOfName);
				swtList.setItems(listOfName);
			}
		}
	}

	/**
	 * remove officials
	 * 
	 * @param officialList Widget List of officials
	 * @param definedOfficials List of officials (umpires or score keepers) in the page
	 * @param officials List of officials (umpires or score keepers) in the club
	 */
	private void removeSelectedOfficial(List officialList, HashMap<String, Member> definedOfficials, java.util.List<Member> officials) {
		MessageBox dialog = new MessageBox(new Shell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
		dialog.setText("Suppression de membres");
		dialog.setMessage("Etes vous sur de vouloir supprimer les membres qui ont été sélectionnés");
		if (dialog.open() == SWT.OK) {
			
			for (int selectionIndice : officialList.getSelectionIndices()) {
				
				Member member = definedOfficials.get(officialList.getItem(selectionIndice));
				officials.remove(member);
				definedOfficials.remove(officialList.getItem(selectionIndice));
			}
			officialList.remove(officialList.getSelectionIndices());
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do here
	}

	@Override
	public void handleEvent(Event event) {
		removeUmpireBtn.setEnabled(umpireList.getSelectionCount()>0);
		removeScorekeeperBtn.setEnabled(scorekeeperList.getSelectionCount()>0);
	}
}
