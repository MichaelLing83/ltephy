/**
 * 
 */
package common.math.junit;

import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.Complex;

/**
 * @author Michael Duo Ling
 * 
 */
public class ComplexTest extends UnitTestBase {
	@Test
	public void testComplex() throws Exception {
		Complex a = new Complex(3, 4);
		this.assertEquals(a.toString(), "3.0+4.0i");
		Complex b = new Complex(1, -100);
		this.assertTrue((a.getNorm() - 5) < 0.0001);
		this.assertTrue((b.getAngle() + 1.56079666) < 0.0001);
		this.assertTrue(a.mul(b).sub(new Complex(403.0, -296.0)).getNorm() < 0.0001);
		this.assertTrue(a.div(b)
				.sub(new Complex(-0.03969603039, 0.030396960303)).getNorm() < 0.0001);
		this.assertTrue(a.div(b).mul(b).sub(new Complex(3.0, 4.0)).getNorm() < 0.0001);
		this.assertTrue(a.add(b).sub(new Complex(4.0, -96)).getNorm() < 0.0001);
	}
}
