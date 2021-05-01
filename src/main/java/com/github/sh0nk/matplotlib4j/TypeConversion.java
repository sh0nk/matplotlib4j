package com.github.sh0nk.matplotlib4j;

import java.util.List;
import java.util.stream.Collectors;

public enum TypeConversion {
    INSTANCE;

    private final static String PYTHON_NONE = "None";

    public List<Object> typeSafeList(List<?> orgList) {
        return orgList.stream().map(x -> {
            if (x == null) {
                return PYTHON_NONE;
            } else if (x instanceof String) {
                return "\"" + x + "\"";
            } else {
                return x;
            }
        }).collect(Collectors.toList());
    }
}
