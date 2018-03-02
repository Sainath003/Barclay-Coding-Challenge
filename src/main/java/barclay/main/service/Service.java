package barclay.main.service;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import barclay.main.dto.Theater;
import barclay.main.entity.Order;
/**
 * @author Sainath
 *
 */
public class Service {

	public void lookUpSeats(Order o, Theater t) 
	{
		for (Entry<String, Integer> e : o.getOrders().entrySet()) {
			if (e.getValue() <= t.getAllSeats()) {
				checkingSeatRequest(o, t, e.getValue(), e.getKey());
				t.setSeats(t.getAllSeats() - e.getValue());
			} else {
				o.getResults().put(e.getKey(), "Sorry we can't handle your party.");
			}
		}

		output(o.getResults());
	}

	private void checkingSeatRequest(Order o, Theater t, Integer i, String name) {

		boolean flag = false;
		LinkedHashMap<String, String> output = o.getResults();
		LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> rowMap = t.getRow();

		for (Entry<Integer, LinkedHashMap<Integer, Integer>> e : rowMap.entrySet()) {
			for (Entry<Integer, Integer> o1 : e.getValue().entrySet()) {
				int d = o1.getValue() - i;
				LinkedHashMap<Integer, Integer> sectionMap = rowMap.get(e.getKey());
				if (d == 1 || d < 0)
					continue;
				else {
					if (output.get(name) == null) {
						output.put(name, "Row " + e.getKey() + " Section " + o1.getKey());
						sectionMap.put(o1.getKey(), d);
						rowMap.put(e.getKey(), sectionMap);
					}
					flag = true;
				}
			}
		}

		if (!flag) {
			output.put(name, "Call to split party.");
		}
	}

	private void output(LinkedHashMap<String, String> m) {
		for (Entry<String, String> e : m.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println();
	}
}
