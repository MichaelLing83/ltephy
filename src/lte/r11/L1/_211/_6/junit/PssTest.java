/**
 * 
 */
package lte.r11.L1._211._6.junit;

import gui.LtePlot;
import lte.r11.L1._211._6.ModulationAndUpconversion;
import lte.r11.L1._211._6.OfdmBaseBandSignalGeneration;
import lte.r11.L1._211._6.PSS;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.RealVector;
import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.ComplexVector;

/**
 * @author Michael Duo Ling
 * 
 */
public class PssTest extends UnitTestBase {

	@Test
	public void testPSS() throws Exception {
		for (int N_ID_2 = 0; N_ID_2 < 3; N_ID_2++) {
			ComplexVector pss = PSS.pss(N_ID_2);
			LtePlot.plot("PSS with N_ID_2=" + N_ID_2, "n", "PSS amplitude",
					"PSS", pss);
			ComplexVector reVector = new ComplexVector(100 * 12, new Complex(0,
					0));
			PSS.mapPss(pss, reVector);
			LtePlot.plot("PSS after RE mapping with N_ID_2=" + N_ID_2, "n", "",
					"PSS", reVector);
			ComplexVector basebandSignal = OfdmBaseBandSignalGeneration
					.ofdmBaseBandSignalGeneration(reVector, 100, 12, 1, 0, 6);
			LtePlot.plot("PSS baseband with N_ID_2=" + N_ID_2, "n", "", "PSS",
					basebandSignal);
			RealVector uuSignal = ModulationAndUpconversion.downlinkModulation(
					basebandSignal, 0, 2600 * 1000000);
			LtePlot.plot("PSS uu signal with N_ID_2=" + N_ID_2, "n", "", "PSS",
					uuSignal);
		}
		System.out.println("done.");
	}
}
