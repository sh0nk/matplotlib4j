package com.github.sh0nk.matplotlib4j.builder;


import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;

/**
 * matplotlib.pyplot.grid(b=None, which='major', axis='both', **kwargs)[source]
 */
public interface GridBuilder extends Builder, TextArgsBuilder<GridBuilder>, Line2DBuilder<GridBuilder>, KwArgsBuilder<GridBuilder> {

    enum WhichType {
        major,
        minor,
        both
    }

    enum AxisType {
        both,
        x,
        y
    }

    GridBuilder visible(Boolean bol);

    GridBuilder which(WhichType arg);

    GridBuilder axis(AxisType arg);

}
