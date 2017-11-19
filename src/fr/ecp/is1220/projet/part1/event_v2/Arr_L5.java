package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arr_L5 extends Arr {
	private static int lastArr = 0;
	public Arr_L5(EmergencyDepartment ed) {
		super(Arr_L5.getNextPatientTimeStamp(lastArr), ed);
		lastArr = this.timeStamp;
		
		
	}

	private static int getNextPatientTimeStamp(int lastArr2) {
		return lastArr2 + 15; // Il faudra utiliser la loi de proba pour déterminer le temps d'arrivée du prochain patient
	}

	@Override
	public void execute() {
		Patient p1 = new Patient(this.ed, "Random name");
		p1.setSeverity(SeverityLevel.L5);
		p1.setPatientState(PatientState.ARRIVING);
		p1.fillRecord(Integer.toString(p1.getPatientRecord().size()) + " - " + Integer.toString(p1.getId()) +" - Arrived in " + p1.getPatientEd() + " at " + Integer.toString(this.timeStamp)); 
		EndEvent e = new EndEvent(this.timeStamp + 3, this.ed, p1); // Cet event a pour fonction de mettre a jour l'état du patient pour simuler le temps passé dans l'évent "arrival"
		this.ed.addEventInEventQueue(e);
		this.ed.addPatientInED(p1);
		this.ed.addPatientWaitingForTriage(p1);
	}

}
