package common;

import java.util.ArrayList;
import java.util.List;

public class Event extends BasicBaseClass {

	private ParameterMap		perEventParameters;
	private List<ParameterMap>	perCellParameterList;

	/**
	 * Clone all parameters in case value in reference changes before this event
	 * is resolved.
	 * 
	 * @param perCellParameterList
	 * @param perEventParameters
	 */
	public Event(List<ParameterMap> perCellParameterList,
			ParameterMap perEventParameters) {
		this.perCellParameterList = new ArrayList<ParameterMap>();
		for (ParameterMap pMap : perCellParameterList) {
			this.perCellParameterList.add(pMap.clone());
		}
		this.perEventParameters = perEventParameters.clone();
	}

	public long getParameter(ParameterName key) {
		long result = -1;
		if (this.perEventParameters.hasParameter(key)) {
			result = this.perEventParameters.get(key);
		} else {
			for (ParameterMap pMap : this.perCellParameterList) {
				if (pMap.hasParameter(key)) {
					result = pMap.get(key);
					break;
				}
			}
		}
		return result;
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
