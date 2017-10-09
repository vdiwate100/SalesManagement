package com.org.vd.model;


import junit.framework.TestCase;

public class SaleTest extends TestCase {
	
	private Sale sale;
	
	protected void setUp() throws Exception{
		super.setUp();
		sale = new Sale();
	}
	
	public void testManageSalesItinerary() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(1);
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		assertEquals(true,sale.manageSalesItinerary(product));
	}
	
	public void testManageSalesItineraryAdujstment() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(1);
		product.setAdjustmentOperation(AdjustmentOperation.ADD);
		assertEquals(true,sale.manageSalesItinerary(product));
	}
	
	public void testManageSalesItineraryNull() {
		assertEquals(false,sale.manageSalesItinerary(null));
	}
	
	public void testManageSalesItineraryAdujstmentMul() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(1);
		product.setAdjustmentOperation(AdjustmentOperation.MULTIPLY);
		assertEquals(true,sale.manageSalesItinerary(product));
	}
	
	public void testManageSalesItineraryAdujstmentSub() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(1);
		product.setAdjustmentOperation(AdjustmentOperation.SUBTRACT);
		assertEquals(true,sale.manageSalesItinerary(product));
	}
	
}
