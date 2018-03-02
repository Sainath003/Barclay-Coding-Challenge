package barclay.main.dto;

import java.util.LinkedHashMap;
/**
 * @author Sainath
 *
 */
public class Theater {

	private LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> row;
	private LinkedHashMap<Integer, Integer> section;
	private int total = 0;

	public LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> getRow() {
		return row;
	}

	public void setRowMap(LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> row) {
		this.row = row;
	}

	public LinkedHashMap<Integer, Integer> getSection() {
		return section;
	}

	public void setSectionMap(LinkedHashMap<Integer, Integer> section) {
		this.section = section;
	}

	public int getAllSeats() {
		return total;
	}

	public void setSeats(int total) {
		this.total = total;
	}

}
