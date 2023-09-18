package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilderImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AxLineBuilderImpl implements AxLineBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(AxLineBuilderImpl.class);

    private CompositeBuilder<AxLineBuilder> innerBuilder = new CompositeBuilder<>(this);
    private Line2DBuilder<AxLineBuilder> line2DBuilder = new Line2DBuilderImpl<>(innerBuilder);
    private final String direction;
    private final String axis;

    public AxLineBuilderImpl(String direction, String axis) {
        this.direction = direction;
        this.axis = axis;
    }

    @Override
    public AxLineBuilder at(Number value) {
        return innerBuilder.addToKwargs(axis, value);
    }

    @Override
    public AxLineBuilder min(Number value) {
        return innerBuilder.addToKwargs(axis + "min", value);
    }

    @Override
    public AxLineBuilder max(Number value) {
        return innerBuilder.addToKwargs(axis + "max", value);
    }

    @Override
    public AxLineBuilder linestyle(String arg) {
        return line2DBuilder.linestyle(arg);
    }

    @Override
    public AxLineBuilder ls(String arg) {
        return line2DBuilder.ls(arg);
    }

    @Override
    public AxLineBuilder linewidth(double arg) {
        return line2DBuilder.linewidth(arg);
    }

    @Override
    public AxLineBuilder lw(double arg) {
        return line2DBuilder.lw(arg);
    }

    @Override
    public AxLineBuilder label(String arg) {
        return line2DBuilder.label(arg);
    }

    @Override
    public AxLineBuilder color(String arg) {
        return line2DBuilder.color(arg);
    }

    @Override
    public AxLineBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public AxLineBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public AxLineBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public AxLineBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public AxLineBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "ax" + direction + "line";
    }
}
