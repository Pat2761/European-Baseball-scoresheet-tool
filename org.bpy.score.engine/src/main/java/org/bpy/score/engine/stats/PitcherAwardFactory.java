/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2020  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.score.engine.stats;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.engine.stats.emf.statistic.LineupEntry;
import org.bpy.score.engine.util.EngineConstants;

/**
 * <b>Winner:</b><br>
 * <ul><li>(a) The official scorer shall credit as the winning pitcher that pitcher whose team assumes a lead while such pitcher is in the game,
 *         or during the inning on offense in which such pitcher is removed from the game and does not relinquish such lead, unless
 *         <ul>
 *         <li> (1) such pitcher is a starting pitcher and Rule 10.17(b) applies; or</li>
 *         <li> (2) rule 10.17(c) applies</li></ul>
 * <br>
 * <b>Comment:</b>  Whenever the score is tied, the game becomes a new contest insofar as the winning pitcher is concerned.
 * Once the opposing team assumes the lead, all pitchers who have pitched up to that point and have been replaced are excluded from
 * being credited with the victory. If the pitcher against whose pitching the opposing team gained the lead continues to pitch until
 * his team regains the lead, which it holds to the finish of the game, that pitcher shall be the winning pitcher.
 * <br>
 * <li> (b) If the pitcher whose team assumes a lead while such pitcher is in the game, or during the inning on offense in which such pitcher is removed
 * from the game and does not relinquish such lead, is a starting pitcher who has not completed
 *     <ul><li>(1) five innings of a game that lasts six of more innings on defense, or</li>
 *     <li>(2) four innings of a game that lasts five innings on defense,</li></ul>
 * <br>
 * then the official scorer shall credit as the winning pitcher the relief pitcher, if there is only one relief pitcher, or the relief pitcher who,
 * in the official scorer’s judgement was the most effective, if there is more than one relief pitcher.
 * <br><br>
 * <b>Comment:</b> It is the intent of Rule 10.17(b) that a relief pitcher pitch at least one complete inning or pitch when a crucial out is made,
 * within the context of the game (including the score) in order to be credited as the winning pitcher. If the first relief pitcher pitches effectively,
 * the official score should not presumptively credit that pitcher with the win, because the rule requires that the win be credited to the pitcher
 * who was the most effective, and a subsequent relief pitcher may have been most effective. The official scorer, in determining which relief pitcher
 * was the most effective, should consider the number of runs, earned runs and base runners given up by each relief pitcher and the context of the
 * game at the time of each relief pitcher’s appearance. If two or more relief pitchers were similarly effective, the official scorer should give
 * the presumption to the earlier pitcher as the winning pitcher.
 * <br><br>
 * <li>(c) The official scorer shall not credit as the winning pitcher a relief pitcher who is ineffective in a brief appearance, when at least one
 * succeeding relief pitcher pitches effectively in helping his team maintain its lead. In such a case, the official scorer shall credit as the winning
 * pitcher the succeeding relief pitcher who was most effective, in the judgement of the official scorer.
 * <br><br>
 * <b>Comment:</b> The official scorer generally should, but is not required to, consider the appearance of a relief pitcher to be ineffective and
 * brief if such relief pitcher pitches less than one inning and allows two or more earned runs to score (even if such runs are charged to a previous pitcher).
 * Rule 10.17(b) Comment provides guidance on choosing the winning pitcher from among several succeeding relief pitchers.
 * <br><br>
 * <b>Loser:</b>
 *    pitcher who is responsible for the run that gives the winning team a lead that the winning team does not relinquish
 * <br><br>
 * <b>Save:</b>
 * <ul>
 *    <li>(a) He is the finishing pitcher in a game won by his team;</li>
 *      <li>(b) He is not the winning pitcher; </li>
 *    <li>(c) He is credited with at least 1/3 of an inning pitched; and</li>
 *    <li>(d) He satisfies one of the following conditions:</li>
 *    <ul>
 *      <li>(1) He enters the game with a lead of no more than three runs and pitches for at least one inning; or</li>
 *      <lI>(2) He enters the game, regardless of the count, with the potential tying run either on base, or at bat, or on deck (that is, the potential tying run is either already on base or is one of the first two batters he faces); or</li>
 *      <li>(3) He pitches for at least three innings.</li>
 *    </ul>
 * </ul>
 * 
 * This class try to compute the Winner, loser and save pitcher. Not perfect 
 * 
 * @author Patrick BRIAND
 * 
 */
public class PitcherAwardFactory {

  /**
   * Abstract class for pitcher event	
   * 
   * @author Patrick BRIAND
   *
   */
  public abstract class AbstractPitcherEvent {
	/** Reference on the pitcher */  
    private LineupEntry pitcher;
    /** Name of the team */
    private String team;
    
    /**
     * Get the pitcher reference. 
     * 
     * @return pitcher reference
     */
	public LineupEntry getPitcher() {
		return pitcher;
	}
	
	/**
	 * Set the pitcher reference.
	 * 
	 * @param pitcher pitcher reference
	 */
	public void setPitcher(LineupEntry pitcher) {
		this.pitcher = pitcher;
	}
	
	/**
	 * Get the team name.
	 *  
	 * @return team name
	 */
	public String getTeam() {
		return team;
	}
	
	/**
	 * Set the team name.
	 * 
	 * @param team
	 */
	public void setTeam(String team) {
		this.team = team;
	}
    
    
  }

  /**
   * New point for pitcher event.
   * 
   * @author Patrick BRIAND
   *
   */
  public class NewPointEvent extends AbstractPitcherEvent {

    @Override
    public String toString() {
      return getTeam() + " : NewPointEvent           "; //$NON-NLS-1$
    }
  }

  /**
   * Pitcher substituion event.
   * 
   * @author Patrick BRIAND
   *
   */
  public class PitcherReplacementEvent extends AbstractPitcherEvent {

    @Override
    public String toString() {
      return getTeam() + " : PitcherReplacementEvent " + getPitcher().getPlayerDescription().getName(); //$NON-NLS-1$
    }
  }

  /**
   * This class manage the score during a game and check the equality.
   * 
   * @author Patrick BRIAND
   *
   */
  public class ScoreManager {
	/** Counter for the visitor point */  
    private int visitorPoint = 0;
    /** Counter for the hoem team point */
    private int hometeamPoint = 0;
    /** boolean which indicate equality */
    private boolean isEquality;

    /**
     * Constructor of the class.
     * Initialize fields
     */
    public ScoreManager() {
      visitorPoint = 0;
      hometeamPoint = 0;
      isEquality = true;
    }

    /**
     * Increments the visitor point.
     */
    public void incVisitorPoints() {
      visitorPoint++;
      isEquality = visitorPoint==hometeamPoint;
    }

    /**
     * Increments the home team point.
     */
    public void incHometeamPoints() {
      hometeamPoint++;
      isEquality = visitorPoint==hometeamPoint;
    }

    /**
     * Return if home team and visitor are equality
     * 
     * @return <b>true</b> Equality on the score, <b>false</b> otherwise
     */
    public boolean isEquality() {
      return isEquality;
    }
  }
  
  /** Logger of the class */
  public static final Logger logger = Logger.getLogger(PitcherAwardFactory.class.getSimpleName());

  /** Memorize the list of pitcher events */
  private List<AbstractPitcherEvent> pictherEvents;
  /** Number of visitor pitchers */
  private int visitorPitcherNumbers;
  /** Number of home team pitchers */
  private int hometeamPitcherNumbers;
  /** Number of visitor inning played */
  private int visitorNbInningPlayed;
  /** Number of home team inning played */
  private int hometeamNbInningPlayed;
  /** Visitor score */
  private int visitorScore;
  /** Home team score */
  private int hometeamScore;

  /** Reference on the looser pitcher */
  private LineupEntry looserPitcher = null;
  /** Reference on the winner pitcher */
  private LineupEntry winnerPitcher = null;
  /** Reference on the saved pitcher */
  private LineupEntry savedPitcher = null;

  /**
   * Constructor of the class.
   * Initialize some fields
   */
  public PitcherAwardFactory() {
    pictherEvents = new ArrayList<>();
  }

  /**
   * Return the looser pitcher 
   * 
   * @return Looser pitcher reference
   */
  public LineupEntry getLooserPitcher() {
    return looserPitcher;
  }

  /**
   * Return the winner pitcher 
   * 
   * @return winner pitcher reference
   */
  public LineupEntry getWinnerPitcher() {
    return winnerPitcher;
  }

  /**
   * Return the saved pitcher 
   * 
   * @return saved pitcher reference
   */
  public LineupEntry getSavedPitcher() {
    return savedPitcher;
  }

  /**
   * Add a new pitcher for the computation.
   * 
   * @param team team type (visitor or hometeam)
   * @param pitcher reference to the pitcher
   */
  public void addPitcherReplacement(String team, LineupEntry pitcher) {
    PitcherReplacementEvent pitcherReplacementEvent = new PitcherReplacementEvent();
    pitcherReplacementEvent.setTeam(team);
    pitcherReplacementEvent.setPitcher(pitcher);

    pictherEvents.add(pitcherReplacementEvent);
  }

  /**
   * Add a new point event for the computation.
   * 
   * @param team team type (visitor or hometeam)
   * @param responsiblePitcher Reference to the responsible 
   */
  public void addNewPointEvent(String team,LineupEntry responsiblePitcher) {
    NewPointEvent newPointEvent = new NewPointEvent();
    newPointEvent.setPitcher(responsiblePitcher);
    newPointEvent.setTeam(team);

    pictherEvents.add(newPointEvent);
  }

  /**
   * Compute the looser and winner pitcher
   * 
   */
  public void computePitcherAwards() {
    visitorPitcherNumbers = countPitchers(EngineConstants.VISITOR);
    hometeamPitcherNumbers = countPitchers(EngineConstants.HOMETEAM);
    visitorNbInningPlayed = countNbInningPlayer(EngineConstants.VISITOR);
    hometeamNbInningPlayed = countNbInningPlayer(EngineConstants.HOMETEAM);
    visitorScore = getScore(EngineConstants.VISITOR);
    hometeamScore = getScore(EngineConstants.HOMETEAM);

    computeLooserPitcher();
    computeWinnerPitcher();

  }

  /**
   * Compute the winner pitcher.
   */
  private void computeWinnerPitcher() {
    ScoreManager scoreManager = new ScoreManager();

    int bclCounter = 0;
    LineupEntry currentHomeTeamPitcher = null;
    LineupEntry currentVisitorPitcher = null;

    int nbInningHometeam = countNbInningPlayer(EngineConstants.HOMETEAM);
    int nbInningVisitor = countNbInningPlayer(EngineConstants.VISITOR);

    for (bclCounter=0 ; bclCounter<pictherEvents.size() ; bclCounter++) {


      AbstractPitcherEvent event = pictherEvents.get(bclCounter);

      if (event instanceof PitcherReplacementEvent) {
        if (event.team.equals(EngineConstants.HOMETEAM)) {
          currentHomeTeamPitcher = event.pitcher;
        } else {
          currentVisitorPitcher = event.pitcher;
        }
      }

      if (event instanceof NewPointEvent) {

        if (scoreManager.isEquality()) {
           if (noMorePitcher(event.team, bclCounter)) {

             winnerPitcher = event.team.equals(EngineConstants.HOMETEAM)? currentHomeTeamPitcher:currentVisitorPitcher;
             savedPitcher = null;

           } else {

             int nbInning = event.team.equals(EngineConstants.HOMETEAM) ? nbInningHometeam : nbInningVisitor;
             LineupEntry pitcher = event.team.equals(EngineConstants.HOMETEAM) ? currentHomeTeamPitcher : currentVisitorPitcher;

             /* check if have played enough inning for wn the game */
             if ((nbInning > 5 && pitcher != null && pitcher.getIpPlayed() >=5 ) || (nbInning == 5 && pitcher.getIpPlayed() >=4 )) {
               winnerPitcher = pitcher;

               savedPitcher = getSavedPitcherIfExist(event.team, nbInning, bclCounter);

             } else {
               /* Check for winner batter in the next batters */
               List<LineupEntry> nextBatters = getNextBatters(event.team, bclCounter);
               if (nextBatters.size() == 1) {
                 /* Only one batter, so it i the winner */
                 winnerPitcher = nextBatters.get(0);
                 savedPitcher = null;

               } else {
                 winnerPitcher = null;
                 savedPitcher = null;
               }
             }
           }
        }

        /* On met a jour le score */
        if (event.team.equals(EngineConstants.HOMETEAM)) {
          scoreManager.incHometeamPoints();
        } else {
          scoreManager.incVisitorPoints();
        }
      }
    }
  }

  /**
   * Compute the saved pitcher
   * 
   * @param team team type (visitor or hometeam) 
   * @param nbInning number of inning
   * @param bclCounter Start of the search
   * 
   * @return Saved pitcher reference if exist,<b>null</b> is no saved pitcher
   */
  private LineupEntry getSavedPitcherIfExist(String team, int nbInning, int bclCounter) {

    /* He is not the winning pitcher since, the seacrh start after the winning pitcher */
    for (int counter=bclCounter ; counter<pictherEvents.size() ; counter++) {
      AbstractPitcherEvent event = pictherEvents.get(counter);

      if (event instanceof PitcherReplacementEvent && event.team.equals(team)) {

        LineupEntry currentPitcher = event.pitcher;

        /* He is the finishing pitcher in a game won by his team */
        if (noMorePitcher(team, counter+1) && ( (currentPitcher.getIpPlayed() >= (double)nbInning/3) && (currentPitcher.getIpPlayed() >=3))) {

        	/* He is credited with at least 1/3 of an inning pitched  and he pitches for at least three innings */
            return currentPitcher;
        }
      }
    }


    return null;
  }

  /**
   * get next batters. 
   * 
   * @param team team type (visitor or hometeam) 
   * @param bclCounter Start of the search
   * 
   * @return a list which contains the next batters
   */
  private List<LineupEntry> getNextBatters(String team, int bclCounter) {
    List<LineupEntry> nextBatters = new ArrayList<>();

    for (int counter=bclCounter ; counter<pictherEvents.size() ; counter++) {
      AbstractPitcherEvent event = pictherEvents.get(counter);

      if (event instanceof PitcherReplacementEvent &&
          event.team.equals(team)) {
        nextBatters.add(event.pitcher);
      }
    }

    return nextBatters;
  }

  /**
   * Search if there no more batters. 
   * 
   * @param team team type (visitor or hometeam) 
   * @param bclCounter Start of the search

   * @return <b>true</b> no more batter,<b>false</b> left batters
   */
  private boolean noMorePitcher(String team, int bclCounter) {

    boolean noMorePitcher = true;

    for (int counter=bclCounter ; counter<pictherEvents.size() ; counter++) {
      AbstractPitcherEvent event = pictherEvents.get(counter);

      if (event instanceof PitcherReplacementEvent &&
          event.team.equals(team)) {
        noMorePitcher= false;
      }

    }
    return noMorePitcher;
  }

  /**
   * Define the looser pitcher
   */
  private void computeLooserPitcher() {
    ScoreManager scoreManager = new ScoreManager();

    for (AbstractPitcherEvent event : pictherEvents) {

      if (event instanceof NewPointEvent) {

        if (scoreManager.isEquality()) {
          looserPitcher = event.pitcher;
        }

        /* On met a jour le score */
        if (event.team.equals(EngineConstants.HOMETEAM)) {
          scoreManager.incHometeamPoints();
        } else {
          scoreManager.incVisitorPoints();
        }

      }
    }
  }

  /**
   * Get the score of a team
   * 
   * @param team team type (visitor or hometeam) 
   * @return score of the team
   */
  private int getScore(String team) {
    int score = 0;

    for (AbstractPitcherEvent event : pictherEvents) {
      if (event instanceof NewPointEvent && event.team.equals(team)) {
        score++;
      }
    }
    return score;
  }

  /**
   * Count the number of inning played by a pitcher.
   * 
   * @param team team type (visitor or hometeam) 
   * 
   * @return number of inning played
   */
  private int countNbInningPlayer(String team) {
    double ip = 0.0;
    for (AbstractPitcherEvent event : pictherEvents) {
      if (event instanceof PitcherReplacementEvent && event.team.equals(team) && (((PitcherReplacementEvent) event).getPitcher() != null)) {
        ip += ((PitcherReplacementEvent) event).getPitcher().getIpPlayed();
      }
    }
    return (int) ip;
  }

  /**
   * Count the number of pitcher for a team 
   * 
   * @param team team type (visitor or hometeam) 
   * 
   * @return Number of pitcher for the team
   */
  private int countPitchers(String team) {
    int counter = 0;
    for (AbstractPitcherEvent event : pictherEvents) {
      if (event instanceof PitcherReplacementEvent && event.team.equals(team)) {
        counter++;
      }
    }
    return counter;
  }

  @Override
  public String toString() {
    StringBuilder strBuilder = new StringBuilder("-[Pitcher awards statistic]--------------------------------------------------------------------------\n"); //$NON-NLS-1$
    strBuilder.append("Nb Pitchers : " + visitorPitcherNumbers + "- " + hometeamPitcherNumbers + "\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    strBuilder.append("Nb Innings  : " + visitorNbInningPlayed + "- " + hometeamNbInningPlayed + "\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    strBuilder.append("Score       : " + visitorScore + "- " + hometeamScore + "\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    strBuilder.append("-----------------------------------------------------------------------------------------------------\n"); //$NON-NLS-1$
    if (winnerPitcher != null) {
      strBuilder.append("Winner pitcher    : " + winnerPitcher.getPlayerDescription().getName() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
    } else {
      strBuilder.append("No Winner pitcher : \n"); //$NON-NLS-1$
    }
    if (looserPitcher != null) {
      strBuilder.append("looser pitcher    : " + looserPitcher.getPlayerDescription().getName() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
    } else {
      strBuilder.append("No looser pitcher : \n"); //$NON-NLS-1$
    }
    if (savedPitcher != null) {
      strBuilder.append("save pitcher      : " + savedPitcher.getPlayerDescription().getName() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
    } else {
      strBuilder.append("No save pitcher   : \n"); //$NON-NLS-1$
    }
    strBuilder.append("-----------------------------------------------------------------------------------------------------\n"); //$NON-NLS-1$

    return strBuilder.toString();
  }

  /**
   * For debug
   */
  public void debug() {
	logger.log(Level.FINE,"{0}",this);   //$NON-NLS-1$
  }
}
