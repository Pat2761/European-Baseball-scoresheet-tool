package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Defense_Appeal_Test extends AbstractWBSCUnitTest {

  public WBSC_2016_Defense_Appeal_Test() {
    super();
  }

  /**
   * Defense : exemple 009 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_009.JPG"/></td>
   * <td>Runner on second base. The batter hits a single and the runner scores after having failed to touch third base. The left fielder catches the ball and
   * throws it to the third baseman, who tags the base in a natural course of the play. An assist should be credited to the left fielder and a putout to the
   * third baseman.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example009() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_009") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un double dans le champ centre */\r\n");
    buf.append("        action { batter -> 2B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit dans le champ gauche */\r\n");
    buf.append("        /* le coureur rejoint le marbre sans toucher la troisi�me base */\r\n");
    buf.append("        /* le d�fenseur du champ gauche renvoie la balle au d�fenseur de la troisi�me base qui fait appel */\r\n");
    buf.append("        /* L'appel est valid� par l'arbitre et le coureur etst retir� */\r\n");
    buf.append("        action { batter -> 1B7, runner2 -> A75 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 2, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 7, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 010 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_010.JPG"/></td>
   * <td>Runner on second base. The batter hits a single and the runner scores after having failed to touch third base. starts with the same initial situation
   * After the action has been completed, the pitcher walks out onto his mound then leaves it, throws the ball to the fielder on third who tags the base and
   * makes an appeal. There is a putout for the third baseman, an assist must be credited to the pitcher.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example010() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_010") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un double dans le champ centre */\r\n");
    buf.append("        action { batter -> 2B8 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit dans le champ gauche */\r\n");
    buf.append("        /* le coureur rejoint le marbre sans toucher la troisi�me base */\r\n");
    buf.append("        /* Avant le premier lanc�, le lanceur renvoie la balle au d�fenseur de la troisi�me base qui fait appel */\r\n");
    buf.append("        /* L'appel est valid� par l'arbitre et le coureur etst retir� */\r\n");
    buf.append("        action { batter -> 1B7, runner2 -> A15 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 0, 0, 2, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 2, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 011 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_011.JPG"/></td>
   * <td>With one out and bases loaded, the fourth batter hits a home run. Before the pitcher makes his pitch to the new batter, he throws the ball to the first
   * baseman who makes an appeal on first base on the grounds that the batter-runner missed first base. The appeal is sustained by the umpire and the batter is
   * called out. In consequence of the appeal play the run scored by the batter who hit the home run is disallowed, but the others, remain valid, along with the
   * advances.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example011() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_011") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc�, le coureur en 1 avance */\r\n");
    buf.append("        action { batter -> HP, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un homerun et fait rentrer tous les coureurs */\r\n");
    buf.append("        /* Il n'a pas touch� la premi�re base, le lanceur fait un appel en renvoyant la balle au d�fneseur de la premi�re base */\r\n");
    buf.append("        action { batter -> A13, runner1 -> +++, runner2 -> ++,, runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 3, 0, 1, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 012 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_012.JPG"/></td>
   * <td>With one out and bases loaded, the fourth batter hits a home run. The appeal play now is made on home plate. The appeal is sustained and the
   * batter-runner is called out on home plate. As a consequence of the appeal, the run scored by the batter who hit a home run is disallowed and he is credited
   * with a triple. The other three, remain valid</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example012() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_012") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc�, le coureur en 1 avance */\r\n");
    buf.append("        action { batter -> HP, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un homerun dans le champ droit et fait rentrer tous les coureurs */\r\n");
    buf.append("        /* Il n'a pas touch� la marbre, le lanceur fait un appel en renvoyant la balle au receveur */\r\n");
    buf.append("        action { batter -> 3B9 A12, runner1 -> +++, runner2 -> ++, runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 3, 0, 2, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 3, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 3);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 3, 0, 2, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 3, 0, 2, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 013 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_013.JPG"/></td>
   * <td>With two out and a runner on second base, the batter hits a home run. While running the bases, the batter runner misses first base. The home plate
   * umpire gives the new ball to the pitcher and before the first pitch is made to the next batter, the defending team appeals against the batter runner from
   * first base. The appeal is sustained and the batter-runner is called out on first base. The run scored by the runner who was on second base is therefore
   * disallowed.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example013() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_013") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une erreur de rattraper de fly du champs centre */\r\n");
    buf.append("        action { batter -> E8F }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 1 vole la deuxi�me base */\r\n");
    buf.append("        action { runner1 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me battter frappe un homerun, mais ne touche pas la premi�re base */\r\n");
    buf.append("        /* un jeu d'appel est fait et le batteur coureur est retir */\r\n");
    buf.append("        action { batter -> A13 }\r\n");
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
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkTotalOffensivStatistic(statisticEngine, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0);
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
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 014 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_014.JPG"/></td>
   * <td>With none or one out and bases loaded the batter hits the ball out of the park. In the manner provided by the OBR, the defense appeals against the
   * runner who was on third base for having failed to touch the home plate. The appeal is sustained and as a consequence the first run scored is disallowed and
   * the runner who had advanced is called out. As a consequence of this appeal play three runs are scored, all batted in by the batter who hit the home run.
   * The runners� advances are all legal. The consequences are similar when, with less than two out, any runner, with bases loaded, is called out on appeal for
   * having missed one of the bases after the one where he started.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example014() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_014") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc�, le coureur en 1 avance */\r\n");
    buf.append("        action { batter -> HP, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un homerun dans le champ droit et fait rentrer tous les coureurs */\r\n");
    buf.append("        /* Le coureur qui part de la base 3 ne touche pas le marbre */\r\n");
    buf.append("        /* Le lanceur fait appel en renvoyant la balle au receveur, le coureur est retir� */\r\n");
    buf.append("        action { batter -> O1+++, runner1 -> +++, runner2 -> ++, runner3 -> A12 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 3, 0, 1, 1, 1, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 015 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_015.JPG"/></td>
   * <td>With one out and bases loaded, the fourth batter hits a triple. The defense appeals against the runner who was on third base, for having failed to
   * touch home plate. The appeal is sustained, the first run scored is disallowed, and the lead runner is called out. As a consequence of this appeal play, the
   * number of runs scored is reduced to two, both of which were batted in by the batter who hit the triple. The advances made by the runners are all legal.
   * </td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example015() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_015") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc�, le coureur en 1 avance */\r\n");
    buf.append("        action { batter -> HP, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un triple dans le champ droit et fait rentrer tous les coureurs */\r\n");
    buf.append("        /* Le coureur qui part de la base 3 ne touche pas le marbre */\r\n");
    buf.append("        /* Le lanceur fait appel en renvoyant la balle au receveur, le coureur est retir� */\r\n");
    buf.append("        action { batter -> O1++, runner1 -> +++, runner2 -> ++, runner3 -> A12 }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 0, 1, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 016 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_016.JPG"/></td>
   * <td>With one out and bases loaded, the fourth batter hits a triple. The defense appeals against the runner who started from first base, for having failed
   * to touch home plate. The appeal is sustained and in consequence the final run scored is disallowed and the runner against whom the appeal was made is
   * called out. The effect of this appeal play is that the number of runs scored is reduced to two, both of which were batted in by the batter who hit the
   * triple. The advances made by the runners are all legal. The action of the batter-runner is recorded as a two-base hit, and an fielder�s choice to indicate
   * that he reached third base [OBR rule 9.06(b) Comment].</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example016() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_016") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc�, le coureur en 1 avance */\r\n");
    buf.append("        action { batter -> HP, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un triple dans le champ droit et fait rentrer les deux trois coureur */\r\n");
    buf.append("        /* Le coureur qui part de la base 1 ne touche pas le marbre */\r\n");
    buf.append("        /* Le d�fenseur du champ droit fait appel en renvoyant la balle au receveur, le coureur est retir� */\r\n");
    buf.append("        action { batter -> 2B9 O9, runner1 -> ++ A92, runner2 -> ++, runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 0, 2, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 1, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 9, 0, 1, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 1, 0);
    checkTotalCatcherSt(statisticEngine, 0, 1, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 017 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_017.JPG"/></td>
   * <td>With two out and runners on first and third, the batter hits a double, as a result of which both runners score. Before the next pitch is thrown, the
   * pitcher throws the ball to the third baseman and the defense appeals that the second runner has missed third base. The appeal is sustained and as a
   * consequence the runner is called out. Only the first run, which was batted in, is allowed, and the batter-runner is credited with a single. A fielder�s
   * choice is written to indicate that he reached second base.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example017() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_017") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur le champ centre, le coureur avance de deux bases */\r\n");
    buf.append("        action { batter -> 1B8, runner1 -> ++ }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur frappe un double sur le champs gauche */\r\n");
    buf.append("        /* Le coureur qui part de la base 1 ne touche pas la troisi�me base */\r\n");
    buf.append("        /* Le lanceur fait donc appel en relayant la balle au d�fenseur de la trois�me base, le coureur est retir� */\r\n");
    buf.append("        action { batter -> 1B7 O1, runner1 -> + A15, runner3 -> +}\r\n");
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
    checkGeneralStat(statisticEngine, 2, 1, 0, 2, 1, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 1, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 2, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 2, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 018 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_018.JPG"/></td>
   * <td>With two out and bases full, the batter hits a home run. Before the runner who was on first base can touch third, he is overtaken by the batter-runner,
   * who is called out by virtue of rule 5.09(b)(9) of the OBR. Two runs are nevertheless scored: the runner from first base is deemed to have reached second
   * safely and the batterrunner is credited with a double and an automatic putout.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example018() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_018") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 1 vole la deuxi�me base */\r\n");
    buf.append("        action { runner1 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc� */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un homerun dans le champ centre et fait rentrer les deux premier coureurs */\r\n");
    buf.append("        /* Le batteur coureur double le coureur venant de la une avant que celui-ci n'atteigne la troisi�me base */\r\n");
    buf.append("        /* L'exemple fournit par le document semble faut Le dernier batteur gagnerais la deuxi�me base alors qu'elle est occup�e */\r\n");
    buf.append("        action { batter -> 2B8 OBR11-5, runner1 -> ++ , runner2 -> ++, runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 2, 2, 0, 2, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0, 2);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 2, 0);
    checkTotalCatcherSt(statisticEngine, 0, 2, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 019 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_Defense_exemple_019.JPG"/></td>
   * <td>if, however, the batter-runner is called out before the second runner touches home plate, only one run is scored, as the second run would have been
   * scored after the third putout.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example019() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "DEFENSE_019") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur atteint la premi�re base sur une interf�rence du receveur */\r\n");
    buf.append("        action { batter -> INT }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me batteur frappe un hit sur la troisi�me base, le coureur avance */\r\n");
    buf.append("        action { batter -> 1B5, runner1 -> + }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 1 vole la deuxi�me base */\r\n");
    buf.append("        action { runner1 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le troisi�me batteur est touch� par un lanc� */\r\n");
    buf.append("        action { batter -> HP }\r\n");
    buf.append("\r\n");
    buf.append("        /* le quatri�me batteur frappe un homerun dans le champ centre et fait rentrer le premier coureur */\r\n");
    buf.append("        /* Le batteur coureur double le coureur venant de la une avant que celui-ci n'atteigne la troisi�me base */\r\n");
    buf.append("        /* L'exemple fournit par le document semble faut Le dernier batteur gagnerais la deuxi�me base alors qu'elle est occup�e */\r\n");
    buf.append("        action { batter -> 1B8 OBR11-5, runner1 -> + , runner2 -> +, runner3 -> + }\r\n");
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
    checkOffensivePlayerStat(statisticEngine, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 4, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 4, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 2, 0, 0, 1, 0);
    checkDefensivePlayerStat(statisticEngine, 5, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 1, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 4, 2, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 4, 2, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 2, 0);
    checkTotalCatcherSt(statisticEngine, 0, 2, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
