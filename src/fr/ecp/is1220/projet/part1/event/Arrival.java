package fr.ecp.is1220.projet.part1.event;


import java.util.Date;

import fr.ecp.is1220.projet.part1.core.EmergencyDepartment;
import fr.ecp.is1220.projet.part1.core.Patient;
import fr.ecp.is1220.projet.part1.core.SeverityLevel;

public class Arrival extends Event {

	protected SeverityLevel severity;
	protected Date arrivaldate;
	
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
		
		this.setEndDate();
		
		this.fillrecord();
		
	}

	@Override

	public String toString() {
		return "Arrived at" + this.getStartDate() + ", Niveau de gravité = "+ severity;
	}

	@SuppressWarnings("deprecation")
	protected void setEndDate() {
		// Disons que l'arrivée du patient à l'hopital dure 1 minutes
		int year = this.getStartDate().getYear();
		int month = this.getStartDate().getMonth();
		int date = this.getStartDate().getDate();
		int hrs = this.getStartDate().getHours();
		int min = this.getStartDate().getMinutes() + 1;
		
		this.endEvent = new Date(year, month, date, hrs, min);
		
		
	}

}
