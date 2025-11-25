package org.bpy.score.engine.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bpy.score.engine.manager.IpCounter;
import org.junit.jupiter.api.Test;

public class IPUtilTest {

	@Test
	void test01() {
		IpCounter ipCounter = new IpCounter(2.1);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		assertEquals("2.1", ""+val,"Ip Value computatione error");
	}	
		
	@Test
	void test02() {
		IpCounter ipCounter = new IpCounter(5.2);
		double val = ipCounter.getIpCounter(1.2); /* val = 2.1 */
		assertEquals("4.0", ""+val,"Ip Value computatione error");
	}
	
	@Test
	void test03() {
		IpCounter ipCounter = new IpCounter(6.1);
		double val = ipCounter.getIpCounter(2.2); /* val = 2.1 */
		assertEquals("3.2", ""+val, "Ip Value computatione error");
	}

	@Test
	void test04() {
		IpCounter ipCounter = new IpCounter(6.0);
		double val = ipCounter.getIpCounter(2.2); /* val = 2.1 */
		assertEquals("3.1", ""+val, "Ip Value computatione error");
	}

	@Test
	void test05() {
		IpCounter ipCounter = new IpCounter();
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		assertEquals("0.0", ""+val, "Ip Value computatione error");
	}

	@Test
	void test06() {
		IpCounter ipCounter = new IpCounter(0.2);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		assertEquals("0.2", ""+val, "Ip Value computatione error");
	}

	@Test
	void test07() {
		IpCounter ipCounter = new IpCounter(9.0);
		double val = ipCounter.getIpCounter(0.0); /* val = 2.1 */
		assertEquals("9.0", ""+val, "Ip Value computatione error");
	}

}
