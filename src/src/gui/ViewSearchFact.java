package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.ActionsView;

public class ViewSearchFact extends JInternalFrame implements ActionListener{
	
	private JTextField txtNumber;
	private JDesktopPane desktop;
	private JButton validar;
	private JButton limpiar;
	private MainWindow window;
	
	public ViewSearchFact(JDesktopPane desktop,MainWindow window){
		this.desktop=desktop;
		this.window=window;
		setTitle("Buscar Facturas");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setSize(420, 360);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setLayout(new GridBagLayout());
		beginComponents();
		addComponents();
		this.pack();
		desktop.add(this);
	}

	private void beginComponents() {
		txtNumber=new JTextField();
		validar=new JButton("ACEPTAR");
		validar.setActionCommand(ActionsView.LIST_BILL);
		validar.addActionListener(window.getControll());
		
		limpiar = new JButton("Limpiar");
		limpiar.setActionCommand("Limpiar");
		limpiar.addActionListener(this);
		
	}

	private void addComponents() {
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		add(new JLabel("Id cliente"), gbc);
		gbc.gridx=1;
		gbc.gridwidth=2;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtNumber,gbc);
		
		gbc.weightx=0;
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(validar,gbc);
		
		gbc.weightx = 0;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(limpiar, gbc);
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Limpiar":
		txtNumber.setText(null);
		break;
		}
	}

	public JTextField getTxtNumber() {
		return txtNumber;
	}

	public void setTxtNumber(JTextField txtNumber) {
		this.txtNumber = txtNumber;
	}

	public JButton getValidar() {
		return validar;
	}

	public void setValidar(JButton validar) {
		this.validar = validar;
	}

	public JButton getLimpiar() {
		return limpiar;
	}

	public void setLimpiar(JButton limpiar) {
		this.limpiar = limpiar;
	}

	public MainWindow getWindow() {
		return window;
	}

	public void setWindow(MainWindow window) {
		this.window = window;
	}

}
