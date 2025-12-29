package org.bpy.score.preferences.ui;

import org.bpy.score.internationalization.preferences.Messages;
import org.bpy.score.preferences.core.ScorePreferenceConstants;
import org.bpy.score.preferences.core.ScorePreferencesManager;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.PropertyPage;

public class GraphicalPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

   private Button useProjectConfiguration;
   private GraphicalPreferenceComposite graphicalPreferenceComposite;

   public GraphicalPropertyPage() {
      // TODO Auto-generated constructor stub
   }

   @Override
   protected Control createContents(Composite parent) {
      Composite composite = new Composite(parent, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));

      Composite composite1 = new Composite(composite, SWT.NONE);
      composite1.setLayout(new GridLayout(3, false));
      composite1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      useProjectConfiguration = new Button(composite1, SWT.CHECK);
      useProjectConfiguration.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            changeScopeLevel(useProjectConfiguration.getSelection());
         }
      });
      useProjectConfiguration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      useProjectConfiguration.setText(Messages.EnableProjectSetting);

      Label lblNewLabel = new Label(composite1, SWT.NONE);
      lblNewLabel.setText(Messages.GraphicalPropertyPage_lblNewLabel_text); // $NON-NLS-1$

      Link link = new Link(composite1, SWT.NONE);
      link.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            displayPreferencePage(parent);
         }
      });
      link.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
      link.setText("<a>" + Messages.ConfigureWorkspaceSetting + "</a>");//$NON-NLS-1$ //$NON-NLS-2$

      IEclipsePreferences store = ScorePreferencesManager.getInstance().getProjectPreferenceStore();
      graphicalPreferenceComposite = new GraphicalPreferenceComposite(composite, store);
      graphicalPreferenceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

      initContent();
      return composite;
   }

   /**
    * Initialize the content of the panel.
    */
   private void initContent() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();
      IEclipsePreferences store = preferenceManager.getProjectPreferenceStore();

      Boolean useProjectSettings = preferenceManager.getBooleanValue(store, ScorePreferenceConstants.GPP_USE_REPORT_PROJECT_SETTING);
      useProjectConfiguration.setSelection(useProjectSettings);
      changeScopeLevel(useProjectSettings);
   }

   protected void changeScopeLevel(boolean projectScope) {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();

      IEclipsePreferences preferenceScope;
      if (projectScope) {
         preferenceScope = preferenceManager.getProjectPreferenceStore();
      } else {
         preferenceScope = preferenceManager.getWorkspacePreferenceStore();
      }

      if (preferenceScope != null) {
         graphicalPreferenceComposite.storePreferenceChange(preferenceScope);
      }

      setState(graphicalPreferenceComposite, projectScope);
   }

   /**
    * Change the state of parameter composite.
    * 
    * @param swtElement   composite eelement
    * @param projectScope state of the composite
    */
   private void setState(Composite swtElement, boolean projectScope) {
      swtElement.setEnabled(projectScope);
      for (Control child : swtElement.getChildren()) {
         if (child instanceof Composite subComposite) {
            setState(subComposite, projectScope);
         } else {
            child.setEnabled(projectScope);
         }
      }
   }

   /**
    * Display the preference panel.
    * 
    * @param parent Parent composite
    */
   protected void displayPreferencePage(Composite parent) {
      PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(parent.getShell(), "org.bpy.score.rcp.preferences.graphics", //$NON-NLS-1$
            null, null);
      if (dialog != null) {
         dialog.open();
      }
   }

   @Override
   protected void performApply() {
      saveValues();
      graphicalPreferenceComposite.performApply();
      super.performApply();
   }

   @Override
   protected void performDefaults() {
      graphicalPreferenceComposite.performDefaults();
      super.performDefaults();
   }

   @Override
   public boolean performOk() {
      saveValues();
      graphicalPreferenceComposite.performOk();
      return super.performOk();
   }

   private void saveValues() {
      ScorePreferencesManager preferenceManager = ScorePreferencesManager.getInstance();
      
      boolean projectScope = useProjectConfiguration.getSelection();
      IEclipsePreferences preferenceScope;
      preferenceScope = preferenceManager.getProjectPreferenceStore();
      preferenceManager.setValue(preferenceScope, ScorePreferenceConstants.GRW_USE_REPORT_PROJECT_SETTING, projectScope);
   }

}
