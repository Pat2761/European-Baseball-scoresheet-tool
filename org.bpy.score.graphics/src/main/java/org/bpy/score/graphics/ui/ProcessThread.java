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

import java.util.LinkedList;
import java.util.Queue;

import org.bpy.score.internationalization.preferences.Messages;

/**
 * Abstract thread which allow to execute a task linked to to progress dialog box
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class ProcessThread extends Thread {
	
	/** reference to the dialog box */
	private ProgressBarDialog progressBarDialog;

	/** Flag for memorize stop request */
	private volatile boolean shouldStop = false;

	/** Collection of tasks to do in the process */ 
	private Queue<DataProcessContainer> actiosnStacks; 
	
	/** task counter */
	private int counter = 0;
	
	/**
	 * Constructor of the class
	 * 
	 * @param dialogBoxTitle Title of the dialog box
	 * @param firstMessage message to display
	 */
	public ProcessThread(String dialogBoxTitle, String firstMessage) {
		super();
		
		progressBarDialog = new ProgressBarDialog();
		progressBarDialog.setShellTitle(dialogBoxTitle);
		progressBarDialog.setProcessMessage(firstMessage);
	}

	/**
	 * Constructor of the class
	 * Used for debug
	 * 
	 * @param dialogBoxTitle Title of the dialog box
	 * @param firstMessage message to display
	 */
	public ProcessThread() {
		
	}

	/**
	 * Create the collection of task to do in the process
	 * 
	 * @param actiosnStacks data structure to populate with tasks
	 */
	public abstract void initializeDataToProcess(Queue<DataProcessContainer> actiosnStacks);
	
	/**
	 * Execute a task
	 * 
	 * @param container task description 
	 */
	public abstract void executeElement(DataProcessContainer container);
	
	/**
	 * Activate the process
	 */
	public void executeTasks() {
		actiosnStacks = new LinkedList<>();
		initializeDataToProcess(actiosnStacks);

		progressBarDialog.setExecuteTime(actiosnStacks.size());

		progressBarDialog.setMayCancel(true);
		progressBarDialog.setProcessMessage(Messages.ProcessThread_PleaseWaiting);
		progressBarDialog.setThread(this);
		
		progressBarDialog.open();
	}

	@Override
	public void run() {

		while (!actiosnStacks.isEmpty()) {
			
			DataProcessContainer actionToDo = actiosnStacks.poll();

			executeElement(actionToDo);
			
			if (this.progressBarDialog.getDisplay().isDisposed()) {
				return;
			}
			
			updateTheUSerInterface(actionToDo);

			if (shouldStop) {
				break;
			}
		}
	}

	/**
	 * Update the user interface 
	 * 
	 * @param actionToDo task description
	 */
	private void updateTheUSerInterface(DataProcessContainer actionToDo) {
		this.progressBarDialog.getDisplay().syncExec(() -> {
			
				if (ProcessThread.this.progressBarDialog.getProgressBar().isDisposed()) {
					return;
				}
				ProcessThread.this.progressBarDialog.getProcessMessageLabel().setText(actionToDo.getMessage());
				ProcessThread.this.progressBarDialog.getProgressBar().setSelection(counter++);

				if (actiosnStacks.isEmpty() || ProcessThread.this.progressBarDialog.isClosed()) {
					if (ProcessThread.this.progressBarDialog.isClosed()) {
						shouldStop = true;//
					}
					ProcessThread.this.progressBarDialog.getShell().close();
				}
		});
	}
}