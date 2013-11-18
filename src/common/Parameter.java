package common;

/**
 * Internal value of one Parameter should never be smaller than Parameter.NA!
 * 
 * @author linggduo
 * 
 */
public class Parameter extends BasicBaseClass {
	final public static long	NA		= -1;
	protected long				value	= Parameter.NA;
	protected String			suffix	= "";
	protected String			prefix	= "";
	/**
	 * Range of valid configuration.
	 */
	protected long				max		= 1;
	protected long				min		= 0;

	public Parameter(long max, long min, long value, String prefix,
			String suffix) {
		this.max = max;
		this.min = min;
		this.value = value;
		this.prefix = new String(prefix);
		this.suffix = new String(suffix);
	}

	@Override
	public String toBinaryString() {
		// first we need to know how many bits are needed to code the entire
		// value range from min to max.
		int size = 1;
		long max_value = 2;
		while (max_value < this.max) {
			size++;
			max_value <<= 1;
		}
		StringBuilder binarySb = new StringBuilder();
		binarySb.append(Long.toBinaryString(value));
		while (binarySb.length() < size) {
			binarySb.insert(0, "0");
		}
		return binarySb.toString();
	}

	@Override
	public String toReadableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(value);
		sb.append(suffix);
		return sb.toString();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
