package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.kwargs.KwArgsBuilder;

/**
 * matplotlib.pyplot.savefig(fname, **kwargs)
 */
public interface SaveFigBuilder extends Builder, KwArgsBuilder<SaveFigBuilder> {

    enum Orientation {
        horizontal,
        vertical;
    }

    SaveFigBuilder dpi(double arg);

    SaveFigBuilder facecolor(String arg);

    SaveFigBuilder orientation(Orientation orientation);

    SaveFigBuilder papertype(String arg);

    SaveFigBuilder format(String arg);

    SaveFigBuilder transparent(boolean arg);

    SaveFigBuilder frameon(boolean arg);

    SaveFigBuilder bboxInches(double arg);

    // `bbox_extra_artists` is not supported yet

}
