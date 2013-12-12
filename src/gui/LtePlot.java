package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.linear.RealVector;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.StyleManager.LegendPosition;
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
		// double x_max = cv.getEntry(0).abs();
		// double x_min = cv.getEntry(0).abs();
		List<Number> x_abs = new ArrayList<Number>();
		List<Number> x_arg = new ArrayList<Number>();
		List<Number> n = new ArrayList<Number>();
		for (int i = 0; i < cv.getDimension(); i++) {
			x_abs.add(cv.getEntry(i).abs());
			x_arg.add(cv.getEntry(i).getArgument());
			// x_max = Math.max(cv.getEntry(i).abs(), x_max);
			// x_min = Math.min(cv.getEntry(i).abs(), x_min);
			n.add(i);
		}
		Chart chart = new ChartBuilder().chartType(ChartType.Line).width(1024)
				.height(768).title(chartName).xAxisTitle(xTitle)
				.yAxisTitle(yTitle).build();
		chart.addSeries("Amplitude", n, x_abs);
		chart.addSeries("Argument", n, x_arg);
		// Chart chart = QuickChart.getChart(chartName, xTitle, yTitle,
		// seriesName, n, x_abs);
		// chart.getStyleManager().setYAxisMin(x_min);
		// chart.getStyleManager().setYAxisMax(x_max);
		chart.getStyleManager().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyleManager().setChartType(ChartType.Line);
		chart.getStyleManager().setYAxisTicksVisible(true);
		// chart.getStyleManager().setYAxisLogarithmic(true);
		// System.out.println("x_max=" + x_max + ", x_min=" + x_min);
		new SwingWrapper(chart).displayChart();
	}

	static public void plot(String chartName, String xTitle, String yTitle,
			String seriesName, RealVector rv) {
		// double x_max = cv.getEntry(0).abs();
		// double x_min = cv.getEntry(0).abs();
		List<Number> x = new ArrayList<Number>();
		List<Number> n = new ArrayList<Number>();
		for (int i = 0; i < rv.getDimension(); i++) {
			x.add(rv.getEntry(i));
			n.add(i);
		}
		Chart chart = new ChartBuilder().chartType(ChartType.Line).width(1024)
				.height(768).title(chartName).xAxisTitle(xTitle)
				.yAxisTitle(yTitle).build();
		chart.addSeries("Amplitude", n, x);
		// Chart chart = QuickChart.getChart(chartName, xTitle, yTitle,
		// seriesName, n, x_abs);
		// chart.getStyleManager().setYAxisMin(x_min);
		// chart.getStyleManager().setYAxisMax(x_max);
		chart.getStyleManager().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyleManager().setChartType(ChartType.Line);
		chart.getStyleManager().setYAxisTicksVisible(true);
		// chart.getStyleManager().setYAxisLogarithmic(true);
		// System.out.println("x_max=" + x_max + ", x_min=" + x_min);
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
