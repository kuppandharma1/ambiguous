package com.manga42.ambiguous.core.convertors;

import com.manga42.ambiguous.core.Convertor;
import com.manga42.ambiguous.core.data.BrandFinder;
import com.manga42.ambiguous.core.data.Category;
import com.manga42.ambiguous.core.data.CategoryFinder;
import com.manga42.ambiguous.core.data.ProductNameFinder;

public class ProductConvertor<C extends Convertor<String, ?,?>> implements Convertor<ProductData, String, C> {

	
	C convertor;
	public ProductConvertor(C convertor){
		this.convertor = convertor;
	}
	
	@Override
	public ProductData convert() {
		String productPart = convertor.convert();
		
		String brand = BrandFinder.getIfBrand(productPart);
		Category category = CategoryFinder.getIfCategory(productPart);
		String name = ProductNameFinder.getIfProductName(productPart);
		
		return new ProductData(name, brand, category);
				
	}

}
