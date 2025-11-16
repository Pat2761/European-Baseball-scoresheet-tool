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
package org.bpy.score.engine.stats.stats;

/**
 * Data container for General statistics.
 * 
 * @author Patrick BRIAND
 *
 */
public class GeneralStatContainer {

	/** offensives data : Ips counter */
	private double offensiveIps;
	/** offensives data : Plate appearance counter */
	private int offensivePAs;
	/** offensives data : At bats counter */
	private int offesnviveAtBats;
	/** offensives data : Run counter */
	private int offensiveRuns;
	/** offensives data : Hits counter */
	private int offensiveHits;
	/** offensives data : Double hits counter */
	private int offensiveDoubleHits;
	/** offensives data : Triple hits counter */
	private int offensiveTripleHits;
	/** offensives data : Home run hits counter */
	private int offensiveHomeruns;
	/** offensives data : Grounded double plays counter */
	private int offensiveGDPs;
	/** offensives data : Sacrifice hits counter */
	private int offensiveSacrificeHits;
	/** offensives data : Sacrifice flies counter */
	private int offensiveSacrificeFlies;
	/** offensives data : Stolen base counter */
	private int offensiveStolenBases;
	/** offensives data : Caught stealing counter */
	private int offensiveCaughtStealings;
	/** offensives data : Base on ball counter */
	private int offensiveBaseOnBalls;
	/** offensives data : Intentional base on ball counter */
	private int offensiveIntentionalBaseOnBall;
	/** offensives data : Hit by pitch counter */
	private int offensiveHitByPitchs;
	/** offensives data : Interference or obstruction counter */
	private int offensiveIOs;
	/** offensives data : Strike out counter */
	private int offensiveStrikeOuts;
	/** offensives data : RBIs counter */
	private int offensiveRbis;

	/** Defensive data : IPs counter */
	private double defensiveIps;
	/** Defensive data : Put outs counter */
	private int defensivePutouts;
	/** Defensive data : Assistances counter */
	private int defensiveAssists;
	/** Defensive data : Errors counter */
	private int defensiveErrors;
	/** Defensive data : Double plays participation counter */
	private int defensiveDoublePlays;

	/** Catcher data : IPs counter */
	private double catcherIps;
	/** Catcher data : Pass balls counter */
	private int catcherPassBalls;
	/** Catcher data : Caught stealing counter */
	private int catcherCaugthStealings;
	/** Catcher data : Stolen bases counter */
	private int catcherStolenBases;

	/** Pitcher data : IPs counter */
	private double pitcherIps;
	/** Pitcher data : Battle fronts counter */
	private int pitcherBatterFronts;
	/** Pitcher data : At bats counter */
	private int pitcherAtbats;
	/** Pitcher data : Runs counter */
	private int pitcherRuns;
	/** Pitcher data : Earned runs counter */
	private int pitcherEarnedRuns;
	/** Pitcher data : Hits counter */
	private int pitcherHits;
	/** Pitcher data : Double hits counter */
	private int pitchesDoubleHits;
	/** Pitcher data : Triple hits counter */
	private int pitcherTripleHits;
	/** Pitcher data : Home runs counter */
	private int pitcherHomeruns;
	/** Pitcher data : Sacrifice hits counter */
	private int pitcherSacrificeHits;
	/** Pitcher data : Sacrifice flies counter */
	private int pitcherSacrificeFlies;
	/** Pitcher data : Bases on ball counter */
	private int pitcherBaseOnBalls;
	/** Pitcher data : Intentional bases on ball counter */
	private int pitcherIntentionalBaseOnBalls;
	/** Pitcher data : Intentional Hit by pitch counter */
	private int pitcherHitByPitchs;
	/** Pitcher data : interference or obstruction counter */
	private int pitcherIos;
	/** Pitcher data : Strike out counter */
	private int pitcherStrikeOuts;
	/** Pitcher data : Wild pitchs counter */
	private int pitcherWildPitchs;
	/** Pitcher data : Balks counter */
	private int pitcherBalks;

	/**
	 * Get Offensive stolen bases counter.
	 * 
	 * @return number of stolen bases
	 */
	public int getOffensiveStolenBases() {
		return offensiveStolenBases;
	}

	/**
	 * Add stolen bases in the Offensive stolen bases counter.
	 * 
	 * @param stolenBases number of stolen bases to add
	 */
	public void addOffensiveStolenBases(int stolenBases) {
		offensiveStolenBases += stolenBases;
	}

	/**
	 * Get Offensive caught stealing counter.
	 * 
	 * @return number of caught stealing
	 */
	public int getOffensiveCaughtStealings() {
		return offensiveCaughtStealings;
	}

	/**
	 * Add caught stealing in the Offensive caught stealing counter.
	 * 
	 * @param caughtStealings number of caught stealing to add
	 */
	public void addOffensiveCaughtStealings(int caughtStealings) {
		offensiveCaughtStealings += caughtStealings;
	}

	/**
	 * Get Offensive IPs counter.
	 * 
	 * @return number of ips
	 */
	public double getOffensiveIps() {
		return offensiveIps;
	}

	/**
	 * Add Ips in the Offensive Ips Counter.
	 * 
	 * @param offensiveIps number of Ips to add
	 */
	public void addOffensiveIps(double offensiveIps) {
		this.offensiveIps += offensiveIps;
	}

	/**
	 * Get Offensive Plate appearance counter.
	 * 
	 * @return number of Plate appearance
	 */
	public int getOffensivesPAs() {
		return offensivePAs;
	}

	/**
	 * Add plates appearance in the Offensive plates appearance counter.
	 * 
	 * @param offensivesPAs number of plates appearance to add
	 */
	public void addOffensivesPAs(int offensivesPAs) {
		this.offensivePAs += offensivesPAs;
	}

	/**
	 * Get Offensive At bats counter.
	 * 
	 * @return number of At bats
	 */
	public int getOffensiveAtBats() {
		return offesnviveAtBats;
	}

	/**
	 * Add At bats in the Offensive At bats counter.
	 * 
	 * @param offesnvivesAtBats number of At bats to add
	 */
	public void addOffesnvivesAtBats(int offesnvivesAtBats) {
		this.offesnviveAtBats += offesnvivesAtBats;
	}

	/**
	 * Get Offensive Runs counter.
	 * 
	 * @return number of runs
	 */
	public int getOffensiveRuns() {
		return offensiveRuns;
	}

	/**
	 * Add runs in the Offensive runs counter.
	 * 
	 * @param offensivesRuns number of runs to add
	 */
	public void addOffensivesRuns(int offensivesRuns) {
		this.offensiveRuns += offensivesRuns;
	}

	/**
	 * Get Offensive hits counter.
	 * 
	 * @return number of Hits
	 */
	public int getOffensiveHits() {
		return offensiveHits;
	}

	/**
	 * Add hits in the Offensive hits counter.
	 * 
	 * @param offensivesHits number of hits to add
	 */
	public void addOffensivesHits(int offensivesHits) {
		this.offensiveHits += offensivesHits;
	}

	/**
	 * Get Offensive double hits counter.
	 * 
	 * @return number of double hits
	 */
	public int getOffensiveDoubleHits() {
		return offensiveDoubleHits;
	}

	/**
	 * Add double hits in the Offensive double hits counter.
	 * 
	 * @param offensiveDoubleHits number of double hits to add
	 */
	public void addOffensiveDoubleHits(int offensiveDoubleHits) {
		this.offensiveDoubleHits += offensiveDoubleHits;
	}

	/**
	 * Get Offensive triple hits counter.
	 * 
	 * @return number of triple hits
	 */
	public int getOffensiveTripleHits() {
		return offensiveTripleHits;
	}

	/**
	 * Add triple hits in the Offensive triple hits counter.
	 * 
	 * @param offensivesTripleHits number of triple hits to add
	 */
	public void addOffensivesTripleHits(int offensivesTripleHits) {
		this.offensiveTripleHits += offensivesTripleHits;
	}

	/**
	 * Get Offensive home run counter.
	 * 
	 * @return number of home runs
	 */
	public int getOffensiveHomeruns() {
		return offensiveHomeruns;
	}

	/**
	 * Add home runs in the Offensive home runs counter.
	 * 
	 * @param offensiveHomeruns number of home runs to add
	 */
	public void addOffensiveHomeruns(int offensiveHomeruns) {
		this.offensiveHomeruns += offensiveHomeruns;
	}

	/**
	 * Get Offensive grounded double plays counter.
	 * 
	 * @return number of grounded double plays
	 */
	public int getOffensiveGDPs() {
		return offensiveGDPs;
	}

	/**
	 * Add grounded double plays in the Offensive grounded double plays counter.
	 * 
	 * @param offensiveGDPs number of grounded double plays to add
	 */
	public void addOffensiveGDPs(int offensiveGDPs) {
		this.offensiveGDPs += offensiveGDPs;
	}

	/**
	 * Get Offensive sacrifice hits counter.
	 * 
	 * @return number of sacrifice hits
	 */
	public int getOffensiveSacrificeHits() {
		return offensiveSacrificeHits;
	}

	/**
	 * Add sacrifice hits in the Offensive sacrifice hits counter.
	 * 
	 * @param offensiveSacrificeHits number of sacrifice hits to add
	 */
	public void addOffensiveSacrificeHits(int offensiveSacrificeHits) {
		this.offensiveSacrificeHits += offensiveSacrificeHits;
	}

	/**
	 * Get Offensive sacrifice flies counter.
	 * 
	 * @return number of sacrifice flies
	 */
	public int getOffensiveSacrificeFlies() {
		return offensiveSacrificeFlies;
	}

	/**
	 * Add sacrifice flies in the Offensive sacrifice flies counter.
	 * 
	 * @param offensiveSacrificeFlies number of sacrifice flies to add
	 */
	public void addOffensiveSacrificeFlies(int offensiveSacrificeFlies) {
		this.offensiveSacrificeFlies += offensiveSacrificeFlies;
	}

	/**
	 * Get Offensive bases on ball counter.
	 * 
	 * @return number of bases on ball
	 */
	public int getOffensiveBaseOnBalls() {
		return offensiveBaseOnBalls;
	}

	/**
	 * Add bases on ball in the Offensive bases on ball counter.
	 * 
	 * @param offensiveBaseOnBalls number of bases on ball to add
	 */
	public void addOffensiveBaseOnBalls(int offensiveBaseOnBalls) {
		this.offensiveBaseOnBalls += offensiveBaseOnBalls;
	}

	/**
	 * Get Offensive intentional bases on ball counter.
	 * 
	 * @return number of intentional bases on ball
	 */
	public int getOffensiveIntentionalBaseOnBall() {
		return offensiveIntentionalBaseOnBall;
	}

	/**
	 * Add intentional bases on ball in the Offensive intentional bases on ball
	 * counter.
	 * 
	 * @param offensiveIntentionalBaseOnBall number of intentional bases on ball to
	 *                                       add
	 */
	public void addOffensiveIntentionalBaseOnBall(int offensiveIntentionalBaseOnBall) {
		this.offensiveIntentionalBaseOnBall += offensiveIntentionalBaseOnBall;
	}

	/**
	 * Get Offensive hits by pitch counter.
	 * 
	 * @return number of hits by pitch
	 */
	public int getOffensiveHitByPitchs() {
		return offensiveHitByPitchs;
	}

	/**
	 * Add hits by pitch in the Offensive hits by pitch counter.
	 * 
	 * @param offensiveHitByPitchs number of hits by pitch to add
	 */
	public void addOffensiveHitByPitchs(int offensiveHitByPitchs) {
		this.offensiveHitByPitchs += offensiveHitByPitchs;
	}

	/**
	 * Get Offensive obstructions or interferences counter.
	 * 
	 * @return number of obstructions or interferences
	 */
	public int getOffensiveIOs() {
		return offensiveIOs;
	}

	/**
	 * Add interferences or obstructions in the Offensive interferences or
	 * obstructions counter.
	 * 
	 * @param offensiveIOs number of interferences or obstructions to add
	 */
	public void addOffensiveIOs(int offensiveIOs) {
		this.offensiveIOs += offensiveIOs;
	}

	/**
	 * Get Offensive strikes out counter.
	 * 
	 * @return number of Strikes out
	 */
	public int getOffensiveStrikeOuts() {
		return offensiveStrikeOuts;
	}

	/**
	 * Add strikes out in the Offensive strikes out counter.
	 * 
	 * @param offensiveStrikeOuts number of strikes out to add
	 */
	public void addOffensiveStrikeOuts(int offensiveStrikeOuts) {
		this.offensiveStrikeOuts += offensiveStrikeOuts;
	}

	/**
	 * Get Offensive RBis counter.
	 * 
	 * @return number of Rbi
	 */
	public int getOffensiveRbis() {
		return offensiveRbis;
	}

	/**
	 * Add RBIs in the Offensive RBIs counter.
	 * 
	 * @param offensiveRbis number of RBIs to add
	 */
	public void addOffensiveRbis(int offensiveRbis) {
		this.offensiveRbis += offensiveRbis;
	}

	/**
	 * Get Defensive IPs counter.
	 * 
	 * @return number of Ips
	 */
	public double getDefensiveIps() {
		return defensiveIps;
	}

	/**
	 * Add IPs in the defensive IPs counter.
	 * 
	 * @param defensiveIps number of IPs to add
	 */
	public void addDefensiveIps(double defensiveIps) {
		this.defensiveIps += defensiveIps;
	}

	/**
	 * Get Defensive put outs counter.
	 * 
	 * @return number of put outs
	 */
	public int getDefensivePutouts() {
		return defensivePutouts;
	}

	/**
	 * Add put outs in the defensive put outs counter.
	 * 
	 * @param defensivePutouts number of put outs to add
	 */
	public void addDefensivePutouts(int defensivePutouts) {
		this.defensivePutouts += defensivePutouts;
	}

	/**
	 * Get Defensive assistances counter.
	 * 
	 * @return number of assistances
	 */
	public int getDefensiveAssists() {
		return defensiveAssists;
	}

	/**
	 * Add assistances in the defensive assistances counter.
	 * 
	 * @param defensiveAssists number of assistances to add
	 */
	public void addDefensiveAssists(int defensiveAssists) {
		this.defensiveAssists += defensiveAssists;
	}

	/**
	 * Get Defensive errors counter.
	 * 
	 * @return number of errors
	 */
	public int getDefensiveErrors() {
		return defensiveErrors;
	}

	/**
	 * Add errors in the defensive errors counter.
	 * 
	 * @param defensiveErrors number of errors to add
	 */
	public void addDefensiveErrors(int defensiveErrors) {
		this.defensiveErrors = +defensiveErrors;
	}

	/**
	 * Get Defensive double play participation counter.
	 * 
	 * @return number of double play participation
	 */
	public int getDefensiveDoublePlays() {
		return defensiveDoublePlays;
	}

	/**
	 * Add double play participation in the defensive double play participation counter.
	 * 
	 * @param defensiveDoublePlays number of double play participation to add
	 */
	public void addDefensiveDoublePlays(int defensiveDoublePlays) {
		this.defensiveDoublePlays += defensiveDoublePlays;
	}

	/**
	 * Get catcher IPs counter.
	 * 
	 * @return number of Ips
	 */
	public double getCatcherIps() {
		return catcherIps;
	}

	/**
	 * Add IPs in the catcher IPs counter.
	 * 
	 * @param catcherIps number of IPs to add
	 */
	public void addCatcherIps(double catcherIps) {
		this.catcherIps = +catcherIps;
	}

	/**
	 * Get catcher pass balls counter.
	 * 
	 * @return number of pass balls
	 */
	public int getCatcherPassBalls() {
		return catcherPassBalls;
	}

	/**
	 * Add pass balls in the catcher pass balls counter.
	 * 
	 * @param catcherPassBalls number of pass balls to add
	 */
	public void addCatcherPassBalls(int catcherPassBalls) {
		this.catcherPassBalls += catcherPassBalls;
	}

	/**
	 * Get catcher caught stealing counter.
	 * 
	 * @return number of caught stealing
	 */
	public int getCatcherCaugthStealings() {
		return catcherCaugthStealings;
	}

	/**
	 * Add caught stealing in the catcher caught stealing counter.
	 * 
	 * @param catcherCaugthStealings number of caught stealing to add
	 */
	public void addCatcherCaugthStealings(int catcherCaugthStealings) {
		this.catcherCaugthStealings += catcherCaugthStealings;
	}

	/**
	 * Get catcher stolen bases counter.
	 * 
	 * @return number of stolen bases
	 */
	public int getCatcherStolenBases() {
		return catcherStolenBases;
	}

	/**
	 * Add stolen bases in the catcher stolen bases counter.
	 * 
	 * @param catcherStolenBases number of stolen bases to add
	 */
	public void addCatcherStolenBases(int catcherStolenBases) {
		this.catcherStolenBases += catcherStolenBases;
	}

	/**
	 * Get pitcher IPs counter.
	 * 
	 * @return number of Ips
	 */
	public double getPitcherIps() {
		return pitcherIps;
	}

	/**
	 * Add IPs in the pitcher IPs counter.
	 * 
	 * @param pitcherIps number of IPs to add
	 */
	public void addPitcherIps(double pitcherIps) {
		this.pitcherIps += pitcherIps;
	}

	/**
	 * Get pitcher batter front counter.
	 * 
	 * @return number of batter front
	 */
	public int getPitcherBatterFronts() {
		return pitcherBatterFronts;
	}

	/**
	 * Add pitcher batter front in the pitcher batter front counter.
	 * 
	 * @param pitcherBatterFronts number of batter front to add
	 */
	public void addPitcherBatterFronts(int pitcherBatterFronts) {
		this.pitcherBatterFronts += pitcherBatterFronts;
	}

	/**
	 * Get pitcher At bats counter.
	 * 
	 * @return number of At bats
	 */
	public int getPitcherAtbats() {
		return pitcherAtbats;
	}

	/**
	 * Add At bats in the pitcher At bats counter.
	 * 
	 * @param pitcherAtbats number of At bats to add
	 */
	public void addPitcherAtbats(int pitcherAtbats) {
		this.pitcherAtbats += pitcherAtbats;
	}

	/**
	 * Get pitcher runs counter.
	 * 
	 * @return number of runs
	 */
	public int getPitcherRuns() {
		return pitcherRuns;
	}

	/**
	 * Add runs in the pitcher runs counter.
	 * 
	 * @param pitcherRuns number of runs to add
	 */
	public void addPitcherRuns(int pitcherRuns) {
		this.pitcherRuns += pitcherRuns;
	}

	/**
	 * Get pitcher earned runs counter.
	 * 
	 * @return number of earned runs
	 */
	public int getPitcherEarnedRuns() {
		return pitcherEarnedRuns;
	}

	/**
	 * Add earned runs in the pitcher earned runs counter.
	 * 
	 * @param pitcherEarnedRuns number of earned runs to add
	 */
	public void addPitcherEarnedRuns(int pitcherEarnedRuns) {
		this.pitcherEarnedRuns += pitcherEarnedRuns;
	}

	/**
	 * Get pitcher hits counter.
	 * 
	 * @return number of hits
	 */
	public int getPitcherHits() {
		return pitcherHits;
	}

	/**
	 * Add hits in the pitcher hits counter.
	 * 
	 * @param pitcherHits number of hits to add
	 */
	public void addPitcherHits(int pitcherHits) {
		this.pitcherHits += pitcherHits;
	}

	/**
	 * Get pitcher double hits counter.
	 * 
	 * @return number of double hits
	 */
	public int getPitchesDoubleHits() {
		return pitchesDoubleHits;
	}

	/**
	 * Add double hits in the pitcher double hits counter.
	 * 
	 * @param pitchesDoubleHits number of double hits to add
	 */
	public void addPitchesDoubleHits(int pitchesDoubleHits) {
		this.pitchesDoubleHits += pitchesDoubleHits;
	}

	/**
	 * Get pitcher triple hits counter.
	 * 
	 * @return number of triple hits
	 */
	public int getPitcherTripleHits() {
		return pitcherTripleHits;
	}

	/**
	 * Add triple hits in the pitcher triple hits counter.
	 * 
	 * @param pitcherTripleHits number of triple hits to add
	 */
	public void addPitcherTripleHits(int pitcherTripleHits) {
		this.pitcherTripleHits += pitcherTripleHits;
	}

	/**
	 * Get pitcher home runs counter.
	 * 
	 * @return number of home runs
	 */
	public int getPitcherHomeruns() {
		return pitcherHomeruns;
	}

	/**
	 * Add home runs in the pitcher home runs counter.
	 * 
	 * @param pitcherHomeruns number of home runs to add
	 */
	public void addPitcherHomeruns(int pitcherHomeruns) {
		this.pitcherHomeruns += pitcherHomeruns;
	}

	/**
	 * Get sacrifice hits counter.
	 * 
	 * @return number of sacrifice hits
	 */
	public int getPitcherSacrificeHits() {
		return pitcherSacrificeHits;
	}

	/**
	 * Add sacrifice hits in the pitcher sacrifice hits counter.
	 * 
	 * @param pitcherSacrificeHits number of sacrifice hits to add
	 */
	public void addPitcherSacrificeHits(int pitcherSacrificeHits) {
		this.pitcherSacrificeHits += pitcherSacrificeHits;
	}

	/**
	 * Get sacrifice flies counter.
	 * 
	 * @return number of sacrifice flies
	 */
	public int getPitcherSacrificeFlies() {
		return pitcherSacrificeFlies;
	}

	/**
	 * Add sacrifice flies in the pitcher sacrifice flies counter.
	 * 
	 * @param pitcherSacrificeFlies number of sacrifice flies to add
	 */
	public void addPitcherSacrificeFlies(int pitcherSacrificeFlies) {
		this.pitcherSacrificeFlies += pitcherSacrificeFlies;
	}

	/**
	 * Get bases on ball counter.
	 * 
	 * @return number of bases on ball
	 */
	public int getPitcherBaseOnBalls() {
		return pitcherBaseOnBalls;
	}

	/**
	 * Add bases on ball in the pitcher bases on ball counter.
	 * 
	 * @param pitcherBaseOnBalls number of bases on ball to add
	 */
	public void addPitcherBaseOnBalls(int pitcherBaseOnBalls) {
		this.pitcherBaseOnBalls += pitcherBaseOnBalls;
	}

	/**
	 * Get intentional bases on ball counter.
	 * 
	 * @return number of intentional bases on ball
	 */
	public int getPitcherIntentionalBaseOnBalls() {
		return pitcherIntentionalBaseOnBalls;
	}

	/**
	 * Add intentional bases on ball in the pitcher intentional bases on ball counter.
	 * 
	 * @param pitcherIntentionalBaseOnBalls number of intentional bases on ball to add
	 */
	public void addPitcherIntentionalBaseOnBalls(int pitcherIntentionalBaseOnBalls) {
		this.pitcherIntentionalBaseOnBalls += pitcherIntentionalBaseOnBalls;
	}

	/**
	 * Get hit by pitch counter.
	 * 
	 * @return number of hit by pitch
	 */
	public int getPitcherHitByPitchs() {
		return pitcherHitByPitchs;
	}

	/**
	 * Add hit by pitch in the pitcher hit by pitch counter.
	 * 
	 * @param pitcherHitByPitchs number of hit by pitch to add
	 */
	public void addPitcherHitByPitchs(int pitcherHitByPitchs) {
		this.pitcherHitByPitchs += pitcherHitByPitchs;
	}

	/**
	 * Get interferences or obstructions counter.
	 * 
	 * @return number of interferences or obstructions
	 */
	public int getPitcherIos() {
		return pitcherIos;
	}

	/**
	 * Add interferences or obstructions in the pitcher interferences or obstructions counter.
	 * 
	 * @param pitcherIos number of interferences or obstructions to add
	 */
	public void addPitcherIos(int pitcherIos) {
		this.pitcherIos += pitcherIos;
	}

	/**
	 * Get strike outs counter.
	 * 
	 * @return number of strike outs
	 */
	public int getPitcherStrikeOuts() {
		return pitcherStrikeOuts;
	}

	/**
	 * Add strike outs in the pitcher strike outs counter.
	 * 
	 * @param pitcherStrikeOuts number of strike outs to add
	 */
	public void addPitcherStrikeOuts(int pitcherStrikeOuts) {
		this.pitcherStrikeOuts += pitcherStrikeOuts;
	}

	/**
	 * Get wild pitches counter.
	 * 
	 * @return number of wild pitches
	 */
	public int getPitcherWildPitchs() {
		return pitcherWildPitchs;
	}

	/**
	 * Add wild pitches in the pitcher wild pitches counter.
	 * 
	 * @param pitcherWildPitchs number of wild pitches to add
	 */
	public void addPitcherWildPitchs(int pitcherWildPitchs) {
		this.pitcherWildPitchs += pitcherWildPitchs;
	}

	/**
	 * Get balks counter.
	 * 
	 * @return number of balks
	 */
	public int getPitcherBalks() {
		return pitcherBalks;
	}

	/**
	 * Add balks in the pitcher balks counter.
	 * 
	 * @param pitcherBalks number of balks to add
	 */
	public void addPitcherBalks(int pitcherBalks) {
		this.pitcherBalks += pitcherBalks;
	}
}
