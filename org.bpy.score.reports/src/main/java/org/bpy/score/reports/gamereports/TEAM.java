/**
 */
package org.bpy.score.reports.gamereports;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TEAM</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getTEAM()
 * @model
 * @generated
 */
public enum TEAM implements Enumerator {
	/**
	 * The '<em><b>HOMETEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOMETEAM_VALUE
	 * @generated
	 * @ordered
	 */
	HOMETEAM(0, "HOMETEAM", "HOMETEAM"),

	/**
	 * The '<em><b>VISITOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISITOR_VALUE
	 * @generated
	 * @ordered
	 */
	VISITOR(1, "VISITOR", "VISITOR");

	/**
	 * The '<em><b>HOMETEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOMETEAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOMETEAM_VALUE = 0;

	/**
	 * The '<em><b>VISITOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISITOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VISITOR_VALUE = 1;

	/**
	 * An array of all the '<em><b>TEAM</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TEAM[] VALUES_ARRAY =
		new TEAM[] {
			HOMETEAM,
			VISITOR,
		};

	/**
	 * A public read-only list of all the '<em><b>TEAM</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TEAM> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TEAM</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TEAM get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TEAM result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TEAM</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TEAM getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TEAM result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TEAM</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TEAM get(int value) {
		switch (value) {
			case HOMETEAM_VALUE: return HOMETEAM;
			case VISITOR_VALUE: return VISITOR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TEAM(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TEAM
