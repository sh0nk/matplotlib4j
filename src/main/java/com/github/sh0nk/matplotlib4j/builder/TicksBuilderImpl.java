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
        this.methodName = methodName;
        innerBuilder.addToArgs(ticks);
    }

    @Override
    public TicksBuilder labels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public static TicksBuilderImpl xTicksBuilder(List<? extends Number> ticks) {
        return new TicksBuilderImpl(ticks, "xticks");
    }

    public static TicksBuilderImpl yTicksBuilder(List<? extends Number> ticks) {
        return new TicksBuilderImpl(ticks, "yticks");
    }

    @Override
    public String build() {
        if (labels != null) {
            // Add labels without ticks causes an error, that's why made ticks as default mandatory parameter
            // matplotlib.units.ConversionError: Failed to convert value(s) to axis units: ['a', 'b']
            innerBuilder.addToArgs(labels);
        }
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }

}
