package com.org.vd.interpreter;

import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;

public class SoloMessageInterpreter extends MessageInterpreter{

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
