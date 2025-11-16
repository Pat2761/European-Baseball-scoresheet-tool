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
package org.bpy.score.engine.stats;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.GameStatistic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.TeamStatistic;
import org.bpy.score.engine.stats.stats.GeneralStatContainer;
import org.bpy.score.engine.stats.stats.MapValueComparator;

/**
 * 
 * Find on http://www.argancy-baseball.com/lexique-statistiques/ <br>
 *<br>
 *<b><u>STATS AU BÂTON</u></b><br>
 *<br>
 *<ul><li><b>STATS STANDARDS</b></li>
 *<ul><li><b>G</b> (Games) : nombre de matchs joués</li>
 *<li><b>GS</b> (Games Started) : nombre de matchs débutés comme titulaire</li>
 *<li><b>PA</b> (Plate Appearance) : nombre de présences au bâton</li>
 *<li><b>AB</b> (At-Bats) : nombre de présences OFFICIELLES au bâton = PA – BB – HBP – SH – SF</li>
 *<li><b>R</b> (Runs) : nombre de points marqués</li>
 *<li><b>RBI</b> (Runs Batted In) : nombre de points produits (un frappeur fait marquer un coureur sur base)</li>
 *<li><b>H</b> (Hits) : nombre de coups sûrs (frappe qui permet à un batteur d’arriver sur base sans erreur de la défense) = 1B+2B+3B+HR. On distingue les coups sûrs d’une base (1B – simple), de deux bases (2B – doubles), trois bases (3B – triples), quatre bases (HR – home-runs)</li>
 *<li><b>TB</b> (Total Bases) : nombre total de bases = 1B + 2*2B + 3*3B + 4*HR</li>
 *<li><b>BB</b> (Base On Balls) : nombre de buts sur balles (quatre mauvais lancers du lanceur ce qui permet au batteur d’atteindre la première base « gratuitement »)</li>
 *<li><b>SO</b> (Strike-Out, noté aussi K) : nombre de retraits sur prises</li>
 *<li><b>HBP</b> (Hit By Pitch) : nombre de fois qu’un batteur s’est fait atteindre par un lancer (ce qui permet au frappeur d’atteindre la première base « gratuitement »)</li>
 *<li><b>SH</b> (Sacrifice Hit) : frappe de type « amorti ». Le frappeur se fait généralement éliminer mais son amorti permet aux coureurs de progresser d’une base</li>
 *<li><b>SF</b> (Sacrifice Fly) : chandelle sacrifice. Une balle frappée en champ extérieur, captée de volée par la défense (donc le frappeur est éliminé) mais qui permet à un coureur en troisième base de marquer un point</li>
 *</ul>
 *<br>
 *<li><b>MOYENNES</b></li>
 *<ul><li><b>AVG</b> (Average) : moyenne au bâton = H / AB. Par exemple Vincent Choné a frappé 10 coups sûrs en 24 présences officielles au bâton, soit une moyenne de 417 (on exprime la statistique sur 1000).</li>
 *<li><b>OBP</b> (On-Base Percentage) : moyenne de présence sur les bases. La même chose que la moyenne au bâton, en ajoutant les buts sur balles (BB) et atteints par un lancer (HBP) = (H + BB + HBP) / (AB + BB + HBP + SF)</li>
 *<li><b>SLG</b> (Slugging Average) : moyenne de puissance, permet de mesurer la puissance d’un frappeur = TB / AB</li>
 *<li><b>BABIP</b> (Batting average on balls in play) : moyenne au bâton lorsque la balle est mise en jeu (excepté les homeruns) = (H – HR) / (AB – SO – HR + SF)</li>
 *</ul>
 *<br>
 *<li><b>STATS SUR BASE</b></li>
 *<ul><li><b>SB%</b> : moyenne de bases volées = SB / (SB+CS)</li>
 *<li><b>SB</b> (Stolen Base) : nombre de bases volées par un coureur (progression d’une base sans l’aide d’une frappe d’un coéquipier)</li>
 *<li><b>CS</b> (Caught Stealing) : nombre de fois qu’un coureur s’est fait retirer en tentant de voler une base</li>
 *</ul>
 *<br>
 *<li><b>RATIOS</b></li>
 *<ul><li><b>SO%</b> : pourcentage de passages au bâton qui se terminent en retraits sur prises = (SO / PA) * 100</li>
 *<li><b>BB%</b> : pourcentage de passages au bâton qui se terminent en buts sur balles = (BB / PA) * 100</li>
 *<li><b>XBH%</b> : pourcentage de passages au bâton qui se terminent en coups sûrs de plus d’une base (double, triple ou home-run) = ((2B + 3B + HR ) / PA) * 100</li>
 *<li><b>X/H%</b> : pourcentage de coups sûrs de plus d’une base (double, triple ou home-run) = ((2B + 3B + HR) / H) * 100</li>
 *<li><b>SO/BB</b> : ratio retraits sur prises / but sur balles</li>
 *<li><b>AB/SO</b> : par exemple un chiffre de 8.3 signifie qu’un frappeur se fait retirer sur prises tous les 8.3 passages au bâton</li>
 *<li><b>AB/RBI</b> : même chose avec les points produits</li>
 *<li><b>IP%</b> : pourcentage de passages au bâton qui se terminent avec la balle mise en jeu = ((AB-SO-HR+SF) / PA) * 100</li>
 *</ul>
 *<br>
 *</ul>
 *<b><u>STATS AU LANCER<br></u></b><br>
 *<br>
 *<ul><li><b>STATS STANDARDS</b></li>
 *<br>
 *<ul><li><b>G</b> (Games) : nombre de matchs joués</li>
 *<li><b>GS</b> (Games Started) : nombre de matchs joués comme lanceur partant</li>
 *<li><b>W</b> (Wins) : nombre de victoires</li>
 *<li><b>L</b> (Losses) : nombre de défaites</li>
 *<li><b>ERA</b> (Earned Runs Average) : moyenne de points mérités = 9 * ER / IP</li>
 *<li><b>ERA7</b> (Earned Runs Average) : cette même moyenne ramenée sur 7 manches (format des matchs en Nationale 1 et Régionale 2) = 7 * ER / IP</li>
 *<li><b>IP</b> (Innings Pitched) : nombre de manches lancés</li>
 *<li><b>H</b> (Hits) : nombre de coups sûrs concédés</li>
 *<li><b>R</b> (Runs) : nombre de points concédés</li>
 *<li><b>ER</b> (Earned Runs) : nombre de points mérités concédés</li>
 *<li><b>BB</b> (Bases On Balls) : nombre de buts sur balles concédés</li>
 *<li><b>SO</b> (Strike-Out) : nombre de retraits sur prises</li>
 *<li><b>HBP</b> (Hit By Pitch) : nombre de fois qu’un lanceur a atteint un frappeur par son lancer</li>
 *<li><b>WP</b> (Wild Pitch) : lancer fou que le receveur n’est pas capable d’attraper et qui permet aux coureurs de progresser sur bases</li>
 *<li><b>BF</b> (Batters Faced) : nombre de batteurs affrontés</li>
 *</ul>
 *<br>
 *<li><b>RATIOS</b></li>
 *<ul><li><b>WHIP</b> (Walks + Hits Per IP) : nombre de buts sur balles et de coups sûrs moyens concédés par manche = (BB + H) / IP</li>
 *<li><b>H/7</b> : nombre de coups sûrs moyen par match (7 manches)</li>
 *<li><b>BB/7</b> : nombre de buts sur balles moyen par match (7 manches)</li>
 *<li><b>SO/7</b> : nombre de retraits sur prises moyen par match (7 manches)</li>
 *</ul>
 *<br>
 *</ul>
 *<b><u>STATS EN DEFENSE</u></b><br>
 *<br>
 *<ul><li><b>STATS STANDARDS</b></li>
 *<li><b>G</b> (Games)          : nombre de matchs joués</li>
 *<li><b>GS</b> (Games Started) : nombre de matchs joués comme titulaire</li>
 *<li><b>Inn</b> (Innings)      : nombre de manches jouées en défense</li>
 *<li><b>PO</b> (Putout)        : nombre de retraits effectués</li>
 *<li><b>A</b> (Assist)         : nombre d’assistance (le fait de participer à un retrait en relançant la balle notamment)</li>
 *<li><b>E</b> (Errors)         : nombre d’erreurs commises</li>
 *<li><b>Ch</b> (Chances)       : nombre d’opportunités totales d’effectuer un retrait = PO + A + E</li>
 *</ul>
 *<br>
 *</ul>
 *
 * @author Patrick BRIAND
 *
 */

public class GlobalStatisticGenerator {

  /** Key used for G offensive statistic value*/	
  public static final String OFFENSIVE_G = "OFFENSIVE_G"; //$NON-NLS-1$
  /** Key used for GS offensive statistic value*/	
  public static final String OFFENSIVE_GS = "OFFENSIVE_GS"; //$NON-NLS-1$
  /** Key used for PA offensive statistic value*/	
  public static final String OFFENSIVE_PA = "OFFENSIVE_PA"; //$NON-NLS-1$
  /** Key used for AB offensive statistic value*/	
  public static final String OFFENSIVE_AB = "OFFENSIVE_AB"; //$NON-NLS-1$
  /** Key used for R offensive statistic value*/	
  public static final String OFFENSIVE_R = "OFFENSIVE_R"; //$NON-NLS-1$
  /** Key used for RBI offensive statistic value*/	
  public static final String OFFENSIVE_RBI = "OFFENSIVE_RBI"; //$NON-NLS-1$
  /** Key used for H offensive statistic value*/	
  public static final String OFFENSIVE_H = "OFFENSIVE_H"; //$NON-NLS-1$
  /** Key used for TB offensive statistic value*/	
  public static final String OFFENSIVE_TB = "OFFENSIVE_TB"; //$NON-NLS-1$
  /** Key used for BB offensive statistic value*/	
  public static final String OFFENSIVE_BB = "OFFENSIVE_BB"; //$NON-NLS-1$
  /** Key used for SO offensive statistic value*/	
  public static final String OFFENSIVE_SO = "OFFENSIVE_SO"; //$NON-NLS-1$
  /** Key used for HPB offensive statistic value*/	
  public static final String OFFENSIVE_HBP = "OFFENSIVE_HPB"; //$NON-NLS-1$
  /** Key used for SH offensive statistic value*/	
  public static final String OFFENSIVE_SH = "OFFENSIVE_SH"; //$NON-NLS-1$
  /** Key used for SF offensive statistic value*/	
  public static final String OFFENSIVE_SF = "OFFENSIVE_SF"; //$NON-NLS-1$

  /** Key used for AVG offensive statistic value*/	
  public static final String OFFENSIVE_AVG="OFFENSIVE_AVG"; //$NON-NLS-1$
  /** Key used for OBP offensive statistic value*/	
  public static final String OFFENSIVE_OBP="OFFENSIVE_OBP"; //$NON-NLS-1$
  /** Key used for SLG offensive statistic value*/	
  public static final String OFFENSIVE_SLG="OFFENSIVE_SLG"; //$NON-NLS-1$
  /** Key used for BABIP offensive statistic value*/	
  public static final String OFFENSIVE_BABIP="OFFENSIVE_BABIP"; //$NON-NLS-1$

  /** Key used for SB% offensive statistic value*/	
  public static final String OFFENSIVE_SB_PERCENT="OFFENSIVE_SB%"; //$NON-NLS-1$
  /** Key used for SB offensive statistic value*/	
  public static final String OFFENSIVE_SB="OFFENSIVE_SB"; //$NON-NLS-1$
  /** Key used for CS offensive statistic value*/	
  public static final String OFFENSIVE_CS="OFFENSIVE_CS"; //$NON-NLS-1$

  /** Key used for SO% offensive statistic value*/	
  public static final String OFFENSIVE_SO_PERCENT="OFFENSIVE_SO%"; //$NON-NLS-1$
  /** Key used for BB% offensive statistic value*/	
  public static final String OFFENSIVE_BB_PERCENT="OFFENSIVE_BB%"; //$NON-NLS-1$
  /** Key used for XBH% offensive statistic value*/	
  public static final String OFFENSIVE_XBH_PERCENT="OFFENSIVE_XBH%"; //$NON-NLS-1$
  /** Key used for X/H% offensive statistic value*/	
  public static final String OFFENSIVE_X_H_PERCENT="OFFENSIVE_X/H%"; //$NON-NLS-1$
  /** Key used for SO/BB offensive statistic value*/	
  public static final String OFFENSIVE_SO_BB="OFFENSIVE_SO/BB"; //$NON-NLS-1$
  /** Key used for AB/SO offensive statistic value*/	
  public static final String OFFENSIVE_AB_SO="OFFENSIVE_AB/SO"; //$NON-NLS-1$
  /** Key used for AB/RBI offensive statistic value*/	
  public static final String OFFENSIVE_AB_RBI="OFFENSIVE_AB/RBI"; //$NON-NLS-1$
  /** Key used for IP% offensive statistic value*/	
  public static final String OFFENSIVE_IP_PERCENT="OFFENSIVE_IP%"; //$NON-NLS-1$

  /** Key used for G pitching statistic value*/	
  public static final String PTICHING_G="PTICHING_G"; //$NON-NLS-1$
  /** Key used for GS pitching statistic value*/	
  public static final String PTICHING_GS="PTICHING_GS"; //$NON-NLS-1$
  /** Key used for W pitching statistic value*/	
  public static final String PTICHING_W="PTICHING_W"; //$NON-NLS-1$
  /** Key used for L pitching statistic value*/	
  public static final String PTICHING_L="PTICHING_L"; //$NON-NLS-1$
  /** Key used for ERA pitching statistic value*/	
  public static final String PTICHING_ERA="PTICHING_ERA"; //$NON-NLS-1$
  /** Key used for ERA7 pitching statistic value*/	
  public static final String PTICHING_ERA7="PTICHING_ERA7"; //$NON-NLS-1$
  /** Key used for IP pitching statistic value*/	
  public static final String PTICHING_IP="PTICHING_IP"; //$NON-NLS-1$
  /** Key used for H pitching statistic value*/	
  public static final String PTICHING_H="PTICHING_H"; //$NON-NLS-1$
  /** Key used for R pitching statistic value*/	
  public static final String PTICHING_R="PTICHING_R"; //$NON-NLS-1$
  /** Key used for ER pitching statistic value*/	
  public static final String PTICHING_ER="PTICHING_ER"; //$NON-NLS-1$
  /** Key used for BB pitching statistic value*/	
  public static final String PTICHING_BB="PTICHING_BB"; //$NON-NLS-1$
  /** Key used for SO pitching statistic value*/	
  public static final String PTICHING_SO="PTICHING_SO"; //$NON-NLS-1$
  /** Key used for HBP pitching statistic value*/	
  public static final String PTICHING_HBP="PTICHING_HBP"; //$NON-NLS-1$
  /** Key used for WP pitching statistic value*/	
  public static final String PTICHING_WP="PTICHING_WP"; //$NON-NLS-1$
  /** Key used for BF pitching statistic value*/	
  public static final String PTICHING_BF="PTICHING_BF"; //$NON-NLS-1$

  /** Key used for WHIP pitching statistic value*/	
  public static final String PTICHING_WHIP="PTICHING_WHIP"; //$NON-NLS-1$
  /** Key used for H pitching statistic value*/	
  public static final String PTICHING_H_7="PTICHING_H"; //$NON-NLS-1$
  /** Key used for BB pitching statistic value*/	
  public static final String PTICHING_BB_7="PTICHING_BB"; //$NON-NLS-1$
  /** Key used for SO pitching statistic value*/	
  public static final String PTICHING_SO_7="PTICHING_SO"; //$NON-NLS-1$

  /** Key used for G defensive statistic value*/	
  public static final String DEFENSIVE_G="DEFENSIVE_G"; //$NON-NLS-1$
  /** Key used for GS defensive statistic value*/	
  public static final String DEFENSIVE_GS="DEFENSIVE_GS"; //$NON-NLS-1$
  /** Key used for INN defensive statistic value*/	
  public static final String DEFENSIVE_INN="DEFENSIVE_Inn"; //$NON-NLS-1$
  /** Key used for PO defensive statistic value*/	
  public static final String DEFENSIVE_PO="DEFENSIVE_PO"; //$NON-NLS-1$
  /** Key used for A defensive statistic value*/	
  public static final String DEFENSIVE_A="DEFENSIVE_A"; //$NON-NLS-1$
  /** Key used for E defensive statistic value*/	
  public static final String DEFENSIVE_E="DEFENSIVE_E"; //$NON-NLS-1$
  /** Key used for Ch defensive statistic value*/	
  public static final String DEFENSIVE_CH="DEFENSIVE_Ch"; //$NON-NLS-1$

  /** Allow to compare two values */
  protected static Comparator<Double> valueComparator = (s1,s2) ->   s2.compareTo(s1);

  /** Player statistics container */
  private HashMap<String, GeneralStatContainer> playerStatistics;
  /** Player general statistics */
  private HashMap<String, HashMap<String, Double>> playersGeneralStatistics;

  /**
   * Constructor of the class.
   * initialize some fields
   */
  public GlobalStatisticGenerator() {
    playerStatistics = new HashMap<>();
    playersGeneralStatistics = new HashMap<>();
  }

  /**
   * Compute statistics.
   * 
   * @param stats list of statistics manager computing from games files 
   */
  public void generateStatistics(List<StatisticManager> stats) {
	  
    for (StatisticManager gameStats : stats) {
      GameStatistic teamStats = gameStats.getStats();
      analyseTeamStats(gameStats.getStatisticContainer().getHomeTeamStatistic(teamStats));
      analyseTeamStats(gameStats.getStatisticContainer().getVisitorStatistic(teamStats));
    }

    for ( Entry<String, GeneralStatContainer> entry : playerStatistics.entrySet()) {
      GeneralStatContainer playerStats = entry.getValue();

      setGeneralStat(entry.getKey(), DEFENSIVE_A, playerStats.getDefensiveAssists());
      setGeneralStat(entry.getKey(), DEFENSIVE_E, playerStats.getDefensiveErrors());
      setGeneralStat(entry.getKey(), DEFENSIVE_PO, playerStats.getDefensivePutouts());

      setGeneralStat(entry.getKey(), OFFENSIVE_AB, playerStats.getOffensiveAtBats());
      setGeneralStat(entry.getKey(), OFFENSIVE_BB, playerStats.getOffensiveBaseOnBalls());
      setGeneralStat(entry.getKey(), OFFENSIVE_CS, playerStats.getOffensiveCaughtStealings());
      setGeneralStat(entry.getKey(), OFFENSIVE_H, playerStats.getOffensiveHits());
      setGeneralStat(entry.getKey(), OFFENSIVE_HBP, playerStats.getOffensiveHitByPitchs());
      setGeneralStat(entry.getKey(), OFFENSIVE_PA, playerStats.getOffensivesPAs());
      setGeneralStat(entry.getKey(), OFFENSIVE_R, playerStats.getOffensiveRuns());
      setGeneralStat(entry.getKey(), OFFENSIVE_RBI, playerStats.getOffensiveRbis());
      setGeneralStat(entry.getKey(), OFFENSIVE_SB, playerStats.getOffensiveStolenBases());
      setGeneralStat(entry.getKey(), OFFENSIVE_SF, playerStats.getOffensiveSacrificeFlies());
      setGeneralStat(entry.getKey(), OFFENSIVE_SH, playerStats.getOffensiveSacrificeHits());

      setGeneralStat(entry.getKey(), PTICHING_BB, playerStats.getPitcherBaseOnBalls());
      setGeneralStat(entry.getKey(), PTICHING_BF, playerStats.getPitcherBatterFronts());
      setGeneralStat(entry.getKey(), PTICHING_ER, playerStats.getPitcherEarnedRuns());
      setGeneralStat(entry.getKey(), PTICHING_H, playerStats.getPitcherHits());
      setGeneralStat(entry.getKey(), PTICHING_HBP, playerStats.getPitcherHitByPitchs());
      setGeneralStat(entry.getKey(), PTICHING_IP, playerStats.getPitcherIps());
      setGeneralStat(entry.getKey(), PTICHING_SO, playerStats.getPitcherStrikeOuts());
      setGeneralStat(entry.getKey(), PTICHING_WP, playerStats.getPitcherWildPitchs());
    }


    computeSLG();
    computeAVG();
    computeOBP();
  }

  /**
   * get statistics value
   * 
   * @param statsName statistic name 
   * 
   * @return map which contains all the statistics
   */
  public Map<String, Double> getGlobalStatistics(String statsName) {
    HashMap<String, Double> tmpTab = new HashMap<>();
    for (Entry<String, HashMap<String, Double>> entry : playersGeneralStatistics.entrySet()) {
      double value = 0.0;
      if (entry.getValue().containsKey(statsName)) {
        value = entry.getValue().get(statsName);
      }
      tmpTab.put(entry.getKey(), value);
    }

    MapValueComparator bvc = new MapValueComparator(tmpTab);
    TreeMap<String, Double> sortedMap = new TreeMap<>(bvc);
    sortedMap.putAll(tmpTab);

    return sortedMap;
  }

  /**
   * Compute the OBP statistic.
   * OBP= (H + BB + HBP) / (AB + BB + HBP + SF)
   */
  private void computeOBP() {
    for (Entry<String, GeneralStatContainer> entry : playerStatistics.entrySet()) {

      GeneralStatContainer stats = entry.getValue();
      /* OBP= (H + BB + HBP) / (AB + BB + HBP + SF) */
      int divide = stats.getOffensiveAtBats() + stats.getOffensiveBaseOnBalls() - stats.getOffensiveHitByPitchs() - stats.getOffensiveSacrificeFlies();
      int num = stats.getOffensiveHits() + stats.getOffensiveBaseOnBalls() - stats.getOffensiveHitByPitchs();
      double obp = (divide != 0) ?
          (double) (num) / (double) (divide):
            0.0;

      setGeneralStat(entry.getKey(), OFFENSIVE_OBP, obp);
    }
  }

  /**
   * Compute the AVG statistic.
   * AVG = H / AB
   * 
   */
  private void computeAVG() {
    for (Entry<String, GeneralStatContainer> entry : playerStatistics.entrySet()) {

      GeneralStatContainer stats = entry.getValue();
      double avg = (stats.getOffensiveAtBats()!= 0) ?
          (double) (stats.getOffensiveHits()) / (double) (stats.getOffensiveAtBats()):
            0.0;

      setGeneralStat(entry.getKey(), OFFENSIVE_AVG, avg);
    }
  }

  /**
   * Compute the SLG statistic.
   * 
   * SLG = (1B +(2*2B) + + (3*3B) + (4*HR))/AB
   */
  private void computeSLG() {
    for (Entry<String, GeneralStatContainer> entry : playerStatistics.entrySet()) {

      GeneralStatContainer stats = entry.getValue();
      int singles = stats.getOffensiveHits() - stats.getOffensiveDoubleHits() - stats.getOffensiveTripleHits() - stats.getOffensiveHomeruns();
      double slg = (stats.getOffensiveAtBats()!= 0) ?
          (double) (singles + (2 * stats.getOffensiveDoubleHits()) + (3 * stats.getOffensiveTripleHits()) + (4 * stats.getOffensiveHomeruns())) / (double) (stats.getOffensiveAtBats()):
            0.0;

      setGeneralStat(entry.getKey(), OFFENSIVE_SLG, slg);
    }
  }

  /**
   * Set a general statistic for a player.
   * 
   * @param playerName Name of the player
   * @param statName Name of the statistic
   * @param value value to set
   */
  @SuppressWarnings("java:S3824")
  private void setGeneralStat(String playerName, String statName, double value) {
    HashMap<String, Double> generalStatistics = playersGeneralStatistics.get(playerName);
    if (generalStatistics == null) {
      generalStatistics = new HashMap<>();
      playersGeneralStatistics.put(playerName, generalStatistics);
    }
    generalStatistics.put(statName, value);
  }

  /**
   * Analyse the team statistics.
   * 
   * @param teamStatistic TeamStatistic reference
   */
  private void analyseTeamStats(TeamStatistic teamStatistic) {
    for (LineupEntry player : teamStatistic.getPlayers()) {
      String playerName = player.getPlayerDescription().getName();

      GeneralStatContainer generalStatContainer = playerStatistics.get(playerName);
      if (generalStatContainer == null) {
        generalStatContainer = new GeneralStatContainer();
        playerStatistics.put(playerName, generalStatContainer);
      }

      if (player.getOffensiveStatistic() != null) {
        OffensiveStatistic offensiveStatistic = player.getOffensiveStatistic();

        generalStatContainer.addOffensiveBaseOnBalls(offensiveStatistic.getBaseOnBall());
        generalStatContainer.addOffensiveDoubleHits(offensiveStatistic.getDouble());
        generalStatContainer.addOffensiveGDPs(offensiveStatistic.getGroundedDoublePlay());
        generalStatContainer.addOffensiveHitByPitchs(offensiveStatistic.getHitByPitch());
        generalStatContainer.addOffensiveHomeruns(offensiveStatistic.getHomerun());
        generalStatContainer.addOffensiveIntentionalBaseOnBall(offensiveStatistic.getIntentionalbaseOnBall());
        generalStatContainer.addOffensiveIOs(offensiveStatistic.getInterferanceObstruction());
        generalStatContainer.addOffensiveRbis(offensiveStatistic.getRbi());
        generalStatContainer.addOffensiveSacrificeFlies(offensiveStatistic.getSacrificeFly());
        generalStatContainer.addOffensiveSacrificeHits(offensiveStatistic.getSacrificeHit());
        generalStatContainer.addOffensivesHits(offensiveStatistic.getHits());
        generalStatContainer.addOffensivesPAs(offensiveStatistic.getPlateAppearances());
        generalStatContainer.addOffensivesRuns(offensiveStatistic.getRuns());
        generalStatContainer.addOffensiveStrikeOuts(offensiveStatistic.getStrikeOut());
        generalStatContainer.addOffensivesTripleHits(offensiveStatistic.getTriple());
        generalStatContainer.addOffesnvivesAtBats(offensiveStatistic.getAtBats());
        generalStatContainer.addOffensiveIps(player.getIpPlayed());
        generalStatContainer.addOffensiveCaughtStealings(offensiveStatistic.getCaughtStealing());
        generalStatContainer.addOffensiveStolenBases(offensiveStatistic.getStolenBase());
      }

      if (player.getCatcherStatistic() != null) {
        CatcherStatistic catcherStatistic = player.getCatcherStatistic();

        generalStatContainer.addCatcherCaugthStealings(catcherStatistic.getCaughtStealing());
        generalStatContainer.addCatcherIps(player.getIpPlayed());
        generalStatContainer.addCatcherPassBalls(catcherStatistic.getPassBall());
        generalStatContainer.addCatcherStolenBases(catcherStatistic.getStolenBase());
      }

      if (player.getDefensiveStatistic() != null) {
        DefensiveStatistic defensiveStatistic = player.getDefensiveStatistic();

        generalStatContainer.addDefensiveAssists(defensiveStatistic.getAssitances());
        generalStatContainer.addDefensiveDoublePlays(defensiveStatistic.getDoublePlay());
        generalStatContainer.addDefensiveErrors(defensiveStatistic.getErrors());
        generalStatContainer.addDefensiveIps(player.getIpPlayed());
        generalStatContainer.addDefensivePutouts(defensiveStatistic.getPutOut());
      }

      if (player.getPitcherStatistic() != null) {
        PitcherStatistic pitcherStatistic = player.getPitcherStatistic();

        generalStatContainer.addPitcherAtbats(pitcherStatistic.getAtBats());
        generalStatContainer.addPitcherBalks(pitcherStatistic.getBalks());
        generalStatContainer.addPitcherBaseOnBalls(pitcherStatistic.getBaseOnBall());
        generalStatContainer.addPitcherBatterFronts(pitcherStatistic.getBatterFront());
        generalStatContainer.addPitcherEarnedRuns(pitcherStatistic.getEarnedRuns());
        generalStatContainer.addPitcherHitByPitchs(pitcherStatistic.getHitByPitch());
        generalStatContainer.addPitcherHits(pitcherStatistic.getHits());
        generalStatContainer.addPitcherHomeruns(pitcherStatistic.getHomerun());
        generalStatContainer.addPitcherIntentionalBaseOnBalls(pitcherStatistic.getIntentionalbaseOnBall());
        generalStatContainer.addPitcherIos(pitcherStatistic.getInterferanceObstruction());
        generalStatContainer.addPitcherIps(player.getIpPlayed());
        generalStatContainer.addPitcherRuns(pitcherStatistic.getRuns());
        generalStatContainer.addPitcherSacrificeFlies(pitcherStatistic.getSacrificeFly());
        generalStatContainer.addPitcherSacrificeHits(pitcherStatistic.getSacrificeHit());
        generalStatContainer.addPitcherStrikeOuts(pitcherStatistic.getStrikeOut());
        generalStatContainer.addPitcherTripleHits(pitcherStatistic.getTriple());
        generalStatContainer.addPitcherWildPitchs(pitcherStatistic.getWildPitches());
        generalStatContainer.addPitchesDoubleHits(pitcherStatistic.getDouble());
      }
    }
  }

  /**
   * Return the general statistics for a player.
   * 
   * @param name Name of player
   * @return general statistics for the player.
   */
  public GeneralStatContainer getPlayerStatistics(String name) {
    return playerStatistics.get(name);

  }
}
