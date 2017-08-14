package solutions;

import java.util.ArrayList;
import java.util.List;

public class Students {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        students.add("Anne");
        students.add("Bob");
        students.add("Charles");
        students.add("Danielle");
        students.add("Eric");
        students.add("Frank");
        students.add("Gary");

        for (String string : students) {
            System.out.println(string);
        }
    }

}
