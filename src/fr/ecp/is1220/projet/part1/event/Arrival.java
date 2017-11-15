package fr.ecp.is1220.projet.part1.event;


import java.util.Date;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arrival extends Event {

	protected SeverityLevel severity;
	public Date arrivaldate;
	
	public Arrival(Patient patient, Date arrivalTime){
		super(arrivalTime, patient);
		
		// On génère la sévérité du patient 
		double severityProbability = Math.random();
		if (severityProbability <= 0.4){
			severity = SeverityLevel.L1;
		}else if (severityProbability <= 0.6){
			severity = SeverityLevel.L2;
		}else if (severityProbability <= 0.8){
			severity = SeverityLevel.L3;
		}else if (severityProbability <= 0.92){
			severity = SeverityLevel.L4;
		}else{
			severity = SeverityLevel.L5;
		}
		// Une fois générée par la classe event, on modifie l'attribut du patient 
		patient.setSeverity(severity);
		// Le patient entre dans l'hopital, on l'ajoute à la liste 
		EmergencyDepartment ed = patient.getPatientEd();
		ed.addPatientInED(patient);
		// on ajoute le patient à la file d'attente pour triage de son ED
		ed.addPatientInWaitingForTriage(patient);
		
		this.setEndDate(1);
		//on suppose qu'une arrivée dure une minute
		
		this.fillrecord();
		
	}

	@Override

	public String toString() {
		return "Arrived at" + this.getStartDate() + ", Niveau de gravité = "+ severity;
	}

}
