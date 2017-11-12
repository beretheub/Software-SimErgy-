package fr.ecp.is1220.projet.part1.event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.ecp.is1220.projet.part1.core.Patient;

public abstract class Event {
	public Date startevent = Calendar.getInstance().getTime();
	public Date endevent;
	public Patient patient; 
	public ArrayList<Patient> fileattente = new ArrayList<>(); 
	

	/**
	 * L'événement s'éxécute sur le patient 
	 */
	public abstract void execute();

	
	public Event(int arrivalDate, Patient patient){
		this.startevent = arrivalDate;
		this.setPatient(patient);
	}

	
	protected abstract void setEndDate();

	public Patient getPatient() {
		return patient;
	}

	
	/**
	 * La fiche patient est remplie
	 */
	public void fillrecord(){
		patient.listOfEvent.add(this);
	}
	
	public abstract String toString();

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
