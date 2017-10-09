package com.org.vd.interpreter;

import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;

/**
 * 
 * @author vaibhav.diwate
 * Manage solo message : Parse Adjustment Message
 */
public class SoloMessageInterpreter extends MessageInterpreter{

	/**
	 * 
	 * @param message : Message to parse E.g apple at 10p
	 * @return : Parsed Project object
	 */
	@Override
	protected Product parser(String[] msgArr) {
		if(msgArr.length > 3 || msgArr.length < 3){
			return null;
		}
		Product product =  new Product();
		product.setName(this.formatProductName(msgArr[0]));
		product.setPrice(this.formatPrice(msgArr[2]));
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		return product;
	}

}
