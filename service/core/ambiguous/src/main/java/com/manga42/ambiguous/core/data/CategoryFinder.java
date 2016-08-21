package com.manga42.ambiguous.core.data;

import java.util.HashMap;
import java.util.Map;

public class CategoryFinder {
	

	private static Map<String, Category> categories = new HashMap<>();
	
	static {
		categories.put("idly", new Category("IDLY", "Sadha"));
		categories.put("basmathi", new Category("BASMATHI", BrandFinder.getIfBrand("double deer")));
		categories.put("boiled", new Category("BOILED", "KRISHNA PONNI"));
		categories.put("raw", new Category("RAW", "PONNI"));
		categories.put("refined", new Category("REFINED", "PARRYS"));
	}
	
	public static Category getIfCategory(String category){
		return categories.get(category);
	}

}
