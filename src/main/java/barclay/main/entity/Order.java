package barclay.main.entity;

import java.util.LinkedHashMap;
/**
 * @author Sainath
 *
 */
public class Order {
	
	private LinkedHashMap<String, Integer> orders;
	private LinkedHashMap<String, String> output;	
	
	public LinkedHashMap<String, Integer> getOrders() {
		return orders;
	}
	public void setOrdersMap(LinkedHashMap<String, Integer> orders) {
		this.orders = orders;
	}
	public LinkedHashMap<String, String> getResults() {
		return output;
	}
	public void setResultsMap(LinkedHashMap<String, String> output) {
		this.output = output;
	}
	
}
