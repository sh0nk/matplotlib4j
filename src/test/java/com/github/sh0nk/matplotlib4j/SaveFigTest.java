package com.github.sh0nk.matplotlib4j;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SaveFigTest {

    private static final boolean DRY_RUN = true;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSaveFig() throws IOException, PythonExecutionException {
        File tmpDir = Files.createTempDir();
        tmpDir.deleteOnExit();
        File tmpFile = new File(tmpDir, "tmp.png");
        tmpFile.deleteOnExit();

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 2));
        plt.title("Title!");
        plt.legend();
        plt.savefig(tmpFile.getAbsolutePath());
        plt.executeSilently();

        Assert.assertTrue(tmpFile.exists());
    }

    @Test
    public void testSaveFigTwice() throws IOException, PythonExecutionException {
        File tmpDir = Files.createTempDir();
        File tmpDir2 = Files.createTempDir();
        tmpDir.deleteOnExit();
        tmpDir2.deleteOnExit();
        File tmpFile = new File(tmpDir, "tmp.png");
        File tmpFile2 = new File(tmpDir2, "tmp.png");
        tmpFile.deleteOnExit();
        tmpFile2.deleteOnExit();

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 2));
        plt.title("Title!");
        plt.legend();
        plt.savefig(tmpFile.getAbsolutePath());
        plt.savefig(tmpFile2.getAbsolutePath());
        plt.executeSilently();

        Assert.assertTrue(tmpFile.exists());
        Assert.assertTrue(tmpFile2.exists());
    }

    @Test
    public void testCallExecuteTwice() throws IOException, PythonExecutionException {
        File tmpDir = Files.createTempDir();
        tmpDir.deleteOnExit();
        File tmpFile = new File(tmpDir, "tmp.png");
        tmpFile.deleteOnExit();

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 2));
        plt.title("Title!");
        plt.legend();
        plt.savefig(tmpFile.getAbsolutePath());
        plt.executeSilently();
        plt.executeSilently();

        Assert.assertTrue(tmpFile.exists());
    }

    @Test
    public void testSaveFigNoImpactToShow() throws IOException, PythonExecutionException {
        File tmpDir = Files.createTempDir();
        tmpDir.deleteOnExit();
        File tmpFile = new File(tmpDir, "tmp.png");
        tmpFile.deleteOnExit();

        Plot plt = new PlotImpl(DRY_RUN);
        plt.plot().add(Arrays.asList(1.3, 2));
        plt.title("Title!");
        plt.legend();
        plt.savefig(tmpFile.getAbsolutePath());
        plt.executeSilently();
        plt.show();

        Assert.assertTrue(tmpFile.exists());
    }

}
