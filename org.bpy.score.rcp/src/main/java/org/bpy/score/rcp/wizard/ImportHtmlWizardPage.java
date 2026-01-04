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

import org.bpy.score.internationalization.rcp.Messages;
import org.bpy.score.preferences.ui.IPathSelectionCompositeChange;
import org.bpy.score.preferences.ui.PathSelectionComposite;
import org.bpy.score.preferences.ui.PathSelectionCompositeStatus;
import org.bpy.score.preferences.ui.PathSelectionFileFilter;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

/**
 *  This class is the page for the wizard which import HTML description game coming from the FFBS 
 * 
 * @author Patrick BRIAND
 *
 */
public class ImportHtmlWizardPage extends WizardPage implements IPathSelectionCompositeChange {

	/** Indicate if all information are correctly set */
	boolean isPageIsComplete;
	/** SWT Widget for select a file */
   private PathSelectionComposite pathSelectionComposite;
	
	/**
	 * Create the wizard.
	 */
	public ImportHtmlWizardPage() {
		super("ImportHtmlWizardPage"); //$NON-NLS-1$
		setTitle(Messages.ImportHtmlWizardPage_PageTitle);
		setDescription(Messages.ImportHtmlWizardPage_PageDescription);
		setMessage(Messages.ImportHtmlWizardPage_PageMessage);
		isPageIsComplete = false;
	}

	/**
	 * Get selected file name
	 * 
	 * @return full path name of the HTML file
	 * 
	 */
	public String getFileName() {
		return pathSelectionComposite.getResolvedAbsolutePath();
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
      setControl(container);
      container.setLayout(new GridLayout(1, false));

      pathSelectionComposite = new PathSelectionComposite(container, SWT.NONE);
      pathSelectionComposite.setMessage(Messages.ImportHtmlWizardPage_pathSelectionComposite_message);
      pathSelectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      pathSelectionComposite.setFeatures(IResource.FILE, new PathSelectionFileFilter(IResource.FILE, new String[] {"*.html","*.htm"}));
      pathSelectionComposite.addPathChangerListener(this);
      checkPageComplete(); 
	}

   /**
	 * Check if the page is correctly setted
	 */
	private void checkPageComplete() {
	   PathSelectionCompositeStatus state = pathSelectionComposite.validateSelection();
	   if (PathSelectionCompositeStatus.IS_EMPTY.equals(state)) {

	      setErrorMessage(Messages.ImportHtmlWizardPage_needToDefinedPath);
         setPageComplete(false);
	      
	   } else if (PathSelectionCompositeStatus.BAD_FILE_NAME.equals(state) || PathSelectionCompositeStatus.NOT_A_FILE.equals(state))  {
	   
         setErrorMessage(Messages.ImportHtmlWizardPage_FilePathNotValidError);
	      setPageComplete(false);

	   } else {
         setErrorMessage(null);
         setPageComplete(true);
	   }
	}

   @Override
   public void pathSelectionChanged(PathSelectionCompositeStatus status) {
      checkPageComplete();
   }
}
