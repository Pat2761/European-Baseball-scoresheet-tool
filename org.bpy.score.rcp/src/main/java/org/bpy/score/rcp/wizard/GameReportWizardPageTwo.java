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
package org.bpy.score.rcp.wizard;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Logger;

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.preferences.Activator;
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.bpy.score.preferences.ui.PathSelectionComposite;

/**
 * This class is the page one of generation report wizard.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameReportWizardPageTwo extends WizardPage implements SelectionListener,ModifyListener {
	
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(GameReportWizardPageOne.class.getSimpleName());
	
	/** Select file button text */
	public static final String SELECT_FILE_BUTTOB_TEXT = "..."; //$NON-NLS-1$
	
	/** Game extension constant */
	private GenerateGameReportWizard generateGameReportWizard;
	/** Select predefined configuration */
	private Button btnStandardConf;

	/** state of the page two */
	private boolean isValid;

	private PathSelectionComposite cssFilePath;
	private PathSelectionComposite xsltFilePath;
	private PathSelectionComposite bannerFilePath;

	/**
	 * Create the wizard.
	 */
	public GameReportWizardPageTwo() {
		super("wizardPage"); //$NON-NLS-1$
		setMessage(Messages.GameReportWizardPageTwo_PageMessage);
		setTitle(Messages.GameReportWizardPageTwo_PageTitle);
		setDescription(Messages.GameReportWizardPageTwo_PageDescription);
		isValid = false;
	}

	/**
	 * Set Reference on the game report wizard
	 * 
	 * @param generateGameReportWizard Reference on the game report wizard
	 */
	public void setParent(GenerateGameReportWizard generateGameReportWizard) {
		this.generateGameReportWizard = generateGameReportWizard; 
	}

	/**
	 * Return the state of the page one
	 * 
	 * @return <b>true</b> is valid, <b>false</b> otherwise
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Get CSS file path
	 * 
	 * @return CSS file path
	 */
	public String getCssFilePath() {
		return cssFilePath.getResolvedAbsolutePath();
	}
	
	/**
	 * Get Banner file path
	 * 
	 * @return banner file path
	 */
	public String getBannerFilePath() {
		return bannerFilePath.getResolvedAbsolutePath();
	}
	
	/**
	 * Get XSLT file path
	 * 
	 * @return XSLT file path
	 */
	public String getXsltFilePath() {
		return xsltFilePath.getResolvedAbsolutePath();
	}
	
	/**
	 * Get standard configuration (use predefined CSS, XSTL and banner)
	 * 
	 * @return <b>true</b> predefined configuration, <b>false</b> otherwise
	 */
	public boolean isStandardConf() {
		return btnStandardConf.getSelection();
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		btnStandardConf = new Button(container, SWT.CHECK);
		btnStandardConf.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnStandardConf.addSelectionListener(this);
		btnStandardConf.setSelection(true);
		btnStandardConf.setText(Messages.GameReportWizardPageTwo_UseStandardConfiguration);
		
		Group grpTtt = new Group(container, SWT.NONE);
		grpTtt.setLayout(new GridLayout(1, false));
		grpTtt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		grpTtt.setText(Messages.GameReportWizardPageTwo_grpTtt_text);
		
		cssFilePath = new PathSelectionComposite(grpTtt, SWT.NONE);
		cssFilePath.setMessage(Messages.GameReportWizardPageTwo_CSSPathFile);
		cssFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cssFilePath.setFeatures(IResource.FILE, new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().toLowerCase().endsWith(".css");
			}
		});
		
		xsltFilePath = new PathSelectionComposite(grpTtt, SWT.NONE);
		xsltFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		xsltFilePath.setMessage(Messages.GameReportWizardPageTwo_XSLTPathFile);
		xsltFilePath.setFeatures(IResource.FILE, new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().toLowerCase().endsWith(".xslt");
			}
		});
		 
		bannerFilePath = new PathSelectionComposite(grpTtt, SWT.NONE);
		bannerFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		bannerFilePath.setMessage(Messages.GameReportWizardPageTwo_BannerPathFile);
		bannerFilePath.setFeatures(IResource.FILE, new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && 
					( file.getName().toLowerCase().endsWith(".jpg") ||
					  file.getName().toLowerCase().endsWith(".png"));
			}
		});
		
		
		btnStandardConf.addSelectionListener(this);
		Transfer[] cssTypes = new Transfer[] { FileTransfer.getInstance() };
		Transfer[] xsltTypes = new Transfer[] { FileTransfer.getInstance() };
		Transfer[] bannerTypes = new Transfer[] { FileTransfer.getInstance() };

//		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
//		generationFolder.setText(store.getDefaultString(PreferenceConstants.GAME_REPORT_PREFERENCE_GENERATION_FOLDER));
//		cssFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_CSS_FILE_PATH));
//		xsltFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_XSLT_FILE_PATH));
//		bannerFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_BANNER_FILE_PATH));

		updateButtonState();
		checkIsvalid();
	}

	@Override
	public void setVisible(boolean visible) {
		
		btnStandardConf.setSelection(("true".equals(RcpUtils.getPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.STANDARD_PREDEFINED_FLAG)))); //$NON-NLS-1$

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		checkIsvalid();
		
		super.setVisible(visible);
	}

	/**
	 * Check if page one is valid
	 */
	private void checkIsvalid() {
		if (btnStandardConf.getSelection()) {
			isValid = true;
			
			setErrorMessage(null);
			setPageComplete(true);
			
		} else {
//			isValid  = RcpUtils.isPathIsAValidFile(cssFilePath.getText()) 
//					&& RcpUtils.isPathIsAValidFile(xsltFilePath.getText())
//					&& RcpUtils.isPathIsAValidFile(bannerFilePath.getText());
//			if (isValid) {
//				setErrorMessage(null);
//				setPageComplete(true);
//			} else {
//				setErrorMessage(Messages.GameReportWizardPageTwo_MissingFileError);
//				setPageComplete(false);
//			}
		}
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == btnStandardConf) {
			updateButtonState();
			checkIsvalid();
		}	
	}

	private void updateButtonState() {
	}

	/**
	 * Common file selection
	 * 
	 * @param message Message to display
	 * @param textWidget target text widget 
	 */
	private void selectFile(String message, Text textWidget) {
		FileDialog	fileDialog = new FileDialog(new Shell());
		fileDialog.setText(message);
		String path = fileDialog.open();
		
		if (path != null) {
			textWidget.setText(path);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// not used
	}

	@Override
	public void modifyText(ModifyEvent e) {
	}

	/**
	 * Save configuration in the preference for the next call
	 */
	public void savePreference() {
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.STANDARD_PREDEFINED_FLAG, (btnStandardConf.getSelection()?"true":"false")); //$NON-NLS-1$ //$NON-NLS-2$
//		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.CSS_FILE_PATH, cssFilePath.getText());
//		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.XSLT_FILE_PATH, xsltFilePath.getText());
//		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.BANNER_FILE_PATH, bannerFilePath.getText());
	}
}
