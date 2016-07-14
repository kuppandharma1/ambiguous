package com.manga42.ambiguous.core.convertors;

import com.manga42.ambiguous.core.data.Category;

public class ProductData {
	
	public final String brand;
	public final String name;
	public final Category category;
	
	
	public ProductData(String name, String brand, Category category){
		this.name = name;
		this.category = category;
		this.brand = brand;
	}
	

	public String toString(){
		if(category != null && brand == null){
			return category.defaultBrand + " " + category + " " + name;
		}
		return brand+" "+category + " " + name;
	}
}
