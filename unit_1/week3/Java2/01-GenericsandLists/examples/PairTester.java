package examples;

public class PairTester {
    public static void main(String[] args) {
        Pair pres = new Pair("George", "Washington");

        String first = (String) pres.getFirstElement();
        String last = (String) pres.getSecondElement();

        System.out.println(first);
        System.out.println(last);
    }
}