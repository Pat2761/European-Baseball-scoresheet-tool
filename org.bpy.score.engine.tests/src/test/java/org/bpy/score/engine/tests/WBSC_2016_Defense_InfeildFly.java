package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Defense_InfeildFly extends AbstractWBSCUnitTest {

  public WBSC_2016_Defense_InfeildFly() {
    super();
  }

  /**
   * Defense : exemple 020 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_020.JPG"/></td>
   * <td>With bases loaded and one out, the batter hits a high ball to shortstop, which the umpire declares `infield fly�. The fly ball is caught by the
   * shortstop.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example020() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_020") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un cloche be condition d'infield fly et la balle est rattrap�e de vol�e par l'arr�t court  */\r\n");
    buf.append("        action { batter -> IF6 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 0, 0);

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
    checkDefensivePlayerStat(statisticEngine, 6, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
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
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 021 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_021.JPG"/></td>
   * <td>With bases loaded and one out, the batter hits a high ball to third, which the umpire declares �Infield fly if fair�. As it falls, the ball hits the
   * runner touching third base. The batter is declared out under �Out By Rule� rule 8, and the putout is credited to the third baseman. The runner who was hit
   * is not out, and remains on the same base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example021() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_021") + "\r\n");
    buf.append("\r\n");
    buf.append(
        "        /* Le batteur frappe un cloche be condition d'infield fly et la balle en retombant touche le coureur qui etait sur la troisi�me base  */\r\n");
    buf.append("        action { batter -> OBR8-5 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 0, 0);

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
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
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
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 022 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_022.JPG"/></td>
   * <td>With first and second bases occupied the batter hits a high ball along the line between first base and home plate, and the umpire therefore declares
   * �Infield fly if fair�; the first baseman goes for the ball but fails to catch it. The runner on second base, seeing the bad play, tries to advance to third
   * base, but the first baseman recovers the ball and assists the third baseman in a putout. The batter is automatically put out under �Out By Rule� 8
   * [9.09(c)(1)] (Infield Fly), while the runner is tagged out.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example022() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_022") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un double dans le champs centre */\r\n");
    buf.append("        action { batter -> 2B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deui�me batteur arrive sur base sur 'base on Ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le troisi�me batteur frappe une cloche dans le champ interne et un Infeild fly est annonc� par l'arbitre */\r\n");
    buf.append("        /* le d�fenseur de la troisi�me base tente de rattraper la balle de vol�e, mais commet une erreur et la balle tomne au sol */\r\n");
    buf.append(
        "        /* le coureur en deuxi�me base, voyant l'erreur, tente de gagner la treoisi�me base mais se fait tagger par le d�fenseur de la troisi�me base */\r\n");
    buf.append("        action { batter -> OBR8-3 dontCountAsDoublePlay , runner2 -> 35 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 1, 0, 1);

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
    checkDefensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
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
    
  }

  /**
   * Defense : exemple 023 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_023.JPG"/></td>
   * <td>With first and second bases occupied and one out, the batter hits a fly ball along the line between first base and home plate, and the umpire therefore
   * calls �Infield fly if fair�; the ball lands in foul territory and bounces fair before being touched by a fielder: charge a putout by infield fly to the
   * batter and credit a putout to the fielder nearest the ball (in this case the first baseman)</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example023() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_023") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe une cloche le long de la ligne entre le marbre et la premi�re base. */\r\n");
    buf.append("        /* Infiled fly est annonc�, mais la balle tombe dans la zone des fausses balles mais roule en zone des bonnes balles */\r\n");
    buf.append("        action { batter -> OBR8-3 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 0, 0);

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
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
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
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 024 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_024.JPG"/></td>
   * <td>If interference is called during an infield fly, the ball remains alive until it is determined whether the ball is fair or foul. Example 24: If fair,
   * both the runner who interfered with the fielder and the batter are out. [OBR Definition of Terms]</td>
   * </tr>
   * </table>
   */
  @Test
  public void example024() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_024") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le premier batteur frappe un hit dans le champs droit */\r\n");
    buf.append("        action { batter -> 1B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me bateyr frappe une cloche et l'infield fly est appell�. le d�feseur */\r\n");
    buf.append("        /* de la deuxi�me base laisse tomb�e la balle, a cause d'une interf�rnce du coureur en premi�re base. */\r\n");
    buf.append("        action { batter -> OBR8-4 , runner1 -> OBR13-4 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 1, 0, 0, 0);

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
    checkDefensivePlayerStat(statisticEngine, 4, 2, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 0, 1);
    checkGeneralDoublePlay(statisticEngine, 1);

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
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 025 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_025.JPG"/></td>
   * <td>If foul, even if caught, the runner is out and the batter returns to bat. [OBR Definition of Terms]</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example025() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_025") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un hit dans le champ droit */\r\n");
    buf.append("        action { batter -> 1B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /*  */\r\n");
    buf.append("        action { runner1 -> OBR13-4 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
