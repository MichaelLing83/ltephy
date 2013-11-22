package lte.r11.L1._211._7;

import org.apache.commons.math3.complex.Complex;

import common.BasicBaseClass;
import common.BitList;
import common.math.ComplexVector;

public class ModulationMapper extends BasicBaseClass {

	private static final double	BPSK_UNIT	= 1.0 / Math.sqrt(2.0);
	private static final double	QPSK_UNIT	= 1.0 / Math.sqrt(2.0);
	private static final double	QAM16_UNIT	= 1.0 / Math.sqrt(10.0);
	private static final double	QAM64_UNIT	= 1.0 / Math.sqrt(42.0);
	private static final int[]	BPSK_I		= { 1, -1 };
	private static final int[]	BPSK_Q		= { 1, -1 };
	private static final int[]	QPSK_I		= { 1, 1, -1, -1 };
	private static final int[]	QPSK_Q		= { 1, -1, 1, -1 };
	private static final int[]	QAM16_I		= { 1, 1, 3, 3, 1, 1, 3, 3, -1, -1,
			-3, -3, -1, -1, -3, -3			};
	private static final int[]	QAM16_Q		= { 1, 3, 1, 3, -1, -3, -1, -3, 1,
			3, 1, 3, -1, -3, -1, -3		};
	private static final int[]	QAM64_I		= { 3, 3, 1, 1, 3, 3, 1, 1, 5, 5,
			7, 7, 5, 5, 7, 7, 3, 3, 1, 1, 3, 3, 1, 1, 5, 5, 7, 7, 5, 5, 7, 7,
			-3, -3, -1, -1, -3, -3, -1, -1, -5, -5, -7, -7, -5, -5, -7, -7, -3,
			-3, -1, -1, -3, -3, -1, -1, -5, -5, -7, -7, -5, -5, -7, -7 };
	private static final int[]	QAM64_Q		= { 3, 1, 3, 1, 5, 7, 5, 7, 3, 1,
			3, 1, 5, 7, 5, 7, -3, -1, -3, -1, -5, -7, -5, -7, -3, -1, -3, -1,
			-5, -7, -5, -7, 3, 1, 3, 1, 5, 7, 5, 7, 3, 1, 3, 1, 5, 7, 5, 7, -3,
			-1, -3, -1, -5, -7, -5, -7, -3, -1, -3, -1, -5, -7, -5, -7 };

	public static ComplexVector BPSK(BitList bitList) throws Exception {
		ComplexVector bpskSymbols = new ComplexVector();
		for (int i = 0; i < bitList.size(); i++) {
			bpskSymbols.append(new Complex(BPSK_I[bitList.getInteger(i)]
					* BPSK_UNIT, BPSK_Q[bitList.getInteger(i)] * BPSK_UNIT));
		}
		return bpskSymbols;
	}

	public static Complex BPSK(int bit) throws Exception {
		garantee(bit == 0 || bit == 1,
				"Invalid BPSK modulation parameter: bit=" + bit);
		return new Complex(BPSK_I[bit] * BPSK_UNIT, BPSK_Q[bit] * BPSK_UNIT);
	}

	@Override
	public String toBinaryString() {
		return toReadableString();
	}

	@Override
	public String toReadableString() {
		return ModulationMapper.class.getName();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
