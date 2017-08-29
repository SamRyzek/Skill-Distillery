package com.sd.data;

public interface DataCheck {
	default boolean checkData(String data){
		System.out.println("DataCheck interface default checkData");
		return isNull(data);
	}
	
	static boolean isNull(String data){
		System.out.println("DataCheck interface isNull");
		return data == null;
	}
}
