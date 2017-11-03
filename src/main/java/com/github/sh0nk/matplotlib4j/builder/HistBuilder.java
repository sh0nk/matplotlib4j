package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.PatchBuilder;

import java.util.List;


/**
 * matplotlib.pyplot.hist(x, **kwargs)
 */
public interface HistBuilder extends Builder, PatchBuilder<HistBuilder> {

    enum HistType {
        bar,
        barstacked,
        step,
        stepfilled;
    }

    enum Align {
        left,
        mid,
        right;
    }

    enum Orientation {
        horizontal,
        vertical;
    }

    HistBuilder add(List<? extends Number> nums);

    HistBuilder bins(int arg);

    HistBuilder bins(List<? extends Number> nums);

    HistBuilder range(double lower, double upper);

    HistBuilder density(boolean arg);

    HistBuilder weights(List<? extends Number> nums);

    HistBuilder cumulative(boolean arg);

    HistBuilder bottom(double arg);

    HistBuilder bottom(List<? extends Number> nums);

    HistBuilder histtype(HistType histType);

    HistBuilder align(Align align);

    HistBuilder orientation(Orientation orientation);

    HistBuilder rwidth(double arg);

    HistBuilder log(boolean arg);

    HistBuilder color(String... args);

    HistBuilder stacked(boolean arg);

}
