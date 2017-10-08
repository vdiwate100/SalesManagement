package com.org.vd.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.org.vd.common.ApplicationConstant;
import com.org.vd.interpreter.ManageMessageInterpreter;
import com.org.vd.model.Product;
import com.org.vd.model.Sale;
import com.org.vd.report.SalesConsoleReport;
import com.org.vd.report.SalesReport;

public class MessageSalesProcessor implements SalesProcessor{
	
	private ManageMessageInterpreter manageMessageInterpreter;
	private Sale sale;
	private SalesReport salesReport;

	public MessageSalesProcessor(){
		this.manageMessageInterpreter= new ManageMessageInterpreter();
		this.sale = new Sale();
		this.salesReport = new SalesConsoleReport();
	}
	
	@Override
	public boolean process() {
		BufferedReader inputFile = extractSalesMessages();
		if(null == inputFile){
			return false;
		}
		int lineCounter=1;
		String line;
		Product product;
		try {
			while((line = inputFile.readLine()) != null) {
			   product = manageMessageInterpreter.parseMessage(line);
			   if(null != product){
				   sale.manageSalesItinerary(product);
			   }
				   
			   if((lineCounter % ApplicationConstant.TRIGGER_LOG_AT) == 0) {
				   salesReport.productReport(sale.getItems());
			   }
			   
			   if((lineCounter % ApplicationConstant.TERMINATE_APPLICATION) == 0){
				   System.out.println("\nReached max message limit of "+ApplicationConstant.TERMINATE_APPLICATION+" and cannot process further. Following are the adjustment records-\n");
				   salesReport.productAdjustmentReport(sale.getAdjustmentRepo());
				   break;
			   }
			   lineCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	private BufferedReader extractSalesMessages(){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = new File(classloader.getResource(ApplicationConstant.INPUT_FILE_NAME).getFile());
		try {
			return new BufferedReader(new FileReader(file));
		}catch(IOException e){
		    e.printStackTrace();
		    return null;
		}
	}
}
