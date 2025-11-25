package org.bpy.score.engine.tests;

import org.junit.jupiter.api.Test;

public class WBSC_2016_Full_example extends AbstractWBSCUnitTest {

  public static final String SCENARII = "/***********************************************************************************/\r\n"
      + "/* Automatic parse of game : 76                                                    */\r\n"
      + "/* Date                    : mercredi 23 janvier 2019                              */\r\n"
      + "/***********************************************************************************/\r\n" + "\r\n" + "/* start of game description */\r\n"
      + "game \"76\" {\r\n" + "\r\n" + "  /* description of the game */\r\n" + "  header {\r\n" + "    tournament = \"2011 BWC PANAMA\";\r\n"
      + "    stadium = \"ROD CAREW\";\r\n" + "    place = \"PANAMA CITY\";\r\n" + "    date = \"15/10/2011\";\r\n" + "    startTime = \"21:00\";\r\n"
      + "    endTime = \"23:57\";\r\n" + "    duration = \"02:57\";\r\n" + "    type = baseball;\r\n" + "    category = \"National\";\r\n"
      + "    scorekeepers = \"\";\r\n" + "    umpires = \"\";\r\n" + "  }\r\n" + "\r\n" + "  /* Roster of the visitor team */\r\n"
      + "  roster visitor \"Cuba\" {\r\n" + "     player \"ABREU Jose D\",\r\n" + "     player \"ALVAREZ Freddy\",\r\n"
      + "     player \"ARRUEBARRUEANA Borbas\",\r\n" + "     player \"BELL Alexei\",\r\n" + "     player \"CASTILLO Rusney\",\r\n"
      + "     player \"CEPEDA Frederich\",\r\n" + "     player \"DESPAIGNE Alfredo\",\r\n" + "     player \"DUVERGEL Gioruis\",\r\n"
      + "     player \"ENRIQUEZ Michel\",\r\n" + "     player \"FESTANO Ariel\",\r\n" + "     player \"GONZALES Yulieski\",\r\n"
      + "     player \"GOURRIEL Yulleski\",\r\n" + "     player \"MOREJON Frank C\",\r\n" + "     player \"OLIVERA Hector\",\r\n"
      + "     player \"REYES Rudy\"\r\n" + "  }\r\n" + "\r\n" + "  /* Roster of the hometeam team */\r\n" + "  roster hometeam \"Netherland\" {\r\n"
      + "     player \"BERGMAN David\",\r\n" + "     player \"CORDEMANS Robbie\",\r\n" + "     player \"ENGELHARDT Bryan\",\r\n"
      + "     player \"GREGORUS Marielson\",\r\n" + "     player \"JONG DE Sidney\",\r\n" + "     player \"KEMP Dwayne\",\r\n"
      + "     player \"ROMBLEY Danny\",\r\n" + "     player \"SAMS Kalian\",\r\n" + "     player \"SCHOOP Sharlon\",\r\n"
      + "     player \"SHOOP Jonathan\",\r\n" + "     player \"SMITH Curt\",\r\n" + "     player \"SULBARAB Juan\"\r\n" + "  }\r\n" + "\r\n"
      + "  /* Game description 76 */\r\n" + "  gameEntry {\r\n" + "        \r\n" + "    /* Lineup description for the visitor */\r\n"
      + "    lineup visitor {\r\n" + "      /* 01 */  name= \"CASTILLO Rusney\" defensivePosition = 8 shirtNumber = 38;\r\n"
      + "      /* 02 */  name= \"BELL Alexei\" defensivePosition = 9 shirtNumber = 88;\r\n"
      + "      /* 03 */  name= \"CEPEDA Frederich\" defensivePosition = dh shirtNumber = 24;\r\n"
      + "      /* 04 */  name= \"DESPAIGNE Alfredo\" defensivePosition = 7 shirtNumber = 54;\r\n"
      + "      /* 05 */  name= \"GOURRIEL Yulleski\" defensivePosition = 4 shirtNumber = 10;\r\n"
      + "      /* 06 */  name= \"ABREU Jose D\" defensivePosition = 3 shirtNumber = 79;\r\n"
      + "      /* 07 */  name= \"ENRIQUEZ Michel\" defensivePosition = 5 shirtNumber = 12;\r\n"
      + "      /* 08 */  name= \"FESTANO Ariel\" defensivePosition = 2 shirtNumber = 13;\r\n"
      + "      /* 09 */  name= \"ARRUEBARRUEANA Borbas\" defensivePosition = 6 shirtNumber = 71;\r\n"
      + "      /* 10 */  name= \"GONZALES Yulieski\" defensivePosition = 1 shirtNumber = 48;\r\n" + "    }\r\n" + "\r\n"
      + "    /* Lineup description for the hometeam */\r\n" + "    lineup hometeam {\r\n"
      + "      /* 01 */  name= \"KEMP Dwayne\" defensivePosition = 7 shirtNumber = 7;\r\n"
      + "      /* 02 */  name= \"GREGORUS Marielson\" defensivePosition = 6 shirtNumber = 9;\r\n"
      + "      /* 03 */  name= \"JONG DE Sidney\" defensivePosition = 2 shirtNumber = 24;\r\n"
      + "      /* 04 */  name= \"SMITH Curt\" defensivePosition = 3 shirtNumber = 30;\r\n"
      + "      /* 05 */  name= \"ENGELHARDT Bryan\" defensivePosition = dh shirtNumber = 37;\r\n"
      + "      /* 06 */  name= \"SCHOOP Sharlon\" defensivePosition = 4 shirtNumber = 15;\r\n"
      + "      /* 07 */  name= \"SHOOP Jonathan\" defensivePosition = 5 shirtNumber = 16;\r\n"
      + "      /* 08 */  name= \"SAMS Kalian\" defensivePosition = 8 shirtNumber = 35;\r\n"
      + "      /* 09 */  name= \"ROMBLEY Danny\" defensivePosition = 9 shirtNumber = 27;\r\n"
      + "      /* 10 */  name= \"CORDEMANS Robbie\" defensivePosition = 1 shirtNumber = 19;\r\n" + "    }\r\n" + "\r\n" + "    /* Inning 1 : visitor */\r\n"
      + "    inning visitor number 1 {\r\n" + "      note = \"Game starts at 21:00 due to rain field condition\";\r\n"
      + "      action { batter (\"CASTILLO Rusney\") -> 13}\r\n" + "      action { batter (\"BELL Alexei\") -> F9}\r\n"
      + "      action { batter (\"CEPEDA Frederich\") -> KS}     \r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 1 : hometeam */\r\n"
      + "    inning hometeam number 1 {\r\n" + "      action { batter (\"KEMP Dwayne\") -> 1B5}\r\n"
      + "      action { batter (\"GREGORUS Marielson\") -> KS }\r\n" + "      action { runner1 (\"KEMP Dwayne\") -> SB}\r\n"
      + "      action { batter (\"JONG DE Sidney\") -> KS}\r\n" + "      action { batter (\"SMITH Curt\") -> BB}\r\n"
      + "      action { batter (\"ENGELHARDT Bryan\") -> KS}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 2 : visitor */\r\n"
      + "    inning visitor number 2 {\r\n" + "      action { batter (\"DESPAIGNE Alfredo\") -> KS }\r\n"
      + "      action { batter (\"GOURRIEL Yulleski\") -> F8 }\r\n" + "      action { batter (\"ABREU Jose D\") -> HP }\r\n"
      + "      action { batter (\"ENRIQUEZ Michel\") -> FP5 }\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 2 : hometeam */\r\n"
      + "    inning hometeam number 2 {\r\n" + "      action { batter (\"SCHOOP Sharlon\") -> 53}\r\n" + "      action { batter (\"SHOOP Jonathan\") -> 43}\r\n"
      + "      action { batter (\"SAMS Kalian\") -> KS}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 3 : visitor */\r\n"
      + "    inning visitor number 3 {\r\n" + "      action { batter (\"FESTANO Ariel\") -> KL}\r\n"
      + "      action { batter (\"ARRUEBARRUEANA Borbas\") -> KS}\r\n" + "      action { batter (\"CASTILLO Rusney\") -> KS}\r\n" + "    }\r\n" + "    \r\n"
      + "    /* Inning 3 : hometeam */\r\n" + "    inning hometeam number 3 {\r\n" + "      action { batter (\"ROMBLEY Danny\") -> P4}\r\n"
      + "      action { batter (\"KEMP Dwayne\") -> P3}\r\n" + "      action { batter (\"GREGORUS Marielson\") -> L9}\r\n" + "    }\r\n" + "    \r\n"
      + "    /* Inning 4 : visitor */\r\n" + "    inning visitor number 4 {\r\n" + "      action { batter (\"BELL Alexei\") -> KS}\r\n"
      + "      action { batter (\"CEPEDA Frederich\") -> 2BRC}\r\n" + "      action { runner2 (\"CEPEDA Frederich\") -> WP}\r\n"
      + "      action { batter (\"DESPAIGNE Alfredo\") -> SF8 , runner3 (\"CEPEDA Frederich\") -> + earned}\r\n"
      + "      action { batter (\"GOURRIEL Yulleski\") -> F4 }\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 4 : hometeam */\r\n"
      + "    inning hometeam number 4 {\r\n" + "      action { batter (\"JONG DE Sidney\") -> BB}\r\n"
      + "      action { batter (\"SMITH Curt\") -> 1B9 , runner1 (\"JONG DE Sidney\") -> + }\r\n"
      + "      action { batter (\"ENGELHARDT Bryan\") -> 1BRS, runner1 (\"SMITH Curt\") -> +,runner2 (\"JONG DE Sidney\") -> ++ earned}\r\n"
      + "      substitution visitor {\r\n" + "        player 1 replaceBy \"ALVAREZ Freddy\" shirtNumber = 15 at 1         \r\n" + "      }\r\n"
      + "      action { batter (\"SCHOOP Sharlon\") -> SH14, runner1 (\"ENGELHARDT Bryan\") -> + ,runner2 (\"SMITH Curt\") -> +}\r\n"
      + "      action { batter (\"SHOOP Jonathan\") -> 1BMI, runner2 (\"ENGELHARDT Bryan\") -> +,runner3 (\"SMITH Curt\") -> + earned}\r\n"
      + "      action { batter (\"SAMS Kalian\") -> HP, runner1 (\"SHOOP Jonathan\") -> + }\r\n" + "      action { batter (\"ROMBLEY Danny\") -> KS}\r\n"
      + "      action { batter (\"KEMP Dwayne\") -> L1}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 5 : visitor */\r\n"
      + "    inning visitor number 5 {\r\n" + "      action { batter (\"ABREU Jose D\") -> FP3 }\r\n" + "      action { batter (\"ENRIQUEZ Michel\") -> F9}\r\n"
      + "      action { batter (\"FESTANO Ariel\") -> P3 }\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 5 : hometeam */\r\n"
      + "    inning hometeam number 5 {\r\n" + "      action { batter (\"GREGORUS Marielson\") -> 3}\r\n"
      + "      action { batter (\"JONG DE Sidney\") -> KS}\r\n" + "      action { batter (\"SMITH Curt\") -> 1B7}\r\n"
      + "      action { batter (\"ENGELHARDT Bryan\") -> FP5}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 6 : visitor */\r\n"
      + "    inning visitor number 6 {\r\n" + "      action { batter (\"ARRUEBARRUEANA Borbas\") -> F8}\r\n"
      + "      action { batter (\"CASTILLO Rusney\") -> L4}\r\n" + "      action { batter (\"BELL Alexei\") -> BB}\r\n"
      + "      action { batter (\"CEPEDA Frederich\") -> F7}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 6 : hometeam */\r\n"
      + "    inning hometeam number 6 {\r\n" + "      action { batter (\"SCHOOP Sharlon\") -> HP}\r\n"
      + "      action { batter (\"SHOOP Jonathan\") -> SH1, runner1 (\"SCHOOP Sharlon\") -> +}\r\n" + "      action { batter (\"SAMS Kalian\") -> BB }\r\n"
      + "      action { batter (\"ROMBLEY Danny\") -> O1, runner1 (\"SAMS Kalian\") -> 16 ,runner2 (\"SCHOOP Sharlon\") -> +}\r\n"
      + "      action { batter (\"KEMP Dwayne\") -> F6}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 7 : visitor */\r\n"
      + "    inning visitor number 7 {\r\n" + "      action { batter (\"DESPAIGNE Alfredo\") -> E7F+}\r\n"
      + "      action { batter (\"GOURRIEL Yulleski\") -> 43}\r\n" + "      action { batter (\"ABREU Jose D\") -> F9}\r\n"
      + "      action { batter (\"ENRIQUEZ Michel\") -> F7}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 7 : hometeam */\r\n"
      + "    inning hometeam number 7 {\r\n" + "      action { batter (\"GREGORUS Marielson\") -> 43}\r\n"
      + "      action { batter (\"JONG DE Sidney\") -> BB}\r\n" + "      action { batter (\"SMITH Curt\") -> KS}\r\n"
      + "      action { batter (\"ENGELHARDT Bryan\") -> 1B9, runner1 (\"JONG DE Sidney\") -> ++}\r\n" + "      action { batter (\"SCHOOP Sharlon\") -> F8}\r\n"
      + "      substitution visitor {\r\n" + "        player 2 replaceBy \"DUVERGEL Gioruis\" shirtNumber=1 at ph8, \r\n"
      + "        player 6 replaceBy \"REYES Rudy\" shirtNumber=50 at ph9     \r\n" + "      }\r\n" + "    }\r\n" + "    \r\n"
      + "    /* Inning 8 : visitor */\r\n" + "    inning visitor number 8 {\r\n" + "      action { batter (\"DUVERGEL Gioruis\") -> FP5}\r\n"
      + "      action { batter (\"REYES Rudy\") -> 2B7}\r\n" + "      substitution hometeam {\r\n"
      + "        player 1 replaceBy \"SULBARAB Juan\" shirtNumber=33 at 1\r\n" + "      }\r\n" + "      action { batter (\"CASTILLO Rusney\") -> 1B6}\r\n"
      + "      action { batter (\"BELL Alexei\") -> F7}\r\n" + "      action { batter (\"CEPEDA Frederich\") -> F7}\r\n" + "    }\r\n" + "    \r\n"
      + "    /* Inning 8 : hometeam */\r\n" + "    inning hometeam number 8 {\r\n" + "      substitution visitor {\r\n"
      + "          player ph8 replaceBy \"MOREJON Frank C\" shirtNumber=45 at 2,\r\n" + "        player ph9 moveTo 6       \r\n" + "      }\r\n"
      + "      action {  batter (\"SHOOP Jonathan\") -> 63}\r\n" + "      action { batter (\"SAMS Kalian\") -> 63}\r\n"
      + "      action { batter (\"ROMBLEY Danny\") -> 3}\r\n" + "    }\r\n" + "    \r\n" + "    /* Inning 9 : visitor */\r\n"
      + "    inning visitor number 9 {\r\n" + "      substitution visitor {\r\n"
      + "        player 2 replaceBy \"OLIVERA Hector\" shirtNumber=28 at ph8       \r\n" + "      }\r\n" + "\r\n"
      + "      action { batter (\"DESPAIGNE Alfredo\") -> F8}\r\n" + "      action { batter (\"GOURRIEL Yulleski\") -> 1BRS}\r\n"
      + "      substitution hometeam {\r\n" + "        player 1 replaceBy \"BERGMAN David\" shirtNumber=33 at 1\r\n" + "      }\r\n"
      + "      action { batter (\"ABREU Jose D\") -> F7}\r\n" + "      action { batter (\"ENRIQUEZ Michel\") -> 1BLS, runner1 (\"GOURRIEL Yulleski\") -> +}\r\n"
      + "      action { batter (\"DUVERGEL Gioruis\") -> L5 }\r\n" + "    }\r\n" + "  }\r\n" + "}\r\n" + "";

  public WBSC_2016_Full_example() {
    super();
  }

  /**
   * Defense : exemple xxx <br>
   * 
   * <table>
   * <tr>
   * <td><img src="./resources/WBSC_2016_offense_exemple_xxx.JPG"/></td>
   * <td></td>
   * </tr>
   * </table>
   * 
   */
  @Test
  public void TestFulleExample() {

//    IParseResult parserResult = parser.parse(new StringReader(SCENARII));
//    
//    assertNotNull("Parser result can't be null", parserResult);
//    Game game = (Game) parserResult.getRootASTElement();
//
//    /* create statistiques */
//    StatisticEngine statisticEngine = new StatisticEngine();
//    statisticEngine.setGame(game);
//    statisticEngine.setActionsManager(new StatisticManager());
//    statisticEngine.run();

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check general statisitics */
    /* ab, r, er, h, a, e,lob */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    // checkGeneralStat(statisticEngine, ab, r, er, h, a, e, lob);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check offensive statisitics */
    /* player, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    // checkOffensivePlayerStat(statisticEngine, 1, pa, ab, r, h, 2b, 3b, hr, gdp, sh, sf, bb, ibb, hp, io, sb, cs, k, rbi);
    // checkTotalOffensivStatistic(statisticEngine, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check defensive statisitics */
    /* player, po, a, e, dp */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    // checkDefensivePlayerStat(statisticEngine, player, po, a, e, dp);
    // checkTotalDefensivesStatist(statisticEngine, 0, 0, 0, 0);
    // checkGeneralDoublePlay(statisticEngine, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check pitcher statisitics */
    /* player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb,ibb, hp, io, k, wp, bk */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    // checkPitcherStat(statisticEngine, player, bf, ab, r, er, h, 2b, 3b, hr, sh, sf, bb, ibb, hp, io, k, wp, bk);
    // checkTotalPitchStat(statisticEngine, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    /* ----------------------------------------------------------------------------------------------------------------------- */
    /* Check catcher statisitics */
    /* pb, sb, cs */
    /* ----------------------------------------------------------------------------------------------------------------------- */
    // checkCatcherStat(statisticEngine, player, pb, sb, cs);
    // checkTotalCatcherSt(statisticEngine, 0, 0, 0);

    /* On met ce boolean � vrai si le r�sultat attenedu est conforme � l'image d�fini dans le commentaire ci dessus */
    
  }

}
