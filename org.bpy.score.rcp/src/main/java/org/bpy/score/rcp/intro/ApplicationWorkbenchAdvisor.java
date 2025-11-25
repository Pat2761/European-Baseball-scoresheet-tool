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

import java.awt.Color;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.preferences.core.PreferenceConstants;
import org.bpy.score.rcp.Activator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.ide.IDE;

/**
 * Allow to create the main window.
 * 
 * @author Patrick BRIAND
 *
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	/** Id of the main perspective */
	private static final String PERSPECTIVE_ID = "org.bpy.score.rcp.perspective"; //$NON-NLS-1$

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ApplicationWorkbenchAdvisor.class.getSimpleName());

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		configurer.setSaveAndRestore(true);
		IDE.registerAdapters();

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		EngineConstants.graphicsShowStatistiques = store.getString(EngineConstants.GRAPHIC_DISPLAY_STATISTICS);
		EngineConstants.graphicsShowNewStyleSheet = store.getBoolean(EngineConstants.GRAPHIC_NEW_STYLE_SHEET);
		EngineConstants.graphicsShowWinLoseSave = store.getBoolean(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER);

		RGB rgb = PreferenceConverter.getColor(store, EngineConstants.GRAPHIC_COLOR_LINE);
		EngineConstants.graphicsColorSheet = new Color(rgb.red, rgb.green, rgb.blue);
		rgb = PreferenceConverter.getColor(store, EngineConstants.GRAPHIC_COLOR_TEXT);
		EngineConstants.graphicsColorPencil = new Color(rgb.red, rgb.green, rgb.blue);

		EngineConstants.checkFlyOutLocation = store.getString(PreferenceConstants.CHECK_FLY_OUT_LOCATION);
		EngineConstants.checkMissingEarnedPoint = store.getString(PreferenceConstants.CHECK_MISSING_EARNED_POINT);

		MessageConsole myConsole = new MessageConsole("Console", null); //$NON-NLS-1$

		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { myConsole });
		MessageConsoleStream stream = myConsole.newMessageStream();

		PrintStream myS = new PrintStream(stream);
		System.setOut(myS); // link standard output stream to the console
		System.setErr(myS); // link error output stream to the console

	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public IAdaptable getDefaultPageInput() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	@Override
	public void postStartup() {
		PreferenceManager pm = PlatformUI.getWorkbench().getPreferenceManager();
		pm.remove("org.eclipse.help.ui.browsersPreferencePage"); //$NON-NLS-1$
		pm.remove("org.eclipse.m2e.core.preferences.Maven2PreferencePage"); //$NON-NLS-1$
		pm.remove("org.eclipse.ant.ui.AntPreferencePage"); //$NON-NLS-1$
		pm.remove("org.eclipse.jdt.ui.preferences.JavaBasePreferencePage"); //$NON-NLS-1$
		pm.remove("org.eclipse.team.ui.TeamPreferences"); //$NON-NLS-1$
		pm.remove("org.eclipse.debug.ui.DebugPreferencePage"); //$NON-NLS-1$

		pm.remove("org.eclipse.ui.preferencePages.Globalization"); //$NON-NLS-1$
		pm.remove("org.eclipse.ui.preferencePages.Perspectives"); //$NON-NLS-1$
		pm.remove("org.eclipse.ui.preferencePages.LinkedResources"); //$NON-NLS-1$
		pm.remove("org.eclipse.ui.preferencePages.BuildOrder"); //$NON-NLS-1$

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.getNature("org.eclipse.xtext.ui.shared.xtextNature") != null) { //$NON-NLS-1$
					project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}
}
