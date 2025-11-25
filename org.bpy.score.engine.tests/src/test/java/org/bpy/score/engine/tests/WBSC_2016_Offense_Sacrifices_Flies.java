package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.StringReader;

import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.stats.StatisticManager;
import org.bpy.score.game.game.Game;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.jupiter.api.Test;

public class WBSC_2016_Offense_Sacrifices_Flies extends AbstractWBSCUnitTest {

  public WBSC_2016_Offense_Sacrifices_Flies() {
    super();
  }

  /**
   * Defense : exemple 015 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_015.JPG"/></td>
   * <td>A high ball to the center field becomes a sacrifice fly as it allows the runner on third base to score. Obviously, the runner on third waited until the
   * ball had been caught before leaving the base, otherwise he would have been called out on appeal and cancelled out the sacrifice fly.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example015() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_015") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un triple dans le champ droit */\r\n");
    buf.append("        action { batter -> 3BRC }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le frappeur frappe une fly ans le champs centre qui est rattrap�e de vol� par le d�fenseur, le coureur marque le point */\r\n");
    buf.append("        action { batter -> SF8 , runner3 -> + }\r\n");
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
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 016 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_016.JPG"/></td>
   * <td>Sacrifice fly to the left fielder, who drops the ball. As you can see, the advance by the runner to home base is annotated with the batting order
   * number of the player who hit the sacrifice fly. Even though there has been an error which allows the batter-runner to occupy first base, the batter-runner
   * is not charged with a time at bat.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example016() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_016") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un double dans le champs gauche */\r\n");
    buf.append("        action { batter -> 2B7 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le coureur en 2 vole la troisi�me base */\r\n");
    buf.append("        action { runner2 -> SB }\r\n");
    buf.append("\r\n");
    buf.append("        /* le batteur frappe une fly dans le champs. Le d�fenseur commet un erreur en rattrapant la balle, le coureur marque le point */\r\n");
    buf.append("        action { batter -> SFE7 , runner3 -> +}\r\n");
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
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 0, 1, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1);

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
    checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

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
   * <td><img src="./resources/WBSC_2016_offense_exemple_017.JPG"/></td>
   * <td>A sacrifice fly also occurs when the ball is hit into foul territory in the outfield. Indeed, a catch by an outfielder in foul territory puts the
   * runners back into play, and they may try to advance. The abbreviation �FSF� is used to designate a sacrifice fly in foul territory.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example017() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_017") + "\r\n");
    buf.append("\r\n");
    buf.append("        /* Le premier batteur frappe un triple dans le champ droit */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append(
        "        /* le deuxi�me frappeur frappe une fly dans le champ droit dans la zone des fausses balles, et le d�fenseur rattrapae la balle de vol�  */\r\n");
    buf.append("        action { batter -> FSF9 , runner3 -> + }\r\n");
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
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 2, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 9, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 0, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 2, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

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
   * <td><img src="./resources/WBSC_2016_offense_exemple_018.JPG"/></td>
   * <td>A sacrifice fly must be credited if it enables a runner to score a run, even if another runner is tagged out at a base he was trying to reach. Example
   * 18: The center fielder, after catching a fly ball, assists the second baseman in time to put out the runner on first, while the runner on third reaches
   * home base. This is noted as a double play.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example018() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_018") + "\r\n");
    buf.append("\r\n");
    buf.append("        /*  le premier frappeur frappe un triple dans le champ droit */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me frappeur arrive sur bse su un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le frappeur frappe une fly dans le champs centre, le d�fenseur attrape la balle de vol�e */\r\n");
    buf.append("        /* le d�fenseur renvoie la balle au d�fenseur de la deuxi�me base pour retirer le coureur arrivant de la 1 */\r\n");
    buf.append("        /* le coureur en troisi�me abse en profite pour marquer le point */\r\n");
    buf.append("        action { batter -> SF8 , runner1 -> 84 , runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 1, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 1, 1, 0, 1);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 1);
    checkTotalDefensivesStatist(statisticEngine, 2, 1, 0, 2);
    checkGeneralDoublePlay(statisticEngine, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

  /**
   * Defense : exemple 019 <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_019.JPG"/></td>
   * <td>The center fielder, after having dropped the ball, forces the runner out on second, while the other runner scores. In this case no error is charged to
   * the outfielder, in accordance with rule 9.12(d)(4) of the OBR.</td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void example019() {

    StringBuffer buf = new StringBuffer(CommonResources.BASEBALL_STARTING_GAME.replaceAll("J4R115", "OFFENSE_Exemple_019") + "\r\n");
    buf.append("\r\n");
    buf.append("        /*  le premier frappeur frappe un triple dans le champ droit */\r\n");
    buf.append("        action { batter -> 3B9 }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le deuxi�me frappeur arrive sur bse su un 'base on ball' */\r\n");
    buf.append("        action { batter -> BB }\r\n");
    buf.append("\r\n");
    buf.append("        /* Le frappeur frappe une fly dans le champs centre, le d�fenseur attrape la balle de vol�e mais ma laisse retomber */\r\n");
    buf.append("        /* le d�fenseur renvoie la balle au d�fenseur de la deuxi�me base pour retirer le coureur arrivant de la 1 */\r\n");
    buf.append("        /* le coureur en troisi�me abse en profite pour marquer le point */\r\n");
    buf.append("        action { batter -> SFO8 , runner1 -> 84 , runner3 -> + }\r\n");
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
    checkGeneralStat(statisticEngine, 1, 1, 0, 1, 1, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkOffensivePlayerStat(statisticEngine, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    checkOffensivePlayerStat(statisticEngine, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);
    checkTotalOffensivStatistic(statisticEngine, 3, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkDefensivePlayerStat(statisticEngine, 8, 0, 1, 0, 0);
    checkDefensivePlayerStat(statisticEngine, 4, 1, 0, 0, 0);
    checkTotalDefensivesStatist(statisticEngine, 1, 1, 0, 0);
    checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkPitcherStat(statisticEngine, 1, 3, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
    checkTotalPitchStat(statisticEngine, 3, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    checkCatcherStat(statisticEngine, 1, 0, 0, 0);
    checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
