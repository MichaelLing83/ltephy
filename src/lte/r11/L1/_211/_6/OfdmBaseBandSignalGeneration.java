package lte.r11.L1._211._6;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

import common.LteParameterLookUp;
import common.ParameterName;
import common.math.ComplexVector;

public class OfdmBaseBandSignalGeneration extends common.BasicBaseClass {

	static public ComplexVector ofdmBaseBandSignalGeneration(ComplexVector res,
			int N_DL_RB, int N_RB_sc, long delta_f_index, long dl_cp_index,
			int l) throws Exception {
		// check RE length is the same as DL BW configuration.
		int M = res.getDimension();
		garantee(
				M == N_DL_RB * N_RB_sc,
				"Given RE sequence is shorter than cell bandwidth configuration! Consider padding 0's!");
		// decide how many points IFFT to use
		int N = 2048;
		if (delta_f_index != LteParameterLookUp.lookUpIndex(
				ParameterName.delta_f, "15kHz")) {
			N = 4096;
		}
		// shift RE symbols to prepare for IFFT
		ComplexVector beforeIfft = new ComplexVector();
		beforeIfft.append(new Complex(0, 0));
		beforeIfft.append(res.getSubVector(M / 2, M / 2));
		beforeIfft.append(new ComplexVector(N - M - 1, new Complex(0, 0)));
		beforeIfft.append(res.getSubVector(0, M / 2));
		// IFFT
		FastFourierTransformer fft = new FastFourierTransformer(
				DftNormalization.STANDARD);
		ComplexVector beforeCpInsersion = new ComplexVector(fft.transform(
				beforeIfft.toArray(), TransformType.INVERSE));
		// calculate CP length
		int cpLength = 144;
		if (delta_f_index != LteParameterLookUp.lookUpIndex(
				ParameterName.delta_f, "15kHz")) {
			// delta_f is 7.5 kHz
			garantee(l >= 0 && l < 3, "OFDM symbol index = " + l
					+ " is invalid for 7.5kHz subcarriers!");
			cpLength = 1024;
		} else {
			// delta_f is 15 kHz
			if (dl_cp_index == LteParameterLookUp.lookUpIndex(
					ParameterName.DL_CyclicPrefixLength, "len1")) {
				// normal CP
				garantee(l >= 0 && l < 7, "OFDM symbol index = " + l
						+ " is invalid!");
				if (l == 0) {
					cpLength = 160;
				} else {
					cpLength = 144;
				}
			} else {
				// extended CP
				garantee(l >= 0 && l < 6, "OFDM symbol index = " + l
						+ " is invalid for extended DL CP!");
				cpLength = 512;
			}
		}
		// insert CP
		ComplexVector afterCpInsersion = beforeCpInsersion.getSubVector(
				beforeCpInsersion.getDimension() - cpLength, cpLength).add(
				beforeCpInsersion);
		return afterCpInsersion;
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
