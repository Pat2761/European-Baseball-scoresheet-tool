/**
 */
package org.bpy.score.reports.gamereports.util;

import org.bpy.score.reports.gamereports.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.bpy.score.reports.gamereports.GameReportsPackage
 * @generated
 */
public class GameReportsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GameReportsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GameReportsSwitch() {
		if (modelPackage == null) {
			modelPackage = GameReportsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GameReportsPackage.GAME_REPORT: {
				GameReport gameReport = (GameReport)theEObject;
				T result = caseGameReport(gameReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.TEAM_STATISITICS: {
				TeamStatisitics teamStatisitics = (TeamStatisitics)theEObject;
				T result = caseTeamStatisitics(teamStatisitics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.PITCHER_STATISTIC: {
				PitcherStatistic pitcherStatistic = (PitcherStatistic)theEObject;
				T result = casePitcherStatistic(pitcherStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.DEFENSIVE_STATISTIC: {
				DefensiveStatistic defensiveStatistic = (DefensiveStatistic)theEObject;
				T result = caseDefensiveStatistic(defensiveStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.CATCHER_STATISTIC: {
				CatcherStatistic catcherStatistic = (CatcherStatistic)theEObject;
				T result = caseCatcherStatistic(catcherStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.OFFENSIVE_STATISTIC: {
				OffensiveStatistic offensiveStatistic = (OffensiveStatistic)theEObject;
				T result = caseOffensiveStatistic(offensiveStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.PLAYER: {
				Player player = (Player)theEObject;
				T result = casePlayer(player);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.PLAY_BY_PLAY: {
				PlayByPlay playByPlay = (PlayByPlay)theEObject;
				T result = casePlayByPlay(playByPlay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.GAME_GENERAL_STATS: {
				GameGeneralStats gameGeneralStats = (GameGeneralStats)theEObject;
				T result = caseGameGeneralStats(gameGeneralStats);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.POINTS_PER_INNING: {
				PointsPerInning pointsPerInning = (PointsPerInning)theEObject;
				T result = casePointsPerInning(pointsPerInning);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.STARTING_LINEUP: {
				StartingLineup startingLineup = (StartingLineup)theEObject;
				T result = caseStartingLineup(startingLineup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.LINEUP_PLAYER: {
				LineupPlayer lineupPlayer = (LineupPlayer)theEObject;
				T result = caseLineupPlayer(lineupPlayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GameReportsPackage.ACTION_DESCRIPTION: {
				ActionDescription actionDescription = (ActionDescription)theEObject;
				T result = caseActionDescription(actionDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Game Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Game Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGameReport(GameReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Team Statisitics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Team Statisitics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTeamStatisitics(TeamStatisitics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pitcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pitcher Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePitcherStatistic(PitcherStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defensive Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefensiveStatistic(DefensiveStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catcher Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catcher Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatcherStatistic(CatcherStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offensive Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offensive Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOffensiveStatistic(OffensiveStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlayer(Player object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Play By Play</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Play By Play</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlayByPlay(PlayByPlay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Game General Stats</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Game General Stats</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGameGeneralStats(GameGeneralStats object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Points Per Inning</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Points Per Inning</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointsPerInning(PointsPerInning object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Starting Lineup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Starting Lineup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartingLineup(StartingLineup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lineup Player</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lineup Player</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineupPlayer(LineupPlayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionDescription(ActionDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GameReportsSwitch
