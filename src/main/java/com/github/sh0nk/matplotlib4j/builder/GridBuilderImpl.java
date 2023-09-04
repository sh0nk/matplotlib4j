package com.github.sh0nk.matplotlib4j.builder;

public class GridBuilderImpl implements GridBuilder {

    private CompositeBuilder<GridBuilder> innerBuilder = new CompositeBuilder<>(this);

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

    // TODO("Add kwargs")

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "grid";
    }
}
