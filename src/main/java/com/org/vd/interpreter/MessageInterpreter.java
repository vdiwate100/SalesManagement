package com.org.vd.interpreter;

import com.org.vd.model.Product;

public abstract class MessageInterpreter {
	
	protected abstract Product parser(String[] msgArr);
	
	protected double formatPrice(String priceStr) {
        double price = Double.parseDouble(priceStr.replaceAll("p|£", ""));
        if (!priceStr.contains(".")) {
        	price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
	}
	
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
