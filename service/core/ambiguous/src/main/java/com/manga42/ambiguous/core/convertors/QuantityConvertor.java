package com.manga42.ambiguous.core.convertors;

import java.math.BigDecimal;

import com.manga42.ambiguous.core.Convertor;

public class QuantityConvertor<C extends Convertor<String, ?, ?>> implements Convertor<QuantityData, String, C> {

	private C convertor;
	
	public QuantityConvertor(C convertor){
		this.convertor = convertor;
	}

	@Override
	public QuantityData convert() {
		String convertedQuantity = convertor.convert();
		double q = 0.0;
		try{
			q = Double.parseDouble(convertedQuantity);
		}catch(NumberFormatException ex){
			//do nothing
		}
		return new QuantityData(BigDecimal.valueOf(q), Units.GRAMS);
	}
}
