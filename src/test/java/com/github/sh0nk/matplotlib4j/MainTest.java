package com.github.sh0nk.matplotlib4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
        plt.title("sin curve");
        plt.legend().loc("upper right");
        plt.show();
    }

    @Test
    public void testPlotContour() throws IOException, PythonExecutionException {
        List<Double> x = NumpyUtils.linspace(-1, 1, 100);
        List<Double> y = NumpyUtils.linspace(-1, 1, 100);
        NumpyUtils.Grid<Double> z = NumpyUtils.meshgrid(x, y);
        LOGGER.info("z.x {}, z.y {}", z.x, z.y);

        List<List<Double>> zCalced = z.calcZ((xi, yj) -> xi * xi + yj * yj);

        Plot plt = new PlotImpl(false);
        plt.contour().add(x, y, zCalced); //.levels(Collections.singletonList(0));
        plt.title("contour");
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
    public void testNullCauseNoException() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 0x66, null))
                .add(Arrays.asList(null, -3.2e-8, 1));
        plt.show();
    }
}
