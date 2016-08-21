package com.manga42.ambiguous.core.guessors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.manga42.ambiguous.core.Guessor;
import com.manga42.ambiguous.core.convertors.QuantityData;
import com.manga42.ambiguous.core.convertors.StringInputConvertor;
import com.manga42.ambiguous.core.convertors.Units;
import com.manga42.ambiguous.core.convertors.UnitsConvertor;

public class UnitsGuessor implements Guessor<String, QuantityData>{


	private List<GuessedData<String, QuantityData>> data = new ArrayList<>();
	private Iterator<GuessedData<String, QuantityData>> dataIter = null;
	
	private QuantityData prevData = null;
	
	@Override
	public void guess(String input) {
		StringInputConvertor convertor = new StringInputConvertor(input);
		UnitsConvertor<StringInputConvertor> qConvertor = new UnitsConvertor<>(convertor);
		QuantityData qData = qConvertor.convert();
		double confidence = 100.0;
		
		double quantity = qData.quantity.doubleValue();
		
		if(prevData != null && prevData.unit == Units.COUNT){
			quantity = prevData.quantity.doubleValue() * quantity;
			qData = new QuantityData(BigDecimal.valueOf(quantity), qData.unit);
		}
		
		if(qData.unit == Units.GRAMS){
			if(quantity >= 50.0 && quantity <= 25000.0){
				confidence = 100.0;
			}else{
				confidence = 50.0;
			}
		}else if(qData.unit == Units.LITRES){
			if(quantity > 0.1 && quantity < 5.0){
				confidence = 100.0;
			}else {
				confidence = 50.0;
			}
		}else if(qData.unit == Units.COUNT){
			confidence = 50.0;
		}
		
		prevData = qData;
		data.add(new GuessedData<>(confidence, input, qData));
		
	}
	
	public void sort(){
		data = data.parallelStream().sorted((x,y) -> Double.compare(y.confidence, x.confidence))
				.collect(Collectors.toList());
		
		System.out.println(data);
	}

	@Override
	public GuessedData<String, QuantityData> nextGuess() {
		if(dataIter == null){
			dataIter = data.iterator();
		}
		
		if(dataIter.hasNext()){
			return dataIter.next();
		}
		return null;
	}
}
