package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReadPet {
    public static void main(String[] args) throws Exception {
        String s;
        String words[];
        Pattern p = Pattern.compile("[|]");

        try (BufferedReader in = new BufferedReader(
                new FileReader("pet.txt"));) {

            in.readLine(); // get rid of header line

            while ((s = in.readLine()) != null) {
                words = p.split(s);
                System.out.println(words[1] + " is a " + words[2] + " "
                        + words[3] + ". S/he is a " + words[4]
                        + " year old " + words[5] + ". Comments: "
                        + words[6] + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
