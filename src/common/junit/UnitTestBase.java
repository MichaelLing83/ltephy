package common.junit;

public class UnitTestBase {

	public interface Statements {
		void runStatements() throws Exception;
	}

	protected void assertBiggerThan(Integer value, Integer threshold)
			throws Exception {
		if (value <= threshold) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("value <= threshold (" + value + " <= "
					+ threshold + ") at:\n\tfile:\t" + e.getFileName()
					+ "\n\tclass:\t" + e.getClassName() + "\n\tline:\t"
					+ e.getLineNumber());
		}
	}

	protected void assertBiggerThanOrEqualTo(Integer value, Integer threshold)
			throws Exception {
		if (value < threshold) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("value < threshold (" + value + " < "
					+ threshold + ") at:\n\tfile:\t" + e.getFileName()
					+ "\n\tclass:\t" + e.getClassName() + "\n\tline:\t"
					+ e.getLineNumber());
		}
	}

	protected void assertEquals(Object expected, Object actual)
			throws Exception {
		if (!expected.equals(actual)) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("Expected != actual (" + expected.toString()
					+ " != " + actual.toString() + ") at:\n\tfile:\t"
					+ e.getFileName() + "\n\tclass:\t" + e.getClassName()
					+ "\n\tline:\t" + e.getLineNumber());
		}
		// org.junit.Assert.assertEquals(expected, actual);
	}

	protected void assertSmallerThan(Integer value, Integer threshold)
			throws Exception {
		if (value >= threshold) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("value >= threshold (" + value + " >= "
					+ threshold + ") at:\n\tfile:\t" + e.getFileName()
					+ "\n\tclass:\t" + e.getClassName() + "\n\tline:\t"
					+ e.getLineNumber());
		}
	}

	protected void assertSmallerThanOrEqualTo(Integer value, Integer threshold)
			throws Exception {
		if (value > threshold) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("value > threshold (" + value + " > "
					+ threshold + ") at:\n\tfile:\t" + e.getFileName()
					+ "\n\tclass:\t" + e.getClassName() + "\n\tline:\t"
					+ e.getLineNumber());
		}
	}

	protected void assertThrowException(Statements statements,
			String exceptionMessage, boolean isExactMessage) throws Exception {
		boolean hasException = false;

		try {
			this.runInsideMe(statements);
		} catch (Exception e) {
			hasException = true;
			if (isExactMessage) {
				if (!e.getMessage().equals(exceptionMessage)) {
					throw new Exception("Raised exception with message:\n\t"
							+ e.getMessage()
							+ "\nis different from the expected message:\n\t"
							+ exceptionMessage);

				}
			} else {
				if (!e.getMessage().contains(exceptionMessage)) {
					throw new Exception("Raised exception with message:\n\t"
							+ e.getMessage()
							+ "\ndoesn't contain the expected message:\n\t"
							+ exceptionMessage);
				}
			}
		}
		if (!hasException) {
			throw new Exception("The excepted exception with message + \""
					+ exceptionMessage + "\" is not thrown!");
		}
	}

	protected void assertTrue(boolean condition) throws Exception {
		if (!condition) {
			StackTraceElement[] stackTraceElements = Thread.currentThread()
					.getStackTrace();
			StackTraceElement e = stackTraceElements[2];
			throw new Exception("assertTrue failed at:\n\tfile:\t"
					+ e.getFileName() + "\n\tclass:\t" + e.getClassName()
					+ "\n\tline:\t" + e.getLineNumber());
		}
	}

	private void runInsideMe(Statements ss) throws Exception {
		ss.runStatements();
	}
}
