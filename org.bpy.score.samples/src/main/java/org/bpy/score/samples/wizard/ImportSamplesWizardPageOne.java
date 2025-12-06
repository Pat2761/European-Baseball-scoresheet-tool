/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2024  Patrick BRIAND
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
package org.bpy.score.samples.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bpy.score.internationalization.samples.Messages;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * First page of the sample project importer.
 */
public class ImportSamplesWizardPageOne extends WizardPage {

	/**
	 * Contains the description and the charset used for an example
	 */
	public class SampleDescription {
		
		/** Contains the name of the zip file */
		private String zipName;
		/** Contains the description of the sample */
		private String description;
		/** Contains the charset used by the sample */
		private String charset;

		/**
		 * Constructor of the class.
		 * 
		 * @param zipName name of the zip file
		 * @param description description of the sample
		 * @param charset charset used by the sample
		 */
		public SampleDescription(String zipName, String description, String charset) {
			this.zipName = zipName;
			this.description = description;
			this.charset = charset;
		}

		/**
		 * Get the name of sample file.
		 * 
		 * @return name of sample file
		 */
		public String getZipName() {
			return zipName;
		}

		/**
		 * Get the description of the sample.
		 * 
		 * @return description of the sample
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Get the charset used by the sample.
		 * 
		 * @return charset used by the sample
		 */
		public String getCharset() {
			return charset;
		}
	}
	
	/** Contains the list of sample projects */
	private final Map<String,SampleDescription> samplesCollection;
	
	/** Contains the list of selected samples */
	private java.util.List<SampleDescription> selectedExamples;
	
	/** SWT Widget which display the list os sample projects */
	private List list;
	/** SWT Button for unselect projects */
	private Button btnUnselectAll;
	/** SWT Button for select all projects in the list */
	private Button btnSelectAll;
	
	
	/**
	 * Constructor of the class
	 */
	public ImportSamplesWizardPageOne() {
		super("ImportSamplesWizardPageOne"); //$NON-NLS-N$ //$NON-NLS-1$ //$NON-NLS-1$

		samplesCollection = new HashMap<>();
		
		SampleDescription sample1 = new SampleDescription("Championat de france", Messages.frenchD1TournamentDescription,"ISO-8859-1"); //$NON-NLS-1$ //$NON-NLS-2$
		samplesCollection.put("Championat de france", sample1); //$NON-NLS-N$ //$NON-NLS-1$ //$NON-NLS-1$

		setTitle(Messages.importWizardPageOneTitle);
		setDescription(Messages.importWizardPageOneDescription);
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblListOfSample = new Label(container, SWT.NONE);
		lblListOfSample.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblListOfSample.setText(Messages.labelProjectListSelector);
		new Label(container, SWT.NONE);
		
		list = new List(container, SWT.BORDER | SWT.MULTI);
		list.addListener(SWT.Selection, e -> memorizeSelection());
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		
		btnUnselectAll = new Button(container, SWT.NONE);
		btnUnselectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.deselectAll();
				memorizeSelection();
			}
		});
		btnUnselectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnUnselectAll.setText(Messages.deselectAll);
		
		btnSelectAll = new Button(container, SWT.NONE);
		btnSelectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.selectAll();
				memorizeSelection();
			}
		});
		btnSelectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectAll.setText(Messages.selectAll);
		
		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		initData();
		memorizeSelection();
	}

	/**
	 * Return the list of selected projects.
	 * 
	 * @return list of selected projects
	 */
	public java.util.List<SampleDescription> getSelectedExamples() {
		return selectedExamples;
	}

	/**
	 * Call when a selection event occurs in the list of projects 
	 * 
	 */
	protected void memorizeSelection() {
		if (selectedExamples == null) {
			selectedExamples = new ArrayList<>();
		}
		selectedExamples.clear();
		
		if (list.getSelectionCount() == 0) {
			setPageComplete(false);
			setErrorMessage(Messages.missingAtLeastOneSelection);
		} else {
			setPageComplete(true);
			setErrorMessage(null);

			for (String selection : list.getSelection()) {
				selectedExamples.add((SampleDescription) list.getData(selection));
			}
		}
	}

	/**
	 * Initialize the list of possible projects 
	 * 
	 */
	private void initData() {
		for (Entry<String, SampleDescription> sampleEntry : samplesCollection.entrySet()) {
			list.add(sampleEntry.getValue().getDescription());
			list.setData(sampleEntry.getValue().getDescription(), sampleEntry.getValue());
		}
	}
}
