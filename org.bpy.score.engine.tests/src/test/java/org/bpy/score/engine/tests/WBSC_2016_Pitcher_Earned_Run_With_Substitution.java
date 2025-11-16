package org.bpy.score.engine.tests;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.tests.CommonResources;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Test;

public class WBSC_2016_Pitcher_Earned_Run_With_Substitution extends AbstractWBSCUnitTest {

  public WBSC_2016_Pitcher_Earned_Run_With_Substitution() {
    super();
  }

  /**
   * Pitcher : exemple 025 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_025.JPG"/></td>
   * <td>The starting pitcher leaves one runner on base when he is relieved. The next batter hits a single to right field and the previous runner scores. As a
   * rule, to which there are no exceptions, the runners left on base by a pitcher belong to the starting pitcher. For this reason, the run is charged to the
   * first pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example025() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_025") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un simple dans le champ centre */\r\n");
    buf.append("        action { batter -> 1B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit, le coureur marque */\r\n");
    buf.append("        action { batter -> 1B9 , runner1 -> +++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 1, 2, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);

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
    checkPitcherStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 026 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_026.JPG"/></td>
   * <td>The first pitcher leaves one runner on base, and he is put out after the pitcher is relieved by a normal action as a result of a batted ball. Given
   * that the first pitcher left one runner on base, he must be charged with a run. We have here the two fundamental conditions: an occupied ball and the putout
   * of a runner put on base by the first pitcher. The run is therefore charged to the first pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example026() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_026") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une sur l'arrêt qui fait le choix de retirer le coureur' */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> 64 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un double dans le champ droit */\r\n");
    buf.append("        action { batter -> 2BRC , runner1 -> +++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 1, 1, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 2, 2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 027 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_027.JPG"/></td>
   * <td>In this example, the second baseman failed to put out the runner. As the second run cannot be charged to the first pitcher, as he would in that case be
   * charged with two runs, despite having left only one runner on base, the fielding chance (6E4) is transferred to the second pitcher (in place of the ‘O6’).
   * The first run is therefore earned and the second is unearned.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example027() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_027") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une sur l'arrêt qui fait le choix de retirer le coureur' */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> 6E4 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un double dans le champ droit */\r\n");
    buf.append("        action { batter -> 2BRC , runner1 -> +++ , runner2 -> ++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 1, 1, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 2, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 0, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 0, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 2, 2, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 2, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 028 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_028.JPG"/></td>
   * <td>The first pitcher leaves one runner on base. The runner is picked off base, i.e. the putout is not due to an action by the batter. The first pitcher is
   * therefore not charged with any runs, and the run is consequently charged to the relief pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example028() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_028") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un double dans le champ centre */\r\n");
    buf.append("        action { batter -> 2B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur suivant gagne la première base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en deux est retiré sur un pick off */\r\n");
    buf.append("        action { runner2 -> PO16 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un double dans le champ droit, le couteur marque */\r\n");
    buf.append("        action { batter -> 2B8 , runner1 -> +++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 1, 2, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 2, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 029 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_029.JPG"/></td>
   * <td>The first pitcher leaves one runner on base, who is subsequently put out trying to advance on a hit. The author of the hit reaches second and
   * subsequently scores. The run is charged to the second pitcher as the runner put on base by the first pitcher was put out by his own fault and not by the
   * fault of the batter.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example029() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_029") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteru arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ centre et profite d'une relai du 8 pour gagner la deuxième */\r\n");
    buf.append("        action { batter -> 1B8 T85 , runner1 -> + 85 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit et lecoureur marque un point */\r\n");
    buf.append("        action { batter -> 1B9 , runner2 -> ++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 1, 2, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 2, 2, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 1, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 030 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_030.JPG"/></td>
   * <td>The first and second pitchers both leave one runner on base when they are relieved, and must therefore be charged with one run each. The first runner
   * is put out on a batted ball, likewise the second, while the batter-runners reach base safely on an occupied ball. The fifth batter hits a home run to the
   * right field. A run is charged to each pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example030() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_030") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteru arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ centre, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B8 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"POTIER Nicolas\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle sur l'arrêt court qui fait le choix de retirer le premier coureur */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> O6 , runner2 -> 65 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle sur le laceur qui fait le choix de retirer le premier coureur */\r\n");
    buf.append("        action { batter -> O1 , runner1 -> O5 , runner2 -> 15 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un home run, tout le monde marque un point */\r\n");
    buf.append("        action { batter -> HR9 earned, runner1 -> +++ earned, runner2 -> ++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 3, 3, 2, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 3, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 2, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 2, 0, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 3, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 3, 3, 3, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 3, 3, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 031 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_031.JPG"/></td>
   * <td>The first pitcher leaves one runner on base. He must be charged with one run. During the play in which the runner put on base by the first pitcher is
   * put out, the other runners reach base safely because the ball is occupied. Two runs are then scored. The first run is charged to the first pitcher, while
   * the second is charged to the second pitcher. Indeed, the first pitcher may be charged with only one run as he left only one man on base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example031() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_031") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteru arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteru arrive sur base sur un 'base on ball', le coureur avance */\r\n");
    buf.append("        action { batter -> BB, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle vers l'arrêt court qui fait le choix de retirer le coureur le plus avancé */\r\n");
    buf.append("        action { batter -> O6 , runner1 -> O6 , runner2 -> 65   }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle dans le champ centre, les deux coureur rentre */\r\n");
    buf.append("        action { batter -> 2B8 , runner1 -> +++ earned, runner2 -> ++ earned  }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 2, 1, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 2, 1, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 3, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 2, 2, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 032 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_032.JPG"/></td>
   * <td>Both the first and second pitchers leave one runner on base. The runner on first base, who was put there by the second pitcher, is put out on a ground
   * ball by the third batter. The preceding runner is put out on a batted ball by the fourth batter. The next home run hit brings in three runs, all earned.
   * Each pitcher is charged with one run</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example032() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_032") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur arrive sur base sur un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ centre, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B8 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"POTIER Nicolas\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle sur la deuxième base qui fait le choix de retirer le premier coureur */\r\n");
    buf.append("        action { batter -> O4 , runner1 -> 46 , runner2 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe une balle sur le laceur qui fait le choix de retirer le coureur qui arrive au mrbre */\r\n");
    buf.append("        action { batter -> O1 , runner1 -> O1 , runner3 -> 12 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un home run, tout le monde marque un point */\r\n");
    buf.append("        action { batter -> HR9 earned, runner1 -> +++ earned, runner2 -> ++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 3, 3, 2, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 5, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 5, 4, 3, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 4, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 6, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 2, 0, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 3, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 3, 3, 3, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 5, 4, 3, 3, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

  /**
   * Pitcher : exemple 033 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_pitcher_exemple_033.JPG"/></td>
   * <td>The first pitcher leaves one runner on base when he is substituted. The batter on the second pitcher is put out. A third pitcher climbs the mound. The
   * first runner is put out on a batted ball, while the batter-runner reaches base safely on an occupied ball. The fourth batter hits a home run to the right
   * field. An earned run is charged to the first and the third pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example033() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "PITCHER_Exemple_033") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe un simple dans le champ droit */\r\n");
    buf.append("        action { batter -> 1B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"CAMBUZAT Valerian\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le batteur frappe est reité sur une bale au sol, le coureur avance */\r\n");
    buf.append("        action { batter -> 43 , runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Remplacement du lanceur */ \r\n");
    buf.append("        substitution hometeam {\r\n");
    buf.append("           player 1 replaceBy \"POTIER Nicolas\" shirtNumber=32 at 1\r\n");
    buf.append("        }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteyr frappe un balle vers l'arrêt court qui fait un choix defensif en retirant tle coueur */\r\n");
    buf.append("        action { batter -> O6 , runner2 -> 65 }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe un home run n */\r\n");
    buf.append("        action { batter -> HR9 earned , runner1 -> +++ earned }\r\n");
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
    checkGeneralStat(statisticEngine, 4, 2, 2, 2, 2, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 4, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 6, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 2, 2, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkPitcherStat(statisticEngine, 3, 2, 2, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 4, 2, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean à vrai si le résultat attenedu est conforme à l'image défini dans le commentaire ci dessus */
    
  }

}
