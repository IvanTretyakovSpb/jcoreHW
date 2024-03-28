package homework.sem05.presentation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task03_1 {
    public static void main(String[] args) {
        String search = "Hello";
        String replace = "Goodbye";
        try {
            FileInputStream fis = new FileInputStream("./src/homework/sem05/presentation/task03.txt");
            FileOutputStream fos = new FileOutputStream("./src/homework/sem05/presentation/task03_1_new.txt");
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = fis.read()) != -1) {
                sb.append((char) ch);
                if (sb.length() == search.length()) {
                    if (sb.toString().equals(search)) {
                        fos.write(replace.getBytes());
                        sb.delete(0, search.length());
                    } else {
                        fos.write(sb.charAt(0));
                        sb.deleteCharAt(0);
                    }
                }
            }
            fos.write(sb.toString().getBytes());

            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
