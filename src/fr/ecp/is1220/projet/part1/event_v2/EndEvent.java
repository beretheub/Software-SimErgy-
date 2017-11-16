package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;

public class EndEvent extends Event {
	private Patient patient;
	public EndEvent(int timeStamp, EmergencyDepartment ed, Patient patient) {
		super(timeStamp, ed);
		this.patient = patient;
	}

	@Override
	public void execute() {
		this.patient.setPatientState(PatientState.WAITING); // Le patient a fini son event

	}

}	 