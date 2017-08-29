
interface Interface1 {
	public static final int field1 = 95;		//fields are public static final
	
	static int field2 = 106;
}

interface Interface2 extends Interface1 {
	static int field2 = 107;
}


public class Implementer implements Interface1, Interface2 {
	static int field1;
	
	public static void main(String[] args) {
		Implementer i1 = new Implementer();
		System.out.println(i1.field1);
		System.out.println(Interface1.field1);
		
		System.out.println(((Interface2)i1).field2);
		
		//NOOOOOO!!!!
		//System.out.println(((Interface1)Implementer).field2);
		System.out.println(Implementer.field1);
		System.out.println(field1);
	}
}
