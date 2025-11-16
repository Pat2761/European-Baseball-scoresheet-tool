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

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

/**
 * Dialog box which allow to create a new member in a team
 * 
 * @author Patrick BRIAND
 *
 */
public class NewMemberDialog extends Dialog implements ModifyListener {
	
	/** text widget for the member name */
	private Text memberNameTxt;
	/** text widget for the member short name */
	private Text shortNameTxt;
	/** text widget for the member license number */
	private Text licenceNumberTxt;
	/** Reference on the checkbox Foreign */
	private Button isForeignBtn;
	/** Reference on the checkbox muted */
	private Button isMutedBtn;
	
	/** Reference on the OK button */
	private Button okButton;

	/** Name of the member */
	private String memberName;
	/** Short name of the member */
	private String shortName;
	/** License number  of the member */
	private String licenceNumber;
	/** Foreign state of the member */
	private boolean isForeign;
	/** Transfered state of the member */
	private boolean isTransfered;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewMemberDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.NewMemberDialog_Title);
	}
	
	/**
	 * Get Name of the member
	 * 
	 * @return Name of the member
	 */
	public String getMemberName() {
		return memberName;
	}
	
	/**
	 * Get short name of the member
	 * 
	 * @return Short name of the member
	 */
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * Get license number of the member
	 * 
	 * @return License number of the member
	 */
	public String getLicenseNumber() {
		return licenceNumber;
	}
	
	/**
	 * get foreign state of the member
	 * 
	 * @return <b>true</b> is foreign,<b>false</b> otherwise
	 */
	public boolean isForeign() {
		return isForeign;
	}
	
	/**
	 * get transfered state of the member
	 * 
	 * @return <b>true</b> is transfered ,<b>false</b> otherwise
	 */
	public boolean isTranssfered() {
		return isTransfered;
	}

	@Override
	protected void okPressed() {
		memberName = memberNameTxt.getText();
		shortName = shortNameTxt.getText();
		licenceNumber = licenceNumberTxt.getText();
		isForeign = isForeignBtn.getSelection();
		isTransfered = isMutedBtn.getSelection();

		super.okPressed();
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		container.setLayout(null);
		
		Label lblNomDuMembre = new Label(container, SWT.NONE);
		lblNomDuMembre.setBounds(10, 10, 185, 15);
		lblNomDuMembre.setText(Messages.NewMemberDialog_MemberNameLabel);
		
		memberNameTxt = new Text(container, SWT.BORDER);
		memberNameTxt.setBounds(10, 31, 185, 21);
		memberNameTxt.addModifyListener(this);
		
		Label lblSurnomDuMembre = new Label(container, SWT.NONE);
		lblSurnomDuMembre.setBounds(240, 76, 185, 15);
		lblSurnomDuMembre.setText(Messages.NewMemberDialog_MemberSurNameLabel);
		
		shortNameTxt = new Text(container, SWT.BORDER);
		shortNameTxt.setBounds(235, 97, 185, 21);
		
		Label lblNumroDeLicense = new Label(container, SWT.NONE);
		lblNumroDeLicense.setBounds(10, 76, 185, 15);
		lblNumroDeLicense.setText(Messages.NewMemberDialog_LicenseNumberLabel);
		
		licenceNumberTxt = new Text(container, SWT.BORDER);
		licenceNumberTxt.setBounds(10, 97, 185, 21);
		licenceNumberTxt.addModifyListener(this);
		
		isForeignBtn = new Button(container, SWT.CHECK);
		isForeignBtn.setBounds(235, 31, 176, 16);
		isForeignBtn.setText(Messages.NewMemberDialog_ForeignPlayerCheckBox);
		
		isMutedBtn = new Button(container, SWT.CHECK);
		isMutedBtn.setBounds(235, 52, 176, 16);
		isMutedBtn.setText(Messages.NewMemberDialog_TransferedPlayerCheckBox);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		okButton.setEnabled(false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 230);
	}

	@Override
	public void modifyText(ModifyEvent e) {
		okButton.setEnabled(!memberNameTxt.getText().isBlank() && !licenceNumberTxt.getText().isBlank());
	}
}
