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
package org.bpy.score.reports.generator.processtask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.bpy.score.graphics.ui.DataProcessContainer;

/**
 * Copy an inputStream to a destination file
 * 
 * @author Patrick BRIAND
 *
 */
public class CopyInputStreamToDestination extends DataProcessContainer {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(CopyInputStreamToDestination.class.getCanonicalName());
	
	/**
	 * Constructor of the class.
	 * 
	 * @param message message to display while the execution is done
	 * @param dataToProcess object use for the execution
	 */
	public CopyInputStreamToDestination(String message, Object dataToProcess) {
		super(message, dataToProcess);
	}

	@Override
	public void executeTask() {
		CopyInputStreamToDestinationData data = (CopyInputStreamToDestinationData)getDataToProcess();
		
		InputStream input = data.getInputStream();
		
		try {
			OutputStream output = new FileOutputStream( new File(data.getPath()));
			IOUtils.copy(input, output);
			output.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		
	}

}
