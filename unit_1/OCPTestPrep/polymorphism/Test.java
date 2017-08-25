package poly;

public class Test {
	public static void main(String[] args) {
		Animal a = new Animal();
		a.speak();
		System.out.println(a.name);

		Bird b = new Bird();
		b.speak();
		System.out.println(b.name);

		Animal c = new Bird();
		c.speak();
		System.out.println(c.name);
		System.out.println(((Bird) c).name);

		Animal d = new Bird();
		d.getName();
		System.out.println(d.name);
	}
}
