package org.bpy.score.engine.tests;




public class ActionStatsTest {

//	public ActionStatsTest() {
//	      com.google.inject.Injector injector = new GameStandaloneSetup().createInjectorAndDoEMFRegistration();
//	      injector.injectMembers(this);
//	}
//	
//	@Inject private IParser parser;
//	@Inject @Extension private ValidationTestHelper _validationTestHelper;
//	
//	@Test
//	public void checkStatBatterBalk() throws Exception {
//
//		StringBuilder str = new StringBuilder(CommonResources.BASEBALL_STARTING_GAME);
//      	str.append("action { batter -> BK}");
//      	str.append(CommonResources.ENDING_GAME);
//      	
//      	StatisticManager statisticManager = getStatisticManager(str.toString());
//      	TeamStatistic hometeamStats = statisticManager.getStats().getHometeam();
//      	PitcherStatistic pitcherStatistic = hometeamStats.getCurrentPitcher().getPitcherStatistic();
//      	
//      	Assertions.assertEquals(1, pitcherStatistic.getAtBats(), "Atbats check value");
//      	Assertions.assertEquals(1, pitcherStatistic.getBalks(), "Balks check value");
//	}
//	
//	private StatisticManager getStatisticManager(String description) throws Exception {
//		IParseResult parserResult = parser.parse(new StringReader(description));
//      	
//      	StatisticEngine engine = new StatisticEngine();
//      	engine.setGame((Game) parserResult.getRootASTElement());
//      	engine.run();
//
//      	return engine.getStatisticManager();
//	}
}
