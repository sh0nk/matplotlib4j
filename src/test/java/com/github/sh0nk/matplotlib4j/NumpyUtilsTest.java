package com.github.sh0nk.matplotlib4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumpyUtilsTest {

    @Test
    public void testLinspace() throws Exception {
        assertListDouble(Arrays.asList(2.0, 10.0), NumpyUtils.linspace(2, 10, 2));
        assertListDouble(Arrays.asList(10.0, 4.5, -1.0), NumpyUtils.linspace(10, -1, 3));
        assertListDouble(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5), NumpyUtils.linspace(1.1, 5.5, 5));
    }

    @Test
    public void testLinspaceFail() throws Exception {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            assertListDouble(Arrays.asList(10.0, 7.0, 4.0, 1.0), NumpyUtils.linspace(10, -1, -3));
        });
    }

    @Test
    public void testArange() throws Exception {
        assertListDouble(Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0), NumpyUtils.arange(2, 10, 2));
        assertListDouble(Arrays.asList(10.0, 7.0, 4.0, 1.0), NumpyUtils.arange(10, -1, -3));
        assertListDouble(Arrays.asList(1.1, 3.1), NumpyUtils.arange(1.1, 3.3, 2));
    }

    @Test
    public void testMeshGrid() {
        NumpyUtils.Grid<Double> expect = new NumpyUtils.Grid<>();
        expect.x = Arrays.asList(Arrays.asList(0.0, 1.0, 2.0), Arrays.asList(0.0, 1.0, 2.0));
        expect.y = Arrays.asList(Arrays.asList(2.0, 2.0, 2.0), Arrays.asList(3.0, 3.0, 3.0));
        assert2DListDouble(expect.x, NumpyUtils.meshgrid(Arrays.asList(0.0, 1.0, 2.0), Arrays.asList(2.0, 3.0)).x);
        assert2DListDouble(expect.y, NumpyUtils.meshgrid(Arrays.asList(0.0, 1.0, 2.0), Arrays.asList(2.0, 3.0)).y);
    }

    private static void assertListDouble(List<Double> expect, List<Double> actual) {
        Assert.assertEquals(expect.size(), actual.size());
        IntStream.range(0, expect.size()).forEach(i -> Assert.assertEquals(expect.get(i), actual.get(i), 1.0e-10));
    }

    private static void assert2DListDouble(List<List<Double>> expect, List<List<Double>> actual) {
        Assert.assertEquals(expect.size(), actual.size());
        IntStream.range(0, expect.size()).forEach(i -> {
            assertListDouble(expect.get(0), actual.get(0));
        });
    }

}