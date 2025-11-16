package org.bpy.score.rcp.handler;

import org.bpy.score.rcp.utils.RcpUtils;
import org.bpy.score.rcp.wizard.SearchGameByDateWizard;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class execute the search game by date menu 
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchMatchForDateHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
	    IFolder folder = (IFolder) ((TreeSelection)selection).getFirstElement();

	    SearchGameByDateWizard wizard = new SearchGameByDateWizard(folder);
	    WizardDialog wizardDialog = new WizardDialog(new Shell(), wizard);
		wizardDialog.open();
	    
	    return null;
	}

	@Override
	public boolean isEnabled() {
	    ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

	    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
	    if (selection instanceof TreeSelection) {
	      TreeSelection treeSelection = (TreeSelection) selection;
	      if (treeSelection.getFirstElement() instanceof IFolder) {
	    	  IFolder currentFolder = (IFolder) treeSelection.getFirstElement();
    		  return RcpUtils.isCategoryFolder(currentFolder);
	      }
	    }
	    
	    return false;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}

}
