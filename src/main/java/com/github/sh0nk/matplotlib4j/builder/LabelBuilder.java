package com.github.sh0nk.matplotlib4j.builder;

import java.util.List;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface LabelBuilder extends Builder {

    LabelBuilder label(String arg);

    LabelBuilder add(List<Number> nums);

    LabelBuilder linestyle(String arg);

    LabelBuilder ls(String arg);

}
