package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.TypeConversion;

public class LegendBuilderImpl implements LegendBuilder {

    private CompositeBuilder<LegendBuilder> innerBuilder = new CompositeBuilder<>(this);

    @Override
    public LegendBuilder loc(int arg) {
        return innerBuilder.addToKwargs("loc", arg);
    }

    @Override
    public LegendBuilder loc(String arg) {
        return innerBuilder.addToKwargs("loc", arg);
    }

    @Override
    public LegendBuilder loc(double x, double y) {
        return innerBuilder.addToKwargsWithoutQuoting("loc", String.format("(%s, %s)",
                TypeConversion.INSTANCE.toSafeDouble(x), TypeConversion.INSTANCE.toSafeDouble(y)));
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "legend";
    }
}
