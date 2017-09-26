package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

public class YLabelBuilderImpl implements YLabelBuilder {

    private CompositeBuilder<YLabelBuilder> innerBuilder = new CompositeBuilder<>(this);
    private TextArgsBuilder<YLabelBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public YLabelBuilderImpl(String s) {
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "ylabel";
    }
}
