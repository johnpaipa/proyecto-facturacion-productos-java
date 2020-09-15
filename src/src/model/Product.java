package model;

public class Product {
	
	
	private String idProduct,description;
	private double value;
	private short stock;
	private byte stockMin;
	private float iva;
	
	
	public Product() {
		
	}
	
	public Product(String idProduct, String description, double value, short stock, byte stockMin, float iva) {
		super();
		this.idProduct = idProduct;
		this.description = description;
		this.value = value;
		this.stock = stock;
		this.stockMin = stockMin;
		this.iva = iva;
	}
	
	
	
	

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public short getStock() {
		return stock;
	}

	public void setStock(short stock) {
		this.stock = stock;
	}

	public byte getStockMin() {
		return stockMin;
	}

	public void setStockMin(byte stockMin) {
		this.stockMin = stockMin;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}
	
	
	public double calcValue() {
		
		return 0.0;
		
	}
	
	
	

}
