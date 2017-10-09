package com.org.vd.interpreter;

import com.org.vd.model.Product;

/**
 * 
 * @author vaibhav.diwate
 * Manages Message interpretation : Identify message type and send it for a parsing process
 */
public class ManageMessageInterpreter {
	
	/**
	 * 
	 * @param message : Message to parse
	 * @return : Parsed Project object
	 */
	public Product parseMessage(String message){
		if (message == null || message.isEmpty()) {
            return null;
        }
		Product product = null;
		MessageInterpreter messageInterpreter;
        String[] msgArr = message.trim().split("\\s+");
        String firstWord = msgArr[0];
        if (msgArr.length == 3 && msgArr[1].contains("at")) {
        	messageInterpreter = new SoloMessageInterpreter();
        	product = messageInterpreter.parser(msgArr);
        }else if (firstWord.matches("^\\d+")) {
        	messageInterpreter = new GroupMessageInterpreter();
        	product = messageInterpreter.parser(msgArr);
        }else if (firstWord.matches("Add|Subtract|Multiply")) {
        	messageInterpreter = new AdjustOprMessageInterpreter();
        	product = messageInterpreter.parser(msgArr);
        }else {
            System.out.println("Not a valid message");
            product = null;
        }
        return product;
	}
	
}
