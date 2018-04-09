package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

public class YScaleBuilderImpl implements YScaleBuilder {

    private CompositeBuilder<YScaleBuilder> innerBuilder = new CompositeBuilder<>(this);
    private TextArgsBuilder<YScaleBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public YScaleBuilderImpl(String s) {
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "yscale";
    }
}
