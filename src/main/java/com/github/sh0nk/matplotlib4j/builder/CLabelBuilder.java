package com.github.sh0nk.matplotlib4j.builder;

public interface CLabelBuilder extends Builder {

    CLabelBuilder fontsize(String arg);

    CLabelBuilder fontsize(double arg);

    CLabelBuilder inline(boolean arg);

    CLabelBuilder inlineSpacing(double arg);

    CLabelBuilder fmt(String arg);

    CLabelBuilder manual(boolean arg);

    CLabelBuilder rightsideUp(boolean arg);

    CLabelBuilder useClabeltext(boolean arg);
}
