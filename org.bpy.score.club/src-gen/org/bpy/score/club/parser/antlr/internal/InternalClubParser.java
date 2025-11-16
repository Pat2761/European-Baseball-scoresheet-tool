package org.bpy.score.club.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.bpy.score.club.services.ClubGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalClubParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'club'", "'{'", "'}'", "'city'", "'='", "';'", "'team'", "'player'", "'name'", "'officials'", "'scoreKeeper'", "'umpire'", "'members'", "'member'", "'shortName'", "'licenceNumber'", "'shirtNumber'", "'status'", "','", "'E'", "'UE'", "'M'", "'Ex'", "'18U'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalClubParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalClubParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalClubParser.tokenNames; }
    public String getGrammarFileName() { return "InternalClub.g"; }



     	private ClubGrammarAccess grammarAccess;

        public InternalClubParser(TokenStream input, ClubGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Club";
       	}

       	@Override
       	protected ClubGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleClub"
    // InternalClub.g:65:1: entryRuleClub returns [EObject current=null] : iv_ruleClub= ruleClub EOF ;
    public final EObject entryRuleClub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClub = null;


        try {
            // InternalClub.g:65:45: (iv_ruleClub= ruleClub EOF )
            // InternalClub.g:66:2: iv_ruleClub= ruleClub EOF
            {
             newCompositeNode(grammarAccess.getClubRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClub=ruleClub();

            state._fsp--;

             current =iv_ruleClub; 
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
    // $ANTLR end "entryRuleClub"


    // $ANTLR start "ruleClub"
    // InternalClub.g:72:1: ruleClub returns [EObject current=null] : (otherlv_0= 'club' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_clubDescription_3_0= ruleClubDescription ) ) otherlv_4= '}' ) ;
    public final EObject ruleClub() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_clubDescription_3_0 = null;



        	enterRule();

        try {
            // InternalClub.g:78:2: ( (otherlv_0= 'club' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_clubDescription_3_0= ruleClubDescription ) ) otherlv_4= '}' ) )
            // InternalClub.g:79:2: (otherlv_0= 'club' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_clubDescription_3_0= ruleClubDescription ) ) otherlv_4= '}' )
            {
            // InternalClub.g:79:2: (otherlv_0= 'club' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_clubDescription_3_0= ruleClubDescription ) ) otherlv_4= '}' )
            // InternalClub.g:80:3: otherlv_0= 'club' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_clubDescription_3_0= ruleClubDescription ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getClubAccess().getClubKeyword_0());
            		
            // InternalClub.g:84:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalClub.g:85:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalClub.g:85:4: (lv_name_1_0= RULE_STRING )
            // InternalClub.g:86:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getClubAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClubRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getClubAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalClub.g:106:3: ( (lv_clubDescription_3_0= ruleClubDescription ) )
            // InternalClub.g:107:4: (lv_clubDescription_3_0= ruleClubDescription )
            {
            // InternalClub.g:107:4: (lv_clubDescription_3_0= ruleClubDescription )
            // InternalClub.g:108:5: lv_clubDescription_3_0= ruleClubDescription
            {

            					newCompositeNode(grammarAccess.getClubAccess().getClubDescriptionClubDescriptionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_clubDescription_3_0=ruleClubDescription();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClubRule());
            					}
            					set(
            						current,
            						"clubDescription",
            						lv_clubDescription_3_0,
            						"org.bpy.score.club.Club.ClubDescription");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getClubAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleClub"


    // $ANTLR start "entryRuleClubDescription"
    // InternalClub.g:133:1: entryRuleClubDescription returns [EObject current=null] : iv_ruleClubDescription= ruleClubDescription EOF ;
    public final EObject entryRuleClubDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClubDescription = null;


        try {
            // InternalClub.g:133:56: (iv_ruleClubDescription= ruleClubDescription EOF )
            // InternalClub.g:134:2: iv_ruleClubDescription= ruleClubDescription EOF
            {
             newCompositeNode(grammarAccess.getClubDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClubDescription=ruleClubDescription();

            state._fsp--;

             current =iv_ruleClubDescription; 
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
    // $ANTLR end "entryRuleClubDescription"


    // $ANTLR start "ruleClubDescription"
    // InternalClub.g:140:1: ruleClubDescription returns [EObject current=null] : (otherlv_0= 'city' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ';' ( (lv_members_4_0= ruleMembers ) ) ( (lv_teams_5_0= ruleTeam ) )* ( (lv_officials_6_0= ruleOfficials ) )? ) ;
    public final EObject ruleClubDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_members_4_0 = null;

        EObject lv_teams_5_0 = null;

        EObject lv_officials_6_0 = null;



        	enterRule();

        try {
            // InternalClub.g:146:2: ( (otherlv_0= 'city' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ';' ( (lv_members_4_0= ruleMembers ) ) ( (lv_teams_5_0= ruleTeam ) )* ( (lv_officials_6_0= ruleOfficials ) )? ) )
            // InternalClub.g:147:2: (otherlv_0= 'city' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ';' ( (lv_members_4_0= ruleMembers ) ) ( (lv_teams_5_0= ruleTeam ) )* ( (lv_officials_6_0= ruleOfficials ) )? )
            {
            // InternalClub.g:147:2: (otherlv_0= 'city' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ';' ( (lv_members_4_0= ruleMembers ) ) ( (lv_teams_5_0= ruleTeam ) )* ( (lv_officials_6_0= ruleOfficials ) )? )
            // InternalClub.g:148:3: otherlv_0= 'city' otherlv_1= '=' ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ';' ( (lv_members_4_0= ruleMembers ) ) ( (lv_teams_5_0= ruleTeam ) )* ( (lv_officials_6_0= ruleOfficials ) )?
            {
            otherlv_0=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getClubDescriptionAccess().getCityKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getClubDescriptionAccess().getEqualsSignKeyword_1());
            		
            // InternalClub.g:156:3: ( (lv_name_2_0= RULE_STRING ) )
            // InternalClub.g:157:4: (lv_name_2_0= RULE_STRING )
            {
            // InternalClub.g:157:4: (lv_name_2_0= RULE_STRING )
            // InternalClub.g:158:5: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClubDescriptionAccess().getNameSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClubDescriptionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getClubDescriptionAccess().getSemicolonKeyword_3());
            		
            // InternalClub.g:178:3: ( (lv_members_4_0= ruleMembers ) )
            // InternalClub.g:179:4: (lv_members_4_0= ruleMembers )
            {
            // InternalClub.g:179:4: (lv_members_4_0= ruleMembers )
            // InternalClub.g:180:5: lv_members_4_0= ruleMembers
            {

            					newCompositeNode(grammarAccess.getClubDescriptionAccess().getMembersMembersParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_10);
            lv_members_4_0=ruleMembers();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClubDescriptionRule());
            					}
            					set(
            						current,
            						"members",
            						lv_members_4_0,
            						"org.bpy.score.club.Club.Members");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalClub.g:197:3: ( (lv_teams_5_0= ruleTeam ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalClub.g:198:4: (lv_teams_5_0= ruleTeam )
            	    {
            	    // InternalClub.g:198:4: (lv_teams_5_0= ruleTeam )
            	    // InternalClub.g:199:5: lv_teams_5_0= ruleTeam
            	    {

            	    					newCompositeNode(grammarAccess.getClubDescriptionAccess().getTeamsTeamParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_teams_5_0=ruleTeam();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getClubDescriptionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"teams",
            	    						lv_teams_5_0,
            	    						"org.bpy.score.club.Club.Team");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalClub.g:216:3: ( (lv_officials_6_0= ruleOfficials ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalClub.g:217:4: (lv_officials_6_0= ruleOfficials )
                    {
                    // InternalClub.g:217:4: (lv_officials_6_0= ruleOfficials )
                    // InternalClub.g:218:5: lv_officials_6_0= ruleOfficials
                    {

                    					newCompositeNode(grammarAccess.getClubDescriptionAccess().getOfficialsOfficialsParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_officials_6_0=ruleOfficials();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClubDescriptionRule());
                    					}
                    					set(
                    						current,
                    						"officials",
                    						lv_officials_6_0,
                    						"org.bpy.score.club.Club.Officials");
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
    // $ANTLR end "ruleClubDescription"


    // $ANTLR start "entryRuleTeam"
    // InternalClub.g:239:1: entryRuleTeam returns [EObject current=null] : iv_ruleTeam= ruleTeam EOF ;
    public final EObject entryRuleTeam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTeam = null;


        try {
            // InternalClub.g:239:45: (iv_ruleTeam= ruleTeam EOF )
            // InternalClub.g:240:2: iv_ruleTeam= ruleTeam EOF
            {
             newCompositeNode(grammarAccess.getTeamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTeam=ruleTeam();

            state._fsp--;

             current =iv_ruleTeam; 
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
    // $ANTLR end "entryRuleTeam"


    // $ANTLR start "ruleTeam"
    // InternalClub.g:246:1: ruleTeam returns [EObject current=null] : (otherlv_0= 'team' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_players_3_0= rulePlayer ) )* otherlv_4= '}' ) ;
    public final EObject ruleTeam() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_players_3_0 = null;



        	enterRule();

        try {
            // InternalClub.g:252:2: ( (otherlv_0= 'team' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_players_3_0= rulePlayer ) )* otherlv_4= '}' ) )
            // InternalClub.g:253:2: (otherlv_0= 'team' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_players_3_0= rulePlayer ) )* otherlv_4= '}' )
            {
            // InternalClub.g:253:2: (otherlv_0= 'team' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_players_3_0= rulePlayer ) )* otherlv_4= '}' )
            // InternalClub.g:254:3: otherlv_0= 'team' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_players_3_0= rulePlayer ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTeamAccess().getTeamKeyword_0());
            		
            // InternalClub.g:258:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalClub.g:259:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalClub.g:259:4: (lv_name_1_0= RULE_STRING )
            // InternalClub.g:260:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTeamAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTeamRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getTeamAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalClub.g:280:3: ( (lv_players_3_0= rulePlayer ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalClub.g:281:4: (lv_players_3_0= rulePlayer )
            	    {
            	    // InternalClub.g:281:4: (lv_players_3_0= rulePlayer )
            	    // InternalClub.g:282:5: lv_players_3_0= rulePlayer
            	    {

            	    					newCompositeNode(grammarAccess.getTeamAccess().getPlayersPlayerParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_players_3_0=rulePlayer();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTeamRule());
            	    					}
            	    					add(
            	    						current,
            	    						"players",
            	    						lv_players_3_0,
            	    						"org.bpy.score.club.Club.Player");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTeamAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleTeam"


    // $ANTLR start "entryRulePlayer"
    // InternalClub.g:307:1: entryRulePlayer returns [EObject current=null] : iv_rulePlayer= rulePlayer EOF ;
    public final EObject entryRulePlayer() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlayer = null;


        try {
            // InternalClub.g:307:47: (iv_rulePlayer= rulePlayer EOF )
            // InternalClub.g:308:2: iv_rulePlayer= rulePlayer EOF
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
    // InternalClub.g:314:1: rulePlayer returns [EObject current=null] : (otherlv_0= 'player' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject rulePlayer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalClub.g:320:2: ( (otherlv_0= 'player' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalClub.g:321:2: (otherlv_0= 'player' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalClub.g:321:2: (otherlv_0= 'player' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            // InternalClub.g:322:3: otherlv_0= 'player' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getPlayerAccess().getPlayerKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getPlayerAccess().getNameKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getPlayerAccess().getEqualsSignKeyword_2());
            		
            // InternalClub.g:334:3: ( (otherlv_3= RULE_STRING ) )
            // InternalClub.g:335:4: (otherlv_3= RULE_STRING )
            {
            // InternalClub.g:335:4: (otherlv_3= RULE_STRING )
            // InternalClub.g:336:5: otherlv_3= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlayerRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getPlayerAccess().getPlayerNameMemberCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPlayerAccess().getSemicolonKeyword_4());
            		

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


    // $ANTLR start "entryRuleOfficials"
    // InternalClub.g:355:1: entryRuleOfficials returns [EObject current=null] : iv_ruleOfficials= ruleOfficials EOF ;
    public final EObject entryRuleOfficials() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOfficials = null;


        try {
            // InternalClub.g:355:50: (iv_ruleOfficials= ruleOfficials EOF )
            // InternalClub.g:356:2: iv_ruleOfficials= ruleOfficials EOF
            {
             newCompositeNode(grammarAccess.getOfficialsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOfficials=ruleOfficials();

            state._fsp--;

             current =iv_ruleOfficials; 
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
    // $ANTLR end "entryRuleOfficials"


    // $ANTLR start "ruleOfficials"
    // InternalClub.g:362:1: ruleOfficials returns [EObject current=null] : ( () otherlv_1= 'officials' otherlv_2= '{' ( (lv_officials_3_0= ruleOfficial ) )* otherlv_4= '}' ) ;
    public final EObject ruleOfficials() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_officials_3_0 = null;



        	enterRule();

        try {
            // InternalClub.g:368:2: ( ( () otherlv_1= 'officials' otherlv_2= '{' ( (lv_officials_3_0= ruleOfficial ) )* otherlv_4= '}' ) )
            // InternalClub.g:369:2: ( () otherlv_1= 'officials' otherlv_2= '{' ( (lv_officials_3_0= ruleOfficial ) )* otherlv_4= '}' )
            {
            // InternalClub.g:369:2: ( () otherlv_1= 'officials' otherlv_2= '{' ( (lv_officials_3_0= ruleOfficial ) )* otherlv_4= '}' )
            // InternalClub.g:370:3: () otherlv_1= 'officials' otherlv_2= '{' ( (lv_officials_3_0= ruleOfficial ) )* otherlv_4= '}'
            {
            // InternalClub.g:370:3: ()
            // InternalClub.g:371:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOfficialsAccess().getOfficialsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getOfficialsAccess().getOfficialsKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getOfficialsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalClub.g:385:3: ( (lv_officials_3_0= ruleOfficial ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=21 && LA4_0<=22)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalClub.g:386:4: (lv_officials_3_0= ruleOfficial )
            	    {
            	    // InternalClub.g:386:4: (lv_officials_3_0= ruleOfficial )
            	    // InternalClub.g:387:5: lv_officials_3_0= ruleOfficial
            	    {

            	    					newCompositeNode(grammarAccess.getOfficialsAccess().getOfficialsOfficialParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_officials_3_0=ruleOfficial();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOfficialsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"officials",
            	    						lv_officials_3_0,
            	    						"org.bpy.score.club.Club.Official");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getOfficialsAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleOfficials"


    // $ANTLR start "entryRuleOfficial"
    // InternalClub.g:412:1: entryRuleOfficial returns [EObject current=null] : iv_ruleOfficial= ruleOfficial EOF ;
    public final EObject entryRuleOfficial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOfficial = null;


        try {
            // InternalClub.g:412:49: (iv_ruleOfficial= ruleOfficial EOF )
            // InternalClub.g:413:2: iv_ruleOfficial= ruleOfficial EOF
            {
             newCompositeNode(grammarAccess.getOfficialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOfficial=ruleOfficial();

            state._fsp--;

             current =iv_ruleOfficial; 
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
    // $ANTLR end "entryRuleOfficial"


    // $ANTLR start "ruleOfficial"
    // InternalClub.g:419:1: ruleOfficial returns [EObject current=null] : (this_Umpire_0= ruleUmpire | this_ScoreKeeper_1= ruleScoreKeeper ) ;
    public final EObject ruleOfficial() throws RecognitionException {
        EObject current = null;

        EObject this_Umpire_0 = null;

        EObject this_ScoreKeeper_1 = null;



        	enterRule();

        try {
            // InternalClub.g:425:2: ( (this_Umpire_0= ruleUmpire | this_ScoreKeeper_1= ruleScoreKeeper ) )
            // InternalClub.g:426:2: (this_Umpire_0= ruleUmpire | this_ScoreKeeper_1= ruleScoreKeeper )
            {
            // InternalClub.g:426:2: (this_Umpire_0= ruleUmpire | this_ScoreKeeper_1= ruleScoreKeeper )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            else if ( (LA5_0==21) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalClub.g:427:3: this_Umpire_0= ruleUmpire
                    {

                    			newCompositeNode(grammarAccess.getOfficialAccess().getUmpireParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Umpire_0=ruleUmpire();

                    state._fsp--;


                    			current = this_Umpire_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalClub.g:436:3: this_ScoreKeeper_1= ruleScoreKeeper
                    {

                    			newCompositeNode(grammarAccess.getOfficialAccess().getScoreKeeperParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScoreKeeper_1=ruleScoreKeeper();

                    state._fsp--;


                    			current = this_ScoreKeeper_1;
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
    // $ANTLR end "ruleOfficial"


    // $ANTLR start "entryRuleScoreKeeper"
    // InternalClub.g:448:1: entryRuleScoreKeeper returns [EObject current=null] : iv_ruleScoreKeeper= ruleScoreKeeper EOF ;
    public final EObject entryRuleScoreKeeper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScoreKeeper = null;


        try {
            // InternalClub.g:448:52: (iv_ruleScoreKeeper= ruleScoreKeeper EOF )
            // InternalClub.g:449:2: iv_ruleScoreKeeper= ruleScoreKeeper EOF
            {
             newCompositeNode(grammarAccess.getScoreKeeperRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScoreKeeper=ruleScoreKeeper();

            state._fsp--;

             current =iv_ruleScoreKeeper; 
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
    // $ANTLR end "entryRuleScoreKeeper"


    // $ANTLR start "ruleScoreKeeper"
    // InternalClub.g:455:1: ruleScoreKeeper returns [EObject current=null] : (otherlv_0= 'scoreKeeper' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleScoreKeeper() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalClub.g:461:2: ( (otherlv_0= 'scoreKeeper' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalClub.g:462:2: (otherlv_0= 'scoreKeeper' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalClub.g:462:2: (otherlv_0= 'scoreKeeper' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            // InternalClub.g:463:3: otherlv_0= 'scoreKeeper' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getScoreKeeperAccess().getScoreKeeperKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getScoreKeeperAccess().getNameKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getScoreKeeperAccess().getEqualsSignKeyword_2());
            		
            // InternalClub.g:475:3: ( (otherlv_3= RULE_STRING ) )
            // InternalClub.g:476:4: (otherlv_3= RULE_STRING )
            {
            // InternalClub.g:476:4: (otherlv_3= RULE_STRING )
            // InternalClub.g:477:5: otherlv_3= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScoreKeeperRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getScoreKeeperAccess().getNameMemberCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getScoreKeeperAccess().getSemicolonKeyword_4());
            		

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
    // $ANTLR end "ruleScoreKeeper"


    // $ANTLR start "entryRuleUmpire"
    // InternalClub.g:496:1: entryRuleUmpire returns [EObject current=null] : iv_ruleUmpire= ruleUmpire EOF ;
    public final EObject entryRuleUmpire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUmpire = null;


        try {
            // InternalClub.g:496:47: (iv_ruleUmpire= ruleUmpire EOF )
            // InternalClub.g:497:2: iv_ruleUmpire= ruleUmpire EOF
            {
             newCompositeNode(grammarAccess.getUmpireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUmpire=ruleUmpire();

            state._fsp--;

             current =iv_ruleUmpire; 
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
    // $ANTLR end "entryRuleUmpire"


    // $ANTLR start "ruleUmpire"
    // InternalClub.g:503:1: ruleUmpire returns [EObject current=null] : (otherlv_0= 'umpire' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) ;
    public final EObject ruleUmpire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalClub.g:509:2: ( (otherlv_0= 'umpire' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' ) )
            // InternalClub.g:510:2: (otherlv_0= 'umpire' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            {
            // InternalClub.g:510:2: (otherlv_0= 'umpire' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';' )
            // InternalClub.g:511:3: otherlv_0= 'umpire' otherlv_1= 'name' otherlv_2= '=' ( (otherlv_3= RULE_STRING ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getUmpireAccess().getUmpireKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getUmpireAccess().getNameKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getUmpireAccess().getEqualsSignKeyword_2());
            		
            // InternalClub.g:523:3: ( (otherlv_3= RULE_STRING ) )
            // InternalClub.g:524:4: (otherlv_3= RULE_STRING )
            {
            // InternalClub.g:524:4: (otherlv_3= RULE_STRING )
            // InternalClub.g:525:5: otherlv_3= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUmpireRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(otherlv_3, grammarAccess.getUmpireAccess().getNameMemberCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getUmpireAccess().getSemicolonKeyword_4());
            		

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
    // $ANTLR end "ruleUmpire"


    // $ANTLR start "entryRuleMembers"
    // InternalClub.g:544:1: entryRuleMembers returns [EObject current=null] : iv_ruleMembers= ruleMembers EOF ;
    public final EObject entryRuleMembers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMembers = null;


        try {
            // InternalClub.g:544:48: (iv_ruleMembers= ruleMembers EOF )
            // InternalClub.g:545:2: iv_ruleMembers= ruleMembers EOF
            {
             newCompositeNode(grammarAccess.getMembersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMembers=ruleMembers();

            state._fsp--;

             current =iv_ruleMembers; 
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
    // $ANTLR end "entryRuleMembers"


    // $ANTLR start "ruleMembers"
    // InternalClub.g:551:1: ruleMembers returns [EObject current=null] : (otherlv_0= 'members' otherlv_1= '{' ( (lv_members_2_0= ruleMember ) )+ otherlv_3= '}' ) ;
    public final EObject ruleMembers() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_members_2_0 = null;



        	enterRule();

        try {
            // InternalClub.g:557:2: ( (otherlv_0= 'members' otherlv_1= '{' ( (lv_members_2_0= ruleMember ) )+ otherlv_3= '}' ) )
            // InternalClub.g:558:2: (otherlv_0= 'members' otherlv_1= '{' ( (lv_members_2_0= ruleMember ) )+ otherlv_3= '}' )
            {
            // InternalClub.g:558:2: (otherlv_0= 'members' otherlv_1= '{' ( (lv_members_2_0= ruleMember ) )+ otherlv_3= '}' )
            // InternalClub.g:559:3: otherlv_0= 'members' otherlv_1= '{' ( (lv_members_2_0= ruleMember ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMembersAccess().getMembersKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getMembersAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalClub.g:567:3: ( (lv_members_2_0= ruleMember ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalClub.g:568:4: (lv_members_2_0= ruleMember )
            	    {
            	    // InternalClub.g:568:4: (lv_members_2_0= ruleMember )
            	    // InternalClub.g:569:5: lv_members_2_0= ruleMember
            	    {

            	    					newCompositeNode(grammarAccess.getMembersAccess().getMembersMemberParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_members_2_0=ruleMember();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMembersRule());
            	    					}
            	    					add(
            	    						current,
            	    						"members",
            	    						lv_members_2_0,
            	    						"org.bpy.score.club.Club.Member");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMembersAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleMembers"


    // $ANTLR start "entryRuleMember"
    // InternalClub.g:594:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // InternalClub.g:594:47: (iv_ruleMember= ruleMember EOF )
            // InternalClub.g:595:2: iv_ruleMember= ruleMember EOF
            {
             newCompositeNode(grammarAccess.getMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMember=ruleMember();

            state._fsp--;

             current =iv_ruleMember; 
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
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // InternalClub.g:601:1: ruleMember returns [EObject current=null] : (otherlv_0= 'member' otherlv_1= 'name' otherlv_2= '=' ( (lv_name_3_0= RULE_STRING ) ) (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )? otherlv_7= 'licenceNumber' otherlv_8= '=' ( (lv_licenceNumber_9_0= RULE_STRING ) ) (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )? (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )? otherlv_16= ';' ) ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_shortName_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_licenceNumber_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_shirtNumber_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_status_15_0 = null;



        	enterRule();

        try {
            // InternalClub.g:607:2: ( (otherlv_0= 'member' otherlv_1= 'name' otherlv_2= '=' ( (lv_name_3_0= RULE_STRING ) ) (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )? otherlv_7= 'licenceNumber' otherlv_8= '=' ( (lv_licenceNumber_9_0= RULE_STRING ) ) (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )? (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )? otherlv_16= ';' ) )
            // InternalClub.g:608:2: (otherlv_0= 'member' otherlv_1= 'name' otherlv_2= '=' ( (lv_name_3_0= RULE_STRING ) ) (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )? otherlv_7= 'licenceNumber' otherlv_8= '=' ( (lv_licenceNumber_9_0= RULE_STRING ) ) (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )? (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )? otherlv_16= ';' )
            {
            // InternalClub.g:608:2: (otherlv_0= 'member' otherlv_1= 'name' otherlv_2= '=' ( (lv_name_3_0= RULE_STRING ) ) (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )? otherlv_7= 'licenceNumber' otherlv_8= '=' ( (lv_licenceNumber_9_0= RULE_STRING ) ) (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )? (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )? otherlv_16= ';' )
            // InternalClub.g:609:3: otherlv_0= 'member' otherlv_1= 'name' otherlv_2= '=' ( (lv_name_3_0= RULE_STRING ) ) (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )? otherlv_7= 'licenceNumber' otherlv_8= '=' ( (lv_licenceNumber_9_0= RULE_STRING ) ) (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )? (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )? otherlv_16= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getMemberAccess().getMemberKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getMemberAccess().getNameKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getMemberAccess().getEqualsSignKeyword_2());
            		
            // InternalClub.g:621:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalClub.g:622:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalClub.g:622:4: (lv_name_3_0= RULE_STRING )
            // InternalClub.g:623:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_name_3_0, grammarAccess.getMemberAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMemberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalClub.g:639:3: (otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalClub.g:640:4: otherlv_4= 'shortName' otherlv_5= '=' ( (lv_shortName_6_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getMemberAccess().getShortNameKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getMemberAccess().getEqualsSignKeyword_4_1());
                    			
                    // InternalClub.g:648:4: ( (lv_shortName_6_0= RULE_STRING ) )
                    // InternalClub.g:649:5: (lv_shortName_6_0= RULE_STRING )
                    {
                    // InternalClub.g:649:5: (lv_shortName_6_0= RULE_STRING )
                    // InternalClub.g:650:6: lv_shortName_6_0= RULE_STRING
                    {
                    lv_shortName_6_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

                    						newLeafNode(lv_shortName_6_0, grammarAccess.getMemberAccess().getShortNameSTRINGTerminalRuleCall_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMemberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"shortName",
                    							lv_shortName_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,26,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getMemberAccess().getLicenceNumberKeyword_5());
            		
            otherlv_8=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getMemberAccess().getEqualsSignKeyword_6());
            		
            // InternalClub.g:675:3: ( (lv_licenceNumber_9_0= RULE_STRING ) )
            // InternalClub.g:676:4: (lv_licenceNumber_9_0= RULE_STRING )
            {
            // InternalClub.g:676:4: (lv_licenceNumber_9_0= RULE_STRING )
            // InternalClub.g:677:5: lv_licenceNumber_9_0= RULE_STRING
            {
            lv_licenceNumber_9_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

            					newLeafNode(lv_licenceNumber_9_0, grammarAccess.getMemberAccess().getLicenceNumberSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMemberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"licenceNumber",
            						lv_licenceNumber_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalClub.g:693:3: (otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalClub.g:694:4: otherlv_10= 'shirtNumber' otherlv_11= '=' ( (lv_shirtNumber_12_0= RULE_INT ) )
                    {
                    otherlv_10=(Token)match(input,27,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getMemberAccess().getShirtNumberKeyword_8_0());
                    			
                    otherlv_11=(Token)match(input,15,FOLLOW_19); 

                    				newLeafNode(otherlv_11, grammarAccess.getMemberAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalClub.g:702:4: ( (lv_shirtNumber_12_0= RULE_INT ) )
                    // InternalClub.g:703:5: (lv_shirtNumber_12_0= RULE_INT )
                    {
                    // InternalClub.g:703:5: (lv_shirtNumber_12_0= RULE_INT )
                    // InternalClub.g:704:6: lv_shirtNumber_12_0= RULE_INT
                    {
                    lv_shirtNumber_12_0=(Token)match(input,RULE_INT,FOLLOW_20); 

                    						newLeafNode(lv_shirtNumber_12_0, grammarAccess.getMemberAccess().getShirtNumberINTTerminalRuleCall_8_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMemberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"shirtNumber",
                    							lv_shirtNumber_12_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalClub.g:721:3: (otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalClub.g:722:4: otherlv_13= 'status' otherlv_14= '=' ( (lv_status_15_0= ruleMemberStatus ) )
                    {
                    otherlv_13=(Token)match(input,28,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getMemberAccess().getStatusKeyword_9_0());
                    			
                    otherlv_14=(Token)match(input,15,FOLLOW_21); 

                    				newLeafNode(otherlv_14, grammarAccess.getMemberAccess().getEqualsSignKeyword_9_1());
                    			
                    // InternalClub.g:730:4: ( (lv_status_15_0= ruleMemberStatus ) )
                    // InternalClub.g:731:5: (lv_status_15_0= ruleMemberStatus )
                    {
                    // InternalClub.g:731:5: (lv_status_15_0= ruleMemberStatus )
                    // InternalClub.g:732:6: lv_status_15_0= ruleMemberStatus
                    {

                    						newCompositeNode(grammarAccess.getMemberAccess().getStatusMemberStatusParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_status_15_0=ruleMemberStatus();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMemberRule());
                    						}
                    						set(
                    							current,
                    							"status",
                    							lv_status_15_0,
                    							"org.bpy.score.club.Club.MemberStatus");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getMemberAccess().getSemicolonKeyword_10());
            		

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
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleMemberStatus"
    // InternalClub.g:758:1: entryRuleMemberStatus returns [EObject current=null] : iv_ruleMemberStatus= ruleMemberStatus EOF ;
    public final EObject entryRuleMemberStatus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemberStatus = null;


        try {
            // InternalClub.g:758:53: (iv_ruleMemberStatus= ruleMemberStatus EOF )
            // InternalClub.g:759:2: iv_ruleMemberStatus= ruleMemberStatus EOF
            {
             newCompositeNode(grammarAccess.getMemberStatusRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMemberStatus=ruleMemberStatus();

            state._fsp--;

             current =iv_ruleMemberStatus; 
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
    // $ANTLR end "entryRuleMemberStatus"


    // $ANTLR start "ruleMemberStatus"
    // InternalClub.g:765:1: ruleMemberStatus returns [EObject current=null] : ( ( (lv_status_0_0= ruleSTATUS ) ) (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )* ) ;
    public final EObject ruleMemberStatus() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_status_0_0 = null;

        Enumerator lv_status_2_0 = null;



        	enterRule();

        try {
            // InternalClub.g:771:2: ( ( ( (lv_status_0_0= ruleSTATUS ) ) (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )* ) )
            // InternalClub.g:772:2: ( ( (lv_status_0_0= ruleSTATUS ) ) (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )* )
            {
            // InternalClub.g:772:2: ( ( (lv_status_0_0= ruleSTATUS ) ) (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )* )
            // InternalClub.g:773:3: ( (lv_status_0_0= ruleSTATUS ) ) (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )*
            {
            // InternalClub.g:773:3: ( (lv_status_0_0= ruleSTATUS ) )
            // InternalClub.g:774:4: (lv_status_0_0= ruleSTATUS )
            {
            // InternalClub.g:774:4: (lv_status_0_0= ruleSTATUS )
            // InternalClub.g:775:5: lv_status_0_0= ruleSTATUS
            {

            					newCompositeNode(grammarAccess.getMemberStatusAccess().getStatusSTATUSEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
            lv_status_0_0=ruleSTATUS();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMemberStatusRule());
            					}
            					add(
            						current,
            						"status",
            						lv_status_0_0,
            						"org.bpy.score.club.Club.STATUS");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalClub.g:792:3: (otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalClub.g:793:4: otherlv_1= ',' ( (lv_status_2_0= ruleSTATUS ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_21); 

            	    				newLeafNode(otherlv_1, grammarAccess.getMemberStatusAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalClub.g:797:4: ( (lv_status_2_0= ruleSTATUS ) )
            	    // InternalClub.g:798:5: (lv_status_2_0= ruleSTATUS )
            	    {
            	    // InternalClub.g:798:5: (lv_status_2_0= ruleSTATUS )
            	    // InternalClub.g:799:6: lv_status_2_0= ruleSTATUS
            	    {

            	    						newCompositeNode(grammarAccess.getMemberStatusAccess().getStatusSTATUSEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_status_2_0=ruleSTATUS();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMemberStatusRule());
            	    						}
            	    						add(
            	    							current,
            	    							"status",
            	    							lv_status_2_0,
            	    							"org.bpy.score.club.Club.STATUS");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end "ruleMemberStatus"


    // $ANTLR start "ruleSTATUS"
    // InternalClub.g:821:1: ruleSTATUS returns [Enumerator current=null] : ( (enumLiteral_0= 'E' ) | (enumLiteral_1= 'UE' ) | (enumLiteral_2= 'M' ) | (enumLiteral_3= 'Ex' ) | (enumLiteral_4= '18U' ) ) ;
    public final Enumerator ruleSTATUS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalClub.g:827:2: ( ( (enumLiteral_0= 'E' ) | (enumLiteral_1= 'UE' ) | (enumLiteral_2= 'M' ) | (enumLiteral_3= 'Ex' ) | (enumLiteral_4= '18U' ) ) )
            // InternalClub.g:828:2: ( (enumLiteral_0= 'E' ) | (enumLiteral_1= 'UE' ) | (enumLiteral_2= 'M' ) | (enumLiteral_3= 'Ex' ) | (enumLiteral_4= '18U' ) )
            {
            // InternalClub.g:828:2: ( (enumLiteral_0= 'E' ) | (enumLiteral_1= 'UE' ) | (enumLiteral_2= 'M' ) | (enumLiteral_3= 'Ex' ) | (enumLiteral_4= '18U' ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt11=1;
                }
                break;
            case 31:
                {
                alt11=2;
                }
                break;
            case 32:
                {
                alt11=3;
                }
                break;
            case 33:
                {
                alt11=4;
                }
                break;
            case 34:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalClub.g:829:3: (enumLiteral_0= 'E' )
                    {
                    // InternalClub.g:829:3: (enumLiteral_0= 'E' )
                    // InternalClub.g:830:4: enumLiteral_0= 'E'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getSTATUSAccess().getForeignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSTATUSAccess().getForeignEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalClub.g:837:3: (enumLiteral_1= 'UE' )
                    {
                    // InternalClub.g:837:3: (enumLiteral_1= 'UE' )
                    // InternalClub.g:838:4: enumLiteral_1= 'UE'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getSTATUSAccess().getEuropeanEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSTATUSAccess().getEuropeanEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalClub.g:845:3: (enumLiteral_2= 'M' )
                    {
                    // InternalClub.g:845:3: (enumLiteral_2= 'M' )
                    // InternalClub.g:846:4: enumLiteral_2= 'M'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getSTATUSAccess().getTransferedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSTATUSAccess().getTransferedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalClub.g:853:3: (enumLiteral_3= 'Ex' )
                    {
                    // InternalClub.g:853:3: (enumLiteral_3= 'Ex' )
                    // InternalClub.g:854:4: enumLiteral_3= 'Ex'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getSTATUSAccess().getLicenseExtensionEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getSTATUSAccess().getLicenseExtensionEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalClub.g:861:3: (enumLiteral_4= '18U' )
                    {
                    // InternalClub.g:861:3: (enumLiteral_4= '18U' )
                    // InternalClub.g:862:4: enumLiteral_4= '18U'
                    {
                    enumLiteral_4=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getSTATUSAccess().getAgeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getSTATUSAccess().getAgeEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleSTATUS"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000602000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000018010000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000007C0000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000002L});

}