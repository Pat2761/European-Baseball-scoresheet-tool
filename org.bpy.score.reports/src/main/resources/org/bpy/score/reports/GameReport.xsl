<?xml version="1.0" encoding="UTF-8"?>

<!-- 
 European Scoring Tool For Baseball
 Copyright (C) 2020  Patrick BRIAND
  
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 -->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8"
		doctype-public="-//W3C//DTD HTML 4.01//EN" doctype-system="http://www.w3.org/TR/html4/strict.dtd"
		indent="yes">
	</xsl:output>
	
	<!-- 
		Entry point of the game description
	 -->
	<xsl:template match="/">
		<html>
			<head>
  				<link rel="stylesheet" type="text/css" href="GameReport.css"/>
			</head>
			<body>
			
				<!-- Insertion de la banière -->
				<xsl:call-template name="displayBannerEntryPoint"></xsl:call-template>

				<!-- description du match -->
				<xsl:call-template name="setGameDescriptionEntryPoint"></xsl:call-template>

				<!-- Resultat du match -->
				<xsl:call-template name="displayGeneralResultEntryPoint"></xsl:call-template>

				<!-- Resultat du match -->
				<xsl:call-template name="displayPlayerStatisiticsEntryPoint"></xsl:call-template>

				<!-- Lineup partant -->
				<xsl:call-template name="displayStartingLineupEntryPoint"></xsl:call-template>

				<!-- Images des feuilles de scorage -->
				<xsl:call-template name="displayScoreSheetEntryPoint"></xsl:call-template>
				
				<!-- play by play -->
				<xsl:call-template name="displayPlayByPlayEntryPoint"></xsl:call-template>

				<!-- closure sheet -->
				<xsl:call-template name="closureSheetEntryPoint"></xsl:call-template>
				
			</body>
		</html>	
	</xsl:template>

	<!--
		Display player statitistics
	 -->	
	<xsl:template name="displayPlayerStatisiticsEntryPoint">
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		
		<xsl:call-template name="displayTeamPlayerStatisiticsEntryPoint">
			<xsl:with-param name="teamStats" select="GAME-REPORT/VISITOR-STATS"/>
		</xsl:call-template>
		<br/>
		<xsl:call-template name="displayTeamPlayerStatisiticsEntryPoint">
			<xsl:with-param name="teamStats" select="GAME-REPORT/HOMETEAM-STATS"/>
		</xsl:call-template>
		<br/>
		<xsl:call-template name="displayPitcherStatisiticsEntryPoint">
			<xsl:with-param name="teamStats" select="GAME-REPORT/VISITOR-STATS"/>
		</xsl:call-template>
		<br/>
		<xsl:call-template name="displayPitcherStatisiticsEntryPoint">
			<xsl:with-param name="teamStats" select="GAME-REPORT/HOMETEAM-STATS"/>
		</xsl:call-template>
		<br/>
		
	</xsl:template>

	<!--
		Display pitcher statitistics
	 -->	
	<xsl:template name="displayPitcherStatisiticsEntryPoint">
		<xsl:param name="teamStats"/>
		<table align="center" class="PlayerStats">
			<tr >
				<th class="PlayerStats_Town"><xsl:value-of select="$teamStats/TOWN-NAME"/></th>
				<th class="PlayerStats_Offensive">ip</th>
				<th class="PlayerStats_Offensive">h</th>
				<th class="PlayerStats_Offensive">r</th>
				<th class="PlayerStats_Offensive">er</th>
				<th class="PlayerStats_Offensive">bb</th>
				<th class="PlayerStats_Offensive">so</th>
				<th class="PlayerStats_Offensive">wp</th>
				<th class="PlayerStats_Offensive">bk</th>
				<th class="PlayerStats_Offensive">hbp</th>
				<th class="PlayerStats_Offensive">ibb</th>
				<th class="PlayerStats_Offensive">ab</th>
				<th class="PlayerStats_Offensive">bf</th>
				<th class="PlayerStats_Offensive">fo</th>
				<th class="PlayerStats_Offensive">go</th>
			</tr>
			
			<xsl:call-template name="showPitcherStatistics">
				<xsl:with-param name="teamStats" select="$teamStats"/>
				<xsl:with-param name="position" select="1"/>
			</xsl:call-template>
	
			<xsl:for-each select="$teamStats/PLAYER">
				<xsl:if test="current()/PITCHER-STATISTICS">
				</xsl:if>
			</xsl:for-each>
			
		</table>	
	</xsl:template>
	
	<xsl:template name="showPitcherStatistics">
		<xsl:param name="teamStats"/>
		<xsl:param name="position"/>
		<xsl:call-template name="FillPitcherStatsTable">
  			<xsl:with-param name="pitcherStat" select="$teamStats/PLAYER/PITCHER-STATISTICS/PITCHER-ORDER[text()=$position]" />
		</xsl:call-template>

		<xsl:if test="$teamStats/PLAYER/PITCHER-STATISTICS/PITCHER-ORDER[text()=$position+1]">
			<xsl:call-template name="showPitcherStatistics">
				<xsl:with-param name="teamStats" select="$teamStats" />
				<xsl:with-param name="position" select="$position+1" />
			</xsl:call-template>
		</xsl:if>

	</xsl:template>

	<xsl:template name="FillPitcherStatsTable">
		<xsl:param name="pitcherStat"/>
		<tr>
			<td class="PlayerStats_Town"><xsl:value-of select="$pitcherStat/../../NAME"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../IPS"/></td>
  			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../HITS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../RUNS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../EARNED-RUNS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../BASE-ON-BALLS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../STRIKE-OUTS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../WILD-PITCHES"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../BALKS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../HIT-BY-PITCHS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../INTENTIONAL-BASE-ON-BALLS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../AT-BATS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../BATTER-FRONTS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../FLY-OUTS"/></td>
			<td class="PlayerStats_Offensive"><xsl:value-of select="$pitcherStat/../GROUNDED-OUTS"/></td>
		</tr>
	</xsl:template>

	<!--
		Display player statitistics
	 -->	
	<xsl:template name="displayTeamPlayerStatisiticsEntryPoint">
		<xsl:param name="teamStats"/>
		
		<table align="center" class="PlayerStats">
			<tr >
				<th class="PlayerStats_Town"><xsl:value-of select="$teamStats/TOWN-NAME"/></th>
				<th class="PlayerStats_Offensive">PA</th>
				<th class="PlayerStats_Offensive">AB</th>
				<th class="PlayerStats_Offensive">R</th>
				<th class="PlayerStats_Offensive">H</th>
				<th class="PlayerStats_Offensive">RBI</th>
				<th class="PlayerStats_Offensive">2B</th>
				<th class="PlayerStats_Offensive">3B</th>
				<th class="PlayerStats_Offensive">HR</th>
				<th class="PlayerStats_Offensive">BB</th>
				<th class="PlayerStats_Offensive">SB</th>
				<th class="PlayerStats_Offensive">CS</th>
				<th class="PlayerStats_Offensive">HP</th>
				<th class="PlayerStats_Offensive">SH</th>
				<th class="PlayerStats_Offensive">SF</th>
				<th class="PlayerStats_Offensive">SO</th>
				<th class="PlayerStats_Offensive">IBB</th>
				<th class="PlayerStats_Offensive">KL</th>
				<th class="PlayerStats_Offensive">GDP</th>
				<th class="PlayerStats_Defensive">PO</th>
				<th class="PlayerStats_Defensive">A</th>
				<th class="PlayerStats_Defensive">E</th>
			</tr>
			
			<xsl:for-each select="$teamStats/PLAYER">
				<tr>
					<td class="PlayerStats_Town"><xsl:value-of select="current()/NAME"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/PLATE-APPEARANCES"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/AT-BATS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/RUNS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/HITS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/RBIS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/DOUBLES"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/TRIPLES"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/HOMERUNS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/BASE-ON-BALLS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/STOLEN-BASES"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/CAUGHT-STEALING"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/HIT-BY-PITCHS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/SACRIFICES-HITS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/SACRIFICE-FLIES"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/STRIKE-OUTS"/></td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/INTENTIONAL-BASE-ON-BALLS"/></td>
					<td class="PlayerStats_Offensive">?</td>
					<td class="PlayerStats_Offensive"><xsl:value-of select="current()/OFFENSIVE-STATISTICS/GROUND-OUT-DOUBLE-PLAY"/></td>
					<td class="PlayerStats_Defensive"><xsl:value-of select="current()/DEFENSIVES-STATISTICS/PUT-OUTS"/></td>
					<td class="PlayerStats_Defensive"><xsl:value-of select="current()/DEFENSIVES-STATISTICS/ASSISTANCES"/></td>
					<td class="PlayerStats_Defensive"><xsl:value-of select="current()/DEFENSIVES-STATISTICS/ERRORS"/></td>
				</tr>
			</xsl:for-each>
			
		</table>
		
	</xsl:template>

	<!--
		closureSheet entry point
	 -->	
	<xsl:template name="closureSheetEntryPoint">
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		<h3 align="center">
			<xsl:element name="a">
				<xsl:attribute name="href"><xsl:value-of select="GAME-REPORT/PDF-FILE"/></xsl:attribute>
				lien de telechargement
			</xsl:element>
		</h3>
		<hr align="center" width="75%" color="midnightblue" size="3"/>
	</xsl:template>

	<!--
		play by play entry point
	 -->	
	<xsl:template name="displayPlayByPlayEntryPoint">
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		<xsl:call-template name="PlayByPlay">
			<xsl:with-param name="playByPlayEntry" select="GAME-REPORT/PLAY-BY-PLAY" />
		</xsl:call-template>
	</xsl:template>

	<!--
		scoresheet entry point
	 -->	
	<xsl:template name="displayScoreSheetEntryPoint">
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		<h1 align="center">Feuille de scorage de l'équipe visiteur</h1>
		<p align="center">
			<xsl:element name="img">
			<xsl:attribute name="class">scoringSheet</xsl:attribute>
			<xsl:attribute name="src"><xsl:value-of select="GAME-REPORT/VISITOR-SHEET-PATH"/></xsl:attribute>
			</xsl:element>
		</p>
		<h1 align="center">Feuille de scorage de l'équipe recevante</h1>
		<p align="center">
			<xsl:element name="img">
			<xsl:attribute name="class">scoringSheet</xsl:attribute>
			<xsl:attribute name="src"><xsl:value-of select="GAME-REPORT/HOMETEAM-SHEET-PATH"/></xsl:attribute>
			</xsl:element>
		</p>
	</xsl:template>

	<!--
		lineup description entry point
	 -->	
	<xsl:template name="displayStartingLineupEntryPoint">
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		<xsl:call-template name="displayStartingLineup">
			<xsl:with-param name="forTeam" select="GAME-REPORT/STARTING-VISITOR-LINEUP" />
			<xsl:with-param name="headerValue" select='"Lineup Partant : Equipe visiteur"' />
		</xsl:call-template>
		<xsl:call-template name="displayStartingLineup">
			<xsl:with-param name="forTeam" select="GAME-REPORT/STARTING-HOMETEAM-LINEUP" />
			<xsl:with-param name="headerValue" select='"Lineup Partant : Equipe recevante"' />
		</xsl:call-template>
	</xsl:template>

	<!--
		Display general result of the game entry point
	 -->	
	<xsl:template name="displayGeneralResultEntryPoint">
		<!-- Display general information about the result of the game -->
		<hr align="center" width="75%" color="midnightblue" size="3"/>
		<xsl:call-template name="displayGeneralResult">
			<xsl:with-param name="visitorName" select="GAME-REPORT/VISITOR-STATS/TOWN-NAME" />
			<xsl:with-param name="hometeamName" select="GAME-REPORT/HOMETEAM-STATS/TOWN-NAME" />
			<xsl:with-param name="generalResult" select="GAME-REPORT/GAME-GENERAL-STATS" />
		</xsl:call-template>
	</xsl:template>

	<!--
		Display general result of the game
	 -->	
	<xsl:template name="displayGeneralResult">
		<xsl:param name="visitorName"/>
		<xsl:param name="hometeamName"/>
		<xsl:param name="generalResult"/>
		<xsl:variable name="countInning" select="1" />
		
		<h1 align="center">Résultat général</h1>
		
		<p>
			<table align="center" class="GeneralResult">
			
				<tr>
					<td class="GeneralResult_inningRun"></td>
					<xsl:for-each select="$generalResult/POINTS-PER-INNING">
						<td class="GeneralResult_inningRun"><xsl:value-of select="current()/ORDER + 1"/></td>
					</xsl:for-each>
					<td class="GeneralResult_General">Points</td>
					<td class="GeneralResult_General">Hits</td>
					<td class="GeneralResult_General">Erreurs</td>
				</tr>

				<!-- Visitor row -->
				<tr>
					<td class="GeneralResult_General"><xsl:value-of select="$visitorName"/></td>
					<xsl:for-each select="$generalResult/POINTS-PER-INNING">
						<td class="GeneralResult_inningRun"><xsl:value-of select="current()/VISITOR-POINTS"/></td>
					</xsl:for-each>
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/VISITOR-RUNS"/></td>
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/VISITOR-HITS"/></td>
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/VISITOR-ERRORS"/></td>
				</tr>

				<!-- Hometeam row -->
				<tr>
					<td class="GeneralResult_General"><xsl:value-of select="$hometeamName"/></td>
 					<xsl:for-each select="$generalResult/POINTS-PER-INNING">
  						<xsl:choose>
							<xsl:when test="current()/HOMETEAM-POINTS">
								<td class="GeneralResult_inningRun"><xsl:value-of select="current()/HOMETEAM-POINTS"/></td>
							</xsl:when>
							<xsl:otherwise>
 								<td class="GeneralResult_inningRun">X</td>
 							</xsl:otherwise>
						</xsl:choose> 
					</xsl:for-each> 
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/HOMETEAM-RUNS"/></td>
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/HOMETEAM-HITS"/></td>
					<td class="GeneralResult_General"><xsl:value-of select="$generalResult/HOMETEAM-ERRORS"/></td>
				</tr>
			</table>
		</p>
	</xsl:template>
	
	<!--
		Display the play by play  
	 -->	
	<xsl:template name="PlayByPlay">
		<xsl:param name="playByPlayEntry"/>
		<h1 align="center">
			Play by play 
		</h1>
	
		<p>
			<xsl:for-each select="$playByPlayEntry//ACTION-DESCRIPTION">
				<table class="PlayByPlay">
					<tr><td class="PlayByPlay_Header"><xsl:value-of select="current()/HEADER"/></td></tr>
					<xsl:choose>
						<xsl:when test="current()/TEAM='VISITOR'">
							<tr><td class="PlayByPlay_Corps_visitor"><xsl:value-of select="current()/CONTENT"/></td></tr>
						</xsl:when>
						<xsl:otherwise>
							<tr><td class="PlayByPlay_Corps_hometeam"><xsl:value-of select="current()/CONTENT"/></td></tr>
						</xsl:otherwise>
					</xsl:choose>	
					<tr><td class="PlayByPlay_Resume"><xsl:value-of select="current()/RESUME"/></td></tr>
				</table>
				<br></br>
			</xsl:for-each>
		</p>
	</xsl:template>

	<!--
		Display a table which contains the description of the starting line up 
	 -->	
	<xsl:template name="displayStartingLineup">
		<xsl:param name="forTeam"/>
		<xsl:param name="headerValue"/>
		<xsl:variable name="countBatter" select="1" />
		
		<p align="center">
			<h1 align="center"><xsl:value-of select="$headerValue"/></h1>
			<table class="lineup"> 
				<tr> <th class="lineupFrappeur">Ordre au baton</th><th class="lineupFrappeur"></th></tr>
				<tr>
					<td>
						<table>
							<xsl:for-each select="$forTeam//LINEUP-PLAYER">
								<xsl:if test="current()/OFFENSIVE-POSITION &lt;= 10">
									<tr><td align="left" class="lineupFrappeur"><p>Frappeur <xsl:value-of select="current()/OFFENSIVE-POSITION"/> : <xsl:value-of select="current()/NAME"/></p></td></tr>
								</xsl:if>	
							</xsl:for-each>
						</table>
					</td>
					<td>
						<p>
							<xsl:element name="img">  
								<xsl:attribute name="class">startlingLineUpImage</xsl:attribute>
								<xsl:attribute name="src"><xsl:value-of select="$forTeam/FIELD-PICTURE-LINK"/></xsl:attribute>
							</xsl:element>
						</p>
					</td>
				</tr>
			</table>
		</p>
	</xsl:template>

	<!--
		Display the game description
	 -->	
	<xsl:template name="setGameDescriptionEntryPoint">
		<!-- Titre de la rencontre -->
		<h1 align="center">
			Rencontre 
			<xsl:value-of select="GAME-REPORT/VISITOR-STATS/TOWN-NAME"></xsl:value-of>
			(<xsl:value-of select="GAME-REPORT/VISITOR-STATS/TEAM-NAME"></xsl:value-of>
			) vs <xsl:value-of select="GAME-REPORT/HOMETEAM-STATS/TOWN-NAME"></xsl:value-of>
			(<xsl:value-of select="GAME-REPORT/HOMETEAM-STATS/TEAM-NAME"></xsl:value-of>)
		</h1>
		
		<!-- Lieu de la rencontre -->
		<h2 align="center"> en date du <xsl:value-of select="GAME-REPORT/DATE"></xsl:value-of> à 
		<xsl:value-of select="GAME-REPORT/CITY"></xsl:value-of>
		( Stade <xsl:value-of select="GAME-REPORT/STADIUM"></xsl:value-of>)
		</h2>
		
		<!-- heure de début et la durée du match -->
		<h2 align="center">
			Heure de début de la rencontre  <xsl:value-of select="GAME-REPORT/START-TIME"></xsl:value-of>
			durée : <xsl:value-of select="GAME-REPORT/DURATION"></xsl:value-of> 
		</h2>
		
		<!-- Officiels -->
		<h2 align="center">
			Arbitres : 
			<xsl:for-each select="GAME-REPORT/UMPIRE">
				<xsl:value-of select="current()"/>
				<xsl:if test="position() != last()">, </xsl:if>
			</xsl:for-each>
		</h2>
		<h2 align="center">
			Scoreurs : 
			<xsl:for-each select="GAME-REPORT/SCOREKEEPER">
				<xsl:value-of select="current()"/>
				<xsl:if test="position() != last()">, </xsl:if>
			</xsl:for-each>
		</h2>
		
	</xsl:template>

	<!--
		Display the header banner
	 -->	
	<xsl:template name="displayBannerEntryPoint">
		<p align="center"><img src="banner.jpg"/></p>
	</xsl:template>


</xsl:stylesheet>