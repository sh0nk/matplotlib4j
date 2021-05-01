package com.github.sh0nk.matplotlib4j.kwargs;

import com.github.sh0nk.matplotlib4j.builder.Builder;
import com.github.sh0nk.matplotlib4j.builder.CompositeBuilder;

public class TextArgsBuilderImpl<T extends Builder> implements TextArgsBuilder<T> {
    // TODO: Add Text properties as Line2DBuilderImpl (https://matplotlib.org/stable/api/text_api.html#matplotlib.text.Text)

    private final CompositeBuilder<T> innerBuilder;

    public TextArgsBuilderImpl(CompositeBuilder<T> innerBuilder) {
        this.innerBuilder = innerBuilder;
    }

}
