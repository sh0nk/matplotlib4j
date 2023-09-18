package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;


/**
 * matplotlib.pyplot.xlabel(s, *args, **kwargs)
 * matplotlib.pyplot.ylabel(s, *args, **kwargs)
 */
public interface LabelBuilder extends Builder, TextArgsBuilder<LabelBuilder>, KwArgsBuilder<LabelBuilder> {


}
