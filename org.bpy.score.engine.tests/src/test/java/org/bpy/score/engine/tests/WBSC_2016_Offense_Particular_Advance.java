package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Particular_Advance extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Particular_Advance() {
    super();
  }

  /**
   * Defense : exemple 108 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_108.JPG"/></td>
   * <td>With first and second bases occupied, and one ball and one strike to the batter, the wild pitch lodges in the catcher�s mask, and the runners advance
   * one base while the batter remains in the box to play out his turn. He is awarded a ball or a strike depending on the umpire�s call. The advances are
   * recorded with the abbreviation for wild pitch.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example108() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_108") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur suivant frappe un hit en champ gauche, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B7 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Suite � un lancer four, la balle se loge dans plstron de l'arbitre, les deux coureurs avance sur le lancer fou */\r\n");
    buf.append("        action { runner1 -> wp , runner2 -> WP }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 109 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_109.JPG"/></td>
   * <td>With two out, third and first bases occupied and two balls and two strikes to the batter. The pitched ball, a wild pitch or a passed ball, lodges in
   * the umpire�s clothing and is called the third strike. The batter is therefore awarded first base and the runners are allowed to advance one base. Use the
   * scoring symbol according to the situation for wild pitch or passed ball.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example109() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_109") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur le lanceur */\r\n");
    buf.append("        action { batter -> 1B1b }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur suivant frappe un hit en champ gauche, le coureur gagne deux bases */\r\n");
    buf.append("        action { batter -> 1B7 , runner1 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur un troisi�me relach� sur 'pass ball' */\r\n");
    buf.append("        /* le deux coureurs avancent sur le 'pass ball' */\r\n");
    buf.append("        action { batter -> KSPB , runner1 -> pb , runner3 -> pb}\r\n");
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
    checkGeneralStat(statisticEngine, 3, 1, 0, 2, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);

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
    checkPitcherStat(statisticEngine, 1, 3, 3, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 3, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 1, 0, 0);
    checkTotalCatcherSt(statisticEngine, 1, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 110
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_110.JPG"/></td>
   * <td>With first and third bases occupied and the count at three balls and one strike, the ball lodges in the umpire�s clothing due to a wild pitch or passed
   * ball. In this situation, the pitch is considered the fourth ball and the batter is awarded first base. The advance by the runner on third base is recorded
   * with �WP� or �PB� as he was not forced and the batter was third in the batting order.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example110() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_110") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur le lanceur */\r\n");
    buf.append("        action { batter -> 1B1 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple dans le champ centre */\r\n");
    buf.append("        /* le coureur gagne une base sur la frappe et profite d'une erreur du d�fenseur pour en gagner une deuxi�me */\r\n");
    buf.append("        action { batter -> 1B8 , runner1 -> + e8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le troisi�me batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        /* le coureur profite de ce lancer fou pour arriver au marbre */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + , runner3 -> WP }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 0, 2, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 111 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_111.JPG"/></td>
   * <td>In the course of an attempted double steal, the lead runner is touched by the pitched ball before he reaches home base. As he was clearly in the act of
   * stealing a base, both advances are recorded with the abbreviation �SB�.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example111() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_111") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 1 avance sur un balk */\r\n");
    buf.append("        action { runner1 -> BK }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple sur l'arr�t court, le coureur avance d'une base */\r\n");
    buf.append("        action { batter -> 1B6, runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* les deux coureurs volent une base */\r\n");
    buf.append("        action { runner1 -> SB , runner3 -> SB }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);
    checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 2, 0);
    checkTotalCatcherSt(statisticEngine, 0, 2, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 112 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_112.JPG"/></td>
   * <td>With runners on first and third base, the lead runner is touched by the legally pitched ball before reaching home base. The run is allowed, the leading
   * runner is credited with a stolen base and the other runner�s advance to second base is recorded with the notation �WP� or �PB�, depending on the situation.
   * </td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example112() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_112") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur gagne la premi�re base sur un 'hit by pitch' */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 1 avance sur un balk */\r\n");
    buf.append("        action { runner1 -> BK }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple dans le champ centre, le coureur avance d'une base */\r\n");
    buf.append("        action { batter -> 1B6, runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le premier coureur vole une base, tandis que le second profite d'un lancer fou */\r\n");
    buf.append("        action { runner1 -> WP , runner3 -> SB }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1);
    checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 113 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_113.JPG"/></td>
   * <td>With third and first bases occupied, and a full count to the batter, there is an attempted double steal. The lead runner is touched by the ball before
   * reaching the strike zone. The run is allowed, the runner who scored is credited with a steal and the batter, as this was the fourth ball, is awarded first
   * base. This latter event also justifies the second runner�s advance, regardless of whether he was already attempting to steal a base (forced advance)</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example113() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_113") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe une balle vers l'arr�t court qui commet une une erreur */\r\n");
    buf.append("        action { batter -> E6 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un simple dans le champ droit, le coureur gagne deux bases */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur suivant obtient un 'base on ball' alors que le coureur etait entrain de voler */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + , runner3 -> SB }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 0, 1, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 114 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_114.JPG"/></td>
   * <td>With bases loaded, two out and a full count to the batter, the legally pitched ball slips from the pitcher�s hand and hits the runner leaving third
   * base before entering the strike zone. Given that the pitch is also the fourth ball, all (forced) advances occur as a consequence of the base awarded to the
   * fourth batter regardless of any attempts to steal a base</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example114() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_114") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit en champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe une fly dans le centre qui est mal rattrap�e, le coureur avance sur l'erreur */\r\n");
    buf.append("        action { batter -> E8F , runner1 -> (2) }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur suivant gange une base sur un 'hit by pitch', les deux coureurs avancent */\r\n");
    buf.append("        action { batter -> HP , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant gagne la premi�re base sun un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + , runner2 -> + , runner3 -> +  }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 0, 1, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 115 <br>
   * 
   * <table>
   *   <tr>
   *      <td>
   *        <img src="./resources/WBSC_2016_offense_exemple_115.JPG"/>
   *      </td>
   *      <td>With first and third bases occupied and less than
two strikes on the batter, the runner on third is touched by a
legally pitched ball while passing through the strike zone.
The umpire allows the run, charges a strike to the batter and
awards the other runner second base.
The run counts as �stolen� while the advance to second base is
recorded with the abbreviation �O/1.
   *      </td>
   *   </tr>
   * </table>  
   * 
   */
@Test
public void example115() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_115") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'Hit by pitch'  */\r\n");
  buf.append("        action { batter -> HP }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur avance sur un lancer fou  */\r\n");
  buf.append("        action { runner1 -> WP}\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit en champ droit, le coureur avance  */\r\n");
  buf.append("        action { batter -> 1B9 , runner2 -> +}\r\n");
  buf.append("\r\n");
  buf.append("        /* Un coureur vole la base , le second avance sur une indif�rence */\r\n");
  buf.append("        action { runner1 -> O/1 , runner3 -> SB }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 1, 0);
  checkTotalCatcherSt(statisticEngine, 0, 1, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 116 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_116.JPG"/>
 *      </td>
 *      <td> starts with the same situation as example 113,
but now the second runner was trying to steal the next base:
both are credited with a stolen base.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example116() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_116") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'Hit by pitch'  */\r\n");
  buf.append("        action { batter -> HP }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur avance sur un lancer fou  */\r\n");
  buf.append("        action { runner1 -> WP}\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit en champ droit, le coureur avance  */\r\n");
  buf.append("        action { batter -> 1B9 , runner2 -> +}\r\n");
  buf.append("\r\n");
  buf.append("        /* les deux coureurs volent une base */\r\n");
  buf.append("        action { runner1 -> SB , runner3 -> SB }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 0, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 2, 0);
  checkTotalCatcherSt(statisticEngine, 0, 2, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 117 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_117.JPG"/>
 *      </td>
 *      <td>With first and third bases occupied, less than
two out and two strikes on the batter, the runner on third
tries to steal home base but is touched by the ball while
passing through the strike zone.
The umpire calls out the batter on the third strike, validates
the run and awards the other runner an additional base.
The scorer therefore credits the runner who scored with a
stolen base, and notes down the advance to second with the
notation �O/1�.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example117() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_117") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un hit sur la premi�re base et profite d'une erreur pour gagner la deuxi�me */\r\n");
  buf.append("        action { batter -> 1B3 e3 }\r\n");
  buf.append("\r\n");
  buf.append("        /* le coureur profite d'un lancer fou pour gagner la troisi�me base */\r\n");
  buf.append("        action { runner2 -> WP }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur est strike out, un coureur cole le marbre et l'autre avance sur une ind�f�rence */\r\n");
  buf.append("        action { batter -> KS , runner1 -> O/1 , runner3 -> SB }\r\n");
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
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 3, 0, 0, 1, 0);
  checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
  checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 1, 0);
  checkTotalCatcherSt(statisticEngine, 0, 1, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 118 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_118.JPG"/>
 *      </td>
 *      <td>With first and third bases occupied, two out and
two strikes on the batter, the runner on third is touched by
the ball in the strike zone as he is trying to score.
The umpire calls out the batter and (as this is the third putout)
no run is scored.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example118() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_118") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* le premier batteur arrive sur base sur une erreur de relance du d�fenseur de la cinqui�me base */\r\n");
  buf.append("        action { batter -> E5T }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur vole une base */\r\n");
  buf.append("        action { runner1 -> SB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant  frappe un simple sur le lanceur, le couruer avance d'une base */\r\n");
  buf.append("        action { batter -> 1B1 , runner2 -> +}\r\n");
  buf.append("\r\n");
  buf.append("        /* le batteur est strike out */\r\n");
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
  /* Check general statisitics                                                                                               */
  /*                                 ab,  r, er,  h,  a,  e,lob                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkGeneralStat(statisticEngine, 3, 0, 0, 1, 0, 1, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalOffensivStatistic(statisticEngine, 3, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 5, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 3, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkTotalPitchStat(statisticEngine, 3, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 1, 0);
  checkTotalCatcherSt(statisticEngine, 0, 1, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 119 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_119.JPG"/>
 *      </td>
 *      <td>With no men out and bases full, the seventh
batter hits a short fly ball into foul territory towards the third
base dugout. The fielder makes the catch but falls into the
dugout as he does so.
The umpire calls out the batter and all runners advance one
base.
Each advance is noted with batters number.  
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example119() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_119") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur frappe un hit en champ centre */\r\n");
  buf.append("        action { batter -> 1B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur avance sur un lancer fou */\r\n");
  buf.append("        action { runner1 -> WP }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe un hit sur le receveur, le coureur avance */\r\n");
  buf.append("        action { batter -> 1B2 , runner2 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant gagne la premi�re base sur un 'base on ball', le coureur avance */\r\n");
  buf.append("        action { batter -> BB, runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le batteur suivant frappe une fly dans la zone des fausses balles qui est rattrap�e de vol�e, tous les coureurs avance */\r\n");
  buf.append("        action { batter -> FF5 , runner1 -> +  , runner2 -> +, runner3 -> +}\r\n");
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
  checkGeneralStat(statisticEngine, 3, 1, 0, 2, 0, 0, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 4, 3, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 4, 3, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0);
  checkTotalPitchStat(statisticEngine, 4, 3, 1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkTotalCatcherSt(statisticEngine, 0, 0, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 120 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_120.JPG"/>
 *      </td>
 *      <td>With no men out and a runner on third, the
batter hits a long fly ball into foul territory towards the left
fielder who, after making a dash for the ball, succeeds in
catching it but falls into the fence, ending up outside the field.
The umpire calls out the batter and sends the runner home.
The advance is noted with the batting order number of the
batter.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example120() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_120") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteru frappe un hit dans le champ centre */\r\n");
  buf.append("        action { batter -> 1B8 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Puis il vole une base */\r\n");
  buf.append("        action { runner1 -> SB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Puis il profite d'un lnacer fou pour gagner la 3*/\r\n");
  buf.append("        action { runner2 -> WP }\r\n");
  buf.append("\r\n");
  buf.append("        /* La Batteur suivant frappe une fly dans la champ gauche dans la zone des fausses balles qui est rattap�e, le coureur marque un point */\r\n");
  buf.append("        action { batter -> FF7 , runner3 -> + }\r\n");
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
  checkGeneralStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
  checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 7, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  checkTotalPitchStat(statisticEngine, 2, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 1, 0);
  checkTotalCatcherSt(statisticEngine, 0, 1, 0);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}


}
