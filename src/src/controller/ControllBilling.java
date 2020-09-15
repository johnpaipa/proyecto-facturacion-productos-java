package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Exceptions.ExceptionBill;
import Exceptions.ExceptionProduct;
import Exceptions.ExceptionStock;
import gui.MainWindow;
import gui.ViewBill;
import gui.ViewListClient;
import model.Client;
import model.ManagementBilling;
import view.ActionsView;
import view.ViewConsole;

public class ControllBilling implements ActionListener {
	private ActionsView view;
	public ManagementBilling mngBill;
	private MainWindow window;
	private ViewListClient list;
	private Client client;
	
	public ControllBilling(ActionsView View) {
		
		
		this.view=View;
		mngBill=new ManagementBilling();
		client= new Client();
		window=new MainWindow();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//arrelar metodos  de consola  osea estos 4 de window.addbill()
		
		switch (e.getActionCommand()) {		
		
		
		case ActionsView.ADD_BILL:addBill();
		break;
		
		case ActionsView.ADD_ITEM:try {
			addItem();
		} catch (ExceptionProduct e1) {
			
			JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			
		} catch (ExceptionStock e1) {

			JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			
		} catch (ExceptionBill e1) {

			JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage(),null,JOptionPane.ERROR_MESSAGE);
			
		}
			break;	
		
		case ActionsView.ADD_PRODUCT:addProduct();
		break;
		case ActionsView.LIST_CLIENT:listClients();
		break;
		
       case ActionsView.QUERY_BILL:queryBill();       
       break;
   	
       case ActionsView.ADD_CLIENT:addClient();
       break;
       
       case  ActionsView.LIST_PRODUCT:listProducts();
       break;

       case  ActionsView.CALFACT:Calfact();
       break;
       
       case  ActionsView.LIST_BILL:ListBill();
       break;
		
		}
		
	}
	
	
	
	
	private void ListBill() {
		
		String[] dates=view.readInput(ActionsView.LIST_BILL);
		String id=dates[0];
		
		view.listBill(mngBill.findClient(id).getBills());
		
		
		}
	
	
	private void Calfact() {
		
		
		try {
		String[] dates=view.readInput(ActionsView.CALFACT);
		String id=dates[0];
		String numFact=dates[1];
		String iva= dates[2];
		String valorNeto=dates[3];
		String valorTotal=dates[4];
		System.out.println(ActionsView.CALFACT);
		String[] output=new String[] {id,numFact,iva,valorNeto,valorTotal};
		view.writeOutPut(ActionsView.CALFACT,true, output);
		}
		
		catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Numero de Factura  invalido o ID cliente  invalido",null,JOptionPane.ERROR_MESSAGE);

		}

		
	}
	

	private void listClients() {
		
		view.listClients(mngBill.getClients());
		}

	
	private void listProducts() {
		
		view.listProducts(mngBill.getProducts());
		
	}
	

	private void queryBill() {
		try {
		String[] dates=view.readInput(ActionsView.QUERY_BILL);
		String id=dates[0];
		String numFact=dates[1];
		if((mngBill.findClient(id).findBill(numFact))!=null) {
			
			view.listDetail(mngBill.findClient(id).findBill(numFact).getDetails());
			
		}
		else {
			
			JOptionPane.showMessageDialog(null, "id o numfact  invalido ",null,JOptionPane.ERROR_MESSAGE);
		}
		}
		catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "NumFact  invalido ",null,JOptionPane.ERROR_MESSAGE);

		}
	}
	 
	
	private void addClient() {
		try {
		System.out.println(ActionsView.ADD_CLIENT);
		
		String[] dates=view.readInput(ActionsView.ADD_CLIENT);
		String name=dates[0];
		String id=dates[1];
	
		
		if(mngBill.addClient(name,id)==true) {
			view.writeOutPut(ActionsView.ADD_CLIENT, true,dates[0],dates[1]);
			System.out.println("Nombre->"+dates[0]+"\nIdentificacion->"+dates[1]);
			JOptionPane.showMessageDialog(null," CLIENTE AÑADIDO");
		}
		else {
			view.writeOutPut(ActionsView.ADD_CLIENT,false,dates[0],dates[1]);
			JOptionPane.showMessageDialog(null, "Ese Cliente  ya existe ingrese  otro  id ",null,JOptionPane.ERROR_MESSAGE);
		}
		}
		catch(NullPointerException e) {
			System.out.println("Campos  vacios");
		}
		
	}



	private void addProduct() {
		
	try {
		
		
		System.out.println(ActionsView.ADD_PRODUCT);
		String[] dates=view.readInput(ActionsView.ADD_PRODUCT);
		
		System.out.println("Id->"+dates[0]+"\nDescripcion->"+dates[1]);
		double value= Double.parseDouble(dates[2]);
		short stock=Short.parseShort(dates[3]);
		byte stockMin= Byte.parseByte(dates[4]);
		float iva=Float.parseFloat(dates[5]);
		
		if(mngBill.addProduct(dates[0], dates[1], value, stock, stockMin, iva)){
			view.writeOutPut(ActionsView.ADD_PRODUCT, true,dates[0],dates[1]);
			JOptionPane.showMessageDialog(null,"PRODUCTO AÑADIDO  ");
			}
		
			else {
				view.writeOutPut(ActionsView.ADD_PRODUCT,false,dates[0],dates[1]);
				JOptionPane.showMessageDialog(null, "Ese Producto con ese  Id  ya  existe O El Stockmin debe  ser menor que Stock ",null,JOptionPane.ERROR_MESSAGE);
			}
	}
	catch(NullPointerException e) {
		System.out.println("Campos  vacios");
	}
	catch(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "no se pueden ingresar letras ",null,JOptionPane.ERROR_MESSAGE);
		
	}
		
	}



	private void addItem() throws HeadlessException, ExceptionProduct, ExceptionStock, ExceptionBill {
		try {
		System.out.println(ActionsView.ADD_ITEM);
		String[] dates=view.readInput(ActionsView.ADD_ITEM);
		String idProduct=dates[0];
		String idCliente=dates[1];
		String numFact=dates[2];
		short cant= Short.parseShort(dates[3]);
		
		
			if(mngBill.addDetail(idProduct, idCliente, numFact, cant)==true) {
				
				JOptionPane.showMessageDialog(null,"PRODUCTO AÑADIDO  A LA FACTURA "+numFact);
				view.writeOutPut(ActionsView.ADD_BILL, true,dates[0],dates[1],dates[2],dates[3]);
			
		}
		
		else {
			view.writeOutPut(ActionsView.ADD_BILL,false,dates[0],dates[1],dates[2]);
			JOptionPane.showMessageDialog(null,"");
		}
		
		}
		catch(NullPointerException e) {
			System.out.println("Campos  vacios");
		}
		
	}



	private void addBill() {
		try {
		int numBill=0;
		
		
		//String number=client.addBill();
		String[]input=view.readInput(ActionsView.ADD_BILL);
		String id =input[0];
		
		
		if(mngBill.findClient(id)!=null) {
			
			String num=mngBill.findClient(input[0]).addBill();
			
			String fecha=mngBill.findClient(input[0]).findBill(num).getDateBill().getTime().toString();
			String[] output=new String[] {input[0],num,fecha};
			view.writeOutPut(ActionsView.ADD_BILL, true,output[0],output[1],output[2]);
			System.out.println("Id->"+input[0]+"\nNumero factura: "+num+"\nFecha->"+fecha);
			JOptionPane.showMessageDialog(null,"FACTURA AÑADIDA");
		}
		
		else {
			view.writeOutPut(ActionsView.ADD_BILL,false,input[0]);
			JOptionPane.showMessageDialog(null,"ESE CLIENTE NO EXISTE");
		}
		
		
		}
		catch(NullPointerException e) {
			System.out.println("Campos  vacios");
		}
	}

}
