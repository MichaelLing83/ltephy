package common.math;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexField;
import org.apache.commons.math3.complex.ComplexFormat;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.FieldVector;

import common.BasicBaseClass;

public class ComplexVector extends BasicBaseClass {

	private FieldVector<Complex>	complexVector	= new ArrayFieldVector<Complex>(
															ComplexField
																	.getInstance());

	public ComplexVector() {
	}

	public ComplexVector(ComplexVector another) {
		this.complexVector = another.complexVector.copy();
	}

	public void append(Complex complex) {
		this.complexVector = this.complexVector.append(complex);
	}

	@Override
	public String toBinaryString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toGnuplot3DString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Complex c : complexVector.toArray()) {
			sb.append(i++);
			sb.append("\t");
			sb.append(c.getReal());
			sb.append("\t");
			sb.append(c.getImaginary());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public String toReadableString() {
		StringBuilder sb = new StringBuilder();
		for (Complex c : complexVector.toArray()) {
			sb.append(c.getReal());
			sb.append("\t");
			sb.append(c.getImaginary());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Complex c : complexVector.toArray()) {
			sb.append(ComplexFormat.getInstance().format(c));
			sb.append(", ");
		}
		return sb.toString();
	}

}
