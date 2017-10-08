package com.org.vd.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sale {
	private Map<String,Product> items;
	private List<String> adjustmentRepo;

	public Sale(){
		this.items = new HashMap<String,Product>();
		this.adjustmentRepo = new ArrayList<String>();
	}
	
	public Map<String, Product> getItems() {
		return items;
	}

	public void setItems(Map<String, Product> items) {
		this.items = items;
	}
	
	public boolean manageSalesItinerary(Product product){
		if(null == product){
			return false;
		}
		if(this.items.containsKey(product.getName())){
			Product prevEntry = this.items.get(product.getName());
			if(AdjustmentOperation.NA == product.getAdjustmentOperation()){
				product.setPrice(product.calculateTotalPrice());
				product.setPrice(product.getPrice() + prevEntry.getPrice());
				product.setQuantity(product.getQuantity() + prevEntry.getQuantity());
			}else{
				product = adjustPrice(prevEntry,product);
			}
			this.items.put(product.getName(), product);
		}else{
			product.setPrice(product.calculateTotalPrice());
			this.items.put(product.getName(), product);
		}
		return true;
	}
	
	private Product adjustPrice(Product prevEntry,Product product){
		double productPrice = product.getPrice();
		double prevProductPrice = prevEntry.getPrice();
		switch(product.getAdjustmentOperation()){
			case ADD:   prevEntry.setPrice(prevEntry.getPrice() + (prevEntry.getQuantity() * product.getPrice()));
						break;
			case SUBTRACT: 
						prevEntry.setPrice(prevEntry.getPrice() - (prevEntry.getQuantity() * product.getPrice()));
						break;
			case MULTIPLY: 
						prevEntry.setPrice(prevEntry.getPrice() + 
								((prevEntry.getPrice() * product.getPrice()) +
								 (prevEntry.getQuantity() * product.getPrice()) 		
								));
						break;
			default : 
						break;	
		} 
		
		this.adjustmentRepo.add(String.format(
		            "Operation performed %s %.2fp to %d %s and price adjusted from %.2fp to %.2fp",
		            product.getAdjustmentOperation(),
		            productPrice,
		            prevEntry.getQuantity(),
		            prevEntry.getName(),
		            prevProductPrice,
		            prevEntry.getPrice()
		));
		return prevEntry;
	}

	public List<String> getAdjustmentRepo() {
		return adjustmentRepo;
	}

	public void setAdjustmentRepo(List<String> adjustmentRepo) {
		this.adjustmentRepo = adjustmentRepo;
	}
	
}
