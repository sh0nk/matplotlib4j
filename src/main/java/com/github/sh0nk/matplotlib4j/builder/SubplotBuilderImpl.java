package com.github.sh0nk.matplotlib4j.builder;

public class SubplotBuilderImpl implements SubplotBuilder {
    private final CompositeBuilder<SubplotBuilder> innerBuilder =
            new CompositeBuilder<>(this);

    public SubplotBuilderImpl(int nrows, int ncols, int index) {
        innerBuilder.addToArgs(nrows);
        innerBuilder.addToArgs(ncols);
        innerBuilder.addToArgs(index);
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
