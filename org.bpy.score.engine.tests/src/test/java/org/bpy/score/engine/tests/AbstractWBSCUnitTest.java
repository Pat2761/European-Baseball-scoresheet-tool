package org.bpy.score.engine.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.emf.statistic.CatcherStatistic;
import org.bpy.score.engine.stats.emf.statistic.DefensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.InninStatictic;
import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.stats.emf.statistic.OffensiveStatistic;
import org.bpy.score.engine.stats.emf.statistic.PitcherStatistic;
import org.bpy.score.game.GameStandaloneSetup;
import org.eclipse.xtext.parser.IParser;
import org.junit.BeforeClass;

import com.google.inject.Inject;

public abstract class AbstractWBSCUnitTest {

  @Inject
  protected IParser parser;

  @BeforeClass
  public static void onlyOnce() {
	  // Nothing to do
  }
  
  public AbstractWBSCUnitTest() {
    com.google.inject.Injector injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
    injector.injectMembers(this);
  }

  protected void checkGeneralStat(StatisticEngine statisticEngine, int ab, int r, int er, int h, int a, int e, int lob) {
    InninStatictic inningStats = statisticEngine.getStatisticManager().getStats().getVisitor().getGeneralInningStats().get(0);

    assertEquals("Error for At bats", ab, inningStats.getInningStat().getAtBats());
    assertEquals("Error for Runs", r, inningStats.getInningStat().getRuns());
    assertEquals("Error for Earned runs", er, inningStats.getInningStat().getEarnedRuns());
    assertEquals("Error for Hits", h, inningStats.getInningStat().getHits());
    assertEquals("Error for Assistances", a, inningStats.getInningStat().getAssitances());
    assertEquals("Error for errors", e, inningStats.getInningStat().getErrors());
    assertEquals("Error for left on bases", lob, inningStats.getInningStat().getLob());
  }

  protected void checkTotalCatcherSt(StatisticEngine statisticEngine, int pb, int sb, int cs) {
    CatcherStatistic catcherStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalCatcherStatistic();

    assertEquals("Error for Pass balls", pb, catcherStatisitics.getPassBall());
    assertEquals("Error for Stolen bases", sb, catcherStatisitics.getStolenBase());
    assertEquals("Error for Caugth stealing", cs, catcherStatisitics.getCaughtStealing());
  }

  protected void checkCatcherStat(StatisticEngine statisticEngine, int catcherNUlmber, int pb, int sb, int cs) {
    LineupEntry currentCatcher = statisticEngine.getStatisticManager().getHometeamLineup().getCatchers().get(catcherNUlmber - 1);
    CatcherStatistic catcherStatisitics = currentCatcher.getCatcherStatistic();

    assertEquals("Error for Pass balls", pb, catcherStatisitics.getPassBall());
    assertEquals("Error for Stolen bases", sb, catcherStatisitics.getStolenBase());
    assertEquals("Error for Caugth stealing", cs, catcherStatisitics.getCaughtStealing());
  }

  protected void checkTotalPitchStat(StatisticEngine statisticEngine, int bf, int ab, int r, int er, int h, int b2, int b3, int hr, int sh, int sf, int bb,
      int ibb, int hp, int io, int k, int wp, int bk) {
    PitcherStatistic pitcherStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalPitcherStatistic();

    assertEquals("Error for batter front", bf, pitcherStatisitics.getBatterFront());
    assertEquals("Error for AtBats", ab, pitcherStatisitics.getAtBats());
    assertEquals("Error for Runs", r, pitcherStatisitics.getRuns());
    assertEquals("Error for Earned Runs", er, pitcherStatisitics.getEarnedRuns());
    assertEquals("Error for Hits", h, pitcherStatisitics.getHits());
    assertEquals("Error for Double Hits", b2, pitcherStatisitics.getDouble());
    assertEquals("Error for Triples Hits", b3, pitcherStatisitics.getTriple());
    assertEquals("Error for Home runs", hr, pitcherStatisitics.getHomerun());
    assertEquals("Error for Sacrifice hits", sh, pitcherStatisitics.getSacrificeHit());
    assertEquals("Error for Sacrifice flies", sf, pitcherStatisitics.getSacrificeFly());
    assertEquals("Error for base on ball", bb, pitcherStatisitics.getBaseOnBall());
    assertEquals("Error for intentional base on ball", ibb, pitcherStatisitics.getIntentionalbaseOnBall());
    assertEquals("Error for hit by pitch", hp, pitcherStatisitics.getHitByPitch());
    assertEquals("Error for Obstruction/Interference", io, pitcherStatisitics.getInterferanceObstruction());
    assertEquals("Error for Strike out", k, pitcherStatisitics.getStrikeOut());
    assertEquals("Error for Wild pitch", wp, pitcherStatisitics.getWildPitches());
    assertEquals("Error for Balk", bk, pitcherStatisitics.getBalks());
  }

  protected void checkPitcherStat(StatisticEngine statisticEngine, int pitcherNumber, int bf, int ab, int r, int er, int h, int b2, int b3, int hr, int sh,
      int sf, int bb, int ibb, int hp, int io, int k, int wp, int bk) {
    LineupEntry currentPitcher = statisticEngine.getStatisticManager().getHometeamLineup().getPitchers().get(pitcherNumber - 1);
    PitcherStatistic pitcherStatisitics = currentPitcher.getPitcherStatistic();

    assertEquals("Error for batter front", bf, pitcherStatisitics.getBatterFront());
    assertEquals("Error for AtBats", ab, pitcherStatisitics.getAtBats());
    assertEquals("Error for Runs", r, pitcherStatisitics.getRuns());
    assertEquals("Error for Earned Runs", er, pitcherStatisitics.getEarnedRuns());
    assertEquals("Error for Hits", h, pitcherStatisitics.getHits());
    assertEquals("Error for Double Hits", b2, pitcherStatisitics.getDouble());
    assertEquals("Error for Triples Hits", b3, pitcherStatisitics.getTriple());
    assertEquals("Error for Home runs", hr, pitcherStatisitics.getHomerun());
    assertEquals("Error for Sacrifice hits", sh, pitcherStatisitics.getSacrificeHit());
    assertEquals("Error for Sacrifice flies", sf, pitcherStatisitics.getSacrificeFly());
    assertEquals("Error for base on ball", bb, pitcherStatisitics.getBaseOnBall());
    assertEquals("Error for intentional base on ball", ibb, pitcherStatisitics.getIntentionalbaseOnBall());
    assertEquals("Error for hit by pitch", hp, pitcherStatisitics.getHitByPitch());
    assertEquals("Error for Obstruction/Interference", io, pitcherStatisitics.getInterferanceObstruction());
    assertEquals("Error for Strike out", k, pitcherStatisitics.getStrikeOut());
    assertEquals("Error for Wild pitch", wp, pitcherStatisitics.getWildPitches());
    assertEquals("Error for Balk", bk, pitcherStatisitics.getBalks());
  }

  protected void checkGeneralDoublePlay(StatisticEngine statisticEngine, int doublePlay) {
    assertEquals("Error for double plays", doublePlay, statisticEngine.getStatisticManager().getStats().getHometeam().getDoublePlayCounter());
  }

  protected void checkTotalDefensivesStatist(StatisticEngine statisticEngine, int po, int a, int e, int dp) {
    DefensiveStatistic defensiveStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalDefensiveStatistic();

    assertEquals("Error for put out", po, defensiveStatisitics.getPutOut());
    assertEquals("Error for assistances", a, defensiveStatisitics.getAssitances());
    assertEquals("Error for errors", e, defensiveStatisitics.getErrors());
    assertEquals("Error for double plays", dp, defensiveStatisitics.getDoublePlay());
  }

  protected void checkDefensivePlayerStat(StatisticEngine statisticEngine, int defensivePosition, int po, int a, int e, int dp) {
    LineupEntry player = statisticEngine.getStatisticManager().getHometeamLineup().getPlayerForDefensivePosition("" + defensivePosition);
    DefensiveStatistic defensiveStatisitics = player.getDefensiveStatistic();

    assertEquals("Error for put out", po, defensiveStatisitics.getPutOut());
    assertEquals("Error for assistances", a, defensiveStatisitics.getAssitances());
    assertEquals("Error for errors", e, defensiveStatisitics.getErrors());
    assertEquals("Error for double plays", dp, defensiveStatisitics.getDoublePlay());
  }
  
  protected void checkDefensivePlayerStat(StatisticEngine statisticEngine, int defensivePosition, int order, int po, int a, int e, int dp) {
    
    List<LineupEntry> players = new ArrayList<LineupEntry>();
    LineupManager lineup = statisticEngine.getStatisticManager().getHometeamLineup();
    for (LineupEntry player : lineup.getPlayers()) {
      if (player.getDefensivePosition().equals(""+defensivePosition)) {
        players.add(player);
      }
    }
    
    LineupEntry player = players.get(order-1);
    DefensiveStatistic defensiveStatisitics = player.getDefensiveStatistic();

    assertEquals("Error for put out", po, defensiveStatisitics.getPutOut());
    assertEquals("Error for assistances", a, defensiveStatisitics.getAssitances());
    assertEquals("Error for errors", e, defensiveStatisitics.getErrors());
    assertEquals("Error for double plays", dp, defensiveStatisitics.getDoublePlay());
  }


  protected void checkTotalOffensivStatistic(StatisticEngine statisticEngine, int pa, int ab, int r, int h, int b2, int b3, int hr, int gdp, int sh, int sf,
      int bb, int ibb, int hp, int io, int sb, int cs, int k, int rbi) {
    OffensiveStatistic offensiveStatistic = statisticEngine.getStatisticManager().getStats().getVisitor().getTotalOffensiveStatistic();

    assertEquals("Error for plate appearance", pa, offensiveStatistic.getPlateAppearances());
    assertEquals("Error for At Bat", ab, offensiveStatistic.getAtBats());
    assertEquals("Error for runs", r, offensiveStatistic.getRuns());
    assertEquals("Error for two bases hits", b2, offensiveStatistic.getDouble());
    assertEquals("Error for three bases hits", b3, offensiveStatistic.getTriple());
    assertEquals("Error for home run", hr, offensiveStatistic.getHomerun());
    assertEquals("Error for Grounded double play", gdp, offensiveStatistic.getGroundedDoublePlay());
    assertEquals("Error for sacrifice hit", sh, offensiveStatistic.getSacrificeHit());
    assertEquals("Error for sacrifice fly", sf, offensiveStatistic.getSacrificeFly());
    assertEquals("Error for base on ball", bb, offensiveStatistic.getBaseOnBall());
    assertEquals("Error for intentional base on ball", ibb, offensiveStatistic.getIntentionalbaseOnBall());
    assertEquals("Error for hit by pitch", hp, offensiveStatistic.getHitByPitch());
    assertEquals("Error for Obstruction/Interference", io, offensiveStatistic.getInterferanceObstruction());
    assertEquals("Error for Stolen base", sb, offensiveStatistic.getStolenBase());
    assertEquals("Error for Caugth stealing", cs, offensiveStatistic.getCaughtStealing());
    assertEquals("Error for Strike out", k, offensiveStatistic.getStrikeOut());
    assertEquals("Error for Rbi", rbi, offensiveStatistic.getRbi());
  }

  protected void checkOffensivePlayerStat(StatisticEngine statisticEngine, int offensivePosition, int pa, int ab, int r, int h, int b2, int b3, int hr, int gdp,
      int sh, int sf, int bb, int ibb, int hp, int io, int sb, int cs, int k, int rbi) {
    LineupEntry player = statisticEngine.getStatisticManager().getVisitorLineup().getPlayerForOffensivePosition("" + offensivePosition);
    OffensiveStatistic offensiveStatistic = player.getOffensiveStatistic();

    assertEquals("Error for plate appearance", pa, offensiveStatistic.getPlateAppearances());
    assertEquals("Error for At Bat", ab, offensiveStatistic.getAtBats());
    assertEquals("Error for runs", r, offensiveStatistic.getRuns());
    assertEquals("Error for two bases hits", b2, offensiveStatistic.getDouble());
    assertEquals("Error for three bases hits", b3, offensiveStatistic.getTriple());
    assertEquals("Error for home run", hr, offensiveStatistic.getHomerun());
    assertEquals("Error for Grounded double play", gdp, offensiveStatistic.getGroundedDoublePlay());
    assertEquals("Error for sacrifice hit", sh, offensiveStatistic.getSacrificeHit());
    assertEquals("Error for sacrifice fly", sf, offensiveStatistic.getSacrificeFly());
    assertEquals("Error for base on ball", bb, offensiveStatistic.getBaseOnBall());
    assertEquals("Error for intentional base on ball", ibb, offensiveStatistic.getIntentionalbaseOnBall());
    assertEquals("Error for hit by pitch", hp, offensiveStatistic.getHitByPitch());
    assertEquals("Error for Obstruction/Interference", io, offensiveStatistic.getInterferanceObstruction());
    assertEquals("Error for Stolen base", sb, offensiveStatistic.getStolenBase());
    assertEquals("Error for Caugth stealing", cs, offensiveStatistic.getCaughtStealing());
    assertEquals("Error for Strike out", k, offensiveStatistic.getStrikeOut());
    assertEquals("Error for Rbi", rbi, offensiveStatistic.getRbi());
  }
}
