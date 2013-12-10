package common.math;

import org.apache.commons.math3.complex.Complex;

import common.BasicBaseClass;

public class MathHelper extends BasicBaseClass {

	static public String complexToString(Complex c) {
		return "" + c.getReal() + "+j" + c.getImaginary();
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
