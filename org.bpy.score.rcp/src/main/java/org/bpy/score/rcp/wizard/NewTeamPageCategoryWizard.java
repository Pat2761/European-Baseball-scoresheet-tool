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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.swt.widgets.Button;

/**
 * Wizard page for add players to a category
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamPageCategoryWizard extends WizardPage implements Listener,SelectionListener {
	
	/** New member button */
	private Button newMemberBtn;
	/** Remove member button */
	private Button removeMemberBtn;
	/** List widget which contains the list of player in the category */
	private List memberList;
	
	/** Category name */
	private String categoryName;
	/** Reference on the wizard owner of this page */
	private NewTeamWizard newTeamWizard;
	
	/** Collection of displayed members */
	private HashMap<String,Member> displayedMembers;

	/**
	 * Create the wizard.
	 */
	public NewTeamPageCategoryWizard() {
		super("wizardPage"); //$NON-NLS-1$
		setTitle("Wizard Page title"); //$NON-NLS-1$
		setDescription("Wizard Page description"); //$NON-NLS-1$
		
		displayedMembers = new HashMap<>();
	}

	/**
	 * set the category name
	 * 
	 * @param categoryName category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Set the reference on the wizard owner of this page 
	 * 
	 * @param newTeamWizard Reference on the wizard owner of this page 
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
		
		Label lblListeDesMembres = new Label(container, SWT.NONE);
		lblListeDesMembres.setBounds(10, 10, 271, 15);
		lblListeDesMembres.setText(Messages.NewTeamPageCategoryWizard_MembersListLabel);
		
		memberList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		memberList.setBounds(10, 34, 173, 289);
		memberList.addListener(SWT.Selection, this);
		
		newMemberBtn = new Button(container, SWT.NONE);
		newMemberBtn.setBounds(189, 41, 240, 25);
		newMemberBtn.setText(Messages.NewTeamPageCategoryWizard_AddMemberButton);
		newMemberBtn.addSelectionListener(this);
		
		removeMemberBtn = new Button(container, SWT.NONE);
		removeMemberBtn.setBounds(189, 72, 240, 25);
		removeMemberBtn.setText(Messages.NewTeamPageCategoryWizard_RemoveMemberButton);
		removeMemberBtn.addSelectionListener(this);
		removeMemberBtn.setEnabled(false);
	}

	@Override
	public void setVisible(boolean visible) {
		java.util.List<Member> members = newTeamWizard.getClubDescription().getCategories().get(categoryName);
		if (members != null) {
			for (Member member : members) {
				displayedMembers.put(member.getName(), member);
			}
		} else {
			newTeamWizard.getClubDescription().getCategories().put(categoryName, new ArrayList<>());
		}
	
		String[] items = displayedMembers.keySet().toArray(new String[displayedMembers.keySet().size()]);
		Arrays.sort(items);
		memberList.setItems(items);
		
		super.setVisible(visible);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == removeMemberBtn) {
			removeSelectedMembers();
			
		} else if (e.getSource() == newMemberBtn) {
			addNewMember();
		}
	}

	/**
	 * Remove the selected members
	 */
	private void removeSelectedMembers() {
		MessageBox dialog = new MessageBox(new Shell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
		dialog.setText(Messages.NewTeamPageCategoryWizard_RemoveDialogTitle);
		dialog.setMessage(Messages.NewTeamPageCategoryWizard_RemoveDialogMessage);
		if (dialog.open() == SWT.OK) {
			
			for (int selectionIndice : memberList.getSelectionIndices()) {
				
				Member member = displayedMembers.get(memberList.getItem(selectionIndice));
				newTeamWizard.getClubDescription().getCategories().get(categoryName).remove(member);
				displayedMembers.remove(memberList.getItem(selectionIndice));
			}
			memberList.remove(memberList.getSelectionIndices());
		}
	}

	/**
	 * Add members in the category
	 */
	private void addNewMember() {
		ArrayList<String> allreadyDefinedPlayers = new ArrayList<>(displayedMembers.keySet());
		HashMap<String, Member> potientalplayers = new HashMap<>();
		for (Member member : newTeamWizard.getClubDescription().getMembers()) {
			if (!allreadyDefinedPlayers.contains(member.getName())) {
				potientalplayers.put(member.getName(), member);
			}
		}
		
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(new Shell(), new LabelProvider());
		dialog.setTitle(Messages.NewTeamPageCategoryWizard_AddDialogTitle);
		dialog.setElements(potientalplayers.keySet().toArray(new String[potientalplayers.size()]));
		if (dialog.open() == Window.OK) {
			String playerName = (String) dialog.getFirstResult();
			if (playerName!= null) {
				Member playerMember = potientalplayers.get(playerName);
				
				displayedMembers.put(playerName, playerMember);
				newTeamWizard.getClubDescription().getCategory(categoryName).add(playerMember);
				
				memberList.add(playerName);
				String[] listOfName = memberList.getItems();
				Arrays.sort(listOfName);
				memberList.setItems(listOfName);
			}
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do here
	}

	@Override
	public void handleEvent(Event event) {
		removeMemberBtn.setEnabled(memberList.getSelectionCount()>0);
	}

}
