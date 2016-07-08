package com.manga42.ambiguous.core.guessors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.manga42.ambiguous.core.Guessor;
import com.manga42.ambiguous.core.convertors.QuantityConvertor;
import com.manga42.ambiguous.core.convertors.QuantityData;
import com.manga42.ambiguous.core.convertors.StringInputConvertor;
import com.manga42.ambiguous.core.convertors.Units;

public class QuantityGuessor implements Guessor<String, QuantityData>{


	private List<GuessedData<String, QuantityData>> data = new ArrayList<>();
	private Iterator<GuessedData<String, QuantityData>> dataIter = null;
	
	@Override
	public void guess(String input) {
		StringInputConvertor convertor = new StringInputConvertor(input);
		QuantityConvertor<StringInputConvertor> qConvertor = new QuantityConvertor<>(convertor);
		QuantityData qData = qConvertor.convert();
		double confidence = 100.0;
		if(qData.unit == Units.GRAMS){
			if(qData.quantity == null){
				confidence = 5.0;
			}
			
			if(qData.quantity.doubleValue() > 0 && qData.quantity.doubleValue() < 5000){
				confidence = 100.0;
			}else{
				confidence  = 50.0;
			}
		}
		
		data.add(new GuessedData<>(confidence, input, qData));
		
	}
	
	public void sort(){
		data = data.parallelStream().sorted((x,y) -> Double.compare(y.confidence, x.confidence)).collect(Collectors.toList()); 
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
