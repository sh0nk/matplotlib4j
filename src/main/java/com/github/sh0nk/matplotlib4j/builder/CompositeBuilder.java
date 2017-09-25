package com.github.sh0nk.matplotlib4j.builder;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompositeBuilder<T extends Builder> implements Builder {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompositeBuilder.class);

    private List<Object> args = new LinkedList<>();
    private Map<String, Object> kwargs = new HashMap<>();

    private final T ownerBulder;

    CompositeBuilder(T ownerBuilder) {
        this.ownerBulder = ownerBuilder;
    }

    T addToArgs(List<Number> numbers) {
        args.add(numbers);
        return ownerBulder;
    }

    T addToArgs(String v) {
        // TODO: Do it with StringBuilder on join
        args.add("\"" + v + "\"");
        return ownerBulder;
    }

    T addToKwargs(String k, String v) {
        // TODO: Do it with StringBuilder on join
        kwargs.put(k, "\"" + v + "\"");
        return ownerBulder;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("plt.");
        sb.append(ownerBulder.getMethodName());
        sb.append("(");

        // Args
        // TODO: type conversion
        Joiner.on(',').appendTo(sb, args);

        // Kwargs
        if (!kwargs.isEmpty()) {
            sb.append(',');
            Joiner.on(',').withKeyValueSeparator("=").appendTo(sb, kwargs);
        }

        sb.append(")");
        String str = sb.toString();
        LOGGER.debug(".plot command: {}", str);
        return str;
    }

    @Override
    public String getMethodName() {
        throw new UnsupportedOperationException("CompositeBuilder doensn't have any real method.");
    }
}
