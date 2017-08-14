package examples;

import java.io.File;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) {
        File f = new File("input.txt");
        System.out.printf("The length of %s is %d bytes.%n",
                f.getName(), f.length());

        try {
            System.out.printf("%s has a full path of %s.%n",
                    f.getName(), f.getCanonicalPath());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
