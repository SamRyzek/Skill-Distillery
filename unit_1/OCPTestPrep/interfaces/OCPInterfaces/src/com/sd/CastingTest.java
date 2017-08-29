package com.sd;

public class CastingTest {
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		CastingTest ct = new CastingTest();
		
		String s = "q";
		Comparable c = s; //Works because String implements Comparable
		//Comparable maybe = ct;
		
		Comparable comp = (Comparable) ct;
	}
}
