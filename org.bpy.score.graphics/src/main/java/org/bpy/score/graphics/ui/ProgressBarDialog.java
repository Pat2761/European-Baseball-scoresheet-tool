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
 */package org.bpy.score.graphics.ui;

import org.bpy.score.internationalization.preferences.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * progress bar dialog. the first, you must know your app execute times, you
 * need implement two method:
 * 
 * @author Patrick BRIAND
 * 
 */
public class ProgressBarDialog extends Dialog {

	/** info of process finish */
	private Label processMessageLabel; 
	/** reference to the progress bar */
	private ProgressBar progressBar = null;
	/** Reference on the shell of the dialog box */
	private Shell shell; //
	/** reference on the display */
	private Display display = null;

	/** close state */
	private volatile boolean isClosed = false;

	/** Number of tasks to execute */
	protected int executeTime = 50;
	
	/** Process message */
	protected String processMessage = Messages.ProgressBarDialog_ProcessMessage;
	/** Default dialog box title */
	protected String shellTitle = Messages.ProgressBarDialog_ShellTitle; 
	/** Reference on the process icon */
	protected Image processImage = SWTUtil.getImageOfMessage();
	/** Cancel */
	protected boolean mayCancel = true; 
	/** Progress bar style */
	protected int processBarStyle = SWT.SMOOTH; 
	/** reference on the process step */
	private ProcessThread processThread;

	/**
	 * Set cancel attribute authorization 
	 * @param mayCancel  cancel attribute authorization
	 */
	public void setMayCancel(boolean mayCancel) {
		this.mayCancel = mayCancel;
	}

	/**
	 * Set number of the tasks to execute
	 *  
	 * @param executeTime number of the tasks to execute
	 */
	public void setExecuteTime(int executeTime) {
		this.executeTime = executeTime;
	}

	/**
	 * Constructor of the class.
	 */
	public ProgressBarDialog() {
		super(new Shell());
	}

	/**
	 * Show the dialog box and run the process.
	 * 
	 */
	public void open() {
		createContents(); 
		getShell().open();
		getShell().layout();

		// start work
		processThread.start();

		while (!getShell().isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Populate the dialog box
	 */
	protected void createContents() {
		setShell(new Shell(getParent(), SWT.TITLE | SWT.PRIMARY_MODAL));
		setDisplay(getShell().getDisplay());
		final GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 10;

		getShell().setLayout(gridLayout);
		getShell().setSize(483, 181);
		getShell().setText(shellTitle);

		final Composite composite = new Composite(getShell(), SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		composite.setLayout(new GridLayout());

		CLabel message = new CLabel(composite, SWT.NONE);
		message.setImage(processImage);
		message.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		message.setText(processMessage);

		Composite progressBarComposite = new Composite(getShell(), SWT.NONE);
		progressBarComposite.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, false, false));
		progressBarComposite.setLayout(new FillLayout());

		setProgressBar(new ProgressBar(progressBarComposite, processBarStyle));
		getProgressBar().setMaximum(executeTime);

		setProcessMessageLabel(new Label(getShell(), SWT.NONE));
		getProcessMessageLabel().setAlignment(SWT.CENTER);
		getProcessMessageLabel().setLayoutData(new GridData(GridData.FILL, GridData.CENTER, false, false));
		Label lineLabel = new Label(getShell(), SWT.HORIZONTAL | SWT.SEPARATOR);
		lineLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, false, false));

		Composite cancelComposite = new Composite(getShell(), SWT.NONE);
		cancelComposite.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
		final GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		cancelComposite.setLayout(gridLayout1);

		Button cancelButton = new Button(cancelComposite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setClosed(true);
			}
		});
		cancelButton.setLayoutData(new GridData(78, SWT.DEFAULT));
		cancelButton.setText(Messages.ProgressBarDialog_CancelButton);
		cancelButton.setEnabled(this.mayCancel);
		new Label(cancelComposite, SWT.NONE);

	}

	/**
	 * Set the shell title
	 * 
	 * @param shellTitle title of the shell
	 */
	public void setShellTitle(String shellTitle) {
		this.shellTitle = shellTitle;
	}

	/**
	 * Set the progress bar style
	 * 
	 * @param pStyle <b>true</b> for SMOOTH, <b>false</b> otherwise
	 */
	public void setProcessBarStyle(boolean pStyle) {
		if (pStyle)
			this.processBarStyle = SWT.SMOOTH;
		else
			this.processBarStyle = SWT.NONE;

	}

	/**
	 * Get the display
	 * 
	 * @return reference on the display
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * Set the display
	 * 
	 * @param display reference on the display
	 */
	public void setDisplay(Display display) {
		this.display = display;
	}

	/**
	 * get the reference on the progress bar widget
	 * 
	 * @return reference on the progress bar widget
	 */
	public ProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * Set the reference on the progress bar widget
	 * 
	 * @param progressBar reference on the progress bar widget
	 */
	public void setProgressBar(ProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	/**
	 * Get the reference on the message label
	 * 
	 * @return reference on the message label
	 */
	public Label getProcessMessageLabel() {
		return processMessageLabel;
	}

	/**
	 * Set the reference on the message label
	 * 
	 * @param processMessageLabel reference on the message label
	 */
	public void setProcessMessageLabel(Label processMessageLabel) {
		this.processMessageLabel = processMessageLabel;
	}

	/**
	 * Getter for the close boolean
	 * 
	 * @return state of the close boolean 
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * Setter for the close boolean
	 * 
	 * @param isClosed state of the close boolean 
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	/** 
	 * Get shell of the dialog box
	 * 
	 * @return shell of the dialog box
	 */
	public Shell getShell() {
		return shell;
	}

	/** 
	 * Set shell of the dialog box
	 * 
	 * @param shell shell of the dialog box
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * Set the process description.
	 * 
	 * @param processThread process thread
	 */
	public void setThread(ProcessThread processThread) {
		this.processThread = processThread;
		
	}

	/**
	 * Set the process message
	 * 
	 * @param message process message
	 */
	public void setProcessMessage(String message) {
		processMessage = message;
	}
}