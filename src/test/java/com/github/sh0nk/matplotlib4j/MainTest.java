package com.github.sh0nk.matplotlib4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTest {

    private static final boolean DRY_RUN = true;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCommand() throws IOException, PythonExecutionException {
        Command command = new Command();
        command.execute("print('test')");
    }

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
    public void testThirdArgError() throws IOException, PythonExecutionException {
        expectedException.expect(PythonExecutionException.class);

        Plot plt = Plot.create();
        plt.plot().add(Arrays.asList(1.3, 2))
            .add(Arrays.asList(1.3, 2))
            .add(Arrays.asList(1.3, 2));
        plt.show();
    }
}
