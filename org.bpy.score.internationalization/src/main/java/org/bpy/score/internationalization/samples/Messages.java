package org.bpy.score.internationalization.samples;

import org.eclipse.osgi.util.NLS;

public class Messages {

	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.samples.messages"; //$NON-NLS-1$

	// ###################################################################"
	// Wizard String 
	// ###################################################################"
	/** Title of the page one */
	public static String importWizardPageOneTitle;
	/** Description of the page one */
	public static String importWizardPageOneDescription;
	/** Main title of the wizard */
	public static String importWizardWindowTitle;
	/** Label in the page one for describe the content of the list */
	public static String labelProjectListSelector;
	/** Select all button */
	public static String selectAll;
	/** unselect all button */
	public static String deselectAll;
	/** Error message when there are no example selected */
	public static String missingAtLeastOneSelection;

	// ###################################################################"
	// Sample project description
	// ###################################################################"
	/** Name of the sample */
	public static String frenchD1TournamentDescription;
	/** Ttile of error while importing */
	public static String errorWhileImportingSample;
	
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
