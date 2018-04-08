package subtasks.one;

import java.nio.file.*;

public class Main {
    public static void main(String... args) {
        Path directory = Paths.get("task5-exceptions", "src", "main", "java", "subtasks", "one");
        FilesUtil.printDirectoryContent(directory);

        Path file = Paths.get(directory.toString() + "/newFile.txt");
        FilesUtil.createNewFile(file);
        FilesUtil.printDirectoryContent(directory);

        FilesUtil.writeToFile("some\ntext\nto\nwrite\n", file);
        FilesUtil.printFileContent(file);

        FilesUtil.addDataToFile("new text\nto\nwrite\n", file);
        FilesUtil.printFileContent(file);

        Path newDirectory = Paths.get(directory.toString() + "/inner/inner1");
        FilesUtil.createDirectory(newDirectory);
        FilesUtil.printDirectoryContent(directory);

        FilesUtil.printPathAttributes(file);
        FilesUtil.printPathAttributes(newDirectory);
        FilesUtil.printPathAttributes(directory);

        Path moveFilePath = Paths.get(newDirectory.toString(), file.toFile().getName());
        FilesUtil.move(file, moveFilePath);


        Path copyFilePath = Paths.get(newDirectory.getParent().toString(), file.toFile().getName());
        FilesUtil.copy(moveFilePath, copyFilePath);

        FilesUtil.delete(moveFilePath);
        FilesUtil.delete(copyFilePath);
        FilesUtil.delete(newDirectory);
        FilesUtil.delete(newDirectory.getParent());
        FilesUtil.printDirectoryContent(directory);
    }
}