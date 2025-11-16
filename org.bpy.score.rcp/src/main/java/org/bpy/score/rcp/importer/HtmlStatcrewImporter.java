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
package org.bpy.score.rcp.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.bpy.score.club.club.Member;
import org.bpy.score.club.util.ClubDataParser;
import org.bpy.score.engine.util.EngineConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Html statcrew game importer
 * 
 * @author Patrick BRIAND
 *
 */
public class HtmlStatcrewImporter {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(HtmlStatcrewImporter.class.getSimpleName());
	
	/** HTML Starter constant */
	private static final String HTML_STARTER = " starters:"; //$NON-NLS-1$
	/** HTML End font constant */
	private static final String HTML_END_FONT = "</font>"; //$NON-NLS-1$
	
	/** Automate state for read the HTML file */
	public enum STATE_READER {
		/** Wait for title of game */
		WAITING_TITLE, 
		/** Header detected */
		HEADER_DETECTED,
		/** Waiting for participants area */
		WAITING_PARTICIPANTS,
		/** end of participant */
		FINISH, 
		/** Waiting for date */
		WAITING_DATE,
		/** Waiting for umpires */
		WAITING_UMPIRES,
		/** Visitor starting line-up */
		VISITOR_STARTERS, 
		/** Home team starting line-up */
		HOMETEAM_STARTERS, 
		/** Inning visitor */
		VISITOR_INNING,
		/** End Inning visitor */
		END_VISITOR_INNING,
		/** Inning Home team */
		HOMETEAM_INNING,
		/** End Inning Home team */
		END_HOMETEAM_INNING,
		/** Visitor starter parts */
		VISITOR_STARTERS_PARTS,
		/** home team starter parts */
		HOMETEAM_STARTERS_PARTS,
	}
	
	/** Month converter */
	private HashMap<String,String> monthConverter;
	/** List of clubs */
	private HashMap<String, ClubDataParser> clubs;
	
	/** State of the automate */
	private STATE_READER stateReader ;
	/** Game date */
	private String gameDate;
	/** City */
	private String town;
	/** Stadium */
	private String stadium;

	/** Name of the visitors */
	private String visitorName;
	/** Name of the hometeam */
	private String hometeamName;
	
	/** String builder */
	private StringBuilder strBuffer;
	/** General String builder */
	private StringBuilder strGeneralBuffer;
	
	/** Innning visitor count */
	private int visitorCounter;
	/** Innning home team count */
	private int hometeamCounter;

	/**
	 * Constructor of the class.
	 */
	public  HtmlStatcrewImporter() {
		monthConverter = new HashMap<>();
		monthConverter.put("jan", "01"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("feb", "02"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("mar", "03"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("apr", "04"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("may", "05"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("jun", "06"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("jul", "07"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("aug", "08"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("sep", "09"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("oct", "10"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("nov", "11"); //$NON-NLS-1$ //$NON-NLS-2$
		monthConverter.put("dec", "12"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Get game date.
	 *  
	 * @return game date
	 */
	public String getGameDate() {
		return gameDate;
	}
	
	/**
	 * Get town.
	 *  
	 * @return town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * Get stadium.
	 * 
	 * @return stadium
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * Read and translate the file. 
	 * 
	 * @param inputPath path of the file
	 */
	public void readFile(String inputPath) {
		stateReader = STATE_READER.WAITING_TITLE;
		visitorCounter = 1;
		hometeamCounter = 1;
		strGeneralBuffer = new StringBuilder();
		
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IFile editorFile = ResourceUtil.getFile(currentEditor.getEditorInput());
		IFolder parentFolder = (IFolder) editorFile.getParent().getParent(); 
		clubs = new HashMap<>();
		
		try {
			for (IResource member : parentFolder.members()) {
				if ((member instanceof IFile) && (member.getName().toLowerCase().endsWith(".club"))) { //$NON-NLS-1$
					ClubDataParser clubDataParser = new ClubDataParser();
					clubDataParser.parseData((IFile) member);
					
					clubs.put(clubDataParser.getCityName(), clubDataParser);
				}
			}
		} catch (CoreException e1) {
			logger.log(Level.SEVERE,e1.getMessage());
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputPath)))) {
			
			String line = null;
			do {
				line = reader.readLine();
				
				if (line != null) {
					
					parseLine(line);
				}
				
			} while (line != null);
			
			IDocumentProvider dp = ((ITextEditor) currentEditor).getDocumentProvider();
			IDocument doc = dp.getDocument(currentEditor.getEditorInput());
			int offset;
			offset = doc.getLineOffset(doc.getNumberOfLines() - 4);
			doc.replace(offset, 0, strGeneralBuffer.toString());

		} catch (BadLocationException|IOException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}

	/**
	 * Parse a line of the HTML file
	 * 
	 * @param line line of the HTML file
	 */
	private void parseLine(String line) {
		if (stateReader == STATE_READER.WAITING_TITLE) {
			if (line.contains("<font size=\"3\">")) {  //$NON-NLS-1$
				stateReader = STATE_READER.HEADER_DETECTED;
			}
		
		} else if (stateReader == STATE_READER.HEADER_DETECTED) {
			stateReader= STATE_READER.WAITING_PARTICIPANTS;
		
		} else if (stateReader == STATE_READER.WAITING_PARTICIPANTS) {
			String val = line.replace(" - Composite Box Score<br>", "").trim(); //$NON-NLS-1$ //$NON-NLS-2$
			if (val.contains(" at ")) { //$NON-NLS-1$
				String[] valParts = val.split(" at "); //$NON-NLS-1$
				visitorName = valParts[0];
				hometeamName = valParts[1];
			} else {
				visitorName = StringUtils.EMPTY;
				hometeamName = StringUtils.EMPTY;
			}

			stateReader = STATE_READER.WAITING_DATE;
			
			
		} else if (stateReader == STATE_READER.WAITING_DATE) {

			stateReader= STATE_READER.WAITING_UMPIRES;
		
		} else if (stateReader == STATE_READER.WAITING_UMPIRES) {
			if (line.startsWith("Umpires - ")) { //$NON-NLS-1$
				stateReader = STATE_READER.VISITOR_STARTERS;
			}
		
		} else if (stateReader == STATE_READER.VISITOR_STARTERS) {
			strBuffer = new StringBuilder();
			if (line.contains(visitorName + HTML_STARTER)) {
				
				if ("".equals(visitorName)) { //$NON-NLS-1$
					String[] partsName = line.split(HTML_STARTER);
					visitorName = partsName[0].trim();
					visitorName = getClubName(visitorName);
				}
				
				stateReader = STATE_READER.VISITOR_STARTERS_PARTS;
				String[] parts = line.split("starters:"); //$NON-NLS-1$
				strBuffer.append(parts[1]);
			}
			
		} else if (stateReader == STATE_READER.VISITOR_STARTERS_PARTS) {
			if (line.startsWith(HTML_END_FONT)) {
				String[] starters = strBuffer.toString().split(";"); //$NON-NLS-1$
				placeStarters(EngineConstants.VISITOR, starters);

				stateReader = STATE_READER.HOMETEAM_STARTERS;
			} else {
				strBuffer.append(" " + line); //$NON-NLS-1$
			}

		} else if (stateReader == STATE_READER.HOMETEAM_STARTERS) {
			strBuffer = new StringBuilder();
			if (line.contains(hometeamName + HTML_STARTER)) {

				if ("".equals(hometeamName)) { //$NON-NLS-1$
					String[] partsName = line.split(HTML_STARTER);
					hometeamName = partsName[0].trim();
					hometeamName = getClubName(hometeamName);
				}

				stateReader = STATE_READER.HOMETEAM_STARTERS_PARTS;
				String[] parts = line.split("starters:"); //$NON-NLS-1$
				strBuffer.append(parts[1]);
			}

		} else if (stateReader == STATE_READER.HOMETEAM_STARTERS_PARTS) {
			if (line.startsWith(HTML_END_FONT)) {
				String[] starters = strBuffer.toString().split(";"); //$NON-NLS-1$
				placeStarters(EngineConstants.HOMETEAM, starters);

				stateReader = STATE_READER.VISITOR_INNING;
			} else {
				strBuffer.append(" " + line); //$NON-NLS-1$
			}


		} else if (stateReader == STATE_READER.VISITOR_INNING) {
			
			if (line.contains(visitorName)) {
				String[] parts = line.split(HTML_END_FONT);
				strBuffer = new StringBuilder();
				strBuffer.append(parts[1] + " "); //$NON-NLS-1$
				stateReader = STATE_READER.END_VISITOR_INNING;
			
			} else if (line.equals("<a name=\"end\"> </a>")) { //$NON-NLS-1$
				stateReader = STATE_READER.FINISH;
			}
		
		} else if (stateReader == STATE_READER.END_VISITOR_INNING) {
			
				if (line.contains("<i>")) { //$NON-NLS-1$
					String[] parts = line.split("<i>"); //$NON-NLS-1$
					strBuffer.append(parts[0] + " "); //$NON-NLS-1$
					stateReader = STATE_READER.HOMETEAM_INNING;
					manageInningInformation(STATE_READER.VISITOR_INNING, visitorCounter);
					visitorCounter++;
				} else {
					strBuffer.append(line + " "); //$NON-NLS-1$
				}				
			

		} else if (stateReader == STATE_READER.HOMETEAM_INNING) {
			
			if (line.contains(hometeamName)) {
				String[] parts = line.split(HTML_END_FONT);
				strBuffer = new StringBuilder();
				strBuffer.append(parts[1] + " "); //$NON-NLS-1$
				stateReader = STATE_READER.END_HOMETEAM_INNING;
			
			} else if (line.equals("<a name=\"end\"> </a>")) { //$NON-NLS-1$
				stateReader = STATE_READER.FINISH;
			}
		
		} else if (stateReader == STATE_READER.END_HOMETEAM_INNING) {
			
			if (line.contains("<i>")) { //$NON-NLS-1$
				String[] parts = line.split("<i>"); //$NON-NLS-1$
				strBuffer.append(parts[0] + " "); //$NON-NLS-1$
				stateReader = STATE_READER.VISITOR_INNING;
				manageInningInformation(STATE_READER.HOMETEAM_INNING, hometeamCounter);
				hometeamCounter++;
			} else {
				strBuffer.append(line + " "); //$NON-NLS-1$
			}				
		}
	}

	/**
	 * Get club name 
	 * 
	 * @param targetName target name
	 * 
	 * @return club name
	 */
	private String getClubName(String targetName) {
		List<String> clubNames = new ArrayList<>(clubs.keySet());
		for (String potentialClubName : clubNames) {
			if (targetName.toLowerCase().contains(potentialClubName.toLowerCase())) {
				return potentialClubName;
			}
		}
		return targetName;
	}

	/**
	 * Set the string line-up
	 * 
	 * @param team current team
	 * @param starters starter players
	 */
	private void placeStarters(String team, String[] starters) {
		
		ClubDataParser clubDataParser = getClub(team);
		if (clubDataParser != null) {
			
			strGeneralBuffer.append("\t\t/* Lineup description for the " + team + " */\r\n"); //$NON-NLS-1$  //$NON-NLS-2$
			strGeneralBuffer.append("\t\tlineup " + team + " {\r\n"); //$NON-NLS-1$ //$NON-NLS-2$

			int counter = 1;
			Pattern pattern = Pattern.compile("(\\d+)\\/(\\w+)\\s+(\\w+)"); //$NON-NLS-1$
			for (String starter : starters) {
				if (starter.endsWith(";")) { //$NON-NLS-1$
					starter = starter.replace(";", ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
				starter = starter.trim();
				Matcher matcher = pattern.matcher(starter);
				if (matcher.matches()) {
					strGeneralBuffer.append("\t\t\t/* " + String.format("%02d", counter) + " */ "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					strGeneralBuffer.append("name = \"" + getName(clubDataParser, matcher.group(3)) + "\" "); //$NON-NLS-1$ //$NON-NLS-2$
					strGeneralBuffer.append("defensivePosition = " + getDefensivePosition(matcher.group(2)) + " "); //$NON-NLS-1$ //$NON-NLS-2$
					strGeneralBuffer.append("shirtNumber = " + matcher.group(1) + ";\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
				counter++; 
			}
			strGeneralBuffer.append("\t\t}\r\n"); //$NON-NLS-1$
			strGeneralBuffer.append("\r\n"); //$NON-NLS-1$
		}
	}

	/**
	 * Get defensive position
	 * 
	 * @param defPos HTML defensive position
	 * @return game defensive position
	 */
	private String getDefensivePosition(String defPos) {
		switch (defPos) {
		case "p" : return "1"; //$NON-NLS-1$ //$NON-NLS-2$
		case "c" : return "2"; //$NON-NLS-1$ //$NON-NLS-2$
		case "1b" : return "3"; //$NON-NLS-1$ //$NON-NLS-2$
		case "2b" : return "4"; //$NON-NLS-1$ //$NON-NLS-2$
		case "3b" : return "5"; //$NON-NLS-1$ //$NON-NLS-2$
		case "ss" : return "6"; //$NON-NLS-1$ //$NON-NLS-2$
		case "lf" : return "7"; //$NON-NLS-1$ //$NON-NLS-2$
		case "cf" : return "8"; //$NON-NLS-1$ //$NON-NLS-2$
		case "rf" : return "9"; //$NON-NLS-1$ //$NON-NLS-2$
		case "dh" : return "dh"; //$NON-NLS-1$ //$NON-NLS-2$
		case "dp" : return "dp"; //$NON-NLS-1$ //$NON-NLS-2$
		default: 
		}
		return "?"; //$NON-NLS-1$
	}

	/**
	 * Get name of the game.
	 *  
	 * @param clubDataParser Reference on the club data parser
	 * @param shortName short name
	 * 
	 * @return name of the game
	 */
	private String getName(ClubDataParser clubDataParser, String shortName) {
		for (Member member : clubDataParser.getMembers()) {
			if (member.getName().toLowerCase().startsWith(shortName.toLowerCase())) {
				return member.getName();
			}
		}
		return "?"; //$NON-NLS-1$
	}

	/**
	 * Get club from team name.
	 * 
	 * @param team team name
	 * @return a club reference, <b>null</b> if not found
	 */
	private ClubDataParser getClub(String team) {
		String clubName = visitorName;
		if (EngineConstants.HOMETEAM.equals(team)) {
			clubName = hometeamName;
		}
		
		List<String> possibilities = new ArrayList<>(clubs.keySet());
		for (String possibilitie : possibilities) {
			if (clubName.toLowerCase().contains(possibilitie.toLowerCase())) {
				return clubs.get(possibilitie);
			}
		}
		
		return null;
	}

	/**
	 * Manage inning information
	 * 
	 * @param inning Html inning description
	 * @param counter counter of inning
	 */
	private void manageInningInformation(STATE_READER inning, int counter) {
		String[] actions = strBuffer.toString().split("\\."); //$NON-NLS-1$
		String team = ((inning == STATE_READER.VISITOR_INNING)?"visitor":"hometeam"); //$NON-NLS-1$ //$NON-NLS-2$
		
		String comment = "//"; //$NON-NLS-1$
		if (inning == STATE_READER.VISITOR_INNING && counter==1) {
			comment=""; //$NON-NLS-1$
		}
		
		strGeneralBuffer.append(comment + "\t\t/* Inning " + counter + " : " + team + " */\r\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		strGeneralBuffer.append(comment + "\t\tinning " + team +" number " + counter + " {\r\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		for (String action : actions) {
			if (!"".equals(action.trim())) { //$NON-NLS-1$
				strGeneralBuffer.append(comment + "\t\t\t/* "+ action.trim() + ". */\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}	
		}
		strGeneralBuffer.append(comment + "\t\t}\r\n"); //$NON-NLS-1$
		strGeneralBuffer.append(comment + "\r\n"); //$NON-NLS-1$
		
	}
}
