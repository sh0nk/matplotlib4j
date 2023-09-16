package com.github.sh0nk.matplotlib4j.builder;

public interface Builder {
    String build();

    default boolean returns() {
        return true;
    }

    default String getMethodPrefix() {
        return "plt.";
    }

    String getMethodName();
}
