package com.manga42.ambiguous.core.convertors;

import com.manga42.ambiguous.core.Convertor;

public class StringInputConvertor implements Convertor<String, String, StringInputConvertor>{

	public final String input;
	
	public StringInputConvertor(String input){
		this.input = input;
	}
	@Override
	public String convert() {
		return this.input;
	}
	
}
