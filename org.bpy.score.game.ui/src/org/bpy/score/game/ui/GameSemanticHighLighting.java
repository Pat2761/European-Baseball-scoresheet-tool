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
package org.bpy.score.game.ui;

import org.bpy.score.game.game.BatterAdvanceOnBaseOnBall;
import org.bpy.score.game.game.BatterAdvanceOnCatcherInterference;
import org.bpy.score.game.game.BatterAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.BatterAdvanceOnDoubleHit;
import org.bpy.score.game.game.BatterAdvanceOnFlyError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithError;
import org.bpy.score.game.game.BatterAdvanceOnGdpWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnHitByPitch;
import org.bpy.score.game.game.BatterAdvanceOnHomeRun;
import org.bpy.score.game.game.BatterAdvanceOnInsidePark;
import org.bpy.score.game.game.BatterAdvanceOnIntentionalBaseOnBall;
import org.bpy.score.game.game.BatterAdvanceOnKAbr;
import org.bpy.score.game.game.BatterAdvanceOnKPassBall;
import org.bpy.score.game.game.BatterAdvanceOnKWildPitch;
import org.bpy.score.game.game.BatterAdvanceOnKWithError;
import org.bpy.score.game.game.BatterAdvanceOnKWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnObstruction;
import org.bpy.score.game.game.BatterAdvanceOnOccupedBall;
import org.bpy.score.game.game.BatterAdvanceOnReceiveError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeFlyWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithError;
import org.bpy.score.game.game.BatterAdvanceOnSacrificeHitWithFielderChoice;
import org.bpy.score.game.game.BatterAdvanceOnSingleHit;
import org.bpy.score.game.game.BatterAdvanceOnThrowError;
import org.bpy.score.game.game.BatterAdvanceOnTripleHit;
import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnAppeal;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnGroundedDoublePlay;
import org.bpy.score.game.game.BatterOutOnInfieldFly;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnLineDriveFallBall;
import org.bpy.score.game.game.BatterOutOnLookedStrike;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.BatterOutOnSacrificeFly;
import org.bpy.score.game.game.BatterOutOnSacrificeFlyFallBall;
import org.bpy.score.game.game.BatterOutOnSacrificeHit;
import org.bpy.score.game.game.BatterOutOnSwingedStrike;
import org.bpy.score.game.game.Pitch;
import org.bpy.score.game.game.Pitches;
import org.bpy.score.game.game.RunnerAdvanceByBatterAction;
import org.bpy.score.game.game.RunnerAdvanceOnBalk;
import org.bpy.score.game.game.RunnerAdvanceOnCaughtStealingWithError;
import org.bpy.score.game.game.RunnerAdvanceOnDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnDefensiveChoice;
import org.bpy.score.game.game.RunnerAdvanceOnError;
import org.bpy.score.game.game.RunnerAdvanceOnFielderChoice;
import org.bpy.score.game.game.RunnerAdvanceOnIndiference;
import org.bpy.score.game.game.RunnerAdvanceOnNoDecisiveObstruction;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveFlyError;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnNonDecisiveThrowError;
import org.bpy.score.game.game.RunnerAdvanceOnOccupedBall;
import org.bpy.score.game.game.RunnerAdvanceOnOtherPlayerError;
import org.bpy.score.game.game.RunnerAdvanceOnPassBall;
import org.bpy.score.game.game.RunnerAdvanceOnPickOffWithError;
import org.bpy.score.game.game.RunnerAdvanceOnReceiveError;
import org.bpy.score.game.game.RunnerAdvanceOnRule;
import org.bpy.score.game.game.RunnerAdvanceOnStolenBase;
import org.bpy.score.game.game.RunnerAdvanceOnThrow;
import org.bpy.score.game.game.RunnerAdvanceOnThrowError;
import org.bpy.score.game.game.RunnerAdvanceOnWildPitch;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.game.RunnerOutOnAppeal;
import org.bpy.score.game.game.RunnerOutOnCaugthStealing;
import org.bpy.score.game.game.RunnerOutOnFielderAction;
import org.bpy.score.game.game.RunnerOutOnPickOff;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * This class select the color in function of the type of action.
 * 
 * @author Patrick BRIAND
 *
 */
public class GameSemanticHighLighting implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,	CancelIndicator cancelIndicator) {
		if(resource == null || resource.getParseResult() == null) return;

		ICompositeNode root = resource.getParseResult().getRootNode();
		for (ILeafNode node : root.getLeafNodes()) {

			if (!node.isHidden()) {

				if (node.getSemanticElement() instanceof BatterOutOnSwingedStrike ||
					node.getSemanticElement() instanceof BatterOutOnLookedStrike ||
					node.getSemanticElement() instanceof BatterOutOnReleasedStrike ||
					node.getSemanticElement() instanceof BatterOutOnFlyed ||
					node.getSemanticElement() instanceof BatterOutOnLine ||
					node.getSemanticElement() instanceof BatterOutOnPopped ||
					node.getSemanticElement() instanceof BatterOutOnFlyedFallBall ||
					node.getSemanticElement() instanceof BatterOutOnPoppedFallBall ||
					node.getSemanticElement() instanceof BatterOutOnLineDriveFallBall ||
					node.getSemanticElement() instanceof BatterOutOnGroundedBall ||
					node.getSemanticElement() instanceof BatterOutByRule ||
					node.getSemanticElement() instanceof BatterOutOnAppeal ||
					node.getSemanticElement() instanceof BatterOutOnGroundedDoublePlay ||
					node.getSemanticElement() instanceof BatterOutOnSacrificeFly ||
					node.getSemanticElement() instanceof BatterOutOnSacrificeFlyFallBall ||
					node.getSemanticElement() instanceof BatterOutOnSacrificeHit ||
					node.getSemanticElement() instanceof BatterOutOnInfieldFly ||
					node.getSemanticElement() instanceof RunnerOutOnFielderAction ||
					node.getSemanticElement() instanceof RunnerOutByRules ||
					node.getSemanticElement() instanceof RunnerOutOnAppeal ||
					node.getSemanticElement() instanceof RunnerOutOnCaugthStealing ||
					node.getSemanticElement() instanceof RunnerOutOnPickOff ) {

					setColoration(node.getText(), node.getOffset(), GameHighlightingConfiguration.PUTOUT_ID, acceptor);

				} else if (node.getSemanticElement() instanceof RunnerAdvanceByBatterAction ||
					node.getSemanticElement() instanceof RunnerAdvanceOnError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnStolenBase ||
					node.getSemanticElement() instanceof RunnerAdvanceOnWildPitch ||
					node.getSemanticElement() instanceof RunnerAdvanceOnPassBall ||
					node.getSemanticElement() instanceof RunnerAdvanceOnBalk ||
					node.getSemanticElement() instanceof RunnerAdvanceOnPickOffWithError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnCaughtStealingWithError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnOccupedBall ||
					node.getSemanticElement() instanceof RunnerAdvanceOnThrow ||
					node.getSemanticElement() instanceof RunnerAdvanceOnIndiference ||
					node.getSemanticElement() instanceof RunnerAdvanceOnThrowError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnReceiveError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnNonDecisiveThrowError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnNonDecisiveReceiveError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnDecisiveObstruction ||
					node.getSemanticElement() instanceof RunnerAdvanceOnRule ||
					node.getSemanticElement() instanceof RunnerAdvanceOnFielderChoice ||
					node.getSemanticElement() instanceof RunnerAdvanceOnOtherPlayerError ||
					node.getSemanticElement() instanceof BatterAdvanceOnOccupedBall ||
					node.getSemanticElement() instanceof BatterAdvanceOnDefensiveChoice ||
					node.getSemanticElement() instanceof RunnerAdvanceOnNonDecisiveFlyError ||
					node.getSemanticElement() instanceof RunnerAdvanceOnDefensiveChoice ||
					node.getSemanticElement() instanceof RunnerAdvanceOnNoDecisiveObstruction ||
					node.getSemanticElement() instanceof BatterAdvanceOnBaseOnBall ||
					node.getSemanticElement() instanceof BatterAdvanceOnIntentionalBaseOnBall ||
					node.getSemanticElement() instanceof BatterAdvanceOnHitByPitch ||
					node.getSemanticElement() instanceof BatterAdvanceOnKPassBall ||
					node.getSemanticElement() instanceof BatterAdvanceOnKWildPitch ||
					node.getSemanticElement() instanceof BatterAdvanceOnKAbr ||
					node.getSemanticElement() instanceof BatterAdvanceOnKWithError ||
					node.getSemanticElement() instanceof BatterAdvanceOnSacrificeHitWithError ||
					node.getSemanticElement() instanceof BatterAdvanceOnSacrificeHitWithFielderChoice ||
					node.getSemanticElement() instanceof BatterAdvanceOnSacrificeFlyWithError ||
					node.getSemanticElement() instanceof BatterAdvanceOnSacrificeFlyWithFielderChoice ||
					node.getSemanticElement() instanceof BatterAdvanceOnCatcherInterference ||
					node.getSemanticElement() instanceof BatterAdvanceOnObstruction ||
					node.getSemanticElement() instanceof BatterAdvanceOnKWithFielderChoice ||
					node.getSemanticElement() instanceof BatterAdvanceOnGdpWithFielderChoice ||
					node.getSemanticElement() instanceof BatterAdvanceOnSingleHit ||
					node.getSemanticElement() instanceof BatterAdvanceOnDoubleHit ||
					node.getSemanticElement() instanceof BatterAdvanceOnTripleHit ||
					node.getSemanticElement() instanceof BatterAdvanceOnHomeRun ||
					node.getSemanticElement() instanceof BatterAdvanceOnInsidePark ||
					node.getSemanticElement() instanceof BatterAdvanceOnFlyError ||
					node.getSemanticElement() instanceof BatterAdvanceOnReceiveError ||
					node.getSemanticElement() instanceof BatterAdvanceOnThrowError ||
					node.getSemanticElement() instanceof BatterAdvanceOnGdpWithError ) {

					setColoration(node.getText(), node.getOffset(), GameHighlightingConfiguration.ADVANCE_ID, acceptor);

				} else if (node.getSemanticElement() instanceof Pitches || node.getSemanticElement() instanceof Pitch) {
			    	setPitchesColoration(node.getText(), node.getOffset(), GameHighlightingConfiguration.PITCHE_ID, acceptor);
				
				}
			}
		}
	}
	
	/**
	 * Set color for pitch.
	 * 
	 * @param text text area to colorize
	 * @param offset point 
	 * @param id Id of the style
	 * @param acceptor reference on the IHighlightedPositionAcceptor 
	 */
	private void setPitchesColoration(String text, int offset, String id, IHighlightedPositionAcceptor acceptor) {
		acceptor.addPosition(offset, text.length(), id);
	}

	/**
	 *	Set color for the action .
	 * 
	 * @param text text area to highlight
	 * @param offset point 
	 * @param id Id of the style
	 * @param acceptor reference on the IHighlightedPositionAcceptor 
	 */
	private void setColoration(String text, int offset, String id, IHighlightedPositionAcceptor acceptor) {
		String[] parts = text.split("->"); //$NON-NLS-1$
		if (parts.length == 2) {
			String code = parts[1].replace("earned", "").trim(); //$NON-NLS-1$
			code = code.replace("unEarnedForTeam", "").trim(); //$NON-NLS-1$
			int start = text.trim().indexOf(code);
			acceptor.addPosition(offset + start, code.length(), id);
		} else {
			acceptor.addPosition(offset, text.length(), id);
		}
	}

}
