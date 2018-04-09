package com.github.sh0nk.matplotlib4j;

import java.io.IOException;

import com.github.sh0nk.matplotlib4j.builder.CLabelBuilder;
import com.github.sh0nk.matplotlib4j.builder.ContourBuilder;
import com.github.sh0nk.matplotlib4j.builder.HistBuilder;
import com.github.sh0nk.matplotlib4j.builder.LegendBuilder;
import com.github.sh0nk.matplotlib4j.builder.PColorBuilder;
import com.github.sh0nk.matplotlib4j.builder.PlotBuilder;
import com.github.sh0nk.matplotlib4j.builder.SaveFigBuilder;
import com.github.sh0nk.matplotlib4j.builder.TextBuilder;
import com.github.sh0nk.matplotlib4j.builder.XLabelBuilder;
import com.github.sh0nk.matplotlib4j.builder.XScaleBuilder;
import com.github.sh0nk.matplotlib4j.builder.YLabelBuilder;
import com.github.sh0nk.matplotlib4j.builder.YScaleBuilder;

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

    XScaleBuilder xscale(String scale);

    YScaleBuilder yscale(String scale);

    void xlim(Number xmin, Number xmax);

    void ylim(Number ymin, Number ymax);

    TextBuilder text(double x, double y, String s);

    PlotBuilder plot();

    ContourBuilder contour();

    PColorBuilder pcolor();

    HistBuilder hist();

    CLabelBuilder clabel(ContourBuilder contour);

    SaveFigBuilder savefig(String fname);

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
