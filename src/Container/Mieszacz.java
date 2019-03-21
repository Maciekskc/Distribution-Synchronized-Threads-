package Container;

import java.util.ArrayList;
	
public class Mieszacz {
	private ArrayList<Zasob> zasoby = new ArrayList<Zasob>();

	public WindowStyle items;
	
	public Mieszacz(ArrayList<Zasob> zasoby,WindowStyle items) {
		this.zasoby = zasoby;
		this.items = items;
	}
	
	public ArrayList<Zasob> getZasoby(){
		return zasoby;
	}
	
	public ArrayList<String> get(ArrayList<String> need) {
		synchronized(zasoby) {
			int len = need.size();
			ArrayList<String> spice = new ArrayList<String>();
		next_spice :for(int x = 0 ; x<len;x++) {
				for(int i =0 ; i<zasoby.size();i++) {
					for(int j = 0 ; j< zasoby.get(i).getSize();j++) {
						try{
							if(zasoby.get(i).przyprawy.get(j).equals(need.get(x))) {
							spice.add(zasoby.get(i).take(j));
							continue next_spice;
							}
						}catch(IndexOutOfBoundsException e) {
						}
					}
				}
			}
			updateTable();
			return spice;
		}
	}
	
	public boolean checkOrder(ArrayList<String> need) {
		synchronized(zasoby) {
			int len = need.size();
			int counter = 0;
		next_spice :for(int x = 0 ; x<len;x++) {
				for(int i =0 ; i<zasoby.size();i++) {
					for(int j = 0 ; j< zasoby.get(i).getSize();j++) {
						try {
						if(zasoby.get(i).przyprawy.get(j).equals(need.get(x))) {
							counter++;
							continue next_spice;
						}}catch(IndexOutOfBoundsException e) {
							
						}
					}
				}
			}
			if(len == counter) {
				return true;
			}else {
				zasoby.notify();//jak nie ma dostêpnych przypraw, budzimy dostawce
				return false;
			}
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
