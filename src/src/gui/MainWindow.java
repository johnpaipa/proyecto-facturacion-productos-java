package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.xml.soap.Detail;

import controller.ControllBilling;
import model.Bill;
import model.Client;
import model.Product;
import view.ActionsView;

public class MainWindow extends JFrame implements ActionsView{
	
	private ControllBilling controll;
	private JDesktopPane jDesk;
	private JInternalFrame jIntFam;
	private JDesktopPane desktop;
	private MainWindow mainWindow;
	private MainMenu mainMenu;
	private ViewAddProduct viewAddProduct;
	private ViewAddClient viewAddClient;
	private ViewAddBill viewAddBill;
	private ViewAddDetail viewAddDetail;
	private ViewListClient viewListClient;
	private ViewListProducts viewListProduct;
	private ViewListFacts  viewListBill;
	private ViewSearchFact  viewSearch;
	private ViewBill viewBill;
	private ViewDetail viewDetail;
	private ViewDetailBill viewDetailBill;
	private WindowList windowLis;
	private ToolBar toolbar;
	private ActionsView view;
	private ArrayList<Client> clients;
	
	
	
	
	public MainWindow(){
		

		
		setTitle("Sistema de Facturacion");
		setSize(new Dimension(640,480));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		cerrar();
		
		
		
	}
	
	
	
	
	private void beginComponents(){
		
		mainMenu=new MainMenu(this);
		
	    desktop=new JDesktopPane();
        viewAddProduct= new ViewAddProduct(desktop,this);
        toolbar=new ToolBar(this);
		
		
		viewAddClient=new ViewAddClient(desktop, this);
		viewAddBill=new ViewAddBill(desktop, this);
		//viewAddDetail=new ViewAddDetail(desktop, this,controll.mngBill.getProducts());
		viewBill=new  ViewBill(desktop, this);
		viewSearch=new  ViewSearchFact(desktop, this);
		viewDetail=new  ViewDetail(desktop, this);
		
		
		windowLis=new WindowList(controll.mngBill.getProducts());
		//viewListClient=new ViewListClient(desktop,this,controll.mngBill.getClients());
		
	}
	
	
	private void addComponents(){
	
		
		this.add(desktop,BorderLayout.CENTER);
		
		this.setJMenuBar(mainMenu);
		this.add(toolbar,BorderLayout.NORTH);
		
		
	}
	
	private boolean validateFields() {
		
		 
		
		if(viewAddProduct.getTxtId().getText().length()==0) {
			
			return false;
		}
		else if(viewAddProduct.getTxtDescription().getText().length()==0) {
			return false;
		}
		else if(viewAddProduct.getTxtValue().getText().length()==0) {
			
			return false;
		}
		else if(viewAddProduct.getIva().getSelectedItem().toString().length()==0) {
			
			return false;
		}
		else if(viewAddProduct.getStock().getValue().toString().length()==0) {
			
			return false;
		}
	  else if(viewAddProduct.getStockMin().getValue().toString().length()==0) {
			
			return false;
		}
	  
		
		return true;
	}
	
	private boolean validateFieldsClient() {
	
	
	 if(viewAddClient.getTxtName().getText().length()==0) {
			return false;
		}
	  else if(viewAddClient.getTxtxIdClient().getText().length()==0) {
			return false;
		}
	 
	return true;
	}
	
	

	private boolean validateFieldsCaclFact() {
		
		 if(viewBill.getTxtIdClient().getText().length()==0) {
				return false;
			}
		 if(viewBill.getTxtNumFact().getText().length()==0) {
				return false;
			}
		
		return true;
	}
	
	private boolean validateFieldsSearch() {
		
		 if(viewSearch.getTxtNumber().getText().length()==0) {
				return false;
			}
		
		return true;
	}
	
	
	
	
	private boolean validateFieldsDetail() {
		
		 if(viewDetail.getTxtIdClient().getText().length()==0) {
				return false;
			}
		
		return true;
	}
	
	
	
	
	private boolean validateFieldsBill() {
		
		 if(viewAddBill.getTxtIdClient().getText().length()==0) {
				return false;
		}
		
		return true;
	}

	private boolean validateFieldsItem() {
		
		 if(viewAddDetail.getTxtIdProduct().getText().length()==0) {
				return false;
			}
		 
		 else if(viewAddDetail.getCant().getValue().toString().length()==0) {
			 
			 return false;
			 
		 }
		 else if(viewAddDetail.getTxtIdClient().getText().length()==0) {
			 
			 return false;
			 
		 }
		 else if(viewAddDetail.getTxtIdFact().getText().length()==0) {
			 
			 return false;
			 
		 }
		
		return true;
	}
	
	
	@Override
	public String[] readInput(String option) {
		
		
		if (validateFields()|| validateFieldsClient()|| validateFieldsBill()|| validateFieldsCaclFact()|| validateFieldsSearch()) {
			
			switch (option) {
			case ActionsView.ADD_PRODUCT: return readProduct();	
			
			case ActionsView.ADD_CLIENT: return readClient();	
			case ActionsView.ADD_BILL: return readBill();
			case ActionsView.ADD_ITEM:return readItem();
			case ActionsView.CALFACT:return readCalFact();
			case ActionsView.LIST_BILL:return readSearch();
			case ActionsView.QUERY_BILL:return readDetailBills();


			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Campos Vacios","Error",JOptionPane.ERROR_MESSAGE);
			
		}
		return null;
	}
	
	
private String[] readCalFact() {
	
	String id= viewBill.getTxtIdClient().getText();
	String numFact=viewBill.getTxtNumFact().getText();
	String valorNeto=viewBill.getTxtValorneto().getText();
	String iva=viewBill.getTxtIva().getText();
	String valorTotal=viewBill.getTxtValorTotal().getText();
	
	Double auxili2=controll.mngBill.findClient(id).findBill(numFact).calcAssessment();
	viewBill.getTxtIva().setText(auxili2.toString());
	
	Double auxili=controll.mngBill.findClient(id).findBill(numFact).calcExempt();
	viewBill.getTxtValorneto().setText(auxili.toString());
	
	Double auxili3=controll.mngBill.findClient(id).findBill(numFact).calcTotal();
	viewBill.getTxtValorTotal().setText(auxili3.toString());
	
	

	
	String []dates=  new String[] {id,numFact,iva,valorNeto,valorTotal};
	
		return dates;
	}




private String[] readItem() {
		
		String aux=(String) viewAddDetail.getJcmbProducts().getSelectedItem();
		String id=aux.substring(aux.indexOf("-")+2);
		//String id= viewAddDetail.getTxtIdProduct().getText();
		String aux2=(String) viewAddDetail.getJcbIdClientBill().getSelectedItem();
		String idClient=aux2.substring(12, aux2.indexOf("/")-1);
		
		String aux3=(String) viewAddDetail.getJcbIdClientBill().getSelectedItem();
		String idFact=aux3.substring(aux3.indexOf("/")+18);
		
		
		String cant=viewAddDetail.getCant().getValue().toString();
		//String idClient=viewAddDetail.getTxtIdClient().getText();
		//String idFact=viewAddDetail.getTxtIdFact().getText();
		String []dates=  new String[] {id,idClient,idFact,cant};
		
		
		return dates;
		
	}
	
	
	private String[] readBill() {
		System.out.println("ok");
		
		String id= viewAddBill.getTxtIdClient().getText();
		String []dates=  new String[] {id};
		System.out.println(id);
		
		return dates;
		
	}
	
	private String[] readClient() {
		
		String name= viewAddClient.getTxtName().getText();
		String id= viewAddClient.getTxtxIdClient().getText();
		String []dates=  new String[] {name,id};
		
		
		
		return dates;
	}

	private String[] readProduct() { 
		String id=viewAddProduct.getTxtId().getText();
		String description= viewAddProduct.getTxtDescription().getText();
		String value= viewAddProduct.getTxtValue().getText();
		String iva= viewAddProduct.getIva().getSelectedItem().toString();
		String stock= viewAddProduct.getStock().getValue().toString();
		String stockMin=viewAddProduct.getStockMin().getValue().toString();
		
		
		String[]dates=new String[] {id,description,value,stock,stockMin,iva};
		
		return dates;
	}
	
	private String[] readSearch() {
		
		String id=viewSearch.getTxtNumber().getText();
		
		String[]dates=new String[] {id};
		viewListBill=new ViewListFacts(desktop,this,(controll.mngBill.findClient(id).getBills()));
		viewListBill.setVisible(true);
		
		return  dates;
	}
	
	
private String[] readDetailBills() {
		
		String id=viewDetail.getTxtIdClient().getText();
		String number=viewDetail.getTxtNumFact().getText();
		
		String[]dates=new String[] {id,number};
		viewDetailBill=new ViewDetailBill(desktop,this,controll.mngBill.findClient(id).findBill(number).getDetails());
		viewDetailBill.setVisible(true);
		
		return  dates;
	}

	
	public void   cerrar() {
		
		
		
		try {
			
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				
				public  void windowClosing(WindowEvent e) {
					
					exit();
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



	@Override
	public void writeOutPut(String Option, boolean status, String... output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControll(ControllBilling controll) {
		
		this.controll=controll;
		
	}

	public ControllBilling getControll() {
		
		return controll;
	}


	@Override
	public void begin() {
		
		
		beginComponents();
		addComponents();
		this.setVisible(true);
		
		
	}

	@Override
	public void exit() {
		int exit=JOptionPane.showConfirmDialog(null,"Desea salir?","SALIR",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(exit==JOptionPane.YES_OPTION) {
		System.exit(0);
		}
		
	}

	@Override
	public void listProducts(ArrayList<Product> products) {
		// TODO Auto-generated method stub
		
	}
	public  void showBill() {
		
		viewBill.setVisible(true);
	}



	public void showAddDetail() {
		viewAddDetail=new ViewAddDetail(desktop, this,controll.mngBill.getProducts(),controll.mngBill.getClients());
		viewAddDetail.setVisible(true);
		
	}

		
	

	public void showAddClient() {
		
		viewAddClient.setVisible(true);
		
		
	}


	public void showAddProduct() {
	viewAddProduct.setVisible(true);
	
	}
	
	public void showAddBill() {
		
		
		viewAddBill.setVisible(true);
		
	}
	
	
	public  void  showListBills() {
	
		viewSearch.setVisible(true);
		

		
	}
	public  void  showQuery() {
		
		viewDetail.setVisible(true);
		

		
	}
	
	


	public void showListClient() {
		
		viewListClient=new ViewListClient(desktop,this,controll.mngBill.getClients());
		viewListClient.setVisible(true);

	}

	public void showListProducts() {
		
		viewListProduct=new ViewListProducts(desktop,this,controll.mngBill.getProducts());
		viewListProduct.setVisible(true);

	}


	@Override
	public void addItem() {
		System.out.println("Añadiendo Item");
		
	}




	@Override
	public void queryBill() {
		
		
		
		System.out.println("Consultando factura");
	}




	@Override
	public void addBill() {
		// TODO Auto-generated method stub
		
	}

 @Override
 public void listClients(ArrayList<Client> clients) {
		
}




@Override
public void listBill(ArrayList<Bill> bills) {
	/*S
	
	String []dates=  new String[] {id};
	viewListBill=new ViewListFacts(desktop,this,(controll.mngBill.findClient(id).getBills()));
	viewListBill.setVisible(true);
	*/
}




@Override
public void listDetail(ArrayList<model.Bill.Detail> arrayList) {
	// TODO Auto-generated method stub
	
}










	
	

}
