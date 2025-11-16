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
package org.bpy.score.rcp.preferences;

import org.bpy.score.rcp.Activator;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Field editor for the HTML preference (Under construction)
 * 
 * @author Patrick BRAIND
 *
 */
public class HtmlStyle extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructor of the class
	 */
  public HtmlStyle() {
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
  }

  @Override
  public void init(IWorkbench workbench) {
	// Nothing to do
  }

  @Override
  protected void createFieldEditors() {
    ColorFieldEditor backGroundColor = new ColorFieldEditor("backGroundColor", "Background color : ", getFieldEditorParent());
    backGroundColor.setPreferenceStore(getPreferenceStore());
    backGroundColor.load();

    Group grpTitle = new Group(getFieldEditorParent(), SWT.NONE);
    grpTitle.setText("Title 1");
    grpTitle.setBounds(10, 35, 345, 82);

  }

}
