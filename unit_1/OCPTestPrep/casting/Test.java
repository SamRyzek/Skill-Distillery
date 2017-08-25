package casting;

public class Test {
	public static void main(String[] args) {
		//instantiate objects
		Animal a = new Animal();
		Bird b = new Bird();
		Animal a2 = new Bird();

		//call methods
		a.speak();
		b.speak();
		b.fly();
		a2.speak();

		//	a2.fly();	//wont compile, why?

		/* The compiler will allow us to cast to another type that is in our inheritance hierarchy. */

		((Bird)a2).fly();  //down-cast

		/*
		 * However, you are still prone to runtime
		 * ClassCastExceptions
		 * To avoid ClassCastException, wrap your casting code
		 * in an if statement checking the type with instanceof
		 */

		if (a2 instanceof Bird) {
				Bird b2 = (Bird)a2;
				b2.fly();
		}


		((Animal)b).speak(); //up-cast
		System.out.println(((Animal)b).name); //up-cast
//
//		Animal a3 = new Animal();
//		Bird b2 = a3;

		/* The compiler will not allow you to cast
		 * to a type that is not in your inheritance
		 * hierarchy
			*/

		String s = "Andrew";
		a = (Animal)s;  // doesn't compile

	}
}
