/**
 * 
 */
package lte.r11.L1._211._7.junit;

import lte.r11.L1._211._7.ModulationMapper;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;

import common.BitList;
import common.junit.UnitTestBase;
import common.math.ComplexVector;

/**
 * @author Michael Duo Ling
 * 
 */
public class ModulationMapperTest extends UnitTestBase {
	@Test
	public void testBPSK() throws Exception {
		Complex bpskSymbol = ModulationMapper.BPSK(0);
		System.out.println(bpskSymbol.getReal() + "\t"
				+ bpskSymbol.getImaginary());

		System.out.println("############################");

		ComplexVector bpskSymbols = ModulationMapper.BPSK(new BitList(
				new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1 }));
		System.out.println(bpskSymbols.toGnuplot3DString());
	}
}
