package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import java.util.List;


/**
 * matplotlib.pyplot.bar(*args, **kwargs)
 */
public interface BarBuilder extends Builder, Line2DBuilder<BarBuilder>, KwArgsBuilder<BarBuilder> {

    BarBuilder add(List<? extends Number> nums);

}
