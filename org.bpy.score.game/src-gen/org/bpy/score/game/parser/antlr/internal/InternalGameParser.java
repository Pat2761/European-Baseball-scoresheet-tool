package org.bpy.score.game.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.bpy.score.game.services.GameGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGameParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_EXECUTE", "RULE_MUST_BE_OUT_ON_ERROR", "RULE_ADVANCE_ON_ERROR", "RULE_PICK_OFF_WITH_ERROR", "RULE_CAUGTH_STEALING_WITH_ERROR", "RULE_REACH_ON_THROW_ERROR", "RULE_REACH_ON_RECEIVE_ERROR", "RULE_EXTRA_ON_THROW_ERROR", "RULE_EXTRA_ON_RECEIVE_ERROR", "RULE_CAUGTH_STEALING", "RULE_PICK_OFF", "RULE_OUT_BY_RULE", "RULE_APPEAL", "RULE_ADVANCE", "RULE_STOLEN_BASE", "RULE_WILD_PITCH", "RULE_PASS_BALL", "RULE_BALK", "RULE_FIELDER_CHOICE_WITH_PUTOUT", "RULE_NO_DECISIVE_OBSTRUCTION", "RULE_DECISIVE_OBSTRUCTION", "RULE_ADVANCE_ON_THROW", "RULE_INDIFERENCE", "RULE_ADVANCE_BY_RULE", "RULE_ADVANCE_BY_OTHER_PLAYER_EROR", "RULE_FIELDER_CHOICE", "RULE_LATERALITY", "RULE_LOST_TURN", "RULE_EXTRA_ON_FLY_ERROR", "RULE_BASE_ON_BALL", "RULE_INTENTIONAL_BASE_ON_BALL", "RULE_HIT_BY_PITCH", "RULE_K_PASS_BALL", "RULE_K_WILD_PITCH", "RULE_K_ADVANCE_BY_RULE", "RULE_K_WITH_ERROR", "RULE_SACRIFICE_BUNT_WITH_ERROR", "RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE", "RULE_SACRIFICE_FLY_WITH_ERROR", "RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE", "RULE_CATCHER_INTERFERENCE", "RULE_INTERFERENCE", "RULE_K_ADVANCE_BY_FIELDER_CHOCE", "RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE", "RULE_SINGLE", "RULE_DOUBLE", "RULE_TRIPLE", "RULE_HOMERUN", "RULE_INSIDE_PARK", "RULE_REACH_ON_FLY_ERROR", "RULE_REACH_ON_POP_ERROR", "RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR", "RULE_FLYED_OUT", "RULE_LINE_OUT", "RULE_POPPED_OUT", "RULE_FLYED_FALLBALL_OUT", "RULE_POPPED_FALLBALL_OUT", "RULE_LINE_FALLBALL_OUT", "RULE_GROUNDED_DOUBLE_PLAY_OUT", "RULE_SACRIFICE_FLY", "RULE_SACRIFICE_FLY_FOUL_BALL", "RULE_SACRIFICE_BUNT", "RULE_INFIELD_FLY", "RULE_SWING_STRIKE_OUT", "RULE_LOOKED_STRIKE_OUT", "RULE_RELEASED_STRIKE_OUT", "RULE_BATTER", "RULE_RUNNER", "RULE_DESIGNAATED_HITTER", "RULE_PITCH_RUNNER_WITH_POSITION", "RULE_DESIGNATED_PITCHER", "RULE_PITCH_HITTER_WITH_POSITION", "RULE_PITCH_RUNNER", "RULE_PITCH_HITTER", "RULE_SPECIAL_LOCATION", "RULE_UNASSIST_OUT", "RULE_DOUBLE_PLAY", "RULE_TRIPLE_PLAY", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'game'", "'{'", "'}'", "'forfeit'", "';'", "'gameEntry'", "'gameResume'", "'win'", "'='", "'lose'", "'save'", "'inning'", "'number'", "'graphicalCommand'", "'columnNumber'", "'selectBatter'", "'note'", "'specialSituation'", "'tieBreak'", "'action'", "','", "'noAdvance'", "'on'", "'dontCountAsDoublePlay'", "'earned'", "'unEarnedForTeam'", "'substitution'", "'player'", "'('", "')'", "'moveTo'", "'laterality'", "'replaceBy'", "'shirtNumber'", "'at'", "'b'", "'lineup'", "'name'", "'defensivePosition'", "'B'", "'k'", "'K'", "'s'", "'S'", "'h'", "'H'", "'f'", "'F'", "'.'", "'roster'", "'header'", "'tournament'", "'stadium'", "'place'", "'date'", "'startTime'", "'endTime'", "'duration'", "'category'", "'type'", "'notes'", "'scorekeepers'", "'umpires'", "'visitor'", "'hometeam'", "'baseball'", "'softball'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__145=145;
    public static final int RULE_LINE_FALLBALL_OUT=63;
    public static final int T__140=140;
    public static final int RULE_SPECIAL_LOCATION=80;
    public static final int T__142=142;
    public static final int RULE_RUNNER=73;
    public static final int T__141=141;
    public static final int RULE_ADVANCE_ON_ERROR=8;
    public static final int RULE_FIELDER_CHOICE_WITH_PUTOUT=24;
    public static final int RULE_SINGLE=50;
    public static final int RULE_DECISIVE_OBSTRUCTION=26;
    public static final int RULE_PITCH_RUNNER_WITH_POSITION=75;
    public static final int RULE_REACH_ON_RECEIVE_ERROR=12;
    public static final int RULE_TRIPLE=52;
    public static final int RULE_DESIGNAATED_HITTER=74;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int RULE_ADVANCE_BY_RULE=29;
    public static final int RULE_PITCH_HITTER_WITH_POSITION=77;
    public static final int RULE_TRIPLE_PLAY=83;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int RULE_ID=84;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_HIT_BY_PITCH=37;
    public static final int RULE_POPPED_OUT=60;
    public static final int RULE_OUT_BY_RULE=17;
    public static final int RULE_K_WILD_PITCH=39;
    public static final int RULE_PITCH_RUNNER=78;
    public static final int RULE_RELEASED_STRIKE_OUT=71;
    public static final int RULE_INT=5;
    public static final int RULE_SACRIFICE_BUNT=67;
    public static final int RULE_ML_COMMENT=85;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int RULE_WILD_PITCH=21;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int RULE_BALK=23;
    public static final int RULE_EXTRA_ON_THROW_ERROR=13;
    public static final int RULE_STOLEN_BASE=20;
    public static final int RULE_DOUBLE_PLAY=82;
    public static final int RULE_INTENTIONAL_BASE_ON_BALL=36;
    public static final int RULE_INTERFERENCE=47;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int RULE_SACRIFICE_BUNT_WITH_ERROR=42;
    public static final int RULE_INSIDE_PARK=54;
    public static final int RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR=57;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int RULE_LOST_TURN=33;
    public static final int RULE_EXTRA_ON_FLY_ERROR=34;
    public static final int RULE_FLYED_OUT=58;
    public static final int RULE_PICK_OFF_WITH_ERROR=9;
    public static final int RULE_K_WITH_ERROR=41;
    public static final int RULE_REACH_ON_THROW_ERROR=11;
    public static final int RULE_K_ADVANCE_BY_RULE=40;
    public static final int RULE_HOMERUN=53;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_EXTRA_ON_RECEIVE_ERROR=14;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_SACRIFICE_FLY_FOUL_BALL=66;
    public static final int RULE_NO_DECISIVE_OBSTRUCTION=25;
    public static final int RULE_FIELDER_CHOICE=31;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int RULE_CATCHER_INTERFERENCE=46;
    public static final int T__98=98;
    public static final int RULE_REACH_ON_POP_ERROR=56;
    public static final int RULE_PICK_OFF=16;
    public static final int RULE_INDIFERENCE=28;
    public static final int RULE_CAUGTH_STEALING=15;
    public static final int RULE_K_PASS_BALL=38;
    public static final int RULE_PASS_BALL=22;
    public static final int RULE_GROUNDED_DOUBLE_PLAY_OUT=64;
    public static final int RULE_APPEAL=18;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int RULE_ADVANCE_BY_OTHER_PLAYER_EROR=30;
    public static final int T__123=123;
    public static final int RULE_K_ADVANCE_BY_FIELDER_CHOCE=48;
    public static final int RULE_SACRIFICE_FLY=65;
    public static final int RULE_BASE_ON_BALL=35;
    public static final int T__120=120;
    public static final int RULE_LOOKED_STRIKE_OUT=70;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=86;
    public static final int RULE_DESIGNATED_PITCHER=76;
    public static final int RULE_SWING_STRIKE_OUT=69;
    public static final int RULE_DOUBLE=51;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int RULE_LINE_OUT=59;
    public static final int RULE_EXECUTE=6;
    public static final int RULE_REACH_ON_FLY_ERROR=55;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE=45;
    public static final int T__116=116;
    public static final int RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE=49;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_ADVANCE=19;
    public static final int T__113=113;
    public static final int RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE=43;
    public static final int T__112=112;
    public static final int RULE_WS=87;
    public static final int RULE_FLYED_FALLBALL_OUT=61;
    public static final int RULE_ADVANCE_ON_THROW=27;
    public static final int RULE_SACRIFICE_FLY_WITH_ERROR=44;
    public static final int RULE_ANY_OTHER=88;
    public static final int RULE_UNASSIST_OUT=81;
    public static final int RULE_LATERALITY=32;
    public static final int RULE_CAUGTH_STEALING_WITH_ERROR=10;
    public static final int RULE_INFIELD_FLY=68;
    public static final int T__108=108;
    public static final int RULE_POPPED_FALLBALL_OUT=62;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int RULE_MUST_BE_OUT_ON_ERROR=7;
    public static final int T__104=104;
    public static final int RULE_PITCH_HITTER=79;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int RULE_BATTER=72;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalGameParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGameParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGameParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGame.g"; }



     	private GameGrammarAccess grammarAccess;

        public InternalGameParser(TokenStream input, GameGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Game";
       	}

       	@Override
       	protected GameGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGame"
    // InternalGame.g:64:1: entryRuleGame returns [EObject current=null] : iv_ruleGame= ruleGame EOF ;
    public final EObject entryRuleGame() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGame = null;


        try {
            // InternalGame.g:64:45: (iv_ruleGame= ruleGame EOF )
            // InternalGame.g:65:2: iv_ruleGame= ruleGame EOF
            {
             newCompositeNode(grammarAccess.getGameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGame=ruleGame();

            state._fsp--;

             current =iv_ruleGame; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGame"


    // $ANTLR start "ruleGame"
    // InternalGame.g:71:1: ruleGame returns [EObject current=null] : (otherlv_0= 'game' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_description_3_0= ruleDescription ) ) ( (lv_visitor_4_0= ruleRoster ) ) ( (lv_hometeam_5_0= ruleRoster ) ) ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) ) otherlv_8= '}' ) ;
    public final EObject ruleGame() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        EObject lv_description_3_0 = null;

        EObject lv_visitor_4_0 = null;

        EObject lv_hometeam_5_0 = null;

        EObject lv_forfeitGame_6_0 = null;

        EObject lv_actions_7_0 = null;



        	enterRule();

        try {
            // InternalGame.g:77:2: ( (otherlv_0= 'game' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_description_3_0= ruleDescription ) ) ( (lv_visitor_4_0= ruleRoster ) ) ( (lv_hometeam_5_0= ruleRoster ) ) ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) ) otherlv_8= '}' ) )
            // InternalGame.g:78:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_description_3_0= ruleDescription ) ) ( (lv_visitor_4_0= ruleRoster ) ) ( (lv_hometeam_5_0= ruleRoster ) ) ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) ) otherlv_8= '}' )
            {
            // InternalGame.g:78:2: (otherlv_0= 'game' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_description_3_0= ruleDescription ) ) ( (lv_visitor_4_0= ruleRoster ) ) ( (lv_hometeam_5_0= ruleRoster ) ) ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) ) otherlv_8= '}' )
            // InternalGame.g:79:3: otherlv_0= 'game' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_description_3_0= ruleDescription ) ) ( (lv_visitor_4_0= ruleRoster ) ) ( (lv_hometeam_5_0= ruleRoster ) ) ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGameAccess().getGameKeyword_0());
            		
            // InternalGame.g:83:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalGame.g:84:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalGame.g:84:4: (lv_name_1_0= RULE_STRING )
            // InternalGame.g:85:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGameAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,90,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGameAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGame.g:105:3: ( (lv_description_3_0= ruleDescription ) )
            // InternalGame.g:106:4: (lv_description_3_0= ruleDescription )
            {
            // InternalGame.g:106:4: (lv_description_3_0= ruleDescription )
            // InternalGame.g:107:5: lv_description_3_0= ruleDescription
            {

            					newCompositeNode(grammarAccess.getGameAccess().getDescriptionDescriptionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_description_3_0=ruleDescription();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"description",
            						lv_description_3_0,
            						"org.bpy.score.game.Game.Description");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:124:3: ( (lv_visitor_4_0= ruleRoster ) )
            // InternalGame.g:125:4: (lv_visitor_4_0= ruleRoster )
            {
            // InternalGame.g:125:4: (lv_visitor_4_0= ruleRoster )
            // InternalGame.g:126:5: lv_visitor_4_0= ruleRoster
            {

            					newCompositeNode(grammarAccess.getGameAccess().getVisitorRosterParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_visitor_4_0=ruleRoster();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"visitor",
            						lv_visitor_4_0,
            						"org.bpy.score.game.Game.Roster");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:143:3: ( (lv_hometeam_5_0= ruleRoster ) )
            // InternalGame.g:144:4: (lv_hometeam_5_0= ruleRoster )
            {
            // InternalGame.g:144:4: (lv_hometeam_5_0= ruleRoster )
            // InternalGame.g:145:5: lv_hometeam_5_0= ruleRoster
            {

            					newCompositeNode(grammarAccess.getGameAccess().getHometeamRosterParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_7);
            lv_hometeam_5_0=ruleRoster();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGameRule());
            					}
            					set(
            						current,
            						"hometeam",
            						lv_hometeam_5_0,
            						"org.bpy.score.game.Game.Roster");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:162:3: ( ( (lv_forfeitGame_6_0= ruleForfeitGame ) ) | ( (lv_actions_7_0= ruleActions ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==92) ) {
                alt1=1;
            }
            else if ( (LA1_0==94) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalGame.g:163:4: ( (lv_forfeitGame_6_0= ruleForfeitGame ) )
                    {
                    // InternalGame.g:163:4: ( (lv_forfeitGame_6_0= ruleForfeitGame ) )
                    // InternalGame.g:164:5: (lv_forfeitGame_6_0= ruleForfeitGame )
                    {
                    // InternalGame.g:164:5: (lv_forfeitGame_6_0= ruleForfeitGame )
                    // InternalGame.g:165:6: lv_forfeitGame_6_0= ruleForfeitGame
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getForfeitGameForfeitGameParserRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_forfeitGame_6_0=ruleForfeitGame();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						set(
                    							current,
                    							"forfeitGame",
                    							lv_forfeitGame_6_0,
                    							"org.bpy.score.game.Game.ForfeitGame");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:183:4: ( (lv_actions_7_0= ruleActions ) )
                    {
                    // InternalGame.g:183:4: ( (lv_actions_7_0= ruleActions ) )
                    // InternalGame.g:184:5: (lv_actions_7_0= ruleActions )
                    {
                    // InternalGame.g:184:5: (lv_actions_7_0= ruleActions )
                    // InternalGame.g:185:6: lv_actions_7_0= ruleActions
                    {

                    						newCompositeNode(grammarAccess.getGameAccess().getActionsActionsParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_actions_7_0=ruleActions();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGameRule());
                    						}
                    						set(
                    							current,
                    							"actions",
                    							lv_actions_7_0,
                    							"org.bpy.score.game.Game.Actions");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getGameAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGame"


    // $ANTLR start "entryRuleForfeitGame"
    // InternalGame.g:211:1: entryRuleForfeitGame returns [EObject current=null] : iv_ruleForfeitGame= ruleForfeitGame EOF ;
    public final EObject entryRuleForfeitGame() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForfeitGame = null;


        try {
            // InternalGame.g:211:52: (iv_ruleForfeitGame= ruleForfeitGame EOF )
            // InternalGame.g:212:2: iv_ruleForfeitGame= ruleForfeitGame EOF
            {
             newCompositeNode(grammarAccess.getForfeitGameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForfeitGame=ruleForfeitGame();

            state._fsp--;

             current =iv_ruleForfeitGame; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForfeitGame"


    // $ANTLR start "ruleForfeitGame"
    // InternalGame.g:218:1: ruleForfeitGame returns [EObject current=null] : (otherlv_0= 'forfeit' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= ';' ) ;
    public final EObject ruleForfeitGame() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_team_1_0 = null;



        	enterRule();

        try {
            // InternalGame.g:224:2: ( (otherlv_0= 'forfeit' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= ';' ) )
            // InternalGame.g:225:2: (otherlv_0= 'forfeit' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= ';' )
            {
            // InternalGame.g:225:2: (otherlv_0= 'forfeit' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= ';' )
            // InternalGame.g:226:3: otherlv_0= 'forfeit' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getForfeitGameAccess().getForfeitKeyword_0());
            		
            // InternalGame.g:230:3: ( (lv_team_1_0= ruleTeamTypeEnum ) )
            // InternalGame.g:231:4: (lv_team_1_0= ruleTeamTypeEnum )
            {
            // InternalGame.g:231:4: (lv_team_1_0= ruleTeamTypeEnum )
            // InternalGame.g:232:5: lv_team_1_0= ruleTeamTypeEnum
            {

            					newCompositeNode(grammarAccess.getForfeitGameAccess().getTeamTeamTypeEnumParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_team_1_0=ruleTeamTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForfeitGameRule());
            					}
            					set(
            						current,
            						"team",
            						lv_team_1_0,
            						"org.bpy.score.game.Game.TeamTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getForfeitGameAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForfeitGame"


    // $ANTLR start "entryRuleActions"
    // InternalGame.g:257:1: entryRuleActions returns [EObject current=null] : iv_ruleActions= ruleActions EOF ;
    public final EObject entryRuleActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActions = null;


        try {
            // InternalGame.g:257:48: (iv_ruleActions= ruleActions EOF )
            // InternalGame.g:258:2: iv_ruleActions= ruleActions EOF
            {
             newCompositeNode(grammarAccess.getActionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActions=ruleActions();

            state._fsp--;

             current =iv_ruleActions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActions"


    // $ANTLR start "ruleActions"
    // InternalGame.g:264:1: ruleActions returns [EObject current=null] : (otherlv_0= 'gameEntry' otherlv_1= '{' ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? ) otherlv_5= '}' ) ;
    public final EObject ruleActions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_lineup_2_0 = null;

        EObject lv_halfInnings_3_0 = null;

        EObject lv_gameResume_4_0 = null;



        	enterRule();

        try {
            // InternalGame.g:270:2: ( (otherlv_0= 'gameEntry' otherlv_1= '{' ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? ) otherlv_5= '}' ) )
            // InternalGame.g:271:2: (otherlv_0= 'gameEntry' otherlv_1= '{' ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? ) otherlv_5= '}' )
            {
            // InternalGame.g:271:2: (otherlv_0= 'gameEntry' otherlv_1= '{' ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? ) otherlv_5= '}' )
            // InternalGame.g:272:3: otherlv_0= 'gameEntry' otherlv_1= '{' ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getActionsAccess().getGameEntryKeyword_0());
            		
            otherlv_1=(Token)match(input,90,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getActionsAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalGame.g:280:3: ( ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )? )
            // InternalGame.g:281:4: ( (lv_lineup_2_0= ruleLineUp ) )+ ( (lv_halfInnings_3_0= ruleHalfInning ) )* ( (lv_gameResume_4_0= ruleGameResume ) )?
            {
            // InternalGame.g:281:4: ( (lv_lineup_2_0= ruleLineUp ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==125) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGame.g:282:5: (lv_lineup_2_0= ruleLineUp )
            	    {
            	    // InternalGame.g:282:5: (lv_lineup_2_0= ruleLineUp )
            	    // InternalGame.g:283:6: lv_lineup_2_0= ruleLineUp
            	    {

            	    						newCompositeNode(grammarAccess.getActionsAccess().getLineupLineUpParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_lineup_2_0=ruleLineUp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getActionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"lineup",
            	    							lv_lineup_2_0,
            	    							"org.bpy.score.game.Game.LineUp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalGame.g:300:4: ( (lv_halfInnings_3_0= ruleHalfInning ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==100) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGame.g:301:5: (lv_halfInnings_3_0= ruleHalfInning )
            	    {
            	    // InternalGame.g:301:5: (lv_halfInnings_3_0= ruleHalfInning )
            	    // InternalGame.g:302:6: lv_halfInnings_3_0= ruleHalfInning
            	    {

            	    						newCompositeNode(grammarAccess.getActionsAccess().getHalfInningsHalfInningParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_halfInnings_3_0=ruleHalfInning();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getActionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"halfInnings",
            	    							lv_halfInnings_3_0,
            	    							"org.bpy.score.game.Game.HalfInning");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalGame.g:319:4: ( (lv_gameResume_4_0= ruleGameResume ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==95) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalGame.g:320:5: (lv_gameResume_4_0= ruleGameResume )
                    {
                    // InternalGame.g:320:5: (lv_gameResume_4_0= ruleGameResume )
                    // InternalGame.g:321:6: lv_gameResume_4_0= ruleGameResume
                    {

                    						newCompositeNode(grammarAccess.getActionsAccess().getGameResumeGameResumeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_gameResume_4_0=ruleGameResume();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionsRule());
                    						}
                    						set(
                    							current,
                    							"gameResume",
                    							lv_gameResume_4_0,
                    							"org.bpy.score.game.Game.GameResume");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }
                    break;

            }


            }

            otherlv_5=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getActionsAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActions"


    // $ANTLR start "entryRuleGameResume"
    // InternalGame.g:347:1: entryRuleGameResume returns [EObject current=null] : iv_ruleGameResume= ruleGameResume EOF ;
    public final EObject entryRuleGameResume() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGameResume = null;


        try {
            // InternalGame.g:347:51: (iv_ruleGameResume= ruleGameResume EOF )
            // InternalGame.g:348:2: iv_ruleGameResume= ruleGameResume EOF
            {
             newCompositeNode(grammarAccess.getGameResumeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGameResume=ruleGameResume();

            state._fsp--;

             current =iv_ruleGameResume; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGameResume"


    // $ANTLR start "ruleGameResume"
    // InternalGame.g:354:1: ruleGameResume returns [EObject current=null] : (otherlv_0= 'gameResume' otherlv_1= '{' otherlv_2= 'win' otherlv_3= '=' ( (lv_win_4_0= RULE_STRING ) ) otherlv_5= ';' otherlv_6= 'lose' otherlv_7= '=' ( (lv_lose_8_0= RULE_STRING ) ) otherlv_9= ';' (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )? otherlv_14= '}' ) ;
    public final EObject ruleGameResume() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_win_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_lose_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_save_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalGame.g:360:2: ( (otherlv_0= 'gameResume' otherlv_1= '{' otherlv_2= 'win' otherlv_3= '=' ( (lv_win_4_0= RULE_STRING ) ) otherlv_5= ';' otherlv_6= 'lose' otherlv_7= '=' ( (lv_lose_8_0= RULE_STRING ) ) otherlv_9= ';' (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )? otherlv_14= '}' ) )
            // InternalGame.g:361:2: (otherlv_0= 'gameResume' otherlv_1= '{' otherlv_2= 'win' otherlv_3= '=' ( (lv_win_4_0= RULE_STRING ) ) otherlv_5= ';' otherlv_6= 'lose' otherlv_7= '=' ( (lv_lose_8_0= RULE_STRING ) ) otherlv_9= ';' (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )? otherlv_14= '}' )
            {
            // InternalGame.g:361:2: (otherlv_0= 'gameResume' otherlv_1= '{' otherlv_2= 'win' otherlv_3= '=' ( (lv_win_4_0= RULE_STRING ) ) otherlv_5= ';' otherlv_6= 'lose' otherlv_7= '=' ( (lv_lose_8_0= RULE_STRING ) ) otherlv_9= ';' (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )? otherlv_14= '}' )
            // InternalGame.g:362:3: otherlv_0= 'gameResume' otherlv_1= '{' otherlv_2= 'win' otherlv_3= '=' ( (lv_win_4_0= RULE_STRING ) ) otherlv_5= ';' otherlv_6= 'lose' otherlv_7= '=' ( (lv_lose_8_0= RULE_STRING ) ) otherlv_9= ';' (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )? otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getGameResumeAccess().getGameResumeKeyword_0());
            		
            otherlv_1=(Token)match(input,90,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getGameResumeAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,96,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getGameResumeAccess().getWinKeyword_2());
            		
            otherlv_3=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getGameResumeAccess().getEqualsSignKeyword_3());
            		
            // InternalGame.g:378:3: ( (lv_win_4_0= RULE_STRING ) )
            // InternalGame.g:379:4: (lv_win_4_0= RULE_STRING )
            {
            // InternalGame.g:379:4: (lv_win_4_0= RULE_STRING )
            // InternalGame.g:380:5: lv_win_4_0= RULE_STRING
            {
            lv_win_4_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_win_4_0, grammarAccess.getGameResumeAccess().getWinSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameResumeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"win",
            						lv_win_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,93,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getGameResumeAccess().getSemicolonKeyword_5());
            		
            otherlv_6=(Token)match(input,98,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getGameResumeAccess().getLoseKeyword_6());
            		
            otherlv_7=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getGameResumeAccess().getEqualsSignKeyword_7());
            		
            // InternalGame.g:408:3: ( (lv_lose_8_0= RULE_STRING ) )
            // InternalGame.g:409:4: (lv_lose_8_0= RULE_STRING )
            {
            // InternalGame.g:409:4: (lv_lose_8_0= RULE_STRING )
            // InternalGame.g:410:5: lv_lose_8_0= RULE_STRING
            {
            lv_lose_8_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_lose_8_0, grammarAccess.getGameResumeAccess().getLoseSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGameResumeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"lose",
            						lv_lose_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,93,FOLLOW_17); 

            			newLeafNode(otherlv_9, grammarAccess.getGameResumeAccess().getSemicolonKeyword_9());
            		
            // InternalGame.g:430:3: (otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==99) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGame.g:431:4: otherlv_10= 'save' otherlv_11= '=' ( (lv_save_12_0= RULE_STRING ) ) otherlv_13= ';'
                    {
                    otherlv_10=(Token)match(input,99,FOLLOW_15); 

                    				newLeafNode(otherlv_10, grammarAccess.getGameResumeAccess().getSaveKeyword_10_0());
                    			
                    otherlv_11=(Token)match(input,97,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getGameResumeAccess().getEqualsSignKeyword_10_1());
                    			
                    // InternalGame.g:439:4: ( (lv_save_12_0= RULE_STRING ) )
                    // InternalGame.g:440:5: (lv_save_12_0= RULE_STRING )
                    {
                    // InternalGame.g:440:5: (lv_save_12_0= RULE_STRING )
                    // InternalGame.g:441:6: lv_save_12_0= RULE_STRING
                    {
                    lv_save_12_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

                    						newLeafNode(lv_save_12_0, grammarAccess.getGameResumeAccess().getSaveSTRINGTerminalRuleCall_10_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGameResumeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"save",
                    							lv_save_12_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,93,FOLLOW_8); 

                    				newLeafNode(otherlv_13, grammarAccess.getGameResumeAccess().getSemicolonKeyword_10_3());
                    			

                    }
                    break;

            }

            otherlv_14=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getGameResumeAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGameResume"


    // $ANTLR start "entryRuleHalfInning"
    // InternalGame.g:470:1: entryRuleHalfInning returns [EObject current=null] : iv_ruleHalfInning= ruleHalfInning EOF ;
    public final EObject entryRuleHalfInning() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHalfInning = null;


        try {
            // InternalGame.g:470:51: (iv_ruleHalfInning= ruleHalfInning EOF )
            // InternalGame.g:471:2: iv_ruleHalfInning= ruleHalfInning EOF
            {
             newCompositeNode(grammarAccess.getHalfInningRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHalfInning=ruleHalfInning();

            state._fsp--;

             current =iv_ruleHalfInning; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHalfInning"


    // $ANTLR start "ruleHalfInning"
    // InternalGame.g:477:1: ruleHalfInning returns [EObject current=null] : (otherlv_0= 'inning' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= 'number' ( (lv_number_3_0= RULE_INT ) ) otherlv_4= '{' ( (lv_inningSetting_5_0= ruleInningSetting ) )* ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleHalfInning() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_number_3_0=null;
        Token otherlv_4=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_team_1_0 = null;

        EObject lv_inningSetting_5_0 = null;

        EObject lv_inningElements_6_0 = null;

        EObject lv_inningElements_7_0 = null;

        EObject lv_inningElements_8_0 = null;

        EObject lv_notes_9_0 = null;



        	enterRule();

        try {
            // InternalGame.g:483:2: ( (otherlv_0= 'inning' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= 'number' ( (lv_number_3_0= RULE_INT ) ) otherlv_4= '{' ( (lv_inningSetting_5_0= ruleInningSetting ) )* ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )* otherlv_10= '}' ) )
            // InternalGame.g:484:2: (otherlv_0= 'inning' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= 'number' ( (lv_number_3_0= RULE_INT ) ) otherlv_4= '{' ( (lv_inningSetting_5_0= ruleInningSetting ) )* ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )* otherlv_10= '}' )
            {
            // InternalGame.g:484:2: (otherlv_0= 'inning' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= 'number' ( (lv_number_3_0= RULE_INT ) ) otherlv_4= '{' ( (lv_inningSetting_5_0= ruleInningSetting ) )* ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )* otherlv_10= '}' )
            // InternalGame.g:485:3: otherlv_0= 'inning' ( (lv_team_1_0= ruleTeamTypeEnum ) ) otherlv_2= 'number' ( (lv_number_3_0= RULE_INT ) ) otherlv_4= '{' ( (lv_inningSetting_5_0= ruleInningSetting ) )* ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )* otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHalfInningAccess().getInningKeyword_0());
            		
            // InternalGame.g:489:3: ( (lv_team_1_0= ruleTeamTypeEnum ) )
            // InternalGame.g:490:4: (lv_team_1_0= ruleTeamTypeEnum )
            {
            // InternalGame.g:490:4: (lv_team_1_0= ruleTeamTypeEnum )
            // InternalGame.g:491:5: lv_team_1_0= ruleTeamTypeEnum
            {

            					newCompositeNode(grammarAccess.getHalfInningAccess().getTeamTeamTypeEnumParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_team_1_0=ruleTeamTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHalfInningRule());
            					}
            					set(
            						current,
            						"team",
            						lv_team_1_0,
            						"org.bpy.score.game.Game.TeamTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,101,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getHalfInningAccess().getNumberKeyword_2());
            		
            // InternalGame.g:512:3: ( (lv_number_3_0= RULE_INT ) )
            // InternalGame.g:513:4: (lv_number_3_0= RULE_INT )
            {
            // InternalGame.g:513:4: (lv_number_3_0= RULE_INT )
            // InternalGame.g:514:5: lv_number_3_0= RULE_INT
            {
            lv_number_3_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            					newLeafNode(lv_number_3_0, grammarAccess.getHalfInningAccess().getNumberINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHalfInningRule());
            					}
            					setWithLastConsumed(
            						current,
            						"number",
            						lv_number_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,90,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getHalfInningAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalGame.g:534:3: ( (lv_inningSetting_5_0= ruleInningSetting ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==106) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalGame.g:535:4: (lv_inningSetting_5_0= ruleInningSetting )
            	    {
            	    // InternalGame.g:535:4: (lv_inningSetting_5_0= ruleInningSetting )
            	    // InternalGame.g:536:5: lv_inningSetting_5_0= ruleInningSetting
            	    {

            	    					newCompositeNode(grammarAccess.getHalfInningAccess().getInningSettingInningSettingParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_inningSetting_5_0=ruleInningSetting();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHalfInningRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inningSetting",
            	    						lv_inningSetting_5_0,
            	    						"org.bpy.score.game.Game.InningSetting");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalGame.g:553:3: ( ( (lv_inningElements_6_0= ruleSubstitutionEvent ) ) | ( (lv_inningElements_7_0= ruleAction ) ) | ( (lv_inningElements_8_0= ruleCommands ) ) | ( (lv_notes_9_0= ruleNote ) ) )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case 115:
                case 116:
                    {
                    alt7=1;
                    }
                    break;
                case RULE_INT:
                case 108:
                case 124:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                    {
                    alt7=2;
                    }
                    break;
                case 102:
                    {
                    alt7=3;
                    }
                    break;
                case 105:
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // InternalGame.g:554:4: ( (lv_inningElements_6_0= ruleSubstitutionEvent ) )
            	    {
            	    // InternalGame.g:554:4: ( (lv_inningElements_6_0= ruleSubstitutionEvent ) )
            	    // InternalGame.g:555:5: (lv_inningElements_6_0= ruleSubstitutionEvent )
            	    {
            	    // InternalGame.g:555:5: (lv_inningElements_6_0= ruleSubstitutionEvent )
            	    // InternalGame.g:556:6: lv_inningElements_6_0= ruleSubstitutionEvent
            	    {

            	    						newCompositeNode(grammarAccess.getHalfInningAccess().getInningElementsSubstitutionEventParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_inningElements_6_0=ruleSubstitutionEvent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getHalfInningRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inningElements",
            	    							lv_inningElements_6_0,
            	    							"org.bpy.score.game.Game.SubstitutionEvent");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGame.g:574:4: ( (lv_inningElements_7_0= ruleAction ) )
            	    {
            	    // InternalGame.g:574:4: ( (lv_inningElements_7_0= ruleAction ) )
            	    // InternalGame.g:575:5: (lv_inningElements_7_0= ruleAction )
            	    {
            	    // InternalGame.g:575:5: (lv_inningElements_7_0= ruleAction )
            	    // InternalGame.g:576:6: lv_inningElements_7_0= ruleAction
            	    {

            	    						newCompositeNode(grammarAccess.getHalfInningAccess().getInningElementsActionParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_inningElements_7_0=ruleAction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getHalfInningRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inningElements",
            	    							lv_inningElements_7_0,
            	    							"org.bpy.score.game.Game.Action");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalGame.g:594:4: ( (lv_inningElements_8_0= ruleCommands ) )
            	    {
            	    // InternalGame.g:594:4: ( (lv_inningElements_8_0= ruleCommands ) )
            	    // InternalGame.g:595:5: (lv_inningElements_8_0= ruleCommands )
            	    {
            	    // InternalGame.g:595:5: (lv_inningElements_8_0= ruleCommands )
            	    // InternalGame.g:596:6: lv_inningElements_8_0= ruleCommands
            	    {

            	    						newCompositeNode(grammarAccess.getHalfInningAccess().getInningElementsCommandsParserRuleCall_6_2_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_inningElements_8_0=ruleCommands();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getHalfInningRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inningElements",
            	    							lv_inningElements_8_0,
            	    							"org.bpy.score.game.Game.Commands");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalGame.g:614:4: ( (lv_notes_9_0= ruleNote ) )
            	    {
            	    // InternalGame.g:614:4: ( (lv_notes_9_0= ruleNote ) )
            	    // InternalGame.g:615:5: (lv_notes_9_0= ruleNote )
            	    {
            	    // InternalGame.g:615:5: (lv_notes_9_0= ruleNote )
            	    // InternalGame.g:616:6: lv_notes_9_0= ruleNote
            	    {

            	    						newCompositeNode(grammarAccess.getHalfInningAccess().getNotesNoteParserRuleCall_6_3_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_notes_9_0=ruleNote();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getHalfInningRule());
            	    						}
            	    						add(
            	    							current,
            	    							"notes",
            	    							lv_notes_9_0,
            	    							"org.bpy.score.game.Game.Note");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_10=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getHalfInningAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHalfInning"


    // $ANTLR start "entryRuleCommands"
    // InternalGame.g:642:1: entryRuleCommands returns [EObject current=null] : iv_ruleCommands= ruleCommands EOF ;
    public final EObject entryRuleCommands() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommands = null;


        try {
            // InternalGame.g:642:49: (iv_ruleCommands= ruleCommands EOF )
            // InternalGame.g:643:2: iv_ruleCommands= ruleCommands EOF
            {
             newCompositeNode(grammarAccess.getCommandsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommands=ruleCommands();

            state._fsp--;

             current =iv_ruleCommands; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommands"


    // $ANTLR start "ruleCommands"
    // InternalGame.g:649:1: ruleCommands returns [EObject current=null] : (otherlv_0= 'graphicalCommand' ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) ) ) ;
    public final EObject ruleCommands() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_command_1_1 = null;

        EObject lv_command_1_2 = null;



        	enterRule();

        try {
            // InternalGame.g:655:2: ( (otherlv_0= 'graphicalCommand' ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) ) ) )
            // InternalGame.g:656:2: (otherlv_0= 'graphicalCommand' ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) ) )
            {
            // InternalGame.g:656:2: (otherlv_0= 'graphicalCommand' ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) ) )
            // InternalGame.g:657:3: otherlv_0= 'graphicalCommand' ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) )
            {
            otherlv_0=(Token)match(input,102,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getCommandsAccess().getGraphicalCommandKeyword_0());
            		
            // InternalGame.g:661:3: ( ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) ) )
            // InternalGame.g:662:4: ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) )
            {
            // InternalGame.g:662:4: ( (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand ) )
            // InternalGame.g:663:5: (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand )
            {
            // InternalGame.g:663:5: (lv_command_1_1= ruleMoveCommand | lv_command_1_2= ruleSelectedBatterCommand )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==103) ) {
                alt8=1;
            }
            else if ( (LA8_0==104) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalGame.g:664:6: lv_command_1_1= ruleMoveCommand
                    {

                    						newCompositeNode(grammarAccess.getCommandsAccess().getCommandMoveCommandParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_command_1_1=ruleMoveCommand();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCommandsRule());
                    						}
                    						set(
                    							current,
                    							"command",
                    							lv_command_1_1,
                    							"org.bpy.score.game.Game.MoveCommand");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalGame.g:680:6: lv_command_1_2= ruleSelectedBatterCommand
                    {

                    						newCompositeNode(grammarAccess.getCommandsAccess().getCommandSelectedBatterCommandParserRuleCall_1_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_command_1_2=ruleSelectedBatterCommand();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCommandsRule());
                    						}
                    						set(
                    							current,
                    							"command",
                    							lv_command_1_2,
                    							"org.bpy.score.game.Game.SelectedBatterCommand");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommands"


    // $ANTLR start "entryRuleMoveCommand"
    // InternalGame.g:702:1: entryRuleMoveCommand returns [EObject current=null] : iv_ruleMoveCommand= ruleMoveCommand EOF ;
    public final EObject entryRuleMoveCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoveCommand = null;


        try {
            // InternalGame.g:702:52: (iv_ruleMoveCommand= ruleMoveCommand EOF )
            // InternalGame.g:703:2: iv_ruleMoveCommand= ruleMoveCommand EOF
            {
             newCompositeNode(grammarAccess.getMoveCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoveCommand=ruleMoveCommand();

            state._fsp--;

             current =iv_ruleMoveCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMoveCommand"


    // $ANTLR start "ruleMoveCommand"
    // InternalGame.g:709:1: ruleMoveCommand returns [EObject current=null] : (otherlv_0= 'columnNumber' otherlv_1= '=' ( (lv_columnNumber_2_0= RULE_INT ) ) otherlv_3= ';' ) ;
    public final EObject ruleMoveCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_columnNumber_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGame.g:715:2: ( (otherlv_0= 'columnNumber' otherlv_1= '=' ( (lv_columnNumber_2_0= RULE_INT ) ) otherlv_3= ';' ) )
            // InternalGame.g:716:2: (otherlv_0= 'columnNumber' otherlv_1= '=' ( (lv_columnNumber_2_0= RULE_INT ) ) otherlv_3= ';' )
            {
            // InternalGame.g:716:2: (otherlv_0= 'columnNumber' otherlv_1= '=' ( (lv_columnNumber_2_0= RULE_INT ) ) otherlv_3= ';' )
            // InternalGame.g:717:3: otherlv_0= 'columnNumber' otherlv_1= '=' ( (lv_columnNumber_2_0= RULE_INT ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getMoveCommandAccess().getColumnNumberKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getMoveCommandAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:725:3: ( (lv_columnNumber_2_0= RULE_INT ) )
            // InternalGame.g:726:4: (lv_columnNumber_2_0= RULE_INT )
            {
            // InternalGame.g:726:4: (lv_columnNumber_2_0= RULE_INT )
            // InternalGame.g:727:5: lv_columnNumber_2_0= RULE_INT
            {
            lv_columnNumber_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

            					newLeafNode(lv_columnNumber_2_0, grammarAccess.getMoveCommandAccess().getColumnNumberINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMoveCommandRule());
            					}
            					setWithLastConsumed(
            						current,
            						"columnNumber",
            						lv_columnNumber_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMoveCommandAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMoveCommand"


    // $ANTLR start "entryRuleSelectedBatterCommand"
    // InternalGame.g:751:1: entryRuleSelectedBatterCommand returns [EObject current=null] : iv_ruleSelectedBatterCommand= ruleSelectedBatterCommand EOF ;
    public final EObject entryRuleSelectedBatterCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectedBatterCommand = null;


        try {
            // InternalGame.g:751:62: (iv_ruleSelectedBatterCommand= ruleSelectedBatterCommand EOF )
            // InternalGame.g:752:2: iv_ruleSelectedBatterCommand= ruleSelectedBatterCommand EOF
            {
             newCompositeNode(grammarAccess.getSelectedBatterCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectedBatterCommand=ruleSelectedBatterCommand();

            state._fsp--;

             current =iv_ruleSelectedBatterCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectedBatterCommand"


    // $ANTLR start "ruleSelectedBatterCommand"
    // InternalGame.g:758:1: ruleSelectedBatterCommand returns [EObject current=null] : (otherlv_0= 'selectBatter' otherlv_1= '=' ( (lv_starterBatter_2_0= RULE_INT ) ) otherlv_3= ';' ) ;
    public final EObject ruleSelectedBatterCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_starterBatter_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGame.g:764:2: ( (otherlv_0= 'selectBatter' otherlv_1= '=' ( (lv_starterBatter_2_0= RULE_INT ) ) otherlv_3= ';' ) )
            // InternalGame.g:765:2: (otherlv_0= 'selectBatter' otherlv_1= '=' ( (lv_starterBatter_2_0= RULE_INT ) ) otherlv_3= ';' )
            {
            // InternalGame.g:765:2: (otherlv_0= 'selectBatter' otherlv_1= '=' ( (lv_starterBatter_2_0= RULE_INT ) ) otherlv_3= ';' )
            // InternalGame.g:766:3: otherlv_0= 'selectBatter' otherlv_1= '=' ( (lv_starterBatter_2_0= RULE_INT ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,104,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectedBatterCommandAccess().getSelectBatterKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectedBatterCommandAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:774:3: ( (lv_starterBatter_2_0= RULE_INT ) )
            // InternalGame.g:775:4: (lv_starterBatter_2_0= RULE_INT )
            {
            // InternalGame.g:775:4: (lv_starterBatter_2_0= RULE_INT )
            // InternalGame.g:776:5: lv_starterBatter_2_0= RULE_INT
            {
            lv_starterBatter_2_0=(Token)match(input,RULE_INT,FOLLOW_10); 

            					newLeafNode(lv_starterBatter_2_0, grammarAccess.getSelectedBatterCommandAccess().getStarterBatterINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSelectedBatterCommandRule());
            					}
            					setWithLastConsumed(
            						current,
            						"starterBatter",
            						lv_starterBatter_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectedBatterCommandAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectedBatterCommand"


    // $ANTLR start "entryRuleNote"
    // InternalGame.g:800:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // InternalGame.g:800:45: (iv_ruleNote= ruleNote EOF )
            // InternalGame.g:801:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNote"


    // $ANTLR start "ruleNote"
    // InternalGame.g:807:1: ruleNote returns [EObject current=null] : (otherlv_0= 'note' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) otherlv_3= ';' ) ;
    public final EObject ruleNote() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_notes_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGame.g:813:2: ( (otherlv_0= 'note' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) otherlv_3= ';' ) )
            // InternalGame.g:814:2: (otherlv_0= 'note' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) otherlv_3= ';' )
            {
            // InternalGame.g:814:2: (otherlv_0= 'note' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) otherlv_3= ';' )
            // InternalGame.g:815:3: otherlv_0= 'note' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,105,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getNoteAccess().getNoteKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:823:3: ( (lv_notes_2_0= RULE_STRING ) )
            // InternalGame.g:824:4: (lv_notes_2_0= RULE_STRING )
            {
            // InternalGame.g:824:4: (lv_notes_2_0= RULE_STRING )
            // InternalGame.g:825:5: lv_notes_2_0= RULE_STRING
            {
            lv_notes_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_notes_2_0, grammarAccess.getNoteAccess().getNotesSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNoteRule());
            					}
            					setWithLastConsumed(
            						current,
            						"notes",
            						lv_notes_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNote"


    // $ANTLR start "entryRuleInningSetting"
    // InternalGame.g:849:1: entryRuleInningSetting returns [EObject current=null] : iv_ruleInningSetting= ruleInningSetting EOF ;
    public final EObject entryRuleInningSetting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInningSetting = null;


        try {
            // InternalGame.g:849:54: (iv_ruleInningSetting= ruleInningSetting EOF )
            // InternalGame.g:850:2: iv_ruleInningSetting= ruleInningSetting EOF
            {
             newCompositeNode(grammarAccess.getInningSettingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInningSetting=ruleInningSetting();

            state._fsp--;

             current =iv_ruleInningSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInningSetting"


    // $ANTLR start "ruleInningSetting"
    // InternalGame.g:856:1: ruleInningSetting returns [EObject current=null] : ( () otherlv_1= 'specialSituation' otherlv_2= '{' ( (lv_isTiebrak_3_0= 'tieBreak' ) )? otherlv_4= '}' ) ;
    public final EObject ruleInningSetting() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_isTiebrak_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGame.g:862:2: ( ( () otherlv_1= 'specialSituation' otherlv_2= '{' ( (lv_isTiebrak_3_0= 'tieBreak' ) )? otherlv_4= '}' ) )
            // InternalGame.g:863:2: ( () otherlv_1= 'specialSituation' otherlv_2= '{' ( (lv_isTiebrak_3_0= 'tieBreak' ) )? otherlv_4= '}' )
            {
            // InternalGame.g:863:2: ( () otherlv_1= 'specialSituation' otherlv_2= '{' ( (lv_isTiebrak_3_0= 'tieBreak' ) )? otherlv_4= '}' )
            // InternalGame.g:864:3: () otherlv_1= 'specialSituation' otherlv_2= '{' ( (lv_isTiebrak_3_0= 'tieBreak' ) )? otherlv_4= '}'
            {
            // InternalGame.g:864:3: ()
            // InternalGame.g:865:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInningSettingAccess().getInningSettingAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,106,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getInningSettingAccess().getSpecialSituationKeyword_1());
            		
            otherlv_2=(Token)match(input,90,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getInningSettingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGame.g:879:3: ( (lv_isTiebrak_3_0= 'tieBreak' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==107) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalGame.g:880:4: (lv_isTiebrak_3_0= 'tieBreak' )
                    {
                    // InternalGame.g:880:4: (lv_isTiebrak_3_0= 'tieBreak' )
                    // InternalGame.g:881:5: lv_isTiebrak_3_0= 'tieBreak'
                    {
                    lv_isTiebrak_3_0=(Token)match(input,107,FOLLOW_8); 

                    					newLeafNode(lv_isTiebrak_3_0, grammarAccess.getInningSettingAccess().getIsTiebrakTieBreakKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInningSettingRule());
                    					}
                    					setWithLastConsumed(current, "isTiebrak", lv_isTiebrak_3_0 != null, "tieBreak");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getInningSettingAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInningSetting"


    // $ANTLR start "entryRuleAction"
    // InternalGame.g:901:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalGame.g:901:47: (iv_ruleAction= ruleAction EOF )
            // InternalGame.g:902:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalGame.g:908:1: ruleAction returns [EObject current=null] : ( ( (lv_pitches_0_0= rulePitches ) )? otherlv_1= 'action' otherlv_2= '{' ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) ) otherlv_9= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_pitches_0_0 = null;

        EObject lv_batterAction_3_0 = null;

        EObject lv_runnerActions_5_0 = null;

        EObject lv_runnerActions_6_0 = null;

        EObject lv_runnerActions_8_0 = null;



        	enterRule();

        try {
            // InternalGame.g:914:2: ( ( ( (lv_pitches_0_0= rulePitches ) )? otherlv_1= 'action' otherlv_2= '{' ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) ) otherlv_9= '}' ) )
            // InternalGame.g:915:2: ( ( (lv_pitches_0_0= rulePitches ) )? otherlv_1= 'action' otherlv_2= '{' ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) ) otherlv_9= '}' )
            {
            // InternalGame.g:915:2: ( ( (lv_pitches_0_0= rulePitches ) )? otherlv_1= 'action' otherlv_2= '{' ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) ) otherlv_9= '}' )
            // InternalGame.g:916:3: ( (lv_pitches_0_0= rulePitches ) )? otherlv_1= 'action' otherlv_2= '{' ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) ) otherlv_9= '}'
            {
            // InternalGame.g:916:3: ( (lv_pitches_0_0= rulePitches ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT||LA10_0==124||(LA10_0>=128 && LA10_0<=137)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGame.g:917:4: (lv_pitches_0_0= rulePitches )
                    {
                    // InternalGame.g:917:4: (lv_pitches_0_0= rulePitches )
                    // InternalGame.g:918:5: lv_pitches_0_0= rulePitches
                    {

                    					newCompositeNode(grammarAccess.getActionAccess().getPitchesPitchesParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_24);
                    lv_pitches_0_0=rulePitches();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActionRule());
                    					}
                    					set(
                    						current,
                    						"pitches",
                    						lv_pitches_0_0,
                    						"org.bpy.score.game.Game.Pitches");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,108,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getActionAccess().getActionKeyword_1());
            		
            otherlv_2=(Token)match(input,90,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGame.g:943:3: ( ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* ) | ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BATTER) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_RUNNER||LA13_0==110) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalGame.g:944:4: ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* )
                    {
                    // InternalGame.g:944:4: ( ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )* )
                    // InternalGame.g:945:5: ( (lv_batterAction_3_0= ruleBatterAction ) ) (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )*
                    {
                    // InternalGame.g:945:5: ( (lv_batterAction_3_0= ruleBatterAction ) )
                    // InternalGame.g:946:6: (lv_batterAction_3_0= ruleBatterAction )
                    {
                    // InternalGame.g:946:6: (lv_batterAction_3_0= ruleBatterAction )
                    // InternalGame.g:947:7: lv_batterAction_3_0= ruleBatterAction
                    {

                    							newCompositeNode(grammarAccess.getActionAccess().getBatterActionBatterActionParserRuleCall_3_0_0_0());
                    						
                    pushFollow(FOLLOW_26);
                    lv_batterAction_3_0=ruleBatterAction();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getActionRule());
                    							}
                    							set(
                    								current,
                    								"batterAction",
                    								lv_batterAction_3_0,
                    								"org.bpy.score.game.Game.BatterAction");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalGame.g:964:5: (otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==109) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalGame.g:965:6: otherlv_4= ',' ( (lv_runnerActions_5_0= ruleRunnerAction ) )
                    	    {
                    	    otherlv_4=(Token)match(input,109,FOLLOW_25); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getActionAccess().getCommaKeyword_3_0_1_0());
                    	    					
                    	    // InternalGame.g:969:6: ( (lv_runnerActions_5_0= ruleRunnerAction ) )
                    	    // InternalGame.g:970:7: (lv_runnerActions_5_0= ruleRunnerAction )
                    	    {
                    	    // InternalGame.g:970:7: (lv_runnerActions_5_0= ruleRunnerAction )
                    	    // InternalGame.g:971:8: lv_runnerActions_5_0= ruleRunnerAction
                    	    {

                    	    								newCompositeNode(grammarAccess.getActionAccess().getRunnerActionsRunnerActionParserRuleCall_3_0_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_26);
                    	    lv_runnerActions_5_0=ruleRunnerAction();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getActionRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"runnerActions",
                    	    									lv_runnerActions_5_0,
                    	    									"org.bpy.score.game.Game.RunnerAction");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:991:4: ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* )
                    {
                    // InternalGame.g:991:4: ( ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )* )
                    // InternalGame.g:992:5: ( (lv_runnerActions_6_0= ruleRunnerAction ) ) (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )*
                    {
                    // InternalGame.g:992:5: ( (lv_runnerActions_6_0= ruleRunnerAction ) )
                    // InternalGame.g:993:6: (lv_runnerActions_6_0= ruleRunnerAction )
                    {
                    // InternalGame.g:993:6: (lv_runnerActions_6_0= ruleRunnerAction )
                    // InternalGame.g:994:7: lv_runnerActions_6_0= ruleRunnerAction
                    {

                    							newCompositeNode(grammarAccess.getActionAccess().getRunnerActionsRunnerActionParserRuleCall_3_1_0_0());
                    						
                    pushFollow(FOLLOW_26);
                    lv_runnerActions_6_0=ruleRunnerAction();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getActionRule());
                    							}
                    							add(
                    								current,
                    								"runnerActions",
                    								lv_runnerActions_6_0,
                    								"org.bpy.score.game.Game.RunnerAction");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalGame.g:1011:5: (otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==109) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalGame.g:1012:6: otherlv_7= ',' ( (lv_runnerActions_8_0= ruleRunnerAction ) )
                    	    {
                    	    otherlv_7=(Token)match(input,109,FOLLOW_25); 

                    	    						newLeafNode(otherlv_7, grammarAccess.getActionAccess().getCommaKeyword_3_1_1_0());
                    	    					
                    	    // InternalGame.g:1016:6: ( (lv_runnerActions_8_0= ruleRunnerAction ) )
                    	    // InternalGame.g:1017:7: (lv_runnerActions_8_0= ruleRunnerAction )
                    	    {
                    	    // InternalGame.g:1017:7: (lv_runnerActions_8_0= ruleRunnerAction )
                    	    // InternalGame.g:1018:8: lv_runnerActions_8_0= ruleRunnerAction
                    	    {

                    	    								newCompositeNode(grammarAccess.getActionAccess().getRunnerActionsRunnerActionParserRuleCall_3_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_26);
                    	    lv_runnerActions_8_0=ruleRunnerAction();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getActionRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"runnerActions",
                    	    									lv_runnerActions_8_0,
                    	    									"org.bpy.score.game.Game.RunnerAction");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRulePitches"
    // InternalGame.g:1046:1: entryRulePitches returns [EObject current=null] : iv_rulePitches= rulePitches EOF ;
    public final EObject entryRulePitches() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePitches = null;


        try {
            // InternalGame.g:1046:48: (iv_rulePitches= rulePitches EOF )
            // InternalGame.g:1047:2: iv_rulePitches= rulePitches EOF
            {
             newCompositeNode(grammarAccess.getPitchesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePitches=rulePitches();

            state._fsp--;

             current =iv_rulePitches; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePitches"


    // $ANTLR start "rulePitches"
    // InternalGame.g:1053:1: rulePitches returns [EObject current=null] : ( ( (lv_pitches_0_0= rulePitch ) ) (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )* ) ;
    public final EObject rulePitches() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_pitches_0_0 = null;

        EObject lv_pitches_2_0 = null;



        	enterRule();

        try {
            // InternalGame.g:1059:2: ( ( ( (lv_pitches_0_0= rulePitch ) ) (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )* ) )
            // InternalGame.g:1060:2: ( ( (lv_pitches_0_0= rulePitch ) ) (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )* )
            {
            // InternalGame.g:1060:2: ( ( (lv_pitches_0_0= rulePitch ) ) (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )* )
            // InternalGame.g:1061:3: ( (lv_pitches_0_0= rulePitch ) ) (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )*
            {
            // InternalGame.g:1061:3: ( (lv_pitches_0_0= rulePitch ) )
            // InternalGame.g:1062:4: (lv_pitches_0_0= rulePitch )
            {
            // InternalGame.g:1062:4: (lv_pitches_0_0= rulePitch )
            // InternalGame.g:1063:5: lv_pitches_0_0= rulePitch
            {

            					newCompositeNode(grammarAccess.getPitchesAccess().getPitchesPitchParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_27);
            lv_pitches_0_0=rulePitch();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPitchesRule());
            					}
            					add(
            						current,
            						"pitches",
            						lv_pitches_0_0,
            						"org.bpy.score.game.Game.Pitch");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:1080:3: (otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==109) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalGame.g:1081:4: otherlv_1= ',' ( (lv_pitches_2_0= rulePitch ) )
            	    {
            	    otherlv_1=(Token)match(input,109,FOLLOW_28); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPitchesAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalGame.g:1085:4: ( (lv_pitches_2_0= rulePitch ) )
            	    // InternalGame.g:1086:5: (lv_pitches_2_0= rulePitch )
            	    {
            	    // InternalGame.g:1086:5: (lv_pitches_2_0= rulePitch )
            	    // InternalGame.g:1087:6: lv_pitches_2_0= rulePitch
            	    {

            	    						newCompositeNode(grammarAccess.getPitchesAccess().getPitchesPitchParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_pitches_2_0=rulePitch();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPitchesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pitches",
            	    							lv_pitches_2_0,
            	    							"org.bpy.score.game.Game.Pitch");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePitches"


    // $ANTLR start "entryRulePitch"
    // InternalGame.g:1109:1: entryRulePitch returns [EObject current=null] : iv_rulePitch= rulePitch EOF ;
    public final EObject entryRulePitch() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePitch = null;


        try {
            // InternalGame.g:1109:46: (iv_rulePitch= rulePitch EOF )
            // InternalGame.g:1110:2: iv_rulePitch= rulePitch EOF
            {
             newCompositeNode(grammarAccess.getPitchRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePitch=rulePitch();

            state._fsp--;

             current =iv_rulePitch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePitch"


    // $ANTLR start "rulePitch"
    // InternalGame.g:1116:1: rulePitch returns [EObject current=null] : ( (lv_pitch_0_0= ruleTypeOfPitch ) ) ;
    public final EObject rulePitch() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_pitch_0_0 = null;



        	enterRule();

        try {
            // InternalGame.g:1122:2: ( ( (lv_pitch_0_0= ruleTypeOfPitch ) ) )
            // InternalGame.g:1123:2: ( (lv_pitch_0_0= ruleTypeOfPitch ) )
            {
            // InternalGame.g:1123:2: ( (lv_pitch_0_0= ruleTypeOfPitch ) )
            // InternalGame.g:1124:3: (lv_pitch_0_0= ruleTypeOfPitch )
            {
            // InternalGame.g:1124:3: (lv_pitch_0_0= ruleTypeOfPitch )
            // InternalGame.g:1125:4: lv_pitch_0_0= ruleTypeOfPitch
            {

            				newCompositeNode(grammarAccess.getPitchAccess().getPitchTypeOfPitchParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_pitch_0_0=ruleTypeOfPitch();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPitchRule());
            				}
            				set(
            					current,
            					"pitch",
            					lv_pitch_0_0,
            					"org.bpy.score.game.Game.TypeOfPitch");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePitch"


    // $ANTLR start "entryRuleTypeOfPitch"
    // InternalGame.g:1145:1: entryRuleTypeOfPitch returns [String current=null] : iv_ruleTypeOfPitch= ruleTypeOfPitch EOF ;
    public final String entryRuleTypeOfPitch() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTypeOfPitch = null;


        try {
            // InternalGame.g:1145:51: (iv_ruleTypeOfPitch= ruleTypeOfPitch EOF )
            // InternalGame.g:1146:2: iv_ruleTypeOfPitch= ruleTypeOfPitch EOF
            {
             newCompositeNode(grammarAccess.getTypeOfPitchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeOfPitch=ruleTypeOfPitch();

            state._fsp--;

             current =iv_ruleTypeOfPitch.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeOfPitch"


    // $ANTLR start "ruleTypeOfPitch"
    // InternalGame.g:1152:1: ruleTypeOfPitch returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_KindOfPitch_0= ruleKindOfPitch | this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTypeOfPitch() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_KindOfPitch_0 = null;



        	enterRule();

        try {
            // InternalGame.g:1158:2: ( (this_KindOfPitch_0= ruleKindOfPitch | this_INT_1= RULE_INT ) )
            // InternalGame.g:1159:2: (this_KindOfPitch_0= ruleKindOfPitch | this_INT_1= RULE_INT )
            {
            // InternalGame.g:1159:2: (this_KindOfPitch_0= ruleKindOfPitch | this_INT_1= RULE_INT )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==124||(LA15_0>=128 && LA15_0<=137)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_INT) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalGame.g:1160:3: this_KindOfPitch_0= ruleKindOfPitch
                    {

                    			newCompositeNode(grammarAccess.getTypeOfPitchAccess().getKindOfPitchParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_KindOfPitch_0=ruleKindOfPitch();

                    state._fsp--;


                    			current.merge(this_KindOfPitch_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:1171:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getTypeOfPitchAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeOfPitch"


    // $ANTLR start "entryRuleRunnerAction"
    // InternalGame.g:1182:1: entryRuleRunnerAction returns [EObject current=null] : iv_ruleRunnerAction= ruleRunnerAction EOF ;
    public final EObject entryRuleRunnerAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRunnerAction = null;


        try {
            // InternalGame.g:1182:53: (iv_ruleRunnerAction= ruleRunnerAction EOF )
            // InternalGame.g:1183:2: iv_ruleRunnerAction= ruleRunnerAction EOF
            {
             newCompositeNode(grammarAccess.getRunnerActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRunnerAction=ruleRunnerAction();

            state._fsp--;

             current =iv_ruleRunnerAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRunnerAction"


    // $ANTLR start "ruleRunnerAction"
    // InternalGame.g:1189:1: ruleRunnerAction returns [EObject current=null] : ( (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? ) | this_RunnerOut_3= ruleRunnerOut | this_OtherRunnerAction_4= ruleOtherRunnerAction ) ;
    public final EObject ruleRunnerAction() throws RecognitionException {
        EObject current = null;

        EObject this_RunnerAdvance_0 = null;

        EObject lv_moreAdvances_1_0 = null;

        EObject lv_runnerOut_2_0 = null;

        EObject this_RunnerOut_3 = null;

        EObject this_OtherRunnerAction_4 = null;



        	enterRule();

        try {
            // InternalGame.g:1195:2: ( ( (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? ) | this_RunnerOut_3= ruleRunnerOut | this_OtherRunnerAction_4= ruleOtherRunnerAction ) )
            // InternalGame.g:1196:2: ( (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? ) | this_RunnerOut_3= ruleRunnerOut | this_OtherRunnerAction_4= ruleOtherRunnerAction )
            {
            // InternalGame.g:1196:2: ( (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? ) | this_RunnerOut_3= ruleRunnerOut | this_OtherRunnerAction_4= ruleOtherRunnerAction )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_RUNNER) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==117) ) {
                    int LA18_3 = input.LA(3);

                    if ( (LA18_3==RULE_STRING) ) {
                        int LA18_5 = input.LA(4);

                        if ( (LA18_5==118) ) {
                            int LA18_8 = input.LA(5);

                            if ( (LA18_8==RULE_EXECUTE) ) {
                                int LA18_4 = input.LA(6);

                                if ( ((LA18_4>=RULE_ADVANCE_ON_ERROR && LA18_4<=RULE_EXTRA_ON_RECEIVE_ERROR)||(LA18_4>=RULE_ADVANCE && LA18_4<=RULE_FIELDER_CHOICE)) ) {
                                    alt18=1;
                                }
                                else if ( (LA18_4==RULE_INT||(LA18_4>=RULE_CAUGTH_STEALING && LA18_4<=RULE_APPEAL)) ) {
                                    alt18=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 18, 4, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 8, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA18_1==RULE_EXECUTE) ) {
                    int LA18_4 = input.LA(3);

                    if ( ((LA18_4>=RULE_ADVANCE_ON_ERROR && LA18_4<=RULE_EXTRA_ON_RECEIVE_ERROR)||(LA18_4>=RULE_ADVANCE && LA18_4<=RULE_FIELDER_CHOICE)) ) {
                        alt18=1;
                    }
                    else if ( (LA18_4==RULE_INT||(LA18_4>=RULE_CAUGTH_STEALING && LA18_4<=RULE_APPEAL)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA18_0==110) ) {
                alt18=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalGame.g:1197:3: (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? )
                    {
                    // InternalGame.g:1197:3: (this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )? )
                    // InternalGame.g:1198:4: this_RunnerAdvance_0= ruleRunnerAdvance ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )* ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )?
                    {

                    				newCompositeNode(grammarAccess.getRunnerActionAccess().getRunnerAdvanceParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_29);
                    this_RunnerAdvance_0=ruleRunnerAdvance();

                    state._fsp--;


                    				current = this_RunnerAdvance_0;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalGame.g:1206:4: ( (lv_moreAdvances_1_0= ruleAdvanceWithContinuation ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ADVANCE_ON_ERROR||(LA16_0>=RULE_REACH_ON_THROW_ERROR && LA16_0<=RULE_EXTRA_ON_RECEIVE_ERROR)||(LA16_0>=RULE_STOLEN_BASE && LA16_0<=RULE_ADVANCE_BY_RULE)||LA16_0==RULE_FIELDER_CHOICE||LA16_0==RULE_EXTRA_ON_FLY_ERROR) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalGame.g:1207:5: (lv_moreAdvances_1_0= ruleAdvanceWithContinuation )
                    	    {
                    	    // InternalGame.g:1207:5: (lv_moreAdvances_1_0= ruleAdvanceWithContinuation )
                    	    // InternalGame.g:1208:6: lv_moreAdvances_1_0= ruleAdvanceWithContinuation
                    	    {

                    	    						newCompositeNode(grammarAccess.getRunnerActionAccess().getMoreAdvancesAdvanceWithContinuationParserRuleCall_0_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    lv_moreAdvances_1_0=ruleAdvanceWithContinuation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRunnerActionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"moreAdvances",
                    	    							lv_moreAdvances_1_0,
                    	    							"org.bpy.score.game.Game.AdvanceWithContinuation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    // InternalGame.g:1225:4: ( (lv_runnerOut_2_0= ruleMoreAdanceFail ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_INT||(LA17_0>=RULE_OUT_BY_RULE && LA17_0<=RULE_APPEAL)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalGame.g:1226:5: (lv_runnerOut_2_0= ruleMoreAdanceFail )
                            {
                            // InternalGame.g:1226:5: (lv_runnerOut_2_0= ruleMoreAdanceFail )
                            // InternalGame.g:1227:6: lv_runnerOut_2_0= ruleMoreAdanceFail
                            {

                            						newCompositeNode(grammarAccess.getRunnerActionAccess().getRunnerOutMoreAdanceFailParserRuleCall_0_2_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_runnerOut_2_0=ruleMoreAdanceFail();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getRunnerActionRule());
                            						}
                            						set(
                            							current,
                            							"runnerOut",
                            							lv_runnerOut_2_0,
                            							"org.bpy.score.game.Game.MoreAdanceFail");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:1246:3: this_RunnerOut_3= ruleRunnerOut
                    {

                    			newCompositeNode(grammarAccess.getRunnerActionAccess().getRunnerOutParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RunnerOut_3=ruleRunnerOut();

                    state._fsp--;


                    			current = this_RunnerOut_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGame.g:1255:3: this_OtherRunnerAction_4= ruleOtherRunnerAction
                    {

                    			newCompositeNode(grammarAccess.getRunnerActionAccess().getOtherRunnerActionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OtherRunnerAction_4=ruleOtherRunnerAction();

                    state._fsp--;


                    			current = this_OtherRunnerAction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRunnerAction"


    // $ANTLR start "entryRuleOtherRunnerAction"
    // InternalGame.g:1267:1: entryRuleOtherRunnerAction returns [EObject current=null] : iv_ruleOtherRunnerAction= ruleOtherRunnerAction EOF ;
    public final EObject entryRuleOtherRunnerAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherRunnerAction = null;


        try {
            // InternalGame.g:1267:58: (iv_ruleOtherRunnerAction= ruleOtherRunnerAction EOF )
            // InternalGame.g:1268:2: iv_ruleOtherRunnerAction= ruleOtherRunnerAction EOF
            {
             newCompositeNode(grammarAccess.getOtherRunnerActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherRunnerAction=ruleOtherRunnerAction();

            state._fsp--;

             current =iv_ruleOtherRunnerAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherRunnerAction"


    // $ANTLR start "ruleOtherRunnerAction"
    // InternalGame.g:1274:1: ruleOtherRunnerAction returns [EObject current=null] : (otherlv_0= 'noAdvance' otherlv_1= 'on' ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) ) ) ;
    public final EObject ruleOtherRunnerAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_EXECUTE_4=null;
        Token lv_actionCode_5_0=null;
        Token this_EXECUTE_8=null;
        Token lv_actionCode_9_0=null;
        Token this_EXECUTE_12=null;
        Token lv_actionCode_13_0=null;
        Token this_EXECUTE_16=null;
        Token lv_actionCode_17_0=null;
        Token this_EXECUTE_20=null;
        Token lv_actionCode_21_0=null;
        Token this_EXECUTE_24=null;
        Token lv_actionCode_25_0=null;
        Token this_EXECUTE_28=null;
        Token lv_actionCode_29_0=null;
        Token this_EXECUTE_32=null;
        Token lv_actionCode_33_0=null;
        EObject lv_runner_3_0 = null;

        EObject lv_runner_7_0 = null;

        EObject lv_runner_11_0 = null;

        EObject lv_runner_15_0 = null;

        EObject lv_runner_19_0 = null;

        EObject lv_runner_23_0 = null;

        EObject lv_runner_27_0 = null;

        EObject lv_runner_31_0 = null;



        	enterRule();

        try {
            // InternalGame.g:1280:2: ( (otherlv_0= 'noAdvance' otherlv_1= 'on' ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) ) ) )
            // InternalGame.g:1281:2: (otherlv_0= 'noAdvance' otherlv_1= 'on' ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) ) )
            {
            // InternalGame.g:1281:2: (otherlv_0= 'noAdvance' otherlv_1= 'on' ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) ) )
            // InternalGame.g:1282:3: otherlv_0= 'noAdvance' otherlv_1= 'on' ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) )
            {
            otherlv_0=(Token)match(input,110,FOLLOW_30); 

            			newLeafNode(otherlv_0, grammarAccess.getOtherRunnerActionAccess().getNoAdvanceKeyword_0());
            		
            otherlv_1=(Token)match(input,111,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getOtherRunnerActionAccess().getOnKeyword_1());
            		
            // InternalGame.g:1290:3: ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) )
            int alt19=8;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalGame.g:1291:4: ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) )
                    {
                    // InternalGame.g:1291:4: ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) )
                    // InternalGame.g:1292:5: () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) )
                    {
                    // InternalGame.g:1292:5: ()
                    // InternalGame.g:1293:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerMustBeOutOnErrorAction_2_0_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1299:5: ( (lv_runner_3_0= ruleCurrentRunner ) )
                    // InternalGame.g:1300:6: (lv_runner_3_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1300:6: (lv_runner_3_0= ruleCurrentRunner )
                    // InternalGame.g:1301:7: lv_runner_3_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_3_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_3_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_4=(Token)match(input,RULE_EXECUTE,FOLLOW_33); 

                    					newLeafNode(this_EXECUTE_4, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_0_2());
                    				
                    // InternalGame.g:1322:5: ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) )
                    // InternalGame.g:1323:6: (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR )
                    {
                    // InternalGame.g:1323:6: (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR )
                    // InternalGame.g:1324:7: lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR
                    {
                    lv_actionCode_5_0=(Token)match(input,RULE_MUST_BE_OUT_ON_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_5_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeMUST_BE_OUT_ON_ERRORTerminalRuleCall_2_0_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_5_0,
                    								"org.bpy.score.game.Game.MUST_BE_OUT_ON_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:1342:4: ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) )
                    {
                    // InternalGame.g:1342:4: ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) )
                    // InternalGame.g:1343:5: () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) )
                    {
                    // InternalGame.g:1343:5: ()
                    // InternalGame.g:1344:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnErrorAction_2_1_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1350:5: ( (lv_runner_7_0= ruleCurrentRunner ) )
                    // InternalGame.g:1351:6: (lv_runner_7_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1351:6: (lv_runner_7_0= ruleCurrentRunner )
                    // InternalGame.g:1352:7: lv_runner_7_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_1_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_7_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_7_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_8=(Token)match(input,RULE_EXECUTE,FOLLOW_34); 

                    					newLeafNode(this_EXECUTE_8, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_1_2());
                    				
                    // InternalGame.g:1373:5: ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) )
                    // InternalGame.g:1374:6: (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR )
                    {
                    // InternalGame.g:1374:6: (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR )
                    // InternalGame.g:1375:7: lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR
                    {
                    lv_actionCode_9_0=(Token)match(input,RULE_ADVANCE_ON_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_9_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeADVANCE_ON_ERRORTerminalRuleCall_2_1_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_9_0,
                    								"org.bpy.score.game.Game.ADVANCE_ON_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:1393:4: ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:1393:4: ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) )
                    // InternalGame.g:1394:5: () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) )
                    {
                    // InternalGame.g:1394:5: ()
                    // InternalGame.g:1395:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnPickOffWithErrorAction_2_2_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1401:5: ( (lv_runner_11_0= ruleCurrentRunner ) )
                    // InternalGame.g:1402:6: (lv_runner_11_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1402:6: (lv_runner_11_0= ruleCurrentRunner )
                    // InternalGame.g:1403:7: lv_runner_11_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_2_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_11_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_11_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_12=(Token)match(input,RULE_EXECUTE,FOLLOW_35); 

                    					newLeafNode(this_EXECUTE_12, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_2_2());
                    				
                    // InternalGame.g:1424:5: ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) )
                    // InternalGame.g:1425:6: (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR )
                    {
                    // InternalGame.g:1425:6: (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR )
                    // InternalGame.g:1426:7: lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR
                    {
                    lv_actionCode_13_0=(Token)match(input,RULE_PICK_OFF_WITH_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_13_0, grammarAccess.getOtherRunnerActionAccess().getActionCodePICK_OFF_WITH_ERRORTerminalRuleCall_2_2_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_13_0,
                    								"org.bpy.score.game.Game.PICK_OFF_WITH_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:1444:4: ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:1444:4: ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) )
                    // InternalGame.g:1445:5: () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) )
                    {
                    // InternalGame.g:1445:5: ()
                    // InternalGame.g:1446:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnCaughtStealingWithErrorAction_2_3_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1452:5: ( (lv_runner_15_0= ruleCurrentRunner ) )
                    // InternalGame.g:1453:6: (lv_runner_15_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1453:6: (lv_runner_15_0= ruleCurrentRunner )
                    // InternalGame.g:1454:7: lv_runner_15_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_3_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_15_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_15_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_16=(Token)match(input,RULE_EXECUTE,FOLLOW_36); 

                    					newLeafNode(this_EXECUTE_16, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_3_2());
                    				
                    // InternalGame.g:1475:5: ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) )
                    // InternalGame.g:1476:6: (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR )
                    {
                    // InternalGame.g:1476:6: (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR )
                    // InternalGame.g:1477:7: lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR
                    {
                    lv_actionCode_17_0=(Token)match(input,RULE_CAUGTH_STEALING_WITH_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_17_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeCAUGTH_STEALING_WITH_ERRORTerminalRuleCall_2_3_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_17_0,
                    								"org.bpy.score.game.Game.CAUGTH_STEALING_WITH_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:1495:4: ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) )
                    {
                    // InternalGame.g:1495:4: ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) )
                    // InternalGame.g:1496:5: () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) )
                    {
                    // InternalGame.g:1496:5: ()
                    // InternalGame.g:1497:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnThrowErrorAction_2_4_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1503:5: ( (lv_runner_19_0= ruleCurrentRunner ) )
                    // InternalGame.g:1504:6: (lv_runner_19_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1504:6: (lv_runner_19_0= ruleCurrentRunner )
                    // InternalGame.g:1505:7: lv_runner_19_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_4_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_19_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_19_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_20=(Token)match(input,RULE_EXECUTE,FOLLOW_37); 

                    					newLeafNode(this_EXECUTE_20, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_4_2());
                    				
                    // InternalGame.g:1526:5: ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) )
                    // InternalGame.g:1527:6: (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR )
                    {
                    // InternalGame.g:1527:6: (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR )
                    // InternalGame.g:1528:7: lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR
                    {
                    lv_actionCode_21_0=(Token)match(input,RULE_REACH_ON_THROW_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_21_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeREACH_ON_THROW_ERRORTerminalRuleCall_2_4_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_21_0,
                    								"org.bpy.score.game.Game.REACH_ON_THROW_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalGame.g:1546:4: ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) )
                    {
                    // InternalGame.g:1546:4: ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) )
                    // InternalGame.g:1547:5: () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    {
                    // InternalGame.g:1547:5: ()
                    // InternalGame.g:1548:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnReceiveErrorAction_2_5_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1554:5: ( (lv_runner_23_0= ruleCurrentRunner ) )
                    // InternalGame.g:1555:6: (lv_runner_23_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1555:6: (lv_runner_23_0= ruleCurrentRunner )
                    // InternalGame.g:1556:7: lv_runner_23_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_5_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_23_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_23_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_24=(Token)match(input,RULE_EXECUTE,FOLLOW_38); 

                    					newLeafNode(this_EXECUTE_24, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_5_2());
                    				
                    // InternalGame.g:1577:5: ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:1578:6: (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:1578:6: (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR )
                    // InternalGame.g:1579:7: lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR
                    {
                    lv_actionCode_25_0=(Token)match(input,RULE_REACH_ON_RECEIVE_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_25_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeREACH_ON_RECEIVE_ERRORTerminalRuleCall_2_5_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_25_0,
                    								"org.bpy.score.game.Game.REACH_ON_RECEIVE_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalGame.g:1597:4: ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) )
                    {
                    // InternalGame.g:1597:4: ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) )
                    // InternalGame.g:1598:5: () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) )
                    {
                    // InternalGame.g:1598:5: ()
                    // InternalGame.g:1599:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnNonDecisiveThrowErrorAction_2_6_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1605:5: ( (lv_runner_27_0= ruleCurrentRunner ) )
                    // InternalGame.g:1606:6: (lv_runner_27_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1606:6: (lv_runner_27_0= ruleCurrentRunner )
                    // InternalGame.g:1607:7: lv_runner_27_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_6_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_27_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_27_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_28=(Token)match(input,RULE_EXECUTE,FOLLOW_39); 

                    					newLeafNode(this_EXECUTE_28, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_6_2());
                    				
                    // InternalGame.g:1628:5: ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) )
                    // InternalGame.g:1629:6: (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR )
                    {
                    // InternalGame.g:1629:6: (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR )
                    // InternalGame.g:1630:7: lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR
                    {
                    lv_actionCode_29_0=(Token)match(input,RULE_EXTRA_ON_THROW_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_29_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeEXTRA_ON_THROW_ERRORTerminalRuleCall_2_6_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_29_0,
                    								"org.bpy.score.game.Game.EXTRA_ON_THROW_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalGame.g:1648:4: ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) )
                    {
                    // InternalGame.g:1648:4: ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) )
                    // InternalGame.g:1649:5: () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) )
                    {
                    // InternalGame.g:1649:5: ()
                    // InternalGame.g:1650:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getOtherRunnerActionAccess().getRunnerDontAdvanceOnNonDecisiveReceiveErrorAction_2_7_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1656:5: ( (lv_runner_31_0= ruleCurrentRunner ) )
                    // InternalGame.g:1657:6: (lv_runner_31_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1657:6: (lv_runner_31_0= ruleCurrentRunner )
                    // InternalGame.g:1658:7: lv_runner_31_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getOtherRunnerActionAccess().getRunnerCurrentRunnerParserRuleCall_2_7_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_31_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_31_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_32=(Token)match(input,RULE_EXECUTE,FOLLOW_40); 

                    					newLeafNode(this_EXECUTE_32, grammarAccess.getOtherRunnerActionAccess().getEXECUTETerminalRuleCall_2_7_2());
                    				
                    // InternalGame.g:1679:5: ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:1680:6: (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:1680:6: (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    // InternalGame.g:1681:7: lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR
                    {
                    lv_actionCode_33_0=(Token)match(input,RULE_EXTRA_ON_RECEIVE_ERROR,FOLLOW_2); 

                    							newLeafNode(lv_actionCode_33_0, grammarAccess.getOtherRunnerActionAccess().getActionCodeEXTRA_ON_RECEIVE_ERRORTerminalRuleCall_2_7_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getOtherRunnerActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"actionCode",
                    								lv_actionCode_33_0,
                    								"org.bpy.score.game.Game.EXTRA_ON_RECEIVE_ERROR");
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherRunnerAction"


    // $ANTLR start "entryRuleRunnerOut"
    // InternalGame.g:1703:1: entryRuleRunnerOut returns [EObject current=null] : iv_ruleRunnerOut= ruleRunnerOut EOF ;
    public final EObject entryRuleRunnerOut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRunnerOut = null;


        try {
            // InternalGame.g:1703:50: (iv_ruleRunnerOut= ruleRunnerOut EOF )
            // InternalGame.g:1704:2: iv_ruleRunnerOut= ruleRunnerOut EOF
            {
             newCompositeNode(grammarAccess.getRunnerOutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRunnerOut=ruleRunnerOut();

            state._fsp--;

             current =iv_ruleRunnerOut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRunnerOut"


    // $ANTLR start "ruleRunnerOut"
    // InternalGame.g:1710:1: ruleRunnerOut returns [EObject current=null] : ( ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) ) ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )? ) ;
    public final EObject ruleRunnerOut() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_runnerOut_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_runnerOut_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_runnerOut_11_0=null;
        Token this_EXECUTE_14=null;
        Token lv_runnerOut_15_0=null;
        Token this_EXECUTE_18=null;
        Token lv_runnerOut_19_0=null;
        Token lv_notInDoublePlay_20_0=null;
        EObject lv_runner_1_0 = null;

        EObject lv_runner_5_0 = null;

        EObject lv_runner_9_0 = null;

        EObject lv_runner_13_0 = null;

        EObject lv_runner_17_0 = null;



        	enterRule();

        try {
            // InternalGame.g:1716:2: ( ( ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) ) ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )? ) )
            // InternalGame.g:1717:2: ( ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) ) ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )? )
            {
            // InternalGame.g:1717:2: ( ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) ) ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )? )
            // InternalGame.g:1718:3: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) ) ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )?
            {
            // InternalGame.g:1718:3: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalGame.g:1719:4: ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) )
                    {
                    // InternalGame.g:1719:4: ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) )
                    // InternalGame.g:1720:5: () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) )
                    {
                    // InternalGame.g:1720:5: ()
                    // InternalGame.g:1721:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getRunnerOutAccess().getRunnerOutOnCaugthStealingAction_0_0_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1727:5: ( (lv_runner_1_0= ruleCurrentRunner ) )
                    // InternalGame.g:1728:6: (lv_runner_1_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1728:6: (lv_runner_1_0= ruleCurrentRunner )
                    // InternalGame.g:1729:7: lv_runner_1_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getRunnerOutAccess().getRunnerCurrentRunnerParserRuleCall_0_0_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_1_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRunnerOutRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_1_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_41); 

                    					newLeafNode(this_EXECUTE_2, grammarAccess.getRunnerOutAccess().getEXECUTETerminalRuleCall_0_0_2());
                    				
                    // InternalGame.g:1750:5: ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) )
                    // InternalGame.g:1751:6: (lv_runnerOut_3_0= RULE_CAUGTH_STEALING )
                    {
                    // InternalGame.g:1751:6: (lv_runnerOut_3_0= RULE_CAUGTH_STEALING )
                    // InternalGame.g:1752:7: lv_runnerOut_3_0= RULE_CAUGTH_STEALING
                    {
                    lv_runnerOut_3_0=(Token)match(input,RULE_CAUGTH_STEALING,FOLLOW_42); 

                    							newLeafNode(lv_runnerOut_3_0, grammarAccess.getRunnerOutAccess().getRunnerOutCAUGTH_STEALINGTerminalRuleCall_0_0_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRunnerOutRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"runnerOut",
                    								lv_runnerOut_3_0,
                    								"org.bpy.score.game.Game.CAUGTH_STEALING");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:1770:4: ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) )
                    {
                    // InternalGame.g:1770:4: ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) )
                    // InternalGame.g:1771:5: () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) )
                    {
                    // InternalGame.g:1771:5: ()
                    // InternalGame.g:1772:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getRunnerOutAccess().getRunnerOutOnPickOffAction_0_1_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1778:5: ( (lv_runner_5_0= ruleCurrentRunner ) )
                    // InternalGame.g:1779:6: (lv_runner_5_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1779:6: (lv_runner_5_0= ruleCurrentRunner )
                    // InternalGame.g:1780:7: lv_runner_5_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getRunnerOutAccess().getRunnerCurrentRunnerParserRuleCall_0_1_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_5_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRunnerOutRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_5_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_43); 

                    					newLeafNode(this_EXECUTE_6, grammarAccess.getRunnerOutAccess().getEXECUTETerminalRuleCall_0_1_2());
                    				
                    // InternalGame.g:1801:5: ( (lv_runnerOut_7_0= RULE_PICK_OFF ) )
                    // InternalGame.g:1802:6: (lv_runnerOut_7_0= RULE_PICK_OFF )
                    {
                    // InternalGame.g:1802:6: (lv_runnerOut_7_0= RULE_PICK_OFF )
                    // InternalGame.g:1803:7: lv_runnerOut_7_0= RULE_PICK_OFF
                    {
                    lv_runnerOut_7_0=(Token)match(input,RULE_PICK_OFF,FOLLOW_42); 

                    							newLeafNode(lv_runnerOut_7_0, grammarAccess.getRunnerOutAccess().getRunnerOutPICK_OFFTerminalRuleCall_0_1_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRunnerOutRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"runnerOut",
                    								lv_runnerOut_7_0,
                    								"org.bpy.score.game.Game.PICK_OFF");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:1821:4: ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) )
                    {
                    // InternalGame.g:1821:4: ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) )
                    // InternalGame.g:1822:5: () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) )
                    {
                    // InternalGame.g:1822:5: ()
                    // InternalGame.g:1823:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getRunnerOutAccess().getRunnerOutOnFielderActionAction_0_2_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1829:5: ( (lv_runner_9_0= ruleCurrentRunner ) )
                    // InternalGame.g:1830:6: (lv_runner_9_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1830:6: (lv_runner_9_0= ruleCurrentRunner )
                    // InternalGame.g:1831:7: lv_runner_9_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getRunnerOutAccess().getRunnerCurrentRunnerParserRuleCall_0_2_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_9_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRunnerOutRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_9_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_19); 

                    					newLeafNode(this_EXECUTE_10, grammarAccess.getRunnerOutAccess().getEXECUTETerminalRuleCall_0_2_2());
                    				
                    // InternalGame.g:1852:5: ( (lv_runnerOut_11_0= RULE_INT ) )
                    // InternalGame.g:1853:6: (lv_runnerOut_11_0= RULE_INT )
                    {
                    // InternalGame.g:1853:6: (lv_runnerOut_11_0= RULE_INT )
                    // InternalGame.g:1854:7: lv_runnerOut_11_0= RULE_INT
                    {
                    lv_runnerOut_11_0=(Token)match(input,RULE_INT,FOLLOW_42); 

                    							newLeafNode(lv_runnerOut_11_0, grammarAccess.getRunnerOutAccess().getRunnerOutINTTerminalRuleCall_0_2_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRunnerOutRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"runnerOut",
                    								lv_runnerOut_11_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:1872:4: ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) )
                    {
                    // InternalGame.g:1872:4: ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) )
                    // InternalGame.g:1873:5: () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) )
                    {
                    // InternalGame.g:1873:5: ()
                    // InternalGame.g:1874:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getRunnerOutAccess().getRunnerOutByRulesAction_0_3_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1880:5: ( (lv_runner_13_0= ruleCurrentRunner ) )
                    // InternalGame.g:1881:6: (lv_runner_13_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1881:6: (lv_runner_13_0= ruleCurrentRunner )
                    // InternalGame.g:1882:7: lv_runner_13_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getRunnerOutAccess().getRunnerCurrentRunnerParserRuleCall_0_3_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_13_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRunnerOutRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_13_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_14=(Token)match(input,RULE_EXECUTE,FOLLOW_44); 

                    					newLeafNode(this_EXECUTE_14, grammarAccess.getRunnerOutAccess().getEXECUTETerminalRuleCall_0_3_2());
                    				
                    // InternalGame.g:1903:5: ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) )
                    // InternalGame.g:1904:6: (lv_runnerOut_15_0= RULE_OUT_BY_RULE )
                    {
                    // InternalGame.g:1904:6: (lv_runnerOut_15_0= RULE_OUT_BY_RULE )
                    // InternalGame.g:1905:7: lv_runnerOut_15_0= RULE_OUT_BY_RULE
                    {
                    lv_runnerOut_15_0=(Token)match(input,RULE_OUT_BY_RULE,FOLLOW_42); 

                    							newLeafNode(lv_runnerOut_15_0, grammarAccess.getRunnerOutAccess().getRunnerOutOUT_BY_RULETerminalRuleCall_0_3_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRunnerOutRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"runnerOut",
                    								lv_runnerOut_15_0,
                    								"org.bpy.score.game.Game.OUT_BY_RULE");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:1923:4: ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) )
                    {
                    // InternalGame.g:1923:4: ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) )
                    // InternalGame.g:1924:5: () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) )
                    {
                    // InternalGame.g:1924:5: ()
                    // InternalGame.g:1925:6: 
                    {

                    						current = forceCreateModelElement(
                    							grammarAccess.getRunnerOutAccess().getRunnerOutOnAppealAction_0_4_0(),
                    							current);
                    					

                    }

                    // InternalGame.g:1931:5: ( (lv_runner_17_0= ruleCurrentRunner ) )
                    // InternalGame.g:1932:6: (lv_runner_17_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:1932:6: (lv_runner_17_0= ruleCurrentRunner )
                    // InternalGame.g:1933:7: lv_runner_17_0= ruleCurrentRunner
                    {

                    							newCompositeNode(grammarAccess.getRunnerOutAccess().getRunnerCurrentRunnerParserRuleCall_0_4_1_0());
                    						
                    pushFollow(FOLLOW_32);
                    lv_runner_17_0=ruleCurrentRunner();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRunnerOutRule());
                    							}
                    							set(
                    								current,
                    								"runner",
                    								lv_runner_17_0,
                    								"org.bpy.score.game.Game.CurrentRunner");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    this_EXECUTE_18=(Token)match(input,RULE_EXECUTE,FOLLOW_45); 

                    					newLeafNode(this_EXECUTE_18, grammarAccess.getRunnerOutAccess().getEXECUTETerminalRuleCall_0_4_2());
                    				
                    // InternalGame.g:1954:5: ( (lv_runnerOut_19_0= RULE_APPEAL ) )
                    // InternalGame.g:1955:6: (lv_runnerOut_19_0= RULE_APPEAL )
                    {
                    // InternalGame.g:1955:6: (lv_runnerOut_19_0= RULE_APPEAL )
                    // InternalGame.g:1956:7: lv_runnerOut_19_0= RULE_APPEAL
                    {
                    lv_runnerOut_19_0=(Token)match(input,RULE_APPEAL,FOLLOW_42); 

                    							newLeafNode(lv_runnerOut_19_0, grammarAccess.getRunnerOutAccess().getRunnerOutAPPEALTerminalRuleCall_0_4_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRunnerOutRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"runnerOut",
                    								lv_runnerOut_19_0,
                    								"org.bpy.score.game.Game.APPEAL");
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalGame.g:1974:3: ( (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==112) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalGame.g:1975:4: (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' )
                    {
                    // InternalGame.g:1975:4: (lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay' )
                    // InternalGame.g:1976:5: lv_notInDoublePlay_20_0= 'dontCountAsDoublePlay'
                    {
                    lv_notInDoublePlay_20_0=(Token)match(input,112,FOLLOW_2); 

                    					newLeafNode(lv_notInDoublePlay_20_0, grammarAccess.getRunnerOutAccess().getNotInDoublePlayDontCountAsDoublePlayKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRunnerOutRule());
                    					}
                    					setWithLastConsumed(current, "notInDoublePlay", lv_notInDoublePlay_20_0 != null, "dontCountAsDoublePlay");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRunnerOut"


    // $ANTLR start "entryRuleRunnerAdvance"
    // InternalGame.g:1992:1: entryRuleRunnerAdvance returns [EObject current=null] : iv_ruleRunnerAdvance= ruleRunnerAdvance EOF ;
    public final EObject entryRuleRunnerAdvance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRunnerAdvance = null;


        try {
            // InternalGame.g:1992:54: (iv_ruleRunnerAdvance= ruleRunnerAdvance EOF )
            // InternalGame.g:1993:2: iv_ruleRunnerAdvance= ruleRunnerAdvance EOF
            {
             newCompositeNode(grammarAccess.getRunnerAdvanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRunnerAdvance=ruleRunnerAdvance();

            state._fsp--;

             current =iv_ruleRunnerAdvance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRunnerAdvance"


    // $ANTLR start "ruleRunnerAdvance"
    // InternalGame.g:1999:1: ruleRunnerAdvance returns [EObject current=null] : ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? ) ) ;
    public final EObject ruleRunnerAdvance() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_runnerAdvance_3_0=null;
        Token lv_isEarned_4_1=null;
        Token lv_isEarned_4_2=null;
        Token this_EXECUTE_7=null;
        Token lv_runnerAdvance_8_0=null;
        Token lv_isEarned_9_1=null;
        Token lv_isEarned_9_2=null;
        Token this_EXECUTE_12=null;
        Token lv_runnerAdvance_13_0=null;
        Token lv_isEarned_14_1=null;
        Token lv_isEarned_14_2=null;
        Token this_EXECUTE_17=null;
        Token lv_runnerAdvance_18_0=null;
        Token lv_isEarned_19_1=null;
        Token lv_isEarned_19_2=null;
        Token this_EXECUTE_22=null;
        Token lv_runnerAdvance_23_0=null;
        Token lv_isEarned_24_1=null;
        Token lv_isEarned_24_2=null;
        Token this_EXECUTE_27=null;
        Token lv_runnerAdvance_28_0=null;
        Token lv_isEarned_29_1=null;
        Token lv_isEarned_29_2=null;
        Token this_EXECUTE_32=null;
        Token lv_runnerAdvance_33_0=null;
        Token lv_isEarned_34_1=null;
        Token lv_isEarned_34_2=null;
        Token this_EXECUTE_37=null;
        Token lv_runnerAdvance_38_0=null;
        Token lv_isEarned_39_1=null;
        Token lv_isEarned_39_2=null;
        Token this_EXECUTE_42=null;
        Token lv_runnerAdvance_43_0=null;
        Token lv_isEarned_44_1=null;
        Token lv_isEarned_44_2=null;
        Token this_EXECUTE_47=null;
        Token lv_runnerAdvance_48_0=null;
        Token lv_isEarned_49_1=null;
        Token lv_isEarned_49_2=null;
        Token this_EXECUTE_52=null;
        Token lv_runnerAdvance_53_0=null;
        Token lv_isEarned_54_1=null;
        Token lv_isEarned_54_2=null;
        Token this_EXECUTE_57=null;
        Token lv_runnerAdvance_58_0=null;
        Token lv_isEarned_59_1=null;
        Token lv_isEarned_59_2=null;
        Token this_EXECUTE_62=null;
        Token lv_runnerAdvance_63_0=null;
        Token lv_isEarned_64_1=null;
        Token lv_isEarned_64_2=null;
        Token this_EXECUTE_67=null;
        Token lv_runnerAdvance_68_0=null;
        Token lv_isEarned_69_1=null;
        Token lv_isEarned_69_2=null;
        Token this_EXECUTE_72=null;
        Token lv_runnerAdvance_73_0=null;
        Token lv_isEarned_74_1=null;
        Token lv_isEarned_74_2=null;
        Token this_EXECUTE_77=null;
        Token lv_runnerAdvance_78_0=null;
        Token lv_isEarned_79_1=null;
        Token lv_isEarned_79_2=null;
        Token this_EXECUTE_82=null;
        Token lv_runnerAdvance_83_0=null;
        Token lv_isEarned_84_1=null;
        Token lv_isEarned_84_2=null;
        Token this_EXECUTE_87=null;
        Token lv_runnerAdvance_88_0=null;
        Token lv_isEarned_89_1=null;
        Token lv_isEarned_89_2=null;
        Token this_EXECUTE_92=null;
        Token lv_runnerAdvance_93_0=null;
        Token lv_isEarned_94_1=null;
        Token lv_isEarned_94_2=null;
        Token this_EXECUTE_97=null;
        Token lv_runnerAdvance_98_0=null;
        Token lv_isEarned_99_1=null;
        Token lv_isEarned_99_2=null;
        EObject lv_runner_1_0 = null;

        EObject lv_runner_6_0 = null;

        EObject lv_runner_11_0 = null;

        EObject lv_runner_16_0 = null;

        EObject lv_runner_21_0 = null;

        EObject lv_runner_26_0 = null;

        EObject lv_runner_31_0 = null;

        EObject lv_runner_36_0 = null;

        EObject lv_runner_41_0 = null;

        EObject lv_runner_46_0 = null;

        EObject lv_runner_51_0 = null;

        EObject lv_runner_56_0 = null;

        EObject lv_runner_61_0 = null;

        EObject lv_runner_66_0 = null;

        EObject lv_runner_71_0 = null;

        EObject lv_runner_76_0 = null;

        EObject lv_runner_81_0 = null;

        EObject lv_runner_86_0 = null;

        EObject lv_runner_91_0 = null;

        EObject lv_runner_96_0 = null;



        	enterRule();

        try {
            // InternalGame.g:2005:2: ( ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? ) ) )
            // InternalGame.g:2006:2: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? ) )
            {
            // InternalGame.g:2006:2: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? ) )
            int alt62=20;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalGame.g:2007:3: ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2007:3: ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2008:4: () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2008:4: ()
                    // InternalGame.g:2009:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceByBatterActionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2015:4: ( (lv_runner_1_0= ruleCurrentRunner ) )
                    // InternalGame.g:2016:5: (lv_runner_1_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2016:5: (lv_runner_1_0= ruleCurrentRunner )
                    // InternalGame.g:2017:6: lv_runner_1_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_1_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_1_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_46); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:2038:4: ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) )
                    // InternalGame.g:2039:5: (lv_runnerAdvance_3_0= RULE_ADVANCE )
                    {
                    // InternalGame.g:2039:5: (lv_runnerAdvance_3_0= RULE_ADVANCE )
                    // InternalGame.g:2040:6: lv_runnerAdvance_3_0= RULE_ADVANCE
                    {
                    lv_runnerAdvance_3_0=(Token)match(input,RULE_ADVANCE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_3_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceADVANCETerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_3_0,
                    							"org.bpy.score.game.Game.ADVANCE");
                    					

                    }


                    }

                    // InternalGame.g:2056:4: ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=113 && LA23_0<=114)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalGame.g:2057:5: ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2057:5: ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2058:6: (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2058:6: (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' )
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==113) ) {
                                alt22=1;
                            }
                            else if ( (LA22_0==114) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 22, 0, input);

                                throw nvae;
                            }
                            switch (alt22) {
                                case 1 :
                                    // InternalGame.g:2059:7: lv_isEarned_4_1= 'earned'
                                    {
                                    lv_isEarned_4_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_4_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_0_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_4_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2070:7: lv_isEarned_4_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_4_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_4_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_0_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_4_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:2085:3: ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2085:3: ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2086:4: () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2086:4: ()
                    // InternalGame.g:2087:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnErrorAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2093:4: ( (lv_runner_6_0= ruleCurrentRunner ) )
                    // InternalGame.g:2094:5: (lv_runner_6_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2094:5: (lv_runner_6_0= ruleCurrentRunner )
                    // InternalGame.g:2095:6: lv_runner_6_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_6_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_6_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_7=(Token)match(input,RULE_EXECUTE,FOLLOW_34); 

                    				newLeafNode(this_EXECUTE_7, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:2116:4: ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) )
                    // InternalGame.g:2117:5: (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR )
                    {
                    // InternalGame.g:2117:5: (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR )
                    // InternalGame.g:2118:6: lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR
                    {
                    lv_runnerAdvance_8_0=(Token)match(input,RULE_ADVANCE_ON_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_8_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceADVANCE_ON_ERRORTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_8_0,
                    							"org.bpy.score.game.Game.ADVANCE_ON_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:2134:4: ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=113 && LA25_0<=114)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalGame.g:2135:5: ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2135:5: ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2136:6: (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2136:6: (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' )
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==113) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==114) ) {
                                alt24=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 0, input);

                                throw nvae;
                            }
                            switch (alt24) {
                                case 1 :
                                    // InternalGame.g:2137:7: lv_isEarned_9_1= 'earned'
                                    {
                                    lv_isEarned_9_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_9_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_1_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_9_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2148:7: lv_isEarned_9_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_9_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_9_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_1_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_9_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:2163:3: ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2163:3: ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2164:4: () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2164:4: ()
                    // InternalGame.g:2165:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnStolenBaseAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2171:4: ( (lv_runner_11_0= ruleCurrentRunner ) )
                    // InternalGame.g:2172:5: (lv_runner_11_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2172:5: (lv_runner_11_0= ruleCurrentRunner )
                    // InternalGame.g:2173:6: lv_runner_11_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_11_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_11_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_12=(Token)match(input,RULE_EXECUTE,FOLLOW_48); 

                    				newLeafNode(this_EXECUTE_12, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:2194:4: ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) )
                    // InternalGame.g:2195:5: (lv_runnerAdvance_13_0= RULE_STOLEN_BASE )
                    {
                    // InternalGame.g:2195:5: (lv_runnerAdvance_13_0= RULE_STOLEN_BASE )
                    // InternalGame.g:2196:6: lv_runnerAdvance_13_0= RULE_STOLEN_BASE
                    {
                    lv_runnerAdvance_13_0=(Token)match(input,RULE_STOLEN_BASE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_13_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceSTOLEN_BASETerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_13_0,
                    							"org.bpy.score.game.Game.STOLEN_BASE");
                    					

                    }


                    }

                    // InternalGame.g:2212:4: ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0>=113 && LA27_0<=114)) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalGame.g:2213:5: ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2213:5: ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2214:6: (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2214:6: (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' )
                            int alt26=2;
                            int LA26_0 = input.LA(1);

                            if ( (LA26_0==113) ) {
                                alt26=1;
                            }
                            else if ( (LA26_0==114) ) {
                                alt26=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 26, 0, input);

                                throw nvae;
                            }
                            switch (alt26) {
                                case 1 :
                                    // InternalGame.g:2215:7: lv_isEarned_14_1= 'earned'
                                    {
                                    lv_isEarned_14_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_14_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_2_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_14_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2226:7: lv_isEarned_14_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_14_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_14_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_2_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_14_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:2241:3: ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2241:3: ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2242:4: () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2242:4: ()
                    // InternalGame.g:2243:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnWildPitchAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2249:4: ( (lv_runner_16_0= ruleCurrentRunner ) )
                    // InternalGame.g:2250:5: (lv_runner_16_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2250:5: (lv_runner_16_0= ruleCurrentRunner )
                    // InternalGame.g:2251:6: lv_runner_16_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_16_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_16_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_17=(Token)match(input,RULE_EXECUTE,FOLLOW_49); 

                    				newLeafNode(this_EXECUTE_17, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_3_2());
                    			
                    // InternalGame.g:2272:4: ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) )
                    // InternalGame.g:2273:5: (lv_runnerAdvance_18_0= RULE_WILD_PITCH )
                    {
                    // InternalGame.g:2273:5: (lv_runnerAdvance_18_0= RULE_WILD_PITCH )
                    // InternalGame.g:2274:6: lv_runnerAdvance_18_0= RULE_WILD_PITCH
                    {
                    lv_runnerAdvance_18_0=(Token)match(input,RULE_WILD_PITCH,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_18_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceWILD_PITCHTerminalRuleCall_3_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_18_0,
                    							"org.bpy.score.game.Game.WILD_PITCH");
                    					

                    }


                    }

                    // InternalGame.g:2290:4: ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=113 && LA29_0<=114)) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalGame.g:2291:5: ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2291:5: ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2292:6: (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2292:6: (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' )
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==113) ) {
                                alt28=1;
                            }
                            else if ( (LA28_0==114) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 28, 0, input);

                                throw nvae;
                            }
                            switch (alt28) {
                                case 1 :
                                    // InternalGame.g:2293:7: lv_isEarned_19_1= 'earned'
                                    {
                                    lv_isEarned_19_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_19_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_3_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_19_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2304:7: lv_isEarned_19_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_19_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_19_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_3_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_19_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:2319:3: ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2319:3: ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2320:4: () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2320:4: ()
                    // InternalGame.g:2321:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnPassBallAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2327:4: ( (lv_runner_21_0= ruleCurrentRunner ) )
                    // InternalGame.g:2328:5: (lv_runner_21_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2328:5: (lv_runner_21_0= ruleCurrentRunner )
                    // InternalGame.g:2329:6: lv_runner_21_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_21_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_21_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_22=(Token)match(input,RULE_EXECUTE,FOLLOW_50); 

                    				newLeafNode(this_EXECUTE_22, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_4_2());
                    			
                    // InternalGame.g:2350:4: ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) )
                    // InternalGame.g:2351:5: (lv_runnerAdvance_23_0= RULE_PASS_BALL )
                    {
                    // InternalGame.g:2351:5: (lv_runnerAdvance_23_0= RULE_PASS_BALL )
                    // InternalGame.g:2352:6: lv_runnerAdvance_23_0= RULE_PASS_BALL
                    {
                    lv_runnerAdvance_23_0=(Token)match(input,RULE_PASS_BALL,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_23_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvancePASS_BALLTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_23_0,
                    							"org.bpy.score.game.Game.PASS_BALL");
                    					

                    }


                    }

                    // InternalGame.g:2368:4: ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=113 && LA31_0<=114)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalGame.g:2369:5: ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2369:5: ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2370:6: (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2370:6: (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' )
                            int alt30=2;
                            int LA30_0 = input.LA(1);

                            if ( (LA30_0==113) ) {
                                alt30=1;
                            }
                            else if ( (LA30_0==114) ) {
                                alt30=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 30, 0, input);

                                throw nvae;
                            }
                            switch (alt30) {
                                case 1 :
                                    // InternalGame.g:2371:7: lv_isEarned_24_1= 'earned'
                                    {
                                    lv_isEarned_24_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_24_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_4_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_24_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2382:7: lv_isEarned_24_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_24_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_24_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_4_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_24_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalGame.g:2397:3: ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2397:3: ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2398:4: () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2398:4: ()
                    // InternalGame.g:2399:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnBalkAction_5_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2405:4: ( (lv_runner_26_0= ruleCurrentRunner ) )
                    // InternalGame.g:2406:5: (lv_runner_26_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2406:5: (lv_runner_26_0= ruleCurrentRunner )
                    // InternalGame.g:2407:6: lv_runner_26_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_26_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_26_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_27=(Token)match(input,RULE_EXECUTE,FOLLOW_51); 

                    				newLeafNode(this_EXECUTE_27, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_5_2());
                    			
                    // InternalGame.g:2428:4: ( (lv_runnerAdvance_28_0= RULE_BALK ) )
                    // InternalGame.g:2429:5: (lv_runnerAdvance_28_0= RULE_BALK )
                    {
                    // InternalGame.g:2429:5: (lv_runnerAdvance_28_0= RULE_BALK )
                    // InternalGame.g:2430:6: lv_runnerAdvance_28_0= RULE_BALK
                    {
                    lv_runnerAdvance_28_0=(Token)match(input,RULE_BALK,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_28_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceBALKTerminalRuleCall_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_28_0,
                    							"org.bpy.score.game.Game.BALK");
                    					

                    }


                    }

                    // InternalGame.g:2446:4: ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=113 && LA33_0<=114)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalGame.g:2447:5: ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2447:5: ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2448:6: (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2448:6: (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' )
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==113) ) {
                                alt32=1;
                            }
                            else if ( (LA32_0==114) ) {
                                alt32=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 32, 0, input);

                                throw nvae;
                            }
                            switch (alt32) {
                                case 1 :
                                    // InternalGame.g:2449:7: lv_isEarned_29_1= 'earned'
                                    {
                                    lv_isEarned_29_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_29_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_5_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_29_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2460:7: lv_isEarned_29_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_29_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_29_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_5_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_29_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalGame.g:2475:3: ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2475:3: ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2476:4: () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2476:4: ()
                    // InternalGame.g:2477:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnPickOffWithErrorAction_6_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2483:4: ( (lv_runner_31_0= ruleCurrentRunner ) )
                    // InternalGame.g:2484:5: (lv_runner_31_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2484:5: (lv_runner_31_0= ruleCurrentRunner )
                    // InternalGame.g:2485:6: lv_runner_31_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_31_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_31_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_32=(Token)match(input,RULE_EXECUTE,FOLLOW_35); 

                    				newLeafNode(this_EXECUTE_32, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_6_2());
                    			
                    // InternalGame.g:2506:4: ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) )
                    // InternalGame.g:2507:5: (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR )
                    {
                    // InternalGame.g:2507:5: (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR )
                    // InternalGame.g:2508:6: lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR
                    {
                    lv_runnerAdvance_33_0=(Token)match(input,RULE_PICK_OFF_WITH_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_33_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvancePICK_OFF_WITH_ERRORTerminalRuleCall_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_33_0,
                    							"org.bpy.score.game.Game.PICK_OFF_WITH_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:2524:4: ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=113 && LA35_0<=114)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalGame.g:2525:5: ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2525:5: ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2526:6: (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2526:6: (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' )
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==113) ) {
                                alt34=1;
                            }
                            else if ( (LA34_0==114) ) {
                                alt34=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 34, 0, input);

                                throw nvae;
                            }
                            switch (alt34) {
                                case 1 :
                                    // InternalGame.g:2527:7: lv_isEarned_34_1= 'earned'
                                    {
                                    lv_isEarned_34_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_34_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_6_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_34_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2538:7: lv_isEarned_34_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_34_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_34_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_6_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_34_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalGame.g:2553:3: ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2553:3: ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2554:4: () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2554:4: ()
                    // InternalGame.g:2555:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnCaughtStealingWithErrorAction_7_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2561:4: ( (lv_runner_36_0= ruleCurrentRunner ) )
                    // InternalGame.g:2562:5: (lv_runner_36_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2562:5: (lv_runner_36_0= ruleCurrentRunner )
                    // InternalGame.g:2563:6: lv_runner_36_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_36_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_36_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_37=(Token)match(input,RULE_EXECUTE,FOLLOW_36); 

                    				newLeafNode(this_EXECUTE_37, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_7_2());
                    			
                    // InternalGame.g:2584:4: ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) )
                    // InternalGame.g:2585:5: (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR )
                    {
                    // InternalGame.g:2585:5: (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR )
                    // InternalGame.g:2586:6: lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR
                    {
                    lv_runnerAdvance_38_0=(Token)match(input,RULE_CAUGTH_STEALING_WITH_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_38_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceCAUGTH_STEALING_WITH_ERRORTerminalRuleCall_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_38_0,
                    							"org.bpy.score.game.Game.CAUGTH_STEALING_WITH_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:2602:4: ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=113 && LA37_0<=114)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalGame.g:2603:5: ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2603:5: ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2604:6: (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2604:6: (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' )
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==113) ) {
                                alt36=1;
                            }
                            else if ( (LA36_0==114) ) {
                                alt36=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 36, 0, input);

                                throw nvae;
                            }
                            switch (alt36) {
                                case 1 :
                                    // InternalGame.g:2605:7: lv_isEarned_39_1= 'earned'
                                    {
                                    lv_isEarned_39_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_39_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_7_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_39_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2616:7: lv_isEarned_39_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_39_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_39_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_7_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_39_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalGame.g:2631:3: ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2631:3: ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2632:4: () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2632:4: ()
                    // InternalGame.g:2633:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnOccupedBallAction_8_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2639:4: ( (lv_runner_41_0= ruleCurrentRunner ) )
                    // InternalGame.g:2640:5: (lv_runner_41_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2640:5: (lv_runner_41_0= ruleCurrentRunner )
                    // InternalGame.g:2641:6: lv_runner_41_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_41_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_41_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_42=(Token)match(input,RULE_EXECUTE,FOLLOW_52); 

                    				newLeafNode(this_EXECUTE_42, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_8_2());
                    			
                    // InternalGame.g:2662:4: ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) )
                    // InternalGame.g:2663:5: (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    {
                    // InternalGame.g:2663:5: (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    // InternalGame.g:2664:6: lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT
                    {
                    lv_runnerAdvance_43_0=(Token)match(input,RULE_FIELDER_CHOICE_WITH_PUTOUT,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_43_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceFIELDER_CHOICE_WITH_PUTOUTTerminalRuleCall_8_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_43_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE_WITH_PUTOUT");
                    					

                    }


                    }

                    // InternalGame.g:2680:4: ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=113 && LA39_0<=114)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalGame.g:2681:5: ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2681:5: ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2682:6: (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2682:6: (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==113) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==114) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // InternalGame.g:2683:7: lv_isEarned_44_1= 'earned'
                                    {
                                    lv_isEarned_44_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_44_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_8_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_44_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2694:7: lv_isEarned_44_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_44_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_44_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_8_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_44_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalGame.g:2709:3: ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2709:3: ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2710:4: () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2710:4: ()
                    // InternalGame.g:2711:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnNoDecisiveObstructionAction_9_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2717:4: ( (lv_runner_46_0= ruleCurrentRunner ) )
                    // InternalGame.g:2718:5: (lv_runner_46_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2718:5: (lv_runner_46_0= ruleCurrentRunner )
                    // InternalGame.g:2719:6: lv_runner_46_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_46_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_46_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_47=(Token)match(input,RULE_EXECUTE,FOLLOW_53); 

                    				newLeafNode(this_EXECUTE_47, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_9_2());
                    			
                    // InternalGame.g:2740:4: ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) )
                    // InternalGame.g:2741:5: (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION )
                    {
                    // InternalGame.g:2741:5: (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION )
                    // InternalGame.g:2742:6: lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION
                    {
                    lv_runnerAdvance_48_0=(Token)match(input,RULE_NO_DECISIVE_OBSTRUCTION,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_48_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceNO_DECISIVE_OBSTRUCTIONTerminalRuleCall_9_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_48_0,
                    							"org.bpy.score.game.Game.NO_DECISIVE_OBSTRUCTION");
                    					

                    }


                    }

                    // InternalGame.g:2758:4: ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=113 && LA41_0<=114)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalGame.g:2759:5: ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2759:5: ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2760:6: (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2760:6: (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==113) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==114) ) {
                                alt40=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 40, 0, input);

                                throw nvae;
                            }
                            switch (alt40) {
                                case 1 :
                                    // InternalGame.g:2761:7: lv_isEarned_49_1= 'earned'
                                    {
                                    lv_isEarned_49_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_49_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_9_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_49_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2772:7: lv_isEarned_49_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_49_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_49_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_9_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_49_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalGame.g:2787:3: ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2787:3: ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2788:4: () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2788:4: ()
                    // InternalGame.g:2789:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnDecisiveObstructionAction_10_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2795:4: ( (lv_runner_51_0= ruleCurrentRunner ) )
                    // InternalGame.g:2796:5: (lv_runner_51_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2796:5: (lv_runner_51_0= ruleCurrentRunner )
                    // InternalGame.g:2797:6: lv_runner_51_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_10_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_51_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_51_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_52=(Token)match(input,RULE_EXECUTE,FOLLOW_54); 

                    				newLeafNode(this_EXECUTE_52, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_10_2());
                    			
                    // InternalGame.g:2818:4: ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) )
                    // InternalGame.g:2819:5: (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION )
                    {
                    // InternalGame.g:2819:5: (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION )
                    // InternalGame.g:2820:6: lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION
                    {
                    lv_runnerAdvance_53_0=(Token)match(input,RULE_DECISIVE_OBSTRUCTION,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_53_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceDECISIVE_OBSTRUCTIONTerminalRuleCall_10_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_53_0,
                    							"org.bpy.score.game.Game.DECISIVE_OBSTRUCTION");
                    					

                    }


                    }

                    // InternalGame.g:2836:4: ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=113 && LA43_0<=114)) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalGame.g:2837:5: ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2837:5: ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2838:6: (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2838:6: (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==113) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==114) ) {
                                alt42=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 42, 0, input);

                                throw nvae;
                            }
                            switch (alt42) {
                                case 1 :
                                    // InternalGame.g:2839:7: lv_isEarned_54_1= 'earned'
                                    {
                                    lv_isEarned_54_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_54_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_10_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_54_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2850:7: lv_isEarned_54_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_54_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_54_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_10_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_54_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalGame.g:2865:3: ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2865:3: ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2866:4: () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2866:4: ()
                    // InternalGame.g:2867:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnThrowAction_11_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2873:4: ( (lv_runner_56_0= ruleCurrentRunner ) )
                    // InternalGame.g:2874:5: (lv_runner_56_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2874:5: (lv_runner_56_0= ruleCurrentRunner )
                    // InternalGame.g:2875:6: lv_runner_56_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_56_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_56_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_57=(Token)match(input,RULE_EXECUTE,FOLLOW_55); 

                    				newLeafNode(this_EXECUTE_57, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_11_2());
                    			
                    // InternalGame.g:2896:4: ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) )
                    // InternalGame.g:2897:5: (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW )
                    {
                    // InternalGame.g:2897:5: (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW )
                    // InternalGame.g:2898:6: lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW
                    {
                    lv_runnerAdvance_58_0=(Token)match(input,RULE_ADVANCE_ON_THROW,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_58_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceADVANCE_ON_THROWTerminalRuleCall_11_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_58_0,
                    							"org.bpy.score.game.Game.ADVANCE_ON_THROW");
                    					

                    }


                    }

                    // InternalGame.g:2914:4: ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=113 && LA45_0<=114)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalGame.g:2915:5: ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2915:5: ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2916:6: (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2916:6: (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' )
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==113) ) {
                                alt44=1;
                            }
                            else if ( (LA44_0==114) ) {
                                alt44=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 44, 0, input);

                                throw nvae;
                            }
                            switch (alt44) {
                                case 1 :
                                    // InternalGame.g:2917:7: lv_isEarned_59_1= 'earned'
                                    {
                                    lv_isEarned_59_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_59_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_11_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_59_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:2928:7: lv_isEarned_59_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_59_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_59_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_11_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_59_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalGame.g:2943:3: ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:2943:3: ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:2944:4: () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:2944:4: ()
                    // InternalGame.g:2945:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnIndiferenceAction_12_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:2951:4: ( (lv_runner_61_0= ruleCurrentRunner ) )
                    // InternalGame.g:2952:5: (lv_runner_61_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:2952:5: (lv_runner_61_0= ruleCurrentRunner )
                    // InternalGame.g:2953:6: lv_runner_61_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_12_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_61_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_61_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_62=(Token)match(input,RULE_EXECUTE,FOLLOW_56); 

                    				newLeafNode(this_EXECUTE_62, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_12_2());
                    			
                    // InternalGame.g:2974:4: ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) )
                    // InternalGame.g:2975:5: (lv_runnerAdvance_63_0= RULE_INDIFERENCE )
                    {
                    // InternalGame.g:2975:5: (lv_runnerAdvance_63_0= RULE_INDIFERENCE )
                    // InternalGame.g:2976:6: lv_runnerAdvance_63_0= RULE_INDIFERENCE
                    {
                    lv_runnerAdvance_63_0=(Token)match(input,RULE_INDIFERENCE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_63_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceINDIFERENCETerminalRuleCall_12_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_63_0,
                    							"org.bpy.score.game.Game.INDIFERENCE");
                    					

                    }


                    }

                    // InternalGame.g:2992:4: ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=113 && LA47_0<=114)) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalGame.g:2993:5: ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:2993:5: ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:2994:6: (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:2994:6: (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' )
                            int alt46=2;
                            int LA46_0 = input.LA(1);

                            if ( (LA46_0==113) ) {
                                alt46=1;
                            }
                            else if ( (LA46_0==114) ) {
                                alt46=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 46, 0, input);

                                throw nvae;
                            }
                            switch (alt46) {
                                case 1 :
                                    // InternalGame.g:2995:7: lv_isEarned_64_1= 'earned'
                                    {
                                    lv_isEarned_64_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_64_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_12_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_64_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3006:7: lv_isEarned_64_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_64_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_64_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_12_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_64_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalGame.g:3021:3: ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3021:3: ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3022:4: () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3022:4: ()
                    // InternalGame.g:3023:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnThrowErrorAction_13_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3029:4: ( (lv_runner_66_0= ruleCurrentRunner ) )
                    // InternalGame.g:3030:5: (lv_runner_66_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3030:5: (lv_runner_66_0= ruleCurrentRunner )
                    // InternalGame.g:3031:6: lv_runner_66_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_13_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_66_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_66_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_67=(Token)match(input,RULE_EXECUTE,FOLLOW_37); 

                    				newLeafNode(this_EXECUTE_67, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_13_2());
                    			
                    // InternalGame.g:3052:4: ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) )
                    // InternalGame.g:3053:5: (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR )
                    {
                    // InternalGame.g:3053:5: (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR )
                    // InternalGame.g:3054:6: lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR
                    {
                    lv_runnerAdvance_68_0=(Token)match(input,RULE_REACH_ON_THROW_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_68_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceREACH_ON_THROW_ERRORTerminalRuleCall_13_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_68_0,
                    							"org.bpy.score.game.Game.REACH_ON_THROW_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:3070:4: ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( ((LA49_0>=113 && LA49_0<=114)) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalGame.g:3071:5: ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3071:5: ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3072:6: (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3072:6: (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' )
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==113) ) {
                                alt48=1;
                            }
                            else if ( (LA48_0==114) ) {
                                alt48=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 48, 0, input);

                                throw nvae;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalGame.g:3073:7: lv_isEarned_69_1= 'earned'
                                    {
                                    lv_isEarned_69_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_69_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_13_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_69_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3084:7: lv_isEarned_69_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_69_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_69_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_13_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_69_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalGame.g:3099:3: ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3099:3: ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3100:4: () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3100:4: ()
                    // InternalGame.g:3101:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnReceiveErrorAction_14_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3107:4: ( (lv_runner_71_0= ruleCurrentRunner ) )
                    // InternalGame.g:3108:5: (lv_runner_71_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3108:5: (lv_runner_71_0= ruleCurrentRunner )
                    // InternalGame.g:3109:6: lv_runner_71_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_71_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_71_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_72=(Token)match(input,RULE_EXECUTE,FOLLOW_38); 

                    				newLeafNode(this_EXECUTE_72, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_14_2());
                    			
                    // InternalGame.g:3130:4: ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:3131:5: (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:3131:5: (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR )
                    // InternalGame.g:3132:6: lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR
                    {
                    lv_runnerAdvance_73_0=(Token)match(input,RULE_REACH_ON_RECEIVE_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_73_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceREACH_ON_RECEIVE_ERRORTerminalRuleCall_14_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_73_0,
                    							"org.bpy.score.game.Game.REACH_ON_RECEIVE_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:3148:4: ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=113 && LA51_0<=114)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalGame.g:3149:5: ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3149:5: ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3150:6: (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3150:6: (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' )
                            int alt50=2;
                            int LA50_0 = input.LA(1);

                            if ( (LA50_0==113) ) {
                                alt50=1;
                            }
                            else if ( (LA50_0==114) ) {
                                alt50=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 50, 0, input);

                                throw nvae;
                            }
                            switch (alt50) {
                                case 1 :
                                    // InternalGame.g:3151:7: lv_isEarned_74_1= 'earned'
                                    {
                                    lv_isEarned_74_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_74_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_14_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_74_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3162:7: lv_isEarned_74_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_74_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_74_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_14_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_74_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalGame.g:3177:3: ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3177:3: ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3178:4: () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3178:4: ()
                    // InternalGame.g:3179:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnNonDecisiveThrowErrorAction_15_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3185:4: ( (lv_runner_76_0= ruleCurrentRunner ) )
                    // InternalGame.g:3186:5: (lv_runner_76_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3186:5: (lv_runner_76_0= ruleCurrentRunner )
                    // InternalGame.g:3187:6: lv_runner_76_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_15_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_76_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_76_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_77=(Token)match(input,RULE_EXECUTE,FOLLOW_39); 

                    				newLeafNode(this_EXECUTE_77, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_15_2());
                    			
                    // InternalGame.g:3208:4: ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) )
                    // InternalGame.g:3209:5: (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR )
                    {
                    // InternalGame.g:3209:5: (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR )
                    // InternalGame.g:3210:6: lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR
                    {
                    lv_runnerAdvance_78_0=(Token)match(input,RULE_EXTRA_ON_THROW_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_78_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceEXTRA_ON_THROW_ERRORTerminalRuleCall_15_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_78_0,
                    							"org.bpy.score.game.Game.EXTRA_ON_THROW_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:3226:4: ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=113 && LA53_0<=114)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalGame.g:3227:5: ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3227:5: ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3228:6: (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3228:6: (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' )
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==113) ) {
                                alt52=1;
                            }
                            else if ( (LA52_0==114) ) {
                                alt52=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 52, 0, input);

                                throw nvae;
                            }
                            switch (alt52) {
                                case 1 :
                                    // InternalGame.g:3229:7: lv_isEarned_79_1= 'earned'
                                    {
                                    lv_isEarned_79_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_79_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_15_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_79_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3240:7: lv_isEarned_79_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_79_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_79_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_15_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_79_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 17 :
                    // InternalGame.g:3255:3: ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3255:3: ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3256:4: () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3256:4: ()
                    // InternalGame.g:3257:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnNonDecisiveReceiveErrorAction_16_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3263:4: ( (lv_runner_81_0= ruleCurrentRunner ) )
                    // InternalGame.g:3264:5: (lv_runner_81_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3264:5: (lv_runner_81_0= ruleCurrentRunner )
                    // InternalGame.g:3265:6: lv_runner_81_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_16_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_81_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_81_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_82=(Token)match(input,RULE_EXECUTE,FOLLOW_40); 

                    				newLeafNode(this_EXECUTE_82, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_16_2());
                    			
                    // InternalGame.g:3286:4: ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:3287:5: (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:3287:5: (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    // InternalGame.g:3288:6: lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR
                    {
                    lv_runnerAdvance_83_0=(Token)match(input,RULE_EXTRA_ON_RECEIVE_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_83_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceEXTRA_ON_RECEIVE_ERRORTerminalRuleCall_16_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_83_0,
                    							"org.bpy.score.game.Game.EXTRA_ON_RECEIVE_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:3304:4: ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=113 && LA55_0<=114)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalGame.g:3305:5: ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3305:5: ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3306:6: (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3306:6: (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' )
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==113) ) {
                                alt54=1;
                            }
                            else if ( (LA54_0==114) ) {
                                alt54=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 54, 0, input);

                                throw nvae;
                            }
                            switch (alt54) {
                                case 1 :
                                    // InternalGame.g:3307:7: lv_isEarned_84_1= 'earned'
                                    {
                                    lv_isEarned_84_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_84_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_16_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_84_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3318:7: lv_isEarned_84_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_84_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_84_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_16_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_84_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 18 :
                    // InternalGame.g:3333:3: ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3333:3: ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3334:4: () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3334:4: ()
                    // InternalGame.g:3335:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnRuleAction_17_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3341:4: ( (lv_runner_86_0= ruleCurrentRunner ) )
                    // InternalGame.g:3342:5: (lv_runner_86_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3342:5: (lv_runner_86_0= ruleCurrentRunner )
                    // InternalGame.g:3343:6: lv_runner_86_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_17_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_86_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_86_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_87=(Token)match(input,RULE_EXECUTE,FOLLOW_57); 

                    				newLeafNode(this_EXECUTE_87, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_17_2());
                    			
                    // InternalGame.g:3364:4: ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) )
                    // InternalGame.g:3365:5: (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE )
                    {
                    // InternalGame.g:3365:5: (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE )
                    // InternalGame.g:3366:6: lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE
                    {
                    lv_runnerAdvance_88_0=(Token)match(input,RULE_ADVANCE_BY_RULE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_88_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceADVANCE_BY_RULETerminalRuleCall_17_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_88_0,
                    							"org.bpy.score.game.Game.ADVANCE_BY_RULE");
                    					

                    }


                    }

                    // InternalGame.g:3382:4: ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( ((LA57_0>=113 && LA57_0<=114)) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalGame.g:3383:5: ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3383:5: ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3384:6: (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3384:6: (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' )
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==113) ) {
                                alt56=1;
                            }
                            else if ( (LA56_0==114) ) {
                                alt56=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 0, input);

                                throw nvae;
                            }
                            switch (alt56) {
                                case 1 :
                                    // InternalGame.g:3385:7: lv_isEarned_89_1= 'earned'
                                    {
                                    lv_isEarned_89_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_89_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_17_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_89_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3396:7: lv_isEarned_89_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_89_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_89_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_17_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_89_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 19 :
                    // InternalGame.g:3411:3: ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3411:3: ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3412:4: () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3412:4: ()
                    // InternalGame.g:3413:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnOtherPlayerErrorAction_18_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3419:4: ( (lv_runner_91_0= ruleCurrentRunner ) )
                    // InternalGame.g:3420:5: (lv_runner_91_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3420:5: (lv_runner_91_0= ruleCurrentRunner )
                    // InternalGame.g:3421:6: lv_runner_91_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_18_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_91_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_91_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_92=(Token)match(input,RULE_EXECUTE,FOLLOW_58); 

                    				newLeafNode(this_EXECUTE_92, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_18_2());
                    			
                    // InternalGame.g:3442:4: ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) )
                    // InternalGame.g:3443:5: (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR )
                    {
                    // InternalGame.g:3443:5: (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR )
                    // InternalGame.g:3444:6: lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR
                    {
                    lv_runnerAdvance_93_0=(Token)match(input,RULE_ADVANCE_BY_OTHER_PLAYER_EROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_93_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceADVANCE_BY_OTHER_PLAYER_ERORTerminalRuleCall_18_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_93_0,
                    							"org.bpy.score.game.Game.ADVANCE_BY_OTHER_PLAYER_EROR");
                    					

                    }


                    }

                    // InternalGame.g:3460:4: ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( ((LA59_0>=113 && LA59_0<=114)) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalGame.g:3461:5: ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3461:5: ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3462:6: (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3462:6: (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' )
                            int alt58=2;
                            int LA58_0 = input.LA(1);

                            if ( (LA58_0==113) ) {
                                alt58=1;
                            }
                            else if ( (LA58_0==114) ) {
                                alt58=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 58, 0, input);

                                throw nvae;
                            }
                            switch (alt58) {
                                case 1 :
                                    // InternalGame.g:3463:7: lv_isEarned_94_1= 'earned'
                                    {
                                    lv_isEarned_94_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_94_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_18_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_94_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3474:7: lv_isEarned_94_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_94_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_94_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_18_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_94_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 20 :
                    // InternalGame.g:3489:3: ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:3489:3: ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:3490:4: () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:3490:4: ()
                    // InternalGame.g:3491:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceOnFielderChoiceAction_19_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:3497:4: ( (lv_runner_96_0= ruleCurrentRunner ) )
                    // InternalGame.g:3498:5: (lv_runner_96_0= ruleCurrentRunner )
                    {
                    // InternalGame.g:3498:5: (lv_runner_96_0= ruleCurrentRunner )
                    // InternalGame.g:3499:6: lv_runner_96_0= ruleCurrentRunner
                    {

                    						newCompositeNode(grammarAccess.getRunnerAdvanceAccess().getRunnerCurrentRunnerParserRuleCall_19_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_runner_96_0=ruleCurrentRunner();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"runner",
                    							lv_runner_96_0,
                    							"org.bpy.score.game.Game.CurrentRunner");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_97=(Token)match(input,RULE_EXECUTE,FOLLOW_59); 

                    				newLeafNode(this_EXECUTE_97, grammarAccess.getRunnerAdvanceAccess().getEXECUTETerminalRuleCall_19_2());
                    			
                    // InternalGame.g:3520:4: ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) )
                    // InternalGame.g:3521:5: (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE )
                    {
                    // InternalGame.g:3521:5: (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE )
                    // InternalGame.g:3522:6: lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE
                    {
                    lv_runnerAdvance_98_0=(Token)match(input,RULE_FIELDER_CHOICE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_98_0, grammarAccess.getRunnerAdvanceAccess().getRunnerAdvanceFIELDER_CHOICETerminalRuleCall_19_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_98_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE");
                    					

                    }


                    }

                    // InternalGame.g:3538:4: ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( ((LA61_0>=113 && LA61_0<=114)) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalGame.g:3539:5: ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:3539:5: ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:3540:6: (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:3540:6: (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' )
                            int alt60=2;
                            int LA60_0 = input.LA(1);

                            if ( (LA60_0==113) ) {
                                alt60=1;
                            }
                            else if ( (LA60_0==114) ) {
                                alt60=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 60, 0, input);

                                throw nvae;
                            }
                            switch (alt60) {
                                case 1 :
                                    // InternalGame.g:3541:7: lv_isEarned_99_1= 'earned'
                                    {
                                    lv_isEarned_99_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_99_1, grammarAccess.getRunnerAdvanceAccess().getIsEarnedEarnedKeyword_19_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_99_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:3552:7: lv_isEarned_99_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_99_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_99_2, grammarAccess.getRunnerAdvanceAccess().getIsEarnedUnEarnedForTeamKeyword_19_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getRunnerAdvanceRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_99_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRunnerAdvance"


    // $ANTLR start "entryRuleSubstitutionEvent"
    // InternalGame.g:3570:1: entryRuleSubstitutionEvent returns [EObject current=null] : iv_ruleSubstitutionEvent= ruleSubstitutionEvent EOF ;
    public final EObject entryRuleSubstitutionEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstitutionEvent = null;


        try {
            // InternalGame.g:3570:58: (iv_ruleSubstitutionEvent= ruleSubstitutionEvent EOF )
            // InternalGame.g:3571:2: iv_ruleSubstitutionEvent= ruleSubstitutionEvent EOF
            {
             newCompositeNode(grammarAccess.getSubstitutionEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubstitutionEvent=ruleSubstitutionEvent();

            state._fsp--;

             current =iv_ruleSubstitutionEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubstitutionEvent"


    // $ANTLR start "ruleSubstitutionEvent"
    // InternalGame.g:3577:1: ruleSubstitutionEvent returns [EObject current=null] : ( (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) ) | ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' ) ) ;
    public final EObject ruleSubstitutionEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_team_1_0 = null;

        EObject lv_substitutions_3_0 = null;

        EObject lv_substitutions_5_0 = null;

        EObject lv_substitutions_7_0 = null;



        	enterRule();

        try {
            // InternalGame.g:3583:2: ( ( (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) ) | ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' ) ) )
            // InternalGame.g:3584:2: ( (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) ) | ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' ) )
            {
            // InternalGame.g:3584:2: ( (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) ) | ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==115) ) {
                alt64=1;
            }
            else if ( (LA64_0==116) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalGame.g:3585:3: (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) )
                    {
                    // InternalGame.g:3585:3: (otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' ) )
                    // InternalGame.g:3586:4: otherlv_0= 'substitution' ( (lv_team_1_0= ruleTeamTypeEnum ) ) (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' )
                    {
                    otherlv_0=(Token)match(input,115,FOLLOW_9); 

                    				newLeafNode(otherlv_0, grammarAccess.getSubstitutionEventAccess().getSubstitutionKeyword_0_0());
                    			
                    // InternalGame.g:3590:4: ( (lv_team_1_0= ruleTeamTypeEnum ) )
                    // InternalGame.g:3591:5: (lv_team_1_0= ruleTeamTypeEnum )
                    {
                    // InternalGame.g:3591:5: (lv_team_1_0= ruleTeamTypeEnum )
                    // InternalGame.g:3592:6: lv_team_1_0= ruleTeamTypeEnum
                    {

                    						newCompositeNode(grammarAccess.getSubstitutionEventAccess().getTeamTeamTypeEnumParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_team_1_0=ruleTeamTypeEnum();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubstitutionEventRule());
                    						}
                    						set(
                    							current,
                    							"team",
                    							lv_team_1_0,
                    							"org.bpy.score.game.Game.TeamTypeEnum");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGame.g:3609:4: (otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}' )
                    // InternalGame.g:3610:5: otherlv_2= '{' ( (lv_substitutions_3_0= ruleSubstitutionDescription ) ) (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,90,FOLLOW_60); 

                    					newLeafNode(otherlv_2, grammarAccess.getSubstitutionEventAccess().getLeftCurlyBracketKeyword_0_2_0());
                    				
                    // InternalGame.g:3614:5: ( (lv_substitutions_3_0= ruleSubstitutionDescription ) )
                    // InternalGame.g:3615:6: (lv_substitutions_3_0= ruleSubstitutionDescription )
                    {
                    // InternalGame.g:3615:6: (lv_substitutions_3_0= ruleSubstitutionDescription )
                    // InternalGame.g:3616:7: lv_substitutions_3_0= ruleSubstitutionDescription
                    {

                    							newCompositeNode(grammarAccess.getSubstitutionEventAccess().getSubstitutionsSubstitutionDescriptionParserRuleCall_0_2_1_0());
                    						
                    pushFollow(FOLLOW_26);
                    lv_substitutions_3_0=ruleSubstitutionDescription();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getSubstitutionEventRule());
                    							}
                    							add(
                    								current,
                    								"substitutions",
                    								lv_substitutions_3_0,
                    								"org.bpy.score.game.Game.SubstitutionDescription");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalGame.g:3633:5: (otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==109) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalGame.g:3634:6: otherlv_4= ',' ( (lv_substitutions_5_0= ruleSubstitutionDescription ) )
                    	    {
                    	    otherlv_4=(Token)match(input,109,FOLLOW_60); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getSubstitutionEventAccess().getCommaKeyword_0_2_2_0());
                    	    					
                    	    // InternalGame.g:3638:6: ( (lv_substitutions_5_0= ruleSubstitutionDescription ) )
                    	    // InternalGame.g:3639:7: (lv_substitutions_5_0= ruleSubstitutionDescription )
                    	    {
                    	    // InternalGame.g:3639:7: (lv_substitutions_5_0= ruleSubstitutionDescription )
                    	    // InternalGame.g:3640:8: lv_substitutions_5_0= ruleSubstitutionDescription
                    	    {

                    	    								newCompositeNode(grammarAccess.getSubstitutionEventAccess().getSubstitutionsSubstitutionDescriptionParserRuleCall_0_2_2_1_0());
                    	    							
                    	    pushFollow(FOLLOW_26);
                    	    lv_substitutions_5_0=ruleSubstitutionDescription();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getSubstitutionEventRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"substitutions",
                    	    									lv_substitutions_5_0,
                    	    									"org.bpy.score.game.Game.SubstitutionDescription");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,91,FOLLOW_2); 

                    					newLeafNode(otherlv_6, grammarAccess.getSubstitutionEventAccess().getRightCurlyBracketKeyword_0_2_3());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:3665:3: ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' )
                    {
                    // InternalGame.g:3665:3: ( ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';' )
                    // InternalGame.g:3666:4: ( (lv_substitutions_7_0= ruleSubstitutionDescription ) ) otherlv_8= ';'
                    {
                    // InternalGame.g:3666:4: ( (lv_substitutions_7_0= ruleSubstitutionDescription ) )
                    // InternalGame.g:3667:5: (lv_substitutions_7_0= ruleSubstitutionDescription )
                    {
                    // InternalGame.g:3667:5: (lv_substitutions_7_0= ruleSubstitutionDescription )
                    // InternalGame.g:3668:6: lv_substitutions_7_0= ruleSubstitutionDescription
                    {

                    						newCompositeNode(grammarAccess.getSubstitutionEventAccess().getSubstitutionsSubstitutionDescriptionParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_substitutions_7_0=ruleSubstitutionDescription();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubstitutionEventRule());
                    						}
                    						add(
                    							current,
                    							"substitutions",
                    							lv_substitutions_7_0,
                    							"org.bpy.score.game.Game.SubstitutionDescription");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,93,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getSubstitutionEventAccess().getSemicolonKeyword_1_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubstitutionEvent"


    // $ANTLR start "entryRuleSubstitutionDescription"
    // InternalGame.g:3694:1: entryRuleSubstitutionDescription returns [EObject current=null] : iv_ruleSubstitutionDescription= ruleSubstitutionDescription EOF ;
    public final EObject entryRuleSubstitutionDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubstitutionDescription = null;


        try {
            // InternalGame.g:3694:64: (iv_ruleSubstitutionDescription= ruleSubstitutionDescription EOF )
            // InternalGame.g:3695:2: iv_ruleSubstitutionDescription= ruleSubstitutionDescription EOF
            {
             newCompositeNode(grammarAccess.getSubstitutionDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubstitutionDescription=ruleSubstitutionDescription();

            state._fsp--;

             current =iv_ruleSubstitutionDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubstitutionDescription"


    // $ANTLR start "ruleSubstitutionDescription"
    // InternalGame.g:3701:1: ruleSubstitutionDescription returns [EObject current=null] : (otherlv_0= 'player' ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) ) (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )? ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) ) ) ;
    public final EObject ruleSubstitutionDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_currentDefensivePosition_1_0 = null;

        EObject lv_subtitution_5_0 = null;

        EObject lv_subtitution_6_0 = null;



        	enterRule();

        try {
            // InternalGame.g:3707:2: ( (otherlv_0= 'player' ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) ) (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )? ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) ) ) )
            // InternalGame.g:3708:2: (otherlv_0= 'player' ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) ) (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )? ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) ) )
            {
            // InternalGame.g:3708:2: (otherlv_0= 'player' ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) ) (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )? ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) ) )
            // InternalGame.g:3709:3: otherlv_0= 'player' ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) ) (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )? ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) )
            {
            otherlv_0=(Token)match(input,116,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getSubstitutionDescriptionAccess().getPlayerKeyword_0());
            		
            // InternalGame.g:3713:3: ( (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition ) )
            // InternalGame.g:3714:4: (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition )
            {
            // InternalGame.g:3714:4: (lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition )
            // InternalGame.g:3715:5: lv_currentDefensivePosition_1_0= ruleLineUPCurrentDefensivePosition
            {

            					newCompositeNode(grammarAccess.getSubstitutionDescriptionAccess().getCurrentDefensivePositionLineUPCurrentDefensivePositionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_62);
            lv_currentDefensivePosition_1_0=ruleLineUPCurrentDefensivePosition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubstitutionDescriptionRule());
            					}
            					set(
            						current,
            						"currentDefensivePosition",
            						lv_currentDefensivePosition_1_0,
            						"org.bpy.score.game.Game.LineUPCurrentDefensivePosition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:3732:3: (otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==117) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalGame.g:3733:4: otherlv_2= '(' ( (lv_name_3_0= RULE_STRING ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,117,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSubstitutionDescriptionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGame.g:3737:4: ( (lv_name_3_0= RULE_STRING ) )
                    // InternalGame.g:3738:5: (lv_name_3_0= RULE_STRING )
                    {
                    // InternalGame.g:3738:5: (lv_name_3_0= RULE_STRING )
                    // InternalGame.g:3739:6: lv_name_3_0= RULE_STRING
                    {
                    lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_63); 

                    						newLeafNode(lv_name_3_0, grammarAccess.getSubstitutionDescriptionAccess().getNameSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSubstitutionDescriptionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,118,FOLLOW_62); 

                    				newLeafNode(otherlv_4, grammarAccess.getSubstitutionDescriptionAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalGame.g:3760:3: ( ( (lv_subtitution_5_0= ruleReplacement ) ) | ( (lv_subtitution_6_0= ruleNewDefensivePosition ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==121) ) {
                alt66=1;
            }
            else if ( (LA66_0==119) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalGame.g:3761:4: ( (lv_subtitution_5_0= ruleReplacement ) )
                    {
                    // InternalGame.g:3761:4: ( (lv_subtitution_5_0= ruleReplacement ) )
                    // InternalGame.g:3762:5: (lv_subtitution_5_0= ruleReplacement )
                    {
                    // InternalGame.g:3762:5: (lv_subtitution_5_0= ruleReplacement )
                    // InternalGame.g:3763:6: lv_subtitution_5_0= ruleReplacement
                    {

                    						newCompositeNode(grammarAccess.getSubstitutionDescriptionAccess().getSubtitutionReplacementParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_subtitution_5_0=ruleReplacement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubstitutionDescriptionRule());
                    						}
                    						set(
                    							current,
                    							"subtitution",
                    							lv_subtitution_5_0,
                    							"org.bpy.score.game.Game.Replacement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:3781:4: ( (lv_subtitution_6_0= ruleNewDefensivePosition ) )
                    {
                    // InternalGame.g:3781:4: ( (lv_subtitution_6_0= ruleNewDefensivePosition ) )
                    // InternalGame.g:3782:5: (lv_subtitution_6_0= ruleNewDefensivePosition )
                    {
                    // InternalGame.g:3782:5: (lv_subtitution_6_0= ruleNewDefensivePosition )
                    // InternalGame.g:3783:6: lv_subtitution_6_0= ruleNewDefensivePosition
                    {

                    						newCompositeNode(grammarAccess.getSubstitutionDescriptionAccess().getSubtitutionNewDefensivePositionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_subtitution_6_0=ruleNewDefensivePosition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubstitutionDescriptionRule());
                    						}
                    						set(
                    							current,
                    							"subtitution",
                    							lv_subtitution_6_0,
                    							"org.bpy.score.game.Game.NewDefensivePosition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubstitutionDescription"


    // $ANTLR start "entryRuleNewDefensivePosition"
    // InternalGame.g:3805:1: entryRuleNewDefensivePosition returns [EObject current=null] : iv_ruleNewDefensivePosition= ruleNewDefensivePosition EOF ;
    public final EObject entryRuleNewDefensivePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewDefensivePosition = null;


        try {
            // InternalGame.g:3805:61: (iv_ruleNewDefensivePosition= ruleNewDefensivePosition EOF )
            // InternalGame.g:3806:2: iv_ruleNewDefensivePosition= ruleNewDefensivePosition EOF
            {
             newCompositeNode(grammarAccess.getNewDefensivePositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNewDefensivePosition=ruleNewDefensivePosition();

            state._fsp--;

             current =iv_ruleNewDefensivePosition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewDefensivePosition"


    // $ANTLR start "ruleNewDefensivePosition"
    // InternalGame.g:3812:1: ruleNewDefensivePosition returns [EObject current=null] : (otherlv_0= 'moveTo' ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) ) (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )? ) ;
    public final EObject ruleNewDefensivePosition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_laterality_4_0=null;
        AntlrDatatypeRuleToken lv_newDefensivePosition_1_0 = null;



        	enterRule();

        try {
            // InternalGame.g:3818:2: ( (otherlv_0= 'moveTo' ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) ) (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )? ) )
            // InternalGame.g:3819:2: (otherlv_0= 'moveTo' ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) ) (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )? )
            {
            // InternalGame.g:3819:2: (otherlv_0= 'moveTo' ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) ) (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )? )
            // InternalGame.g:3820:3: otherlv_0= 'moveTo' ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) ) (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )?
            {
            otherlv_0=(Token)match(input,119,FOLLOW_64); 

            			newLeafNode(otherlv_0, grammarAccess.getNewDefensivePositionAccess().getMoveToKeyword_0());
            		
            // InternalGame.g:3824:3: ( (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition ) )
            // InternalGame.g:3825:4: (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition )
            {
            // InternalGame.g:3825:4: (lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition )
            // InternalGame.g:3826:5: lv_newDefensivePosition_1_0= ruleLineUPAtDefensivePosition
            {

            					newCompositeNode(grammarAccess.getNewDefensivePositionAccess().getNewDefensivePositionLineUPAtDefensivePositionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_65);
            lv_newDefensivePosition_1_0=ruleLineUPAtDefensivePosition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNewDefensivePositionRule());
            					}
            					set(
            						current,
            						"newDefensivePosition",
            						lv_newDefensivePosition_1_0,
            						"org.bpy.score.game.Game.LineUPAtDefensivePosition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:3843:3: (otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==120) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalGame.g:3844:4: otherlv_2= 'laterality' otherlv_3= '=' ( (lv_laterality_4_0= RULE_LATERALITY ) )
                    {
                    otherlv_2=(Token)match(input,120,FOLLOW_15); 

                    				newLeafNode(otherlv_2, grammarAccess.getNewDefensivePositionAccess().getLateralityKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,97,FOLLOW_66); 

                    				newLeafNode(otherlv_3, grammarAccess.getNewDefensivePositionAccess().getEqualsSignKeyword_2_1());
                    			
                    // InternalGame.g:3852:4: ( (lv_laterality_4_0= RULE_LATERALITY ) )
                    // InternalGame.g:3853:5: (lv_laterality_4_0= RULE_LATERALITY )
                    {
                    // InternalGame.g:3853:5: (lv_laterality_4_0= RULE_LATERALITY )
                    // InternalGame.g:3854:6: lv_laterality_4_0= RULE_LATERALITY
                    {
                    lv_laterality_4_0=(Token)match(input,RULE_LATERALITY,FOLLOW_2); 

                    						newLeafNode(lv_laterality_4_0, grammarAccess.getNewDefensivePositionAccess().getLateralityLATERALITYTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNewDefensivePositionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"laterality",
                    							lv_laterality_4_0,
                    							"org.bpy.score.game.Game.LATERALITY");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewDefensivePosition"


    // $ANTLR start "entryRuleReplacement"
    // InternalGame.g:3875:1: entryRuleReplacement returns [EObject current=null] : iv_ruleReplacement= ruleReplacement EOF ;
    public final EObject entryRuleReplacement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacement = null;


        try {
            // InternalGame.g:3875:52: (iv_ruleReplacement= ruleReplacement EOF )
            // InternalGame.g:3876:2: iv_ruleReplacement= ruleReplacement EOF
            {
             newCompositeNode(grammarAccess.getReplacementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReplacement=ruleReplacement();

            state._fsp--;

             current =iv_ruleReplacement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReplacement"


    // $ANTLR start "ruleReplacement"
    // InternalGame.g:3882:1: ruleReplacement returns [EObject current=null] : (otherlv_0= 'replaceBy' ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) ) (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )? (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )? ) ;
    public final EObject ruleReplacement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_shirtNumber_4_0=null;
        Token lv_defensivePosition_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_laterality_10_0=null;
        AntlrDatatypeRuleToken lv_newDefensivePosition_7_0 = null;



        	enterRule();

        try {
            // InternalGame.g:3888:2: ( (otherlv_0= 'replaceBy' ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) ) (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )? (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )? ) )
            // InternalGame.g:3889:2: (otherlv_0= 'replaceBy' ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) ) (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )? (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )? )
            {
            // InternalGame.g:3889:2: (otherlv_0= 'replaceBy' ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) ) (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )? (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )? )
            // InternalGame.g:3890:3: otherlv_0= 'replaceBy' ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) ) (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )? (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )?
            {
            otherlv_0=(Token)match(input,121,FOLLOW_67); 

            			newLeafNode(otherlv_0, grammarAccess.getReplacementAccess().getReplaceByKeyword_0());
            		
            // InternalGame.g:3894:3: ( ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? ) | ( (lv_defensivePosition_5_0= RULE_INT ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_STRING) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_INT) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalGame.g:3895:4: ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? )
                    {
                    // InternalGame.g:3895:4: ( ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )? )
                    // InternalGame.g:3896:5: ( (lv_name_1_0= RULE_STRING ) ) (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )?
                    {
                    // InternalGame.g:3896:5: ( (lv_name_1_0= RULE_STRING ) )
                    // InternalGame.g:3897:6: (lv_name_1_0= RULE_STRING )
                    {
                    // InternalGame.g:3897:6: (lv_name_1_0= RULE_STRING )
                    // InternalGame.g:3898:7: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_68); 

                    							newLeafNode(lv_name_1_0, grammarAccess.getReplacementAccess().getNameSTRINGTerminalRuleCall_1_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getReplacementRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

                    }


                    }

                    // InternalGame.g:3914:5: (otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==122) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalGame.g:3915:6: otherlv_2= 'shirtNumber' otherlv_3= '=' ( (lv_shirtNumber_4_0= RULE_INT ) )
                            {
                            otherlv_2=(Token)match(input,122,FOLLOW_15); 

                            						newLeafNode(otherlv_2, grammarAccess.getReplacementAccess().getShirtNumberKeyword_1_0_1_0());
                            					
                            otherlv_3=(Token)match(input,97,FOLLOW_19); 

                            						newLeafNode(otherlv_3, grammarAccess.getReplacementAccess().getEqualsSignKeyword_1_0_1_1());
                            					
                            // InternalGame.g:3923:6: ( (lv_shirtNumber_4_0= RULE_INT ) )
                            // InternalGame.g:3924:7: (lv_shirtNumber_4_0= RULE_INT )
                            {
                            // InternalGame.g:3924:7: (lv_shirtNumber_4_0= RULE_INT )
                            // InternalGame.g:3925:8: lv_shirtNumber_4_0= RULE_INT
                            {
                            lv_shirtNumber_4_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                            								newLeafNode(lv_shirtNumber_4_0, grammarAccess.getReplacementAccess().getShirtNumberINTTerminalRuleCall_1_0_1_2_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getReplacementRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"shirtNumber",
                            									lv_shirtNumber_4_0,
                            									"org.eclipse.xtext.common.Terminals.INT");
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:3944:4: ( (lv_defensivePosition_5_0= RULE_INT ) )
                    {
                    // InternalGame.g:3944:4: ( (lv_defensivePosition_5_0= RULE_INT ) )
                    // InternalGame.g:3945:5: (lv_defensivePosition_5_0= RULE_INT )
                    {
                    // InternalGame.g:3945:5: (lv_defensivePosition_5_0= RULE_INT )
                    // InternalGame.g:3946:6: lv_defensivePosition_5_0= RULE_INT
                    {
                    lv_defensivePosition_5_0=(Token)match(input,RULE_INT,FOLLOW_69); 

                    						newLeafNode(lv_defensivePosition_5_0, grammarAccess.getReplacementAccess().getDefensivePositionINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReplacementRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"defensivePosition",
                    							lv_defensivePosition_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalGame.g:3963:3: (otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==123) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalGame.g:3964:4: otherlv_6= 'at' ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) )
                    {
                    otherlv_6=(Token)match(input,123,FOLLOW_64); 

                    				newLeafNode(otherlv_6, grammarAccess.getReplacementAccess().getAtKeyword_2_0());
                    			
                    // InternalGame.g:3968:4: ( (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition ) )
                    // InternalGame.g:3969:5: (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition )
                    {
                    // InternalGame.g:3969:5: (lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition )
                    // InternalGame.g:3970:6: lv_newDefensivePosition_7_0= ruleLineUPAtDefensivePosition
                    {

                    						newCompositeNode(grammarAccess.getReplacementAccess().getNewDefensivePositionLineUPAtDefensivePositionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_65);
                    lv_newDefensivePosition_7_0=ruleLineUPAtDefensivePosition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReplacementRule());
                    						}
                    						set(
                    							current,
                    							"newDefensivePosition",
                    							lv_newDefensivePosition_7_0,
                    							"org.bpy.score.game.Game.LineUPAtDefensivePosition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalGame.g:3988:3: (otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==120) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalGame.g:3989:4: otherlv_8= 'laterality' otherlv_9= '=' ( (lv_laterality_10_0= RULE_LATERALITY ) )
                    {
                    otherlv_8=(Token)match(input,120,FOLLOW_15); 

                    				newLeafNode(otherlv_8, grammarAccess.getReplacementAccess().getLateralityKeyword_3_0());
                    			
                    otherlv_9=(Token)match(input,97,FOLLOW_66); 

                    				newLeafNode(otherlv_9, grammarAccess.getReplacementAccess().getEqualsSignKeyword_3_1());
                    			
                    // InternalGame.g:3997:4: ( (lv_laterality_10_0= RULE_LATERALITY ) )
                    // InternalGame.g:3998:5: (lv_laterality_10_0= RULE_LATERALITY )
                    {
                    // InternalGame.g:3998:5: (lv_laterality_10_0= RULE_LATERALITY )
                    // InternalGame.g:3999:6: lv_laterality_10_0= RULE_LATERALITY
                    {
                    lv_laterality_10_0=(Token)match(input,RULE_LATERALITY,FOLLOW_2); 

                    						newLeafNode(lv_laterality_10_0, grammarAccess.getReplacementAccess().getLateralityLATERALITYTerminalRuleCall_3_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReplacementRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"laterality",
                    							lv_laterality_10_0,
                    							"org.bpy.score.game.Game.LATERALITY");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReplacement"


    // $ANTLR start "entryRuleBatterAction"
    // InternalGame.g:4020:1: entryRuleBatterAction returns [EObject current=null] : iv_ruleBatterAction= ruleBatterAction EOF ;
    public final EObject entryRuleBatterAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterAction = null;


        try {
            // InternalGame.g:4020:53: (iv_ruleBatterAction= ruleBatterAction EOF )
            // InternalGame.g:4021:2: iv_ruleBatterAction= ruleBatterAction EOF
            {
             newCompositeNode(grammarAccess.getBatterActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterAction=ruleBatterAction();

            state._fsp--;

             current =iv_ruleBatterAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterAction"


    // $ANTLR start "ruleBatterAction"
    // InternalGame.g:4027:1: ruleBatterAction returns [EObject current=null] : (this_BatterOut_0= ruleBatterOut | this_BatterAdvance_1= ruleBatterAdvance | this_BatterLostTurn_2= ruleBatterLostTurn | this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall | this_BatterBalk_4= ruleBatterBalk ) ;
    public final EObject ruleBatterAction() throws RecognitionException {
        EObject current = null;

        EObject this_BatterOut_0 = null;

        EObject this_BatterAdvance_1 = null;

        EObject this_BatterLostTurn_2 = null;

        EObject this_BatterMustOutOnFlyFoulBall_3 = null;

        EObject this_BatterBalk_4 = null;



        	enterRule();

        try {
            // InternalGame.g:4033:2: ( (this_BatterOut_0= ruleBatterOut | this_BatterAdvance_1= ruleBatterAdvance | this_BatterLostTurn_2= ruleBatterLostTurn | this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall | this_BatterBalk_4= ruleBatterBalk ) )
            // InternalGame.g:4034:2: (this_BatterOut_0= ruleBatterOut | this_BatterAdvance_1= ruleBatterAdvance | this_BatterLostTurn_2= ruleBatterLostTurn | this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall | this_BatterBalk_4= ruleBatterBalk )
            {
            // InternalGame.g:4034:2: (this_BatterOut_0= ruleBatterOut | this_BatterAdvance_1= ruleBatterAdvance | this_BatterLostTurn_2= ruleBatterLostTurn | this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall | this_BatterBalk_4= ruleBatterBalk )
            int alt72=5;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // InternalGame.g:4035:3: this_BatterOut_0= ruleBatterOut
                    {

                    			newCompositeNode(grammarAccess.getBatterActionAccess().getBatterOutParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BatterOut_0=ruleBatterOut();

                    state._fsp--;


                    			current = this_BatterOut_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:4044:3: this_BatterAdvance_1= ruleBatterAdvance
                    {

                    			newCompositeNode(grammarAccess.getBatterActionAccess().getBatterAdvanceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BatterAdvance_1=ruleBatterAdvance();

                    state._fsp--;


                    			current = this_BatterAdvance_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGame.g:4053:3: this_BatterLostTurn_2= ruleBatterLostTurn
                    {

                    			newCompositeNode(grammarAccess.getBatterActionAccess().getBatterLostTurnParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BatterLostTurn_2=ruleBatterLostTurn();

                    state._fsp--;


                    			current = this_BatterLostTurn_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGame.g:4062:3: this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall
                    {

                    			newCompositeNode(grammarAccess.getBatterActionAccess().getBatterMustOutOnFlyFoulBallParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BatterMustOutOnFlyFoulBall_3=ruleBatterMustOutOnFlyFoulBall();

                    state._fsp--;


                    			current = this_BatterMustOutOnFlyFoulBall_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalGame.g:4071:3: this_BatterBalk_4= ruleBatterBalk
                    {

                    			newCompositeNode(grammarAccess.getBatterActionAccess().getBatterBalkParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BatterBalk_4=ruleBatterBalk();

                    state._fsp--;


                    			current = this_BatterBalk_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterAction"


    // $ANTLR start "entryRuleBatterBalk"
    // InternalGame.g:4083:1: entryRuleBatterBalk returns [EObject current=null] : iv_ruleBatterBalk= ruleBatterBalk EOF ;
    public final EObject entryRuleBatterBalk() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterBalk = null;


        try {
            // InternalGame.g:4083:51: (iv_ruleBatterBalk= ruleBatterBalk EOF )
            // InternalGame.g:4084:2: iv_ruleBatterBalk= ruleBatterBalk EOF
            {
             newCompositeNode(grammarAccess.getBatterBalkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterBalk=ruleBatterBalk();

            state._fsp--;

             current =iv_ruleBatterBalk; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterBalk"


    // $ANTLR start "ruleBatterBalk"
    // InternalGame.g:4090:1: ruleBatterBalk returns [EObject current=null] : ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAction_3_0= RULE_BALK ) ) ) ;
    public final EObject ruleBatterBalk() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterAction_3_0=null;
        EObject lv_currentBatter_1_0 = null;



        	enterRule();

        try {
            // InternalGame.g:4096:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAction_3_0= RULE_BALK ) ) ) )
            // InternalGame.g:4097:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAction_3_0= RULE_BALK ) ) )
            {
            // InternalGame.g:4097:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAction_3_0= RULE_BALK ) ) )
            // InternalGame.g:4098:3: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAction_3_0= RULE_BALK ) )
            {
            // InternalGame.g:4098:3: ()
            // InternalGame.g:4099:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBatterBalkAccess().getBatterBalkAction_0(),
            					current);
            			

            }

            // InternalGame.g:4105:3: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
            // InternalGame.g:4106:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            {
            // InternalGame.g:4106:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            // InternalGame.g:4107:5: lv_currentBatter_1_0= ruleCurrentBatter
            {

            					newCompositeNode(grammarAccess.getBatterBalkAccess().getCurrentBatterCurrentBatterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_currentBatter_1_0=ruleCurrentBatter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBatterBalkRule());
            					}
            					set(
            						current,
            						"currentBatter",
            						lv_currentBatter_1_0,
            						"org.bpy.score.game.Game.CurrentBatter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_51); 

            			newLeafNode(this_EXECUTE_2, grammarAccess.getBatterBalkAccess().getEXECUTETerminalRuleCall_2());
            		
            // InternalGame.g:4128:3: ( (lv_batterAction_3_0= RULE_BALK ) )
            // InternalGame.g:4129:4: (lv_batterAction_3_0= RULE_BALK )
            {
            // InternalGame.g:4129:4: (lv_batterAction_3_0= RULE_BALK )
            // InternalGame.g:4130:5: lv_batterAction_3_0= RULE_BALK
            {
            lv_batterAction_3_0=(Token)match(input,RULE_BALK,FOLLOW_2); 

            					newLeafNode(lv_batterAction_3_0, grammarAccess.getBatterBalkAccess().getBatterActionBALKTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBatterBalkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"batterAction",
            						lv_batterAction_3_0,
            						"org.bpy.score.game.Game.BALK");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterBalk"


    // $ANTLR start "entryRuleBatterMustOutOnFlyFoulBall"
    // InternalGame.g:4150:1: entryRuleBatterMustOutOnFlyFoulBall returns [EObject current=null] : iv_ruleBatterMustOutOnFlyFoulBall= ruleBatterMustOutOnFlyFoulBall EOF ;
    public final EObject entryRuleBatterMustOutOnFlyFoulBall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterMustOutOnFlyFoulBall = null;


        try {
            // InternalGame.g:4150:67: (iv_ruleBatterMustOutOnFlyFoulBall= ruleBatterMustOutOnFlyFoulBall EOF )
            // InternalGame.g:4151:2: iv_ruleBatterMustOutOnFlyFoulBall= ruleBatterMustOutOnFlyFoulBall EOF
            {
             newCompositeNode(grammarAccess.getBatterMustOutOnFlyFoulBallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterMustOutOnFlyFoulBall=ruleBatterMustOutOnFlyFoulBall();

            state._fsp--;

             current =iv_ruleBatterMustOutOnFlyFoulBall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterMustOutOnFlyFoulBall"


    // $ANTLR start "ruleBatterMustOutOnFlyFoulBall"
    // InternalGame.g:4157:1: ruleBatterMustOutOnFlyFoulBall returns [EObject current=null] : ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) ;
    public final EObject ruleBatterMustOutOnFlyFoulBall() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_error_3_0=null;
        EObject lv_currentBatter_1_0 = null;



        	enterRule();

        try {
            // InternalGame.g:4163:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) )
            // InternalGame.g:4164:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) ) )
            {
            // InternalGame.g:4164:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) ) )
            // InternalGame.g:4165:3: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) )
            {
            // InternalGame.g:4165:3: ()
            // InternalGame.g:4166:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBatterMustOutOnFlyFoulBallAccess().getBatterMustOutOnFlyFoulBallAction_0(),
            					current);
            			

            }

            // InternalGame.g:4172:3: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
            // InternalGame.g:4173:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            {
            // InternalGame.g:4173:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            // InternalGame.g:4174:5: lv_currentBatter_1_0= ruleCurrentBatter
            {

            					newCompositeNode(grammarAccess.getBatterMustOutOnFlyFoulBallAccess().getCurrentBatterCurrentBatterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_currentBatter_1_0=ruleCurrentBatter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBatterMustOutOnFlyFoulBallRule());
            					}
            					set(
            						current,
            						"currentBatter",
            						lv_currentBatter_1_0,
            						"org.bpy.score.game.Game.CurrentBatter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_33); 

            			newLeafNode(this_EXECUTE_2, grammarAccess.getBatterMustOutOnFlyFoulBallAccess().getEXECUTETerminalRuleCall_2());
            		
            // InternalGame.g:4195:3: ( (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR ) )
            // InternalGame.g:4196:4: (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR )
            {
            // InternalGame.g:4196:4: (lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR )
            // InternalGame.g:4197:5: lv_error_3_0= RULE_MUST_BE_OUT_ON_ERROR
            {
            lv_error_3_0=(Token)match(input,RULE_MUST_BE_OUT_ON_ERROR,FOLLOW_2); 

            					newLeafNode(lv_error_3_0, grammarAccess.getBatterMustOutOnFlyFoulBallAccess().getErrorMUST_BE_OUT_ON_ERRORTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBatterMustOutOnFlyFoulBallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"error",
            						lv_error_3_0,
            						"org.bpy.score.game.Game.MUST_BE_OUT_ON_ERROR");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterMustOutOnFlyFoulBall"


    // $ANTLR start "entryRuleBatterLostTurn"
    // InternalGame.g:4217:1: entryRuleBatterLostTurn returns [EObject current=null] : iv_ruleBatterLostTurn= ruleBatterLostTurn EOF ;
    public final EObject entryRuleBatterLostTurn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterLostTurn = null;


        try {
            // InternalGame.g:4217:55: (iv_ruleBatterLostTurn= ruleBatterLostTurn EOF )
            // InternalGame.g:4218:2: iv_ruleBatterLostTurn= ruleBatterLostTurn EOF
            {
             newCompositeNode(grammarAccess.getBatterLostTurnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterLostTurn=ruleBatterLostTurn();

            state._fsp--;

             current =iv_ruleBatterLostTurn; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterLostTurn"


    // $ANTLR start "ruleBatterLostTurn"
    // InternalGame.g:4224:1: ruleBatterLostTurn returns [EObject current=null] : ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) ) ) ;
    public final EObject ruleBatterLostTurn() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterAdvance_3_0=null;
        EObject lv_currentBatter_1_0 = null;



        	enterRule();

        try {
            // InternalGame.g:4230:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) ) ) )
            // InternalGame.g:4231:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) ) )
            {
            // InternalGame.g:4231:2: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) ) )
            // InternalGame.g:4232:3: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) )
            {
            // InternalGame.g:4232:3: ()
            // InternalGame.g:4233:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBatterLostTurnAccess().getBatterLostTurnAction_0(),
            					current);
            			

            }

            // InternalGame.g:4239:3: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
            // InternalGame.g:4240:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            {
            // InternalGame.g:4240:4: (lv_currentBatter_1_0= ruleCurrentBatter )
            // InternalGame.g:4241:5: lv_currentBatter_1_0= ruleCurrentBatter
            {

            					newCompositeNode(grammarAccess.getBatterLostTurnAccess().getCurrentBatterCurrentBatterParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_currentBatter_1_0=ruleCurrentBatter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBatterLostTurnRule());
            					}
            					set(
            						current,
            						"currentBatter",
            						lv_currentBatter_1_0,
            						"org.bpy.score.game.Game.CurrentBatter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_70); 

            			newLeafNode(this_EXECUTE_2, grammarAccess.getBatterLostTurnAccess().getEXECUTETerminalRuleCall_2());
            		
            // InternalGame.g:4262:3: ( (lv_batterAdvance_3_0= RULE_LOST_TURN ) )
            // InternalGame.g:4263:4: (lv_batterAdvance_3_0= RULE_LOST_TURN )
            {
            // InternalGame.g:4263:4: (lv_batterAdvance_3_0= RULE_LOST_TURN )
            // InternalGame.g:4264:5: lv_batterAdvance_3_0= RULE_LOST_TURN
            {
            lv_batterAdvance_3_0=(Token)match(input,RULE_LOST_TURN,FOLLOW_2); 

            					newLeafNode(lv_batterAdvance_3_0, grammarAccess.getBatterLostTurnAccess().getBatterAdvanceLOST_TURNTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBatterLostTurnRule());
            					}
            					setWithLastConsumed(
            						current,
            						"batterAdvance",
            						lv_batterAdvance_3_0,
            						"org.bpy.score.game.Game.LOST_TURN");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterLostTurn"


    // $ANTLR start "entryRuleBatterAdvance"
    // InternalGame.g:4284:1: entryRuleBatterAdvance returns [EObject current=null] : iv_ruleBatterAdvance= ruleBatterAdvance EOF ;
    public final EObject entryRuleBatterAdvance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterAdvance = null;


        try {
            // InternalGame.g:4284:54: (iv_ruleBatterAdvance= ruleBatterAdvance EOF )
            // InternalGame.g:4285:2: iv_ruleBatterAdvance= ruleBatterAdvance EOF
            {
             newCompositeNode(grammarAccess.getBatterAdvanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterAdvance=ruleBatterAdvance();

            state._fsp--;

             current =iv_ruleBatterAdvance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterAdvance"


    // $ANTLR start "ruleBatterAdvance"
    // InternalGame.g:4291:1: ruleBatterAdvance returns [EObject current=null] : ( (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter ) ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )* ( (lv_out_5_0= ruleMoreAdanceFail ) )? ) ;
    public final EObject ruleBatterAdvance() throws RecognitionException {
        EObject current = null;

        EObject this_Hit_0 = null;

        EObject this_DecisiveError_1 = null;

        EObject this_OtherBatterAdvance_2 = null;

        EObject this_DefensiveChoiceForBatter_3 = null;

        EObject lv_moreAdvances_4_0 = null;

        EObject lv_out_5_0 = null;



        	enterRule();

        try {
            // InternalGame.g:4297:2: ( ( (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter ) ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )* ( (lv_out_5_0= ruleMoreAdanceFail ) )? ) )
            // InternalGame.g:4298:2: ( (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter ) ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )* ( (lv_out_5_0= ruleMoreAdanceFail ) )? )
            {
            // InternalGame.g:4298:2: ( (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter ) ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )* ( (lv_out_5_0= ruleMoreAdanceFail ) )? )
            // InternalGame.g:4299:3: (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter ) ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )* ( (lv_out_5_0= ruleMoreAdanceFail ) )?
            {
            // InternalGame.g:4299:3: (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter )
            int alt73=4;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalGame.g:4300:4: this_Hit_0= ruleHit
                    {

                    				newCompositeNode(grammarAccess.getBatterAdvanceAccess().getHitParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_29);
                    this_Hit_0=ruleHit();

                    state._fsp--;


                    				current = this_Hit_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalGame.g:4309:4: this_DecisiveError_1= ruleDecisiveError
                    {

                    				newCompositeNode(grammarAccess.getBatterAdvanceAccess().getDecisiveErrorParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_29);
                    this_DecisiveError_1=ruleDecisiveError();

                    state._fsp--;


                    				current = this_DecisiveError_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 3 :
                    // InternalGame.g:4318:4: this_OtherBatterAdvance_2= ruleOtherBatterAdvance
                    {

                    				newCompositeNode(grammarAccess.getBatterAdvanceAccess().getOtherBatterAdvanceParserRuleCall_0_2());
                    			
                    pushFollow(FOLLOW_29);
                    this_OtherBatterAdvance_2=ruleOtherBatterAdvance();

                    state._fsp--;


                    				current = this_OtherBatterAdvance_2;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 4 :
                    // InternalGame.g:4327:4: this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter
                    {

                    				newCompositeNode(grammarAccess.getBatterAdvanceAccess().getDefensiveChoiceForBatterParserRuleCall_0_3());
                    			
                    pushFollow(FOLLOW_29);
                    this_DefensiveChoiceForBatter_3=ruleDefensiveChoiceForBatter();

                    state._fsp--;


                    				current = this_DefensiveChoiceForBatter_3;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalGame.g:4336:3: ( (lv_moreAdvances_4_0= ruleAdvanceWithContinuation ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ADVANCE_ON_ERROR||(LA74_0>=RULE_REACH_ON_THROW_ERROR && LA74_0<=RULE_EXTRA_ON_RECEIVE_ERROR)||(LA74_0>=RULE_STOLEN_BASE && LA74_0<=RULE_ADVANCE_BY_RULE)||LA74_0==RULE_FIELDER_CHOICE||LA74_0==RULE_EXTRA_ON_FLY_ERROR) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalGame.g:4337:4: (lv_moreAdvances_4_0= ruleAdvanceWithContinuation )
            	    {
            	    // InternalGame.g:4337:4: (lv_moreAdvances_4_0= ruleAdvanceWithContinuation )
            	    // InternalGame.g:4338:5: lv_moreAdvances_4_0= ruleAdvanceWithContinuation
            	    {

            	    					newCompositeNode(grammarAccess.getBatterAdvanceAccess().getMoreAdvancesAdvanceWithContinuationParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_moreAdvances_4_0=ruleAdvanceWithContinuation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBatterAdvanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"moreAdvances",
            	    						lv_moreAdvances_4_0,
            	    						"org.bpy.score.game.Game.AdvanceWithContinuation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            // InternalGame.g:4355:3: ( (lv_out_5_0= ruleMoreAdanceFail ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_INT||(LA75_0>=RULE_OUT_BY_RULE && LA75_0<=RULE_APPEAL)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalGame.g:4356:4: (lv_out_5_0= ruleMoreAdanceFail )
                    {
                    // InternalGame.g:4356:4: (lv_out_5_0= ruleMoreAdanceFail )
                    // InternalGame.g:4357:5: lv_out_5_0= ruleMoreAdanceFail
                    {

                    					newCompositeNode(grammarAccess.getBatterAdvanceAccess().getOutMoreAdanceFailParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_out_5_0=ruleMoreAdanceFail();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBatterAdvanceRule());
                    					}
                    					set(
                    						current,
                    						"out",
                    						lv_out_5_0,
                    						"org.bpy.score.game.Game.MoreAdanceFail");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterAdvance"


    // $ANTLR start "entryRuleDefensiveChoiceForBatter"
    // InternalGame.g:4378:1: entryRuleDefensiveChoiceForBatter returns [EObject current=null] : iv_ruleDefensiveChoiceForBatter= ruleDefensiveChoiceForBatter EOF ;
    public final EObject entryRuleDefensiveChoiceForBatter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefensiveChoiceForBatter = null;


        try {
            // InternalGame.g:4378:65: (iv_ruleDefensiveChoiceForBatter= ruleDefensiveChoiceForBatter EOF )
            // InternalGame.g:4379:2: iv_ruleDefensiveChoiceForBatter= ruleDefensiveChoiceForBatter EOF
            {
             newCompositeNode(grammarAccess.getDefensiveChoiceForBatterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefensiveChoiceForBatter=ruleDefensiveChoiceForBatter();

            state._fsp--;

             current =iv_ruleDefensiveChoiceForBatter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefensiveChoiceForBatter"


    // $ANTLR start "ruleDefensiveChoiceForBatter"
    // InternalGame.g:4385:1: ruleDefensiveChoiceForBatter returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) ) ) ;
    public final EObject ruleDefensiveChoiceForBatter() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterAdvance_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_batterAdvance_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_batterAdvance_11_0=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;



        	enterRule();

        try {
            // InternalGame.g:4391:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) ) ) )
            // InternalGame.g:4392:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) ) )
            {
            // InternalGame.g:4392:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) ) )
            int alt76=3;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_BATTER) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==117) ) {
                    int LA76_2 = input.LA(3);

                    if ( (LA76_2==RULE_STRING) ) {
                        int LA76_4 = input.LA(4);

                        if ( (LA76_4==118) ) {
                            int LA76_8 = input.LA(5);

                            if ( (LA76_8==RULE_EXECUTE) ) {
                                switch ( input.LA(6) ) {
                                case RULE_FIELDER_CHOICE:
                                    {
                                    alt76=2;
                                    }
                                    break;
                                case RULE_FIELDER_CHOICE_WITH_PUTOUT:
                                    {
                                    alt76=1;
                                    }
                                    break;
                                case RULE_INDIFERENCE:
                                    {
                                    alt76=3;
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 76, 3, input);

                                    throw nvae;
                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 76, 8, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 76, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA76_1==RULE_EXECUTE) ) {
                    switch ( input.LA(3) ) {
                    case RULE_FIELDER_CHOICE:
                        {
                        alt76=2;
                        }
                        break;
                    case RULE_FIELDER_CHOICE_WITH_PUTOUT:
                        {
                        alt76=1;
                        }
                        break;
                    case RULE_INDIFERENCE:
                        {
                        alt76=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalGame.g:4393:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) )
                    {
                    // InternalGame.g:4393:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) )
                    // InternalGame.g:4394:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) )
                    {
                    // InternalGame.g:4394:4: ()
                    // InternalGame.g:4395:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceOnOccupedBallAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4401:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:4402:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:4402:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:4403:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDefensiveChoiceForBatterAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_52); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getDefensiveChoiceForBatterAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:4424:4: ( (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) )
                    // InternalGame.g:4425:5: (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    {
                    // InternalGame.g:4425:5: (lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    // InternalGame.g:4426:6: lv_batterAdvance_3_0= RULE_FIELDER_CHOICE_WITH_PUTOUT
                    {
                    lv_batterAdvance_3_0=(Token)match(input,RULE_FIELDER_CHOICE_WITH_PUTOUT,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_3_0, grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceFIELDER_CHOICE_WITH_PUTOUTTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_3_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE_WITH_PUTOUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:4444:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) )
                    {
                    // InternalGame.g:4444:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) ) )
                    // InternalGame.g:4445:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) )
                    {
                    // InternalGame.g:4445:4: ()
                    // InternalGame.g:4446:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceOnDefensiveChoiceAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4452:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:4453:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:4453:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:4454:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDefensiveChoiceForBatterAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_59); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getDefensiveChoiceForBatterAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:4475:4: ( (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE ) )
                    // InternalGame.g:4476:5: (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE )
                    {
                    // InternalGame.g:4476:5: (lv_batterAdvance_7_0= RULE_FIELDER_CHOICE )
                    // InternalGame.g:4477:6: lv_batterAdvance_7_0= RULE_FIELDER_CHOICE
                    {
                    lv_batterAdvance_7_0=(Token)match(input,RULE_FIELDER_CHOICE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_7_0, grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceFIELDER_CHOICETerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_7_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:4495:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) )
                    {
                    // InternalGame.g:4495:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) ) )
                    // InternalGame.g:4496:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) )
                    {
                    // InternalGame.g:4496:4: ()
                    // InternalGame.g:4497:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceOnIndiferenceAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4503:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:4504:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:4504:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:4505:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDefensiveChoiceForBatterAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_56); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getDefensiveChoiceForBatterAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:4526:4: ( (lv_batterAdvance_11_0= RULE_INDIFERENCE ) )
                    // InternalGame.g:4527:5: (lv_batterAdvance_11_0= RULE_INDIFERENCE )
                    {
                    // InternalGame.g:4527:5: (lv_batterAdvance_11_0= RULE_INDIFERENCE )
                    // InternalGame.g:4528:6: lv_batterAdvance_11_0= RULE_INDIFERENCE
                    {
                    lv_batterAdvance_11_0=(Token)match(input,RULE_INDIFERENCE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_11_0, grammarAccess.getDefensiveChoiceForBatterAccess().getBatterAdvanceINDIFERENCETerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDefensiveChoiceForBatterRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_11_0,
                    							"org.bpy.score.game.Game.INDIFERENCE");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefensiveChoiceForBatter"


    // $ANTLR start "entryRuleMoreAdanceFail"
    // InternalGame.g:4549:1: entryRuleMoreAdanceFail returns [EObject current=null] : iv_ruleMoreAdanceFail= ruleMoreAdanceFail EOF ;
    public final EObject entryRuleMoreAdanceFail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoreAdanceFail = null;


        try {
            // InternalGame.g:4549:55: (iv_ruleMoreAdanceFail= ruleMoreAdanceFail EOF )
            // InternalGame.g:4550:2: iv_ruleMoreAdanceFail= ruleMoreAdanceFail EOF
            {
             newCompositeNode(grammarAccess.getMoreAdanceFailRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoreAdanceFail=ruleMoreAdanceFail();

            state._fsp--;

             current =iv_ruleMoreAdanceFail; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMoreAdanceFail"


    // $ANTLR start "ruleMoreAdanceFail"
    // InternalGame.g:4556:1: ruleMoreAdanceFail returns [EObject current=null] : ( ( () ( (lv_runnerOut_1_0= RULE_INT ) ) ) | ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) ) ) ;
    public final EObject ruleMoreAdanceFail() throws RecognitionException {
        EObject current = null;

        Token lv_runnerOut_1_0=null;
        Token lv_runnerOut_3_0=null;
        Token lv_runnerOut_5_0=null;


        	enterRule();

        try {
            // InternalGame.g:4562:2: ( ( ( () ( (lv_runnerOut_1_0= RULE_INT ) ) ) | ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) ) ) )
            // InternalGame.g:4563:2: ( ( () ( (lv_runnerOut_1_0= RULE_INT ) ) ) | ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) ) )
            {
            // InternalGame.g:4563:2: ( ( () ( (lv_runnerOut_1_0= RULE_INT ) ) ) | ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) ) )
            int alt77=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt77=1;
                }
                break;
            case RULE_OUT_BY_RULE:
                {
                alt77=2;
                }
                break;
            case RULE_APPEAL:
                {
                alt77=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalGame.g:4564:3: ( () ( (lv_runnerOut_1_0= RULE_INT ) ) )
                    {
                    // InternalGame.g:4564:3: ( () ( (lv_runnerOut_1_0= RULE_INT ) ) )
                    // InternalGame.g:4565:4: () ( (lv_runnerOut_1_0= RULE_INT ) )
                    {
                    // InternalGame.g:4565:4: ()
                    // InternalGame.g:4566:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMoreAdanceFailAccess().getRunnerOutOnFielderActionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4572:4: ( (lv_runnerOut_1_0= RULE_INT ) )
                    // InternalGame.g:4573:5: (lv_runnerOut_1_0= RULE_INT )
                    {
                    // InternalGame.g:4573:5: (lv_runnerOut_1_0= RULE_INT )
                    // InternalGame.g:4574:6: lv_runnerOut_1_0= RULE_INT
                    {
                    lv_runnerOut_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_runnerOut_1_0, grammarAccess.getMoreAdanceFailAccess().getRunnerOutINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMoreAdanceFailRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerOut",
                    							lv_runnerOut_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:4592:3: ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) )
                    {
                    // InternalGame.g:4592:3: ( () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) ) )
                    // InternalGame.g:4593:4: () ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) )
                    {
                    // InternalGame.g:4593:4: ()
                    // InternalGame.g:4594:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMoreAdanceFailAccess().getRunnerOutByRulesAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4600:4: ( (lv_runnerOut_3_0= RULE_OUT_BY_RULE ) )
                    // InternalGame.g:4601:5: (lv_runnerOut_3_0= RULE_OUT_BY_RULE )
                    {
                    // InternalGame.g:4601:5: (lv_runnerOut_3_0= RULE_OUT_BY_RULE )
                    // InternalGame.g:4602:6: lv_runnerOut_3_0= RULE_OUT_BY_RULE
                    {
                    lv_runnerOut_3_0=(Token)match(input,RULE_OUT_BY_RULE,FOLLOW_2); 

                    						newLeafNode(lv_runnerOut_3_0, grammarAccess.getMoreAdanceFailAccess().getRunnerOutOUT_BY_RULETerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMoreAdanceFailRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerOut",
                    							lv_runnerOut_3_0,
                    							"org.bpy.score.game.Game.OUT_BY_RULE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:4620:3: ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) )
                    {
                    // InternalGame.g:4620:3: ( () ( (lv_runnerOut_5_0= RULE_APPEAL ) ) )
                    // InternalGame.g:4621:4: () ( (lv_runnerOut_5_0= RULE_APPEAL ) )
                    {
                    // InternalGame.g:4621:4: ()
                    // InternalGame.g:4622:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMoreAdanceFailAccess().getRunnerOutOnAppealAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4628:4: ( (lv_runnerOut_5_0= RULE_APPEAL ) )
                    // InternalGame.g:4629:5: (lv_runnerOut_5_0= RULE_APPEAL )
                    {
                    // InternalGame.g:4629:5: (lv_runnerOut_5_0= RULE_APPEAL )
                    // InternalGame.g:4630:6: lv_runnerOut_5_0= RULE_APPEAL
                    {
                    lv_runnerOut_5_0=(Token)match(input,RULE_APPEAL,FOLLOW_2); 

                    						newLeafNode(lv_runnerOut_5_0, grammarAccess.getMoreAdanceFailAccess().getRunnerOutAPPEALTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMoreAdanceFailRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerOut",
                    							lv_runnerOut_5_0,
                    							"org.bpy.score.game.Game.APPEAL");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMoreAdanceFail"


    // $ANTLR start "entryRuleAdvanceWithContinuation"
    // InternalGame.g:4651:1: entryRuleAdvanceWithContinuation returns [EObject current=null] : iv_ruleAdvanceWithContinuation= ruleAdvanceWithContinuation EOF ;
    public final EObject entryRuleAdvanceWithContinuation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvanceWithContinuation = null;


        try {
            // InternalGame.g:4651:64: (iv_ruleAdvanceWithContinuation= ruleAdvanceWithContinuation EOF )
            // InternalGame.g:4652:2: iv_ruleAdvanceWithContinuation= ruleAdvanceWithContinuation EOF
            {
             newCompositeNode(grammarAccess.getAdvanceWithContinuationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdvanceWithContinuation=ruleAdvanceWithContinuation();

            state._fsp--;

             current =iv_ruleAdvanceWithContinuation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdvanceWithContinuation"


    // $ANTLR start "ruleAdvanceWithContinuation"
    // InternalGame.g:4658:1: ruleAdvanceWithContinuation returns [EObject current=null] : ( ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? ) ) ;
    public final EObject ruleAdvanceWithContinuation() throws RecognitionException {
        EObject current = null;

        Token lv_runnerAdvance_1_0=null;
        Token lv_isEarned_2_1=null;
        Token lv_isEarned_2_2=null;
        Token lv_runnerAdvance_4_0=null;
        Token lv_isEarned_5_1=null;
        Token lv_isEarned_5_2=null;
        Token lv_runnerAdvance_7_0=null;
        Token lv_isEarned_8_1=null;
        Token lv_isEarned_8_2=null;
        Token lv_runnerAdvance_10_0=null;
        Token lv_isEarned_11_1=null;
        Token lv_isEarned_11_2=null;
        Token lv_runnerAdvance_13_0=null;
        Token lv_isEarned_14_1=null;
        Token lv_isEarned_14_2=null;
        Token lv_runnerAdvance_16_0=null;
        Token lv_isEarned_17_1=null;
        Token lv_isEarned_17_2=null;
        Token lv_runnerAdvance_19_0=null;
        Token lv_isEarned_20_1=null;
        Token lv_isEarned_20_2=null;
        Token lv_runnerAdvance_22_0=null;
        Token lv_isEarned_23_1=null;
        Token lv_isEarned_23_2=null;
        Token lv_runnerAdvance_25_0=null;
        Token lv_isEarned_26_1=null;
        Token lv_isEarned_26_2=null;
        Token lv_runnerAdvance_28_0=null;
        Token lv_isEarned_29_1=null;
        Token lv_isEarned_29_2=null;
        Token lv_runnerAdvance_31_0=null;
        Token lv_isEarned_32_1=null;
        Token lv_isEarned_32_2=null;
        Token lv_runnerAdvance_34_0=null;
        Token lv_isEarned_35_1=null;
        Token lv_isEarned_35_2=null;
        Token lv_runnerAdvance_37_0=null;
        Token lv_isEarned_38_1=null;
        Token lv_isEarned_38_2=null;
        Token lv_runnerAdvance_40_0=null;
        Token lv_isEarned_41_1=null;
        Token lv_isEarned_41_2=null;
        Token lv_runnerAdvance_43_0=null;
        Token lv_isEarned_44_1=null;
        Token lv_isEarned_44_2=null;
        Token lv_runnerAdvance_46_0=null;
        Token lv_isEarned_47_1=null;
        Token lv_isEarned_47_2=null;
        Token lv_runnerAdvance_49_0=null;
        Token lv_isEarned_50_1=null;
        Token lv_isEarned_50_2=null;


        	enterRule();

        try {
            // InternalGame.g:4664:2: ( ( ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? ) ) )
            // InternalGame.g:4665:2: ( ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? ) )
            {
            // InternalGame.g:4665:2: ( ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? ) )
            int alt112=17;
            switch ( input.LA(1) ) {
            case RULE_EXTRA_ON_FLY_ERROR:
                {
                alt112=1;
                }
                break;
            case RULE_ADVANCE_ON_ERROR:
                {
                alt112=2;
                }
                break;
            case RULE_EXTRA_ON_THROW_ERROR:
                {
                alt112=3;
                }
                break;
            case RULE_EXTRA_ON_RECEIVE_ERROR:
                {
                alt112=4;
                }
                break;
            case RULE_FIELDER_CHOICE_WITH_PUTOUT:
                {
                alt112=5;
                }
                break;
            case RULE_FIELDER_CHOICE:
                {
                alt112=6;
                }
                break;
            case RULE_REACH_ON_THROW_ERROR:
                {
                alt112=7;
                }
                break;
            case RULE_REACH_ON_RECEIVE_ERROR:
                {
                alt112=8;
                }
                break;
            case RULE_ADVANCE_ON_THROW:
                {
                alt112=9;
                }
                break;
            case RULE_NO_DECISIVE_OBSTRUCTION:
                {
                alt112=10;
                }
                break;
            case RULE_DECISIVE_OBSTRUCTION:
                {
                alt112=11;
                }
                break;
            case RULE_ADVANCE_BY_RULE:
                {
                alt112=12;
                }
                break;
            case RULE_INDIFERENCE:
                {
                alt112=13;
                }
                break;
            case RULE_WILD_PITCH:
                {
                alt112=14;
                }
                break;
            case RULE_PASS_BALL:
                {
                alt112=15;
                }
                break;
            case RULE_BALK:
                {
                alt112=16;
                }
                break;
            case RULE_STOLEN_BASE:
                {
                alt112=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalGame.g:4666:3: ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4666:3: ( () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4667:4: () ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) ) ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4667:4: ()
                    // InternalGame.g:4668:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnNonDecisiveFlyErrorAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4674:4: ( (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR ) )
                    // InternalGame.g:4675:5: (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR )
                    {
                    // InternalGame.g:4675:5: (lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR )
                    // InternalGame.g:4676:6: lv_runnerAdvance_1_0= RULE_EXTRA_ON_FLY_ERROR
                    {
                    lv_runnerAdvance_1_0=(Token)match(input,RULE_EXTRA_ON_FLY_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_1_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceEXTRA_ON_FLY_ERRORTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_1_0,
                    							"org.bpy.score.game.Game.EXTRA_ON_FLY_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:4692:4: ( ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( ((LA79_0>=113 && LA79_0<=114)) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalGame.g:4693:5: ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4693:5: ( (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4694:6: (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4694:6: (lv_isEarned_2_1= 'earned' | lv_isEarned_2_2= 'unEarnedForTeam' )
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==113) ) {
                                alt78=1;
                            }
                            else if ( (LA78_0==114) ) {
                                alt78=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 78, 0, input);

                                throw nvae;
                            }
                            switch (alt78) {
                                case 1 :
                                    // InternalGame.g:4695:7: lv_isEarned_2_1= 'earned'
                                    {
                                    lv_isEarned_2_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_2_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_0_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_2_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4706:7: lv_isEarned_2_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_2_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_2_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_0_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_2_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:4721:3: ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4721:3: ( () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4722:4: () ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4722:4: ()
                    // InternalGame.g:4723:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnErrorAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4729:4: ( (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR ) )
                    // InternalGame.g:4730:5: (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR )
                    {
                    // InternalGame.g:4730:5: (lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR )
                    // InternalGame.g:4731:6: lv_runnerAdvance_4_0= RULE_ADVANCE_ON_ERROR
                    {
                    lv_runnerAdvance_4_0=(Token)match(input,RULE_ADVANCE_ON_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_4_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceADVANCE_ON_ERRORTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_4_0,
                    							"org.bpy.score.game.Game.ADVANCE_ON_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:4747:4: ( ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( ((LA81_0>=113 && LA81_0<=114)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalGame.g:4748:5: ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4748:5: ( (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4749:6: (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4749:6: (lv_isEarned_5_1= 'earned' | lv_isEarned_5_2= 'unEarnedForTeam' )
                            int alt80=2;
                            int LA80_0 = input.LA(1);

                            if ( (LA80_0==113) ) {
                                alt80=1;
                            }
                            else if ( (LA80_0==114) ) {
                                alt80=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 80, 0, input);

                                throw nvae;
                            }
                            switch (alt80) {
                                case 1 :
                                    // InternalGame.g:4750:7: lv_isEarned_5_1= 'earned'
                                    {
                                    lv_isEarned_5_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_5_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_1_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_5_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4761:7: lv_isEarned_5_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_5_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_5_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_1_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_5_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:4776:3: ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4776:3: ( () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4777:4: () ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4777:4: ()
                    // InternalGame.g:4778:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnNonDecisiveThrowErrorAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4784:4: ( (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR ) )
                    // InternalGame.g:4785:5: (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR )
                    {
                    // InternalGame.g:4785:5: (lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR )
                    // InternalGame.g:4786:6: lv_runnerAdvance_7_0= RULE_EXTRA_ON_THROW_ERROR
                    {
                    lv_runnerAdvance_7_0=(Token)match(input,RULE_EXTRA_ON_THROW_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_7_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceEXTRA_ON_THROW_ERRORTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_7_0,
                    							"org.bpy.score.game.Game.EXTRA_ON_THROW_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:4802:4: ( ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( ((LA83_0>=113 && LA83_0<=114)) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalGame.g:4803:5: ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4803:5: ( (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4804:6: (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4804:6: (lv_isEarned_8_1= 'earned' | lv_isEarned_8_2= 'unEarnedForTeam' )
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( (LA82_0==113) ) {
                                alt82=1;
                            }
                            else if ( (LA82_0==114) ) {
                                alt82=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 82, 0, input);

                                throw nvae;
                            }
                            switch (alt82) {
                                case 1 :
                                    // InternalGame.g:4805:7: lv_isEarned_8_1= 'earned'
                                    {
                                    lv_isEarned_8_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_8_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_2_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_8_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4816:7: lv_isEarned_8_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_8_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_8_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_2_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_8_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:4831:3: ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4831:3: ( () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4832:4: () ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4832:4: ()
                    // InternalGame.g:4833:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnNonDecisiveReceiveErrorAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4839:4: ( (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:4840:5: (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:4840:5: (lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR )
                    // InternalGame.g:4841:6: lv_runnerAdvance_10_0= RULE_EXTRA_ON_RECEIVE_ERROR
                    {
                    lv_runnerAdvance_10_0=(Token)match(input,RULE_EXTRA_ON_RECEIVE_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_10_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceEXTRA_ON_RECEIVE_ERRORTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_10_0,
                    							"org.bpy.score.game.Game.EXTRA_ON_RECEIVE_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:4857:4: ( ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( ((LA85_0>=113 && LA85_0<=114)) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalGame.g:4858:5: ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4858:5: ( (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4859:6: (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4859:6: (lv_isEarned_11_1= 'earned' | lv_isEarned_11_2= 'unEarnedForTeam' )
                            int alt84=2;
                            int LA84_0 = input.LA(1);

                            if ( (LA84_0==113) ) {
                                alt84=1;
                            }
                            else if ( (LA84_0==114) ) {
                                alt84=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 84, 0, input);

                                throw nvae;
                            }
                            switch (alt84) {
                                case 1 :
                                    // InternalGame.g:4860:7: lv_isEarned_11_1= 'earned'
                                    {
                                    lv_isEarned_11_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_11_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_3_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_11_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4871:7: lv_isEarned_11_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_11_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_11_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_3_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_11_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:4886:3: ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4886:3: ( () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4887:4: () ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4887:4: ()
                    // InternalGame.g:4888:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnOccupedBallAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4894:4: ( (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) )
                    // InternalGame.g:4895:5: (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    {
                    // InternalGame.g:4895:5: (lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT )
                    // InternalGame.g:4896:6: lv_runnerAdvance_13_0= RULE_FIELDER_CHOICE_WITH_PUTOUT
                    {
                    lv_runnerAdvance_13_0=(Token)match(input,RULE_FIELDER_CHOICE_WITH_PUTOUT,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_13_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceFIELDER_CHOICE_WITH_PUTOUTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_13_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE_WITH_PUTOUT");
                    					

                    }


                    }

                    // InternalGame.g:4912:4: ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( ((LA87_0>=113 && LA87_0<=114)) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalGame.g:4913:5: ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4913:5: ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4914:6: (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4914:6: (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' )
                            int alt86=2;
                            int LA86_0 = input.LA(1);

                            if ( (LA86_0==113) ) {
                                alt86=1;
                            }
                            else if ( (LA86_0==114) ) {
                                alt86=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 86, 0, input);

                                throw nvae;
                            }
                            switch (alt86) {
                                case 1 :
                                    // InternalGame.g:4915:7: lv_isEarned_14_1= 'earned'
                                    {
                                    lv_isEarned_14_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_14_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_4_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_14_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4926:7: lv_isEarned_14_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_14_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_14_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_4_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_14_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalGame.g:4941:3: ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4941:3: ( () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4942:4: () ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4942:4: ()
                    // InternalGame.g:4943:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnDefensiveChoiceAction_5_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:4949:4: ( (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE ) )
                    // InternalGame.g:4950:5: (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE )
                    {
                    // InternalGame.g:4950:5: (lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE )
                    // InternalGame.g:4951:6: lv_runnerAdvance_16_0= RULE_FIELDER_CHOICE
                    {
                    lv_runnerAdvance_16_0=(Token)match(input,RULE_FIELDER_CHOICE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_16_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceFIELDER_CHOICETerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_16_0,
                    							"org.bpy.score.game.Game.FIELDER_CHOICE");
                    					

                    }


                    }

                    // InternalGame.g:4967:4: ( ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( ((LA89_0>=113 && LA89_0<=114)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalGame.g:4968:5: ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:4968:5: ( (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:4969:6: (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:4969:6: (lv_isEarned_17_1= 'earned' | lv_isEarned_17_2= 'unEarnedForTeam' )
                            int alt88=2;
                            int LA88_0 = input.LA(1);

                            if ( (LA88_0==113) ) {
                                alt88=1;
                            }
                            else if ( (LA88_0==114) ) {
                                alt88=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 0, input);

                                throw nvae;
                            }
                            switch (alt88) {
                                case 1 :
                                    // InternalGame.g:4970:7: lv_isEarned_17_1= 'earned'
                                    {
                                    lv_isEarned_17_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_17_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_5_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_17_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:4981:7: lv_isEarned_17_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_17_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_17_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_5_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_17_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalGame.g:4996:3: ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:4996:3: ( () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:4997:4: () ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:4997:4: ()
                    // InternalGame.g:4998:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnThrowErrorAction_6_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5004:4: ( (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR ) )
                    // InternalGame.g:5005:5: (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR )
                    {
                    // InternalGame.g:5005:5: (lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR )
                    // InternalGame.g:5006:6: lv_runnerAdvance_19_0= RULE_REACH_ON_THROW_ERROR
                    {
                    lv_runnerAdvance_19_0=(Token)match(input,RULE_REACH_ON_THROW_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_19_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceREACH_ON_THROW_ERRORTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_19_0,
                    							"org.bpy.score.game.Game.REACH_ON_THROW_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:5022:4: ( ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( ((LA91_0>=113 && LA91_0<=114)) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalGame.g:5023:5: ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5023:5: ( (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5024:6: (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5024:6: (lv_isEarned_20_1= 'earned' | lv_isEarned_20_2= 'unEarnedForTeam' )
                            int alt90=2;
                            int LA90_0 = input.LA(1);

                            if ( (LA90_0==113) ) {
                                alt90=1;
                            }
                            else if ( (LA90_0==114) ) {
                                alt90=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 90, 0, input);

                                throw nvae;
                            }
                            switch (alt90) {
                                case 1 :
                                    // InternalGame.g:5025:7: lv_isEarned_20_1= 'earned'
                                    {
                                    lv_isEarned_20_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_20_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_6_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_20_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5036:7: lv_isEarned_20_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_20_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_20_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_6_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_20_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalGame.g:5051:3: ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5051:3: ( () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5052:4: () ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5052:4: ()
                    // InternalGame.g:5053:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnReceiveErrorAction_7_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5059:4: ( (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:5060:5: (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:5060:5: (lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR )
                    // InternalGame.g:5061:6: lv_runnerAdvance_22_0= RULE_REACH_ON_RECEIVE_ERROR
                    {
                    lv_runnerAdvance_22_0=(Token)match(input,RULE_REACH_ON_RECEIVE_ERROR,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_22_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceREACH_ON_RECEIVE_ERRORTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_22_0,
                    							"org.bpy.score.game.Game.REACH_ON_RECEIVE_ERROR");
                    					

                    }


                    }

                    // InternalGame.g:5077:4: ( ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( ((LA93_0>=113 && LA93_0<=114)) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalGame.g:5078:5: ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5078:5: ( (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5079:6: (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5079:6: (lv_isEarned_23_1= 'earned' | lv_isEarned_23_2= 'unEarnedForTeam' )
                            int alt92=2;
                            int LA92_0 = input.LA(1);

                            if ( (LA92_0==113) ) {
                                alt92=1;
                            }
                            else if ( (LA92_0==114) ) {
                                alt92=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 92, 0, input);

                                throw nvae;
                            }
                            switch (alt92) {
                                case 1 :
                                    // InternalGame.g:5080:7: lv_isEarned_23_1= 'earned'
                                    {
                                    lv_isEarned_23_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_23_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_7_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_23_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5091:7: lv_isEarned_23_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_23_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_23_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_7_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_23_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalGame.g:5106:3: ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5106:3: ( () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5107:4: () ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5107:4: ()
                    // InternalGame.g:5108:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnThrowAction_8_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5114:4: ( (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW ) )
                    // InternalGame.g:5115:5: (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW )
                    {
                    // InternalGame.g:5115:5: (lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW )
                    // InternalGame.g:5116:6: lv_runnerAdvance_25_0= RULE_ADVANCE_ON_THROW
                    {
                    lv_runnerAdvance_25_0=(Token)match(input,RULE_ADVANCE_ON_THROW,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_25_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceADVANCE_ON_THROWTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_25_0,
                    							"org.bpy.score.game.Game.ADVANCE_ON_THROW");
                    					

                    }


                    }

                    // InternalGame.g:5132:4: ( ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( ((LA95_0>=113 && LA95_0<=114)) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // InternalGame.g:5133:5: ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5133:5: ( (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5134:6: (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5134:6: (lv_isEarned_26_1= 'earned' | lv_isEarned_26_2= 'unEarnedForTeam' )
                            int alt94=2;
                            int LA94_0 = input.LA(1);

                            if ( (LA94_0==113) ) {
                                alt94=1;
                            }
                            else if ( (LA94_0==114) ) {
                                alt94=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 0, input);

                                throw nvae;
                            }
                            switch (alt94) {
                                case 1 :
                                    // InternalGame.g:5135:7: lv_isEarned_26_1= 'earned'
                                    {
                                    lv_isEarned_26_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_26_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_8_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_26_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5146:7: lv_isEarned_26_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_26_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_26_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_8_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_26_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalGame.g:5161:3: ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5161:3: ( () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5162:4: () ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5162:4: ()
                    // InternalGame.g:5163:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnNoDecisiveObstructionAction_9_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5169:4: ( (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION ) )
                    // InternalGame.g:5170:5: (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION )
                    {
                    // InternalGame.g:5170:5: (lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION )
                    // InternalGame.g:5171:6: lv_runnerAdvance_28_0= RULE_NO_DECISIVE_OBSTRUCTION
                    {
                    lv_runnerAdvance_28_0=(Token)match(input,RULE_NO_DECISIVE_OBSTRUCTION,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_28_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceNO_DECISIVE_OBSTRUCTIONTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_28_0,
                    							"org.bpy.score.game.Game.NO_DECISIVE_OBSTRUCTION");
                    					

                    }


                    }

                    // InternalGame.g:5187:4: ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( ((LA97_0>=113 && LA97_0<=114)) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // InternalGame.g:5188:5: ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5188:5: ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5189:6: (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5189:6: (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' )
                            int alt96=2;
                            int LA96_0 = input.LA(1);

                            if ( (LA96_0==113) ) {
                                alt96=1;
                            }
                            else if ( (LA96_0==114) ) {
                                alt96=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 96, 0, input);

                                throw nvae;
                            }
                            switch (alt96) {
                                case 1 :
                                    // InternalGame.g:5190:7: lv_isEarned_29_1= 'earned'
                                    {
                                    lv_isEarned_29_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_29_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_9_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_29_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5201:7: lv_isEarned_29_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_29_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_29_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_9_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_29_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalGame.g:5216:3: ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5216:3: ( () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5217:4: () ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5217:4: ()
                    // InternalGame.g:5218:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnDecisiveObstructionAction_10_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5224:4: ( (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION ) )
                    // InternalGame.g:5225:5: (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION )
                    {
                    // InternalGame.g:5225:5: (lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION )
                    // InternalGame.g:5226:6: lv_runnerAdvance_31_0= RULE_DECISIVE_OBSTRUCTION
                    {
                    lv_runnerAdvance_31_0=(Token)match(input,RULE_DECISIVE_OBSTRUCTION,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_31_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceDECISIVE_OBSTRUCTIONTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_31_0,
                    							"org.bpy.score.game.Game.DECISIVE_OBSTRUCTION");
                    					

                    }


                    }

                    // InternalGame.g:5242:4: ( ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) ) )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( ((LA99_0>=113 && LA99_0<=114)) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalGame.g:5243:5: ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5243:5: ( (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5244:6: (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5244:6: (lv_isEarned_32_1= 'earned' | lv_isEarned_32_2= 'unEarnedForTeam' )
                            int alt98=2;
                            int LA98_0 = input.LA(1);

                            if ( (LA98_0==113) ) {
                                alt98=1;
                            }
                            else if ( (LA98_0==114) ) {
                                alt98=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 98, 0, input);

                                throw nvae;
                            }
                            switch (alt98) {
                                case 1 :
                                    // InternalGame.g:5245:7: lv_isEarned_32_1= 'earned'
                                    {
                                    lv_isEarned_32_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_32_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_10_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_32_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5256:7: lv_isEarned_32_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_32_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_32_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_10_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_32_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalGame.g:5271:3: ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5271:3: ( () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5272:4: () ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5272:4: ()
                    // InternalGame.g:5273:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnRuleAction_11_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5279:4: ( (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE ) )
                    // InternalGame.g:5280:5: (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE )
                    {
                    // InternalGame.g:5280:5: (lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE )
                    // InternalGame.g:5281:6: lv_runnerAdvance_34_0= RULE_ADVANCE_BY_RULE
                    {
                    lv_runnerAdvance_34_0=(Token)match(input,RULE_ADVANCE_BY_RULE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_34_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceADVANCE_BY_RULETerminalRuleCall_11_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_34_0,
                    							"org.bpy.score.game.Game.ADVANCE_BY_RULE");
                    					

                    }


                    }

                    // InternalGame.g:5297:4: ( ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( ((LA101_0>=113 && LA101_0<=114)) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalGame.g:5298:5: ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5298:5: ( (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5299:6: (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5299:6: (lv_isEarned_35_1= 'earned' | lv_isEarned_35_2= 'unEarnedForTeam' )
                            int alt100=2;
                            int LA100_0 = input.LA(1);

                            if ( (LA100_0==113) ) {
                                alt100=1;
                            }
                            else if ( (LA100_0==114) ) {
                                alt100=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 100, 0, input);

                                throw nvae;
                            }
                            switch (alt100) {
                                case 1 :
                                    // InternalGame.g:5300:7: lv_isEarned_35_1= 'earned'
                                    {
                                    lv_isEarned_35_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_35_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_11_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_35_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5311:7: lv_isEarned_35_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_35_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_35_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_11_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_35_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalGame.g:5326:3: ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5326:3: ( () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5327:4: () ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5327:4: ()
                    // InternalGame.g:5328:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnIndiferenceAction_12_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5334:4: ( (lv_runnerAdvance_37_0= RULE_INDIFERENCE ) )
                    // InternalGame.g:5335:5: (lv_runnerAdvance_37_0= RULE_INDIFERENCE )
                    {
                    // InternalGame.g:5335:5: (lv_runnerAdvance_37_0= RULE_INDIFERENCE )
                    // InternalGame.g:5336:6: lv_runnerAdvance_37_0= RULE_INDIFERENCE
                    {
                    lv_runnerAdvance_37_0=(Token)match(input,RULE_INDIFERENCE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_37_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceINDIFERENCETerminalRuleCall_12_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_37_0,
                    							"org.bpy.score.game.Game.INDIFERENCE");
                    					

                    }


                    }

                    // InternalGame.g:5352:4: ( ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) ) )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( ((LA103_0>=113 && LA103_0<=114)) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalGame.g:5353:5: ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5353:5: ( (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5354:6: (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5354:6: (lv_isEarned_38_1= 'earned' | lv_isEarned_38_2= 'unEarnedForTeam' )
                            int alt102=2;
                            int LA102_0 = input.LA(1);

                            if ( (LA102_0==113) ) {
                                alt102=1;
                            }
                            else if ( (LA102_0==114) ) {
                                alt102=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 102, 0, input);

                                throw nvae;
                            }
                            switch (alt102) {
                                case 1 :
                                    // InternalGame.g:5355:7: lv_isEarned_38_1= 'earned'
                                    {
                                    lv_isEarned_38_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_38_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_12_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_38_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5366:7: lv_isEarned_38_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_38_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_38_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_12_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_38_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalGame.g:5381:3: ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5381:3: ( () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5382:4: () ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5382:4: ()
                    // InternalGame.g:5383:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnWildPitchAction_13_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5389:4: ( (lv_runnerAdvance_40_0= RULE_WILD_PITCH ) )
                    // InternalGame.g:5390:5: (lv_runnerAdvance_40_0= RULE_WILD_PITCH )
                    {
                    // InternalGame.g:5390:5: (lv_runnerAdvance_40_0= RULE_WILD_PITCH )
                    // InternalGame.g:5391:6: lv_runnerAdvance_40_0= RULE_WILD_PITCH
                    {
                    lv_runnerAdvance_40_0=(Token)match(input,RULE_WILD_PITCH,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_40_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceWILD_PITCHTerminalRuleCall_13_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_40_0,
                    							"org.bpy.score.game.Game.WILD_PITCH");
                    					

                    }


                    }

                    // InternalGame.g:5407:4: ( ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) ) )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( ((LA105_0>=113 && LA105_0<=114)) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalGame.g:5408:5: ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5408:5: ( (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5409:6: (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5409:6: (lv_isEarned_41_1= 'earned' | lv_isEarned_41_2= 'unEarnedForTeam' )
                            int alt104=2;
                            int LA104_0 = input.LA(1);

                            if ( (LA104_0==113) ) {
                                alt104=1;
                            }
                            else if ( (LA104_0==114) ) {
                                alt104=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 104, 0, input);

                                throw nvae;
                            }
                            switch (alt104) {
                                case 1 :
                                    // InternalGame.g:5410:7: lv_isEarned_41_1= 'earned'
                                    {
                                    lv_isEarned_41_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_41_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_13_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_41_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5421:7: lv_isEarned_41_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_41_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_41_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_13_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_41_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalGame.g:5436:3: ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5436:3: ( () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5437:4: () ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5437:4: ()
                    // InternalGame.g:5438:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnPassBallAction_14_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5444:4: ( (lv_runnerAdvance_43_0= RULE_PASS_BALL ) )
                    // InternalGame.g:5445:5: (lv_runnerAdvance_43_0= RULE_PASS_BALL )
                    {
                    // InternalGame.g:5445:5: (lv_runnerAdvance_43_0= RULE_PASS_BALL )
                    // InternalGame.g:5446:6: lv_runnerAdvance_43_0= RULE_PASS_BALL
                    {
                    lv_runnerAdvance_43_0=(Token)match(input,RULE_PASS_BALL,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_43_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvancePASS_BALLTerminalRuleCall_14_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_43_0,
                    							"org.bpy.score.game.Game.PASS_BALL");
                    					

                    }


                    }

                    // InternalGame.g:5462:4: ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( ((LA107_0>=113 && LA107_0<=114)) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalGame.g:5463:5: ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5463:5: ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5464:6: (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5464:6: (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' )
                            int alt106=2;
                            int LA106_0 = input.LA(1);

                            if ( (LA106_0==113) ) {
                                alt106=1;
                            }
                            else if ( (LA106_0==114) ) {
                                alt106=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 106, 0, input);

                                throw nvae;
                            }
                            switch (alt106) {
                                case 1 :
                                    // InternalGame.g:5465:7: lv_isEarned_44_1= 'earned'
                                    {
                                    lv_isEarned_44_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_44_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_14_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_44_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5476:7: lv_isEarned_44_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_44_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_44_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_14_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_44_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 16 :
                    // InternalGame.g:5491:3: ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5491:3: ( () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5492:4: () ( (lv_runnerAdvance_46_0= RULE_BALK ) ) ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5492:4: ()
                    // InternalGame.g:5493:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnBalkAction_15_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5499:4: ( (lv_runnerAdvance_46_0= RULE_BALK ) )
                    // InternalGame.g:5500:5: (lv_runnerAdvance_46_0= RULE_BALK )
                    {
                    // InternalGame.g:5500:5: (lv_runnerAdvance_46_0= RULE_BALK )
                    // InternalGame.g:5501:6: lv_runnerAdvance_46_0= RULE_BALK
                    {
                    lv_runnerAdvance_46_0=(Token)match(input,RULE_BALK,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_46_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceBALKTerminalRuleCall_15_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_46_0,
                    							"org.bpy.score.game.Game.BALK");
                    					

                    }


                    }

                    // InternalGame.g:5517:4: ( ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( ((LA109_0>=113 && LA109_0<=114)) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalGame.g:5518:5: ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5518:5: ( (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5519:6: (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5519:6: (lv_isEarned_47_1= 'earned' | lv_isEarned_47_2= 'unEarnedForTeam' )
                            int alt108=2;
                            int LA108_0 = input.LA(1);

                            if ( (LA108_0==113) ) {
                                alt108=1;
                            }
                            else if ( (LA108_0==114) ) {
                                alt108=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 108, 0, input);

                                throw nvae;
                            }
                            switch (alt108) {
                                case 1 :
                                    // InternalGame.g:5520:7: lv_isEarned_47_1= 'earned'
                                    {
                                    lv_isEarned_47_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_47_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_15_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_47_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5531:7: lv_isEarned_47_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_47_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_47_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_15_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_47_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 17 :
                    // InternalGame.g:5546:3: ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:5546:3: ( () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:5547:4: () ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:5547:4: ()
                    // InternalGame.g:5548:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceOnStolenBaseAction_16_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5554:4: ( (lv_runnerAdvance_49_0= RULE_STOLEN_BASE ) )
                    // InternalGame.g:5555:5: (lv_runnerAdvance_49_0= RULE_STOLEN_BASE )
                    {
                    // InternalGame.g:5555:5: (lv_runnerAdvance_49_0= RULE_STOLEN_BASE )
                    // InternalGame.g:5556:6: lv_runnerAdvance_49_0= RULE_STOLEN_BASE
                    {
                    lv_runnerAdvance_49_0=(Token)match(input,RULE_STOLEN_BASE,FOLLOW_47); 

                    						newLeafNode(lv_runnerAdvance_49_0, grammarAccess.getAdvanceWithContinuationAccess().getRunnerAdvanceSTOLEN_BASETerminalRuleCall_16_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"runnerAdvance",
                    							lv_runnerAdvance_49_0,
                    							"org.bpy.score.game.Game.STOLEN_BASE");
                    					

                    }


                    }

                    // InternalGame.g:5572:4: ( ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( ((LA111_0>=113 && LA111_0<=114)) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalGame.g:5573:5: ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:5573:5: ( (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:5574:6: (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:5574:6: (lv_isEarned_50_1= 'earned' | lv_isEarned_50_2= 'unEarnedForTeam' )
                            int alt110=2;
                            int LA110_0 = input.LA(1);

                            if ( (LA110_0==113) ) {
                                alt110=1;
                            }
                            else if ( (LA110_0==114) ) {
                                alt110=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 110, 0, input);

                                throw nvae;
                            }
                            switch (alt110) {
                                case 1 :
                                    // InternalGame.g:5575:7: lv_isEarned_50_1= 'earned'
                                    {
                                    lv_isEarned_50_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_50_1, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedEarnedKeyword_16_2_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_50_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:5586:7: lv_isEarned_50_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_50_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_50_2, grammarAccess.getAdvanceWithContinuationAccess().getIsEarnedUnEarnedForTeamKeyword_16_2_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAdvanceWithContinuationRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_50_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdvanceWithContinuation"


    // $ANTLR start "entryRuleOtherBatterAdvance"
    // InternalGame.g:5604:1: entryRuleOtherBatterAdvance returns [EObject current=null] : iv_ruleOtherBatterAdvance= ruleOtherBatterAdvance EOF ;
    public final EObject entryRuleOtherBatterAdvance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherBatterAdvance = null;


        try {
            // InternalGame.g:5604:59: (iv_ruleOtherBatterAdvance= ruleOtherBatterAdvance EOF )
            // InternalGame.g:5605:2: iv_ruleOtherBatterAdvance= ruleOtherBatterAdvance EOF
            {
             newCompositeNode(grammarAccess.getOtherBatterAdvanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherBatterAdvance=ruleOtherBatterAdvance();

            state._fsp--;

             current =iv_ruleOtherBatterAdvance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherBatterAdvance"


    // $ANTLR start "ruleOtherBatterAdvance"
    // InternalGame.g:5611:1: ruleOtherBatterAdvance returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) ) | ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) ) ) ;
    public final EObject ruleOtherBatterAdvance() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterAdvance_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_batterAdvance_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_batterAdvance_11_0=null;
        Token this_EXECUTE_14=null;
        Token lv_batterAdvance_15_0=null;
        Token this_EXECUTE_18=null;
        Token lv_batterAdvance_19_0=null;
        Token this_EXECUTE_22=null;
        Token lv_batterAdvance_23_0=null;
        Token this_EXECUTE_26=null;
        Token lv_batterAdvance_27_0=null;
        Token this_EXECUTE_30=null;
        Token lv_batterAdvance_31_0=null;
        Token this_EXECUTE_34=null;
        Token lv_batterAdvance_35_0=null;
        Token this_EXECUTE_38=null;
        Token lv_batterAdvance_39_0=null;
        Token this_EXECUTE_42=null;
        Token lv_batterAdvance_43_0=null;
        Token this_EXECUTE_46=null;
        Token lv_batterAdvance_47_0=null;
        Token lv_batterAdvance_48_0=null;
        Token this_EXECUTE_51=null;
        Token lv_batterAdvance_52_0=null;
        Token this_EXECUTE_55=null;
        Token lv_batterAdvance_56_0=null;
        Token this_EXECUTE_59=null;
        Token lv_batterAdvance_60_0=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;

        EObject lv_currentBatter_13_0 = null;

        EObject lv_currentBatter_17_0 = null;

        EObject lv_currentBatter_21_0 = null;

        EObject lv_currentBatter_25_0 = null;

        EObject lv_currentBatter_29_0 = null;

        EObject lv_currentBatter_33_0 = null;

        EObject lv_currentBatter_37_0 = null;

        EObject lv_currentBatter_41_0 = null;

        EObject lv_currentBatter_45_0 = null;

        EObject lv_currentBatter_50_0 = null;

        EObject lv_currentBatter_54_0 = null;

        EObject lv_currentBatter_58_0 = null;



        	enterRule();

        try {
            // InternalGame.g:5617:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) ) | ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) ) ) )
            // InternalGame.g:5618:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) ) | ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) ) )
            {
            // InternalGame.g:5618:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) ) | ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) ) )
            int alt114=15;
            alt114 = dfa114.predict(input);
            switch (alt114) {
                case 1 :
                    // InternalGame.g:5619:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) )
                    {
                    // InternalGame.g:5619:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) )
                    // InternalGame.g:5620:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) )
                    {
                    // InternalGame.g:5620:4: ()
                    // InternalGame.g:5621:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnBaseOnBallAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5627:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:5628:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5628:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:5629:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_71); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:5650:4: ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) )
                    // InternalGame.g:5651:5: (lv_batterAdvance_3_0= RULE_BASE_ON_BALL )
                    {
                    // InternalGame.g:5651:5: (lv_batterAdvance_3_0= RULE_BASE_ON_BALL )
                    // InternalGame.g:5652:6: lv_batterAdvance_3_0= RULE_BASE_ON_BALL
                    {
                    lv_batterAdvance_3_0=(Token)match(input,RULE_BASE_ON_BALL,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_3_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceBASE_ON_BALLTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_3_0,
                    							"org.bpy.score.game.Game.BASE_ON_BALL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:5670:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) )
                    {
                    // InternalGame.g:5670:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) )
                    // InternalGame.g:5671:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) )
                    {
                    // InternalGame.g:5671:4: ()
                    // InternalGame.g:5672:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnIntentionalBaseOnBallAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5678:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:5679:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5679:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:5680:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_72); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:5701:4: ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) )
                    // InternalGame.g:5702:5: (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL )
                    {
                    // InternalGame.g:5702:5: (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL )
                    // InternalGame.g:5703:6: lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL
                    {
                    lv_batterAdvance_7_0=(Token)match(input,RULE_INTENTIONAL_BASE_ON_BALL,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_7_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceINTENTIONAL_BASE_ON_BALLTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_7_0,
                    							"org.bpy.score.game.Game.INTENTIONAL_BASE_ON_BALL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:5721:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) )
                    {
                    // InternalGame.g:5721:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) )
                    // InternalGame.g:5722:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) )
                    {
                    // InternalGame.g:5722:4: ()
                    // InternalGame.g:5723:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnHitByPitchAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5729:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:5730:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5730:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:5731:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_73); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:5752:4: ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) )
                    // InternalGame.g:5753:5: (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH )
                    {
                    // InternalGame.g:5753:5: (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH )
                    // InternalGame.g:5754:6: lv_batterAdvance_11_0= RULE_HIT_BY_PITCH
                    {
                    lv_batterAdvance_11_0=(Token)match(input,RULE_HIT_BY_PITCH,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_11_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceHIT_BY_PITCHTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_11_0,
                    							"org.bpy.score.game.Game.HIT_BY_PITCH");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:5772:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) )
                    {
                    // InternalGame.g:5772:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) )
                    // InternalGame.g:5773:4: () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) )
                    {
                    // InternalGame.g:5773:4: ()
                    // InternalGame.g:5774:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnKPassBallAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5780:4: ( (lv_currentBatter_13_0= ruleCurrentBatter ) )
                    // InternalGame.g:5781:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5781:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    // InternalGame.g:5782:6: lv_currentBatter_13_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_13_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_13_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_14=(Token)match(input,RULE_EXECUTE,FOLLOW_74); 

                    				newLeafNode(this_EXECUTE_14, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_3_2());
                    			
                    // InternalGame.g:5803:4: ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) )
                    // InternalGame.g:5804:5: (lv_batterAdvance_15_0= RULE_K_PASS_BALL )
                    {
                    // InternalGame.g:5804:5: (lv_batterAdvance_15_0= RULE_K_PASS_BALL )
                    // InternalGame.g:5805:6: lv_batterAdvance_15_0= RULE_K_PASS_BALL
                    {
                    lv_batterAdvance_15_0=(Token)match(input,RULE_K_PASS_BALL,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_15_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceK_PASS_BALLTerminalRuleCall_3_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_15_0,
                    							"org.bpy.score.game.Game.K_PASS_BALL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:5823:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) )
                    {
                    // InternalGame.g:5823:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) )
                    // InternalGame.g:5824:4: () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) )
                    {
                    // InternalGame.g:5824:4: ()
                    // InternalGame.g:5825:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnKWildPitchAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5831:4: ( (lv_currentBatter_17_0= ruleCurrentBatter ) )
                    // InternalGame.g:5832:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5832:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    // InternalGame.g:5833:6: lv_currentBatter_17_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_17_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_17_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_18=(Token)match(input,RULE_EXECUTE,FOLLOW_75); 

                    				newLeafNode(this_EXECUTE_18, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_4_2());
                    			
                    // InternalGame.g:5854:4: ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) )
                    // InternalGame.g:5855:5: (lv_batterAdvance_19_0= RULE_K_WILD_PITCH )
                    {
                    // InternalGame.g:5855:5: (lv_batterAdvance_19_0= RULE_K_WILD_PITCH )
                    // InternalGame.g:5856:6: lv_batterAdvance_19_0= RULE_K_WILD_PITCH
                    {
                    lv_batterAdvance_19_0=(Token)match(input,RULE_K_WILD_PITCH,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_19_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceK_WILD_PITCHTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_19_0,
                    							"org.bpy.score.game.Game.K_WILD_PITCH");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalGame.g:5874:3: ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) )
                    {
                    // InternalGame.g:5874:3: ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) )
                    // InternalGame.g:5875:4: () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) )
                    {
                    // InternalGame.g:5875:4: ()
                    // InternalGame.g:5876:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnKAbrAction_5_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5882:4: ( (lv_currentBatter_21_0= ruleCurrentBatter ) )
                    // InternalGame.g:5883:5: (lv_currentBatter_21_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5883:5: (lv_currentBatter_21_0= ruleCurrentBatter )
                    // InternalGame.g:5884:6: lv_currentBatter_21_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_21_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_21_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_22=(Token)match(input,RULE_EXECUTE,FOLLOW_76); 

                    				newLeafNode(this_EXECUTE_22, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_5_2());
                    			
                    // InternalGame.g:5905:4: ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) )
                    // InternalGame.g:5906:5: (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE )
                    {
                    // InternalGame.g:5906:5: (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE )
                    // InternalGame.g:5907:6: lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE
                    {
                    lv_batterAdvance_23_0=(Token)match(input,RULE_K_ADVANCE_BY_RULE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_23_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceK_ADVANCE_BY_RULETerminalRuleCall_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_23_0,
                    							"org.bpy.score.game.Game.K_ADVANCE_BY_RULE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalGame.g:5925:3: ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:5925:3: ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) )
                    // InternalGame.g:5926:4: () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) )
                    {
                    // InternalGame.g:5926:4: ()
                    // InternalGame.g:5927:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnKWithErrorAction_6_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5933:4: ( (lv_currentBatter_25_0= ruleCurrentBatter ) )
                    // InternalGame.g:5934:5: (lv_currentBatter_25_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5934:5: (lv_currentBatter_25_0= ruleCurrentBatter )
                    // InternalGame.g:5935:6: lv_currentBatter_25_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_25_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_25_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_26=(Token)match(input,RULE_EXECUTE,FOLLOW_77); 

                    				newLeafNode(this_EXECUTE_26, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_6_2());
                    			
                    // InternalGame.g:5956:4: ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) )
                    // InternalGame.g:5957:5: (lv_batterAdvance_27_0= RULE_K_WITH_ERROR )
                    {
                    // InternalGame.g:5957:5: (lv_batterAdvance_27_0= RULE_K_WITH_ERROR )
                    // InternalGame.g:5958:6: lv_batterAdvance_27_0= RULE_K_WITH_ERROR
                    {
                    lv_batterAdvance_27_0=(Token)match(input,RULE_K_WITH_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_27_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceK_WITH_ERRORTerminalRuleCall_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_27_0,
                    							"org.bpy.score.game.Game.K_WITH_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalGame.g:5976:3: ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:5976:3: ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) )
                    // InternalGame.g:5977:4: () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) )
                    {
                    // InternalGame.g:5977:4: ()
                    // InternalGame.g:5978:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnSacrificeHitWithErrorAction_7_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:5984:4: ( (lv_currentBatter_29_0= ruleCurrentBatter ) )
                    // InternalGame.g:5985:5: (lv_currentBatter_29_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:5985:5: (lv_currentBatter_29_0= ruleCurrentBatter )
                    // InternalGame.g:5986:6: lv_currentBatter_29_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_29_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_29_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_30=(Token)match(input,RULE_EXECUTE,FOLLOW_78); 

                    				newLeafNode(this_EXECUTE_30, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_7_2());
                    			
                    // InternalGame.g:6007:4: ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) )
                    // InternalGame.g:6008:5: (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR )
                    {
                    // InternalGame.g:6008:5: (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR )
                    // InternalGame.g:6009:6: lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR
                    {
                    lv_batterAdvance_31_0=(Token)match(input,RULE_SACRIFICE_BUNT_WITH_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_31_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceSACRIFICE_BUNT_WITH_ERRORTerminalRuleCall_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_31_0,
                    							"org.bpy.score.game.Game.SACRIFICE_BUNT_WITH_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalGame.g:6027:3: ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) )
                    {
                    // InternalGame.g:6027:3: ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) )
                    // InternalGame.g:6028:4: () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) )
                    {
                    // InternalGame.g:6028:4: ()
                    // InternalGame.g:6029:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnSacrificeHitWithFielderChoiceAction_8_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6035:4: ( (lv_currentBatter_33_0= ruleCurrentBatter ) )
                    // InternalGame.g:6036:5: (lv_currentBatter_33_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6036:5: (lv_currentBatter_33_0= ruleCurrentBatter )
                    // InternalGame.g:6037:6: lv_currentBatter_33_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_33_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_33_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_34=(Token)match(input,RULE_EXECUTE,FOLLOW_79); 

                    				newLeafNode(this_EXECUTE_34, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_8_2());
                    			
                    // InternalGame.g:6058:4: ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) )
                    // InternalGame.g:6059:5: (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE )
                    {
                    // InternalGame.g:6059:5: (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE )
                    // InternalGame.g:6060:6: lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE
                    {
                    lv_batterAdvance_35_0=(Token)match(input,RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_35_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceSACRIFICE_BUNT_WITH_FIELDER_CHOICETerminalRuleCall_8_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_35_0,
                    							"org.bpy.score.game.Game.SACRIFICE_BUNT_WITH_FIELDER_CHOICE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalGame.g:6078:3: ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:6078:3: ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) )
                    // InternalGame.g:6079:4: () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) )
                    {
                    // InternalGame.g:6079:4: ()
                    // InternalGame.g:6080:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnSacrificeFlyWithErrorAction_9_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6086:4: ( (lv_currentBatter_37_0= ruleCurrentBatter ) )
                    // InternalGame.g:6087:5: (lv_currentBatter_37_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6087:5: (lv_currentBatter_37_0= ruleCurrentBatter )
                    // InternalGame.g:6088:6: lv_currentBatter_37_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_37_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_37_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_38=(Token)match(input,RULE_EXECUTE,FOLLOW_80); 

                    				newLeafNode(this_EXECUTE_38, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_9_2());
                    			
                    // InternalGame.g:6109:4: ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) )
                    // InternalGame.g:6110:5: (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR )
                    {
                    // InternalGame.g:6110:5: (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR )
                    // InternalGame.g:6111:6: lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR
                    {
                    lv_batterAdvance_39_0=(Token)match(input,RULE_SACRIFICE_FLY_WITH_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_39_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceSACRIFICE_FLY_WITH_ERRORTerminalRuleCall_9_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_39_0,
                    							"org.bpy.score.game.Game.SACRIFICE_FLY_WITH_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalGame.g:6129:3: ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) )
                    {
                    // InternalGame.g:6129:3: ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) )
                    // InternalGame.g:6130:4: () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) )
                    {
                    // InternalGame.g:6130:4: ()
                    // InternalGame.g:6131:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnSacrificeFlyWithFielderChoiceAction_10_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6137:4: ( (lv_currentBatter_41_0= ruleCurrentBatter ) )
                    // InternalGame.g:6138:5: (lv_currentBatter_41_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6138:5: (lv_currentBatter_41_0= ruleCurrentBatter )
                    // InternalGame.g:6139:6: lv_currentBatter_41_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_10_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_41_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_41_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_42=(Token)match(input,RULE_EXECUTE,FOLLOW_81); 

                    				newLeafNode(this_EXECUTE_42, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_10_2());
                    			
                    // InternalGame.g:6160:4: ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) )
                    // InternalGame.g:6161:5: (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE )
                    {
                    // InternalGame.g:6161:5: (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE )
                    // InternalGame.g:6162:6: lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE
                    {
                    lv_batterAdvance_43_0=(Token)match(input,RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_43_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceSACRIFICE_FLY_WITH_FIELDER_CHOICETerminalRuleCall_10_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_43_0,
                    							"org.bpy.score.game.Game.SACRIFICE_FLY_WITH_FIELDER_CHOICE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalGame.g:6180:3: ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) )
                    {
                    // InternalGame.g:6180:3: ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) )
                    // InternalGame.g:6181:4: () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) )
                    {
                    // InternalGame.g:6181:4: ()
                    // InternalGame.g:6182:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnCatcherInterferenceAction_11_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6188:4: ( (lv_currentBatter_45_0= ruleCurrentBatter ) )
                    // InternalGame.g:6189:5: (lv_currentBatter_45_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6189:5: (lv_currentBatter_45_0= ruleCurrentBatter )
                    // InternalGame.g:6190:6: lv_currentBatter_45_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_45_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_45_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_46=(Token)match(input,RULE_EXECUTE,FOLLOW_82); 

                    				newLeafNode(this_EXECUTE_46, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_11_2());
                    			
                    // InternalGame.g:6211:4: ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) )
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==RULE_CATCHER_INTERFERENCE) ) {
                        alt113=1;
                    }
                    else if ( (LA113_0==RULE_INTERFERENCE) ) {
                        alt113=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 113, 0, input);

                        throw nvae;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalGame.g:6212:5: ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) )
                            {
                            // InternalGame.g:6212:5: ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) )
                            // InternalGame.g:6213:6: (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE )
                            {
                            // InternalGame.g:6213:6: (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE )
                            // InternalGame.g:6214:7: lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE
                            {
                            lv_batterAdvance_47_0=(Token)match(input,RULE_CATCHER_INTERFERENCE,FOLLOW_2); 

                            							newLeafNode(lv_batterAdvance_47_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceCATCHER_INTERFERENCETerminalRuleCall_11_3_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"batterAdvance",
                            								lv_batterAdvance_47_0,
                            								"org.bpy.score.game.Game.CATCHER_INTERFERENCE");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalGame.g:6231:5: ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) )
                            {
                            // InternalGame.g:6231:5: ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) )
                            // InternalGame.g:6232:6: (lv_batterAdvance_48_0= RULE_INTERFERENCE )
                            {
                            // InternalGame.g:6232:6: (lv_batterAdvance_48_0= RULE_INTERFERENCE )
                            // InternalGame.g:6233:7: lv_batterAdvance_48_0= RULE_INTERFERENCE
                            {
                            lv_batterAdvance_48_0=(Token)match(input,RULE_INTERFERENCE,FOLLOW_2); 

                            							newLeafNode(lv_batterAdvance_48_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceINTERFERENCETerminalRuleCall_11_3_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"batterAdvance",
                            								lv_batterAdvance_48_0,
                            								"org.bpy.score.game.Game.INTERFERENCE");
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalGame.g:6252:3: ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) )
                    {
                    // InternalGame.g:6252:3: ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) )
                    // InternalGame.g:6253:4: () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) )
                    {
                    // InternalGame.g:6253:4: ()
                    // InternalGame.g:6254:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnObstructionAction_12_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6260:4: ( (lv_currentBatter_50_0= ruleCurrentBatter ) )
                    // InternalGame.g:6261:5: (lv_currentBatter_50_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6261:5: (lv_currentBatter_50_0= ruleCurrentBatter )
                    // InternalGame.g:6262:6: lv_currentBatter_50_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_12_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_50_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_50_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_51=(Token)match(input,RULE_EXECUTE,FOLLOW_54); 

                    				newLeafNode(this_EXECUTE_51, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_12_2());
                    			
                    // InternalGame.g:6283:4: ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) )
                    // InternalGame.g:6284:5: (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION )
                    {
                    // InternalGame.g:6284:5: (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION )
                    // InternalGame.g:6285:6: lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION
                    {
                    lv_batterAdvance_52_0=(Token)match(input,RULE_DECISIVE_OBSTRUCTION,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_52_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceDECISIVE_OBSTRUCTIONTerminalRuleCall_12_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_52_0,
                    							"org.bpy.score.game.Game.DECISIVE_OBSTRUCTION");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalGame.g:6303:3: ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) )
                    {
                    // InternalGame.g:6303:3: ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) )
                    // InternalGame.g:6304:4: () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) )
                    {
                    // InternalGame.g:6304:4: ()
                    // InternalGame.g:6305:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnKWithFielderChoiceAction_13_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6311:4: ( (lv_currentBatter_54_0= ruleCurrentBatter ) )
                    // InternalGame.g:6312:5: (lv_currentBatter_54_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6312:5: (lv_currentBatter_54_0= ruleCurrentBatter )
                    // InternalGame.g:6313:6: lv_currentBatter_54_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_13_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_54_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_54_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_55=(Token)match(input,RULE_EXECUTE,FOLLOW_83); 

                    				newLeafNode(this_EXECUTE_55, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_13_2());
                    			
                    // InternalGame.g:6334:4: ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) )
                    // InternalGame.g:6335:5: (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE )
                    {
                    // InternalGame.g:6335:5: (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE )
                    // InternalGame.g:6336:6: lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE
                    {
                    lv_batterAdvance_56_0=(Token)match(input,RULE_K_ADVANCE_BY_FIELDER_CHOCE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_56_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceK_ADVANCE_BY_FIELDER_CHOCETerminalRuleCall_13_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_56_0,
                    							"org.bpy.score.game.Game.K_ADVANCE_BY_FIELDER_CHOCE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalGame.g:6354:3: ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) )
                    {
                    // InternalGame.g:6354:3: ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) )
                    // InternalGame.g:6355:4: () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) )
                    {
                    // InternalGame.g:6355:4: ()
                    // InternalGame.g:6356:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceOnGdpWithFielderChoiceAction_14_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6362:4: ( (lv_currentBatter_58_0= ruleCurrentBatter ) )
                    // InternalGame.g:6363:5: (lv_currentBatter_58_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6363:5: (lv_currentBatter_58_0= ruleCurrentBatter )
                    // InternalGame.g:6364:6: lv_currentBatter_58_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getOtherBatterAdvanceAccess().getCurrentBatterCurrentBatterParserRuleCall_14_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_58_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_58_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_59=(Token)match(input,RULE_EXECUTE,FOLLOW_84); 

                    				newLeafNode(this_EXECUTE_59, grammarAccess.getOtherBatterAdvanceAccess().getEXECUTETerminalRuleCall_14_2());
                    			
                    // InternalGame.g:6385:4: ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) )
                    // InternalGame.g:6386:5: (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE )
                    {
                    // InternalGame.g:6386:5: (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE )
                    // InternalGame.g:6387:6: lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE
                    {
                    lv_batterAdvance_60_0=(Token)match(input,RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_60_0, grammarAccess.getOtherBatterAdvanceAccess().getBatterAdvanceGROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICETerminalRuleCall_14_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherBatterAdvanceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_60_0,
                    							"org.bpy.score.game.Game.GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherBatterAdvance"


    // $ANTLR start "entryRuleHit"
    // InternalGame.g:6408:1: entryRuleHit returns [EObject current=null] : iv_ruleHit= ruleHit EOF ;
    public final EObject entryRuleHit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHit = null;


        try {
            // InternalGame.g:6408:44: (iv_ruleHit= ruleHit EOF )
            // InternalGame.g:6409:2: iv_ruleHit= ruleHit EOF
            {
             newCompositeNode(grammarAccess.getHitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHit=ruleHit();

            state._fsp--;

             current =iv_ruleHit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHit"


    // $ANTLR start "ruleHit"
    // InternalGame.g:6415:1: ruleHit returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? ) ) ;
    public final EObject ruleHit() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_hit_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_hit_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_hit_11_0=null;
        Token this_EXECUTE_14=null;
        Token lv_hit_15_0=null;
        Token lv_isEarned_16_1=null;
        Token lv_isEarned_16_2=null;
        Token this_EXECUTE_19=null;
        Token lv_hit_20_0=null;
        Token lv_isEarned_21_1=null;
        Token lv_isEarned_21_2=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;

        EObject lv_currentBatter_13_0 = null;

        EObject lv_currentBatter_18_0 = null;



        	enterRule();

        try {
            // InternalGame.g:6421:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? ) ) )
            // InternalGame.g:6422:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? ) )
            {
            // InternalGame.g:6422:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? ) )
            int alt119=5;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // InternalGame.g:6423:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) )
                    {
                    // InternalGame.g:6423:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) )
                    // InternalGame.g:6424:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) )
                    {
                    // InternalGame.g:6424:4: ()
                    // InternalGame.g:6425:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getHitAccess().getBatterAdvanceOnSingleHitAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6431:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:6432:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6432:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:6433:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getHitAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHitRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_85); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getHitAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:6454:4: ( (lv_hit_3_0= RULE_SINGLE ) )
                    // InternalGame.g:6455:5: (lv_hit_3_0= RULE_SINGLE )
                    {
                    // InternalGame.g:6455:5: (lv_hit_3_0= RULE_SINGLE )
                    // InternalGame.g:6456:6: lv_hit_3_0= RULE_SINGLE
                    {
                    lv_hit_3_0=(Token)match(input,RULE_SINGLE,FOLLOW_2); 

                    						newLeafNode(lv_hit_3_0, grammarAccess.getHitAccess().getHitSINGLETerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hit",
                    							lv_hit_3_0,
                    							"org.bpy.score.game.Game.SINGLE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:6474:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) )
                    {
                    // InternalGame.g:6474:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) )
                    // InternalGame.g:6475:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) )
                    {
                    // InternalGame.g:6475:4: ()
                    // InternalGame.g:6476:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getHitAccess().getBatterAdvanceOnDoubleHitAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6482:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:6483:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6483:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:6484:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getHitAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHitRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_86); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getHitAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:6505:4: ( (lv_hit_7_0= RULE_DOUBLE ) )
                    // InternalGame.g:6506:5: (lv_hit_7_0= RULE_DOUBLE )
                    {
                    // InternalGame.g:6506:5: (lv_hit_7_0= RULE_DOUBLE )
                    // InternalGame.g:6507:6: lv_hit_7_0= RULE_DOUBLE
                    {
                    lv_hit_7_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    						newLeafNode(lv_hit_7_0, grammarAccess.getHitAccess().getHitDOUBLETerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hit",
                    							lv_hit_7_0,
                    							"org.bpy.score.game.Game.DOUBLE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:6525:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) )
                    {
                    // InternalGame.g:6525:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) )
                    // InternalGame.g:6526:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) )
                    {
                    // InternalGame.g:6526:4: ()
                    // InternalGame.g:6527:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getHitAccess().getBatterAdvanceOnTripleHitAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6533:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:6534:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6534:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:6535:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getHitAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHitRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_87); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getHitAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:6556:4: ( (lv_hit_11_0= RULE_TRIPLE ) )
                    // InternalGame.g:6557:5: (lv_hit_11_0= RULE_TRIPLE )
                    {
                    // InternalGame.g:6557:5: (lv_hit_11_0= RULE_TRIPLE )
                    // InternalGame.g:6558:6: lv_hit_11_0= RULE_TRIPLE
                    {
                    lv_hit_11_0=(Token)match(input,RULE_TRIPLE,FOLLOW_2); 

                    						newLeafNode(lv_hit_11_0, grammarAccess.getHitAccess().getHitTRIPLETerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hit",
                    							lv_hit_11_0,
                    							"org.bpy.score.game.Game.TRIPLE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:6576:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:6576:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:6577:4: () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:6577:4: ()
                    // InternalGame.g:6578:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getHitAccess().getBatterAdvanceOnHomeRunAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6584:4: ( (lv_currentBatter_13_0= ruleCurrentBatter ) )
                    // InternalGame.g:6585:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6585:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    // InternalGame.g:6586:6: lv_currentBatter_13_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getHitAccess().getCurrentBatterCurrentBatterParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_13_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHitRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_13_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_14=(Token)match(input,RULE_EXECUTE,FOLLOW_88); 

                    				newLeafNode(this_EXECUTE_14, grammarAccess.getHitAccess().getEXECUTETerminalRuleCall_3_2());
                    			
                    // InternalGame.g:6607:4: ( (lv_hit_15_0= RULE_HOMERUN ) )
                    // InternalGame.g:6608:5: (lv_hit_15_0= RULE_HOMERUN )
                    {
                    // InternalGame.g:6608:5: (lv_hit_15_0= RULE_HOMERUN )
                    // InternalGame.g:6609:6: lv_hit_15_0= RULE_HOMERUN
                    {
                    lv_hit_15_0=(Token)match(input,RULE_HOMERUN,FOLLOW_47); 

                    						newLeafNode(lv_hit_15_0, grammarAccess.getHitAccess().getHitHOMERUNTerminalRuleCall_3_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hit",
                    							lv_hit_15_0,
                    							"org.bpy.score.game.Game.HOMERUN");
                    					

                    }


                    }

                    // InternalGame.g:6625:4: ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( ((LA116_0>=113 && LA116_0<=114)) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalGame.g:6626:5: ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:6626:5: ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:6627:6: (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:6627:6: (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' )
                            int alt115=2;
                            int LA115_0 = input.LA(1);

                            if ( (LA115_0==113) ) {
                                alt115=1;
                            }
                            else if ( (LA115_0==114) ) {
                                alt115=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 115, 0, input);

                                throw nvae;
                            }
                            switch (alt115) {
                                case 1 :
                                    // InternalGame.g:6628:7: lv_isEarned_16_1= 'earned'
                                    {
                                    lv_isEarned_16_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_16_1, grammarAccess.getHitAccess().getIsEarnedEarnedKeyword_3_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getHitRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_16_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:6639:7: lv_isEarned_16_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_16_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_16_2, grammarAccess.getHitAccess().getIsEarnedUnEarnedForTeamKeyword_3_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getHitRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_16_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:6654:3: ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? )
                    {
                    // InternalGame.g:6654:3: ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? )
                    // InternalGame.g:6655:4: () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )?
                    {
                    // InternalGame.g:6655:4: ()
                    // InternalGame.g:6656:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getHitAccess().getBatterAdvanceOnInsideParkAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6662:4: ( (lv_currentBatter_18_0= ruleCurrentBatter ) )
                    // InternalGame.g:6663:5: (lv_currentBatter_18_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6663:5: (lv_currentBatter_18_0= ruleCurrentBatter )
                    // InternalGame.g:6664:6: lv_currentBatter_18_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getHitAccess().getCurrentBatterCurrentBatterParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_18_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHitRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_18_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_19=(Token)match(input,RULE_EXECUTE,FOLLOW_89); 

                    				newLeafNode(this_EXECUTE_19, grammarAccess.getHitAccess().getEXECUTETerminalRuleCall_4_2());
                    			
                    // InternalGame.g:6685:4: ( (lv_hit_20_0= RULE_INSIDE_PARK ) )
                    // InternalGame.g:6686:5: (lv_hit_20_0= RULE_INSIDE_PARK )
                    {
                    // InternalGame.g:6686:5: (lv_hit_20_0= RULE_INSIDE_PARK )
                    // InternalGame.g:6687:6: lv_hit_20_0= RULE_INSIDE_PARK
                    {
                    lv_hit_20_0=(Token)match(input,RULE_INSIDE_PARK,FOLLOW_47); 

                    						newLeafNode(lv_hit_20_0, grammarAccess.getHitAccess().getHitINSIDE_PARKTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"hit",
                    							lv_hit_20_0,
                    							"org.bpy.score.game.Game.INSIDE_PARK");
                    					

                    }


                    }

                    // InternalGame.g:6703:4: ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )?
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( ((LA118_0>=113 && LA118_0<=114)) ) {
                        alt118=1;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalGame.g:6704:5: ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) )
                            {
                            // InternalGame.g:6704:5: ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) )
                            // InternalGame.g:6705:6: (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' )
                            {
                            // InternalGame.g:6705:6: (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' )
                            int alt117=2;
                            int LA117_0 = input.LA(1);

                            if ( (LA117_0==113) ) {
                                alt117=1;
                            }
                            else if ( (LA117_0==114) ) {
                                alt117=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 117, 0, input);

                                throw nvae;
                            }
                            switch (alt117) {
                                case 1 :
                                    // InternalGame.g:6706:7: lv_isEarned_21_1= 'earned'
                                    {
                                    lv_isEarned_21_1=(Token)match(input,113,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_21_1, grammarAccess.getHitAccess().getIsEarnedEarnedKeyword_4_4_0_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getHitRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_21_1, null);
                                    						

                                    }
                                    break;
                                case 2 :
                                    // InternalGame.g:6717:7: lv_isEarned_21_2= 'unEarnedForTeam'
                                    {
                                    lv_isEarned_21_2=(Token)match(input,114,FOLLOW_2); 

                                    							newLeafNode(lv_isEarned_21_2, grammarAccess.getHitAccess().getIsEarnedUnEarnedForTeamKeyword_4_4_0_1());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getHitRule());
                                    							}
                                    							setWithLastConsumed(current, "isEarned", lv_isEarned_21_2, null);
                                    						

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHit"


    // $ANTLR start "entryRuleDecisiveError"
    // InternalGame.g:6735:1: entryRuleDecisiveError returns [EObject current=null] : iv_ruleDecisiveError= ruleDecisiveError EOF ;
    public final EObject entryRuleDecisiveError() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecisiveError = null;


        try {
            // InternalGame.g:6735:54: (iv_ruleDecisiveError= ruleDecisiveError EOF )
            // InternalGame.g:6736:2: iv_ruleDecisiveError= ruleDecisiveError EOF
            {
             newCompositeNode(grammarAccess.getDecisiveErrorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecisiveError=ruleDecisiveError();

            state._fsp--;

             current =iv_ruleDecisiveError; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecisiveError"


    // $ANTLR start "ruleDecisiveError"
    // InternalGame.g:6742:1: ruleDecisiveError returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) ) ) ;
    public final EObject ruleDecisiveError() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterAdvance_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_batterAdvance_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_batterAdvance_11_0=null;
        Token this_EXECUTE_14=null;
        Token lv_batterAdvance_15_0=null;
        Token this_EXECUTE_18=null;
        Token lv_batterAdvance_19_0=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;

        EObject lv_currentBatter_13_0 = null;

        EObject lv_currentBatter_17_0 = null;



        	enterRule();

        try {
            // InternalGame.g:6748:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) ) ) )
            // InternalGame.g:6749:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) ) )
            {
            // InternalGame.g:6749:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) ) )
            int alt120=5;
            alt120 = dfa120.predict(input);
            switch (alt120) {
                case 1 :
                    // InternalGame.g:6750:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) )
                    {
                    // InternalGame.g:6750:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) )
                    // InternalGame.g:6751:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) )
                    {
                    // InternalGame.g:6751:4: ()
                    // InternalGame.g:6752:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDecisiveErrorAccess().getBatterAdvanceOnFlyErrorAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6758:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:6759:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6759:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:6760:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDecisiveErrorAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecisiveErrorRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_90); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getDecisiveErrorAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:6781:4: ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) )
                    // InternalGame.g:6782:5: (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR )
                    {
                    // InternalGame.g:6782:5: (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR )
                    // InternalGame.g:6783:6: lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR
                    {
                    lv_batterAdvance_3_0=(Token)match(input,RULE_REACH_ON_FLY_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_3_0, grammarAccess.getDecisiveErrorAccess().getBatterAdvanceREACH_ON_FLY_ERRORTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDecisiveErrorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_3_0,
                    							"org.bpy.score.game.Game.REACH_ON_FLY_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:6801:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) )
                    {
                    // InternalGame.g:6801:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) )
                    // InternalGame.g:6802:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) )
                    {
                    // InternalGame.g:6802:4: ()
                    // InternalGame.g:6803:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDecisiveErrorAccess().getBatterAdvanceOnPopErrorAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6809:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:6810:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6810:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:6811:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDecisiveErrorAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecisiveErrorRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_91); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getDecisiveErrorAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:6832:4: ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) )
                    // InternalGame.g:6833:5: (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR )
                    {
                    // InternalGame.g:6833:5: (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR )
                    // InternalGame.g:6834:6: lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR
                    {
                    lv_batterAdvance_7_0=(Token)match(input,RULE_REACH_ON_POP_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_7_0, grammarAccess.getDecisiveErrorAccess().getBatterAdvanceREACH_ON_POP_ERRORTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDecisiveErrorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_7_0,
                    							"org.bpy.score.game.Game.REACH_ON_POP_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:6852:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) )
                    {
                    // InternalGame.g:6852:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) )
                    // InternalGame.g:6853:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    {
                    // InternalGame.g:6853:4: ()
                    // InternalGame.g:6854:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDecisiveErrorAccess().getBatterAdvanceOnReceiveErrorAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6860:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:6861:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6861:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:6862:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDecisiveErrorAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecisiveErrorRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_38); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getDecisiveErrorAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:6883:4: ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) )
                    // InternalGame.g:6884:5: (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR )
                    {
                    // InternalGame.g:6884:5: (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR )
                    // InternalGame.g:6885:6: lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR
                    {
                    lv_batterAdvance_11_0=(Token)match(input,RULE_REACH_ON_RECEIVE_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_11_0, grammarAccess.getDecisiveErrorAccess().getBatterAdvanceREACH_ON_RECEIVE_ERRORTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDecisiveErrorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_11_0,
                    							"org.bpy.score.game.Game.REACH_ON_RECEIVE_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:6903:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) )
                    {
                    // InternalGame.g:6903:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) )
                    // InternalGame.g:6904:4: () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) )
                    {
                    // InternalGame.g:6904:4: ()
                    // InternalGame.g:6905:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDecisiveErrorAccess().getBatterAdvanceOnThrowErrorAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6911:4: ( (lv_currentBatter_13_0= ruleCurrentBatter ) )
                    // InternalGame.g:6912:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6912:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    // InternalGame.g:6913:6: lv_currentBatter_13_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDecisiveErrorAccess().getCurrentBatterCurrentBatterParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_13_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecisiveErrorRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_13_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_14=(Token)match(input,RULE_EXECUTE,FOLLOW_37); 

                    				newLeafNode(this_EXECUTE_14, grammarAccess.getDecisiveErrorAccess().getEXECUTETerminalRuleCall_3_2());
                    			
                    // InternalGame.g:6934:4: ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) )
                    // InternalGame.g:6935:5: (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR )
                    {
                    // InternalGame.g:6935:5: (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR )
                    // InternalGame.g:6936:6: lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR
                    {
                    lv_batterAdvance_15_0=(Token)match(input,RULE_REACH_ON_THROW_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_15_0, grammarAccess.getDecisiveErrorAccess().getBatterAdvanceREACH_ON_THROW_ERRORTerminalRuleCall_3_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDecisiveErrorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_15_0,
                    							"org.bpy.score.game.Game.REACH_ON_THROW_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:6954:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) )
                    {
                    // InternalGame.g:6954:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) )
                    // InternalGame.g:6955:4: () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) )
                    {
                    // InternalGame.g:6955:4: ()
                    // InternalGame.g:6956:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getDecisiveErrorAccess().getBatterAdvanceOnGdpWithErrorAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:6962:4: ( (lv_currentBatter_17_0= ruleCurrentBatter ) )
                    // InternalGame.g:6963:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:6963:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    // InternalGame.g:6964:6: lv_currentBatter_17_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getDecisiveErrorAccess().getCurrentBatterCurrentBatterParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_17_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecisiveErrorRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_17_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_18=(Token)match(input,RULE_EXECUTE,FOLLOW_92); 

                    				newLeafNode(this_EXECUTE_18, grammarAccess.getDecisiveErrorAccess().getEXECUTETerminalRuleCall_4_2());
                    			
                    // InternalGame.g:6985:4: ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) )
                    // InternalGame.g:6986:5: (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR )
                    {
                    // InternalGame.g:6986:5: (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR )
                    // InternalGame.g:6987:6: lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR
                    {
                    lv_batterAdvance_19_0=(Token)match(input,RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR,FOLLOW_2); 

                    						newLeafNode(lv_batterAdvance_19_0, grammarAccess.getDecisiveErrorAccess().getBatterAdvanceGROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERRORTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDecisiveErrorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterAdvance",
                    							lv_batterAdvance_19_0,
                    							"org.bpy.score.game.Game.GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecisiveError"


    // $ANTLR start "entryRuleBatterOut"
    // InternalGame.g:7008:1: entryRuleBatterOut returns [EObject current=null] : iv_ruleBatterOut= ruleBatterOut EOF ;
    public final EObject entryRuleBatterOut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBatterOut = null;


        try {
            // InternalGame.g:7008:50: (iv_ruleBatterOut= ruleBatterOut EOF )
            // InternalGame.g:7009:2: iv_ruleBatterOut= ruleBatterOut EOF
            {
             newCompositeNode(grammarAccess.getBatterOutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBatterOut=ruleBatterOut();

            state._fsp--;

             current =iv_ruleBatterOut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBatterOut"


    // $ANTLR start "ruleBatterOut"
    // InternalGame.g:7015:1: ruleBatterOut returns [EObject current=null] : ( (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut ) ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )? ) ;
    public final EObject ruleBatterOut() throws RecognitionException {
        EObject current = null;

        Token lv_notInDoublePlay_2_0=null;
        EObject this_StrikeOut_0 = null;

        EObject this_FielderOut_1 = null;



        	enterRule();

        try {
            // InternalGame.g:7021:2: ( ( (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut ) ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )? ) )
            // InternalGame.g:7022:2: ( (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut ) ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )? )
            {
            // InternalGame.g:7022:2: ( (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut ) ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )? )
            // InternalGame.g:7023:3: (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut ) ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )?
            {
            // InternalGame.g:7023:3: (this_StrikeOut_0= ruleStrikeOut | this_FielderOut_1= ruleFielderOut )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==RULE_BATTER) ) {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==117) ) {
                    int LA121_2 = input.LA(3);

                    if ( (LA121_2==RULE_STRING) ) {
                        int LA121_4 = input.LA(4);

                        if ( (LA121_4==118) ) {
                            int LA121_7 = input.LA(5);

                            if ( (LA121_7==RULE_EXECUTE) ) {
                                int LA121_3 = input.LA(6);

                                if ( (LA121_3==RULE_INT||(LA121_3>=RULE_OUT_BY_RULE && LA121_3<=RULE_APPEAL)||(LA121_3>=RULE_FLYED_OUT && LA121_3<=RULE_INFIELD_FLY)) ) {
                                    alt121=2;
                                }
                                else if ( ((LA121_3>=RULE_SWING_STRIKE_OUT && LA121_3<=RULE_RELEASED_STRIKE_OUT)) ) {
                                    alt121=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 121, 3, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 121, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 121, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 121, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA121_1==RULE_EXECUTE) ) {
                    int LA121_3 = input.LA(3);

                    if ( (LA121_3==RULE_INT||(LA121_3>=RULE_OUT_BY_RULE && LA121_3<=RULE_APPEAL)||(LA121_3>=RULE_FLYED_OUT && LA121_3<=RULE_INFIELD_FLY)) ) {
                        alt121=2;
                    }
                    else if ( ((LA121_3>=RULE_SWING_STRIKE_OUT && LA121_3<=RULE_RELEASED_STRIKE_OUT)) ) {
                        alt121=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 121, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // InternalGame.g:7024:4: this_StrikeOut_0= ruleStrikeOut
                    {

                    				newCompositeNode(grammarAccess.getBatterOutAccess().getStrikeOutParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_42);
                    this_StrikeOut_0=ruleStrikeOut();

                    state._fsp--;


                    				current = this_StrikeOut_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalGame.g:7033:4: this_FielderOut_1= ruleFielderOut
                    {

                    				newCompositeNode(grammarAccess.getBatterOutAccess().getFielderOutParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_42);
                    this_FielderOut_1=ruleFielderOut();

                    state._fsp--;


                    				current = this_FielderOut_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalGame.g:7042:3: ( (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==112) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalGame.g:7043:4: (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' )
                    {
                    // InternalGame.g:7043:4: (lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay' )
                    // InternalGame.g:7044:5: lv_notInDoublePlay_2_0= 'dontCountAsDoublePlay'
                    {
                    lv_notInDoublePlay_2_0=(Token)match(input,112,FOLLOW_2); 

                    					newLeafNode(lv_notInDoublePlay_2_0, grammarAccess.getBatterOutAccess().getNotInDoublePlayDontCountAsDoublePlayKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBatterOutRule());
                    					}
                    					setWithLastConsumed(current, "notInDoublePlay", lv_notInDoublePlay_2_0 != null, "dontCountAsDoublePlay");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBatterOut"


    // $ANTLR start "entryRuleFielderOut"
    // InternalGame.g:7060:1: entryRuleFielderOut returns [EObject current=null] : iv_ruleFielderOut= ruleFielderOut EOF ;
    public final EObject entryRuleFielderOut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFielderOut = null;


        try {
            // InternalGame.g:7060:51: (iv_ruleFielderOut= ruleFielderOut EOF )
            // InternalGame.g:7061:2: iv_ruleFielderOut= ruleFielderOut EOF
            {
             newCompositeNode(grammarAccess.getFielderOutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFielderOut=ruleFielderOut();

            state._fsp--;

             current =iv_ruleFielderOut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFielderOut"


    // $ANTLR start "ruleFielderOut"
    // InternalGame.g:7067:1: ruleFielderOut returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? ) | ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) ) | ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) ) | ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) ) | ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) ) ) ;
    public final EObject ruleFielderOut() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_batterOut_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_batterOut_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_batterOut_11_0=null;
        Token this_EXECUTE_14=null;
        Token lv_batterOut_15_0=null;
        Token this_EXECUTE_18=null;
        Token lv_batterOut_19_0=null;
        Token this_EXECUTE_22=null;
        Token lv_batterOut_23_0=null;
        Token this_EXECUTE_26=null;
        Token lv_batterOut_27_0=null;
        Token lv_isBunt_28_0=null;
        Token this_EXECUTE_31=null;
        Token lv_batterOut_32_0=null;
        Token this_EXECUTE_35=null;
        Token lv_batterOut_36_0=null;
        Token this_EXECUTE_39=null;
        Token lv_batterOut_40_0=null;
        Token this_EXECUTE_43=null;
        Token lv_batterOut_44_0=null;
        Token this_EXECUTE_47=null;
        Token lv_batterOut_48_0=null;
        Token this_EXECUTE_51=null;
        Token lv_batterOut_52_0=null;
        Token this_EXECUTE_55=null;
        Token lv_batterOut_56_0=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;

        EObject lv_currentBatter_13_0 = null;

        EObject lv_currentBatter_17_0 = null;

        EObject lv_currentBatter_21_0 = null;

        EObject lv_currentBatter_25_0 = null;

        EObject lv_currentBatter_30_0 = null;

        EObject lv_currentBatter_34_0 = null;

        EObject lv_currentBatter_38_0 = null;

        EObject lv_currentBatter_42_0 = null;

        EObject lv_currentBatter_46_0 = null;

        EObject lv_currentBatter_50_0 = null;

        EObject lv_currentBatter_54_0 = null;



        	enterRule();

        try {
            // InternalGame.g:7073:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? ) | ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) ) | ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) ) | ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) ) | ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) ) ) )
            // InternalGame.g:7074:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? ) | ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) ) | ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) ) | ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) ) | ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) ) )
            {
            // InternalGame.g:7074:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? ) | ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) ) | ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) ) | ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) ) | ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) ) )
            int alt124=14;
            alt124 = dfa124.predict(input);
            switch (alt124) {
                case 1 :
                    // InternalGame.g:7075:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) )
                    {
                    // InternalGame.g:7075:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) )
                    // InternalGame.g:7076:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) )
                    {
                    // InternalGame.g:7076:4: ()
                    // InternalGame.g:7077:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnFlyedAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7083:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:7084:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7084:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:7085:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_93); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:7106:4: ( (lv_batterOut_3_0= RULE_FLYED_OUT ) )
                    // InternalGame.g:7107:5: (lv_batterOut_3_0= RULE_FLYED_OUT )
                    {
                    // InternalGame.g:7107:5: (lv_batterOut_3_0= RULE_FLYED_OUT )
                    // InternalGame.g:7108:6: lv_batterOut_3_0= RULE_FLYED_OUT
                    {
                    lv_batterOut_3_0=(Token)match(input,RULE_FLYED_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_3_0, grammarAccess.getFielderOutAccess().getBatterOutFLYED_OUTTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_3_0,
                    							"org.bpy.score.game.Game.FLYED_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:7126:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) )
                    {
                    // InternalGame.g:7126:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) )
                    // InternalGame.g:7127:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) )
                    {
                    // InternalGame.g:7127:4: ()
                    // InternalGame.g:7128:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnLineAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7134:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:7135:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7135:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:7136:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_94); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:7157:4: ( (lv_batterOut_7_0= RULE_LINE_OUT ) )
                    // InternalGame.g:7158:5: (lv_batterOut_7_0= RULE_LINE_OUT )
                    {
                    // InternalGame.g:7158:5: (lv_batterOut_7_0= RULE_LINE_OUT )
                    // InternalGame.g:7159:6: lv_batterOut_7_0= RULE_LINE_OUT
                    {
                    lv_batterOut_7_0=(Token)match(input,RULE_LINE_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_7_0, grammarAccess.getFielderOutAccess().getBatterOutLINE_OUTTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_7_0,
                    							"org.bpy.score.game.Game.LINE_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:7177:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) )
                    {
                    // InternalGame.g:7177:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) )
                    // InternalGame.g:7178:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) )
                    {
                    // InternalGame.g:7178:4: ()
                    // InternalGame.g:7179:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnPoppedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7185:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:7186:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7186:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:7187:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_95); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:7208:4: ( (lv_batterOut_11_0= RULE_POPPED_OUT ) )
                    // InternalGame.g:7209:5: (lv_batterOut_11_0= RULE_POPPED_OUT )
                    {
                    // InternalGame.g:7209:5: (lv_batterOut_11_0= RULE_POPPED_OUT )
                    // InternalGame.g:7210:6: lv_batterOut_11_0= RULE_POPPED_OUT
                    {
                    lv_batterOut_11_0=(Token)match(input,RULE_POPPED_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_11_0, grammarAccess.getFielderOutAccess().getBatterOutPOPPED_OUTTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_11_0,
                    							"org.bpy.score.game.Game.POPPED_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGame.g:7228:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) )
                    {
                    // InternalGame.g:7228:3: ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) )
                    // InternalGame.g:7229:4: () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) )
                    {
                    // InternalGame.g:7229:4: ()
                    // InternalGame.g:7230:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnFlyedFallBallAction_3_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7236:4: ( (lv_currentBatter_13_0= ruleCurrentBatter ) )
                    // InternalGame.g:7237:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7237:5: (lv_currentBatter_13_0= ruleCurrentBatter )
                    // InternalGame.g:7238:6: lv_currentBatter_13_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_13_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_13_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_14=(Token)match(input,RULE_EXECUTE,FOLLOW_96); 

                    				newLeafNode(this_EXECUTE_14, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_3_2());
                    			
                    // InternalGame.g:7259:4: ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) )
                    // InternalGame.g:7260:5: (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT )
                    {
                    // InternalGame.g:7260:5: (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT )
                    // InternalGame.g:7261:6: lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT
                    {
                    lv_batterOut_15_0=(Token)match(input,RULE_FLYED_FALLBALL_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_15_0, grammarAccess.getFielderOutAccess().getBatterOutFLYED_FALLBALL_OUTTerminalRuleCall_3_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_15_0,
                    							"org.bpy.score.game.Game.FLYED_FALLBALL_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGame.g:7279:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) )
                    {
                    // InternalGame.g:7279:3: ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) )
                    // InternalGame.g:7280:4: () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) )
                    {
                    // InternalGame.g:7280:4: ()
                    // InternalGame.g:7281:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnPoppedFallBallAction_4_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7287:4: ( (lv_currentBatter_17_0= ruleCurrentBatter ) )
                    // InternalGame.g:7288:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7288:5: (lv_currentBatter_17_0= ruleCurrentBatter )
                    // InternalGame.g:7289:6: lv_currentBatter_17_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_17_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_17_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_18=(Token)match(input,RULE_EXECUTE,FOLLOW_97); 

                    				newLeafNode(this_EXECUTE_18, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_4_2());
                    			
                    // InternalGame.g:7310:4: ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) )
                    // InternalGame.g:7311:5: (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT )
                    {
                    // InternalGame.g:7311:5: (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT )
                    // InternalGame.g:7312:6: lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT
                    {
                    lv_batterOut_19_0=(Token)match(input,RULE_POPPED_FALLBALL_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_19_0, grammarAccess.getFielderOutAccess().getBatterOutPOPPED_FALLBALL_OUTTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_19_0,
                    							"org.bpy.score.game.Game.POPPED_FALLBALL_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalGame.g:7330:3: ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) )
                    {
                    // InternalGame.g:7330:3: ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) )
                    // InternalGame.g:7331:4: () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) )
                    {
                    // InternalGame.g:7331:4: ()
                    // InternalGame.g:7332:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnLineDriveFallBallAction_5_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7338:4: ( (lv_currentBatter_21_0= ruleCurrentBatter ) )
                    // InternalGame.g:7339:5: (lv_currentBatter_21_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7339:5: (lv_currentBatter_21_0= ruleCurrentBatter )
                    // InternalGame.g:7340:6: lv_currentBatter_21_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_21_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_21_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_22=(Token)match(input,RULE_EXECUTE,FOLLOW_98); 

                    				newLeafNode(this_EXECUTE_22, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_5_2());
                    			
                    // InternalGame.g:7361:4: ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) )
                    // InternalGame.g:7362:5: (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT )
                    {
                    // InternalGame.g:7362:5: (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT )
                    // InternalGame.g:7363:6: lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT
                    {
                    lv_batterOut_23_0=(Token)match(input,RULE_LINE_FALLBALL_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_23_0, grammarAccess.getFielderOutAccess().getBatterOutLINE_FALLBALL_OUTTerminalRuleCall_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_23_0,
                    							"org.bpy.score.game.Game.LINE_FALLBALL_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalGame.g:7381:3: ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? )
                    {
                    // InternalGame.g:7381:3: ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? )
                    // InternalGame.g:7382:4: () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )?
                    {
                    // InternalGame.g:7382:4: ()
                    // InternalGame.g:7383:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnGroundedBallAction_6_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7389:4: ( (lv_currentBatter_25_0= ruleCurrentBatter ) )
                    // InternalGame.g:7390:5: (lv_currentBatter_25_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7390:5: (lv_currentBatter_25_0= ruleCurrentBatter )
                    // InternalGame.g:7391:6: lv_currentBatter_25_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_25_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_25_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_26=(Token)match(input,RULE_EXECUTE,FOLLOW_19); 

                    				newLeafNode(this_EXECUTE_26, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_6_2());
                    			
                    // InternalGame.g:7412:4: ( (lv_batterOut_27_0= RULE_INT ) )
                    // InternalGame.g:7413:5: (lv_batterOut_27_0= RULE_INT )
                    {
                    // InternalGame.g:7413:5: (lv_batterOut_27_0= RULE_INT )
                    // InternalGame.g:7414:6: lv_batterOut_27_0= RULE_INT
                    {
                    lv_batterOut_27_0=(Token)match(input,RULE_INT,FOLLOW_99); 

                    						newLeafNode(lv_batterOut_27_0, grammarAccess.getFielderOutAccess().getBatterOutINTTerminalRuleCall_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_27_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalGame.g:7430:4: ( (lv_isBunt_28_0= 'b' ) )?
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==124) ) {
                        alt123=1;
                    }
                    switch (alt123) {
                        case 1 :
                            // InternalGame.g:7431:5: (lv_isBunt_28_0= 'b' )
                            {
                            // InternalGame.g:7431:5: (lv_isBunt_28_0= 'b' )
                            // InternalGame.g:7432:6: lv_isBunt_28_0= 'b'
                            {
                            lv_isBunt_28_0=(Token)match(input,124,FOLLOW_2); 

                            						newLeafNode(lv_isBunt_28_0, grammarAccess.getFielderOutAccess().getIsBuntBKeyword_6_4_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getFielderOutRule());
                            						}
                            						setWithLastConsumed(current, "isBunt", lv_isBunt_28_0 != null, "b");
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalGame.g:7446:3: ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) )
                    {
                    // InternalGame.g:7446:3: ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) )
                    // InternalGame.g:7447:4: () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) )
                    {
                    // InternalGame.g:7447:4: ()
                    // InternalGame.g:7448:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutByRuleAction_7_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7454:4: ( (lv_currentBatter_30_0= ruleCurrentBatter ) )
                    // InternalGame.g:7455:5: (lv_currentBatter_30_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7455:5: (lv_currentBatter_30_0= ruleCurrentBatter )
                    // InternalGame.g:7456:6: lv_currentBatter_30_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_30_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_30_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_31=(Token)match(input,RULE_EXECUTE,FOLLOW_44); 

                    				newLeafNode(this_EXECUTE_31, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_7_2());
                    			
                    // InternalGame.g:7477:4: ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) )
                    // InternalGame.g:7478:5: (lv_batterOut_32_0= RULE_OUT_BY_RULE )
                    {
                    // InternalGame.g:7478:5: (lv_batterOut_32_0= RULE_OUT_BY_RULE )
                    // InternalGame.g:7479:6: lv_batterOut_32_0= RULE_OUT_BY_RULE
                    {
                    lv_batterOut_32_0=(Token)match(input,RULE_OUT_BY_RULE,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_32_0, grammarAccess.getFielderOutAccess().getBatterOutOUT_BY_RULETerminalRuleCall_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_32_0,
                    							"org.bpy.score.game.Game.OUT_BY_RULE");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalGame.g:7497:3: ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) )
                    {
                    // InternalGame.g:7497:3: ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) )
                    // InternalGame.g:7498:4: () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) )
                    {
                    // InternalGame.g:7498:4: ()
                    // InternalGame.g:7499:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnAppealAction_8_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7505:4: ( (lv_currentBatter_34_0= ruleCurrentBatter ) )
                    // InternalGame.g:7506:5: (lv_currentBatter_34_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7506:5: (lv_currentBatter_34_0= ruleCurrentBatter )
                    // InternalGame.g:7507:6: lv_currentBatter_34_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_34_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_34_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_35=(Token)match(input,RULE_EXECUTE,FOLLOW_45); 

                    				newLeafNode(this_EXECUTE_35, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_8_2());
                    			
                    // InternalGame.g:7528:4: ( (lv_batterOut_36_0= RULE_APPEAL ) )
                    // InternalGame.g:7529:5: (lv_batterOut_36_0= RULE_APPEAL )
                    {
                    // InternalGame.g:7529:5: (lv_batterOut_36_0= RULE_APPEAL )
                    // InternalGame.g:7530:6: lv_batterOut_36_0= RULE_APPEAL
                    {
                    lv_batterOut_36_0=(Token)match(input,RULE_APPEAL,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_36_0, grammarAccess.getFielderOutAccess().getBatterOutAPPEALTerminalRuleCall_8_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_36_0,
                    							"org.bpy.score.game.Game.APPEAL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalGame.g:7548:3: ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) )
                    {
                    // InternalGame.g:7548:3: ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) )
                    // InternalGame.g:7549:4: () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) )
                    {
                    // InternalGame.g:7549:4: ()
                    // InternalGame.g:7550:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnGroundedDoublePlayAction_9_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7556:4: ( (lv_currentBatter_38_0= ruleCurrentBatter ) )
                    // InternalGame.g:7557:5: (lv_currentBatter_38_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7557:5: (lv_currentBatter_38_0= ruleCurrentBatter )
                    // InternalGame.g:7558:6: lv_currentBatter_38_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_38_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_38_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_39=(Token)match(input,RULE_EXECUTE,FOLLOW_100); 

                    				newLeafNode(this_EXECUTE_39, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_9_2());
                    			
                    // InternalGame.g:7579:4: ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) )
                    // InternalGame.g:7580:5: (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT )
                    {
                    // InternalGame.g:7580:5: (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT )
                    // InternalGame.g:7581:6: lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT
                    {
                    lv_batterOut_40_0=(Token)match(input,RULE_GROUNDED_DOUBLE_PLAY_OUT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_40_0, grammarAccess.getFielderOutAccess().getBatterOutGROUNDED_DOUBLE_PLAY_OUTTerminalRuleCall_9_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_40_0,
                    							"org.bpy.score.game.Game.GROUNDED_DOUBLE_PLAY_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalGame.g:7599:3: ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) )
                    {
                    // InternalGame.g:7599:3: ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) )
                    // InternalGame.g:7600:4: () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) )
                    {
                    // InternalGame.g:7600:4: ()
                    // InternalGame.g:7601:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnSacrificeFlyAction_10_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7607:4: ( (lv_currentBatter_42_0= ruleCurrentBatter ) )
                    // InternalGame.g:7608:5: (lv_currentBatter_42_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7608:5: (lv_currentBatter_42_0= ruleCurrentBatter )
                    // InternalGame.g:7609:6: lv_currentBatter_42_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_10_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_42_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_42_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_43=(Token)match(input,RULE_EXECUTE,FOLLOW_101); 

                    				newLeafNode(this_EXECUTE_43, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_10_2());
                    			
                    // InternalGame.g:7630:4: ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) )
                    // InternalGame.g:7631:5: (lv_batterOut_44_0= RULE_SACRIFICE_FLY )
                    {
                    // InternalGame.g:7631:5: (lv_batterOut_44_0= RULE_SACRIFICE_FLY )
                    // InternalGame.g:7632:6: lv_batterOut_44_0= RULE_SACRIFICE_FLY
                    {
                    lv_batterOut_44_0=(Token)match(input,RULE_SACRIFICE_FLY,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_44_0, grammarAccess.getFielderOutAccess().getBatterOutSACRIFICE_FLYTerminalRuleCall_10_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_44_0,
                    							"org.bpy.score.game.Game.SACRIFICE_FLY");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalGame.g:7650:3: ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) )
                    {
                    // InternalGame.g:7650:3: ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) )
                    // InternalGame.g:7651:4: () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) )
                    {
                    // InternalGame.g:7651:4: ()
                    // InternalGame.g:7652:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnSacrificeFlyFallBallAction_11_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7658:4: ( (lv_currentBatter_46_0= ruleCurrentBatter ) )
                    // InternalGame.g:7659:5: (lv_currentBatter_46_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7659:5: (lv_currentBatter_46_0= ruleCurrentBatter )
                    // InternalGame.g:7660:6: lv_currentBatter_46_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_46_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_46_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_47=(Token)match(input,RULE_EXECUTE,FOLLOW_102); 

                    				newLeafNode(this_EXECUTE_47, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_11_2());
                    			
                    // InternalGame.g:7681:4: ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) )
                    // InternalGame.g:7682:5: (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL )
                    {
                    // InternalGame.g:7682:5: (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL )
                    // InternalGame.g:7683:6: lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL
                    {
                    lv_batterOut_48_0=(Token)match(input,RULE_SACRIFICE_FLY_FOUL_BALL,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_48_0, grammarAccess.getFielderOutAccess().getBatterOutSACRIFICE_FLY_FOUL_BALLTerminalRuleCall_11_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_48_0,
                    							"org.bpy.score.game.Game.SACRIFICE_FLY_FOUL_BALL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalGame.g:7701:3: ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) )
                    {
                    // InternalGame.g:7701:3: ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) )
                    // InternalGame.g:7702:4: () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) )
                    {
                    // InternalGame.g:7702:4: ()
                    // InternalGame.g:7703:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnSacrificeHitAction_12_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7709:4: ( (lv_currentBatter_50_0= ruleCurrentBatter ) )
                    // InternalGame.g:7710:5: (lv_currentBatter_50_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7710:5: (lv_currentBatter_50_0= ruleCurrentBatter )
                    // InternalGame.g:7711:6: lv_currentBatter_50_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_12_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_50_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_50_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_51=(Token)match(input,RULE_EXECUTE,FOLLOW_103); 

                    				newLeafNode(this_EXECUTE_51, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_12_2());
                    			
                    // InternalGame.g:7732:4: ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) )
                    // InternalGame.g:7733:5: (lv_batterOut_52_0= RULE_SACRIFICE_BUNT )
                    {
                    // InternalGame.g:7733:5: (lv_batterOut_52_0= RULE_SACRIFICE_BUNT )
                    // InternalGame.g:7734:6: lv_batterOut_52_0= RULE_SACRIFICE_BUNT
                    {
                    lv_batterOut_52_0=(Token)match(input,RULE_SACRIFICE_BUNT,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_52_0, grammarAccess.getFielderOutAccess().getBatterOutSACRIFICE_BUNTTerminalRuleCall_12_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_52_0,
                    							"org.bpy.score.game.Game.SACRIFICE_BUNT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalGame.g:7752:3: ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) )
                    {
                    // InternalGame.g:7752:3: ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) )
                    // InternalGame.g:7753:4: () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) )
                    {
                    // InternalGame.g:7753:4: ()
                    // InternalGame.g:7754:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFielderOutAccess().getBatterOutOnInfieldFlyAction_13_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7760:4: ( (lv_currentBatter_54_0= ruleCurrentBatter ) )
                    // InternalGame.g:7761:5: (lv_currentBatter_54_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7761:5: (lv_currentBatter_54_0= ruleCurrentBatter )
                    // InternalGame.g:7762:6: lv_currentBatter_54_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getFielderOutAccess().getCurrentBatterCurrentBatterParserRuleCall_13_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_54_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFielderOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_54_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_55=(Token)match(input,RULE_EXECUTE,FOLLOW_104); 

                    				newLeafNode(this_EXECUTE_55, grammarAccess.getFielderOutAccess().getEXECUTETerminalRuleCall_13_2());
                    			
                    // InternalGame.g:7783:4: ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) )
                    // InternalGame.g:7784:5: (lv_batterOut_56_0= RULE_INFIELD_FLY )
                    {
                    // InternalGame.g:7784:5: (lv_batterOut_56_0= RULE_INFIELD_FLY )
                    // InternalGame.g:7785:6: lv_batterOut_56_0= RULE_INFIELD_FLY
                    {
                    lv_batterOut_56_0=(Token)match(input,RULE_INFIELD_FLY,FOLLOW_2); 

                    						newLeafNode(lv_batterOut_56_0, grammarAccess.getFielderOutAccess().getBatterOutINFIELD_FLYTerminalRuleCall_13_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFielderOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batterOut",
                    							lv_batterOut_56_0,
                    							"org.bpy.score.game.Game.INFIELD_FLY");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFielderOut"


    // $ANTLR start "entryRuleStrikeOut"
    // InternalGame.g:7806:1: entryRuleStrikeOut returns [EObject current=null] : iv_ruleStrikeOut= ruleStrikeOut EOF ;
    public final EObject entryRuleStrikeOut() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrikeOut = null;


        try {
            // InternalGame.g:7806:50: (iv_ruleStrikeOut= ruleStrikeOut EOF )
            // InternalGame.g:7807:2: iv_ruleStrikeOut= ruleStrikeOut EOF
            {
             newCompositeNode(grammarAccess.getStrikeOutRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStrikeOut=ruleStrikeOut();

            state._fsp--;

             current =iv_ruleStrikeOut; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStrikeOut"


    // $ANTLR start "ruleStrikeOut"
    // InternalGame.g:7813:1: ruleStrikeOut returns [EObject current=null] : ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) ) ) ;
    public final EObject ruleStrikeOut() throws RecognitionException {
        EObject current = null;

        Token this_EXECUTE_2=null;
        Token lv_strikeOutValue_3_0=null;
        Token this_EXECUTE_6=null;
        Token lv_strikeOutValue_7_0=null;
        Token this_EXECUTE_10=null;
        Token lv_strikeOutValue_11_0=null;
        EObject lv_currentBatter_1_0 = null;

        EObject lv_currentBatter_5_0 = null;

        EObject lv_currentBatter_9_0 = null;



        	enterRule();

        try {
            // InternalGame.g:7819:2: ( ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) ) ) )
            // InternalGame.g:7820:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) ) )
            {
            // InternalGame.g:7820:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) ) )
            int alt125=3;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_BATTER) ) {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==117) ) {
                    int LA125_2 = input.LA(3);

                    if ( (LA125_2==RULE_STRING) ) {
                        int LA125_4 = input.LA(4);

                        if ( (LA125_4==118) ) {
                            int LA125_8 = input.LA(5);

                            if ( (LA125_8==RULE_EXECUTE) ) {
                                switch ( input.LA(6) ) {
                                case RULE_LOOKED_STRIKE_OUT:
                                    {
                                    alt125=2;
                                    }
                                    break;
                                case RULE_SWING_STRIKE_OUT:
                                    {
                                    alt125=1;
                                    }
                                    break;
                                case RULE_RELEASED_STRIKE_OUT:
                                    {
                                    alt125=3;
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 125, 3, input);

                                    throw nvae;
                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 125, 8, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 125, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 125, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA125_1==RULE_EXECUTE) ) {
                    switch ( input.LA(3) ) {
                    case RULE_LOOKED_STRIKE_OUT:
                        {
                        alt125=2;
                        }
                        break;
                    case RULE_SWING_STRIKE_OUT:
                        {
                        alt125=1;
                        }
                        break;
                    case RULE_RELEASED_STRIKE_OUT:
                        {
                        alt125=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 125, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 125, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }
            switch (alt125) {
                case 1 :
                    // InternalGame.g:7821:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) )
                    {
                    // InternalGame.g:7821:3: ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) ) )
                    // InternalGame.g:7822:4: () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) )
                    {
                    // InternalGame.g:7822:4: ()
                    // InternalGame.g:7823:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStrikeOutAccess().getBatterOutOnSwingedStrikeAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7829:4: ( (lv_currentBatter_1_0= ruleCurrentBatter ) )
                    // InternalGame.g:7830:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7830:5: (lv_currentBatter_1_0= ruleCurrentBatter )
                    // InternalGame.g:7831:6: lv_currentBatter_1_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getStrikeOutAccess().getCurrentBatterCurrentBatterParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_1_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStrikeOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_1_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_2=(Token)match(input,RULE_EXECUTE,FOLLOW_105); 

                    				newLeafNode(this_EXECUTE_2, grammarAccess.getStrikeOutAccess().getEXECUTETerminalRuleCall_0_2());
                    			
                    // InternalGame.g:7852:4: ( (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT ) )
                    // InternalGame.g:7853:5: (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT )
                    {
                    // InternalGame.g:7853:5: (lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT )
                    // InternalGame.g:7854:6: lv_strikeOutValue_3_0= RULE_SWING_STRIKE_OUT
                    {
                    lv_strikeOutValue_3_0=(Token)match(input,RULE_SWING_STRIKE_OUT,FOLLOW_2); 

                    						newLeafNode(lv_strikeOutValue_3_0, grammarAccess.getStrikeOutAccess().getStrikeOutValueSWING_STRIKE_OUTTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStrikeOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"strikeOutValue",
                    							lv_strikeOutValue_3_0,
                    							"org.bpy.score.game.Game.SWING_STRIKE_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGame.g:7872:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) )
                    {
                    // InternalGame.g:7872:3: ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) ) )
                    // InternalGame.g:7873:4: () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) )
                    {
                    // InternalGame.g:7873:4: ()
                    // InternalGame.g:7874:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStrikeOutAccess().getBatterOutOnLookedStrikeAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7880:4: ( (lv_currentBatter_5_0= ruleCurrentBatter ) )
                    // InternalGame.g:7881:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7881:5: (lv_currentBatter_5_0= ruleCurrentBatter )
                    // InternalGame.g:7882:6: lv_currentBatter_5_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getStrikeOutAccess().getCurrentBatterCurrentBatterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_5_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStrikeOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_5_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_6=(Token)match(input,RULE_EXECUTE,FOLLOW_106); 

                    				newLeafNode(this_EXECUTE_6, grammarAccess.getStrikeOutAccess().getEXECUTETerminalRuleCall_1_2());
                    			
                    // InternalGame.g:7903:4: ( (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT ) )
                    // InternalGame.g:7904:5: (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT )
                    {
                    // InternalGame.g:7904:5: (lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT )
                    // InternalGame.g:7905:6: lv_strikeOutValue_7_0= RULE_LOOKED_STRIKE_OUT
                    {
                    lv_strikeOutValue_7_0=(Token)match(input,RULE_LOOKED_STRIKE_OUT,FOLLOW_2); 

                    						newLeafNode(lv_strikeOutValue_7_0, grammarAccess.getStrikeOutAccess().getStrikeOutValueLOOKED_STRIKE_OUTTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStrikeOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"strikeOutValue",
                    							lv_strikeOutValue_7_0,
                    							"org.bpy.score.game.Game.LOOKED_STRIKE_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGame.g:7923:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) )
                    {
                    // InternalGame.g:7923:3: ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) ) )
                    // InternalGame.g:7924:4: () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) )
                    {
                    // InternalGame.g:7924:4: ()
                    // InternalGame.g:7925:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStrikeOutAccess().getBatterOutOnReleasedStrikeAction_2_0(),
                    						current);
                    				

                    }

                    // InternalGame.g:7931:4: ( (lv_currentBatter_9_0= ruleCurrentBatter ) )
                    // InternalGame.g:7932:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    {
                    // InternalGame.g:7932:5: (lv_currentBatter_9_0= ruleCurrentBatter )
                    // InternalGame.g:7933:6: lv_currentBatter_9_0= ruleCurrentBatter
                    {

                    						newCompositeNode(grammarAccess.getStrikeOutAccess().getCurrentBatterCurrentBatterParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    lv_currentBatter_9_0=ruleCurrentBatter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStrikeOutRule());
                    						}
                    						set(
                    							current,
                    							"currentBatter",
                    							lv_currentBatter_9_0,
                    							"org.bpy.score.game.Game.CurrentBatter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_EXECUTE_10=(Token)match(input,RULE_EXECUTE,FOLLOW_107); 

                    				newLeafNode(this_EXECUTE_10, grammarAccess.getStrikeOutAccess().getEXECUTETerminalRuleCall_2_2());
                    			
                    // InternalGame.g:7954:4: ( (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT ) )
                    // InternalGame.g:7955:5: (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT )
                    {
                    // InternalGame.g:7955:5: (lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT )
                    // InternalGame.g:7956:6: lv_strikeOutValue_11_0= RULE_RELEASED_STRIKE_OUT
                    {
                    lv_strikeOutValue_11_0=(Token)match(input,RULE_RELEASED_STRIKE_OUT,FOLLOW_2); 

                    						newLeafNode(lv_strikeOutValue_11_0, grammarAccess.getStrikeOutAccess().getStrikeOutValueRELEASED_STRIKE_OUTTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStrikeOutRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"strikeOutValue",
                    							lv_strikeOutValue_11_0,
                    							"org.bpy.score.game.Game.RELEASED_STRIKE_OUT");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStrikeOut"


    // $ANTLR start "entryRuleCurrentBatter"
    // InternalGame.g:7977:1: entryRuleCurrentBatter returns [EObject current=null] : iv_ruleCurrentBatter= ruleCurrentBatter EOF ;
    public final EObject entryRuleCurrentBatter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurrentBatter = null;


        try {
            // InternalGame.g:7977:54: (iv_ruleCurrentBatter= ruleCurrentBatter EOF )
            // InternalGame.g:7978:2: iv_ruleCurrentBatter= ruleCurrentBatter EOF
            {
             newCompositeNode(grammarAccess.getCurrentBatterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCurrentBatter=ruleCurrentBatter();

            state._fsp--;

             current =iv_ruleCurrentBatter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCurrentBatter"


    // $ANTLR start "ruleCurrentBatter"
    // InternalGame.g:7984:1: ruleCurrentBatter returns [EObject current=null] : ( ( (lv_batter_0_0= RULE_BATTER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCurrentBatter() throws RecognitionException {
        EObject current = null;

        Token lv_batter_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGame.g:7990:2: ( ( ( (lv_batter_0_0= RULE_BATTER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? ) )
            // InternalGame.g:7991:2: ( ( (lv_batter_0_0= RULE_BATTER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? )
            {
            // InternalGame.g:7991:2: ( ( (lv_batter_0_0= RULE_BATTER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? )
            // InternalGame.g:7992:3: ( (lv_batter_0_0= RULE_BATTER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )?
            {
            // InternalGame.g:7992:3: ( (lv_batter_0_0= RULE_BATTER ) )
            // InternalGame.g:7993:4: (lv_batter_0_0= RULE_BATTER )
            {
            // InternalGame.g:7993:4: (lv_batter_0_0= RULE_BATTER )
            // InternalGame.g:7994:5: lv_batter_0_0= RULE_BATTER
            {
            lv_batter_0_0=(Token)match(input,RULE_BATTER,FOLLOW_108); 

            					newLeafNode(lv_batter_0_0, grammarAccess.getCurrentBatterAccess().getBatterBATTERTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCurrentBatterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"batter",
            						lv_batter_0_0,
            						"org.bpy.score.game.Game.BATTER");
            				

            }


            }

            // InternalGame.g:8010:3: (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==117) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalGame.g:8011:4: otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,117,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getCurrentBatterAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalGame.g:8015:4: ( (lv_name_2_0= RULE_STRING ) )
                    // InternalGame.g:8016:5: (lv_name_2_0= RULE_STRING )
                    {
                    // InternalGame.g:8016:5: (lv_name_2_0= RULE_STRING )
                    // InternalGame.g:8017:6: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_63); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getCurrentBatterAccess().getNameSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCurrentBatterRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,118,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getCurrentBatterAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCurrentBatter"


    // $ANTLR start "entryRuleCurrentRunner"
    // InternalGame.g:8042:1: entryRuleCurrentRunner returns [EObject current=null] : iv_ruleCurrentRunner= ruleCurrentRunner EOF ;
    public final EObject entryRuleCurrentRunner() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurrentRunner = null;


        try {
            // InternalGame.g:8042:54: (iv_ruleCurrentRunner= ruleCurrentRunner EOF )
            // InternalGame.g:8043:2: iv_ruleCurrentRunner= ruleCurrentRunner EOF
            {
             newCompositeNode(grammarAccess.getCurrentRunnerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCurrentRunner=ruleCurrentRunner();

            state._fsp--;

             current =iv_ruleCurrentRunner; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCurrentRunner"


    // $ANTLR start "ruleCurrentRunner"
    // InternalGame.g:8049:1: ruleCurrentRunner returns [EObject current=null] : ( ( (lv_runner_0_0= RULE_RUNNER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCurrentRunner() throws RecognitionException {
        EObject current = null;

        Token lv_runner_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGame.g:8055:2: ( ( ( (lv_runner_0_0= RULE_RUNNER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? ) )
            // InternalGame.g:8056:2: ( ( (lv_runner_0_0= RULE_RUNNER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? )
            {
            // InternalGame.g:8056:2: ( ( (lv_runner_0_0= RULE_RUNNER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )? )
            // InternalGame.g:8057:3: ( (lv_runner_0_0= RULE_RUNNER ) ) (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )?
            {
            // InternalGame.g:8057:3: ( (lv_runner_0_0= RULE_RUNNER ) )
            // InternalGame.g:8058:4: (lv_runner_0_0= RULE_RUNNER )
            {
            // InternalGame.g:8058:4: (lv_runner_0_0= RULE_RUNNER )
            // InternalGame.g:8059:5: lv_runner_0_0= RULE_RUNNER
            {
            lv_runner_0_0=(Token)match(input,RULE_RUNNER,FOLLOW_108); 

            					newLeafNode(lv_runner_0_0, grammarAccess.getCurrentRunnerAccess().getRunnerRUNNERTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCurrentRunnerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"runner",
            						lv_runner_0_0,
            						"org.bpy.score.game.Game.RUNNER");
            				

            }


            }

            // InternalGame.g:8075:3: (otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==117) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalGame.g:8076:4: otherlv_1= '(' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,117,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getCurrentRunnerAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalGame.g:8080:4: ( (lv_name_2_0= RULE_STRING ) )
                    // InternalGame.g:8081:5: (lv_name_2_0= RULE_STRING )
                    {
                    // InternalGame.g:8081:5: (lv_name_2_0= RULE_STRING )
                    // InternalGame.g:8082:6: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_63); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getCurrentRunnerAccess().getNameSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCurrentRunnerRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,118,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getCurrentRunnerAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCurrentRunner"


    // $ANTLR start "entryRuleLineUp"
    // InternalGame.g:8107:1: entryRuleLineUp returns [EObject current=null] : iv_ruleLineUp= ruleLineUp EOF ;
    public final EObject entryRuleLineUp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineUp = null;


        try {
            // InternalGame.g:8107:47: (iv_ruleLineUp= ruleLineUp EOF )
            // InternalGame.g:8108:2: iv_ruleLineUp= ruleLineUp EOF
            {
             newCompositeNode(grammarAccess.getLineUpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineUp=ruleLineUp();

            state._fsp--;

             current =iv_ruleLineUp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineUp"


    // $ANTLR start "ruleLineUp"
    // InternalGame.g:8114:1: ruleLineUp returns [EObject current=null] : (otherlv_0= 'lineup' ( (lv_teamType_1_0= ruleTeamTypeEnum ) ) otherlv_2= '{' ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+ otherlv_4= '}' ) ;
    public final EObject ruleLineUp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_teamType_1_0 = null;

        EObject lv_lineUpEntries_3_0 = null;



        	enterRule();

        try {
            // InternalGame.g:8120:2: ( (otherlv_0= 'lineup' ( (lv_teamType_1_0= ruleTeamTypeEnum ) ) otherlv_2= '{' ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+ otherlv_4= '}' ) )
            // InternalGame.g:8121:2: (otherlv_0= 'lineup' ( (lv_teamType_1_0= ruleTeamTypeEnum ) ) otherlv_2= '{' ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+ otherlv_4= '}' )
            {
            // InternalGame.g:8121:2: (otherlv_0= 'lineup' ( (lv_teamType_1_0= ruleTeamTypeEnum ) ) otherlv_2= '{' ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+ otherlv_4= '}' )
            // InternalGame.g:8122:3: otherlv_0= 'lineup' ( (lv_teamType_1_0= ruleTeamTypeEnum ) ) otherlv_2= '{' ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,125,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getLineUpAccess().getLineupKeyword_0());
            		
            // InternalGame.g:8126:3: ( (lv_teamType_1_0= ruleTeamTypeEnum ) )
            // InternalGame.g:8127:4: (lv_teamType_1_0= ruleTeamTypeEnum )
            {
            // InternalGame.g:8127:4: (lv_teamType_1_0= ruleTeamTypeEnum )
            // InternalGame.g:8128:5: lv_teamType_1_0= ruleTeamTypeEnum
            {

            					newCompositeNode(grammarAccess.getLineUpAccess().getTeamTypeTeamTypeEnumParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_teamType_1_0=ruleTeamTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLineUpRule());
            					}
            					set(
            						current,
            						"teamType",
            						lv_teamType_1_0,
            						"org.bpy.score.game.Game.TeamTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,90,FOLLOW_109); 

            			newLeafNode(otherlv_2, grammarAccess.getLineUpAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGame.g:8149:3: ( (lv_lineUpEntries_3_0= ruleLineUpEntry ) )+
            int cnt128=0;
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==126) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // InternalGame.g:8150:4: (lv_lineUpEntries_3_0= ruleLineUpEntry )
            	    {
            	    // InternalGame.g:8150:4: (lv_lineUpEntries_3_0= ruleLineUpEntry )
            	    // InternalGame.g:8151:5: lv_lineUpEntries_3_0= ruleLineUpEntry
            	    {

            	    					newCompositeNode(grammarAccess.getLineUpAccess().getLineUpEntriesLineUpEntryParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_110);
            	    lv_lineUpEntries_3_0=ruleLineUpEntry();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLineUpRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lineUpEntries",
            	    						lv_lineUpEntries_3_0,
            	    						"org.bpy.score.game.Game.LineUpEntry");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt128 >= 1 ) break loop128;
                        EarlyExitException eee =
                            new EarlyExitException(128, input);
                        throw eee;
                }
                cnt128++;
            } while (true);

            otherlv_4=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLineUpAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineUp"


    // $ANTLR start "entryRuleLineUpEntry"
    // InternalGame.g:8176:1: entryRuleLineUpEntry returns [EObject current=null] : iv_ruleLineUpEntry= ruleLineUpEntry EOF ;
    public final EObject entryRuleLineUpEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLineUpEntry = null;


        try {
            // InternalGame.g:8176:52: (iv_ruleLineUpEntry= ruleLineUpEntry EOF )
            // InternalGame.g:8177:2: iv_ruleLineUpEntry= ruleLineUpEntry EOF
            {
             newCompositeNode(grammarAccess.getLineUpEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineUpEntry=ruleLineUpEntry();

            state._fsp--;

             current =iv_ruleLineUpEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineUpEntry"


    // $ANTLR start "ruleLineUpEntry"
    // InternalGame.g:8183:1: ruleLineUpEntry returns [EObject current=null] : (otherlv_0= 'name' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= 'defensivePosition' otherlv_4= '=' ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) ) (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )? (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )? otherlv_12= ';' ) ;
    public final EObject ruleLineUpEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_shirtNumber_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_laterality_11_0=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_defensivePosition_5_0 = null;



        	enterRule();

        try {
            // InternalGame.g:8189:2: ( (otherlv_0= 'name' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= 'defensivePosition' otherlv_4= '=' ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) ) (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )? (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )? otherlv_12= ';' ) )
            // InternalGame.g:8190:2: (otherlv_0= 'name' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= 'defensivePosition' otherlv_4= '=' ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) ) (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )? (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )? otherlv_12= ';' )
            {
            // InternalGame.g:8190:2: (otherlv_0= 'name' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= 'defensivePosition' otherlv_4= '=' ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) ) (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )? (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )? otherlv_12= ';' )
            // InternalGame.g:8191:3: otherlv_0= 'name' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= 'defensivePosition' otherlv_4= '=' ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) ) (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )? (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )? otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,126,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getLineUpEntryAccess().getNameKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLineUpEntryAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:8199:3: ( (lv_name_2_0= RULE_STRING ) )
            // InternalGame.g:8200:4: (lv_name_2_0= RULE_STRING )
            {
            // InternalGame.g:8200:4: (lv_name_2_0= RULE_STRING )
            // InternalGame.g:8201:5: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_111); 

            					newLeafNode(lv_name_2_0, grammarAccess.getLineUpEntryAccess().getNameSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLineUpEntryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,127,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getLineUpEntryAccess().getDefensivePositionKeyword_3());
            		
            otherlv_4=(Token)match(input,97,FOLLOW_64); 

            			newLeafNode(otherlv_4, grammarAccess.getLineUpEntryAccess().getEqualsSignKeyword_4());
            		
            // InternalGame.g:8225:3: ( (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition ) )
            // InternalGame.g:8226:4: (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition )
            {
            // InternalGame.g:8226:4: (lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition )
            // InternalGame.g:8227:5: lv_defensivePosition_5_0= ruleLineUPAtDefensivePosition
            {

            					newCompositeNode(grammarAccess.getLineUpEntryAccess().getDefensivePositionLineUPAtDefensivePositionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_112);
            lv_defensivePosition_5_0=ruleLineUPAtDefensivePosition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLineUpEntryRule());
            					}
            					set(
            						current,
            						"defensivePosition",
            						lv_defensivePosition_5_0,
            						"org.bpy.score.game.Game.LineUPAtDefensivePosition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:8244:3: (otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==122) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalGame.g:8245:4: otherlv_6= 'shirtNumber' otherlv_7= '=' ( (lv_shirtNumber_8_0= RULE_INT ) )
                    {
                    otherlv_6=(Token)match(input,122,FOLLOW_15); 

                    				newLeafNode(otherlv_6, grammarAccess.getLineUpEntryAccess().getShirtNumberKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,97,FOLLOW_19); 

                    				newLeafNode(otherlv_7, grammarAccess.getLineUpEntryAccess().getEqualsSignKeyword_6_1());
                    			
                    // InternalGame.g:8253:4: ( (lv_shirtNumber_8_0= RULE_INT ) )
                    // InternalGame.g:8254:5: (lv_shirtNumber_8_0= RULE_INT )
                    {
                    // InternalGame.g:8254:5: (lv_shirtNumber_8_0= RULE_INT )
                    // InternalGame.g:8255:6: lv_shirtNumber_8_0= RULE_INT
                    {
                    lv_shirtNumber_8_0=(Token)match(input,RULE_INT,FOLLOW_113); 

                    						newLeafNode(lv_shirtNumber_8_0, grammarAccess.getLineUpEntryAccess().getShirtNumberINTTerminalRuleCall_6_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLineUpEntryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"shirtNumber",
                    							lv_shirtNumber_8_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalGame.g:8272:3: (otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==120) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalGame.g:8273:4: otherlv_9= 'laterality' otherlv_10= '=' ( (lv_laterality_11_0= RULE_LATERALITY ) )
                    {
                    otherlv_9=(Token)match(input,120,FOLLOW_15); 

                    				newLeafNode(otherlv_9, grammarAccess.getLineUpEntryAccess().getLateralityKeyword_7_0());
                    			
                    otherlv_10=(Token)match(input,97,FOLLOW_66); 

                    				newLeafNode(otherlv_10, grammarAccess.getLineUpEntryAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalGame.g:8281:4: ( (lv_laterality_11_0= RULE_LATERALITY ) )
                    // InternalGame.g:8282:5: (lv_laterality_11_0= RULE_LATERALITY )
                    {
                    // InternalGame.g:8282:5: (lv_laterality_11_0= RULE_LATERALITY )
                    // InternalGame.g:8283:6: lv_laterality_11_0= RULE_LATERALITY
                    {
                    lv_laterality_11_0=(Token)match(input,RULE_LATERALITY,FOLLOW_10); 

                    						newLeafNode(lv_laterality_11_0, grammarAccess.getLineUpEntryAccess().getLateralityLATERALITYTerminalRuleCall_7_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLineUpEntryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"laterality",
                    							lv_laterality_11_0,
                    							"org.bpy.score.game.Game.LATERALITY");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLineUpEntryAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineUpEntry"


    // $ANTLR start "entryRuleLineUPCurrentDefensivePosition"
    // InternalGame.g:8308:1: entryRuleLineUPCurrentDefensivePosition returns [String current=null] : iv_ruleLineUPCurrentDefensivePosition= ruleLineUPCurrentDefensivePosition EOF ;
    public final String entryRuleLineUPCurrentDefensivePosition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLineUPCurrentDefensivePosition = null;


        try {
            // InternalGame.g:8308:70: (iv_ruleLineUPCurrentDefensivePosition= ruleLineUPCurrentDefensivePosition EOF )
            // InternalGame.g:8309:2: iv_ruleLineUPCurrentDefensivePosition= ruleLineUPCurrentDefensivePosition EOF
            {
             newCompositeNode(grammarAccess.getLineUPCurrentDefensivePositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineUPCurrentDefensivePosition=ruleLineUPCurrentDefensivePosition();

            state._fsp--;

             current =iv_ruleLineUPCurrentDefensivePosition.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineUPCurrentDefensivePosition"


    // $ANTLR start "ruleLineUPCurrentDefensivePosition"
    // InternalGame.g:8315:1: ruleLineUPCurrentDefensivePosition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_WITH_POSITION_2= RULE_PITCH_RUNNER_WITH_POSITION | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_WITH_POSITION_4= RULE_PITCH_HITTER_WITH_POSITION ) ;
    public final AntlrDatatypeRuleToken ruleLineUPCurrentDefensivePosition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DESIGNAATED_HITTER_1=null;
        Token this_PITCH_RUNNER_WITH_POSITION_2=null;
        Token this_DESIGNATED_PITCHER_3=null;
        Token this_PITCH_HITTER_WITH_POSITION_4=null;


        	enterRule();

        try {
            // InternalGame.g:8321:2: ( (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_WITH_POSITION_2= RULE_PITCH_RUNNER_WITH_POSITION | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_WITH_POSITION_4= RULE_PITCH_HITTER_WITH_POSITION ) )
            // InternalGame.g:8322:2: (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_WITH_POSITION_2= RULE_PITCH_RUNNER_WITH_POSITION | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_WITH_POSITION_4= RULE_PITCH_HITTER_WITH_POSITION )
            {
            // InternalGame.g:8322:2: (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_WITH_POSITION_2= RULE_PITCH_RUNNER_WITH_POSITION | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_WITH_POSITION_4= RULE_PITCH_HITTER_WITH_POSITION )
            int alt131=5;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt131=1;
                }
                break;
            case RULE_DESIGNAATED_HITTER:
                {
                alt131=2;
                }
                break;
            case RULE_PITCH_RUNNER_WITH_POSITION:
                {
                alt131=3;
                }
                break;
            case RULE_DESIGNATED_PITCHER:
                {
                alt131=4;
                }
                break;
            case RULE_PITCH_HITTER_WITH_POSITION:
                {
                alt131=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // InternalGame.g:8323:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_0);
                    		

                    			newLeafNode(this_INT_0, grammarAccess.getLineUPCurrentDefensivePositionAccess().getINTTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:8331:3: this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER
                    {
                    this_DESIGNAATED_HITTER_1=(Token)match(input,RULE_DESIGNAATED_HITTER,FOLLOW_2); 

                    			current.merge(this_DESIGNAATED_HITTER_1);
                    		

                    			newLeafNode(this_DESIGNAATED_HITTER_1, grammarAccess.getLineUPCurrentDefensivePositionAccess().getDESIGNAATED_HITTERTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalGame.g:8339:3: this_PITCH_RUNNER_WITH_POSITION_2= RULE_PITCH_RUNNER_WITH_POSITION
                    {
                    this_PITCH_RUNNER_WITH_POSITION_2=(Token)match(input,RULE_PITCH_RUNNER_WITH_POSITION,FOLLOW_2); 

                    			current.merge(this_PITCH_RUNNER_WITH_POSITION_2);
                    		

                    			newLeafNode(this_PITCH_RUNNER_WITH_POSITION_2, grammarAccess.getLineUPCurrentDefensivePositionAccess().getPITCH_RUNNER_WITH_POSITIONTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalGame.g:8347:3: this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER
                    {
                    this_DESIGNATED_PITCHER_3=(Token)match(input,RULE_DESIGNATED_PITCHER,FOLLOW_2); 

                    			current.merge(this_DESIGNATED_PITCHER_3);
                    		

                    			newLeafNode(this_DESIGNATED_PITCHER_3, grammarAccess.getLineUPCurrentDefensivePositionAccess().getDESIGNATED_PITCHERTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalGame.g:8355:3: this_PITCH_HITTER_WITH_POSITION_4= RULE_PITCH_HITTER_WITH_POSITION
                    {
                    this_PITCH_HITTER_WITH_POSITION_4=(Token)match(input,RULE_PITCH_HITTER_WITH_POSITION,FOLLOW_2); 

                    			current.merge(this_PITCH_HITTER_WITH_POSITION_4);
                    		

                    			newLeafNode(this_PITCH_HITTER_WITH_POSITION_4, grammarAccess.getLineUPCurrentDefensivePositionAccess().getPITCH_HITTER_WITH_POSITIONTerminalRuleCall_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineUPCurrentDefensivePosition"


    // $ANTLR start "entryRuleLineUPAtDefensivePosition"
    // InternalGame.g:8366:1: entryRuleLineUPAtDefensivePosition returns [String current=null] : iv_ruleLineUPAtDefensivePosition= ruleLineUPAtDefensivePosition EOF ;
    public final String entryRuleLineUPAtDefensivePosition() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLineUPAtDefensivePosition = null;


        try {
            // InternalGame.g:8366:65: (iv_ruleLineUPAtDefensivePosition= ruleLineUPAtDefensivePosition EOF )
            // InternalGame.g:8367:2: iv_ruleLineUPAtDefensivePosition= ruleLineUPAtDefensivePosition EOF
            {
             newCompositeNode(grammarAccess.getLineUPAtDefensivePositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLineUPAtDefensivePosition=ruleLineUPAtDefensivePosition();

            state._fsp--;

             current =iv_ruleLineUPAtDefensivePosition.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLineUPAtDefensivePosition"


    // $ANTLR start "ruleLineUPAtDefensivePosition"
    // InternalGame.g:8373:1: ruleLineUPAtDefensivePosition returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_2= RULE_PITCH_RUNNER | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_4= RULE_PITCH_HITTER ) ;
    public final AntlrDatatypeRuleToken ruleLineUPAtDefensivePosition() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DESIGNAATED_HITTER_1=null;
        Token this_PITCH_RUNNER_2=null;
        Token this_DESIGNATED_PITCHER_3=null;
        Token this_PITCH_HITTER_4=null;


        	enterRule();

        try {
            // InternalGame.g:8379:2: ( (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_2= RULE_PITCH_RUNNER | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_4= RULE_PITCH_HITTER ) )
            // InternalGame.g:8380:2: (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_2= RULE_PITCH_RUNNER | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_4= RULE_PITCH_HITTER )
            {
            // InternalGame.g:8380:2: (this_INT_0= RULE_INT | this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER | this_PITCH_RUNNER_2= RULE_PITCH_RUNNER | this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER | this_PITCH_HITTER_4= RULE_PITCH_HITTER )
            int alt132=5;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt132=1;
                }
                break;
            case RULE_DESIGNAATED_HITTER:
                {
                alt132=2;
                }
                break;
            case RULE_PITCH_RUNNER:
                {
                alt132=3;
                }
                break;
            case RULE_DESIGNATED_PITCHER:
                {
                alt132=4;
                }
                break;
            case RULE_PITCH_HITTER:
                {
                alt132=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }

            switch (alt132) {
                case 1 :
                    // InternalGame.g:8381:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_0);
                    		

                    			newLeafNode(this_INT_0, grammarAccess.getLineUPAtDefensivePositionAccess().getINTTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:8389:3: this_DESIGNAATED_HITTER_1= RULE_DESIGNAATED_HITTER
                    {
                    this_DESIGNAATED_HITTER_1=(Token)match(input,RULE_DESIGNAATED_HITTER,FOLLOW_2); 

                    			current.merge(this_DESIGNAATED_HITTER_1);
                    		

                    			newLeafNode(this_DESIGNAATED_HITTER_1, grammarAccess.getLineUPAtDefensivePositionAccess().getDESIGNAATED_HITTERTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalGame.g:8397:3: this_PITCH_RUNNER_2= RULE_PITCH_RUNNER
                    {
                    this_PITCH_RUNNER_2=(Token)match(input,RULE_PITCH_RUNNER,FOLLOW_2); 

                    			current.merge(this_PITCH_RUNNER_2);
                    		

                    			newLeafNode(this_PITCH_RUNNER_2, grammarAccess.getLineUPAtDefensivePositionAccess().getPITCH_RUNNERTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalGame.g:8405:3: this_DESIGNATED_PITCHER_3= RULE_DESIGNATED_PITCHER
                    {
                    this_DESIGNATED_PITCHER_3=(Token)match(input,RULE_DESIGNATED_PITCHER,FOLLOW_2); 

                    			current.merge(this_DESIGNATED_PITCHER_3);
                    		

                    			newLeafNode(this_DESIGNATED_PITCHER_3, grammarAccess.getLineUPAtDefensivePositionAccess().getDESIGNATED_PITCHERTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalGame.g:8413:3: this_PITCH_HITTER_4= RULE_PITCH_HITTER
                    {
                    this_PITCH_HITTER_4=(Token)match(input,RULE_PITCH_HITTER,FOLLOW_2); 

                    			current.merge(this_PITCH_HITTER_4);
                    		

                    			newLeafNode(this_PITCH_HITTER_4, grammarAccess.getLineUPAtDefensivePositionAccess().getPITCH_HITTERTerminalRuleCall_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLineUPAtDefensivePosition"


    // $ANTLR start "entryRuleKindOfPitch"
    // InternalGame.g:8424:1: entryRuleKindOfPitch returns [String current=null] : iv_ruleKindOfPitch= ruleKindOfPitch EOF ;
    public final String entryRuleKindOfPitch() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKindOfPitch = null;


        try {
            // InternalGame.g:8424:51: (iv_ruleKindOfPitch= ruleKindOfPitch EOF )
            // InternalGame.g:8425:2: iv_ruleKindOfPitch= ruleKindOfPitch EOF
            {
             newCompositeNode(grammarAccess.getKindOfPitchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKindOfPitch=ruleKindOfPitch();

            state._fsp--;

             current =iv_ruleKindOfPitch.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKindOfPitch"


    // $ANTLR start "ruleKindOfPitch"
    // InternalGame.g:8431:1: ruleKindOfPitch returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'b' | kw= 'B' | kw= 'k' | kw= 'K' | kw= 's' | kw= 'S' | kw= 'h' | kw= 'H' | kw= 'f' | kw= 'F' | kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleKindOfPitch() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGame.g:8437:2: ( (kw= 'b' | kw= 'B' | kw= 'k' | kw= 'K' | kw= 's' | kw= 'S' | kw= 'h' | kw= 'H' | kw= 'f' | kw= 'F' | kw= '.' ) )
            // InternalGame.g:8438:2: (kw= 'b' | kw= 'B' | kw= 'k' | kw= 'K' | kw= 's' | kw= 'S' | kw= 'h' | kw= 'H' | kw= 'f' | kw= 'F' | kw= '.' )
            {
            // InternalGame.g:8438:2: (kw= 'b' | kw= 'B' | kw= 'k' | kw= 'K' | kw= 's' | kw= 'S' | kw= 'h' | kw= 'H' | kw= 'f' | kw= 'F' | kw= '.' )
            int alt133=11;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt133=1;
                }
                break;
            case 128:
                {
                alt133=2;
                }
                break;
            case 129:
                {
                alt133=3;
                }
                break;
            case 130:
                {
                alt133=4;
                }
                break;
            case 131:
                {
                alt133=5;
                }
                break;
            case 132:
                {
                alt133=6;
                }
                break;
            case 133:
                {
                alt133=7;
                }
                break;
            case 134:
                {
                alt133=8;
                }
                break;
            case 135:
                {
                alt133=9;
                }
                break;
            case 136:
                {
                alt133=10;
                }
                break;
            case 137:
                {
                alt133=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalGame.g:8439:3: kw= 'b'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getBKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:8445:3: kw= 'B'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getBKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalGame.g:8451:3: kw= 'k'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getKKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalGame.g:8457:3: kw= 'K'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getKKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalGame.g:8463:3: kw= 's'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getSKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalGame.g:8469:3: kw= 'S'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getSKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalGame.g:8475:3: kw= 'h'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getHKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalGame.g:8481:3: kw= 'H'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getHKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalGame.g:8487:3: kw= 'f'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getFKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalGame.g:8493:3: kw= 'F'
                    {
                    kw=(Token)match(input,136,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getFKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalGame.g:8499:3: kw= '.'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKindOfPitchAccess().getFullStopKeyword_10());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKindOfPitch"


    // $ANTLR start "entryRuleRoster"
    // InternalGame.g:8508:1: entryRuleRoster returns [EObject current=null] : iv_ruleRoster= ruleRoster EOF ;
    public final EObject entryRuleRoster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoster = null;


        try {
            // InternalGame.g:8508:47: (iv_ruleRoster= ruleRoster EOF )
            // InternalGame.g:8509:2: iv_ruleRoster= ruleRoster EOF
            {
             newCompositeNode(grammarAccess.getRosterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoster=ruleRoster();

            state._fsp--;

             current =iv_ruleRoster; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoster"


    // $ANTLR start "ruleRoster"
    // InternalGame.g:8515:1: ruleRoster returns [EObject current=null] : (otherlv_0= 'roster' ( (lv_who_1_0= ruleTeamTypeEnum ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= '{' ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )? otherlv_7= '}' ) ;
    public final EObject ruleRoster() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_who_1_0 = null;

        EObject lv_players_4_0 = null;

        EObject lv_players_6_0 = null;



        	enterRule();

        try {
            // InternalGame.g:8521:2: ( (otherlv_0= 'roster' ( (lv_who_1_0= ruleTeamTypeEnum ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= '{' ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )? otherlv_7= '}' ) )
            // InternalGame.g:8522:2: (otherlv_0= 'roster' ( (lv_who_1_0= ruleTeamTypeEnum ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= '{' ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )? otherlv_7= '}' )
            {
            // InternalGame.g:8522:2: (otherlv_0= 'roster' ( (lv_who_1_0= ruleTeamTypeEnum ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= '{' ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )? otherlv_7= '}' )
            // InternalGame.g:8523:3: otherlv_0= 'roster' ( (lv_who_1_0= ruleTeamTypeEnum ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= '{' ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,138,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getRosterAccess().getRosterKeyword_0());
            		
            // InternalGame.g:8527:3: ( (lv_who_1_0= ruleTeamTypeEnum ) )
            // InternalGame.g:8528:4: (lv_who_1_0= ruleTeamTypeEnum )
            {
            // InternalGame.g:8528:4: (lv_who_1_0= ruleTeamTypeEnum )
            // InternalGame.g:8529:5: lv_who_1_0= ruleTeamTypeEnum
            {

            					newCompositeNode(grammarAccess.getRosterAccess().getWhoTeamTypeEnumParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_who_1_0=ruleTeamTypeEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRosterRule());
            					}
            					set(
            						current,
            						"who",
            						lv_who_1_0,
            						"org.bpy.score.game.Game.TeamTypeEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGame.g:8546:3: ( (lv_name_2_0= RULE_STRING ) )
            // InternalGame.g:8547:4: (lv_name_2_0= RULE_STRING )
            {
            // InternalGame.g:8547:4: (lv_name_2_0= RULE_STRING )
            // InternalGame.g:8548:5: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_2_0, grammarAccess.getRosterAccess().getNameSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRosterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,90,FOLLOW_114); 

            			newLeafNode(otherlv_3, grammarAccess.getRosterAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalGame.g:8568:3: ( ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )* )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==116) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalGame.g:8569:4: ( (lv_players_4_0= rulePlayer ) ) (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )*
                    {
                    // InternalGame.g:8569:4: ( (lv_players_4_0= rulePlayer ) )
                    // InternalGame.g:8570:5: (lv_players_4_0= rulePlayer )
                    {
                    // InternalGame.g:8570:5: (lv_players_4_0= rulePlayer )
                    // InternalGame.g:8571:6: lv_players_4_0= rulePlayer
                    {

                    						newCompositeNode(grammarAccess.getRosterAccess().getPlayersPlayerParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_players_4_0=rulePlayer();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRosterRule());
                    						}
                    						add(
                    							current,
                    							"players",
                    							lv_players_4_0,
                    							"org.bpy.score.game.Game.Player");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGame.g:8588:4: (otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) ) )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==109) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // InternalGame.g:8589:5: otherlv_5= ',' ( (lv_players_6_0= rulePlayer ) )
                    	    {
                    	    otherlv_5=(Token)match(input,109,FOLLOW_115); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getRosterAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalGame.g:8593:5: ( (lv_players_6_0= rulePlayer ) )
                    	    // InternalGame.g:8594:6: (lv_players_6_0= rulePlayer )
                    	    {
                    	    // InternalGame.g:8594:6: (lv_players_6_0= rulePlayer )
                    	    // InternalGame.g:8595:7: lv_players_6_0= rulePlayer
                    	    {

                    	    							newCompositeNode(grammarAccess.getRosterAccess().getPlayersPlayerParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_26);
                    	    lv_players_6_0=rulePlayer();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRosterRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"players",
                    	    								lv_players_6_0,
                    	    								"org.bpy.score.game.Game.Player");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop134;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRosterAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoster"


    // $ANTLR start "entryRulePlayer"
    // InternalGame.g:8622:1: entryRulePlayer returns [EObject current=null] : iv_rulePlayer= rulePlayer EOF ;
    public final EObject entryRulePlayer() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlayer = null;


        try {
            // InternalGame.g:8622:47: (iv_rulePlayer= rulePlayer EOF )
            // InternalGame.g:8623:2: iv_rulePlayer= rulePlayer EOF
            {
             newCompositeNode(grammarAccess.getPlayerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlayer=rulePlayer();

            state._fsp--;

             current =iv_rulePlayer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlayer"


    // $ANTLR start "rulePlayer"
    // InternalGame.g:8629:1: rulePlayer returns [EObject current=null] : (otherlv_0= 'player' ( (lv_playerName_1_0= RULE_STRING ) ) ) ;
    public final EObject rulePlayer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_playerName_1_0=null;


        	enterRule();

        try {
            // InternalGame.g:8635:2: ( (otherlv_0= 'player' ( (lv_playerName_1_0= RULE_STRING ) ) ) )
            // InternalGame.g:8636:2: (otherlv_0= 'player' ( (lv_playerName_1_0= RULE_STRING ) ) )
            {
            // InternalGame.g:8636:2: (otherlv_0= 'player' ( (lv_playerName_1_0= RULE_STRING ) ) )
            // InternalGame.g:8637:3: otherlv_0= 'player' ( (lv_playerName_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,116,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPlayerAccess().getPlayerKeyword_0());
            		
            // InternalGame.g:8641:3: ( (lv_playerName_1_0= RULE_STRING ) )
            // InternalGame.g:8642:4: (lv_playerName_1_0= RULE_STRING )
            {
            // InternalGame.g:8642:4: (lv_playerName_1_0= RULE_STRING )
            // InternalGame.g:8643:5: lv_playerName_1_0= RULE_STRING
            {
            lv_playerName_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_playerName_1_0, grammarAccess.getPlayerAccess().getPlayerNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlayerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"playerName",
            						lv_playerName_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlayer"


    // $ANTLR start "entryRuleDescription"
    // InternalGame.g:8663:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // InternalGame.g:8663:52: (iv_ruleDescription= ruleDescription EOF )
            // InternalGame.g:8664:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // InternalGame.g:8670:1: ruleDescription returns [EObject current=null] : (otherlv_0= 'header' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) ) otherlv_42= '}' ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_tournament_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_stadium_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_place_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_date_17_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token lv_startTime_21_0=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token lv_endTime_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token lv_duration_29_0=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token lv_category_33_0=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_42=null;
        AntlrDatatypeRuleToken lv_type_37_0 = null;

        EObject lv_umpires_39_0 = null;

        EObject lv_scorekeepers_40_0 = null;

        EObject lv_notes_41_0 = null;



        	enterRule();

        try {
            // InternalGame.g:8676:2: ( (otherlv_0= 'header' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) ) otherlv_42= '}' ) )
            // InternalGame.g:8677:2: (otherlv_0= 'header' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) ) otherlv_42= '}' )
            {
            // InternalGame.g:8677:2: (otherlv_0= 'header' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) ) otherlv_42= '}' )
            // InternalGame.g:8678:3: otherlv_0= 'header' otherlv_1= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) ) otherlv_42= '}'
            {
            otherlv_0=(Token)match(input,139,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getHeaderKeyword_0());
            		
            otherlv_1=(Token)match(input,90,FOLLOW_116); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalGame.g:8686:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) ) )
            // InternalGame.g:8687:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) )
            {
            // InternalGame.g:8687:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?) )
            // InternalGame.g:8688:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            				
            // InternalGame.g:8691:5: ( ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?)
            // InternalGame.g:8692:6: ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+ {...}?
            {
            // InternalGame.g:8692:6: ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+
            int cnt136=0;
            loop136:
            do {
                int alt136=13;
                alt136 = dfa136.predict(input);
                switch (alt136) {
            	case 1 :
            	    // InternalGame.g:8693:4: ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8693:4: ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) )
            	    // InternalGame.g:8694:5: {...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalGame.g:8694:108: ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) )
            	    // InternalGame.g:8695:6: ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalGame.g:8698:9: ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) )
            	    // InternalGame.g:8698:10: {...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8698:19: (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' )
            	    // InternalGame.g:8698:20: otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';'
            	    {
            	    otherlv_3=(Token)match(input,140,FOLLOW_15); 

            	    									newLeafNode(otherlv_3, grammarAccess.getDescriptionAccess().getTournamentKeyword_2_0_0());
            	    								
            	    otherlv_4=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_4, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_0_1());
            	    								
            	    // InternalGame.g:8706:9: ( (lv_tournament_5_0= RULE_STRING ) )
            	    // InternalGame.g:8707:10: (lv_tournament_5_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8707:10: (lv_tournament_5_0= RULE_STRING )
            	    // InternalGame.g:8708:11: lv_tournament_5_0= RULE_STRING
            	    {
            	    lv_tournament_5_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_tournament_5_0, grammarAccess.getDescriptionAccess().getTournamentSTRINGTerminalRuleCall_2_0_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"tournament",
            	    												lv_tournament_5_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_6=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_6, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_0_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGame.g:8734:4: ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8734:4: ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) )
            	    // InternalGame.g:8735:5: {...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalGame.g:8735:108: ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) )
            	    // InternalGame.g:8736:6: ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalGame.g:8739:9: ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) )
            	    // InternalGame.g:8739:10: {...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8739:19: (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' )
            	    // InternalGame.g:8739:20: otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';'
            	    {
            	    otherlv_7=(Token)match(input,141,FOLLOW_15); 

            	    									newLeafNode(otherlv_7, grammarAccess.getDescriptionAccess().getStadiumKeyword_2_1_0());
            	    								
            	    otherlv_8=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_8, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_1_1());
            	    								
            	    // InternalGame.g:8747:9: ( (lv_stadium_9_0= RULE_STRING ) )
            	    // InternalGame.g:8748:10: (lv_stadium_9_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8748:10: (lv_stadium_9_0= RULE_STRING )
            	    // InternalGame.g:8749:11: lv_stadium_9_0= RULE_STRING
            	    {
            	    lv_stadium_9_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_stadium_9_0, grammarAccess.getDescriptionAccess().getStadiumSTRINGTerminalRuleCall_2_1_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"stadium",
            	    												lv_stadium_9_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_10=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_10, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_1_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalGame.g:8775:4: ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8775:4: ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) )
            	    // InternalGame.g:8776:5: {...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalGame.g:8776:108: ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) )
            	    // InternalGame.g:8777:6: ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalGame.g:8780:9: ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) )
            	    // InternalGame.g:8780:10: {...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8780:19: (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' )
            	    // InternalGame.g:8780:20: otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';'
            	    {
            	    otherlv_11=(Token)match(input,142,FOLLOW_15); 

            	    									newLeafNode(otherlv_11, grammarAccess.getDescriptionAccess().getPlaceKeyword_2_2_0());
            	    								
            	    otherlv_12=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_12, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_2_1());
            	    								
            	    // InternalGame.g:8788:9: ( (lv_place_13_0= RULE_STRING ) )
            	    // InternalGame.g:8789:10: (lv_place_13_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8789:10: (lv_place_13_0= RULE_STRING )
            	    // InternalGame.g:8790:11: lv_place_13_0= RULE_STRING
            	    {
            	    lv_place_13_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_place_13_0, grammarAccess.getDescriptionAccess().getPlaceSTRINGTerminalRuleCall_2_2_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"place",
            	    												lv_place_13_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_14=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_14, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_2_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalGame.g:8816:4: ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8816:4: ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) )
            	    // InternalGame.g:8817:5: {...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalGame.g:8817:108: ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) )
            	    // InternalGame.g:8818:6: ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalGame.g:8821:9: ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) )
            	    // InternalGame.g:8821:10: {...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8821:19: (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' )
            	    // InternalGame.g:8821:20: otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';'
            	    {
            	    otherlv_15=(Token)match(input,143,FOLLOW_15); 

            	    									newLeafNode(otherlv_15, grammarAccess.getDescriptionAccess().getDateKeyword_2_3_0());
            	    								
            	    otherlv_16=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_16, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_3_1());
            	    								
            	    // InternalGame.g:8829:9: ( (lv_date_17_0= RULE_STRING ) )
            	    // InternalGame.g:8830:10: (lv_date_17_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8830:10: (lv_date_17_0= RULE_STRING )
            	    // InternalGame.g:8831:11: lv_date_17_0= RULE_STRING
            	    {
            	    lv_date_17_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_date_17_0, grammarAccess.getDescriptionAccess().getDateSTRINGTerminalRuleCall_2_3_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"date",
            	    												lv_date_17_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_18=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_18, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_3_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalGame.g:8857:4: ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8857:4: ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) )
            	    // InternalGame.g:8858:5: {...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // InternalGame.g:8858:108: ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) )
            	    // InternalGame.g:8859:6: ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 4);
            	    					
            	    // InternalGame.g:8862:9: ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) )
            	    // InternalGame.g:8862:10: {...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8862:19: (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' )
            	    // InternalGame.g:8862:20: otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';'
            	    {
            	    otherlv_19=(Token)match(input,144,FOLLOW_15); 

            	    									newLeafNode(otherlv_19, grammarAccess.getDescriptionAccess().getStartTimeKeyword_2_4_0());
            	    								
            	    otherlv_20=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_20, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_4_1());
            	    								
            	    // InternalGame.g:8870:9: ( (lv_startTime_21_0= RULE_STRING ) )
            	    // InternalGame.g:8871:10: (lv_startTime_21_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8871:10: (lv_startTime_21_0= RULE_STRING )
            	    // InternalGame.g:8872:11: lv_startTime_21_0= RULE_STRING
            	    {
            	    lv_startTime_21_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_startTime_21_0, grammarAccess.getDescriptionAccess().getStartTimeSTRINGTerminalRuleCall_2_4_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"startTime",
            	    												lv_startTime_21_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_22=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_22, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_4_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalGame.g:8898:4: ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8898:4: ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) )
            	    // InternalGame.g:8899:5: {...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 5)");
            	    }
            	    // InternalGame.g:8899:108: ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) )
            	    // InternalGame.g:8900:6: ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 5);
            	    					
            	    // InternalGame.g:8903:9: ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) )
            	    // InternalGame.g:8903:10: {...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8903:19: (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' )
            	    // InternalGame.g:8903:20: otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';'
            	    {
            	    otherlv_23=(Token)match(input,145,FOLLOW_15); 

            	    									newLeafNode(otherlv_23, grammarAccess.getDescriptionAccess().getEndTimeKeyword_2_5_0());
            	    								
            	    otherlv_24=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_24, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_5_1());
            	    								
            	    // InternalGame.g:8911:9: ( (lv_endTime_25_0= RULE_STRING ) )
            	    // InternalGame.g:8912:10: (lv_endTime_25_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8912:10: (lv_endTime_25_0= RULE_STRING )
            	    // InternalGame.g:8913:11: lv_endTime_25_0= RULE_STRING
            	    {
            	    lv_endTime_25_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_endTime_25_0, grammarAccess.getDescriptionAccess().getEndTimeSTRINGTerminalRuleCall_2_5_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"endTime",
            	    												lv_endTime_25_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_26=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_26, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_5_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalGame.g:8939:4: ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8939:4: ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) )
            	    // InternalGame.g:8940:5: {...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 6)");
            	    }
            	    // InternalGame.g:8940:108: ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) )
            	    // InternalGame.g:8941:6: ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 6);
            	    					
            	    // InternalGame.g:8944:9: ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) )
            	    // InternalGame.g:8944:10: {...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8944:19: (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' )
            	    // InternalGame.g:8944:20: otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';'
            	    {
            	    otherlv_27=(Token)match(input,146,FOLLOW_15); 

            	    									newLeafNode(otherlv_27, grammarAccess.getDescriptionAccess().getDurationKeyword_2_6_0());
            	    								
            	    otherlv_28=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_28, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_6_1());
            	    								
            	    // InternalGame.g:8952:9: ( (lv_duration_29_0= RULE_STRING ) )
            	    // InternalGame.g:8953:10: (lv_duration_29_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8953:10: (lv_duration_29_0= RULE_STRING )
            	    // InternalGame.g:8954:11: lv_duration_29_0= RULE_STRING
            	    {
            	    lv_duration_29_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_duration_29_0, grammarAccess.getDescriptionAccess().getDurationSTRINGTerminalRuleCall_2_6_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"duration",
            	    												lv_duration_29_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_30=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_30, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_6_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalGame.g:8980:4: ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) )
            	    {
            	    // InternalGame.g:8980:4: ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) )
            	    // InternalGame.g:8981:5: {...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 7)");
            	    }
            	    // InternalGame.g:8981:108: ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) )
            	    // InternalGame.g:8982:6: ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 7);
            	    					
            	    // InternalGame.g:8985:9: ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) )
            	    // InternalGame.g:8985:10: {...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:8985:19: (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' )
            	    // InternalGame.g:8985:20: otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';'
            	    {
            	    otherlv_31=(Token)match(input,147,FOLLOW_15); 

            	    									newLeafNode(otherlv_31, grammarAccess.getDescriptionAccess().getCategoryKeyword_2_7_0());
            	    								
            	    otherlv_32=(Token)match(input,97,FOLLOW_3); 

            	    									newLeafNode(otherlv_32, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_7_1());
            	    								
            	    // InternalGame.g:8993:9: ( (lv_category_33_0= RULE_STRING ) )
            	    // InternalGame.g:8994:10: (lv_category_33_0= RULE_STRING )
            	    {
            	    // InternalGame.g:8994:10: (lv_category_33_0= RULE_STRING )
            	    // InternalGame.g:8995:11: lv_category_33_0= RULE_STRING
            	    {
            	    lv_category_33_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    											newLeafNode(lv_category_33_0, grammarAccess.getDescriptionAccess().getCategorySTRINGTerminalRuleCall_2_7_2_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getDescriptionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"category",
            	    												lv_category_33_0,
            	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    										

            	    }


            	    }

            	    otherlv_34=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_34, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_7_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalGame.g:9021:4: ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) )
            	    {
            	    // InternalGame.g:9021:4: ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) )
            	    // InternalGame.g:9022:5: {...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 8)");
            	    }
            	    // InternalGame.g:9022:108: ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) )
            	    // InternalGame.g:9023:6: ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 8);
            	    					
            	    // InternalGame.g:9026:9: ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) )
            	    // InternalGame.g:9026:10: {...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:9026:19: (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' )
            	    // InternalGame.g:9026:20: otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';'
            	    {
            	    otherlv_35=(Token)match(input,148,FOLLOW_15); 

            	    									newLeafNode(otherlv_35, grammarAccess.getDescriptionAccess().getTypeKeyword_2_8_0());
            	    								
            	    otherlv_36=(Token)match(input,97,FOLLOW_118); 

            	    									newLeafNode(otherlv_36, grammarAccess.getDescriptionAccess().getEqualsSignKeyword_2_8_1());
            	    								
            	    // InternalGame.g:9034:9: ( (lv_type_37_0= ruleGameTypeEnum ) )
            	    // InternalGame.g:9035:10: (lv_type_37_0= ruleGameTypeEnum )
            	    {
            	    // InternalGame.g:9035:10: (lv_type_37_0= ruleGameTypeEnum )
            	    // InternalGame.g:9036:11: lv_type_37_0= ruleGameTypeEnum
            	    {

            	    											newCompositeNode(grammarAccess.getDescriptionAccess().getTypeGameTypeEnumParserRuleCall_2_8_2_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    lv_type_37_0=ruleGameTypeEnum();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"type",
            	    												lv_type_37_0,
            	    												"org.bpy.score.game.Game.GameTypeEnum");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_38=(Token)match(input,93,FOLLOW_117); 

            	    									newLeafNode(otherlv_38, grammarAccess.getDescriptionAccess().getSemicolonKeyword_2_8_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalGame.g:9063:4: ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) )
            	    {
            	    // InternalGame.g:9063:4: ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) )
            	    // InternalGame.g:9064:5: {...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 9)");
            	    }
            	    // InternalGame.g:9064:108: ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) )
            	    // InternalGame.g:9065:6: ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 9);
            	    					
            	    // InternalGame.g:9068:9: ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) )
            	    // InternalGame.g:9068:10: {...}? => ( (lv_umpires_39_0= ruleUmpires ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:9068:19: ( (lv_umpires_39_0= ruleUmpires ) )
            	    // InternalGame.g:9068:20: (lv_umpires_39_0= ruleUmpires )
            	    {
            	    // InternalGame.g:9068:20: (lv_umpires_39_0= ruleUmpires )
            	    // InternalGame.g:9069:10: lv_umpires_39_0= ruleUmpires
            	    {

            	    										newCompositeNode(grammarAccess.getDescriptionAccess().getUmpiresUmpiresParserRuleCall_2_9_0());
            	    									
            	    pushFollow(FOLLOW_117);
            	    lv_umpires_39_0=ruleUmpires();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"umpires",
            	    											lv_umpires_39_0,
            	    											"org.bpy.score.game.Game.Umpires");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalGame.g:9091:4: ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) )
            	    {
            	    // InternalGame.g:9091:4: ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) )
            	    // InternalGame.g:9092:5: {...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 10)");
            	    }
            	    // InternalGame.g:9092:109: ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) )
            	    // InternalGame.g:9093:6: ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 10);
            	    					
            	    // InternalGame.g:9096:9: ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) )
            	    // InternalGame.g:9096:10: {...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:9096:19: ( (lv_scorekeepers_40_0= ruleScoreKeepers ) )
            	    // InternalGame.g:9096:20: (lv_scorekeepers_40_0= ruleScoreKeepers )
            	    {
            	    // InternalGame.g:9096:20: (lv_scorekeepers_40_0= ruleScoreKeepers )
            	    // InternalGame.g:9097:10: lv_scorekeepers_40_0= ruleScoreKeepers
            	    {

            	    										newCompositeNode(grammarAccess.getDescriptionAccess().getScorekeepersScoreKeepersParserRuleCall_2_10_0());
            	    									
            	    pushFollow(FOLLOW_117);
            	    lv_scorekeepers_40_0=ruleScoreKeepers();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"scorekeepers",
            	    											lv_scorekeepers_40_0,
            	    											"org.bpy.score.game.Game.ScoreKeepers");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalGame.g:9119:4: ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) )
            	    {
            	    // InternalGame.g:9119:4: ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) )
            	    // InternalGame.g:9120:5: {...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 11)");
            	    }
            	    // InternalGame.g:9120:109: ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) )
            	    // InternalGame.g:9121:6: ({...}? => ( (lv_notes_41_0= ruleNotes ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 11);
            	    					
            	    // InternalGame.g:9124:9: ({...}? => ( (lv_notes_41_0= ruleNotes ) ) )
            	    // InternalGame.g:9124:10: {...}? => ( (lv_notes_41_0= ruleNotes ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleDescription", "true");
            	    }
            	    // InternalGame.g:9124:19: ( (lv_notes_41_0= ruleNotes ) )
            	    // InternalGame.g:9124:20: (lv_notes_41_0= ruleNotes )
            	    {
            	    // InternalGame.g:9124:20: (lv_notes_41_0= ruleNotes )
            	    // InternalGame.g:9125:10: lv_notes_41_0= ruleNotes
            	    {

            	    										newCompositeNode(grammarAccess.getDescriptionAccess().getNotesNotesParserRuleCall_2_11_0());
            	    									
            	    pushFollow(FOLLOW_117);
            	    lv_notes_41_0=ruleNotes();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"notes",
            	    											lv_notes_41_0,
            	    											"org.bpy.score.game.Game.Notes");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt136 >= 1 ) break loop136;
                        EarlyExitException eee =
                            new EarlyExitException(136, input);
                        throw eee;
                }
                cnt136++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getDescriptionAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleDescription", "getUnorderedGroupHelper().canLeave(grammarAccess.getDescriptionAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getDescriptionAccess().getUnorderedGroup_2());
            				

            }

            otherlv_42=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_42, grammarAccess.getDescriptionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleNotes"
    // InternalGame.g:9163:1: entryRuleNotes returns [EObject current=null] : iv_ruleNotes= ruleNotes EOF ;
    public final EObject entryRuleNotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotes = null;


        try {
            // InternalGame.g:9163:46: (iv_ruleNotes= ruleNotes EOF )
            // InternalGame.g:9164:2: iv_ruleNotes= ruleNotes EOF
            {
             newCompositeNode(grammarAccess.getNotesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotes=ruleNotes();

            state._fsp--;

             current =iv_ruleNotes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotes"


    // $ANTLR start "ruleNotes"
    // InternalGame.g:9170:1: ruleNotes returns [EObject current=null] : (otherlv_0= 'notes' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleNotes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_notes_2_0=null;
        Token otherlv_3=null;
        Token lv_notess_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalGame.g:9176:2: ( (otherlv_0= 'notes' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) )
            // InternalGame.g:9177:2: (otherlv_0= 'notes' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            {
            // InternalGame.g:9177:2: (otherlv_0= 'notes' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            // InternalGame.g:9178:3: otherlv_0= 'notes' otherlv_1= '=' ( (lv_notes_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,149,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getNotesAccess().getNotesKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNotesAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:9186:3: ( (lv_notes_2_0= RULE_STRING ) )
            // InternalGame.g:9187:4: (lv_notes_2_0= RULE_STRING )
            {
            // InternalGame.g:9187:4: (lv_notes_2_0= RULE_STRING )
            // InternalGame.g:9188:5: lv_notes_2_0= RULE_STRING
            {
            lv_notes_2_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            					newLeafNode(lv_notes_2_0, grammarAccess.getNotesAccess().getNotesSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNotesRule());
            					}
            					addWithLastConsumed(
            						current,
            						"notes",
            						lv_notes_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGame.g:9204:3: (otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) ) )*
            loop137:
            do {
                int alt137=2;
                int LA137_0 = input.LA(1);

                if ( (LA137_0==109) ) {
                    alt137=1;
                }


                switch (alt137) {
            	case 1 :
            	    // InternalGame.g:9205:4: otherlv_3= ',' ( (lv_notess_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,109,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getNotesAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalGame.g:9209:4: ( (lv_notess_4_0= RULE_STRING ) )
            	    // InternalGame.g:9210:5: (lv_notess_4_0= RULE_STRING )
            	    {
            	    // InternalGame.g:9210:5: (lv_notess_4_0= RULE_STRING )
            	    // InternalGame.g:9211:6: lv_notess_4_0= RULE_STRING
            	    {
            	    lv_notess_4_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            	    						newLeafNode(lv_notess_4_0, grammarAccess.getNotesAccess().getNotessSTRINGTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getNotesRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"notess",
            	    							lv_notess_4_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop137;
                }
            } while (true);

            otherlv_5=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getNotesAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotes"


    // $ANTLR start "entryRuleScoreKeepers"
    // InternalGame.g:9236:1: entryRuleScoreKeepers returns [EObject current=null] : iv_ruleScoreKeepers= ruleScoreKeepers EOF ;
    public final EObject entryRuleScoreKeepers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScoreKeepers = null;


        try {
            // InternalGame.g:9236:53: (iv_ruleScoreKeepers= ruleScoreKeepers EOF )
            // InternalGame.g:9237:2: iv_ruleScoreKeepers= ruleScoreKeepers EOF
            {
             newCompositeNode(grammarAccess.getScoreKeepersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScoreKeepers=ruleScoreKeepers();

            state._fsp--;

             current =iv_ruleScoreKeepers; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScoreKeepers"


    // $ANTLR start "ruleScoreKeepers"
    // InternalGame.g:9243:1: ruleScoreKeepers returns [EObject current=null] : (otherlv_0= 'scorekeepers' otherlv_1= '=' ( (lv_scorekeepers_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleScoreKeepers() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_scorekeepers_2_0=null;
        Token otherlv_3=null;
        Token lv_scorekeepers_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalGame.g:9249:2: ( (otherlv_0= 'scorekeepers' otherlv_1= '=' ( (lv_scorekeepers_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) )
            // InternalGame.g:9250:2: (otherlv_0= 'scorekeepers' otherlv_1= '=' ( (lv_scorekeepers_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            {
            // InternalGame.g:9250:2: (otherlv_0= 'scorekeepers' otherlv_1= '=' ( (lv_scorekeepers_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            // InternalGame.g:9251:3: otherlv_0= 'scorekeepers' otherlv_1= '=' ( (lv_scorekeepers_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,150,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getScoreKeepersAccess().getScorekeepersKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getScoreKeepersAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:9259:3: ( (lv_scorekeepers_2_0= RULE_STRING ) )
            // InternalGame.g:9260:4: (lv_scorekeepers_2_0= RULE_STRING )
            {
            // InternalGame.g:9260:4: (lv_scorekeepers_2_0= RULE_STRING )
            // InternalGame.g:9261:5: lv_scorekeepers_2_0= RULE_STRING
            {
            lv_scorekeepers_2_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            					newLeafNode(lv_scorekeepers_2_0, grammarAccess.getScoreKeepersAccess().getScorekeepersSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScoreKeepersRule());
            					}
            					addWithLastConsumed(
            						current,
            						"scorekeepers",
            						lv_scorekeepers_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGame.g:9277:3: (otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) ) )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==109) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // InternalGame.g:9278:4: otherlv_3= ',' ( (lv_scorekeepers_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,109,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getScoreKeepersAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalGame.g:9282:4: ( (lv_scorekeepers_4_0= RULE_STRING ) )
            	    // InternalGame.g:9283:5: (lv_scorekeepers_4_0= RULE_STRING )
            	    {
            	    // InternalGame.g:9283:5: (lv_scorekeepers_4_0= RULE_STRING )
            	    // InternalGame.g:9284:6: lv_scorekeepers_4_0= RULE_STRING
            	    {
            	    lv_scorekeepers_4_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            	    						newLeafNode(lv_scorekeepers_4_0, grammarAccess.getScoreKeepersAccess().getScorekeepersSTRINGTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getScoreKeepersRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"scorekeepers",
            	    							lv_scorekeepers_4_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop138;
                }
            } while (true);

            otherlv_5=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getScoreKeepersAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScoreKeepers"


    // $ANTLR start "entryRuleUmpires"
    // InternalGame.g:9309:1: entryRuleUmpires returns [EObject current=null] : iv_ruleUmpires= ruleUmpires EOF ;
    public final EObject entryRuleUmpires() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpires = null;


        try {
            // InternalGame.g:9309:48: (iv_ruleUmpires= ruleUmpires EOF )
            // InternalGame.g:9310:2: iv_ruleUmpires= ruleUmpires EOF
            {
             newCompositeNode(grammarAccess.getUmpiresRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUmpires=ruleUmpires();

            state._fsp--;

             current =iv_ruleUmpires; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUmpires"


    // $ANTLR start "ruleUmpires"
    // InternalGame.g:9316:1: ruleUmpires returns [EObject current=null] : (otherlv_0= 'umpires' otherlv_1= '=' ( (lv_umpires_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleUmpires() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_umpires_2_0=null;
        Token otherlv_3=null;
        Token lv_umpires_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalGame.g:9322:2: ( (otherlv_0= 'umpires' otherlv_1= '=' ( (lv_umpires_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )* otherlv_5= ';' ) )
            // InternalGame.g:9323:2: (otherlv_0= 'umpires' otherlv_1= '=' ( (lv_umpires_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            {
            // InternalGame.g:9323:2: (otherlv_0= 'umpires' otherlv_1= '=' ( (lv_umpires_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )* otherlv_5= ';' )
            // InternalGame.g:9324:3: otherlv_0= 'umpires' otherlv_1= '=' ( (lv_umpires_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,151,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getUmpiresAccess().getUmpiresKeyword_0());
            		
            otherlv_1=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUmpiresAccess().getEqualsSignKeyword_1());
            		
            // InternalGame.g:9332:3: ( (lv_umpires_2_0= RULE_STRING ) )
            // InternalGame.g:9333:4: (lv_umpires_2_0= RULE_STRING )
            {
            // InternalGame.g:9333:4: (lv_umpires_2_0= RULE_STRING )
            // InternalGame.g:9334:5: lv_umpires_2_0= RULE_STRING
            {
            lv_umpires_2_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            					newLeafNode(lv_umpires_2_0, grammarAccess.getUmpiresAccess().getUmpiresSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUmpiresRule());
            					}
            					addWithLastConsumed(
            						current,
            						"umpires",
            						lv_umpires_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGame.g:9350:3: (otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==109) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalGame.g:9351:4: otherlv_3= ',' ( (lv_umpires_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,109,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getUmpiresAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalGame.g:9355:4: ( (lv_umpires_4_0= RULE_STRING ) )
            	    // InternalGame.g:9356:5: (lv_umpires_4_0= RULE_STRING )
            	    {
            	    // InternalGame.g:9356:5: (lv_umpires_4_0= RULE_STRING )
            	    // InternalGame.g:9357:6: lv_umpires_4_0= RULE_STRING
            	    {
            	    lv_umpires_4_0=(Token)match(input,RULE_STRING,FOLLOW_119); 

            	    						newLeafNode(lv_umpires_4_0, grammarAccess.getUmpiresAccess().getUmpiresSTRINGTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getUmpiresRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"umpires",
            	    							lv_umpires_4_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop139;
                }
            } while (true);

            otherlv_5=(Token)match(input,93,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getUmpiresAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUmpires"


    // $ANTLR start "entryRuleTeamTypeEnum"
    // InternalGame.g:9382:1: entryRuleTeamTypeEnum returns [String current=null] : iv_ruleTeamTypeEnum= ruleTeamTypeEnum EOF ;
    public final String entryRuleTeamTypeEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTeamTypeEnum = null;


        try {
            // InternalGame.g:9382:52: (iv_ruleTeamTypeEnum= ruleTeamTypeEnum EOF )
            // InternalGame.g:9383:2: iv_ruleTeamTypeEnum= ruleTeamTypeEnum EOF
            {
             newCompositeNode(grammarAccess.getTeamTypeEnumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTeamTypeEnum=ruleTeamTypeEnum();

            state._fsp--;

             current =iv_ruleTeamTypeEnum.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTeamTypeEnum"


    // $ANTLR start "ruleTeamTypeEnum"
    // InternalGame.g:9389:1: ruleTeamTypeEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'visitor' | kw= 'hometeam' ) ;
    public final AntlrDatatypeRuleToken ruleTeamTypeEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGame.g:9395:2: ( (kw= 'visitor' | kw= 'hometeam' ) )
            // InternalGame.g:9396:2: (kw= 'visitor' | kw= 'hometeam' )
            {
            // InternalGame.g:9396:2: (kw= 'visitor' | kw= 'hometeam' )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==152) ) {
                alt140=1;
            }
            else if ( (LA140_0==153) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalGame.g:9397:3: kw= 'visitor'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTeamTypeEnumAccess().getVisitorKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:9403:3: kw= 'hometeam'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTeamTypeEnumAccess().getHometeamKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTeamTypeEnum"


    // $ANTLR start "entryRuleGameTypeEnum"
    // InternalGame.g:9412:1: entryRuleGameTypeEnum returns [String current=null] : iv_ruleGameTypeEnum= ruleGameTypeEnum EOF ;
    public final String entryRuleGameTypeEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGameTypeEnum = null;


        try {
            // InternalGame.g:9412:52: (iv_ruleGameTypeEnum= ruleGameTypeEnum EOF )
            // InternalGame.g:9413:2: iv_ruleGameTypeEnum= ruleGameTypeEnum EOF
            {
             newCompositeNode(grammarAccess.getGameTypeEnumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGameTypeEnum=ruleGameTypeEnum();

            state._fsp--;

             current =iv_ruleGameTypeEnum.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGameTypeEnum"


    // $ANTLR start "ruleGameTypeEnum"
    // InternalGame.g:9419:1: ruleGameTypeEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'baseball' | kw= 'softball' ) ;
    public final AntlrDatatypeRuleToken ruleGameTypeEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGame.g:9425:2: ( (kw= 'baseball' | kw= 'softball' ) )
            // InternalGame.g:9426:2: (kw= 'baseball' | kw= 'softball' )
            {
            // InternalGame.g:9426:2: (kw= 'baseball' | kw= 'softball' )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==154) ) {
                alt141=1;
            }
            else if ( (LA141_0==155) ) {
                alt141=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalGame.g:9427:3: kw= 'baseball'
                    {
                    kw=(Token)match(input,154,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getGameTypeEnumAccess().getBaseballKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGame.g:9433:3: kw= 'softball'
                    {
                    kw=(Token)match(input,155,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getGameTypeEnumAccess().getSoftballKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGameTypeEnum"

    // Delegated rules


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA114 dfa114 = new DFA114(this);
    protected DFA119 dfa119 = new DFA119(this);
    protected DFA120 dfa120 = new DFA120(this);
    protected DFA124 dfa124 = new DFA124(this);
    protected DFA136 dfa136 = new DFA136(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\111\1\6\1\4\1\7\1\166\10\uffff\1\6";
    static final String dfa_3s = "\1\111\1\165\1\4\1\16\1\166\10\uffff\1\6";
    static final String dfa_4s = "\5\uffff\1\10\1\5\1\2\1\7\1\4\1\1\1\6\1\3\1\uffff";
    static final String dfa_5s = "\16\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\12\1\7\1\14\1\11\1\6\1\13\1\10\1\5",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1290:3: ( ( () ( (lv_runner_3_0= ruleCurrentRunner ) ) this_EXECUTE_4= RULE_EXECUTE ( (lv_actionCode_5_0= RULE_MUST_BE_OUT_ON_ERROR ) ) ) | ( () ( (lv_runner_7_0= ruleCurrentRunner ) ) this_EXECUTE_8= RULE_EXECUTE ( (lv_actionCode_9_0= RULE_ADVANCE_ON_ERROR ) ) ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_actionCode_13_0= RULE_PICK_OFF_WITH_ERROR ) ) ) | ( () ( (lv_runner_15_0= ruleCurrentRunner ) ) this_EXECUTE_16= RULE_EXECUTE ( (lv_actionCode_17_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ) | ( () ( (lv_runner_19_0= ruleCurrentRunner ) ) this_EXECUTE_20= RULE_EXECUTE ( (lv_actionCode_21_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_23_0= ruleCurrentRunner ) ) this_EXECUTE_24= RULE_EXECUTE ( (lv_actionCode_25_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_runner_27_0= ruleCurrentRunner ) ) this_EXECUTE_28= RULE_EXECUTE ( (lv_actionCode_29_0= RULE_EXTRA_ON_THROW_ERROR ) ) ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_actionCode_33_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ) )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\1\111\1\6\1\4\1\5\1\166\5\uffff\1\6";
    static final String dfa_9s = "\1\111\1\165\1\4\1\22\1\166\5\uffff\1\6";
    static final String dfa_10s = "\5\uffff\1\5\1\2\1\4\1\1\1\3\1\uffff";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\11\11\uffff\1\10\1\6\1\7\1\5",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1718:3: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerOut_3_0= RULE_CAUGTH_STEALING ) ) ) | ( () ( (lv_runner_5_0= ruleCurrentRunner ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_runnerOut_7_0= RULE_PICK_OFF ) ) ) | ( () ( (lv_runner_9_0= ruleCurrentRunner ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_runnerOut_11_0= RULE_INT ) ) ) | ( () ( (lv_runner_13_0= ruleCurrentRunner ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_runnerOut_15_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_runner_17_0= ruleCurrentRunner ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_runnerOut_19_0= RULE_APPEAL ) ) ) )";
        }
    }
    static final String dfa_13s = "\32\uffff";
    static final String dfa_14s = "\1\111\1\6\1\4\1\10\1\166\24\uffff\1\6";
    static final String dfa_15s = "\1\111\1\165\1\4\1\37\1\166\24\uffff\1\6";
    static final String dfa_16s = "\5\uffff\1\1\1\6\1\13\1\20\1\4\1\11\1\16\1\23\1\2\1\7\1\14\1\21\1\5\1\12\1\17\1\24\1\3\1\10\1\15\1\22\1\uffff";
    static final String dfa_17s = "\32\uffff}>";
    static final String[] dfa_18s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\15\1\16\1\26\1\13\1\23\1\10\1\20\4\uffff\1\5\1\25\1\11\1\21\1\6\1\12\1\22\1\7\1\17\1\27\1\30\1\14\1\24",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2006:2: ( ( () ( (lv_runner_1_0= ruleCurrentRunner ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_runnerAdvance_3_0= RULE_ADVANCE ) ) ( ( (lv_isEarned_4_1= 'earned' | lv_isEarned_4_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_6_0= ruleCurrentRunner ) ) this_EXECUTE_7= RULE_EXECUTE ( (lv_runnerAdvance_8_0= RULE_ADVANCE_ON_ERROR ) ) ( ( (lv_isEarned_9_1= 'earned' | lv_isEarned_9_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_11_0= ruleCurrentRunner ) ) this_EXECUTE_12= RULE_EXECUTE ( (lv_runnerAdvance_13_0= RULE_STOLEN_BASE ) ) ( ( (lv_isEarned_14_1= 'earned' | lv_isEarned_14_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_16_0= ruleCurrentRunner ) ) this_EXECUTE_17= RULE_EXECUTE ( (lv_runnerAdvance_18_0= RULE_WILD_PITCH ) ) ( ( (lv_isEarned_19_1= 'earned' | lv_isEarned_19_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_21_0= ruleCurrentRunner ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_runnerAdvance_23_0= RULE_PASS_BALL ) ) ( ( (lv_isEarned_24_1= 'earned' | lv_isEarned_24_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_26_0= ruleCurrentRunner ) ) this_EXECUTE_27= RULE_EXECUTE ( (lv_runnerAdvance_28_0= RULE_BALK ) ) ( ( (lv_isEarned_29_1= 'earned' | lv_isEarned_29_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_31_0= ruleCurrentRunner ) ) this_EXECUTE_32= RULE_EXECUTE ( (lv_runnerAdvance_33_0= RULE_PICK_OFF_WITH_ERROR ) ) ( ( (lv_isEarned_34_1= 'earned' | lv_isEarned_34_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_36_0= ruleCurrentRunner ) ) this_EXECUTE_37= RULE_EXECUTE ( (lv_runnerAdvance_38_0= RULE_CAUGTH_STEALING_WITH_ERROR ) ) ( ( (lv_isEarned_39_1= 'earned' | lv_isEarned_39_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_41_0= ruleCurrentRunner ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_runnerAdvance_43_0= RULE_FIELDER_CHOICE_WITH_PUTOUT ) ) ( ( (lv_isEarned_44_1= 'earned' | lv_isEarned_44_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_46_0= ruleCurrentRunner ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_runnerAdvance_48_0= RULE_NO_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_49_1= 'earned' | lv_isEarned_49_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_51_0= ruleCurrentRunner ) ) this_EXECUTE_52= RULE_EXECUTE ( (lv_runnerAdvance_53_0= RULE_DECISIVE_OBSTRUCTION ) ) ( ( (lv_isEarned_54_1= 'earned' | lv_isEarned_54_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_56_0= ruleCurrentRunner ) ) this_EXECUTE_57= RULE_EXECUTE ( (lv_runnerAdvance_58_0= RULE_ADVANCE_ON_THROW ) ) ( ( (lv_isEarned_59_1= 'earned' | lv_isEarned_59_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_61_0= ruleCurrentRunner ) ) this_EXECUTE_62= RULE_EXECUTE ( (lv_runnerAdvance_63_0= RULE_INDIFERENCE ) ) ( ( (lv_isEarned_64_1= 'earned' | lv_isEarned_64_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_66_0= ruleCurrentRunner ) ) this_EXECUTE_67= RULE_EXECUTE ( (lv_runnerAdvance_68_0= RULE_REACH_ON_THROW_ERROR ) ) ( ( (lv_isEarned_69_1= 'earned' | lv_isEarned_69_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_71_0= ruleCurrentRunner ) ) this_EXECUTE_72= RULE_EXECUTE ( (lv_runnerAdvance_73_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_74_1= 'earned' | lv_isEarned_74_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_76_0= ruleCurrentRunner ) ) this_EXECUTE_77= RULE_EXECUTE ( (lv_runnerAdvance_78_0= RULE_EXTRA_ON_THROW_ERROR ) ) ( ( (lv_isEarned_79_1= 'earned' | lv_isEarned_79_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_81_0= ruleCurrentRunner ) ) this_EXECUTE_82= RULE_EXECUTE ( (lv_runnerAdvance_83_0= RULE_EXTRA_ON_RECEIVE_ERROR ) ) ( ( (lv_isEarned_84_1= 'earned' | lv_isEarned_84_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_86_0= ruleCurrentRunner ) ) this_EXECUTE_87= RULE_EXECUTE ( (lv_runnerAdvance_88_0= RULE_ADVANCE_BY_RULE ) ) ( ( (lv_isEarned_89_1= 'earned' | lv_isEarned_89_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_91_0= ruleCurrentRunner ) ) this_EXECUTE_92= RULE_EXECUTE ( (lv_runnerAdvance_93_0= RULE_ADVANCE_BY_OTHER_PLAYER_EROR ) ) ( ( (lv_isEarned_94_1= 'earned' | lv_isEarned_94_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_runner_96_0= ruleCurrentRunner ) ) this_EXECUTE_97= RULE_EXECUTE ( (lv_runnerAdvance_98_0= RULE_FIELDER_CHOICE ) ) ( ( (lv_isEarned_99_1= 'earned' | lv_isEarned_99_2= 'unEarnedForTeam' ) ) )? ) )";
        }
    }
    static final String dfa_19s = "\1\110\1\6\1\4\1\5\1\166\5\uffff\1\6";
    static final String dfa_20s = "\1\110\1\165\1\4\1\107\1\166\5\uffff\1\6";
    static final String dfa_21s = "\5\uffff\1\1\1\2\1\4\1\3\1\5\1\uffff";
    static final String[] dfa_22s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\5\1\uffff\1\7\3\uffff\2\6\4\uffff\2\5\4\uffff\1\11\1\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\6\1\uffff\1\10\1\uffff\27\6\16\5",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_19;
            this.max = dfa_20;
            this.accept = dfa_21;
            this.special = dfa_11;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "4034:2: (this_BatterOut_0= ruleBatterOut | this_BatterAdvance_1= ruleBatterAdvance | this_BatterLostTurn_2= ruleBatterLostTurn | this_BatterMustOutOnFlyFoulBall_3= ruleBatterMustOutOnFlyFoulBall | this_BatterBalk_4= ruleBatterBalk )";
        }
    }
    static final String dfa_23s = "\12\uffff";
    static final String dfa_24s = "\1\110\1\6\1\4\1\13\1\166\4\uffff\1\6";
    static final String dfa_25s = "\1\110\1\165\1\4\1\71\1\166\4\uffff\1\6";
    static final String dfa_26s = "\5\uffff\1\3\1\2\1\1\1\4\1\uffff";
    static final String dfa_27s = "\12\uffff}>";
    static final String[] dfa_28s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\2\6\13\uffff\1\10\1\uffff\1\5\1\uffff\1\10\2\uffff\1\10\3\uffff\17\5\5\7\3\6",
            "\1\11",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_23;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "4299:3: (this_Hit_0= ruleHit | this_DecisiveError_1= ruleDecisiveError | this_OtherBatterAdvance_2= ruleOtherBatterAdvance | this_DefensiveChoiceForBatter_3= ruleDefensiveChoiceForBatter )";
        }
    }
    static final String dfa_29s = "\25\uffff";
    static final String dfa_30s = "\1\110\1\6\1\4\1\32\1\166\17\uffff\1\6";
    static final String dfa_31s = "\1\110\1\165\1\4\1\61\1\166\17\uffff\1\6";
    static final String dfa_32s = "\5\uffff\1\4\1\11\1\3\1\10\1\17\1\2\1\7\1\16\1\14\1\1\1\6\1\15\1\13\1\5\1\12\1\uffff";
    static final String dfa_33s = "\25\uffff}>";
    static final String[] dfa_34s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\20\10\uffff\1\16\1\12\1\7\1\5\1\22\1\17\1\13\1\10\1\6\1\23\1\21\2\15\1\14\1\11",
            "\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA114 extends DFA {

        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = dfa_29;
            this.eof = dfa_29;
            this.min = dfa_30;
            this.max = dfa_31;
            this.accept = dfa_32;
            this.special = dfa_33;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5618:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_INTENTIONAL_BASE_ON_BALL ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_HIT_BY_PITCH ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_K_PASS_BALL ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_K_WILD_PITCH ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterAdvance_23_0= RULE_K_ADVANCE_BY_RULE ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterAdvance_27_0= RULE_K_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_29_0= ruleCurrentBatter ) ) this_EXECUTE_30= RULE_EXECUTE ( (lv_batterAdvance_31_0= RULE_SACRIFICE_BUNT_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_33_0= ruleCurrentBatter ) ) this_EXECUTE_34= RULE_EXECUTE ( (lv_batterAdvance_35_0= RULE_SACRIFICE_BUNT_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_37_0= ruleCurrentBatter ) ) this_EXECUTE_38= RULE_EXECUTE ( (lv_batterAdvance_39_0= RULE_SACRIFICE_FLY_WITH_ERROR ) ) ) | ( () ( (lv_currentBatter_41_0= ruleCurrentBatter ) ) this_EXECUTE_42= RULE_EXECUTE ( (lv_batterAdvance_43_0= RULE_SACRIFICE_FLY_WITH_FIELDER_CHOICE ) ) ) | ( () ( (lv_currentBatter_45_0= ruleCurrentBatter ) ) this_EXECUTE_46= RULE_EXECUTE ( ( (lv_batterAdvance_47_0= RULE_CATCHER_INTERFERENCE ) ) | ( (lv_batterAdvance_48_0= RULE_INTERFERENCE ) ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterAdvance_52_0= RULE_DECISIVE_OBSTRUCTION ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterAdvance_56_0= RULE_K_ADVANCE_BY_FIELDER_CHOCE ) ) ) | ( () ( (lv_currentBatter_58_0= ruleCurrentBatter ) ) this_EXECUTE_59= RULE_EXECUTE ( (lv_batterAdvance_60_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_FIELDER_CHOICE ) ) ) )";
        }
    }
    static final String dfa_35s = "\1\110\1\6\1\4\1\62\1\166\5\uffff\1\6";
    static final String dfa_36s = "\1\110\1\165\1\4\1\66\1\166\5\uffff\1\6";
    static final String dfa_37s = "\5\uffff\1\1\1\3\1\2\1\5\1\4\1\uffff";
    static final String[] dfa_38s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\5\1\7\1\6\1\11\1\10",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_11;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "6422:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_hit_3_0= RULE_SINGLE ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_hit_7_0= RULE_DOUBLE ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_hit_11_0= RULE_TRIPLE ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_hit_15_0= RULE_HOMERUN ) ) ( ( (lv_isEarned_16_1= 'earned' | lv_isEarned_16_2= 'unEarnedForTeam' ) ) )? ) | ( () ( (lv_currentBatter_18_0= ruleCurrentBatter ) ) this_EXECUTE_19= RULE_EXECUTE ( (lv_hit_20_0= RULE_INSIDE_PARK ) ) ( ( (lv_isEarned_21_1= 'earned' | lv_isEarned_21_2= 'unEarnedForTeam' ) ) )? ) )";
        }
    }
    static final String dfa_39s = "\1\110\1\6\1\4\1\13\1\166\5\uffff\1\6";
    static final String dfa_40s = "\1\110\1\165\1\4\1\71\1\166\5\uffff\1\6";
    static final String dfa_41s = "\5\uffff\1\4\1\1\1\3\1\5\1\2\1\uffff";
    static final String[] dfa_42s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\5\1\7\52\uffff\1\6\1\11\1\10",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[][] dfa_42 = unpackEncodedStringArray(dfa_42s);

    class DFA120 extends DFA {

        public DFA120(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 120;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_11;
            this.transition = dfa_42;
        }
        public String getDescription() {
            return "6749:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterAdvance_3_0= RULE_REACH_ON_FLY_ERROR ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterAdvance_7_0= RULE_REACH_ON_POP_ERROR ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterAdvance_11_0= RULE_REACH_ON_RECEIVE_ERROR ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterAdvance_15_0= RULE_REACH_ON_THROW_ERROR ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterAdvance_19_0= RULE_GROUNDED_DOUBLE_PLAY_ADVANCE_WITH_ERROR ) ) ) )";
        }
    }
    static final String dfa_43s = "\24\uffff";
    static final String dfa_44s = "\1\110\1\6\1\4\1\5\1\166\16\uffff\1\6";
    static final String dfa_45s = "\1\110\1\165\1\4\1\104\1\166\16\uffff\1\6";
    static final String dfa_46s = "\5\uffff\1\4\1\13\1\3\1\12\1\2\1\11\1\7\1\16\1\1\1\10\1\6\1\15\1\5\1\14\1\uffff";
    static final String dfa_47s = "\24\uffff}>";
    static final String[] dfa_48s = {
            "\1\1",
            "\1\3\156\uffff\1\2",
            "\1\4",
            "\1\13\13\uffff\1\16\1\12\47\uffff\1\15\1\11\1\7\1\5\1\21\1\17\1\10\1\6\1\22\1\20\1\14",
            "\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3"
    };

    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final char[] dfa_44 = DFA.unpackEncodedStringToUnsignedChars(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final short[][] dfa_48 = unpackEncodedStringArray(dfa_48s);

    class DFA124 extends DFA {

        public DFA124(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 124;
            this.eot = dfa_43;
            this.eof = dfa_43;
            this.min = dfa_44;
            this.max = dfa_45;
            this.accept = dfa_46;
            this.special = dfa_47;
            this.transition = dfa_48;
        }
        public String getDescription() {
            return "7074:2: ( ( () ( (lv_currentBatter_1_0= ruleCurrentBatter ) ) this_EXECUTE_2= RULE_EXECUTE ( (lv_batterOut_3_0= RULE_FLYED_OUT ) ) ) | ( () ( (lv_currentBatter_5_0= ruleCurrentBatter ) ) this_EXECUTE_6= RULE_EXECUTE ( (lv_batterOut_7_0= RULE_LINE_OUT ) ) ) | ( () ( (lv_currentBatter_9_0= ruleCurrentBatter ) ) this_EXECUTE_10= RULE_EXECUTE ( (lv_batterOut_11_0= RULE_POPPED_OUT ) ) ) | ( () ( (lv_currentBatter_13_0= ruleCurrentBatter ) ) this_EXECUTE_14= RULE_EXECUTE ( (lv_batterOut_15_0= RULE_FLYED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_17_0= ruleCurrentBatter ) ) this_EXECUTE_18= RULE_EXECUTE ( (lv_batterOut_19_0= RULE_POPPED_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_21_0= ruleCurrentBatter ) ) this_EXECUTE_22= RULE_EXECUTE ( (lv_batterOut_23_0= RULE_LINE_FALLBALL_OUT ) ) ) | ( () ( (lv_currentBatter_25_0= ruleCurrentBatter ) ) this_EXECUTE_26= RULE_EXECUTE ( (lv_batterOut_27_0= RULE_INT ) ) ( (lv_isBunt_28_0= 'b' ) )? ) | ( () ( (lv_currentBatter_30_0= ruleCurrentBatter ) ) this_EXECUTE_31= RULE_EXECUTE ( (lv_batterOut_32_0= RULE_OUT_BY_RULE ) ) ) | ( () ( (lv_currentBatter_34_0= ruleCurrentBatter ) ) this_EXECUTE_35= RULE_EXECUTE ( (lv_batterOut_36_0= RULE_APPEAL ) ) ) | ( () ( (lv_currentBatter_38_0= ruleCurrentBatter ) ) this_EXECUTE_39= RULE_EXECUTE ( (lv_batterOut_40_0= RULE_GROUNDED_DOUBLE_PLAY_OUT ) ) ) | ( () ( (lv_currentBatter_42_0= ruleCurrentBatter ) ) this_EXECUTE_43= RULE_EXECUTE ( (lv_batterOut_44_0= RULE_SACRIFICE_FLY ) ) ) | ( () ( (lv_currentBatter_46_0= ruleCurrentBatter ) ) this_EXECUTE_47= RULE_EXECUTE ( (lv_batterOut_48_0= RULE_SACRIFICE_FLY_FOUL_BALL ) ) ) | ( () ( (lv_currentBatter_50_0= ruleCurrentBatter ) ) this_EXECUTE_51= RULE_EXECUTE ( (lv_batterOut_52_0= RULE_SACRIFICE_BUNT ) ) ) | ( () ( (lv_currentBatter_54_0= ruleCurrentBatter ) ) this_EXECUTE_55= RULE_EXECUTE ( (lv_batterOut_56_0= RULE_INFIELD_FLY ) ) ) )";
        }
    }
    static final String dfa_49s = "\1\133\15\uffff";
    static final String dfa_50s = "\1\u0097\15\uffff";
    static final String dfa_51s = "\1\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String dfa_52s = "\1\0\15\uffff}>";
    static final String[] dfa_53s = {
            "\1\1\60\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\15\1\14\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final char[] dfa_50 = DFA.unpackEncodedStringToUnsignedChars(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final short[][] dfa_53 = unpackEncodedStringArray(dfa_53s);

    class DFA136 extends DFA {

        public DFA136(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 136;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_49;
            this.max = dfa_50;
            this.accept = dfa_51;
            this.special = dfa_52;
            this.transition = dfa_53;
        }
        public String getDescription() {
            return "()+ loopback of 8692:6: ( ({...}? => ( ({...}? => (otherlv_3= 'tournament' otherlv_4= '=' ( (lv_tournament_5_0= RULE_STRING ) ) otherlv_6= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'stadium' otherlv_8= '=' ( (lv_stadium_9_0= RULE_STRING ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'place' otherlv_12= '=' ( (lv_place_13_0= RULE_STRING ) ) otherlv_14= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'date' otherlv_16= '=' ( (lv_date_17_0= RULE_STRING ) ) otherlv_18= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'startTime' otherlv_20= '=' ( (lv_startTime_21_0= RULE_STRING ) ) otherlv_22= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'endTime' otherlv_24= '=' ( (lv_endTime_25_0= RULE_STRING ) ) otherlv_26= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'duration' otherlv_28= '=' ( (lv_duration_29_0= RULE_STRING ) ) otherlv_30= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'category' otherlv_32= '=' ( (lv_category_33_0= RULE_STRING ) ) otherlv_34= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'type' otherlv_36= '=' ( (lv_type_37_0= ruleGameTypeEnum ) ) otherlv_38= ';' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_umpires_39_0= ruleUmpires ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_scorekeepers_40_0= ruleScoreKeepers ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_notes_41_0= ruleNotes ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA136_0 = input.LA(1);

                         
                        int index136_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA136_0==91) ) {s = 1;}

                        else if ( LA136_0 == 140 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 0) ) {s = 2;}

                        else if ( LA136_0 == 141 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 1) ) {s = 3;}

                        else if ( LA136_0 == 142 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 2) ) {s = 4;}

                        else if ( LA136_0 == 143 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 3) ) {s = 5;}

                        else if ( LA136_0 == 144 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 4) ) {s = 6;}

                        else if ( LA136_0 == 145 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 5) ) {s = 7;}

                        else if ( LA136_0 == 146 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 6) ) {s = 8;}

                        else if ( LA136_0 == 147 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 7) ) {s = 9;}

                        else if ( LA136_0 == 148 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 8) ) {s = 10;}

                        else if ( LA136_0 == 151 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 9) ) {s = 11;}

                        else if ( LA136_0 == 150 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 10) ) {s = 12;}

                        else if ( LA136_0 == 149 && getUnorderedGroupHelper().canSelect(grammarAccess.getDescriptionAccess().getUnorderedGroup_2(), 11) ) {s = 13;}

                         
                        input.seek(index136_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 136, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000050000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x2000001088000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000001088000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L,0x1018164008000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L,0x1018124008000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000080008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000300L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000200008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000020L,0x1000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000004BFF67922L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0006000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000020L,0x0000000000003C00L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x02A0000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000020L,0x000000000000D400L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0100000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0D00000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0900000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000002L,0x1000000000000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x4000000008000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000000L,0x0500000020000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x0100000020000000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000000L,0x0010000008000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000FFF000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000FFF000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000000000000L,0x0000200020000000L});

}
