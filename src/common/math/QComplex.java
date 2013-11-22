/**
 * 
 */
package common.math;

import org.apache.commons.math3.complex.Complex;

import common.BasicBaseClass;

/**
 * Complex number with quantilized value.
 * 
 * @author Michael Duo Ling, Code extracted from:
 *         http://en.literateprograms.org/Complex_numbers_(Java)
 * 
 */
public class QComplex extends BasicBaseClass {

	private long	real;
	private long	imaginary;
	private Complex	complex;

	public QComplex() {
		this.real = 0;
		this.imaginary = 0;
		this.complex = new Complex(this.real, this.imaginary);
	}

	public QComplex(long real) {
		this.real = real;
		this.imaginary = 0;
		this.complex = new Complex(this.real, this.imaginary);
	}

	public QComplex(long real, long imaginary) {
		this.real = real;
		this.imaginary = imaginary;
		this.complex = new Complex(this.real, this.imaginary);
	}

	public QComplex(QComplex input) {
		this.real = input.getReal();
		this.imaginary = input.getImaginary();
		this.complex = new Complex(this.real, this.imaginary);
	}

	public long abs() {
		return (long) this.complex.abs();
	}

	public QComplex add(QComplex addend) {
		QComplex result = new QComplex();
		result.setReal(this.real + addend.getReal());
		result.setImaginary(this.imaginary + addend.getImaginary());
		return result;
	}

	public QComplex conjugate() {
		return new QComplex(this.real, this.imaginary * (-1));
	}

	public QComplex divide(long divisor) {
		return new QComplex(real / divisor, imaginary / divisor);
	}

	public QComplex divide(QComplex divisor) {
		QComplex result = new QComplex(this);
		result = result.mul(divisor.conjugate());
		long opNormSq = (divisor.getReal() * divisor.getReal())
				+ (divisor.getImaginary() * divisor.getImaginary());
		result.setReal(result.getReal() / opNormSq);
		result.setImaginary(result.getImaginary() / opNormSq);
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof QComplex) {
			QComplex qc = (QComplex) other;
			return real == qc.real && imaginary == qc.imaginary;
		} else {
			return false;
		}
	}

	public QComplex fromPolar(long magnitude, long angle) {
		QComplex result = new QComplex();
		result.setReal((long) (magnitude * Math.cos(angle
				* Operation.angleQuantizationDelta)));
		result.setImaginary((long) (magnitude * Math.sin(angle
				* Operation.angleQuantizationDelta)));
		return result;
	}

	public long getAngle() {
		return Operation.angleQuantilize(Math.atan2(this.imaginary, this.real));
	}

	public long getImaginary() {
		return this.imaginary;
	}

	public long getNorm() {
		return (long) Math.sqrt((this.real * this.real) + (this.imaginary * this.imaginary));
	}

	public long getReal() {
		return this.real;
	}

	public QComplex mul(QComplex op) {
		QComplex result = new QComplex();
		result.setReal((this.real * op.getReal()) - (this.imaginary * op.getImaginary()));
		result.setImaginary((this.real * op.getImaginary()) + (this.imaginary * op.getReal()));
		return result;
	}

	public void setImaginary(long imaginary) {
		this.imaginary = imaginary;
	}

	public void setReal(long real) {
		this.real = real;
	}

	public QComplex subtract(QComplex op) {
		QComplex result = new QComplex();
		result.setReal(this.real - op.getReal());
		result.setImaginary(this.imaginary - op.getImaginary());
		return result;
	}

	@Override
	public String toBinaryString() {
		return "Complex numbers cannot directly be translated to binary!";
	}

	@Override
	public String toReadableString() {
		return toString();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		if (this.real == 0) {
			if (this.imaginary == 0) {
				return "0";
			} else {
				return (this.imaginary + "i");
			}
		} else {
			if (this.imaginary == 0) {
				return String.valueOf(this.real);
			} else if (this.imaginary < 0) {
				return (this.real + " " + this.imaginary + "i");
			} else {
				return (this.real + "+" + this.imaginary + "i");
			}
		}
	}

}
