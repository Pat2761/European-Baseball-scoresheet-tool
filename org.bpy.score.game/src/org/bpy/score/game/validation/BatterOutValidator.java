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
package org.bpy.score.game.validation;

import org.bpy.score.game.game.BatterOutByRule;
import org.bpy.score.game.game.BatterOutOnFlyed;
import org.bpy.score.game.game.BatterOutOnFlyedFallBall;
import org.bpy.score.game.game.BatterOutOnGroundedBall;
import org.bpy.score.game.game.BatterOutOnInfieldFly;
import org.bpy.score.game.game.BatterOutOnLine;
import org.bpy.score.game.game.BatterOutOnPopped;
import org.bpy.score.game.game.BatterOutOnPoppedFallBall;
import org.bpy.score.game.game.BatterOutOnReleasedStrike;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.game.GamePackage;
import org.bpy.score.game.game.RunnerOutByRules;
import org.bpy.score.game.util.ScoreGameUtil;
import org.bpy.score.internationalization.game.Messages;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.validation.Check;

/**
 * Execute some check on game file
 * 
 * @author Patrick BRIAND
 *
 */
public class BatterOutValidator extends AbstractGameValidator {

	/** bad description for an invalid player number (use for quick fix) */
	public static final String INVALID_DEFENDER_NUMMBER = "invalidDefenderNumber"; //$NON-NLS-1$
	/** bad description for an invalid defensive position (use for quick fix) */
	public static final String INVALID_DEFENSIVE_POSITION = "invalidDefensivePosition"; //$NON-NLS-1$
	/** bad description for a suspicious defensive position (use for quick fix) */
	public static final String SUSPICIOUS_DEFENSIVE_POSITION = "suspiciousDefensivePosition"; //$NON-NLS-1$
	/** bad description for an invalid OBR number (use for quick fix) */
	public static final String INVALID_BATTER_OBR_CAUSE = "invalidBatterObrCause"; //$NON-NLS-1$
	/** bad description for an invalid OBR number (use for quick fix) */
	public static final String INVALID_RUNNER_OBR_CAUSE = "invalidRunnerObrCause"; //$NON-NLS-1$

	/**
	 * Check that the fielder which make the out is define between 1 to 9
	 * Check that each fielder which make assist is define between 1 to 9
	 * 
	 * @param releaseStrikeOut Action to check 
	 */
	@Check
	public void checkReleasedStrikeOutConsistency(BatterOutOnReleasedStrike releaseStrikeOut) {
		String defenderPart = ScoreGameUtil.getDefenderPart(releaseStrikeOut);

		char outMadeBy = ScoreGameUtil.getPutoutDefender(defenderPart);
		if (outMadeBy < '1' || outMadeBy > '9') {
			error(
				NLS.bind(Messages.BatterOutValidator_badDefenderNumber, outMadeBy),   
				GamePackage.eINSTANCE.getStrikeOut_StrikeOutValue(),
				INVALID_DEFENDER_NUMMBER
			);
		}

		String assist = ScoreGameUtil.getAssistDefender(defenderPart);
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number), 
						GamePackage.eINSTANCE.getStrikeOut_StrikeOutValue(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}
	}

	/**
	 * Check that only one defensive position is set
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Warning if infield fly define a defensive position in the outfield
	 * 
	 * @param infieldFlyOut Action to check 
	 */
	@Check
	public void checkInfieldFlyOutConsistency(BatterOutOnInfieldFly infieldFlyOut) {
		String defensivePosition = ScoreGameUtil.getDefensivePosition(infieldFlyOut);

		if (defensivePosition.length() != 1) {
			error(
				Messages.BatterOutValidator_infieldFlyMissingDefenderNumber,
				GamePackage.eINSTANCE.getBatterOutOnInfieldFly_BatterOut(),
				INVALID_DEFENSIVE_POSITION
			);
		} else {
			if (defensivePosition.charAt(0) < '1' || defensivePosition.charAt(0) > '9') {
				error(
					NLS.bind(Messages.BatterOutValidator_badDefenderNumber, defensivePosition), 
					GamePackage.eINSTANCE.getBatterOutOnInfieldFly_BatterOut(),
					INVALID_DEFENSIVE_POSITION
				);
			} else if (defensivePosition.charAt(0) > '6') {
				warning(
					NLS.bind(Messages.BatterOutValidator_infieldFlySuspiciousDefenderNumber, defensivePosition), 
					GamePackage.eINSTANCE.getBatterOutOnInfieldFly_BatterOut(),
					SUSPICIOUS_DEFENSIVE_POSITION
				);
			}
		}
	}

	/**
	 * Suspicious if fly is catch by the pitcher or the catcher
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param flyedOut Action to check 
	 *
	 */
	@Check
	public void checkFlyedOut(BatterOutOnFlyed flyedOut) {
		char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(flyedOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		char char1 = '1';
		char char2 = '2';

		if (putoutDefender == char1 || putoutDefender == char2) {
			warning(
				NLS.bind(Messages.BatterOutValidator_FlyCatchSuspiciousDefenderNumber, putoutDefender), 
				GamePackage.eINSTANCE.getBatterOutOnFlyed_BatterOut(),
				SUSPICIOUS_DEFENSIVE_POSITION
			);
		}

		if (putoutDefender < '1' || putoutDefender > '9') {
			error(
				NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
				GamePackage.eINSTANCE.getBatterOutOnFlyed_BatterOut(),
				INVALID_DEFENDER_NUMMBER
			);
		}


		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(flyedOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number), 
						GamePackage.eINSTANCE.getBatterOutOnFlyed_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnFlyed_BatterOut());
	}

	/**
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param lineOut Action to check 
	 *
	 */
	@Check
	public void checkLineOut(BatterOutOnLine lineOut) {
	    char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(lineOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (putoutDefender < '1' || putoutDefender > '9') {
				error(
					NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
					GamePackage.eINSTANCE.getBatterOutOnLine_BatterOut(),
					INVALID_DEFENDER_NUMMBER
				);
		}

		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(lineOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number), 
						GamePackage.eINSTANCE.getBatterOutOnLine_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnLine_BatterOut());
	}

	/**
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param poppedOut Action to check 
	 *
	 */
	@Check
	public void checkPoppedOut(BatterOutOnPopped poppedOut) {
		char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(poppedOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (putoutDefender < '1' || putoutDefender > '9') {
				error(
					NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
					GamePackage.eINSTANCE.getBatterOutOnPopped_BatterOut(),
					INVALID_DEFENDER_NUMMBER
				);
		}

		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(poppedOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number), 
						GamePackage.eINSTANCE.getBatterOutOnPopped_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnPopped_BatterOut());
	}

	/**
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param poppedFallBallOut Action to check 
	 *
	 */
	@Check
	public void checkPoppedOut(BatterOutOnPoppedFallBall poppedFallBallOut) {
		char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(poppedFallBallOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (putoutDefender < '1' || putoutDefender > '9') {
				error(
					NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
					GamePackage.eINSTANCE.getBatterOutOnPoppedFallBall_BatterOut(),
					INVALID_DEFENDER_NUMMBER
				);
		}

		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(poppedFallBallOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number), 
						GamePackage.eINSTANCE.getBatterOutOnPoppedFallBall_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnPoppedFallBall_BatterOut());
	}

	/**
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param groundedOut Action to check 
	 *
	 */
	@Check
	public void checkGroundedOut(BatterOutOnGroundedBall groundedOut) {
		char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(groundedOut));
		if (putoutDefender < '1' || putoutDefender > '9') {
				error(
					NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender),  
					GamePackage.eINSTANCE.getBatterOutOnGroundedBall_BatterOut(),
					INVALID_DEFENDER_NUMMBER
				);
		}

		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(groundedOut));
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, number),
						GamePackage.eINSTANCE.getBatterOutOnGroundedBall_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnGroundedBall_BatterOut());
	}

//	/**
//	 * Check that the defensive position is a valid defensive position (1..9)
//	 * Check that assist and out can't be done by the same defensive position
//	 * 
//	 * @param outOutByRuleOut Action to check 
//	 *
//	 */
//	@Check
//	public void checkBatterOutByRule(BatterOutByRule outOutByRuleOut) {
//
//		String obrType = ScoreGameUtil.getOBRType(outOutByRuleOut);
//		
//		if ("KS".equals(obrType) ||  //$NON-NLS-1$
//		    "1".equals(obrType) || "2".equals(obrType) || "3".equals(obrType) || "4".equals(obrType) ||   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
//		    "5".equals(obrType) || "6".equals(obrType)  || "8".equals(obrType) ||  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
//		    "14".equals(obrType)  || "16".equals(obrType)  ) { //$NON-NLS-1$ //$NON-NLS-2$  
//		    
//			// it is paerfect
//			
//	    }  else  {
//			error(
//				NLS.bind(Messages.BatterOutValidator_invalidBatterBaseballObr, new String[] {obrType }),
//				GamePackage.eINSTANCE.getBatterOutByRule_BatterOut(),
//				INVALID_BATTER_OBR_CAUSE);
//	    }
//				
//
//		Game game = (Game) EcoreUtil.getRootContainer(outOutByRuleOut);
//		if ( ("baseball".equals(ScoreGameUtil.getTypeOfGame(game))) && //$NON-NLS-1$  
//			 ("15".equals(obrType) || "16".equals(obrType))) { //$NON-NLS-1$  //$NON-NLS-2$
//			 	error(
//					NLS.bind(Messages.BatterOutValidator_badBaseballObrCause, outOutByRuleOut.getBatterOut()),
//					GamePackage.eINSTANCE.getBatterOutByRule_BatterOut(),
//					INVALID_BATTER_OBR_CAUSE
//			);
//    	}
//	}
//
//	/**
//	 * Check that the defensive position is a valid defensive position (1..9)
//	 * Check that assist and out can't be done by the same defensive position
//	 * 
//	 * @param outOutByRuleOut Action to check 
//	 *
//	 */
//	@Check
//	public void checkRunnerOutByRule(RunnerOutByRules outOutByRuleOut) {
//
//		String obrType = ScoreGameUtil.getOBRType(outOutByRuleOut);
//		
//		if ("7".equals(obrType) || //$NON-NLS-1$ 
//		    "9".equals(obrType) || "10".equals(obrType) || "11".equals(obrType) || "12".equals(obrType) ||  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
//		    "13".equals(obrType)|| "14".equals(obrType)|| "15".equals(obrType)) { //$NON-NLS-1$ //$NON-NLS-2$   //$NON-NLS-3$ 
//		    
//			// it is paerfect
//			
//	    }  else  {
//			error(
//				NLS.bind(Messages.BatterOutValidator_invalidRunnerBaseballObr, new String[] {obrType }),
//				GamePackage.eINSTANCE.getRunnerOutByRules_RunnerOut(),
//				INVALID_RUNNER_OBR_CAUSE);
//	    }
//				
//
//		Game game = (Game) EcoreUtil.getRootContainer(outOutByRuleOut);
//		if ( ("baseball".equals(ScoreGameUtil.getTypeOfGame(game))) && //$NON-NLS-1$  
//			 ("15".equals(obrType) || "16".equals(obrType))) { //$NON-NLS-1$  //$NON-NLS-2$
//			 	error(
//					NLS.bind(Messages.BatterOutValidator_badBaseballObrCause, outOutByRuleOut.getRunnerOut()),
//					GamePackage.eINSTANCE.getRunnerOutByRules_RunnerOut(),
//					INVALID_RUNNER_OBR_CAUSE
//			);
//    	}
//	}

	
	/**
	 * Suspicious if fly is catch by the pitcher or the catcher
	 * Check that the defensive position is a valid defensive position (1..9)
	 * Check that assist and out can't be done by the same defensive position
	 * 
	 * @param flyedFallBallOut Action to check 
	 *
	 */
	@Check
	public void checkFlyedOut(BatterOutOnFlyedFallBall flyedFallBallOut) {
		char putoutDefender = ScoreGameUtil.getPutoutDefender(ScoreGameUtil.getDefensivePosition(flyedFallBallOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		char char1 = '1';
		char char2 = '2';

		if (putoutDefender == char1 || putoutDefender == char2) {
			warning(
				NLS.bind(Messages.BatterOutValidator_FlyCatchSuspiciousDefenderNumber, putoutDefender), 
				GamePackage.eINSTANCE.getBatterOutOnFlyedFallBall_BatterOut(),
				SUSPICIOUS_DEFENSIVE_POSITION
			);
		}

		if (putoutDefender < '1' || putoutDefender > '9') {
			error(
				NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
				GamePackage.eINSTANCE.getBatterOutOnFlyedFallBall_BatterOut(),
				INVALID_DEFENDER_NUMMBER
			);
		}


		String assist = ScoreGameUtil.getAssistDefender(ScoreGameUtil.getDefensivePosition(flyedFallBallOut).replace("b","")); //$NON-NLS-1$  //$NON-NLS-2$
		if (!assist.isEmpty()) {
			for (char number : assist.toCharArray()) {
				if (number < '1' || number > '9') {
					error(
						NLS.bind(Messages.BatterOutValidator_badDefenderNumber, putoutDefender), 
						GamePackage.eINSTANCE.getBatterOutOnFlyedFallBall_BatterOut(),
						INVALID_DEFENDER_NUMMBER
					);
				}
			}
		}

		checkConsistencyAssistAndOut(putoutDefender, assist, GamePackage.eINSTANCE.getBatterOutOnFlyedFallBall_BatterOut());
	}
	
	/**
	 * Check that the last assist defender don't make the put out
	 * 
	 * @param outDefensivePosition put out number
	 * @param assists assist numbers
	 * @param attribute Attribute reference for setting the error
	 */
	private void checkConsistencyAssistAndOut(char outDefensivePosition, String assists, EAttribute attribute) {
		if (assists.length()>0) {
			char lastAssist = assists.charAt(assists.length()-1);
			if (lastAssist == outDefensivePosition) {
				error(
					NLS.bind(Messages.BatterOutValidator_badLastAssistDefenderNumber, lastAssist), 
					attribute,
					INVALID_DEFENDER_NUMMBER
				);
			}
		}
	}
}
