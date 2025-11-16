/**
 */
package org.bpy.score.engine.stats.emf.statistic.util;

import java.util.Map;

import org.bpy.score.engine.stats.emf.statistic.*;

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
 * @see org.bpy.score.engine.stats.emf.statistic.StatisticPackage
 * @generated
 */
public class StatisticSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatisticPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticSwitch() {
		if (modelPackage == null) {
			modelPackage = StatisticPackage.eINSTANCE;
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
			case StatisticPackage.GAME_STATISTIC: {
				GameStatistic gameStatistic = (GameStatistic)theEObject;
				T result = caseGameStatistic(gameStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.TEAM_STATISTIC: {
				TeamStatistic teamStatistic = (TeamStatistic)theEObject;
				T result = caseTeamStatistic(teamStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.INNING_GENERAL_STATISTIC: {
				InningGeneralStatistic inningGeneralStatistic = (InningGeneralStatistic)theEObject;
				T result = caseInningGeneralStatistic(inningGeneralStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.INNIN_STATICTIC: {
				InninStatictic inninStatictic = (InninStatictic)theEObject;
				T result = caseInninStatictic(inninStatictic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.OFFENSIVE_STATISTIC: {
				OffensiveStatistic offensiveStatistic = (OffensiveStatistic)theEObject;
				T result = caseOffensiveStatistic(offensiveStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.PITCHER_STATISTIC: {
				PitcherStatistic pitcherStatistic = (PitcherStatistic)theEObject;
				T result = casePitcherStatistic(pitcherStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.CATCHER_STATISTIC: {
				CatcherStatistic catcherStatistic = (CatcherStatistic)theEObject;
				T result = caseCatcherStatistic(catcherStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.DEFENSIVE_STATISTIC: {
				DefensiveStatistic defensiveStatistic = (DefensiveStatistic)theEObject;
				T result = caseDefensiveStatistic(defensiveStatistic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.LINEUP_ENTRY: {
				LineupEntry lineupEntry = (LineupEntry)theEObject;
				T result = caseLineupEntry(lineupEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.ESTRING_TO_ASSOCIATED_OBJECT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Object> eStringToAssociatedObjectMap = (Map.Entry<String, Object>)theEObject;
				T result = caseEStringToAssociatedObjectMap(eStringToAssociatedObjectMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatisticPackage.ESTRING_TO_LINEUP_ENTRY_TYPE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, LineupEntry> eStringToLineupEntryTypeMap = (Map.Entry<String, LineupEntry>)theEObject;
				T result = caseEStringToLineupEntryTypeMap(eStringToLineupEntryTypeMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Game Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Game Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGameStatistic(GameStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Team Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Team Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTeamStatistic(TeamStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inning General Statistic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inning General Statistic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInningGeneralStatistic(InningGeneralStatistic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Innin Statictic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Innin Statictic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInninStatictic(InninStatictic object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Lineup Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lineup Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineupEntry(LineupEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To Associated Object Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To Associated Object Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToAssociatedObjectMap(Map.Entry<String, Object> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To Lineup Entry Type Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To Lineup Entry Type Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringToLineupEntryTypeMap(Map.Entry<String, LineupEntry> object) {
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

} //StatisticSwitch
