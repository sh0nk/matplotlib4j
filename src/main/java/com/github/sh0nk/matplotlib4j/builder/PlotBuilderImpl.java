package com.github.sh0nk.matplotlib4j.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class PlotBuilderImpl implements PlotBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlotBuilderImpl.class);

    CompositeBuilder<PlotBuilder> innerBuilder = new CompositeBuilder<>(this);

    @Override
    public PlotBuilder add(List<Number> x) {
        return innerBuilder.addToArgs(x);
    }

    @Override
    public PlotBuilder add(List<Number> x, List<Number> y) {
        innerBuilder.addToArgs(x);
        return innerBuilder.addToArgs(y);
    }

    @Override
    public PlotBuilder add(List<Number> x, List<Number> y, String fmt) {
        innerBuilder.addToArgs(x);
        innerBuilder.addToArgs(y);
        return innerBuilder.addToArgs(fmt);
    }

    @Override
    public PlotBuilder linestyle(String arg) {
        return ls(arg);
    }

    @Override
    public PlotBuilder ls(String arg) {
        return innerBuilder.addToKwargs("ls", arg);
    }

    @Override
    public PlotBuilder label(String arg) {
        return innerBuilder.addToKwargs("label", arg);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "plot";
    }
}
