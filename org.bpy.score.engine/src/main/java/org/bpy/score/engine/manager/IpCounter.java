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
package org.bpy.score.engine.manager;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;

/**
 * IP manager class. Allow to compute IPs
 * 
 * @author Patrick BRIAND
 *
 */
public class IpCounter {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(IpCounter.class.getSimpleName());

	/** IP counter */
	private double ipCounterValue;

	/**
	 * Constructor of the class. Initialize some fields
	 */
	public IpCounter() {
		ipCounterValue = 0.0;
	}

	/**
	 * Constructor of the class. Initialize some fields
	 * @param value Ip value
	 */
	public IpCounter(double value) {
		ipCounterValue = value;
	}


	/**
	 * Get the new value of the IP counter.
	 * 
	 * @return Ip Counter value
	 */
	public double getIpCounter() {
		return getIpCounter(0.0);
	}

	/**
	 * Get the value of the IP counter since an previous value.
	 * 
	 * @param previousIpCounter previous value of IP counter
	 * @return The IP value
	 */
	public double getIpCounter(double previousIpCounter) {
		long currentOut = getNbOuts(ipCounterValue);
		long previousOut = getNbOuts(previousIpCounter);

		return getIpValue(currentOut - previousOut);
	}

	/**
	 * Compute the IP value for a number of put outs.
	 * 
	 * @param nbOut number of put outs.
	 * 
	 * @return IP value
	 */
	private double getIpValue(long nbOut) {

		double ipCounter = (int)((double)nbOut / 3.0);
		ipCounter += (double) (nbOut % 3) / 10.0;
		return ipCounter;
	}

	/**
	 * Compute the number of put outs from an IP value.
	 * 
	 * @param ipValue IP value
	 * @return Number of put outs
	 */
	private long getNbOuts(double ipValue) {
		long counter = Math.round(ipValue) * 3;
		ipValue -= Math.round(ipValue);
		counter += Math.round(ipValue * 10);
		return counter;
	}

	/**
	 * Add a put out to the IP
	 */
	public void addPutOut() {
		ipCounterValue += 0.1;
	}

	/**
	 * Compute the new IP value from the current IP value and the a number of put
	 * outs
	 * 
	 * @param currentIps     Current IP value
	 * @param putoutDetected Put outs detected
	 * 
	 * @return New IP value
	 */
	public double getNewIpValue(double currentIps, int putoutDetected) {
		long currentNbOuts = getNbOuts(currentIps);
		currentNbOuts += putoutDetected;
		return getIpValue(currentNbOuts);
	}

	/**
	 * Convert an IP value to an integer value.
	 * 
	 * @param ipPlayed IP Value
	 * @return integer value
	 */
	public static int intValue(double ipPlayed) {
		int nbPoutouts = (int) ipPlayed;

		ipPlayed -= nbPoutouts;
		nbPoutouts += (int) (ipPlayed * 10);
		return nbPoutouts;
	}

	/**
	 * For test.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		IpCounter obj = new IpCounter();
		obj.test();
		logger.log(Level.INFO,"unit test done and ok"); //$NON-NLS-1$
	}

	/**
	 * For test
	 */
	private void test() {
		double val;
		ipCounterValue = 2.1;
		val = getIpCounter(0.0); /* val = 2.1 */
		Assert.isTrue("2.1".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 5.2;
		val = getIpCounter(1.2); /* val = 4.0 */
		Assert.isTrue("4.0".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 6.1;
		val = getIpCounter(2.2); /* val = 3.2 */
		Assert.isTrue("3.2".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 6.0;
		val = getIpCounter(2.2); /* val = 3.1 */
		Assert.isTrue("3.1".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 0.0;
		val = getIpCounter(0.0); /* val = 0.0 */
		Assert.isTrue("0.0".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 0.2;
		val = getIpCounter(0.0); /* val = 0.2 */
		Assert.isTrue("0.2".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$

		ipCounterValue = 9.0;
		val = getIpCounter(0.0); /* val = 9.0 */
		Assert.isTrue("9.0".equals("" + val)); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
