package com.org.vd.interpreter;

import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;

import junit.framework.TestCase;

public class MessageInterpreterTest extends TestCase {
	
	private SoloMessageInterpreter soloMessageInterpreter;
	private GroupMessageInterpreter groupMessageInterpreter;
	private AdjustOprMessageInterpreter adjustOprMessageInterpreter;
	
	protected void setUp() throws Exception{
		super.setUp();
		soloMessageInterpreter = new SoloMessageInterpreter();
		groupMessageInterpreter = new GroupMessageInterpreter();
		adjustOprMessageInterpreter = new AdjustOprMessageInterpreter();
	}

	public void testSoloMessageInterpreter() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.10);
		product.setQuantity(1);
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		assertEquals(product,soloMessageInterpreter.parser(new String[]{"apples","at","10p"}));
	}
	
	public void testGroupMessageInterpreter() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.1);
		product.setQuantity(20);
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		assertEquals(product,groupMessageInterpreter.parser(new String[]{"20","sales","of","apples","at","10p","each"}));
	}
	
	public void testAdjustOprMessageInterpreterAdd() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.2);
		product.setQuantity(0);
		product.setAdjustmentOperation(AdjustmentOperation.ADD);
		assertEquals(product,adjustOprMessageInterpreter.parser(new String[]{"Add","20p","apples"}));
	}
	
	public void testAdjustOprMessageInterpreterSub() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.2);
		product.setQuantity(0);
		product.setAdjustmentOperation(AdjustmentOperation.SUBTRACT);
		assertEquals(product,adjustOprMessageInterpreter.parser(new String[]{"Subtract","20p","apples"}));
	}
	
	public void testAdjustOprMessageInterpreterMul() {
		Product product = new Product();
		product.setName("apples");
		product.setPrice(0.2);
		product.setQuantity(0);
		product.setAdjustmentOperation(AdjustmentOperation.MULTIPLY);
		assertEquals(product,adjustOprMessageInterpreter.parser(new String[]{"Multiply","20p","apples"}));
	}
	
	public void testFormatPrice() {
		assertEquals(0.2,adjustOprMessageInterpreter.formatPrice("20p"));
	}
	
	public void testFormatPricePound() {
		assertEquals(2.2,adjustOprMessageInterpreter.formatPrice("£2.2"));
	}
	
	public void formatProductName() {
		assertEquals("apples",adjustOprMessageInterpreter.formatProductName("apple"));
	}
	
	public void formatProductNameCherry() {
		assertEquals("cherries",adjustOprMessageInterpreter.formatProductName("cherry"));
	}
	
	public void formatProductNameMango() {
		assertEquals("mangsoes",adjustOprMessageInterpreter.formatProductName("mango"));
	}
}
