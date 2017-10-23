package com.github.sh0nk.matplotlib4j.builder;

public class CLabelBuilderImpl implements CLabelBuilder {

    private final CompositeBuilder<CLabelBuilder> innerBuilder = new CompositeBuilder<>(this);

    public CLabelBuilderImpl(ContourBuilder contour) {
        innerBuilder.addToArgsWithoutQuoting(contour.getRetName());
    }

    @Override
    public CLabelBuilder fontsize(String arg) {
        return innerBuilder.addToKwargs("fontsize", arg);
    }

    @Override
    public CLabelBuilder fontsize(double arg) {
        return innerBuilder.addToKwargs("fontsize", arg);
    }

    @Override
    public CLabelBuilder inline(boolean arg) {
        return innerBuilder.addToKwargs("inline", arg);
    }

    @Override
    public CLabelBuilder inlineSpacing(double arg) {
        return innerBuilder.addToKwargs("inline_spacing", arg);
    }

    @Override
    public CLabelBuilder fmt(String arg) {
        return innerBuilder.addToKwargs("fmt", arg);
    }

    @Override
    public CLabelBuilder manual(boolean arg) {
        return innerBuilder.addToKwargs("manual", arg);
    }

    @Override
    public CLabelBuilder rightsideUp(boolean arg) {
        return innerBuilder.addToKwargs("rightside_up", arg);
    }

    @Override
    public CLabelBuilder useClabeltext(boolean arg) {
        return innerBuilder.addToKwargs("use_clabeltext", arg);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "clabel";
    }
}
