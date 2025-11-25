package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Run_Battle_In extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Run_Battle_In() {
    super();
  }

/**
 * Defense : exemple 123 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_123.JPG"/>
 *      </td>
 *      <td>With runners on first and third bases, the batter
hits a double to the right field, enabling both runners to score.
This means that the fourth batter in the batting order is
credited with two runs batted in.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example123() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_123") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier coureur frappe un triple dans le champ centre */\r\n");
  buf.append("        action { batter -> 3B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur suivant gagne la premi�re base sur une interf�rence du receveur */\r\n");
  buf.append("        action { batter -> INT }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivnat frappe un double dans le champ droit , les deux coureur marque un point */\r\n");
  buf.append("        action { batter -> 2B9 , runner1 -> +++ , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 2, 0, 2, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 124 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_124.JPG"/>
 *      </td>
 *      <td>With runners on first and third bases, the batter
hits a single to the center fielder, who lets the ball run
between his legs. Consequently, both runners score and the
batter reaches second base.
The run scored by the runner from third base is batted in, as it
was scored on the hit.
The run scored by the runner from first base, however, is not a
run batted in as it occurred because of the error by the center
fielder.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example124() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_124") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier coureur frappe un triple dans le champ centre */\r\n");
  buf.append("        action { batter -> 3B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur suivant gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un simple dans le champ centre et profite d'une erreur pour gagner le deuxi�me base */\r\n");
  buf.append("        /* Les deux coureur avance, le second profite de l'erreur pour marque le point */\r\n");
  buf.append("        action { action { batter -> 1B8 e8 , runner1 -> ++ (3) , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 2, 0, 2, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 2, 2, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 2, 0, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 2, 0, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 125 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_125.JPG"/>
 *      </td>
 *      <td>With runners on first and third bases, the batter
hits to the shortstop, who puts out the runner from first base
with an assist to the second baseman.
The runner from third scores.
This run counts as a run batted in, since it was scored on the
batted ball.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example125() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_125") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier coureur frappe un triple dans le champ centre */\r\n");
  buf.append("        action { batter -> 3B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur suivant gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur frappe une balle vers l'arr�t court  qui r�cup�re et relai la bale pour retirer le coueur arrivant de la une */\r\n");
  buf.append("        action { batter -> O6 , runner1 -> 64 , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 1, 1, 0, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 126 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_126.JPG"/>
 *      </td>
 *      <td>With bases full the batter is touched
by the ball and goes directly to first base, forcing the other
runners to advance.
The runner on third consequently scores.
This run is counted as a run batted in, since it was forced by
the batter.
The same situation occurs not only when a batter-runner
reaches first base on a hit by pitch, but also a base on balls or
interference.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example126() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_126") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un hit en champ gauche */\r\n");
  buf.append("        action { batter -> 1B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit dans le champ droit, le coureur gagne deux bases */\r\n");
  buf.append("        action { batter -> 1B9 , runner1 -> ++ }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la prmi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB, runner1 -> +  }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la prmi�re base sur un 'hit by pitch', tous les coureurs avances */\r\n");
  buf.append("        action { batter -> HP, runner1 -> + , runner2 -> + , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 2, 0, 0, 3);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 4, 2, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 4, 2, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 4, 2, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 127 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_127.JPG"/>
 *      </td>
 *      <td>With first and second bases occupied, the batter
hits a home run, and three runs are scored.
All three runs are batted in, and are credited to the batter
(including his own home run).
Example
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example127() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_127") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un simple dans le champ centre */\r\n");
  buf.append("        action { batter -> 1B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un simple dans le champ droit, le coureur avance d'une base */\r\n");
  buf.append("        action { batter -> 1B9 , runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur frappe un homerun dans le champ centre, tous le monde marque */\r\n");
  buf.append("        action { batter -> HR8 , runner1 -> +++ , runner2 -> ++ }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 3, 3, 0, 3, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
  checkTotalOffensivStatistic(statisticEngine, 3, 3, 3, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 3, 3, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 3, 3, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 128 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_128.JPG"/>
 *      </td>
 *      <td>With third base occupied, the batter hits a fly
ball to the center fielder and is caught out.
The runner on third base leaves after the catch and scores.
The run is batted in and is credited to the batter who hit the
sacrifice fly.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example128() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_128") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un triple dans le chammp droit */\r\n");
  buf.append("        action { batter -> 3B9 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur frappe un sacrifice fly dans le champ centre, le coureur marque */\r\n");
  buf.append("        action { batter -> SF8 , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 8, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 129 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_129.JPG"/>
 *      </td>
 *      <td>With a runner on third base, the pitcher delivers
a wild pitch, allowing the runner to score.
This run is not batted in. The same applies for a passed ball.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example129() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_129") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un triple dans le chammp centre */\r\n");
  buf.append("        action { batter -> 3B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* le coureur profite d'un lancer fou pour marque le point */\r\n");
  buf.append("        action { runner3 -> WP }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalPitchStat(statisticEngine, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 130 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_130.JPG"/>
 *      </td>
 *      <td>With a runner on second base, the batter hits a
sacrifice bunt that enables the runner to reach third base.
However, the pitcher, who catches the bunt, muffs his throw
to first, enabling the runner to score and the batter to reach
second base.
The run is not batted in as it was scored because of an error.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example130() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_130") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* le premier batteur frappe un double dans le champ gauche */\r\n");
  buf.append("        action { batter -> 2B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant fait sun sacrfice hit, mais arrive sur base sur une erreur, le coureur avance et profite de l'erreur pour marquer */\r\n");
  buf.append("        action { batter -> SHE1T+ , runner2 -> + (2) }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 1, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 131 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_131.JPG"/>
 *      </td>
 *      <td>With runners on first and third, the batter hits to
the shortstop who passes the ball to the second baseman, who
in turn puts out the runner from first, then throws to the first
baseman, making a double play.
The runner on third scores.
The lead runner�s advance is entirely legal although the run
cannot be counted as having been batted in, as it was scored
on the back of a batted ball that led to a double play.
In this case it is important to remember to note the batting
order number of the batter with a stroke above, to show that
it is not a run batted in, despite the fact that the advance was
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example131() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_131") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un triple dans le champ centre */\r\n");
  buf.append("        action { batter -> 3B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* le batteur suivant frappe une balle au sol vers l'arr�t court ce qui entrine un double jeu, le coureur en 3 marque le point */\r\n");
  buf.append("        action { batter -> GDP43 , runner1 -> 64 , runner3 -> + }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 1, 2, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 1);
  checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
  checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 1);
  checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 3);
  checkGeneralDoublePlay(statisticEngine, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 132 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_132.JPG"/>
 *      </td>
 *      <td>With two out and a runner on third base, the
batter hits to the shortstop who bungles the catch, allowing
the runner on third to score, and the batter to reach first base
safely.
The run is not batted in as there were already two out, and if
the shortstop had not made the error the inning would have
been over.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example132() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_132") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un triple dans le champ centre */\r\n");
  buf.append("        action { batter -> 3BRC }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la premi�re base sur une erreur, me coureur profite de l'erreur pour marquer le point */\r\n");
  buf.append("        action { batter -> E6 , runner3 -> (2) }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 1, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 6, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 133 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_133.JPG"/>
 *      </td>
 *      <td>With a runner on second base, the batter hits a
single to the center fielder, who lets the ball pass between his
legs.
The runner on second base succeeds in scoring, while the
batter reaches second base.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example133() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_133") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier coureur frappe un double dans le champ gauche */\r\n");
  buf.append("        action { batter -> 2B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit dans le champ centre et profite de l'erreur pour gagner la deuxi�me base, le coureur marque */\r\n");
  buf.append("        action { batter -> 1B8 e8 , runner2 -> ++ }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 2, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 134 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_134.JPG"/>
 *      </td>
 *      <td>If not, example 134, the run would not count as having been
batted in.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example134() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_134") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier coureur frappe un double dans le champ gauche */\r\n");
  buf.append("        action { batter -> 2B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit dans le champ centre et profite de l'erreur pour gagner la deuxi�me base, le coureur marque sur l'erreur */\r\n");
  buf.append("        action { batter -> 1B8 e8 , runner2 -> + (2) }\r\n");
  buf.append("\r\n");
  buf.append(CommonResources.ENDING_GAME);
  
  
  IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
  assertNotNull(parserResult,"Parser result can't be null");
  Game game = (Game) parserResult.getRootASTElement();
  
  /* create statistiques */
  StatisticEngine statisticEngine = new StatisticEngine();
  statisticEngine.setGame(game);
  statisticEngine.setActionsManager(new StatisticManager());
  statisticEngine.run();
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 2, 1, 0, 2, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

  
}
