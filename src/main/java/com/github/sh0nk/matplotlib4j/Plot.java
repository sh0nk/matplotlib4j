package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.*;

import java.io.IOException;

public interface Plot {

    static Plot create() {
        return new PlotImpl(PythonConfig.systemDefaultPythonConfig(), false);
    }

    static Plot create(PythonConfig pythonConfig) {
        return new PlotImpl(pythonConfig, false);
    }

    LegendBuilder legend();

    void title(String title);

    XLabelBuilder xlabel(String label);

    YLabelBuilder ylabel(String label);

    void xlim(Number xmin, Number xmax);

    void ylim(Number ymin, Number ymax);

    TextBuilder text(double x, double y, String s);

    PlotBuilder plot();

    ContourBuilder contour();

    HistBuilder hist();

    CLabelBuilder clabel(ContourBuilder contour);

    SaveFigBuilder savefig(String fname);

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
