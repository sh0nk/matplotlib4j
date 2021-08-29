package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.ContourBuilder;
import com.github.sh0nk.matplotlib4j.builder.GridBuilder;
import com.github.sh0nk.matplotlib4j.builder.HistBuilder;
import com.github.sh0nk.matplotlib4j.builder.ScaleBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTest {

    private static final boolean DRY_RUN = true;

    private final static Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testPlot() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot()
           .add(Arrays.asList(1.3, 2))
           .label("label")
           .linestyle("--");
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();
    }

    @Test
    public void testPlotLogScale() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot()
           .add(Arrays.asList(1.3, 20, 200, 300, 400, 1000), Arrays.asList(1, 4, 10, 20, 100, 800))
           .label("label")
           .linestyle("--")
           .linewidth(2.0);
        plt.xscale(ScaleBuilder.Scale.log);
        plt.yscale(ScaleBuilder.Scale.log);
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();
    }

    @Test
    public void testPlotSin() throws IOException, PythonExecutionException {
        List<Double> x = IntStream.range(0, 100).boxed()
                .map(Integer::doubleValue)
                .map(d -> d / 15).collect(Collectors.toList());
        List<Double> y = x.stream().map(Math::sin).collect(Collectors.toList());

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot()
                .add(x, y)
                .label("sin")
                .linestyle("--");
        plt.xlim(1.0, 5.0);
        plt.xticks(Arrays.asList(Math.PI / 2, Math.PI, Math.PI * 3 / 2))
                .labels(Arrays.asList("$\\pi/2$", "$\\pi$", "$3\\pi/2$"));
        plt.title("sin curve");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotScatter() throws IOException, PythonExecutionException {
        List<Double> x = NumpyUtils.linspace(-3, 3, 100);
        List<Double> y = x.stream().map(xi -> Math.sin(xi) + Math.random()).collect(Collectors.toList());

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(x, y, "o").label("sin");
        plt.title("scatter");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotContour() throws IOException, PythonExecutionException {
        List<Double> x = NumpyUtils.linspace(-1, 1, 100);
        List<Double> y = NumpyUtils.linspace(-1, 1, 100);
        NumpyUtils.Grid<Double> grid = NumpyUtils.meshgrid(x, y);
        LOGGER.info("grid.x {}, grid.y {}", grid.x, grid.y);

        List<List<Double>> zCalced = grid.calcZ((xi, yj) -> Math.sqrt(xi * xi + yj * yj));

        Plot plt = new PlotImpl(DRY_RUN);
        ContourBuilder contour = plt.contour().add(x, y, zCalced);
        plt.clabel(contour).inline(true).fontsize(10);
        plt.title("contour");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotPColor() throws IOException, PythonExecutionException {
        List<Double> x = NumpyUtils.linspace(-1, 1, 100);
        List<Double> y = NumpyUtils.linspace(-1, 1, 100);
        NumpyUtils.Grid<Double> grid = NumpyUtils.meshgrid(x, y);
        LOGGER.info("grid.x {}, grid.y {}", grid.x, grid.y);

        List<List<Double>> cCalced = grid.calcZ((xi, yj) -> Math.sqrt(xi * xi + yj * yj));

        Plot plt = new PlotImpl(DRY_RUN);
        plt.pcolor().add(x, y, cCalced).cmap("plt.cm.Blues");
        plt.title("pcolor");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotOneHistogram() throws IOException, PythonExecutionException {
        Random rand = new Random();
        List<Double> x = IntStream.range(0, 1000).mapToObj(i -> rand.nextGaussian())
                .collect(Collectors.toList());

        Plot plt = new PlotImpl(DRY_RUN);
        plt.hist().add(x).orientation(HistBuilder.Orientation.horizontal);
        plt.ylim(-5, 5);
        plt.title("histogram");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotTwoHistogram() throws IOException, PythonExecutionException {
        Random rand = new Random();
        List<Double> x1 = IntStream.range(0, 1000).mapToObj(i -> rand.nextGaussian())
                .collect(Collectors.toList());
        List<Double> x2 = IntStream.range(0, 1000).mapToObj(i -> 4.0 + rand.nextGaussian())
                .collect(Collectors.toList());

        Plot plt = new PlotImpl(DRY_RUN);
        plt.hist().add(x1).add(x2).bins(20).stacked(true).color("#66DD66", "#6688FF").range(3, 5);
        plt.xlim(-6, 10);
        plt.title("histogram");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotHistogramNoXError() throws IOException, PythonExecutionException {
        expectedException.expect(IllegalArgumentException.class);

        Plot plt = new PlotImpl(DRY_RUN);
        plt.hist();
        plt.xlim(-5, 5);
        plt.title("histogram");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testThirdArgError() throws IOException, PythonExecutionException {
        expectedException.expect(PythonExecutionException.class);

        Plot plt = Plot.create();
        plt.plot().add(Arrays.asList(1.3, 2))
            .add(Arrays.asList(1.3, 2))
            .add(Arrays.asList(1.3, 2));
        plt.show();
    }

    @Test
    public void testBoundaryValuesCauseNoException() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 0x66, null, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY))
                .add(Arrays.asList(null, -3.2e-8, 1, Double.NaN, Double.NaN));
        plt.show();
    }

    @Test
    public void testShowTwiceClearFirstPlot() throws IOException, PythonExecutionException {
        // TODO: Check .plot() or so is not called twice on the second run script

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 2));
        plt.title("Title!");
        plt.legend();
        plt.show();

        Assert.assertEquals(0, ((PlotImpl) plt).registeredBuilders.size());
        plt.show();
    }

    @Test
    public void testSubplots() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);

        plt.subplot(2, 1, 1);
        plt.plot()
            .add(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 9));

        plt.subplot(2, 1, 2);
        plt.plot()
            .add(Arrays.asList(1, 2, 3), Arrays.asList(1, -8, 27));

        plt.show();
    }

    @Test
    public void testGrid()  throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);

        plt.plot()
                .add(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 9));

        plt.grid().axis(GridBuilder.AxisType.both).which(GridBuilder.WhichType.minor).b(true);

        plt.show();
    }
}
