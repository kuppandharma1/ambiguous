package com.manga42.ambiguous.core.data;

import java.util.HashMap;
import java.util.Map;

public class ProductNameFinder {
	
	
	private static Map<String, String> names = new HashMap<>();
	
	static {
		names.put("rice", "RICE");
		names.put("sugar", "SUGAR");
		names.put("pepper", "PEPPER");
	}
	
	public static String getIfProductName(String name){
		return names.get(name);
	}

}
