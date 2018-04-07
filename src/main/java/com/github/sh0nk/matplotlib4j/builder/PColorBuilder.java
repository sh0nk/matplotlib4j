package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public interface PColorBuilder extends Builder {

    /**
     * Equivalent to {@code pyplot.pcolor(C)}
     *
     * @param C array C
     * @return PColorBuilder for method chain
     */
    PColorBuilder add(List<? extends Number> C);

    /**
     * Equivalent to {@code pyplot.pcolor(X, Y, C)}
     *
     * @param X the x coordinate of the surface
     * @param Y the y coordinate of the surface
     * @param C array C
     * @return PColorBuilder for method chain
     */
    PColorBuilder add(List<? extends Number> X, List<? extends Number> Y, List<? extends List<? extends Number>> C);

    // TODO: support V and N


    PColorBuilder cmap(String colorMap);

    PColorBuilder vmin(double arg);

    PColorBuilder vmax(double arg);

    PColorBuilder edgecolors(String arg);

    PColorBuilder alpha(double arg);

    String getRetName();
}
