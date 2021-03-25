package com.github.sh0nk.matplotlib4j.kwargs;

import com.github.sh0nk.matplotlib4j.builder.Builder;
import com.github.sh0nk.matplotlib4j.builder.CompositeBuilder;


public class Line2DBuilderImpl<T extends Builder> implements Line2DBuilder<T> {

    private final CompositeBuilder<T> innerBuilder;

    public Line2DBuilderImpl(CompositeBuilder<T> innerBuilder) {
        this.innerBuilder = innerBuilder;
    }

    @Override
    public T linestyle(String arg) {
        return ls(arg);
    }

    @Override
    public T ls(String arg) {
        return innerBuilder.addToKwargs("ls", arg);
    }

    @Override
    public T linewidth(double arg) {
        return lw(arg);
    }

    @Override
    public T lw(double arg) {
        return innerBuilder.addToKwargs("lw", arg);
    }

    @Override
    public T label(String arg) {
        return innerBuilder.addToKwargs("label", arg);
    }

    @Override
    public T color(String arg) {
        return innerBuilder.addToKwargs("color", arg);
    }

}
