package view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControllBilling;
import gui.ViewListClient;
import gui.WindowList;
import model.Bill;
import model.Bill.Detail;
import model.Client;
import model.ManagementBilling;
import model.Product;

public class ViewConsole implements ActionsView{
	
	private ControllBilling controll;
	private ViewListClient viewListClient;

	public void setControl(ControllBilling controll) {
		
		this.controll=controll;
		
	}
	
	

	@Override
	public String[] readInput(String option) {
		switch (option) {
		case ActionsView.ADD_PRODUCT:return readProduct();
			
			
		}
		return null;
	}
	
	private  String[] readProduct() {
		String id=JOptionPane.showInputDialog(null,"id product" );
		String description=JOptionPane.showInputDialog(null,"descripcion");
		String value=JOptionPane.showInputDialog(null,"valor del producto");
		String stock=JOptionPane.showInputDialog(null,"stock");
		String stockMin=JOptionPane.showInputDialog(null,"stockMin");
		String iva=JOptionPane.showInputDialog(null,"iva");
		
		String[] record=new String[] {id,description,value,stock,stockMin,iva};
		
		
		return record;
	}
	

	@Override
	public void writeOutPut(String Option, boolean status, String ...output) {
	switch (Option) {
	case ActionsView.ADD_BILL:
		System.out.println("La factura "+ output[0] +" se creo Exitosa");
		
		break;
	case ActionsView.ADD_PRODUCT:
		if (status) {
			JOptionPane.showMessageDialog(null,"El producto "+output[0]+" se inserto OK");
			
		}
		else {
			//errores ern mesaje
		}

	}
	}

	@Override
	public void setControll(ControllBilling controll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void begin() {
		System.out.println("Inicio "+controll);
		
		String[] options=new String[] {ActionsView.ADD_BILL,ActionsView.ADD_PRODUCT,ActionsView.ADD_ITEM,ActionsView.QUERY_BILL,ActionsView.LIST_PRODUCT};
		while(true) {
			
			String option=(String)JOptionPane.showInputDialog(null, "Digite opcion","MENU PRINCIPAL",JOptionPane.DEFAULT_OPTION,null,options,options[0]);
			option=option==null?"salir":option;
			switch (option) {
			case "salir":exit();
			case ActionsView.ADD_BILL:controll.actionPerformed(new ActionEvent(this, 0,ActionsView.ADD_BILL));
			break;
			case ActionsView.ADD_ITEM:controll.actionPerformed(new ActionEvent(this, 0,ActionsView.ADD_ITEM));	
			break;
			case ActionsView.ADD_PRODUCT:controll.actionPerformed(new ActionEvent(this, 0,ActionsView.ADD_PRODUCT));
			break;
			case ActionsView.QUERY_BILL:controll.actionPerformed(new ActionEvent(this, 0,ActionsView.QUERY_BILL));
			break;
			case ActionsView.LIST_PRODUCT:controll.actionPerformed(new ActionEvent(this, 0,ActionsView.LIST_PRODUCT));
			
			}
			
			
		}
		
	}

	@Override
	public void exit() {
		int exit=JOptionPane.showConfirmDialog(null,"Desea salir?","SALIR",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(exit==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
		
	}



	@Override
	public void listProducts(ArrayList<Product> products) {
		
		WindowList window=new WindowList(products);
		window.setVisible(true);
		
	}



	









	@Override
	public void addItem() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void queryBill() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addBill() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void listClients(ArrayList<Client> clients) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void listBill(ArrayList<Bill> bills) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void listDetail(ArrayList<Detail> arrayList) {
		// TODO Auto-generated method stub
		
	}



	



//	@Override
	//public void listClients(ArrayList<Client> clients) {
//	ViewListClient windowlist=new ViewListClient(clients);
	
		
	//	windowlist.setVisible(true);
		
//	}
	
	

}
