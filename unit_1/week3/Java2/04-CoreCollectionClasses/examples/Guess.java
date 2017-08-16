package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Guess {
    public static void main(String args[]) throws IOException {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = new String("abcd");

        Set<String> mySet = new HashSet<>();
        mySet.add(s1);
        mySet.add(s2);
        mySet.add(s3);

        System.out.print("What is the HashSet size? ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(
                System.in));

        int guess = Integer.parseInt(buf.readLine());

        if (guess == mySet.size()) {
            System.out.println("\nCORRECT!!!\n\nElements: ");
            for (String s : mySet) {
                System.out.println("Value: " + s + " Hash Code: "
                        + s.hashCode());
            }
        }
        else {
            System.out.println("I'm sorry. Please try again.");
        }
    }
}
