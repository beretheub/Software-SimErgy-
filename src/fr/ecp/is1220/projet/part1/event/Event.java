package fr.ecp.is1220.projet.part1.event;


import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;

public abstract class Event {
	public Date startEvent;
	public Date endEvent;
	public Patient patient; 
	
	public Event(Date arrivalDate, Patient patient){
		this.startEvent = arrivalDate;
		this.setPatient(patient);
	}

	public Patient getPatient() {
		return patient;
	}
	/**
	 * Remplit la fiche du patient
	 */
	// Bien faire attention à plus tard, cette compétence est du domaine de l'event
	public void fillrecord(){
		patient.addEvent(this);
	}
	
	public abstract String toString();

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getStartDate(){
		return startEvent;

	}
	public Date getEndDate(){
		return endEvent;
	}


	@SuppressWarnings("deprecation")
	protected void setEndDate(double duree) {
		// Disons que l'arrivée du patient à l'hopital dure 1 minutes
		int year = this.getStartDate().getYear();
		int month = this.getStartDate().getMonth();
		int date = this.getStartDate().getDate();
		int hrs = this.getStartDate().getHours();
		int min = this.getStartDate().getMinutes() + (int)duree;
		
		this.endEvent = new Date(year, month, date, hrs, min);
		
		
	}
	 
	
}
