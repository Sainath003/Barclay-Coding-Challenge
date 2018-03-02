package barclay.main;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import barclay.main.dto.Theater;
import barclay.main.entity.Order;
import barclay.main.service.Service;
/**
 * @author Sainath
 *
 */
public class BarclaysApplicationTest {
	
	@Test
	public void findSeats() {

		Theater th = new Theater();
		Order or = new Order();
		Service fds = new Service();
		
		th.setRowMap(new LinkedHashMap<>());
		or.setOrdersMap(new LinkedHashMap<>());
		or.setResultsMap(new LinkedHashMap<>());

		StringBuilder sout = new StringBuilder();
		sout.append(
				"{Smith=Row 1 Section 1, Jones=Row 2 Section 2, Davis=Row 1 Section 2, Wilson=Sorry we can't handle your party., Johnson=Row 2 Section 1, Williams=Row 1 Section 1, Brown=Row 4 Section 2, Miller=Call to split party.}");

		StringBuilder map = new StringBuilder();
		map.append("6 6\n" + "3 5 5 3\n" + "4 6 6 4\n" + "2 8 8 2\n" + "6 6");

		setInput(th, map);

		StringBuilder order = new StringBuilder();
		order.append("Smith 2\n" + "Jones 5\n" + "Davis 6\n" + "Wilson 100\n" + "Johnson 3\n" + "Williams 4\n"
				+ "Brown 8\n" + "Miller 12");
		setOrder(or, order);

		fds.lookUpSeats(or, th);
		
		assertEquals(or.getResults().toString(), sout.toString());
	}

	public void setInput(Theater th, StringBuilder sMap) {
		String[] rowArr = sMap.toString().split("\n");
		int i = 1;
		for (String row : rowArr) {
			String[] sectionArr = row.split(" ");
			int j = 1;
			th.setSectionMap(new LinkedHashMap<>());			
			for (String section : sectionArr) {
				th.getSection().put(j++, Integer.parseInt(section));
				th.setSeats(th.getAllSeats() + Integer.parseInt(section));
			}
			th.getRow().put(i++, th.getSection());
		}
	}

	public void setOrder(Order or, StringBuilder order) {
		
		String[] input = order.toString().split("\n");		
		List<String> in = new LinkedList<>(Arrays.asList(input));
		in.forEach(o -> or.getOrders().put(o.split(" ")[0], Integer.parseInt(o.split(" ")[1])));
		
	}

}
