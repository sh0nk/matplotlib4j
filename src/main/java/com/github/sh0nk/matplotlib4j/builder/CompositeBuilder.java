package com.github.sh0nk.matplotlib4j.builder;

import com.github.sh0nk.matplotlib4j.TypeConversion;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompositeBuilder<T extends Builder> implements Builder {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompositeBuilder.class);

    private List<Object> args = new LinkedList<>();
    private Map<String, Object> kwargs = new HashMap<>();

    private final T ownerBulder;

    public CompositeBuilder(T ownerBuilder) {
        this.ownerBulder = ownerBuilder;
    }

    public T addToArgs(List<? extends Number> numbers) {
        args.add(TypeConversion.INSTANCE.typeSafeList(numbers));
        return ownerBulder;
    }

    public T add2DimListToArgs(List<? extends List<? extends Number>> numbers) {
        args.add(numbers.stream().map(TypeConversion.INSTANCE::typeSafeList).collect(Collectors.toList()));
        return ownerBulder;
    }

    public T addToArgs(String v) {
        // TODO: Do it with StringBuilder on join
        args.add("\"" + v + "\"");
        return ownerBulder;
    }

    public T addToArgs(Number n) {
        args.add(n);
        return ownerBulder;
    }

    public T addToKwargs(String k, String v) {
        // TODO: Do it with StringBuilder on join
        kwargs.put(k, "\"" + v + "\"");
        return ownerBulder;
    }

    public T addToKwargsWithoutQuoting(String k, String v) {
        // TODO: Do it with StringBuilder on join
        kwargs.put(k, v);
        return ownerBulder;
    }

    public T addToKwargs(String k, Number n) {
        kwargs.put(k, n);
        return ownerBulder;
    }

    public T addToKwargs(String k, List<? extends Number> v) {
        kwargs.put(k, v);
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
            if (!args.isEmpty()) {
                sb.append(',');
            }
            Joiner.on(',').withKeyValueSeparator("=").appendTo(sb, kwargs);
        }

        sb.append(")");
        String str = sb.toString();
        LOGGER.debug(".plot command: {}", str);
        return str;
    }

    @Override
    public String getMethodName() {
        throw new UnsupportedOperationException("CompositeBuilder doesn't have any real method.");
    }
}
