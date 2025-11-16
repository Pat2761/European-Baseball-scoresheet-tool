/**
 */
package org.bpy.score.engine.stats.emf.statistic.impl;

import java.util.Map;

import org.bpy.score.engine.manager.lineup.LineupPlayerDescription;

import org.bpy.score.engine.stats.emf.statistic.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatisticFactoryImpl extends EFactoryImpl implements StatisticFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatisticFactory init() {
		try {
			StatisticFactory theStatisticFactory = (StatisticFactory)EPackage.Registry.INSTANCE.getEFactory(StatisticPackage.eNS_URI);
			if (theStatisticFactory != null) {
				return theStatisticFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatisticFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StatisticPackage.GAME_STATISTIC: return createGameStatistic();
			case StatisticPackage.TEAM_STATISTIC: return createTeamStatistic();
			case StatisticPackage.INNING_GENERAL_STATISTIC: return createInningGeneralStatistic();
			case StatisticPackage.INNIN_STATICTIC: return createInninStatictic();
			case StatisticPackage.OFFENSIVE_STATISTIC: return createOffensiveStatistic();
			case StatisticPackage.PITCHER_STATISTIC: return createPitcherStatistic();
			case StatisticPackage.CATCHER_STATISTIC: return createCatcherStatistic();
			case StatisticPackage.DEFENSIVE_STATISTIC: return createDefensiveStatistic();
			case StatisticPackage.LINEUP_ENTRY: return createLineupEntry();
			case StatisticPackage.ESTRING_TO_ASSOCIATED_OBJECT_MAP: return (EObject)createEStringToAssociatedObjectMap();
			case StatisticPackage.ESTRING_TO_LINEUP_ENTRY_TYPE_MAP: return (EObject)createEStringToLineupEntryTypeMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StatisticPackage.LINEUP_ENTRY_TYPE:
				return createLineupEntryTypeFromString(eDataType, initialValue);
			case StatisticPackage.ASSOCIATED_OBJECT:
				return createAssociatedObjectFromString(eDataType, initialValue);
			case StatisticPackage.PLAYER_DESCRIPTION:
				return createPlayerDescriptionFromString(eDataType, initialValue);
			case StatisticPackage.DEFENSIVE_STATISTIC_TYPE:
				return createDefensiveStatisticTypeFromString(eDataType, initialValue);
			case StatisticPackage.CATCHER_STATISTIC_TYPE:
				return createCatcherStatisticTypeFromString(eDataType, initialValue);
			case StatisticPackage.OFFENSIVE_STATISTIC_TYPE:
				return createOffensiveStatisticTypeFromString(eDataType, initialValue);
			case StatisticPackage.PITCHER_STATISTIC_TYPE:
				return createPitcherStatisticTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StatisticPackage.LINEUP_ENTRY_TYPE:
				return convertLineupEntryTypeToString(eDataType, instanceValue);
			case StatisticPackage.ASSOCIATED_OBJECT:
				return convertAssociatedObjectToString(eDataType, instanceValue);
			case StatisticPackage.PLAYER_DESCRIPTION:
				return convertPlayerDescriptionToString(eDataType, instanceValue);
			case StatisticPackage.DEFENSIVE_STATISTIC_TYPE:
				return convertDefensiveStatisticTypeToString(eDataType, instanceValue);
			case StatisticPackage.CATCHER_STATISTIC_TYPE:
				return convertCatcherStatisticTypeToString(eDataType, instanceValue);
			case StatisticPackage.OFFENSIVE_STATISTIC_TYPE:
				return convertOffensiveStatisticTypeToString(eDataType, instanceValue);
			case StatisticPackage.PITCHER_STATISTIC_TYPE:
				return convertPitcherStatisticTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GameStatistic createGameStatistic() {
		GameStatisticImpl gameStatistic = new GameStatisticImpl();
		return gameStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatistic createTeamStatistic() {
		TeamStatisticImpl teamStatistic = new TeamStatisticImpl();
		return teamStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InningGeneralStatistic createInningGeneralStatistic() {
		InningGeneralStatisticImpl inningGeneralStatistic = new InningGeneralStatisticImpl();
		return inningGeneralStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InninStatictic createInninStatictic() {
		InninStaticticImpl inninStatictic = new InninStaticticImpl();
		return inninStatictic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistic createOffensiveStatistic() {
		OffensiveStatisticImpl offensiveStatistic = new OffensiveStatisticImpl();
		return offensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistic createPitcherStatistic() {
		PitcherStatisticImpl pitcherStatistic = new PitcherStatisticImpl();
		return pitcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CatcherStatistic createCatcherStatistic() {
		CatcherStatisticImpl catcherStatistic = new CatcherStatisticImpl();
		return catcherStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistic createDefensiveStatistic() {
		DefensiveStatisticImpl defensiveStatistic = new DefensiveStatisticImpl();
		return defensiveStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineupEntry createLineupEntry() {
		LineupEntryImpl lineupEntry = new LineupEntryImpl();
		return lineupEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createEStringToAssociatedObjectMap() {
		EStringToAssociatedObjectMapImpl eStringToAssociatedObjectMap = new EStringToAssociatedObjectMapImpl();
		return eStringToAssociatedObjectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, LineupEntry> createEStringToLineupEntryTypeMap() {
		EStringToLineupEntryTypeMapImpl eStringToLineupEntryTypeMap = new EStringToLineupEntryTypeMapImpl();
		return eStringToLineupEntryTypeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineupEntry createLineupEntryTypeFromString(EDataType eDataType, String initialValue) {
		return (LineupEntry)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLineupEntryTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createAssociatedObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssociatedObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineupPlayerDescription createPlayerDescriptionFromString(EDataType eDataType, String initialValue) {
		return (LineupPlayerDescription)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPlayerDescriptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefensiveStatistic createDefensiveStatisticTypeFromString(EDataType eDataType, String initialValue) {
		return (DefensiveStatistic)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefensiveStatisticTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatcherStatistic createCatcherStatisticTypeFromString(EDataType eDataType, String initialValue) {
		return (CatcherStatistic)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCatcherStatisticTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OffensiveStatistic createOffensiveStatisticTypeFromString(EDataType eDataType, String initialValue) {
		return (OffensiveStatistic)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOffensiveStatisticTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PitcherStatistic createPitcherStatisticTypeFromString(EDataType eDataType, String initialValue) {
		return (PitcherStatistic)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPitcherStatisticTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatisticPackage getStatisticPackage() {
		return (StatisticPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatisticPackage getPackage() {
		return StatisticPackage.eINSTANCE;
	}

} //StatisticFactoryImpl
