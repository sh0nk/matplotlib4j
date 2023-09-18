package com.github.sh0nk.matplotlib4j.kwargs;

import com.github.sh0nk.matplotlib4j.builder.Builder;
import java.util.List;

public interface KwArgsBuilder<T extends Builder> {

    T addToKwargs(String k, String v);

    T addToKwargsWithoutQuoting(String k, String v);

    T addToKwargs(String k, Number n);

    T addToKwargs(String k, List<? extends Number> v);

    T addToKwargs(String k, boolean v);

}
