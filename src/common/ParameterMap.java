package common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParameterMap extends BasicBaseClass implements Cloneable {

	private Map<ParameterName, Long>	m;

	public ParameterMap() {
		m = new HashMap<ParameterName, Long>();
	}

	@Override
	public ParameterMap clone() {
		ParameterMap newMap = new ParameterMap();
		for (ParameterName key : keys()) {
			newMap.set(key, this.get(key));
		}
		return newMap;
	}

	public Long get(ParameterName key) {
		return m.get(key);
	}

	public boolean hasParameter(ParameterName key) {
		return m.containsKey(key);
	}

	public Set<ParameterName> keys() {
		return m.keySet();
	}

	public void set(ParameterName key, Long value) {
		m.put(key, value);
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

	public Collection<Long> values() {
		return m.values();
	}

}
