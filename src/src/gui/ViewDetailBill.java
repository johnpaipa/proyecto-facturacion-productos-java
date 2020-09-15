package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.soap.Detail;

import model.Bill;
import view.ActionsView;

public class ViewDetailBill extends JInternalFrame  implements ActionListener{
	
	private DefaultTableModel model;
	private JTable table;
	private MainWindow window;
	private JDesktopPane desktop;
	private ActionsView view;
	private ArrayList<model.Bill.Detail>details;
	
	
 public ViewDetailBill(JDesktopPane desktop,MainWindow mainWindow,ArrayList<model.Bill.Detail> arrayList) {
		
		this.details=arrayList;	
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
			
				
				String[] titles=new String[]{"Descripcion", "codigo", "Cantidad", "iva", "subtotal", "total"};
				
				model=new DefaultTableModel(titles,0);
				table=new JTable(model);
				this.add(new JScrollPane(table),BorderLayout.CENTER);
				
				
	
}








	private void listBills() {
		
	
		
		
			for(model.Bill.Detail detail:details){
			
			Object[] row=new Object[]{
				detail.getProduct().getdescription(),
				detail.getProduct().getIdProduct(),
				detail.getQuantity(),
				detail.getProduct().getIva(),
				detail.calcSubtotal(),
				detail.calcTotal(),
				
				
				
			};
			model.addRow(row);
		
		}
	
}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
