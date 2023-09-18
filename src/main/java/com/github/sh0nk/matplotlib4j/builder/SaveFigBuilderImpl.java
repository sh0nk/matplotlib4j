package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class SaveFigBuilderImpl implements SaveFigBuilder {

    private final CompositeBuilder<SaveFigBuilder> innerBuilder = new CompositeBuilder<>(this);

    public SaveFigBuilderImpl(String fname) {
        innerBuilder.addToArgs(fname);
    }

    @Override
    public SaveFigBuilder dpi(double arg) {
        return innerBuilder.addToKwargs("dpi", arg);
    }

    @Override
    public SaveFigBuilder facecolor(String arg) {
        return innerBuilder.addToKwargs("facecolor", arg);
    }

    @Override
    public SaveFigBuilder orientation(Orientation orientation) {
        return innerBuilder.addToKwargs("orientation", orientation.toString());
    }

    @Override
    public SaveFigBuilder papertype(String arg) {
        return innerBuilder.addToKwargs("papertype", arg);
    }

    @Override
    public SaveFigBuilder format(String arg) {
        return innerBuilder.addToKwargs("format", arg);
    }

    @Override
    public SaveFigBuilder transparent(boolean arg) {
        return innerBuilder.addToKwargs("transparent", arg);
    }

    @Override
    public SaveFigBuilder frameon(boolean arg) {
        return innerBuilder.addToKwargs("frameon", arg);
    }

    @Override
    public SaveFigBuilder bboxInches(double arg) {
        return innerBuilder.addToKwargs("bboxInches", arg);
    }

    @Override
    public SaveFigBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public SaveFigBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public SaveFigBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public SaveFigBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public SaveFigBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "savefig";
    }
}
