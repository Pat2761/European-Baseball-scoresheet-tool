package org.bpy.score.engine.tests;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.tests.CommonResources;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Test;

public class WBSC_2016_Pitcher_Not_Earned_For_Team extends AbstractWBSCUnitTest {

  public WBSC_2016_Pitcher_Not_Earned_For_Team() {
    super();
  }

  /**
   * Pitcher : exemple 034 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_034.JPG"/></td>
   * <td>The first batter hits a fly ball and is put out by the left fielder. The next batter reaches second base safely on a catching error by the center
   * fielder. The third batter hits a single to the right field, sending the runner to third base. The fourth batter hits a sacrifice fly that enables the
   * runner on third to score the first run (the runner on first base stays put). After a pitching change, the fifth batter hits a home run that brings in two
   * runs. The first pitcher is charged with two unearned runs (there had been three fielding chances at the time the home run was hit: ‘F7’, ‘E8F’ and ‘SF8’).
   * The second pitcher is charged with one earned run (only two fielding chances were transferred by the previous pitcher: ‘F7’ and ‘SF8’). The team is charged
   * with three runs, none of which is earned, as the team had three fielding chances: ‘F7’, ‘E8F’ and ‘SF8’. This example shows that the third run is a run
   * unearned against the team, but earned against the pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example034() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_034") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est retiré sur un fly dans le champ gauche */\r\n");
    buf.append("        action { batter -> F7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une erreur du champ centre et profite de l'erreur pour prendre la deuxième base */\r\n");
    buf.append("        action { batter -> E8F+ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit, le coureur avance d'une base */\r\n");
    buf.append("        action { batter -> 1B9 , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un sacrifice fly , le coureur marque le point */\r\n");
    buf.append("        action { batter -> SF8 , runner3 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un home run, deux points sont marqués */\r\n");
    buf.append("        action { batter -> HR8 unEarnedForTeam , runner1 -> +++ }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 3, 1, 2, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 3, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 7, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 8, 1, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 3, 2, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 3, 1, 2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 036 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_036.JPG"/></td>
   * <td>With two out, i.e. with two fielding chances, there is a base on balls followed by an error. This error constitutes the third fielding chance for the
   * first pitcher, who therefore cannot be charged with any further earned runs. The relief pitcher, on the other hand, does not benefit from the failed
   * putout. Consequently, the home run, which is charged to the relief pitcher, is earned against the pitcher but unearned against the team.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example036() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_036") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est retiré sur une frappe au sol */\r\n");
    buf.append("        action { batter -> 63 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un  'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur sur une ereur de réception du première base, le coureur avane sur l'erreur */\r\n");
    buf.append("        action { batter -> 6E3 , runner1 -> (4) }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteyr frappe un home run */\r\n");
    buf.append("        action { batter -> HR8 unEarnedForTeam, runner1 -> +++ , runner2 -> ++ }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 3, 1, 1, 2, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 3, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 2, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 3, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 3, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 037 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_037.JPG"/></td>
   * <td>With two out, there follow two bases on balls, after which the pitcher is relieved. An error is committed against the next batter. This error
   * constitutes the third fielding chance for the relief pitcher, who can also count the two putouts. But it is also the third fielding chance for the first
   * pitcher, as the relief pitcher cannot count failed putouts, although the replaced pitcher can. From this moment, therefore, no runs charged to either the
   * first or the second pitcher can be earned. Thus, with the subsequent home run, two runs are charged to the first pitcher and two to the second, although
   * none are earned.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example037() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_037") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur est retiré sur une frappe au sol */\r\n");
    buf.append("        action { batter -> 63 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur est retiré sur un fly dans le champ centre */\r\n");
    buf.append("        action { batter -> F8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur 'base on ball, le coureur avance */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une rreur de relance du 6, les deux coureurs avancent sur l'erreur */\r\n");
    buf.append("        action { batter -> E6T , runner1 ->(5) , runner2 ->(5) }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un home run, tous les coureur rentre */\r\n");
    buf.append("        action { batter -> HR7, runner1 -> +++, runner2 -> ++, runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 4, 0, 1, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4);
    checkTotalOffensivStatistic(statisticEngine, 6, 4, 4, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 4);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 8, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 2, 2, 2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 6, 4, 4, 0, 1, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 038 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_038.JPG"/></td>
   * <td>In this inning, after a putout, with the batterrunner on first base because of an error, the third batter is awarded a base on balls. The fourth batter
   * reaches first base safely on a fielder’s choice, as on the hit the pitcher tried unsuccessfully to put out the runner heading for second. Bearing in mind
   * that fielder’s choice is not a fielding chance, the runs by the third, fourth and fifth batters are earned runs, both for the team and the relief pitchers,
   * because team and pitchers only have two and one fielding chances respectively at this moment.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example038() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_038") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur une arreur de deuxième base */\r\n");
    buf.append("        action { batter -> E4 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur arrive sur base sur un choix défensif */\r\n");
    buf.append("        action { batter -> FC14 , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un home run */\r\n");
    buf.append("        action { batter -> HR8 earned, runner1 -> +++ earned , runner2 -> ++ earned , runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 4, 3, 1, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 4, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 4);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 3, 3, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 4, 3, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 039 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_039.JPG"/></td>
   * <td>In this inning, after a base on balls, there is an error, which constitutes the first and only fielding chance for the first pitcher, who is then
   * relieved. The relief pitcher therefore begins with no fielding chances to his credit. He gives up a three-run home run: the first two runs are charged to
   * the first pitcher, and only the first is earned, as the second was compromised by an error. The home run itself is charged to the second pitcher, and is an
   * earned run. The inning continues with two strikeouts, after which there is another error. This is the third fielding chance for the second pitcher, and
   * thus no runs charged against him from this moment on are earned.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example039() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_039") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arriv sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une erreur de rattrapé de fly */\r\n");
    buf.append("        action { batter -> E8F , runner1 -> (2) }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un hoem run */\r\n");
    buf.append("        action { batter -> HR7 earned, runner1 -> +++ , runner2 -> ++ earned }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur arrive sur base sur une erreur de l'arrêt court */\r\n");
    buf.append("        action { batter -> E6 }\r\n");
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
    checkGeneralStat(statisticEngine, 5, 3, 2, 1, 0, 2, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 6, 5, 3, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 2, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 2, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 4, 4, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0);
    checkTotalPitchStat(statisticEngine, 6, 5, 3, 2, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 040 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_040.JPG"/></td>
   * <td>The first batter reaches first base on an error. The pitcher is replaced. The second batter is awarded a base on balls and the third hits a ground ball
   * to the shortstop who assists the third baseman in putting out the lead runner, while the others reach base safely. Finally, the fourth batter hits a safe
   * hit, sending the second runner home. The run is charged to the first pitcher but is not earned because of the batter reaching first base on the error.
   * When, after a pitcher change, a batted ball results in a putout of a runner, both for the batter as well as any other runner an occupied shall be written.
   * </td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example040() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_040") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur eune erreur du défenseur de la troisième base */\r\n");
    buf.append("        action { batter -> E5 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le bateeur arrive sur base sur un choix défensif de l'arrêt court */\r\n");
    buf.append("        action { batter -> O6, runner1 -> O6 , runner2 -> 65 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simplpe dans le champ droit */\r\n");
    buf.append("        action { batter -> 1B9, runner1 -> ++ , runner2 -> ++ }\r\n");
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
    checkGeneralStat(statisticEngine, 3, 1, 0, 1, 1, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 3, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 3, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 3, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 041 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_041.JPG"/></td>
   * <td>The first batter reaches first base on an error. The second is awarded a base on balls and the pitcher is replaced. The third batter hits a safe hit,
   * filling the bases. The fourth batter hits a ground ball to the third baseman who throws an assist to home base, putting out the first runner. The fifth
   * batter hits a ground ball to shortstop who throws an assist to home base, putting out the second runner. The sixth batter hits a four-run home run, and the
   * inning finally ends with the seventh batter being struck out. The first pitcher should be charged with two runs, as he was replaced with two men on base.
   * The runs in question are the first two, and they are indicated by the occupied ball notation.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example041() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_041") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur arrive sur base sur une erreur de lancer de l'arrêt court */\r\n");
    buf.append("        action { batter -> E6T }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 , runner1 -> + , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur un choixx defensif */\r\n");
    buf.append("        action { batter -> O5, runner1 -> O5 , runner2 -> O5 , runner3 -> 52 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant arrive sur base sur un choixx defensif */\r\n");
    buf.append("        action { batter -> O6, runner1 -> O6 , runner2 -> O6 , runner3 -> 62 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant frappe un home run */\r\n");
    buf.append("        action { batter -> HR7 unEarnedForTeam , runner1 -> +++ unEarnedForTeam , runner2 -> ++ , runner3 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est retiré sur strike out */\r\n");
    buf.append("        action { batter -> KL }\r\n");
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
    checkGeneralStat(statisticEngine, 6, 4, 2, 2, 2, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 6, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4);
    checkOffensivePlayerStat(statisticEngine, 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkTotalOffensivStatistic(statisticEngine, 7, 6, 4, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 4);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 5, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 3, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 3, 2, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 5, 5, 2, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 7, 6, 4, 2, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 042 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_042.JPG"/></td>
   * <td>The runner on second base would not have been able to advance if the game had been played correctly, so for the purposes of calculating earned runs he
   * should be considered as being on first base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example042() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_042") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ gauche et profite de l'erreur pour gagner une base suplémentiare */\r\n");
    buf.append("        action { batter -> 1B7 e7 }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 0, 0, 1, 0, 1, 1);

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
    checkDefensivePlayerStat(statisticEngine, 7, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
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
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 043 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_043.JPG"/></td>
   * <td>The first batter hits to the right field and, thanks to an error by the outfielder, reaches third base. The second batter walks and goes on to steal
   * second base. The third batter hits to the left field, enabling both runners to score. Up to this moment, the first run is earned, but not the second, since
   * if it had not been for the outfielder’s error, the lead runner would have remained on second base, thus removing from the other runner any possibility of
   * stealing, and the third batter’s safe hit would have sent home only the first runner, while the second runner would have stopped at third base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example043() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_043") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ droit et profite de l'erreur pour gagner deux bases suplémentiares */\r\n");
    buf.append("        action { batter -> 1B9 e9+ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coueeeeur en 1 vole la base */\r\n");
    buf.append("        action { runner1 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une simple dans le champ gauche, les deux coureurs marquent */\r\n");
    buf.append("        action { batter -> 1B7 , runner2 ->  ++ , runner3 -> + earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 1, 2, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 2);

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
    checkPitcherStat(statisticEngine, 1, 3, 2, 2, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 2, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 044 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_044.JPG"/></td>
   * <td>The first batter is awarded a base on balls and reaches second base on an error when the first baseman attempts to pick him off. The second batter
   * reaches first on a wild pitch after having swung at the third strike, and the runner reaches third base. The third batter hits a home run. The first and
   * third runs are earned, but not the second, because if it had not been for the fielding error on the first runner, first base was occupied and the second
   * batter would have been called out under rule 5.09(a)(3) of the OBR.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example044() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_044") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur gagne la première base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur gagne la deuxième base sur 'pick off' raté */\r\n");
    buf.append("        action { runner1 -> PO1e3 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un troisième strike relaché */\r\n");
    buf.append("        action { batter -> KSWP , runner2 -> wp }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un home run */\r\n");
    buf.append("        action { batter -> HR7 earned , runner1 -> +++ , runner3 -> + earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 3, 2, 1, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 3, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 3, 2, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 3, 2, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 045 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_045.JPG"/></td>
   * <td>With a man on second base due to an error, a safe hit to the center fielder enables him to score, while the batterrunner reaches second base on the
   * throw to home base. If the play had been legal, the first runner would not have been where he was, so the center fielder would not have thrown to home base
   * and the batter would have remained on first base. On the next hit another run is scored, which for the time being is unearned since the runner, after
   * having advanced two bases, would have been on third base. We therefore recommend reconstructing the action carefully to determine whether an advance is
   * legal or not. In this respect it can be helpful to reconstruct an imaginary inning, only with legal advances, excluding all advances because of errors or
   * passed balls.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example045() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_045") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur une erreur sur une fly et progite de l'erreur pour gangner une base supplémentaire */\r\n");
    buf.append("        action { batter -> E9F+ }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ cnetre et profite du relai pour ganger la 2, le coureur marque */\r\n");
    buf.append("        action { batter -> 1B8 T82 , runner2 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ gauche, le coureur marque */\r\n");
    buf.append("        action { batter -> 1B7 , runner2 -> ++ }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 2, 0, 2, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 9, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 4, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 4, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 046 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_046.JPG"/></td>
   * <td>In this situation we see the action as it occurred. We have an indication of what would have happened with legal play: the second batter would not yet
   * have scored, but would have stopped at third base. With this method it is possible to see clearly that if a runner had scored through legal play, the
   * corresponding run in the real action would be earned, even if the play had been illegal. If not, a run actually scored would be unearned.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example046() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_046") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le bztteur est retiré sur une fly */\r\n");
    buf.append("        action { batter -> F9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ centre */\r\n");
    buf.append("        action { batter -> 1B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur est strike out */\r\n");
    buf.append("        action { batter -> KS }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un siloke dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7, runner1 -> ++ }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 0, 0, 2, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 4, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 9, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 047 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_047.JPG"/></td>
   * <td>With a runner on first base, the first baseman muffs a foul fly on an easy hit and an error is therefore noted in the first base square. The second
   * batter hits a home run. The second run cannot be earned in any circumstances. In order to determine whether the first run is earned, we have to wait for
   * the subsequent turns at bat, as in the reconstruction of the inning the first batsman should be considered as being still on first base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example047() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_047") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ gauche */\r\n");
    buf.append("        action { batter -> 1B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur aurait du être retiré sur une fly dans les fausses balles */\r\n");
    buf.append("        action { batter -> EF3 }\r\n");
    buf.append("\r\n");
    buf.append("        /* La batteur frappe un home run dans le champ centre */\r\n");
    buf.append("        action { batter -> HR8 , runner1 -> +++ }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 0, 2, 0, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 3, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 2, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 2, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

}
