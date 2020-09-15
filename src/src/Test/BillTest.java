package Test;



import java.util.Calendar;
import java.util.GregorianCalendar;



import Exceptions.ExceptionStock;
import model.Bill;
import model.Product;

public class BillTest {
	
	
	private Bill bill;
	private Product hardDisk,USB,proccesor;
	
	
	private void setup(){
		bill=new Bill();
		
		hardDisk=new Product ("HD01","Disco duro de 1 TB",150000,(short)17,(byte)3,(float)19);
		proccesor=new Product ("PR01","CPU Intel core i7",350000,(short)8,(byte)2,(float)9);
		USB=new Product ("USB01","Memoria USB de 16 Gb",45000,(short)120,(byte)20,(float)16);
	}
	
	private void setup2() throws ExceptionStock{
		
		bill=new  Bill();
		
		setup();
		
		bill.addDetail(hardDisk, (short)1);
		bill.addDetail(proccesor, (short)1);
		bill.addDetail(USB, (short)3);
		
	}
	
	
	
	public void testCalcValors() throws ExceptionStock{
		setup2();
		/*
		assertEquals(635000, bill.calcExempt(),1);
		assertEquals(81600, bill.calcAssessment(),1);
		assertEquals(716600, bill.calcTotal(),1);*/
		
	}
	
	/*
	
	@Test
	public void testAddDetail() throws ExceptionStock {
		setup();
		assertTrue(bill.addDetail(hardDisk, (short)1));
		assertTrue(bill.addDetail(proccesor, (short)1));
		assertTrue(bill.addDetail(USB, (short)2));
		assertFalse(bill.addDetail(hardDisk, (short)17));
		
	}
	
	@Test
	public void testAddExists() throws ExceptionStock{
		setup2();
		
		assertEquals(3, bill.getDetails().size());
		assertEquals(3, bill.getDetails().get(2).getQuantity());
		
	}*/
	

	
	
	

}
