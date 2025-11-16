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
package org.bpy.score.rcp.handler;

import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.views.markers.MarkerSupportView;
import org.eclipse.ui.views.markers.MarkerViewHandler;
import org.eclipse.ui.views.markers.internal.MarkerMessages;


/**
 * Handler for delete something
 * 
 * @author Patrick BRIAND
 *
 */
@SuppressWarnings("restriction")
public class DeleteHandler extends MarkerViewHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final MarkerSupportView view = getView(event);
		if (view == null)
			return this;

		final IMarker[] selected = getSelectedMarkers(event);

		// Verify.
		MessageDialog dialog = new MessageDialog(view.getSite().getShell(), MarkerMessages.deleteActionConfirmTitle,
				null, // icon
				MarkerMessages.deleteActionConfirmMessage, MessageDialog.WARNING, 0, Messages.DeleteHandler_RemoveText,
				IDialogConstants.CANCEL_LABEL);

		if (dialog.open() != IDialogConstants.OK_ID) {
			return view;
		}

		WorkspaceJob deleteJob = new WorkspaceJob(IDEWorkbenchMessages.MarkerDeleteHandler_JobTitle) { // See Bug#250807
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				monitor.beginTask(IDEWorkbenchMessages.MarkerDeleteHandler_JobMessageLabel, 10 * selected.length);
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		deleteJob.setUser(true);
		deleteJob.schedule();

		return this;
	}
}
