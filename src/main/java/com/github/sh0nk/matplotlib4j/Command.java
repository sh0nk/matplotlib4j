package com.github.sh0nk.matplotlib4j;

import com.github.sh0nk.matplotlib4j.builder.CompositeBuilder;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    private final static Logger LOGGER = LoggerFactory.getLogger(Command.class);

    private final static Pattern ERROR_PAT = Pattern.compile("^.+Error:");

    private void command(String... args) throws IOException, PythonExecutionException {
        ProcessBuilder pb = new ProcessBuilder(Lists.asList("python", args));
        Process process = pb.start();

        // stdout
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }

        // stderr
        // TODO: have a common way with stdout

        br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        line = br.readLine();
        boolean hasError = false;
        while (line != null) {
            sb.append(line).append('\n');
            Matcher matcher = ERROR_PAT.matcher(line);
            if (matcher.find()) {
                hasError = true;
            }
            line = br.readLine();
        }

        String msg = sb.toString();
        if (hasError) {
            LOGGER.error(msg);
            throw new PythonExecutionException("Python execution error: " + msg);
        } else {
            LOGGER.warn(msg);
        }
    }

    private void writeFile(String pythonScript, File script) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(script)));
        bw.write(pythonScript);
        bw.close();
    }

    public void execute(String pythonScript) throws IOException, PythonExecutionException {
        File tmpDir = Files.createTempDir();
        tmpDir.deleteOnExit();
        File script = new File(tmpDir, "exec.py");

        writeFile(pythonScript, script);

        command(Paths.get(script.toURI()).toAbsolutePath().toString());
        tmpDir.delete();
    }
}
