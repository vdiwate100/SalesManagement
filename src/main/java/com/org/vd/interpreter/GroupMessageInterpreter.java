package com.org.vd.interpreter;

import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;

public class GroupMessageInterpreter extends MessageInterpreter{

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
