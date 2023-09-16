package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;

public class CustomBuilderImpl implements CustomBuilder {

    private final CompositeBuilder<CustomBuilder> innerBuilder = new CompositeBuilder<>(this);
    private final String key;
    private final String methodPrefix;
    private final Boolean returns;

    public CustomBuilderImpl(String key) {
        this(null, key, null);
    }

    public CustomBuilderImpl(String methodPrefix, String key, Boolean returns) {
        this.methodPrefix = methodPrefix;
        this.key = key;
        this.returns = returns;
    }

    @Override
    public CustomBuilder addToArgs(List<?> objs) {
        return innerBuilder.addToArgs(objs);
    }

    @Override
    public CustomBuilder add2DimListToArgs(List<? extends List<? extends Number>> numbers) {
        return innerBuilder.addToArgs(numbers);
    }

    @Override
    public CustomBuilder addToArgs(String v) {
        return innerBuilder.addToArgs(v);
    }

    @Override
    public CustomBuilder addToArgsWithoutQuoting(String v) {
        return innerBuilder.addToArgsWithoutQuoting(v);
    }

    @Override
    public CustomBuilder addToArgs(Number n) {
        return innerBuilder.addToArgs(n);
    }

    @Override
    public CustomBuilder addToKwargs(String k, String v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public CustomBuilder addToKwargsWithoutQuoting(String k, String v) {
        return innerBuilder.addToKwargsWithoutQuoting(k, v);
    }

    @Override
    public CustomBuilder addToKwargs(String k, Number n) {
        return innerBuilder.addToKwargs(k, n);
    }

    @Override
    public CustomBuilder addToKwargs(String k, List<? extends Number> v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public CustomBuilder addToKwargs(String k, boolean v) {
        return innerBuilder.addToKwargs(k, v);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public boolean returns() {
        if (returns != null) return returns;
        return CustomBuilder.super.returns();
    }

    @Override
    public String getMethodPrefix() {
        if (methodPrefix != null) return methodPrefix;
        return CustomBuilder.super.getMethodPrefix();
    }

    @Override
    public String getMethodName() {
        return key;
    }
}
