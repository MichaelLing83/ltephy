import java.util.ArrayList;
import java.util.Collection;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;

public class Main {

	public static void main(String[] args) {
		// Create Chart
		// Chart chart = new ChartBuilder().width(800).height(600)
		// .theme(ChartTheme.Matlab).title("Matlab Theme").xAxisTitle("X")
		// .yAxisTitle("Y").build();
		// chart.getStyleManager().setPlotGridLinesVisible(false);

		// generate data
		Collection<Number> x = new ArrayList<Number>();
		Collection<Number> y = new ArrayList<Number>();
		long N = 1000;
		double T = Math.PI * 2 / N;
		for (int i = 0; i < N; i++) {
			x.add(i * T);
			y.add(Math.sin(i * T));
		}

		// Series series1 = chart.addSeries("sin(x)", x, y);
		// series1.setLineStyle(SeriesLineStyle.DOT_DOT);

		Chart chart = QuickChart.getChart("test", "x", "y", "sin(x)", x, y);
		new SwingWrapper(chart).displayChart();
	}

}
