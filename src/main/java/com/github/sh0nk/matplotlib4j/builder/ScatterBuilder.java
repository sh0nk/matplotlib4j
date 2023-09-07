package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;

import java.util.List;


/**
 * matplotlib.pyplot.scatter(*args, **kwargs)
 */
public interface ScatterBuilder extends Builder {

    ScatterBuilder add(List<? extends Number> x);

    ScatterBuilder s(double s);

    ScatterBuilder c(String color);

    ScatterBuilder marker(String marker);

    ScatterBuilder cmap(String cmap);

    ScatterBuilder norm(String norm);

    ScatterBuilder vmin(double vmin);

    ScatterBuilder vmax(double vmax);

    ScatterBuilder alpha(double alpha);

    ScatterBuilder linewidths(double linewidths);

    ScatterBuilder edgecolors(String edgecolors);

    ScatterBuilder plotnonfinite(boolean plotnonfinite);

}
