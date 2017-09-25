package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface PlotBuilder extends Builder {

    PlotBuilder add(List<Number> nums);

    PlotBuilder add(List<Number> x, List<Number> y);

    PlotBuilder add(List<Number> x, List<Number> y, String fmt);

    PlotBuilder linestyle(String arg);

    PlotBuilder ls(String arg);

    PlotBuilder label(String arg);

}
