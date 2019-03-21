package Container;

import java.util.ArrayList;
import java.util.Random;

public class Kucharz implements Runnable {
	private Mieszacz mieszacz;
	private int m;//ile przypraw na raz mo�e ��da�
	private Random rand = new Random();
	//baza przypraw
	public final String[] baza_przypraw = {"sol","pieprz","oregano","bazylia"};
	
	//konstruktor
	public Kucharz(Mieszacz mieszacz, int m) {
		this.mieszacz = mieszacz;
		this.m = m;
	}
	
	public int getM() {
		return m;
	}
	
	//metoda losowania przypraw (algorytm losuje przyprawy z dost�opnej bazy przypraw)
	public ArrayList<String> need() {
		ArrayList<String> variables = new ArrayList<String>();
		for(int i=0;i<m;i++) {
			int x =  baza_przypraw.length;
			String s = baza_przypraw[rand.nextInt(x)];
			variables.add(s);
		}		
		return variables;
	}
	
	public void run() {
		synchronized(mieszacz) {
			do {
				ArrayList<String> x = new ArrayList<String>();
				x = Kucharz.this.need(); //rz�danie kucharza
				String var="";
				for(int e = 0 ; e<x.size();e++) {
					var+=x.get(e);
					var+=" ";
				}
				mieszacz.items.cookerTxtPanel.setText(var);
				if(mieszacz.checkOrder(x)) {//sprawdzenie czy takowe sk�adniki s� dost�pne
					x = mieszacz.get(x); //podanie do mieszacza potrzebnych sk�adnikow
					mieszacz.items.cookerTxtPanel2.setText("Tak");
				}else {
					mieszacz.items.cookerTxtPanel2.setText("Nie, budze\ndostawce");
				}
				try {
					Thread.sleep(5000);//kolejne rz�dania s� co 5 sekund
				} catch (InterruptedException e) {
				}
			}while(true);
		}
	}
}
