package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import java.util.List;

public interface ContourBuilder extends Builder, KwArgsBuilder<ContourBuilder> {

    /**
     * Equivalent to {@code pyplot.contour(Z)}
     *
     * @param Z array Z
     * @return ContourBuilder for method chain
     */
    ContourBuilder add(List<? extends Number> Z);

    /**
     * Equivalent to {@code pyplot.contour(X, Y, Z)}
     *
     * @param X the x coordinate of the surface
     * @param Y the y coordinate of the surface
     * @param Z array Z
     * @return ContourBuilder for method chain
     */
    ContourBuilder add(List<? extends Number> X, List<? extends Number> Y, List<? extends List<? extends Number>> Z);

    // TODO: support V and N

    ContourBuilder colors(String arg);

    ContourBuilder vmin(double arg);

    ContourBuilder vmax(double arg);

    ContourBuilder alpha(double arg);

    ContourBuilder levels(List<? extends Number> arg);

    String getRetName();
}
