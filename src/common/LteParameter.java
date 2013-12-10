package common;

import java.util.Arrays;
import java.util.List;

/**
 * Internal value of one Parameter should never be smaller than Parameter.NA!
 * 
 * @author linggduo
 * 
 */
public class LteParameter extends BasicBaseClass {

	protected String		suffix			= "";
	protected String		prefix			= "";
	protected List<String>	allValueList	= null;
	protected long			min				= -1;
	protected long			max				= -1;

	public LteParameter(long min, long max) {
		this.min = min;
		this.max = max;
	}

	public LteParameter(String[] valueArray) {
		this.allValueList = Arrays.asList(valueArray);
		this.prefix = "";
		this.suffix = "";
	}

	public LteParameter(String[] valueArray, String prefix, String suffix) {
		this.allValueList = Arrays.asList(valueArray);
		this.prefix = new String(prefix);
		this.suffix = new String(suffix);
	}

	public long getIndex(String value) throws Exception {
		long result = -1;
		garantee(this.allValueList != null,
				"Can't search for String values when potential possible values are too many!");
		for (int i = 0; i < this.allValueList.size(); i++) {
			if (this.allValueList.get(i).equals(value)) {
				result = i;
				break;
			}
		}
		return result;
	}

	public long getLong(long index) throws Exception {
		long result = -1;
		if (this.allValueList != null) {
			// this parameter is stored as String value list
			garantee(index >= 0 && index < this.allValueList.size(), "Index="
					+ index + " is out of boundary!");
			String value = this.allValueList.get((int) index);
			value = value.substring(this.prefix.length(), value.length() - 1
					- this.suffix.length());
			result = Long.parseLong(value);
		} else {
			// this parameter is stored as min and max
			garantee(index >= 0 && index < this.max - this.min, "Index="
					+ index + " is out of boundary!");
			result = this.min + index;
		}
		return result;
	}

	@Override
	public String toBinaryString() {
		return "";
	}

	public String toBinaryString(long index) {
		// first we need to know how many bits are needed to code the entire
		// value range from min to max.
		int size = 1;
		long max_value = 2;
		while (max_value < this.max) {
			size++;
			max_value <<= 1;
		}
		StringBuilder binarySb = new StringBuilder();
		binarySb.append(Long.toBinaryString(index));
		while (binarySb.length() < size) {
			binarySb.insert(0, "0");
		}
		return binarySb.toString();
	}

	@Override
	public String toReadableString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toReadableString(long index) {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(index);
		sb.append(suffix);
		return sb.toString();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
