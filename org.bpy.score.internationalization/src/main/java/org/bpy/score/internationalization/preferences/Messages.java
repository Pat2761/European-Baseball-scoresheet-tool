package org.bpy.score.internationalization.preferences;

import org.eclipse.osgi.util.NLS;

@SuppressWarnings("all")
public class Messages extends NLS {

	/** Name of the bundle */
	private static final String BUNDLE_NAME = "org.bpy.score.internationalization.preferences.messages"; //$NON-NLS-1$

   public static String EnableProjectSetting;
   public static String ConfigureWorkspaceSetting;
	
	/*----------------------------------------------------------------------- */
	/* ControlPreferencePage class                                               */
	/*----------------------------------------------------------------------- */
	/** Control Preference Page : Fly out location label */
	public static String ControlPreferencePage_FlyOutLocationlabel;
	/** Control Preference Page : Missing Earned point label */
	public static String ControlPreferencePage_MissingEarnedPointlabel;
   /** Control level ignore */
   public static String Compile_Ignore;
   /** Control level Warning */
   public static String Compile_Warning;
   /** Control level Error */
   public static String Compile_Error;

	/*----------------------------------------------------------------------- */
	/* GameReportPreferencePage class                                         */
	/*----------------------------------------------------------------------- */
	/** Check box for use the category folder as generation folder (text) */ 
	public static String GameReportPreferencePage_useCategoryFolderButton_text;
	/** Check box for use the category folder as generation folder (Tool tip) */ 
	public static String GameReportPreferencePage_useCategoryFolderButton_tooltip;
	
	/** Label for text widget which contains the generation folder path (text)*/ 
	public static String GameReportPreferencePage_label_Textbox;
	/** Label for text widget which contains the generation folder path (tool tip)*/ 
	public static String GameReportPreferencePage_Tooltip_Textbox;
	
	/** Generation absolute path button (text)*/
	public static String GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Text;
	/** Generation absolute path button (tooltip)*/
	public static String GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Tooltip;
	/** Generation absolute path button (dialog box message) */
	public static String GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Message;
	
	/** Generation relative path button (text)*/
	public static String GameReportPreferencePage_GenerationFolderRelativePathBtn_Text;
	/** Generation relative path button (tooltip)*/
	public static String GameReportPreferencePage_GenerationFolderRelativePathBtn_Tooltip;
	
	/** Check box for use the predefined templates (text) */ 
	public static String GameReportPreferencePage_usePredefinedTemplateButton_text;
	/** Check box for use the predefined templates (Tool tip) */ 
	public static String GameReportPreferencePage_usePredefinedTemplateButton_tooltip;
	
	/** Label for text widget which contains the CSS folder file path (text)*/ 
	public static String GameReportPreferencePage_LabelCssFilePath_Text;
	/** Label for text widget which contains the CSS file path (tool tip)*/ 
	public static String GameReportPreferencePage_LabelCssFilePath_Tooltip;
	
	/** CSS Generation absolute path button (text)*/
	public static String GameReportPreferencePage_CssAbsolutePathBtn_Text;
	/** CSS Generation absolute path button (tooltip)*/
	public static String GameReportPreferencePage_CssAbsolutePathBtn_Tooltip;
	/** CSS Generation absolute path button (dialog box message) */
	public static String GameReportPreferencePage_CssAbsolutePathBtn_Message;
	
	/** CSS relative path button (text)*/
	public static String GameReportPreferencePage_CssRelativePathBtn_Text;
	/** CSS relative path button (tooltip)*/
	public static String GameReportPreferencePage_CssRelativePathBtn_Tooltip;
	
	/** Label for text widget which contains the XSLT folder file path (text)*/ 
	public static String GameReportPreferencePage_LabelXsltFilePath_Text;
	/** Label for text widget which contains the XSLT file path (tool tip)*/ 
	public static String GameReportPreferencePage_LabelXsltFilePath_Tooltip;
	
	/** XSLT Generation absolute path button (text)*/
	public static String GameReportPreferencePage_XsltAbsolutePathBtn_Text;
	/** XSLT Generation absolute path button (tooltip)*/
	public static String GameReportPreferencePage_XsltAbsolutePathBtn_Tooltip;
	/** XSLT Generation absolute path button (dialog box message) */
	public static String GameReportPreferencePage_XsltAbsolutePathBtn_Message;
	
	/** XSLT relative path button (text)*/
	public static String GameReportPreferencePage_XsltRelativePathBtn_Text;
	/** XSLT relative path button (tooltip)*/
	public static String GameReportPreferencePage_XsltRelativePathBtn_Tooltip;
	
	/** Label for text widget which contains the Banner file path (text)*/ 
	public static String GameReportPreferencePage_LabelBannerFilePath_Text;
	/** Label for text widget which contains the Banner path (tool tip)*/ 
	public static String GameReportPreferencePage_LabelBannerFilePath_Tooltip;
	
	/** Banner Generation absolute path button (text)*/
	public static String GameReportPreferencePage_BannertAbsolutePathBtn_Text;
	/** Banner Generation absolute path button (tooltip)*/
	public static String GameReportPreferencePage_BannerAbsolutePathBtn_Tooltip;
	/** Banner Generation absolute path button (dialog box message) */
	public static String GameReportPreferencePage_BannerAbsolutePathBtn_Message;
	
	/** Banner relative path button (text)*/
	public static String GameReportPreferencePage_BannerRelativePathBtn_Text;
	/** Banner relative path button (tooltip)*/
	public static String GameReportPreferencePage_BannerRelativePathBtn_Tooltip;
	
	/** Label for text widget which contains the regex (text)*/ 
	public static String GameReportPreferencePage_LabelRegex_Text;
	/** Label for text widget which contains the regex (tool tip)*/ 
	public static String GameReportPreferencePage_LabelRegex_Tooltip;
	
	/** Label for checkbox widget which select HTML expert file */ 
	public static String GameReportPreferencePage_HtmlExport_Text;
	/** Label for checkbox widget which select HTML expert file */ 
	public static String GameReportPreferencePage_HtmlExport_Tooltip;
	
	/** Label for checkbox widget which select XML expert file */ 
	public static String GameReportPreferencePage_XmlExport_Text;
	/** Label for checkbox widget which select XML expert file */ 
	public static String GameReportPreferencePage_XmlExport_Tooltip;
	
	/** Dialog title for select a relative path (title)*/ 
	public static String GameReportPreferencePage_DialogRelativePath_Title;
	/** Dialog title for select a relative path (message)*/ 
	public static String GameReportPreferencePage_DialogRelativePath_Message;
	/** Dialog error 1 for select a relative path */ 
	public static String GameReportPreferencePage_DialogError1_Title;
	/** Dialog error 2 for select a relative path */ 
	public static String GameReportPreferencePage_DialogError2_Title;
	/** Dialog error 3 for select a relative path */ 
	public static String GameReportPreferencePage_DialogError3_Title;
	/** Dialog no error for select a relative path */ 
	public static String GameReportPreferencePage_DialogNoError_Title;

	/** Dialog title for select an absolute path (title)*/ 
	public static String GameReportPreferencePage_DialogAbsolutePath_Title;
	
	/** Main report preference page description */  
	public static String ReportPreferencePage_Description;
	/** Main report preference page message */  
	public static String ReportPreferencePage_Message;

	/** Main report properties page description */  
	public static String ReportPropertiesPage_Description;
	/** Main report properties page message */  
	public static String ReportPropertiesPage_Message;

	/** CSS File check */
   public static String ReportParameterComposite_CSSConfiguration;
   /** XSLT File check */
   public static String ReportParameterComposite_XSLTConfiguration;
   /** Banner File check */
   public static String ReportParameterComposite_BannerConfiguration;
	
   /** Not a valid file name */
   public static String NotAValidFileName;
   /** Not a file */ 
   public static String NotAFile;
   /** Not a Directory */ 
   public static String NotAFolder;
   /** Bad file type */
   public static String BadFileType;
   /** Undefined error */
   public static String undefinedError;
   
	/*------------------------------------------------------------------------------*/
	/* class ProgressBarDialog                                                      */ 
	/*------------------------------------------------------------------------------*/
	public static String ProgressBarDialog_ProcessMessage;
	public static String ProgressBarDialog_ShellTitle;
	public static String ProgressBarDialog_CancelButton;

	/*------------------------------------------------------------------------------*/
	/* class ProcessThread                                                      */ 
	/*------------------------------------------------------------------------------*/
	public static String ProcessThread_PleaseWaiting;

	/*------------------------------------------------------------------------------*/
	/* class PathSelectionComposite                                                      */ 
	/*------------------------------------------------------------------------------*/
	public static String workspaceSelectorButton;
	public static String fillSystemButton;
	public static String variableButton;
	public static String pathSelectionCompositeTitle;
	public static String pathSelectionCompositeMessage;
	
   /*------------------------------------------------------------------------------*/
   /* class ScorePreferencesManager                                                     */ 
   /*------------------------------------------------------------------------------*/
	public static String typeIsNotManageByPreferences;
   public static String missingDefaultValueForPreferences;
   public static String noTypeDefinedForPreferenceValue;
   public static String badTypeElement;
	public static String cannotFindPropertyPageForKey; 
	public static String cannotFindSpecificSettingsForKey;
	public static String GameReportPreferencePage_pathSelectionComposite_text;
	public static String GameReportPreferencePage_pathSelectionComposite_1_message;
	public static String GameReportPreferencePage_pathSelectionComposite_message;
	public static String ReportPropertyPageParameters_btnCheckButton_text;
	public static String ReportPropertyPageParameters_lblNewLabel_text;

	/*----------------------------------------------------------------------- */
   /* GraphicalPreferencePage class                                               */
   /*----------------------------------------------------------------------- */
   /** Graphical Preference Page : Line Color label */
   public static String GraphicalPreferencePage_LineColorLabel;
   /** Graphical Preference Page : Pencil Color label */
   public static String GraphicalPreferencePage_PencilColorLabel;
   /** Graphical Preference Page : No statistics */
   public static String GraphicalPreferencePage_NoStatistics;
   /** Graphical Preference Page : SF1 display */
   public static String GraphicalPreferencePage_Sf1Display;
   /** Graphical Preference Page : Full display */
   public static String GraphicalPreferencePage_FullDisplay;
   /** Graphical Preference Page : Display statistics label */
   public static String GraphicalPreferencePage_DisplayStatisticsLabel;
   /** Graphical Preference Page : Display Win/Lose/Save */
   public static String GraphicalPreferencePage_DisplayWinLoseSave;
   /** Graphical Preference Page : New style sheet display */
   public static String GraphicalPreferencePage_NewStyleSheetDisplay;
   /** Preview label */
   public static String GraphicalPreferencePage_preview;
   
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
