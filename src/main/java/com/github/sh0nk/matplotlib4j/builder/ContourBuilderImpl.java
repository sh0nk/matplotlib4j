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
    public ContourBuilder vmin(double arg) {
        return innerBuilder.addToKwargs("vmin", arg);
    }

    @Override
    public ContourBuilder vmax(double arg) {
        return innerBuilder.addToKwargs("vmax", arg);
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
    public ContourBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ContourBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public ContourBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public ContourBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ContourBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
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
