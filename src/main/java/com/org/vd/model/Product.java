package com.org.vd.model;

import java.util.Objects;

import com.org.vd.common.ApplicationConstant;

/**
 * 
 * @author vaibhav.diwate
 * Product model class which holds product related information
 */
public class Product {
	
	private String name;
	
	private int quantity;
	
	private double price;
	
	private AdjustmentOperation adjustmentOperation;
	
	public Product(){
		this.quantity = ApplicationConstant.DEFAULT_PRODUCT_QUANTITY;
		this.adjustmentOperation = AdjustmentOperation.NA;
	}
	
	/**
	 * Calculates product price 
	 * @return : Total price 
	 */
	public double calculateTotalPrice(){
        return this.quantity * this.price;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public AdjustmentOperation getAdjustmentOperation() {
		return adjustmentOperation;
	}
	public void setAdjustmentOperation(AdjustmentOperation adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		if (!(other instanceof Product)) {
			return false;
		}
		Product product = (Product) other;
		return ((this.name.equals(product.name)) &&
					(this.quantity == product.quantity) &&
						(this.price == product.price) &&
							(this.adjustmentOperation == product.adjustmentOperation));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name,this.quantity,this.price,this.adjustmentOperation);
	}
}
