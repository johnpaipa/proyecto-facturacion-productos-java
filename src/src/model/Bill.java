package model;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.ExceptionStock;


public class Bill {
	
	private String number;
	private Calendar dateBill;
	private ArrayList<Detail> details;
	private static int last=0;
	
	public Bill() {

		details=new ArrayList<>();
		
	}
	
	
	


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}





	public void setDateBill(Calendar dateBill) {
		this.dateBill = dateBill;
	}





	public void setDetails(ArrayList<Detail> details) {
		this.details = details;
	}





	public Calendar getDateBill() {
		return dateBill;
	}
	
	public boolean addDetail(Product product, short quatity) throws ExceptionStock{
		
		if(product.getStockMin()<=product.getStock()-quatity){
			
			details.add(new Detail( product,quatity));
			
			product.setStock((short) (product.getStock()-quatity));
			
			if(product.getStock()==product.getStockMin()){
				
				throw new ExceptionStock("Ojo Comprar: " + product.getdescription());
			}
			
			return true;
		}
		
		return false;
		
		
	}
	
	public double calcTotal(){
		
		
		double total=0.0;
		
		for (Detail detail:details) {
			
			total +=detail.calcSubtotal();
			
		}
		
		return total+calcAssessment();
		
		
	}
	
	public double calcExempt(){

		double output=0.0;
		
		for(Bill.Detail detail:details){
			
			Product product=detail.getProduct();
			
			output += (product.getValue()*detail.getQuantity());
			
		}
		
		return output;
		
		
	}
	
	public double calcAssessment(){
		
		double output=0.0;
		
		for(Bill.Detail detail:details){
			
			Product product=detail.getProduct();
			
			output += (product.getValue()*detail.getQuantity()) * (product.getIva()/100);
			
		}
		
		return output;
		

		
	}
	
	public ArrayList<Detail> getDetails(){
		
	return (ArrayList<Detail>) details;
		
		//return details;
		
	}
	
	public String makeNumber(){
		
		
		
	
		return 	Integer.toString(last++);
		
		
	}
	
	public Product isProduct(String idProduct){
		
		
		
		
		return null;
		
	}
	
	
	public class Detail{
		
		
		private short quantity;
		private Product product;

		public Detail(Product product,short quantity) {
			
			this.product = product;
			this.quantity = quantity;
		}

		public short getQuantity() {
			return quantity;
		}

		public void setQuantity(short quantity) {
			this.quantity = quantity;
		}
		
		
		public double calcExempt(){
			
			return product.getValue();
			
			
		}
		
		public double calcAssessment(){
			
			return product.getValue() * (product.getIva()/100);
		
			
			
		}
		
		public double calcSubtotal(){
			
			return (product.getValue()*getQuantity());
			
			
		}
		
		public double calcTotal(){
			
			return (product.getValue()*getQuantity())+(calcAssessment()*getQuantity());
			
			
		}

		public Product getProduct() {
			
			return product;
			
		}
		

		
		
	}
	
	
}
