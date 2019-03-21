package Container;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends JFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//sta³e
	public final static int CAPACITY = 3;
	public final static int QUANTITY =2;
	
	//okno
	public static WindowStyle items;
	
	//elementy 
	public static Dostawca supplier;
	public static Zasob zas1,zas2,zas3;
	public static Mieszacz mix;
	public static Kucharz cooker1;
	public static Thread cooker1Thread,cooker2Thread,supplierThread;
	
	
	public Frame() {
		items = new WindowStyle(this);
	}
	
	
	
	public static void main(String[] args) {
		new Frame();

		createUsers();
		createThreads();
	}
	
	public static void createUsers() {
		zas1=  new Zasob(CAPACITY);
		zas2=  new Zasob(CAPACITY);
		zas3=  new Zasob(CAPACITY);
		
		ArrayList<Zasob> container = new ArrayList<Zasob>();
		container.add(zas1);
		container.add(zas2);
		container.add(zas3);
		
		mix = new Mieszacz(container,items);
		cooker1 = new Kucharz(mix,QUANTITY);
		supplier = new Dostawca(container,items,mix);

	}
	
	public static void createThreads() {
		cooker1Thread = new Thread(cooker1);
		cooker1Thread.start();
		
		supplierThread= new Thread(supplier);
		supplierThread.start();
	}

}
