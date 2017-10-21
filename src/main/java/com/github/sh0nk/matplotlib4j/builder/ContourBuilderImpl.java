package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class ContourBuilderImpl implements ContourBuilder {

    private final CompositeBuilder<ContourBuilder> innerBuilder = new CompositeBuilder<>(this);

    @Override
    public ContourBuilder add(List<? extends Number> Z) {
        return innerBuilder.addToArgs(Z);
    }

    @Override
    public ContourBuilder add(List<? extends Number> X, List<? extends Number> Y, List<? extends List<? extends Number>> Z) {
        innerBuilder.addToArgs(X);
        innerBuilder.addToArgs(Y);
        return innerBuilder.add2DimListToArgs(Z);
    }

    @Override
    public ContourBuilder colors(String arg) {
        return innerBuilder.addToKwargs("colors", arg);
    }

    @Override
    public ContourBuilder alpha(double arg) {
        return innerBuilder.addToKwargs("alpha", arg);
    }

    @Override
    public ContourBuilder levels(List<? extends Number> arg) {
        return innerBuilder.addToKwargs("levels", arg);
    }

    @Override
    public String getRetName() {
        return innerBuilder.getRetName();
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "contour";
    }
}
