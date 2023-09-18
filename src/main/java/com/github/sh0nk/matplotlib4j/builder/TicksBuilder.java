package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;

import java.util.List;


/**
 * matplotlib.pyplot.xticks(ticks=None, labels=None, **kwargs)
 * matplotlib.pyplot.yticks(ticks=None, labels=None,  **kwargs)
 */
public interface TicksBuilder extends Builder, TextArgsBuilder<TicksBuilder>, KwArgsBuilder<TicksBuilder> {

    TicksBuilder labels(List<String> labels);
}
