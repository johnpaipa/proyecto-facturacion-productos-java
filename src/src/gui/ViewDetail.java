package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ManagementBilling;
import view.ActionsView;

public class ViewDetail extends JInternalFrame {
	
	
	private JButton btnAccept;
	private JButton btnClean;
	private JTextField txtIdClient;
	private JTextField txtNumFact;
	private ActionsView view;
	private MainWindow window;
	private ViewAddBill viewAddBill;
	private JDesktopPane desktop;
	private JLabel lbl;
	
	ManagementBilling mng=new ManagementBilling();
	

	public ViewDetail(JDesktopPane desktop,MainWindow window) {
		
		this.window=window;
		this.desktop=desktop;
		setTitle("Consultar Factura");
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
					gbc.insets=new Insets(20,15,0,10);
					add(new JLabel("ID Cliente: "),gbc);
					
					//cuadro de texto
					gbc.gridx=1;
					gbc.gridy=0;
					gbc.gridwidth=2;//une columnas
					gbc.weightx=1.0;//se estira				
					gbc.fill=GridBagConstraints.HORIZONTAL;
					gbc.insets=new Insets(20,20,0,100);				
					add(txtIdClient,gbc);
					gbc.weightx=0;
					
					

					//texto 
							gbc.gridx=0;
							gbc.gridy=1;		
							gbc.anchor=GridBagConstraints.WEST;
							gbc.insets=new Insets(20,15,0,10);
							add(new JLabel("Id de  Factura: "),gbc);
							
							//cuadro de texto
							gbc.gridx=1;
							gbc.gridy=1;
							gbc.gridwidth=2;//une columnas
							gbc.weightx=1.0;//se estira				
							gbc.fill=GridBagConstraints.HORIZONTAL;
							gbc.insets=new Insets(20,20,0,100);				
							add(txtNumFact,gbc);
							gbc.weightx=0;
					
					
					//aceptar
					
					gbc.gridx=0;
					gbc.gridy=6;
					gbc.anchor=GridBagConstraints.WEST;				
					gbc.insets=new Insets(30,250,15,0);
					gbc.fill=GridBagConstraints.CENTER;				
					add(btnAccept,gbc);
					
					//limpiar
					gbc.gridx=2;
					gbc.gridy=6;
					gbc.fill=GridBagConstraints.EAST;
					gbc.insets=new Insets(30,20,15,50);				
					add(btnClean,gbc);
			
		}
		
		private void beginComponents() {
			
			
			txtIdClient=new JTextField();
			txtNumFact=new JTextField();
			btnAccept= new JButton("Aceptar");
			btnAccept.setActionCommand(view.QUERY_BILL);
			btnAccept.setEnabled(false);
			btnAccept.addActionListener(window.getControll());
			btnClean= new JButton("Limpiar");
			btnClean.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                txtIdClient.setText(null);
	                txtNumFact.setText(null);
	                
	            }
	        } );
			lbl=new JLabel();
			
			txtIdClient.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
		
				
					@Override
					public void keyReleased(KeyEvent e) {
						
						String t=txtIdClient.getText();
						lbl.setText(t);
						
							try{
							
								if(window.getControll().mngBill.findClient(t)!=null){
									
				
									btnAccept.setEnabled(true);
									
								}else{
									
				
									btnAccept.setEnabled(false);
									
								}
								
							}catch(NullPointerException exc){
								
								
								
								
							}
					}
					
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		
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
		
		

}
