package com.sd.data;

public class DataCheckImpl implements DataCheck {
	
	//@Override //Is this really an override?
	public boolean isNull(String data){
		System.out.println("DataCheckImpl class isNull");
		return data == null;
	}
	
	public static void main(String[] args) {
		DataCheckImpl impl = new DataCheckImpl();
		impl.checkData("data");
		impl.isNull("abcd");
	}
	
	//Can I do this? Method is not static in interface.
//	static void checkData(String data){
//		
//	}
}
