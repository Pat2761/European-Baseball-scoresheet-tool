/**
 */
package org.bpy.score.engine.stats.emf.globalstatistics.impl;

import org.bpy.score.engine.stats.emf.globalstatistics.GlobalStatisticsPackage;
import org.bpy.score.engine.stats.emf.globalstatistics.OffensiveStatistics;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Offensive Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getHits <em>Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getBaseOnBalls <em>Base On Balls</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getHitsByPitch <em>Hits By Pitch</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getAtBats <em>At Bats</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getSacrificeFlies <em>Sacrifice Flies</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getDoubleBaseHits <em>Double Base Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getTripleBaseHits <em>Triple Base Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getFourBaseHits <em>Four Base Hits</em>}</li>
 *   <li>{@link org.bpy.score.engine.stats.emf.globalstatistics.impl.OffensiveStatisticsImpl#getPlateAppearance <em>Plate Appearance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OffensiveStatisticsImpl extends MinimalEObjectImpl.Container implements OffensiveStatistics {
	/**
	 * The default value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected static final int HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHits() <em>Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHits()
	 * @generated
	 * @ordered
	 */
	protected int hits = HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseOnBalls() <em>Base On Balls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseOnBalls()
	 * @generated
	 * @ordered
	 */
	protected static final int BASE_ON_BALLS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getBaseOnBalls() <em>Base On Balls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseOnBalls()
	 * @generated
	 * @ordered
	 */
	protected int baseOnBalls = BASE_ON_BALLS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHitsByPitch() <em>Hits By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitsByPitch()
	 * @generated
	 * @ordered
	 */
	protected static final int HITS_BY_PITCH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getHitsByPitch() <em>Hits By Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHitsByPitch()
	 * @generated
	 * @ordered
	 */
	protected int hitsByPitch = HITS_BY_PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getAtBats() <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtBats()
	 * @generated
	 * @ordered
	 */
	protected static final int AT_BATS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getAtBats() <em>At Bats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtBats()
	 * @generated
	 * @ordered
	 */
	protected int atBats = AT_BATS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSacrificeFlies() <em>Sacrifice Flies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeFlies()
	 * @generated
	 * @ordered
	 */
	protected static final int SACRIFICE_FLIES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSacrificeFlies() <em>Sacrifice Flies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSacrificeFlies()
	 * @generated
	 * @ordered
	 */
	protected int sacrificeFlies = SACRIFICE_FLIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoubleBaseHits() <em>Double Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleBaseHits()
	 * @generated
	 * @ordered
	 */
	protected static final int DOUBLE_BASE_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getDoubleBaseHits() <em>Double Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleBaseHits()
	 * @generated
	 * @ordered
	 */
	protected int doubleBaseHits = DOUBLE_BASE_HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTripleBaseHits() <em>Triple Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripleBaseHits()
	 * @generated
	 * @ordered
	 */
	protected static final int TRIPLE_BASE_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getTripleBaseHits() <em>Triple Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripleBaseHits()
	 * @generated
	 * @ordered
	 */
	protected int tripleBaseHits = TRIPLE_BASE_HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFourBaseHits() <em>Four Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFourBaseHits()
	 * @generated
	 * @ordered
	 */
	protected static final int FOUR_BASE_HITS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getFourBaseHits() <em>Four Base Hits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFourBaseHits()
	 * @generated
	 * @ordered
	 */
	protected int fourBaseHits = FOUR_BASE_HITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlateAppearance() <em>Plate Appearance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearance()
	 * @generated
	 * @ordered
	 */
	protected static final int PLATE_APPEARANCE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPlateAppearance() <em>Plate Appearance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlateAppearance()
	 * @generated
	 * @ordered
	 */
	protected int plateAppearance = PLATE_APPEARANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OffensiveStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlobalStatisticsPackage.Literals.OFFENSIVE_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHits() {
		return hits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHits(int newHits) {
		int oldHits = hits;
		hits = newHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS, oldHits, hits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBaseOnBalls() {
		return baseOnBalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseOnBalls(int newBaseOnBalls) {
		int oldBaseOnBalls = baseOnBalls;
		baseOnBalls = newBaseOnBalls;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BASE_ON_BALLS, oldBaseOnBalls, baseOnBalls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHitsByPitch() {
		return hitsByPitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHitsByPitch(int newHitsByPitch) {
		int oldHitsByPitch = hitsByPitch;
		hitsByPitch = newHitsByPitch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS_BY_PITCH, oldHitsByPitch, hitsByPitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAtBats() {
		return atBats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtBats(int newAtBats) {
		int oldAtBats = atBats;
		atBats = newAtBats;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS, oldAtBats, atBats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSacrificeFlies() {
		return sacrificeFlies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSacrificeFlies(int newSacrificeFlies) {
		int oldSacrificeFlies = sacrificeFlies;
		sacrificeFlies = newSacrificeFlies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLIES, oldSacrificeFlies, sacrificeFlies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDoubleBaseHits() {
		return doubleBaseHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDoubleBaseHits(int newDoubleBaseHits) {
		int oldDoubleBaseHits = doubleBaseHits;
		doubleBaseHits = newDoubleBaseHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS, oldDoubleBaseHits, doubleBaseHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTripleBaseHits() {
		return tripleBaseHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTripleBaseHits(int newTripleBaseHits) {
		int oldTripleBaseHits = tripleBaseHits;
		tripleBaseHits = newTripleBaseHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS, oldTripleBaseHits, tripleBaseHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFourBaseHits() {
		return fourBaseHits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFourBaseHits(int newFourBaseHits) {
		int oldFourBaseHits = fourBaseHits;
		fourBaseHits = newFourBaseHits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__FOUR_BASE_HITS, oldFourBaseHits, fourBaseHits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPlateAppearance() {
		return plateAppearance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlateAppearance(int newPlateAppearance) {
		int oldPlateAppearance = plateAppearance;
		plateAppearance = newPlateAppearance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE, oldPlateAppearance, plateAppearance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				return getHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BASE_ON_BALLS:
				return getBaseOnBalls();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS_BY_PITCH:
				return getHitsByPitch();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				return getAtBats();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLIES:
				return getSacrificeFlies();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS:
				return getDoubleBaseHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS:
				return getTripleBaseHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__FOUR_BASE_HITS:
				return getFourBaseHits();
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				return getPlateAppearance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				setHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BASE_ON_BALLS:
				setBaseOnBalls((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS_BY_PITCH:
				setHitsByPitch((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				setAtBats((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLIES:
				setSacrificeFlies((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS:
				setDoubleBaseHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS:
				setTripleBaseHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__FOUR_BASE_HITS:
				setFourBaseHits((Integer)newValue);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				setPlateAppearance((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				setHits(HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BASE_ON_BALLS:
				setBaseOnBalls(BASE_ON_BALLS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS_BY_PITCH:
				setHitsByPitch(HITS_BY_PITCH_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				setAtBats(AT_BATS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLIES:
				setSacrificeFlies(SACRIFICE_FLIES_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS:
				setDoubleBaseHits(DOUBLE_BASE_HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS:
				setTripleBaseHits(TRIPLE_BASE_HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__FOUR_BASE_HITS:
				setFourBaseHits(FOUR_BASE_HITS_EDEFAULT);
				return;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				setPlateAppearance(PLATE_APPEARANCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS:
				return hits != HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__BASE_ON_BALLS:
				return baseOnBalls != BASE_ON_BALLS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__HITS_BY_PITCH:
				return hitsByPitch != HITS_BY_PITCH_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__AT_BATS:
				return atBats != AT_BATS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__SACRIFICE_FLIES:
				return sacrificeFlies != SACRIFICE_FLIES_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__DOUBLE_BASE_HITS:
				return doubleBaseHits != DOUBLE_BASE_HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__TRIPLE_BASE_HITS:
				return tripleBaseHits != TRIPLE_BASE_HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__FOUR_BASE_HITS:
				return fourBaseHits != FOUR_BASE_HITS_EDEFAULT;
			case GlobalStatisticsPackage.OFFENSIVE_STATISTICS__PLATE_APPEARANCE:
				return plateAppearance != PLATE_APPEARANCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (hits: ");
		result.append(hits);
		result.append(", baseOnBalls: ");
		result.append(baseOnBalls);
		result.append(", hitsByPitch: ");
		result.append(hitsByPitch);
		result.append(", atBats: ");
		result.append(atBats);
		result.append(", sacrificeFlies: ");
		result.append(sacrificeFlies);
		result.append(", doubleBaseHits: ");
		result.append(doubleBaseHits);
		result.append(", tripleBaseHits: ");
		result.append(tripleBaseHits);
		result.append(", fourBaseHits: ");
		result.append(fourBaseHits);
		result.append(", plateAppearance: ");
		result.append(plateAppearance);
		result.append(')');
		return result.toString();
	}

} //OffensiveStatisticsImpl
