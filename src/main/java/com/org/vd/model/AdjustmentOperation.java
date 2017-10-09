package com.org.vd.model;

/**
 * 
 * @author vaibhav.diwate
 * Set of custom adjustment operation	
 */
public enum AdjustmentOperation {
	ADD("Add"),
	SUBTRACT("Subtract"),
	MULTIPLY("Multiply"),
	NA("na");
	
	private String value;
	
	private AdjustmentOperation(String value){
		this.value = value;
	}
	public String getValue() {
	      return value;
	}
}
