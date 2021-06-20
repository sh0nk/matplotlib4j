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
            } else if (x instanceof Double) {
                Double v = (Double) x;
                if (Double.isInfinite(v)) {
                    return v > 0 ? "np.inf" : "-np.inf";
                } else if (Double.isNaN(v)) {
                    return "np.nan";
                }
            } else if (x instanceof Float) {
                Float v = (Float) x;
                if (Float.isInfinite(v)) {
                    return v > 0 ? "np.inf" : "-np.inf";
                } else if (Float.isNaN(v)) {
                    return "np.nan";
                }
            }
            return x;
        }).collect(Collectors.toList());
    }
}
