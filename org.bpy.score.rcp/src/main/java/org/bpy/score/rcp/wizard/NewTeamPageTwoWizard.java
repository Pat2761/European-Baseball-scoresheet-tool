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

import java.util.Arrays;
import java.util.HashMap;

import org.bpy.score.club.club.Member;
import org.bpy.score.internationalization.rcp.Messages;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * Page two of the New team wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewTeamPageTwoWizard extends WizardPage implements Listener,SelectionListener {

	/** Reference on the wizard owner of this page */
	private NewTeamWizard newTeamWizard;
	/** List widget for display the members*/
	private List memberList;
	
	/** First time displayed */
	private boolean firstSetVisible = true;
	/** Button for remove a member */
	private Button removeElementButton;
	/** Button for add a member */
	private Button addMemberButton;

	/** Collection of members */
	private HashMap<String, Member> definedMembers;
	private Label lblNewLabel;

	/**
	 * Create the wizard.
	 */
	public NewTeamPageTwoWizard() {
		super("NewTeamPageTwoWizard"); //$NON-NLS-1$
		setTitle(Messages.NewTeamPageTwoWizard_PageTitle);
		setDescription(Messages.NewTeamPageTwoWizard_PageDescription);
		
		definedMembers = new HashMap<>();
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblListeDesMembres = new Label(container, SWT.NONE);
		lblListeDesMembres.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		lblListeDesMembres.setText(Messages.NewTeamPageTwoWizard_ListMemberLabel);
		
		memberList = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		memberList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		memberList.addListener(SWT.Selection, this);
		
		addMemberButton = new Button(container, SWT.NONE);
		addMemberButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		addMemberButton.setText(Messages.NewTeamPageTwoWizard_AddMemberButton);
		addMemberButton.addSelectionListener(this);
		
		removeElementButton = new Button(container, SWT.NONE);
		removeElementButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		removeElementButton.setEnabled(false);
		removeElementButton.setText(Messages.NewTeamPageTwoWizard_RemoveMemberButton);
		
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1));
		lblNewLabel.setText(Messages.NewTeamPageTwoWizard_lblNewLabel_text);
		removeElementButton.addSelectionListener(this);
	}

	/** 
	 * Set the reference on the wizard owner of this page. 
	 * 
	 * @param newTeamWizard reference on the wizard owner of this page 
	 */ 
	public void setNewTeamWizard(NewTeamWizard newTeamWizard) {
		this.newTeamWizard = newTeamWizard;
	}

	@Override
	public void setVisible(boolean visible) {
		if (firstSetVisible) {
			firstSetVisible = false;
			if (newTeamWizard.getClubDescription() != null) {
				
				
				definedMembers.clear();

				java.util.List<Member> members = newTeamWizard.getClubDescription().getMembers();
				
				for (Member member : members) {
					definedMembers.put(member.getName(), member);
					memberList.add(member.getName());
				}
			}
		}

		super.setVisible(visible);
	}

	@Override
	public void handleEvent(Event event) {
		removeElementButton.setEnabled(memberList.getSelectionCount() > 0); 
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == addMemberButton) {
			addNewMember();
			
		} else if (e.getSource() == removeElementButton) {
			removeSelectedMembers();
		}
	}

	/**
	 * Add a new member to the club
	 */
	private void addNewMember() {
		
		NewMemberDialog newMemberDialog = new NewMemberDialog(new Shell());
		
		if (newMemberDialog.open() == Window.OK) {
			
			Member member = newTeamWizard.getClubDescription().createNewMember(newMemberDialog.getMemberName(), 
					newMemberDialog.getLicenseNumber(),
					newMemberDialog.getShortName());
			definedMembers.put(member.getName(), member);
			memberList.add(member.getName());
			newTeamWizard.getClubDescription().getMembers().add(member);

			String[] currentMembers = memberList.getItems();
			Arrays.sort(currentMembers);
			memberList.setItems(currentMembers);
			
		}
	}

	/**
	 * Remove a member in the list
	 */
	private void removeSelectedMembers() {
		MessageBox dialog = new MessageBox(new Shell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
		dialog.setText(Messages.NewTeamPageTwoWizard_RemoveMemberDialogTitle);
		dialog.setMessage(Messages.NewTeamPageTwoWizard_RemoveMemberDialogMessage);
		if (dialog.open() == SWT.OK) {
			
			for (int selectionIndice : memberList.getSelectionIndices()) {
				
				Member member = definedMembers.get(memberList.getItem(selectionIndice));
				newTeamWizard.getClubDescription().getMembers().remove(member);
				definedMembers.remove(memberList.getItem(selectionIndice));
			}
			memberList.remove(memberList.getSelectionIndices());
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Not used
	}

}
