package com.github.sh0nk.matplotlib4j;

import com.google.common.base.Joiner;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class PythonConfigCommandTest {

    @Test
    public void testCommand() throws IOException, PythonExecutionException {
        PyCommand command = new PyCommand(PythonConfig.systemDefaultPythonConfig());
        command.execute("print('test')");
        command.execute(Joiner.on("\n").join(Arrays.asList("import sys", "print(sys.version)")));
        command.execute(Joiner.on("\n").join(Arrays.asList("import matplotlib", "print(matplotlib.__file__)")));
    }

    @Test
    @Ignore("Only for local, could be supported by CI")
    public void testPyenvCommand() throws IOException, PythonExecutionException {
        PyCommand command = new PyCommand(PythonConfig.pyenvConfig("anaconda3-4.4.0"));
        command.execute("print('test')");
        command.execute(Joiner.on("\n").join(Arrays.asList("import sys", "print(sys.version)")));
        command.execute(Joiner.on("\n").join(Arrays.asList("import matplotlib", "print(matplotlib.__file__)")));
    }

    @Test
    @Ignore("Only for local, could be supported by CI")
    public void testPyenvVirtualenvCommand() throws IOException, PythonExecutionException {
        PyCommand command = new PyCommand(PythonConfig.pyenvVirtualenvConfig("anaconda3-4.4.0", "nlp-class"));
        command.execute("print('test')");
        command.execute(Joiner.on("\n").join(Arrays.asList("import sys", "print(sys.version)")));
        command.execute(Joiner.on("\n").join(Arrays.asList("import matplotlib", "print(matplotlib.__file__)")));
    }

    @Test
    @Ignore("Only for local, could be supported by CI")
    public void testPythonBinCommand() throws IOException, PythonExecutionException {
        PyCommand command = new PyCommand(PythonConfig.pythonBinPathConfig("/usr/bin/python"));
        command.execute("print('test')");
        command.execute(Joiner.on("\n").join(Arrays.asList("import sys", "print(sys.version)")));
        command.execute(Joiner.on("\n").join(Arrays.asList("import matplotlib", "print(matplotlib.__file__)")));
    }

}
