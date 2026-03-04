package org.bpy.score.rcp.wizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class CreateOfficialDialog extends Dialog {

   private Text officalName;
   private Text firstNames;
   private Text licenseNumber;

   /**
    * Create the dialog.
    * 
    * @param parentShell
    */
   public CreateOfficialDialog(Shell parentShell) {
      super(parentShell);
      setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE);
   }

   @Override
   protected void configureShell(Shell newShell) {
      newShell.setText("Create a new official");
      super.configureShell(newShell);
   }

   /**
    * Create contents of the dialog.
    * 
    * @param parent
    */
   @Override
   protected Control createDialogArea(Composite parent) {
      Composite container = (Composite) super.createDialogArea(parent);
      container.setLayout(new GridLayout(2, false));

      Label officialNameLbl = new Label(container, SWT.NONE);
      officialNameLbl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      officialNameLbl.setText("Name:");

      officalName = new Text(container, SWT.BORDER);
      officalName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

      Label lblFirstName = new Label(container, SWT.NONE);
      lblFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      lblFirstName.setText("First names:");

      firstNames = new Text(container, SWT.BORDER);
      firstNames.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      Label lblLicenseNumber = new Label(container, SWT.NONE);
      lblLicenseNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
      lblLicenseNumber.setText("License number:");

      licenseNumber = new Text(container, SWT.BORDER);
      licenseNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      Label lblTeamName = new Label(container, SWT.NONE);
      lblTeamName.setText("Team name:");

      Combo teamName = new Combo(container, SWT.NONE);
      teamName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      return container;
   }

   /**
    * Create contents of the button bar.
    * 
    * @param parent
    */
   @Override
   protected void createButtonsForButtonBar(Composite parent) {
      createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
      createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
   }

   /**
    * Return the initial size of the dialog.
    */
   @Override
   protected Point getInitialSize() {
      return new Point(510, 336);
   }

}
