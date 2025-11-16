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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;


/**
 * Provide Label for tournament
 * 
 * @author Patrick BRIAND
 *
 */
public class TournamentDecoratedLabelProvider extends WorkbenchLabelProvider implements ICommonLabelProvider {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(TournamentDecoratedLabelProvider.class.getSimpleName());
	
	@Override
	public void restoreState(IMemento aMemento) {
		// Nothing to do
	}

	@Override
	public void saveState(IMemento aMemento) {
		// Nothing to do
	}

	@Override
	public String getDescription(Object anElement) {
		if (anElement instanceof IResource) {
			return ((IResource) anElement).getFullPath().makeRelative().toString();
		}
		return null;
	}

	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		// Nothing to do
	}

	@Override
	protected ImageDescriptor decorateImage(ImageDescriptor input, Object element) {
		ImageDescriptor descriptor = super.decorateImage(input, element);
		if (descriptor == null) {
			return null;
		}

		IResource resource = Adapters.adapt(element, IResource.class);
		if (resource != null && (resource.getType() != IResource.PROJECT || ((IProject) resource).isOpen())) {
			ImageDescriptor overlay = null;

			switch (getHighestProblemSeverity(resource)) {

			case IMarker.SEVERITY_ERROR:
				overlay = PlatformUI.getWorkbench().getSharedImages()
						.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR);
				break;

			case IMarker.SEVERITY_WARNING:
				overlay = PlatformUI.getWorkbench().getSharedImages()
						.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
				break;

			default:
			}

			if (overlay != null) {
				descriptor = new DecorationOverlayIcon(descriptor, overlay, IDecoration.BOTTOM_LEFT);
			}
		}
		return descriptor;
	}

	/**
	 * Get the most important problem
	 * 
	 * @param resource resource to check
	 * 
	 * @return problem severity
	 */
	protected int getHighestProblemSeverity(IResource resource) {
		int problemSeverity = -1;
		try {
			for (IMarker marker : resource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)) {
				problemSeverity = Math.max(problemSeverity, marker.getAttribute(IMarker.SEVERITY, -1));
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
		return problemSeverity;
	}

}
