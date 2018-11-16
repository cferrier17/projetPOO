package logger.src.logger;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogger implements Logger {
    private final Path path;

    public FileLogger(String pathAsString) {
        path = Paths.get(pathAsString).toAbsolutePath();
    }

    public void info(String category, String message) {
        try {
            Files.write(path, ("INFO -- " +category+" -- "+message + "\n").getBytes(), APPEND, CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write info message to file [" + path + "]", e);
        }
    }

    public void error(String category, String message){
        try {
            Files.write(path, ("ERROR -- " +category+" -- "+message + "\n").getBytes(), APPEND, CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write info message to file [" + path + "]", e);
        }
    }
}