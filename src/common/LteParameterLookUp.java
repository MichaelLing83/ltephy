package common;

import java.util.HashMap;
import java.util.Map;

public class LteParameterLookUp extends BasicBaseClass {

	static private Map<ParameterName, LteParameter>	m	= new HashMap<ParameterName, LteParameter>();

	static {
		// initialize all parameter configurations
		m.put(ParameterName.delta_f, new LteParameter(new String[] { "7.5kHz",
			"15kHz" }, "", "kHz"));
		m.put(ParameterName.DL_CyclicPrefixLength, new LteParameter(
				new String[] { "len1", "len2" }, "len", ""));
		m.put(ParameterName.MultiplexingMode, new LteParameter(new String[] {
			"FDD", "TDD" }, "", ""));
	}

	static public LteParameter get(ParameterName key) {
		return m.get(key);
	}

	static public long lookUpIndex(ParameterName key, String value)
			throws Exception {
		return m.get(key).getIndex(value);
	}

	@Override
	public String toBinaryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toReadableString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
