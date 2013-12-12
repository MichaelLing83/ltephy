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

	public ComplexVector(Complex[] complexArray) {
		for (int i = 0; i < complexArray.length; i++) {
			this.append(complexArray[i]);
		}
	}

	public ComplexVector(ComplexVector another) {
		this.complexVector = another.complexVector.copy();
	}

	public ComplexVector(int dimension, Complex defaultValue) {
		for (int i = 0; i < dimension; i++) {
			this.append(defaultValue);
		}
	}

	public ComplexVector add(ComplexVector v) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.add(v.complexVector);
		return result;
	}

	public void append(Complex complex) {
		this.complexVector = this.complexVector.append(complex);
	}

	public void append(ComplexVector v) {
		this.complexVector = this.complexVector.append(v.complexVector);
	}

	public ComplexVector copy() {
		ComplexVector cp = new ComplexVector();
		cp.complexVector = this.complexVector.copy();
		return cp;
	}

	public Complex dotProduct(ComplexVector v) {
		return this.complexVector.dotProduct(v.complexVector);
	}

	public ComplexVector ebeDivide(ComplexVector v) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.ebeDivide(v.complexVector);
		return result;
	}

	public ComplexVector ebeMultiply(ComplexVector v) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.ebeMultiply(v.complexVector);
		return result;
	}

	public int getDimension() {
		return this.complexVector.getDimension();
	}

	public Complex getEntry(int index) {
		return this.complexVector.getEntry(index);
	}

	public ComplexVector getSubVector(int index, int n) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.getSubVector(index, n);
		return result;
	}

	/**
	 * Add Complex number c to each element of this ComplexVector.
	 * 
	 * @param c
	 * @return
	 */
	public ComplexVector mapAdd(Complex c) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.mapAdd(c);
		return result;
	}

	/**
	 * Each element of this ComplexVector is divided by Complex number c.
	 * 
	 * @param c
	 * @return
	 */
	public ComplexVector mapDivide(Complex c) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.mapDivide(c);
		return result;
	}

	public void set(Complex c) {
		this.complexVector.set(c);
	}

	public void setEntry(int index, Complex c) {
		this.complexVector.setEntry(index, c);
	}

	public ComplexVector subtract(ComplexVector v) {
		ComplexVector result = new ComplexVector();
		result.complexVector = this.complexVector.subtract(v.complexVector);
		return result;
	}

	public Complex[] toArray() {
		return this.complexVector.toArray();
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
