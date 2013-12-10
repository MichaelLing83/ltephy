package gui;

import java.util.Collection;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;
import common.BasicBaseClass;

public class LtePlot extends BasicBaseClass {

	static public void plot(String chartName, String xTitle, String yTitle,
			String seriesName, Collection<Number> x, Collection<Number> y) {
		Chart chart = QuickChart.getChart(chartName, xTitle, yTitle,
				seriesName, x, y);
		new SwingWrapper(chart).displayChart();
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
