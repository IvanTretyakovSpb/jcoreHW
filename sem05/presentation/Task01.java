package homework.sem05.presentation;

import java.io.FileOutputStream;
import java.io.IOException;

public class Task01 {
    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 2, 0, 1, 5, 3, 9, 7, 8, 4, 1, 4, 9};
        int[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3};
        final int DIGIT_BOUND = 48;

        try {
            FileOutputStream fos = new FileOutputStream("./src/homework/sem05/presentation/save.txt");
            fos.write('[');
            for (int i = 0; i < arr.length; i++) {
                fos.write(DIGIT_BOUND + arr[i]);
                if (i < arr.length - 1) fos.write(',');
            }
            fos.write(']');
            fos.flush();
            fos.close();

// task with *
            FileOutputStream fos1 = new FileOutputStream("./src/homework/sem05/presentation/save0.txt");
            for (int i = 0; i < ar1.length; i++) {
                fos1.write(ar1[i]);
                fos1.write(0);
            }
            fos1.flush();
            fos1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
