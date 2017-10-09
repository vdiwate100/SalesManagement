package com.org.vd.interpreter;

import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;


/**
 * 
 * @author vaibhav.diwate
 * Manage group message : Parse Adjustment Message
 */
public class GroupMessageInterpreter extends MessageInterpreter{

	/**
	 * 
	 * @param message : Message to parse E.g 20 sales of apples at 10p each.
	 * @return : Parsed Project object
	 */
	@Override
	protected Product parser(String[] msgArr) {
		if(msgArr.length > 7 || msgArr.length < 7){
			return null;
		}
		Product product =  new Product();
		product.setName(this.formatProductName(msgArr[3]));
		product.setPrice(this.formatPrice(msgArr[5]));
		product.setQuantity(Integer.parseInt(msgArr[0]));
		product.setAdjustmentOperation(AdjustmentOperation.NA);
		return product;
	}

}
