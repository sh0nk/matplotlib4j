package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.*;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PlotImpl implements Plot {
    private List<Builder> registeredBuilders = new LinkedList<>();
    private List<Builder> showBuilders = new LinkedList<>();

    private final boolean dryRun;
    private final PythonConfig pythonConfig;

    PlotImpl(PythonConfig pythonConfig, boolean dryRun) {
        this.pythonConfig = pythonConfig;
        this.dryRun = dryRun;
    }

    @VisibleForTesting
    PlotImpl(boolean dryRun) {
        this(PythonConfig.systemDefaultPythonConfig(), dryRun);
    }

    @Override
    public LegendBuilder legend() {
        LegendBuilder builder = new LegendBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void title(String title) {
        registeredBuilders.add(new ArgsBuilderImpl("title", title));
    }

    @Override
    public XLabelBuilder xlabel(String s) {
        XLabelBuilder builder = new XLabelBuilderImpl(s);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public YLabelBuilder ylabel(String s) {
        YLabelBuilder builder = new YLabelBuilderImpl(s);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void xlim(Number xmin, Number xmax) {
        registeredBuilders.add(new ArgsBuilderImpl("xlim", xmin, xmax));
    }

    @Override
    public void ylim(Number ymin, Number ymax) {
        registeredBuilders.add(new ArgsBuilderImpl("ylim", ymin, ymax));
    }

    @Override
    public TextBuilder text(double x, double y, String s) {
        TextBuilder builder = new TextBuilderImpl(x, y, s);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public PlotBuilder plot() {
        PlotBuilder builder = new PlotBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public ContourBuilder contour() {
        ContourBuilder builder = new ContourBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public HistBuilder hist() {
        HistBuilder builder = new HistBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public CLabelBuilder clabel(ContourBuilder contour) {
        CLabelBuilder builder = new CLabelBuilderImpl(contour);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public SaveFigBuilder savefig(String fname) {
        SaveFigBuilder builder = new SaveFigBuilderImpl(fname);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void executeSilently() throws IOException, PythonExecutionException {
        List<String> scriptLines = new LinkedList<>();
        scriptLines.add("import matplotlib as mpl");
        scriptLines.add("mpl.use('Agg')");
        scriptLines.add("import matplotlib.pyplot as plt");
        registeredBuilders.forEach(b -> scriptLines.add(b.build()));
        showBuilders.forEach(b -> scriptLines.add(b.build()));
        PyCommand command = new PyCommand(pythonConfig);
        command.execute(Joiner.on('\n').join(scriptLines));
    }

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    @Override
    public void show() throws IOException, PythonExecutionException {
        List<String> scriptLines = new LinkedList<>();
        scriptLines.add("import matplotlib.pyplot as plt");
        registeredBuilders.forEach(b -> scriptLines.add(b.build()));

        // show
        if (!dryRun) {
            scriptLines.add("plt.show()");
        }

        PyCommand command = new PyCommand(pythonConfig);
        command.execute(Joiner.on('\n').join(scriptLines));
    }

}
