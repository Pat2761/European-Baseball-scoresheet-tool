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
package org.bpy.score.game.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.game.GameStandaloneSetup;
import org.bpy.score.game.game.Description;
import org.bpy.score.game.game.Game;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Supply some functionalities about game files
 * 
 * @author Patrick BRIAND
 *
 */
public class GameDataParser {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameDataParser.class.getSimpleName());

	/** Injection */
	@Inject	Injector injector;
	
	/** reference opn the XText resource */
	private XtextResourceSet resourceSet;
	
	/** the list of towns defined in all games for a category*/
	private ArrayList<String> towns;
	/** the list of stadiums defined in all games for a category */
	private ArrayList<String> stadiums;
	/** List of games  for a category */
	private ArrayList<Game> games;

	/**
	 * Constructor of the class.  
     */
	public GameDataParser() {
		injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		resourceSet = injector.getInstance(XtextResourceSet.class);
	} 
	
	/**
	 * Parse all games in a folder
	 * 
	 * @param folder to parse
	 */ 
	public void parseData(IFolder folder) {

		towns = new ArrayList<>();
		stadiums = new ArrayList<>();
		games = new ArrayList<>();

		try {
			for (IResource member : folder.members()) {

				if (member instanceof IFile) {
					parseData((IFile)member);
				}
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}
	
	/**
	 * Parse a game file 
	 * 
	 * @param iFile file to parse
	 */ 
	private void parseData(IFile iFile) {

		if ((iFile.getFileExtension() != null) && iFile.getFileExtension().equalsIgnoreCase("game")) { //$NON-NLS-1$

			URI modelURI = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
			Resource xtextResource = resourceSet.getResource(modelURI, true);

			EcoreUtil.resolveAll(xtextResource);

			TreeIterator<EObject> contents = xtextResource.getAllContents();
			while (contents.hasNext()) {
				EObject content = contents.next();

				if (content instanceof Description) {
					Description gameDescription = (Description) content; 
					if (!towns.contains(gameDescription.getPlace()))
						towns.add(gameDescription.getPlace());
					if (!stadiums.contains(gameDescription.getStadium()))
						stadiums.add(gameDescription.getStadium());	
				}
				
				if (content instanceof Game) {
					games.add((Game) content);					
				}
			}
		}
	}
	
	/**
	 * return the list of towns found in a folder 
	 * 
	 * @return list of towns 
	 */
	public List<String> getTowns() {
		return towns;	
	}
	
	/**
	 * return the list of stadiums found in a folder 
	 * 
	 * @return list of stadiums 
	 */
	public List<String> getStadiums() {
		return stadiums;		
	}
	
	/**
	 * return the list of games found in a folder 
	 * 
	 * @return list of games 
	 */
	public List<Game> getGames() {
		return games;
	}
}
