package fr.ecp.is1220.projet.part1.event;


import java.util.Random;

import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arrival extends Event {
	private SeverityLevel severity;
	
	public Arrival(int arrivalTime, Patient patient){
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
		patient.getPatientEd().addPatientInED(patient);
		// on ajoute le patient à la file d'attente pour triage de son ED
		patient.getPatientEd().addPatientInWaitingForTriage(patient);
		
		
	}

	@Override
	protected void setEndDate() {
		// Disons que l'arrivée du patient à l'hopital dure 1 minutes
		this.endevent = this.getStartDate() + 1;
		
		
	}
}
