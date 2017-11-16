package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;


public class Arr_L1 extends Arr {
	
	public Arr_L1(EmergencyDepartment ed) {
		super(Arr_L1.getNextPatientTimeStamp(lastArr), ed);
		lastArr = this.timeStamp;
		
		
	}

	private static int getNextPatientTimeStamp(int lastArr2) {
		return lastArr2 + 5; // Il faudra utiliser la loi de proba pour déterminer le temps d'arrivée du prochain patient
	}

	@Override
	public void execute() {
		Patient p1 = new Patient(this.ed, "Random name");
		p1.setSeverity(SeverityLevel.L1);
		p1.setPatientState(PatientState.OCCUPIED);
		PatientWaiting e = new PatientWaiting(); 
		
		
		
	}

}
