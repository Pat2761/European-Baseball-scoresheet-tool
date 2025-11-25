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

import java.util.logging.Logger;

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.preferences.Activator;
import org.bpy.score.preferences.core.PreferenceConstants;
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.reports.generator.GameReportGenerator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;

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
	
	/** Text widget which contains the CSS file path */
	private Text cssFilePath;
	/** Text widget which contains the XSLT file path */
	private Text xsltFilePath;
	/** Text widget which contains the Banner file path */
	private Text bannerFilePath;
	/** Select predefined configuration */
	private Button btnStandardConf;

	/** state of the page two */
	private boolean isValid;
	private Button cssAbsolutePath;
	private Button xlstAbsolutePath;
	private Button bannerAbsolutePath;
	private Button bannerRelativePath;
	private Button xsltRelativePath;
	private Button cssRelativePath;
	private Label cssFilePathLabel;
	private Label xsltFilePathLabel;
	private Label bannerFilePathLabel;

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
		return cssFilePath.getText();
	}
	
	/**
	 * Get Banner file path
	 * 
	 * @return banner file path
	 */
	public String getBannerFilePath() {
		return bannerFilePath.getText();
	}
	
	/**
	 * Get XSLT file path
	 * 
	 * @return XSLT file path
	 */
	public String getXsltFilePath() {
		return xsltFilePath.getText();
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
		container.setLayout(new FormLayout());
		
		btnStandardConf = new Button(container, SWT.CHECK);
		FormData fd_btnStandardConf = new FormData();
		fd_btnStandardConf.right = new FormAttachment(0, 296);
		fd_btnStandardConf.top = new FormAttachment(0, 10);
		fd_btnStandardConf.left = new FormAttachment(0, 10);
		btnStandardConf.setLayoutData(fd_btnStandardConf);
		btnStandardConf.addSelectionListener(this);
		btnStandardConf.setSelection(true);
		btnStandardConf.setText(Messages.GameReportWizardPageTwo_UseStandardConfiguration);
		btnStandardConf.addSelectionListener(this);
		
		Composite composite = new Composite(container, SWT.BORDER);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 312);
		fd_composite.right = new FormAttachment(0, 560);
		fd_composite.top = new FormAttachment(0, 41);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(3, false));
		
		cssFilePathLabel = new Label(composite, SWT.NONE);
		cssFilePathLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 3, 1));
		cssFilePathLabel.setText(Messages.GameReportWizardPageTwo_CSSPathFile);
		
		cssFilePath = new Text(composite, SWT.BORDER);
		cssFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		cssFilePath.setEnabled(false);
		DropTarget cssTarget = new DropTarget(cssFilePath, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		Transfer[] cssTypes = new Transfer[] { FileTransfer.getInstance() };
		cssTarget.setTransfer(cssTypes);
		cssTarget.addDropListener(new DropTargetAdapter() {
			@Override
			 public void drop(DropTargetEvent event) {
				if (event.data instanceof String[]) {
					cssFilePath.setText(((String[]) event.data)[0]);
					checkIsvalid();
				}	
			}	
		});
		cssFilePath.addModifyListener(this);
		
		cssAbsolutePath = new Button(composite, SWT.NONE);
		cssAbsolutePath.setToolTipText(Messages.GameReportWizardPageTwo_cssAbsolutePath_toolTipText);
		cssAbsolutePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_text);
		
		cssRelativePath = new Button(composite, SWT.NONE);
		cssRelativePath.setToolTipText(Messages.GameReportWizardPageTwo_cssRelativePath_toolTipText);
		cssRelativePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_1_text);
		new Label(composite, SWT.NONE);
		
		xsltFilePathLabel = new Label(composite, SWT.NONE);
		xsltFilePathLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		xsltFilePathLabel.setText(Messages.GameReportWizardPageTwo_XSLTPathFile);
		
		xsltFilePath = new Text(composite, SWT.BORDER);
		xsltFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		xsltFilePath.setEnabled(false);
//		DropTarget xsltTarget = new DropTarget(xsltFilePath, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
//		xsltTarget.setTransfer(xsltTypes);
//		xsltTarget.addDropListener(new DropTargetAdapter() {
//			@Override
//			 public void drop(DropTargetEvent event) {
//				if (event.data instanceof String[]) {
//					xsltFilePath.setText(((String[]) event.data)[0]);
//					checkIsvalid();
//				}	
//			}	
//		});
		xsltFilePath.addModifyListener(this);
		
		xlstAbsolutePath = new Button(composite, SWT.NONE);
		xlstAbsolutePath.setToolTipText(Messages.GameReportWizardPageTwo_xlstAbsolutePath_toolTipText);
		xlstAbsolutePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_2_text);
		
		xsltRelativePath = new Button(composite, SWT.NONE);
		xsltRelativePath.setToolTipText(Messages.GameReportWizardPageTwo_xsltRelativePath_toolTipText);
		xsltRelativePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_3_text);
		new Label(composite, SWT.NONE);
		Transfer[] xsltTypes = new Transfer[] { FileTransfer.getInstance() };
		Transfer[] bannerTypes = new Transfer[] { FileTransfer.getInstance() };
		
		bannerFilePathLabel = new Label(composite, SWT.NONE);
		bannerFilePathLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		bannerFilePathLabel.setText(Messages.GameReportWizardPageTwo_BannerPathFile);
		
		bannerFilePath = new Text(composite, SWT.BORDER);
		bannerFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		bannerFilePath.setEnabled(false);
		DropTarget bannerTarget = new DropTarget(bannerFilePath, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		bannerTarget.setTransfer(bannerTypes);
		bannerTarget.addDropListener(new DropTargetAdapter() {
			@Override
			 public void drop(DropTargetEvent event) {
				if (event.data instanceof String[]) {
					bannerFilePath.setText(((String[]) event.data)[0]);
					checkIsvalid();
				}	
			}	
		});
		bannerFilePath.addModifyListener(this);
		
		bannerAbsolutePath = new Button(composite, SWT.NONE);
		bannerAbsolutePath.setToolTipText(Messages.GameReportWizardPageTwo_bannerAbsolutePath_toolTipText);
		bannerAbsolutePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_4_text);
		
		bannerRelativePath = new Button(composite, SWT.NONE);
		bannerRelativePath.setToolTipText(Messages.GameReportWizardPageTwo_bannerRelativePath_toolTipText);
		bannerRelativePath.setText(Messages.GameReportWizardPageTwo_btnNewButton_5_text);
		new Label(composite, SWT.NONE);

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
		cssFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_CSS_FILE_PATH));
		xsltFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_XSLT_FILE_PATH));
		bannerFilePath.setText(store.getString(PreferenceConstants.GAME_REPORT_PREFERENCE_BANNER_FILE_PATH));

		cssFilePath.setEnabled(!btnStandardConf.getSelection());
		xsltFilePath.setEnabled(!btnStandardConf.getSelection());
		bannerFilePath.setEnabled(!btnStandardConf.getSelection());

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
			isValid  = RcpUtils.isPathIsAValidFile(cssFilePath.getText()) 
					&& RcpUtils.isPathIsAValidFile(xsltFilePath.getText())
					&& RcpUtils.isPathIsAValidFile(bannerFilePath.getText());
			if (isValid) {
				setErrorMessage(null);
				setPageComplete(true);
			} else {
				setErrorMessage(Messages.GameReportWizardPageTwo_MissingFileError);
				setPageComplete(false);
			}
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
		cssFilePath.setEnabled(!btnStandardConf.getSelection());
		xsltFilePath.setEnabled(!btnStandardConf.getSelection());
		bannerFilePath.setEnabled(!btnStandardConf.getSelection());
		cssAbsolutePath.setEnabled(!btnStandardConf.getSelection());
		xlstAbsolutePath.setEnabled(!btnStandardConf.getSelection());
		bannerAbsolutePath.setEnabled(!btnStandardConf.getSelection());
		bannerRelativePath.setEnabled(!btnStandardConf.getSelection());
		xsltRelativePath.setEnabled(!btnStandardConf.getSelection());
		cssRelativePath.setEnabled(!btnStandardConf.getSelection());
		cssFilePathLabel.setEnabled(!btnStandardConf.getSelection());
		xsltFilePathLabel.setEnabled(!btnStandardConf.getSelection());
		bannerFilePathLabel.setEnabled(!btnStandardConf.getSelection());
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
		checkIsvalid();
	}

	/**
	 * Save configuration in the preference for the next call
	 */
	public void savePreference() {
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.STANDARD_PREDEFINED_FLAG, (btnStandardConf.getSelection()?"true":"false")); //$NON-NLS-1$ //$NON-NLS-2$
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.CSS_FILE_PATH, cssFilePath.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.XSLT_FILE_PATH, xsltFilePath.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.BANNER_FILE_PATH, bannerFilePath.getText());
	}
}
