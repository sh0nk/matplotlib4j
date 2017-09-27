package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.PlotBuilder;
import com.github.sh0nk.matplotlib4j.builder.TextBuilder;
import com.github.sh0nk.matplotlib4j.builder.XLabelBuilder;
import com.github.sh0nk.matplotlib4j.builder.YLabelBuilder;

import java.io.IOException;

public interface Plot {

    static Plot create() {
        return new PlotImpl();
    }

    void legend();

    void title(String title);

    XLabelBuilder xlabel(String label);

    YLabelBuilder ylabel(String label);

    void xlim(Number xmin, Number xmax);

    void ylim(Number ymin, Number ymax);

    TextBuilder text(double x, double y, String s);

    PlotBuilder plot();

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    void show() throws IOException, PythonExecutionException;
}
