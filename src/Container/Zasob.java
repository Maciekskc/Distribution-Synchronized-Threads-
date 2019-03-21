package Container;

import java.util.ArrayList;

public class Zasob {
	private int count = 0;
	private int capacity;
	public boolean isFull = false;
	public final String[] baza_przypraw = {"sol","pieprz","oregano","bazylia"};
	
	public ArrayList<String> przyprawy = new ArrayList<String>();
	
	public Zasob(int capacity) {
		this.capacity = capacity;
	}
	
	public void checkFull() {
		if(count == capacity) {
			isFull=true;
		}else {
			isFull = false;
		}
	}
	
	public String take(int x) {
		String var = przyprawy.get(x);
		przyprawy.remove(x);
		count--;
		checkFull();
		return var;
	}
	
	public void addElement(String val) {
		if(!isFull) {
			przyprawy.add(val);
			count++;
			checkFull();
		}
	}
	
	public int getSize() {
		return count;
	}
	
	public int getCapacity() {
		return capacity;
	}
}
