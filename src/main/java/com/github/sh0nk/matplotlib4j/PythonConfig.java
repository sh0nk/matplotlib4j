package com.github.sh0nk.matplotlib4j;

public class PythonConfig {
    private final String pyenv;
    private final String virtualenv;
    private final String pythonBinPath;

    private PythonConfig(String pyenv, String virtualenv, String pythonBinPath) {
        this.pyenv = pyenv;
        this.virtualenv = virtualenv;
        this.pythonBinPath = pythonBinPath;
    }

    public static PythonConfig systemDefaultPythonConfig() {
        return new PythonConfig(null, null, null);
    }

    public static PythonConfig pyenvConfig(String pyenv) {
        return new PythonConfig(pyenv, null, null);
    }

    public static PythonConfig pyenvVirtualenvConfig(String pyenv, String virtualenv) {
        return new PythonConfig(pyenv, virtualenv, null);
    }

    public static PythonConfig pythonBinPathConfig(String pythonBinPath) {
        return new PythonConfig(null, null, pythonBinPath);
    }

    public String getPyenv() {
        return pyenv;
    }

    public String getVirtualenv() {
        return virtualenv;
    }

    public String getPythonBinPath() {
        return pythonBinPath;
    }

}
