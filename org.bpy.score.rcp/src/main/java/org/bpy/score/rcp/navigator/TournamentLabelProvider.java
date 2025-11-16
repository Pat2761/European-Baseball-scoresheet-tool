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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * Provide a label for tournament folder.
 * 
 * @author Patrick BRIAND
 *
 */
public class TournamentLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// Nothing to do
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Nothing to do
	}

	@Override
	public Image getImage(Object element) {

		if (ScoreToolProjectParent.class.isInstance(element)) {
			return ((ScoreToolProjectParent) element).getImage();

		} else if (IScoreToolProjectElement.class.isInstance(element)) {
			return ((IScoreToolProjectElement) element).getImage();

		}

		return WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider().getImage(element);
	}

	@Override
	public String getText(Object element) {
		String text = "not found"; //$NON-NLS-1$

		if (ScoreToolProjectParent.class.isInstance(element)) {
			text = ((ScoreToolProjectParent) element).getText();

		} else if (ScoreToolSeasonElement.class.isInstance(element)) {
			text = ((ScoreToolSeasonElement) element).getText();

		} else if (IScoreToolProjectElement.class.isInstance(element)) {
			text = ((IScoreToolProjectElement) element).getText();

		} else if (IFile.class.isInstance(element)) {
			text = ((IFile) element).getName();

		} else if (IFolder.class.isInstance(element)) {
			text = ((IFolder) element).getName();
		}

		return text;
	}

}
