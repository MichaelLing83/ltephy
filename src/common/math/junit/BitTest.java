package common.math.junit;

import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.Bit;

/**
 * JUnit test class for class Bit.
 * 
 * @author Michael Duo Ling
 * 
 */
public class BitTest extends UnitTestBase {
	@Test
	public void testBitOperation() throws Exception {
		// AND
		this.assertTrue(!new Bit(0).and(new Bit(0)).toBoolean());
		this.assertTrue(!new Bit(0).and(new Bit(1)).toBoolean());
		this.assertTrue(!new Bit(1).and(new Bit(0)).toBoolean());
		this.assertTrue(new Bit(1).and(new Bit(1)).toBoolean());
		// OR
		this.assertTrue(!new Bit(0).or(new Bit(0)).toBoolean());
		this.assertTrue(new Bit(0).or(new Bit(1)).toBoolean());
		this.assertTrue(new Bit(1).or(new Bit(0)).toBoolean());
		this.assertTrue(new Bit(1).or(new Bit(1)).toBoolean());
		// XOR
		this.assertTrue(!new Bit(0).xor(new Bit(0)).toBoolean());
		this.assertTrue(new Bit(0).xor(new Bit(1)).toBoolean());
		this.assertTrue(new Bit(1).xor(new Bit(0)).toBoolean());
		this.assertTrue(!new Bit(1).xor(new Bit(1)).toBoolean());
		// NOT
		this.assertTrue(new Bit(0).not().toBoolean());
		this.assertTrue(!new Bit(1).not().toBoolean());
	}

	@Test
	public void testCompare() throws Exception {
		Bit zero = new Bit(0);
		Bit one = new Bit(1);
		this.assertEquals(-1, zero.compareTo(one));
		this.assertEquals(1, one.compareTo(zero));
		this.assertEquals(0, zero.compareTo(zero));
	}

	@Test
	public void testConstructorAbnormal() throws Exception {
		Statements ss = new Statements() {
			@Override
			public void runStatements() throws Exception {
				new Bit(-1);
			}
		};
		this.assertThrowException(ss, "bit=-1 is not valid for one bit!", true);
		ss = new Statements() {
			@Override
			public void runStatements() throws Exception {
				new Bit(2);
			}
		};
		this.assertThrowException(ss, "bit=2 is not valid for one bit!", true);
	}

	@Test
	public void testConstructorNormal() throws Exception {
		@SuppressWarnings("unused")
		Bit bit = new Bit(0);
		bit = new Bit(1);
		bit = new Bit(true);
		bit = new Bit(false);
	}

	@Test
	public void testIsOne() throws Exception {
		this.assertTrue(!new Bit(0).isOne());
		this.assertTrue(new Bit(1).isOne());
	}

	@Test
	public void testSetBit() throws Exception {
		Bit bit = new Bit(0);
		bit.setBitValue(1);
		this.assertEquals(true, bit.isOne());
		bit.setBitValue(0);
		this.assertEquals(false, bit.isOne());
		bit.setBit(true);
		this.assertEquals(true, bit.isOne());
		bit.setBit(false);
		this.assertEquals(false, bit.isOne());
	}

	@Test
	public void testSetBitAbnormal() throws Exception {
		final Bit bit = new Bit(0);
		Statements ss = new Statements() {
			@Override
			public void runStatements() throws Exception {
				bit.setBitValue(2);
			}
		};
		this.assertThrowException(ss, "Invalid argument=2!", true);
	}

	@Test
	public void testToString() throws Exception {
		this.assertEquals("0", new Bit(0).toBinaryString());
		this.assertEquals("1", new Bit(1).toBinaryString());
		this.assertEquals("0", new Bit(0).toString());
		this.assertEquals("1", new Bit(1).toString());
	}
}
