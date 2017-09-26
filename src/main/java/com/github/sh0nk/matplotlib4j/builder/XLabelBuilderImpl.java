package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

public class XLabelBuilderImpl implements XLabelBuilder {

    private CompositeBuilder<XLabelBuilder> innerBuilder = new CompositeBuilder<>(this);
    private TextArgsBuilder<XLabelBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public XLabelBuilderImpl(String s) {
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "xlabel";
    }
}
