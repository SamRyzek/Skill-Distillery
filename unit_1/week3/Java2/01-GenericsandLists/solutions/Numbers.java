package solutions;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public void printNumbers() {
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(Math.random());
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%.3f%n", numbers.get(i));
        }
    }

    public static void main(String[] args) {
        Numbers n = new Numbers();
        n.printNumbers();
    }
}
