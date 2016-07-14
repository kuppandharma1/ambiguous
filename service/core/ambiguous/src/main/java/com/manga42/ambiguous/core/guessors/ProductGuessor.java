package com.manga42.ambiguous.core.guessors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.manga42.ambiguous.core.Guessor;
import com.manga42.ambiguous.core.convertors.ProductConvertor;
import com.manga42.ambiguous.core.convertors.ProductData;
import com.manga42.ambiguous.core.convertors.StringInputConvertor;
import com.manga42.ambiguous.core.data.Category;

public class ProductGuessor implements Guessor<String, ProductData>{

	private List<GuessedData<String, ProductData>> data = new ArrayList<>();
	private Iterator<GuessedData<String, ProductData>> dataIter = null;
	
	private List<ProductData> seenData = new ArrayList<>();
	
	@Override
	public void guess(String input) {
		StringInputConvertor s = new StringInputConvertor(input);
		ProductConvertor<StringInputConvertor> pc = new ProductConvertor<>(s);
		
		ProductData productData = pc.convert();
		
		double confidence = 100.0;
		String brand = productData.brand;
		Category category = productData.category;
		String name = productData.name;
		
		for(ProductData d: seenData){
			if(d.brand != null){
				brand = d.brand;
			}
			if(d.category != null){
				category = d.category;
			}
			if(d.name != null){
				name = d.name;
			}
		}
		
		productData = new ProductData(name, brand, category);
		
		
		if(productData.brand == null){
			confidence = 75.0;
		}
		
		if(productData.category == null){
			confidence = 50.0;
		}
		
		if(productData.name == null){
			confidence = 25.0;
		}
		
		seenData.add(productData);
		data.add(new GuessedData<>(confidence,input,productData));
		
	}

	@Override
	public void sort() {
		data = data.parallelStream().sorted((x,y) -> Double.compare(y.confidence, x.confidence))
				.collect(Collectors.toList());
		
		System.out.println(data);
	}

	@Override
	public GuessedData<String, ProductData> nextGuess() {
		if(dataIter == null){
			dataIter = data.iterator();
		}
		
		if(dataIter.hasNext()){
			return dataIter.next();
		}
		return null;
	}
	
}