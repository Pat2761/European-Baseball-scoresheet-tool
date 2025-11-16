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
package org.bpy.score.rcp.intro;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.ide.ChooseWorkspaceData;
import org.eclipse.ui.internal.ide.ChooseWorkspaceDialog;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.application.IDEApplication.ReturnCode;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication,IExecutableExtension {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		Display display = PlatformUI.createDisplay();
		try {
			 
			Shell shell = WorkbenchPlugin.getSplashShell(display);
			checkInstanceLocation(shell, context.getArguments());
			
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}

	/**
	 * @param shell
	 * @param arguments
	 * @return Object
	 */
	private Object checkInstanceLocation(Shell shell, Map<?, ?> arguments) {
		Location instanceLoc = Platform.getInstanceLocation();		

		URL workspaceUrl = null;
		boolean force = false;
		ChooseWorkspaceData launchData = new ChooseWorkspaceData(instanceLoc.getDefault());
		
		while(true) {
		try {
			workspaceUrl = promptForWorkspace(shell, launchData, force);
		} catch (OperationCanceledException e) {
			// Chosen workspace location was not compatible, select default one
			launchData = new ChooseWorkspaceData(instanceLoc.getDefault());

			// Bug 551260: ignore 'use default location' setting on retries. If the user has
			// no opportunity to set another location it would only fail again and again and
			// again.
			force = true;
			continue;
		}
		
		force = true;
		try {
			if (instanceLoc.isSet()) {
				// restart with new location
				return Workbench.setRestartArguments(workspaceUrl.getFile());
			}

			// the operation will fail if the url is not a valid
			// instance data area, so other checking is unneeded
			if (instanceLoc.set(workspaceUrl, true)) {
				launchData.writePersistedData();
				//writeWorkspaceVersion();
				return null;
			}
		} catch (IllegalStateException e) {
			MessageDialog
					.openError(
							shell,
							IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetTitle,
							IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetMessage);
			return EXIT_OK;
		} catch (IOException e) {
			MessageDialog
			.openError(
					shell,
					IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetTitle,
					IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetMessage);
		}

		// by this point it has been determined that the workspace is
		// already in use -- force the user to choose again
		MessageDialog dialog = new MessageDialog(null, IDEWorkbenchMessages.IDEApplication_workspaceInUseTitle,
				null, NLS.bind(IDEWorkbenchMessages.IDEApplication_workspaceInUseMessage, workspaceUrl.getFile()),
				MessageDialog.ERROR, 1, IDEWorkbenchMessages.IDEApplication_workspaceInUse_Retry,
				IDEWorkbenchMessages.IDEApplication_workspaceInUse_Choose);
		// the return value influences the next loop's iteration
		/*returnValue = */dialog.open();
		// Remember the locked workspace as recent workspace
		launchData.writePersistedData();
		}
	}
	
//	/**
//	 * Write the version of the metadata into a known file overwriting any
//	 * existing file contents. Writing the version file isn't really crucial,
//	 * so the function is silent about failure
//	 */
//	private static void writeWorkspaceVersion() {
//		if (WORKSPACE_CHECK_REFERENCE_BUNDLE_VERSION == null) {
//			// no reference bundle installed, no check possible
//			return;
//		}
//
//		Location instanceLoc = Platform.getInstanceLocation();
//		if (instanceLoc == null || instanceLoc.isReadOnly()) {
//			return;
//		}
//
//		File versionFile = getVersionFile(instanceLoc.getURL(), true);
//		if (versionFile == null) {
//			return;
//		}
//
//		Properties props = new Properties();
//
//		// write new property
//		props.setProperty(WORKSPACE_CHECK_REFERENCE_BUNDLE_NAME, WORKSPACE_CHECK_REFERENCE_BUNDLE_VERSION.toString());
//
//		// write legacy property with an incremented version,
//		// so that pre-4.4 IDEs will also warn about the workspace
//		props.setProperty(WORKSPACE_CHECK_REFERENCE_BUNDLE_NAME_LEGACY, WORKSPACE_CHECK_LEGACY_VERSION_INCREMENTED);
//
//		try (OutputStream output = new FileOutputStream(versionFile)) {
//			props.store(output, null);
//		} catch (IOException e) {
//			IDEWorkbenchPlugin.log("Could not write version file", //$NON-NLS-1$
//					StatusUtil.newError(e));
//		}
//	}	
	
	/**
	 * @param shell
	 * @param launchData
	 * @param force
	 * @return URL
	 */
	private URL promptForWorkspace(Shell shell, ChooseWorkspaceData launchData,	boolean force) {
		URL url = null;

		do {
			showChooseWorkspaceDialog(shell, launchData, force);

			String instancePath = launchData.getSelection();
			if (instancePath == null) {
				return null;
			}

			// the dialog is not forced on the first iteration, but is on every
			// subsequent one -- if there was an error then the user needs to be
			// allowed to fix it
			force = true;

			// 70576: don't accept empty input
			if (instancePath.length() <= 0) {
				MessageDialog
				.openError(
						shell,
						IDEWorkbenchMessages.IDEApplication_workspaceEmptyTitle,
						IDEWorkbenchMessages.IDEApplication_workspaceEmptyMessage);
				continue;
			}

			// create the workspace if it does not already exist
			File workspace = new File(instancePath);
			if (!workspace.exists()) {
				workspace.mkdir();
			}

			try {
				// Don't use File.toURL() since it adds a leading slash that Platform does not
				// handle properly.  See bug 54081 for more details.
				String path = workspace.getAbsolutePath().replace(File.separatorChar, '/');
				url = new URL("file", null, path); //$NON-NLS-1$
			} catch (MalformedURLException e) {
				MessageDialog
						.openError(
								shell,
								IDEWorkbenchMessages.IDEApplication_workspaceInvalidTitle,
								IDEWorkbenchMessages.IDEApplication_workspaceInvalidMessage);
				continue;
			}
			ReturnCode result = checkValidWorkspace(shell, url);
			if (result == ReturnCode.INVALID) {
				throw new OperationCanceledException("Invalid workspace location: " + url); //$NON-NLS-1$
			}
			if (result == ReturnCode.EXIT) {
				return null;
			}
			return url;
		} while (true);
	}

	/**
	 * Show the choose workspace dialog to the user (if needed).
	 * @param shell      parentShell the parent shell for this dialog
	 * @param launchData launchData the launch data from past launches
	 * @param force      true if the dialog should be opened regardless of the value
	 *                   of the show dialog checkbox
	 */
	protected void showChooseWorkspaceDialog(Shell shell, ChooseWorkspaceData launchData, boolean force) {
		new ChooseWorkspaceDialog(shell, launchData, false, true) {
			@Override
			protected Shell getParentShell() {
				// Bug 429308: Make workspace selection dialog visible
				// in the task manager of the OS
				return null;
			}

		}.prompt(force);
	}

	/**
	 * 
	 * @param shell
	 * @param url
	 * @return error code
	 */
	private ReturnCode checkValidWorkspace(Shell shell, URL url) {
		return ReturnCode.VALID;
	}

	@Override
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec( () -> { if (!display.isDisposed())	workbench.close();});
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		
	}

}
