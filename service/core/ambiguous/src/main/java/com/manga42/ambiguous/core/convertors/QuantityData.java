package com.manga42.ambiguous.core.convertors;

import java.math.BigDecimal;

public class QuantityData {
	
	public final BigDecimal quantity;
	public final Units unit;
	
	public QuantityData(BigDecimal quantity, Units unit){
		this.quantity = quantity;
		this.unit = unit;
	}
	

	public String toString(){
		return this.quantity.toString() + " " + this.unit.name();
	}
}
