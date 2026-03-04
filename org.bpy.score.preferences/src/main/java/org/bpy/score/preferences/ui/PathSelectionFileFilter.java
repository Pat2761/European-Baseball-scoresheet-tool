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
package org.bpy.score.preferences.ui;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Allow to filter file and folders. in the path selection widget
 * 
 * @author Patrick BRIAND
 */
public class PathSelectionFileFilter extends ViewerFilter {

   /** Contains the list of authorized extensions */
   private String[] extensions;
   /** Contains the category of element (FILE or FOLDER) */
   private int category;

   /**
    * Constructor of the class.
    * 
    * @param category   category of element (FILE or FOLDER)
    * @param extensions list of authorized extensions
    */
   public PathSelectionFileFilter(int category, String[] extensions) {
      this.category = category;
      this.extensions = extensions;
   }

   /**
    * Return the list of extensions.
    * 
    * @return list of extensions
    */
   public String[] getExtensions() {
      return extensions;
   }

   /**
    * Check if the the extension of the file is valid.
    * 
    * @param file file to check
    * 
    * @return <b>true</b> extension if correct, <b>false</b> otherwise
    */
   public boolean accept(File file) {
      String fileName = file.getName();
      for (String extension : extensions) {
            extension = "." + extension;
            if (fileName.toLowerCase().endsWith(extension)) {
               return true;
            }
     }
      return false;

   }

   @Override
   public boolean select(Viewer viewer, Object parentElement, Object element) {

      boolean state = true;

      if ((IResource.FOLDER == category) && (element instanceof IFile)) {
         state = false;

      } else if (IResource.FILE == category && (element instanceof IFile file)) {
         String fileExtension = file.getFileExtension().toLowerCase();

         boolean found = false;
         for (String extension : extensions) {
            if (extension.equals(fileExtension)) {
               found = true;
               break;
            }
         }
         state = found;
      }

      return state;
   }
}
