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
import javax.swing.SpinnerNumberModel;

import view.ActionsView;

public class ViewAddClient extends JInternalFrame implements ActionListener {
	
	
	private JTextField txtName;
	private JTextField txtxIdClient;
	private JButton accept;
	private JButton cancel;
	private ActionsView view;
	private MainWindow window;
	private JDesktopPane desktop;	
	private MainMenu mainMenu;
	private  ViewAddClient viewAddClient;
	
	

	public ViewAddClient(JDesktopPane desktop,MainWindow window) {
		super();
		this.window = window;
		this.desktop = desktop;
		setTitle("Agregar Cliente");
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
				gbc.insets=new Insets(15,15,0,0);
				add(new JLabel("Nombre: "),gbc);
				
				//cuadro de texto
				gbc.gridx=1;
				gbc.gridy=0;
				gbc.gridwidth=2;//une columnas
				gbc.weightx=1.0;//se estira				
				gbc.fill=GridBagConstraints.HORIZONTAL;
				gbc.insets=new Insets(15,15,0,180);				
				add(txtName,gbc);
				gbc.weightx=0;
				
				//texto 
				gbc.gridx=0;
				gbc.gridy=1;
				gbc.anchor=GridBagConstraints.WEST;
				gbc.insets=new Insets(2,0,0,0);
				add(new JLabel("identifiacion: "),gbc);
				
				//cuadro de texto
				gbc.gridx=1;
				gbc.gridy=1;		
				gbc.anchor=GridBagConstraints.WEST;
				gbc.fill=GridBagConstraints.HORIZONTAL;
				gbc.insets=new Insets(2,15,0,180);
				add(txtxIdClient,gbc);
		
				//aceptar
				
				gbc.gridx=0;
				gbc.gridy=6;
				gbc.anchor=GridBagConstraints.WEST;				
				gbc.insets=new Insets(10,140,15,0);
				gbc.fill=GridBagConstraints.CENTER;				
				add(accept,gbc);
				
				
				//cancelar
				gbc.gridx=2;
				gbc.gridy=6;
				gbc.fill=GridBagConstraints.EAST;
				gbc.insets=new Insets(10,100,15,0);				
				add(cancel,gbc);
				
		
		
		
	}

	private void beginComponents() {
		
		txtName=new JTextField();
		txtxIdClient=new JTextField();
		accept= new JButton("Aceptar");
		accept.setActionCommand(view.ADD_CLIENT);
		accept.addActionListener(window.getControll());
		cancel= new JButton("limpiar  campos");
		cancel.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                txtxIdClient.setText(null);
	                txtName.setText(null);
	                
	            }
	        } );
			
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	public JTextField getTxtName() {
		return txtName;
	}



	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}




	public JTextField getTxtxIdClient() {
		return txtxIdClient;
	}

	public void setTxtxIdClient(JTextField txtxIdClient) {
		this.txtxIdClient = txtxIdClient;
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
	
	
	
	
	

}
