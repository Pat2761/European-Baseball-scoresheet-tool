package org.bpy.score.engine.tests;

import org.bpy.score.engine.manager.IpCounter;
import org.junit.Assert;
import org.junit.Test;

public class IPUtilTest {

	@Test
	public void test01() {
		IpCounter ipCounter = new IpCounter(2.1);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "2.1", ""+val);
	}	
		
	@Test
	public void test02() {
		IpCounter ipCounter = new IpCounter(5.2);
		double val = ipCounter.getIpCounter(1.2); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "4.0", ""+val);
	}
	
	@Test
	public void test03() {
		IpCounter ipCounter = new IpCounter(6.1);
		double val = ipCounter.getIpCounter(2.2); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "3.2", ""+val);
	}

	@Test
	public void test04() {
		IpCounter ipCounter = new IpCounter(6.0);
		double val = ipCounter.getIpCounter(2.2); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "3.1", ""+val);
	}

	@Test
	public void test05() {
		IpCounter ipCounter = new IpCounter();
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "0.0", ""+val);
	}

	@Test
	public void test06() {
		IpCounter ipCounter = new IpCounter(0.2);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "0.2", ""+val);
	}

	@Test
	public void test07() {
		IpCounter ipCounter = new IpCounter(9.0);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		Assert.assertEquals("Ip Value computatione error", "9.0", ""+val);
	}

}
