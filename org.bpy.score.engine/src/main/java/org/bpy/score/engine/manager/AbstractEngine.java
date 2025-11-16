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
package org.bpy.score.engine.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.exception.OccupedbaseException;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.game.game.Action;
import org.bpy.score.game.game.Commands;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.GameResume;
import org.bpy.score.game.game.HalfInning;
import org.bpy.score.game.game.InningSetting;
import org.bpy.score.game.game.SubstitutionEvent;
import org.bpy.score.internationalization.engine.Messages;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

/**
 * This class is the engine which allow to exploit data contains in a game file
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractEngine {
	
  /** Logger of the class */	
  public static final Logger logger = Logger.getLogger(AbstractEngine.class.getSimpleName());	

  /** Reference to the parse result of a game file */	
  protected Game game;

  /** Reference to actions manager which analyze the content of the game file */
  protected AbstractActionManager actionsManager;

  /**
   * Constructor of the class. 
   * Initialize some fields
   *  
   * @param game Reference to the parse result of the game file
   */
  public void setGame(Game game) {
    this.game = game;
  }

  /**
   * Define the actions manager which analyze the content of the game file.
   * 
   * @param actionsManager actions manager which analyze the content of the game file
   */
  public void setActionsManager(AbstractActionManager actionsManager) {
    this.actionsManager = actionsManager;
  }

  /**
   * Get the actions manager which analyze the content of the game file.
   * 
   * @return actions manager which analyze the content of the game file.
   */
  public AbstractActionManager getActionsManager() {
    return actionsManager;
  }

  /**
   * Manage all actions in a half inning.
   * 
   * @param halfInnings reference on the half inning
   * @throws OccupedbaseException
   */
  protected void manageActions(EList<HalfInning> halfInnings) throws OccupedbaseException {

    actionsManager.startGame();

    for (HalfInning halfInning : halfInnings) {

      actionsManager.startInning(halfInning);

      for (InningSetting setting : halfInning.getInningSetting()) {
        if (setting.isIsTiebrak()) {
          actionsManager.manageTieBreak();
        }
      }

      for (EObject element : halfInning.getInningElements()) {
        if (EngineConstants.debugEngine) {
          logger.log(Level.FINE,"------------------------------------------------------------------------"); //$NON-NLS-1$
        }

        if (element instanceof Action) {
          actionsManager.startAction(halfInning.getTeam(), (Action) element);
          actionsManager.manage((Action) element);
          actionsManager.closeAction(halfInning.getTeam(), (Action) element);

        } else if (element instanceof SubstitutionEvent) {
          actionsManager.manage((SubstitutionEvent) element);

        } else if (element instanceof Commands) {
          actionsManager.manage((Commands) element);
          
        } else {
        	String message = NLS.bind(Messages.AbstractEngine_UnexpectedClassDetected,element.getClass().getSimpleName());
        	logger.log(Level.FINE,message);
        }
      }
      
      actionsManager.closeInning(halfInning);
    }
    
    actionsManager.closeGame();

    if (EngineConstants.debugEngine) {
      actionsManager.debug();
    }
  }
  
  /**
   * Manage the game resume in the game file.
   * 
   * @param gameResume reference on the game resume
   */
  protected void manageGameResume(GameResume gameResume) {
	  actionsManager.manage(gameResume);
  }
}
