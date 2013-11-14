package common.math.junit;

import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.Bit;
import common.math.LteBinaryIndexedFromMsb;

public class LteBinaryIndexedFromMsbTest extends UnitTestBase {

	@Test
	public void testAddedBy() throws Exception {
		LteBinaryIndexedFromMsb a = new LteBinaryIndexedFromMsb(4, 10);
		a.addedBy(new LteBinaryIndexedFromMsb(2, 3));
		this.assertEquals("1101", a.toBinaryString());

		a.subtractedBy(new LteBinaryIndexedFromMsb(2, 3));
		this.assertEquals("1010", a.toBinaryString());

		a.clear();
		this.assertEquals("0000", a.toBinaryString());
	}

	@Test
	public void testAppend() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		bin.append(new LteBinaryIndexedFromMsb(1, 0));
		this.assertEquals("10100", bin.toBinaryString());
		bin.append(new LteBinaryIndexedFromMsb(2, 3));
		this.assertEquals("1010011", bin.toBinaryString());
	}

	@Test
	public void testBitOperation() throws Exception {
		LteBinaryIndexedFromMsb x = new LteBinaryIndexedFromMsb(4, 10);
		LteBinaryIndexedFromMsb y = new LteBinaryIndexedFromMsb(4, 10);
		y.chopMsb(1);
		// 1010 & 010
		x.and(y);
		this.assertEquals("0010", x.toBinaryString());

		x = new LteBinaryIndexedFromMsb(4, 10);
		y = new LteBinaryIndexedFromMsb(4, 10);
		y.chopMsb(1);
		// 1010 | 010
		x.or(y);
		this.assertEquals("1010", x.toBinaryString());

		x = new LteBinaryIndexedFromMsb(4, 10);
		y = new LteBinaryIndexedFromMsb(4, 10);
		y.chopMsb(1);
		// 1010 ^ 010
		x.xor(y);
		this.assertEquals("1000", x.toBinaryString());
	}

	@Test
	public void testChopAllLeadingZero() throws Exception {
		// 0011
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 3);
		bin.chopAllLeadingZero();
		this.assertEquals("11", bin.toBinaryString());
	}

	@Test
	public void testChopLeadingZero() throws Exception {
		// 0011
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 3);
		bin.chopLeadingZero();
		this.assertEquals("011", bin.toBinaryString());
	}

	@Test
	public void testChopMsb() throws Exception {
		// 0011
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 3);
		bin.chopAllLeadingZero();
		bin.chopMsb(1);
		this.assertEquals("1", bin.toBinaryString());
	}

	@Test
	public void testCompareTo() throws Exception {
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(1, bin.compareTo(new LteBinaryIndexedFromMsb(1, 1)));
		this.assertEquals(-1, bin.compareTo(new LteBinaryIndexedFromMsb(4, 11)));
		this.assertEquals(0, bin.compareTo(new LteBinaryIndexedFromMsb(4, 10)));
	}

	@Test
	public void testConstructorNormal() throws Exception {
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(1, 0);
		bin = new LteBinaryIndexedFromMsb(1, 1);
		bin = new LteBinaryIndexedFromMsb(10, 0);
		bin = new LteBinaryIndexedFromMsb(100, 0);
		bin = new LteBinaryIndexedFromMsb(1000, 0);
		bin = new LteBinaryIndexedFromMsb(10000, 0);
		bin = new LteBinaryIndexedFromMsb(100000, 0);
		bin = new LteBinaryIndexedFromMsb(1000000, 0);

		@SuppressWarnings("unused")
		LteBinaryIndexedFromMsb a = new LteBinaryIndexedFromMsb(bin);
	}

	@Test
	public void testDividedBy() throws Exception {
		// 11010 / 101 = 101, remainder = 1
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(5, 0b11010);
		LteBinaryIndexedFromMsb remainder = bin
				.dividedBy(new LteBinaryIndexedFromMsb(3, 0b101));
		this.assertEquals("00101", bin.toBinaryString());
		this.assertEquals("00001", remainder.toBinaryString());

		bin.multipliedBy(new LteBinaryIndexedFromMsb(3, 0b101));
		bin.addedBy(remainder);
		this.assertEquals("11010", bin.toBinaryString());
	}

	@Test
	public void testEquals() throws Exception {
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertTrue(!bin.equals(new LteBinaryIndexedFromMsb(1, 1)));
		this.assertTrue(bin.equals(new LteBinaryIndexedFromMsb(4, 10)));
	}

	@Test
	public void testGetBit() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(new Bit(1).equals(bin.getBit(0)), true);
	}

	@Test
	public void testGetBoolean() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(bin.getBoolean(0), true);
		this.assertEquals(bin.getBoolean(1), false);
		this.assertEquals(bin.getBoolean(2), true);
		this.assertEquals(bin.getBoolean(3), false);
	}

	@Test
	public void testGetInt() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(bin.getInt(0), 1);
		this.assertEquals(bin.getInt(1), 0);
		this.assertEquals(bin.getInt(2), 1);
		this.assertEquals(bin.getInt(3), 0);
	}

	@Test
	public void testGetMsb() throws Exception {
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(new Bit(1), bin.getMsb());
	}

	@Test
	public void testInsert() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		bin.insert(new LteBinaryIndexedFromMsb(2, 2), 0);
		this.assertEquals("101010", bin.toBinaryString());
		bin.insert(new LteBinaryIndexedFromMsb(2, 1), bin.getSize());
		this.assertEquals("10101001", bin.toBinaryString());
		bin.insert(new LteBinaryIndexedFromMsb(2, 1), 2);
		this.assertEquals("1001101001", bin.toBinaryString());

		// 1010
		LteBinaryIndexedFromMsb a = new LteBinaryIndexedFromMsb(4, 10);
		a.insert(new LteBinaryIndexedFromMsb(3, 5), 1);
		this.assertEquals("1101010", a.toBinaryString());
	}

	@Test
	public void testShiftRight() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		bin.shiftRight(2);
		this.assertEquals("10", bin.toBinaryString());
		bin.shiftRight(10);
		this.assertEquals("0", bin.toBinaryString());
	}

	@Test
	public void testToBinaryString() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(bin.toBinaryString(), "1010");
	}

	@Test
	public void testToInteger() throws Exception {
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(10, bin.toInteger());
	}

	@Test
	public void testToString() throws Exception {
		// 1010
		LteBinaryIndexedFromMsb bin = new LteBinaryIndexedFromMsb(4, 10);
		this.assertEquals(bin.toString(), "1010");
	}
}
