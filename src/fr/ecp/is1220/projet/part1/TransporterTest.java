package fr.ecp.is1220.projet.part1;

import org.junit.Test;

public class TransporterTest {
@Test
	private void TestTransporter1() {
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
