package com.github.sh0nk.matplotlib4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.Arrays;

public class MainTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCommand() throws IOException, PythonExecutionException {
        Command command = new Command();
        command.execute("print('test')");
    }

    @Test
    public void testPlot() throws IOException, PythonExecutionException {
        Plot plt = new PlotImpl(true);
        plt.plot()
            .add(Arrays.asList(1.3, 2))
            .label("label")
            .linestyle("--");
        plt.title("Title!");
        plt.legend();
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
