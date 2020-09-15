package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.ManagementBilling;
import model.Product;

public class ViewListClient extends JInternalFrame implements ActionListener{
	
	private DefaultTableModel model;
	private JTable table;
	private MainWindow window;
	private JDesktopPane desktop;
	private ArrayList<Client> clients;


public ViewListClient(JDesktopPane desktop,MainWindow mainWindow,ArrayList<Client> clients) {
	
	this.clients=clients;	
	this.window = mainWindow;
	this.desktop = desktop;
	setTitle("LIsta Cliente");
	setDefaultCloseOperation(HIDE_ON_CLOSE);
	setResizable(true);
	setClosable(true);
	setMaximizable(true);//maximizar ventana
	setIconifiable(true);
	setLayout(new BorderLayout());
	beginComponents();
	listClients();
	this.pack();//ajuste  al contenedor
	desktop.add(this);
		
}
	
	 
	 
	private void beginComponents() {
			
			String[] titles=new String[]{"Id","Name"};
			
			model=new DefaultTableModel(titles,0);
			table=new JTable(model);
			this.add(new JScrollPane(table),BorderLayout.CENTER);
			
			
		}
	

	private void listClients(){
		
		for(Client client:clients){
			
			Object[] row=new Object[]{
				client.getId(),
				client.getName(),
				
			};
			model.addRow(row);
		
		}
		
		
	}



	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 public ArrayList<Client> getClients() {
		return clients;
	}


	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}
