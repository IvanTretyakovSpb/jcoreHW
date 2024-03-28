package homework.sem05.presentation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        int[] ar00 = new int[15];
        int[] ar10 = new int[15];
        final int DIGIT_BOUND = 48;
        try {
            FileInputStream fis = new FileInputStream("./src/homework/sem05/presentation/save.txt");
            fis.read();
            for (int i = 0; i < ar00.length; i++) {
                ar00[i] = fis.read() - DIGIT_BOUND;
                fis.read();
            }
            fis.close();
            System.out.println(Arrays.toString(ar00));

            // task with *
            FileInputStream fis1 = new FileInputStream("./src/homework/sem05/presentation/save0.txt");
            int b;
            int i = 0;
            while ((b = fis1.read()) != -1) {
                if (b != 0) {
                    ar10[i++] = b;
                }
            }
            fis1.close();
            System.out.println(Arrays.toString(ar10));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
