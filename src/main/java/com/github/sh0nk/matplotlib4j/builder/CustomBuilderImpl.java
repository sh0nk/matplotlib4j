package com.github.sh0nk.matplotlib4j.builder;

public class CustomBuilderImpl implements CustomBuilder {

    private final String cmd;

    public CustomBuilderImpl(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String build() {
        return cmd;
    }

    @Override
    public boolean returns() {
        return false;
    }

    @Override
    public String getMethodPrefix() {
        return null;
    }

    @Override
    public String getMethodName() {
        return null;
    }
}
