package com.ajn.util;

//Why we need this class? The reason we use this class is to have all our Controller mappings at one place
//making it easier to maintain
public final class Mappings { //Since this class will only contain public static constants
							//that we can use directly, there is no reason to ever extend this class
	
	//== constants == 
	public static final String ITEMS = "items";
	public static final String ADD_ITEM ="addItem";
	
	// == constructor == 
	private Mappings() {} // The reason constructor is private here is because, there is no reason to instantiate 
						//the Mappings class
		
}
