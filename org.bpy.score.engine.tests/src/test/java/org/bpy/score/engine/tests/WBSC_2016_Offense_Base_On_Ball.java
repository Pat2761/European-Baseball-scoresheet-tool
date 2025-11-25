package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Base_On_Ball extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Base_On_Ball() {
    super();
  }

  /**
   * Defense : exemple 020 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_020.JPG"/></td>
   * <td>In the example 20 given here, this is the fourth base on balls conceded by the same pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example020() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_020") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + , runner2 -> + , runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 0, 1, 0, 0, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 1);

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
    checkPitcherStat(statisticEngine, 1, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0);

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
   * <td><img src="./resources/WBSC_2016_offense_exemple_021.JPG"/></td>
   * <td>the award of a base on balls to the batter (the third to the plate) forced the two runners on base to advance.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example021() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_021") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe une balle roulante vers l'arr�t court.  */\r\n");
    buf.append("        /* Le d�fenseur relance mal la balle  */\r\n");
    buf.append("        action { batter -> E6T , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + , runner2 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 0, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

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
    checkPitcherStat(statisticEngine, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
