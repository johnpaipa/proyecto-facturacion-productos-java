package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.Product;

public class ViewListProducts  extends JInternalFrame implements ActionListener {
	
	private DefaultTableModel model;
	private JTable table;
	private MainWindow window;
	private JDesktopPane desktop;
	private ArrayList<Product>products;

 public ViewListProducts(JDesktopPane desktop,MainWindow mainWindow,ArrayList<Product>products) {
	
	this.products=products;	
	this.window = mainWindow;
	this.desktop = desktop;
	setTitle("Lista Productos");
	setDefaultCloseOperation(HIDE_ON_CLOSE);
	setResizable(true);
	setClosable(true);
	setMaximizable(true);//maximizar ventana
	setIconifiable(true);
	setLayout(new BorderLayout());
	beginComponents();
	listProducts();
	this.pack();//ajuste  al contenedor
	desktop.add(this);
		
}
	
	 
	 
	private void beginComponents() {
			
		String[] titles=new String[]{"Id","Descripcion","Valor","IVA","Existencias","Stock Minimo"};
			
			model=new DefaultTableModel(titles,0);
			table=new JTable(model);
			this.add(new JScrollPane(table),BorderLayout.CENTER);
			
			
		}
	

	private void listProducts(){
		
		for(Product product:products){
			
			Object[] row=new Object[]{
			product.getIdProduct(),
			product.getdescription(),
			product.getValue(),
			product.getIva(),
			product.getStock(),
			product.getStockMin()
			};
			model.addRow(row);
			
		}
		
		
	}
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
