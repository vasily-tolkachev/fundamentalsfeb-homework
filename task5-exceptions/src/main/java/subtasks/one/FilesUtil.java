package subtasks.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

class FilesUtil {
    private static final Logger log = LogManager.getLogger(Main.class);

    private FilesUtil() {}

    static boolean createNewFile(Path path) {
        try {
            return path.toFile().createNewFile();
        } catch (IOException e) {
            log.info("IOException", e);
        }
        return false;
    }

    static void delete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void writeToFile(String data, Path path) {
        try {
            Files.write(path, data.getBytes());
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void addDataToFile(String data, Path path) {
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void printFileContent(Path path) {
        try {
            final List<String> lines = Files.readAllLines(path);
            StringBuilder builder = new StringBuilder();
            for (String line : lines) {
                builder.append(line).append('\n');
            }
            log.info("\n{} content:\n{}", path, builder.toString());
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void printPathAttributes(Path path) {
        StringBuilder builder = new StringBuilder();
        try {
            BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
            builder.append("Is path a directory? ").append(data.isDirectory()).append('\n');
            builder.append("Is path a file? ").append(data.isRegularFile()).append('\n');
            builder.append("Is path a symbolic link? ").append(data.isSymbolicLink()).append('\n');
            builder.append("Not all of above? ").append(data.isOther()).append('\n');
            builder.append("Size (in bytes): ").append(data.size()).append('\n');
            builder.append("Date/Time of creation: ").append(data.creationTime()).append('\n');
        } catch (IOException e) {
            log.info("IOException", e);
        }
        log.info("\nFor path {}:\n{}", path, builder.toString());
    }

    static void createDirectory(Path directory) {
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void printDirectoryContent(Path directory) {
        StringBuilder builder = new StringBuilder();
        try (
                Stream<Path> stream = Files.walk(directory)
        ) {
            stream.forEach(p -> builder.append(p).append('\n'));
        } catch (IOException e) {
            log.info("IOException", e);
        }
        log.info("\nFiles and subdirectories of {}:\n{}", directory, builder.toString());
    }

    static void move(Path source, Path target) {
        try {
            Files.move(source, target);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

    static void copy(Path source, Path target) {
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }
}
