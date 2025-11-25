package org.bpy.score.rcp.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.rcp.ScoreProjectNature;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

public class UnsetProjectScoreNatureHandler implements IHandler {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(UnsetProjectScoreNatureHandler.class.getCanonicalName());

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// do nothing
	}

	@Override
	public void dispose() {
		// do nothing
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

	    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
	    if (selection instanceof TreeSelection) {
	      TreeSelection treeSelection = (TreeSelection) selection;
	      if (treeSelection.getFirstElement() instanceof IProject) {
	    	  
	    	IProject currentProject = (IProject) treeSelection.getFirstElement();
	  		IProjectDescription description;
			try {
				description = currentProject.getDescription();
				
				List<String> natureIds = new ArrayList<>();
				for (String natureId : description.getNatureIds()) {
					natureIds.add(natureId);
				}
				
				natureIds.remove(ScoreProjectNature.NATURE_ID);
				
				description.setNatureIds(natureIds.toArray(new String[natureIds.size()]) );

				currentProject.setDescription(description, new NullProgressMonitor());
				
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
	      }
	    }  
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		ISelectionService  selectionService=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

	    ISelection selection = selectionService.getSelection("org.eclipse.ui.navigator.ProjectExplorer"); //$NON-NLS-1$
	    if (selection instanceof TreeSelection) {
	      TreeSelection treeSelection = (TreeSelection) selection;
	      if (treeSelection.getFirstElement() instanceof IProject) {
	    	  return true;
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
		// do nothing
	}

}
