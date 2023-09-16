package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.*;

import java.io.IOException;
import java.util.List;

public interface Plot {

    static Plot create() {
        return new PlotImpl(PythonConfig.systemDefaultPythonConfig(), false);
    }

    static Plot create(PythonConfig pythonConfig) {
        return new PlotImpl(pythonConfig, false);
    }

    CustomBuilder cmd(String key);

    CustomBuilder cmd(String methodPrefix, String key, Boolean returns);

    GridBuilder grid();

    LegendBuilder legend();

    /**
     * This renews a figure. Make sure that this has to be put before adding plots.
     * Unless that, a new figure window will be open.
     */
    void figure(String windowTitle);

    void title(String title);

    LabelBuilder xlabel(String label);

    LabelBuilder ylabel(String label);

    ScaleBuilder xscale(ScaleBuilder.Scale scale);

    ScaleBuilder yscale(ScaleBuilder.Scale scale);

    void xlim(Number xmin, Number xmax);

    void ylim(Number ymin, Number ymax);

    TicksBuilder xticks(List<? extends Number> ticks);

    TicksBuilder yticks(List<? extends Number> ticks);

    TextBuilder text(double x, double y, String s);

    AxLineBuilder axvline();

    AxLineBuilder axhline();

    PlotBuilder plot();

    ContourBuilder contour();

    PColorBuilder pcolor();

    HistBuilder hist();

    BarBuilder bar();

    ScatterBuilder scatter();

    CLabelBuilder clabel(ContourBuilder contour);

    SaveFigBuilder savefig(String fname);

    SubplotBuilder subplot(int nrows, int ncols, int index);

    /**
     * Close a figure window.
     */
    void close();

    /**
     * Close a figure window with name label.
     */
    void close(String name);

    /**
     * Silently execute Python script until here by builders.
     * It is mostly useful to execute `plt.savefig()` without showing by window.
     */
    void executeSilently() throws IOException, PythonExecutionException;

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    void show() throws IOException, PythonExecutionException;

}
