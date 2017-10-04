package com.github.sh0nk.matplotlib4j;

import java.util.List;
import java.util.stream.Collectors;

public enum TypeConversion {
    INSTANCE;

    private final static String PYTHON_NONE = "None";

    public List<Object> typeSafeList(List<? extends Number> orgList) {
        return orgList.stream().map(x -> {
            if (x == null) {
                return PYTHON_NONE;
            } else {
                return x;
            }
        }).collect(Collectors.toList());
    }
}
