package com.org.vd.model;

import junit.framework.TestCase;

public class ProductTest extends TestCase {
	
	public void testCalculateTotalPrice() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(20);
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		assertEquals(2.0,product.calculateTotalPrice());
	}
}
