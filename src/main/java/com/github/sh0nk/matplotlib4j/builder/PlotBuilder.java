package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface PlotBuilder extends Builder {

    PlotBuilder add(List<? extends Number> nums);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y, String fmt);

    PlotBuilder linestyle(String arg);

    PlotBuilder ls(String arg);

    PlotBuilder label(String arg);

}
