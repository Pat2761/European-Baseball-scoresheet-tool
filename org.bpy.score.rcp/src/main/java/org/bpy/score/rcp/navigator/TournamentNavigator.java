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
package org.bpy.score.rcp.navigator;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Tournament navigator class
 * 
 * @author P
 *
 */
public class TournamentNavigator extends CommonNavigator {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(TournamentNavigator.class.getSimpleName());

	@Override
	protected Object getInitialInput() {
		return new ScoreToolProjectWorkbenchRoot();
	}

	@Override
	protected void initListeners(TreeViewer viewer) {

		viewer.addDoubleClickListener(event -> manageEvent(event));

		super.initListeners(viewer);
	}

	/**
	 * Manage the double click event.
	 * 
	 * @param event reference on the event
	 */
	protected void manageEvent(DoubleClickEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object element = selection.getFirstElement();

		if (IFile.class.isInstance(element)) {
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(((IFile) element).getName());
			try {
				page.openEditor(new FileEditorInput((IFile) element), desc.getId());
			} catch (PartInitException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}

}
