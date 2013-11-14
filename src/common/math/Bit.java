package common.math;

import common.BasicBaseClass;

public class Bit extends BasicBaseClass {

	boolean	bit	= false;

	public Bit() throws Exception {
		super();
	}

	public Bit(boolean bit) throws Exception {
		super();
		this.bit = bit;
	}

	public Bit(Integer bit) throws Exception {
		super();
		BasicBaseClass.garantee((bit == 0) || (bit == 1), "bit=" + bit
				+ " is not valid for one bit!");
		this.bit = bit == 1 ? true : false;
	}

	/**
	 * Bitwise and (&&).
	 * 
	 * @param y
	 * @return Bit
	 * @throws Exception
	 */
	public Bit and(Bit y) throws Exception {
		boolean a = this.bit;
		boolean b = y.isOne();
		return new Bit(a && b);
	}

	public Integer compareTo(Object anotherObj) {
		Integer result = 0;
		if (anotherObj instanceof Integer) {
			result = this.toInteger() - (Integer) anotherObj;
		} else {
			Bit anotherBit = (Bit) anotherObj;
			result = this.toInteger() - anotherBit.toInteger();
		}
		return result;
	}

	@Override
	public boolean equals(Object anotherObj) {
		return this.compareTo(anotherObj) == 0;
	}

	public boolean isOne() {
		return this.bit;
	}

	/**
	 * Create a new Bit instance holding !this.bit
	 * 
	 * @return
	 * @throws Exception
	 */
	public Bit not() throws Exception {
		return new Bit(!this.bit);
	}

	/**
	 * Bitwise or (||).
	 * 
	 * @param y
	 * @return
	 * @throws Exception
	 */
	public Bit or(Bit y) throws Exception {
		boolean a = this.bit;
		boolean b = y.isOne();
		return new Bit(a || b);
	}

	public void setBit(boolean bit) {
		this.bit = bit;
	}

	public void setBitValue(Integer bit) throws Exception {
		BasicBaseClass.garantee((bit == 0) || (bit == 1), "Invalid argument="
				+ bit + "!");
		this.bit = bit == 1 ? true : false;
	}

	@Override
	public String toBinaryString() {
		return this.bit ? "1" : "0";
	}

	public boolean toBoolean() {
		return this.bit;
	}

	public Integer toInteger() {
		return this.bit ? 1 : 0;
	}

	@Override
	public String toReadableString() {
		return toString();
	}

	@Override
	public String toString() {
		return this.toBinaryString();
	}

	/**
	 * Bitwise xor (^).
	 * 
	 * @param y
	 * @return
	 * @throws Exception
	 */
	public Bit xor(Bit y) throws Exception {
		boolean a = this.bit;
		boolean b = y.isOne();
		return new Bit((a && !b) || (!a && b));
	}
}
