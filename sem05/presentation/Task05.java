package homework.sem05.presentation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Task05 {
    public static void main(String[] args) {
        String[] files = {"task5_1.txt", "task5_2.txt", "task5_another.txt"};
        for (String file : files) {
            Path path = Path.of(file);
            if (Files.exists(path)) {
                try {
                    Files.move(path, Paths.get("pre_" + path), REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Cannot rename file with name " + path);
                    throw new RuntimeException();
                }
            } else {
                System.out.println("No file with the name " + file);
            }
        }
    }
}
