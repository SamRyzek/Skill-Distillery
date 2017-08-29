package com.sd;

interface InterfaceD1 {
	default void defMethod(){
		System.out.println("ID1 defMethod called");
	}
	
	//default void otherMethod(); //Will this work?
}

interface InterfaceD2 {
	default void defMethod(){
		System.out.println("ID2 defMethod called");
	}
	//void defMethod();
}

public class TestDefaultInterfaces implements InterfaceD2, InterfaceD1 {
	
	public static void main(String[] args) {
		TestDefaultInterfaces def = new TestDefaultInterfaces();
		def.defMethod();
	}
	//public default void defMethod() {}	//possible?
	//protected void defMethod(){}			//possible?
	//public abstract void defMethod();	//Redefine as abstract...
	public void defMethod(){}	//must override
}

interface D1Extender extends InterfaceD1 {
	//Will these work?
	//void defMethod() {}
	//void defMethod();
	//default void defMethod(){ }
	//public static void defMethod(){}
}

//class TestInterfaceDefaultCollisions implements InterfaceD1, InterfaceD2  //D1Extender
//{
	//@Override
	//public void defMethod(){
	//}
//}
