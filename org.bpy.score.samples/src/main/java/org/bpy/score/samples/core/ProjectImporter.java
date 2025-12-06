package org.bpy.score.samples.core;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.bpy.score.samples.Activator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.prefs.BackingStoreException;

public class ProjectImporter {

	/** Category folder qualified name */
	public static final QualifiedName FOLDER_CATEGORY = new QualifiedName("org.bpy.score.rcp.folder", "category"); //$NON-NLS-1$ //$NON-NLS-2$
	/** Season folder qualified name */
	public static final String SEASON_CATEGORY = "org.bpy.score.rcp.season.category"; //$NON-NLS-1$
	/** Category folder qualified name */
	public static final String CATEGORY_CATEGORY = "org.bpy.score.rcp.category.category"; //$NON-NLS-1$

	public ProjectImporter() {

	}

	public void importProject(String projectNamme) {
		Bundle bundle = FrameworkUtil.getBundle(Activator.class);

		InputStream is = Activator.class.getClassLoader()
				.getResourceAsStream("org/bpy/score/samples/" + projectNamme + ".zip");
		if (is != null) {
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IProject project = workspace.getRoot().getProject(projectNamme);

				if (!project.exists()) {
					IProjectDescription desc = workspace.newProjectDescription(project.getName());
					desc.setLocation(null); // workspace default location

					project.create(desc, null); // création
					project.open(null); // ouverture

					desc.setNatureIds(new String[] { "org.bpy.score.rcp.projectNature",
							"org.eclipse.xtext.ui.shared.xtextNature" });
					project.setDescription(desc, null);

					extractFileFromResources(project, is);
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

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

	private void createFile(IProject project, ZipInputStream zis, ZipEntry zipEntry) throws CoreException, IOException {
		String name = zipEntry.getName().replaceFirst(project.getName() + '/', "");
		if (!name.isBlank() && !name.isEmpty()) {
			IFile file = project.getFile(name);
			if (!file.exists()) {
				byte[] buffer = zis.readAllBytes();
				file.create(new ByteArrayInputStream(buffer), false, null);
			}
		}
	}

	private void createDirectory(IProject project, String name) throws CoreException, BackingStoreException {
		name = name.replaceFirst(project.getName() + '/', "");
		if (!name.isBlank() && !name.isEmpty()) {
			IFolder folder = project.getFolder(name);
			if (!folder.exists()) {

				folder.create(true, true, null);
				folder.refreshLocal(IResource.DEPTH_INFINITE, null);

				int type = name.split("/").length;
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

	private void setCategory(IProject project, IFolder folder, String category)
			throws CoreException, BackingStoreException {
		folder.setPersistentProperty(FOLDER_CATEGORY, CATEGORY_CATEGORY);

		IScopeContext projectScope = new ProjectScope(folder.getProject());
		IEclipsePreferences projectNode = projectScope.getNode("org.bpy.score.rcp");
		if (projectNode != null) {
			projectNode.put(folder.getFullPath().toPortableString(), category);
			try {
				projectNode.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
