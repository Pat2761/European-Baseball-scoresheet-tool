package org.bpy.score.engine.tests;

public class CommonResources {
	
	public static String BASEBALL_STARTING_GAME = "game \"J4R115\" {" +
			   "/* description of the game */" +
			   "header {" +
			   "   tournament = \"R1 Normandie\";" +
			   "   stadium = \"McNour\";" +
			   "   place = \"CAEN\";" +
			   "   date = \"26/03/2017\";" +
			   "   startTime = \"11:04\";" +
			   "   endTime = \"13:15\";" +
			   "   duration = \"02:12\";" +
			   "   type = baseball;" +
			   "   category = \"SENIOR\";" +
			   "   scorekeepers = \"BECOUSE Sophie\";" +
			   "   umpires = \"NORDSTERN Sheridan\";" +
			   "}" +

			  " /* Roster of the visitor team ROUEN */" +
			   "roster visitor \"Rouen\" {" +
			   "    /* 00 */ player \"DUBOS Antonin\"," +
			   "    /* 01 */ player \"GUERN Auguste\"," +
			   "    /* 02 */ player \"HARRISON Gabriel\"," +
			   "    /* 03 */ player \"DUBOIS Jeremy\"," +
			   "    /* 04 */ player \"LEVIGNERON Laurent\"," +
			   "    /* 05 */ player \"VIGER Luc\"," +
			   "    /* 06 */ player \"VISSAC Martin\"," +
			   "    /* 07 */ player \"VIREY Max\"," +
			   "    /* 08 */ player \"PARISI Nicolas\"," +
			   "    /* 09 */ player \"BOURDON Nicolas\"," +
			   "    /* 10 */ player \"DEHORS Simon\"," +
			   "    /* 11 */ player \"TRANCHANT Theotime\"," +
			   "    /* 12 */ player \"GRANDIN Victor\"," +
			   "    /* 13 */ player \"MOREAU Louis\"," +
			   "    /* 14 */ player \"TAMURCE Tabki\"" +
			   "}" +

			  " /* Roster of the hometeam team CAEN */" +
			   "roster hometeam \"Caen\" {" +
			   "    /* 00 */ player \"BERNARD Guillaume\"," +
			   "    /* 00 */ player \"CAMBUZAT Valerian\"," +
			   "    /* 00 */ player \"CHARIOU Claire\"," +
			   "    /* 00 */ player \"CHAVANY Antoine\"," +
			   "    /* 00 */ player \"CHIEU Maximilien\"," +
			   "    /* 00 */ player \"COLAS Lilian\"," +
			   "    /* 00 */ player \"DAVIDSON Gabriel\"," +
			   "    /* 00 */ player \"DELAIN Dominique\"," +
			   "    /* 00 */ player \"DELAMAIRE Charles\"," +
			   "    /* 00 */ player \"FONTAINE Anne\"," +
			   "    /* 00 */ player \"FOUCHER Camille\"," +
			   "    /* 00 */ player \"GOMONT Gabin\"," +
			   "    /* 00 */ player \"GUY Arthur\"," +
			   "    /* 00 */ player \"HELLEU Boris\"," +
			   "    /* 00 */ player \"JACQUES Anthony\"," +
			   "    /* 00 */ player \"LE CAVELIER Fabien\"," +
			   "    /* 00 */ player \"LEFRANCOIS Bénédicte\"," +
			   "    /* 00 */ player \"LENOURRY Gabrielle\"," +
			   "    /* 00 */ player \"MATEILLE Emmanuel\"," +
			   "    /* 00 */ player \"MORIN Benjamin\"," +
			   "    /* 00 */ player \"NORDSTERN Sheridan\"," +
			   "    /* 00 */ player \"PATIN Aurelie\"," +
			   "    /* 00 */ player \"POTIER Nicolas\"," +
			   "    /* 00 */ player \"PRISSET Nicolas\"," +
			   "    /* 00 */ player \"SCOLA Martin\"," +
			   "    /* 00 */ player \"SISONGKHAM Vincent\"," +
			   "    /* 00 */ player \"VIOLET Angelique\"" +
			   "}" +

			  " /* Game description J1R104 */" +
			   "gameEntry {" +

			  "    /* Lineup description for the visitor */" +
			   "   lineup visitor {" +
			   "   	/* 01 */	name= \"DUBOS Antonin\" defensivePosition = 1 shirtNumber = 16 ;" +
			   "   	/* 02 */	name= \"BOURDON Nicolas\" defensivePosition = 8 shirtNumber = 15;" +
			   "   	/* 03 */	name= \"VISSAC Martin\" defensivePosition = 6 shirtNumber = 70 ;" +
			   "   	/* 04 */	name= \"DEHORS Simon\" defensivePosition = 3 shirtNumber = 20;" +
			   "   	/* 05 */	name= \"HARRISON Gabriel\" defensivePosition = 2 shirtNumber = 9;" +
			   "   	/* 06 */	name= \"VIGER Luc\" defensivePosition = 5 shirtNumber = 6;" +
			   "   	/* 07 */	name= \"GUERN Auguste\" defensivePosition = 4 shirtNumber = 72;" +
			   "   	/* 08 */	name= \"MOREAU Louis\" defensivePosition = 9 shirtNumber = 9;" +
			   "   	/* 09 */	name= \"GRANDIN Victor\" defensivePosition = 7 shirtNumber = 64;" +
			   "   }" +

			  "    /* Lineup description for the hometeam */" +
			   "   lineup hometeam {" +
			   "   	/* 01 */	name= \"HELLEU Boris\" defensivePosition = 9 shirtNumber = 7;" +
			   "   	/* 02 */	name= \"CHAVANY Antoine\" defensivePosition = 5 shirtNumber = 6;" +
			   "   	/* 03 */	name= \"MORIN Benjamin\" defensivePosition = 6 shirtNumber = 18;" +
			   "   	/* 04 */	name= \"SISONGKHAM Vincent\" defensivePosition = 2 shirtNumber = 4;" +
			   "   	/* 05 */	name= \"LE CAVELIER Fabien\" defensivePosition = 3 shirtNumber = 50 ;" +
			   "   	/* 06 */	name= \"FOUCHER Camille\" defensivePosition = 1 shirtNumber = 51;" +
			   "   	/* 07 */	name= \"BERNARD Guillaume\" defensivePosition = 8 shirtNumber = 29;" +
			   "   	/* 08 */	name= \"LENOURRY Gabrielle\" defensivePosition = 4 shirtNumber = 15;" +
			   "   	/* 09 */	name= \"PRISSET Nicolas\" defensivePosition = 7 shirtNumber = 19;" +
			   "   }" +

			  "    inning visitor number 1 {"; 

	public static String SOFTBALL_STARTING_GAME = "game \"J4R115\" {" +
			   "header {" +
			   "   tournament = \"TDB\";" +
			   "   stadium = \"Stade TOMASINI\";" +
			   "   place = \"Les Andelys\";" +
			   "   date = \"Apr 17, 2016\";" +
			   "   startTime = \"11:02\";" +
			   "   endTime = \"TDB\";" +
			   "   duration = \"TDB\";" +
			   "   umpires = \"MOULIN Gerard\";" +
			   "   scorekeepers = \"TDB\";" +
			   "   category = \"TDB\";" +
			   "   notes = \"SCORER:CHENAL Didier DATA ENTRY:BRIAND Patrick\"," +
			   "\"\"," +
			   "\"\"," +
			   "\"\";" +
			   "   type = softball;" +
			   "}" +

			  " roster visitor \"ROUEN\" {" +
			   "   player \"AJAVON J\"," +
			   "   player \"ANOUAR H\"," +
			   "   player \"ANOUAR S\"," +
			   "   player \"BLONDEL H\"," +
			   "   player \"BOURDON N\"," +
			   "   player \"BRETAR M\"," +
			   "   player \"CESPEDES J\"," +
			   "   player \"DEHORS S\"," +
			   "   player \"DUBOIS J\"," +
			   "   player \"GOUYETTE T\"," +
			   "   player \"GOUYETTE V\"," +
			   "   player \"LEGAL A\"," +
			   "   player \"LEROY B\"," +
			   "   player \"LEVIGNERON L\"," +
			   "   player \"MASSE T\"," +
			   "   player \"MENNETRIER C\"," +
			   "   player \"OBJOIS JP\"," +
			   "   player \"TROUSSEAU G\"," +
			   "   player \"VIGER L\"," +
			   "   player \"VIREY M\"," +
			   "   player \"VISSAC M\"" +
			   "}" +

			  " roster hometeam \"ROUEN\" {" +
			   "   player \"AJAVON J\"," +
			   "   player \"ANOUAR H\"," +
			   "   player \"ANOUAR S\"," +
			   "   player \"BLONDEL H\"," +
			   "   player \"BOURDON N\"," +
			   "   player \"BRETAR M\"," +
			   "   player \"CESPEDES J\"," +
			   "   player \"DEHORS S\"," +
			   "   player \"DUBOIS J\"," +
			   "   player \"GOUYETTE T\"," +
			   "   player \"GOUYETTE V\"," +
			   "   player \"LEGAL A\"," +
			   "   player \"LEROY B\"," +
			   "   player \"LEVIGNERON L\"," +
			   "   player \"MASSE T\"," +
			   "   player \"MENNETRIER C\"," +
			   "   player \"OBJOIS JP\"," +
			   "   player \"TROUSSEAU G\"," +
			   "   player \"VIGER L\"," +
			   "   player \"VIREY M\"," +
			   "   player \"VISSAC M\"" +
			   "}" +

			  " actions {" +

			  "    /* dÃ©claration du lineUp visitor*/" +
			   "   lineup visitor {" +
			   "      name  = \"LEVIGNERON L\" defensivePosition = 8;" +
			   "      name  = \"LEROY B\" defensivePosition = 5;" +
			   "      name  = \"BOURDON N\" defensivePosition = 6;" +
			   "      name  = \"DEHORS S\" defensivePosition = 3;" +
			   "      name  = \"OBJOIS JP\" defensivePosition = 9;" +
			   "      name  = \"GOUYETTE V\" defensivePosition = 7;" +
			   "      name  = \"MENNETRIER C\" defensivePosition = 2;" +
			   "      name  = \"VIREY M\" defensivePosition = 4;" +
			   "      name  = \"DUBOIS J\" defensivePosition = 1;" +
			   "   }" +

			   "    /* dÃ©claration du lineUp hometeam*/" +
			   "   lineup hometeam {" +
			   "      name  = \"PIERRON R\" defensivePosition = 9;" +
			   "      name  = \"LITTEE S\" defensivePosition = 4;" +
			   "      name  = \"BLOQUET S\" defensivePosition = 2;" +
			   "      name  = \"SOCHON A\" defensivePosition = 3;" +
			   "      name  = \"MOULIN R\" defensivePosition = 5;" +
			   "      name  = \"CORBEAU A\" defensivePosition = 8;" +
			   "      name  = \"POIRIER S\" defensivePosition = 7;" +
			   "      name  = \"BERNARD W\" defensivePosition = 1;" +
			   "      name  = \"LEMOINE D\" defensivePosition = 6;" +
			   "   }" +

			   "    inning visitor number 1 {"; 

				public static String ENDING_GAME ="      }"+
				"gameResume {" +
			    	"win = \"DUBOS Antonin\";" +
				    "lose = \"FOUCHER Camille\";" + 
			    	"}" + 
				    "}" +
			    	"}";

				public static String CEB_STRING_001 = BASEBALL_STARTING_GAME +
					"action { batter -> KL }" +
			      	"action { batter -> KS }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_002 = BASEBALL_STARTING_GAME +
					 "action { batter -> K23 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_003 = BASEBALL_STARTING_GAME +
					 "action { batter -> F8 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_004 = BASEBALL_STARTING_GAME +
					 "action { batter -> FF2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_005 = BASEBALL_STARTING_GAME +
					 "action { batter -> L1 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_006 = BASEBALL_STARTING_GAME +
					 "action { batter -> FL5 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_007 = BASEBALL_STARTING_GAME +
					 "action { batter -> 53 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_008 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_009 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 64 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_010 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1  -> PO13 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_011 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 63, runner1 -> 6 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_012 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> L4, runner1 -> 43 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_013 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { batter -> 63, runner2 -> 6 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_014 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> KS, runner1 -> CS24 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_015 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> BB }" +
					 "action { batter -> 63, runner1 -> + , runner2 -> + 32 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_016 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B7, runner1 -> + }" +
					 "action { batter -> GDPO5, runner1 -> 54 , runner2 -> 5 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_017 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP43, runner1 -> 64 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_018 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B8, runner1 -> + }" +
					 "action { batter -> 4E3, runner1 -> + ,runner2 -> + }" +
					 "action { batter -> L5, runner2 -> 54 ,runner3 -> 5 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_019 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6F }" +
					 "action { batter -> 1B8, runner1 -> + }" +
					 "action { batter -> BB, runner1 -> + ,runner2 -> + }" +
					 "action { batter -> GDP43, runner1 -> 54 ,runner2 -> 5 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_020 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR1-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_021 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBRKS-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_022 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR3-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_023 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR4-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_024 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR5-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_025 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR5-3 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_026 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR6-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_027 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B7 }" +
					 "action { runner3 -> OBR7-2 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_028 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR8-5 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_029 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> 1B4, runner1 -> OBR9-4 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_030 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> OBR10-43 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_031 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B7 , runner1 -> + }" +
					 "action { batter -> 1B7, runner1 -> + OBR11-6, runner2 -> + }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_032 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { runner2 -> OBR12-4 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_033 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B9 OBR13-94 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_034 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> OBR14-3, runner1 -> 6 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_035 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B9 }" +
					 "action { batter -> OBR14-3, runner1 -> OBR13-46 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_036 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { batter -> 1B7 , runner2 -> 75 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_037 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { batter -> 1B7 }" +
					 "action { runner2 -> A15 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_038 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> A3, runner1 -> +++, runner2 -> ++, runner3 -> + }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_039 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> 3B8 A2, runner1 -> +++, runner2 -> ++, runner3 -> + }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_040 = BASEBALL_STARTING_GAME +
					 "action { batter -> E8F }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> A13 }" +
			      	 ENDING_GAME;;

				public static String CEB_STRING_041 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> O2+++, runner1 -> +++, runner2 -> ++, runner3 -> A2 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_042 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> O2+++, runner1 -> +++, runner2 -> ++, runner3 -> A2 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_043 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> 2B9+, runner1 -> ++ A2, runner2 -> ++, runner3 -> + }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_044 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B8, runner1 -> ++ }" +
					 "action { batter -> 1B7+, runner1 -> + A15, runner3 -> + }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_045 = BASEBALL_STARTING_GAME +
					 "action { batter -> CI }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> HP }" +
					 "action { batter -> 2B9 OBR11-5, runner1 -> ++, runner2 -> ++, runner3 -> + }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_046 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B7, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS2E5 }" +
					 "action { batter -> 1B8 A2, runner2 -> +, runner3 -> + }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_047 = BASEBALL_STARTING_GAME +
					 "action { batter -> IF6 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_048 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR8-6 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_049 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR8-5 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_050 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { batter -> BB }" +
					 "action { batter -> OBR8-3 , runner2 -> 35}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_051 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR8-3}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_052 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR5-63}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_053 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR5-945}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_054 = BASEBALL_STARTING_GAME +
					 "action { batter -> LT}" +
					 "action { batter -> 1B8}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_055 = BASEBALL_STARTING_GAME +
					 "action { batter -> OBR5-2}" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_056 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O5 , runner1 -> 564 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_057 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { batter -> 463 , runner1 -> + }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_058 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> O5 , runner2 -> 54626 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_059 = BASEBALL_STARTING_GAME +
					 "action { batter -> E5T 96 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_060 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B5 96 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_061 = BASEBALL_STARTING_GAME +
					 "action { batter -> K13 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_062 = BASEBALL_STARTING_GAME +
					 "action { batter -> F49 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_063 = BASEBALL_STARTING_GAME +
					 "action { batter -> 63 }" +
			      	 ENDING_GAME;;

			    public static String CEB_STRING_064 = BASEBALL_STARTING_GAME +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_065 = BASEBALL_STARTING_GAME +
					 "action { batter -> OB3 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_066 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> SB e2T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_067 = BASEBALL_STARTING_GAME +
					 "action { batter -> EF3 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_068 = BASEBALL_STARTING_GAME +
					 "action { batter -> E3 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_069 = BASEBALL_STARTING_GAME +
					 "action { batter -> E9F }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_070 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6T+ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_071 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 6E4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_072 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E4, runner1 -> + (2) }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_073 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> CS2E4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_074 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B8 O8, runner1 -> + 8564E6T+ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_075 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B8 T85, runner1 -> + e8T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_076 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> 1B85, runner2 -> + ob5 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_077 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> 1B8, runner2 -> ++ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_078 = BASEBALL_STARTING_GAME +
					 "action { batter -> E8F }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_079 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6 e6T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_080 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { runner1 -> CS2E4 45 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_081 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> E7F 74, runner1 -> (2)+ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_082 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> E8F, runner2 -> 85 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_083 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 e8 75 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_084 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 e8 75 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_085 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> e2T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_086 = BASEBALL_STARTING_GAME +
					 "action { batter -> KSE2T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_087 = BASEBALL_STARTING_GAME +
					 "action { batter -> KS2E3 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_088 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> EF7 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_089 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP4E3 , runner1 -> 64 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_090 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP63 , runner1 -> E6 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_091 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP6E3 , runner1 -> E6 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_092 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP43 , runner1 -> 4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_093 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP3 , runner1 -> 4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_094 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6 e4T , runner1 -> 64 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_095 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> GDP4E3 36, runner1 -> 4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_096 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_097 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_098 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_099 = BASEBALL_STARTING_GAME +
					 "action { batter -> HR8 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_100 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O4, runner1 -> A14 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_101 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O4, runner1 -> OBR14-4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_102 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9 T95, runner1 -> ++ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_103 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { batter -> 2B89, runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_104 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> 2B8 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_105 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9, runner1 -> +, runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_106 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { batter -> BB }" +
					 "action { batter -> HR9, runner1 -> +++, runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_107 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> SH13 , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_108 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> SH5E3 , runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_109 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { batter -> SH34 , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_110 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> SH34 , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_111 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> SHFC54 , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_112 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { batter -> O1 , runner1 -> + , runner3 -> 12}" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_113 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> BB }" +
					 "action { batter -> SH1E3 , runner1 -> + , runner2 -> + 32}" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_114 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B89 }" +
					 "action { batter -> SF8 , runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_115 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { runner2 -> SB }" +
					 "action { batter -> SFE7 , runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_116 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> FSF9 , runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_117 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { batter -> SF8 , runner1 -> 84,  runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_118 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { batter -> SFO8 , runner1 -> 84,  runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_119 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_120 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E6T , runner1 -> + }" +
					 "action { batter -> BB , runner1 -> + , runner2 -> +}" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_121 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> IBB , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_122 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> HP , runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_123 = BASEBALL_STARTING_GAME +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_124 = BASEBALL_STARTING_GAME +
					 "action { batter -> OB3 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_125 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> 1B4, runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_126 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B9 }" +
					 "action { batter -> E5T, runner1 -> + (2) }" +
					 "action { batter -> 1B4, runner1 -> OBR9-4 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_127 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> BB}" +
					 "action { batter -> 1B8, runner1 -> +, runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_128 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B8, runner1 -> ++ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_129 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 2B78, runner1 -> +++ }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_130 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 43, runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_131 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 64, runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_132 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E5T+, runner1 -> + (2) }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_133 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> e1T, runner3 -> (5) }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_134 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> E5, runner1 -> + , runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_135 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> O5, runner1 -> E5 , runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_136 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB}" +
					 "action { runner1 -> O/2 }" +
					 "action { runner2 -> pb, runner3 -> PB }" +
					 "action { batter -> K23 }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_137 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB}" +
					 "action { runner1 -> O/2 }" +
					 "action { runner2 -> pb, runner3 -> PB }" +
					 "action { batter -> KSE2T }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_138 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB}" +
					 "action { batter -> INT, runner1 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_139 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> SB }" +
					 "action { runner2 -> WP }" +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_140 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> BB , runner1 -> + }" +
					 "action { batter -> INT , runner1 -> + , runner2 -> + }"  +
					 "action { batter -> KS }" +
					 "action { batter -> IF5 }" +
					 "action { batter -> INT , runner1 -> + , runner2 -> + , runner3 -> +}"  +
			      	 ENDING_GAME;

			    public static String CEB_STRING_141 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { runner2 -> PB }" +
					 "action { batter -> SF9 , runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_142 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { runner2 -> PB }" +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_143 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 e8 }" +
					 "action { batter -> SH13 , runner2 -> +}" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_144 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 e8 }" +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_145 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { runner2 -> WP }" +
					 "action { runner3 -> SB }" +
					 "action { batter -> INT }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_146 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B7, runner1 -> + }" +
					 "action { runner1 -> 3ABR , runner2 -> 3ABR  }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_147 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> KABR, runner1 -> 3ABR , runner3 -> 3ABR  }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_148 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> 1B8, runner1 -> + e8 }" +
					 "action { batter -> KABR, runner1 -> + , runner3 -> 3ABR  }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_149 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { runner1 -> BK }" +
					 "action { batter -> 1B6 , runner2 -> + }" +
					 "action { runner1 -> SB, runner3 -> SB  }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_150 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { runner1 -> WP }" +
					 "action { batter -> 1B9 , runner2 -> + }" +
					 "action { runner1 -> 1ABR, runner3 -> SB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_151 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6 }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> BB , runner1 -> +, runner3 -> SB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_152 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> E8F, runner1 -> (2) }" +
					 "action { batter -> HP , runner1 -> +, runner2 -> + }" +
					 "action { batter -> BB , runner1 -> +, runner2 -> +, runner3 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_153 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { runner1 -> WP }" +
					 "action { batter -> 1B9 , runner2 -> + }" +
					 "action { runner1 -> 1ABR, runner3 -> SB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_154 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { runner1 -> WP }" +
					 "action { batter -> 1B9 , runner2 -> + }" +
					 "action { runner1 -> SB, runner3 -> SB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_155 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B3 e3 }" +
					 "action { batter -> BB }" +
					 "action { runner2 -> WP }" +
					 "action { runner1 -> SB, runner3 -> SB }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_156 = BASEBALL_STARTING_GAME +
					 "action { batter -> E5T }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> 1B1, runner2 -> + }" +
					 "action { batter -> KL }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_157 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { runner1 -> WP }" +
					 "action { batter -> 1B2, runner2 -> + }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> FF5, runner1 -> 7ABR, runner2 -> 7ABR, runner3 -> 7ABR  }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_158 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { runner1 -> SB }" +
					 "action { runner2 -> WP }" +
					 "action { batter -> FF7, runner3 -> 6ABR }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_159 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { runner1 -> (9) , runner2 -> e6 }" +
					 "action { batter -> OBR8-6}" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_160 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 "action { batter -> OBR8-6 , runner1 -> +, runner2 -> + }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_161 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { runner1 -> bk, runner2 -> BK }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_162 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B89 }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> wp, runner3 -> WP }" +
			      	 ENDING_GAME;

			    public static String CEB_STRING_163 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B78 }" +
					 "action { batter -> KSWP , runner2 -> wp }" +
					 ENDING_GAME;

			    public static String CEB_STRING_164 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> WP+ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_165 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> WP }" +
					 "action { runner2 -> WP }" +
					 ENDING_GAME;

			    public static String CEB_STRING_166 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> pb , runner2 -> PB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_167 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> PB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_168 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> PB }" +
					 "action { batter -> KSPB,  runner2 -> pb }" +
					 ENDING_GAME;

			    public static String CEB_STRING_169 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> PB }" +
					 "action { batter -> KL }" +
					 ENDING_GAME;

			    public static String CEB_STRING_170 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> BK }" +
					 "action { batter -> K23, runner2 -> PB}" +
					 ENDING_GAME;

			    public static String CEB_STRING_171 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 64}" +
					 ENDING_GAME;

			    public static String CEB_STRING_172 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 6E4}" +
					 ENDING_GAME;

			    public static String CEB_STRING_173 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> SFO6, runner1 -> 86 , runner3 -> +}" +
					 ENDING_GAME;

			    public static String CEB_STRING_174 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> O8, runner1 -> 86 , runner3 -> e8}" +
					 ENDING_GAME;

			    public static String CEB_STRING_175 = BASEBALL_STARTING_GAME +
					 "action { batter -> KSWP }" +
					 "action { batter -> 1B1, runner1 -> + }" +
					 "action { batter -> BB, runner1 -> + , runner2 -> + }" +
					 "action { batter -> GDPO5, runner1 -> 54 , runner2 -> 5, runner3 -> +}" +
					 ENDING_GAME;

			    public static String CEB_STRING_176 = BASEBALL_STARTING_GAME +
					 "action { batter -> KSWP }" +
					 "action { runner1 -> PB }" +
					 "action { batter -> O2+, runner2 -> 2565 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_177 = BASEBALL_STARTING_GAME +
					 "action { batter -> E8F }" +
					 "action { batter -> 1B4, runner1 -> + }" +
					 "action { batter -> O6, runner1 -> O6 , runner2 -> 65 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_178 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> 1B7 T75, runner2 -> + }" +
					 "action { batter -> KSO2, runner2 -> O2 , runner3 -> 21 }" +
					 ENDING_GAME;

				// Offense example 60
			    public static String CEB_STRING_179 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> O5, noAdvance on runner3 -> EF5 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_180 = BASEBALL_STARTING_GAME +
					 "action { batter -> E8F }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { runner1 -> O/2 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_181 = BASEBALL_STARTING_GAME +
					 "action { batter -> E8F }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { runner1 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_182 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { runner1 -> O/2 , runner2 -> CS25 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_183 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B3, runner1 -> + }" +
					 "action { runner1 -> CS1364 , runner2 -> O/1 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_184 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 43, runner1 -> + }" +
					 "action { batter -> 13, runner2 -> + O/3 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_185 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> 1B6, runner2 -> +  O/3}" +
					 ENDING_GAME;

			    public static String CEB_STRING_186 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> 1B8, runner2 -> + }" +
					 "action { batter -> F9, runner1 -> O/1, runner3 -> A15 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_187 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> 1B8, runner2 -> + }" +
					 "action { batter -> SF9, runner1 -> O/1, runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_188 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> FC54, runner1 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_189 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> 53, runner1 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_190 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> 1B5, runner1 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_191 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B4, runner1 -> + }" +
					 "action { batter -> SHFC18, runner1 -> +, runner2 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_192 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B4, runner1 -> + }" +
					 "action { batter -> O1, runner1 -> +, runner2 -> 15 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_193 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B4, runner1 -> + }" +
					 "action { batter -> 1B1, runner1 -> +, runner2 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_194 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { runner2 -> PB }" +
					 "action { batter -> KSFC15 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_195 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "action { runner2 -> PB }" +
					 "action { batter -> K23 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_196 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6F }" +
					 "action { batter -> 1B8 T85, runner1 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_197 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E9F T95, runner1 -> + (7) }" +
					 ENDING_GAME;

			    public static String CEB_STRING_198 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E9F+ , runner1 -> + (7) }" +
					 ENDING_GAME;

			    public static String CEB_STRING_199 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { batter -> 1B4, runner1 -> + }" +
					 "action { batter -> 1B7, runner1 -> + T72, runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_200 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8}" +
					 "action { runner3 -> SB }" +
					 "action { batter -> BB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_201 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB}" +
					 "action { runner1 -> SB WP }" +
					 ENDING_GAME;

			    public static String CEB_STRING_202 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB}" +
					 "action { runner1 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_203 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB}" +
					 "action { runner1 -> SB e2T }" +
					 ENDING_GAME;

			    public static String CEB_STRING_204 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> HP, runner1 -> + }" +
					 "action { runner1 -> SB, runner2 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_205 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> HP, runner1 -> + }" +
					 "action { runner1 -> O/2, runner2 -> CS25 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_206 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { runner1 -> CS2E4 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_207 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> O/2, runner3 -> CS242 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_208 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9 , runner1 -> ++ }" +
					 "action { runner1 -> SB, runner3 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_209 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9 , runner1 -> ++ }" +
					 "action { runner1 -> CS24 , runner3 -> O/2 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_210 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> BB , runner1 -> + }" +
					 "action { runner2 -> SB }" +
					 "action { runner1 -> WP  }" +
					 ENDING_GAME;

			    public static String CEB_STRING_211 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> INT }" +
					 "action { runner1 -> SB , runner3 -> e2T }" +
					 ENDING_GAME;

			    public static String CEB_STRING_212 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { runner3 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_213 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { runner1 -> SB, runner2 -> SB SB}" +
					 ENDING_GAME;

			    public static String CEB_STRING_214 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { runner1 -> CS24 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_215 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B6 }" +
					 "action { runner1 -> CS134 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_216 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { runner3 -> CS2 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_217 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { runner3 -> CS12 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_218 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { runner1 -> O/2, runner3 -> CS2  }" +
					 "action { batter -> KS }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> KS }" +
					 ENDING_GAME;

			    public static String CEB_STRING_219 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> CS23 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_220 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B89 }" +
					 "action { batter -> INT }" +
					 "action { batter -> 2B9, runner1 -> +++, runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_221 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B89 }" +
					 "action { batter -> BB }" +
					 "action { batter -> 1B8 e8, runner1 -> ++ (4), runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_222 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B89 }" +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> 64, runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_223 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> 1B9, runner1 -> ++  }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> HP, runner1 -> +, runner2 -> +, runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_224 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "action { batter -> 1B9, runner1 -> +  }" +
					 "action { batter -> HR8, runner1 -> +++, runner2 -> ++}" +
					 ENDING_GAME;

			    public static String CEB_STRING_225 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { batter -> SF8, runner3 -> +  }" +
					 ENDING_GAME;

			    public static String CEB_STRING_226 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { runner3 -> WP  }" +
					 ENDING_GAME;

			    public static String CEB_STRING_227 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
					 "action { batter -> SHE1T, runner2 -> + (9)  }" +
					 ENDING_GAME;

			    public static String CEB_STRING_228 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { batter -> BB  }" +
					 "action { batter -> GDP43 , runner1 -> 64, runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_229 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B7 }" +
			         "action { batter -> SHE1T, runner2 -> + (9)}"+
					 ENDING_GAME;

			    public static String CEB_STRING_230 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> 1B8 e8 , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_231 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B9 }" +
					 "action { batter -> 1B8 e8 , runner2 -> + (5) }" +
					 ENDING_GAME;

			    public static String CEB_STRING_232 = BASEBALL_STARTING_GAME +
					 "action { batter -> KS }" +
					 "action { batter -> 63 }" +
					 "action { batter -> E6T }" +
					 ENDING_GAME;

			    public static String CEB_STRING_233 = BASEBALL_STARTING_GAME +
					 "action { batter -> EF2 }" +
					 "action { batter -> F9 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_234 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B1 }" +
					 "action { batter -> 6E3, runner1 -> + }" +
					 "action { runner1 -> 13 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_235 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6F }" +
					 "action { batter -> O6, runner1 -> 64 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_236 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9 e9, runner1 -> ++ }" +
					 "action { batter -> KSWP , runner2 -> wp , runner3 -> wp }" +
					 ENDING_GAME;

			    public static String CEB_STRING_237 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B9, runner1 -> ++ }" +
					 "action { batter -> KL , runner1 -> wp , runner3 -> WP }" +
					 ENDING_GAME;

			    public static String CEB_STRING_238 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> e1T }" +
					 "action { batter -> KSWP , runner2 -> wp }" +
					 ENDING_GAME;

			    public static String CEB_STRING_239 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> WP }" +
					 "action { batter -> KS }" +
					 ENDING_GAME;

			    public static String CEB_STRING_240 = BASEBALL_STARTING_GAME +
					 "action { batter -> HP }" +
					 "action { runner1 -> PB }" +
					 "action { batter -> KSWP, runner2 -> wp }" +
					 ENDING_GAME;

			    public static String CEB_STRING_241 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> PB }" +
					 "action { batter -> KSWP, runner2 -> wp }" +
					 "action { batter -> HR8, runner1 -> +++ , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_242 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B9 }" +
					 "action { runner3 -> PB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_243 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 2B8 , runner1 -> ++ }" +
					 "action { batter -> SF8 , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_244 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B5 }" +
					 "action { batter -> 1B9 , runner1 -> ++ }" +
					 "action { runner1 -> SB , runner3 -> SB }" +
					 ENDING_GAME;

			    public static String CEB_STRING_245 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 2B8 , runner1 -> ++ }" +
					 "action { batter -> HP }" +
					 "action { batter -> FC62, runner1 -> + , runner2 -> + , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_246 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> 1B5 , runner1 -> + }" +
					 "action { batter -> 1B4 , runner1 -> + , runner2 -> +}" +
					 "action { batter -> BB, runner1 -> + , runner2 -> + , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_247 = BASEBALL_STARTING_GAME +
					 "action { batter -> E5T }" +
					 "action { batter -> 2B9 , runner1 -> +++ }" +
					 "action { batter -> KS }" +
					 "action { batter -> 1B9 , runner2 -> ++ }" +
					 "action { batter -> 63, runner1 -> + }" +
					 "action { batter -> F6 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_248 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> BB , runner1 -> + }" +
					 "action { batter -> SH13, runner1 -> +, runner2 -> +  }" +
					 "action { runner2 -> bk, runner3 -> BK }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> wp, runner3 -> WP }" +
					 ENDING_GAME;

			    public static String CEB_STRING_249 = BASEBALL_STARTING_GAME +
					 "action { batter -> EF2 }" +
					 "action { batter -> HR8 }" +
					 "action { batter -> KL }" +
					 "action { batter -> 3B9 }" +
					 "action { runner3 -> WP }" +
					 "action { batter -> KS }" +
					 "action { batter -> 3B8 }" +
					 "action { runner3 -> BK }" +
					 ENDING_GAME;

			    public static String CEB_STRING_250 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> O6, runner1 -> E6T }" +
					 "action { runner1 -> pb, runner2 -> PB }" +
					 "action { batter -> SF8, runner3 -> + }" +
					 "action { batter -> 1B8, runner2 -> ++ }" +
					 "action { batter -> KS }" +
					 "action { batter -> HR9 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_251 = BASEBALL_STARTING_GAME +
					 "action { batter -> 3B8 }" +
					 "action { batter -> E6F}" +
					 "action { runner1 -> SB , runner3 -> SB }" +
					 "action { batter -> KS }" +
					 "action { batter -> KL }" +
					 "action { batter -> 63 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_252 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B8 }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B9, runner1 -> +++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_253 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> O6 , runner1 -> 64 }" +
					 "action { batter -> 2B89 , runner1 -> +++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_254 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> O6 , runner1 -> 6E4 }" +
					 "action { batter -> 2B89  , runner1 -> +++ , runner2 -> ++}" +
					 ENDING_GAME;

			    public static String CEB_STRING_255 = BASEBALL_STARTING_GAME +
					 "action { batter -> 2B8 }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { runner2 -> 16 }" +
					 "action { batter -> BB  }" +
					 "action { batter -> 2B8 , runner1 -> +++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_256 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B8 T85, runner1 -> + 85  }" +
					 "action { batter -> 2B9 , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_257 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B8, runner1 -> +  }" +
					 "substitution visitor { player 1 (\"VISSAC M\") replaceBy \"MASSE T\" }" +
					 "action { batter -> O6 , runner1 -> + , runner2 -> 65 }" +
					 "action { batter -> O1 , runner1 -> + , runner2 -> 15 }" +
					 "action { batter -> HR9 , runner1 -> +++ , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_258 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B8, runner1 -> +  }" +
					 "action { batter -> O6 , runner1 -> O6 , runner2 -> 65 }" +
					 "action { batter -> 2B8 , runner1 -> +++ , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_259 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B8, runner1 -> +  }" +
					 "substitution visitor { player 1 (\"VISSAC M\") replaceBy \"MASSE T\" }" +
					 "action { batter -> O4 , runner1 -> 46 , runner2 -> + }" +
					 "action { batter -> O1 , runner1 -> + , runner3 -> 12 }" +
					 "action { batter -> HR9 , runner1 -> +++ , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_260 = BASEBALL_STARTING_GAME +
					 "action { batter -> F7 }" +
					 "action { batter -> E8F+ }" +
					 "action { batter -> 1B9 , runner2 -> + }" +
					 "action { batter -> SF8 , runner3 -> + }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> HR8 , runner1 -> +++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_261 = BASEBALL_STARTING_GAME +
					 "action { batter -> KS }" +
					 "action { batter -> 63 }" +
			         "action { batter -> BB }" +
			         "action { batter -> 6E3 , runner1 -> (4) }" +
			         "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
			         "action { batter -> HR8 , runner1 -> +++ , runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_262 = BASEBALL_STARTING_GAME +
					 "action { batter -> 63 }" +
					 "action { batter -> F8 }" +
					 "action { batter -> BB  }" +
					 "action { batter -> BB , runner1 -> + }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> E6T , runner1 -> (5), runner2 -> (5) }" +
					 "action { batter -> HR7 , runner1 -> +++ , runner2 -> ++ , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_263 = BASEBALL_STARTING_GAME +
					 "action { batter -> KS }" +
					 "action { batter -> E4 }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> FC14 , runner1 -> + , runner2 -> + }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> HR8 , runner1 -> +++ , runner2 -> ++ , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_264 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { batter -> E8F, runner1 -> (2) }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> HR7, runner1 -> +++ , runner2 -> ++ }" +
					 "action { batter -> KL }" +
					 "action { batter -> KS }" +
					 "action { batter -> E6 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_265 = BASEBALL_STARTING_GAME +
					 "action { batter -> E5 }" +
					 "substitution visitor { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> BB, runner1 -> + }" +
					 "action { batter -> O6, runner1 -> O6 , runner2 -> 65 }" +
					 "action { batter -> 1B9 , runner1 -> ++, runner2 -> ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_266 = BASEBALL_STARTING_GAME +
					 "action { batter -> E6T }" +
			     	 "action { batter -> BB, runner1 -> + }" +
					 "substitution hometeam { player 1 (\"DUBOIS J\") replaceBy \"VISSAC M\" }" +
					 "action { batter -> 1B7, runner1 -> + , runner2 -> + }" +
					 "action { batter -> O5, runner1 -> O5 , runner2 -> O5, runner3 -> 52 }" +
					 "action { batter -> O5 , runner1 -> O5 , runner2 -> O5,  runner3 -> 52 }" +
					 "action { batter -> HR7 , runner1 -> +++ , runner2 -> ++ , runner3 -> + }" +
					 "action { batter -> KS }" +
					 ENDING_GAME;

			    public static String CEB_STRING_267 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 e7 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_268 = BASEBALL_STARTING_GAME +
					 "action { batter -> E9F++ }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> O/2 }" +
					 ENDING_GAME;

			    public static String CEB_STRING_269 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B9 e9+ }" +
					 "action { batter -> BB }" +
					 "action { runner1 -> SB }" +
					 "action { batter -> 1B7, runner2 ->  ++ , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_270 = BASEBALL_STARTING_GAME +
					 "action { batter -> BB }" +
					 "action { runner1 -> e3 }" +
					 "action { batter -> KSWP , runner2 -> wp }" +
					 "action { batter -> HR7, runner1 ->  +++ , runner3 -> + }" +
					 ENDING_GAME;

			    public static String CEB_STRING_271 = BASEBALL_STARTING_GAME +
					 "action { batter -> E9F+ }" +
					 "action { batter -> 1B8 T82 , runner2 -> ++ }" +
					 "action { batter -> KS }" +
					 "action { batter -> 1B7, runner2 ->  ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_272 = BASEBALL_STARTING_GAME +
					 "action { batter -> F9 }" +
					 "action { batter -> 1B8 }" +
					 "action { batter -> KS }" +
					 "action { batter -> 1B7, runner1 ->  ++ }" +
					 ENDING_GAME;

			    public static String CEB_STRING_273 = BASEBALL_STARTING_GAME +
					 "action { batter -> 1B7 }" +
					 "action { batter -> EF3 }" +
					 "action { batter -> HR8, runner1 -> +++ }" +
					 ENDING_GAME;

}
