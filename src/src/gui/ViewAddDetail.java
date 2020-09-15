package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.ControllBilling;
import model.Client;
import model.Product;
import view.ActionsView;

public class ViewAddDetail extends JInternalFrame implements ActionListener {

	private ControllBilling controll;
	private JTextField txtIdProduct;
	private JTextField txtIdClient;
	private JTextField txtIdFact;
	private  JSpinner cant;
	private JButton btnAccept;
	private JButton btnClean;
	private JComboBox<String> jcmbProducts;
	private JComboBox<String> jcbIdClientBill;
	private MainWindow window;
	private JDesktopPane desktop;	
	private MainMenu mainMenu;
	private ActionsView view;
	private  ViewAddDetail viewAddDetail;
	private ArrayList<Product> pro;
	private ArrayList<Client> clie;
	
	
	
	

	public ViewAddDetail(JDesktopPane desktop,MainWindow window,ArrayList<Product> pro,ArrayList<Client> clie) {
		super();
		this.clie=clie;
		this.pro=pro;
		this.window = window;
		this.desktop = desktop;
		setTitle("AñadirProducto a  factura");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);//maximizar ventana
		setIconifiable(true);
		setLayout(new GridBagLayout());
		beginComponents();
		addComponents();
		this.pack();//ajuste  al contenedor
		desktop.add(this);
	}
	
	
	
	private void addComponents() {
		
		GridBagConstraints gbc= new GridBagConstraints();
		
		/*
		
		//texto 
			gbc.gridx=0;
			gbc.gridy=0;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(15,110,0,0);
		    add(new JLabel("Id  cliente: "),gbc);
							
				//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=0;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
		    gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(15,10,0,200);				
			add(txtIdClient,gbc);
			gbc.weightx=0;
							
				
		gbc.gridx=0;
		gbc.gridy=1;		
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.insets=new Insets(15,100,0,0);
		add(new JLabel("Id Producto: "),gbc);
		
		//cuadro de texto
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=2;//une columnas
		gbc.weightx=1.0;//se estira				
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets=new Insets(15,10,0,200);				
		add(txtIdProduct,gbc);
		gbc.weightx=0;*/
		

		//texto numero de factura
		gbc.gridx=0;
		gbc.gridy=0;		
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(15,100,0,0);
		add(new JLabel("Numero de Factura: "),gbc);
		
		//Combo box id de cliente con factura
		gbc.gridx=1;
		gbc.gridy=0;		
		gbc.anchor=GridBagConstraints.WEST;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets=new Insets(15,10,0,100);
		add(jcbIdClientBill,gbc);
		
		//texto nombre producto
		gbc.gridx=0;
		gbc.gridy=2;		
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(15,100,0,0);
		add(new JLabel("Producto: "),gbc);
		
		//Combo box nombres productos
		gbc.gridx=1;
		gbc.gridy=2;		
		//gbc.anchor=GridBagConstraints.WEST;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets=new Insets(15,10,0,100);
		add(jcmbProducts,gbc);
		
		//texto 
		gbc.gridx=0;
		gbc.gridy=3;		
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(15,110,0,0);
		add(new JLabel("Cantidad: "),gbc);
		
		//cuadro de texto
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.gridwidth=2;//une columnas
		gbc.weightx=1.0;//se estira				
		gbc.fill=GridBagConstraints.CENTER;
		gbc.insets=new Insets(15,10,0,200);				
		add(cant,gbc);
		gbc.weightx=0;
		
		
		/*

		//texto 
			gbc.gridx=0;
			gbc.gridy=3;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(15,110,0,0);
		    add(new JLabel("Id Factura: "),gbc);
							
				//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=3;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
		    gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(15,10,0,200);				
			add(txtIdFact,gbc);
			gbc.weightx=0;*/
			


		//aceptar
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.anchor=GridBagConstraints.WEST;				
		gbc.insets=new Insets(15,150,0,0);
		gbc.fill=GridBagConstraints.CENTER;				
		add(btnAccept,gbc);
		
		//limpiar
		gbc.gridx=1;
		gbc.gridy=6;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.fill=GridBagConstraints.CENTER;
		gbc.insets=new Insets(15,10,0,0);				
		add(btnClean,gbc);

		
	}
	
	public JTextField getTxtIdFact() {
		return txtIdFact;
	}



	public void setTxtIdFact(JTextField txtIdFact) {
		this.txtIdFact = txtIdFact;
	}



	private void beginComponents() {
		
		
		String[] aux =new String[pro.size()];
	for (int j = 0; j < pro.size(); j++) {
			
			aux[j]=pro.get(j).getdescription()+" - "+pro.get(j).getIdProduct();;
		
			
		}
	

	int m=0;
	for (int j = 0; j < clie.size(); j++) {
		
		for (int k = 0; k < clie.get(j).getBills().size(); k++) {
			
			m++;
			
		}

		m++;
	}
	

	String[] aux2 =new String[m-clie.size()];
	
	int i=0;
	
	for (int j = 0; j < clie.size(); j++) {
		
		for (int k = 0; k < clie.get(j).getBills().size(); k++) {
			
			aux2[i]="Id Cliente: "+clie.get(j).getId()+" / Numero Factura: "+clie.get(j).getBills().get(k).getNumber();
			
			i++;
			
		}

		
	}
	
	
		jcbIdClientBill=new JComboBox(aux2);		
		jcmbProducts=new JComboBox(aux);
		txtIdProduct=new JTextField();	
		txtIdClient=new JTextField();	
		txtIdFact=new JTextField();
		btnAccept= new JButton("Aceptar");
		btnAccept.setActionCommand(view.ADD_ITEM);
		btnAccept.addActionListener(window.getControll());
		btnClean= new JButton("Limpiar");
		btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIdClient.setText(null);
                jcbIdClientBill.setSelectedItem(null);
                jcmbProducts.setSelectedItem(null);
                cant.setValue(1);
                
            }
        } );
		SpinnerNumberModel model=new SpinnerNumberModel(1,1,100,1);	
		cant= new JSpinner(model);
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	public JComboBox<String> getJcbIdClientBill() {
		return jcbIdClientBill;
	}



	public void setJcbIdClientBill(JComboBox<String> jcbIdClientBill) {
		this.jcbIdClientBill = jcbIdClientBill;
	}



	public JComboBox<String> getJcmbProducts() {
		return jcmbProducts;
	}



	public void setJcmbProducts(JComboBox<String> jcmbProducts) {
		this.jcmbProducts = jcmbProducts;
	}



	public JTextField getTxtIdProduct() {
		return txtIdProduct;
	}



	public void setTxtIdProduct(JTextField txtIdProduct) {
		this.txtIdProduct = txtIdProduct;
	}



	



	public JTextField getTxtIdClient() {
		return txtIdClient;
	}



	public void setTxtIdClient(JTextField txtIdClient) {
		this.txtIdClient = txtIdClient;
	}



	public JButton getBtnAccept() {
		return btnAccept;
	}



	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}



	public JButton getBtnClean() {
		return btnClean;
	}



	public void setBtnClean(JButton btnClean) {
		this.btnClean = btnClean;
	}



	public JDesktopPane getDesktop() {
		return desktop;
	}



	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}



	public JSpinner getCant() {
		return cant;
	}



	public void setCant(JSpinner cant) {
		this.cant = cant;
	}
	
	

}
