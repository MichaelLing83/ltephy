package common.math;

import common.BasicBaseClass;

public class Operation extends BasicBaseClass {

	static public double	magnitudeQuantizationDelta	= 0.001;
	static public double	angleQuantizationDelta		= 0.001;

	static public long angleQuantilize(double value) {
		return (long) Math.floor(value / Operation.angleQuantizationDelta);
	}

	static public long magnitudeQuantilize(double value) {
		return (long) Math.floor(value / Operation.magnitudeQuantizationDelta);
	}

	static public long quantilize(double value, double delta) {
		return (long) Math.floor(value / delta);
	}

	@Override
	public String toBinaryString() {
		return toReadableString();
	}

	@Override
	public String toReadableString() {
		return Operation.class.getName();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
