package examples;

public class GenericPairTester {
    public static void main(String[] args) {
        GenericPair<String> pres = 
                new GenericPair<>("George", "Washington");

        String first = pres.getFirstElement();
        String last = pres.getSecondElement();

        System.out.println(first);
        System.out.println(last);
    }
}