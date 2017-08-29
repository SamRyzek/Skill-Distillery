package com.sd;

interface D1 {
	static void method(){}
}
interface D2 {
	static void method(){}
}

public class StaticImplementer implements D1, D2 {
	public static void main(String[] args){
		//method();  //Can I do this?
		//D1.method();
	}
}

interface D3 extends D1, D2 {
	static void myMethod(){
		//method();
	}
}
