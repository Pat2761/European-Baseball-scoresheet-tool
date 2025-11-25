/**
 */
package org.bpy.score.reports.gamereports;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getBannerPath <em>Banner Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getVisitorSheetPath <em>Visitor Sheet Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getVisitorStats <em>Visitor Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getHometeamStats <em>Hometeam Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getUmpires <em>Umpires</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getScorekeepers <em>Scorekeepers</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getDate <em>Date</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getStartingTime <em>Starting Time</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getTown <em>Town</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getStadium <em>Stadium</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getHometeamSheetPath <em>Hometeam Sheet Path</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getGameNumber <em>Game Number</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getPlayByPlay <em>Play By Play</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getPdfFile <em>Pdf File</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getGeneralStats <em>General Stats</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getVisitorLineup <em>Visitor Lineup</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getHometeamLineup <em>Hometeam Lineup</em>}</li>
 *   <li>{@link org.bpy.score.reports.gamereports.GameReport#getMixed <em>Mixed</em>}</li>
 * </ul>
 *
 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport()
 * @model extendedMetaData="kind='elementOnly' name='GAME-REPORT'"
 * @generated
 */
public interface GameReport extends EObject {
	/**
	 * Returns the value of the '<em><b>Banner Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Banner Path</em>' attribute list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_BannerPath()
	 * @model extendedMetaData="kind='element' name='BANNER-PATH'"
	 * @generated
	 */
	EList<String> getBannerPath();

	/**
	 * Returns the value of the '<em><b>Visitor Sheet Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Sheet Path</em>' attribute.
	 * @see #setVisitorSheetPath(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_VisitorSheetPath()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='VISITOR-SHEET-PATH'"
	 * @generated
	 */
	String getVisitorSheetPath();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorSheetPath <em>Visitor Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Sheet Path</em>' attribute.
	 * @see #getVisitorSheetPath()
	 * @generated
	 */
	void setVisitorSheetPath(String value);

	/**
	 * Returns the value of the '<em><b>Visitor Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Stats</em>' containment reference.
	 * @see #setVisitorStats(TeamStatisitics)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_VisitorStats()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='VISITOR-STATS'"
	 * @generated
	 */
	TeamStatisitics getVisitorStats();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorStats <em>Visitor Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Stats</em>' containment reference.
	 * @see #getVisitorStats()
	 * @generated
	 */
	void setVisitorStats(TeamStatisitics value);

	/**
	 * Returns the value of the '<em><b>Hometeam Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Stats</em>' containment reference.
	 * @see #setHometeamStats(TeamStatisitics)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_HometeamStats()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-STATS'"
	 * @generated
	 */
	TeamStatisitics getHometeamStats();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamStats <em>Hometeam Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Stats</em>' containment reference.
	 * @see #getHometeamStats()
	 * @generated
	 */
	void setHometeamStats(TeamStatisitics value);

	/**
	 * Returns the value of the '<em><b>Umpires</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Umpires</em>' attribute list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Umpires()
	 * @model extendedMetaData="kind='element' name='UMPIRE'"
	 * @generated
	 */
	EList<String> getUmpires();

	/**
	 * Returns the value of the '<em><b>Scorekeepers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scorekeepers</em>' attribute list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Scorekeepers()
	 * @model extendedMetaData="kind='element' name='SCOREKEEPER'"
	 * @generated
	 */
	EList<String> getScorekeepers();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Date()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='DATE'"
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Starting Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting Time</em>' attribute.
	 * @see #setStartingTime(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_StartingTime()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='START-TIME'"
	 * @generated
	 */
	String getStartingTime();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getStartingTime <em>Starting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting Time</em>' attribute.
	 * @see #getStartingTime()
	 * @generated
	 */
	void setStartingTime(String value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Duration()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='DURATION'"
	 * @generated
	 */
	String getDuration();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(String value);

	/**
	 * Returns the value of the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Town</em>' attribute.
	 * @see #setTown(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Town()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='CITY'"
	 * @generated
	 */
	String getTown();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getTown <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Town</em>' attribute.
	 * @see #getTown()
	 * @generated
	 */
	void setTown(String value);

	/**
	 * Returns the value of the '<em><b>Stadium</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stadium</em>' attribute.
	 * @see #setStadium(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Stadium()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='STADIUM'"
	 * @generated
	 */
	String getStadium();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getStadium <em>Stadium</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stadium</em>' attribute.
	 * @see #getStadium()
	 * @generated
	 */
	void setStadium(String value);

	/**
	 * Returns the value of the '<em><b>Hometeam Sheet Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Sheet Path</em>' attribute.
	 * @see #setHometeamSheetPath(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_HometeamSheetPath()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='HOMETEAM-SHEET-PATH'"
	 * @generated
	 */
	String getHometeamSheetPath();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamSheetPath <em>Hometeam Sheet Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Sheet Path</em>' attribute.
	 * @see #getHometeamSheetPath()
	 * @generated
	 */
	void setHometeamSheetPath(String value);

	/**
	 * Returns the value of the '<em><b>Game Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Game Number</em>' attribute.
	 * @see #setGameNumber(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_GameNumber()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='GAME-NUMBER'"
	 * @generated
	 */
	String getGameNumber();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getGameNumber <em>Game Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game Number</em>' attribute.
	 * @see #getGameNumber()
	 * @generated
	 */
	void setGameNumber(String value);

	/**
	 * Returns the value of the '<em><b>Play By Play</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play By Play</em>' containment reference.
	 * @see #setPlayByPlay(PlayByPlay)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_PlayByPlay()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='PLAY-BY-PLAY'"
	 * @generated
	 */
	PlayByPlay getPlayByPlay();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getPlayByPlay <em>Play By Play</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play By Play</em>' containment reference.
	 * @see #getPlayByPlay()
	 * @generated
	 */
	void setPlayByPlay(PlayByPlay value);

	/**
	 * Returns the value of the '<em><b>Pdf File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pdf File</em>' attribute.
	 * @see #setPdfFile(String)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_PdfFile()
	 * @model extendedMetaData="kind='element' name='PDF-FILE'"
	 * @generated
	 */
	String getPdfFile();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getPdfFile <em>Pdf File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pdf File</em>' attribute.
	 * @see #getPdfFile()
	 * @generated
	 */
	void setPdfFile(String value);

	/**
	 * Returns the value of the '<em><b>General Stats</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Stats</em>' containment reference.
	 * @see #setGeneralStats(GameGeneralStats)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_GeneralStats()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='GAME-GENERAL-STATS'"
	 * @generated
	 */
	GameGeneralStats getGeneralStats();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getGeneralStats <em>General Stats</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Stats</em>' containment reference.
	 * @see #getGeneralStats()
	 * @generated
	 */
	void setGeneralStats(GameGeneralStats value);

	/**
	 * Returns the value of the '<em><b>Visitor Lineup</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visitor Lineup</em>' containment reference.
	 * @see #setVisitorLineup(StartingLineup)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_VisitorLineup()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='STARTING-VISITOR-LINEUP'"
	 * @generated
	 */
	StartingLineup getVisitorLineup();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getVisitorLineup <em>Visitor Lineup</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visitor Lineup</em>' containment reference.
	 * @see #getVisitorLineup()
	 * @generated
	 */
	void setVisitorLineup(StartingLineup value);

	/**
	 * Returns the value of the '<em><b>Hometeam Lineup</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hometeam Lineup</em>' containment reference.
	 * @see #setHometeamLineup(StartingLineup)
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_HometeamLineup()
	 * @model containment="true" derived="true"
	 *        extendedMetaData="kind='element' name='STARTING-HOMETEAM-LINEUP'"
	 * @generated
	 */
	StartingLineup getHometeamLineup();

	/**
	 * Sets the value of the '{@link org.bpy.score.reports.gamereports.GameReport#getHometeamLineup <em>Hometeam Lineup</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hometeam Lineup</em>' containment reference.
	 * @see #getHometeamLineup()
	 * @generated
	 */
	void setHometeamLineup(StartingLineup value);

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.bpy.score.reports.gamereports.GameReportsPackage#getGameReport_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false" transient="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

} // GameReport
