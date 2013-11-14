package common.math.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BitTest.class, LteBinaryIndexedFromMsbTest.class,
		LteBinaryIndexedFromLsbTest.class })
public class CommonMathTestSuite {
	// empty class
}