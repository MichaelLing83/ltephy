/**
 * 
 */
package common.math.junit;

import gui.LtePlot;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import org.junit.Test;

import common.junit.UnitTestBase;
import common.math.ComplexVector;

/**
 * @author Michael Duo Ling
 * 
 */
public class DftTest extends UnitTestBase {
	@Test
	public void testAdd() throws Exception {
		int N = 1024;
		ComplexVector x = new ComplexVector();
		// Collection<Number> n = new ArrayList<Number>();
		for (int i = 0; i < N; i++) {
			x.append(new Complex(0, 0));
			// n.add(i);
		}
		x.setEntry(0, new Complex(3, 4));
		x.setEntry(1, new Complex(3, 4));
		// List<Number> x_abs = new ArrayList<Number>();
		// for (Complex c : x.toArray()) {
		// x_abs.add(c.abs());
		// }
		// new ArrayList<Complex>(Arrays.asList(x.toArray()));
		// LtePlot.plot("x", "n", "x[n]", "x[n]", n, x_abs);
		LtePlot.plot("new_x", "n", "x[n]", "x[n]", x);
		FastFourierTransformer fft = new FastFourierTransformer(
				DftNormalization.STANDARD);
		ComplexVector X = new ComplexVector(fft.transform(x.toArray(),
				TransformType.FORWARD));
		LtePlot.plot("X", "k", "X[k]", "X[k]", X);
		ComplexVector y = new ComplexVector(fft.transform(X.toArray(),
				TransformType.INVERSE));
		LtePlot.plot("y", "n", "y[n]", "y[n]", y);
		X.getClass();
		// System.out.println(X.toReadableString());
	}
}
