package common.junit;

import org.junit.Test;

import common.Parameter;

/**
 * JUnit test class for class Parameter.
 * 
 * @author Michael Duo Ling
 * 
 */
public class ParameterTest extends UnitTestBase {

	@Test
	public void testConstructorNormal() throws Exception {
		@SuppressWarnings("unused")
		Parameter p = new Parameter(15, 0, 8, "", "");
	}

	@Test
	public void testToBinaryString() throws Exception {
		Parameter p = new Parameter(15, 0, 5, "RELOADED", "TEST");
		this.assertEquals("0101", p.toBinaryString());
	}

	@Test
	public void testToString() throws Exception {
		Parameter p = new Parameter(15, 0, 5, "RELOADED_", "_TEST");
		this.assertEquals("RELOADED_5_TEST", p.toString());
	}
}
