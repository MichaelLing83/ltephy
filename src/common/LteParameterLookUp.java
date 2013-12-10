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
