package fr.ecp.is1220.projet.part1.event_v2;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.PatientState;
import fr.ecp.is1220.projet.part2.simulation.EventsType;

/**
*Fonction à expliquer 
*
**/

public class EndEvent extends Event implements java.io.Serializable {
	protected Patient patient;
	public EndEvent(double d, EmergencyDepartment ed, Patient patient) {
		super(d, ed);
		this.patient = patient;
	}

	@Override
	public void execute() {
		this.patient.setPatientState(PatientState.WAITING); // Le patient a fini son event

	}

	@Override
	public EventsType getType() {
		// TODO Auto-generated method stub
		return EventsType.ENDEVENT;
	}

}	 