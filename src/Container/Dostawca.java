package Container;

import java.util.ArrayList;
import java.util.Random;

public class Dostawca implements Runnable {
	public ArrayList<Zasob> zasoby = new ArrayList<Zasob>();
	public Random rand = new Random();
	public WindowStyle items;
	public Mieszacz mix;
	
	public Dostawca(ArrayList<Zasob> zasoby,WindowStyle items,Mieszacz mix) {
		this.zasoby = zasoby;
		this.items = items;
		this.mix = mix;
	}
	
	@Override
	public void run() {
		synchronized(zasoby) {
			do{
				for(int i = 0 ; i <zasoby.size() ; i++) {
					while(!zasoby.get(i).isFull) {
						String val;
						val= zasoby.get(i).baza_przypraw[rand.nextInt(zasoby.get(i).baza_przypraw.length)];
						zasoby.get(i).addElement(val);
					}
				}
				updateTable();
				try {
					zasoby.wait();	
				} catch (InterruptedException e) {
				}
			}while(true);
		}
	}
	
	public void updateTable() {
		//pierwsza tabela 
			//for na usuwanie
			for(int i = items.tableModel.getRowCount() -1; i >= 0; i--) {
				items.tableModel.removeRow(i);
			}
			//for na dodawanie
			for(int i = 0  ; i <zasoby.get(0).przyprawy.size(); i++) {
				items.tableModel.addRow(new Object[] {zasoby.get(0).przyprawy.get(i)});
			}
		//druga tabela
			//for na usuwanie
			for(int i = items.tableModel1.getRowCount() -1; i >= 0; i--) {
				items.tableModel1.removeRow(i);
			}
			//for na dodawanie
			for(int i = 0  ; i <zasoby.get(1).przyprawy.size(); i++) {
				items.tableModel1.addRow(new Object[] {zasoby.get(1).przyprawy.get(i)});
			}
		//trzecia tabela
			//for na usuwanie
			for(int i = items.tableModel2.getRowCount() -1; i >= 0; i--) {
				items.tableModel2.removeRow(i);
			}
			//for na dodawanie
			for(int i = 0  ; i <zasoby.get(2).przyprawy.size(); i++) {
				items.tableModel2.addRow(new Object[] {zasoby.get(2).przyprawy.get(i)});
			}
		}
}
