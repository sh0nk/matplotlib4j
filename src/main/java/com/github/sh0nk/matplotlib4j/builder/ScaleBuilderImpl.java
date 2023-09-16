package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class ScaleBuilderImpl implements ScaleBuilder {

    private CompositeBuilder<ScaleBuilder> innerBuilder = new CompositeBuilder<>(this);
    private final String methodName;

    private ScaleBuilderImpl(Scale scale, String methodName) {
        this.methodName = methodName;
        innerBuilder.addToArgs(scale.name());
    }

    public static ScaleBuilderImpl xScaleBuilder(Scale scale) {
        return new ScaleBuilderImpl(scale, "xscale");
    }

    public static ScaleBuilderImpl yScaleBuilder(Scale scale) {
        return new ScaleBuilderImpl(scale, "yscale");
    }

    @Override
    public ScaleBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ScaleBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public ScaleBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public ScaleBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ScaleBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }
}
