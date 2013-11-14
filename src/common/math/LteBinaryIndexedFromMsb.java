package common.math;

import org.junit.Test;

import common.BasicBaseClass;

/**
 * Binary indexed from MSB (Most Significant Bit): decimal:10 hex: A binary: 1 0
 * 1 0 index: 0 1 2 3
 */
public class LteBinaryIndexedFromMsb extends BinaryBaseClass {

	public LteBinaryIndexedFromMsb(BinaryBaseClass anotherBin) throws Exception {
		super(anotherBin);
	}

	/**
	 * Construct a new object holding an integer (initValue) with maximum size
	 * in bits (size), which is indexed from most significant bit.
	 */
	public LteBinaryIndexedFromMsb(Integer size, Integer initValue)
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
	public LteBinaryIndexedFromMsb dividedBy(LteBinaryIndexedFromMsb divisorIn)
			throws Exception {
		Integer dividend = toInteger();
		Integer divisor = divisorIn.toInteger();
		setToInteger(dividend / divisor);
		return new LteBinaryIndexedFromMsb(size, dividend % divisor);
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
		return new Bit(bitSet.get(invertIndex(index)));
	}

	@Override
	public boolean getBoolean(int index) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinary.get(int index)!");
		return bitSet.get(invertIndex(index));
	}

	public Integer getInt(Integer index) throws Exception {
		BasicBaseClass
				.garantee(
						index > -1,
						"index="
								+ index
								+ " is invalid for LteBinaryIndexedFromMsb.get(Integer index)!");
		Integer result = 0;
		if (index < size) {
			result = bitSet.get(invertIndex(index)) ? 1 : 0;
		}
		return result;
	}

	@Override
	public void insert(BinaryBaseClass binary, Integer position)
			throws Exception {
		BasicBaseClass.garantee((position > -1) && (position < (size + 1)),
				"positon=" + position + " is invalid!");
		// position = this.invertIndex(position);
		if (position == 0) {
			size += binary.getSize();
			for (int i = 0; i < binary.getSize(); i++) {
				set(0, binary.getBit(0));
			}
		} else if (position == size) {
			append(binary);
		} else {
			size += binary.getSize();
			for (Integer i = 0; i < position; i++) {
				set(i, getBit(i + binary.getSize()));
			}
			for (Integer i = position, j = 0; i < (position + binary.getSize()); i++) {
				set(i, binary.getBit(j));
				j++;
			}
		}
	}

	protected int invertIndex(int index) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinaryIndexedFromMsb object!");
		return size - 1 - index;
	}

	/**
	 * @param factor
	 * @throws Exception
	 */
	@Test
	public void multipliedBy(LteBinaryIndexedFromMsb factor) throws Exception {
		Integer a = toInteger();
		Integer b = factor.toInteger();
		setToInteger(a * b);
	}

	@Override
	/**
	 * Set the bit at "index" to be "bit". Note: MSB has the index=0, and LSB has the index=this.size-1.
	 * 
	 * @param index
	 * @param bit
	 * @throws Exception
	 */
	public void set(Integer index, Bit bit) throws Exception {
		BasicBaseClass.garantee(index > -1, "index=" + index
				+ " is invalid for LteBinary.set(int index)!");
		bitSet.set(invertIndex(index), bit.toBoolean());
	}

	@Override
	public String toReadableString() {
		return LteBinaryIndexedFromLsb.class.toString();
	}

}
