package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

public class TextBuilderImpl implements TextBuilder {

    private CompositeBuilder<TextBuilder> innerBuilder = new CompositeBuilder<>(this);
    // TODO: Add kwargs with textBuilder
    private TextArgsBuilder<TextBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public TextBuilderImpl(double x, double y, String s) {
        innerBuilder.addToArgs(x);
        innerBuilder.addToArgs(y);
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "text";
    }
}
