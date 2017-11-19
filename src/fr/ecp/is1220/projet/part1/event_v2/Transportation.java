package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.Exceptions.FullEquipment;
import fr.ecp.is1220.projet.part1.Exceptions.FullRoom;
import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;
import fr.ecp.is1220.projet.part1.core.Strecher;
import fr.ecp.is1220.projet.part1.core.Transporter;

/**
 * Fonctionnemet du transport : 
 * Durée fixe de 5 minutes
 * 
 */

public class Transportation extends Event {
	Transporter transporter;
	Patient p1;
	Strecher strecher;
	
	
	public Transportation(EmergencyDepartment ed, int timeStamp, Transporter transporter, Strecher strecher, Patient pat ) {
		super(timeStamp, ed);
		this.transporter=transporter;
		this.p1=pat;
		this.strecher=strecher;

	}
	
	@Override
	public void execute() {
		try {
			strecher.newPatient(p1);
		} catch (FullEquipment e) {		
			e.printStackTrace();
			return; //si on arrive pas a placer le patient dans la salle, on arrête la méthode ! On ne fait pas la suite
		}

		p1.setPatientState(PatientState.INSTALLING);
		
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Transporté par " + transporter.getName() + " :" + transporter.getId() + " sur " + strecher.getId() + " at " + Integer.toString(this.timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		this.ed.addEventInEventQueue(e);
		this.ed.addPatientWaitingForExam(p1);
		
		
		
	}

}
