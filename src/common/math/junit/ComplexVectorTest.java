/**
 * 
 */
package common.math.junit;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.ComplexVector;

/**
 * @author Michael Duo Ling
 * 
 */
public class ComplexVectorTest extends UnitTestBase {
	@Test
	public void testComplexVector() throws Exception {
		ComplexVector cv = new ComplexVector();
		cv.append(new Complex(1, 2));
		cv.append(new Complex(1, 2));
		this.assertEquals("1 + 2i, 1 + 2i, ", cv.toString());
		// System.out.println(cv.toString());
		// System.out.println("#######");
		this.assertEquals("1.0	2.0\n1.0	2.0\n", cv.toReadableString());
		// System.out.println(cv.toReadableString());
	}
}
