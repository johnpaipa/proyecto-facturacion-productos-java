package model;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.ExceptionBill;
import Exceptions.ExceptionProduct;
import Exceptions.ExceptionStock;

/** Esta clase se encarga de hacer operaciones como: buscar cliente, añadir cliente, añadir productos entre otros metodos de la logica
 * @author: Diego Armando Higuera Blanco y John Fredy Paipa Lara

 * @version: 10/02/2019*/


public class ManagementBilling {
	/**¸Declaramos los vectores*/
	
	ArrayList<Product> products;
	ArrayList<Client> clients;
	
	

	

	
	/** constructor de la clase  donde inicializamos  los vectores para que cada cliente
	 *  tenga un array d efacturas y productos*/
	public ManagementBilling() {
		
		products=new ArrayList<>();		
		clients=new ArrayList<>();
		Client  client= new Client("pedro","5");
		clients.add(new Client("pedro","2"));
		
		Product product=new Product("5", "papa", (double)500, (short)15,(byte) 5,(float) 5);
		products.add(product);
		
	}
	//cierre  del constuctor
	
	/** metodo  que se  encarga de  buscar si  el cliente existe o no
	 * @param id es  el parametro que recibe el metodo  con el cual realizamos  la busqueda
	 * @return client un objeto de  tipo cliente 
	 * @return null  en caso de no encontrar el  cliente con ese id*/
	
	public Client findClient(String id){
		
		for(Client client:clients){
			
			if(client.getId().equals(id)){
				
				return client; 
				
			}
			
		}
		return null;
		
		
	}
	/**
	 * getters and setters de  los  Arraylist */
	


	public ArrayList<Client> getClients() {
		return clients;
	}


	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	
	/**
	 * fin de  los  getters and setters
	 */

	/**
	 * metodo  que se  encarga de añadir  el cliente o crearlo
	 * @param name ,id  recibe  como  parametro  el nombre  y el numero de identificacion del cliente
	 * @return me devuelve falso  o  verdadero  segun se a  el caso si lo añade  me retorna true y si no me retorna false*/

	public boolean addClient(String name,String id){
		
		if(findClient(id)==null){ 
			
			clients.add(new Client(name, id));
			
			return true;
			
		}else{
		
		return false;
		}
		
		
	}//fin del metodo
	
	
	/**
	 * este metodo se encarga de buscar  el producto en el inventario
	 * @param idProduct recibe como parametro  y realiza la busqueda
	 * @return null o product si encuentra el producto y si no devuelve nulo*/
	
	public Product findProduct(String idProduct) {

		for(Product product:products){
			
			if(product.getIdProduct().equals(idProduct)){
				
				return product;
				
			}
			
		}
		return null;
				
	}// fin metodo
	
	
	
	/**Este  metodo se  encargade  añadir  productos  al inventario
	 * @param idProduct  codigo dle producto
	 * @param description  nombre del producto
	 * @param  value valor del producto
	 * @param  stock  cantidad  a dejar en el inventario
	 * @param stockMin cantidad  minima a dejar en el inventario
	 * @param iva iva del producto*/
	
public boolean addProduct(String idProduct, String description, double value, short stock, byte stockMin, float iva){
		
		if(findProduct(idProduct)==null&& stock>stockMin ){
			
			products.add(new Product(idProduct, description, value, stock, stockMin, iva));
			return true;
			
		}else{
		
		return false;
		}
		
		
		
	}/**
 * @return true  si añade  el producto o  false  si no*/

/**
 * metodo para añadir  productos  a la factura o realizar  compras  en otras  palabras
 * @param id Product recibe  un  numero  de identificacion del producto
 * @param number numero de  la factura
 * @param cant cantidad de productos a  comprar
 * @throws ExceptionProduct  si el  producto no existe
 * @throws ExceptionBill  si la  factura no  existe*/


public boolean addDetail(String idProduct,String idClient,String number,short cant ) throws ExceptionProduct, ExceptionStock, ExceptionBill{
		
	
        Bill bill= findClient(idClient).findBill(number);
        
        
         if(bill != null){
 			
 			Product product=findProduct(idProduct);
 			
 			if(product !=null){
 				
 				bill.addDetail(product, cant);
 				
 				return true;
 				
 			}else{
 				
 				throw new ExceptionProduct("Producto Inexistente");
 				
 			}
 			
 		}else{
 			
 			throw new ExceptionBill("factura Inexistente");
 			
 		}
         
	
	
}
/**
 * getter  para arraylist products */


public ArrayList<Product> getProducts() {
	return products;
}
/**
 * setter  para arraylist products */

public void setProducts(ArrayList<Product> products) {
	this.products = products;
}


	
	
	
	
	
	
	
	

}
