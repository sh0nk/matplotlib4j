package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

public class XScaleBuilderImpl implements XScaleBuilder {

    private CompositeBuilder<XScaleBuilder> innerBuilder = new CompositeBuilder<>(this);
    private TextArgsBuilder<XScaleBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public XScaleBuilderImpl(String s) {
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "xscale";
    }
}
