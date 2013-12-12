package lte.r11.L1._211._6;

import java.util.Arrays;

import lte.r11.L1.ReType;

import org.apache.commons.math3.complex.Complex;

import common.BasicBaseClass;
import common.LteParameterLookUp;
import common.ParameterName;
import common.ReTypeMatrix;
import common.math.ComplexMatrix;
import common.math.ComplexVector;

public class PSS extends BasicBaseClass {

	static public Complex d_u(int n, int u) throws Exception {
		garantee((Arrays.asList((new Integer[] { 25, 29, 34 })).contains(u)),
				"u=" + u + " is invalid for PSS!");
		garantee(n >= 0 && n < 62, "n=" + n + " out of range!");
		if (n < 31) {
			return (new Complex(0, -1 * Math.PI * u * n * (n + 1) / 63.0))
					.exp();
		} else {
			return (new Complex(0, -1 * Math.PI * u * (n + 1) * (n + 2) / 63.0))
					.exp();
		}
	}

	static public void mapPss(ComplexVector pss, ComplexVector reVector)
			throws Exception {
		for (int i = 0, k = -31 + reVector.getDimension() / 2; k < 62 - 31 + reVector
				.getDimension() / 2; k++) {
			reVector.setEntry(k, pss.getEntry(i++));
		}
	}

	static public void mapPss(long multiplexingMode_i, ComplexVector pss,
			long frame, int subframe, ComplexMatrix res) throws Exception {
		garantee(
				multiplexingMode_i >= 0
						&& multiplexingMode_i < LteParameterLookUp.get(
								ParameterName.MultiplexingMode).getSize(),
				"Invalid parameter!");
		garantee(res.getColumnDimension() == 2 * 6
				|| res.getColumnDimension() == 2 * 7,
				"Given RE matrix isn't for a subframe!");
		if (multiplexingMode_i == LteParameterLookUp.lookUpIndex(
				ParameterName.MultiplexingMode, "FDD")) {
			if (subframe == 0 / 2 || subframe == 10 / 2) {
				// has PSS
				int l = 6;
				if (res.getColumnDimension() < 2 * 7) {
					l = 5;
				}
				for (int i = 0, k = -31 + res.getRowDimension() / 2; k < 62 - 31 + res
						.getRowDimension() / 2; k++) {
					res.setEntry(k, l, pss.getEntry(i++));
				}
			}
		} else {
			// TDD
			if (subframe == 1 || subframe == 6) {
				// has PSS
				int l = 2;
				for (int i = 0, k = -31 + res.getRowDimension() / 2; k < 62 - 31 + res
						.getRowDimension() / 2; k++) {
					res.setEntry(k, l, pss.getEntry(i++));
				}
			}
		}
	}

	static public void markPss(long multiplexingMode_i, ComplexVector pss,
			long frame, int subframe, ReTypeMatrix reTypeMatrix)
			throws Exception {
		garantee(
				multiplexingMode_i >= 0
						&& multiplexingMode_i < LteParameterLookUp.get(
								ParameterName.MultiplexingMode).getSize(),
				"Invalid parameter!");
		garantee(
				reTypeMatrix.getColumnDimension() == 2 * 6
						|| reTypeMatrix.getColumnDimension() == 2 * 7,
				"Given RE matrix isn't for a subframe!");
		if (multiplexingMode_i == LteParameterLookUp.lookUpIndex(
				ParameterName.MultiplexingMode, "FDD")) {
			if (subframe == 0 / 2 || subframe == 10 / 2) {
				// has PSS
				int l = 6;
				if (reTypeMatrix.getColumnDimension() < 2 * 7) {
					l = 5;
				}
				for (int k = -31 + reTypeMatrix.getRowDimension() / 2; k < 62 - 31 + reTypeMatrix
						.getRowDimension() / 2; k++) {
					reTypeMatrix.setEntry(k, l, ReType.PSS);
				}
			}
		} else {
			// TDD
			if (subframe == 1 || subframe == 6) {
				// has PSS
				int l = 2;
				for (int k = -31 + reTypeMatrix.getRowDimension() / 2; k < 62 - 31 + reTypeMatrix
						.getRowDimension() / 2; k++) {
					reTypeMatrix.setEntry(k, l, ReType.PSS);
				}
			}
		}
	}

	static public ComplexVector pss(int N_ID_2) throws Exception {
		garantee((Arrays.asList((new Integer[] { 0, 1, 2 })).contains(N_ID_2)),
				"N_ID_2=" + N_ID_2 + " is invalid!");
		ComplexVector cv = new ComplexVector();
		int u = (new Integer[] { 25, 29, 34 })[N_ID_2];
		for (int i = 0; i < 62; i++) {
			cv.append(d_u(i, u));
		}
		return cv;
	}

	public PSS() {
		// TODO Auto-generated constructor stub
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
