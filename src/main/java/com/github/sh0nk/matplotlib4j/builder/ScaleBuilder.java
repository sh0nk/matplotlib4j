package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;
import com.github.sh0nk.matplotlib4j.kwargs.TextArgsBuilder;

/**
 * matplotlib.pyplot.xscale(scale, **kwargs)
 * matplotlib.pyplot.yscale(scale, **kwargs)
 */
public interface ScaleBuilder extends Builder, TextArgsBuilder<ScaleBuilder>, KwArgsBuilder<ScaleBuilder> {

    enum Scale {
        linear,
        log,
        logit,
        symlog;
    }

}
