/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catcher Statistic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.CatcherStatistic#getPassBall <em>Pass Ball</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.CatcherStatistic#getStolenBase <em>Stolen Base</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.CatcherStatistic#getCaughtStealing <em>Caught Stealing</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getCatcherStatistic()
 * @model extendedMetaData="kind='elementOnly' name='CATCHER-STATISTICS'"
 * @generated
 */
public interface CatcherStatistic extends EObject {
	/**
	 * Returns the value of the '<em><b>Pass Ball</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Ball</em>' attribute.
	 * @see #setPassBall(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getCatcherStatistic_PassBall()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='PASS-BALLS'"
	 * @generated
	 */
	int getPassBall();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getPassBall <em>Pass Ball</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Ball</em>' attribute.
	 * @see #getPassBall()
	 * @generated
	 */
	void setPassBall(int value);

	/**
	 * Returns the value of the '<em><b>Stolen Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stolen Base</em>' attribute.
	 * @see #setStolenBase(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getCatcherStatistic_StolenBase()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='STOLEN-BASES'"
	 * @generated
	 */
	int getStolenBase();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getStolenBase <em>Stolen Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stolen Base</em>' attribute.
	 * @see #getStolenBase()
	 * @generated
	 */
	void setStolenBase(int value);

	/**
	 * Returns the value of the '<em><b>Caught Stealing</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Stealing</em>' attribute.
	 * @see #setCaughtStealing(int)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getCatcherStatistic_CaughtStealing()
	 * @model default="-1" required="true"
	 *        extendedMetaData="kind='element' name='CAUGHT-STEALING'"
	 * @generated
	 */
	int getCaughtStealing();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.CatcherStatistic#getCaughtStealing <em>Caught Stealing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caught Stealing</em>' attribute.
	 * @see #getCaughtStealing()
	 * @generated
	 */
	void setCaughtStealing(int value);

} // CatcherStatistic
