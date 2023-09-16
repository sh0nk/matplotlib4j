package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import java.util.List;

public interface CustomBuilder extends Builder, KwArgsBuilder<CustomBuilder> {

    CustomBuilder addToArgs(List<?> objs);

    CustomBuilder add2DimListToArgs(List<? extends List<? extends Number>> numbers);

    CustomBuilder addToArgs(String v);

    CustomBuilder addToArgsWithoutQuoting(String v);

    CustomBuilder addToArgs(Number n);

}
