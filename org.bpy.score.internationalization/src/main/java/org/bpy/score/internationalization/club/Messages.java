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
package org.bpy.score.internationalization.club;


import org.eclipse.osgi.util.NLS;

/**
 * Make the internationalization for the engine plugin.
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("all")
public class Messages extends NLS {
	
	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.club.messages"; //$NON-NLS-1$

	/** Outline name for members */
	public static String ClubOutlineTreeProvider_Members;
	/** Outline name for officals */
	public static String ClubOutlineTreeProvider_Officials;
	/** Outline name for score keeper */
	public static String ClubOutlineTreeProvider_ScooreKeeper;
	/** Outline name for umpire */
	public static String ClubOutlineTreeProvider_Umpire;

	/* ------------------------------------------------------------------*/
	/* Class ClubProposalProvider                                        */
	/* ------------------------------------------------------------------*/
	/** Proposal for add a new member */
	public static String ClubProposalProvider_AddNewMember;
	/** Proposal for add a new member to a team */
	public static String ClubProposalProvider_AddNewMemberToTeam;
	/** Proposal for set member as role */
	public static String ClubProposalProvider_SetMemberAsRole;
	
	/* ------------------------------------------------------------------*/
	/* Class ClubProposalProvider                                        */
	/* ------------------------------------------------------------------*/
	/** Missing license */	
	public static String ClubValidator_MissingLicence;
	/** Invalid license for player*/	
	public static String ClubValidator_InvalidLicence;
	/** Duplicate member */	
	public static String ClubValidator_DuplicateMember;
	/** Duplicate licence member */	
	public static String ClubValidator_DuplicateLicenceMember;
	/** Shirt number invalid */	
	public static String ClubValidator_InvalidShirtNumber;
	/** Duplicate team name */	
	public static String ClubValidator_DuplicateTeamName;

	/**
	 * Initialize the internationalization
	 */
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	/**
	 * Constructor of the class
	 */
	private Messages() {
	}
}
