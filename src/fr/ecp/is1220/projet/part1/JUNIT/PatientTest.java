package fr.ecp.is1220.projet.part1.JUNIT;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

import fr.ecp.is1220.projet.part1.Exceptions.WrongIDAttribution;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Insurance;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class PatientTest {
	@Test
	public void testPatientBrigitte() throws WrongIDAttribution {
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		Patient p1=new Patient(ed1, "Alfred");
		Patient p2= new Patient (ed1,"Brigitte",Insurance.GOLD) ;
		p1.toString();
		p2.toString();
		
		p1.setArrivalTime(1);
		p1.setDepartureTime(3);
		p1.setFirstPhysicianTime(2);
		p1.setNexstep(Output.MRI);
		p1.setPatientState(PatientState.ARRIVING);
		p1.setSeverity(SeverityLevel.L1);
		p1.setName("Brigitte");
		p1.setInsurance(Insurance.GOLD);
		p1.toString();
		p2.toString();
		
		p1.getClass();
		p1.getId();
		p1.getInsurance();
		p1.getName();
		p1.getNexstep();
		p1.getPatientEd();
		p1.getPatientRecord();
		p1.getPatientState();
		p1.getSeverity();
		
	}
	
	@Test
	public void CalculCostTest(){
		
		EmergencyDepartment ed1 = new EmergencyDepartment("CHU Blois");
		
		Patient pat1 = null;
		try {
			pat1 = new Patient(ed1, "Martin", Insurance.GOLD);
		} catch (WrongIDAttribution e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Patient pat2 = null;
		try {
			pat2 = new Patient(ed1, "Martin", Insurance.SILVER);
		} catch (WrongIDAttribution e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Patient pat3 = null;
		try {
			pat3 = new Patient(ed1, "Martin", Insurance.NO);
		} catch (WrongIDAttribution e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pat1.addcharges(10);
		pat2.addcharges(10);
		pat3.addcharges(10);
		
		System.out.println(pat1.calculcost());
		System.out.println(pat2.calculcost());
		System.out.println(pat3.calculcost());
		
		
		//assertEquals(pat1.calculcost(), 2.0);
		/*assertEquals(pat2.calculcost(), 5.0);
		assertEquals(pat3.calculcost(), 10.0);*/
	}
	
	
}
