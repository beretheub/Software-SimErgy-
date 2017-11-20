package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.noPatientinED;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;

/**
 * Le patient quitte l'hopital : 
 * 	- soit car il en a marre d'attendre
 * 	- soit car ses examens sont termin�s, et que le m�decin l'autorise � partir
 * 	- soit car il est hospitalis�
 * 	- soit acr il d�c�de
 * 
 */

public class Leaving extends Event {
	Patient p1;
	
	
	
	public Leaving(EmergencyDepartment ed, int timeStamp, Patient pat ) {
		super(timeStamp, ed);
		this.p1=pat;
			}
	
	@Override
	public void execute() throws noPatientinED {
		ed.removePatientInTheED(p1);
		p1.setPatientState(PatientState.OUT);
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - leaves the ED at " + Integer.toString(this.timeStamp)); 
		System.out.println("Prix total � payer : " + p1.totalcharge);
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Supposons qu'il met 3 minutes � partir
		this.ed.addEventInEventQueue(e);

		
		
		
	}

}
