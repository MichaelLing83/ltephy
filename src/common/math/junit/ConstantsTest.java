package common.math.junit;

import org.junit.Test;

import common.junit.UnitTestBase;

/**
 * JUnit test class for class Bit.
 * 
 * @author Michael Duo Ling
 * 
 */
public class ConstantsTest extends UnitTestBase {
	@Test
	public void testBasicDataType() throws Exception {
		System.out.println("Short.size=" + Short.SIZE);
		System.out.println("Integer.size=" + Integer.SIZE);
		System.out.println("Long.size=" + Long.SIZE);
	}

}
