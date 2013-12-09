package common;

import java.util.BitSet;

public class BitList extends BasicBaseClass {

	private BitSet	bitSet;
	private int		size;

	public BitList() {
		bitSet = new BitSet();
		size = 0;
	}

	public BitList(int size) {
		bitSet = new BitSet();
		this.size = size;
	}

	public BitList(int[] bitArray) throws Exception {
		bitSet = new BitSet();
		size = bitArray.length;
		for (int i = 0; i < bitArray.length; i++) {
			garantee(bitArray[bitArray.length - 1 - i] == 0
					|| bitArray[bitArray.length - 1 - i] == 1,
					"Invalid bit array for initialization: " + bitArray);
			bitSet.set(i, bitArray[bitArray.length - 1 - i] == 1);
		}
	}

	public boolean get(int bitIndex) throws Exception {
		garantee(bitIndex < size, "bitIndex=" + bitIndex + " is out of range!");
		return bitSet.get(bitIndex);
	}

	public int getInteger(int bitIndex) throws Exception {
		garantee(bitIndex < size, "bitIndex=" + bitIndex + " is out of range!");
		return bitSet.get(bitIndex) ? 1 : 0;
	}

	/**
	 * Set given bit to 1.
	 * 
	 * @param bitIndex
	 */
	public void set(int bitIndex) {
		if (bitIndex >= size) {
			size = bitIndex + 1;
		}
		bitSet.set(bitIndex);
	}

	/**
	 * Set given bit to value.
	 * 
	 * @param bitIndex
	 */
	public void set(int bitIndex, boolean value) {
		if (bitIndex >= size) {
			size = bitIndex + 1;
		}
		bitSet.set(bitIndex, value);
	}

	/**
	 * Sets the bits from the specified fromIndex (inclusive) to the specified
	 * toIndex (exclusive) to the specified value
	 * 
	 * @param fromIndex
	 * @param toIndex
	 * @param value
	 */
	public void set(int fromIndex, int toIndex, boolean value) {
		if (toIndex >= size) {
			size = toIndex + 1;
		}
		bitSet.set(fromIndex, toIndex, value);
	}

	public int size() {
		return size;
	}

	@Override
	public String toBinaryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toReadableString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
