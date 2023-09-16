package com.github.sh0nk.matplotlib4j.kwargs;

import com.github.sh0nk.matplotlib4j.builder.Builder;

public interface PatchBuilder<T extends Builder> {

    T linestyle(String arg);

    T ls(String arg);

    T linewidth(double arg);

    T lw(double arg);

    T label(String arg);

}
