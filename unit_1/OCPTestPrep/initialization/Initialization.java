package init;

public class Initialization {
    int instanceField = instanceMethod();
    static int staticField = staticMethod();

    static {
        System.out.println("In static initializer1");
    }

    {
        System.out.println("In instance initializer1");
    }

    public Initialization() {
        System.out.println("In constructor");
    }

    public static int staticMethod() {
        System.out.println("Initialize static field");
        return 1;
    }

    public int instanceMethod() {
        System.out.println("Initialize instance field");
        return 1;
    }

    public static void main(String[] args) {
        Initialization i1 = new Initialization();
    }
}
