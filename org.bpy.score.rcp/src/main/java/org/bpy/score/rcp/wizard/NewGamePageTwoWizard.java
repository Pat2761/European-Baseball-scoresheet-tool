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
import java.util.Map.Entry;

import org.bpy.score.club.club.Member;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.swt.widgets.Button;

/**
 * New game wizard (Second page)
 * 
 * @author Patrick BRIAND
 *
 */
public class NewGamePageTwoWizard extends WizardPage implements SelectionListener {

	/** widget list of selected umpires */
	private List umpireList;
	/** Button widget for add new umpire */
	private Button newUmpireBtn;
	/** Button widget for remove an umpire */
	private Button removeUmpireBtn;
	/** Button widget for create an umpire */
	private Button createNewUmpire;

	/** widget list of selected score keeper */
	private List scorekeeperList;
	/** Button widget for add new score keeper */
	private Button newScoreKeeperBtn;
	/** Button widget for remove an score keeper */
	private Button removeScoreKeeperBtn;
	/** Button widget for create a Score keeper */
	private Button createNewScorekeeper;

	/** Collection of score keepers */
	private HashMap<String, Member> declaredScoreKeepers;
	/** Collection of umpires */
	private HashMap<String, Member> declaredUmpires;
	
	

	/**
	 * Create the wizard.
	 */
	public NewGamePageTwoWizard() {
		super("NewGamePageTwoWizard");  //$NON-NLS-1$
		setTitle(Messages.NewGamePageTwoWizard_PageTitle);
		setDescription(Messages.NewGamePageTwoWizard_PageDescription);
		setMessage(Messages.NewGamePageTwoWizard_PageMessage);
		
		declaredScoreKeepers = new HashMap<>();
		declaredUmpires = new HashMap<>();
	}
	
	/**
	 * Get list of selected umpires.
	 * 
	 * @return list of selected umpires.
	 */
	public String[] getSelectedUmpires() {
		return umpireList.getItems();
	}

	/**
	 * Get list of selected score keepers.
	 * 
	 * @return list of selected score keepers.
	 */
	public String[] getSelectedScorekeepers() {
		return scorekeeperList.getItems();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		Label lblListeDesArbitres = new Label(container, SWT.NONE);
		lblListeDesArbitres.setBounds(20, 10, 149, 23);
		lblListeDesArbitres.setText(Messages.NewGamePageTwoWizard_ListOfUmpiresLabel);
		
		umpireList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		umpireList.setBounds(20, 39, 225, 111);
		umpireList.addSelectionListener(this);
		
		newUmpireBtn = new Button(container, SWT.NONE);
		newUmpireBtn.setBounds(251, 38, 245, 25);
		newUmpireBtn.setText(Messages.NewGamePageTwoWizard_AddUmpireButton);
		newUmpireBtn.addSelectionListener(this);
		
		removeUmpireBtn = new Button(container, SWT.NONE);
		removeUmpireBtn.setEnabled(false);
		removeUmpireBtn.setBounds(251, 74, 245, 25);
		removeUmpireBtn.setText(Messages.NewGamePageTwoWizard_RemoveUmpiresButton);
		removeUmpireBtn.addSelectionListener(this);
		
		createNewUmpire = new Button(container, SWT.NONE);
		createNewUmpire.setBounds(251, 109, 245, 25);
		createNewUmpire.setText(Messages.NewGamePageTwoWizard_DeclareNewUmpireButton);
		createNewUmpire.addSelectionListener(this);
		
		Label scorekeeperBtn = new Label(container, SWT.NONE);
		scorekeeperBtn.setText(Messages.NewGamePageTwoWizard_ListOfScoreKeepersLabel);
		scorekeeperBtn.setBounds(20, 163, 149, 23);
		
		scorekeeperList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		scorekeeperList.setBounds(20, 192, 225, 111);
		scorekeeperList.addSelectionListener(this);
		scorekeeperList.addSelectionListener(this);
		
		newScoreKeeperBtn = new Button(container, SWT.NONE);
		newScoreKeeperBtn.setText(Messages.NewGamePageTwoWizard_AddScoreKeeperButton);
		newScoreKeeperBtn.setBounds(251, 191, 245, 25);
		newScoreKeeperBtn.addSelectionListener(this);
		
		removeScoreKeeperBtn = new Button(container, SWT.NONE);
		removeScoreKeeperBtn.setEnabled(false);
		removeScoreKeeperBtn.setText(Messages.NewGamePageTwoWizard_RemoveScoreKeepersButton);
		removeScoreKeeperBtn.setBounds(251, 227, 245, 25);
		
		createNewScorekeeper = new Button(container, SWT.NONE);
		createNewScorekeeper.setText(Messages.NewGamePageTwoWizard_DeclareNewScoreKeeperButton);
		createNewScorekeeper.setBounds(251, 262, 245, 25);
		createNewScorekeeper.addSelectionListener(this);

		checkPageCompleted();
	}

	/**
	 * Initialize the content of the collections of umpires and score keepers
	 * 
	 * @param newGameWizard reference on the wizard
	 */
	public void setNewGameWizard(NewGameWizard newGameWizard) {
		for (Member umpire : newGameWizard.getClubDataParser().getUmpires()) {
			declaredUmpires.put(umpire.getName(), umpire);
		}
		for (Member scoreKeeper : newGameWizard.getClubDataParser().getScoreKeepers()) {
			declaredScoreKeepers.put(scoreKeeper.getName(), scoreKeeper);
		}
	}

	/** 
	 * Check if the page is completed
	 * 
	 * @return <b>true</b> page is complete, <b>false</b> otherwise
	 */
	public boolean getPageCompleted() {
		return getErrorMessage()==null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		removeScoreKeeperBtn.setEnabled(scorekeeperList.getSelectionCount()>0);
		removeUmpireBtn.setEnabled(umpireList.getSelectionCount()>0);
		
		if (e.getSource() == newUmpireBtn) {
			addMember(umpireList, declaredUmpires);
			
		} else if (e.getSource() == newScoreKeeperBtn) {
			addMember(scorekeeperList, declaredScoreKeepers);
			
		} else if (e.getSource() == removeUmpireBtn) {
			removeMembers(umpireList);

		} else if (e.getSource() == removeScoreKeeperBtn) {
			removeMembers(scorekeeperList);

		} else if (e.getSource() == createNewUmpire) {
			// Nothing, must be develop in the future

		} else if (e.getSource() == createNewScorekeeper) {
			// Nothing, must be develop in the future
		} else {
			// Not possible
		}
		
		checkPageCompleted();
	}

	/**
	 * Check if the page is correctly set
	 */
	private void checkPageCompleted() {
		if (umpireList.getItems().length <1) {
			setErrorMessage(Messages.NewGamePageTwoWizard_NoUmpireSetError);
			setPageComplete(false);
			return;
		}
		
		if (scorekeeperList.getItems().length <1) {
			setErrorMessage(Messages.NewGamePageTwoWizard_NoScoreKeeperSetError);
			setPageComplete(false);
			return;
		}
		
		setErrorMessage(null);
		setPageComplete(true);
	}

	/**
	 * Remove an official.
	 * 
	 * @param widget List widget of score keepers or umpires 
	 */
	private void removeMembers(List widget) {
		MessageBox dialog = new MessageBox(new Shell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
		dialog.setText(Messages.NewGamePageTwoWizard_RemoveQuestionTitle);
		dialog.setMessage(Messages.NewGamePageTwoWizard_RemoveQuestionMessage);
		if (dialog.open() == SWT.OK) {
			
			widget.remove(widget.getSelectionIndices());
		}
	}

	/**
	 * Add a new official.
	 * 
	 * @param widget List widget of score keepers or umpires
	 * 
	 * @param declaredMember Collection of officials
	 */
	private void addMember(List widget, HashMap<String, Member> declaredMember) {
		HashMap<String, Member> possiblesMembers = new HashMap<>();
		java.util.List<String> currentMembers = new ArrayList<>(Arrays.asList(widget.getItems()));
		for (Entry<String, Member> memberEntry : declaredMember.entrySet()) {
			if (!currentMembers.contains(memberEntry.getKey())) {
				possiblesMembers.put(memberEntry.getKey(), memberEntry.getValue());
			}
		}
		
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(new Shell(), new LabelProvider());
		dialog.setTitle(Messages.NewGamePageTwoWizard_AddOffcial);
		dialog.setMultipleSelection(true);
		dialog.setElements(possiblesMembers.keySet().toArray(new String[possiblesMembers.size()]));
		if (dialog.open() == Window.OK) {
			String officialName = (String) dialog.getFirstResult();
			if (officialName!= null) {
				Member officialMember = possiblesMembers.get(officialName);
				
				declaredMember.put(officialName, officialMember);
				
				widget.add(officialName);
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do here
	}
}
