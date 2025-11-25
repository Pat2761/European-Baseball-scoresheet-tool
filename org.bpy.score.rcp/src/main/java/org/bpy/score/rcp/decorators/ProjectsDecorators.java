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


import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.ScoreProjectNature;
import org.bpy.score.rcp.utils.RcpUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Allow to decorate tournament projects.
 * Manage open and closed projects 
 * 
 * @author Patrick BRIAND
 *
 */
public class ProjectsDecorators  extends LabelProvider implements ILabelDecorator {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(FoldersDecorator.class.getSimpleName());

	@Override
	public Image decorateImage(Image image, Object element) {
		image = super.getImage(element);
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			try {
				
				
				IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(project.getLocation().toOSString().replace("\\", "/") + "/.project" ));//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				
				if (description.hasNature(ScoreProjectNature.NATURE_ID)) {
					if (project.isOpen()) {
						return RcpUtils.OPEN_TOURNAMENT_IMAGE;
					} else {
						return RcpUtils.CLOSE_TOURNAMENT_IMAGE;
					}
				} else {
					if (project.isOpen()) {
						return RcpUtils.OPEN_PROJECT_IMAGE;
					} else {
						return RcpUtils.CLOSE_PROJECT_IMAGE;
					}
				}
			} catch (CoreException e) {
				logger.log(Level.SEVERE,e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		return null;
	}
}
