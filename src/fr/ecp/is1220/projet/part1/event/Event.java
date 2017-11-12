package fr.ecp.is1220.projet.part1.event;

import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;

public abstract class Event {
	private int startevent;
	protected int endevent;
	private Patient patient;
	
	public Event(int arrivalDate, Patient patient){
		this.startevent = arrivalDate;
		this.setPatient(patient);
	}
	
	protected abstract void setEndDate();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getStartDate(){
		return startevent;
	}
	public int getEndDate(){
		return endevent;
	}
	 
	
}
