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
package org.bpy.score.rcp;

import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.rcp.preferences.PreferenceConstants;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.bpy.score.rcp"; //$NON-NLS-1$

	/** The shared instance */
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		// Nothing to do
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("java:S2696")
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		IEclipsePreferences node = new ConfigurationScope().getNode(IDEWorkbenchPlugin.IDE_WORKBENCH);
		node.putBoolean(IDE.Preferences.SHOW_WORKSPACE_SELECTION_DIALOG,true);
		node.putInt(IDE.Preferences.MAX_RECENT_WORKSPACES, 10);		
		
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("java:S2696")
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

  @Override
  @Deprecated
  protected void initializeDefaultPreferences(IPreferenceStore store) {
    
    Color defaulLineColor = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
    PreferenceConverter.setDefault(store,  EngineConstants.GRAPHIC_COLOR_LINE, defaulLineColor.getRGB());

    Color defaultextColor = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
    PreferenceConverter.setDefault(store,  EngineConstants.GRAPHIC_COLOR_TEXT, defaultextColor.getRGB());
    
    store.setDefault(EngineConstants.GRAPHIC_DISPLAY_STATISTICS, true);
    store.setDefault(EngineConstants.GRAPHIC_DISPLAY_WIN_LOSE_PITCHER, false);
    store.setDefault(EngineConstants.GRAPHIC_NEW_STYLE_SHEET, false);
    
    store.setDefault(PreferenceConstants.CHECK_FLY_OUT_LOCATION, PreferenceConstants.WARNING);
    store.setDefault(PreferenceConstants.CHECK_MISSING_EARNED_POINT, PreferenceConstants.IGNORE);
  }

  /**
   * Create an image from a file path 
   * 
   * @param imagePath image file path
   * 
   * @return image reference, <b>null</b> if not found
   */
  public static Image getImage(String imagePath) {
    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath);
    return imageDescriptor.createImage();
  }
}
