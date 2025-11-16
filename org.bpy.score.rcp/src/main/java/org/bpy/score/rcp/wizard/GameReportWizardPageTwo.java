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
import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.reports.generator.GameReportGenerator;
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
	/** Button for select a CSS file */
	private Button selectCssFile;
	/** Button for select a XSLT file */
	private Button selectXsltFile;
	/** Button for select a Banner file */
	private Button selectBannerFile;
	/** Select predefined configuration */
	private Button btnStandardConf;

	/** state of the page two */
	private boolean isValid;

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
		
		btnStandardConf = new Button(container, SWT.CHECK);
		btnStandardConf.addSelectionListener(this);
		btnStandardConf.setSelection(true);
		btnStandardConf.setBounds(10, 10, 286, 16);
		btnStandardConf.setText(Messages.GameReportWizardPageTwo_UseStandardConfiguration);
		btnStandardConf.addSelectionListener(this);
		
		Composite composite = new Composite(container, SWT.BORDER);
		composite.setBounds(10, 41, 550, 216);
		
		Label lblCheminDuFichier = new Label(composite, SWT.NONE);
		lblCheminDuFichier.setBounds(10, 25, 171, 15);
		lblCheminDuFichier.setText(Messages.GameReportWizardPageTwo_CSSPathFile);
		
		cssFilePath = new Text(composite, SWT.BORDER);
		cssFilePath.setEnabled(false);
		cssFilePath.setBounds(10, 46, 469, 21);
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
		
		selectCssFile = new Button(composite, SWT.NONE);
		selectCssFile.setEnabled(false);
		selectCssFile.setBounds(485, 46, 51, 21);
		selectCssFile.setText(SELECT_FILE_BUTTOB_TEXT);
		selectCssFile.addSelectionListener(this);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.GameReportWizardPageTwo_XSLTPathFile);
		label.setBounds(10, 77, 171, 15);
		
		xsltFilePath = new Text(composite, SWT.BORDER);
		xsltFilePath.setEnabled(false);
		xsltFilePath.setBounds(10, 98, 469, 21);
		DropTarget xsltTarget = new DropTarget(xsltFilePath, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		Transfer[] xsltTypes = new Transfer[] { FileTransfer.getInstance() };
		xsltTarget.setTransfer(xsltTypes);
		xsltTarget.addDropListener(new DropTargetAdapter() {
			@Override
			 public void drop(DropTargetEvent event) {
				if (event.data instanceof String[]) {
					xsltFilePath.setText(((String[]) event.data)[0]);
					checkIsvalid();
				}	
			}	
		});
		xsltFilePath.addModifyListener(this);
		
		Label labelBanner = new Label(composite, SWT.NONE);
		labelBanner.setText(Messages.GameReportWizardPageTwo_BannerPathFile);
		labelBanner.setBounds(10, 125, 171, 15);
		
		bannerFilePath = new Text(composite, SWT.BORDER);
		bannerFilePath.setEnabled(false);
		bannerFilePath.setBounds(10, 145, 469, 21);
		DropTarget bannerTarget = new DropTarget(bannerFilePath, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		Transfer[] bannerTypes = new Transfer[] { FileTransfer.getInstance() };
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

		
		selectXsltFile = new Button(composite, SWT.NONE);
		selectXsltFile.setEnabled(false);
		selectXsltFile.setText(SELECT_FILE_BUTTOB_TEXT);
		selectXsltFile.setBounds(485, 98, 51, 21);
		selectXsltFile.addSelectionListener(this);
		
		selectBannerFile = new Button(composite, SWT.NONE);
		selectBannerFile.setEnabled(false);
		selectBannerFile.setText(SELECT_FILE_BUTTOB_TEXT);
		selectBannerFile.setBounds(485, 145, 51, 21);
		selectBannerFile.addSelectionListener(this);

		
		checkIsvalid();
	}

	@Override
	public void setVisible(boolean visible) {
		
		btnStandardConf.setSelection(("true".equals(RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.STANDARD_CONFIGURATION_FLAG)))); //$NON-NLS-1$
		cssFilePath.setText(RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.CSS_FILE_PATH));
		xsltFilePath.setText(RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.XSLT_FILE_PATH));
		bannerFilePath.setText(RcpUtils.getPreferneceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.BANNER_FILE_PATH));

		cssFilePath.setEnabled(!btnStandardConf.getSelection());
		selectCssFile.setEnabled(!btnStandardConf.getSelection());
		xsltFilePath.setEnabled(!btnStandardConf.getSelection());
		selectXsltFile.setEnabled(!btnStandardConf.getSelection());
		bannerFilePath.setEnabled(!btnStandardConf.getSelection());
		selectBannerFile.setEnabled(!btnStandardConf.getSelection());

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
				setErrorMessage("Tous les chemins doivent être renseignés");
				setPageComplete(false);
			}
		}
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == btnStandardConf) {
			cssFilePath.setEnabled(!btnStandardConf.getSelection());
			selectCssFile.setEnabled(!btnStandardConf.getSelection());
			xsltFilePath.setEnabled(!btnStandardConf.getSelection());
			selectXsltFile.setEnabled(!btnStandardConf.getSelection());
			bannerFilePath.setEnabled(!btnStandardConf.getSelection());
			selectBannerFile.setEnabled(!btnStandardConf.getSelection());
			checkIsvalid();
		
		} else if (e.getSource() == selectCssFile) {
			selectFile(Messages.GameReportWizardPageTwo_CSSSelectionMessage, cssFilePath);
			
		} else if (e.getSource() == selectBannerFile) {
			selectFile(Messages.GameReportWizardPageTwo_BannerSelectionMessage, bannerFilePath);
			
		} else if (e.getSource() == selectXsltFile) {
			selectFile(Messages.GameReportWizardPageTwo_XSLTSelectionMessage, xsltFilePath);
		
	    }
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
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.STANDARD_CONFIGURATION_FLAG, (btnStandardConf.getSelection()?"true":"false"));
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.CSS_FILE_PATH, cssFilePath.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.XSLT_FILE_PATH, xsltFilePath.getText());
		RcpUtils.setPreferenceValue(generateGameReportWizard.getCurrentFolder(), GameReportGenerator.BANNER_FILE_PATH, bannerFilePath.getText());
	}

}
