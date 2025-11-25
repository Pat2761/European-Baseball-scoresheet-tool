package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.google.inject.Inject;

public abstract class AbstractWBSCUnitTest {

  @Inject
  protected IParser parser;
   
  public AbstractWBSCUnitTest() {
    com.google.inject.Injector injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
    injector.injectMembers(this);
  }

  protected void checkGeneralStat(StatisticEngine statisticEngine, int ab, int r, int er, int h, int a, int e, int lob) {
    InninStatictic inningStats = statisticEngine.getStatisticManager().getStats().getVisitor().getGeneralInningStats().get(0);

    assertEquals(ab, inningStats.getInningStat().getAtBats(),"Error for At bats");
    assertEquals(r, inningStats.getInningStat().getRuns(),"Error for Runs");
    assertEquals(er, inningStats.getInningStat().getEarnedRuns(),"Error for Earned runs");
    assertEquals(h, inningStats.getInningStat().getHits(),"Error for Hits");
    assertEquals(a, inningStats.getInningStat().getAssitances(),"Error for Assistances");
    assertEquals(e, inningStats.getInningStat().getErrors(),"Error for errors");
    assertEquals(lob, inningStats.getInningStat().getLob(),"Error for left on bases");
  }

  protected void checkTotalCatcherSt(StatisticEngine statisticEngine, int pb, int sb, int cs) {
    CatcherStatistic catcherStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalCatcherStatistic();

    assertEquals(pb, catcherStatisitics.getPassBall(),"Error for Pass balls");
    assertEquals(sb, catcherStatisitics.getStolenBase(),"Error for Stolen bases");
    assertEquals(cs, catcherStatisitics.getCaughtStealing(),"Error for Caugth stealing");
  }

  protected void checkCatcherStat(StatisticEngine statisticEngine, int catcherNUlmber, int pb, int sb, int cs) {
    LineupEntry currentCatcher = statisticEngine.getStatisticManager().getHometeamLineup().getCatchers().get(catcherNUlmber - 1);
    CatcherStatistic catcherStatisitics = currentCatcher.getCatcherStatistic();

    assertEquals(pb, catcherStatisitics.getPassBall(),"Error for Pass balls");
    assertEquals(sb, catcherStatisitics.getStolenBase(),"Error for Stolen bases");
    assertEquals(cs, catcherStatisitics.getCaughtStealing(),"Error for Caugth stealing");
  }

  protected void checkTotalPitchStat(StatisticEngine statisticEngine, int bf, int ab, int r, int er, int h, int b2, int b3, int hr, int sh, int sf, int bb,
      int ibb, int hp, int io, int k, int wp, int bk) {
    PitcherStatistic pitcherStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalPitcherStatistic();

    assertEquals(bf, pitcherStatisitics.getBatterFront(),"Error for batter front");
    assertEquals(ab, pitcherStatisitics.getAtBats(),"Error for AtBats");
    assertEquals(r, pitcherStatisitics.getRuns(),"Error for Runs");
    assertEquals(er, pitcherStatisitics.getEarnedRuns(),"Error for Earned Runs");
    assertEquals(h, pitcherStatisitics.getHits(),"Error for Hits");
    assertEquals(b2, pitcherStatisitics.getDouble(),"Error for Double Hits");
    assertEquals(b3, pitcherStatisitics.getTriple(),"Error for Triples Hits");
    assertEquals(hr, pitcherStatisitics.getHomerun(),"Error for Home runs");
    assertEquals(sh, pitcherStatisitics.getSacrificeHit(),"Error for Sacrifice hits");
    assertEquals(sf, pitcherStatisitics.getSacrificeFly(),"Error for Sacrifice flies");
    assertEquals(bb, pitcherStatisitics.getBaseOnBall(),"Error for base on ball");
    assertEquals(ibb, pitcherStatisitics.getIntentionalbaseOnBall(),"Error for intentional base on ball");
    assertEquals(hp, pitcherStatisitics.getHitByPitch(),"Error for hit by pitch");
    assertEquals(io, pitcherStatisitics.getInterferanceObstruction(),"Error for Obstruction/Interference");
    assertEquals(k, pitcherStatisitics.getStrikeOut(),"Error for Strike out");
    assertEquals(wp, pitcherStatisitics.getWildPitches(),"Error for Wild pitch");
    assertEquals(bk, pitcherStatisitics.getBalks(),"Error for Balk");
  }

  protected void checkPitcherStat(StatisticEngine statisticEngine, int pitcherNumber, int bf, int ab, int r, int er, int h, int b2, int b3, int hr, int sh,
      int sf, int bb, int ibb, int hp, int io, int k, int wp, int bk) {
    LineupEntry currentPitcher = statisticEngine.getStatisticManager().getHometeamLineup().getPitchers().get(pitcherNumber - 1);
    PitcherStatistic pitcherStatisitics = currentPitcher.getPitcherStatistic();

    assertEquals(bf, pitcherStatisitics.getBatterFront(),"Error for batter front");
    assertEquals(ab, pitcherStatisitics.getAtBats(),"Error for AtBats");
    assertEquals(r, pitcherStatisitics.getRuns(),"Error for Runs");
    assertEquals(er, pitcherStatisitics.getEarnedRuns(),"Error for Earned Runs");
    assertEquals(h, pitcherStatisitics.getHits(),"Error for Hits");
    assertEquals(b2, pitcherStatisitics.getDouble(),"Error for Double Hits");
    assertEquals(b3, pitcherStatisitics.getTriple(),"Error for Triples Hits");
    assertEquals(hr, pitcherStatisitics.getHomerun(),"Error for Home runs");
    assertEquals(sh, pitcherStatisitics.getSacrificeHit(),"Error for Sacrifice hits");
    assertEquals(sf, pitcherStatisitics.getSacrificeFly(),"Error for Sacrifice flies");
    assertEquals(bb, pitcherStatisitics.getBaseOnBall(),"Error for base on ball");
    assertEquals(ibb, pitcherStatisitics.getIntentionalbaseOnBall(),"Error for intentional base on ball");
    assertEquals(hp, pitcherStatisitics.getHitByPitch(),"Error for hit by pitch");
    assertEquals(io, pitcherStatisitics.getInterferanceObstruction(),"Error for Obstruction/Interference");
    assertEquals(k, pitcherStatisitics.getStrikeOut(),"Error for Strike out");
    assertEquals(wp, pitcherStatisitics.getWildPitches(),"Error for Wild pitch");
    assertEquals(bk, pitcherStatisitics.getBalks(),"Error for Balk");
  }

  protected void checkGeneralDoublePlay(StatisticEngine statisticEngine, int doublePlay) {
    assertEquals(doublePlay, statisticEngine.getStatisticManager().getStats().getHometeam().getDoublePlayCounter(),"Error for double plays");
  }

  protected void checkTotalDefensivesStatist(StatisticEngine statisticEngine, int po, int a, int e, int dp) {
    DefensiveStatistic defensiveStatisitics = statisticEngine.getStatisticManager().getStats().getHometeam().getTotalDefensiveStatistic();

    assertEquals(po, defensiveStatisitics.getPutOut(),"Error for put out");
    assertEquals(a, defensiveStatisitics.getAssitances(),"Error for assistances");
    assertEquals(e, defensiveStatisitics.getErrors(),"Error for errors");
    assertEquals(dp, defensiveStatisitics.getDoublePlay(),"Error for double plays");
  }

  protected void checkDefensivePlayerStat(StatisticEngine statisticEngine, int defensivePosition, int po, int a, int e, int dp) {
    LineupEntry player = statisticEngine.getStatisticManager().getHometeamLineup().getPlayerForDefensivePosition("" + defensivePosition);
    DefensiveStatistic defensiveStatisitics = player.getDefensiveStatistic();

    assertEquals(po, defensiveStatisitics.getPutOut(),"Error for put out");
    assertEquals(a, defensiveStatisitics.getAssitances(),"Error for assistances");
    assertEquals(e, defensiveStatisitics.getErrors(),"Error for errors");
    assertEquals(dp, defensiveStatisitics.getDoublePlay(),"Error for double plays");
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

    assertEquals(po, defensiveStatisitics.getPutOut(),"Error for put out");
    assertEquals(a, defensiveStatisitics.getAssitances(),"Error for assistances");
    assertEquals(e, defensiveStatisitics.getErrors(),"Error for errors");
    assertEquals(dp, defensiveStatisitics.getDoublePlay(),"Error for double plays");
  }


  protected void checkTotalOffensivStatistic(StatisticEngine statisticEngine, int pa, int ab, int r, int h, int b2, int b3, int hr, int gdp, int sh, int sf,
      int bb, int ibb, int hp, int io, int sb, int cs, int k, int rbi) {
    OffensiveStatistic offensiveStatistic = statisticEngine.getStatisticManager().getStats().getVisitor().getTotalOffensiveStatistic();

    assertEquals(pa, offensiveStatistic.getPlateAppearances(),"Error for plate appearance");
    assertEquals(ab, offensiveStatistic.getAtBats(),"Error for At Bat");
    assertEquals(r, offensiveStatistic.getRuns(),"Error for runs");
    assertEquals(b2, offensiveStatistic.getDouble(),"Error for two bases hits");
    assertEquals(b3, offensiveStatistic.getTriple(),"Error for three bases hits");
    assertEquals(hr, offensiveStatistic.getHomerun(),"Error for home run");
    assertEquals(gdp, offensiveStatistic.getGroundedDoublePlay(),"Error for Grounded double play");
    assertEquals(sh, offensiveStatistic.getSacrificeHit(),"Error for sacrifice hit");
    assertEquals(sf, offensiveStatistic.getSacrificeFly(),"Error for sacrifice fly");
    assertEquals(bb, offensiveStatistic.getBaseOnBall(),"Error for base on ball");
    assertEquals(ibb, offensiveStatistic.getIntentionalbaseOnBall(),"Error for intentional base on ball");
    assertEquals(hp, offensiveStatistic.getHitByPitch(),"Error for hit by pitch");
    assertEquals(io, offensiveStatistic.getInterferanceObstruction(),"Error for Obstruction/Interference");
    assertEquals(sb, offensiveStatistic.getStolenBase(),"Error for Stolen base");
    assertEquals(cs, offensiveStatistic.getCaughtStealing(),"Error for Caugth stealing");
    assertEquals(k, offensiveStatistic.getStrikeOut(),"Error for Strike out");
    assertEquals(rbi, offensiveStatistic.getRbi(),"Error for Rbi");
  }

  protected void checkOffensivePlayerStat(StatisticEngine statisticEngine, int offensivePosition, int pa, int ab, int r, int h, int b2, int b3, int hr, int gdp,
      int sh, int sf, int bb, int ibb, int hp, int io, int sb, int cs, int k, int rbi) {
    LineupEntry player = statisticEngine.getStatisticManager().getVisitorLineup().getPlayerForOffensivePosition("" + offensivePosition);
    OffensiveStatistic offensiveStatistic = player.getOffensiveStatistic();

    assertEquals(pa, offensiveStatistic.getPlateAppearances(),"Error for plate appearance");
    assertEquals(ab, offensiveStatistic.getAtBats(),"Error for At Bat");
    assertEquals(r, offensiveStatistic.getRuns(),"Error for runs");
    assertEquals(b2, offensiveStatistic.getDouble(),"Error for two bases hits");
    assertEquals(b3, offensiveStatistic.getTriple(),"Error for three bases hits");
    assertEquals(hr, offensiveStatistic.getHomerun(),"Error for home run");
    assertEquals(gdp, offensiveStatistic.getGroundedDoublePlay(),"Error for Grounded double play");
    assertEquals(sh, offensiveStatistic.getSacrificeHit(),"Error for sacrifice hit");
    assertEquals(sf, offensiveStatistic.getSacrificeFly(),"Error for sacrifice fly");
    assertEquals(bb, offensiveStatistic.getBaseOnBall(),"Error for base on ball");
    assertEquals(ibb, offensiveStatistic.getIntentionalbaseOnBall(),"Error for intentional base on ball");
    assertEquals(hp, offensiveStatistic.getHitByPitch(),"Error for hit by pitch");
    assertEquals(io, offensiveStatistic.getInterferanceObstruction(),"Error for Obstruction/Interference");
    assertEquals(sb, offensiveStatistic.getStolenBase(),"Error for Stolen base");
    assertEquals(cs, offensiveStatistic.getCaughtStealing(),"Error for Caugth stealing");
    assertEquals(k, offensiveStatistic.getStrikeOut(),"Error for Strike out");
    assertEquals(rbi, offensiveStatistic.getRbi(),"Error for Rbi");
  }
}
