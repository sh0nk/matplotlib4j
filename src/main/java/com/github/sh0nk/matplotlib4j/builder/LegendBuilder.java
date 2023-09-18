package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;

/**
 * matplotlib.pyplot.legend(*args, **kwargs)
 */
public interface LegendBuilder extends Builder, KwArgsBuilder<LegendBuilder> {

    LegendBuilder loc(int arg);

    LegendBuilder loc(String arg);

    LegendBuilder loc(double x, double y);

}
