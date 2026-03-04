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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;

/**
 * SWT Widget element for select a color.
 * 
 * @author Patrick BRIAND
 */
public class ColorSelector extends Canvas implements PaintListener, MouseListener {

   /** Current value of the color */
   private RGB currentRGB;

   /** 
    * Constructor of the class.
    * 
    * @param parent parent composite
    */
   public ColorSelector(Composite parent) {
      super(parent, SWT.BORDER | SWT.DOUBLE_BUFFERED);
      currentRGB = new RGB(0, 0, 0);
      this.addMouseListener(this);
      this.addPaintListener(this);
   }

   /**
    * Get the select color.
    * 
    * @return selected color
    */
   public RGB getRGB() {
      return currentRGB;
   }

   /**
    * Set the selected color.
    * 
    * @param currentRGB value of the color
    */
   public void setRGB(RGB currentRGB) {
      this.currentRGB = currentRGB;
      this.redraw();
   }

   @Override
   public void paintControl(PaintEvent e) {
      Rectangle r = this.getClientArea();

      Color c = new Color(this.getDisplay(), currentRGB);
      try {
         e.gc.setBackground(c);
         e.gc.fillRectangle(r);
         e.gc.setForeground(this.getDisplay().getSystemColor(SWT.COLOR_BLACK));
         e.gc.drawRectangle(r.x, r.y, r.width - 1, r.height - 1);
      } finally {
         c.dispose();
      }
   }

   @Override
   public void mouseDoubleClick(MouseEvent e) {
      ColorDialog dlg = new ColorDialog(this.getShell());
      dlg.setRGB(currentRGB);
      RGB newRgb = dlg.open();
      if (newRgb != null) {   
         currentRGB = newRgb;
         this.redraw();
      }
    }

   @Override
   public void mouseDown(MouseEvent e) {
      // Nothing to do

   }

   @Override
   public void mouseUp(MouseEvent e) {
      // Nothing to do

   }
}
