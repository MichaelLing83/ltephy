package common.math.junit;

import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.Bit;
import common.math.LteBinaryIndexedFromLsb;
import common.math.LteBinaryIndexedFromMsb;

public class LteBinaryIndexedFromLsbTest extends UnitTestBase {

	@Test
	public void testAppend() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		bin.append(new LteBinaryIndexedFromMsb(1, 0));
		this.assertEquals("10100", bin.toBinaryString());
		bin.append(new LteBinaryIndexedFromMsb(2, 3));
		this.assertEquals("1010011", bin.toBinaryString());
	}

	@Test
	public void testChopAllLeadingZero() throws Exception {
		// 0011
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 3);
		bin.chopAllLeadingZero();
		this.assertEquals("11", bin.toBinaryString());
	}

	@Test
	public void testChopLeadingZero() throws Exception {
		// 0011
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 3);
		bin.chopLeadingZero();
		this.assertEquals("011", bin.toBinaryString());
	}

	@Test
	public void testChopMsb() throws Exception {
		// 0011
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 3);
		bin.chopAllLeadingZero();
		bin.chopMsb(1);
		this.assertEquals("1", bin.toBinaryString());
	}

	@Test
	public void testConstructorNormal() throws Exception {
		@SuppressWarnings("unused")
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(1, 0);
		bin = new LteBinaryIndexedFromLsb(1, 1);
		bin = new LteBinaryIndexedFromLsb(10, 0);
		bin = new LteBinaryIndexedFromLsb(100, 0);
		bin = new LteBinaryIndexedFromLsb(1000, 0);
		bin = new LteBinaryIndexedFromLsb(10000, 0);
		bin = new LteBinaryIndexedFromLsb(100000, 0);
		bin = new LteBinaryIndexedFromLsb(1000000, 0);
	}

	@Test
	public void testDividedBy() throws Exception {
		// 11010 / 101 = 101, remainder = 1
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(5, 0b11010);
		LteBinaryIndexedFromLsb remainder = bin
				.dividedBy(new LteBinaryIndexedFromLsb(3, 0b101));
		this.assertEquals("00101", bin.toBinaryString());
		this.assertEquals("00001", remainder.toBinaryString());

		bin.multipliedBy(new LteBinaryIndexedFromLsb(3, 0b101));
		bin.addedBy(remainder);
		this.assertEquals("11010", bin.toBinaryString());
	}

	@Test
	public void testEquals() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertTrue(!bin.equals(new LteBinaryIndexedFromLsb(1, 1)));
		this.assertEquals(new LteBinaryIndexedFromLsb(4, 10),
				new LteBinaryIndexedFromLsb(4, 10));
	}

	@Test
	public void testGetBit() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertEquals(new Bit(0), bin.getBit(0));
		this.assertEquals(new Bit(1), bin.getBit(1));
		this.assertEquals(new Bit(0), bin.getBit(2));
		this.assertEquals(new Bit(1), bin.getBit(3));
	}

	@Test
	public void testGetBoolean() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertEquals(bin.getBoolean(0), false);
		this.assertEquals(bin.getBoolean(1), true);
		this.assertEquals(bin.getBoolean(2), false);
		this.assertEquals(bin.getBoolean(3), true);
	}

	@Test
	public void testGetInt() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertEquals(bin.getInt(0), 0);
		this.assertEquals(bin.getInt(1), 1);
		this.assertEquals(bin.getInt(2), 0);
		this.assertEquals(bin.getInt(3), 1);
	}

	@Test
	public void testInsert() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		bin.insert(new LteBinaryIndexedFromLsb(2, 2), 0);
		this.assertEquals("101010", bin.toBinaryString());
		bin.insert(new LteBinaryIndexedFromLsb(2, 1), bin.getSize());
		this.assertEquals("01101010", bin.toBinaryString());
		bin.insert(new LteBinaryIndexedFromLsb(2, 1), 2);
		this.assertEquals("0110100110", bin.toBinaryString());

		// 1010
		LteBinaryIndexedFromLsb a = new LteBinaryIndexedFromLsb(4, 10);
		a.insert(new LteBinaryIndexedFromLsb(3, 5), 1);
		this.assertEquals("1011010", a.toBinaryString());
	}

	@Test
	public void testToBinaryString() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertEquals(bin.toBinaryString(), "1010");
	}

	@Test
	public void testToInteger() throws Exception {
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertTrue(10 == bin.toInteger());
	}

	@Test
	public void testToString() throws Exception {
		// 1010
		LteBinaryIndexedFromLsb bin = new LteBinaryIndexedFromLsb(4, 10);
		this.assertEquals(bin.toString(), "1010");
	}
}
