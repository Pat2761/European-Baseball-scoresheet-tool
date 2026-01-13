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

import java.time.Year;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

/**
 * This class provide a wizard page which allow to create a new tournament.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewChampionatWizardPage extends WizardPage implements ModifyListener {

   /** Name of the tournament widget */
   private Text tournamentName;
   /** Get season name */
   private Spinner yearSpinner;

   /**
    * Create the wizard.
    */
   public NewChampionatWizardPage() {
      super("NewChampionatWizardPage"); //$NON-NLS-1$
      setTitle(Messages.NewChampionatWizardPage_NewTournamentWizardPageTitle);
      setDescription(Messages.NewChampionatWizardPage_NewTournamentWizardPageDescription);
   }

   /**
    * Create contents of the wizard.
    * 
    * @param parent
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NONE);

      setControl(container);
      container.setLayout(new GridLayout(3, false));

      Label lblNomDuChampionat = new Label(container, SWT.NONE);
      lblNomDuChampionat.setText(Messages.NewChampionatWizardPage_NameOfNewtournament);

      tournamentName = new Text(container, SWT.BORDER);
      tournamentName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
      tournamentName.addModifyListener(this);

      Label lblAjoutDuneSaison = new Label(container, SWT.NONE);
      lblAjoutDuneSaison.setText(Messages.NewChampionatWizardPage_AddSeason);

      Label lblNewLabel = new Label(container, SWT.NONE);
      lblNewLabel.setText(" "); //$NON-NLS-1$
      lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      yearSpinner = new Spinner(container, SWT.BORDER);
      GridData gdSpinner = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
      gdSpinner.widthHint = 100;
      yearSpinner.setLayoutData(gdSpinner);
      
      yearSpinner.setDigits(0);
      yearSpinner.setMinimum(1990);
      yearSpinner.setMaximum(Year.now().getValue()+10);
      yearSpinner.setSelection(Year.now().getValue());
   }

   /**
    * Get tournament name.
    * 
    * @return tournament name
    */
   public String getTournamentName() {
      return tournamentName.getText();
   }

   /**
    * Get season name.
    * 
    * @return season name
    */
   public String getSeasonName() {
      return yearSpinner.getText();
   }

   @Override
   public void modifyText(ModifyEvent e) {
      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      IProject[] projects = workspaceRoot.getProjects();

      if (tournamentName.getText().isBlank()) { // $NON-NLS-1$
         setErrorMessage(Messages.NewChampionatWizardPage_BlanckTournamentNameError);
         setPageComplete(false);
         return;
      }

      for (IProject project : projects) {
         if (tournamentName.getText().equalsIgnoreCase(project.getName())) {
            setErrorMessage(NLS.bind(Messages.NewChampionatWizardPage_TournamentAlreadyExistError, tournamentName.getText()));
            setPageComplete(false);
            return;
         }
      }
      setErrorMessage(null);
      setPageComplete(true);
   }
}
