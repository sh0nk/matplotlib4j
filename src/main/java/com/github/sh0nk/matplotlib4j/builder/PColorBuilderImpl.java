package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class PColorBuilderImpl implements PColorBuilder {

    private final CompositeBuilder<PColorBuilder> innerBuilder = new CompositeBuilder<>(this);

    @Override
    public PColorBuilder add(List<? extends Number> C) {
        return innerBuilder.addToArgs(C);
    }

    @Override
    public PColorBuilder add(List<? extends Number> X, List<? extends Number> Y, List<? extends List<? extends Number>> C) {
        innerBuilder.addToArgs(X);
        innerBuilder.addToArgs(Y);
        return innerBuilder.add2DimListToArgs(C);
    }

    @Override
    public PColorBuilder cmap(String colorMap) {
        return innerBuilder.addToKwargsWithoutQuoting("cmap", colorMap);
    }

    @Override
    public PColorBuilder vmin(double arg) {
        return innerBuilder.addToKwargs("vmin", arg);
    }

    @Override
    public PColorBuilder vmax(double arg) {
        return innerBuilder.addToKwargs("vmax", arg);
    }

    @Override
    public PColorBuilder edgecolors(String arg) {
        return innerBuilder.addToKwargs("edgecolors", arg);
    }

    @Override
    public PColorBuilder alpha(double arg) {
        return innerBuilder.addToKwargs("alpha", arg);
    }

    @Override
    public String getRetName() {
        return innerBuilder.getRetName();
    }

    @Override
    public PColorBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public PColorBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public PColorBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public PColorBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public PColorBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "pcolor";
    }
}
