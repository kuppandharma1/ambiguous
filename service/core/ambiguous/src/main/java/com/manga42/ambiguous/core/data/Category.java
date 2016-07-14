package com.manga42.ambiguous.core.data;

public class Category {
	
	public final String name;
	public final String defaultBrand;
	
	public Category(String name, String defaultBrand){
		this.name = name;
		this.defaultBrand = defaultBrand;
	}

	public String toString(){
		return name;
	}
}
