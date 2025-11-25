package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Advance_On_Caught_Stealing extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Advance_On_Caught_Stealing() {
    super();
  }

  /**
   * Defense : exemple 097 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_097.JPG"/></td>
   * <td>The runner on first is caught stealing by an assist from the catcher to second base, while player three of the batting order is at bat.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example097() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_097") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur l'arr�t court */\r\n");
    buf.append("        action { batter -> 1B6 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le tente de voler la deuxi�me mais se fait retirer */\r\n");
    buf.append("        action { runner1 -> CS24 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
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
    checkCatcherStat(statisticEngine, 1, 0, 0, 1);
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 098 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_098.JPG"/></td>
   * <td>The runner on first base is picked off by an accurate throw by the pitcher. He consequently tries to advance, but he is put out by the second baseman
   * on an assist by the first baseman. Assists are credited to the pitcher and the first baseman, and a putout is credited to the second baseman. In this case,
   * no caught stealing is credited to the catcher but to the pitcher. Write the name of the pitcher in a colored row of the catcher box and put a vertical
   * stroke behind this name. By doing this the sum of the stolen bases will be the same as the sum of stolen bases in the offense information.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example098() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_098") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur l'arr�t court */\r\n");
    buf.append("        action { batter -> 1B6 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le tente de voler la deuxi�me mais se fait retirer */\r\n");
    buf.append("        action { runner1 -> CS134 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 2, 0, 0);
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
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 099 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_099.JPG"/></td>
   * <td>The runner on first base is picked off by an accurate throw by the pitcher. He consequently tries to advance, but he is put out by the second baseman
   * on an assist by the first baseman. Assists are credited to the pitcher and the first baseman, and a putout is credited to the second baseman. In this case,
   * no caught stealing is credited to the catcher but to the pitcher. Write the name of the pitcher in a colored row of the catcher box and put a vertical
   * stroke behind this name. By doing this the sum of the stolen bases will be the same as the sum of stolen bases in the offense information.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example099() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_099") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur l'arr�t court */\r\n");
    buf.append("        action { batter -> 1B6 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le tente de voler la deuxi�me mais se fait retirer */\r\n");
    buf.append("        action { runner1 -> CS1363 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 3, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 3, 0, 0);
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
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 100 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_100.JPG"/></td>
   * <td>When the runner returns to first base safely due to a catching error of the first baseman, we have to write the error as it prolongs the presence of
   * the runner on base [OBR 9.12]. Assist will be credited to the pitcher, the first baseman and the shortstop and an error is credited to the first baseman as
   * well. Credit the Caught Stealing to the pitcher.
   * 
   * </td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example100() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_100") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit sur l'arr�t court */\r\n");
    buf.append("        action { batter -> 1B6 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur tente de voler la deuxi�me base mais aurait du se faire retirer si un d�fenseur n'avait pas commit d'erreur */\r\n");
    buf.append("        action { noAdvance on runner1 -> CS136E3 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 3, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 3, 1, 0);
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
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 101 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_101.JPG"/></td>
   * <td>ATTENTION: If a runner tries to steal home base and is put out by the catcher, catching a regular pitch by the pitcher, the pitcher is not credited
   * with an assist.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example101() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_101") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un triple sur le champ centre */\r\n");
    buf.append("        action { batter -> 3B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur tente de voler le marbre mais se fait retirer par le receveur */\r\n");
    buf.append("        action { runner3 -> CS2 }\r\n");
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
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 1);
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 102 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_102.JPG"/></td>
   * <td>The pitcher, realizing the runner�s intention in time, gets down from the plate and throws to the catcher. He is credited with an assist. The scorer
   * must therefore pay close attention to the behavior of the pitcher where there is an attempt to steal home base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example102() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_102") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un triple sur le champ centre */\r\n");
    buf.append("        action { batter -> 3B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur tente de voler le marbre mais se fait retirer par le receveur */\r\n");
    buf.append("        action { runner3 -> CS12 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 1);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

/**
 * Defense : exemple 103 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_103.JPG"/>
 *      </td>
 *      <td>With runners on first and second, there is a
double steal. The catcher plays for the runner on third, but as
the third baseman muffs the throw, the runner is safe on third
base. Credit an assist for the catcher and an error for the third
baseman on the caught stealing play for the runner from
second to third and a fielder�s choice to the runner from first
to second.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example103() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_103") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premoer batter frappe un hit dans le champ gauche */\r\n");
  buf.append("        action { batter -> 1B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le second batteur gagne une base sur 'Hit by pitch', le coureur avance */\r\n");
  buf.append("        action { batter -> HP, runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* les deux coureur volent une base, mais un des deux aurait du se faire retirer */\r\n");
  buf.append("        action { runner1 -> O/2 , runner2 -> CS2E5 }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 0, 0, 1, 1, 1, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 5, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 1, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 0, 1);
  checkTotalCatcherSt(statisticEngine, 0, 0, 1);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 104 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_104.JPG"/>
 *      </td>
 *      <td>With runners on first and second, the runner
from second is stealing third base. The catcher makes a good
throw, but the third baseman muffs the throw. Seeing the
third baseman making an error, the runner from first decides
to advance to second base (so not simultaneously with the
runner from second). Credit an assist for the catcher and an
error for the third baseman on the caught stealing for the
runner to third and place the number of the batting order for
the lead runner in parentheses in the second base square of the latter
runner.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example104() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_104") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premoer batter frappe un hit dans le champ gauche */\r\n");
  buf.append("        action { batter -> 1B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le second batteur gagne une base sur 'Hit by pitch', le coureur avance */\r\n");
  buf.append("        action { batter -> HP, runner1 -> + }\r\n");
  buf.append("\r\n");
  buf.append("        /* un coureur vole une base, mais aurait du se faire retirer, le deuxi�me profite de l'erreur pour avancer */\r\n");
  buf.append("        action { runner1 -> (1) , runner2 -> CS2E5 }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 0, 0, 1, 1, 1, 2);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 5, 0, 0, 1, 0);
  checkTotalDefensivesStatist(statisticEngine, 0, 1, 1, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 0, 1);
  checkTotalCatcherSt(statisticEngine, 0, 0, 1);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 105 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_105.JPG"/>
 *      </td>
 *      <td> With a runner on first base, the batter tries for a
sacrifice bunt and fails to contact the ball. The runner, who
had already begun to run for second base, tries to return but is
put out on an assist by the catcher. In this case also, the reason
for the caught stealing should be recorded in the notes.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example105() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_105") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* Le premier batteur gagne la premi�re base sur un 'base on ball' */\r\n");
  buf.append("        action { batter -> BB }\r\n");
  buf.append("\r\n");
  buf.append("        /* Le coureur en 1 se fait retirer en tentant de voler une base */\r\n");
  buf.append("        action { runner1 -> CS24 }\r\n");
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
  checkGeneralStat(statisticEngine, 0, 0, 0, 0, 1, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0);
  
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check defensive statisitics                                                                                             */
  /*                                    player, po,  a, e, dp                                                                */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkDefensivePlayerStat(statisticEngine, 2, 0, 1, 0, 0);
  checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
  checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
  checkGeneralDoublePlay(statisticEngine, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check pitcher statisitics                                                                                               */
  /*                                player, bf, ab,  r, er,  h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io,  k, wp, bk                      */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkPitcherStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 0, 1);
  checkTotalCatcherSt(statisticEngine, 0, 0, 1);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 106 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_106.JPG"/>
 *      </td>
 *      <td>A runner on first base, after being surprised by a
pick-off, starts to advance to second base, which is seen as an
attempt to steal. With an unquestionable opportunity for the
defensive to put out the runner, the pitcher makes a bad
throw which cannot be caught by the first baseman. As a result the runner
reaches second base safely
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example106() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_106") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* le premier batter frappe un hit en champ gauche */\r\n");
  buf.append("        action { batter -> 1B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* le coureur vole la deuxi�me base, il n'est pas retir� � cause d'une erreur */\r\n");
  buf.append("        action { runner1 -> CSE1T }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 0, 1);
  checkTotalCatcherSt(statisticEngine, 0, 0, 1);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

/**
 * Defense : exemple 107 <br>
 * 
 * <table>
 *   <tr>
 *      <td>
 *        <img src="./resources/WBSC_2016_offense_exemple_107.JPG"/>
 *      </td>
 *      <td>n case the runner starts to advance to second
base, but returns to first base safely, we still have to write the
error since it prolongs the time on base for that runner. Write
the error between first and second base.
 *      </td>
 *   </tr>
 * </table>  
 * 
 */
@Test
public void example107() {
  
  StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_107") + "\r\n");
  buf.append("\r\n");
  buf.append("        /* le premier batter frappe un hit en champ gauche */\r\n");
  buf.append("        action { batter -> 1B7 }\r\n");
  buf.append("\r\n");
  buf.append("        /* le coureur tente de voler la deuxi�me base, il n'est pas retir� � cause d'une erreur, mais il n'avance pas */\r\n");
  buf.append("        action { noAdvance on runner1 -> CSE1T }\r\n");
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
  checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 1, 1);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check offensive statisitics                                                                                             */
  /*                                        player, pa, ab,  r,  h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  checkTotalOffensivStatistic(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
  
  
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
  checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  checkTotalPitchStat(statisticEngine, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  
  /* ----------------------------------------------------------------------------------------------------------------------- */
  /* Check catcher statisitics                                                                                               */
  /*                                 pb, sb, cs                                                                              */
  /* ----------------------------------------------------------------------------------------------------------------------- */
  checkCatcherStat(statisticEngine, 1, 0, 0, 1);
  checkTotalCatcherSt(statisticEngine, 0, 0, 1);
  
  /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
  
}

  
}
