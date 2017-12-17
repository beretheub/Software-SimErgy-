package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Output;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part1.core.Rooms;

public class EndConsultation extends EndEvent implements java.io.Serializable{
	
	private static final long serialVersionUID = 7944700265431846312L;
	private Rooms room;
	
	public EndConsultation(double timestamp, EmergencyDepartment ed, Patient patient, Rooms room) {
		super(timestamp, ed, patient);
		this.room = room;
		
	}
	
	@Override
	public void execute() {
		this.patient.setPatientState(PatientState.WAITING); // Le patient a fini son event
		this.room.removePatient(patient);
		if (!(patient.nextstep == Output.NOTEST)){
			ed.addPatientWaitingForTransportation(patient);
		}else{
			ed.patientOutOfEmergencyDepartment(patient);
			patient.setDepartureTime(timeStamp);
		}
	}
	

}
