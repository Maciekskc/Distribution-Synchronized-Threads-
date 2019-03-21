package Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public class WindowStyle {
	Frame frame;
	
	public JPanel panel;
	public JTable table,table1,table2;
	private Object columnNames[] = {"Przyprawa"};
	public JLabel cookerLabel,cookerLabel2;
	public JTextPane cookerTxtPanel2,cookerTxtPanel;
	public DefaultTableModel tableModel = new DefaultTableModel(null,columnNames);
	public DefaultTableModel tableModel1 = new DefaultTableModel(null,columnNames);
	public DefaultTableModel tableModel2 = new DefaultTableModel(null,columnNames);

	
	public WindowStyle(Frame frame) {
		this.frame = frame;
		
		createPanel();
		
		frame.setSize(378,290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("lab05");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 378, 290);
		
		cookerTxtPanel = new JTextPane();
		cookerTxtPanel.setBounds(63, 140, 86, 100);
		panel.add(cookerTxtPanel);
		
		cookerLabel = new JLabel("Kucharz rz¹da");
		cookerLabel.setBounds(63, 120, 100, 14);
		panel.add(cookerLabel);
		
		cookerLabel2 = new JLabel("Dostêpne?");
		cookerLabel2.setBounds(189, 120, 80, 14);
		panel.add(cookerLabel2);
		
		cookerTxtPanel2 = new JTextPane();
		cookerTxtPanel2.setBounds(189, 140, 86, 50);
		panel.add(cookerTxtPanel2);
		
		table = new JTable(tableModel);
		table.setBounds(10, 10, 106, 100);
		panel.add(table);
		
		JScrollPane scrollPane= new JScrollPane(table);
		scrollPane.setBounds(10, 10, 106, 100);
		panel.add(scrollPane);
		
		table1 = new JTable(tableModel1);
		table1.setBounds(126, 10, 106, 100);
		panel.add(table1);
		
		JScrollPane scrollPane1= new JScrollPane(table1);
		scrollPane1.setBounds(126, 10, 106, 100);
		panel.add(scrollPane1);
		
		table2 = new JTable(tableModel2);
		table2.setBounds(242, 10, 106, 100);
		panel.add(table2);
		
		JScrollPane scrollPane2= new JScrollPane(table2);
		scrollPane2.setBounds(242, 10, 106, 100);
		panel.add(scrollPane2);
		
		panel.setVisible(true);
		frame.add(panel);
	}	
}
