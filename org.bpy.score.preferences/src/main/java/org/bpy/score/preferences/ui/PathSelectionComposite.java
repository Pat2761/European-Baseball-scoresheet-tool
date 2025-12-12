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

import org.bpy.score.internationalization.preferences.Messages;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * This class supply a widget which allow to select a path
 * which can contains variables, relative project and absolute path
 * 
 * @author Patrick BRIAND
 */
public class PathSelectionComposite extends Composite {

	/** Reference on the Text Widget which contains the path */
	private Text txtPath;
	/** Reference on the label widget which define the purpose of the path */
	private Label label;

	/**
	 * Constructor of the class.
	 * 
	 * @param parent reference on the parent composite
	 * @param style SWT style of the composite
	 */
	public PathSelectionComposite(Composite parent, int style) {
		super(parent, style);
		createControls();
	}
	
	/**
	 * Set the purpose of the path.
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		label.setText(message + ":"); //$NON-NLS-1$ 
	}

	/**
	 * Set the contents of the path selector.
	 * 
	 */
	private void createControls() {
		setLayout(new GridLayout(4, false));

		label = new Label(this, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

		txtPath = new Text(this, SWT.BORDER);
		txtPath.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseHover(MouseEvent e) {
				txtPath.setToolTipText(getResolvedAbsolutePath());
			}
		});
		txtPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

		Label lblFdfdsfsdfsd = new Label(this, SWT.NONE);
		lblFdfdsfsdfsd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnWorkspace = new Button(this, SWT.PUSH);
		btnWorkspace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnWorkspace.setText(Messages.workspaceSelectorButton);
		btnWorkspace.addListener(SWT.Selection, e -> openWorkspaceDialog());

		Button btnFile = new Button(this, SWT.PUSH);
		btnFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnFile.setText(Messages.fillSystemButton);
		btnFile.addListener(SWT.Selection, e -> openFilesystemDialog());

		Button btnVar = new Button(this, SWT.PUSH);
		btnVar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnVar.setText(Messages.variableButton);
		btnVar.addListener(SWT.Selection, e -> openVariableDialog());
	}

	/**
	 * Open a dialog box for select an element in the workspace.
	 * 
	 */
	private void openWorkspaceDialog() {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), new WorkbenchLabelProvider(),
				new WorkbenchContentProvider());

		dialog.setTitle(Messages.pathSelectionCompositeTitle);
		dialog.setMessage(Messages.pathSelectionCompositeMessage);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setAllowMultiple(false);

		if (dialog.open() == Window.OK) {
			IResource res = (IResource) dialog.getFirstResult();
			if (res != null) {
				txtPath.setText(res.getFullPath().toPortableString());
			}
		}
	}

	/**
	 * Open a dialog box for select a folder in the file system.
	 * 
	 */
	private void openFilesystemDialog() {
		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		String path = dialog.open();
		if (path != null) {
			txtPath.setText(path);
		}
	}

	/**
	 * Open a dialog box for select a variable to add to the path.
	 * 
	 */
	private void openVariableDialog() {
		StringVariableSelectionDialog dialog = new StringVariableSelectionDialog(getShell());
		int ret = dialog.open();

		if (ret == Window.OK) {
			String variableExpression = dialog.getVariableExpression();
			if (variableExpression != null) {
				txtPath.setText(variableExpression);
			}
		}
	}

	/**
	 * Return the path.
	 * 
	 */
	public String getDisplayPath() {
		return txtPath.getText();
	}

	/**
	 * Set the path
	 * 
	 * @param path path
	 */
	public void setPath(String path) {
		txtPath.setText(path != null ? path : ""); //$NON-NLS-N$
	}

	/**
	 * Resolve and get the file system path.
	 * 
	 * @return Selected file system
	 */
	public String getResolvedAbsolutePath() {
	    String raw = txtPath.getText();
	    
	    String sub;
	    try {
	        sub = VariablesPlugin.getDefault()
	               .getStringVariableManager()
	               .performStringSubstitution(raw, false);
	    } catch(CoreException e) {
	        sub = raw;
	    }

	    IResource res = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(sub));
	    if (res != null) {
	        IPath loc = res.getLocation();
	        if (loc != null) {
	            return loc.toOSString();
	        }
	    }

	    sub = replaceProjectLocation(sub);
	    return sub;
	}

	/**
	 * Replace the relative path to the workspace by an absolute path.
	 * 
	 * @param raw String to convert 
	 * @return Converted path
	 */
	private String replaceProjectLocation(String raw) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject[] projects = workspace.getRoot().getProjects();
		
		for (IProject project : projects) {
			String s2 = project.getFullPath().toOSString();
			if (s2.startsWith("\\")) {  //$NON-NLS-N$
				s2 = "/" + s2.substring(1); //$NON-NLS-N$ 
			}
			if (raw.startsWith(s2)) {
				raw = raw.replaceFirst(s2, project.getLocation().toString());
				break;
			}
		}
		
		return raw;
	}
}