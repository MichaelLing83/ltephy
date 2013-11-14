package common.math;

import java.util.BitSet;

import common.BasicBaseClass;

/**
 * Abstract base class for binary representing objects.
 */
public abstract class BinaryBaseClass extends BasicBaseClass {

	/**
	 * holds all bits in this
	 */
	protected BitSet	bitSet;

	/**
	 * represents the number of bits
	 */
	protected int		size;

	/**
	 * Copy constructor.
	 * 
	 * @param binary
	 */
	public BinaryBaseClass(BinaryBaseClass binary) {
		super();
		this.size = binary.getSize();
		this.bitSet = new BitSet();
		for (int i = 0; i < this.size; i++) {
			this.bitSet.set(i, binary.getBitSet().get(i));
		}
	}

	/**
	 * Construct a binary with "size" number of bits and has value of
	 * "initValue".
	 * 
	 * @param size
	 * @param initValue
	 * @throws Exception
	 */
	public BinaryBaseClass(Integer size, Integer initValue) throws Exception {
		super();
		BasicBaseClass.garantee(size > -1, "size=" + size
				+ " is invalid for LteBinary!");
		BasicBaseClass
				.garantee(
						initValue > -1,
						"initValue="
								+ initValue
								+ " is invalid for LteBinary! It has to be a positive integer!");
		this.size = size;
		this.bitSet = new BitSet();
		Integer originalInitValue = initValue;
		for (Integer i = 0; i < size; i++) {
			this.bitSet.set(i, (initValue & 0x1) == 1);
			initValue = initValue >> 1;
			if (initValue == 0) {
				break;
			}
		}
		if (initValue != 0) {
			throw new Exception("Given size=" + size
					+ " is too small for the given initValue="
					+ originalInitValue);
		}
	}

	/**
	 * @param addee
	 * @throws Exception
	 */
	public void addedBy(BinaryBaseClass addee) throws Exception {
		Integer sum = this.toInteger() + addee.toInteger();
		this.setToInteger(sum);
	}

	public void and(BinaryBaseClass bin) {
		for (int i = 0; i < Math.max(this.bitSet.length(), bin.bitSet.length()); i++) {
			this.bitSet.set(i, this.bitSet.get(i) & bin.bitSet.get(i));
		}
		// this.bitSet.and(bin.bitSet);
	}

	/**
	 * Add tail to the end (LSB) of current binary
	 * 
	 * @param tail
	 * @throws Exception
	 */
	public void append(BinaryBaseClass tail) throws Exception {
		this.shiftLeft(tail.getSize());
		for (int i = tail.getSize() - 1; i > -1; i--) {
			this.bitSet.set(i, tail.getBitSet().get(i));
		}
	}

	/**
	 * Delete all bits that are zero from MSB; if all bits are zero, "0" will be
	 * the result.
	 */
	public void chopAllLeadingZero() throws Exception {
		BasicBaseClass.garantee(this.size > -1, "Current size=" + this.size
				+ " is invalid!");
		while ((this.size > 0) && (this.bitSet.get(this.size - 1) == false)) {
			this.size -= 1;
		}
	}

	/**
	 * Delete MSB if it is zero.
	 */
	public void chopLeadingZero() throws Exception {
		BasicBaseClass.garantee(this.size > -1, "Current size=" + this.size
				+ " is invalid!");
		if (this.bitSet.get(this.size - 1) == false) {
			this.size -= 1;
		}
	}

	/**
	 * Remove size bits starting from MSB
	 */
	public void chopMsb(Integer size) throws Exception {
		BasicBaseClass.garantee((size > -1) && (size < this.size),
				"Cannot chop " + size + " most important bits! Current size="
						+ this.size + ".");
		for (int i = 0; i < size; i++) {
			this.bitSet.set(this.size - 1 - i, false);
		}
		this.size -= size;
	}

	public void clear() {
		this.bitSet.clear();
	}

	/**
	 * Compare another binary with current one. Returns -1 if currentBin is
	 * smaller than anotherBin; 0 if currentBin is equal to anotherBin; +1 if
	 * currentBin is bigger than anotherBin.
	 */
	public Integer compareTo(Object anotherObj) {
		BinaryBaseClass y = (BinaryBaseClass) anotherObj;
		Integer result = 0;
		for (Integer i = Math.max(this.size, y.getSize()) - 1; i > -1; i--) {
			if (this.bitSet.get(i) && (!y.getBitSet().get(i))) {
				result = 1;
				break;
			} else if ((!this.bitSet.get(i)) && y.getBitSet().get(i)) {
				result = -1;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object anotherObj) {
		return this.compareTo(anotherObj) == 0;
	}

	public BitSet getBitSet() {
		return this.bitSet;
	}

	abstract public boolean getBoolean(int index) throws Exception;

	/**
	 * Return MSB.
	 * 
	 * @throws Exception
	 */
	public Bit getMsb() throws Exception {
		return new Bit(this.bitSet.get(this.size - 1));
	}

	public Integer getSize() {
		return this.size;
	}

	/**
	 * Insert the given binary to the right of given position. Note that this
	 * operation will have different outcome for indexing from MSB and indexing
	 * from LSB!
	 * 
	 * @param binary
	 * @param position
	 * @throws Exception
	 */
	abstract public void insert(BinaryBaseClass binary, Integer position)
			throws Exception;

	public void or(BinaryBaseClass bin) {
		this.bitSet.or(bin.bitSet);
	}

	/**
	 * Set the bit at "index" to be "bit".
	 * 
	 * @param index
	 * @param bit
	 * @throws Exception
	 */
	abstract public void set(Integer index, Bit bit) throws Exception;

	public void setToInteger(Integer value) throws Exception {
		BasicBaseClass.garantee(this.size > -1, "size=" + this.size
				+ " is invalid for LteBinary!");
		BasicBaseClass
				.garantee(
						value > -1,
						"value="
								+ value
								+ " is invalid for LteBinary! It has to be a positive integer!");
		this.bitSet = new BitSet();
		Integer originalInitValue = value;
		for (Integer i = 0; i < this.size; i++) {
			this.bitSet.set(i, (value & 0x1) == 1);
			value = value >> 1;
			if (value == 0) {
				break;
			}
		}
		if (value != 0) {
			throw new Exception("Given size=" + this.size
					+ " is too small for the given initValue="
					+ originalInitValue);
		}
	}

	public void shiftLeft(Integer numOfBits) throws Exception {
		BasicBaseClass.garantee(numOfBits >= 0,
				"shiftLeft has to take positive parameter, but is given bits="
						+ numOfBits);
		this.size += numOfBits;
		for (Integer i = this.size - 1; i > (numOfBits - 1); i--) {
			this.bitSet.set(i, this.bitSet.get(i - numOfBits));
		}
		for (Integer i = numOfBits - 1; i > -1; i--) {
			this.bitSet.set(i, false);
		}
	}

	public void shiftRight(int numOfBits) throws Exception {
		if (numOfBits < 0) {
			throw new Exception(
					"shiftRight has to take positive parameter, but is given bits="
							+ numOfBits);
		}
		int newSize = this.size - numOfBits;
		if (newSize > 0) {
			for (int i = this.size - 1; i > (newSize - 1); i--) {
				this.bitSet.set(i, false);
			}
			this.size = newSize;
		} else {
			for (int i = 0; i < this.size; i++) {
				this.bitSet.set(i, false);
			}
			this.size = 1;
		}
	}

	/**
	 * @param subtrahend
	 * @throws Exception
	 */
	public void subtractedBy(BinaryBaseClass subtrahend) throws Exception {
		Integer difference = this.toInteger() - subtrahend.toInteger();
		this.setToInteger(difference);
	}

	@Override
	public String toBinaryString() {
		StringBuilder sb = new StringBuilder();
		for (int i = this.size - 1; i > -1; i--) {
			if (this.bitSet.get(i)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public Integer toInteger() throws Exception {
		Integer bin = 0;
		for (int i = 0; i < this.size; i++) {
			bin += (this.bitSet.get(i) ? 1 : 0) << i;
		}
		return bin;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer i = this.size - 1; i > -1; i--) {
			if (this.bitSet.get(i)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public void xor(BinaryBaseClass bin) {
		this.bitSet.xor(bin.bitSet);
	}

	public abstract Bit getBit(Integer index) throws Exception;
}
