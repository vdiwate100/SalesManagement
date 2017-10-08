package com.org.vd.interpreter;

import com.org.vd.common.ApplicationConstant;
import com.org.vd.model.AdjustmentOperation;
import com.org.vd.model.Product;

public class AdjustOprMessageInterpreter extends MessageInterpreter{

	@Override
	protected Product parser(String[] msgArr) {
		if(msgArr.length > 3 || msgArr.length < 3){
			return null;
		}
		Product product =  new Product();
		product.setName(this.formatProductName(msgArr[2]));
		product.setPrice(this.formatPrice(msgArr[1]));
		product.setQuantity(ApplicationConstant.DEFAULT_PRODUCT_QUANTITY_ADJUST_OPR);
		product.setAdjustmentOperation(AdjustmentOperation.valueOf(msgArr[0].toUpperCase()));
		return product;
	}

}
