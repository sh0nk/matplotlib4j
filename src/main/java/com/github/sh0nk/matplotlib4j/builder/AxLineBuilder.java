package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.Line2DBuilder;
import java.util.List;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface AxLineBuilder extends Builder, Line2DBuilder<AxLineBuilder> {

    AxLineBuilder at(Number value);

    AxLineBuilder min(Number value);

    AxLineBuilder max(Number value);
}
