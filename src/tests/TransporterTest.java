package tests;

import org.junit.Test;

import fr.ecp.is1220.projet.part1.core.Transporter;

public class TransporterTest {
@Test
	public void TestTransporter1() {
		// TODO Auto-generated method stub
		Transporter t1=new Transporter("Rex","Te");
		Transporter t2=new Transporter("Rex","Te",2);
		
		t1.setName("Bull");
		t1.setSurname("Red");
		
		t1.getName();
		t1.getSurname();
		t1.getId();
		t1.toString();
		
		t1.setState(0);
		t1.toString();
		
		t1.setState(1);
		t1.toString();
		
		t1.setState(2);
		t1.toString();
		t2.toString();
		
		
		
	}

}
