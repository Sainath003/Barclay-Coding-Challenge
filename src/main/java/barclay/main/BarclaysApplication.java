package barclay.main;

import java.util.LinkedHashMap;
import java.util.Scanner;

import barclay.main.dto.Theater;
import barclay.main.entity.Order;
import barclay.main.service.Service;
/**
 * @author Sainath
 *
 */
public class BarclaysApplication {
		
	public static void main(String[] args) {
		
		Theater t = new Theater();
		Order o = new Order();
		Service s = new Service();
		
		System.out.println("Enter Input");
		Scanner scan = new Scanner(System.in);
		int i = 1;
		t.setRowMap(new LinkedHashMap<>());
		o.setOrdersMap(new LinkedHashMap<>());
		o.setResultsMap(new LinkedHashMap<>());

		while (scan.hasNextLine()) {
			String[] c = scan.nextLine().split(" ");
			if (c[0].equals(""))
				break;
			int j = 1;
			t.setSectionMap(new LinkedHashMap<>());
			for (String x : c) {
				t.getSection().put(j++, Integer.parseInt(x));
				t.setSeats(t.getAllSeats() + Integer.parseInt(x));
			}
			t.getRow().put(i++, t.getSection());
		}

		while (scan.hasNextLine()) {
			String[] c = scan.nextLine().split(" ");
			if (c[0].equals(""))
				break;
			o.getOrders().put(c[0], Integer.parseInt(c[1]));
		}

		s.lookUpSeats(o, t);
		scan.close();
	}
	
}
