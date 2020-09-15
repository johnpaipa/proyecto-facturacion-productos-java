package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import view.ActionsView;

public class MainMenu extends JMenuBar implements ActionListener{
	
	private JMenu clients;
	private JMenuItem addClient;
	private JMenuItem exit;
	private JMenu products;
	private JMenuItem addProdcuts;
	private JMenuItem listProducts;
	private JMenuItem listClients;
	private JMenu facts;
	private JMenuItem addItem;
	private JMenuItem addBill;
	private JMenuItem queryBill;
	private JMenuItem listBill;
	private JMenuItem CalTotalBill;
	private MainWindow window;
	private ViewAddProduct  view;
	
	
	public MainMenu(MainWindow window){
		
		this.window=window;
		beginComponents();
		addComponents();
		
	}
	
	private void beginComponents(){
		//clientes
		clients=new JMenu("Clientes");
		clients.setMnemonic('C');
		
		addClient=new JMenuItem("Adicionar");
		addClient.setIcon(new ImageIcon("resources/icons/colaboracion.png"));
		addClient.setMnemonic('A');
		addClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		addClient.setActionCommand("Add Client");
		addClient.addActionListener(this);
		
		//listar  clientes
		listClients=new JMenuItem("Listar Clientes");
		listClients.setIcon(new ImageIcon("resources/icons/prueba.png"));
		listClients.setMnemonic('O');
		listClients.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		listClients.setActionCommand("List CLient");
		listClients.addActionListener(this);
		
		
		
		//salir
		exit=new JMenuItem("Salir");
		exit.setIcon(new ImageIcon("resources/icons/exit.png"));
		exit.setMnemonic('x');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		exit.setActionCommand("exit");
		exit.addActionListener(this);
		
		
		//productos
		products=new JMenu("Productos");
		products.setMnemonic('P');		
		addProdcuts=new JMenuItem("Adicionar Productos");
		addProdcuts.setIcon(new ImageIcon("resources/icons/comestibles.png"));
		addProdcuts.setMnemonic('D');
		addProdcuts.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		addProdcuts.setActionCommand("Productos");
		addProdcuts.addActionListener(this);
		
		
		//listar
		listProducts=new JMenuItem("Listar Productos");
		listProducts.setIcon(new ImageIcon("resources/icons/tienda-online.png"));
		listProducts.setMnemonic('L');
		listProducts.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		listProducts.setActionCommand("Listar");
		listProducts.addActionListener(this);
		
		//facturas
		facts=new JMenu("Facturas");
		facts.setMnemonic('F');
		
		addItem=new JMenuItem("Adicionar Item");
		addItem.setIcon(new ImageIcon("resources/icons/dieta.png"));
		addItem.setMnemonic('I');
		addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		addItem.setActionCommand("Item");
		addItem.addActionListener(this);
	
		
		addBill=new JMenuItem("Adicionar Factura");
		addBill.setIcon(new ImageIcon("resources/icons/factura.png"));
		addBill.setMnemonic('J');
		addBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		addBill.setActionCommand("Fac");
		addBill.addActionListener(this);
		
		//listar facturas
		listBill=new JMenuItem("Listar  Facturas");
		listBill.setIcon(new ImageIcon("resources/icons/factura.png"));
		listBill.setMnemonic('J');
		listBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		listBill.setActionCommand("List Facts");
		listBill.addActionListener(this);
		
		
		queryBill=new JMenuItem("Consultar Factura");
		queryBill.setIcon(new ImageIcon("resources/icons/imagen.png"));;
		queryBill.setMnemonic('S');
		queryBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		queryBill.setActionCommand("Search");
		queryBill.addActionListener(this);
		
		
		CalTotalBill=new JMenuItem("Imprimir Factura");
		CalTotalBill.setIcon(new ImageIcon("resources/icons/impresora.png"));
		CalTotalBill.setMnemonic('T');
		CalTotalBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK));
		CalTotalBill.setActionCommand("Print");
		CalTotalBill.addActionListener(this);
		
	}
	
	private void addComponents(){
		
		clients.add(addClient);
		clients.addSeparator();
		clients.add(exit);
		clients.add(listClients);
		this.add(clients);
		
		
		
		products.add(addProdcuts);
		products.addSeparator();
		products.add(listProducts);
		products.addSeparator();
		products.add(exit);
		this.add(products);
		
		
		
		
		facts.add(addBill);
		facts.addSeparator();
		facts.add(addItem);
		facts.addSeparator();
		facts.add(queryBill);
		facts.addSeparator();
		facts.add(listBill);
		facts.addSeparator();
		facts.add(CalTotalBill);
		facts.addSeparator();
		facts.add(exit);
		this.add(facts);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		
		case"exit":window.exit();
		break;
		
		
		case"Add Client":window.showAddClient();
		break;
		
		case"Productos":window.showAddProduct();
		
		break;
		
		
		case"Fac":window.showAddBill();
		
		break;
		
		case"Item":window.showAddDetail();
		
		break;
		case"List CLient":window.showListClient();
		
		break;
		case"Listar":window.showListProducts();
		
		break;
		
		case"List Facts":window.showListBills();
		
		break;
		
		case"Search":window.showQuery();
		
		break;
		case"Print":window.showBill();
		
		break;
		
	
		
		}
		
		
	}

}
