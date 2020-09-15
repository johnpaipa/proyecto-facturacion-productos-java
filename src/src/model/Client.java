package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Client {
	/**
	 * Declaramos las variables name  e id y  el array  de  facturas*/
	private String name,id;
	ArrayList<Bill> bills;
	
	
	/**Inicializamos en  el constructor  el array de facturas para que cada cliente tenga sus facturas*/
	public Client() {
		
		bills=new ArrayList<>();
		
	}
	/**por sobrecarga de metodos en este contructor recibe como parametros
	 * @param id que  es la identificacion del cliente
	 * @param name nombre del cliente*/
	public Client(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		bills=new ArrayList<>();
	}
	/**generamos  getters  and setters de las  variables*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public ArrayList<Bill> getBills() {
		return bills;
	}
	
	/**Este  metodo se  encarga de generar  la fecha y el numero de factura 
	 * @return number retorna el numero de factura*/
	
	
	public String addBill(){
		
		 
	    Bill bill=new Bill();
	    bill.setDateBill(Calendar.getInstance());
	    String number=bill.makeNumber();
	    bill.setNumber(number);
	    bills.add(bill);
	
		
	
		return number;
	
		
	}
	/**Este  metodo busca la  factura del cliente
	 * @param numer recibe el numero  d efactura
	 * @return bill una factura
	 * @return null si  no encuentra la  factura*/
	
	public Bill findBill(String number) { 
		
        for(Bill bill:bills){
		
		if(bill.getNumber().equals(number)){
			
			return bill;
			
		}
		
	}
	return null;
	
	
}
	/**Este metodo calcula  el total de  las  facturas
	 * @return total  de la factura*/
	public double calcTotBill(){
		
		double total=0.0;
		
		for(Bill bill:bills){
			
			total=+bill.calcTotal();
			
		}
		
		return total;
		
		
	}
	

	@Override
	public String toString() {
		return "Client [Nombre:" + name + ",Identificacion:" + id + "]";
	}
	
	
	

}
