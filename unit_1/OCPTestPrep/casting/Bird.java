package casting;

public class Bird extends Animal{
	String name = "Tweety";

	@Override
	public void speak() {
		System.out.println("i tought i taw a puddy cat");
	}

	public void getName(){
		System.out.println(name);
	}

	public void fly() {
		System.out.println("I'm flying");
	}

}
