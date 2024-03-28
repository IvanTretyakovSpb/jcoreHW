package homework.sem05.presentation;

import java.io.File;

public class Task04 {
    private static final String PATH = "./src/homework";

    public static void main(String[] args) {
//        printContentsStandard(PATH);  // без подкаталогов
        printContentsRecursion(PATH);
    }

    private static void printContentsStandard(String path) {
        File fullPath = new File(path);
        File[] dirs = fullPath.listFiles();
        for (File dir : dirs) {
            System.out.println(dir);
        }
    }

    private static void printContentsRecursion(String path) {
        File fullPath = new File(path);
        File[] dirs = fullPath.listFiles();
        for (File dir : dirs) {
            if (dir.isDirectory()) {
                printContentsRecursion(dir.toString());
            }
            System.out.println(dir);
        }
    }
}
