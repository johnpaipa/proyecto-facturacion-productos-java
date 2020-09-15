package view;

import java.util.ArrayList;

import javax.xml.soap.Detail;

import controller.ControllBilling;
import model.Bill;
import model.Client;
import model.Product;

public interface ActionsView {
	public static final String ADD_BILL="Adicionar Factura";
	public static final String CALFACT="Calcular Factura";
	public static final String ADD_PRODUCT="Adicionar Producto";
	public static final String ADD_ITEM="Adicionar Item";
	public static final String QUERY_BILL="Consultar Factura";
	public static final String LIST_PRODUCT="Listar Productos";
	public static final String ADD_CLIENT="Añadir Cliente";
	public static final String LIST_CLIENT="Listar Clientes";
	public static final String LIST_BILL="Listar Facuras";
	
	String[]readInput(String option);
	
	void writeOutPut(String Option, boolean status,String...output);
	void setControll(ControllBilling controll);
	void begin();
	void exit();
	void listProducts(ArrayList<Product> products);
	void listClients(ArrayList<Client> clients);
	void listBill(ArrayList<Bill> bills);
	void listDetail(ArrayList<model.Bill.Detail> arrayList);

	
	void addItem();
	void queryBill();
	void addBill();


	
	
	

}
