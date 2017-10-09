package com.org.vd.report;

import java.util.List;
import java.util.Map;

import com.org.vd.model.Product;

/**
 * 
 * @author vaibhav.diwate
 * Contract for Sales Report
 */
public interface SalesReport {
	void productReport(Map<String,Product> items);
	void productAdjustmentReport(List<String> adjustmentRepo);
}
