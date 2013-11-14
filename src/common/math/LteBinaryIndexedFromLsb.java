package common.math;

import org.junit.Test;

import common.BasicBaseClass;

/*
 * Binary indexed from LSB (Least Significant Bit):
 * 	decimal:10
 * 	hex:	A
 * 	binary:	1 0 1 0
 * 	index:	3 2 1 0
 */
public class LteBinaryIndexedFromLsb extends BinaryBaseClass {

	/*
	 * Construct a new object holding an integer (initValue) with maximum size
	 * in bits (size), which is indexed from least significant bit.
	 */
	public LteBinaryIndexedFromLsb(Integer size, Integer initValue)
			throws Exception {
		super(size, initValue);
	}

	/**
	 * this divided by divisor, save quotient to this.
	 * 
	 * @param dividend
	 * @return remainder
	 * @throws Exception
	 */
	public LteBinaryIndexedFromLsb dividedBy(LteBinaryIndexedFromLsb divisor)
			throws Exception {
		Integer dividend = this.toInteger();
		Integer d = divisor.toInteger();
		this.setToInteger(dividend / d);
		return new LteBinaryIndexedFromLsb(this.size, dividend % d);
		// int dividentSize = this.size;
		// LteBinaryIndexedFromMsb dividend = new LteBinaryIndexedFromMsb(this);
		// LteBinaryIndexedFromMsb remainder = null;
		// this.clear(); // set quotient to 0
		// if (dividend.compareTo(divisorIn) < 0) {
		// // dividend is smaller than divisor
		// // quotient is 0, remainder is dividend
		// remainder = new LteBinaryIndexedFromMsb(dividend);
		// } else {
		// // dividend is bigger or equal to divisor
		// dividend.chopAllLeadingZero();
		// LteBinaryIndexedFromMsb divisor = new LteBinaryIndexedFromMsb(
		// divisorIn);
		// divisor.chopAllLeadingZero();
		// // align left-most digits in dividend and divisor
		// divisor.shiftLeft(dividend.size-divisor.size);
		//
		// }
		//
		//
		//
		// return remainder;
	}

	@Override
	public Bit getBit(Integer index) throws Exception {
		return new Bit(this.bitSet.get(index));
	}

	@Override
	public boolean getBoolean(int index) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinary.get(int index)!");
		return this.bitSet.get(index);
	}

	public Integer getInt(Integer index) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinary.get(int index)!");
		return this.bitSet.get(index) ? 1 : 0;
	}

	@Override
	public void insert(BinaryBaseClass binary, Integer position)
			throws Exception {
		BasicBaseClass.garantee((position > -1) && (position <= this.size),
				"Invalid position=" + position + ", this.size=" + this.size);
		if (position == 0) {
			this.append(binary);
		} else if (position == this.size) {
			this.size += binary.size;
			for (int i = 0; i < binary.size; i++) {
				this.set(i + position, binary.getBit(i));
			}
		} else {
			this.size += binary.size;
			for (int i = this.size - 1; i >= (position + binary.size); i--) {
				this.set(i, this.getBit(i - binary.size));
			}
			for (int i = 0; i < binary.size; i++) {
				this.set(i + position, binary.getBit(i));
			}
		}
	}

	/**
	 * @param factor
	 * @throws Exception
	 */
	@Test
	public void multipliedBy(LteBinaryIndexedFromLsb factor) throws Exception {
		Integer a = this.toInteger();
		Integer b = factor.toInteger();
		this.setToInteger(a * b);
	}

	@Override
	public void set(Integer index, Bit bit) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinary.set(int index)!");
		this.bitSet.set(index, bit.toBoolean());
	}

	@Override
	public void shiftLeft(Integer bits) throws Exception {
		BasicBaseClass.garantee(bits >= 0,
				"shiftLeft has to take positive number of bits, but is given bits="
						+ bits);
		this.size += bits;
		for (int i = this.size - 1; i > (bits - 1); i--) {
			this.bitSet.set(i, this.bitSet.get(i - bits));
		}
		for (int i = bits - 1; i > -1; i--) {
			this.bitSet.set(i, false);
		}
	}

	@Override
	public String toReadableString() {
		return toBinaryString();
	}

}
