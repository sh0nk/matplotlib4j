package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilderImpl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BarBuilderImpl implements BarBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(BarBuilderImpl.class);

    private CompositeBuilder<BarBuilder> innerBuilder = new CompositeBuilder<>(this);
    private Line2DBuilder<BarBuilder> line2DBuilder = new Line2DBuilderImpl<>(innerBuilder);

    @Override
    public BarBuilder add(List<? extends Number> nums) {
        return innerBuilder.addToArgs(nums);
    }

    @Override
    public BarBuilder linestyle(String arg) {
        return line2DBuilder.linestyle(arg);
    }

    @Override
    public BarBuilder ls(String arg) {
        return line2DBuilder.ls(arg);
    }

    @Override
    public BarBuilder linewidth(double arg) {
        return line2DBuilder.linewidth(arg);
    }

    @Override
    public BarBuilder lw(double arg) {
        return line2DBuilder.lw(arg);
    }

    @Override
    public BarBuilder label(String arg) {
        return line2DBuilder.label(arg);
    }

    @Override
    public BarBuilder color(String arg) {
        return line2DBuilder.color(arg);
    }

    @Override
    public BarBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public BarBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public BarBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public BarBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public BarBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "bar";
    }
}
