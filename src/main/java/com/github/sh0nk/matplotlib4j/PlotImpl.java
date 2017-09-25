package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.Builder;
import com.github.sh0nk.matplotlib4j.builder.PlotBuilder;
import com.github.sh0nk.matplotlib4j.builder.PlotBuilderImpl;
import com.github.sh0nk.matplotlib4j.builder.SingleStringArgBuilderImpl;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PlotImpl implements Plot {
    private List<String> scriptLines = new LinkedList<>();
    private List<Builder> registeredBuilders = new LinkedList<>();

    private final boolean dryRun;

    public PlotImpl() {
        this(false);
    }

    @VisibleForTesting
    PlotImpl(boolean dryRun) {
        this.dryRun = dryRun;
        scriptLines.add("import matplotlib.pyplot as plt");
    }

    @Override
    public void legend() {
        scriptLines.add("plt.legend()");
    }

    @Override
    public void title(String title) {
        registeredBuilders.add(new SingleStringArgBuilderImpl("title", title));
    }

    @Override
    public PlotBuilder plot() {
        PlotBuilder builder = new PlotBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    @Override
    public void show() throws IOException, PythonExecutionException {
        registeredBuilders.stream().forEach(b -> scriptLines.add(b.build()));

        // show
        if (!dryRun) {
            scriptLines.add("plt.show()");
        }

        Command command = new Command();
        command.execute(Joiner.on('\n').join(scriptLines));
    }
}
