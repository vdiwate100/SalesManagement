package com.org.vd.report;

import java.util.List;
import java.util.Map;

import com.org.vd.model.Product;

/**
 * 
 * @author vaibhav.diwate
 * Manage console based sales report
 */
public class SalesConsoleReport implements SalesReport{

	/**
	 * Manage console based report for sales item
	 * @param message : Sales Repository
	 */
	@Override
	public void productReport(Map<String,Product> items){
		if(null == items){
			return;
		}
		double totalSaleAmount= 0.0;
		System.out.println("\n########## Sales Report for 10 Messages :: START ##########");
		for(String key:items.keySet()){
			totalSaleAmount = totalSaleAmount + items.get(key).getPrice();
			System.out.println(String.format("|%-18s|%-11d|%-11.2f|", 
					key,
					items.get(key).getQuantity(), 
					items.get(key).getPrice()));
		}
		System.out.println("--------------------------------------------");
		System.out.println(String.format("|%-30s|%-11.2f|","Total Product Sales",totalSaleAmount));
		System.out.println("--------------------------------------------");
		System.out.println("########## Sales Report for 10 Messages :: END ##########");
		
	}

	/**
	 *  Manage console based report for adjustment
	 *  @param message : Adjustment Repository
	 */
	@Override
	public void productAdjustmentReport(List<String> adjustmentRepo) {
		if(null == adjustmentRepo){
			return;
		}
		System.out.println("\n########## Sales Adjustment Report :: START ##########");
		for(String item:adjustmentRepo){
			System.out.println(item);
		}
		System.out.println("########## Sales Adjustment Report :: END ##########");
	}

}
