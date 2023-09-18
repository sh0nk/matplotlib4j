package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class CustomCmdBuilderImpl implements CustomCmdBuilder {

    private final CompositeBuilder<CustomCmdBuilder> innerBuilder = new CompositeBuilder<>(this);
    private final String key;
    private final String methodPrefix;
    private final Boolean returns;

    public CustomCmdBuilderImpl(String key) {
        this(null, key, null);
    }

    public CustomCmdBuilderImpl(String methodPrefix, String key, Boolean returns) {
        this.methodPrefix = methodPrefix;
        this.key = key;
        this.returns = returns;
    }

    @Override
    public CustomCmdBuilder addToArgs(List<?> objs) {
        return innerBuilder.addToArgs(objs);
    }

    @Override
    public CustomCmdBuilder add2DimListToArgs(List<? extends List<? extends Number>> numbers) {
        return innerBuilder.addToArgs(numbers);
    }

    @Override
    public CustomCmdBuilder addToArgs(String v) {
        return innerBuilder.addToArgs(v);
    }

    @Override
    public CustomCmdBuilder addToArgsWithoutQuoting(String v) {
        return innerBuilder.addToArgsWithoutQuoting(v);
    }

    @Override
    public CustomCmdBuilder addToArgs(Number n) {
        return innerBuilder.addToArgs(n);
    }

    @Override
    public CustomCmdBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public CustomCmdBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public CustomCmdBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public CustomCmdBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public CustomCmdBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public boolean returns() {
        if (returns != null) return returns;
        return CustomCmdBuilder.super.returns();
    }

    @Override
    public String getMethodPrefix() {
        if (methodPrefix != null) return methodPrefix;
        return CustomCmdBuilder.super.getMethodPrefix();
    }

    @Override
    public String getMethodName() {
        return key;
    }
}
