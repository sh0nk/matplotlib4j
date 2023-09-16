package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class LabelBuilderImpl implements LabelBuilder {

    private CompositeBuilder<LabelBuilder> innerBuilder = new CompositeBuilder<>(this);
    private final String methodName;

    public LabelBuilderImpl(String label, String methodName) {
        this.methodName = methodName;
        innerBuilder.addToArgs(label);
    }

    public static LabelBuilderImpl xLabelBuilder(String label) {
        return new LabelBuilderImpl(label, "xlabel");
    }

    public static LabelBuilderImpl yLabelBuilder(String label) {
        return new LabelBuilderImpl(label, "ylabel");
    }

    @Override
    public LabelBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public LabelBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public LabelBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public LabelBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public LabelBuilder addToKwargs(String k, boolean v) {
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
