package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilderImpl;
import java.util.List;

public class GridBuilderImpl implements GridBuilder {

    private CompositeBuilder<GridBuilder> innerBuilder = new CompositeBuilder<>(this);
    private Line2DBuilder<GridBuilder> line2DBuilder = new Line2DBuilderImpl<>(innerBuilder);

    // -------------------------------- Optional Arguments --------------------------------
    @Override
    public GridBuilder visible(Boolean bol) {
        innerBuilder.addToKwargs("visible", bol);
        return this;
    }

    @Override
    public GridBuilder which(WhichType arg) {
        innerBuilder.addToKwargs("which", arg.toString());
        return this;
    }

    @Override
    public GridBuilder axis(AxisType arg) {
        innerBuilder.addToKwargs("axis", arg.toString());
        return this;
    }

    @Override
    public GridBuilder linestyle(String arg) {
        return line2DBuilder.linestyle(arg);
    }

    @Override
    public GridBuilder ls(String arg) {
        return line2DBuilder.ls(arg);
    }

    @Override
    public GridBuilder linewidth(double arg) {
        return line2DBuilder.linewidth(arg);
    }

    @Override
    public GridBuilder lw(double arg) {
        return line2DBuilder.lw(arg);
    }

    @Override
    public GridBuilder label(String arg) {
        return line2DBuilder.label(arg);
    }

    @Override
    public GridBuilder color(String arg) {
        return line2DBuilder.color(arg);
    }

    @Override
    public GridBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public GridBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public GridBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public GridBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public GridBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "grid";
    }
}
