package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Pitcher_Earned_Runs extends AbstractWBSCUnitTest {

  public WBSC_2016_Pitcher_Earned_Runs() {
    super();
  }

  /**
   * Pitcher : exemple 001 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_001.JPG"/></td>
   * <td>In the example 1 given here, the defense has already had three fielding chances, as there have been two putouts, and a third runner reached base on an
   * error.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example001() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_001") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une balle sur l'arr�t qui la relai pour retirer le coureur batteur */\r\n");
    buf.append("        action { batter -> 63 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant atteind la premi�re sur une erreur */\r\n");
    buf.append("        action { batter -> E6T }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 3, 0, 0, 0, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 002 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_002.JPG"/></td>
   * <td>Usually, when there are two fielding chances on the same player, just one is counted, as any player can be put out only once. Example 2 shows two
   * fielding chances by the error of the catcher and the fly ball caught by the right fielder.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example002() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_002") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur aurait du �tre retirer sur pop fly */\r\n");
    buf.append("        action { batter -> EF2 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est retir� sur un fly dans le champ droit */\r\n");
    buf.append("        action { batter -> F9 }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 9, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 003 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_003.JPG"/></td>
   * <td>As the batter runner would have been put out if not for the error, there was no possibility for the pick-off.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example003() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_003") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe une simple sur le lanceur */\r\n");
    buf.append("        action { batter -> 1B1 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une balle vers l'arr�t court qui le relai la balle vers le 1 */\r\n");
    buf.append("        /* le d�fenseur comment une erreur */\r\n");
    buf.append("        action { batter -> 6E3 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en est retir� sur un 'pick off' */\r\n");
    buf.append("        action { runner1 -> PO13 }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 2, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 2, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 004 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_004.JPG"/></td>
   * <td>There are two fielding chances on the runner put out on second base. It should be noted, however, that if this runner had been put out on first, rather
   * than reaching base safely on an error, the defense would also have put out the next batter, thus making two putouts in all.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example004() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_004") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une erreur */\r\n");
    buf.append("        action { batter -> E6F }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une balle sur l'arr�t court qui la relaie pour retirer le coureur */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> 64 }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 0, 0, 0, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 005 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_005.JPG"/></td>
   * <td>With no men out and first base occupied, the eighth man in the line-up hits a single to the right fielder, who fails to catch the ball. The
   * batter-runner takes the opportunity to advance one base. The next batter swings at the third strike, which is also a wild pitch, and succeeds in reaching
   * first base safely, while the other runners advance one base on the wild pitch.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example005() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_005") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un hit en champ droit et avance d'une base sur l'une erreur */\r\n");
    buf.append("        action { batter -> 1B9 e9 , runner1 -> ++  }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant profite d'un troisi�me strike relach�, les coureurs avances */\r\n");
    buf.append("        action { batter -> KSWP , runner2 -> wp , runner3 -> wp earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 1, 1, 1, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 9, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 006 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_006.JPG"/></td>
   * <td>If the right fielder in example 5 had not committed an error, the ninth batter would have found first base occupied and he would have been struck out,
   * while the runners would have advanced one base on the wild pitch. �KS1 WP� in example 5 is therefore a fielding chance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example006() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_006") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un hit en champ droit et avance d'une base sur l'une erreur */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> ++  }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant profite d'un troisi�me strike relach�, les coureurs avances */\r\n");
    buf.append("        action { batter -> KS , runner1 -> wp , runner3 -> WP earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 1, 1, 1, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 007 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_007.JPG"/></td>
   * <td>A failed pickoff on first base allows the runner to advance to second and offers the batter the opportunity to reach first base on �KS1 WP�.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example007() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_007") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur aurait du �tre retir� sue un pick off, mais avance sur une erreur */\r\n");
    buf.append("        action { runner1 -> POe1T }\r\n");
    buf.append("\r\n");
    buf.append("        /* TRoisi�me strike relach� le batteur gagne la premi�re base, le coureur avance sur la lancer fou */\r\n");
    buf.append("        action { batter -> KSWP , runner2 -> wp }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 008 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_008.JPG"/></td>
   * <td>f it had not been for the pitcher�s error, first base would have been occupied and therefore automatically off limits to the batter. The �KS1 WP� is
   * therefore a fielding chance</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example008() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_008") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* TRoisi�me strike relach� le batteur gagne la premi�re base, le coureur avance sur la lancer fou */\r\n");
    buf.append("        action { batter -> KS , runner1 -> WP }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 009 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_009.JPG"/></td>
   * <td>After having swung at the third strike, the batter-runner is able to advance to first base because of a previous passed ball. The �KS1 WP� is therefore
   * a fielding chance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example009() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_009") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur avance sur une balle pass�e */\r\n");
    buf.append("        action { runner1 -> PB }\r\n");
    buf.append("\r\n");
    buf.append("        /* trois�me strike realch�, le bateur gagne la premi�re base, le coureur avance sur le lancer fou */\r\n");
    buf.append("        action { batter -> KSWP , runner2 -> wp }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 1, 0, 0);
    checkTotalCatcherSt(statisticEngine, 1, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 010 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_010.JPG"/></td>
   * <td>Of the three runs batted in on the strength of the home run, only the first and last are earned, as the second batter reached first base on �KS1 WP�
   * due to the previous passed ball. The �KS1 WP� is therefore a fielding chance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example010() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_010") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur avance sur une balle pass�e */\r\n");
    buf.append("        action { runner1 -> PB }\r\n");
    buf.append("\r\n");
    buf.append("        /* trois�me strike realch�, le bateur gagne la premi�re base, le coureur avance sur le lancer fou */\r\n");
    buf.append("        action { batter -> KSWP , runner2 -> wp }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un home run, tout le monde marque un point */\r\n");
    buf.append("        action { batter -> HR8 earned , runner1 -> +++ , runner3 -> + earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 3, 2, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 3, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 3, 2, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 3, 2, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 1, 0, 0);
    checkTotalCatcherSt(statisticEngine, 1, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 011 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_011.JPG"/></td>
   * <td></td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example011() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_011") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le premier batteur frappe un triple en champ droit  */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur marque le point sur une balle pass�e */\r\n");
    buf.append("        action { runner3 -> PB }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 1, 0, 0);
    checkTotalCatcherSt(statisticEngine, 1, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 012 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_012.JPG"/></td>
   * <td>The first batter is awarded a base on balls. The second batter hits a double and forces the runner to third base. The third batter hits a fly ball to
   * the center fielder that enables the runner on third to score. This is an earned run.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example012() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_012") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premu�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un double dans le champ droit, le coureur gagne deux bases */\r\n");
    buf.append("        action { batter -> 2B8 , runner1 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le frappeur suivant frappe un sacrifice fly dans le champ centre, le coureur en 3 marque */\r\n");
    buf.append("        action { batter -> SF8 , runner3 -> + earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 1, 1, 1, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 013 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_013.JPG"/></td>
   * <td>The first batter hits a safe hit to third base, while the next batter sends him to third with a single to the right field. On an attempt to steal
   * second, the catcher throws to the second baseman but fails to make the putout. The runner on third base takes this opportunity to advance to home base and
   * score. Both runners are awarded stolen bases and the run is earned.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example013() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_013") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur la troisi�me base */\r\n");
    buf.append("        action { batter -> 1B5 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un hit dans le champ droit, le coureur avance de deux bases */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Les deux coureurs voent une base */\r\n");
    buf.append("        action { runner1 -> SB , runner3 -> SB earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 1, 1, 2, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 2, 0);
    checkTotalCatcherSt(statisticEngine, 0, 2, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 014 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_014.JPG"/></td>
   * <td>With less than two out, the first batter walks. The next batter hits a double to the center fielder, forcing the runner to third base. The third batter
   * advances to first base after being touched by the pitched ball. The next batter hits to the shortstop who throws to home base in an attempt to put out the
   * runner about to score. The runner, however, reaches the base before the ball does, and scores. The fielder's choice is not a fielding chance. Everyone else
   * advances one base. The run is an earned run</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example014() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_014") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le scond batteur frappe un double dans  le champ centre, le coureur gagne deux bases */\r\n");
    buf.append("        action { batter -> 2B8 , runner1 -> ++}\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un balle sur l'arr�t court qui fait un choix d�fensif */\r\n");
    buf.append("        action { batter -> FC62 , runner1 -> + , runner2 -> + , runner3 -> + earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 1, 1, 1, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 015 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_015.JPG"/></td>
   * <td>The first batter walks. The next two batters hit singles inside the diamond, filling the bases. The fourth batter is awarded a base on balls, forcing
   * all the other runners to advance one base, and enabling the runner on third to score. This is an earned run.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example015() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_015") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple sur la trois�me base */\r\n");
    buf.append("        action { batter -> 1B5 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple sur la deuxi�me base */\r\n");
    buf.append("        action { batter -> 1B4 , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant gagne la premi�re base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + , runner2 -> + , runner3 -> + earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 2, 1, 1, 2, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 1, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 1, 1, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 1, 1, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 016 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_016.JPG"/></td>
   * <td>The first batter reaches first base on a throwing error by the third baseman. The second batter hits a double to the right field, and the runner from
   * first base runs home. The next batter is struck out, and the fourth batter hits a single to the right field, sending home the runner from second base. The
   * next two batters are put out. The first run cannot be earned because the batter reached first base on an error. The second run is earned, as it was
   * obtained with just two fielding chances.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example016() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_016") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur une balle sur le d�fenseur de la troisi�me base qui commet une erreur en relayant la balle */\r\n");
    buf.append("        action { batter -> E5T }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un double en champ droit, le coureur marque */\r\n");
    buf.append("        action { batter -> 2B9, runner1 -> +++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est sstrkie out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple dans le champ droit, le coureur en 2 marque */\r\n");
    buf.append("        action { batter -> 1B9 , runner2 -> ++ earned }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une balle sur l'arr�t court qui relaye en une pour le retirer */\r\n");
    buf.append("        action { batter -> 63, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est retire sur une fly sur l'arr�t court */\r\n");
    buf.append("        action { batter -> F6 }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 6, 2, 1, 2, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 6, 6, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 5, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 1, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 3, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 6, 6, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 6, 6, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 017 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_017.JPG"/></td>
   * <td>The first batter reaches first base with a safe hit to the left field, and is driven to second by the next batter, who is awarded a base on balls. The
   * third batter hits a sacrifice bunt enabling both runners to advance one base. With the fourth batsman at the plate, the pitcher delivers a balk, which
   * means both runners advance one base and a run is scored. The batter is then awarded a base on balls. The next batter receives a wild pitch that enables
   * both runners to advance one base, and another run is scored. Both runs are earned runs.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example017() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_017") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur une 'base on ball' */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant fait un sacifice hit, les deux coureurs avancent */\r\n");
    buf.append("        action { batter -> SH13 , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Les deux coureurs avancent sur un 'balk' */\r\n");
    buf.append("        action { runner2 -> bk , runner3 -> BK earned }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur une 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Les deux coureurs avances sur lancer fou */\r\n");
    buf.append("        action { runner1 -> wp, runner3 -> WP earned }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 1, 2, 2, 1, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 4, 1, 2, 1, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 1, 2, 2, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 1, 1);
    checkTotalPitchStat(statisticEngine, 4, 1, 2, 2, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 018 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_018.JPG"/></td>
   * <td>The first batter hits a high ball into foul territory, which the catcher should be able to catch but does not. The scorer decides it is an easy catch
   * and assigns an error to the catcher. The batter returns to bat and hits a home run to the center field. The next batter is struck out, and the third hits a
   * triple to the right field. At this point, with the fourth batter at the plate, the pitcher delivers a wild pitch, allowing the runner on third to score the
   * second run. The batter is subsequently struck out. The fifth batter hits a triple to the center field and goes on to score the third run thanks to a balk
   * by the pitcher. The first run scored on the home run hit cannot be earned as the batter�s life had been prolonged by an error. The second run was earned as
   * it had been obtained with just two fielding chances. The third run, however, was not earned, as it was scored after the third fielding chance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example018() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_018") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur aurait du �tre �liminer sur une fly dans fausses balles */\r\n");
    buf.append("        action { batter -> EF2 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Ensuite il frappe un home run dans le champ centre */\r\n");
    buf.append("        action { batter -> HR8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur suivant frappe un triple dans le champ droit */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* il marque sur lancer fou */\r\n");
    buf.append("        action { runner3 -> WP earned }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un triple dans le champ centre */\r\n");
    buf.append("        action { batter -> 3B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* et il marque le point sur une 'balk' */\r\n");
    buf.append("        action { runner3 -> BK }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 5, 3, 1, 3, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 5, 5, 3, 3, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 5, 5, 3, 1, 3, 0, 2, 1, 0, 0, 0, 0, 0, 0, 2, 1, 1);
    checkTotalPitchStat(statisticEngine, 5, 5, 3, 1, 3, 0, 2, 1, 0, 0, 0, 0, 0, 0, 2, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 019 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_019.JPG"/></td>
   * <td>The first batter walks. The next batter hits towards the shortstop, who throws to second in time to put out the runner, but muffs the throw. With first
   * and second bases occupied, the catcher lets through a pitch he should have caught, allowing both runners to advance. The third batter hits a fly ball to
   * the center field, enabling the runner from third to score. The fourth batter hits a single to the center field, thus sending the runner from second home.
   * The fifth batter is struck out, and the sixth hits a home run to the right field, enabling a further two runs to be scored. None of these four runs is
   * earned. The first run cannot be earned because the runner reached second on an error. The second run was obtained with just two fielding chances, but it
   * must be remembered that the runner reached second on a passed ball, without which the fourth batter's hit would have enabled him to reach third at most,
   * and which would have been the third fielding chance. The other two runs were scored after three fielding chances.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example019() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_019") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une balle et arrive sur base sur un choix et une erreur d�fenseive */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> E6T }\r\n");
    buf.append("\r\n");
    buf.append("        /* Les deux coureurs avancent sur une balle pass�e */\r\n");
    buf.append("        action { runner1 -> pb , runner2 -> PB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un sacrifice hit, le premier coureur marque */\r\n");
    buf.append("        action { batter -> SF8 , runner3 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un double dans le champ centere, le coureur marque */\r\n");
    buf.append("        action { batter -> 1B8 , runner2 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un Homerun, le coureur marque */\r\n");
    buf.append("        action { batter -> HR9 , runner1 -> +++ }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 4, 4, 0, 2, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 6, 4, 4, 2, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 4);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 6, 4, 4, 0, 2, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 6, 4, 4, 0, 2, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 1, 0, 0);
    checkTotalCatcherSt(statisticEngine, 1, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 020 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_020.JPG"/></td>
   * <td>The first batter hits a triple to center field. The second batter reaches first base safely when the shortstop muffs a fly ball. While the third batter
   * is at bat the runner on first steals second base, and the other runner takes advantage of the fact that the fielders are concentrating on his team-mate to
   * score a run. The third and fourth batters are struck out. The fifth is put out at first base with an assist by the shortstop. The only run scored was not
   * earned, because if it had not been for the shortstop�s error the second batter would have been put out and consequently he would not have been able to
   * steal second base, thus allowing the runner on third to score.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example020() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_020") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un triple fns le champ droit */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur une erreur de l'arr�t court */\r\n");
    buf.append("        action { batter -> E6F }\r\n");
    buf.append("\r\n");
    buf.append("        /* Les deux coureurs voelnt une base */\r\n");
    buf.append("        action { runner1 -> SB , runner3 -> SB  }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est retir� sur une frappe au sol */\r\n");
    buf.append("        action { batter -> 63 }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 5, 1, 0, 1, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 5, 5, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 3, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 5, 5, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 5, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 2, 0);
    checkTotalCatcherSt(statisticEngine, 0, 2, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 021 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_021.JPG"/></td>
   * <td>In the case of catcher�s interference to the batterrunner (before he reaches first base), it is a decisive error that for the rules [OBR 9.16(a)
   * comment] is not considered a fielding chance, and for this reason any runs scored by this batter-runner cannot become earned. Example 21: with two out the
   * third batter reaches first on a catcher�s interference. The fourth batter hits a home run. The fifth batter strikes out. Two runs have scored, but one (the
   * run of the fourth batter) is earned, because the official scorer cannot assume that the third batter would have made an out to end the inning, absent the
   * catcher�s interference.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example021() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_021") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur se fait retirer sur une balle au sol */\r\n");
    buf.append("        action { batter -> 63 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur se fait retirer sur une fly */\r\n");
    buf.append("        action { batter -> F6  }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un home run dans le champ droit, le coureur avance et marque */\r\n");
    buf.append("        action { batter -> HR9 earned , runner1 -> +++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 4, 2, 1, 1, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 1, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 3, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 5, 4, 2, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 2, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 022 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_022.JPG"/></td>
   * <td>the first two batters are struck out. The third batter reaches first base on a safe hit to third base. The fourth batter reaches first base on a safe
   * hit to left field, allowing the runner to advance to second base The catcher interferes with the fifth batter and forces the other two to advance. The
   * sixth advances to first base after being touched by the pitched ball; all runners advance and the third of the batting order scores a run. This run is
   * considered a run batted in, but not an earned run, as the official scorer shall not assume that the batter who reached first base by catcher�s interference
   * would have made an out. Because such batter never had a chance to complete his time at bat, it is unknown how such batter would have fared absent the
   * catcher�s interference [OBR 9.16(a) Comment]</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example022() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_022") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple sur la troisi�me  base */\r\n");
    buf.append("        action { batter -> 1B5 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 , runner1-> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP , runner1 -> + , runner2 -> + , runner3 -> + }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 4, 1, 0, 2, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 6, 4, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 2, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 6, 4, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0);
    checkTotalPitchStat(statisticEngine, 6, 4, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 023 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_023.JPG"/></td>
   * <td>continues with the situation mentioned in example 22. Now the seventh batter reaches first base on a safe hit to right field which makes all runners to
   * advance one base. Now the run of the third batter becomes earned; the run of the fourth batter is not earned yet.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example023() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_023") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple sur la troisi�me  base */\r\n");
    buf.append("        action { batter -> 1B5 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 , runner1-> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP , runner1 -> + , runner2 -> + , runner3 -> + earned}\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> + , runner2 -> + , runner3 -> + }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 5, 2, 1, 3, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 7, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 7, 5, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 2, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 7, 5, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0);
    checkTotalPitchStat(statisticEngine, 7, 5, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 024 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_024.JPG"/></td>
   * <td>Example 24 continues with the situation of example 23. The next batter hits a home run, allowing all other runners to score. Now all runs become earned
   * runs, except for the run of the fifth batter who reached first base through the catcher�s interference. This batter never had a chance to complete his time
   * at bat and it is unknown how such batter would have fared absent the catcher�s interference.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example024() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_024") + "\r\n");
    buf.append("\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple sur la troisi�me  base */\r\n");
    buf.append("        action { batter -> 1B5 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 , runner1-> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la premiere base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP , runner1 -> + , runner2 -> + , runner3 -> + earned}\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> + , runner2 -> + , runner3 -> + earned }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un homerun */\r\n");
    buf.append("        action { batter -> HR9 earned, runner1 -> +++ earned, runner2 -> ++ earned, runner3 -> + }\r\n");
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
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkGeneralStat(statisticEngine, 6, 6, 5, 4, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 7, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 8, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4);
    checkTotalOffensivStatistic(statisticEngine, 8, 6, 6, 4, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 2, 6);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 8, 6, 6, 5, 4, 0, 0, 1, 0, 0, 0, 0, 1, 1, 2, 0, 0);
    checkTotalPitchStat(statisticEngine, 8, 6, 6, 5, 4, 0, 0, 1, 0, 0, 0, 0, 1, 1, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
