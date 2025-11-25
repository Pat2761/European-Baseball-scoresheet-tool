package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Defense_GDP extends AbstractWBSCUnitTest {

  public WBSC_2016_Defense_GDP() {
    super();
  }

  /**
   * Defense : exemple 1 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_001.JPG"/></td>
   * <td>With first base occupied, the batter hits a line ball which is caught by the second baseman. The runner, who had broken away from first base, tries to
   * retouch but is anticipated by an assist from the second baseman. This is a double play but does not count as a GDP against the batter, as it was not a
   * ground ball.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example001() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_001") + "\r\n");
    buf.append("        /* Premier batteur avance sur un BB */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur retir� sur une line drive par le d�fenseur de la deuxi�me base */\r\n");
    buf.append("        /* Double jeu, le d�fenseur de la deuxi�me base renvoie � temps vers le d�fenseur de la premi�re base pour faire le retrait */\r\n");
    buf.append("        action { batter -> L4, runner1 -> 43 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 002 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_002.JPG"/></td>
   * <td>With a runner on second base, the batter hits a ground ball to the shortstop, who catches it and tags out the runner attempting to reach third base
   * from second, then throws the ball to first base in time to put out the batter runner This is not a GDP, since the runner on second base was not forced to
   * advance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example002() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_002") + "\r\n");
    buf.append("        /* Premier batteur avance sur un double dans le champs cntre */\r\n");
    buf.append("        action { batter -> 2B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur retir� sur une sur une frappe au sol vers l'arret court */\r\n");
    buf.append("        /* Double jeu, le d�fenseur arret court renvoie � temps vers le d�fenseur de la premi�re base pour faire le retrait */\r\n");
    buf.append("        action { batter -> 6, runner2 -> 63 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 003 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_003.JPG"/></td>
   * <td>First base is occupied and the batter has two strikes against him. On the next pitch, the runner tries to steal second base. The pitch is a third
   * strike, which means the batter is struck out. The catcher then succeeds in throwing to second base in time to put out the runner.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example003() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_003") + "\r\n");
    buf.append("        /* Premier batteur avance sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur strikeout swing� */\r\n");
    buf.append(
        "        /* Double jeu, le receveur renvoie a temps la balle vers le d�fenseur de la deuxi�me pour retir� le coureur qui volait la deuxi�me base */\r\n");
    buf.append("        action { batter -> KS, runner1 -> CS24 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 1);
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 004 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_004.JPG"/></td>
   * <td>With first and second bases occupied, the third batter hits a ground ball to the shortstop, who throws the ball to first base in time to put out the
   * batter-runner. Both runners advance, and the lead runner continues to run for home plate. The first baseman throws to home in time to put out the runner.
   * The defense is awarded a double play but not a grounded into double play, because the runner is not forced to advance. A participation should be credited
   * to every fielder who took part in the play</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example004() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_004") + "\r\n");
    buf.append("        /* Premier batteur avance sur un double hit vers le champs gauche */\r\n");
    buf.append("        action { batter -> 2B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur avance sur un 'Base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("       /* Batter frappe aue balle au sol vers l'arret court qui relaye a temps en premi�re base pour faire le retrait */\r\n");
    buf.append("       /* Les deux coureur en profite pour avancer d'une base */\r\n");
    buf.append("       /* le coureur qui arrive ne troisi�me base tente de gagner le point , mais se fait retirer par le receveur assist� par le */\r\n");
    buf.append("       /* ds�fenseur de la premi�re base */\r\n");
    buf.append("        action { batter -> 63, runner1 -> +, runner2 -> + 32 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 2, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 3);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 005a <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_005a.JPG"/></td>
   * <td>With first and second bases occupied, the batter hits a ground ball to the third baseman who puts out the runner who is forced to third base, and
   * completes the double play by assisting the second baseman. A GDP is charged against the batter-runner, even though he was not put out himself.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example005a() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_005a") + "\r\n");
    buf.append("        /* Premier batteur avance sur 'Base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur avance sur un hit en champs gauche, le coureur en premi�re base avance */\r\n");
    buf.append("        action { batter -> 1B7, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("       /* Batteur frappe un balle au sol vers le d�fenseur de la troisi�me base qui touche sa base */\r\n");
    buf.append("       /* puis relais a temps vers le d�fenseur de la deuxi�me base pour retirer le coureur arrivant de la premi�re base */\r\n");
    buf.append("        action { batter -> GDPO5, runner1 -> 54, runner2 -> 5  }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 5, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 005b <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_005b.JPG"/></td>
   * <td>With first and second bases occupied, the batter hits a ground ball to short stop who assists the second baseman to put out the runner who is forced to
   * second base, and completes the double play by assisting the third baseman for the putout on the lead runner. This is a reverse double play. Also in this
   * case a GDP is charged against the batter-runner, even though he was not put out himself.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example005b() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_005b") + "\r\n");
    buf.append("        /* Premier batteur avance sur 'Base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Deuxi�me batteur avance sur un hit en champs gauche, le coureur en premi�re base avance */\r\n");
    buf.append("        action { batter -> 1B7, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("       /* Batteur frappe un balle au sol vers le d�fenseur arret court qui renvoie a temps la balle au d�fenseur */\r\n");
    buf.append("       /* de la deuxi�me base pour retirer le coureur venant de la premi�re base */\r\n");
    buf.append("       /* Ce d�fenseur relais la balle au d�fenseur de la troisi�me base qui touche le coureur arrivant de la deuxi�me base */\r\n");
    buf.append("        action { batter -> GDPO6, runner1 -> 64, runner2 -> 45  }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 2, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 3);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 006 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_006.JPG"/></td>
   * <td>With a runner on first base, the batter hits a ground ball which is caught by the shortstop, who throws to second in time to put out the runner. In
   * turn, the second baseman throws to first and puts out the batter-runner. The official scorer awards a double play to the team, participation in a double
   * play to the three fielders who took part in the action (shortstop, second baseman, first baseman) and a grounded into double play to the batter.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example006() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_006") + "\r\n");
    buf.append("        /* Premier batteur avance sur 'Base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe une balle roulante sur l'arret court qui r�cup�re la balle */\r\n");
    buf.append("        /* a temps au d�fenseur de la deuxi�me base pour retirer le coureur venant de la premi�re base */\r\n");
    buf.append("        /* Le d�fenseur de la deuxi�me base revoie a temps la balle au d�fenseur de la premi�re base pour retirer le coureur batteur  */\r\n");
    buf.append("        action { batter -> GDP43, runner1 -> 64 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 3);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 007 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_007.JPG"/></td>
   * <td>Bases are full. The batter hits a line drive which is caught by the third baseman. The third baseman, after catching it, tags third base and retires
   * the runner who had left third base, then throws to second in time to put out the runner who had left second. This is not a grounded into double play
   * because it was not a ground ball.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example007() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_007") + "\r\n");
    buf.append("        /* Premier batteur avance sur 'Base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur avance sur un hit en champs centre' */\r\n");
    buf.append("        action { batter -> 1B8, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le troisi�me batteur avance sur une erreur du d�fenseur de la premi�re base apr�s un relais du f�genseur de la trois�me base*/\r\n");
    buf.append("        action { batter -> 4E3, runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le quatri�me batteur est retir� par le d�fenseur de la troisi�me base sur ube line drive*/\r\n");
    buf.append("        /* le d�fenseur touche sa base et retire le coureur en troii�me avant qu'il ne revienne sur sa base */\r\n");
    buf.append(
        "        /* puis relaie a temps la balle vers le d�fenseur de la deuxi�me base pour retirer le coureur en deuxi�me avant qu'il ne tousche sa base */\r\n");
    buf.append("        action { batter -> L5, runner1 ->  +, runner2 -> 54 , runner3 -> 5 }\r\n");
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
    checkGeneralStat(statisticEngine, 3, 0, 0, 1, 2, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 5, 2, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 3, 2, 1, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 3, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 3, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    boolean graphicalResult = true;
    assertEquals(true, graphicalResult,"graphical aspect is not the expected visual aspect");
  }

  /**
   * Defense : exemple 008 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_008.JPG"/></td>
   * <td>Bases are loaded. The batter hits a ground ball which is fielded by the third baseman. He tags the base, then throws the ball to the second baseman who
   * catches it, touches the base and throws it to first base for the third out. A �GDP� is charged against the batter-runner.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example008() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_008") + "\r\n");
    buf.append("        /* Le Premier batteur avance sur une erreur de re ttrap�e de fly du � l'arret court */\r\n");
    buf.append("        action { batter -> E6F }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur avance sur un hit en champs centre, le coureur en une avance */\r\n");
    buf.append("        action { batter -> 1B8, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le troisi�me batteur avance sur 'Base on Ball', tous es coureurs avance */\r\n");
    buf.append("        action { batter -> BB, runner1 -> +, runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le quatri�me batteur frappe une balle au sol vers le d�fenseur de la troisi�me Base qui touche sa base */\r\n");
    buf.append("        /* et retire le coureur venant de la deuxi�me base, il relai a temps vers le d�fenseur de la deuxi�me base  */\r\n");
    buf.append("        /* pour retirer le couruer venant de la premi�re base. Le defenseur de la deuxi�me relaie aussi a temps  */\r\n");
    buf.append("        /* vers le d�fenseur de la premi�re abse pour retirer le batteur coureur  */\r\n");
    buf.append("        action { batter -> GDP43, runner1 -> 54, runner2 -> 5 }\r\n");
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
    checkGeneralStat(statisticEngine, 3, 0, 0, 1, 2, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 4, 3, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 3, 2, 1, 3);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 3, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 3, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
