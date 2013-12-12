/**
 * 
 */
package lte.r11.L1._211._6.junit;

import gui.LtePlot;
import lte.r11.L1._211._6.PSS;

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
		}
		System.out.println("done.");
	}
}
