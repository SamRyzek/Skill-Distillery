package examples;

public class PairTest {
  public static void main(String[] args) {
    Pair p1 = new Pair("ABC", "XYZ");
    Pair p2 = new Pair(new Integer(1), new Integer(2));

    if (p1.getFirstElement() instanceof String) {
      String s = (String)p1.getFirstElement();
    }

    if (p2.getFirstElement() instanceof Integer) {
      Integer s = (Integer)p2.getFirstElement();
    }
  }
}
