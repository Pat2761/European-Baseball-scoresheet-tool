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
package org.bpy.score.preferences.core;

import java.util.HashMap;

import org.bpy.score.internationalization.rcp.Messages;

/**
 * Define all constants used as preferences by the application
 * 
 * @author Patrick BRIAND
 *
 */
public class ScorePreferenceConstants {

	/** ID for preference maanager */
	public static final String PREFERENCE_ID = "org.bpy.score.rcp.preferences"; //$NON-NLS-1$

	/* --------------------------------------------------------------------------------------
	 * GenerateGameReport preferences
	 * ------------------------------------------------------------------------------------- */
	/** Page name of the Game report wizard */
	public static final String GAME_REPORT_WIZARD = "GenerateGameReportWizard";
	/** Page name of the Game report wizard */
	public static final String GRW_PROJECT_SCOPE = "GRW_projectScope";

	/** Display regular expression key of the Game Report Wizard */
	public static final String GRW_DISPLAY_REGULAR_EXPRESSION_KEY = "GRW_displayRegularExpressionKey"; //$NON-NLS-1$
	/** Default value of Display regular expression key of the Game Report Wizard */
	public static final String GRW_DISPLAY_REGULAR_EXPRESSION_KEY_DEFAULT = ""; //$NON-NLS-1$

	/** Selection regular expression key of the Game Report Wizard  */
	public static final String GRW_SELECTION_REGULAR_EXPRESSION_KEY = "GRW_selectionRegularExpressionKey"; //$NON-NLS-1$
	/** Default value of Selection regular expression key of the Game Report Wizard  */
	public static final String GRW_SELECTION_REGULAR_EXPRESSION_KEY_DEFAULT = ""; //$NON-NLS-1$

	/** Output folder path key of the Game Report Wizard  */
	public static final String GRW_OUTPUT_FOLDER_KEY = "GRW_outputFolderKey"; //$NON-NLS-1$
	/** Default value of Output folder path key of the Game Report Wizard  */
	public static final String GRW_OUTPUT_FOLDER_KEY_DEFAULT = ""; //$NON-NLS-1$
	
	/** Use preference configuration for the CSS, XSLT and banner file */
	public static final String GRW_USE_STANDARD_CONFIGURATION = "GRW_UseStandardConfiguration";
	/** Use preference configuration for the CSS, XSLT and banner file default value */ 
	public static final boolean GRW_USE_STANDARD_CONFIGURATION_DEFAULT = true;
	
	/** CSS file path for the report generation */
	public static final String GRW_CSS_FILE_PATH = "GRW_CssFilePath";
	/** CSS default file path for the report generation */
	public static final String GRW_CSS_FILE_DEFAULT = "";
	
	/** XSLT file path for the report generation */
	public static final String GRW_XSLT_FILE_PATH = "GRW_XsltFilePath";
	/** XSLT default file path for the report generation */
	public static final String GRW_XSLT_FILE_DEFAULT = "";
	
	/** Banner file path for the report generation */
	public static final String GRW_BANNER_FILE_PATH = "GRW_BannerFilePath";
	/** Banner default file path for the report generation */
	public static final String GRW_BANNER_FILE_DEFAULT = "";
	
	
	/** Error level preference definition */ 
	protected static final HashMap<String, String> errorsDefinition = new HashMap<>();
	/** Reverse Error level preference definition */ 
	protected static final HashMap<String, String> reverseErrorsDefinition = new HashMap<>();

	/** Error levels */
	public static final String[][] errorLevel = new String[3][2];

	/** Level error ignore */
	public static final String IGNORE_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorIgnore;
	/** Level error warning */
	public static final String WARNING_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorWarning;
	/** Level error error */
	public static final String ERROR_STR_TO_DISPLAY = Messages.PreferenceConstants_LevelErrorError;

	/** Level error ignore key store*/
	public static final String IGNORE = "ignore";//$NON-NLS-1$
	/** Level error warning key store */
	public static final String WARNING = "warning";//$NON-NLS-1$
	/** Level error error key store */
	public static final String ERROR = "error";//$NON-NLS-1$

	/** Fly out check location key store */
	public static final String CHECK_FLY_OUT_LOCATION = "check.fly.out.location";//$NON-NLS-1$
	/** Earned point check location key store */
	public static final String CHECK_MISSING_EARNED_POINT = "check.missing.earned.point";//$NON-NLS-1$

	/** Key for indicate if the tool use the category folder for the game report generation */
	public static final String GAME_REPORT_PREFERENCE_USE_CATEGORY_GENERATION_FOLDER = "GameReportPreferenceUseCategogryFolder"; //$NON-NLS-1$
	
	/** Key for define the game report generation folder */
	public static final String GAME_REPORT_PREFERENCE_GENERATION_FOLDER = "GameReportPreferenceGenerationFolder"; //$NON-NLS-1$
	
	/** Key for indicate if the tool use the standard CSS et XSLT file */
	public static final String GAME_REPORT_PREFERENCE_USE_STANDARD_FORMATTER = "GameReportPreferenceUseStandardFormatter"; //$NON-NLS-1$
	
	/** Key for define the game report CSS File */
	public static final String GAME_REPORT_PREFERENCE_CSS_FILE_PATH = "GameReportPreferenceCssFilePath"; //$NON-NLS-1$

	/** Key for define the game report XSLT File */
	public static final String GAME_REPORT_PREFERENCE_XSLT_FILE_PATH = "GameReportPreferenceXsltFilePath"; //$NON-NLS-1$

	/** Key for define the game report banner File */
	public static final String GAME_REPORT_PREFERENCE_BANNER_FILE_PATH = "GameReportPreferenceBannerFilePath"; //$NON-NLS-1$

	/** Key for define the kind of game report file (XML or HTML) */
	public static final String GRW_PREFERENCE_TYPE_GENERATED_FILE = "GameReportPreferenceTypeGeneratedFile"; //$NON-NLS-1$

	/** Constant which contains the last regex for the selection file */
	public static final String GAME_REPORT_REGEX_SELECTION_FILE = "GameReportPreferenceRegexSelectionFile"; //$NON-NLS-1$

	/** Constant which indicate the game report is an XML file */
	public static final String GRW_TYPE_XML = "GameReportPreferenceXMLGeneratedFile"; //$NON-NLS-1$

	/** Constant which indicate the game report is an HTML file */
	public static final String GRW_TYPE_HTML = "GameReportPreferenceHTMLGeneratedFile"; //$NON-NLS-1$

	/** Key for setting the preference linked to use project properties */
	public static final String PROPERTIE_USE_PROJECT_SETTINGS = "propertiesUseProjectSettings";  //$NON-NLS-1$

   /* --------------------------------------------------------------------------------------
    * Graphical preferences
    * ------------------------------------------------------------------------------------- */
   /** Contains the color line */
   public static final String GPP_GRAPHIC_COLOR_LINE = "graphicalPreferenceColorLine";
   /** Contains the color line default value*/
   public static final String GPP_GRAPHIC_COLOR_LINE_DEFAULT_VALUE = "0,0,0";

   /** Contains the writing color */
   public static final String GPP_GRAPHIC_WRITING_LINE = "graphicalPreferenceWritingLine";
   /** Contains the writing color default value*/
   public static final String GPP_GRAPHIC_WRITING_LINE_DEFAULT_VALUE = "0,0,0";
	
   /** Parameter key for specify level of statistic display */
   public static final String GPP_DISPLAY_STATISTICS = "graphicalPreferenceDisplayStatistic";
   /** Full display for the statistic display */
   public static final String GPP_FULL_STATISTC_DISPLAY = "fullStatisticDisplay";
   /** Full display for the statistic display */
   public static final String GPP_SF1_STATISTC_DISPLAY = "sf1StatisticDisplay";
   /** Full display for the statistic display */
   public static final String GPP_NO_STATISTC_DISPLAY = "noStatisticDisplay";
	 
   /** Parameter key for allow the new style sheet */
   public static final String GPP_USE_NEW_STYLE_SHEET = "graphicalPreferenceDisplayUseNewStyleSheet";
   /** Parameter key for allow the new style sheet default value */
   public static final boolean GPP_USE_NEW_STYLE_SHEET_DEFAULT_VALUE = false;

   /** Parameter key for display the pitcher Win/Lose/Save state */
   public static final String GPP_DISPLAY_PITCHER_STATE = "graphicalPreferenceDisplayPitcherState";
   /** Parameter key for display the pitcher Win/Lose/Save state default value*/
   public static final boolean GPP_DISPLAY_PITCHER_STATE_DEFAULT_VALUE = true;

   /* --------------------------------------------------------------------------------------
    * Graphical preferences
    * ------------------------------------------------------------------------------------- */
   /** Parameter for memorize the flyout level error */
   public static final String CPP_FLYOUT_CONTROL = "cppFlyoutControl";
   /** Parameter for memorize the flyout level error none */
   public static final String CPP_FLYOUT_CONTROL_NONE = "compileNone";
   /** Parameter for memorize the flyout level error warning */
   public static final String CPP_FLYOUT_CONTROL_WARNING = "compileWarning";
   /** Parameter for memorize the flyout level error error*/
   public static final String CPP_FLYOUT_CONTROL_ERROR = "compileError";
   /** Parameter for memorize the flyout level error default value*/
   public static final String CPP_FLYOUT_CONTROL_DEFAULT_VALUE = CPP_FLYOUT_CONTROL_NONE;
   
   /* --------------------------------------------------------------------------------------
    * Project property used
    * ------------------------------------------------------------------------------------- */
   /** Parameter for memorize the use of the project setting for the report generation */
   public static final String GRW_USE_REPORT_PROJECT_SETTING = "useReportProjectSetting";
   /** Default value for : Parameter for memorize the use of the project setting for the report generation */
   public static final boolean GRW_USE_REPORT_PROJECT_SETTING_DEFAULT_VALUE = false;

   /** Parameter for memorize the use of the project setting for the graphical configuration */
   public static final String GPP_USE_REPORT_PROJECT_SETTING = "useReportProjectSetting";
   /** Default value for : Parameter for memorize the use of the project setting for the graphical configuration */
   public static final boolean GPP_USE_REPORT_PROJECT_SETTING_DEFAULT_VALUE = false;

   /** Parameter for memorize the use of the project setting for the control on the game */
   public static final String CPP_USE_REPORT_PROJECT_SETTING = "useReportProjectSetting";
   /** Default value for : Parameter for memorize the use of the project setting for the control on the game*/
   public static final boolean CPP_USE_REPORT_PROJECT_SETTING_DEFAULT_VALUE = false;
   
	static {

		errorsDefinition.put(IGNORE, IGNORE_STR_TO_DISPLAY);
		errorsDefinition.put(WARNING, WARNING_STR_TO_DISPLAY);
		errorsDefinition.put(ERROR, ERROR_STR_TO_DISPLAY);

		reverseErrorsDefinition.put(IGNORE_STR_TO_DISPLAY, IGNORE);
		reverseErrorsDefinition.put(WARNING_STR_TO_DISPLAY, WARNING);
		reverseErrorsDefinition.put(ERROR_STR_TO_DISPLAY, ERROR);

		errorLevel[0][0] = IGNORE_STR_TO_DISPLAY;
		errorLevel[0][1] = IGNORE;
		errorLevel[1][0] = WARNING_STR_TO_DISPLAY;
		errorLevel[1][1] = WARNING;
		errorLevel[2][0] = ERROR_STR_TO_DISPLAY;
		errorLevel[2][1] = ERROR;
	}
	
	/**
	 * Utility classes, which are collections of static members, are not meant to be instantiated. Even abstract utility classes, which can be extended, should not have public constructors.
	 */
	private ScorePreferenceConstants() {
		throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}

}
