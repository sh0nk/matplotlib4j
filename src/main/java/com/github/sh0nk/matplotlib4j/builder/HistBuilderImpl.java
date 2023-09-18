package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.PatchBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.PatchBuilderImpl;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

import java.util.LinkedList;
import java.util.List;


public class HistBuilderImpl implements HistBuilder {

    private CompositeBuilder<HistBuilder> innerBuilder = new CompositeBuilder<>(this);
    private PatchBuilder<HistBuilder> patchBuilder = new PatchBuilderImpl<>(innerBuilder);
    private List<List<? extends Number>> xList = new LinkedList<>();

    @Override
    public HistBuilder add(List<? extends Number> nums) {
        xList.add(nums);
        return this;
    }

    @Override
    public HistBuilder bins(int arg) {
        return innerBuilder.addToKwargs("bins", arg);
    }

    @Override
    public HistBuilder bins(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("bins", nums);
    }

    @Override
    public HistBuilder range(double lower, double upper) {
        return innerBuilder.addToKwargsWithoutQuoting("range", String.format("(%f, %f)", lower, upper));
    }

    @Override
    public HistBuilder density(boolean arg) {
        return innerBuilder.addToKwargs("density", arg);
    }

    @Override
    public HistBuilder weights(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("weights", nums);
    }

    @Override
    public HistBuilder cumulative(boolean arg) {
        return innerBuilder.addToKwargs("cumulative", arg);
    }

    @Override
    public HistBuilder bottom(double arg) {
        return innerBuilder.addToKwargs("bottom", arg);
    }

    @Override
    public HistBuilder bottom(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("bottom", nums);
    }

    @Override
    public HistBuilder histtype(HistType histType) {
        return innerBuilder.addToKwargs("histtype", histType.toString());
    }

    @Override
    public HistBuilder align(Align align) {
        return innerBuilder.addToKwargs("align", align.name());
    }

    @Override
    public HistBuilder orientation(Orientation orientation) {
        return innerBuilder.addToKwargs("orientation", orientation.name());
    }

    @Override
    public HistBuilder rwidth(double arg) {
        return innerBuilder.addToKwargs("rwidth", arg);
    }

    @Override
    public HistBuilder log(boolean arg) {
        return innerBuilder.addToKwargs("log", arg);
    }

    @Override
    public HistBuilder color(String... args) {
        Preconditions.checkArgument(args.length > 0, ".color() needs to have at least one argument.");
        return innerBuilder.addToKwargsWithoutQuoting("color", "[\"" + Joiner.on("\", \"").join(args) + "\"]");
    }

    @Override
    public HistBuilder stacked(boolean arg) {
        return innerBuilder.addToKwargs("stacked", arg);
    }

    @Override
    public HistBuilder linestyle(String arg) {
        return patchBuilder.linestyle(arg);
    }

    @Override
    public HistBuilder ls(String arg) {
        return patchBuilder.ls(arg);
    }

    @Override
    public HistBuilder linewidth(double arg) {
        return patchBuilder.linewidth(arg);
    }

    @Override
    public HistBuilder lw(double arg) {
        return patchBuilder.lw(arg);
    }

    @Override
    public HistBuilder label(String arg) {
        return patchBuilder.label(arg);
    }

    @Override
    public HistBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public HistBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public HistBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public HistBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public HistBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        Preconditions.checkArgument(!xList.isEmpty(), ".add() is needed to be called at least once.");
        innerBuilder.addToArgsWithoutQuoting(xList.toString());
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "hist";
    }

}
