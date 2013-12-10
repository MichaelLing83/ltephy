/**
 * 
 */
package common.math.junit;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.ComplexMatrix;

/**
 * @author Michael Duo Ling
 * 
 */
public class ComplexMatrixTest extends UnitTestBase {
	@Test
	public void testAdd() throws Exception {
		ComplexMatrix m = new ComplexMatrix();
		m = m.createMatrix(3, 3);
		m.setEntry(0, 0, new Complex(1, 1));
		System.out.println(m.toReadableString());
	}
}
