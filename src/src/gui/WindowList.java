package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Product;

public class WindowList extends JDialog{
	
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<Product> products;
	
	
	
	public WindowList(ArrayList<Product> products){
		
		this.products=products;
		this.setTitle("Lista Productos");
		this.setSize(420, 360);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setModal(true);
		begin();
		listProducts();
		
	}
	
	private void begin(){
	
		String[] titles=new String[]{"Id","Descripcion","Valor","Existencias","IVA","Stock Minimo"};
		
		model=new DefaultTableModel(titles,0);
		table=new JTable(model);
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		
	}




	
	private void listProducts(){
		//table.setModel(new DefaultTableModel());
		
		for(Product product:products){
		
			Object[] row=new Object[]{
				product.getIdProduct(),
				product.getdescription(),
				product.getValue(),
				product.getStock(),
				product.getIva(),
				product.getStockMin()
				
			};
			model.addRow(row);
		
		}
		
	}

}
