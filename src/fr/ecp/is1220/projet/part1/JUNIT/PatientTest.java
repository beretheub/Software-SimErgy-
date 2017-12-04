package fr.ecp.is1220.projet.part1.JUNIT;

import org.junit.Test;

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
	
	
}
