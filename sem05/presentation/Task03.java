package homework.sem05.presentation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task03 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/homework/sem05/presentation/task03.txt");
            int i;
            char what = ',';
            char to = '!';
            FileOutputStream fos = new FileOutputStream("./src/homework/sem05/presentation/task03_new.txt");
            while ((i = fis.read()) != -1) {
                if (i == what) {
                    i = to;
                }
                fos.write(i);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
