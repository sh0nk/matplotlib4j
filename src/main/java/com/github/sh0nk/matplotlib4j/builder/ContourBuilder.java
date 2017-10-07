package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public interface ContourBuilder extends Builder {

    ContourBuilder add(List<? extends Number> Z);

    ContourBuilder add(List<? extends Number> X, List<? extends Number> Y, List<? extends List<? extends Number>> Z);

    // TODO: suppport V and N

    ContourBuilder colors(String arg);

    ContourBuilder alpha(double arg);

    ContourBuilder levels(List<? extends Number> arg);
}
