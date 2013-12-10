import java.util.ArrayList;
import java.util.Collection;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;

public class Main {

	public static void main(String[] args) {

		// generate data
		Collection<Number> x = new ArrayList<Number>();
		Collection<Number> y = new ArrayList<Number>();
		long N = 1000;
		double T = Math.PI * 2 / N;
		for (int i = 0; i < N; i++) {
			x.add(i * T);
			y.add(Math.sin(i * T));
		}
		//
		// // Series series1 = chart.addSeries("sin(x)", x, y);
		// // series1.setLineStyle(SeriesLineStyle.DOT_DOT);
		//
		Chart chart = QuickChart.getChart("test", "x", "y", "sin(x)", x, y);
		new SwingWrapper(chart).displayChart();

		// XYSeriesCollection dataset = new XYSeriesCollection();
		// XYSeries series = new XYSeries("XYGraph");
		// long N = 1000;
		// double T = Math.PI * 2 / N;
		// for (int i = 0; i < N; i++) {
		// series.add(i * T, Math.sin(i * T));
		// }
		// dataset.addSeries(series);
		//
		// JFreeChart chart = ChartFactory.createXYLineChart("XY Chart", "X",
		// "Y",
		// dataset);
		//
		// // JFreeChart chart = ChartFactory.createXYAreaChart("XY Chart", "X",
		// // "Y",
		// // dataset);
		//
		// try {
		// ChartUtilities.saveChartAsJPEG(new File(
		// "C:\\Users\\linggduo\\Documents\\test.jpeg"), chart, 1024,
		// 768);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
