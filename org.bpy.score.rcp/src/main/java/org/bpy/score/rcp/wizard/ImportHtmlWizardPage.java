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

import java.io.File;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

/**
 *  This class is the page for the wizard which import HTML description game coming from the FFBS 
 * 
 * @author Patrick BRIAND
 *
 */
public class ImportHtmlWizardPage extends WizardPage implements ModifyListener,SelectionListener {
	
	/** Text widget which contains the path of the HTML file */
	private Text text;

	/** Indicate if all information are correctly setted */
	boolean isPageIsComplete;
	
	/**
	 * Create the wizard.
	 */
	public ImportHtmlWizardPage() {
		super("wizardPage"); //$NON-NLS-1$
		setTitle(Messages.ImportHtmlWizardPage_PageTitle);
		setDescription(Messages.ImportHtmlWizardPage_PageDescription);
		setMessage(Messages.ImportHtmlWizardPage_PageMessage);
		isPageIsComplete = false;
	}

	/**
	 * get page state
	 * 
	 * @return <b>true</b> Page is complete,<b>false</b> otherwise
	 */
	public boolean isPageIsComplete() {
		return isPageIsComplete;
	}

	/**
	 * Get can finish
	 * 
	 * @return <b>true</b> Can finish,<b>false</b> otherwise
	 */
	public boolean canFinish() {
		return isPageIsComplete;
	}

	/**
	 * Get selected file name
	 * 
	 * @return full path name of the HTML file
	 * 
	 */
	public String getFileName() {
		return text.getText();
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		
		text = new Text(container, SWT.BORDER);
		text.addModifyListener(this);
		text.setBounds(10, 45, 298, 21);
		
		DropTarget target = new DropTarget(text, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		Transfer[] types = new Transfer[] { FileTransfer.getInstance() };
		target.setTransfer(types);
		target.addDropListener(new DropTargetAdapter() {
			@Override
			 public void drop(DropTargetEvent event) {
				if (event.data instanceof String[]) {
					text.setText(((String[]) event.data)[0]);
					checkPageComplete();
				}	
			}	
		});
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 24, 187, 15);
		lblNewLabel.setText(Messages.ImportHtmlWizardPage_FileSelectionLabel);
		
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(this);
		button.setBounds(321, 45, 75, 21);
		button.setText("..."); //$NON-NLS-1$

		checkPageComplete(); 
	}
	
	/**
	 * Check if the page is correctly setted
	 */
	private void checkPageComplete() {
		File file = new File(text.getText());
		if (file.exists() && file.isFile()) {
			setErrorMessage(null);
			setPageComplete(true);
			isPageIsComplete = true;
		} else {
			setErrorMessage(NLS.bind(Messages.ImportHtmlWizardPage_FilePathNotValidError, text.getText()));
			setPageComplete(false);
			isPageIsComplete = false;
		}
	}

	@Override
	public void modifyText(ModifyEvent e) {
		checkPageComplete();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog openFile = new FileDialog(new Shell(), SWT.OPEN);
		openFile.setText(Messages.ImportHtmlWizardPage_SelectHtmlFile);
		openFile.setFilterExtensions(new String[] {"*.html","*.htm"}); //$NON-NLS-1$ //$NON-NLS-2$
		String selectedFile = openFile.open();
		if (selectedFile != null) {
			text.setText(selectedFile);
			checkPageComplete(); 
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Nothing to do
	}
}
