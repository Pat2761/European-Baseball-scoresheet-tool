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

/**
 * Data container for execute a process in  adialog box
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class DataProcessContainer {

	/** Message to display in the dialog box */
	private String message;
	/** Object to process in a step */
	private Object dataToProcess;
	
	/**
	 * Constructor of the class
	 * 
	 * @param message Message to display in the dialog box
	 * @param dataToProcess Object to process in a step
	 */
	public DataProcessContainer(String message, Object dataToProcess) {
		this.message = message;
		this.dataToProcess = dataToProcess;
	}
	
	/**
	 * Make the treatment
	 */
	public abstract void executeTask();

	/**
	 * Get the message to display in the dialog box
	 * 
	 * @return message to display in the dialog box
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Get the object to process in a step 
	 * 
	 * @return object to process in a step
	 */
	public Object getDataToProcess() {
		return dataToProcess;
	}
}
