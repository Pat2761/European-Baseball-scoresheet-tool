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

import java.io.InputStream;

/**
 * Data container for the process of the copy from an input stream to a file
 * 
 * @author Patrick BRIAND
 *
 */
public class CopyInputStreamToDestinationData {

	/** Reference on the input Stream to copy */
	private InputStream inputStream;
	
	/** Generated file name */
	private String path;

	/**
	 * Get the reference on the input Stream to copy.
	 *  
	 * @return reference on the input Stream to copy 
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * Set the reference on the input Stream to copy.
	 * 
	 * @param inputStream reference on the input Stream to copy 
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * Get the generated file name.
	 * 
	 * @return Generated file name
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the generated file name.
	 * 
	 * @param path Generated file name
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
