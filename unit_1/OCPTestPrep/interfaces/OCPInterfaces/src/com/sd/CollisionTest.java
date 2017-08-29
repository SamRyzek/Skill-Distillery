package com.sd;

interface InterfaceFieldCollision1 {
	double PI = 3.14;
}

interface InterfaceFieldCollision2 {
	double PI = 3.14159;
}

//Comment out static double PI and make CollisionTest implement InterfaceFieldCollision2 as well
public class CollisionTest implements InterfaceFieldCollision1 {
	static double PI = 3.14145987;
	
	public static void main(String[] args){
		
		CollisionTest ct = new CollisionTest();
		double d = InterfaceFieldCollision1.PI;
		double d2 = ((InterfaceFieldCollision1)ct).PI;
		
		System.out.println(PI);
		
	}
}
