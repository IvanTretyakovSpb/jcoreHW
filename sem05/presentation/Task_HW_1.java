package homework.sem05.presentation;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task_HW_1 {
    public static void main(String[] args) {
        try {
            Files.createDirectory(Path.of("./backup"));

            DirectoryStream<Path> dirs = Files.newDirectoryStream(Path.of("."));
            for (Path dir : dirs) {
                if (Files.isDirectory(dir)) {
                    continue;
                }
                Files.copy(dir, Path.of("./backup/" + dir));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
