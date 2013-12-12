package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;
import common.BasicBaseClass;
import common.math.ComplexVector;

public class LtePlot extends BasicBaseClass {

	static public void plot(String chartName, String xTitle, String yTitle,
			String seriesName, Collection<Number> x, Collection<Number> y) {
		Chart chart = QuickChart.getChart(chartName, xTitle, yTitle,
				seriesName, x, y);
		new SwingWrapper(chart).displayChart();
	}

	static public void plot(String chartName, String xTitle, String yTitle,
			String seriesName, ComplexVector cv) {
		List<Number> x_abs = new ArrayList<Number>();
		List<Number> n = new ArrayList<Number>();
		for (int i = 0; i < cv.getDimension(); i++) {
			x_abs.add(cv.getEntry(i).abs());
			n.add(i);
		}
		Chart chart = QuickChart.getChart(chartName, xTitle, yTitle,
				seriesName, n, x_abs);
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
