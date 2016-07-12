package com.manga42.ambiguous.core.convertors;

import java.math.BigDecimal;

import com.manga42.ambiguous.core.Convertor;

public class UnitsConvertor<C extends Convertor<String, ?,?>> implements Convertor<QuantityData, String, C>{

	private C convertor;
	
	public UnitsConvertor(C convertor){
		this.convertor = convertor;
	}

	@Override
	public QuantityData convert() {
		String convertedUnit = convertor.convert().trim().toLowerCase();
		if(convertedUnit.equals("kg") ||
			convertedUnit.equals("kilograms")){
			return new QuantityData(BigDecimal.valueOf(1000.0), Units.GRAMS);
		}
		
		if(convertedUnit.equals("ml")){
			return new QuantityData(BigDecimal.valueOf(0.001), Units.LITRES);
		}
		try { 
			if(convertedUnit.matches("[0-9\\.]+[lL]")){
				String q = convertedUnit.substring(0, convertedUnit.length()-1);
				return new QuantityData(BigDecimal.valueOf(Double.parseDouble((q))), Units.LITRES);
			}
			if(convertedUnit.matches("[0-9\\.]+[gG]")){
				String q = convertedUnit.substring(0, convertedUnit.length()-1);
				return new QuantityData(BigDecimal.valueOf(Double.parseDouble((q))), Units.GRAMS);
			}
			return new QuantityData(BigDecimal.valueOf(Double.parseDouble(convertedUnit)), Units.COUNT);
		}catch(NumberFormatException ex){
			return new QuantityData(BigDecimal.ONE, Units.COUNT);
		}
	}
}
