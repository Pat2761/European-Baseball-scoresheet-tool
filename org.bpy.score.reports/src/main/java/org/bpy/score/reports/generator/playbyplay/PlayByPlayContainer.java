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
package org.bpy.score.reports.generator.playbyplay;

/**
 * Data class which contains the description of the play by play inning
 * 
 * @author Patrick BRIAND
 *
 */
public class PlayByPlayContainer {
	
	/** header of the inning */
	private String header;
	/** description of the plays */
	private String content;
	/** resume of the inning */
	private String resume;

	/**
	 * Constructor of the class
	 * 
	 */
	public PlayByPlayContainer() {
		// do nothing
	}

	/**
	 * Get the header of the inning.
	 * 
	 * @return header of the inning
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Set the header of the inning.
	 * 
	 * @param header header of the inning
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * Get the description of the actions in the inning.
	 * 
	 * @return description of the actions in the inning
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Set the description of the actions in the inning.
	 * 
	 * @param content description of the actions in the inning
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/***
	 * Get the resume of the inning.
	 * 
	 * @return resume of the inning.
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * Set the resume of the inning.
	 * 
	 * @param resume  resume of the inning.
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}
	
}