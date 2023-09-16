package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class SubplotBuilderImpl implements SubplotBuilder {
    private final CompositeBuilder<SubplotBuilder> innerBuilder = new CompositeBuilder<>(this);

    public SubplotBuilderImpl(int nrows, int ncols, int index) {
        innerBuilder.addToArgs(nrows);
        innerBuilder.addToArgs(ncols);
        innerBuilder.addToArgs(index);
    }

    @Override
    public SubplotBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public SubplotBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public SubplotBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public SubplotBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public SubplotBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "subplot";
    }
}
