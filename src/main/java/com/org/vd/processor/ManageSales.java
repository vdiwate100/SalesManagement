package com.org.vd.processor;

public class ManageSales {
	public static void main(String[] args) {
		try{
			SalesProcessor salesProcessor = new MessageSalesProcessor();
			salesProcessor.process();
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}

}
