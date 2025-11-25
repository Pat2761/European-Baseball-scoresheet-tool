package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Advance_On_Fielder_Choice extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Advance_On_Fielder_Choice() {
    super();
  }

 /**
 * Defense : exemple 071 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_071.JPG"/>
 *      </td>
 *      <td>The infield ground ball is recovered by the third
baseman who chooses to play for the forced runner, and fails
to make the putout.
This also indicates that when an infield ground ball is
recovered by the second baseman, who chooses to play for
the forced runner and throws to the shortstop, but fails to
make the putout, we score FC 44 for the batter (the first 4 is
the fielder who initiated the play and the second 4 is the base towards he
threw).
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example071() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_071") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteru frappe un simple sur le lanceur */\r\n");
  buf.append("        action { batter -> 1B1 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe une balle vers le �fenseur de la troisi�me base qui fait le choix de relayer la balle au d�fenseur de la deuxi�me base sans succ�s */\r\n");
  buf.append("        action { batter -> FC54 , runner1 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 1, 0, 0, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 072 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_072.JPG"/>
 *      </td>
 *      <td>The notation �FC� in the first base square indicates that a play
for that base would have led to the batter-runner being put
out, as demonstrated in the example 72.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example072() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_072") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteru frappe un simple sur le lanceur */\r\n");
  buf.append("        action { batter -> 1B1 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe une balle vers le d�fenseur de la troisi�me base qui relaier la balle au d�fenseur de la premi�re base pour retire le batteur coureur */\r\n");
  buf.append("        action { batter -> 53 , runner1 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 1);

  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 5, 0, 1, 0, 0); 
  checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 073 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_073.JPG"/>
 *      </td>
 *      <td>Example 73: In the event that the scorer is not convinced that
the batter would have been put out on first base, the result
would be a safe hit.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example073() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_073") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteru frappe un simple sur le lanceur */\r\n");
  buf.append("        action { batter -> 1B1 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un balle vers le d�fenseur de la troisi�me base qui relaier la balle au d�fenseur de la deuxi�me base car c'est un hit */\r\n");
  buf.append("        action { batter -> 1B5 , runner1 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 2, 0, 0, 2);

  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 074 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_074.JPG"/>
 *      </td>
 *      <td>Example 74: With first and second bases occupied, on a bunt
by the ninth batter the pitcher tries unsuccessfully to put out
the forced runner on third, thus giving the batter-runner the
opportunity to reach first base.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example074() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_074") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit sur la deuxi�me base, le coureur avence en deuxi�me base */\r\n");
  buf.append("        action { batter -> 1B4 , runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur brappe un bunt sacrifice, mais la d�fenseur fait le chois de retirer le coureur en 2 sans succ�s */\r\n");
  buf.append("        action { batter -> SHFC15 , runner1 -> +, runner2 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 0, 3);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 3, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 075 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_075.JPG"/>
 *      </td>
 *      <td>Example 75: If, in the action described above, the lead runner
had been put out (or had reached base safely on an error by
one of the two fielders who took part in the action), the
batter-runner�s arrival on first base would have been recorded
as an �occupied ball�.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example075() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_075") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit sur la deuxi�me base, le coureur avence en deuxi�me base */\r\n");
  buf.append("        action { batter -> 1B4 , runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un bunt sur le lanceur qui r�cup�re la balle et fait le choix d'�liminer le courreur arrivant en 3 */\r\n");
  buf.append("        action { batter -> O1b , runner1 -> O1 , runner2 -> 15 }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 076 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_076.JPG"/>
 *      </td>
 *      <td>The example 76 shows what happens when there is no
opportunity to retire any of the runners.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example076() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_076") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit sur la deuxi�me base, le coureur avence en deuxi�me base */\r\n");
  buf.append("        action { batter -> 1B4 , runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un bunt sur le lanceur qui r�cup�re la balle et relance la balle pour retirer le courreur arrivant en 3 sans succee */\r\n");
  buf.append("        action { batter -> 1B1b , runner1 -> + , runner2 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 2, 0, 0, 3);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 3, 2, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 077 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_077.JPG"/>
 *      </td>
 *      <td>The seventh batter swings at the third strike,
which is missed by the catcher. Despite recovering the ball in
time to make the putout on first, the catcher tries to put out
the runner who left his base on the passed ball. The runner
reaches base safely.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example077() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_077") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un double dans le champ centre */\r\n");
  buf.append("        action { batter -> 2B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Troisi�me strike relach� sur un pass ball, le receveur fait le chois de retirer le coureur arrivant en trois sans succ�s */\r\n");
  buf.append("        action { batter -> KSFC25 , runner2 -> PB }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 1, 0, 0, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 1, 0, 0);
  checkTotalCatcherSt(statisticEngine, 1, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 078 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_078.JPG"/>
 *      </td>
 *      <td>The example 78 shows the effects of a successful play for first
base. No passed ball is charged to the catcher, because of the
out.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example078() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_078") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un double dans le champ centre */\r\n");
  buf.append("        action { batter -> 2B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Troisi�me strike relach� sur un pass ball, le receveur retrait du batteur coureur par une relance au premi�re base */\r\n");
  buf.append("        action { batter -> KS23 , runner2 -> O/2 }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

}
