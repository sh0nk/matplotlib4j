package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;

import java.util.List;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface PlotBuilder extends Builder, Line2DBuilder<PlotBuilder> {

    PlotBuilder add(List<? extends Number> nums);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y, String fmt);
}
