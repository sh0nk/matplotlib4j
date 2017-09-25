package com.github.sh0nk.matplotlib4j.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class SingleStringArgBuilderImpl implements Builder {

    private final static Logger LOGGER = LoggerFactory.getLogger(SingleStringArgBuilderImpl.class);

    private final String key;
    private final String arg;
    Map<String, Object> kwargs = new HashMap<>();

    public SingleStringArgBuilderImpl(String key, String arg) {
        this.key = key;
        this.arg = arg;
        addStringToKwargs(key, arg);
    }

    private SingleStringArgBuilderImpl addStringToKwargs(String k, String v) {
        // TODO: Do it with StringBuilder on join
        kwargs.put(k, "\"" + v + "\"");
        return this;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("plt.");
        sb.append(key);
        sb.append("(\"");
        sb.append(arg);
        sb.append("\")");

        String str = sb.toString();
        LOGGER.debug(".plot command: {}", str);
        return str;
    }

    @Override
    public String getMethodName() {
        return key;
    }
}
