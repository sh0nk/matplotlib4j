package com.github.sh0nk.matplotlib4j.builder;

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
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }
}
