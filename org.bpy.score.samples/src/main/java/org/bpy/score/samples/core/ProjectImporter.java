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
package org.bpy.score.samples.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.bpy.score.internationalization.samples.Messages;
import org.bpy.score.samples.Activator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Execute l'imporation of the project
 * 
 * @author Patrick BRIAND.
 */
public class ProjectImporter {

	/** Category folder qualified name */
	public static final QualifiedName FOLDER_CATEGORY = new QualifiedName("org.bpy.score.rcp.folder", "category"); //$NON-NLS-1$ //$NON-NLS-2$
	/** Season folder qualified name */
	public static final String SEASON_CATEGORY = "org.bpy.score.rcp.season.category"; //$NON-NLS-1$
	/** Category folder qualified name */
	public static final String CATEGORY_CATEGORY = "org.bpy.score.rcp.category.category"; //$NON-NLS-1$

	/**
	 * Constructor of the class.
	 * 
	 */
	public ProjectImporter() {
		// Nothing to do
	}

	/**
	 * Import the project in the workspace.
	 * 
	 * @param projectNamme Name of the zip file which contains the sample
	 * @param charset      char set used for this project
	 */
	public void importProject(String projectNamme, String charset) {
		InputStream is = Activator.class.getClassLoader()
				.getResourceAsStream("org/bpy/score/samples/" + projectNamme + ".zip"); //$NON-NLS-1$ //$NON-NLS-2$
		if (is != null) {
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IProject project = workspace.getRoot().getProject(projectNamme);

				if (!project.exists()) {
					IProjectDescription desc = workspace.newProjectDescription(project.getName());
					desc.setLocation(null); // workspace default location

					project.create(desc, null); // création
					project.open(null); // ouverture

					desc.setNatureIds(new String[] { "org.bpy.score.rcp.projectNature", // $NON-NLS-N$ //$NON-NLS-1$
							"org.eclipse.xtext.ui.shared.xtextNature" }); // $NON-NLS-N$ //$NON-NLS-1$
					project.setDescription(desc, null);

					extractFileFromResources(project, is);

					project.setDefaultCharset(charset, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.errorWhileImportingSample, e.getMessage());
			} catch (IOException e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.errorWhileImportingSample, e.getMessage());
			} catch (BackingStoreException e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.errorWhileImportingSample, e.getMessage());
			}
		}
	}

	/**
	 * Extract files to the project in the zip file.
	 * 
	 * @param project Project which receive the files
	 * @param is      reference on the input stream of the zip file
	 * 
	 * @throws IOException           in case of error
	 * @throws CoreException         in case of error
	 * @throws BackingStoreException in case of error
	 */
	private void extractFileFromResources(IProject project, InputStream is)
			throws IOException, CoreException, BackingStoreException {
		ZipInputStream zis = new ZipInputStream(is);
		ZipEntry zipEntry = zis.getNextEntry();
		while (zipEntry != null) {
			if (zipEntry.isDirectory()) {
				createDirectory(project, zipEntry.getName());
			} else {
				createFile(project, zis, zipEntry);
			}
			zipEntry = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
	}

	/**
	 * Extract a file and copy this file in the project.
	 * 
	 * @param project  Project which receive the files
	 * @param zis      Zip file input stream
	 * @param zipEntry entry in the zip file
	 * 
	 * @throws IOException   in case of error
	 * @throws CoreException in case of error
	 */
	private void createFile(IProject project, ZipInputStream zis, ZipEntry zipEntry) throws CoreException, IOException {
		String name = zipEntry.getName().replaceFirst(project.getName() + '/', ""); // $NON-NLS-N$ //$NON-NLS-1$
		if (!name.isBlank() && !name.isEmpty()) {
			IFile file = project.getFile(name);
			if (!file.exists()) {
				byte[] buffer = zis.readAllBytes();
				file.create(new ByteArrayInputStream(buffer), false, null);
			}
		}
	}

	/**
	 * Create a directory in the project
	 * 
	 * @param project Define the project for the creation of the folder
	 * @param name    Name of the folder
	 * 
	 * @throws CoreException         in case of error
	 * @throws BackingStoreException in case of error
	 */
	private void createDirectory(IProject project, String name) throws CoreException, BackingStoreException {
		name = name.replaceFirst(project.getName() + '/', ""); // $NON-NLS-N$ //$NON-NLS-1$
		if (!name.isBlank() && !name.isEmpty()) {
			IFolder folder = project.getFolder(name);
			if (!folder.exists()) {

				folder.create(true, true, null);
				folder.refreshLocal(IResource.DEPTH_INFINITE, null);

				int type = name.split("/").length; // $NON-NLS-N$ //$NON-NLS-1$
				switch (type) {
				case 1:
					setCategory(project, folder, SEASON_CATEGORY);
					break;
				case 2:
					setCategory(project, folder, CATEGORY_CATEGORY);
					break;
				}
			}
		}
	}

	/**
	 * Define the category of the folder (used for the decoration).
	 * 
	 * @param project  reference on the current project
	 * @param folder   reference on the current folder
	 * @param category category of the folder
	 * 
	 * @throws CoreException         in case of error
	 * @throws BackingStoreException in case of error
	 */
	private void setCategory(IProject project, IFolder folder, String category)
			throws CoreException, BackingStoreException {
		folder.setPersistentProperty(FOLDER_CATEGORY, CATEGORY_CATEGORY);

		IScopeContext projectScope = new ProjectScope(folder.getProject());
		IEclipsePreferences projectNode = projectScope.getNode("org.bpy.score.rcp"); // $NON-NLS-N$ //$NON-NLS-1$
		if (projectNode != null) {
			projectNode.put(folder.getFullPath().toPortableString(), category);
			projectNode.flush();
		}
	}
}
