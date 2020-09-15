package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.ActionsView;

public class ViewBill extends JInternalFrame implements ActionListener {
	private JButton btnAccept;
	private JButton btnClean;
	private JTextField txtIdClient;
	private JTextField txtNumFact;
	private JTextField txtIva;
	private JTextField txtValorneto;
	private JTextField txtValorTotal;
	private ActionsView view;
	private MainWindow window;
	private ViewAddBill viewAddBill;
	private JDesktopPane desktop;
	
public ViewBill(JDesktopPane desktop,MainWindow window) {
		
		this.window=window;
		this.desktop=desktop;
		setTitle("Añadir Factura");
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
	
	
	//texto 
			gbc.gridx=0;
			gbc.gridy=0;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(0,15,0,10);
			add(new JLabel("ID Cliente: "),gbc);
			
			//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=0;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(0,0,0,50);				
			add(txtIdClient,gbc);
			gbc.weightx=0;
			
			//texto 
			gbc.gridwidth=2;
			gbc.gridx=3;
			gbc.gridy=0;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(0,15,0,10);
			add(new JLabel("Numero factura: "),gbc);
			
			//cuadro de texto
			gbc.gridx=5;
			gbc.gridy=0;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(0,15,0,10);
			add(txtNumFact,gbc);
			gbc.weightx=0;
			
			//texto 
			gbc.gridwidth=2;
			gbc.gridx=0;
			gbc.gridy=1;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(0,15,0,10);
			add(new JLabel("iva: "),gbc);
			
			//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=1;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(10,15,0,10);	
			txtIva.setEditable(false);
			add(txtIva,gbc);
			gbc.weightx=0;
			
			
			
			
			//texto 
			gbc.gridwidth=2;
			gbc.gridx=0;
			gbc.gridy=2;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(10,15,0,10);
			add(new JLabel("Valor Neto: "),gbc);
			
			//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=2;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(10,15,0,10);
			txtValorneto.setEditable(false);
			add(txtValorneto,gbc);
			gbc.weightx=0;
			
			
			//texto 
			gbc.gridwidth=2;
			gbc.gridx=0;
			gbc.gridy=3;		
			gbc.anchor=GridBagConstraints.WEST;
			gbc.insets=new Insets(10,15,0,10);
			add(new JLabel("Valor Total: "),gbc);
			
			//cuadro de texto
			gbc.gridx=1;
			gbc.gridy=3;
			gbc.gridwidth=2;//une columnas
			gbc.weightx=1.0;//se estira				
			gbc.fill=GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(10,15,0,10);
			txtValorTotal.setEditable(false);
			add(txtValorTotal,gbc);
			gbc.weightx=0;
			
			//aceptar
			
			gbc.gridx=0;
			gbc.gridy=5;
			gbc.anchor=GridBagConstraints.WEST;				
			gbc.insets=new Insets(10,50,0,0);
			gbc.fill=GridBagConstraints.CENTER;				
			add(btnAccept,gbc);
			//Clean
			
			gbc.gridx=2;
			gbc.gridy=5;
			gbc.anchor=GridBagConstraints.WEST;				
			gbc.insets=new Insets(10,30,0,20);
			gbc.fill=GridBagConstraints.CENTER;				
			add(btnClean,gbc);
			
			
	
	
	
}
	
private void beginComponents() {
	
	
	txtNumFact=new JTextField();
	txtIdClient=new JTextField();
	txtValorneto=new JTextField();
	txtValorTotal=new JTextField();
	txtIva=new JTextField();
	btnAccept= new JButton("Aceptar");
	btnAccept.setActionCommand(view.CALFACT);
	btnAccept.addActionListener(window.getControll());
	btnClean= new JButton("limpiar  campos");
	btnClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtIdClient.setText(null);
                txtNumFact.setText(null);
                
            }
        } );
	
	
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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


	public JTextField getTxtIdClient() {
		return txtIdClient;
	}


	public void setTxtIdClient(JTextField txtIdClient) {
		this.txtIdClient = txtIdClient;
	}


	public JTextField getTxtNumFact() {
		return txtNumFact;
	}


	public void setTxtNumFact(JTextField txtNumFact) {
		this.txtNumFact = txtNumFact;
	}


	public JTextField getTxtIva() {
		return txtIva;
	}


	public void setTxtIva(JTextField txtIva) {
		this.txtIva = txtIva;
	}


	public JTextField getTxtValorneto() {
		return txtValorneto;
	}


	public void setTxtValorneto(JTextField txtValorneto) {
		this.txtValorneto = txtValorneto;
	}


	public JTextField getTxtValorTotal() {
		return txtValorTotal;
	}


	public void setTxtValorTotal(JTextField txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}
	
	

}
