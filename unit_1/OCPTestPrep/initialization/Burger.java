package init;

public class Burger extends Lunch {
	static Bread bread = new Bread();
	Cheese cheese = new Cheese();
	Patty patty = new Patty();
	Bread breadBottom = new Bread();

	{
		System.out.println("in static block");
	}

	public Burger() {
		this.bread = new Bread();
		System.out.println("Burger()");
	}

	public static void main(String[] args) {
		System.out.println("Start of Main");
		Burger burger = new Burger();
		System.out.println("End of Main");
	}
}

class Bread {
	public Bread() {
		System.out.println("Bread()");
	}
}

class Cheese {
	public Cheese() {
		System.out.println("Cheese()");
	}
}

class Patty {
	public Patty() {
		System.out.println("Patty()");
	}
}

class Meal {

	static {
		System.out.println("In MEAL STATIC");
	}

	public Meal() {
		System.out.println("Meal()");
	}
}

class Lunch extends Meal {
	public Lunch() {
		System.out.println("Lunch()");
	}
}
