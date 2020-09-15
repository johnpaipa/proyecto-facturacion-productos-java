package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Bill;
import model.Client;
import model.Product;
import view.ActionsView;

public class ViewListFacts extends JInternalFrame implements ActionListener {
	
	private DefaultTableModel model;
	private JTable table;
	private MainWindow window;
	private JButton accept;
	private JDesktopPane desktop;
	private ActionsView view;
	private JTextField txtxIdClient;
	private ArrayList<Bill>bills;
	
	
 public ViewListFacts(JDesktopPane desktop,MainWindow mainWindow,ArrayList<Bill>bills) {
		
		this.bills=bills;	
		this.window = mainWindow;
		this.desktop = desktop;
		setTitle("Lista  Facturas");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);//maximizar ventana
		setIconifiable(true);
		setLayout(new BorderLayout());
		beginComponents();
		listBills();
		this.pack();//ajuste  al contenedor
		desktop.add(this);
			
	}
 
 	
	
	

	private void beginComponents() {
			
				
				String[] titles=new String[]{"Id","Fecha"};
				
				model=new DefaultTableModel(titles,0);
				table=new JTable(model);
				this.add(new JScrollPane(table),BorderLayout.CENTER);
				
				
	
}








	private void listBills() {
		
		txtxIdClient=new JTextField();
		accept= new JButton("Aceptar");
		accept.setActionCommand(view.LIST_BILL);
		accept.addActionListener(window.getControll());
		
		
			for(Bill bill:bills){
			
			Object[] row=new Object[]{
				bill.getNumber(),
				bill.getDateBill().getTime().toString(),
				
			};
			model.addRow(row);
		
		}
	
}








	public JTextField getTxtxIdClient() {
		return txtxIdClient;
	}








	public void setTxtxIdClient(JTextField txtxIdClient) {
		this.txtxIdClient = txtxIdClient;
	}








	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
