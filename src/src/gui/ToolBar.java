package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ToolBar extends JToolBar implements ActionListener{
	
	
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private MainWindow mainWindow;
	
	
	
	
	
	public ToolBar(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		beginComponents();
		addComponents();
	}




	private   void  beginComponents() {
		//añadirproducto
		btn1= new JButton("Añadir  producto");
		
		btn1= new JButton(new ImageIcon("resources/icons/comestibles.png"));	
		
		btn1.setMnemonic('A');		
		btn1.setActionCommand("Add");
		btn1.addActionListener(this);
		
		// añadir  cliente
		btn2= new JButton("Añadir cliente");		
		btn2= new JButton(new ImageIcon("resources/icons/colaboracion.png"));		
		btn2.setMnemonic('C');		
		btn2.setActionCommand("Add Cliente");
		btn2.addActionListener(this);
		
		
		
		
		//Añadir  factura
	
		
		btn3= new JButton("Añadir Factura");
		btn3= new JButton(new ImageIcon("resources/icons/factura.png"));
		btn3.setMnemonic('F');		
		btn3.setActionCommand("Add Bill");
		btn3.addActionListener(this);
		//Añadir  item
		btn4= new JButton("Añadir Item");
		btn4= new JButton(new ImageIcon("resources/icons/dieta.png"));
		btn4.setMnemonic('I');		
		btn4.setActionCommand("Add Item");
		btn4.addActionListener(this);
		
		//Listar Clientes
		btn5= new JButton("Listar Clientes");
		btn5= new JButton(new ImageIcon("resources/icons/prueba.png"));
		btn5.setMnemonic('L');		
		btn5.setActionCommand("List Client");
		btn5.addActionListener(this);
        //Listar Productos
		
		btn6= new JButton("Listar Productos");
		btn6= new JButton(new ImageIcon("resources/icons/tienda-online.png"));
		btn6.setMnemonic('P');		
		btn6.setActionCommand("List Product");
		btn6.addActionListener(this);

		btn7= new JButton("Consultar factura");
		btn7= new JButton(new ImageIcon("resources/icons/imagen.png"));
		btn7.setMnemonic('M');		
		btn7.setActionCommand("Query");
		btn7.addActionListener(this);
		
		btn8= new JButton("Imprimir Factura");
		btn8= new JButton(new ImageIcon("resources/icons/impresora.png"));
		btn8.setMnemonic('L');		
		btn8.setActionCommand("Print");
		btn8.addActionListener(this);
	}
	
	
	
	
	private void  addComponents() {
		
		this.add(btn1);
		
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		

		switch (e.getActionCommand()) {
		case "Add":mainWindow.showAddProduct();
			
			
			break;
			
		case "Add Cliente":mainWindow.showAddClient();
		
		
		break;
		
		case "Add Bill":mainWindow.showAddBill();
		
		
		break;
		case "Add Item":mainWindow.showAddDetail();
		
		
		break;
		case "List Client":mainWindow.showListClient();
		
		
		break;
		case "List Product":mainWindow.showListProducts();
		
		
		break;	
		
		
		case "Query":mainWindow.showQuery();
		
		
		break;

		case "Print":mainWindow.showBill();
		
		
		break;


		default:
			break;
		}
		
	}
	

}
