package com.org.vd.interpreter;

import com.org.vd.model.Product;

/**
 * 
 * @author vaibhav.diwate
 * An abstract implementation for Message Interpreter
 */
public abstract class MessageInterpreter {
	
	protected abstract Product parser(String[] msgArr);
	
	/**
	 * 
	 * @param priceStr : Price in the form of String
	 * @return : double interpretation of price value
	 */
	protected double formatPrice(String priceStr) {
        double price = Double.parseDouble(priceStr.replaceAll("p|£", ""));
        if (!priceStr.contains(".")) {
        	price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
	}
	
	/**
	 * 
	 * @param name : Product Name
	 * @return : Uniformed product name
	 */
	protected String formatProductName(String name){
		if(null == name)
			return null;
		String formattedName = ""; 
		String singularNameState = name.substring(0, name.length() - 1);
		if (name.endsWith("o")) {
			formattedName = String.format("%soes", singularNameState);
        } else if (name.endsWith("y")) {
        	formattedName = String.format("%sies", singularNameState);
        } else if (name.endsWith("h")) {
        	formattedName = String.format("%shes", singularNameState);
        } else if (!name.endsWith("s")) {
        	formattedName = String.format("%ss", name);
        } else {
        	formattedName = String.format("%s", name);
        }
		return formattedName.toLowerCase();
	}
}
