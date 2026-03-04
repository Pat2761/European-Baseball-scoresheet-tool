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

/**
 * define the status of the Path selection composite widget
 */
public enum PathSelectionCompositeStatus {

   /** No problems */
   OK,

   /** is empty */
   IS_EMPTY,
   
   /** The string isn't a valid file of folder name */
   BAD_FILE_NAME,
   
   /** Not a directory */
   NOT_A_DIRECTORY,
   
   /** Not a file */
   NOT_A_FILE,
   
   /** Bad file type */
   BAD_FILE_TYPE
}
