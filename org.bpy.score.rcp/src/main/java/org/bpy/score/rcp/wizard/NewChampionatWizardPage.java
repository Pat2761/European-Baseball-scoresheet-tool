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

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
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

/**
 * This class provide a wizard page which allow to create a new tournament.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewChampionatWizardPage extends WizardPage implements ModifyListener {

	/** Name of the tournament widget */
	private Text tournamentName;
	/** can finish state */
	private boolean canFinish = false;
	/** name of season widget */
	private Text seasonName;

	/**
	 * Create the wizard.
	 */
	public NewChampionatWizardPage() {
		super("wizardPage"); //$NON-NLS-1$
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

		Label lblNomDuChampionat = new Label(container, SWT.NONE);
		lblNomDuChampionat.setBounds(10, 10, 359, 23);
		lblNomDuChampionat.setText(Messages.NewChampionatWizardPage_NameOfNewtournament);

		tournamentName = new Text(container, SWT.BORDER);
		tournamentName.setBounds(10, 32, 359, 23);

		Label lblAjoutDuneSaison = new Label(container, SWT.NONE);
		lblAjoutDuneSaison.setBounds(10, 67, 359, 24);
		lblAjoutDuneSaison.setText(Messages.NewChampionatWizardPage_AddSeason);

		seasonName = new Text(container, SWT.BORDER);
		seasonName.setText(StringUtils.EMPTY + Calendar.getInstance().get(Calendar.YEAR)); 
		seasonName.setBounds(10, 86, 359, 23);
		tournamentName.addModifyListener(this);
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
		return seasonName.getText();
	}

	/**
	 * return the can finish state
	 * 
	 * @return <b>true</b> can finish,<b>false</b> otherwise
	 */
	public boolean canFinish() {
		return canFinish;
	}

	@Override
	public void modifyText(ModifyEvent e) {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject[] projects = workspaceRoot.getProjects();

		if (tournamentName.getText().isBlank()) { //$NON-NLS-1$
			setErrorMessage(Messages.NewChampionatWizardPage_BlanckTournamentNameError);
			canFinish = false;
			setPageComplete(false);
			return;
		}

		for (IProject project : projects) {
			if (tournamentName.getText().equalsIgnoreCase(project.getName())) {
				setErrorMessage(NLS.bind(Messages.NewChampionatWizardPage_TournamentAlreadyExistError, tournamentName.getText()));
				canFinish = false;
				setPageComplete(false);
				return;
			}
		}
		setErrorMessage(null);
		canFinish = true;
		setPageComplete(true);
	}
}
