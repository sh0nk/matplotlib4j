package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class LegendBuilderImpl implements LegendBuilder {

    private CompositeBuilder<LegendBuilder> innerBuilder = new CompositeBuilder<>(this);

    @Override
    public LegendBuilder loc(int arg) {
        return innerBuilder.addToKwargs("loc", arg);
    }

    @Override
    public LegendBuilder loc(String arg) {
        return innerBuilder.addToKwargs("loc", arg);
    }

    @Override
    public LegendBuilder loc(double x, double y) {
        return innerBuilder.addToKwargsWithoutQuoting("loc", String.format("(%d, %d)", x, y));
    }

    @Override
    public LegendBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public LegendBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public LegendBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public LegendBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public LegendBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "legend";
    }
}
