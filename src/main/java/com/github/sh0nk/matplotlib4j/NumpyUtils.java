package com.github.sh0nk.matplotlib4j;

import com.google.common.base.Preconditions;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumpyUtils {

    // TODO: more options from numpy
    public static List<Double> linspace(double start, double end, int num) {
        Preconditions.checkArgument(num >= 0);
        return ContiguousSet.create(Range.closedOpen(0, num), DiscreteDomain.integers())
                .stream().map(x -> (double) (x  * (end - start)) / (num - 1) + start).collect(Collectors.toList());
    }

    public static List<Double> arange(double start, double end, double step) {
        double scaledStart = start / step;
        double scaledEnd = end / step;
        double floorGap = scaledStart - (int) scaledStart;
        return ContiguousSet.create(Range.closed((int) scaledStart, (int) scaledEnd), DiscreteDomain.integers())
                .stream().map(x -> (x + floorGap) * step).collect(Collectors.toList());
    }

    public static <T extends Number> Grid<T> meshgrid(List<T> x, List<T> y) {
        Grid<T> grid = new Grid<>();
        grid.x = IntStream.range(0, y.size()).mapToObj(i -> x).collect(Collectors.toList());
        grid.y = y.stream().map(t -> (IntStream.range(0, x.size()).mapToObj(i -> t).collect(Collectors.toList()))).collect(Collectors.toList());
        return grid;
    }

    public static class Grid<T extends Number> {
        public List<List<T>> x;
        public List<List<T>> y;

        public <R> List<List<R>> calcZ(BiFunction<T, T, R> biFunction) {
            return IntStream.range(0, x.size()).mapToObj(i ->
                IntStream.range(0, y.size()).mapToObj(j ->
                    biFunction.apply(x.get(i).get(j), y.get(i).get(j))
                ).collect(Collectors.toList())
            ).collect(Collectors.toList());
        }
    }

}
