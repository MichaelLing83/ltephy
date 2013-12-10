package common.math;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexField;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;

public class ComplexMatrix extends common.BasicBaseClass {

	private FieldMatrix<Complex>	fieldMatrix	= new Array2DRowFieldMatrix<Complex>(
														ComplexField
																.getInstance());

	public ComplexMatrix add(ComplexMatrix m) {
		ComplexMatrix result = new ComplexMatrix();
		result.fieldMatrix = this.fieldMatrix.add(m.fieldMatrix);
		return result;
	}

	public void addToEntry(int row, int column, Complex increment) {
		this.fieldMatrix.addToEntry(row, column, increment);
	}

	public ComplexMatrix copy() {
		ComplexMatrix result = new ComplexMatrix();
		result.fieldMatrix = this.fieldMatrix.copy();
		return result;
	}

	public ComplexMatrix createMatrix(int rowDimension, int columnDimension) {
		ComplexMatrix result = new ComplexMatrix();
		result.fieldMatrix = this.fieldMatrix.createMatrix(rowDimension,
				columnDimension);
		return result;
	}

	public int getColumnDimension() {
		return this.fieldMatrix.getColumnDimension();
	}

	public Complex[][] getData() {
		return fieldMatrix.getData();
	}

	public Complex getEntry(int row, int column) {
		return fieldMatrix.getEntry(row, column);
	}

	public int getRowDimension() {
		return this.fieldMatrix.getRowDimension();
	}

	public ComplexMatrix multiply(ComplexMatrix m) {
		ComplexMatrix result = new ComplexMatrix();
		result.fieldMatrix = this.fieldMatrix.multiply(m.fieldMatrix);
		return result;
	}

	public void multiplyEntry(int row, int column, Complex factor) {
		this.fieldMatrix.multiplyEntry(row, column, factor);
	}

	public Complex[] operate(Complex[] v) {
		return this.fieldMatrix.operate(v);
	}

	public Complex[] preMultiply(Complex[] v) {
		return this.fieldMatrix.preMultiply(v);
	}

	public void setEntry(int row, int column, Complex value) {
		this.fieldMatrix.setEntry(row, column, value);
	}

	public void setSubMatrix(Complex[][] subMatrix, int row, int column) {
		this.fieldMatrix.setSubMatrix(subMatrix, row, column);
	}

	public ComplexMatrix subtract(ComplexMatrix m) {
		ComplexMatrix result = new ComplexMatrix();
		result.fieldMatrix = this.fieldMatrix.subtract(m.fieldMatrix);
		return result;
	}

	@Override
	public String toBinaryString() {
		return "";
	}

	@Override
	public String toReadableString() {
		StringBuilder sb = new StringBuilder();
		int rowDimension = this.getRowDimension();
		int columnDimension = this.getColumnDimension();
		for (int row = 0; row < rowDimension; row++) {
			for (int column = 0; column < columnDimension; column++) {
				// sb.append(this.getEntry(row, column).toString() + "\t");
				sb.append(MathHelper.complexToString(this.getEntry(row, column))
						+ "\t");
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
