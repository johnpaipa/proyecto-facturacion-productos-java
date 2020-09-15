package run;

import javax.swing.JOptionPane;

import controller.ControllBilling;
import gui.MainWindow;
import view.ViewConsole;

public class Runner {
	
	
	public static void main(String []args) {
		
	/*	
		String[] options=new String[]{
			
				"Grafica",
				"Consola"
				
		};
		
		int option=JOptionPane.showOptionDialog(null, "Que Interfaz?", "Vistas", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(option==0){*/
			
			MainWindow myWindow=new MainWindow();
			ControllBilling controll=new ControllBilling(myWindow);
			myWindow.setControll(controll);
			myWindow.begin();
			
			
		/*	
		}else{
			
			ViewConsole view=new ViewConsole();
			ControllBilling controll= new ControllBilling(view);
			
			view.setControl(controll);
			view.begin();
			
			
		}*/
		

		
	}

}
