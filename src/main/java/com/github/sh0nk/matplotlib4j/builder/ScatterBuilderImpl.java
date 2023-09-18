package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ScatterBuilderImpl implements ScatterBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScatterBuilderImpl.class);

    private CompositeBuilder<ScatterBuilder> innerBuilder = new CompositeBuilder<>(this);
    private Line2DBuilder<ScatterBuilder> line2DBuilder = new Line2DBuilderImpl<>(innerBuilder);

    @Override
    public ScatterBuilder add(List<? extends Number> x) {
        return innerBuilder.addToArgs(x);
    }

    @Override
    public ScatterBuilder s(double s) {
        return innerBuilder.addToKwargs("s", s);
    }

    @Override
    public ScatterBuilder c(String color) {
        return innerBuilder.addToKwargs("c", color);
    }

    @Override
    public ScatterBuilder marker(String marker) {
        return innerBuilder.addToKwargs("marker", marker);
    }

    @Override
    public ScatterBuilder cmap(String cmap) {
        return innerBuilder.addToKwargs("cmap", cmap);
    }

    @Override
    public ScatterBuilder norm(String norm) {
        return innerBuilder.addToKwargs("norm", norm);
    }

    @Override
    public ScatterBuilder vmin(double vmin) {
        return innerBuilder.addToKwargs("vmin", vmin);
    }

    @Override
    public ScatterBuilder vmax(double vmax) {
        return innerBuilder.addToKwargs("vmax", vmax);
    }

    @Override
    public ScatterBuilder alpha(double alpha) {
        return innerBuilder.addToKwargs("alpha", alpha);
    }

    @Override
    public ScatterBuilder linewidths(double linewidths) {
        return innerBuilder.addToKwargs("linewidths", linewidths);
    }

    @Override
    public ScatterBuilder edgecolors(String edgecolors) {
        return innerBuilder.addToKwargs("edgecolors", edgecolors);
    }

    @Override
    public ScatterBuilder plotnonfinite(boolean plotnonfinite) {
        return innerBuilder.addToKwargs("plotnonfinite", plotnonfinite);
    }

    @Override
    public ScatterBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ScatterBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public ScatterBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public ScatterBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public ScatterBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "scatter";
    }
}
