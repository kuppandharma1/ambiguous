package com.manga42.ambiguous.core.data;

import java.util.HashMap;
import java.util.Map;

public class BrandFinder {

	private static Map<String, String> brands = new HashMap<>();
	
	static {
		brands.put("double deer", "DOUBLE_DEER");
	}
	
	public static String getIfBrand(String brand){
		return brands.get(brand);
	}
}
