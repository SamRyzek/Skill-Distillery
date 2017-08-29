package init;

public class InitSuper {
	int instanceField = superinstanceMethod();

    static int staticField = superstaticMethod();


    static {
        System.out.println("In super static initializer1");
    }

    {
        System.out.println("In super instance initializer1");
    }

    public InitSuper() {
        System.out.println("In super constructor");
    }

    public static int superstaticMethod() {
        System.out.println("Initialize super static field");
        return 1;
    }

    public int superinstanceMethod() {
        System.out.println("Initialize super instance field");
        return 1;
    }

}
