package lte.r11.L1._211._6;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

import common.math.ComplexVector;

public class OfdmBaseBandSignalGeneration extends common.BasicBaseClass {

	static public ComplexVector ofdmBaseBandSignalGeneration(ComplexVector res,
			int N_DL_RB, int N_RB_sc, int delta_f, int N__CP) throws Exception {
		int M = res.getDimension();
		garantee(
				M == N_DL_RB * N_RB_sc,
				"Given RE sequence is shorter than cell bandwidth configuration! Consider padding 0's!");
		int N = 2048;
		if (delta_f != 15) {
			N = 4096;
		}
		ComplexVector beforeIfft = new ComplexVector();
		beforeIfft.append(new Complex(0, 0));
		beforeIfft.append(res.getSubVector(M / 2, M / 2));
		beforeIfft.append(new ComplexVector(N - M - 1, new Complex(0, 0)));
		beforeIfft.append(res.getSubVector(0, M / 2));
		FastFourierTransformer fft = new FastFourierTransformer(
				DftNormalization.STANDARD);
		return new ComplexVector(fft.transform(beforeIfft.toArray(),
				TransformType.INVERSE));
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
