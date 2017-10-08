package com.org.vd.model;

import com.org.vd.common.ApplicationConstant;

public class Product {
	
	private String name;
	
	private int quantity;
	
	private double price;
	
	private AdjustmentOperation adjustmentOperation;
	
	public Product(){
		this.quantity = ApplicationConstant.DEFAULT_PRODUCT_QUANTITY;
		this.adjustmentOperation = AdjustmentOperation.NA;
	}
	
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
	
}
