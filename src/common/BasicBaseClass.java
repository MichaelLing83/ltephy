package common;
/**
 * Common stuff.
 */


/**
 * Base class for all classes in project. Belong to non-generable domain.
 * 
 * @author Michael Duo Ling
 */
public abstract class BasicBaseClass extends Object {

	/**
	 * Get debug information as a string, with current Class name, method name,
	 * and line number.
	 * 
	 * @return
	 */
	protected static String _getDebugInfo() {
		String fullClassName = Thread.currentThread().getStackTrace()[3]
				.getClassName();
		String className = fullClassName.substring(fullClassName
				.lastIndexOf(".") + 1);
		String methodName = Thread.currentThread().getStackTrace()[3]
				.getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[3]
				.getLineNumber();

		return className + "." + methodName + "():" + lineNumber;
	}

	/**
	 * Check the given condition and throw an Exception if it's not met.
	 */
	static public void garantee(boolean condition, String text)
			throws Exception {
		if (!condition) {
			throw new Exception(text);
		}
	}

	/**
	 * Return an binary string representation of this object. Can later be used
	 * to re-create this object from this string.
	 * 
	 * @return
	 */
	abstract public String toBinaryString();

	/**
	 * Return an human readable string representing this object. An empty string
	 * should be returned if this object cannot be represented by an human
	 * readable string.
	 * 
	 * @return
	 */
	abstract public String toReadableString();

	/**
	 * Return text representation of the object.
	 */
	@Override
	abstract public String toString();
}
