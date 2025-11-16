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
package org.bpy.score.rcp.decorators;

import java.util.logging.Logger;

import org.bpy.score.rcp.Activator;
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class decorators for folders. 
 * It is used for decorate the project explorer for visualize specific folders of the score tool
 * 
 * @author Patrick BRIAND
 *
 */
public class FoldersDecorator extends LabelProvider implements ILabelDecorator {
	
	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(FoldersDecorator.class.getSimpleName());

	@Override
	public Image decorateImage(Image image, Object element) {
		if (element instanceof IFolder) {
			IFolder folder = (IFolder) element;
				
			IScopeContext projectScope = new ProjectScope(folder.getProject());
			IEclipsePreferences projectNode = projectScope.getNode(Activator.PLUGIN_ID);
			if (projectNode != null) {

				String value = projectNode.get(folder.toString().replaceAll("\\s+", "_"), ""); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				
				if (RcpUtils.SEASON_CATEGORY.equals(value)) {
					return RcpUtils.seasonImage;
				} else if (RcpUtils.CATEGORY_CATEGORY.equals(value)) {
					return RcpUtils.categoryImage;
				}
			}
		}
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		return null;
	}
}
