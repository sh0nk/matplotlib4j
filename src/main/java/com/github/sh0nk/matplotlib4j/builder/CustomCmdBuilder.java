package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import java.util.List;

public interface CustomCmdBuilder extends Builder, KwArgsBuilder<CustomCmdBuilder> {

    CustomCmdBuilder addToArgs(List<?> objs);

    CustomCmdBuilder add2DimListToArgs(List<? extends List<? extends Number>> numbers);

    CustomCmdBuilder addToArgs(String v);

    CustomCmdBuilder addToArgsWithoutQuoting(String v);

    CustomCmdBuilder addToArgs(Number n);

}
