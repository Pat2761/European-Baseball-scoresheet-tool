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
package org.bpy.score.preferences.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.internationalization.preferences.Messages;
import org.bpy.score.preferences.Activator;
import org.bpy.score.preferences.core.PreferenceConstants;
import org.bpy.score.preferences.core.PreferenceManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.ui.preferences.PropertyAndPreferencePage;
import org.osgi.service.prefs.BackingStoreException;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

/**
 * Preference page for setting the Game report generation preferences
 * 
 * @author Patrick BRIAND
 */
@SuppressWarnings("restriction")
public class GameReportPreferencePage extends PropertyAndPreferencePage implements IWorkbenchPreferencePage {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportPreferencePage.class.getCanonicalName());

	/** Text widget which contains the generation folder path */
	private Text generationFolder;
	/** Text widget which contains the CSS file path */
	private Text cssFilePath;
	/** Text widget which contains the XSLT file path */
	private Text xsltFilePath;
	/** Text widget which contains the banner file path */
	private Text bannerFilePath;
	/** Text widget which contains the regex file path */
	private Text regexselectionFolder;
	/** Check box for export the report in a XML File */
	private Button exportAsXmlBtn;
	/** Check box for export the report in a HTML File */
	private Button exportAsHtmlBtn;

	/** Check box for use the default generation folder */
	private Button useCategoryFolderButton;
	/** Check box for use the standard style sheet */
	private Button useStandardXSLT;

	/** Button for selection the generation folder path (absolute path) */
	private Button generationFolderAbsolutePathBtn;
	/** Button for selection the generation folder path (relative project path) */
	private Button generationFolderRelativePathBtn;
	/** Button for selection the CSS file path (absolute path) */
	private Button cssFolderAbsolutePathBtn;
	/** Button for selection the CSS file path (relative project path) */
	private Button cssFolderRelativePathBtn;
	/** Button for selection the XSLT file path (absolute path) */
	private Button xsltFolderAbsolutePathBtn;
	/** Button for selection the XSLT file path (relative project path) */
	private Button xsltFolderRelativePathBtn;

	/** reference on the preference store */
	private IPreferenceStore store = Activator.getDefault().getPreferenceStore();

	/**
	 * Constructor of the page
	 */
	public GameReportPreferencePage() {
		// nothing to do
	}

	@Override
	public void init(IWorkbench workbench) {
		// nothing to do
	}		
		
	@Override
	protected Control createPreferenceContent(Composite parent, IPreferencePageContainer preferencePageContainer) {
		Composite fieldEditorParent = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 5;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		fieldEditorParent.setLayout(layout);
		fieldEditorParent.setFont(parent.getFont());

		useCategoryFolderButton = new Button(fieldEditorParent, SWT.CHECK);
		useCategoryFolderButton.setSelection(true);
		useCategoryFolderButton.setToolTipText(Messages.GameReportPreferencePage_useCategoryFolderButton_tooltip);
		useCategoryFolderButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		useCategoryFolderButton.setText(Messages.GameReportPreferencePage_useCategoryFolderButton_text);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		useCategoryFolderButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				manageButtonSelection(e);
			}
		});

		Label lblNewLabel = new Label(fieldEditorParent, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText(Messages.GameReportPreferencePage_label_Textbox);

		generationFolder = new Text(fieldEditorParent, SWT.BORDER);
		generationFolder.setEnabled(false);
		generationFolder.setToolTipText(Messages.GameReportPreferencePage_Tooltip_Textbox);
		generationFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		generationFolderAbsolutePathBtn = new Button(fieldEditorParent, SWT.NONE);
		generationFolderAbsolutePathBtn.setEnabled(false);
		generationFolderAbsolutePathBtn.setToolTipText(Messages.GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Tooltip);
		GridData gdGenerationFolderAbsolutePathBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gdGenerationFolderAbsolutePathBtn.widthHint = 100;
		generationFolderAbsolutePathBtn.setLayoutData(gdGenerationFolderAbsolutePathBtn);
		generationFolderAbsolutePathBtn.setText(Messages.GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Text);
		generationFolderAbsolutePathBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				getAbsoluteLocation(generationFolder, IResource.FOLDER, Messages.GameReportPreferencePage_GenerationFolderAbsolutePathBtn_Message);
			}
		});

		generationFolderRelativePathBtn = new Button(fieldEditorParent, SWT.NONE);
		generationFolderRelativePathBtn.setEnabled(false);
		generationFolderRelativePathBtn.setToolTipText(Messages.GameReportPreferencePage_GenerationFolderRelativePathBtn_Tooltip);
		GridData gdGenerationFolderRelativePathBtn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gdGenerationFolderRelativePathBtn.widthHint = 100;
		generationFolderRelativePathBtn.setLayoutData(gdGenerationFolderRelativePathBtn);
		generationFolderRelativePathBtn.setText(Messages.GameReportPreferencePage_GenerationFolderRelativePathBtn_Text);
		generationFolderRelativePathBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				getWorkspaceLocation(generationFolder, IResource.FOLDER);
			}
		});

		new Label(fieldEditorParent, SWT.NONE);

		useStandardXSLT = new Button(fieldEditorParent, SWT.CHECK);
		useStandardXSLT.setSelection(true);
		useStandardXSLT.setToolTipText(Messages.GameReportPreferencePage_usePredefinedTemplateButton_tooltip);
		useStandardXSLT.setText(Messages.GameReportPreferencePage_usePredefinedTemplateButton_text);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		useStandardXSLT.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				manageButtonSelection(e);
			}
		});

		Label lblCssFilePath = new Label(fieldEditorParent, SWT.NONE);
		lblCssFilePath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCssFilePath.setText(Messages.GameReportPreferencePage_LabelCssFilePath_Text);

		cssFilePath = new Text(fieldEditorParent, SWT.BORDER);
		cssFilePath.setEnabled(false);
		cssFilePath.setToolTipText(Messages.GameReportPreferencePage_LabelCssFilePath_Tooltip);
		cssFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		cssFolderAbsolutePathBtn = new Button(fieldEditorParent, SWT.NONE);
		cssFolderAbsolutePathBtn.setEnabled(false);
		cssFolderAbsolutePathBtn.setToolTipText(Messages.GameReportPreferencePage_CssAbsolutePathBtn_Tooltip);
		GridData gdCssFolderAbsolutePathBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gdCssFolderAbsolutePathBtn.widthHint = 100;
		cssFolderAbsolutePathBtn.setLayoutData(gdCssFolderAbsolutePathBtn);
		cssFolderAbsolutePathBtn.setText(Messages.GameReportPreferencePage_CssAbsolutePathBtn_Text);
		cssFolderAbsolutePathBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				getAbsoluteLocation(cssFilePath, IResource.FILE, Messages.GameReportPreferencePage_CssAbsolutePathBtn_Message);
			}
		});

		cssFolderRelativePathBtn = new Button(fieldEditorParent, SWT.NONE);
		cssFolderRelativePathBtn.setEnabled(false);
		cssFolderRelativePathBtn.setToolTipText(Messages.GameReportPreferencePage_CssRelativePathBtn_Tooltip);
		GridData gdCssFolderRelativePathBtn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gdCssFolderRelativePathBtn.widthHint = 100;
		cssFolderRelativePathBtn.setLayoutData(gdCssFolderRelativePathBtn);
		cssFolderRelativePathBtn.setText(Messages.GameReportPreferencePage_CssRelativePathBtn_Text);
		cssFolderRelativePathBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getWorkspaceLocation(cssFilePath, IResource.FILE);
			}
		});
		new Label(fieldEditorParent, SWT.NONE);

		Label lblXsltPath = new Label(fieldEditorParent, SWT.NONE);
		lblXsltPath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblXsltPath.setText(Messages.GameReportPreferencePage_LabelXsltFilePath_Text);

		xsltFilePath = new Text(fieldEditorParent, SWT.BORDER);
		xsltFilePath.setEnabled(false);
		xsltFilePath.setToolTipText(Messages.GameReportPreferencePage_LabelXsltFilePath_Tooltip);
		xsltFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		xsltFolderAbsolutePathBtn = new Button(fieldEditorParent, SWT.NONE);
		xsltFolderAbsolutePathBtn.setEnabled(false);
		xsltFolderAbsolutePathBtn.setToolTipText(Messages.GameReportPreferencePage_XsltAbsolutePathBtn_Tooltip);
		GridData gdXsltFolderAbsolutePathBtn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gdXsltFolderAbsolutePathBtn.widthHint = 100;
		xsltFolderAbsolutePathBtn.setLayoutData(gdXsltFolderAbsolutePathBtn);
		xsltFolderAbsolutePathBtn.setText(Messages.GameReportPreferencePage_XsltAbsolutePathBtn_Text);
		xsltFolderAbsolutePathBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				getAbsoluteLocation(xsltFilePath, IResource.FILE, Messages.GameReportPreferencePage_XsltAbsolutePathBtn_Message);
			}
		});

		xsltFolderRelativePathBtn = new Button(fieldEditorParent, SWT.NONE);
		xsltFolderRelativePathBtn.setEnabled(false);
		xsltFolderRelativePathBtn.setToolTipText(Messages.GameReportPreferencePage_XsltRelativePathBtn_Tooltip);
		GridData gdXsltFolderRelativePathBtn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gdXsltFolderRelativePathBtn.widthHint = 100;
		xsltFolderRelativePathBtn.setLayoutData(gdXsltFolderRelativePathBtn);
		xsltFolderRelativePathBtn.setText(Messages.GameReportPreferencePage_XsltRelativePathBtn_Text);
		xsltFolderRelativePathBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getWorkspaceLocation(xsltFilePath, IResource.FILE);
			}
		});
		new Label(fieldEditorParent, SWT.NONE);

		Label lblBannerFilePath = new Label(fieldEditorParent, SWT.NONE);
		lblBannerFilePath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBannerFilePath.setText(Messages.GameReportPreferencePage_LabelBannerFilePath_Text);

		bannerFilePath = new Text(fieldEditorParent, SWT.BORDER);
		bannerFilePath.setToolTipText(Messages.GameReportPreferencePage_LabelBannerFilePath_Tooltip);
		bannerFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		Button bannerFolderAbsolutePathBtn = new Button(fieldEditorParent, SWT.NONE);
		bannerFolderAbsolutePathBtn.setToolTipText(Messages.GameReportPreferencePage_BannerAbsolutePathBtn_Tooltip);
		GridData gdBannerFolderAbsolutePathBtn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gdBannerFolderAbsolutePathBtn.widthHint = 100;
		bannerFolderAbsolutePathBtn.setLayoutData(gdBannerFolderAbsolutePathBtn);
		bannerFolderAbsolutePathBtn.setText(Messages.GameReportPreferencePage_BannertAbsolutePathBtn_Text);
		bannerFolderAbsolutePathBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				getAbsoluteLocation(bannerFilePath, IResource.FILE, Messages.GameReportPreferencePage_BannerAbsolutePathBtn_Message);
			}
		});

		Button bannerFolderRelativePathBtn = new Button(fieldEditorParent, SWT.NONE);
		bannerFolderRelativePathBtn.setToolTipText(Messages.GameReportPreferencePage_BannerRelativePathBtn_Tooltip);
		GridData gdBannerFolderRelativePathBtn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gdBannerFolderRelativePathBtn.widthHint = 100;
		bannerFolderRelativePathBtn.setLayoutData(gdBannerFolderRelativePathBtn);
		bannerFolderRelativePathBtn.setText(Messages.GameReportPreferencePage_BannerRelativePathBtn_Text);
		bannerFolderRelativePathBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getWorkspaceLocation(bannerFilePath, IResource.FILE);
			}
		});
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		Label lblRegexSelectionFile = new Label(fieldEditorParent, SWT.NONE);
		lblRegexSelectionFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRegexSelectionFile.setText(Messages.GameReportPreferencePage_LabelRegex_Text);

		regexselectionFolder = new Text(fieldEditorParent, SWT.BORDER);
		regexselectionFolder.setToolTipText(Messages.GameReportPreferencePage_LabelRegex_Tooltip);
		regexselectionFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);

		exportAsHtmlBtn = new Button(fieldEditorParent, SWT.RADIO);
		exportAsHtmlBtn.setSelection(true);
		exportAsHtmlBtn.setToolTipText(Messages.GameReportPreferencePage_HtmlExport_Tooltip);
		exportAsHtmlBtn.setText(Messages.GameReportPreferencePage_HtmlExport_Text);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		exportAsHtmlBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				manageButtonSelection(e);
			}
		});

		exportAsXmlBtn = new Button(fieldEditorParent, SWT.RADIO);
		exportAsXmlBtn.setToolTipText(Messages.GameReportPreferencePage_XmlExport_Tooltip);
		exportAsXmlBtn.setText(Messages.GameReportPreferencePage_XmlExport_Text);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		new Label(fieldEditorParent, SWT.NONE);
		exportAsXmlBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				manageButtonSelection(e);
			}
		});

		return fieldEditorParent;
	}

	@Override
	protected void performDefaults() {
		useCategoryFolderButton.setSelection(store.getDefaultBoolean(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_CATEGORY_GENERATION_FOLDER));
		useStandardXSLT.setSelection(store.getDefaultBoolean(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_STANDARD_FORMATTER));

		generationFolder.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_GENERATION_FOLDER));
		cssFilePath.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_CSS_FILE_PATH));
		xsltFilePath.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_XSLT_FILE_PATH));
		bannerFilePath.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_BANNER_FILE_PATH));
		
		regexselectionFolder.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_REGEX_SELECTION_FILE));

		String documentStyle = store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_GENERATED_FILE);
		if (PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_XML.equals(documentStyle)) {
			exportAsXmlBtn.setSelection(true);
			exportAsHtmlBtn.setSelection(false);
		} else {
			exportAsXmlBtn.setSelection(false);
			exportAsHtmlBtn.setSelection(true);
		}

		updateState();
	}


	@Override
	protected void performApply() {
		storePreferences();
		super.performApply();
	}

	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}

	/**
	 * Store the preferences.
	 * 
	 */
	private void storePreferences() {
		if (getElement() != null) {
			storeValue(PreferenceConstants.PROPERTIE_USE_PROJECT_SETTINGS, useProjectSettings());
		}
		
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_CATEGORY_GENERATION_FOLDER, useCategoryFolderButton.getSelection());
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_CATEGORY_GENERATION_FOLDER, useCategoryFolderButton.getSelection());
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_STANDARD_FORMATTER, useStandardXSLT.getSelection());

		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_GENERATION_FOLDER, generationFolder.getText());
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_CSS_FILE_PATH, cssFilePath.getText());
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_XSLT_FILE_PATH, xsltFilePath.getText());
		storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_BANNER_FILE_PATH, bannerFilePath.getText());

		storeValue(PreferenceConstants.GAME_REPORT_REGEX_SELECTION_FILE, regexselectionFolder.getText());

		if (exportAsXmlBtn.getSelection()) {
			storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_GENERATED_FILE, PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_XML);
		} else {
			storeValue(PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_GENERATED_FILE, PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_HTML);
		}
		
		if (getElement() != null) {
			try {
				PreferenceManager.flushProjectPreference((IProject) getElement());
			} catch (BackingStoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}


	/**
	 * Allow to select a formatted string which represents a variable expression of
	 * a resource
	 * 
	 * @param textToUpdate text widget which receive the selection
	 * @param type         type of resource to select (IResource.FOLDER or
	 *                     IResource.FILE)
	 */
	private void getWorkspaceLocation(Text textToUpdate, int type) {

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(),new WorkbenchContentProvider());
		dialog.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (type == IResource.FOLDER) {
					return (element instanceof IProject) || (element instanceof IFolder);
				} else {
					return (element instanceof IProject) || (element instanceof IFolder) || (element instanceof IFile);
				}

			}
		});

		dialog.setTitle(Messages.GameReportPreferencePage_DialogRelativePath_Title);
		dialog.setValidator(selection -> {

			if (selection.length == 0) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportPreferencePage_DialogError1_Title, null);
			} else if (selection.length > 1) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportPreferencePage_DialogError2_Title, null);
			} else if ((type == IResource.FILE) && !(selection[0] instanceof IFile)) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.GameReportPreferencePage_DialogError3_Title, null);
			}
			return new Status(IStatus.OK, Activator.PLUGIN_ID, 0, Messages.GameReportPreferencePage_DialogNoError_Title, null);
		});

		dialog.setMessage(Messages.GameReportPreferencePage_DialogRelativePath_Message);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		if (dialog.open() == IDialogConstants.OK_ID) {
			IResource resource = (IResource) dialog.getFirstResult();
			if (resource != null) {
				String arg = resource.getFullPath().toString();
				String fileLoc = VariablesPlugin.getDefault().getStringVariableManager().generateVariableExpression("workspace_loc", arg); //$NON-NLS-1$
				textToUpdate.setText(fileLoc);
			}
		}
	}

	@Override
	public void setVisible(boolean visible) {
		
		if (getElement() != null) {
			boolean state = getStoreBooleanValue(PreferenceConstants.PROPERTIE_USE_PROJECT_SETTINGS);
			enableProjectSpecificSettings(state);
		}
		
		useCategoryFolderButton.setSelection(getStoreBooleanValue(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_CATEGORY_GENERATION_FOLDER));
		useStandardXSLT.setSelection(getStoreBooleanValue(PreferenceConstants.GAME_REPORT_PREFERENCE_USE_STANDARD_FORMATTER));

		generationFolder.setText(getStoreStringValue(PreferenceConstants.GAME_REPORT_PREFERENCE_GENERATION_FOLDER));
		cssFilePath.setText(getStoreStringValue(PreferenceConstants.GAME_REPORT_PREFERENCE_CSS_FILE_PATH));
		xsltFilePath.setText(getStoreStringValue(PreferenceConstants.GAME_REPORT_PREFERENCE_XSLT_FILE_PATH));

		regexselectionFolder.setText(getStoreStringValue(PreferenceConstants.GAME_REPORT_REGEX_SELECTION_FILE));

		String documentStyle = getStoreStringValue(PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_GENERATED_FILE);

		if (PreferenceConstants.GAME_REPORT_PREFERENCE_TYPE_XML.equals(documentStyle)) {
			exportAsXmlBtn.setSelection(true);
			exportAsHtmlBtn.setSelection(false);
		} else {
			exportAsXmlBtn.setSelection(false);
			exportAsHtmlBtn.setSelection(true);
		}
		updateState();
		super.setVisible(visible);
	}

	@Override
	protected void enablePreferenceContent(boolean enable) {
		updateState();
		super.enablePreferenceContent(enable);
	}

	/**
	 * Manage the radio button selection event of the page
	 * 
	 * @param e reference to the event
	 */
	protected void manageButtonSelection(SelectionEvent e) {
		if (e.getSource() == exportAsHtmlBtn) {
			exportAsXmlBtn.setSelection(!exportAsHtmlBtn.getSelection());

		} else if (e.getSource() == exportAsXmlBtn) {
			exportAsHtmlBtn.setSelection(!exportAsXmlBtn.getSelection());

		} else if (e.getSource() == useCategoryFolderButton) {
			generationFolder.setEnabled(!useCategoryFolderButton.getSelection());
			generationFolderAbsolutePathBtn.setEnabled(!useCategoryFolderButton.getSelection());
			generationFolderRelativePathBtn.setEnabled(!useCategoryFolderButton.getSelection());

		} else if (e.getSource() == useStandardXSLT) {
			cssFilePath.setEnabled(!useStandardXSLT.getSelection());
			cssFolderAbsolutePathBtn.setEnabled(!useStandardXSLT.getSelection());
			cssFolderRelativePathBtn.setEnabled(!useStandardXSLT.getSelection());
			xsltFilePath.setEnabled(!useStandardXSLT.getSelection());
			xsltFolderAbsolutePathBtn.setEnabled(!useStandardXSLT.getSelection());
			xsltFolderRelativePathBtn.setEnabled(!useStandardXSLT.getSelection());
		}
	}

	/**
	 * Update the state os the widgets in function of their values
	 */
	private void updateState() {
		exportAsXmlBtn.setSelection(!exportAsHtmlBtn.getSelection());
		exportAsHtmlBtn.setSelection(!exportAsXmlBtn.getSelection());

		generationFolder.setEnabled(!useCategoryFolderButton.getSelection());
		generationFolderAbsolutePathBtn.setEnabled(!useCategoryFolderButton.getSelection());
		generationFolderRelativePathBtn.setEnabled(!useCategoryFolderButton.getSelection());

		cssFilePath.setEnabled(!useStandardXSLT.getSelection());
		cssFolderAbsolutePathBtn.setEnabled(!useStandardXSLT.getSelection());
		cssFolderRelativePathBtn.setEnabled(!useStandardXSLT.getSelection());
		xsltFilePath.setEnabled(!useStandardXSLT.getSelection());
		xsltFolderAbsolutePathBtn.setEnabled(!useStandardXSLT.getSelection());
		xsltFolderRelativePathBtn.setEnabled(!useStandardXSLT.getSelection());
	}

	@Override
	protected boolean hasProjectSpecificOptions(IProject project) {
		return false;
	}

	@Override
	protected String getPreferencePageID() {
		return "org.bpy.score.preference.reports.game"; //$NON-NLS-1$
	}

	@Override
	protected String getPropertyPageID() {
		return "org.bpy.score.property.reports.game"; //$NON-NLS-1$
	}

	/**
	 * get a boolean preference value
	 * @param key key of the preference value
	 * 
	 * @return <b>true</b> or <b>false</b>
	 */
	private boolean getStoreBooleanValue(String key) {
		IProject project = (IProject) getElement();
		if (getProject() != null) {
			return PreferenceManager.getProjectProperty(project, key, false);
		} else {
			return store.getBoolean(key);
		}
	}

	/**
	 * get a string value for a preference
	 * 
	 * @param key key of the preference value
	 * @return String value
	 */
	private String getStoreStringValue(String key) {
		IProject project = (IProject) getElement();
		if (getProject() != null) {
			return PreferenceManager.getProjectProperty(project, key, ""); //$NON-NLS-1$
		} else {
			return store.getString(key);
		}
	}

	/**
	 * Store a boolean preference value
	 * 
	 * @param key key of the preference value
	 * @param value value to store
	 */
	private void storeValue(String key, String value) {
		IProject project = (IProject) getElement();
		if (getProject() != null) {
			PreferenceManager.setProjectProperty(project, key, value);
		} else {
			store.setValue(key, value);
		}
	}

	/**
	 * Store a String preference value
	 * 
	 * @param key key of the preference value
	 * @param value value to store
	 */
	private void storeValue(String key, boolean value) {
		IProject project = (IProject) getElement();
		if (getProject() != null) {
			PreferenceManager.setProjectProperty(project, key, value);
		} else {
			store.setValue(key, value);
		}
	}

	/**
	 * Get an absolute path. 
	 * 
	 * @param textToUpdate Text widget to update with the selected value
	 * @param type Folder of file
	 * @param message A message to display in the dialog box
	 */
	private void getAbsoluteLocation(Text textToUpdate, int type, String message) {

		if (type == IResource.FOLDER) {
			getAbsoluteDirectoryLocation(textToUpdate, message);
		} else {
			getAbsoluteFileLocation(textToUpdate, message);
		}
	}

	/**
	 * Get an absolute path for a file
	 * 
	 * @param textToUpdate Text widget to update with the selected file path
	 * @param message A message to display in the dialog box
	 */
	private void getAbsoluteFileLocation(Text textToUpdate, String message) {
		FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		dialog.setText(message);

		if (!textToUpdate.getText().isBlank() && !textToUpdate.getText().startsWith("${")) { //$NON-NLS-1$
			dialog.setFilterPath(textToUpdate.getText());
		} else {
			dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		}

		String result = dialog.open();
		if (result != null) {
			textToUpdate.setText(result);
		}
	}

	/**
	 * Get an absolute path for a folder
	 * 
	 * @param textToUpdate Text widget to update with the selected folder path
	 * @param message A message to display in the dialog box
	 */
	private void getAbsoluteDirectoryLocation(Text textToUpdate, String message) {
		DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
		dialog.setText(Messages.GameReportPreferencePage_DialogAbsolutePath_Title);
		dialog.setMessage(message);

		if (!textToUpdate.getText().isBlank() && !textToUpdate.getText().startsWith("${")) { //$NON-NLS-1$
			dialog.setFilterPath(textToUpdate.getText());
		} else {
			dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		}

		String result = dialog.open();
		if (result != null) {
			textToUpdate.setText(result);
		}
	}
}
