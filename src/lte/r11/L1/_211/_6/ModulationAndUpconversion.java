package lte.r11.L1._211._6;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import common.math.ComplexVector;

public class ModulationAndUpconversion extends common.BasicBaseClass {

	static public RealVector downlinkModulation(ComplexVector signal,
			double timeStart, double f__0) throws Exception {
		double timeStep = 1.0 / (15000 * 2048);
		RealVector result = new ArrayRealVector();
		double t = timeStart;
		for (Complex symbol : signal.toArray()) {
			result = result.append(symbol.getReal()
					* Math.cos(2 * Math.PI * f__0 * t) - symbol.getImaginary()
					* Math.sin(2 * Math.PI * f__0 * t));
			t += timeStep;
		}
		return result;
	}

	static public RealVector downlinkModulation(ComplexVector signal,
			double timeStart, double timeStep, double f__0) throws Exception {
		RealVector result = new ArrayRealVector();
		double t = timeStart;
		for (Complex symbol : signal.toArray()) {
			result = result.append(symbol.getReal()
					* Math.cos(2 * Math.PI * f__0 * t) - symbol.getImaginary()
					* Math.sin(2 * Math.PI * f__0 * t));
			t += timeStep;
		}
		return result;
	}

	static public RealVector downlinkModulation(ComplexVector signal,
			RealVector timeVector, double f__0) throws Exception {
		garantee(signal.getDimension() == timeVector.getDimension(),
				"Input signal must have the same length as time vector!!");
		RealVector result = new ArrayRealVector();
		for (int i = 0; i < signal.getDimension(); i++) {
			result = result.append(signal.getEntry(i).getReal()
					* Math.cos(2 * Math.PI * f__0 * timeVector.getEntry(i))
					- signal.getEntry(i).getImaginary()
					* Math.sin(2 * Math.PI * f__0 * timeVector.getEntry(i)));
		}
		return result;
	}

	@Override
	public String toBinaryString() {
		return toReadableString();
	}

	@Override
	public String toReadableString() {
		return ModulationAndUpconversion.class.getName();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
