package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilderImpl;

import java.util.List;

public class TicksBuilderImpl implements TicksBuilder {

    private CompositeBuilder<TicksBuilder> innerBuilder = new CompositeBuilder<>(this);
    // TODO: Add kwargs with textBuilder
    private TextArgsBuilder<TicksBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    private final String methodName;
    private List<String> labels;

    public TicksBuilderImpl(List<? extends Number> ticks, String methodName) {
        // Add labels without ticks causes an error, that's why made ticks as mandatory parameter
        // matplotlib.units.ConversionError: Failed to convert value(s) to axis units: ['a', 'b']
        this.methodName = methodName;
        innerBuilder.addToArgs(ticks);
    }

    @Override
    public TicksBuilder labels(List<String> labels) {
        innerBuilder.addToArgs(labels);
        return this;
    }

    public static TicksBuilderImpl xTicksBuilder(List<? extends Number> ticks) {
        return new TicksBuilderImpl(ticks, "xticks");
    }

    public static TicksBuilderImpl yTicksBuilder(List<? extends Number> ticks) {
        return new TicksBuilderImpl(ticks, "yticks");
    }

    @Override
    public TicksBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public TicksBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public TicksBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public TicksBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public TicksBuilder addToKwargs(String k, boolean v) {
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
