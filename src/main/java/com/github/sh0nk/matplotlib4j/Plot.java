package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.PlotBuilder;

import java.io.IOException;

public interface Plot {

    static Plot create() {
        return new PlotImpl();
    }

    void legend();

    void title(String title);

    PlotBuilder plot();

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    void show() throws IOException, PythonExecutionException;
}
