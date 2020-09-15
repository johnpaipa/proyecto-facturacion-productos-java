package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import view.ActionsView;

public class ViewAddProduct extends JInternalFrame implements ActionListener {
	
	private JTextField txtId;
	private JTextField txtDescription;
	private JTextField txtValue;
	private  JSpinner stock;
	private  JSpinner stockMin;
	private  JComboBox iva;
	private JButton accept;
	private JButton cancel;
	private ActionsView view;
	private MainWindow window;
	private JDesktopPane desktop;	
	private MainMenu mainMenu;
	private ViewAddProduct viewAddProduct;
	String[] aux = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","30"};
	
	

	public ViewAddProduct(JDesktopPane desktop,MainWindow window) {
		
		this.window=window;
		this.desktop=desktop;
		setTitle("Agregar Producto");
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
	//private

	private void addComponents() {
		
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		add(new JLabel("Nit"),gbc);
		
		gbc.gridy=0;
		gbc.gridwidth=2;//unir columnas
		gbc.gridx=1;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtId,gbc);
		gbc.weightx=0;
		
		
		
		//Descripcion
		gbc.gridy=0;
		gbc.gridx=4;
		add(new JLabel("Descripcion"),gbc);
		gbc.gridwidth=0;
		gbc.gridy=0;
		gbc.gridx=6;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtDescription,gbc);
		gbc.weightx=0;
		
		//value
		gbc.gridwidth=2;//unodoscolumnas   para   value
		gbc.gridy=1;
		gbc.gridx=0;		
		add(new JLabel("Value"),gbc);
		gbc.gridwidth=2;
		gbc.gridy=1;
		gbc.gridx=2;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtValue,gbc);		
		gbc.weightx=0;
		
		
		
		//iva
		       gbc.gridwidth=0;	
				gbc.gridy=1;
				gbc.gridx=3;				
				add(new JLabel("Iva"),gbc);
				gbc.gridwidth=0;				
				gbc.gridy=1;
				gbc.gridx=6;
				gbc.weightx=0.0;
				gbc.fill=GridBagConstraints.HORIZONTAL;
				add(iva,gbc);
				gbc.weightx=0;
				
				
		//stock
				    gbc.gridwidth=2;	
					gbc.gridy=2;
					gbc.gridx=0;				
					add(new JLabel("stock"),gbc);
					gbc.gridwidth=2;				
					gbc.gridy=2;
					gbc.gridx=2;
					gbc.weightx=1.0;					
					gbc.fill=GridBagConstraints.HORIZONTAL;
					add(stock,gbc);
					gbc.weightx=0;
					
		// stock min  
					
					    
					    gbc.gridwidth=2;	
						gbc.gridy=2;
						gbc.gridx=3;				
						add(new JLabel("stockMin"),gbc);
						gbc.gridwidth=2;				
						gbc.gridy=2;
						gbc.gridx=5;
						gbc.weightx=0.0;					
						gbc.fill=GridBagConstraints.HORIZONTAL;
						add(stockMin,gbc);
						gbc.weightx=0;
						
	  //aceptar	
						 
							gbc.gridwidth=3;				
							gbc.gridy=3;
							gbc.gridx=0;
							gbc.weightx=0.0;					
							gbc.fill=GridBagConstraints.CENTER;
							add(accept,gbc);
							gbc.weightx=0;	
		//cancelar
							

							gbc.gridwidth=6;				
							gbc.gridy=3;
							gbc.gridx=2;
							gbc.weightx=0.0;					
							gbc.fill=GridBagConstraints.CENTER;
							add(cancel,gbc);
							gbc.weightx=0;	
	}

	private void beginComponents() {
		txtId=new JTextField();
		txtDescription=new JTextField();
		txtValue=new JTextField();
		
		
		
		  SpinnerNumberModel nm = new SpinnerNumberModel(1,1,100,1);
	               
		iva= new JComboBox(aux);
		stock= new JSpinner();
		stock.setModel(nm);
		SpinnerNumberModel model=new SpinnerNumberModel(1,1,100,1);	
		stockMin= new JSpinner();
		stockMin.setModel(model);
		accept= new JButton("Aceptar");
		accept.setActionCommand(view.ADD_PRODUCT);
		accept.addActionListener(window.getControll());
		
		cancel= new JButton("Limpiar");
		cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText(null);
                txtDescription.setText(null);
                txtValue.setText(null);
                iva.setSelectedItem(null);
                stock.setValue(1);
                stockMin.setValue(1);
          
                
                
            }
        } );
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Aceptar":
			System.out.println("PRODUCTO AÑADIDO EXITOSAMENTE");
			
			break;

		default:
			break;
		}
		
	}
	
	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(JTextField txtDescription) {
		this.txtDescription = txtDescription;
	}

	public JTextField getTxtValue() {
		return txtValue;
	}

	public void setTxtValue(JTextField txtValue) {
		this.txtValue = txtValue;
	}

	public JSpinner getStock() {
		return stock;
	}

	public void setStock(JSpinner stock) {
		this.stock = stock;
	}

	public JSpinner getStockMin() {
		return stockMin;
	}

	public void setStockMin(JSpinner stockMin) {
		this.stockMin = stockMin;
	}

	public JComboBox getIva() {
		return iva;
	}

	public void setIva(JComboBox iva) {
		this.iva = iva;
	}

	public JButton getAccept() {
		return accept;
	}

	public void setAccept(JButton accept) {
		this.accept = accept;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public ActionsView getView() {
		return view;
	}

	public void setView(ActionsView view) {
		this.view = view;
	}

	public MainWindow getWindow() {
		return window;
	}

	public void setWindow(MainWindow window) {
		this.window = window;
	}

	public JDesktopPane getDesktop() {
		return desktop;
	}

	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public ViewAddProduct getViewAddProduct() {
		return viewAddProduct;
	}

	public void setViewAddProduct(ViewAddProduct viewAddProduct) {
		this.viewAddProduct = viewAddProduct;
	}

	public String[] getAux() {
		return aux;
	}

	public void setAux(String[] aux) {
		this.aux = aux;
	}
	

	
	
	
	
	

}
