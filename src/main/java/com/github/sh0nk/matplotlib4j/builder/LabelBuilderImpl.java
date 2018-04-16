package com.github.sh0nk.matplotlib4j.builder;

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
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }
}
