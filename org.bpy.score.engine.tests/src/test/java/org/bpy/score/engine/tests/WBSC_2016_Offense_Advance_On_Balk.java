package org.bpy.score.engine.tests;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.tests.CommonResources;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Test;

public class WBSC_2016_Offense_Advance_On_Balk extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Advance_On_Balk() {
    super();
  }

  /**
   * Defense : exemple 044 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_044.JPG"/></td>
   * <td>The abbreviation used for an advance on a balk is “BK” followed by the batting order number of the player at bat at the time of the balk. If there is
   * more than one runner on base, “BK” (upper case) is used for the lead runner and “bk” (lower case) for the subsequent runners.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example044() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_044") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un hit dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant gagne la première base sur un 'base on ball', le coureur avance */\r\n");
    buf.append("        action { batter -> BB , runner1 -> +}\r\n");
    buf.append("\r\n");
    buf.append("        /* Le lanceur fait un balk, les deux coureurs avance */\r\n");
    buf.append("        action { runner1 -> bk, runner2 -> BK }\r\n");
    buf.append("\r\n");
    buf.append(CommonResources.ENDING_GAME);
    

    IParseResult parserResult = parser.parse(new StringReader(buf.toString()));
    assertNotNull("Parser result can't be null", parserResult);
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
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1);
    checkTotalPitchStat(statisticEngine, 2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

}
