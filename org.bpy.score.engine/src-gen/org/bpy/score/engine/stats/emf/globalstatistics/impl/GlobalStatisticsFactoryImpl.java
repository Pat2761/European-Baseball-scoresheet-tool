/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.*;

import org.eclipse.emf.ecore.EClass;
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
public class GlobalStatisticsFactoryImpl extends EFactoryImpl implements GlobalStatisticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GlobalStatisticsFactory init() {
		try {
			GlobalStatisticsFactory theGlobalStatisticsFactory = (GlobalStatisticsFactory)EPackage.Registry.INSTANCE.getEFactory(GlobalStatisticsPackage.eNS_URI);
			if (theGlobalStatisticsFactory != null) {
				return theGlobalStatisticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GlobalStatisticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalStatisticsFactoryImpl() {
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
			case GlobalStatisticsPackage.GLOBAL_STATISTIC: return createGlobalStatistic();
			case GlobalStatisticsPackage.TEAM_STATISTICS: return createTeamStatistics();
			case GlobalStatisticsPackage.MEMBER: return createMember();
			case GlobalStatisticsPackage.PITCHER_STATISTICS: return createPitcherStatistics();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS: return createOffensiveStatistics();
			case GlobalStatisticsPackage.DEFENSIVE_STATISTICS: return createDefensiveStatistics();
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
	public GlobalStatistic createGlobalStatistic() {
		GlobalStatisticImpl globalStatistic = new GlobalStatisticImpl();
		return globalStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TeamStatistics createTeamStatistics() {
		TeamStatisticsImpl teamStatistics = new TeamStatisticsImpl();
		return teamStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member createMember() {
		MemberImpl member = new MemberImpl();
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PitcherStatistics createPitcherStatistics() {
		PitcherStatisticsImpl pitcherStatistics = new PitcherStatisticsImpl();
		return pitcherStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OffensiveStatistics createOffensiveStatistics() {
		OffensiveStatisticsImpl offensiveStatistics = new OffensiveStatisticsImpl();
		return offensiveStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefensiveStatistics createDefensiveStatistics() {
		DefensiveStatisticsImpl defensiveStatistics = new DefensiveStatisticsImpl();
		return defensiveStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GlobalStatisticsPackage getGlobalStatisticsPackage() {
		return (GlobalStatisticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GlobalStatisticsPackage getPackage() {
		return GlobalStatisticsPackage.eINSTANCE;
	}

} //GlobalStatisticsFactoryImpl
